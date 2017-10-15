package ftp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import org.apache.commons.net.ftp.FTPClient;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FormularioAcceso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel plogin;
	JTextField txtip, txtusuario;
	private JButton btnCancelar;
	JPasswordField txtclave;
	JPanel panelBoton;
	JButton btnaceptar;
	Principal p;
	public static String rutaServidor;

	public FormularioAcceso(Principal prin) {

		p = prin;

		plogin = new JPanel();
		plogin.setLayout(new GridLayout(3, 2));

		txtip = new JTextField(10);
		txtusuario = new JTextField(10);
		txtclave = new JPasswordField(10);

		plogin.add(new JLabel("IP Servidor:"));
		plogin.add(txtip);
		plogin.add(new JLabel("Usuario:"));
		plogin.add(txtusuario);
		plogin.add(new JLabel("Contraseña:"));
		plogin.add(txtclave);

		JPanel paux = new JPanel();
		paux.add(plogin);

		panelBoton = new JPanel();
		btnaceptar = new JButton("Conectar");
		panelBoton.add(btnaceptar);
		btnaceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					p.ftp = new FTPClient();
					p.ftp.connect("ftp."+txtip.getText().trim());
					if (p.ftp.login(txtusuario.getText(),
							new String(txtclave.getPassword()))) {
						FormularioAcceso.this.dispose();
						p.activarTodo();
						p.arbolRemoto.swroot = true;
						p.arbolRemoto.listaDirectorios();
						p.arbolRemoto.updateUI();
						p.repaint();
						p.consola.append("Conectado al servidor "
								+ "ftp."+txtip.getText().trim()+ " \n");
						rutaServidor="www."+txtip.getText().trim();
					} else {
						JOptionPane.showMessageDialog(null,
								"IP, usuario o Contraseña invalia.");
						p.desactivarTodo();
					}
				} catch (IOException e) {
					p.desactivarTodo();
					JOptionPane.showMessageDialog(null,
							"IP, usuario o Contraseña invalia.");
				}
			}

		});
		
		
		btnCancelar = new JButton();
		panelBoton.add(btnCancelar);
		btnCancelar.setText("Cancelar");
		
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
					setVisible(false);
					p.forzarCerrado();
				} catch (Exception e) {
					
				}
			}

		});

		add(paux);
		add(panelBoton, BorderLayout.SOUTH);

		this.setBounds(0, 0, 300, 140);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		setVisible(true);

	}

}