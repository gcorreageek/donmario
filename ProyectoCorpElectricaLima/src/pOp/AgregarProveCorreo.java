package pOp;
import gui.MantProveedor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.GUI;
import servlet.ServletListarProveCorreo;
import beans.BeanListarProveCorreo;

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
public class AgregarProveCorreo extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblNomContacto;
	private JButton btnAgregar;
	private JTable tblListarProve;
	private JScrollPane jScrollPane1;
	private JComboBox cboSexo;
	private JLabel lblSexo;
	private JTextField txtEmail;
	private JLabel lblemail;
	private JTextField txtNomContacto;
	private JTextField txtNomProve;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JPanel pnlCentro;

	MantProveedor objprove;
	GUI objGUI;
	String titulo2[]={"COD.PROVE","NOM.PROVE","EMAIL","SEXO"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletListarProveCorreo objList = new ServletListarProveCorreo();
	public static int codProve=0,sexProve=0;
	public static String nomProve="",perProve="",mailProve="";
	int est=0;
	
	public AgregarProveCorreo(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(597, 294);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(710, 109));

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(22, 19, 57, 16);

			txtNomProve = new JTextField();
			pnlArriba.add(txtNomProve);
			txtNomProve.setBounds(79, 15, 378, 25);
			txtNomProve.addKeyListener(this);

			lblNomContacto = new JLabel();
			pnlArriba.add(lblNomContacto);
			lblNomContacto.setText("N.Contacto:");
			lblNomContacto.setBounds(6, 49, 65, 17);

			txtNomContacto = new JTextField();
			pnlArriba.add(txtNomContacto);
			txtNomContacto.setBounds(79, 45, 223, 20);
			txtNomContacto.setSize(223, 25);

			lblemail = new JLabel();
			pnlArriba.add(lblemail);
			lblemail.setText("Email:");
			lblemail.setBounds(37, 80, 37, 16);

			txtEmail = new JTextField();
			pnlArriba.add(txtEmail);
			txtEmail.setBounds(79, 78, 223, 20);
			txtEmail.setSize(223, 25);

			lblSexo = new JLabel();
			pnlArriba.add(lblSexo);
			lblSexo.setText("Sexo:");
			lblSexo.setBounds(308, 49, 38, 16);

			cboSexo = new JComboBox();
			pnlArriba.add(cboSexo);
			cboSexo.addItem("");
			cboSexo.addItem("Masculino");
			cboSexo.addItem("Femenino");
			cboSexo.setBounds(346, 45, 111, 25);

			btnAgregar = new JButton();
			pnlArriba.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(346, 75, 80, 26);
			btnAgregar.addActionListener(this);

			pnlAbajo = new JPanel();
			FlowLayout pnlAbajoLayout = new FlowLayout();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setLayout(pnlAbajoLayout);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(468, 35));

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(576, 46, 106, 26);
			btnAceptar.setBackground(new java.awt.Color(255,0,0));
			btnAceptar.setPreferredSize(new java.awt.Dimension(85, 26));
			btnAceptar.addActionListener(this);

			pnlCentro = new JPanel();
			GridLayout pnlCentroLayout = new GridLayout(1, 1);
			pnlCentroLayout.setColumns(1);
			pnlCentroLayout.setHgap(5);
			pnlCentroLayout.setVgap(5);
			getContentPane().add(pnlCentro, BorderLayout.CENTER);
			pnlCentro.setLayout(pnlCentroLayout);
			pnlCentro.setPreferredSize(new java.awt.Dimension(710, 74));

			jScrollPane1 = new JScrollPane();
			pnlCentro.add(jScrollPane1);
			
			tblListarProve = new JTable();
			jScrollPane1.setViewportView(tblListarProve);
			tblListarProve.setModel(modelo2);
			tblListarProve.addMouseListener(this);

			TableColumn cod = tblListarProve.getColumn ("COD.PROVE"),
			nom = tblListarProve.getColumn ("NOM.PROVE"),email = tblListarProve.getColumn ("EMAIL"),
			sexo = tblListarProve.getColumn ("SEXO");
			
			cod.setPreferredWidth(20);
			nom.setPreferredWidth(215);
			email.setPreferredWidth(105);
			sexo.setPreferredWidth(7);
			
			listarProve();
			
			
		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	
	
	
	public void listarProve(){

		
		objList.eliminarTodo();
		int n=modelo2.getRowCount();
		
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_PROVE, NOM_PROVE,PER_PROVE,MAIL_PROVE,SEX_PROVE " +
				"FROM tb_proveedor WHERE NOM_PROVE LIKE '"+txtNomProve.getText().trim()+"%' AND " +
				"EST_PROVE='ACTIVADO'";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {//
			while(rs.next()){
				
				BeanListarProveCorreo objP= new BeanListarProveCorreo(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				
				objList.adicionar(objP);
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objList.tamaño(); i++) {
			
			BeanListarProveCorreo objProve=objList.obtener(i) ;
			Object obj[]={Integer.parseInt(""+objProve.getCod_prove()),
					objProve.getNom_prove(),objProve.getMail_prove(),
					Integer.parseInt(""+objProve.getSex_prove())
			};
				
			modelo2.addRow(obj);
		}	
	}
	
	public void cargarlistaProve(){
		
		int fila = tblListarProve.getSelectedRow();
		est=1;
		codProve=objList.obtener(fila).getCod_prove();
		nomProve=objList.obtener(fila).getNom_prove();
		perProve=objList.obtener(fila).getPer_prove();
		mailProve=objList.obtener(fila).getMail_prove();
		sexProve=objList.obtener(fila).getSex_prove();
		
		txtNomProve.setText(""+objList.obtener(fila).getNom_prove());
		txtNomContacto.setText(""+objList.obtener(fila).getPer_prove());
		txtEmail.setText(""+objList.obtener(fila).getMail_prove());
		cboSexo.setSelectedIndex(objList.obtener(fila).getSex_prove());
		
		
	}
	
	public void limpiar(){
		
		txtNomContacto.setText("");
		txtEmail.setText("");
		cboSexo.setSelectedIndex(0);
		
	}
	
	public void insertarProveedor(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String insertarPregunta="INSERT INTO tb_proveedor VALUES("+null+",'"+txtNomProve.getText()+"',''," +
		"'','99','99','99','"+txtNomContacto.getText()+"','"+cboSexo.getSelectedIndex()+"','',''," +
		"'','','','','','',''," +
		"'','"+txtEmail.getText()+"','','','','','',''," +
		"'','','','','ACTIVADO','','','')";
		System.out.println(insertarPregunta);

		int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al agregar el proveedor");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se agrego al proveedor");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar proveedor !!!!!!!");}
		
	    objAccesoBD.cerrarConexion();
		
	}

	public void agregarRubroYMarcaProveedor(){
		 
    	try {
    		objprove = new MantProveedor();
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			int CODPROVE=retornaUltimoCodProve();
			String COD_RUBRO=""+objprove.codiRubro,EST_PROVERUBRO="ACTIVADO";
			String COD_MARCA=""+objprove.codiMarca;
	 		
	 		String insertarPregunta="INSERT INTO tb_proverubmar(cod_prove, cod_rubro, cod_mar, est_proverubmar)" +
	 					" VALUES('"+CODPROVE+"','"+COD_RUBRO+"','"+COD_MARCA+"','"+EST_PROVERUBRO+"');";
	 			System.out.println(insertarPregunta);

				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				
				if(op==0){
					//objGUI.mostrarAviso("Hubo un ERROR al Imgresar los datos");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
				}	
				else{
					//objGUI.mostrarAviso("Se ingreso Correctamente el Rubro");
					System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
				}
				
			objAccesoBD.cerrarConexion();	
		} catch (Exception e) {
			//objGUI.mostrarAviso("Debe llenar los datos");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
		}
    	 		
 	}
	
	 public int retornaUltimoCodProve(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT max(COD_PROVE) FROM tb_proveedor";


			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=1;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					return cod;
					}
				}
				rs.close();
			}catch (Exception e1){
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 1;
		 } 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAceptar){
					
			if(est==0){
				objGUI.mostrarAviso("Debe Seleccionar un Provedor");
			}else{
				setVisible(false);
			}
			
		}
		if(e.getSource()==btnAgregar){
			
			insertarProveedor();
			agregarRubroYMarcaProveedor();
			listarProve();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if(arg0.getSource()==txtNomProve){
			listarProve();
			limpiar();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
        
		cargarlistaProve();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
