package pOp;

import gui.EnvioMail;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import beans.GlobalesCorreo;
import beans.GlobalesCorreoMasivo;

import com.hexidec.ekit.Ekit;


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
public class VistaPrevia extends Ekit {
	private JLabel lblDe;
	private JLabel lblPara;
	private static JTextField txtPara;
	private static JTextField txtDe;
	private static JTextPane txtA;
	ConfigurarCuentas objConfigurarCuentas ;
	EnvioMail objEnvioMail;
	GlobalesCorreo objGlobal;
	
	String correo=objGlobal.correo;
	
	
	public VistaPrevia() {
		//System.out.println("entra al bista previa");
		
		try {
			//txtA.setText(objCorreoMasivo.txtA.getText());
			super.setIconifiable(false);
			super.setClosable(true);
			super.setMaximizable(false);
			super.pnlMedio.setVisible(false);
			super.getJMenuBar().setVisible(false);
			super.ekitCore.setPreferredSize(new java.awt.Dimension(868, 417));
			super.pnlArriba.setPreferredSize(new java.awt.Dimension(868, 62));
			this.setTitle("Vista Previa");
			this.setPreferredSize(new java.awt.Dimension(870, 519));
			this.setBounds(0, 0, 870, 519);
			super.txtPara.setVisible(false);
			super.txtAsunto.setVisible(false);
			super.txtRuta.setVisible(false);
			super.cboTipoCliente.setVisible(false);
			super.jLabel1.setVisible(false);
			super.btnAdjuntar.setVisible(false);
			super.lblTipoCliente.setVisible(false);
			super.lblPara.setVisible(false);
			super.lblAsunto.setVisible(false);

			lblDe = new JLabel();
			super.pnlArriba.add(lblDe);
			lblDe.setText("De:");
			lblDe.setBounds(36, 12, 59, 14);

			lblPara = new JLabel();
			super.pnlArriba.add(lblPara);
			lblPara.setText("Para:");
			lblPara.setBounds(36, 38, 59, 14);

			txtDe = new JTextField();
			super.pnlArriba.add(txtDe);
			txtDe.setBounds(92, 9, 375, 21);

			txtPara = new JTextField();
			super.pnlArriba.add(txtPara);
			txtPara.setBounds(93, 35, 373, 21);
			//mostrarTexto();
			txtA=super.ekitCore.jtpMain;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void   mostrarTexto(){
		String texto=objEnvioMail.txtA.getText();
		
		txtA.setText(texto);
		txtDe.setText(objGlobal.nombre+"<"+objGlobal.correo+">");
		txtPara.setText(objEnvioMail.txtPara.getText() );
		
		
	}
	
	public static boolean mostrar(String texto,String correo){
		GlobalesCorreo obj = null;
		System.out.println(texto);
		boolean valor=false;
		try {
			txtA.setText(texto);
			txtDe.setText(obj.nombre+"<"+obj.correo+">");
			txtPara.setText(correo);
			valor=true;
		} catch (Exception e) {
			valor=false;
		}
		
		return valor;
	}
		
	public static boolean mostrarMasivo(String texto,String correo){
		GlobalesCorreoMasivo obj = null;
		//System.out.println(texto);
		boolean valor=false;
		try {
			txtA.setText(texto);
			txtDe.setText(obj.nombre+"<"+obj.correo+">");
			txtPara.setText(correo);
			valor=true;
		} catch (Exception e) {
			valor=false;
		}
		
		return valor;
	}
	

}
