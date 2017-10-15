package pOp;
import gui.TranCotizacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miLib.AccesoBD;
import miLib.GUI;

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
public class NuevoCliente extends JPanel implements MouseListener, ActionListener {
	private JPanel pnlPrincipal;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JTextField txtAtencion;
	private JLabel lblAtencion;
	private JButton btnRegistrar;
	private JLabel lblNombre;
	private JPanel pnlBuscarCliente;
	private JLabel lblAgente;
	private JComboBox cboAgente;
	private JTextField txtEmail;
	private JLabel lblMail;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JTextField txtNextel;
	private JTextField txtRpm;
	private JTextField txtFax;
	private JLabel lblTelefono;
	private JLabel lblNextel;
	private JLabel lblRpm;
	private JLabel lblFax;
	private JComboBox cboSexo;
	private JLabel lblSexo;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JComboBox cboTipo;
	private JLabel lblTipo;

	 TranCotizacion objcot =new TranCotizacion();
	 GUI objGUI;
	 
	 public NuevoCliente() {
		try {
			System.out.println("Entra al NuevoCliente");


			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(767, 210));

			pnlPrincipal = new JPanel();
			this.add(pnlPrincipal);

			pnlBuscarCliente = new JPanel();
			pnlPrincipal.add(pnlBuscarCliente);

			lblNombre = new JLabel();

			txtNombre = new JTextField();

			btnRegistrar = new JButton();
			btnRegistrar.setText("Registrar");
			btnRegistrar.setBounds(328, 171, 97, 23);
			btnRegistrar.addActionListener(this);

			txtNombre.setBounds(71, 28, 472, 21);

			pnlBuscarCliente.add(lblNombre);
			pnlBuscarCliente.add(txtNombre);
			pnlBuscarCliente.add(btnRegistrar);
			btnRegistrar.setForeground(new java.awt.Color(0,0,0));
			btnRegistrar.setBackground(new java.awt.Color(255,0,0));

			lblAtencion = new JLabel();
			pnlBuscarCliente.add(lblAtencion);
			lblAtencion.setText("Atencion:");
			lblAtencion.setBounds(14, 55, 60, 16);

			txtAtencion = new JTextField();
			pnlBuscarCliente.add(txtAtencion);
			txtAtencion.setBounds(71, 54, 278, 20);

			lblDireccion = new JLabel();
			pnlBuscarCliente.add(lblDireccion);
			lblDireccion.setText("Direccion:");
			lblDireccion.setBounds(11, 81, 66, 16);

			txtDireccion = new JTextField();
			pnlBuscarCliente.add(txtDireccion);
			txtDireccion.setBounds(71, 80, 278, 20);

			lblTipo = new JLabel();
			pnlBuscarCliente.add(lblTipo);
			lblTipo.setText("Tipo:");
			lblTipo.setBounds(559, 30, 29, 16);

			cboTipo = new JComboBox();
			pnlBuscarCliente.add(cboTipo);
			cboTipo.setBounds(593, 28, 145, 21);

			lblRuc = new JLabel();
			pnlBuscarCliente.add(lblRuc);
			lblRuc.setText("Ruc:");
			lblRuc.setBounds(365, 58, 29, 13);

			txtRuc = new JTextField();
			pnlBuscarCliente.add(txtRuc);
			txtRuc.setBounds(396, 54, 147, 20);

			lblSexo = new JLabel();
			pnlBuscarCliente.add(lblSexo);
			lblSexo.setBounds(556, 57, 38, 17);
			lblSexo.setText("Sexo:");

			cboSexo = new JComboBox();
			pnlBuscarCliente.add(cboSexo);
			cboSexo.addItem("¿?");
			cboSexo.addItem("Masculino");
			cboSexo.addItem("Femenino");
			cboSexo.setBounds(593, 54, 101, 21);

			lblFax = new JLabel();
			pnlBuscarCliente.add(lblFax);
			lblFax.setText("Fax:");
			lblFax.setBounds(41, 107, 27, 16);

			lblRpm = new JLabel();
			pnlBuscarCliente.add(lblRpm);
			lblRpm.setText("Rpm:");
			lblRpm.setBounds(191, 108, 35, 16);

			lblNextel = new JLabel();
			pnlBuscarCliente.add(lblNextel);
			lblNextel.setText("Nextel:");
			lblNextel.setBounds(340, 108, 45, 16);

			lblTelefono = new JLabel();
			pnlBuscarCliente.add(lblTelefono);
			lblTelefono.setText("Telefono:");
			lblTelefono.setBounds(505, 107, 57, 16);

			txtFax = new JTextField();
			pnlBuscarCliente.add(txtFax);
			txtFax.setBounds(71, 106, 102, 20);

			txtRpm = new JTextField();
			pnlBuscarCliente.add(txtRpm);
			txtRpm.setBounds(226, 106, 102, 20);

			txtNextel = new JTextField();
			pnlBuscarCliente.add(txtNextel);
			txtNextel.setBounds(385, 105, 102, 20);

			txtTelefono = new JTextField();
			pnlBuscarCliente.add(txtTelefono);
			txtTelefono.setBounds(565, 107, 110, 20);

			txtCelular = new JTextField();
			pnlBuscarCliente.add(txtCelular);
			txtCelular.setBounds(71, 132, 102, 20);

			lblCelular = new JLabel();
			pnlBuscarCliente.add(lblCelular);
			lblCelular.setText("Celular:");
			lblCelular.setBounds(23, 132, 49, 16);

			lblMail = new JLabel();
			pnlBuscarCliente.add(lblMail);
			lblMail.setText("E-Mail:");
			lblMail.setBounds(184, 134, 41, 16);

			txtEmail = new JTextField();
			pnlBuscarCliente.add(txtEmail);
			txtEmail.setBounds(226, 132, 261, 20);

			cboAgente = new JComboBox();
			pnlBuscarCliente.add(cboAgente);
			cboAgente.addItem("");
			cboAgente.addItem("Con Agente de Retencion");
			cboAgente.addItem("Sin Agente de Retencion");
			cboAgente.setBounds(565, 132, 173, 21);

			lblAgente = new JLabel();
			pnlBuscarCliente.add(lblAgente);
			lblAgente.setText("Agente:");
			lblAgente.setBounds(513, 134, 43, 16);

			lblNombre.setText("Nombre:");
			lblNombre.setBounds(20, 31, 53, 14);

			pnlBuscarCliente.setBorder(BorderFactory.createTitledBorder("Registrar Nuevo Cliente"));
			pnlBuscarCliente.setBounds(0, 0, 759, 204);
			pnlBuscarCliente.setLayout(null);

			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(757, 204));

			cargarTipo();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/****************************************************************************************/
	/****************************************************************************************/
		
		public void cargarTipo(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_tipocliente WHERE EST_tipo='ACTIVADO' order by cod_tipo asc;";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			
			try {
				while (rs.next()) {
					cboTipo.addItem(rs.getString(2)+"-"+rs.getInt(1));
				}
				rs.close();
				
			} catch (Exception ex) {
				System.out.println(ex);
				// TODO: handle exception
			}

			objAccesoBD.cerrarConexion();
			
			
		}
		/*************************AGREGAR CLIENTE************************/
		public void agregarCliente(){
			
			String dat="";
			dat=dat.replaceAll("'", "\'\'");
			String dat2=txtAtencion.getText();
			dat2=dat2.replaceAll("'", "\'\'");
			/*JOptionPane.showConfirmDialog(this,"¿Seguro de modificar esta Venta?",
					"Confirmacion",JOptionPane.YES_NO_OPTION);*/
			/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
				"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String NOM_CLI=txtNombre.getText(),LUG_CLI="",
			RUC_CLI=txtRuc.getText(),DIR_CLI=txtDireccion.getText(),CONA_CLI=dat2,TEL1A_CLI=txtTelefono.getText(),TEL2A_CLI="",
			FAXA_CLI=txtFax.getText(),RPMA_CLI=txtRpm.getText(),NEXA_CLI=txtNextel.getText(),CELA_CLI=txtCelular.getText(),MAILA_CLI=txtEmail.getText(),
			CONB_CLI="",TEL1B_CLI="",CELB_CLI="",MAILB_CLI=""
			,RPMB_CLI="",NEXB_CLI="",OBSB_CLI="",
			OBS_CLI=dat,EST_CLI="ACTIVADO";
			
			
			String COD_DEP="",
			COD_PRO="",COD_DIS="";
			String cod_tipo=""+cboTipo.getSelectedItem();
			cod_tipo=cod_tipo.substring(cod_tipo.indexOf("-")+1, cod_tipo.length());
			
			boolean valor;
			int sexo=Integer.parseInt(""+cboSexo.getSelectedIndex());
			int agente=Integer.parseInt(""+cboAgente.getSelectedIndex());
		
			if(COD_DEP.equals("DEPARTAMENTO")||COD_DEP==null||COD_PRO.equals("PROVINCIA")||COD_PRO==null||COD_DIS.equals("DISTRITO")|COD_DIS==null||LUG_CLI.equals("LUGAR")||LUG_CLI==null){
				JOptionPane.showInternalMessageDialog(this, "!Porfavor Ingrese un Departamento¡ \n Si no tiene ponga VACIO",
						"Precaucion", JOptionPane.WARNING_MESSAGE);
				valor=true;
			}else{
				COD_DEP="99";COD_PRO="99";COD_DIS="99";
				LUG_CLI="99";
				valor=false;
			} 
			
			if(valor==false){
				String insertarPregunta="INSERT INTO tb_cliente VALUES("+null+",'"+NOM_CLI+"','"
				+cod_tipo+"','"+LUG_CLI+"','"+RUC_CLI+"','"+COD_DEP+"','"+COD_PRO+"','"+COD_DIS+"','"+DIR_CLI+"','"
				+CONA_CLI+"','"+sexo+"','"+TEL1A_CLI+"','"+TEL2A_CLI+"','"+FAXA_CLI+"','"+RPMA_CLI+"','"+NEXA_CLI+"','"+CELA_CLI+"','"+
				MAILA_CLI+"','"+CONB_CLI+"','"+TEL1B_CLI+"','"+CELB_CLI+"','"+MAILB_CLI+"','"+RPMB_CLI+"','"+NEXB_CLI+"','"+OBSB_CLI+"','"+OBS_CLI+"','"+EST_CLI+"','"+agente+"')";
				System.out.println(insertarPregunta);

				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				//System.out.println(insertarPregunta);
				if(op==0){
					objGUI.mostrarAviso("Hubo un ERROR al Ingresar\nlos datos");
				}else{
					objGUI.mostrarAviso("Se Ingreso Correctamente el Cliente");
				}
				
			objAccesoBD.cerrarConexion();
			}
			
		}
		/***********************************************/
	
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnRegistrar){
			  agregarCliente();
		}
		
		
	
	}

}
