package ftp;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import org.apache.commons.net.ftp.FTPFile;

public class ArbolDirectorios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTree explorador;
	DefaultTreeModel modelo;
	DefaultMutableTreeNode Raiz, ultimoseleccionado;
	Principal p;
	int tipo = -1;
	boolean swroot = false;
	String ruta = "";
	String nombreArchivo = "";
	ClassLoader cl = this.getClass().getClassLoader();
	FormularioAcceso f;
	
	public ArbolDirectorios(Principal prin, int op) {

		setLayout(new BorderLayout());

		p = prin;
		tipo = op;

		if (tipo == 1) {

			Raiz = new DefaultMutableTreeNode("Raiz");
			explorador = new JTree(Raiz);
			DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) explorador
					.getCellRenderer();
			render.setLeafIcon(new ImageIcon(getClass().getResource("/ftp/archivo.png")));
			render.setOpenIcon(new ImageIcon(getClass().getResource("/ftp/carpeta.png")));
			render.setClosedIcon(new ImageIcon(getClass().getResource("/ftp/carpeta.png")));
			explorador.addTreeSelectionListener(new TreeSelectionListener() {

				@Override
				public void valueChanged(TreeSelectionEvent arg0) {
					try {
						DefaultMutableTreeNode sel = (DefaultMutableTreeNode) explorador
								.getLastSelectedPathComponent();
						File fhijo = obtenerRuta(sel);
						ruta = fhijo.toString();
						nombreArchivo = sel.getUserObject().toString();
						System.out.println("RUTA LOCAL: "+ruta);
						if (swroot == false) {

							for (int i = 0; i < sel.getChildCount(); i++) {
								DefaultMutableTreeNode nieto = (DefaultMutableTreeNode) sel
										.getChildAt(i);
								agregarHijos(nieto);
							}
							swroot = true;
						} else {
							for (int i = 0; i < sel.getChildCount(); i++) {
								DefaultMutableTreeNode nieto = (DefaultMutableTreeNode) sel
										.getChildAt(i);
								agregarHijos(nieto);
							}
						}
					} catch (NullPointerException npe) {
						npe.printStackTrace();
					}
				}

			});

			for (int i = 0; i < File.listRoots().length; i++) {
				DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(
						File.listRoots()[i]);
				Raiz.add(hijo);
			}

		} else {
			Raiz = new DefaultMutableTreeNode("Raiz");
			modelo = new DefaultTreeModel(Raiz);
			explorador = new JTree(modelo);
			DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) explorador
					.getCellRenderer();
			render.setLeafIcon(new ImageIcon(getClass().getResource("/ftp/archivo.png")));
			render.setOpenIcon(new ImageIcon(getClass().getResource("/ftp/carpeta.png")));
			render.setClosedIcon(new ImageIcon(getClass().getResource("/ftp/carpeta.png")));
			explorador.addTreeSelectionListener(new TreeSelectionListener() {

				@Override
				public void valueChanged(TreeSelectionEvent arg0) {
					try {
						DefaultMutableTreeNode seleccionado = (DefaultMutableTreeNode) explorador
								.getLastSelectedPathComponent();
						DefaultMutableTreeNode se = null;
						if (seleccionado != null) {
							ruta = p.ftp.printWorkingDirectory() + "/"
									+ seleccionado.getUserObject();
							p.consola.append(f.rutaServidor+ruta(ruta)+ " \n");
							System.out.println("RUTA REMOTA: "+ruta);
							
							if (!seleccionado.isLeaf()) {
								se = new DefaultMutableTreeNode(seleccionado
										.getUserObject());
								ultimoseleccionado = se;
								if (!se.toString().equalsIgnoreCase("Raiz")) {
									Raiz.setUserObject(se.getUserObject());
									Raiz.removeAllChildren();
									modelo.reload();
									listaDirectorios(Raiz);
								}
							}
						}
					} catch (NullPointerException npe) {
						npe.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			});
		}

		add(explorador);
	}

	public void listaDirectorios(DefaultMutableTreeNode padre) {

		FTPFile[] ftpFiles;
		try {
			p.ftp.changeWorkingDirectory(padre.toString());
			ftpFiles = p.ftp.listDirectories();
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getType() == FTPFile.DIRECTORY_TYPE) {
					DefaultMutableTreeNode d = new DefaultMutableTreeNode(
							ftpFile.getName());
					DefaultMutableTreeNode d2 = new DefaultMutableTreeNode(
							"De clic en la carpeta");
					d.add(d2);
					padre.add(d);
				}
			}
			ftpFiles = p.ftp.listFiles();
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getType() == FTPFile.FILE_TYPE) {
					DefaultMutableTreeNode d = new DefaultMutableTreeNode(
							ftpFile.getName());
					padre.add(d);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		explorador.expandRow(0);
		ArbolDirectorios.this.updateUI();
		p.repaint();
	}

	public void listaDirectorios() {

		FTPFile[] ftpFiles;
		try {
			ftpFiles = p.ftp.listDirectories();
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getType() == FTPFile.DIRECTORY_TYPE) {
					DefaultMutableTreeNode d = new DefaultMutableTreeNode(
							ftpFile.getName());
					DefaultMutableTreeNode d2 = new DefaultMutableTreeNode(
							"De clic en la carpeta");
					d.add(d2);
					Raiz.add(d);
				}
			}
			ftpFiles = p.ftp.listFiles();
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getType() == FTPFile.FILE_TYPE) {
					DefaultMutableTreeNode d = new DefaultMutableTreeNode(
							ftpFile.getName());
					Raiz.add(d);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		explorador.expandRow(0);
		ArbolDirectorios.this.updateUI();
		p.repaint();
	}

	public void agregarHijos(DefaultMutableTreeNode padre) {
		if (padre != Raiz) {
			try {
				File fpadre = obtenerRuta(padre);
				if (fpadre.isDirectory()) {
					if (fpadre.listFiles().length > 0) {
						for (int i = 0; i < fpadre.list().length; i++) {
							DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(
									fpadre.list()[i]);
							padre.add(hijo);
						}
					}
				}
			} catch (NullPointerException npe) {

			}
		}
	}

	public File obtenerRuta(DefaultMutableTreeNode p) {
		String ruta = "";
		for (int i = 0; i < p.getPath().length - 1; i++) {
			ruta = ruta + p.getPath()[i + 1] + "\\";
		}
		File f = new File(ruta);
		return f;
	}
	
	public String ruta(String ruta) {

		String caracter = "", nombre = "";
		int cont=0;

		for (int i = ruta.length() - 1; i >= 0; i--) {

			caracter = "" + ruta.charAt(i);
			if (caracter.equals("/")) {
				nombre = caracter + nombre;
				cont++;
				if(cont==2){
					break;
				}
			} else {
				nombre = caracter + nombre;
			}
		}

		return nombre;
	}
}