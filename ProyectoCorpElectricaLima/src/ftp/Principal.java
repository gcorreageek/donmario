package ftp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Principal extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea consola;
	JSplitPane split;
	JPanel panelGUI, panelBotones;
	JScrollPane panelConsola;
	ArbolDirectorios arbolLocal, arbolRemoto;
	JButton btnTransARemoto;
	private JButton btnEliminarDirectorio;
	private JButton btnCrearDirectorio;
	private JButton btnLimpiar;
	private JButton btnEliminar;
	private JButton btnDescargar;
	FTPClient ftp;

	String server;
	String user;
	String pass;
	CrearDirectorio objDirectorio;

	public Principal() {

		// colocarSkin();

		// new FormularioAcceso(this);

		super("Cliente FTP", true, true, true, true);

		setVisible(true);
		this.setBounds(0, 0, 700, 400);
		new FormularioAcceso(this);

		setLayout(new BorderLayout());
		consola = new JTextArea();

		split = new JSplitPane();
		split.setResizeWeight(0.5);
		arbolLocal = new ArbolDirectorios(this, 1);
		arbolRemoto = new ArbolDirectorios(this, 2);
		split.setLeftComponent(new JScrollPane(arbolLocal));
		split.setRightComponent(new JScrollPane(arbolRemoto));

		panelConsola = new JScrollPane(consola);
		panelConsola.setPreferredSize(new Dimension(300, 140));

		panelBotones = new JPanel();

		btnTransARemoto = new JButton("Transferir");
		panelBotones.add(btnTransARemoto);
		{
			btnDescargar = new JButton();
			panelBotones.add(btnDescargar);
			btnDescargar.setText("Descargar");
			btnDescargar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					descargarArchivo();
				}
				
			});
		}
		
		btnEliminar = new JButton();
		panelBotones.add(btnEliminar);
		btnEliminar.setText("Eliminar");

		btnLimpiar = new JButton();
		panelBotones.add(btnLimpiar);
		btnLimpiar.setText("Limpiar");

		btnCrearDirectorio = new JButton();
		panelBotones.add(btnCrearDirectorio);
		btnCrearDirectorio.setText("Crear Directorio");
		btnCrearDirectorio.addActionListener(this);

		btnEliminarDirectorio = new JButton();
		panelBotones.add(btnEliminarDirectorio);
		btnEliminarDirectorio.setText("Eliminar Dir");

		btnTransARemoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					subirArchivo();
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					int n = JOptionPane.showConfirmDialog(getComponent(0),
							"¿Desea Eliminar el Archivo?",
							"Eliminar Archivo", JOptionPane.YES_NO_OPTION);
					switch (n) {
					case JOptionPane.YES_OPTION:
						ftp.deleteFile(arbolRemoto.ruta);
						consola.append("Archivo Eliminado \n");
						arbolRemoto.Raiz.removeAllChildren();
						arbolRemoto.modelo.reload();
						arbolRemoto.listaDirectorios(arbolRemoto.Raiz);
						break;
					case JOptionPane.NO_OPTION:
						break;
					default:
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		});

		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					consola.setText("");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		});

		
		btnEliminarDirectorio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					int n = JOptionPane.showConfirmDialog(getComponent(0),
							"¿Desea Eliminar el Directorio?",
							"Eliminar Directorio", JOptionPane.YES_NO_OPTION);
					switch (n) {
					case JOptionPane.YES_OPTION:
						ftp.removeDirectory(arbolRemoto.ruta);
						consola.append("Directorio Eliminado \n");
						break;
					case JOptionPane.NO_OPTION:
						break;
					default:
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		});

		panelGUI = new JPanel();
		panelGUI.setLayout(new BorderLayout());
		panelGUI.add(split, BorderLayout.CENTER);
		panelGUI.add(panelBotones, BorderLayout.SOUTH);

		add(panelGUI, BorderLayout.CENTER);
		add(panelConsola, BorderLayout.SOUTH);

		datosConexion();
		// login();
		// desactivarTodo();

	}

	public void desactivarTodo() {
		arbolLocal.explorador.setEnabled(false);
		arbolRemoto.explorador.setEnabled(false);
		consola.setEnabled(false);
	}

	public void activarTodo() {
		arbolLocal.explorador.setEnabled(true);
		arbolRemoto.explorador.setEnabled(true);
		consola.setEnabled(true);
	}

	public String nombreArchivo(String ruta) {

		String caracter = "", nombre = "";

		for (int i = ruta.length() - 1; i >= 0; i--) {

			caracter = "" + ruta.charAt(i);
			if (caracter.equals("/")) {
				break;
			} else {
				nombre = caracter + nombre;
			}
		}

		return nombre;
	}

	public void descargarArchivo() {

		int port = 21;
		FTPClient ftpClient = new FTPClient();

		try {

			if ((arbolRemoto.ruta) != null) {

				ftpClient.connect(server, port);
				ftpClient.login(user, pass);
				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

				String remoteFile1 = arbolRemoto.ruta;
				System.out.println("RUTA ARBOL: " + remoteFile1);
				File downloadFile1 = new File(
						"//25.172.14.90/d/ProyectoCEL/descargas FTP/"
								+ nombreArchivo(arbolRemoto.ruta));
				System.out.println("NOMBRE ARCHIVO: "
						+ nombreArchivo(arbolRemoto.ruta));
				OutputStream outputStream1 = new BufferedOutputStream(
						new FileOutputStream(downloadFile1));
				boolean success = ftpClient.retrieveFile(remoteFile1,
						outputStream1);
				outputStream1.close();

				if (success) {
					System.out
							.println("File has been downloaded successfully.");
					consola.append("Archivo Descargado \n");
				}

			} else {
				consola.append("Error al Descargar el Archivo \n");
			}

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void login() {

		try {
			ftp = new FTPClient();
			ftp.connect(server);
			if (ftp.login(user, new String(pass))) {
				activarTodo();
				arbolRemoto.swroot = true;
				arbolRemoto.listaDirectorios();
				arbolRemoto.updateUI();
				repaint();
				consola.append("Conectado al servidor " + server + " \n");
			} else {
				JOptionPane.showMessageDialog(null,
						"Host, usuario o Contraseña invalia.");
				desactivarTodo();
			}
		} catch (IOException e) {
			desactivarTodo();
			JOptionPane.showMessageDialog(null,
					"Host, usuario o Contraseña invalia.");
		}
	}

	public void datosConexion() {

		server = "ftp.electrocornejo.com";
		user = "electroc";
		pass = "7AX_]~MMV;vX";

	}

	public void subirArchivo() throws SocketException, UnknownHostException,
			IOException {

		try {

			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream(
					arbolLocal.ruta));
			ftp.enterLocalPassiveMode();
			ftp.storeFile(arbolLocal.nombreArchivo, buffIn);
			consola.append("Archivo Transferido \n");

			arbolRemoto.Raiz.removeAllChildren();
			arbolRemoto.modelo.reload();
			arbolRemoto.listaDirectorios(arbolRemoto.Raiz);

			buffIn.close();

		} catch (Exception e) {
			consola.append("Error al Transferir el Archivo \n");
		}

	}

	public void forzarCerrado() {

		try {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setClosed(true);
			this.setEnabled(false);

		} catch (PropertyVetoException ex) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnCrearDirectorio){
			
			objDirectorio = new CrearDirectorio();
			
			String[] botones = { "Aceptar", "Cancelar" };// Esto es el nombre
			
			int showOptionDialog = JOptionPane.showInternalOptionDialog(this,
					objDirectorio, "Crear Directorio", 0, -1, null, botones,
					"Cerrar"

			);

			if (showOptionDialog == 1 || showOptionDialog == -1) {
				// x--->no cogio nada
			}else {
				String nombre = objDirectorio.txtNombre.getText();

				if (nombre.equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe poner un Nombre");
				} else {
					try {
						ftp.mkd(arbolRemoto.ruta + "/" + nombre);
						consola.append("Directorio Creado \n");
						arbolRemoto.Raiz.removeAllChildren();
						arbolRemoto.modelo.reload();
						arbolRemoto.listaDirectorios(arbolRemoto.Raiz);
					} catch (Exception ex) {
						// TODO: handle exception
					}
				}
			}
		}
		
	}

	// private void colocarSkin() {
	// try {
	// UIManager
	// .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (InstantiationException e) {
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// } catch (UnsupportedLookAndFeelException e) {
	// e.printStackTrace();
	// }
	// }

	// public static void main(String[] args) {
	// Principal p = new Principal();
	// p.setVisible(true);
	// p.setBounds(0, 0, 700, 400);
	// //p.setLocationRelativeTo(null);
	// p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	// }

}