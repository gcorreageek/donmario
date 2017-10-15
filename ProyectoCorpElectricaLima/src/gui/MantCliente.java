package gui;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.GUI;
import pOp.BuscarRubroCliente;
import pOp.BuscarTipoCliente;
import servlet.ServletEnvioAutoCorreoCliente;
import servlet.ServletEnvioCliente;
import beans.BeanEnvioCliente;
import beans.Globales;

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
public class MantCliente extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JPanel jPanel1;
	private JLabel lblTipoCliente;
	private JLabel lblFax;
	private JTextField txtTelefono2;
	private JTextField txtTelefono1;
	private JLabel lblTelefono1;
	private JTextField txtPersonal;
	private JLabel lblPersona;
	private JButton btnEnviar;
	private JButton btnBienvenida;
	private JButton btnPagBlancas;
	private JButton btnBuscadorElectricos;
	private JComboBox cboAgente;
	private JButton btnMovistar;
	private JTextField txtEstado;
	private JComboBox cboEstado;
	private JTextField txtPNombre;
	private JLabel jLabel4;
	private JTextField txtFecha;
	private JButton btnTipoClien;
	private JButton btnBuscarRuc;
	private JCheckBox chkTipo;
	private JTextField txtRpmC;
	private JLabel jLabel3;
	private JTextField txtNextelC;
	private JLabel lblNextelC;
	private JComboBox cboSexo;
	private JLabel lblSexo;
	private JButton btnLimpiar;
	private JTable jTable1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane1;
	private JPanel pnlLista;
	private JButton btnListar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JTextField txtEmail;
	private JLabel jLabel2;
	private JTextField txtCelular;
	private JLabel jLabel1;
	private JLabel lblObservacion2;
	private JTextArea txtAObservacion2;
	private JScrollPane scrObservacion2;
	private JTextField txtEmailC;
	private JLabel lblEmail;
	private JTextField txtCelularC;
	private JLabel lblCelular;
	private JTextField txtTelefonoC;
	private JLabel lblTelefono;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JScrollPane scrObservacion;
	private JTextArea txtAObservacion;
	private JLabel lblObservacion;
	private JTextField txtNextel;
	private JLabel lblNextel;
	private JTextField txtRpm;
	private JLabel lblRpm;
	private JTextField txtFax;
	private JTextField txtDireccion;
	private JLabel lblDireccion;
	private JComboBox cboDistrito;
	private JLabel lblDistrito;
	private JComboBox cboProvincia;
	private JTextField txtNombreCliente;
	private JLabel lblProvincia;
	private JLabel lblDepartamento;
	private JComboBox cboDepartamento;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JComboBox cboLugar;
	private JComboBox cboTipo;
	private JLabel lblLugar;
	private JLabel lblNombreCliente;
	private JPanel jPanel2;
	public static ServletEnvioCliente objServletcli=null;
	MenuPrincipal objMenu;
	EnviarCorreoCliente objEnviarCliente;
	public static int codclirubro;
	public static String nomcli;
	GUI objGUI;
	Globales objGlo;
	EnvioMailsAutoCliente objEnvioMail;
	
     String titulo2[]={"COD_CLI","NOM_CLI","TIPO_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","SEX","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
			"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","RPMB_CLI","NEXB_CLI","COD_TIPO","OBSB_CLI","OBS_CLI","EST_CLI","AGE_CLI","FEC_CLI","MAIL2_CLI","PNOM_CLI"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 int  codcli;
	 private JLabel lbFecha;
	 private JTextField txtmail2;
	 private JLabel lblmail2;
	 private JButton btnPromelsa;
     ServletEnvioAutoCorreoCliente objCAuto= new ServletEnvioAutoCorreoCliente();
     public static String nom_conacli,correo1,correo2,sexcli,nom_ven;
     TableCellRenderer renderer = new CustomTableCellRenderer3();
     
	public  MantCliente() {
	
		
		super("Mant Cliente", true, true, true, true);
		try {
			
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(948, 721));
			this.setBounds(0, 0, 948, 721);
			
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
				jPanel1.setBounds(12, 12, 923, 409);
				jPanel1.setOpaque(false);
				jPanel1.setLayout(null);
				{
					txtRpm = new JTextField();
					jPanel1.add(txtRpm);
					txtRpm.setBounds(220, 119, 116, 21);
				}
				{
					jPanel2 = new JPanel();
					jPanel1.add(jPanel2);
					jPanel2.setBorder(BorderFactory.createTitledBorder("Datos del Contacto"));
					jPanel2.setBounds(17, 226, 773, 154);
					jPanel2.setLayout(null);
					{
						lblNombre = new JLabel();
						jPanel2.add(lblNombre);
						lblNombre.setText("Nombre:");
						lblNombre.setBounds(17, 22, 58, 14);
					}
					{
						txtNombre = new JTextField();
						jPanel2.add(txtNombre);
						txtNombre.setBounds(82, 19, 343, 21);
					}
					{
						lblTelefono = new JLabel();
						jPanel2.add(lblTelefono);
						lblTelefono.setText("Telefono:");
						lblTelefono.setBounds(437, 24, 52, 14);
					}
					{
						txtTelefonoC = new JTextField();
						jPanel2.add(txtTelefonoC);
						txtTelefonoC.setBounds(496, 21, 106, 21);
					}
					{
						lblCelular = new JLabel();
						jPanel2.add(lblCelular);
						lblCelular.setText("Celular:");
						lblCelular.setBounds(614, 24, 47, 14);
					}
					{
						txtCelularC = new JTextField();
						jPanel2.add(txtCelularC);
						txtCelularC.setBounds(665, 21, 101, 21);
					}
					{
						lblEmail = new JLabel();
						jPanel2.add(lblEmail);
						lblEmail.setText("E-mail:");
						lblEmail.setBounds(372, 49, 53, 14);
					}
					{
						txtEmailC = new JTextField();
						jPanel2.add(txtEmailC);
						txtEmailC.setBounds(425, 46, 341, 21);
						txtEmailC.setBackground(new java.awt.Color(198,198,255));
					}
					{
						scrObservacion2 = new JScrollPane();
						jPanel2.add(scrObservacion2);
						scrObservacion2.setBounds(95, 75, 671, 62);
						{
							txtAObservacion2 = new JTextArea();
							scrObservacion2.setViewportView(txtAObservacion2);
							txtAObservacion2.setBounds(374, 319, 377, 59);
						}
					}
					{
						lblObservacion2 = new JLabel();
						jPanel2.add(lblObservacion2);
						lblObservacion2.setText("Observacion:");
						lblObservacion2.setBounds(17, 73, 78, 14);
					}

					btnLimpiar = new JButton();
					jPanel2.add(btnLimpiar);
					btnLimpiar.setText("Borrar");
					btnLimpiar.setBounds(14, 99, 73, 33);
					btnLimpiar.setSize(73, 37);
					{
						lblNextelC = new JLabel();
						jPanel2.add(lblNextelC);
						lblNextelC.setText("Nextel:");
						lblNextelC.setBounds(17, 50, 58, 14);
					}
					{
						txtNextelC = new JTextField();
						jPanel2.add(txtNextelC);
						txtNextelC.setBounds(82, 46, 118, 21);
					}
					{
						jLabel3 = new JLabel();
						jPanel2.add(jLabel3);
						jLabel3.setText("Rpm:");
						jLabel3.setBounds(206, 49, 49, 14);
					}
					{
						txtRpmC = new JTextField();
						jPanel2.add(txtRpmC);
						txtRpmC.setBounds(254, 46, 111, 21);
					}
					btnLimpiar.addActionListener(this);

				}
				{
					lblNombreCliente = new JLabel();
					jPanel1.add(lblNombreCliente);
					lblNombreCliente.setText("Nombre:");
					lblNombreCliente.setBounds(17, 25, 67, 14);
				
					lblTipoCliente = new JLabel();
					jPanel1.add(lblTipoCliente);
					lblTipoCliente.setText("Tipo:");
					lblTipoCliente.setBounds(753, 29, 46, 14);
				
					txtNombreCliente = new JTextField();
					jPanel1.add(txtNombreCliente);
					txtNombreCliente.setBounds(81, 22, 336, 21);
					txtNombreCliente.addKeyListener(this);

					lblLugar = new JLabel();
					jPanel1.add(lblLugar);
					lblLugar.setText("Lugar:");
					lblLugar.setBounds(17, 62, 51, 14);
				
					cboTipo = new JComboBox();
					jPanel1.add(cboTipo);
					cboTipo.setBounds(782, 26, 135, 21);
					cboTipo.addActionListener(this);

					cboLugar = new JComboBox();
					jPanel1.add(cboLugar);
					cboLugar.addItem("LUGAR");
					cboLugar.setBounds(80, 59, 140, 21);
					cboLugar.addActionListener(this);
				
					lblRuc = new JLabel();
					jPanel1.add(lblRuc);
					lblRuc.setText("Ruc:");
					lblRuc.setBounds(424, 28, 39, 14);
			
					txtRuc = new JTextField();
					jPanel1.add(txtRuc);
					txtRuc.setBounds(475, 25, 244, 21);
				
					cboDepartamento = new JComboBox();
					jPanel1.add(cboDepartamento);
					cboDepartamento.addItem("DEPARTAMENTO");
					cboDepartamento.setBounds(318, 59, 145, 21);
					cboDepartamento.addActionListener(this);
				
					lblDepartamento = new JLabel();
					jPanel1.add(lblDepartamento);
					lblDepartamento.setText("Departamento:");
					lblDepartamento.setBounds(228, 62, 97, 14);
				
					lblProvincia = new JLabel();
					jPanel1.add(lblProvincia);
					lblProvincia.setText("Provincia:");
					lblProvincia.setBounds(469, 62, 61, 14);
				
					cboProvincia = new JComboBox();
					jPanel1.add(cboProvincia);
					cboProvincia.addItem("PROVINCIA");
					cboProvincia.setBounds(542, 59, 126, 21);
					cboProvincia.addActionListener(this);
				
					lblDistrito = new JLabel();
					jPanel1.add(lblDistrito);
					lblDistrito.setText("Distrito:");
					lblDistrito.setBounds(680, 62, 50, 14);
				
					cboDistrito = new JComboBox();
					jPanel1.add(cboDistrito);
					cboDistrito.addItem("DISTRITO");
					cboDistrito.setBounds(742, 59, 138, 21);
					cboDistrito.addActionListener(this);
				
					lblDireccion = new JLabel();
					jPanel1.add(lblDireccion);
					lblDireccion.setText("Direccion:");
					lblDireccion.setBounds(13, 95, 63, 14);
				
					txtDireccion = new JTextField();
					jPanel1.add(txtDireccion);
					txtDireccion.setBounds(80, 92, 262, 21);
				
					lblPersona = new JLabel();
					jPanel1.add(lblPersona);
					lblPersona.setText("Personal:");
					lblPersona.setBounds(520, 94, 57, 14);
				}
				
					txtPersonal = new JTextField();
					jPanel1.add(txtPersonal);
					txtPersonal.setBounds(577, 92, 211, 21);
					txtPersonal.setBackground(new java.awt.Color(198,198,255));

					lblTelefono1 = new JLabel();
					jPanel1.add(lblTelefono1);
					lblTelefono1.setText("Telefono1:");
					lblTelefono1.setBounds(530, 122, 66, 14);
				
				
					txtTelefono1 = new JTextField();
					jPanel1.add(txtTelefono1);
					txtTelefono1.setBounds(589, 119, 138, 21);
				
				
					txtTelefono2 = new JTextField();
					jPanel1.add(txtTelefono2);
					txtTelefono2.setBounds(733, 119, 147, 21);
				
				
					lblFax = new JLabel();
					jPanel1.add(lblFax);
					lblFax.setText("Fax:");
					lblFax.setBounds(13, 122, 34, 14);
				
				
					txtFax = new JTextField();
					jPanel1.add(txtFax);
					txtFax.setBounds(47, 119, 126, 21);
				
				
					lblRpm = new JLabel();
					jPanel1.add(lblRpm);
					lblRpm.setText("Rpm:");
					lblRpm.setBounds(179, 122, 41, 14);
				
				
					lblNextel = new JLabel();
					jPanel1.add(lblNextel);
					lblNextel.setText("Nextel:");
					lblNextel.setBounds(342, 122, 47, 14);
				
				
					txtNextel = new JTextField();
					jPanel1.add(txtNextel);
					txtNextel.setBounds(389, 119, 134, 21);
				
				
					lblObservacion = new JLabel();
					jPanel1.add(lblObservacion);
					lblObservacion.setText("Observacion:");
					lblObservacion.setBounds(17, 185, 76, 14);
				
				
					scrObservacion = new JScrollPane();
					jPanel1.add(scrObservacion);
					scrObservacion.setBounds(93, 182, 650, 44);
					{
						txtAObservacion = new JTextArea();
						scrObservacion.setViewportView(txtAObservacion);
						txtAObservacion.setBounds(96, 140, 647, 41);
					}
					
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Celular:");
					jLabel1.setBounds(17, 158, 51, 14);
				
				
					txtCelular = new JTextField();
					jPanel1.add(txtCelular);
					txtCelular.setBounds(76, 155, 205, 21);
				
				
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("E-mail:");
					jLabel2.setBounds(299, 158, 42, 14);
				
				
					txtEmail = new JTextField();
					jPanel1.add(txtEmail);
					txtEmail.setBounds(341, 155, 225, 21);
					txtEmail.setBackground(new java.awt.Color(198,198,255));

					btnAgregar = new JButton();
					jPanel1.add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(821, 277, 95, 23);
					btnAgregar.addActionListener(this);
				
				
					btnBorrar = new JButton();
					jPanel1.add(btnBorrar);
					btnBorrar.setText("Eliminar");
					btnBorrar.setBounds(821, 303, 95, 23);
					btnBorrar.addActionListener(this);
				
				
					btnModificar = new JButton();
					jPanel1.add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(821, 329, 95, 23);
					btnModificar.addActionListener(this);
				
				
					btnBuscar = new JButton();
					jPanel1.add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setBounds(821, 354, 95, 23);
					btnBuscar.addActionListener(this);
				
				
					btnListar = new JButton();
					jPanel1.add(btnListar);
					btnListar.setText("Listar");
					btnListar.setBounds(821, 380, 95, 23);

					lblSexo = new JLabel();
					jPanel1.add(lblSexo);
					lblSexo.setText("Sexo:");
					lblSexo.setBounds(793, 95, 34, 14);
					
					cboSexo = new JComboBox();
					jPanel1.add(cboSexo);
					cboSexo.addItem("¿?");
					cboSexo.addItem("Masculino");
					cboSexo.addItem("Femenino");
					cboSexo.setBounds(827, 92, 90, 21);

					chkTipo = new JCheckBox();
					jPanel1.add(chkTipo);
					chkTipo.setBounds(730, 25, 20, 24);

					btnEnviar = new JButton();
					jPanel1.add(btnEnviar);
					btnEnviar.setText("Enviar");
					btnEnviar.setBounds(821, 251, 95, 23);

					btnBuscarRuc = new JButton();
					jPanel1.add(btnBuscarRuc);
					btnBuscarRuc.setText("Ruc");
					btnBuscarRuc.setBounds(225, 381, 67, 23);

					btnTipoClien = new JButton();
					jPanel1.add(btnTipoClien);
					btnTipoClien.setText("T.Cliente");
					btnTipoClien.setBounds(293, 381, 89, 22);
					btnTipoClien.setSize(89, 23);

					cboEstado = new JComboBox();
					jPanel1.add(cboEstado);
					cboEstado.addItem("");
					cboEstado.addItem("ACTIVADO");
					cboEstado.addItem("DESACTIVADO");
					cboEstado.setBounds(796, 225, 120, 23);

					txtEstado = new JTextField();
					jPanel1.add(txtEstado);
					txtEstado.setBounds(728, 381, 89, 22);
					txtEstado.setEditable(false);

					btnMovistar = new JButton();
					jPanel1.add(btnMovistar);
					btnMovistar.setText(" RPM");
					btnMovistar.setBounds(155, 381, 69, 22);
					btnMovistar.setSize(69, 23);

					cboAgente = new JComboBox();
					jPanel1.add(cboAgente);
					cboAgente.addItem("");
					cboAgente.addItem("Con Agente de Retencion");
					cboAgente.addItem("Sin Agente de Retencion");
					cboAgente.setBounds(6, 381, 146, 23);

					btnBuscadorElectricos = new JButton();
					jPanel1.add(btnBuscadorElectricos);
					btnBuscadorElectricos.setText("B.Electricos");
					btnBuscadorElectricos.setBounds(384, 381, 101, 23);

					btnPagBlancas = new JButton();
					jPanel1.add(btnPagBlancas);
					btnPagBlancas.setText("P.Blancas");
					btnPagBlancas.setBounds(487, 381, 95, 23);
					{
						btnBienvenida = new JButton();
						jPanel1.add(btnBienvenida);
						btnBienvenida.setText("Bienvenida");
						btnBienvenida.setBounds(584, 381, 97, 23);
						btnBienvenida.addActionListener(this);
					}
					{
						btnPromelsa = new JButton();
						jPanel1.add(btnPromelsa);
						btnPromelsa.setText("P");
						btnPromelsa.setBounds(683, 381, 43, 23);
						btnPromelsa.addActionListener(this);
					}
					{
						lblmail2 = new JLabel();
						jPanel1.add(lblmail2);
						lblmail2.setText("E-mail2:");
						lblmail2.setBounds(573, 157, 50, 16);
					}
					{
						txtmail2 = new JTextField();
						jPanel1.add(txtmail2);
						txtmail2.setBounds(628, 154, 278, 23);
					}
					{
						lbFecha = new JLabel();
						jPanel1.add(lbFecha);
						lbFecha.setText("Fecha:");
						lbFecha.setBounds(755, 187, 43, 20);
					}
					{
						txtFecha = new JTextField();
						jPanel1.add(txtFecha);
						txtFecha.setBounds(796, 186, 110, 23);
						txtFecha.setForeground(new java.awt.Color(255,0,0));
						txtFecha.setFont(new java.awt.Font("Segoe UI",1,12));
						txtFecha.setEditable(false);
					}
					{
						jLabel4 = new JLabel();
						jPanel1.add(jLabel4);
						jLabel4.setText("P.Nombre:");
						jLabel4.setBounds(348, 94, 64, 16);
					}
					{
						txtPNombre = new JTextField();
						jPanel1.add(txtPNombre);
						txtPNombre.setBounds(407, 91, 108, 23);
						txtPNombre.setSize(108, 21);
					}
					btnPagBlancas.addActionListener(this);

					btnBuscadorElectricos.addActionListener(this);

					btnMovistar.addActionListener(this);
					cboEstado.addActionListener(this);
					btnTipoClien.addActionListener(this);
					btnBuscarRuc.addActionListener(this);
					btnEnviar.addActionListener(this);
					btnListar.addActionListener(this);
				
			}

				pnlLista = new JPanel();
				getContentPane().add(pnlLista);
				pnlLista.setLayout(null);
				pnlLista.setBounds(24, 433, 890, 215);

				jScrollPane2 = new JScrollPane();
				pnlLista.add(jScrollPane2);
				jScrollPane2.setBounds(12, 0, 856, 196);

				jScrollPane1 = new JScrollPane();
				jScrollPane2.setViewportView(jScrollPane1);
				jScrollPane1.setBounds(27, 32, 1931, 43);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(1826, 152));
				
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(modelo2);
				jTable1.addMouseListener(this);
			
			listaLugar();
			listaDepartamento();
			listarCliente();
            cargarTipo();
			
			setVisible(true);
			pack();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
     public void  PintarFila(){
		
		TableColumn column0 = jTable1.getColumn(jTable1.getColumnName(0));
		column0.setCellRenderer(renderer);
		
	} 
	
	/********LISTAR CLIENTES************************/
	public void listarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		PintarFila();


		String sql="SELECT CLI.COD_CLI, CLI.NOM_CLI, TIPCLI.NOM_TIPO,CLI.LUG_CLI, CLI.RUC_CLI, CLI.COD_DEP, CLI.COD_PRO, CLI.COD_DIS, CLI.DIR_CLI, "+
	       " CLI.CONA_CLI, CLI.SEX_CLI, CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
	       " CLI.NEXA_CLI, CLI.CELA_CLI, CLI.MAILA_CLI, CLI.CONB_CLI, CLI.TEL1B_CLI, CLI.CELB_CLI,CLI.MAILB_CLI, "+
	       " CLI.RPMB_CLI, CLI.NEXB_CLI, TIPCLI.cod_tipo, CLI.OBSB_CLI, CLI.OBS_CLI, CLI.EST_CLI,CLI.AGE_CLI,CLI.FEC_CLI,CLI.MAIL2_CLI,CLI.PNOM_CLI FROM tb_cliente CLI "+
	       " INNER JOIN tb_tipocliente TIPCLI "+
	       " ON CLI.COD_TIPO=TIPCLI.COD_TIPO " +
	       " where CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI ASC";
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
						rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31),rs.getString(32)
				};	
				modelo2.addRow(obj);

				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/*************************************************************************************************************/
	/********LISTAR CLIENTES************************/
	public void listarClientePorEstado(){
		int n=modelo2.getRowCount();
		String estado=""+cboEstado.getSelectedItem();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT CLI.COD_CLI, CLI.NOM_CLI, TIPCLI.NOM_TIPO,CLI.LUG_CLI, CLI.RUC_CLI, CLI.COD_DEP, CLI.COD_PRO, CLI.COD_DIS, CLI.DIR_CLI, "+
	       " CLI.CONA_CLI, CLI.SEX_CLI, CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
	       " CLI.NEXA_CLI, CLI.CELA_CLI, CLI.MAILA_CLI, CLI.CONB_CLI, CLI.TEL1B_CLI, CLI.CELB_CLI,CLI.MAILB_CLI, "+
	       " CLI.RPMB_CLI, CLI.NEXB_CLI, TIPCLI.cod_tipo, CLI.OBSB_CLI, CLI.OBS_CLI, CLI.EST_CLI, CLI.AGE_CLI,CLI.FEC_CLI,CLI.MAIL2_CLI,CLI.PNOM_CLI FROM tb_cliente CLI "+
	       " INNER JOIN tb_tipocliente TIPCLI "+
	       " ON CLI.COD_TIPO=TIPCLI.COD_TIPO " +
	       " where CLI.EST_CLI='"+estado+"' order by CLI.COD_CLI ASC";
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
						rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31),rs.getString(32)
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
	/********LISTAR CLIENTES************************/
	public void listarClientePorTipo(){
		
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		String codtipo=""+cboTipo.getSelectedItem();
		codtipo=codtipo.substring(codtipo.indexOf("-")+1,codtipo.length());
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT CLI.COD_CLI, CLI.NOM_CLI, TIPCLI.NOM_TIPO,CLI.LUG_CLI, CLI.RUC_CLI, CLI.COD_DEP, CLI.COD_PRO, CLI.COD_DIS, CLI.DIR_CLI, "+
       " CLI.CONA_CLI, CLI.SEX_CLI, CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
       " CLI.NEXA_CLI, CLI.CELA_CLI, CLI.MAILA_CLI, CLI.CONB_CLI, CLI.TEL1B_CLI, CLI.CELB_CLI,CLI.MAILB_CLI, "+
       " CLI.RPMB_CLI, CLI.NEXB_CLI, TIPCLI.cod_tipo, CLI.OBSB_CLI, CLI.OBS_CLI, CLI.EST_CLI, CLI.AGE_CLI,CLI.FEC_CLI,CLI.MAIL2_CLI,CLI.PNOM_CLI FROM tb_cliente CLI "+
       " INNER JOIN tb_tipocliente TIPCLI "+
       " ON CLI.COD_TIPO=TIPCLI.COD_TIPO "+
       " where TIPCLI.COD_TIPO='"+codtipo+"' AND TIPCLI.EST_TIPO='ACTIVADO' AND CLI.EST_CLI='ACTIVADO';";
		
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
						rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31),rs.getString(32)
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
	public String SinAlgunosCaract(String cad){
		
		String palabra="";
		
		palabra=cad.replaceAll("-", "%");
		palabra=palabra.replaceAll(" ", "%");
		palabra=palabra.replace("*", "%");
		palabra=palabra.replace("#", "%");

		return palabra;
	}
	
	
	/********************************BUSCAR CLIENTES********************************/
	public void buscarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		System.out.println("ESTO SALEEEE:"+SinAlgunosCaract("CONSTRUCTORA INMOBILIARIA-SAN*LUIS#"));
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtNombreCliente.getText(),RUC=txtRuc.getText(),DIR_CLI=txtDireccion.getText(),
		CONA_CLI=txtPersonal.getText(),FAXA_CLI=txtFax.getText(),RPMA_CLI=txtRpm.getText(),
		NEXA_CLI=txtNextel.getText(),TEL1A_CLI=txtTelefono1.getText(),TEL2A_CLI=txtTelefono2.getText(),
		CELA_CLI=txtCelular.getText(),MAILA_CLI=txtEmail.getText(),CONB_CLI=txtNombre.getText(),
		TEL1B_CLI=txtTelefonoC.getText(),CELB_CLI=txtCelularC.getText(),NEXB_CLI=txtNextelC.getText(),
	    RPMB_CLI=txtRpmC.getText(),MAILB_CLI=txtEmailC.getText();
		
		
		String sql="SELECT CLI.COD_CLI, CLI.NOM_CLI, TIPCLI.NOM_TIPO,CLI.LUG_CLI, CLI.RUC_CLI, CLI.COD_DEP, CLI.COD_PRO, CLI.COD_DIS, CLI.DIR_CLI, "+
        "CLI.CONA_CLI, CLI.SEX_CLI, CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
		"CLI.NEXA_CLI, CLI.CELA_CLI, CLI.MAILA_CLI, CLI.CONB_CLI, CLI.TEL1B_CLI, CLI.CELB_CLI,CLI.MAILB_CLI, "+
		"CLI.RPMB_CLI, CLI.NEXB_CLI, TIPCLI.cod_tipo, CLI.OBSB_CLI, CLI.OBS_CLI, CLI.EST_CLI,CLI.AGE_CLI,CLI.FEC_CLI,CLI.MAIL2_CLI,CLI.PNOM_CLI FROM tb_cliente CLI "+
		"INNER JOIN tb_tipocliente TIPCLI "+
		"ON CLI.COD_TIPO=TIPCLI.COD_TIPO "+
		"WHERE CLI.NOM_CLI LIKE '%"+NOM_CLI+"%' AND CLI.RUC_CLI LIKE '%"+RUC+"%' AND CLI.DIR_CLI LIKE '%"+DIR_CLI+"%'  AND CLI.CONA_CLI LIKE '%"+CONA_CLI+"%' "+
		"AND replace(replace(replace(replace(CLI.FAXA_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(FAXA_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.RPMA_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(RPMA_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.NEXA_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(NEXA_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.TEL1A_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(TEL1A_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.TEL2A_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(TEL2A_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.CELA_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(CELA_CLI)+"%' "+
		"AND CLI.MAILA_CLI LIKE '%"+MAILA_CLI+"%' AND CLI.CONB_CLI LIKE '%"+CONB_CLI+"%' "+
		"AND replace(replace(replace(replace(CLI.TEL1B_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(TEL1B_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.CELB_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(CELB_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.NEXB_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(NEXB_CLI)+"%' "+
		"AND replace(replace(replace(replace(CLI.RPMB_CLI,' ',''),'-',''),'*',''),'#','') LIKE '%"+SinAlgunosCaract(RPMB_CLI)+"%' "+
		"AND CLI.MAILB_CLI LIKE '%"+MAILB_CLI+"%' AND CLI.EST_CLI='ACTIVADO' "+
		"order by CLI.COD_CLI ;";
			
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
						rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31),rs.getString(32)
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
		
		String sql="UPDATE tb_cliente SET EST_CLI='"+"DESACTIVADO"+"'  WHERE COD_CLI="+codcli+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al eliminar");
		}else{
			objGUI.mostrarAviso("Se elimino el Cliente");
		}
		
		
		
		objAccesoBD.cerrarConexion();	
		listarCliente();
	}
	
	/***********************************************/
	/********MODIFICAR CLIENTE**********************/
	public void modificarCliente(){
		
		String dat=txtAObservacion.getText();
		dat=dat.replaceAll("'", "\'\'");
		String dat2=txtPersonal.getText();
		dat2=dat2.replaceAll("'", "\'\'");
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
		"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
		String COD_DEP=(String)cboDepartamento.getSelectedItem(),COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
		String lug=(String) cboLugar.getSelectedItem();
		String cod_tipo=""+cboTipo.getSelectedItem();
		cod_tipo=cod_tipo.substring(cod_tipo.indexOf("-")+1, cod_tipo.length());
		boolean valor;
		int sexo=Integer.parseInt(""+cboSexo.getSelectedIndex());
		int agente=Integer.parseInt(""+cboAgente.getSelectedIndex());
		if(COD_DEP.equals("")||COD_DEP==null||COD_PRO.equals("")||COD_PRO==null||COD_DIS.equals("")|COD_DIS==null||lug.equals("")||lug==null){
			JOptionPane.showInternalMessageDialog(this, "FALTAN LOS DATOS DE: \n Lugar,Departamento,Provincia,Distrito",
					"Precaucion", JOptionPane.WARNING_MESSAGE);
			valor=true;
		}else{System.out.println("EL COD_DEP:"+COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length()));
			  System.out.println("EL COD_PRO:"+COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length()));
			  System.out.println("EL COD_DIS:"+COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length()));
			COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length());
			COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length());
			COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length());
			lug=lug.substring(0,lug.indexOf("-"));
			valor=false;
		}
		if(valor==false){
			String sql="UPDATE tb_cliente SET NOM_CLI='"+txtNombreCliente.getText()+"' , " +
				"COD_TIPO='"+cod_tipo+"' , LUG_CLI='"+lug+"' , "+
				"RUC_CLI='"+txtRuc.getText()+"' , COD_DEP='"+COD_DEP+"' , "+
				"COD_PRO='"+COD_PRO+"' , COD_DIS='"+COD_DIS+"' , "+
				"DIR_CLI='"+txtDireccion.getText()+"' , CONA_CLI='"+dat2+"' , "+
				"TEL1A_CLI='"+txtTelefono1.getText()+"' , TEL2A_CLI='"+txtTelefono2.getText()+"' , "+
				"  SEX_CLI='"+sexo+"' , "+
				" RPMA_CLI='"+txtRpm.getText()+"' , NEXA_CLI='"+txtNextel.getText()+"' , "+
				"CELA_CLI='"+txtCelular.getText()+"' , MAILA_CLI='"+txtEmail.getText()+"' , "+
				"CONB_CLI='"+txtNombre.getText()+"' , TEL1B_CLI='"+txtTelefonoC.getText()+"' , "+
				"CELB_CLI='"+txtCelularC.getText()+"' , MAILB_CLI='"+txtEmailC.getText()+"' , "+
				"RPMB_CLI='"+txtRpmC.getText()+"' , NEXB_CLI='"+txtNextelC.getText()+"' , "+
				"OBSB_CLI='"+txtAObservacion2.getText()+"' , OBS_CLI='"+dat+"' , AGE_CLI='"+agente+"', FEC_CLI=curdate(), MAIL2_CLI='"+txtmail2.getText()+"', PNOM_CLI='"+txtPNombre.getText()+"'  "+
				" WHERE COD_CLI="+codcli+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al modificar el Cliente");
		}else{
			objGUI.mostrarAviso("Se modifico el Cliente");
		}
		
		objAccesoBD.cerrarConexion();	
		}
		
		listarCliente();
	}
	
	/***********************************************/
	/********MODIFICAR CLIENTE**********************/
	public void modificarClienteEstado(){
		
		String dat=txtAObservacion.getText();
		dat=dat.replaceAll("'", "\'\'");
		String dat2=txtPersonal.getText();
		String estado=""+cboEstado.getSelectedItem();
		dat2=dat2.replaceAll("'", "\'\'");
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
		"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
		String COD_DEP=(String)cboDepartamento.getSelectedItem(),COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
		String lug=(String) cboLugar.getSelectedItem();
		String cod_tipo=""+cboTipo.getSelectedItem();
		cod_tipo=cod_tipo.substring(cod_tipo.indexOf("-")+1, cod_tipo.length());
		boolean valor;
		int sexo=Integer.parseInt(""+cboSexo.getSelectedIndex());
		int agente=Integer.parseInt(""+cboAgente.getSelectedIndex());
		if(COD_DEP.equals("")||COD_DEP==null||COD_PRO.equals("")||COD_PRO==null||COD_DIS.equals("")|COD_DIS==null||lug.equals("")||lug==null){
			JOptionPane.showInternalMessageDialog(this, "FALTAN LOS DATOS DE: \n Lugar,Departamento,Provincia,Distrito",
					"Precaucion", JOptionPane.WARNING_MESSAGE);
			valor=true;
		}else{System.out.println("EL COD_DEP:"+COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length()));
			  System.out.println("EL COD_PRO:"+COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length()));
			  System.out.println("EL COD_DIS:"+COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length()));
			COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1,COD_DEP.length());
			COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1,COD_PRO.length());
			COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1,COD_DIS.length());
			lug=lug.substring(0,lug.indexOf("-"));
			valor=false;
		}
		if(valor==false){
			String sql="UPDATE tb_cliente SET NOM_CLI='"+txtNombreCliente.getText()+"' , " +
				"COD_TIPO='"+cod_tipo+"' , LUG_CLI='"+lug+"' , "+
				"RUC_CLI='"+txtRuc.getText()+"' , COD_DEP='"+COD_DEP+"' , "+
				"COD_PRO='"+COD_PRO+"' , COD_DIS='"+COD_DIS+"' , "+
				"DIR_CLI='"+txtDireccion.getText()+"' , CONA_CLI='"+dat2+"' , "+
				"TEL1A_CLI='"+txtTelefono1.getText()+"' , TEL2A_CLI='"+txtTelefono2.getText()+"' , "+
				"  SEX_CLI='"+sexo+"' , "+
				" RPMA_CLI='"+txtRpm.getText()+"' , NEXA_CLI='"+txtNextel.getText()+"' , "+
				"CELA_CLI='"+txtCelular.getText()+"' , MAILA_CLI='"+txtEmail.getText()+"' , "+
				"CONB_CLI='"+txtNombre.getText()+"' , TEL1B_CLI='"+txtTelefonoC.getText()+"' , "+
				"CELB_CLI='"+txtCelularC.getText()+"' , MAILB_CLI='"+txtEmailC.getText()+"' , "+
				"RPMB_CLI='"+txtRpmC.getText()+"' , NEXB_CLI='"+txtNextelC.getText()+"' , "+
				"OBSB_CLI='"+txtAObservacion2.getText()+"' , OBS_CLI='"+dat+"' , EST_CLI='"+estado+"', AGE_CLI='"+agente+"', FEC_CLI=curdate(), MAIL2_CLI='"+txtmail2.getText()+"', PNOM_CLI='"+txtPNombre.getText()+"'  "+
				"WHERE COD_CLI="+codcli+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al modificar el Cliente");
		}else{
			objGUI.mostrarAviso("Se modifico el Cliente");
		}
		
		objAccesoBD.cerrarConexion();	
		}
		
		listarCliente();
	}
	
	/***********************************************/
	/********AGREGAR CLIENTE************************/
	public void agregarCliente(){
		
		String dat=txtAObservacion.getText();
		dat=dat.replaceAll("'", "\'\'");
		String dat2=txtPersonal.getText();
		dat2=dat2.replaceAll("'", "\'\'");
		/*JOptionPane.showConfirmDialog(this,"¿Seguro de modificar esta Venta?",
				"Confirmacion",JOptionPane.YES_NO_OPTION);*/
		/*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
			"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtNombreCliente.getText(),LUG_CLI=(String) cboLugar.getSelectedItem(),
		RUC_CLI=txtRuc.getText(),DIR_CLI=txtDireccion.getText(),CONA_CLI=dat2,TEL1A_CLI=txtTelefono1.getText(),TEL2A_CLI=txtTelefono2.getText(),
		FAXA_CLI=txtFax.getText(),RPMA_CLI=txtRpm.getText(),NEXA_CLI=txtNextel.getText(),CELA_CLI=txtCelular.getText(),MAILA_CLI=txtEmail.getText(),
		CONB_CLI=txtNombre.getText(),TEL1B_CLI=txtTelefonoC.getText(),CELB_CLI=txtCelularC.getText(),MAILB_CLI=txtEmailC.getText()
		,RPMB_CLI=txtRpmC.getText(),NEXB_CLI=txtNextelC.getText(),OBSB_CLI=txtAObservacion2.getText(),
		OBS_CLI=dat,EST_CLI="ACTIVADO";
		
		
		String COD_DEP=(String) cboDepartamento.getSelectedItem(),
		COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
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
			COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1, COD_DEP.length());COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1, COD_PRO.length());COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1, COD_DIS.length());
			LUG_CLI=LUG_CLI.substring(0, LUG_CLI.indexOf("-"));
			valor=false;
		}
		
		if(valor==false){
			String insertarPregunta="INSERT INTO tb_cliente VALUES("+null+",'"+NOM_CLI+"','"
			+cod_tipo+"','"+LUG_CLI+"','"+RUC_CLI+"','"+COD_DEP+"','"+COD_PRO+"','"+COD_DIS+"','"+DIR_CLI+"','"
			+CONA_CLI+"','"+sexo+"','"+TEL1A_CLI+"','"+TEL2A_CLI+"','"+FAXA_CLI+"','"+RPMA_CLI+"','"+NEXA_CLI+"','"+CELA_CLI+"','"+
			MAILA_CLI+"','"+CONB_CLI+"','"+TEL1B_CLI+"','"+CELB_CLI+"','"+MAILB_CLI+"','"+RPMB_CLI+"','"+NEXB_CLI+"','"+OBSB_CLI+"','"+OBS_CLI+"','"+EST_CLI+"','"+agente+"',curdate(),'"+txtmail2.getText()+"','"+txtPNombre.getText()+"')";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un ERROR al Ingresar\nlos datos");
			}else{
				objGUI.mostrarAviso("Se Ingreso Correctamente el Cliente");
			}
			//objAccesoBD.cerrarConexion();
		objAccesoBD.cerrarConexion();
		}
		
	}
	/***********************************************/
	/********AGREGAR CLIENTE************************/
	/*public void agregarCliente2(){
		
		String dat=txtAObservacion.getText();
		dat=dat.replaceAll("'", "\'\'");
		String dat2=txtPersonal.getText();
		dat2=dat2.replaceAll("'", "\'\'");
		
		AccesoBD2 objAccesoBD2 = new AccesoBD2();
		objAccesoBD2.crearConexion();
		String NOM_CLI=txtNombreCliente.getText(),LUG_CLI=(String) cboLugar.getSelectedItem(),
		RUC_CLI=txtRuc.getText(),DIR_CLI=txtDireccion.getText(),CONA_CLI=dat2,TEL1A_CLI=txtTelefono1.getText(),TEL2A_CLI=txtTelefono2.getText(),
		FAXA_CLI=txtFax.getText(),RPMA_CLI=txtRpm.getText(),NEXA_CLI=txtNextel.getText(),CELA_CLI=txtCelular.getText(),MAILA_CLI=txtEmail.getText(),
		CONB_CLI=txtNombre.getText(),TEL1B_CLI=txtTelefonoC.getText(),CELB_CLI=txtCelularC.getText(),MAILB_CLI=txtEmailC.getText()
		,RPMB_CLI=txtRpmC.getText(),NEXB_CLI=txtNextelC.getText(),OBSB_CLI=txtAObservacion2.getText(),
		OBS_CLI=dat,EST_CLI="ACTIVADO";
		
		
		String COD_DEP=(String) cboDepartamento.getSelectedItem(),
		COD_PRO=(String)cboProvincia.getSelectedItem(),COD_DIS=(String)cboDistrito.getSelectedItem();
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
			COD_DEP=COD_DEP.substring(COD_DEP.indexOf("-")+1, COD_DEP.length());COD_PRO=COD_PRO.substring(COD_PRO.indexOf("-")+1, COD_PRO.length());COD_DIS=COD_DIS.substring(COD_DIS.indexOf("-")+1, COD_DIS.length());
			LUG_CLI=LUG_CLI.substring(0, LUG_CLI.indexOf("-"));
			valor=false;
		}
		
		if(valor==false){
			String insertarPregunta="INSERT INTO tb_cliente VALUES("+null+",'"+NOM_CLI+"','"
			+cod_tipo+"','"+LUG_CLI+"','"+RUC_CLI+"','"+COD_DEP+"','"+COD_PRO+"','"+COD_DIS+"','"+DIR_CLI+"','"
			+CONA_CLI+"','"+sexo+"','"+TEL1A_CLI+"','"+TEL2A_CLI+"','"+FAXA_CLI+"','"+RPMA_CLI+"','"+NEXA_CLI+"','"+CELA_CLI+"','"+
			MAILA_CLI+"','"+CONB_CLI+"','"+TEL1B_CLI+"','"+CELB_CLI+"','"+MAILB_CLI+"','"+RPMB_CLI+"','"+NEXB_CLI+"','"+OBSB_CLI+"','"+OBS_CLI+"','"+EST_CLI+"','"+agente+"')";
			System.out.println(insertarPregunta);

			int op= objAccesoBD2.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un ERROR al Ingresar\nlos datos");
			}else{
				objGUI.mostrarAviso("Se Ingreso Correctamente el Cliente 2222");
			}
			//objAccesoBD.cerrarConexion();
		objAccesoBD2.cerrarConexion();
		}
		
			
		
	}*/
	/***********************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarlistaCliente(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		//Cargar los datos de la fila seleccionada al panel de datos
		int cod= Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		  codcli=cod;
       /*String titulo2[]={"COD_CLI","NOM_CLI","LUG_CLI","RUC_CLI","COD_DEP","COD_PRO","COD_DIS","DIR_CLI","CONA_CLI","SEX","TEL1A_CLI","TEL2A_CLI","FAXA_CLI",
			"RPMA_CLI","NEXA_CLI","CELA_CLI","MAILA_CLI","CONB_CLI","TEL1B_CLI","CELB_CLI","MAILB_CLI","OBSB_CLI","OBS_CLI","EST_CLI"};*/
			
		txtNombreCliente.setText(""+modelo2.getValueAt(fila, 1));
		cboTipo.setSelectedItem(modelo2.getValueAt(fila,2));
		
		//listaLugarNom((String) modelo2.getValueAt(fila,3));
		//cboLugar.setSelectedItem(""+modelo2.getValueAt(fila,3));
		txtRuc.setText(""+modelo2.getValueAt(fila, 4));
		cargarTipoCli(""+modelo2.getValueAt(fila,24));
		cargarLugar(""+modelo2.getValueAt(fila,3));
		
		cargarComboBox((String)modelo2.getValueAt(fila,5), (String)modelo2.getValueAt(fila,6),(String) modelo2.getValueAt(fila,7));
		//listaDepartamento((String)modelo2.getValueAt(fila,5));
		//cboDepartamento.setSelectedItem(modelo2.getValueAt(fila,5));
		//listaProvincias((String)modelo2.getValueAt(fila,5),(String)modelo2.getValueAt(fila,6));
		//cboProvincia.setSelectedItem(modelo2.getValueAt(fila,6));
		//cboDistrito.setSelectedItem(modelo2.getValueAt(fila,7));
		txtDireccion.setText(""+modelo2.getValueAt(fila, 8));
		txtPersonal.setText(""+modelo2.getValueAt(fila, 9));
		cargarSexo(Integer.parseInt(""+modelo2.getValueAt(fila, 10)));
		txtTelefono1.setText(""+modelo2.getValueAt(fila, 11));
		txtTelefono2.setText(""+modelo2.getValueAt(fila, 12));
		txtFax.setText(""+modelo2.getValueAt(fila, 13));
		txtRpm.setText(""+modelo2.getValueAt(fila, 14));
		txtNextel.setText(""+modelo2.getValueAt(fila, 15));
		txtCelular.setText(""+modelo2.getValueAt(fila, 16));
		txtEmail.setText(""+modelo2.getValueAt(fila, 17));
		txtNombre.setText(""+modelo2.getValueAt(fila, 18));
		txtTelefonoC.setText(""+modelo2.getValueAt(fila, 19));
		txtCelularC.setText(""+modelo2.getValueAt(fila, 20));
		txtEmailC.setText(""+modelo2.getValueAt(fila, 21));
		txtRpmC.setText(""+modelo2.getValueAt(fila, 22));
		txtNextelC.setText(""+modelo2.getValueAt(fila, 23));
		txtAObservacion.setText(""+modelo2.getValueAt(fila, 26));
		txtAObservacion2.setText(""+modelo2.getValueAt(fila, 25));
		txtEstado.setText(""+modelo2.getValueAt(fila, 27));
		cargarAgente(Integer.parseInt(""+modelo2.getValueAt(fila, 28)));
		txtFecha.setText(""+modelo2.getValueAt(fila, 29));
		txtmail2.setText(""+modelo2.getValueAt(fila, 30));
		txtPNombre.setText(""+modelo2.getValueAt(fila, 31));
		
	}
	/***********************************************/
	public void cargarSexo(int sex){

		cboSexo.setSelectedIndex(sex);
	}
	/***********************************************/
	public void cargarAgente(int age){
	
		cboAgente.setSelectedIndex(age);
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
			// TODO: handle exception
		}
		
	}
	/***********************************************/
	public void cargarLugar(String lugar){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_ubigeo WHERE NOMBRE='"+lugar+"' and COD_DIS='00' AND COD_PRO='00';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboLugar.setSelectedItem(rs.getString(4)+"-"+rs.getString(1));
				
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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

	
	/********LISTA LUGAR**************************/
	public void listaLugar() {
	AccesoBD objAccesoBD = new AccesoBD();
	objAccesoBD.crearConexion();
	String sql="SELECT * FROM tb_ubigeo WHERE COD_DIS='00' AND COD_PRO='00';";
	ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
	
	try {
		while (rs.next()) {
			cboLugar.addItem( rs.getString(4)+"-"+rs.getString(1));
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}

	objAccesoBD.cerrarConexion();
	}
	/********************************************/
	/********LISTA LUGAR**************************/
	public void listaLugar(String lug) {
    lug=lug.trim();
	AccesoBD objAccesoBD = new AccesoBD();
	objAccesoBD.crearConexion();
	String sql="SELECT * FROM tb_ubigeo WHERE COD_DIS='00' AND COD_PRO='00';";
	ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
	boolean valor=false;
	try {
		while (rs.next()) {
			if(lug.equals(rs.getString(4))){
			//cboLugar.addItem( rs.getString(4)+"-"+rs.getString(1));	
			//	cboLugar.getSelectedItem().equals( rs.getString(4)+"-"+rs.getString(1));
				cboLugar.setSelectedItem(rs.getString(4)+"-"+rs.getString(1));valor=true;
			}
			
			
		}
		if(valor){
			
		}else{
			cboLugar.setSelectedItem("VACIO"+"-"+"99");
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}

	objAccesoBD.cerrarConexion();
	}
	/********************************************/
	public boolean guardarLosCorreos(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		boolean valor = true;
		objServletcli= new ServletEnvioCliente();
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			Object obj=modelo2.getValueAt(i, 0);

			String sql="SELECT COD_CLI,CONA_CLI,NOM_CLI,SEX_CLI,MAILA_CLI,MAILB_CLI FROM tb_cliente WHERE COD_CLI='"+obj+"'";
			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				if(rs.next()){
		BeanEnvioCliente objbean= 
		new BeanEnvioCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					
		objServletcli.adicionar(objbean);
				}
			} catch (Exception e) {
				// TODO: handle exceptions
			}

		}
		
		System.out.println("tam:"+objServletcli.tamaño());
		if(objServletcli==null)
			valor=false;
		else
			valor=true;
		
		return valor;
	}
	/*******LIMPIAR TODO************************/
	public void limpiarTodo(){
		codcli=0;
		txtNombreCliente.setText("");
		cboTipo.setSelectedIndex(0);
		cboSexo.setSelectedIndex(0);
		cboLugar.setSelectedIndex(0);
		txtRuc.setText("");
		
		cboDepartamento.setSelectedIndex(0);
		cboProvincia.setSelectedIndex(0);
		cboDistrito.setSelectedIndex(0);
		txtDireccion.setText("");
		txtPersonal.setText("");
		txtTelefono1.setText("");
		txtTelefono2.setText("");
		txtFax.setText("");
		txtRpm.setText("");
		txtNextel.setText("");
		txtCelular.setText("");
		txtEmail.setText("");
		txtNombre.setText("");
		txtTelefonoC.setText("");
		txtCelularC.setText("");
		txtEmailC.setText("");
		txtRpmC.setText("");
		txtNextelC.setText("");
		txtAObservacion2.setText("");
		txtAObservacion.setText("");
		chkTipo.setSelected(false);
	    cboEstado.setSelectedIndex(0);
	    txtEstado.setText("");
	    cboAgente.setSelectedIndex(0);
	    txtPNombre.setText("");
	}
	/*******************************************/
	
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
	
	public void forzarCerrado() { 
	
		try { 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setClosed(true); 

		} catch (PropertyVetoException ex) { 
		
		}
	}	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cboLugar){

		}
	
		if(e.getSource()==btnAgregar){
			
			agregarCliente();
			String nombre=txtPersonal.getText().trim(),
					mail1=txtEmail.getText().trim(),
					mail2=txtEmailC.getText().trim();
			int sexo=cboSexo.getSelectedIndex();
			
			if(nombre.equals("") || mail1.equals("") || sexo==0){
				objGUI.mostrarAviso("No se puede mandar su mensaje");				
			}else{
				
				nom_conacli=nombre;
				correo1=mail1;
				correo2=mail2;
				sexcli=""+sexo;
				nom_ven=objGlo.NOM_VEN;
				
				objEnvioMail= new EnvioMailsAutoCliente();
				objEnvioMail.setVisible(false);
				objEnvioMail.aMostrar();
				objEnvioMail.envio();
				
			}
			listarCliente();
		}
		if(e.getSource()==btnModificar){
			
			if(cboEstado.getSelectedIndex()==0){
				modificarCliente();
			}else if(cboEstado.getSelectedIndex()==1){
				modificarClienteEstado();
				cboEstado.setSelectedIndex(0);
			}else{
				modificarClienteEstado();
				cboEstado.setSelectedIndex(0);
			}
			
		}
		if(e.getSource()==btnBorrar){
			//eliminarCliente();
			limpiarTodo();
		}
		if(e.getSource()==btnBuscar){
			
		buscarCliente();
			
		}
		if(e.getSource()==btnListar){
				
				if(cboEstado.getSelectedIndex()==0){
					listarCliente();
				}else if(cboEstado.getSelectedIndex()==1){
					listarClientePorEstado();
				}else{
					listarClientePorEstado();
				}
		}
		if(e.getSource()==cboDepartamento){
			listaProvincias();
		}
		if(e.getSource()==cboProvincia){
			listaDistrito();
		}
		if(e.getSource()==cboTipo){
			if(chkTipo.isSelected()){
				listarClientePorTipo();
			}else{
				//nada
			}
			
		}
		if(e.getSource()==btnEnviar){
			
			guardarLosCorreos();
			System.out.println(objServletcli.tamaño());

			if(objEnviarCliente==null||objEnviarCliente.isClosed()){
				//objGUI.mostrarAviso("En Construccion.....!!");
				objEnviarCliente= new EnviarCorreoCliente();
				objEnviarCliente.setVisible(true);
				objMenu.jDesktopPane1.add(objEnviarCliente);
			try{this.setClosed(true);
				}catch(PropertyVetoException e1){e1.printStackTrace();}
			try {objEnviarCliente.setSelected(true);} catch (java.beans.PropertyVetoException ee) {}
					}
		}
		
		if(e.getSource()==btnBuscarRuc){
			
			try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias");
			} catch (IOException e1) {
				// TODO Auto-generated catch blockC:\Archivos de programa\Internet Explorer
				e1.printStackTrace();
			}
				
		}
		
         if(e.getSource()==btnBuscadorElectricos){
			
			try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://es.wikipedia.org");
			} catch (IOException e1) {
				// TODO Auto-generated catch blockC:\Archivos de programa\Internet Explorer
				e1.printStackTrace();
			}
				
		}
         if(e.getSource()==btnPagBlancas){
 			
 			try {
 				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://paginasblancas.com.pe/inicio.asp");
 			} catch (IOException e1) {
 				// TODO Auto-generated catch blockC:\Archivos de programa\Internet Explorer
 				e1.printStackTrace();
 			}
 				
 		}
		
		if(e.getSource()==btnLimpiar){
			limpiarTodo();
		}
		if(e.getSource()==btnTipoClien){
			BuscarTipoCliente objTipCli= new BuscarTipoCliente(objMenu);
			
			objTipCli.setVisible(true);
			objTipCli.pack(); 
			//System.out.println("GGGG: "+objTipCli.verificar);
			
			if(objTipCli.verificar==0){
				//NADA
			}else{
				forzarCerrado();
				MantCliente objMantCli= new MantCliente();
				objMenu.jDesktopPane1.add(objMantCli);
				objTipCli.verificar=0;
				
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

		if(e.getSource()==btnBienvenida){
			
			if(codcli!=0){
				int fila = jTable1.getSelectedRow();
				nom_conacli=""+modelo2.getValueAt(fila, 9);
				correo1=""+modelo2.getValueAt(fila, 17);
				correo2=""+modelo2.getValueAt(fila, 21);
				sexcli=""+modelo2.getValueAt(fila, 10);
				nom_ven=objGlo.NOM_VEN;
				
				objEnvioMail= new EnvioMailsAutoCliente();
				objEnvioMail.setVisible(false);
				objEnvioMail.aMostrar();
				objEnvioMail.envio();
				
			}else{
				objGUI.mostrarAviso("Seleccione un Cliente");
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
				
				codclirubro=(Integer) modelo2.getValueAt(fila,0);
				nomcli=""+modelo2.getValueAt(fila,1);
				BuscarRubroCliente objProRub= new BuscarRubroCliente(objMenu);
				
				objProRub.setTitle("Rubro Cliente");
				objProRub.setVisible(true);
				objProRub.pack(); 
				
			}
			
		}
	}
	public void mouseReleased(MouseEvent e) {}

	/**EVENTOS DEL TECLADO*/
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource()==txtNombreCliente){
			buscarCliente();
			
		}
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}
