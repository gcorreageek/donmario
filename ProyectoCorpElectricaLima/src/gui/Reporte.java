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
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.Fecha;
import miLib.GUI;
import miLib.PasarReporteExcelCorreo;
import miLib.PasarTareaExcelCorreo;
import miLib.Tiempo;
import pOp.BuscarCliCita;
import pOp.BuscarCotizacionTarea;
import servlet.ServletCliCita;
import servlet.ServletReporte;
import servlet.ServletReporteExcel;
import servlet.ServletTareaExcel;
import beans.BeanReporte;
import beans.BeanReporteAExcel;
import beans.BeanTareaAExcel;
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
public class Reporte extends JInternalFrame implements ActionListener, MouseListener, KeyListener{
	private JPanel pnlPrincipal;
	private JLabel lblDep;
	private JPanel pnlListaReporte;
	private JComboBox cboTipo;
	private JButton btnNo;
	private JButton btnSi;
	private JRadioButton rbdOculto;
	private JLabel lblLlamo;
	private JComboBox cboSexo;
	private JLabel lblSexo;
	private JComboBox cboDistrito;
	private JComboBox cboProvincia;
	private JComboBox cboDepartamento;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnTarea;
	private JButton btnReporte;
	private JTextPane txtAObs;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JScrollPane scpObs;
	private JButton btnListar;
	private JTable tblReporte;
	private JScrollPane jScrollPane1;
	private JPanel pnlCentro;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;
	private JComboBox cboTipoCom;
	private JComboBox cboCalif;
	private JLabel lblObs;
	private JLabel lblTipoCom;
	private JLabel lblFechaCita;
	private JLabel lblCalificacion;
	private JLabel lblFActual;
	private JTextField txtEmail2;
	private JTextField txtFax2;
	private JTextField txtNextel2;
	private JTextField txtRpm2;
	private JTextField txtCel2;
	private JTextField txtTel21;
	private JTextField txtTel2;
	private JTextField txtContacto2;
	private JLabel lblEmail2;
	private JLabel lblFax2;
	private JLabel lblNextel2;
	private JLabel lblRpm2;
	private JLabel lblTel21;
	private JLabel lblCel2;
	private JLabel lblTel2;
	private JLabel lblContacto2;
	private JLabel jLabel2;
	private JPanel pnlCita2;
	private JTextField txtEmail1;
	private JTextField txtFax1;
	private JTextField txtNextel1;
	private JTextField txtRpm1;
	private JTextField txtCel1;
	private JTextField txtTel11;
	private JTextField txtTel1;
	private JTextField txtContacto1;
	private JLabel lblTel11;
	private JLabel lblNextel1;
	private JLabel lblRpm1;
	private JLabel lblEmail1;
	private JLabel lblFax1;
	private JLabel lblCel1;
	private JLabel lblTel1;
	private JLabel lblContacto1;
	private JPanel pnlCita1;
	private JButton btnBuscarCli;
	private JTextField txtDireccion;
	private JTextField txtCliente;
	private JLabel lblDis;
	private JLabel lblProv;
	private JLabel lblDireccion;
	private JLabel lblTipo;
	private JLabel lblCliente;
	private DateButton btnFecha1;
	private DateButton btnFecha2;
	ServletReporte objS= new ServletReporte();
	ServletReporteExcel objSExcel =new ServletReporteExcel();
	ServletTareaExcel objSTarea =new ServletTareaExcel();
	ServletCliCita objR= new ServletCliCita();
	BuscarCliCita objBuscarCliCita;
	BuscarCotizacionTarea objBuscarCotTarea;
	TranCotizacionAutMant objTranCoti;
	MenuPrincipal objMenu;
	public static JDesktopPane jDesktopPane1;
	Globales objGlo; 
	Tiempo objTime;
	int array,contaRep,press;
	String codcli, nomcli,tipcli,sexo,dircli,lugcli,depcli,provcli,discli,conacli,tel1acli,
	tel2acli,faxacli,rpmacli,nexacli,celacli,mailacli,conbcli,tel1bcli,rpmbcli,nexbcli,
	 celbcli,mailbcli;
	
	String codrep,nomclirep,nomven,fecrep,feccrep,tipcomrep,calrep,obsrep,estrep;
	
	String titulo2[]={"COD.REPORTE","NOM.CLIENTE","NOM.VENDEDOR","FECHA DEL DIA"
			,"FECHA DE LA CITA","T.COMUNICACION","CALIFICAION","OBS","LLAMADA"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 GUI objGUI;
	 Fecha objFecha;
	 int valor=0,cod_rep,conta,contFechas;
	 
	Object[] arregloCadenas;
	Object[]arregloCadenasTarea;
	Object[][] arregloObjetos;
	Object[][] arregloObjetosTarea;
	PasarReporteExcelCorreo objPasarRepExcelCorreo;
	PasarTareaExcelCorreo objPasarTareaExcelCorreo;
	public static String rutaGlobal,nombrecliente,codigocliente;
	String fechaReporte,fechaTarea,tiemp_rep;
	int verificar;
	public static int entrada;
	
	/**************************************************************************************************
	**************************************************************************************************/
	
	public  Reporte() {
		super("Tarea", true, true, true, true);
		try {
			System.out.println("El ven cod:"+objGlo.COD_VEN);
				this.setPreferredSize(new java.awt.Dimension(1020, 608));
				this.setBounds(0, 0, 1020, 608);
				BorderLayout thisLayout = new BorderLayout();
				getContentPane().setLayout(thisLayout);

				pnlAbajo = new JPanel();
				getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
				pnlAbajo.setPreferredSize(new java.awt.Dimension(1002, 40));

				btnListar = new JButton();
				pnlAbajo.add(btnListar);
				btnListar.setText("Listar");
				btnListar.setPreferredSize(new java.awt.Dimension(98, 21));
				{
					btnBuscar = new JButton();
					pnlAbajo.add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setPreferredSize(new java.awt.Dimension(79, 21));
					btnBuscar.addActionListener(this);
				}
				btnListar.addActionListener(this);

				{
					btnReporte = new JButton();
					pnlAbajo.add(btnReporte);
					btnReporte.setText("Rep.del Dia");
					btnReporte.setPreferredSize(new java.awt.Dimension(105, 21));
					btnReporte.addActionListener(this);
				}
				{
					btnTarea = new JButton();
					pnlAbajo.add(btnTarea);
					btnTarea.setText("Tarea");
					btnTarea.setPreferredSize(new java.awt.Dimension(83, 21));
					btnTarea.addActionListener(this);
				}

				pnlCentro = new JPanel();
				GridLayout pnlCentroLayout = new GridLayout(1, 1);
				pnlCentroLayout.setHgap(5);
				pnlCentroLayout.setVgap(5);
				pnlCentroLayout.setColumns(1);
				pnlCentro.setLayout(pnlCentroLayout);
				getContentPane().add(pnlCentro, BorderLayout.CENTER);
				pnlCentro.setBorder(BorderFactory.createTitledBorder("Lista de Reportes"));
				pnlCentro.setPreferredSize(new java.awt.Dimension(1012, 153));
				{
					jScrollPane1 = new JScrollPane();
					pnlCentro.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(1002, 158));
					{
						tblReporte = new JTable();
						jScrollPane1.setViewportView(tblReporte);
						tblReporte.setModel(modelo2);
						tblReporte.addKeyListener(this);
						tblReporte.addMouseListener(this);
					}
				}
				
				pnlArriba = new JPanel();
				getContentPane().add(pnlArriba, BorderLayout.NORTH);

				pnlPrincipal = new JPanel();
				pnlArriba.add(pnlPrincipal);

				lblCliente = new JLabel();

				lblTipo = new JLabel();

				lblDireccion = new JLabel();

				lblDep = new JLabel();

				lblProv = new JLabel();

				lblDis = new JLabel();

				txtCliente = new JTextField();

				txtDireccion = new JTextField();

				txtDireccion.setBounds(496, 14, 342, 21);

				txtCliente.setBounds(83, 14, 349, 21);

				lblDis.setText("Distrito");
				lblDis.setBounds(805, 44, 47, 14);

				lblProv.setText("Provincia");
				lblProv.setBounds(584, 43, 60, 14);

				lblDep.setText("Departamento");
				lblDep.setBounds(359, 42, 104, 14);

				lblDireccion.setText("Direccion");
				lblDireccion.setBounds(439, 17, 72, 14);

				lblTipo.setText("Tipo Cliente");
				lblTipo.setBounds(9, 44, 91, 14);

				pnlPrincipal.add(lblCliente);
				pnlPrincipal.add(lblTipo);
				pnlPrincipal.add(lblDireccion);
				pnlPrincipal.add(lblDep);
				pnlPrincipal.add(lblProv);
				pnlPrincipal.add(lblDis);
				pnlPrincipal.add(txtCliente);
				pnlPrincipal.add(txtDireccion);

				btnBuscarCli = new JButton();
				pnlPrincipal.add(btnBuscarCli);
				btnBuscarCli.setText("Buscar Cliente");
				btnBuscarCli.setBounds(851, 14, 123, 21);
				
				cboDepartamento = new JComboBox();
				pnlPrincipal.add(cboDepartamento);
				cboDepartamento.addItem("DEPARTAMENTO");
				cboDepartamento.setBounds(445, 41, 120, 21);	
				cboDepartamento.addActionListener(this);    	
					 
				cboProvincia = new JComboBox();
				pnlPrincipal.add(cboProvincia);
				cboProvincia.setBounds(648, 41, 132, 21);
				cboProvincia.addItem("PROVINCIA");
				cboProvincia.addActionListener(this);
						
				cboDistrito = new JComboBox();
				pnlPrincipal.add(cboDistrito);
				cboDistrito.setBounds(852, 41, 123, 21);
				cboDistrito.addItem("DISTRITO");
				cboDistrito.addActionListener(this);
				
					lblSexo = new JLabel();
					pnlPrincipal.add(lblSexo);
					lblSexo.setText("Sexo");
					lblSexo.setBounds(215, 44, 36, 14);
				
				
					
					cboSexo = new JComboBox();
					pnlPrincipal.add(cboSexo);
					cboSexo.setBounds(244, 40, 86, 21);

					cboTipo = new JComboBox();
					pnlPrincipal.add(cboTipo);
					cboTipo.setBounds(83, 40, 109, 25);
					cboTipo.setSize(109, 21);

					cboSexo.addItem("Sexo");
					cboSexo.addItem("Masculino");
					cboSexo.addItem("Femenino");
					cboSexo.addActionListener(this);

				btnBuscarCli.addActionListener(this);

				lblCliente.setText("Nombre");
				lblCliente.setBounds(32, 17, 79, 14);

				pnlPrincipal.setLayout(null);
				pnlPrincipal.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
				pnlPrincipal.setBounds(10, 4, 989, 69);

				pnlCita1 = new JPanel();
				pnlArriba.add(pnlCita1);

				lblContacto1 = new JLabel();

				lblTel1 = new JLabel();

				lblCel1 = new JLabel();

				lblFax1 = new JLabel();

				lblEmail1 = new JLabel();

				lblRpm1 = new JLabel();

				lblNextel1 = new JLabel();

				lblTel11 = new JLabel();

				txtContacto1 = new JTextField();

				txtTel1 = new JTextField();

				txtTel11 = new JTextField();

				txtCel1 = new JTextField();

				txtRpm1 = new JTextField();

				txtNextel1 = new JTextField();

				txtFax1 = new JTextField();
				txtFax1.setBounds(294, 102, 100, 21);

				txtNextel1.setBounds(67, 104, 93, 21);
				txtNextel1.setSize(100, 21);

				txtRpm1.setBounds(295, 75, 100, 21);

				txtCel1.setBounds(67, 77, 96, 21);
				txtCel1.setSize(100, 21);

				txtTel11.setBounds(296, 49, 100, 21);

				txtTel1.setBounds(67, 49, 98, 21);
				txtTel1.setSize(100, 21);

				txtContacto1.setBounds(67, 22, 329, 21);

				lblTel11.setText("Telefono2");
				lblTel11.setBounds(240, 52, 70, 14);

				lblNextel1.setText("Nextel");
				lblNextel1.setBounds(28, 107, 62, 14);

				lblRpm1.setText("Rpm");
				lblRpm1.setBounds(268, 78, 41, 14);

				lblEmail1.setText("Email");
				lblEmail1.setBounds(33, 133, 57, 14);

				lblFax1.setText("Fax");
				lblFax1.setBounds(271, 104, 41, 14);

				lblCel1.setText("Celular");
				lblCel1.setBounds(27, 80, 67, 14);

				lblTel1.setText("Telefono");
				lblTel1.setBounds(17, 52, 74, 14);

				pnlCita1.add(lblContacto1);
				pnlCita1.add(lblTel1);
				pnlCita1.add(lblCel1);
				pnlCita1.add(lblFax1);
				pnlCita1.add(lblEmail1);
				pnlCita1.add(lblRpm1);
				pnlCita1.add(lblNextel1);
				pnlCita1.add(lblTel11);
				pnlCita1.add(txtContacto1);
				pnlCita1.add(txtTel1);
				pnlCita1.add(txtTel11);
				pnlCita1.add(txtCel1);
				pnlCita1.add(txtRpm1);
				pnlCita1.add(txtNextel1);
				pnlCita1.add(txtFax1);

				txtEmail1 = new JTextField();
				pnlCita1.add(txtEmail1);
				txtEmail1.setBounds(67, 130, 326, 21);

				lblContacto1.setText("Contanto");
				lblContacto1.setBounds(15, 25, 76, 14);

				pnlCita1.setBorder(BorderFactory.createTitledBorder("Datos del Contacto1"));
				pnlCita1.setLayout(null);
				pnlCita1.setBounds(12, 73, 478, 160);

				pnlCita2 = new JPanel();
				pnlArriba.add(pnlCita2);
				pnlCita2.setBorder(BorderFactory.createTitledBorder("Datos del Contacto2"));
				pnlCita2.setLayout(null);
				pnlCita2.setBounds(496, 73, 503, 161);

				pnlListaReporte = new JPanel();
				pnlArriba.add(pnlListaReporte);
				pnlListaReporte.setBorder(BorderFactory.createTitledBorder("Datos de la Cita"));
				pnlListaReporte.setLayout(null);
				pnlListaReporte.setBounds(12, 231, 987, 127);

				lblFActual = new JLabel();
				pnlListaReporte.add(lblFActual);
				lblFActual.setText("Fecha Actual");
				lblFActual.setBounds(17, 24, 90, 14);

				lblCalificacion = new JLabel();
				pnlListaReporte.add(lblCalificacion);
				lblCalificacion.setText("Calificacion");
				lblCalificacion.setBounds(527, 53, 87, 14);

				lblFechaCita = new JLabel();
				pnlListaReporte.add(lblFechaCita);
				lblFechaCita.setText("Fecha de Cita");
				lblFechaCita.setBounds(222, 24, 94, 14);

				lblTipoCom = new JLabel();
				pnlListaReporte.add(lblTipoCom);
				lblTipoCom.setText("Tipo de Comunicacion");
				lblTipoCom.setBounds(466, 24, 134, 14);

				lblObs = new JLabel();
				pnlListaReporte.add(lblObs);
				lblObs.setText("Obs");
				lblObs.setBounds(68, 48, 48, 14);

				btnFecha1 = new DateButton();
				pnlListaReporte.add(btnFecha1);
				btnFecha1.setFont(new Font("dialog",0,12));
				btnFecha1.setBounds(95, 20, 118, 22);
				btnFecha1.setEnabled(false);

				btnFecha2 = new DateButton();
				pnlListaReporte.add(btnFecha2);
				btnFecha2.setFont(new Font("dialog",0,12));
				btnFecha2.setBounds(302, 20, 135, 22);

				cboCalif = new JComboBox();
				pnlListaReporte.add(cboCalif);
				cboCalif.addItem("Caliente");
				cboCalif.addItem("Tibio");
				cboCalif.addItem("Frio");
				cboCalif.addItem("Otros");
				cboCalif.setBounds(596, 50, 106, 21);

				cboTipoCom = new JComboBox();
				pnlListaReporte.add(cboTipoCom);
				cboTipoCom.addItem("LL");
				cboTipoCom.addItem("NLL");
				cboTipoCom.addItem("NV");
				cboTipoCom.addItem("@");
				cboTipoCom.addItem("O/C");
				cboTipoCom.setBounds(596, 21, 106, 21);

				scpObs = new JScrollPane();
				pnlListaReporte.add(scpObs);
				scpObs.setBounds(95, 49, 341, 69);
				scpObs.setSize(342, 69);
				{
					btnAgregar = new JButton();
					pnlListaReporte.add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(785, 21, 93, 21);
					btnAgregar.addActionListener(this);
				}
				{
					btnModificar = new JButton();
					pnlListaReporte.add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(881, 21, 93, 21);
					btnModificar.addActionListener(this);
				}
				{
					btnEliminar = new JButton();
					pnlListaReporte.add(btnEliminar);
					btnEliminar.setText("Eliminar");
					btnEliminar.setBounds(835, 45, 89, 21);
					btnEliminar.addActionListener(this);
				
					txtAObs = new JTextPane();
					scpObs.setViewportView(txtAObs);
					txtAObs.setPreferredSize(new java.awt.Dimension(349, 66));
					txtAObs.setSize(340, 66);
				}

				rbdOculto = new JRadioButton();
		        pnlListaReporte.add(rbdOculto);
				rbdOculto.setText("oc");
			    rbdOculto.setBounds(731, 80, 39, 24);
				rbdOculto.addActionListener(this);
				
				 // Group the radio buttons.
			    ButtonGroup group = new ButtonGroup();
			    group.add(rbdOculto);
			    rbdOculto.setVisible(false);

			    lblLlamo = new JLabel();
			    pnlListaReporte.add(lblLlamo);
			    lblLlamo.setText("Contesto");
			    lblLlamo.setBounds(542, 82, 61, 16);

			    btnSi = new JButton();
			    pnlListaReporte.add(btnSi);
			    btnSi.setText("Si");
			    btnSi.setBounds(596, 77, 49, 21);
			    btnSi.addActionListener(this);

			    btnNo = new JButton();
			    pnlListaReporte.add(btnNo);
			    btnNo.setText("No");
			    btnNo.setBounds(653, 77, 49, 21);
			    btnNo.addActionListener(this);

				cboCalif.addActionListener(this);

				lblContacto2 = new JLabel();
				pnlCita2.add(lblContacto2);
				lblContacto2.setText("Contacto");
				lblContacto2.setBounds(27, 25, 71, 14);

				lblTel2 = new JLabel();
				pnlCita2.add(lblTel2);
				lblTel2.setText("Telefono");
				lblTel2.setBounds(28, 49, 76, 14);

				lblCel2 = new JLabel();
				pnlCita2.add(lblCel2);
				lblCel2.setText("Celular");
				lblCel2.setBounds(38, 78, 56, 14);

				lblTel21 = new JLabel();
				pnlCita2.add(lblTel21);
				lblTel21.setLayout(null);
				lblTel21.setText("Telefono2");
				lblTel21.setBounds(241, 50, 79, 14);

				lblRpm2 = new JLabel();
				pnlCita2.add(lblRpm2);
				lblRpm2.setText("Rpm");
				lblRpm2.setBounds(270, 78, 45, 14);

				lblNextel2 = new JLabel();
				pnlCita2.add(lblNextel2);
				lblNextel2.setText("Nextel");
				lblNextel2.setBounds(41, 105, 55, 14);

				lblFax2 = new JLabel();
				pnlCita2.add(lblFax2);
				lblFax2.setText("Fax");
				lblFax2.setBounds(274, 105, 36, 14);

				lblEmail2 = new JLabel();
				pnlCita2.add(lblEmail2);
				lblEmail2.setText("Email");
				lblEmail2.setBounds(47, 133, 42, 14);

				txtContacto2 = new JTextField();
				pnlCita2.add(txtContacto2);
				txtContacto2.setBounds(82, 20, 331, 21);

				txtTel2 = new JTextField();
				pnlCita2.add(txtTel2);
				txtTel2.setBounds(82, 47, 98, 21);

				txtTel21 = new JTextField();
				pnlCita2.add(txtTel21);
				txtTel21.setBounds(313, 47, 100, 21);

				txtCel2 = new JTextField();
				pnlCita2.add(txtCel2);
				txtCel2.setBounds(82, 75, 100, 21);

				txtRpm2 = new JTextField();
				pnlCita2.add(txtRpm2);
				txtRpm2.setBounds(313, 75, 100, 21);

				txtNextel2 = new JTextField();
				pnlCita2.add(txtNextel2);
				txtNextel2.setBounds(82, 104, 98, 21);

				txtFax2 = new JTextField();
				pnlCita2.add(txtFax2);
				txtFax2.setBounds(312, 105, 100, 21);

				txtEmail2 = new JTextField();
				pnlCita2.add(txtEmail2);
				txtEmail2.setBounds(82, 131, 331, 21);

				pnlArriba.setPreferredSize(new java.awt.Dimension(952, 363));
				pnlArriba.setLayout(null);

				listarReporte();
				objBuscarCliCita =new BuscarCliCita();
                conta=0;
                contFechas++;
                listaDepartamento();
                cargarTipo();
              
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
      public void listarReporteAExcel(){
		
	    fechaReporte=fecrep;
		int tipcomrep=cboTipoCom.getSelectedIndex(),
		calrep=cboCalif.getSelectedIndex();
		objSExcel.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
			
		String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,TIPCLI.nom_tipo, "+
           "concat(if(day(REP.FEC_REP)<10,concat(0,day(REP.FEC_REP)),day(REP.FEC_REP)),'-', "+
           "if(month(REP.FEC_REP)<10,concat(0,month(REP.FEC_REP)),month(REP.FEC_REP)),'-', "+
           "year(REP.FEC_REP)) 'fecha actual', "+
     	   "concat(if(day(REP.FECC_REP)<10,concat(0,day(REP.FECC_REP)),day(REP.FECC_REP)),'-', "+
           "if(month(REP.FECC_REP)<10,concat(0,month(REP.FECC_REP)),month(REP.FECC_REP)),'-', "+
           "year(REP.FECC_REP)) 'fecha de cita', "+
           "if(REP.TIP_REP=0,'LL',if(REP.TIP_REP=1,'NLL',if(REP.TIP_REP=2,'NV', "+
           "if(REP.TIP_REP=3,'@',if(REP.TIP_REP=4,'O/C','VACIO'))))) , "+
           "if(REP.CAL_REP=0,'Caliente',if(REP.CAL_REP=1,'Tibio',if(REP.CAL_REP=2,'Frio', "+
           "if(REP.CAL_REP=3,'Otros','VACIO')))),REP.OBS_REP, "+
           "if(REP.EST_REP=0,'Desactivo',if(REP.EST_REP=1,'Activo','VACIO')), "+
     	   "CLI.LUG_CLI,CLI.DIR_CLI,CLI.COD_DEP,CLI.COD_PRO,CLI.COD_DIS,CLI.CONA_CLI,CLI.TEL1A_CLI, "+
     	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,cli.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
     	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
           "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
     	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
     	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' "+
     	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
           "ON REP.COD_CLI = CLI.COD_CLI "+
     	   "INNER JOIN tb_vendedores VEN " +
     	   "ON REP.COD_VEN=VEN.COD_VEN "+
     	   "INNER JOIN tb_tipocliente TIPCLI " +
    	   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
           "where REP.FEC_REP='"+año(btnFecha2.getText())+"-"+mes(btnFecha2.getText())+"-"+dia(btnFecha2.getText())+"';";          
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
			BeanReporteAExcel objR= new BeanReporteAExcel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10), rs.getString(11), rs.getString(12),
					rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
					rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
					rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
					rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
					rs.getString(33));
			objSExcel.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
	}

    public void listarTareaAExcel(){
	
    fechaTarea=feccrep;
	objSTarea.eliminarTodo();
	int n=modelo2.getRowCount();
	for (int fila=0; fila<n; fila++)
	modelo2.removeRow(0);
	AccesoBD objA = new AccesoBD();
	objA.crearConexion();
		
	String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,TIPCLI.nom_tipo, "+
       "concat(if(day(REP.FEC_REP)<10,concat(0,day(REP.FEC_REP)),day(REP.FEC_REP)),'-', "+
       "if(month(REP.FEC_REP)<10,concat(0,month(REP.FEC_REP)),month(REP.FEC_REP)),'-', "+
       "year(REP.FEC_REP)) 'fecha actual', "+
 	   "concat(if(day(REP.FECC_REP)<10,concat(0,day(REP.FECC_REP)),day(REP.FECC_REP)),'-', "+
       "if(month(REP.FECC_REP)<10,concat(0,month(REP.FECC_REP)),month(REP.FECC_REP)),'-', "+
       "year(REP.FECC_REP)) 'fecha de cita', "+
       "if(REP.TIP_REP=0,'LL',if(REP.TIP_REP=1,'NLL',if(REP.TIP_REP=2,'NV', "+
       "if(REP.TIP_REP=3,'@',if(REP.TIP_REP=4,'O/C','VACIO'))))) , "+
       "if(REP.CAL_REP=0,'Caliente',if(REP.CAL_REP=1,'Tibio',if(REP.CAL_REP=2,'Frio', "+
       "if(REP.CAL_REP=3,'Otros','VACIO')))),REP.OBS_REP, "+
       "if(REP.EST_REP=0,'Desactivo',if(REP.EST_REP=1,'Activo','VACIO')), "+
 	   "CLI.LUG_CLI,CLI.DIR_CLI,CLI.COD_DEP,CLI.COD_PRO,CLI.COD_DIS,CLI.CONA_CLI,CLI.TEL1A_CLI, "+
 	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,cli.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
 	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
       "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
 	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
 	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' "+
 	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
       "ON REP.COD_CLI = CLI.COD_CLI "+
 	   "INNER JOIN tb_vendedores VEN "+
 	   "ON REP.COD_VEN=VEN.COD_VEN " +
 	   "INNER JOIN tb_tipocliente TIPCLI "+
       "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
       "where REP.FECC_REP='"+año(btnFecha2.getText())+"-"+mes(btnFecha2.getText())+"-"+dia(btnFecha2.getText())+"';";          
	
	ResultSet rs=objA.ejecutarConsulta(sql);
	try {
		
		while(rs.next()){
		BeanTareaAExcel objT= new BeanTareaAExcel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
				rs.getString(10), rs.getString(11), rs.getString(12),
				rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
				rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
				rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
				rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
				rs.getString(33));
		objSTarea.adicionar(objT);
		
		}
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	objA.cerrarConexion();
}
    

	public void listarReporte(){
		
		verificar=1;
		int cod_ven=objGlo.COD_VEN;
		int tipcomrep=cboTipoCom.getSelectedIndex(),
		calrep=cboCalif.getSelectedIndex();
		objS.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		
		String codi="";
			
		String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,TIPCLI.nom_tipo," +
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
     	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,cli.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
     	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
           "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
     	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
     	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' ,REP.HORA,TIPCLI.COD_TIPO " +
     	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
           "ON REP.COD_CLI = CLI.COD_CLI "+
     	   "INNER JOIN tb_vendedores VEN "+
     	   "ON REP.COD_VEN=VEN.COD_VEN " +
     	   "INNER JOIN tb_tipocliente TIPCLI "+
           "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
           "ORDER BY YEAR(REP.FEC_REP) DESC , MONTH(REP.FEC_REP) DESC , DAY(REP.FEC_REP) DESC;";
               
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
			BeanReporte objR= new BeanReporte(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10), rs.getString(11), rs.getString(12),
					rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
					rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
					rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
					rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
					rs.getString(33),rs.getString(34),rs.getString(35),rs.getString(36));
			objS.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
		for (int i = 0; i < objS.tamaño(); i++) {
			
			
			Object[] obj={objS.obtener(i).getCodrep(),objS.obtener(i).getNomcli(),
					objS.obtener(i).getNomven(),objS.obtener(i).getFecrep(),
					objS.obtener(i).getFeccrep(),objS.obtener(i).getTipocom(),
					objS.obtener(i).getCalrep(),objS.obtener(i).getObsrep(),objS.obtener(i).getEstrep()
			};
			modelo2.addRow(obj);
			
		}
	}
	
	public void buscarReporte(){
		
		int tipcomrep=cboTipoCom.getSelectedIndex(),
		calrep=cboCalif.getSelectedIndex();
		objS.eliminarTodo();
		int n=modelo2.getRowCount();
		String NOM_CLI=txtCliente.getText();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		
			
		String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,TIPCLI.nom_tipo," +
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
     	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,cli.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
     	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
           "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
     	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
     	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' ,REP.HORA,TIPCLI.COD_TIPO "+
     	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
           "ON REP.COD_CLI = CLI.COD_CLI "+
     	   "INNER JOIN tb_vendedores VEN "+
     	   "ON REP.COD_VEN=VEN.COD_VEN  " +
     	   "INNER JOIN tb_tipocliente TIPCLI "+
           "ON CLI.COD_TIPO = TIPCLI.cod_tipo " +
     	   "where CLI.NOM_CLI like '%"+NOM_CLI+"%'"+
           "ORDER BY YEAR(REP.FEC_REP) DESC , MONTH(REP.FEC_REP) DESC , DAY(REP.FEC_REP) DESC;";
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
			BeanReporte objR= new BeanReporte(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10), rs.getString(11), rs.getString(12),
					rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
					rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
					rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
					rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
					rs.getString(33),rs.getString(34),rs.getString(35),rs.getString(36));
			objS.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
		for (int i = 0; i < objS.tamaño(); i++) {
			
			Object[] obj={objS.obtener(i).getCodrep(),objS.obtener(i).getNomcli(),
					objS.obtener(i).getNomven(),objS.obtener(i).getFecrep(),
					objS.obtener(i).getFeccrep(),objS.obtener(i).getTipocom(),
					objS.obtener(i).getCalrep(),objS.obtener(i).getObsrep(),objS.obtener(i).getEstrep()
			};
			modelo2.addRow(obj);
			
		}
	}
	
     public void buscarPorFechaTarea(){
		
		int tipcomrep=cboTipoCom.getSelectedIndex(),
		calrep=cboCalif.getSelectedIndex();
		objS.eliminarTodo();
		int n=modelo2.getRowCount();
		String fec=objFecha.convrtidorFec(btnFecha2.getDate());
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		verificar=0;
			
		String sql="SELECT REP.COD_REP,CLI.COD_CLI,CLI.NOM_CLI,VEN.nom_ven,TIPCLI.nom_tipo," +
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
     	   "CLI.TEL2A_CLI,CLI.CELA_CLI,CLI.RPMA_CLI,cli.NEXA_CLI,CLI.FAXA_CLI,CLI.MAILA_CLI , "+
     	   "CLI.CONB_CLI,CLI.TEL1B_CLI,CLI.CELB_CLI,CLI.RPMB_CLI,CLI.NEXB_CLI,CLI.MAILB_CLI, "+
           "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento', "+
     	   "(select nombre from tb_ubigeo where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', "+
     	   "(select nombre from tb_ubigeo  where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' ,REP.HORA,TIPCLI.COD_TIPO "+
     	   "FROM tb_reporte REP INNER JOIN  tb_cliente CLI "+
           "ON REP.COD_CLI = CLI.COD_CLI "+
     	   "INNER JOIN tb_vendedores VEN "+
     	   "ON REP.COD_VEN=VEN.COD_VEN  " +
     	   "INNER JOIN tb_tipocliente TIPCLI "+
           "ON CLI.COD_TIPO = TIPCLI.cod_tipo " +
     	   "where REP.FECC_REP='"+fec+"'"+
           "ORDER BY YEAR(REP.FEC_REP) DESC , MONTH(REP.FEC_REP) DESC , DAY(REP.FEC_REP)DESC ;";
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
			BeanReporte objR= new BeanReporte(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
					rs.getString(10), rs.getString(11), rs.getString(12),
					rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
					rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), 
					rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
					rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32),
					rs.getString(33),rs.getString(34),rs.getString(35),rs.getString(36));
			objS.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
		for (int i = 0; i < objS.tamaño(); i++) {
			
			Object[] obj={objS.obtener(i).getCodrep(),objS.obtener(i).getNomcli(),
					objS.obtener(i).getNomven(),objS.obtener(i).getFecrep(),
					objS.obtener(i).getFeccrep(),objS.obtener(i).getTipocom(),
					objS.obtener(i).getCalrep(),objS.obtener(i).getObsrep(),objS.obtener(i).getEstrep()
			};
			modelo2.addRow(obj);
			
		}
	}
	
	public void cargarReporte(){
		int fila = tblReporte.getSelectedRow();
		press=0;
		
		codcli=objS.obtener(fila).getCodcli();
		cod_rep=Integer.parseInt(objS.obtener(fila).getCodrep());
		nomcli=objS.obtener(fila).getNomcli();
		tipcli=objS.obtener(fila).getCod_tipo();
		sexo=objS.obtener(fila).getSexo();
		dircli=objS.obtener(fila).getDircli();
		conacli=objS.obtener(fila).getContacto1cli(); 
		tel1acli=objS.obtener(fila).getTel1acli();
		tel2acli=objS.obtener(fila).getTel2acli();
		celacli=objS.obtener(fila).getCelacli();
		rpmacli=objS.obtener(fila).getRpmacli();
		nexacli=objS.obtener(fila).getNexacli();
		faxacli=objS.obtener(fila).getFaxacli();
		mailacli=objS.obtener(fila).getMailacli();
		conbcli=objS.obtener(fila).getContacto2cli();
		tel1bcli=objS.obtener(fila).getTel1bcli();
		celbcli=objS.obtener(fila).getCelbcli();
		rpmbcli=objS.obtener(fila).getRpmbcli();
		nexbcli=objS.obtener(fila).getNexbcli();
		mailbcli=objS.obtener(fila).getMailbcli();
		depcli=objS.obtener(fila).getNomdep();
		provcli=objS.obtener(fila).getNomprov();
		discli=objS.obtener(fila).getNomdis();
		fecrep=objS.obtener(fila).getFecrep();
		feccrep=objS.obtener(fila).getFeccrep();
		tipcomrep=objS.obtener(fila).getTipocom();
		calrep=objS.obtener(fila).getCalrep();
		obsrep=objS.obtener(fila).getObsrep();
		cargarComboBox(objS.obtener(fila).getDepcli(), objS.obtener(fila).getProvcli(),objS.obtener(fila).getDiscli());
	
		txtCliente.setText(nomcli);
		txtDireccion.setText(dircli);
		cargarTipoCli(tipcli);
		txtContacto1.setText(conacli);
		txtTel1.setText(tel1acli);
		txtTel11.setText(tel2acli);
		txtCel1.setText(celacli);
		txtRpm1.setText(rpmacli);	
		txtNextel1.setText(nexacli);
		txtFax1.setText(faxacli);
		txtEmail1.setText(mailacli);
		txtContacto2.setText(conbcli);
		txtTel2.setText(tel1bcli);
		txtCel2.setText(celbcli);
		txtRpm2.setText(rpmbcli);	
		txtNextel2.setText(nexbcli);
		txtEmail2.setText(mailbcli);  
		cboTipoCom.setSelectedItem(tipcomrep);
		cboCalif.setSelectedItem(calrep);
		cboSexo.setSelectedItem(sexo);
		txtAObs.setText(obsrep);
		System.out.println("cod reporte"+cod_rep);
	}
	public void agregarReporte(){
		
//		AccesoBD objAccesoBD = new AccesoBD();
//		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		int seleccionado=0;
		String codcli=objBuscarCliCita.codcli;
		int tipcomrep=cboTipoCom.getSelectedIndex(),
		calrep=cboCalif.getSelectedIndex();
		String obsrep=txtAObs.getText();
		obsrep=obsrep.replaceAll("'", "\'\'");
		String fecrep=objFecha.fechaActual();
		String feccrep =objFecha.convrtidorFec(btnFecha2.getDate());
		String hora="09:00:00";
		
		if(codcli!=null && press!=0){
			 String insertarPregunta="INSERT INTO tb_reporte (COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP, HORA) " +
		    		" VALUES('"+codcli+"','"+codven+"','"+fecrep+"','"
			+feccrep+"','"+tipcomrep+"','"+calrep+"','"+obsrep+"','"+seleccionado+"','"+hora+"');";
			System.out.println(insertarPregunta);

//			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
//			
//			
//				if(op==0){
//				objGUI.mostrarAviso("Hubo un ERROR al Ingresar los datos");
//				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
//			    }	
//			      else{
//				  objGUI.mostrarAviso("Se ingreso Correctamente ");
//				  System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
//				  array=1;
//			   }
//				
//				objAccesoBD.cerrarConexion();
				
				listarReporte();
				listarReporteAExcel();
				listarTareaAExcel();
		}else{
			objGUI.mostrarAviso("Debe cargar los datos del cliente ");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
		}
	
	}
	
	public void eliminarListaRep(){
//		AccesoBD objAccesoBD=  new AccesoBD();
//		objAccesoBD.crearConexion();
		
		String sql="DELETE FROM tb_reporte "+
                    "WHERE COD_REP ='"+cod_rep+"';";
		System.out.println(sql);

		
//		int op=objAccesoBD.ejecutarActualizacion(sql);
//		if(op==0){
//			objGUI.mostrarAviso("Debe seleccioar un reporte");
//		}else{
//			objGUI.mostrarAviso("Se Elimino Correctamente ");
//			
//		}
//		objAccesoBD.cerrarConexion();	
		
	}
	
	public void limpiar(){
		
		String fec=objFecha.fechaActual1();
		txtCliente.setText("");
		txtDireccion.setText("");
		cboTipo.setSelectedIndex(0);
		txtContacto1.setText("");
		txtTel1.setText("");
		txtTel11.setText("");
		txtCel1.setText("");
		txtRpm1.setText("");	
		txtNextel1.setText("");
		txtFax1.setText("");
		txtEmail1.setText("");
		txtContacto2.setText("");
		txtTel2.setText("");
		txtCel2.setText("");
		txtRpm2.setText("");	
		txtNextel2.setText("");
		txtEmail2.setText("");  
	    btnFecha1.setText(objFecha.fechaActual1());
		cboDepartamento.setSelectedIndex(0);
		cboProvincia.setSelectedIndex(0);
		cboDistrito.setSelectedIndex(0);
		cboTipoCom.setSelectedIndex(0);
		cboCalif.setSelectedIndex(0);
		cboSexo.setSelectedIndex(0);
		txtAObs.setText("");
		cod_rep=0;
		rbdOculto.setSelected(true);
		

	}
	public String fecRep(){
		return fecrep;
		
	}
	public String feccRep(){
		return feccrep;
		
	}
	 public int tamañodelExcel() {
		 int item=0;
		for (int i = 0; i < objSExcel.tamaño(); i++) 
			item=item+1;	
		return item;
	}
	 public int tamañodelExcelTarea() {
		 int item=0;
		for (int i = 0; i < objSTarea.tamaño(); i++) 
			item=item+1;	
		return item;
	}
	 
	 public String dia(String fec){
			String cad="";
			for(int i=0 ;i<fec.length();i++){
				    if(i<2){
				    	cad=cad+fec.charAt(i);
				    }else{
				    	break;
				    }
			}
			return cad;
		}
	 public String mes(String fec){
			String cad="";
			int cont=0;
			for(int i=0 ;i<fec.length();i++){
				    if(cont>=3 && i<5){
				    	cad=cad+fec.charAt(i);
				    }else{
				    	cont++;
				    }
			}
			return cad;
		}
	 public String año(String fec){
			String cad="";
			int cont=0;
			for(int i=0 ;i<fec.length();i++){
				    if(cont>=6 && i<fec.length()){
				    	cad=cad+fec.charAt(i);
				    }else{
				    	cont++;
				    }
			}
			return cad;
		}

	 public boolean pasarExcel(int cant) throws FileNotFoundException, IOException{
			
			 boolean devuelve=true;
			 String fecR=objFecha.convrtidorFec2(btnFecha2.getDate());
			 BeanReporteAExcel objRep;
			 int tam=objSExcel.tamaño();
			 int item=-1;
			 if(tam>0){
				 for (int i = 0; i < objSExcel.tamaño(); i++) {
				 
					 objRep=objSExcel.obtener(i);
					
			arregloCadenas[0]="REPORTE DEL DIA: "+fecR;
			
			item=item+1;
			
				 for (int j = 0; j < 11; j++) {
			                
						    if(j==0){
							arregloObjetos[item][j]=objRep.getNomcli();	
							}else if(j==1){
							arregloObjetos[item][j]=objRep.getTipocli().toString().toUpperCase();	
							}else if(j==2){
							arregloObjetos[item][j]=objRep.getLugcli().toString().toUpperCase();	
							}else if(j==3){
							arregloObjetos[item][j]=objRep.getTel1acli().toString().toUpperCase()+" / "+
							objRep.getTel2acli().toString().toUpperCase();		
							}else if(j==4){
							arregloObjetos[item][j]=objRep.getContacto1cli().toString().toUpperCase();			
							}else if(j==5){
							arregloObjetos[item][j]=objRep.getFeccrep().toString().toUpperCase();				
							}else if(j==6){
							arregloObjetos[item][j]=objRep.getTipocom().toString().toUpperCase();	
							}else if(j==7){
							arregloObjetos[item][j]=objRep.getNomven().toString().toUpperCase().charAt(0);	
							}else if(j==8){
							arregloObjetos[item][j]=objRep.getObsrep().toString().toUpperCase();	
							}else if(j==9){
							arregloObjetos[item][j]=objRep.getCalrep().toString().toUpperCase();	
							}else{
							arregloObjetos[item][j]="";	
							}
			
		}
				
	
	  }
	}
    
	        return devuelve;		
	}
	 
	 public boolean pasarExcelTarea(int cant) throws FileNotFoundException, IOException{
			
		 boolean devuelve=true;
		 BeanTareaAExcel objTar;
		 String feccR=objFecha.convrtidorFec2(btnFecha2.getDate());
		 int tam=objSTarea.tamaño();
		 int item=-1;
		 if(tam>0){
			 for (int i = 0; i < objSTarea.tamaño(); i++) {
			 
				 objTar=objSTarea.obtener(i);
				
		arregloCadenasTarea[0]="TAREA DEL DIA: "+feccR;
		
		item=item+1;
		
			 for (int j = 0; j < 11; j++) {
		                
					    if(j==0){
						arregloObjetosTarea[item][j]=objTar.getNomcli();	
						}else if(j==1){
						arregloObjetosTarea[item][j]=objTar.getTipocli().toString().toUpperCase();	
						}else if(j==2){
						arregloObjetosTarea[item][j]=objTar.getLugcli().toString().toUpperCase();	
						}else if(j==3){
						arregloObjetosTarea[item][j]=objTar.getTel1acli().toString().toUpperCase()+" / "+
						objTar.getTel2acli().toString().toUpperCase();		
						}else if(j==4){
						arregloObjetosTarea[item][j]=objTar.getContacto1cli().toString().toUpperCase();			
						}else if(j==5){
						arregloObjetosTarea[item][j]=objTar.getFecrep().toString().toUpperCase();				
						}else if(j==6){
						arregloObjetosTarea[item][j]=objTar.getTipocom().toString().toUpperCase();	
						}else if(j==7){
						arregloObjetosTarea[item][j]=objTar.getNomven().toString().toUpperCase().charAt(0);	
						}else if(j==8){
						arregloObjetosTarea[item][j]=objTar.getObsrep().toString().toUpperCase();	
						}else if(j==9){
						arregloObjetosTarea[item][j]=objTar.getCalrep().toString().toUpperCase();	
						}else{
						arregloObjetosTarea[item][j]="";	
						}
		
	}
			

  }
}

        return devuelve;		
} 
	
	 /********PARA EL COMBOOX DE DEPARTAMENTO***********/
		public void listaDepartamento(){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_ubigeo WHERE COD_DIS='00' AND COD_PRO='00';";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			
			try {
				
				while (rs.next()) {
					cboDepartamento.addItem( rs.getString(4)+"-"+rs.getString(1));
				}
				
				rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}

			objAccesoBD.cerrarConexion();
		}
		/***********************************************/
		/********PARA EL COMBOBOX DE DISTRITO**********/
		public void listaDistrito(){
			
			System.out.println("ESTO ES LO DEL COMBO"+cboDepartamento.getSelectedItem());System.out.println("ESTO ES LO DEL COMBO"+cboProvincia.getSelectedItem());
			if(cboProvincia.getSelectedItem()==null){
				System.out.println("ESTO SALE POR DEFECTO");
			}else if(cboProvincia.getSelectedItem().equals("PROVINCIA")){
				System.out.println("ESTO SALE POR DEFECTO 2");
			}else{
				String dep=""+cboDepartamento.getSelectedItem();
				String cod_dep=dep.substring(dep.indexOf("-")+1, dep.length());
				String pro=""+cboProvincia.getSelectedItem();
				String cod_pro=pro.substring(pro.indexOf("-")+1, pro.length());
				System.out.println("ESTOS SON LOS CODIGOS:"+cod_dep+","+cod_pro);
				AccesoBD objAccesoBD = new AccesoBD();
				objAccesoBD.crearConexion();
				
				String sql3="SELECT * FROM tb_ubigeo WHERE COD_DEP='"+cod_dep+"' AND COD_PRO='"+cod_pro+"' AND COD_DIS!='00';";
				ResultSet rs3 = objAccesoBD.ejecutarConsulta(sql3);
				try {cboDistrito.removeAllItems();
				cboDistrito.addItem("DISTRITO");
					while (rs3.next()) {cboDistrito.addItem(rs3.getString(4) +"-"+rs3.getString(3));}
					rs3.close();
				} catch (Exception e) {System.out.println(e);}
				objAccesoBD.cerrarConexion();	
				}
			}
		
		/********************************************/
		/********PARA EL COMBOOX DE PROVINCIA***********/
		public void listaProvincias(){

			if(cboDepartamento.getSelectedItem().equals("DEPARTAMENTO")){
				
			}else{
				String dep=""+cboDepartamento.getSelectedItem();
				String cod_prov=dep.substring(dep.indexOf("-")+1, dep.length());
				
				AccesoBD objAccesoBD = new AccesoBD();
				objAccesoBD.crearConexion();
				String sql3="SELECT * FROM tb_ubigeo WHERE COD_DEP='"+cod_prov+"' AND COD_DIS='00' AND COD_PRO!='00';";
				ResultSet rs3 = objAccesoBD.ejecutarConsulta(sql3);
				try {cboProvincia.removeAllItems();
				cboProvincia.addItem("PROVINCIA");
					while (rs3.next()) {cboProvincia.addItem(rs3.getString(4) +"-"+rs3.getString(2));}
					rs3.close();	
				} catch (Exception e) {System.out.println(e);}
				objAccesoBD.cerrarConexion();	
			}
				
			}
		
		/********METODO CARGA COMBOBOX******************/
		public void cargarComboBox(String coddep,String codpro,String coddis){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_ubigeo WHERE COD_DEP='"+coddep+"' AND COD_PRO='00' AND COD_DIS='00';";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			
			try {
				while (rs.next()) {
					cboDepartamento.setSelectedItem(rs.getString(4)+"-"+rs.getString(1));
					
				}
				rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//PARA PROVINCIA
			String sql2="SELECT * FROM tb_ubigeo WHERE COD_DEP='"+coddep+"' AND COD_PRO='"+codpro+"' AND COD_DIS='00';";
			ResultSet rs2 = objAccesoBD.ejecutarConsulta(sql2);
			try {
				while (rs2.next()) {
					cboProvincia.setSelectedItem(rs2.getString(4)+"-"+rs2.getString(2));
					
				}
				rs2.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			//PARA DISTRITO
			String sql3="SELECT * FROM tb_ubigeo WHERE COD_DEP='"+coddep+"' AND COD_PRO='"+codpro+"' AND COD_DIS='"+coddis+"';";
			ResultSet rs3 = objAccesoBD.ejecutarConsulta(sql3);
			try {
				while (rs3.next()) {
					cboDistrito.setSelectedItem(rs3.getString(4)+"-"+rs3.getString(3));
					
				}
				rs3.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			objAccesoBD.cerrarConexion();
		}
		/***********************************************/
		public void modificarDatosClienteReporte(){
			
			String hora="09:00:00";
//			AccesoBD objAccesoBD=  new AccesoBD();
//			objAccesoBD.crearConexion();
			/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
			"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
			String COD_DEP=(String)cboDepartamento.getSelectedItem(),COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
			String fec=objFecha.fechaActual();
			String cod_tipo=""+cboTipo.getSelectedItem();
			cod_tipo=cod_tipo.substring(cod_tipo.indexOf("-")+1, cod_tipo.length());
			boolean valor;
			
			if(COD_DEP.equals("")||COD_DEP==null||COD_PRO.equals("")||COD_PRO==null||COD_DIS.equals("")|COD_DIS==null){
				JOptionPane.showInternalMessageDialog(this, "FALTAN LOS DATOS DE: \n Lugar,Departamento,Provincia,Distrito",
						"Precaucion", JOptionPane.WARNING_MESSAGE);
				valor=true;
			}else{System.out.println("EL COD_DEP:"+COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length()));
				  System.out.println("EL COD_PRO:"+COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length()));
				  System.out.println("EL COD_DIS:"+COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length()));
				COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length());
				COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length());
				COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length());
			
				valor=false;
			}
			
			if(valor==false){
				String dat=txtAObs.getText();
				dat=dat.replaceAll("'", "\'\'");
				String sql="update tb_reporte REP , tb_cliente CLI "+
				" SET CLI.NOM_CLI='"+txtCliente.getText()+"',CLI.DIR_CLI='"+txtDireccion.getText()+"',CLI.COD_TIPO='"+cod_tipo+"', "+
				"CLI.COD_DEP='"+COD_DEP+"',CLI.COD_PRO='"+COD_PRO+"', "+
				" CLI.COD_DIS='"+COD_DIS+"',CLI.CONA_CLI='"+txtContacto1.getText()+"',CLI.TEL1A_CLI='"+txtTel1.getText()+"', "+
				" CLI.TEL2A_CLI='"+txtTel11.getText()+"',CLI.CELA_CLI='"+txtCel1.getText()+"',CLI.RPMA_CLI='"+txtRpm1.getText()+"'," +
				"CLI.NEXA_CLI='"+txtNextel1.getText()+"',CLI.FAXA_CLI='"+txtFax1.getText()+"',CLI.MAILA_CLI='"+txtEmail1.getText()+"',CLI.CONB_CLI='"+txtContacto2.getText()+"', "+
				"CLI.TEL1B_CLI='"+txtTel2.getText()+"',CLI.CELB_CLI='"+txtCel2.getText()+"', "+
				"CLI.RPMB_CLI='"+txtRpm2.getText()+"',CLI.NEXB_CLI='"+txtNextel2.getText()+"',CLI.MAILB_CLI='"+txtEmail2.getText()+"'," +
				"REP.FEC_REP='"+fec+"'," +
				"REP.FECC_REP='"+año(btnFecha2.getText())+mes(btnFecha2.getText())+dia(btnFecha2.getText())+"'," +
				"REP.TIP_REP='"+cboTipoCom.getSelectedIndex()+"'," +
				"REP.CAL_REP='"+cboCalif.getSelectedIndex()+"', "+
				"REP.OBS_REP='"+dat+"', " +
			    "REP.HORA='"+hora+"' "+
				"WHERE CLI.COD_CLI='"+codcli+"' AND REP.COD_REP='"+cod_rep+"'; ";

//			System.out.println(sql);
//			int op=objAccesoBD.ejecutarActualizacion(sql);
//			if(op==0){
//				objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
//			}else{
//				objGUI.mostrarAviso("Se modifico el Cliente y el Reporte");
//			}
//			objAccesoBD.cerrarConexion();	
			}
			
		}
		
		public void modificarDatosCliente(){
			
			AccesoBD objAccesoBD=  new AccesoBD();
			objAccesoBD.crearConexion();
			/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
			"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
			String COD_DEP=(String)cboDepartamento.getSelectedItem(),COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
			String fec=objFecha.fechaActual();
			String cod_tipo=""+cboTipo.getSelectedItem();
			cod_tipo=cod_tipo.substring(cod_tipo.indexOf("-")+1, cod_tipo.length());
			boolean valor;
			
			if(COD_DEP.equals("")||COD_DEP==null||COD_PRO.equals("")||COD_PRO==null||COD_DIS.equals("")|COD_DIS==null){
				JOptionPane.showInternalMessageDialog(this, "FALTAN LOS DATOS DE: \n Lugar,Departamento,Provincia,Distrito",
						"Precaucion", JOptionPane.WARNING_MESSAGE);
				valor=true;
			}else{System.out.println("EL COD_DEP:"+COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length()));
				  System.out.println("EL COD_PRO:"+COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length()));
				  System.out.println("EL COD_DIS:"+COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length()));
				COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length());
				COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length());
				COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length());
			
				valor=false;
			}
			
			if(valor==false && array==0){
				String sql="update tb_cliente "+
				" SET NOM_CLI='"+txtCliente.getText()+"',DIR_CLI='"+txtDireccion.getText()+"',COD_TIPO='"+cod_tipo+"', "+
				"SEX_CLI='"+cboSexo.getSelectedIndex()+"',COD_DEP='"+COD_DEP+"',COD_PRO='"+COD_PRO+"', "+
				"COD_DIS='"+COD_DIS+"',CONA_CLI='"+txtContacto1.getText()+"',TEL1A_CLI='"+txtTel1.getText()+"', "+
				"TEL2A_CLI='"+txtTel11.getText()+"',CELA_CLI='"+txtCel1.getText()+"',RPMA_CLI='"+txtRpm1.getText()+"'," +
				"NEXA_CLI='"+txtNextel1.getText()+"',FAXA_CLI='"+txtFax1.getText()+"',MAILA_CLI='"+txtEmail1.getText()+"',CONB_CLI='"+txtContacto2.getText()+"', "+
				"TEL1B_CLI='"+txtTel2.getText()+"',CELB_CLI='"+txtCel2.getText()+"', "+
				"RPMB_CLI='"+txtRpm2.getText()+"',NEXB_CLI='"+txtNextel2.getText()+"',MAILB_CLI='"+txtEmail2.getText()+"' "+
				"WHERE COD_CLI='"+codcli+"'; ";

			System.out.println(sql);

			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				//objGUI.mostrarAviso("Debe Selecionar un Cliente");
			}else{
				//objGUI.mostrarAviso("Se modifico el Cliente");
				array=1;
			}
			
			objAccesoBD.cerrarConexion();	
			}else{
				//objGUI.mostrarAviso("Debe cargar los datos del Cliente");
			}
			
		}
		public void modificarEstRep(int valor){
			
//			AccesoBD objAccesoBD=  new AccesoBD();
//		    objAccesoBD.crearConexion();
			
			String sql="update tb_reporte " +
		    " SET EST_REP='"+valor+"'" +
			" WHERE COD_REP='"+cod_rep+"'; ";

//		System.out.println(sql);

//		int op=objAccesoBD.ejecutarActualizacion(sql);
//		if(op==0){
//			objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
//		}else{
//			System.out.println("Se modifico el estado del reporte");
//			
//		}
//	    objAccesoBD.cerrarConexion();	
		
	}
	/****************************************************************************************************************************/
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
		
		/***********************************************/
		public void cargarTipoCli(String cod_tipo){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_tipocliente WHERE COD_tipo='"+cod_tipo+"';";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			
			try {
				while (rs.next()) {
					cboTipo.setSelectedItem(rs.getString(2)+"-"+rs.getString(1));
				}
				rs.close();
				
			} catch (Exception e) {
				
			}
			
		}
		
   /****************************************************************************************************************************/
		 public void forzarCerrado() { 
				
				try { 
					setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
					setClosed(true); 
					this.setEnabled(false);
				} catch (PropertyVetoException ex) { 
					
				}
		}
		 
   /****************************************************************************************************************************/
					
		@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBuscarCli){
			nombrecliente=txtCliente.getText();
			System.out.println("qqqq :"+nombrecliente);
			//limpiar();
			          objBuscarCliCita=null;
			          objBuscarCliCita= new BuscarCliCita();
                      objBuscarCliCita.listarCliente();
			          array=0;
			          press=1;
				     String[] botones = {"Aceptar"};//Esto es el nombre
	                 int op=  JOptionPane.showOptionDialog(
	    		     this,                             			
	    		     objBuscarCliCita,                                    
	    		     "Buscar Cliente", 		
	    		      0,          						        
	    		     -1,            								
	    		      null,                                       
	    		      botones,
	    		      "Cerrar" );
	               if(op==1||op==-1){
	            	  
	               }else{
	                valor=1;
			    	codcli=objBuscarCliCita.codcli;   
			        nomcli=objBuscarCliCita.nomcli;
			        tipcli=objBuscarCliCita.tipcli;
			        sexo=objBuscarCliCita.sexo;
			        lugcli=objBuscarCliCita.lugcli;
			        dircli=objBuscarCliCita.dircli;
			        conacli=objBuscarCliCita.conacli;
			        tel1acli=objBuscarCliCita.tel1acli;
			        tel2acli=objBuscarCliCita.tel2acli;
			        rpmacli=objBuscarCliCita.rpmacli;
			        nexacli=objBuscarCliCita.nexacli;
			        celacli=objBuscarCliCita.celacli;
			        faxacli=objBuscarCliCita.faxacli;
			        mailacli=objBuscarCliCita.mailacli;
			        conbcli=objBuscarCliCita.conbcli;
			        tel1bcli=objBuscarCliCita.tel1bcli;
			        rpmbcli=objBuscarCliCita.rpmbcli;
			        nexbcli=objBuscarCliCita.nexbcli;
			        celbcli=objBuscarCliCita.celbcli;
			        mailbcli=objBuscarCliCita.mailbcli;
			        depcli=objBuscarCliCita.depcli;
			        provcli=objBuscarCliCita.provcli;
			        discli=objBuscarCliCita.discli;
			        
			        cargarComboBox(depcli, provcli, discli);
			        txtCliente.setText(nomcli);
					cargarTipoCli(tipcli);
					txtDireccion.setText(dircli);
					txtContacto1.setText(conacli);
					txtTel1.setText(tel1acli);
					txtTel11.setText(tel2acli);
					txtCel1.setText(celacli);
					txtRpm1.setText(rpmacli);	
					txtNextel1.setText(nexacli);
					txtFax1.setText(faxacli);
					txtEmail1.setText(mailacli);
					txtContacto2.setText(conbcli);
					txtTel2.setText(tel1bcli);
					txtCel2.setText(celbcli);
					txtRpm2.setText(rpmbcli);	
					txtNextel2.setText(nexbcli);
					txtEmail2.setText(mailbcli);  
					cboSexo.setSelectedItem(sexo);
	              
			        } 
		 
	  }
			
		if(e.getSource()==btnAgregar){
			
				try {
					modificarDatosCliente();
					if(valor==0){
						objGUI.mostrarAviso("Debe cargar los datos del cliente");
						System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
					}
					else{
						if(verificar==0){
							agregarReporte();
							limpiar();
							buscarPorFechaTarea();
						}else{
							agregarReporte();
					        limpiar();
					        listarReporte();
						}
						
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
				limpiar();
				listarReporte();
			
		}
		
		if(e.getSource()==btnListar){
			
			limpiar();
			listarReporte();
			
		}
		
		if(e.getSource()==btnEliminar){
			
			try {
				if(cod_rep==0){
					objGUI.mostrarAviso("Debe seleccionar un reporte");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
				}
				else{
					if(verificar==0){
						eliminarListaRep();
						limpiar();
						buscarPorFechaTarea();
					}else{
						eliminarListaRep();
				        limpiar();
				        listarReporte();
					}
					
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
		
		if(e.getSource()==btnReporte){
		  try {
				contaRep++;
			if(contFechas>=1){
				fechaReporte=fecrep;
				listarReporte();
				if(contaRep==1){
					listarReporteAExcel();
				}else{
					listarReporteAExcel();
				}
		    }	
		  }catch (Exception e2) {
				System.out.println("NADA");
				listarReporte();
			}
			
		
			if(tamañodelExcel()!=0){
				
			boolean valor=true;
			int tam=objSExcel.tamaño();//ESTE ES EL TAMAÑO REAL
			boolean devuelve = false;
			String fec=objFecha.convrtidorFec2(btnFecha2.getDate());
			arregloCadenas= new Object[1];
			arregloObjetos= new Object[tam][11];
		
			try {
				limpiar();
			    listarReporte();
				devuelve=pasarExcel(tam);
				objPasarRepExcelCorreo= new PasarReporteExcelCorreo();
				objPasarRepExcelCorreo.crearExcel(arregloCadenas,arregloObjetos,fec);
				rutaGlobal=objPasarRepExcelCorreo.fileGlobal;
				valor=true;
			} catch (FileNotFoundException e1) {
				valor=false;
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
				valor=false;
			}finally{
				if(!valor){
					objGUI.mostrarAviso("Debe cerrar la aplicacion Anterior!");
					
				}
			}
			if(devuelve){
			
			}
			else{
				objGUI.mostrarAviso("Hubo un error al pasar al excel!");
			}
		 }else{
			 
			 objGUI.mostrarAviso("No existen Reportes para esa fecha");
			 limpiar();
			 listarReporte();
			 conta=1;
			
		 }
			
		}
		
		/****************************************************************************************/
		
		if(e.getSource()==btnTarea){
			verificar=0;
			try {
				contaRep++;
			if(contFechas>=1){
				
				fechaTarea=feccrep;
				listarReporte();
				if(contaRep==1){
					listarTareaAExcel();
				}else{
					listarTareaAExcel();
				}
				
		    }	
		  }catch (Exception e2) {
				System.out.println("NADA");
				listarReporte();
			}
			if(tamañodelExcelTarea()!=0){
			boolean valor=true;
			int tam=objSTarea.tamaño();//ESTE ES EL TAMAÑO REAL
			String feccR=objFecha.convrtidorFec2(btnFecha2.getDate());
			boolean devuelve = false;
			arregloCadenasTarea= new Object[1];
			arregloObjetosTarea= new Object[tam][11];
		
			try {
				limpiar();
				buscarPorFechaTarea();
				devuelve=pasarExcelTarea(tam);
				objPasarTareaExcelCorreo= new PasarTareaExcelCorreo();
				objPasarTareaExcelCorreo.crearExcelTarea(arregloCadenasTarea,arregloObjetosTarea,feccR);
				rutaGlobal=objPasarTareaExcelCorreo.fileGlobal;
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
			 
			 objGUI.mostrarAviso("No existen Tareas para esa fecha");
			 limpiar();
			 listarReporte();
			 conta=1;
			
		 }
			
	  }
		
		if(e.getSource()==btnBuscar){
			buscarReporte();
		}
		
		if(e.getSource()==btnModificar){
			if(codcli==null){
				objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			}else{
				
				if(verificar==0){
					modificarDatosClienteReporte();
					limpiar();
					buscarPorFechaTarea();
				}else{
					modificarDatosClienteReporte();
			        limpiar();
			        listarReporte();
				}
				
			}
			
		
		   /*if(contFechas>=1){
			  fechaReporte=fecrep;
			  listarReporte();
			  modificarDatosClienteReporte();
		   }else{
			listarReporte();
		    System.out.println("NADA");
	       }*/
			
		}
		
		if(e.getSource()==cboDepartamento){
			listaProvincias();
		}
		if(e.getSource()==cboProvincia){
			listaDistrito();
		}
	
		if(e.getSource()==btnSi){
			
			if(verificar==0){
				modificarEstRep(1);
				limpiar();
				buscarPorFechaTarea();
			}else{
				modificarEstRep(1);
		        limpiar();
		        listarReporte();
			}
			
		}
		if(e.getSource()==btnNo){
			
			if(verificar==0){
				modificarEstRep(2);
				limpiar();
				buscarPorFechaTarea();
			}else{
				modificarEstRep(2);
		        limpiar();
		        listarReporte();
			}
		}
		
		/*if(e.getSource()==btnModCli){
			
			try {
				if(valor==0){
				objGUI.mostrarAviso("Debe cargar los datos del Cliente");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			}else{
				modificarDatosCliente();
			    limpiar();
			    listarReporte();
			}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			limpiar();
			listarReporte();
			
		}*/
}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
		MouseEvent evento=e;
		if(evento.getClickCount()==1){
			entrada=0;
			cargarReporte();
		}
			
		if(evento.getClickCount()==2){
			
			entrada=1;
			int fila = tblReporte.getSelectedRow();
			BeanReporte objRep=objS.obtener(fila);
			codigocliente=objRep.getCodcli();
			objBuscarCotTarea= new BuscarCotizacionTarea();
			
			
			 String[] botones1 = {"Aceptar","Cancelar"};//Esto es el nombre
	         int showOptionDialog = JOptionPane.showOptionDialog(
	     		   this,                             			
	     		  objBuscarCotTarea,                                    
	     		   "Buscar Cotizacion", 		
	     		    0,          						        
	     		   -1,            								
	     		   null,                                       
	     		  botones1,
	     		   "Cerrar"
	     		                                  	
	     	);
	         
	         if(showOptionDialog==0){//ACEPTAR
	        	 objTranCoti = new TranCotizacionAutMant();
	        	 objMenu.jDesktopPane1.add(objTranCoti);
	        	 entrada=0;	
	         }else if(showOptionDialog==1){
	        	 //objBuscarTipoCot=null;
	        	 entrada=0;
	        	 System.out.println("1");//CANCELAR
	         }else{
	        	 //objBuscarTipoCot=null;
	        	 entrada=0;
	        	 System.out.println("2");//CERRAR
	         }  
			         
		}	
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
