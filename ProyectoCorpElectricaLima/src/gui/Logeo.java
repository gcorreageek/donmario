package gui;
//import gui.AppContadorSwing.RemindTask;

import gui.BuscarProducto.RemindTask;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import miLib.AccesoBD;
import miLib.AccesoBD2;
import miLib.Fecha;
import miLib.GUI;
import pOp.BuscarCotizacion;
import servlet.ServletCargarTareasReporte;
import servlet.ServletEnvioMailAuto;
import servlet.ServletEnvioMailAutoCli;
import servlet.ServletEnvioMailAutoCye;
import servlet.ServletEnvioMailAutoRep;
import servlet.ServletEnvioMailsAutoProve;
import servlet.ServletNumOrden;
import servlet.ServletSolCliMailAuto;
import servlet.ServletSolProveMailAuto;
import beans.BeanCargarTareasReporte;
import beans.BeanEnvioCorreoCli;
import beans.BeanEnvioMailAuto;
import beans.BeanEnvioMailAutoCye;
import beans.BeanEnvioMailAutoRep;
import beans.BeanEnvioMailsAutoProv;
import beans.BeanEnvioMailsCli;
import beans.BeanNumOrden;
import beans.BeanSolProveMailAuto;
import beans.Globales;
import calendar.DateButton;

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
public class Logeo extends JFrame implements ActionListener, KeyListener {
	private JPanel pnlLogeo;
	private JPanel pnlPrincipal;
	private JButton btnCancelar;
	private JButton btnIngresar;
	private JTextField txtCodUsuario;
	private JPasswordField txtClave;
	private JLabel lblClave;
	private JLabel lblTipoUsuario;
	MenuPrincipal  objMenu;
	private JButton btnAceptar;
	private JButton btnAyer;
	private JButton btnCancelarTipoCambio;
	private JTextField txtVenta;
	private JTextField txtCompra;
	private JComboBox cboMoneda;
	private JLabel lblVenta;
	private JLabel lblCompra;
	private JLabel lblMoneda;
	private JLabel lblFecha;
	private JPanel pnlDatos;
	Globales objG;
	boolean val=false;
	private JLabel lblImagen3;
	private JLabel lblImagen2;
	private JLabel lblLogeo;
	EnvioMailsAuto objf;
	EnvioMailsAutoRep objEMR;
	EnvioMailsAutoProveProdPrec objEMPROV;
	ReporteSolProve objRep;
	BuscarCotizacion objCot;
	
	ClassLoader cl = this .getClass().getClassLoader();
	URL cad=cl.getResource("Images/logeo.jpg");
	
	Icon imagen  = new ImageIcon(cad);
	Icon imagen2  = new ImageIcon(cl.getResource("Images/tipo.jpg"));
	Icon imagen3  = new ImageIcon(cl.getResource("Images/iniciocel.gif"));

	private DateButton btnFecha;
	GUI objGUI;
	Timer timer;
	int segundos,segundos2;//manejar el valor del contador
	int contaRep,contaRepProve;
	public boolean frozen;
	Fecha objfec;
	
	String fec,codi_ven,fecha,fec2;
	int cod_vend,tiempoven,numerodeorden;
	ServletEnvioMailAuto objenvioMailAuto;
	ServletEnvioMailAutoCye objenvioMailAutoCye;
	ServletEnvioMailAutoRep objenvioMailAutoRep;
	ServletEnvioMailsAutoProve objenvioMailsAutoProv;
	ServletSolProveMailAuto objEnvioContesto;
	ServletSolCliMailAuto objEnvioCLi;
	public static String nomvend,sexcli,nomclien,fecp,fecs,correo,refe,est_emp;
	public static String nom_vendedor,sex_clie,nom_clien,fecc_rep,correo_rep,cod_cli,cot_cot;
	public static String nomvendProv,sexProv,nomProv,fecpProv,fecsProv,correoProv,refeProv,codRef;
	public static String nVendedor,per_prove,sex_prove,mail_prove;
	public static String nvendeor,sexocli,ncli,mailcli,mailbcli,est_llamada;
	public static String codigocliente,vendedor,conacli,sexcliente,mail1,mail2,est_envio;
	public static int est,numorden;
	int conTareas;
	ServletCargarTareasReporte objS= new ServletCargarTareasReporte();
	String nomcli;
	int contador;
	ServletNumOrden objSNumOrden= new ServletNumOrden();
	ServletEnvioMailAutoCli objEnvioCliNo;
	int orden;

	public  Logeo() {
			try {
				System.out.println("esto es en logeo:"+cad);
				//objGUI.mostrarAviso("mMIRAME:"+cad);
			//	this.setContentPane(new miLib.Contenedor());
				FlowLayout thisLayout = new FlowLayout();
				getContentPane().setLayout(thisLayout);

				pnlPrincipal = new JPanel();
				
				getContentPane().add(pnlPrincipal);
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(545, 565));

				pnlDatos = new JPanel();
				//((RootPaneContainer) pnlDatos).setContentPane(new miLib.Contenedor());
				pnlPrincipal.add(pnlDatos);
				//pnlDatos.setBorder(BorderFactory.createTitledBorder("Tipo de Cambio"));
				pnlDatos.setLayout(null);
				pnlDatos.setBounds(12, 109, 525, 444);
				pnlDatos.setVisible(false);
				pnlDatos.setVisible(false);

				lblFecha = new JLabel();
				pnlDatos.add(lblFecha);
				lblFecha.setText("Fecha:");
				lblFecha.setBounds(84, 312, 44, 15);

				lblMoneda = new JLabel();
				pnlDatos.add(lblMoneda);
				lblMoneda.setText("Moneda:");
				lblMoneda.setBounds(84, 345, 47, 10);

				lblCompra = new JLabel();
				pnlDatos.add(lblCompra);
				lblCompra.setText("Compra:");
				lblCompra.setBounds(84, 374, 52, 11);

				lblVenta = new JLabel();
				pnlDatos.add(lblVenta);
				lblVenta.setText("Venta:");
				lblVenta.setBounds(84, 403, 51, 14);

				cboMoneda = new JComboBox();
				pnlDatos.add(cboMoneda);
				cboMoneda.setEnabled(false);
				cboMoneda.addItem("Dolar $");
				cboMoneda.addItem("Euro  €");
				cboMoneda.setBounds(176, 341, 163, 22);

				txtCompra = new JTextField();
				pnlDatos.add(txtCompra);
				txtCompra.setBounds(176, 369, 166, 25);

				txtVenta = new JTextField();
				pnlDatos.add(txtVenta);
				txtVenta.setBounds(176, 400, 167, 21);
				txtVenta.addKeyListener(this);

				btnAyer = new JButton();
				pnlDatos.add(btnAyer);
				btnAyer.setText("Fecha Anterior");
				btnAyer.setBounds(353, 370, 95, 24);

				btnCancelarTipoCambio = new JButton();
				pnlDatos.add(btnCancelarTipoCambio);
				btnCancelarTipoCambio.setText("Cancelar");
				btnCancelarTipoCambio.setBounds(366, 472, 94, 23);

				btnAceptar = new JButton();
				pnlDatos.add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(351, 330, 98, 27);
				btnAceptar.addActionListener(this);

				btnCancelarTipoCambio.addActionListener(this);

				btnAyer.addActionListener(this);

				{
					pnlLogeo = new JPanel();
					pnlPrincipal.add(pnlLogeo);
					pnlLogeo.setLayout(null);
					//pnlLogeo.setBorder(BorderFactory.createTitledBorder("Tipo de Cambio"));
					pnlLogeo.setBounds(18, 117, 493, 436);

					//pnlLogeo.add(cboTipoUsuario);
					//cboTipoUsuario.addItem("Administrador");
					//cboTipoUsuario.addItem("Vendedor1");
					
					//cboTipoUsuario.addItemListener(this);
					
					lblTipoUsuario = new JLabel();
					pnlLogeo.add(lblTipoUsuario);
					lblTipoUsuario.setText("Usuario:");
					lblTipoUsuario.setBounds(88, 307, 82, 14);
					
					lblClave = new JLabel();
					pnlLogeo.add(lblClave);
					lblClave.setText("Clave:");
					lblClave.setBounds(88, 343, 82, 14);
					
					txtClave = new JPasswordField();
					pnlLogeo.add(txtClave);
					txtClave.setBounds(217, 340, 191, 21);
					txtClave.addKeyListener(this);

					txtCodUsuario = new JTextField();
					pnlLogeo.add(txtCodUsuario);
					txtCodUsuario.setBounds(217, 307, 191, 21);
					
					btnCancelar = new JButton();
					pnlLogeo.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(325, 373, 89, 26);
					
					btnIngresar = new JButton();
					pnlLogeo.add(btnIngresar);
					btnIngresar.setText("Aceptar");
					btnIngresar.setBounds(88, 373, 86, 26);
					//frozen = true; //iniciamos el estado en congelado
				

					/*lblLogeo = new JLabel();
					pnlDatos.add(lblLogeo);
					//lblLogeo.setIcon(new ImageIcon("Images/cel.gif").getImage())
					//lblLogeo.setI
					//lblLogeo.setText("Fecha:");
					//lblLogeo.setBounds(17, 27, 44, 14);*/
					lblLogeo = new JLabel(imagen);
					pnlLogeo.add(lblLogeo);
					lblLogeo.setBounds(100, 19, 294, 256);

					//lblLogeo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/INICIO.gif")));

					btnIngresar.addActionListener(this);					
					btnCancelar.addActionListener(this);					
					txtClave.addActionListener(this);
					
					btnFecha = new DateButton();
					btnFecha.setFont(new Font("dialog",0,12));
					pnlDatos.add(btnFecha);
					btnFecha.setBounds(176, 308, 167, 22);
					
					try{
						cargarTipoCambio();
					}catch(Exception e){
						System.out.println("GGGGGGGGGGGGGG");
					}
					pack();
				}
				lblImagen3 = new JLabel(imagen3);
				pnlPrincipal.add(lblImagen3);
				lblImagen3.setBounds(0, 0, 545, 105);

				lblImagen2 = new JLabel(imagen2);
				pnlDatos.add(lblImagen2);
				lblImagen2.setBounds(109, 19, 319, 263);

			} catch(Exception e) {
				e.printStackTrace();
			}
			addWindowListener(new WindowAdapter() {
		        public void windowClosing(WindowEvent e) {
		            int n = JOptionPane.showConfirmDialog(e.getWindow(),"¿Desea Cerrar el Sistema?", "Se Cerrará el Sistema",
		            		JOptionPane.YES_NO_OPTION);
					switch (n){
					case JOptionPane.YES_OPTION:
						System.exit(0);
						break;
					case JOptionPane.NO_OPTION:
						break;
					default:
						System.out.println("CERO");
					}           
		        }
			});
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		
	public void metodoCancelar(){
		
		setVisible(false);
		System.exit(0);
	}
	public String buscarNombre(int cod){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs =null;
		String nom="";
		
		try{
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT * from tb_vendedores where cod_ven='"+cod+"'";
		System.out.println(maxCodPregunta);
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		
		
		if(rs.next()){
			String nombre=rs.getString(2).toString();
			nom=nombre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return nom;
	}
	
	public int buscarCodigo(String login,String pass){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT * from tb_vendedores where login_ven='"+login+"' and paSs_ven='"+pass+"'";
		System.out.println(maxCodPregunta);
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		
			if(rs.next()){
				int cod=Integer.parseInt(rs.getString(1));
				return cod;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return 0;
	}
	
	public int buscarTiempo(int cod){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		int time=0;
		
		try{
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT * from tb_vendedores where cod_ven='"+cod+"'";
		System.out.println(maxCodPregunta);
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
				
			if(rs.next()){
				int tiempo=rs.getInt(7);
				time=tiempo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return time;
	}
	
	public int buscarNumOrden(int cod){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		int numorden=0;
		
		try{			
		
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT * from tb_vendedores where cod_ven='"+cod+"'";
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		
			if(rs.next()){
				int norden=rs.getInt(8);
				numorden=norden;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return numorden;
	}
	public int retornaUltimoNumOrden(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
			
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT max(num_orden) FROM tb_vendedores";
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		int cod = 0;
		
			while(rs.next()){
				
				cod=rs.getInt(1);
				cod=cod+1;
				return cod;
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return 1;
	 } 
	
    public int retornaUltimoNumOrden2(){
    	
    	int cod_ven=objG.COD_VEN;
    	AccesoBD objAccesoBD = new AccesoBD();
    	ResultSet rs=null;
    	try{		
    	
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT num_orden FROM tb_vendedores where cod_ven='"+cod_ven+"';";
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		int cod = 0;
		
			while(rs.next()){
				cod=rs.getInt(1);
				return cod;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return 1;
	 } 
    
    public int buscarMinNumOrden(){
    	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		int numorden=0;
		
		try{
			
		objAccesoBD.crearConexion();
		String maxCodPregunta=" select min(num_orden) from tb_vendedores " +
                " where num_orden !=0;";
		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
				
		while(rs.next()){
			numorden=rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return numorden;
	}
	///////////////////////////////////////////////////////////////////////////////
	/*****************************************************************************/
	////////////////ACA COMIENSA LOS METODOS DE TIPO DE CAMBIO////////////////////
	/*****************************************************************************/
	/********CARGA LAS FECHAS********************************/
	
	/*SELECT * FROM cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM)
FROM CAMBIO WHERE FECHA='2009-11-26');*/
	

	public void cargarTipoCambio(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
			
		objAccesoBD.crearConexion();		
		String fecha=btnFecha.getText(),
		dia=fecha.substring(0, fecha.indexOf("-")),
		mes=fecha.substring(3, 5),
		año=fecha.substring(6, 10);
		fecha=año+"-"+mes+"-"+dia;
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM)" +
				" FROM tb_cambio WHERE FECHA='"+fecha+"'); ";

		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				
				if(rs.getString(1).equals("")){
					System.out.println("No hay fecha para hoy"+rs.getString(1));
				}else{
					txtCompra.setText(rs.getString(3));
					txtVenta.setText(rs.getString(4));		
				}
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
	}
	
	
	/*********************************************************/
	
	/********AGREGAR TIPO DE CAMBIO************************/
	public void agregarTipoCambio(){
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD objAccesoBD = new AccesoBD();
		try{
		
		objAccesoBD.crearConexion();
		String compra=txtCompra.getText(),venta=txtVenta.getText(),fecha=btnFecha.getText(),
		dia=fecha.substring(0, fecha.indexOf("-")),
		mes=fecha.substring(3, 5),
		año=fecha.substring(6, 10);
		fecha=año+"-"+mes+"-"+dia;
		
		
		String insertarCambio="INSERT INTO tb_cambio VALUES("+null+",'"+fecha+"','"+compra+"','"+venta+"')";
		System.out.println(insertarCambio);
		int op= objAccesoBD.ejecutarActualizacion(insertarCambio);
		
			if(op==0){
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
			}
			else{
				System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar product0 !!!!!!!");
			}

		}finally{
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		
		
	}
	/***********************************************/
	/********ULTIMA FECHA************************/
	public void ultimaFecha(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				txtCompra.setText(rs.getString(3));
				txtVenta.setText(rs.getString(4));		
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
	}
	/***********************************************/
	public boolean  ultimaFechaS(){
		
	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				double compra=Double.parseDouble(txtCompra.getText()),compraT=Double.parseDouble(rs.getString(3));
				double venta=Double.parseDouble(txtCompra.getText()),ventaT=Double.parseDouble(rs.getString(3));
				if(venta==ventaT&compra==compraT){
					
					System.out.println(txtCompra.getText()+"="+rs.getString(3).trim());
					System.out.println(txtVenta.getText()+"="+rs.getString(4).trim());
					return true;
				}else{
					System.out.println("FALSE");

					System.out.println(txtCompra.getText()+"="+rs.getString(3).trim());
					System.out.println(txtVenta.getText()+"="+rs.getString(4).trim());
					return false;
				}
					
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return false;
	}
	
	public void metodosIngresar(){
		
		System.out.println(txtCodUsuario.getText());
		String login=txtCodUsuario.getText();
		String pass=txtClave.getText();
		System.out.println(login+"-"+pass);
		
		int cod=buscarCodigo(login, pass);
		
		if(cod!=0){
			objG.COD_VEN=cod;
			String nomb=buscarNombre(cod);
			objG.NOM_VEN=nomb;
			int timer=buscarTiempo(cod);
			objG.TIME_VEN=timer;
			int orden=buscarNumOrden(cod);
			objG.NUM_ORDEN=orden;
			//objMenu=null;
			//objMenu=new MenuPrincipal();
			pnlLogeo.setVisible(false);
			pnlDatos.setVisible(true);
		}else{
			System.out.println("ERROR EN LOS DATOS INGRESADOS"+cod);
			JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña invalida","",2);
		}	
	}
	public void metodosAceptarIngresar(){
		 fecha=objfec.fechaActual();
		 cod_vend=objG.COD_VEN;
		 tiempoven=objG.TIME_VEN;
		 numerodeorden=objG.NUM_ORDEN;
		if(txtCompra.getText().equals("")||txtCompra.getText()==null){
			
			
		}else{
			if(ultimaFechaS()&val==false){//es la misma
				this.setVisible(false);
				pnlPrincipal.setVisible(false);
				objMenu=null;
				objMenu=new MenuPrincipal();
				
				
			}else{
			agregarTipoCambio();
			this.setVisible(false);
			pnlPrincipal.setVisible(false);
			objMenu=null;
			objMenu=new MenuPrincipal();	
			} 
			objMenu.setIconImage(new ImageIcon(cl.getResource("Images/kdmconfig.png")).getImage());
			
			objMenu.setTitle("CORPELIMA II S.A.C.");
			
			
			
			/*********************************************************************************************************************************/
			 
			//cargarNumOrden();
			//AQUI ENTRA ALA GUI PRINCIPAL
//			try {
//				start();
//			} catch (Exception e) { 
//				e.printStackTrace();
//			}
			
			//cargarEnvioMailsAuto();
		}
		
	}
	
	public void start() throws Exception {
		timer = new Timer(); 
		frozen = false; 		 
		//le asignamos una tarea al timer  
		timer.schedule(new RemindTask(),0, 1*1000);
	}// end Start
	
	public void stop() {
			System.out.println("Stop");
			frozen = true;
			segundos=0;
			timer.cancel();/////////////////////////////////////////////
	}// end Stop
	 	
	public void reset() {
			System.out.println("Reset");
			frozen = true;
			segundos = 0;
	}// end Reset
	
	/***********************************************************************************************************************************************/
    public void cargarEnvioMailsAuto(){
    	
    	objenvioMailAuto=null;
		objenvioMailAuto= new ServletEnvioMailAuto();		
		objenvioMailAuto.eliminarTodo();
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql=" SELECT ENV.id_mail,ENV.fec_pemail,ENV.fec_semail,ENV.cod_ven,VEN.nom_ven,VEN.time_ven,ENV.cod_cli,CLI.CONA_CLI,CLI.MAILA_CLI, "+
		  "CLI.SEX_CLI,ENV.est_mail,ENV.est_mail2,ENV.ref,ENV.est_emp "+
		  "FROM tb_enviomails ENV INNER JOIN tb_vendedores VEN ON ENV.cod_ven = VEN.cod_ven "+
		  "INNER JOIN tb_cliente CLI ON ENV.cod_cli = CLI.COD_CLI "+
		  "WHERE  ENV.est_mail=0 OR ENV.est_mail2=0 AND (date(ENV.fec_pemail)=CURDATE() or date(ENV.fec_semail)=CURDATE());";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				BeanEnvioMailAuto objE= new BeanEnvioMailAuto(rs.getString(1), SinMilisegundos(rs.getString(2).trim()), SinMilisegundos(rs.getString(3).trim()),
						rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13),rs.getString(14));
				objenvioMailAuto.adicionar(objE);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    }
	/***********************************************************************************************************************************************/
    public String SinMilisegundos(String cad){
    	
    	String palabra="",pal="";
    	
    	for(int i=0;i<cad.length();i++){
    		palabra=""+cad.charAt(i);
    		if(palabra.equals(".")){
    			break;
    		}else{
    			pal+=palabra;
    		}
    	}
    	
    	return pal;
    }
    /***********************************************************************************************************************************************/
    public void cargarEnvioMailsAutoCye(){
    	
    	objenvioMailAutoCye=null;
		objenvioMailAutoCye= new ServletEnvioMailAutoCye();		
		objenvioMailAutoCye.eliminarTodo();
		AccesoBD2 objAccesoBD = new AccesoBD2();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql=" SELECT ENV.id_mail,ENV.fec_pemail,ENV.fec_semail,ENV.cod_ven,VEN.nom_ven,VEN.time_ven,ENV.cod_cli,CLI.CONA_CLI,CLI.MAILA_CLI, "+
		  "CLI.SEX_CLI,ENV.est_mail,ENV.est_mail2,ENV.ref "+
		  "FROM tb_enviomails ENV INNER JOIN tb_vendedores VEN ON ENV.cod_ven = VEN.cod_ven "+
		  "INNER JOIN bd_cyeglobalelectric.tb_cliente CLI ON ENV.cod_cli = CLI.COD_CLI "+
		  "WHERE  ENV.est_mail=0 OR ENV.est_mail2=0 AND (date(ENV.fec_pemail)=CURDATE() or date(ENV.fec_semail)=CURDATE());";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				BeanEnvioMailAutoCye objE= new BeanEnvioMailAutoCye(rs.getString(1), SinMilisegundos(rs.getString(2).trim()), SinMilisegundos(rs.getString(3).trim()),
						rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13));
				objenvioMailAutoCye.adicionar(objE);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    }
	/**********************************************************************************************************************************************/
      public void cargarCorreosDeReporte(){
		
		objenvioMailAutoRep=null;
		objenvioMailAutoRep=new ServletEnvioMailAutoRep();		
		String fecha=objfec.fechaActual();
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT REP.COD_CLI,CLI.CONA_CLI,CLI.SEX_CLI,CLI.MAILA_CLI,VEN.nom_ven,REP.FEC_REP,REP.FECC_REP,REP.EST_REP "+
		  "FROM tb_reporte Rep INNER JOIN tb_vendedores VEN ON REP.cod_ven = VEN.cod_ven "+
		  "INNER JOIN tb_cliente CLI ON REP.cod_cli = CLI.COD_CLI "+
		  "WHERE   REP.FECC_REP='"+fecha+"' AND (REP.EST_REP=2 or REP.EST_REP=0);";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				BeanEnvioMailAutoRep objE= new BeanEnvioMailAutoRep(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				objenvioMailAutoRep.adicionar(objE);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		
	}
	
	/********************************************************************************************************************************************/
	
     public void cargarTareasDeReporte(){
    	 
    	
 		int cod_ven=objG.COD_VEN;
 		String fecha=objfec.fechaActual();
 		objS.eliminarTodo();
 		AccesoBD objAccesoBD = new AccesoBD();
 		ResultSet rs = null;
 		
 		try{
 		objAccesoBD.crearConexion();
 			
 		String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,CLI.COD_TIPO," +
 		   "if(CLI.SEX_CLI=0,'Sexo',if(CLI.SEX_CLI=1,'Masculino','Femenino')), "+
            "concat(if(day(REP.FEC_REP)<10,concat(0,day(REP.FEC_REP)),day(REP.FEC_REP)),'-', "+
            "if(month(REP.FEC_REP)<10,concat(0,month(REP.FEC_REP)),month(REP.FEC_REP)),'-', "+
            "year(REP.FEC_REP)) AS fecha_actual, "+
      	   "concat(if(day(REP.FECC_REP)<10,concat(0,day(REP.FECC_REP)),day(REP.FECC_REP)),'-', "+
            "if(month(REP.FECC_REP)<10,concat(0,month(REP.FECC_REP)),month(REP.FECC_REP)),'-', "+
            "year(REP.FECC_REP)) 'fecha de cita', "+
            "if(REP.TIP_REP=0,'LL',if(REP.TIP_REP=1,'NLL',if(REP.TIP_REP=2,'NV', "+
            "if(REP.TIP_REP=3,'@',if(REP.TIP_REP=4,'O/C','VACIO'))))) , "+
            "if(REP.CAL_REP=0,'Caliente',if(REP.CAL_REP=1,'Tibio',if(REP.CAL_REP=2,'Frio', "+
            "if(REP.CAL_REP=3,'Otros','VACIO')))),REP.OBS_REP, "+
            "IF(REP.EST_REP=0,'',IF(REP.EST_REP=1,'Si Contesto','No Contesto')), "+
      	   "CLI.LUG_CLI,CLI.DIR_CLI,CLI.COD_DEP,CLI.COD_PRO,CLI.COD_DIS,CLI.CONA_CLI,CLI.TEL1A_CLI, "+
      	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
      	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
            "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
      	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
      	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' ,REP.HORA " +
      	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
            "ON REP.COD_CLI = CLI.COD_CLI "+
      	   "INNER JOIN tb_vendedores VEN "+
      	   "ON REP.COD_VEN=VEN.COD_VEN "+
      	    "where REP.fecc_rep='"+fecha+"' "+
            "ORDER BY  MONTH(REP.FEC_REP) DESC , DAY(REP.FEC_REP) DESC;";
                
 		
 		rs=objAccesoBD.ejecutarConsulta(sql);
 		 			
 			while(rs.next()){
 				conTareas++;
 			BeanCargarTareasReporte objR= new BeanCargarTareasReporte(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
 					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
 					rs.getString(10), rs.getString(11), rs.getString(12),
 					rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
 					rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
 					rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
 					rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
 					rs.getString(33),rs.getString(34),rs.getString(35));
 			objS.adicionar(objR);
 			
 			}
 		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		
	}
   /**********************************************************************************************************************************************/
     
     public void actualizarTiempo(){
    	 
// 		AccesoBD objAccesoBD = new AccesoBD();
 		int op = 0;
 		
 		try{
//	 		objAccesoBD.crearConexion();
	 			
	 		int codven=objG.COD_VEN;
	 		int tam= objS.tamaño();
	 		
	 		int time=0;
	 		int tiempo=0;
	 		String fechaActual=objfec.fechaActual();
	 		if(conTareas==0){
	 			time=0;
	 		}else{
	 			time=(3600*8)/conTareas;
	 		}
	 		
	 		if(tam>0){
	 			
	 			for (int i = 0; i < objS.tamaño(); i++) {
	 			tiempo=tiempo+time;
	 			BeanCargarTareasReporte objExcel=objS.obtener(i);
	 			String insertarPregunta="update tb_reporte set hora=(sec_to_time(time_to_sec(TIMESTAMPADD(second,'"+tiempo+"',TIMESTAMP('"+fechaActual+"',hora))))) "+
	 			                         " where hora='09:00:00' and cod_rep='"+objExcel.getCodrep()+"' and cod_ven='"+codven+"' and fecc_rep='"+fechaActual+"';";
//	 			System.out.println(insertarPregunta);
//	 			op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
	 				 
	 			}
	 		}
 		
 		}finally{
// 				if(op==0){ 
// 					System.out.println("Se actualizo mas de una vez"); 
// 				}else{
// 					System.out.println("Se actualizo por primera vez");
// 				}
 	 			//objAccesoBD.cerrarStatement();
// 				objAccesoBD.cerrarConexion();  
 	 	}
 	
 	}
 	
   /**********************************************************************************************************************************************/
  
     public void actualizarNumOrden(int numorden){
 		
 		int codven=objG.COD_VEN;
 		int op = 0;
 		AccesoBD objAccesoBD = new AccesoBD();
 		
 		try{
  		objAccesoBD.crearConexion();
 		
  		String insertarPregunta="update tb_vendedores set num_orden='"+numorden+"'"+
          " where cod_ven='"+codven+"' ;";
            System.out.println(insertarPregunta);
            op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
            
 		}finally{
				if(op==0){ 
					System.out.println("Se actualizo mas de una vez");
					
				}else{
					 System.out.println("Se actualizo satisfactoriamente!!!!!!!!!");
				}
	 			objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
	 	}
 		
 	}
    /**********************************************************************************************************************************************/
     public void actualizarNumOrden2(int numorden){
  		
    	
    	AccesoBD objAccesoBD = new AccesoBD();
    	int op = 0;
    	int codven=objG.COD_VEN;
    	
    	try{
  		objAccesoBD.crearConexion();

  			
  			for (int i = 0; i < objSNumOrden.tamaño(); i++) {
  				
  				if(objSNumOrden.obtener(i).getNum_orden()==numorden){
  	
		  			//BeanNumOrden objNOrden=objSNumOrden.obtener(i);
		  			String insertarPregunta="update tb_vendedores set num_orden=0 where cod_ven='"+codven+"';";
		  			System.out.println(insertarPregunta);
		
		  			try {
		  				 op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
		  			} catch (Exception e){
		  				// TODO: handle exception
		  				op=0;
		  				//System.out.println("ESTO NO KISO GUARDAR:"+guardarCotizacion);
		  			}finally{
		  				if(op==0){ 
		  					System.out.println("Error");
		  					
		  				}else{
		  					System.out.println("Se actualizo satisfactoriamente");
		  				}
		  			}
  				}
  				else if(objSNumOrden.obtener(i).getNum_orden()>numorden){
  					
  					String insertarPregunta="update tb_vendedores set num_orden='"+(objSNumOrden.obtener(i).getNum_orden()-1)+"'" +
  							" where cod_ven='"+objSNumOrden.obtener(i).getCod_ven()+"';";
		  			System.out.println(insertarPregunta);
		
		  			try {
		  				 op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
		  			} catch (Exception e){
		  				// TODO: handle exception
		  				op=0;
		  				//System.out.println("ESTO NO KISO GUARDAR:"+guardarCotizacion);
		  			}finally{
		  				if(op==0){ 
		  					System.out.println("Error");
		  					
		  				}else{
		  					System.out.println("Se actualizo satisfactoriamente");
		  				}
		  			}
  				}else{
  					
  					System.out.println("Nada");
  				}
  			
  		}
  		
  	
    }finally{
		if(op==0){ 
			System.out.println("Se actualizo mas de una vez");
			
		}else{
			 System.out.println("Se actualizo satisfactoriamente!!!!!!!!!");
		}
		objAccesoBD.cerrarStatement();
		objAccesoBD.cerrarConexion();  
    }
  }
  /***********************************************************************************************************/
    public void cargarNumOrden(){
    	
    	AccesoBD objAccesoBD = new AccesoBD();
    	ResultSet rs=null;
    	
    	try{
		objAccesoBD.crearConexion();
		String sql="SELECT cod_ven,num_orden from tb_vendedores ";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				BeanNumOrden obj= new BeanNumOrden(rs.getString(1),rs.getInt(2));
				objSNumOrden.adicionar(obj);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    	
    }
    /*****************************************************************************************************************/
     public void cargarEnvioMailsAutoProve(){
    	
    	objenvioMailsAutoProv=null;
    	objenvioMailsAutoProv= new ServletEnvioMailsAutoProve();		
    	objenvioMailsAutoProv.eliminarTodo();    	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT PROV.PER_PROVE,PROV.SEX_PROVE,PROV.MAIL_PROVE,VEN.nom_ven,ENVPROV.cod_ref,ENVPROV.fec_pemail, "+
                   "ENVPROV.fec_semail,ENVPROV.est_mail,ENVPROV.est_mail2 "+
		           "FROM tb_enviomailsprove ENVPROV INNER JOIN tb_vendedores VEN ON ENVPROV.cod_ven = VEN.cod_ven "+
		           "INNER JOIN tb_proveedor PROV ON ENVPROV.cod_prove = PROV.COD_PROVE "+
		           "WHERE  ENVPROV.est_mail=0 OR ENVPROV.est_mail2=0 and "+
                   "(month(ENVPROV.fec_pemail)=month(curdate()) or month(ENVPROV.fec_semail)=month(curdate()));";
		rs = objAccesoBD.ejecutarConsulta(sql); 
		
			while(rs.next()){
				BeanEnvioMailsAutoProv objE= new BeanEnvioMailsAutoProv(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				objenvioMailsAutoProv.adicionar(objE);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    }
	/***********************************************************************************************************************************************/
    public void envioMailsAutoProveAfirmativo(){
    	
    	objEnvioContesto=null;
    	objEnvioContesto= new ServletSolProveMailAuto();		
    	objEnvioContesto.eliminarTodo();    	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try {
			
		objAccesoBD.crearConexion();
		String sql="select sol.cod_solprove,repsol.cod_ven,ven.nom_ven,repsol.fec_sol,sol.cod_prove, "+
				   "prove.nom_prove,prove.PER_PROVE,prove.SEX_PROVE,prove.MAIL_PROVE,sol.hora_llamada, "+ 
				   "sol.est_llamada,sol.est_envio_mail "+
				   "from tb_reportesolprove repsol "+
				   "inner join tb_solprove sol "+
				   "on sol.cod_sol = repsol.cod_sol "+
				   "inner join tb_vendedores ven "+
				   "on repsol.cod_ven = ven.cod_ven "+
				   "inner join tb_proveedor prove "+
				   "on sol.cod_prove = prove.COD_PROVE "+
				   "where repsol.fec_sol=curdate();";
		rs = objAccesoBD.ejecutarConsulta(sql); 
		
			while(rs.next()){
				BeanSolProveMailAuto objE= new BeanSolProveMailAuto(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				objEnvioContesto.adicionar(objE);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    	
    }
     /***********************************************************************************************************************************************/
    public void envioMailsAutoCliAfirmativo(){
    	
    	objEnvioCLi=null;
    	objEnvioCLi= new ServletSolCliMailAuto();		
    	objEnvioCLi.eliminarTodo();    	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
		objAccesoBD.crearConexion();
		String sql="select repsol.cod_sol,repsol.cod_cli,cli.CONA_CLI,CLI.SEX_CLI,cli.MAILA_CLI,cli.MAILB_CLI, "+
				   "repsol.cod_ven,ven.nom_ven,repsol.est_llamada,repsol.est_envio_mail,repsol.est_envio_mail2 "+
				   "from tb_reportesolprove repsol "+
				   "inner join tb_cliente cli "+
				   "on repsol.cod_cli = CLI.COD_CLI "+
				   "inner join tb_vendedores ven "+
			       "on repsol.cod_ven = ven.cod_ven "+
				   "where repsol.fec_sol=curdate();";
			
		rs = objAccesoBD.ejecutarConsulta(sql); 
		
			while(rs.next()){
				BeanEnvioCorreoCli objE= new BeanEnvioCorreoCli(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9),rs.getString(10),rs.getString(11));
				objEnvioCLi.adicionar(objE);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    	
    }
    
     public void cargarEnvioMailsAutoCli(){
    	
    	objEnvioCliNo=null;
    	objEnvioCliNo= new ServletEnvioMailAutoCli();		
    	objEnvioCliNo.eliminarTodo();
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try {
		objAccesoBD.crearConexion();
		String sql="select cod_envio,nom_ven,cod_cli,cona_cli,sex_cli,maila_cli,mailb_cli,fecha,est_envio " +
				"from tb_enviomailscliente "+
		        "where fecha=curdate() and  est_envio=0";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				BeanEnvioMailsCli objE= new BeanEnvioMailsCli(rs.getString(1), SinMilisegundos(rs.getString(2).trim()), SinMilisegundos(rs.getString(3).trim()),
						rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				objEnvioCliNo.adicionar(objE);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
    }
     
     public String codCot(String cod_cli){
    	 
 		AccesoBD objAccesoBD = new AccesoBD();
 		String numorden="0";
 		ResultSet rs=null;
 		
 		try{
	 		objAccesoBD.crearConexion();
	 		String maxCodPregunta=" select max(cod_cot) from tb_cotizacion " +
	                 " where cod_cli ='"+cod_cli+"'";
	 		rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
	 		numorden="0";
	 		
	 		while(rs.next()){
	 			numorden=rs.getString(1);
	 			}
 		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
 		return numorden;
 	}
     
     public String sinSegundos(String fecha){
    	 
    	 String caracter="",cadena="";
    	 int cont=0;
    	 for(int i=0;i<fecha.length();i++){
    		 
    		 caracter=""+fecha.charAt(i);
    		 
    		 if(caracter.equals(":")){
    			 cont++;
    		 }
    		
    		 if(cont==2){
    			 break;
    		 }else{
    			 cadena+=caracter;
    		 }
    			 
    		 
    	 }
    	 
    	 return cadena;
     }
	/***********************************************************************************************************************************************/
     /***********************************************************************************************************************************************/
    
     class RemindTask extends TimerTask {
    	 
		public void run(){
			
			String hora=objfec.fechaActual3().trim();
			String tiempo=objfec.fechaActual6().trim();
			String hora1=objfec.fechaActual21().trim();
			String nomdia=objfec.fechaActual4();
			//int estado=0;
			
			
			//String fechasnom="Lima, "+objfec.fechaDia()+" de "+objfec.fechaMes()+" del "+objfec.fechaAño();
			orden=buscarNumOrden(objG.COD_VEN);
			envioMailsAutoProveAfirmativo();
			//envioMailsAutoCliAfirmativo();
			
		    segundos++;
		    segundos2++;
		    //System.out.println(segundos2);
		    //System.out.println(hora);
		    //System.out.println("hora3:"+hora+"  "+"hora6:"+tiempo);
		    
		    /*if(objG.COD_VEN!=9){
		    	envioMailsAutoProveAfirmativo();
		    }*/
		    
		    if(segundos==300){
		    	System.out.println("GARBAGE COLLECTOR");
		    	System.gc();
		    	segundos=0;
		    	
		    }
		    
		    if(segundos2==5){
		    	//System.out.println("QQQQQ:"+fechasnom);
		    	//System.out.println("HORA: "+sinSegundos(hora1));
		    	   cargarTareasDeReporte();
		    	   actualizarTiempo();
		    	   
		    	   
		    	   if(retornaUltimoNumOrden2()==0){
			    		 actualizarNumOrden(retornaUltimoNumOrden());
		    	   }else{
		    		   System.out.println("igual");
		    	   }    	  
		    	   
		    }		    	
		    
      	  /*if(objCot.abrir==1){
		   System.out.println("1");
		   objCot=null;
	      }else{
		   System.out.println("0");
	      }*/
		    
			for(int i=0;i<objS.tamaño();i++){

				   if(objS.obtener(i).getHora().trim().equals(tiempo) && objG.COD_VEN!=9){
					 
					 nomcli=objS.obtener(i).getContacto1cli();
					 objGUI.mostrarAviso("El dia de Hoy tiene que llamar a "+nomcli+" para generarle un reporte"); 
					 conTareas--;
					 
				   }else{	   
					
				   }
			}	
			
			for(int i=0;i<objEnvioContesto.tamaño();i++){

				   if(objEnvioContesto.obtener(i).getHora_llamada().trim().equals(tiempo) && objG.COD_VEN!=9){
					 
					 objGUI.mostrarAviso("El dia de Hoy tiene que llamar al Proveedor "+objEnvioContesto.obtener(i).getNom_prove()+
							 " para generarle un reporte");
				   }
			}
		    
			if(objG.COD_VEN==9){
				
				//System.out.println("FFFFF");
				
				cargarEnvioMailsAuto();
				cargarEnvioMailsAutoProve();
				envioMailsAutoProveAfirmativo();
				envioMailsAutoCliAfirmativo();
				cargarEnvioMailsAutoCli();
				
				for(int i=0;i<objenvioMailAuto.tamaño();i++){		
					//System.out.println("HORA: "+hora1);
					//System.out.println("FECHA: "+objenvioMailAuto.obtener(i).getFec_pemail());
					
					if(sinSegundos(objenvioMailAuto.obtener(i).getFec_pemail()).equals(hora1) && objenvioMailAuto.obtener(i).getEst_mail().equals("0")){
						System.out.println("ENTROOOOOOOOOOOOOOOO");
						
						numorden=1;
						if(objenvioMailAuto.obtener(i).getEst_emp().equals("1")){
							nomvend=objenvioMailAuto.obtener(i).getNom_ven();
							nomclien=objenvioMailAuto.obtener(i).getNom_cli();
							sexcli=objenvioMailAuto.obtener(i).getSex_cli();
							fecp=objenvioMailAuto.obtener(i).getFec_pemail();
							fecs=objenvioMailAuto.obtener(i).getFec_semail();
							correo=objenvioMailAuto.obtener(i).getMail_cli();
							refe=objenvioMailAuto.obtener(i).getRef();
							est_emp=objenvioMailAuto.obtener(i).getEst_emp();
							objf=null;
							objf=new EnvioMailsAuto();
							objf.setVisible(false);
							objf.envio2();
							objf.cambiarAenviado();
						}else if(objenvioMailAuto.obtener(i).getEst_emp().equals("2")){
							
						}
						
						
					}
					if(sinSegundos(objenvioMailAuto.obtener(i).getFec_semail()).equals(hora1) && objenvioMailAuto.obtener(i).getEst_mail2().equals("0")){
						
						numorden=1;
						if(objenvioMailAuto.obtener(i).getEst_emp().equals("1")){
							nomvend=objenvioMailAuto.obtener(i).getNom_ven();
							nomclien=objenvioMailAuto.obtener(i).getNom_cli();
							sexcli=objenvioMailAuto.obtener(i).getSex_cli();
							fecp=objenvioMailAuto.obtener(i).getFec_pemail();
							fecs=objenvioMailAuto.obtener(i).getFec_semail();
							correo=objenvioMailAuto.obtener(i).getMail_cli();
							refe=objenvioMailAuto.obtener(i).getRef();
							est_emp=objenvioMailAuto.obtener(i).getEst_emp();
							objf=null;
							objf=new EnvioMailsAuto();
							objf.setVisible(false);
							objf.envio2(); 
							objf.cambiarAenviado2();
							
						}						
					}
				}
	         /***********************************************************************************************/
				for(int i=0;i<objenvioMailsAutoProv.tamaño();i++){
					
					//System.out.println("HORA: "+hora1+".0");
					//System.out.println("FECHA: "+objenvioMailsAutoProv.obtener(i).getFec_semail());
					
					if(sinSegundos(objenvioMailsAutoProv.obtener(i).getFec_pemail()).equals(hora1+".0") && objenvioMailsAutoProv.obtener(i).getEst_mail().equals("0")){
						est=1;
						nomvendProv=objenvioMailsAutoProv.obtener(i).getNom_ven();
						nomProv=objenvioMailsAutoProv.obtener(i).getNom_prove();
						sexProv=objenvioMailsAutoProv.obtener(i).getSexprove();
						fecpProv=objenvioMailsAutoProv.obtener(i).getFec_pemail();
						fecsProv=objenvioMailsAutoProv.obtener(i).getFec_semail();
						correoProv=objenvioMailsAutoProv.obtener(i).getMail_prove();
						codRef=objenvioMailsAutoProv.obtener(i).getCod_ref();
						refeProv="";
						objEMPROV=null;
						objEMPROV=new EnvioMailsAutoProveProdPrec();
						objEMPROV.setVisible(false);
						objEMPROV.envio2();
						objEMPROV.cambiarAenviado(codRef);
					}
					if(sinSegundos(objenvioMailsAutoProv.obtener(i).getFec_semail()).equals(hora1+".0") && objenvioMailsAutoProv.obtener(i).getEst_mail2().equals("0")){
						est=1;
						nomvendProv=objenvioMailsAutoProv.obtener(i).getNom_ven();
						nomProv=objenvioMailsAutoProv.obtener(i).getNom_prove();
						sexProv=objenvioMailsAutoProv.obtener(i).getSexprove();
						fecpProv=objenvioMailsAutoProv.obtener(i).getFec_pemail();
						fecsProv=objenvioMailsAutoProv.obtener(i).getFec_semail();
						correoProv=objenvioMailsAutoProv.obtener(i).getMail_prove();
						codRef=objenvioMailsAutoProv.obtener(i).getCod_ref();
						refeProv="";
						objEMPROV=null;
						objEMPROV=new EnvioMailsAutoProveProdPrec();
						objEMPROV.setVisible(false);
						objEMPROV.envio2();
						objEMPROV.cambiarAenviado2(codRef);
					}
						
					else{
						
					}
				}
			/****************************************************************************************************/	
				for(int i=0;i<objEnvioContesto.tamaño();i++){
					
					  //CORREO AUTOMATICO PROVEEDOR CUANDO EN EL REPORTE LE PONEMOS LA OPCION "SI CONTESTO"
                      if(objEnvioContesto.obtener(i).getEst_llamada().equals("1") && 
                    		  objEnvioContesto.obtener(i).getEst_envio_mail().equals("0")){
                    	est=2;
                    	nVendedor=objEnvioContesto.obtener(i).getNom_ven();
                    	per_prove=objEnvioContesto.obtener(i).getPer_prove();
                    	sex_prove=objEnvioContesto.obtener(i).getSex_prove();
                    	mail_prove=objEnvioContesto.obtener(i).getMail_prove();
						
						objEMPROV=null;
						objEMPROV=new EnvioMailsAutoProveProdPrec();
						objEMPROV.setVisible(false);
						objEMPROV.envio3();
						objEMPROV.cambiarAenviado3(""+objEnvioContesto.obtener(i).getCod_solprove());
					}
                      //CORREO AUTOMATICO PROVEEDOR CUANDO EN EL REPORTE LE PONEMOS LA OPCION "NO CONTESTO"
                      if(objEnvioContesto.obtener(i).getEst_llamada().equals("2") && 
                    		  objEnvioContesto.obtener(i).getEst_envio_mail().equals("0")){
                    	est=3;
                    	nVendedor=objEnvioContesto.obtener(i).getNom_ven();
                    	per_prove=objEnvioContesto.obtener(i).getPer_prove();
                    	sex_prove=objEnvioContesto.obtener(i).getSex_prove();
                    	mail_prove=objEnvioContesto.obtener(i).getMail_prove();
						
						objEMPROV=null;
						objEMPROV=new EnvioMailsAutoProveProdPrec();
						objEMPROV.setVisible(false);
						objEMPROV.envio3();
						objEMPROV.cambiarAenviado3(""+objEnvioContesto.obtener(i).getCod_solprove());
					}
					
				}
				/******************************************************************************************************/
				for(int i=0;i<objEnvioCLi.tamaño();i++){
					
						if(objEnvioCLi.obtener(i).getEst_llamada().equals("2") && 
							objEnvioCLi.obtener(i).getEst_envio_mail().equals("0")){
						
						numorden=2;
						nvendeor=objEnvioCLi.obtener(i).getNom_ven();
						sexocli=objEnvioCLi.obtener(i).getSex_cli();
					    ncli=objEnvioCLi.obtener(i).getCona_cli();
					    mailcli=objEnvioCLi.obtener(i).getMaila_cli();
					    mailbcli=objEnvioCLi.obtener(i).getMailb_cli();
					    est_llamada="2";
					    
					    objf=null;
						objf=new EnvioMailsAuto();
						objf.setVisible(false);
						objf.envioSolCli(); 
						objf.cambiarAenviado3(""+objEnvioCLi.obtener(i).getCod_sol());
					    
					}
					
					if(objEnvioCLi.obtener(i).getEst_llamada().equals("3")&& 
							objEnvioCLi.obtener(i).getEst_envio_mail2().equals("0")){
						
						numorden=2;
						nvendeor=objEnvioCLi.obtener(i).getNom_ven();
						sexocli=objEnvioCLi.obtener(i).getSex_cli();
					    ncli=objEnvioCLi.obtener(i).getCona_cli();
					    mailcli=objEnvioCLi.obtener(i).getMaila_cli();
					    mailbcli=objEnvioCLi.obtener(i).getMailb_cli();
					    est_llamada="3";
					    
					    objf=null;
						objf=new EnvioMailsAuto();
						objf.setVisible(false);
						objf.envioSolCli(); 
						objf.cambiarAenviado4(""+objEnvioCLi.obtener(i).getCod_sol());
					    
					    
					}
					
				}
		 /*****************************************************************************************************/
				for(int i=0;i<objEnvioCliNo.tamaño();i++){
					
					if(objEnvioCliNo.obtener(i).getEst_envio().equals("0")){
						
						numorden=3;
						codigocliente=objEnvioCliNo.obtener(i).getCod_cli();
						vendedor=objEnvioCliNo.obtener(i).getNom_ven();
						conacli=objEnvioCliNo.obtener(i).getCona_cli();
						sexcliente=objEnvioCliNo.obtener(i).getSex_cli();
						mail1=objEnvioCliNo.obtener(i).getMaila_cli();
						mail2=objEnvioCliNo.obtener(i).getMailb_cli();
						
						objf=null;
						objf=new EnvioMailsAuto();
						objf.setVisible(false);
						objf.envioNoContestoCoti();
						objf.cambiarAenviado5(objEnvioCliNo.obtener(i).getCod_envio());
						objf.agregarReporte();
					}
				}
			}
					
		    if(hora.equals("6:00 PM")){
		        
		    	contaRep++;
		    	System.out.println(contaRep);
		    	cargarCorreosDeReporte();
				cargarTareasDeReporte(); 
				String fechas=objfec.fechaActual().trim();
				
				if(objG.COD_VEN==9 && contaRep==1){
						for(int i=0;i<objenvioMailAutoRep.tamaño();i++){
							
			    		nom_vendedor=objenvioMailAutoRep.obtener(i).getNom_ven();
			    		nom_clien=objenvioMailAutoRep.obtener(i).getNom_cli();
			    		sex_clie=objenvioMailAutoRep.obtener(i).getSex_cli();
			    		correo_rep=objenvioMailAutoRep.obtener(i).getMail_cli();
			    		fecc_rep=objenvioMailAutoRep.obtener(i).getFecc_rep();
			    		cod_cli=objenvioMailAutoRep.obtener(i).getCod_cli();
			    		//cot_cot=codCot(cod_cli);
			    		objEMR=null;
			    		objEMR=new EnvioMailsAutoRep();
			    		objEMR.setVisible(false);
			    		//System.out.println(objenvioMailAutoRep.obtener(i).getFecc_rep()+" === "+fechas);
			    		
			    		if(objenvioMailAutoRep.obtener(i).getFecc_rep().equals(fechas)){
			    			objEMR.envio3();
			    			//objEMR.agregarReporte();
			    		
			    		}else{
			    			//System.out.println("VACIO");
			    		}
			    	}
				}
						    	
		    }
		    
		    if(objG.COD_VEN!=9){
									
			    if(nomdia.equals("sáb")){
			    	
			    	 if(hora.equals("1:00 PM") && contaRepProve==0){
			    		 objRep=null;
						 objRep=new ReporteSolProve();
						 objRep.setVisible(false);
						 objRep.generarexcel();
						 contaRepProve++;
			    	 }
			    	 
			    }else{
			    	 if(hora.equals("6:00 PM") && contaRepProve==0){
			    		 objRep=null;
						 objRep=new ReporteSolProve();
						 objRep.setVisible(false);
						 objRep.generarexcel();
						 contaRepProve++;
			    	 }
			    	
			    }
		    }
		}
	  }
		
		/*public static void main(String[] args){
			JFrame.setDefaultLookAndFeelDecorated(true);
			EnvioMailsAuto c = new EnvioMailsAuto();
	    }*/
	
	  /***********************************************************************************************************************/
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnIngresar){
				metodosIngresar();
			}
			if(e.getSource()==btnCancelar){
				metodoCancelar();
			}
			///////////////////////////////////////////////////////////////////////////////
			/*****************************************************************************/
			////////////////ACA COMIENSA LOS ACTIONS DE TIPO DE CAMBIO////////////////////
			/*****************************************************************************/
			
			if(e.getSource()==btnAceptar){			
				metodosAceptarIngresar();				
			}
			if(e.getSource()==btnAyer){
				ultimaFecha();
			val=true;
			}
			
			
			}//termina action

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtClave){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				metodosIngresar();
				
				txtCompra.requestFocus();
			}
		}
		if(e.getSource()==txtVenta){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				metodosAceptarIngresar();
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
				
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
			
	}
					
}