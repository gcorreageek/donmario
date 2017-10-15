package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.Fecha;
import miLib.GUI;
import pOp.BuscarMarcaProve;
import pOp.BuscarRubroProve;
import servlet.ServletEnvioProveedor;
import util.Propiedades;
import beans.BeanEnvioProveedor;

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
public class MantProveedor extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JPanel pnlPrincipal;
	private JTextField txtNombre;
	private JLabel lblDistrito;
	private JLabel lblProvincia;
	private JLabel lblDepartamento;
	private JLabel lblTipo;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JLabel lblNombre;
	private JComboBox cboDistrito;
	private JComboBox cboBanco;
	private JTextField txtTelefono2;
	private JTextField txtTelefono1;
	private JLabel lblTelefono1;
	private JTextField txtCuentaSolea;
	private JTextField txtCuentaDolares;
	private JLabel lblCuentaDolares;
	private JLabel lblNCuentaSolea;
	private JTextField txtDireccion;
	private JLabel lblBanco;
	private JLabel lblDireccion;
	private JComboBox cboDepartamento;
	private JComboBox cboProvincia;
	private JComboBox cboTipo;
	private JTable tblListado;
	private JTable jTable1;
	private JScrollPane scrListaCliente;
	private JScrollPane scrLargo;
	private JPanel AbajoListado;
	private JScrollPane scrListado;
	private JButton btnBuscar;
	private JButton btnListar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JTextArea txtAObservacionC;
	private JButton btnPromelsa;
	private JButton btnModProveMar;
	private JCheckBox chkMarcas;
	private JLabel lblMarcas;
	private JComboBox cboMarcas;
	private JButton btnMovistar;
	private JComboBox cboTiempoEntrega;
	private JComboBox cboLugarEntrega;
	private JComboBox cboCondicion;
	private JLabel lblTiempo;
	private JLabel lblLugarEntrega;
	private JLabel lblCondiciones;
	private JButton btnRuc;
	private JCheckBox chkRubro;
	private JTextField txtRpmC;
	private JTextField txtNexC;
	private JButton btnEnviar;
	private JLabel lblRubro;
	private JComboBox cboRubro;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JLabel lblSexo;
	private JComboBox cboSexo;
	private JTextField txtPersonal;
	private JLabel lblPersonal;
	private JButton btnBorrarTodo;
	private JLabel lblTelefono2;
	private JLabel lblFax;
	private JScrollPane scrObservacionC;
	private JLabel lblObservacionC;
	private JTextField txtCelularC;
	private JLabel lblCelularC;
	private JComboBox cboCargoC;
	private JTextField txtNombreC;
	private JLabel lblCargoC;
	private JLabel lblNombreC;
	private JPanel pnlContacto;
	private JPanel pnlProveedor;
	private JTextArea txtAObservacion;
	private JScrollPane scrObservacion;
	private JTextField txtWeb;
	private JTextField txtEmail;
	private JTextField txtFax;
	private JTextField txtCelular;
	private JTextField txtNextel;
	private JTextField txtRpm;
	private JLabel lblObservacion;
	private JLabel lblWeb;
	private JLabel lblEmail;
	private JLabel lblCelular;
	private JLabel lblNextel;
	private JLabel lblRpm;
	public static ServletEnvioProveedor objServlet=null;
	MenuPrincipal objMenu;
	EnviarCorreoProveedor objEnviarProveedores;
	public static int codproverubro,codprovemar,codiMarca,codiRubro;
	public static String nomprove;
	Fecha objFecha;
	
	GUI objGUI;
	/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS, 
	 * PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, 
	 * TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, FAX_PROVE, 
	 * MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, 
	 * CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
	String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS",
			"PER_PROVE", "SEX_PROVE","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
			"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE",
			"OBS_PROVE","NOMC_PROVE","CARC_PROVE","TELC_PROVE","CELC_PROVE","MAILC_PROVE","RPMC_PROVE","NEXC_PROVE","OBSC_PROVE","CONDICIONES","LUGAR ENTREGA","TIEMPO ENTREGA"};
	
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 int  cod1;

	public  MantProveedor() {
		super("Mant Proveedor", true, true, true, true);
		try {
			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(952, 632));
			this.setBounds(0, 0, 952, 632);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(942, 535));
			pnlPrincipal.setLayout(null);

			scrListado = new JScrollPane();
			pnlPrincipal.add(scrListado);
			scrListado.setBounds(2001, 517, 582, 421);

			tblListado = new JTable();
			scrListado.setViewportView(tblListado);
			tblListado.setModel(modelo2);

			pnlProveedor = new JPanel();
			pnlPrincipal.add(pnlProveedor);
			pnlProveedor.setBorder(BorderFactory.createTitledBorder("Datos Proveedor"));
			pnlProveedor.setBounds(12, 4, 924, 423);
			pnlProveedor.setLayout(null);

			AbajoListado = new JPanel();
			pnlPrincipal.add(AbajoListado, "bottom");
			BorderLayout AbajoListadoLayout = new BorderLayout();
			AbajoListado.setLayout(AbajoListadoLayout);
			AbajoListado.setBounds(8, 433, 928, 173);

			scrLargo = new JScrollPane();
			AbajoListado.add(scrLargo, BorderLayout.NORTH);
			scrLargo.setPreferredSize(new java.awt.Dimension(920, 164));

			scrListaCliente = new JScrollPane();
			scrLargo.setViewportView(scrListaCliente);
			scrListaCliente.setPreferredSize(new java.awt.Dimension(2382, 146));
		

			jTable1 = new JTable();
			scrListaCliente.setViewportView(jTable1);
			
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			txtWeb = new JTextField();
			pnlProveedor.add(txtWeb);
			txtWeb.setBounds(436, 185, 205, 21);

			txtEmail = new JTextField();
			pnlProveedor.add(txtEmail);
			txtEmail.setBounds(84, 185, 301, 21);

			txtFax = new JTextField();
			pnlProveedor.add(txtFax);
			txtFax.setBounds(239, 132, 155, 22);

			txtCelular = new JTextField();
			pnlProveedor.add(txtCelular);
			txtCelular.setBounds(85, 133, 106, 21);

			txtNextel = new JTextField();
			pnlProveedor.add(txtNextel);
			txtNextel.setBounds(660, 133, 124, 21);

			txtRpm = new JTextField();
			pnlProveedor.add(txtRpm);
			txtRpm.setBounds(461, 133, 121, 21);

			lblObservacion = new JLabel();
			pnlProveedor.add(lblObservacion);
			lblObservacion.setText("Observacion:");
			lblObservacion.setBounds(6, 211, 78, 14);

			lblWeb = new JLabel();
			pnlProveedor.add(lblWeb);
			lblWeb.setText("Web:");
			lblWeb.setBounds(402, 188, 41, 14);

			lblEmail = new JLabel();
			pnlProveedor.add(lblEmail);
			lblEmail.setText("Email:");
			lblEmail.setBounds(17, 188, 52, 14);

			lblFax = new JLabel();
			pnlProveedor.add(lblFax);
			lblFax.setText("Fax:");
			lblFax.setBounds(203, 136, 29, 14);

			lblCelular = new JLabel();
			pnlProveedor.add(lblCelular);
			lblCelular.setText("Celular:");
			lblCelular.setBounds(12, 139, 52, 14);

			lblNextel = new JLabel();
			pnlProveedor.add(lblNextel);
			lblNextel.setText("Nextel:");
			lblNextel.setBounds(601, 136, 47, 14);

			lblRpm = new JLabel();
			pnlProveedor.add(lblRpm);
			lblRpm.setText("Rpm:");
			lblRpm.setBounds(412, 137, 37, 13);

			txtTelefono2 = new JTextField();
			pnlProveedor.add(txtTelefono2);
			txtTelefono2.setBounds(799, 104, 117, 21);

			txtTelefono1 = new JTextField();
			pnlProveedor.add(txtTelefono1);
			txtTelefono1.setBounds(607, 104, 116, 21);

			lblTelefono1 = new JLabel();
			pnlProveedor.add(lblTelefono1);
			lblTelefono1.setText("Telefono 1:");
			lblTelefono1.setBounds(531, 107, 66, 14);

			txtCuentaSolea = new JTextField();
			pnlProveedor.add(txtCuentaSolea);
			txtCuentaSolea.setBounds(302, 158, 142, 21);

			txtCuentaDolares = new JTextField();
			pnlProveedor.add(txtCuentaDolares);
			txtCuentaDolares.setBounds(510, 158, 162, 21);

			lblCuentaDolares = new JLabel();
			pnlProveedor.add(lblCuentaDolares);
			lblCuentaDolares.setText("C.Dolares:");
			lblCuentaDolares.setBounds(449, 161, 64, 14);

			lblNCuentaSolea = new JLabel();
			pnlProveedor.add(lblNCuentaSolea);
			lblNCuentaSolea.setText("C.Soles:");
			lblNCuentaSolea.setBounds(251, 161, 54, 14);

			cboBanco = new JComboBox();
			pnlProveedor.add(cboBanco);
			
			cboBanco.addItem("");
			cboBanco.addItem("BCP");
			cboBanco.addItem("INTERBANK");
			cboBanco.addItem("SCOTIABANK");
			cboBanco.addItem("BBVA");
			cboBanco.addItem("OTRO");
			cboBanco.setBounds(84, 158, 160, 21);

			txtDireccion = new JTextField();
			pnlProveedor.add(txtDireccion);
			txtDireccion.setBounds(80, 104, 443, 21);

			lblBanco = new JLabel();
			pnlProveedor.add(lblBanco);
			lblBanco.setText("Banco:");
			lblBanco.setBounds(12, 165, 45, 14);

			lblDireccion = new JLabel();
			pnlProveedor.add(lblDireccion);
			lblDireccion.setText("Direccion:");
			lblDireccion.setBounds(12, 113, 61, 14);

			cboDistrito = new JComboBox();
			cboDistrito.addItem("DISTRITO");
			pnlProveedor.add(cboDistrito);
			
			cboDistrito.setBounds(629, 47, 180, 21);

			cboDepartamento = new JComboBox();
			pnlProveedor.add(cboDepartamento);
			cboDepartamento.addItem("DEPARTAMENTO");
			cboDepartamento.setBounds(110, 47, 159, 21);
			cboDepartamento.addActionListener(this);

			cboProvincia = new JComboBox();
			pnlProveedor.add(cboProvincia);

			cboProvincia.addItem("PROVINCIA");
			cboProvincia.setBounds(360, 47, 171, 21);
			cboProvincia.addActionListener(this);

			cboTipo = new JComboBox();
			pnlProveedor.add(cboTipo);
			cboTipo.addItem("");
			cboTipo.addItem("IMPORTADOR");
			cboTipo.addItem("FABRICANTE");
			cboTipo.addItem("COMERCIANTE");
			cboTipo.setBounds(789, 20, 118, 21);

			lblDistrito = new JLabel();
			pnlProveedor.add(lblDistrito);
			lblDistrito.setText("Distrito:");
			lblDistrito.setBounds(562, 50, 55, 14);

			lblProvincia = new JLabel();
			pnlProveedor.add(lblProvincia);
			lblProvincia.setText("Provincia:");
			lblProvincia.setBounds(294, 50, 59, 14);

			lblDepartamento = new JLabel();
			pnlProveedor.add(lblDepartamento);
			lblDepartamento.setText("Departamento:");
			lblDepartamento.setBounds(11, 50, 87, 14);

			lblTipo = new JLabel();
			pnlProveedor.add(lblTipo);
			lblTipo.setText("Tipo:");
			lblTipo.setBounds(741, 23, 36, 14);

			txtRuc = new JTextField();
			pnlProveedor.add(txtRuc);
			txtRuc.setBounds(594, 20, 135, 21);

			lblRuc = new JLabel();
			pnlProveedor.add(lblRuc);
			lblRuc.setText("Ruc:");
			lblRuc.setBounds(556, 20, 35, 21);

			txtNombre = new JTextField();
			pnlProveedor.add(txtNombre);
			txtNombre.setBounds(76, 19, 468, 21);
			txtNombre.addKeyListener(this);

			lblNombre = new JLabel();
			pnlProveedor.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(12, 22, 64, 14);

			scrObservacion = new JScrollPane();
			pnlProveedor.add(scrObservacion);
			scrObservacion.setBounds(84, 211, 667, 33);

			txtAObservacion = new JTextArea();
			scrObservacion.setViewportView(txtAObservacion);
			txtAObservacion.setBounds(100, 239, 496, 49);
			txtAObservacion.setPreferredSize(new java.awt.Dimension(658, 26));

			pnlContacto = new JPanel();
			pnlProveedor.add(pnlContacto);
			pnlContacto.setBorder(BorderFactory.createTitledBorder("Datos Contacto"));
			pnlContacto.setBounds(8, 273, 776, 116);
			pnlContacto.setLayout(null);

			lblTelefono2 = new JLabel();
			pnlProveedor.add(lblTelefono2);
			lblTelefono2.setText("Telefono 2:");
			lblTelefono2.setBounds(730, 107, 64, 14);

			btnBorrarTodo = new JButton();
			pnlProveedor.add(btnBorrarTodo);
			btnBorrarTodo.setText("Borrar");
			btnBorrarTodo.setBounds(801, 131, 115, 23);

			lblPersonal = new JLabel();
			pnlProveedor.add(lblPersonal);
			lblPersonal.setText("Personal");
			lblPersonal.setBounds(11, 76, 69, 16);

			txtPersonal = new JTextField();
			pnlProveedor.add(txtPersonal);
			txtPersonal.setBounds(92, 73, 568, 23);

			
			cboSexo = new JComboBox();
			pnlProveedor.add(cboSexo);
			cboSexo.addItem("¿?");
			cboSexo.addItem("Masculino");
			cboSexo.addItem("Femenino");
			cboSexo.setBounds(732, 73, 175, 23);

			lblSexo = new JLabel();
			pnlProveedor.add(lblSexo);
			lblSexo.setText("Sexo:");
			lblSexo.setBounds(667, 76, 63, 16);

			btnAgregar = new JButton();
			pnlProveedor.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(813, 209, 95, 23);

			btnModificar = new JButton();
			pnlProveedor.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(813, 234, 95, 23);

			btnEliminar = new JButton();
			pnlProveedor.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(813, 259, 95, 23);

			btnBuscar = new JButton();
			pnlProveedor.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(813, 284, 95, 23);

			btnListar = new JButton();
			pnlProveedor.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(813, 309, 95, 23);

			cboRubro = new JComboBox();
			pnlProveedor.add(cboRubro);
			cboRubro.addItem("");
			cboRubro.setBounds(709, 184, 199, 21);
			cboRubro.addActionListener(this);

			lblRubro = new JLabel();
			pnlProveedor.add(lblRubro);
			lblRubro.setText("Rubro:");
			lblRubro.setBounds(648, 187, 43, 16);

			btnEnviar = new JButton();
			pnlProveedor.add(btnEnviar);
			btnEnviar.setText("E");
			btnEnviar.setBounds(767, 209, 41, 23);

			chkRubro = new JCheckBox();
			pnlProveedor.add(chkRubro);
			chkRubro.setBounds(687, 186, 21, 21);

			btnRuc = new JButton();
			pnlProveedor.add(btnRuc);
			btnRuc.setText(" Ruc");
			btnRuc.setBounds(813, 334, 95, 26);
			btnRuc.setSize(95, 23);

			lblCondiciones = new JLabel();
			pnlProveedor.add(lblCondiciones);
			lblCondiciones.setText("Condiciones:");
			lblCondiciones.setBounds(6, 250, 80, 16);

			lblTiempo = new JLabel();
			pnlProveedor.add(lblTiempo);
			lblTiempo.setText("T.Entrega:");
			lblTiempo.setBounds(307, 250, 60, 16);

			lblLugarEntrega = new JLabel();
			pnlProveedor.add(lblLugarEntrega);
			lblLugarEntrega.setText("L. Entrega:");
			lblLugarEntrega.setBounds(512, 253, 68, 16);

			cboCondicion = new JComboBox();
			pnlProveedor.add(cboCondicion);
			cboCondicion.addItem("");
			cboCondicion.addItem("CHEQUE DIFERIDO");
			cboCondicion.addItem("CONTADO");
			cboCondicion.addItem("LETRA 30 DIAS");
			cboCondicion.setBounds(86, 250, 209, 25);
			cboCondicion.setSize(209, 21);

			cboLugarEntrega = new JComboBox();
			pnlProveedor.add(cboLugarEntrega);
			cboLugarEntrega.addItem("");
			cboLugarEntrega.addItem("EN SUS ALMACENES");
			cboLugarEntrega.addItem("LLEVAR A AGENCIA");
			cboLugarEntrega.addItem("TRAER A NUESTRA OFICINA");
			cboLugarEntrega.setBounds(577, 251, 207, 21);

			cboTiempoEntrega = new JComboBox();
			pnlProveedor.add(cboTiempoEntrega);
			cboTiempoEntrega.addItem("");
			cboTiempoEntrega.addItem("INMEDIATA");
			cboTiempoEntrega.addItem("FABRICACION");
			cboTiempoEntrega.setBounds(367, 251, 135, 21);

			btnMovistar = new JButton();
			pnlProveedor.add(btnMovistar);
			btnMovistar.setText("Directorio RPM");
			btnMovistar.setBounds(789, 360, 119, 26);
			btnMovistar.setSize(119, 23);

			cboMarcas = new JComboBox();
			pnlProveedor.add(cboMarcas);
			cboMarcas.setBounds(742, 159, 174, 21);
			cboMarcas.addItem("");
			cboMarcas.addActionListener(this);

			lblMarcas = new JLabel();
			pnlProveedor.add(lblMarcas);
			lblMarcas.setText("Marcas:");
			lblMarcas.setBounds(673, 160, 53, 16);

			chkMarcas = new JCheckBox();
			pnlProveedor.add(chkMarcas);
			chkMarcas.setBounds(719, 159, 19, 21);

			btnPromelsa = new JButton();
			btnPromelsa.setText("Web Promelsa");
			btnPromelsa.setBounds(790, 386, 118, 23);
			btnPromelsa.addActionListener(this);
			
			btnModProveMar = new JButton();
			pnlProveedor.add(btnModProveMar);
			pnlProveedor.add(btnPromelsa);
			btnModProveMar.setText("Mantenimiento ProveMarcas");
			btnModProveMar.setBounds(711, 391, 197, 23);
			btnModProveMar.setVisible(false);
			btnModProveMar.addActionListener(this);

			btnMovistar.addActionListener(this);

			btnRuc.addActionListener(this);

			btnEnviar.addActionListener(this);

			btnListar.addActionListener(this);

			btnBuscar.addActionListener(this);

			btnEliminar.addActionListener(this);

			btnModificar.addActionListener(this);

			btnAgregar.addActionListener(this);

			btnBorrarTodo.addActionListener(this);

			lblNombreC = new JLabel();
			pnlContacto.add(lblNombreC);
			lblNombreC.setText("Nombre:");
			lblNombreC.setBounds(8, 19, 60, 14);

			lblCargoC = new JLabel();
			pnlContacto.add(lblCargoC);
			lblCargoC.setText("Cargo:");
			lblCargoC.setBounds(453, 18, 45, 18);

			txtNombreC = new JTextField();
			pnlContacto.add(txtNombreC);
			txtNombreC.setBounds(68, 17, 378, 21);
			
			cboCargoC = new JComboBox();
			pnlContacto.add(cboCargoC);
			cboCargoC.addItem("");
			cboCargoC.addItem("VENTAS");
			cboCargoC.addItem("ALMACEN");
			cboCargoC.addItem("ADMINISTRADOR");
			cboCargoC.addItem("GERENTE");
			cboCargoC.addItem("TRANSPORTISTA");
			cboCargoC.addItem("CONTADOR");
			cboCargoC.setBounds(496, 17, 91, 21);

			lblCelularC = new JLabel();
			pnlContacto.add(lblCelularC);
			lblCelularC.setText("Celular:");
			lblCelularC.setBounds(10, 44, 58, 14);

			txtCelularC = new JTextField();
			pnlContacto.add(txtCelularC);
			txtCelularC.setBounds(68, 41, 127, 21);

			lblObservacionC = new JLabel();
			pnlContacto.add(lblObservacionC);
			lblObservacionC.setText("Observacion:");
			lblObservacionC.setBounds(5, 71, 84, 14);

			scrObservacionC = new JScrollPane();
			pnlContacto.add(scrObservacionC);
			scrObservacionC.setBounds(83, 68, 685, 42);

			lblTelefono = new JLabel();
			pnlContacto.add(lblTelefono);
			lblTelefono.setText("Telefono:");
			lblTelefono.setBounds(590, 19, 62, 16);

			txtTelefono = new JTextField();
			pnlContacto.add(txtTelefono);
			txtTelefono.setBounds(653, 15, 115, 23);

			jLabel1 = new JLabel();
			pnlContacto.add(jLabel1);
			jLabel1.setText("Nextel:");
			jLabel1.setBounds(195, 43, 44, 16);

			jLabel2 = new JLabel();
			pnlContacto.add(jLabel2);
			jLabel2.setText("Rpm:");
			jLabel2.setBounds(329, 43, 40, 16);

			jLabel3 = new JLabel();
			pnlContacto.add(jLabel3);
			jLabel3.setText("Email:");
			jLabel3.setBounds(466, 44, 44, 16);

			jTextField3 = new JTextField();
			pnlContacto.add(jTextField3);
			jTextField3.setBounds(516, 41, 252, 23);

			txtNexC = new JTextField();
			pnlContacto.add(txtNexC);
			txtNexC.setBounds(239, 41, 78, 20);
			txtNexC.setSize(78, 21);

			txtRpmC = new JTextField();
			pnlContacto.add(txtRpmC);
			txtRpmC.setBounds(363, 41, 86, 20);
			txtRpmC.setSize(86, 21);

			txtAObservacionC = new JTextArea();
			scrObservacionC.setViewportView(txtAObservacionC);
			txtAObservacionC.setBounds(325, 46, 480, 27);
			txtAObservacionC.setPreferredSize(new java.awt.Dimension(370, 39));

			cargarRubro();
			cargarMarcas();
			listaDepartamento();
			listarCliente();
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/********LISTAR CLIENTES************************/
	public void listarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS, 
		 * PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, 
		 * TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, FAX_PROVE, 
		 * MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, 
		 * CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
		/*String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS",
				"PER_PROVE", "SEX_PROVE","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
				"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE",
				"OBS_PROVE","NOMC_PROVE","CARC_PROVE","TELC_PROVE","CELC_PROVE","MAILC_PROVE","RPMC_PROVE",
				"NEXC_PROVE","OBSC_PROVE"};*/
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS," +
				" PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, " +																				
				"TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, "+
		" FAX_PROVE, MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, " +
		"CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE,CONDI_PROVE,LUGENTRE_PROVE,TIEMPENTRE_PROVE FROM tb_proveedor WHERE EST_PROVE='ACTIVADO'";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {//
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),
						rs.getString(19),rs.getString(20),rs.getString(21),
						rs.getString(22),rs.getString(23),rs.getString(24),
						rs.getString(25),rs.getString(26),rs.getString(27),
						rs.getString(28),rs.getString(29),rs.getString(30),
						rs.getString(31),rs.getString(32),rs.getString(33)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	/********BUSCAR CLIENTES************************/
	public void buscarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		String NOM_PROVE=txtNombre.getText(),RUC_PROVE=txtRuc.getText(),PER_PROVE=txtPersonal.getText(),DIR_PROVE=txtDireccion.getText(),
		TEL1_PROVE=txtTelefono1.getText(),TEL2_PROVE=txtTelefono2.getText(),CEL_PROVE=txtCelular.getText(),FAX_PROVE=txtFax.getText(),
		RPM_PROVE=txtRpm.getText(),NEX_PROVE=txtNextel.getText(),NCUS_PROVE=txtCuentaSolea.getText(),NCUD_PROVE=txtCuentaDolares.getText(),
		MAIL_PROVE=txtEmail.getText(),WEB_PROVE=txtWeb.getText(),NOMC_PROVE=txtNombreC.getText(),TELC_PROVE=txtTelefono.getText(),
		CELC_PROVE=txtCelularC.getText(),NEXC_PROVE=txtNexC.getText(),RPMC_PROVE=txtRpmC.getText(),MAILC_PROVE=jTextField3.getText();
		/*
		String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
				"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE","OBS_PROVE","EST_PROVE","NOMC_PROVE","CARC_PROVE","CELC_PROVE","OBSC_PROVE"};
		*/
		String sql="SELECT COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS," +
		" PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, " +
		"TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, "+
		" FAX_PROVE, MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, " +
		" CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE,CONDI_PROVE,LUGENTRE_PROVE,TIEMPENTRE_PROVE FROM tb_proveedor WHERE " +
		" NOM_PROVE LIKE '%"+NOM_PROVE+"%' AND RUC_PROVE LIKE '%"+RUC_PROVE+"%' AND PER_PROVE LIKE '%"+PER_PROVE+"%' AND DIR_PROVE LIKE '%"+DIR_PROVE+"%' "+
        " AND TEL1_PROVE LIKE '%"+TEL1_PROVE+"%' AND TEL2_PROVE LIKE '%"+TEL2_PROVE+"%' AND CEL_PROVE LIKE '%"+CEL_PROVE+"%' AND FAX_PROVE LIKE '%"+FAX_PROVE+"%' "+
        " AND RPM_PROVE LIKE '%"+RPM_PROVE+"%' AND NEX_PROVE LIKE '%"+NEX_PROVE+"%' AND NCUS_PROVE LIKE '%"+NCUS_PROVE+"%' AND NCUD_PROVE LIKE '%"+NCUD_PROVE+"%' "+
        " AND MAIL_PROVE LIKE '%"+MAIL_PROVE+"%' AND WEB_PROVE LIKE '%"+WEB_PROVE+"%' AND NOMC_PROVE LIKE '%"+NOMC_PROVE+"%' AND TELC_PROVE LIKE '%"+TELC_PROVE+"%' "+
        " AND CELC_PROVE LIKE '%"+CELC_PROVE+"%' AND NEXC_PROVE LIKE '%"+NEXC_PROVE+"%' AND RPMC_PROVE LIKE '%"+RPMC_PROVE+"%' AND MAILC_PROVE LIKE '%"+MAILC_PROVE+"%' "+
        " AND EST_PROVE='ACTIVADO';" ;
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),
						rs.getString(19),rs.getString(20),rs.getString(21),
						rs.getString(22),rs.getString(23),rs.getString(24),
						rs.getString(25),rs.getString(26),rs.getString(27),
						rs.getString(28),rs.getString(29),rs.getString(30),
						rs.getString(31),rs.getString(32),rs.getString(33)
				};
						
				modelo2.addRow(obj);
				
				
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	
	/********ELIMINAR CLIENTE**********************/
	public void eliminarCliente(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String est="DESACTIVADO";
		String sql="UPDATE tb_proveedor SET EST_PROVE='"+est+"'  WHERE COD_PROVE="+cod1+";";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al eliminar el proveedor");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a eliminado  el proveedor");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS eliminar proveedor !!!!!!!");}
		
		objAccesoBD.cerrarConexion();	
		listarCliente();
	}
	
	/***********************************************/
	/********MODIFICAR CLIENTE**********************/
	public void modificarCliente(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS, 
		 * PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, 
		 * TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, FAX_PROVE, 
		 * MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, 
		 * CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
		/*String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS",
				"PER_PROVE", "SEX_PROVE","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
				"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE",
				"OBS_PROVE","NOMC_PROVE","CARC_PROVE","TELC_PROVE","CELC_PROVE","MAILC_PROVE","RPMC_PROVE","NEXC_PROVE","OBSC_PROVE"};*/
		String COD_DEP=(String)cboDepartamento.getSelectedItem(),COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
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
			String sql="UPDATE tb_proveedor SET NOM_PROVE='"+txtNombre.getText()+"' , " +
				"RUC_PROVE='"+txtRuc.getText()+"' , TIP_PROVE='"+(String)cboTipo.getSelectedItem()+"' , "+
				"COD_DEP='"+COD_DEP+"' , COD_PRO='"+COD_PRO+"' , "+
				"COD_DIS='"+COD_DIS+"' , DIR_PROVE='"+txtDireccion.getText()+"' , "+
				"PER_PROVE='"+txtPersonal.getText()+"' , SEX_PROVE='"+cboSexo.getSelectedIndex()+"' , "+
				"BAN_PROVE='"+(String)cboBanco.getSelectedItem()+"' , NCUD_PROVE='"+txtCuentaDolares.getText()+"' , "+
				"NCUS_PROVE='"+txtCuentaSolea.getText()+"' , TEL1_PROVE='"+txtTelefono1.getText()+"' , "+
				"TEL2_PROVE='"+txtTelefono2.getText()+"' , RPM_PROVE='"+txtRpm.getText()+"' , "+
				"NEX_PROVE='"+txtNextel.getText()+"' , CEL_PROVE='"+txtCelular.getText()+"' , "+
				"FAX_PROVE='"+txtFax.getText()+"' , MAIL_PROVE='"+txtEmail.getText()+"' , "+
				"WEB_PROVE='"+txtWeb.getText()+"' , OBS_PROVE='"+txtAObservacion.getText()+"',  "+
				"NOMC_PROVE='"+txtNombreC.getText()+"' , CARC_PROVE='"+(String)cboCargoC.getSelectedItem()+"',  "+
				"TELC_PROVE='"+txtTelefono.getText()+"' , CELC_PROVE='"+txtCelularC.getText()+"',  "+
				"MAILC_PROVE='"+jTextField3.getText()+"' , RPMC_PROVE='"+txtRpmC.getText()+"',  "+
				"NEXC_PROVE='"+txtNexC.getText()+"' , OBSC_PROVE='"+txtAObservacionC.getText()+"', " +
				"CONDI_PROVE='"+(String)cboCondicion.getSelectedItem()+"', LUGENTRE_PROVE='"+(String)cboLugarEntrega.getSelectedItem()+"', " +
				"TIEMPENTRE_PROVE='"+(String)cboTiempoEntrega.getSelectedItem()+"' "+
				" WHERE COD_PROVE='"+cod1+"';";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al modificar el proveedor");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se modifico al proveedor");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar proveedor !!!!!!!");}
		 
		objAccesoBD.cerrarConexion();	
		}
		
		listarCliente();
	}
	
	/***********************************************/
	/********AGREGAR CLIENTE************************/
	public void agregarCliente(){
		
		/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS, 
		 * PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, 
		 * TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, FAX_PROVE, 
		 * MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, 
		 * CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
		/*String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS",
				"PER_PROVE", "SEX_PROVE","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
				"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE",
				"OBS_PROVE","NOMC_PROVE","CARC_PROVE","TELC_PROVE","CELC_PROVE","MAILC_PROVE","RPMC_PROVE","NEXC_PROVE","OBSC_PROVE"};*/
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_PROVE=txtNombre.getText(),RUC_PROVE=txtRuc.getText(),
		TIP_PROVE=(String) cboTipo.getSelectedItem(),DIR_PROVE=txtDireccion.getText(),BAN_PROVE=(String)cboBanco.getSelectedItem(),NCUD_PROVE=txtCuentaDolares.getText(),NCUS_PROVE=txtCuentaSolea.getText(),
		TEL1_PROVE=txtTelefono1.getText(),TEL2_PROVE=txtTelefono2.getText(),RPM_PROVE=txtRpm.getText(),NEX_PROVE=txtNextel.getText(),CEL_PROVE=txtCelular.getText(),
		FAX_PROVE=txtFax.getText(),MAIL_PROVE=txtEmail.getText(),WEB_PROVE=txtWeb.getText(),OBS_PROVE=txtAObservacion.getText(),NOMC_PROVE=txtNombreC.getText(),CARC_PROVE=(String)cboCargoC.getSelectedItem(),
		CELC_PROVE=txtCelularC.getText(),OBSC_PROVE=txtAObservacionC.getText(),EST_PROVE="ACTIVADO",
		PER_PROVE=txtPersonal.getText(),TELC_PROVE=txtTelefono.getText(),MAILC_PROVE=jTextField3.getText(),RPMC_PROVE=txtRpmC.getText(),NEXC_PROVE=txtNexC.getText(),
		CONDI_PROVE=(String)cboCondicion.getSelectedItem(),LUGENTRE_PROVE=(String)cboLugarEntrega.getSelectedItem(),TIEMPENTRE_PROVE=(String)cboTiempoEntrega.getSelectedItem();
		Integer SEX_PROVE=cboSexo.getSelectedIndex();
		
		String COD_DEP=(String) cboDepartamento.getSelectedItem(),
		COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
		
		boolean valor;
		if(COD_DEP.equals("DEPARTAMENTO")||COD_DEP==null||COD_PRO.equals("PROVINCIA")||COD_PRO==null||COD_DIS.equals("DISTRITO")|COD_DIS==null){
			JOptionPane.showInternalMessageDialog(this, "!Porfavor Ingrese un Departamento¡ \n Si no tiene ponga VACIO",
					"Precaucion", JOptionPane.WARNING_MESSAGE);
			valor=true;
		}else{
			COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1, COD_DEP.length());COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1, COD_PRO.length());COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1, COD_DIS.length());
			
			valor=false;
		}
		
		if(valor==false){
			String insertarPregunta="INSERT INTO tb_proveedor VALUES("+null+",'"+NOM_PROVE+"','"
			+RUC_PROVE+"','"+TIP_PROVE+"','"+COD_DEP+"','"+COD_PRO+"','"+COD_DIS+"','"+PER_PROVE+"','"+SEX_PROVE+"','"+DIR_PROVE+"','"+BAN_PROVE+"','"
			+NCUD_PROVE+"','"+NCUS_PROVE+"','"+TEL1_PROVE+"','"+TEL2_PROVE+"','"+RPM_PROVE+"','"+NEX_PROVE+"','"+CEL_PROVE+"','"+
			FAX_PROVE+"','"+MAIL_PROVE+"','"+WEB_PROVE+"','"+OBS_PROVE+"','"+NOMC_PROVE+"','"+CARC_PROVE+"','"+TELC_PROVE+"','"+CELC_PROVE+"','"+
			MAILC_PROVE+"','"+RPMC_PROVE+"','"+NEXC_PROVE+"','"+OBSC_PROVE+"','"+EST_PROVE+"','"+CONDI_PROVE+"','"+LUGENTRE_PROVE+"','"+TIEMPENTRE_PROVE+"')";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un error al agregar el proveedor");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
			else{
				objGUI.mostrarAviso("Se agrego al proveedor");
				System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar proveedor !!!!!!!");}
			//objAccesoBD.cerrarConexion();
		objAccesoBD.cerrarConexion();
		}
		
		listarCliente();
	}
	/***********************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarlistaCliente(){
		limpiarComboBanco();
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		//Cargar los datos de la fila seleccionada al panel de datos
		int cod= Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		  cod1=cod;
 
		 /*
String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE","OBS_PROVE","EST_PROVE","NOMC_PROVE","CARC_PROVE","CELC_PROVE","OBSC_PROVE"};
		*/
			/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, COD_DIS, 
			 * PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, NCUS_PROVE, 
			 * TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, FAX_PROVE, 
			 * MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, TELC_PROVE, 
			 * CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
			/*String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS",
					"PER_PROVE", "SEX_PROVE","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
					"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE",
					"OBS_PROVE","NOMC_PROVE","CARC_PROVE","TELC_PROVE","CELC_PROVE","MAILC_PROVE","RPMC_PROVE","NEXC_PROVE","OBSC_PROVE"};*/
			
		txtNombre.setText((String)modelo2.getValueAt(fila, 1));
		txtRuc.setText((String)modelo2.getValueAt(fila,2));
		cboTipo.setSelectedItem(modelo2.getValueAt(fila,3));
		
		cargarComboBox((String)modelo2.getValueAt(fila,4), (String)modelo2.getValueAt(fila,5),(String) modelo2.getValueAt(fila,6));
		txtPersonal.setText((String)modelo2.getValueAt(fila, 7));
		cboSexo.setSelectedIndex(Integer.parseInt(""+modelo2.getValueAt(fila, 8)));
		txtDireccion.setText((String)modelo2.getValueAt(fila, 9));
		cboBanco.setSelectedItem(modelo2.getValueAt(fila,10));
		txtCuentaDolares.setText((String)modelo2.getValueAt(fila, 11));
		txtCuentaSolea.setText((String)modelo2.getValueAt(fila, 12));
		txtTelefono1.setText((String)modelo2.getValueAt(fila, 13));
		txtTelefono2.setText((String)modelo2.getValueAt(fila, 14));
		txtRpm.setText((String)modelo2.getValueAt(fila, 15));
		txtNextel.setText((String)modelo2.getValueAt(fila, 16));
		txtCelular.setText((String)modelo2.getValueAt(fila, 17));
		txtFax.setText((String)modelo2.getValueAt(fila, 18));
		txtEmail.setText((String)modelo2.getValueAt(fila, 19));
		txtWeb.setText((String)modelo2.getValueAt(fila, 20));
		txtAObservacion.setText((String)modelo2.getValueAt(fila, 21));
		txtNombreC.setText((String)modelo2.getValueAt(fila, 22));
		cboCargoC.setSelectedItem(modelo2.getValueAt(fila,23));
		txtTelefono.setText((String)modelo2.getValueAt(fila, 24));
		txtCelularC.setText((String)modelo2.getValueAt(fila, 25));
		jTextField3.setText((String)modelo2.getValueAt(fila, 26));
		txtRpmC.setText((String)modelo2.getValueAt(fila, 27));
		txtNexC.setText((String)modelo2.getValueAt(fila, 28));
		txtAObservacionC.setText((String)modelo2.getValueAt(fila, 29));
		cboCondicion.setSelectedItem(modelo2.getValueAt(fila,30));
		cboLugarEntrega.setSelectedItem(modelo2.getValueAt(fila,31));
		cboTiempoEntrega.setSelectedItem(modelo2.getValueAt(fila,32));
		
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
			
			//SELECT * FROM ubigeo WHERE COD_DEP='15' AND COD_PRO='01' AND COD_DIS!='00';
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
			objGUI.mostrarAviso("Porfavor Elige un DEPARTAMENTO");
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
	
	public void cargarRubro(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_rubro WHERE EST_RUBRO='ACTIVADO' order by nom_rubro asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboRubro.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	/***************************************************************************************************************/
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_marcas WHERE EST_MAR='ACTIVADO' order by nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboMarcas.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	/**************************************************************************************************************/
	public void buscarPorRubro(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length());
		//codiRubro=Integer.parseInt(codRubro);
		//nomRubro=nomRubro.substring(nomRubro.indexOf("-")+1,nomRubro.length() );
		String sql="SELECT  PROVE.COD_PROVE,PROVE.NOM_PROVE,PROVE.RUC_PROVE, PROVE.TIP_PROVE, PROVE.COD_DEP, PROVE.COD_PRO, PROVE.COD_DIS, "+
		 "PROVE.PER_PROVE, PROVE.SEX_PROVE, PROVE.DIR_PROVE, PROVE.BAN_PROVE, PROVE.NCUD_PROVE, PROVE.NCUS_PROVE, "+
		 "PROVE.TEL1_PROVE, PROVE.TEL2_PROVE, PROVE.RPM_PROVE, PROVE.NEX_PROVE, PROVE.CEL_PROVE, "+
		 "PROVE.FAX_PROVE, PROVE.MAIL_PROVE, PROVE.WEB_PROVE, PROVE.OBS_PROVE, PROVE.NOMC_PROVE, PROVE.CARC_PROVE, PROVE.TELC_PROVE, "+
		 "PROVE.CELC_PROVE, PROVE.MAILC_PROVE, PROVE.RPMC_PROVE, PROVE.NEXC_PROVE, PROVE.OBSC_PROVE, PROVE.CONDI_PROVE, PROVE.LUGENTRE_PROVE, PROVE.TIEMPENTRE_PROVE "+
		 "FROM TB_PROVERUBMAR PROVERUB "+
		 "INNER JOIN tb_proveedor PROVE "+
         "ON PROVERUB.cod_prove = PROVE.COD_PROVE "+
         "WHERE  PROVERUB.est_proverubmar='ACTIVADO' AND PROVERUB.cod_rubro = '"+codRubro+"' and prove.est_prove='ACTIVADO' "+
		 "GROUP BY PROVE.NOM_PROVE;";
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),
						rs.getString(19),rs.getString(20),rs.getString(21),
						rs.getString(22),rs.getString(23),rs.getString(24),
						rs.getString(25),rs.getString(26),rs.getString(27),
						rs.getString(28),rs.getString(29),rs.getString(30),
						rs.getString(31),rs.getString(32),rs.getString(33)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		objAccesoBD.cerrarConexion();
	}
	/*************************************************************************************************************************************/
	public void buscarPorMarcas(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String codMar=""+cboMarcas.getSelectedItem();
		codMar=codMar.substring(codMar.indexOf("-")+1,codMar.length());
		//codiMarca=Integer.parseInt(codMar);
		//nomRubro=nomRubro.substring(nomRubro.indexOf("-")+1,nomRubro.length() );
		String sql="SELECT  PROVE.COD_PROVE,PROVE.NOM_PROVE,PROVE.RUC_PROVE, PROVE.TIP_PROVE, PROVE.COD_DEP, PROVE.COD_PRO, PROVE.COD_DIS, "+
		 "PROVE.PER_PROVE, PROVE.SEX_PROVE, PROVE.DIR_PROVE, PROVE.BAN_PROVE, PROVE.NCUD_PROVE, PROVE.NCUS_PROVE, "+
		 "PROVE.TEL1_PROVE, PROVE.TEL2_PROVE, PROVE.RPM_PROVE, PROVE.NEX_PROVE, PROVE.CEL_PROVE, "+
		 "PROVE.FAX_PROVE, PROVE.MAIL_PROVE, PROVE.WEB_PROVE, PROVE.OBS_PROVE, PROVE.NOMC_PROVE, PROVE.CARC_PROVE, PROVE.TELC_PROVE, "+
		 "PROVE.CELC_PROVE, PROVE.MAILC_PROVE, PROVE.RPMC_PROVE, PROVE.NEXC_PROVE, PROVE.OBSC_PROVE, PROVE.CONDI_PROVE, PROVE.LUGENTRE_PROVE, PROVE.TIEMPENTRE_PROVE "+
		 "FROM TB_PROVERUBMAR PROVEMAR "+
		 "INNER JOIN tb_proveedor PROVE "+
		 "ON PROVEMAR.cod_prove = PROVE.COD_PROVE "+
		 "WHERE  PROVEMAR.est_proverubmar='ACTIVADO' AND PROVEMAR.cod_mar = '"+codMar+"' and prove.est_prove='ACTIVADO' "+
		 "GROUP BY PROVE.NOM_PROVE;";
		 
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getString(13),rs.getString(14),rs.getString(15),
						rs.getString(16),rs.getString(17),rs.getString(18),
						rs.getString(19),rs.getString(20),rs.getString(21),
						rs.getString(22),rs.getString(23),rs.getString(24),
						rs.getString(25),rs.getString(26),rs.getString(27),
						rs.getString(28),rs.getString(29),rs.getString(30),
						rs.getString(31),rs.getString(32),rs.getString(33)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		objAccesoBD.cerrarConexion();
	}
	/*********************************************************************************************************************/
	public boolean guardarLosCorreos(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		boolean valor = true;
		objServlet= new ServletEnvioProveedor();
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			Object obj=modelo2.getValueAt(i, 0);
			String sql="SELECT COD_PROVE,PER_PROVE,NOM_PROVE,SEX_PROVE,MAIL_PROVE," +
					"MAILC_PROVE FROM tb_proveedor WHERE COD_PROVE='"+obj+"' and EST_PROVE='ACTIVADO'";
			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				if(rs.next()){
		BeanEnvioProveedor objbean= 
		new BeanEnvioProveedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					
		objServlet.adicionar(objbean);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		System.out.println("tam:"+objServlet.tamaño());
		if(objServlet==null)
			valor=false;
		else
			valor=true;
		
		
		
		return valor;
	}
	
	/********AGREGAR RUBRO Y MARCA AL PROVEEDOR************************/
	
    public void agregarRubroYMarcaProveedor(){
 		 
    	try {
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			int CODPROVE=retornaUltimoCodProve();
			String COD_RUBRO=""+cboRubro.getSelectedItem(),EST_PROVERUBRO="ACTIVADO";
			String COD_MARCA=""+cboMarcas.getSelectedItem();
			
			if(COD_RUBRO.equals("")){
				COD_RUBRO="56";
	 		}else{
	 			COD_RUBRO=COD_RUBRO.substring(COD_RUBRO.indexOf("-")+1,COD_RUBRO.length());
	 		}

	 		
	 		if(COD_MARCA.equals("")){
	 			COD_MARCA="1";
	 		}else{
	 			COD_MARCA=COD_MARCA.substring(COD_MARCA.indexOf("-")+1,COD_MARCA.length());
	 		}
	 		
	 		String insertarPregunta="INSERT INTO tb_proverubmar(cod_prove, cod_rubro, cod_mar, est_proverubmar)" +
	 					" VALUES('"+CODPROVE+"','"+COD_RUBRO+"','"+COD_MARCA+"','"+EST_PROVERUBRO+"');";
	 			System.out.println(insertarPregunta);

				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				
				if(op==0){
					objGUI.mostrarAviso("Hubo un ERROR al Imgresar los datos");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
				}	
				else{
					objGUI.mostrarAviso("Se ingreso Correctamente el Rubro");
					System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
				}
				
			objAccesoBD.cerrarConexion();	
		} catch (Exception e) {
			objGUI.mostrarAviso("Debe llenar los datos");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
		}
    	 		
 	}
   /********************************************************************************************************/
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
	/******************************************/

	public void limpiarComboBanco(){
		cboCargoC.setSelectedIndex(0);
		cboBanco.setSelectedIndex(0);
		
	}
	/*******LIMPIAR TODO************************/
	public void limpiarTodo(){
		
		txtNombre.setText("");
		txtRuc.setText("");
		txtPersonal.setText("");
		cboTipo.setSelectedIndex(0);
		cboDepartamento.setSelectedIndex(0);
		cboProvincia.setSelectedIndex(0);
		cboDistrito.setSelectedIndex(0);
		cboSexo.setSelectedIndex(0);
		txtDireccion.setText("");
		cboBanco.setSelectedIndex(0);
		txtCuentaDolares.setText("");
		txtCuentaSolea.setText("");
		txtTelefono1.setText("");
		txtTelefono2.setText("");
		txtTelefono.setText("");
		txtRpm.setText("");
		txtRpmC.setText("");
		txtNextel.setText("");
		txtNexC.setText("");
		txtCelular.setText("");
		txtFax.setText("");
		txtEmail.setText("");
		txtWeb.setText("");
		txtAObservacion.setText("");
		txtNombreC.setText("");
		cboCargoC.setSelectedIndex(0);
		txtCelularC.setText("");
		txtAObservacionC.setText("");
		cboRubro.setSelectedIndex(0);
        jTextField3.setText("");
        chkRubro.setSelected(false);
        cboCondicion.setSelectedIndex(0);
        cboLugarEntrega.setSelectedIndex(0);
        cboTiempoEntrega.setSelectedIndex(0);
        cboMarcas.setSelectedIndex(0);
        chkMarcas.setSelected(false);
        listarCliente();
        
	}
	/*******************************************/
	public  String rutaArchivo(){
		
		try {
			String nomdia=objFecha.fechaActual4();
			String carpeta = "";
			Propiedades p=new Propiedades();
			
			if(nomdia.equals("lun")){
				carpeta = (p.getProperty("proveedor")).trim()+"lunes";
			}else if(nomdia.equals("mar")){
				carpeta = (p.getProperty("proveedor")).trim()+"martes";
			}else if(nomdia.equals("mié")){
				carpeta = (p.getProperty("proveedor")).trim()+"miercoles";
			}else if(nomdia.equals("jue")){
				carpeta = (p.getProperty("proveedor")).trim()+"jueves";
			}else if(nomdia.equals("vie")){
				carpeta = (p.getProperty("proveedor")).trim()+"viernes";
			}else if(nomdia.equals("sáb")){
				carpeta = (p.getProperty("proveedor")).trim()+"sabado";
			}else{
				carpeta = (p.getProperty("proveedor")).trim()+"domingo";
			}

		return carpeta;
		
		} catch (Exception e) {
			   System.out.println("NADAAAA");
		}
		return "";

	}
	
	public void RubroMarca(){
		
		if(chkRubro.isSelected()){
			String codRubro=""+cboRubro.getSelectedItem();
			codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length());
			codiRubro=Integer.parseInt(codRubro);
		}else{
			codiRubro=56;
		}
		
		
		if(chkMarcas.isSelected()){
			String codMar=""+cboMarcas.getSelectedItem();
			codMar=codMar.substring(codMar.indexOf("-")+1,codMar.length());
			codiMarca=Integer.parseInt(codMar);
		}else{
			codiMarca=1;
		}
	}
		
		/****************************************************************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cboDepartamento){
			listaProvincias();
		}
		if(e.getSource()==cboProvincia){
			listaDistrito();
		}
		if(e.getSource()==btnAgregar){
			agregarCliente();
			agregarRubroYMarcaProveedor();
		}
		if(e.getSource()==btnModificar){
			modificarCliente();
		}
		if(e.getSource()==btnEliminar){
		eliminarCliente();	
		}
		if(e.getSource()==btnBuscar){
			buscarCliente();
		}
		if(e.getSource()==cboDepartamento){
			listaProvincias();
		}
		if(e.getSource()==cboRubro){
			if(chkRubro.isSelected()){
				buscarPorRubro();
			}else{
				//codiRubro=56;
			}
			
		}
		if(e.getSource()==btnListar){
			chkRubro.setSelected(false);
			chkMarcas.setSelected(false);
			cboRubro.setSelectedIndex(0);
			cboMarcas.setSelectedIndex(0);
		listarCliente();	
		}
		if(e.getSource()==btnBorrarTodo){
			limpiarTodo();
		}
		if(e.getSource()==btnEnviar){
			
			RubroMarca();
			guardarLosCorreos();
			System.out.println(objServlet.tamaño());

			if(objEnviarProveedores==null||objEnviarProveedores.isClosed()){
				//objGUI.mostrarAviso("En Construccion.....!!");
				objEnviarProveedores= new EnviarCorreoProveedor();
				objEnviarProveedores.setVisible(true);
				objMenu.jDesktopPane1.add(objEnviarProveedores);
			try{this.setClosed(true);
				}catch(PropertyVetoException e1){e1.printStackTrace();}
			try {objEnviarProveedores.setSelected(true);} catch (java.beans.PropertyVetoException ee) {}
			}
		}
		
		if(e.getSource()==btnRuc){
			
			try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
        }
		if(e.getSource()==btnMovistar){
			try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.movistar.com.pe/directoriorpm/");
			} catch (IOException e1) {
				// TODO Auto-generated catch blockC:\Archivos de programa\Internet Explorer
				e1.printStackTrace();
			}
		}
		if(e.getSource()==cboMarcas){
		
			if(chkMarcas.isSelected()){
				buscarPorMarcas();
			}else{
				//codiMarca=1;
			}
				
		}
		if(e.getSource()==btnModProveMar){
			
			try {
				int fila = jTable1.getSelectedRow();
				
				codprovemar=(Integer) modelo2.getValueAt(fila,0);
				nomprove=""+modelo2.getValueAt(fila,1);
				BuscarMarcaProve objProMar= new BuscarMarcaProve(objMenu);
				
				objProMar.setTitle("Marcas Proveedor");
				objProMar.setVisible(true);
				objProMar.pack(); 
			} catch (Exception e2) {
				objGUI.mostrarAviso("Debe Selecionar un Proveedor");
			}
			
		}
		
        if(e.getSource()==btnPromelsa){
			
			try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.promelsa.com.pe/");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
        }
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==jTable1){
			MouseEvent evento=e;
			if(evento.getClickCount()==1){
				cargarlistaCliente();
				
			}
			if(evento.getClickCount()==2){
                int fila = jTable1.getSelectedRow();
				
				codproverubro=(Integer) modelo2.getValueAt(fila,0);
				nomprove=""+modelo2.getValueAt(fila,1);
				BuscarRubroProve objProRub= new BuscarRubroProve(objMenu);
				
				objProRub.setTitle("Proveedor Rubro Marca");
				objProRub.setVisible(true);
				objProRub.pack(); 
				
			}
		
		}
		
	}
	public void mouseReleased(MouseEvent e) {}


	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()==txtNombre){
			buscarCliente();
			
		}
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	

}
