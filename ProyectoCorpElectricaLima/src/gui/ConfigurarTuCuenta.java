package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import miLib.GUI;
import beans.GlobalesCorreo;

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
public class ConfigurarTuCuenta extends JInternalFrame implements ActionListener {
	private JLabel lblExtencion;
	private JTextField txtExtension;
	private JTextField txtNombre;
	private JTextField txtCorreoErrores;
	private JButton btnAceptar;
	private JPanel pnlConfiguracion;
	private JLabel lblCorreoErrores;
	private JLabel lblNombre;
	private JPasswordField txtPass;
	private JLabel lblPass;
	private JTextField txtCorreo;
	private JLabel lblCorreo;
	GlobalesCorreo objGlobal;
	GUI objGui;
	MenuPrincipal objMenu;
	public static boolean valor=false;

	public ConfigurarTuCuenta() {
		super("Configurar Cuenta", true, true, true, true);
		try {
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(583, 233));
			this.setBounds(0, 0, 583, 233);
			getContentPane().setLayout(null);

			pnlConfiguracion = new JPanel();
			pnlConfiguracion.setLayout(null);
			getContentPane().add(pnlConfiguracion);
			pnlConfiguracion.setBorder(BorderFactory.createTitledBorder("Configurar Cuenta"));
			pnlConfiguracion.setBounds(5, 0, 565, 160);

			btnAceptar = new JButton();
			getContentPane().add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(229, 172, 110, 21);
			btnAceptar.addActionListener(this);

			lblExtencion = new JLabel();
			pnlConfiguracion.add(lblExtencion);
			lblExtencion.setText("Extencion:");
			lblExtencion.setBounds(22, 22, 89, 14);

			txtExtension = new JTextField();
			pnlConfiguracion.add(txtExtension);
			String nom="smtp.live.com o smtp.gmail.com o smtp.empresa.com";
			//System.out.println(nom);
			txtExtension.setToolTipText(nom);
			
			txtExtension.setBounds(111, 19, 432, 21);

			lblCorreo = new JLabel();
			pnlConfiguracion.add(lblCorreo);
			lblCorreo.setText("Correo:");
			lblCorreo.setBounds(22, 48, 84, 14);

			txtCorreo = new JTextField();
			pnlConfiguracion.add(txtCorreo);
			txtCorreo.setBounds(111, 45, 432, 21);

			lblPass = new JLabel();
			pnlConfiguracion.add(lblPass);
			lblPass.setText("Contraseña:");
			lblPass.setBounds(22, 74, 89, 14);

			txtPass = new JPasswordField();
			pnlConfiguracion.add(txtPass);
			txtPass.setBounds(111, 71, 432, 21);

			lblNombre = new JLabel();
			pnlConfiguracion.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(22, 100, 89, 14);

			txtNombre = new JTextField();
			pnlConfiguracion.add(txtNombre);
			txtNombre.setBounds(111, 97, 432, 21);

			lblCorreoErrores = new JLabel();
			pnlConfiguracion.add(lblCorreoErrores);
			lblCorreoErrores.setText("Correo Errores:");
			lblCorreoErrores.setBounds(22, 126, 89, 14);

			txtCorreoErrores = new JTextField();
			pnlConfiguracion.add(txtCorreoErrores);
			txtCorreoErrores.setBounds(111, 123, 432, 21);
			
			cargarDatos();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void cargarDatos(){
		if(objGlobal.correo==null){
			
		}else{
			txtExtension.setText(objGlobal.extension);
			txtCorreo.setText(objGlobal.correo);
			txtPass.setText(objGlobal.pass);
			txtNombre.setText(objGlobal.nombre);
			txtCorreoErrores.setText(objGlobal.correoError);
		}
		
	}
	
	
	public void ingresoConfiguracion(){
		String extension;
		String correo;
		char[] pass;
		String nombre;
		String correoErrores;
		extension=txtExtension.getText();
		correo=txtCorreo.getText();
		pass=txtPass.getPassword();
		nombre=txtNombre.getText();
		correoErrores=txtCorreoErrores.getText();
		
		if(extension.equals("")||correo.equals("")|pass.equals("")||nombre.equals("")||correoErrores.equals("")){
			objGui.mostrarAviso("ERROR");
			valor=false;
		}else{
			objGui.mostrarAviso(extension+"\n"+correo+"\n"+pass+"\n"+nombre+"\n"+correoErrores);
			objGlobal.extension=extension;
			objGlobal.correo=correo;
			objGlobal.pass=pass+"";
			objGlobal.nombre=nombre;
			objGlobal.correoError=correoErrores;
			valor=true;
		}
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar){
			ingresoConfiguracion();
		}
		
	}

}
