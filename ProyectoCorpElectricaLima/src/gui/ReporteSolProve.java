package gui;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.PreparedStatement;
import miLib.AccesoBD;
import miLib.Fecha;
import miLib.GUI;
import miLib.PasarReporteSolProve;
import miLib.Tiempo;
import pOp.BuscarCliCita;
import pOp.BuscarRubroProveSol;
import pOp.CambiarLlamada;
import servlet.ServletExcelRepSolProve;
import servlet.ServletRepSolProve;
import servlet.ServletSolProve;
import util.Propiedades;
import beans.BeanExcelRepSol;
import beans.BeanRepSolProve;
import beans.BeanSolProve;
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
public class ReporteSolProve extends JInternalFrame implements ActionListener, MouseListener, KeyListener{
	
	private JPanel pnlNorte;
	private JTable tblSolProve;
	private JScrollPane jScrollPane2;
	private JPanel pnlSolProve;
	private JPanel pnlSur;
	private JRadioButton rbdOculto;
	private JTextField txtReferencia;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblFax;
	private JTextField txtFax;
	private JLabel lblRpm;
	private JTextField txtRpm;
	private JLabel lblNextel;
	private JTextField txtNextel;
	private JLabel lblTelefono1;
	private JTextField txtTelefono1;
	private JLabel lblTelefono2;
	private JTextField txtTelefono2;
	private JTextField txtProveedor;
	private JLabel lblNomProveedor;
	private JTextField txtPersonal;
	private JLabel lblPersonal;
	private JLabel lblReferencia;
	private JButton btnSolicitud;
	private JButton btnListar;
	private JTable tblSolicitud;
	private JScrollPane jScrollPane1;
	private JPanel pnlCentro;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;
	private JTextField txtCliente;
	private JLabel lblCliente;
	private JLabel lblFecha2;
	private JButton btnBuscar;
	private DateButton btnFecha1;
	private DateButton btnFecha2;
	private JButton btnRepProve;
	private JTextField txtCorreo;
	private JLabel lblMail;
	private JButton btnAgregar;
	private JButton btnCliente;
	private JButton btnRecibimos;
	public static JDesktopPane jDesktopPane1;
	Globales objGlo; 
	Tiempo objTime;
	CambiarLlamada objLlamada;
	MenuPrincipal objMenu;
	BuscarCliCita objBuscarCli;
	int segundos;
	private JLabel lblRuta;
	private JTextField txtRuta;
	public boolean frozen;
	Timer timer;
	
	String titulo2[]={"COD.SOLICITUD","REFERENCIA","NOM.CLIENTE","NOM.VENDEDOR","FECHA DE LA SOLICITUD","LLAMADA"
			};
	String titulo3[]={"COD.PROVEEDOR","NOM.PROVEEDOR","HORA DE LLAMADA","LLAMADA"
	};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo3);
	 GUI objGUI;
	 Fecha objFecha;
	 ServletRepSolProve objRepSol= new ServletRepSolProve();
	 ServletSolProve objSolProve = new ServletSolProve();
	 ServletExcelRepSolProve objExcelRepSol= new ServletExcelRepSolProve();
	 String codsol;
	 public static int codproverubro;
	 public static String nomprove;
	 Object[]arregloCadenasRepSol;
	 Object[][] arregloObjetosRepSol;
	 PasarReporteSolProve objPasarRepSol;
	 String codcli,nomcli;
	 int valor=0;
	 static String rutaExcelSolicitud;
	 
	/**************************************************************************************************
	**************************************************************************************************/
	
	public  ReporteSolProve() {
		super("Tarea", true, true, true, true);
		try {
			System.out.println("El ven cod:"+objGlo.COD_VEN);
				this.setPreferredSize(new java.awt.Dimension(849, 580));
				this.setBounds(0, 0, 849, 580);
				BorderLayout thisLayout = new BorderLayout();
				getContentPane().setLayout(thisLayout);

				pnlAbajo = new JPanel();
				getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
				pnlAbajo.setPreferredSize(new java.awt.Dimension(839, 275));
				pnlAbajo.setBorder(BorderFactory.createTitledBorder("Lista de Proveedores"));
				pnlAbajo.setLayout(null);

				pnlSolProve = new JPanel();
				GridLayout pnlSolProveLayout = new GridLayout(1, 1);
				pnlSolProveLayout.setColumns(1);
				pnlSolProveLayout.setHgap(5);
				pnlSolProveLayout.setVgap(5);
				pnlAbajo.add(pnlSolProve);
				pnlSolProve.setLayout(pnlSolProveLayout);
				pnlSolProve.setBounds(5, 110, 832, 158);

				lblNomProveedor = new JLabel();
				pnlAbajo.add(lblNomProveedor);
				lblNomProveedor.setText("Nom.Proveedor:");
				lblNomProveedor.setBounds(12, 21, 95, 16);

				txtProveedor = new JTextField();
				pnlAbajo.add(txtProveedor);
				txtProveedor.setBounds(106, 21, 393, 20);

				txtTelefono2 = new JTextField();
				pnlAbajo.add(txtTelefono2);
				txtTelefono2.setText("");
				txtTelefono2.setBounds(644, 47, 98, 20);

				lblTelefono2 = new JLabel();
				pnlAbajo.add(lblTelefono2);
				lblTelefono2.setText("Telefono 2:");
				lblTelefono2.setBounds(575, 48, 65, 19);

				txtTelefono1 = new JTextField();
				pnlAbajo.add(txtTelefono1);
				txtTelefono1.setText("");
				txtTelefono1.setBounds(457, 47, 106, 20);

				lblTelefono1 = new JLabel();
				pnlAbajo.add(lblTelefono1);
				lblTelefono1.setText("Telefono 1:");
				lblTelefono1.setBounds(382, 49, 63, 16);

				txtNextel = new JTextField();
				pnlAbajo.add(txtNextel);
				txtNextel.setText("");
				txtNextel.setBounds(645, 74, 97, 20);

				lblNextel = new JLabel();
				pnlAbajo.add(lblNextel);
				lblNextel.setText("Nextel:");
				lblNextel.setBounds(597, 75, 50, 16);

				txtRpm = new JTextField();
				pnlAbajo.add(txtRpm);
				txtRpm.setText("");
				txtRpm.setBounds(457, 74, 105, 20);

				lblRpm = new JLabel();
				pnlAbajo.add(lblRpm);
				lblRpm.setText("Rpm:");
				lblRpm.setBounds(425, 78, 31, 11);

				txtFax = new JTextField();
				pnlAbajo.add(txtFax);
				txtFax.setText("");
				txtFax.setBounds(323, 74, 94, 20);

				lblFax = new JLabel();
				pnlAbajo.add(lblFax);
				lblFax.setText("Fax:");
				lblFax.setBounds(292, 75, 35, 18);

				txtCelular = new JTextField();
				pnlAbajo.add(txtCelular);
				txtCelular.setText("");
				txtCelular.setBounds(172, 74, 106, 20);

				lblCelular = new JLabel();
				pnlAbajo.add(lblCelular);
				lblCelular.setText("Celular:");
				lblCelular.setBounds(124, 78, 48, 17);

				lblPersonal = new JLabel();
				pnlAbajo.add(lblPersonal);
				lblPersonal.setText("N.Personal:");
				lblPersonal.setBounds(510, 23, 68, 17);

				txtPersonal = new JTextField();
				pnlAbajo.add(txtPersonal);
				txtPersonal.setBounds(583, 21, 245, 20);

				lblMail = new JLabel();
				pnlAbajo.add(lblMail);
				lblMail.setText("Correo:");
				lblMail.setBounds(60, 49, 42, 16);

				txtCorreo = new JTextField();
				pnlAbajo.add(txtCorreo);
				txtCorreo.setBounds(106, 47, 264, 20);

				jScrollPane2 = new JScrollPane();
				pnlSolProve.add(jScrollPane2);
				jScrollPane2.setPreferredSize(new java.awt.Dimension(832, 156));

				tblSolProve = new JTable();
				jScrollPane2.setViewportView(tblSolProve);
				tblSolProve.setModel(modelo3);
				tblSolProve.addMouseListener(this);
				tblSolProve.addKeyListener(this);

				pnlCentro = new JPanel();
				pnlCentro.setLayout(null);
				getContentPane().add(pnlCentro, BorderLayout.CENTER);
				pnlCentro.setPreferredSize(new java.awt.Dimension(866, 57));
				pnlCentro.setBackground(new java.awt.Color(238,238,238));

				pnlArriba = new JPanel();
				getContentPane().add(pnlArriba, BorderLayout.NORTH);

				pnlSur = new JPanel();
				GridLayout pnlNorteLayout = new GridLayout(1, 1);
				pnlNorteLayout.setColumns(1);
				pnlNorteLayout.setHgap(5);
				pnlNorteLayout.setVgap(5);
				pnlArriba.add(pnlSur);
				pnlSur.setLayout(pnlNorteLayout);
				pnlSur.setBounds(5, 121, 829, 123);

				jScrollPane1 = new JScrollPane();
				pnlSur.add(jScrollPane1);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(856, 130));

				tblSolicitud = new JTable();
				jScrollPane1.setViewportView(tblSolicitud);
				tblSolicitud.setModel(modelo2);
				tblSolicitud.addKeyListener(this);
				tblSolicitud.addMouseListener(this);

				pnlNorte = new JPanel();
				pnlArriba.add(pnlNorte);
				pnlNorte.setLayout(null);
				pnlNorte.setBounds(5, 21, 824, 94);

				btnFecha1 = new DateButton();
				pnlNorte.add(btnFecha1);
				btnFecha1.setFont(new Font("dialog",0,12));
				btnFecha1.setBounds(697, 10, 126, 20);
				btnFecha1.setEnabled(false);
				btnFecha1.setSize(126, 21);

				btnFecha2 = new DateButton();
				pnlNorte.add(btnFecha2);
				btnFecha2.setFont(new Font("dialog",0,12));
				btnFecha2.setBounds(407, 40, 141, 19);
				btnFecha2.setSize(141, 21);

				rbdOculto = new JRadioButton();
		        pnlNorte.add(rbdOculto);
				rbdOculto.setText("oc");
			    rbdOculto.setBounds(731, 80, 39, 24);
				rbdOculto.addActionListener(this);
				
				 // Group the radio buttons.
			    ButtonGroup group = new ButtonGroup();
			    group.add(rbdOculto);
			    rbdOculto.setVisible(false);

			    lblCliente = new JLabel();
			    pnlNorte.add(lblCliente);
			    lblCliente.setText("Nombre:");
			    lblCliente.setBounds(9, 15, 79, 14);

			    txtCliente = new JTextField();
			    pnlNorte.add(txtCliente);
			    txtCliente.setBounds(94, 12, 349, 21);
			    txtCliente.addKeyListener(this);

		    	btnSolicitud = new JButton();
		    	pnlNorte.add(btnSolicitud);
		    	btnSolicitud.setText("Solicitud");
		    	btnSolicitud.setBounds(728, 40, 95, 21);
		    	btnSolicitud.addActionListener(this);

			    btnListar = new JButton();
			    pnlNorte.add(btnListar);
			    btnListar.setText("Listar");
			    btnListar.setBounds(636, 40, 87, 21);

		    	lblReferencia = new JLabel();
		    	pnlNorte.add(lblReferencia);
		    	lblReferencia.setText("Referencia:");
		    	lblReferencia.setBounds(7, 41, 70, 16);

		    	txtReferencia = new JTextField();
		    	pnlNorte.add(txtReferencia);
		    	txtReferencia.setBounds(94, 39, 222, 20);

		    	lblFecha2 = new JLabel();
		    	pnlNorte.add(lblFecha2);
		    	lblFecha2.setText("Fec.Busqueda:");
		    	lblFecha2.setBounds(322, 41, 84, 16);

		    	btnBuscar = new JButton();
		    	pnlNorte.add(btnBuscar);
		    	btnBuscar.setText("Buscar");
		    	btnBuscar.setBounds(551, 40, 80, 23);
		    	btnBuscar.setSize(80, 21);

		    	btnRepProve = new JButton();
		    	pnlNorte.add(btnRepProve);
		    	btnRepProve.setText("Rep.Solicitud Provedores");
		    	btnRepProve.setBounds(493, 68, 180, 21);

	    		btnCliente = new JButton();
	    		pnlNorte.add(btnCliente);
	    		btnCliente.setText("Buscar Cliente");
	    		btnCliente.setBounds(453, 12, 119, 23);
	    		btnCliente.setSize(119, 21);
	    		btnCliente.addActionListener(this);
	    	
	    	
	    		btnAgregar = new JButton();
	    		pnlNorte.add(btnAgregar);
	    		btnAgregar.setText("Agregar");
	    		btnAgregar.setBounds(583, 11, 100, 24);
	    		btnAgregar.setSize(100, 21);

    			btnRecibimos = new JButton();
    			pnlNorte.add(btnRecibimos);
    			btnRecibimos.setText("Recibimos Solicitud");
    			btnRecibimos.setBounds(678, 68, 146, 21);
    			{
    				txtRuta = new JTextField();
    				pnlNorte.add(txtRuta);
    				txtRuta.setBounds(94, 69, 393, 21);
    			}
    			{
    				lblRuta = new JLabel();
    				pnlNorte.add(lblRuta);
    				lblRuta.setText("Ruta:");
    				lblRuta.setBounds(7, 72, 41, 14);
    			}

    			btnRecibimos.addActionListener(this);
	    		
	    		btnAgregar.addActionListener(this);
		    	
		    	btnRepProve.addActionListener(this);

		    	btnBuscar.addActionListener(this);

			    btnListar.addActionListener(this);

				pnlArriba.setPreferredSize(new java.awt.Dimension(839, 257));
				pnlArriba.setBorder(BorderFactory.createTitledBorder("Lista de Solicitudes"));
				pnlArriba.setLayout(null);

				listarRepSolProve();
				objLlamada= new CambiarLlamada();
				
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
       public void listarRepSolProve(){
		
		objRepSol.eliminarTodo();
		int n=modelo2.getRowCount();
		
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		
		String sql="select repsol.cod_sol,CLI.COD_CLI,cli.NOM_CLI,ven.cod_ven,ven.nom_ven, "+
                   "repsol.ruta_sol,repsol.ref_sol,repsol.fec_sol, " +
                   "IF(repsol.est_llamada=0,'',IF(repsol.est_llamada=1,'Si Contedto',IF(repsol.est_llamada=2,'No Contesto','')))," +
                   "repsol.est_envio_mail,repsol.idArchivo "+
                   "from tb_reportesolprove repsol inner join tb_cliente cli "+
                   "on repsol.cod_cli = CLI.COD_CLI inner join tb_vendedores ven "+
                   "on repsol.cod_ven = ven.cod_ven "+
                   "order by repsol.fec_sol desc,repsol.cod_sol desc;";

		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
			BeanRepSolProve objR= new BeanRepSolProve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10),rs.getString(11));
			objRepSol.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
		for (int i = 0; i < objRepSol.tamaño(); i++) {
			

			Object[] obj={objRepSol.obtener(i).getCod_sol(),objRepSol.obtener(i).getRef_sol(),
					objRepSol.obtener(i).getNom_cli(),objRepSol.obtener(i).getNom_ven(),
					objRepSol.obtener(i).getFec_sol(),objRepSol.obtener(i).getEst_llamada()
			};
			modelo2.addRow(obj);
			
		}
	}

       public void listarSolProve(String cod){
   		
   		objSolProve.eliminarTodo();
   		int n=modelo3.getRowCount();
   		
   		for (int fila=0; fila<n; fila++)
   		modelo3.removeRow(0);
   		
   		AccesoBD objA = new AccesoBD();
   		objA.crearConexion();
   		
   		String sql="select sol.cod_solprove,repsol.cod_sol,pro.COD_PROVE,pro.NOM_PROVE, "+
		   		   "pro.PER_PROVE,pro.TEL1_PROVE,pro.TEL2_PROVE,pro.RPM_PROVE,pro.NEX_PROVE, "+
		   		   "pro.CEL_PROVE,pro.FAX_PROVE,sol.hora_llamada, " +
		   		   "IF(sol.est_llamada=0,'',IF(sol.est_llamada=1,'Si Contesto',IF(sol.est_llamada=2,'No Contesto','No Tiene el Producto'))), " +
		   		   "pro.mail_prove "+
		   		   "from tb_solprove sol inner join tb_proveedor pro "+
		   		   "on sol.cod_prove = pro.COD_PROVE "+
		   		   "inner join tb_reportesolprove repsol "+
		   		   "on sol.cod_sol = repsol.cod_sol "+
		   		   "where repsol.cod_sol='"+cod+"';";

   		ResultSet rs=objA.ejecutarConsulta(sql);
   		try {
   			
   			while(rs.next()){
   			BeanSolProve objS= new BeanSolProve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
   					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
   					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
   			objSolProve.adicionar(objS);
   			
   			}
   			rs.close();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		objA.cerrarConexion();
   		
   		for (int i = 0; i < objSolProve.tamaño(); i++) {
   			
   			
   			Object[] obj={objSolProve.obtener(i).getCod_prove(),objSolProve.obtener(i).getNom_prove(),
   					objSolProve.obtener(i).getHora_llamada(),objSolProve.obtener(i).getEst_llamada()
   			};
   			modelo3.addRow(obj);
   			
   		}
   	}
    
       public void buscarRepSolProve(){
   		
   		objRepSol.eliminarTodo();
   		int n=modelo2.getRowCount();
   		
   		for (int fila=0; fila<n; fila++)
   		modelo2.removeRow(0);
   		
   		AccesoBD objA = new AccesoBD();
   		objA.crearConexion();
   		
   		String sql="select repsol.cod_sol,CLI.COD_CLI,cli.NOM_CLI,ven.cod_ven,ven.nom_ven, "+
                      "repsol.ruta_sol,repsol.ref_sol,repsol.fec_sol,repsol.est_llamada,repsol.est_envio_mail,repsol.est_envio_mail2,repsol.idArchivo "+
                      "from tb_reportesolprove repsol inner join tb_cliente cli "+
                      "on repsol.cod_cli = CLI.COD_CLI inner join tb_vendedores ven "+
                      "on repsol.cod_ven = ven.cod_ven " +
                      "where cli.NOM_CLI like '"+txtCliente.getText().trim()+"%';";

   		ResultSet rs=objA.ejecutarConsulta(sql);
   		try {
   			
   			while(rs.next()){
   			BeanRepSolProve objR= new BeanRepSolProve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
   					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
   					rs.getString(10),rs.getString(11));
   			objRepSol.adicionar(objR);
   			
   			}
   			rs.close();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		objA.cerrarConexion();
   		
   		for (int i = 0; i < objRepSol.tamaño(); i++) {
   			
   			
   			Object[] obj={objRepSol.obtener(i).getCod_sol(),objRepSol.obtener(i).getRef_sol(),
   					objRepSol.obtener(i).getNom_cli(),objRepSol.obtener(i).getNom_ven(),
   					objRepSol.obtener(i).getFec_sol()
   			};
   			modelo2.addRow(obj);
   			
   		}
   	}
       
       public void buscarRepSolProveFecha(){
      		
    	    String fec=objFecha.convrtidorFec(btnFecha2.getDate());
      		objRepSol.eliminarTodo();
      		int n=modelo2.getRowCount();
      		
      		for (int fila=0; fila<n; fila++)
      		modelo2.removeRow(0);
      		
      		AccesoBD objA = new AccesoBD();
      		objA.crearConexion();
      		
      		String sql="select repsol.cod_sol,CLI.COD_CLI,cli.NOM_CLI,ven.cod_ven,ven.nom_ven, "+
                         "repsol.ruta_sol,repsol.ref_sol,repsol.fec_sol,repsol.est_llamada,repsol.est_envio_mail,repsol.idArchivo "+
                         "from tb_reportesolprove repsol inner join tb_cliente cli "+
                         "on repsol.cod_cli = CLI.COD_CLI inner join tb_vendedores ven "+
                         "on repsol.cod_ven = ven.cod_ven " +
                         "where repsol.fec_sol='"+fec+"';";

      		ResultSet rs=objA.ejecutarConsulta(sql);
      		try {
      			
      			while(rs.next()){
      			BeanRepSolProve objR= new BeanRepSolProve(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
      					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
      					rs.getString(10),rs.getString(11));
      			objRepSol.adicionar(objR);
      			
      			}
      			rs.close();
      		} catch (SQLException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      		}
      		objA.cerrarConexion();
      		
      		for (int i = 0; i < objRepSol.tamaño(); i++) {
      			
      			
      			Object[] obj={objRepSol.obtener(i).getCod_sol(),objRepSol.obtener(i).getRef_sol(),
      					objRepSol.obtener(i).getNom_cli(),objRepSol.obtener(i).getNom_ven(),
      					objRepSol.obtener(i).getFec_sol()
      			};
      			modelo2.addRow(obj);
      			
      		}
      	}
       
    public void cargarRepSol(){
    	   
   		int fila = tblSolicitud.getSelectedRow();
   		txtCliente.setText(objRepSol.obtener(fila).getNom_cli());
   		txtReferencia.setText(objRepSol.obtener(fila).getRef_sol());
   		txtRuta.setText("\\\\192.168.0.20\\d\\ProyectoCEL\\SOLICITUD_PROVEEDORES\\"+
   				objRepSol.obtener(fila).getRef_sol()+".XLS");
   		//System.out.println("RUTA:"+objRepSol.obtener(fila).getRuta_sol());
   		
   	}
       
    public void cargarSolProve(){
    	   
      		int fila = tblSolProve.getSelectedRow();
      		txtProveedor.setText(objSolProve.obtener(fila).getNom_prove());
      		txtPersonal.setText(objSolProve.obtener(fila).getPer_prove());
      		txtTelefono1.setText(objSolProve.obtener(fila).getTel1_prove());
      		txtTelefono2.setText(objSolProve.obtener(fila).getTel2_prove());
      		txtCelular.setText(objSolProve.obtener(fila).getCel_prove());
      		txtFax.setText(objSolProve.obtener(fila).getFax_prove());
      		txtRpm.setText(objSolProve.obtener(fila).getRpm_prove());
      		txtNextel.setText(objSolProve.obtener(fila).getNex_prove());
      		txtCorreo.setText(objSolProve.obtener(fila).getMail_prove());
    }
     public void crearExcelTarea(String idArchivo)throws IOException{
    	
    	 	Propiedades p=new Propiedades();
			String nombre=buscarNombreArchivo(idArchivo);
			
			//System.out.println("Nombre: "+nombre);
			String ruta=(p.getProperty("rutaExcelSolicitudProveedor")).trim();
			String file = ruta+nombre;
			System.out.println(""+file);
	       	rutaExcelSolicitud=file; 
			//System.out.println("idArchivo: "+idArchivo+"       FILE: "+file);
			
			boolean devuelve=obtenerArchivo(idArchivo,file);
			
			if(devuelve){
				try {
					SwingProgressBar obj= new SwingProgressBar(objMenu);
					obj.setTitle("Descarga de Archivo");
					obj.setVisible(true);
					obj.pack();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "El documento está abierto");
			}			
       	      	  
     }
     
     public static void abrirExcel(){
    	 
    	Propiedades p=new Propiedades();
    	try {
    		System.out.println("RUTA: "+p.getProperty("rutaExcel")+" "+rutaExcelSolicitud);
			Runtime.getRuntime().exec(p.getProperty("rutaExcel")+" "+rutaExcelSolicitud);
    		//Runtime.getRuntime().exec("//192.168.0.20/d/ProyectoCEL/SOLICITUD_PROVEEDORES/");
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    
     public void modificarEstRep(int valor,String cod_solprove){
		
		AccesoBD objAccesoBD=  new AccesoBD();
	    objAccesoBD.crearConexion();
		
		String sql="update tb_solprove " +
	    " SET EST_LLAMADA='"+valor+"'" +
		" WHERE COD_SOLPROVE='"+cod_solprove+"'; ";

		System.out.println(sql);
	
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
		}else{
			System.out.println("Se modifico el estado del reporte");
			
		}
	    objAccesoBD.cerrarConexion();	
	
   }
   /************************************************************************************************************/
     public void modificarEstSol(int valor,String cod_sol){
 		
 		AccesoBD objAccesoBD=  new AccesoBD();
 	    objAccesoBD.crearConexion();
 		
 		String sql="update tb_reportesolprove " +
 	    " SET EST_LLAMADA='"+valor+"'" +
 		" WHERE COD_SOL='"+cod_sol+"'; ";

 		System.out.println(sql);
 	
 		int op=objAccesoBD.ejecutarActualizacion(sql);
 		if(op==0){
 			objGUI.mostrarAviso("Debe Selecionar una Solicitud");
 		}else{
 			System.out.println("Se modifico el estado de la solicitud");
 			
 		}
 	    objAccesoBD.cerrarConexion();	
     }
   /************************************************************************************************************/
     
     public void listarRepSolAExcel(){
    		
    		objExcelRepSol.eliminarTodo();
    		int n=modelo2.getRowCount();
    		for (int fila=0; fila<n; fila++)
    		modelo2.removeRow(0);
    		AccesoBD objA = new AccesoBD();
    		objA.crearConexion();
    			
    		String sql="Select prove.NOM_PROVE,prove.TEL1_PROVE,prove.TEL2_PROVE,prove.PER_PROVE, "+
					   "repsol.fec_sol,repsol.ref_sol,cli.NOM_CLI,sol.est_llamada,ven.nom_ven "+
					   "from tb_reportesolprove repsol "+
					   "inner join tb_cliente cli "+
					   "on repsol.cod_cli = CLI.COD_CLI "+
					   "inner join tb_vendedores ven "+
					   "on repsol.cod_ven = ven.cod_ven "+
					   "inner join tb_solprove sol "+
					   "on sol.cod_sol = repsol.cod_sol "+
					   "inner join tb_proveedor prove "+
					   "on sol.cod_prove = prove.COD_PROVE "+
					   "where (sol.est_llamada=0 or sol.est_llamada=2) and fec_sol=curdate() ;";
    		ResultSet rs=objA.ejecutarConsulta(sql);
    		try {
    			
    			while(rs.next()){
    			BeanExcelRepSol objRep= new BeanExcelRepSol(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
    					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
    			objExcelRepSol.adicionar(objRep);
    			
    			}
    			rs.close();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		objA.cerrarConexion();
    	}
     
     
     public boolean pasarExcelRepSol(int cant) throws FileNotFoundException, IOException{
			
		 boolean devuelve=true;
		 BeanExcelRepSol objRep;
		 String fec=objFecha.convrtidorFec2(btnFecha2.getDate());
		 int tam=objExcelRepSol.tamaño();
		 int item=-1;
		 if(tam>0){
			 for (int i = 0; i < objExcelRepSol.tamaño(); i++) {
			 
				 objRep=objExcelRepSol.obtener(i);
				
				 arregloCadenasRepSol[0]="Reportes Pendientes del dia: "+fec;
				
				 item=item+1;
		
				 for (int j = 0; j < 7; j++) {
			                
						    if(j==0){
							arregloObjetosRepSol[item][j]=objRep.getNom_prove().toString().toUpperCase();	
							}else if(j==1){
							arregloObjetosRepSol[item][j]=objRep.getTelf1_prove().toString()+" / "+
							objRep.getTelf2_prove().toString();		
							}else if(j==2){
							arregloObjetosRepSol[item][j]=objRep.getPer_prove().toString().toUpperCase();	
							}else if(j==3){
							arregloObjetosRepSol[item][j]=objRep.getFecha();	
							}else if(j==4){
							arregloObjetosRepSol[item][j]=objRep.getReferencia().toString().toUpperCase();			
							}else if(j==5){
							arregloObjetosRepSol[item][j]=objRep.getNom_cliente().toString().toUpperCase();				
							}else {
							arregloObjetosRepSol[item][j]="";	
							}
			
				}
			}
		}
		
		return devuelve;		
	 } 
     
    public void generarexcel(){
    
    	listarRepSolAExcel();
		
		if(objExcelRepSol.tamaño()!=0){
		boolean valor=true;
		int tam=objExcelRepSol.tamaño();//ESTE ES EL TAMAÑO REAL
		String fec=objFecha.convrtidorFec2(btnFecha1.getDate());
		boolean devuelve = false;
		arregloCadenasRepSol= new Object[1];
		arregloObjetosRepSol= new Object[tam][7];
	
		try {
			listarRepSolProve();
    		objSolProve.eliminarTodo();
       		int n=modelo3.getRowCount();
       		
       		for (int fila=0; fila<n; fila++)
       		modelo3.removeRow(0);
       		txtCliente.setText("");
       		limpiar();
       		
			devuelve=pasarExcelRepSol(tam);
			objPasarRepSol= new PasarReporteSolProve();
			objPasarRepSol.crearExcelTarea(arregloCadenasRepSol,arregloObjetosRepSol,fec);
			//rutaGlobal=objPasarTareaExcelCorreo.fileGlobal;
			valor=true;
		} catch (FileNotFoundException e1) {
			valor=false;
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
			valor=false;
		}finally{
			if(!valor){
				objGUI.mostrarAviso("No se pudo abrir el Archivo");
				
			}
		}
		if(devuelve){
		}
		else{
			objGUI.mostrarAviso("Hubo un error al pasar al excel!");
		}
	 }else{
		 
		 objGUI.mostrarAviso("No existen Tareas para esa fecha");
		 listarRepSolProve();
		 txtCliente.setText("");
		 limpiar();
		
	 }
		
  }
    	
  
   /************************************************************************************************************/
    public void agregarReporte(){
		
    	//System.out.println("CODIGO_CLIENTE:"+cod_cli);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		String fecrep=objFecha.fechaActual();
		
			 String insertarPregunta="INSERT INTO tb_reportesolprove (COD_CLI,COD_VEN, RUTA_SOL,REF_SOL, FEC_SOL,EST_LLAMADA, EST_ENVIO_MAIL,EST_ENVIO_MAIL2) " +
		    		" VALUES('"+codcli+"','"+codven+"','','"+txtReferencia.getText().trim()+"','"+fecrep+"','0','0','0');";
			//System.out.println(insertarPregunta);
			String aumentoBackSlash=insertarPregunta.replace("\\", "\\\\");
			System.out.println("Ahora como se ve:"+aumentoBackSlash);
			int op= objAccesoBD.ejecutarActualizacion(aumentoBackSlash);
			//int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			
			
				if(op==0){
				  objGUI.mostrarAviso("Hubo un ERROR al Ingresar los datos");
				  System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			    }	
			      else{
				  objGUI.mostrarAviso("Se ingreso Correctamente ");
				  System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
				  
			   }
			   objAccesoBD.cerrarConexion();
	}
    /***********************************************************************************************************************************************/
    public String buscarNombreArchivo(String cod){
    	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		String nom="";
		
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT a.Nombre "+
				   "FROM bd_cel.tb_archivos a "+
				   "inner join bd_cel.tb_reportesolprove r " +
				   "on a.idArchivo=r.idArchivo "+
				   "where r.idArchivo='"+cod+"';";
		System.out.println(sql);
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			if(rs.next()){
				String nombre=rs.getString(1).toString();	
				nom=nombre;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		
		return nom;
    }
	/***********************************************************************************************************************************************/
    
    public boolean obtenerArchivo(String idArchivo, String nombreArchivoSalida) {
    	
        InputStream salida = null;           
        AccesoBD objAccesoBD = new AccesoBD();
        
        try {        	
            
        	PreparedStatement pst;
            ResultSet rs;
            Blob blob;
            FileOutputStream archivoSalida;
            String select;

            byte[] arreglo;
            int byteLeidos = 0;
            
            objAccesoBD.crearConexion();
            objAccesoBD.getCon().setAutoCommit(false);
            
            select = "select ARCHIVO from tb_archivos WHERE idArchivo=?";            
            pst = (PreparedStatement) objAccesoBD.getCon().prepareStatement(select);
            pst.setString(1, idArchivo);

            rs = pst.executeQuery();

            if (rs != null) {
                rs.next();
                blob = rs.getBlob(1);
                salida = blob.getBinaryStream();

                arreglo = new byte[2048];

                archivoSalida = new FileOutputStream(nombreArchivoSalida);

                while ((byteLeidos = salida.read(arreglo)) > 0) {
                    archivoSalida.write(arreglo, 0, byteLeidos);
                }
                archivoSalida.close();
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            Logger.getLogger(ReporteSolProve.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ReporteSolProve.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ReporteSolProve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
  /*******************************************************************************************************************/
    public void limpiar(){
    	
    	
    	txtReferencia.setText("");
    	txtProveedor.setText("");
    	txtPersonal.setText("");
    	txtTelefono1.setText("");
    	txtTelefono2.setText("");
    	txtCelular.setText("");
    	txtFax.setText("");
    	txtRpm.setText("");
    	txtNextel.setText("");
    	txtCorreo.setText("");
    	
    	objSolProve.eliminarTodo();
   		int n=modelo3.getRowCount();
   		
   		for (int fila=0; fila<n; fila++)
   		modelo3.removeRow(0);
    	
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		
    	if(e.getSource()==btnListar){
    		
    		listarRepSolProve();
       		txtCliente.setText("");
       		limpiar();
    	}
    	
    	
    	if(e.getSource()==btnSolicitud){
    		
    		int fila = tblSolicitud.getSelectedRow();
    		if(fila==-1){
    			objGUI.mostrarAviso("Debe Seleccionar una Solicitud");
    		}else{
    			try {
				crearExcelTarea(""+objRepSol.obtener(fila).getIdArchivo());
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	}
    	if(e.getSource()==btnBuscar){
    		buscarRepSolProveFecha();
    				
    	}
    	
    	if(e.getSource()==btnRepProve){
    		
    		listarRepSolAExcel();
    		
			if(objExcelRepSol.tamaño()!=0){
			boolean valor=true;
			int tam=objExcelRepSol.tamaño();//ESTE ES EL TAMAÑO REAL
			String fec=objFecha.convrtidorFec2(btnFecha1.getDate());
			boolean devuelve = false;
			arregloCadenasRepSol= new Object[1];
			arregloObjetosRepSol= new Object[tam][7];
		
			try {
				listarRepSolProve();
	       		txtCliente.setText("");
	       		limpiar();
	       		
				devuelve=pasarExcelRepSol(tam);
				objPasarRepSol= new PasarReporteSolProve();
				objPasarRepSol.crearExcelTarea(arregloCadenasRepSol,arregloObjetosRepSol,fec);
				//rutaGlobal=objPasarTareaExcelCorreo.fileGlobal;
				valor=true;
			} catch (FileNotFoundException e1) {
				valor=false;
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
				valor=false;
			}finally{
				if(!valor){
					objGUI.mostrarAviso("Debe cerrar el Excel Anterior!");
					
				}
			}
			if(devuelve){
			}
			else{
				objGUI.mostrarAviso("Hubo un error al pasar al excel!");
			}
		 }else{
			 
			 objGUI.mostrarAviso("No existen Reportes para hoy dia");
			 listarRepSolProve();
			 txtCliente.setText("");
			 limpiar();
			
		 }
    		
    	}
    	if(e.getSource()==btnRecibimos){
    		
    		int fila = tblSolicitud.getSelectedRow();
    		
    		if(fila==-1){
    			objGUI.mostrarAviso("Debe Seleccionar una Solicitud");
    		}else{
    			BeanRepSolProve objSol=objRepSol.obtener(fila);
        		modificarEstSol(3, objSol.getCod_sol());
    		}
    		
    	}
    	if(e.getSource()==btnCliente){
    		
    		objBuscarCli= new BuscarCliCita();
    		String[] botones = {"Aceptar"};//Esto es el nombre
	         int showOptionDialog = JOptionPane.showOptionDialog(
	     		   this,                             			
	     		   objBuscarCli,                                    
	     		   "Buscar Cliente", 		
	     		   0,          						        
	     		   -1,            					
	     		   null,                                       
	     		   botones,
	     		   "Cerrar"
	     		                                  	
	     	);
	         if(showOptionDialog==0){
	        	//Aca entra al boton Aceptar
	        	 valor=1;
	        	 codcli=objBuscarCli.codcli;
	        	 nomcli=objBuscarCli.nomcli;
	        	 txtCliente.setText(nomcli);
	        	 
	        	 //System.out.println("ACEPTAR");
	         }
	         
    	}
    	if(e.getSource()==btnAgregar){
    		if(valor==0){
    			objGUI.mostrarAviso("Debe cargar los datos del cliente");
				///System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
    		}else{
    			agregarReporte();
    			listarRepSolProve();
           		txtCliente.setText("");
           		limpiar();
           		valor=0;
    		}
    		
    	}
    }

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if(arg0.getSource()==txtCliente){
			buscarRepSolProve();
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
		
		if(e.getSource()== tblSolicitud){
			
			MouseEvent evento=e;
			if(evento.getClickCount()==1){
				
				 int fila = tblSolicitud.getSelectedRow();
	 			 codsol=""+modelo2.getValueAt(fila,0);
	 			 listarSolProve(codsol);
	 			 cargarRepSol();
	 			 
	 			 if(tblSolicitud.getSelectedColumn()==5){
                   BeanRepSolProve objSol=objRepSol.obtener(fila);
					
					String[] botones = {"Si","No"};//Esto es el nombre
			         int showOptionDialog = JOptionPane.showOptionDialog(
			     		   this,                             			
			     		   objLlamada,                                    
			     		   "Contesto Llamada", 		
			     		   0,          						        
			     		   -1,            					
			     		   null,                                       
			     		   botones,
			     		   "Cerrar"
			     		                                  	
			     	);
			         if(showOptionDialog==0){
			        	//Aca entra al boton SI
			        	 objSol.setEst_llamada("1");
			             modificarEstSol(1, objSol.getCod_sol());
			             listarRepSolProve();
			        	 
			         }
			         else if(showOptionDialog==1){
			        	 //Aca entra al boton NO
			        	 objSol.setEst_llamada("2");
			        	 modificarEstSol(2, objSol.getCod_sol());
			        	 listarRepSolProve();
			         }else{
			        	 //CERRAR
			         }
	 				 
	 			 }
			}
			
		}
		
        if(e.getSource()== tblSolProve){
        	
        	MouseEvent evento=e;
			if(evento.getClickCount()==1){
				cargarSolProve();
				
                if(tblSolProve.getSelectedColumn()==3){
					
					
					int fila = tblSolProve.getSelectedRow();
					BeanSolProve objSol=objSolProve.obtener(fila);
					
					String[] botones = {"Si","No","No Prod"};//Esto es el nombre
			         int showOptionDialog = JOptionPane.showOptionDialog(
			     		   this,                             			
			     		   objLlamada,                                    
			     		   "Contesto Llamada", 		
			     		   0,          						        
			     		   -1,            					
			     		   null,                                       
			     		   botones,
			     		   "Cerrar"
			     		                                  	
			     	);
			         if(showOptionDialog==0){
			        	//Aca entra al boton SI
			        	 objSol.setEst_llamada("1");
			             modificarEstRep(1, objSol.getCod_solprove());
			             listarSolProve(codsol);
			        	 
			         }
			         else if(showOptionDialog==1){
			        	 //Aca entra al boton NO
			        	 objSol.setEst_llamada("2");
			        	 modificarEstRep(2, objSol.getCod_solprove());
			        	 listarSolProve(codsol);
			         }else if(showOptionDialog==2){
			        	 //Aca entra al boton No Prod
			        	 objSol.setEst_llamada("3");
			        	 modificarEstRep(3, objSol.getCod_solprove());
			        	 listarSolProve(codsol);
			         }else{
			        	 //Cuando se cierra la ventana
			         }
			         
					
				 }
			}
			
			if(evento.getClickCount()==2){
				
                int fila = tblSolProve.getSelectedRow();
				
				codproverubro=Integer.parseInt(""+modelo3.getValueAt(fila,0));
				nomprove=""+modelo3.getValueAt(fila,1);
				BuscarRubroProveSol objProRub= new BuscarRubroProveSol(objMenu);
				
				objProRub.setTitle("Proveedor Rubro Marca");
				objProRub.setVisible(true);
				objProRub.pack();
				
				
			}
			
		}
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/******************************************************************************************************************
	 ******************************************************************************************************************/
	
	class RemindTask extends TimerTask {
    	 
		public void run(){
			segundos++;
			System.out.println(segundos);
			
			//pbSolicitud.setValue(segundos);
			
			if(frozen==false && segundos==5){
				abrirExcel();	
				stop();
			}
			
							
		}
	
	}
	 
	public void start(int pSeg) throws Exception {
		timer = new Timer();
		frozen = false;
		// le asignamos una tarea al timer
		timer.schedule(new RemindTask(), 0, pSeg * 1000);
		System.out.println("START");
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
}
