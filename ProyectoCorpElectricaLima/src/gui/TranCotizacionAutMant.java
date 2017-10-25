package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.AccesoBD2;
import miLib.EditorArchivo;
import miLib.Fecha;
import miLib.GUI;
import miLib.Metodos;
import miLib.PasarExcelCorreo;
import miLib.PasarExcelFactura;
import miLib.PasarExcelTransCotMant;

import org.apache.poi.ss.usermodel.Workbook;

import pOp.BuscarClienteAut;
import pOp.BuscarCotizacion;
import pOp.BuscarCotizacionTarea;
import pOp.BuscarProd;
import pOp.BuscarProdMantCotDialog;
import pOp.BuscarTipoCot;
import pOp.CambiarCant;
import pOp.CambiarCosto;
import pOp.CambiarPeso;
import pOp.CambiarTiempoEntrega;
import pOp.EscogerCalcular;
import servlet.ServletCliente;
import servlet.ServletCotizacionVarios;
import util.Propiedades;
import beans.BeanCliente;
import beans.BeanCotizacionVarios;
import beans.Globales;
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
public  class TranCotizacionAutMant extends  JInternalFrame implements  MouseListener, ActionListener,ItemListener {
	private JPanel pnlPricncipal;
	private JLabel lblTotal;
	private JButton btnGuardar;
	private JTextField txtTotalDif;
	private JTextField txtIgvDif;
	private JTextField txtPrecioVentaDif;
	private JTextField txtTotalIgv;
	private JTextField txtIgvCompra;
	private JLabel lblIgv;
	private JLabel lblPrecioVenta;
	private JTextField txtAtencion2;
	private JTextField txtReferencia;
	private JLabel lblReferencia;
	private JButton btnGuardarCotizacionFinal;
	private JPanel pnlMedio;
	private JTextField txtPesoTotal;
	private JLabel lblPesoTotal;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JTextField txtNroModificacion;
	private JLabel lblNroModificacion;
	private JButton btnBuscarCotizacion;
	private JLabel lblAntencion;
	private JTextField txtSeñores2;
	private JLabel lblSeñores2;
	private JTextField txtPrecioVentaCompra;
	private JTextField txtTotal;
	private JTextField txtIgv;
	private JTextField txtPrecioVenta;
	private JPanel pnlAbajo;
	private JTable tblLista;
	private JScrollPane scrLista;
	private JTextField txtNCotizacion;
	private JLabel lblRuta;
	String texto;
	//// COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT;
	
	//public static String nombre="",marca="";
    
     //GLOBALES
	JCheckBoxHeader2 chkheader; 
	TableColumn Tcol;
	JScrollPane scroll;
	public static String ref;
    int fila,selecciona,idss,cambiaPor;
    public static int numeroDeFilasFac;
    public static String NumeroEnLetras,TIPO_MONEDA;
    public static double TotalFac,IGVFAC;
    ///////////////////////////////////////////////////////////////////////////
    String COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,CUMED,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PROD1,NOM_PROD1,PESO_PROD,TIEMPOENTREGA,
                MODPROD;
	String CODCOT,IDECOT;
	public static String nombre="",marca="";
	public static int cantidadpasar=0;
	public static double costepasar;
	public static String poner;
	private EditorArchivo archivoDatos;//D:\ProyectoCEL(1.0.0.0)\Cotizaciones\CotizacionesModificadas
	String cadenar="D:/ProyectoCEL(1.0.0.0)/Cotizaciones/CotizacionesModificadas/";
	Object[] arregloCadenas;
	Object[][] arregloObjetos;
	Object[] arregloCadenas1;
	Object[][] arregloObjetos1;
	Object[] arregloCadenas2;
	Object[][] arregloObjetos2;
	public static String cod_cot=null;
	public static String codprodpasar;
	public static String codprovepasar;
	public static String codmarpasar;
	public static String codumedpasar;
	public static String cOs="0";
	
	public static 	String[] botones;
	public static ServletCotizacionVarios  objTransacionAutomaticaAutMant;
     //CLASES
	CambiarCosto objCambiarCosto;
	Fecha objFecha;
	Metodos objMetodo;
	GUI objGUI;
	Globales objGlobal;
	BuscarProd objBuscarProd;
	//BuscarProdMantCot objBuscarProdAgregar;
	BuscarClienteAut objBuscarCliAut;
	BuscarCotizacion objBuscarCot;
	private JTextField txtCel;
	private JLabel lblCel;
	private JTextField txtFax;
	private JTextField txtNextel;
	private JTextField txtRpm;
	private JTextField txtTel2;
	private JTextField txtTel1;
	private JLabel lblNextel;
	private JLabel lblRpm;
	private JLabel lblFax;
	private JLabel lblTelefonos;
	private JPanel pnlClientes;
	private JButton btnPrueba;
	private JTextField txtFecha;
	private JLabel lblFecha;
	private JComboBox cboSexo;
	private JTextField txtContacto;
	private JLabel lblContacto;
	BuscarCotizacionTarea objBuscarCotTarea;
	private JLabel lblPorcentaje;
	private JTextField txtPorcentaje;
	private JTextField txtEmpEst;
	private JRadioButton rdbDolares;
	private JRadioButton rdbSoles;
	private JLabel lblDolares;
	private JLabel lblSoles;
	private JPanel pnlFactura;
	private JLabel lblMail2;
	private JLabel lblMail1;
	private JButton btnModificar;
	private JTextField txtEmail2;
	private JTextField txtEmail1;
	private JButton btnAdjuntar;
	private JTextField txtRuta;
	private JTextField txtAgente;
	private JTextField txtPrueba2;
	private JTextField txtPrueba;
	private JButton btnFactura;
	private JButton btnEnviar;
    ServletCliente objServletCliente = new ServletCliente();
    ServletCotizacionVarios objServletCotVarios= new ServletCotizacionVarios();
    PasarExcelCorreo objPasarExcelCorreo;
    public static String rutaGlobal;
    
    EscogerCalcular objescCal;
    MenuPrincipal objMenuP;
    
    BuscarTipoCot objBuscarTipoCot;
    CambiarCant objCambiarCant;
    CambiarTiempoEntrega objCamTiemEntrega;
    CambiarPeso objCambPeso;
    Reporte objReporte;
    
    public static EnvioCotizacionCliente objEnvioCotCliente;
    PasarExcelTransCotMant objPasarExcel;
    public static String nombreCliente,codigocliente,referencia_coti;
    public static String correo1;
	public static String correo2;
	public static String sexo;
	EnvioMail objEnvioMail;
	public static String numCot,ideCot;
	public static String nomEmpresa,espProducto;
	PasarExcelFactura objPasarExcelFactura;
	public int contaFilasFac,conta2,estado;
	MenuPrincipal objMenu;
	public static String ruta,coti,nombreArchivosAdjuntos;
	public static int est;
	//public static int est;
    /**
     * Variables de la otra Classe
     */
    ClassLoader cls = this .getClass().getClassLoader(); 
	static Workbook wb;
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
    public static ClassLoader cl = null;
    TableCellRenderer renderer = new CustomTableCellRenderer2();
    Propiedades p=new Propiedades();
    int cant;
    String acumulaCadena,nombreAdjuntos;
    int numarchivos;
    
    String titulo2[]={"Id","Cant","Und","Descripcion","Marca","Modelo","P.Unit$","IGV$","P.Total$","Totales $",
    		"P.Costo$","C.Total$","Dif.$","P.Unit S/.","IGV S/.","P.Total S/.","Totales S/.","Fecha","%","Proveedor","Tiempo Entrega",
    		"Peso Prod.","P.Carrete"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
    
//    DefaultTableModel modelo2 = new DefaultTableModel(null, titulo2) {
//        public Class getColumnClass(int column) {
//      	 // System.out.println("column:"+column);
//      	 // System.out.println("getcolumncount:"+getColumnCount());
//          if (column >= 0 && column <= getColumnCount()){
//          //	System.out.println(getValueAt(0, column).getClass());
//          	  return getValueAt(0, column).getClass();
//          }
//          
//          else
//            return Object.class;
//        }
//      };
	 
	public TranCotizacionAutMant() {
		super("Cotizacion Mant", true, true, true, true);
		try {

			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(1774, 644));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setBounds(0, 0, 1774, 644);

			pnlMedio = new JPanel();
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			pnlMedio.setPreferredSize(new java.awt.Dimension(943, 406));

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setLayout(null);
			pnlAbajo.setBounds(12, 520, 918, 81);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(1141, 98));
			{
				pnlPricncipal = new JPanel();
				getContentPane().add(pnlPricncipal, BorderLayout.NORTH);
				pnlPricncipal.setLayout(null);
				pnlPricncipal.setBounds(12, 0, 931, 88);
				pnlPricncipal.setPreferredSize(new java.awt.Dimension(1073, 118));
				{
					lblRuta = new JLabel();
					pnlPricncipal.add(lblRuta);
					lblRuta.setText("Nro.Cotizacion:");
					lblRuta.setBounds(12, 10, 87, 16);
				}
				{
					txtNCotizacion = new JTextField();
					pnlPricncipal.add(txtNCotizacion);
					txtNCotizacion.setBounds(99, 7, 150, 23);
				}
				{
					lblSeñores2 = new JLabel();
					pnlPricncipal.add(lblSeñores2);
					lblSeñores2.setText("Señores:");
					lblSeñores2.setBounds(12, 39, 69, 14);
				}
				{
					txtSeñores2 = new JTextField();
					pnlPricncipal.add(txtSeñores2);
					txtSeñores2.setBounds(99, 36, 381, 21);
				}
				{
					lblAntencion = new JLabel();
					pnlPricncipal.add(lblAntencion);
					lblAntencion.setText("Atencion:");
					lblAntencion.setBounds(484, 39, 66, 14);
				}
				{
					txtAtencion2 = new JTextField();
					pnlPricncipal.add(txtAtencion2);
					txtAtencion2.setBounds(565, 36, 212, 22);
					txtAtencion2.setBackground(new java.awt.Color(245,250,254));
				}
				{
					btnBuscarCotizacion = new JButton();
					pnlPricncipal.add(btnBuscarCotizacion);
					btnBuscarCotizacion.setText("Buscar Cot.");
					btnBuscarCotizacion.setBounds(423, 4, 101, 26);
					btnBuscarCotizacion.setVisible(false);
					btnBuscarCotizacion.addActionListener(this);
				}
				{
					lblNroModificacion = new JLabel();
					pnlPricncipal.add(lblNroModificacion);
					lblNroModificacion.setText("Nro Modificacion:");
					lblNroModificacion.setBounds(261, 11, 106, 14);
				}
				{
					txtNroModificacion = new JTextField();
					pnlPricncipal.add(txtNroModificacion);
					txtNroModificacion.setBounds(367, 8, 38, 21);
				}
				{
					btnAgregar = new JButton();
					pnlPricncipal.add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(793, 88, 100, 24);
					btnAgregar.addActionListener(this);
				}
				{
					btnBorrar = new JButton();
					pnlPricncipal.add(btnBorrar);
					btnBorrar.setText("Borrar");
					btnBorrar.setBounds(898, 88, 98, 24);
					btnBorrar.addActionListener(this);
				}
				{
					lblReferencia = new JLabel();
					pnlPricncipal.add(lblReferencia);
					lblReferencia.setText("Referencia:");
					lblReferencia.setBounds(12, 66, 87, 14);
				}
				{
					txtReferencia = new JTextField();
					pnlPricncipal.add(txtReferencia);
					txtReferencia.setBounds(99, 63, 381, 21);
				}
				{
					txtAgente = new JTextField();
					pnlPricncipal.add(txtAgente);
					txtAgente.setBounds(565, 6, 212, 22);
					txtAgente.setEditable(false);
				}
				{
					txtEmail1 = new JTextField();
					pnlPricncipal.add(txtEmail1);
					txtEmail1.setBounds(99, 90, 298, 21);
					txtEmail1.setBackground(new java.awt.Color(245,250,254));
				}
				{
					txtEmail2 = new JTextField();
					pnlPricncipal.add(txtEmail2);
					txtEmail2.setBounds(451, 90, 326, 21);
					txtEmail2.setBackground(new java.awt.Color(245,250,254));
				}
				{
					btnModificar = new JButton();
					pnlPricncipal.add(btnModificar);
					btnModificar.setText("Modificar ");
					btnModificar.setBounds(793, 62, 149, 24);
					btnModificar.addActionListener(this);
				}
				{
					lblMail1 = new JLabel();
					pnlPricncipal.add(lblMail1);
					lblMail1.setText("Mail 1:");
					lblMail1.setBounds(12, 90, 36, 16);
				}
				{
					lblMail2 = new JLabel();
					pnlPricncipal.add(lblMail2);
					lblMail2.setText("Mail 2:");
					lblMail2.setBounds(409, 92, 36, 16);
				}
				{
					txtEmpEst = new JTextField();
					pnlPricncipal.add(txtEmpEst);
					txtEmpEst.setBounds(793, 6, 182, 22);
					txtEmpEst.setEditable(false);
				}
				{
					lblContacto = new JLabel();
					pnlPricncipal.add(lblContacto);
					lblContacto.setText("Contacto Cot:");
					lblContacto.setBounds(484, 65, 82, 16);
				}
				{
					txtContacto = new JTextField();
					pnlPricncipal.add(txtContacto);
					txtContacto.setBounds(566, 63, 211, 20);
					txtContacto.setSize(211, 22);
				}
				{
					cboSexo = new JComboBox();
					pnlPricncipal.add(cboSexo);
					cboSexo.setBounds(793, 36, 111, 23);
				}
				{
					lblFecha = new JLabel();
					pnlPricncipal.add(lblFecha);
					lblFecha.setText("Fecha:");
					lblFecha.setBounds(417, 10, 43, 16);
				}
				{
					txtFecha = new JTextField();
					pnlPricncipal.add(txtFecha);
					txtFecha.setBounds(458, 7, 98, 23);
					txtFecha.setSize(98, 21);
					txtFecha.setEditable(false);
				}
				{
					btnPrueba = new JButton();
					pnlPricncipal.add(btnPrueba);
					btnPrueba.setText("Prueba");
					btnPrueba.setBounds(910, 36, 104, 23);
					btnPrueba.addActionListener(this);
				}
				{
					pnlClientes = new JPanel();
					pnlClientes.setLayout(null);
					pnlPricncipal.add(pnlClientes);
					pnlClientes.setBounds(1033, 0, 388, 112);
					pnlClientes.setBorder(BorderFactory.createTitledBorder("Numeros del Cliente"));
					{
						lblTelefonos = new JLabel();
						pnlClientes.add(lblTelefonos);
						lblTelefonos.setText("Telefonos:");
						lblTelefonos.setBounds(17, 21, 67, 16);
					}
					{
						lblFax = new JLabel();
						pnlClientes.add(lblFax);
						lblFax.setText("Fax:");
						lblFax.setBounds(218, 78, 25, 16);
					}
					{
						lblRpm = new JLabel();
						pnlClientes.add(lblRpm);
						lblRpm.setText("Rpm:");
						lblRpm.setBounds(44, 79, 33, 16);
					}
					{
						lblNextel = new JLabel();
						pnlClientes.add(lblNextel);
						lblNextel.setText("Nextel:");
						lblNextel.setBounds(203, 21, 43, 16);
					}
					{
						txtTel1 = new JTextField();
						pnlClientes.add(txtTel1);
						txtTel1.setBounds(80, 18, 108, 23);
						txtTel1.setEditable(false);
					}
					{
						txtTel2 = new JTextField();
						pnlClientes.add(txtTel2);
						txtTel2.setBounds(80, 47, 108, 23);
						txtTel2.setEditable(false);
					}
					{
						txtRpm = new JTextField();
						pnlClientes.add(txtRpm);
						txtRpm.setBounds(80, 76, 109, 23);
						txtRpm.setEditable(false);
					}
					{
						txtNextel = new JTextField();
						pnlClientes.add(txtNextel);
						txtNextel.setBounds(244, 18, 114, 23);
						txtNextel.setEditable(false);
					}
					{
						txtFax = new JTextField();
						pnlClientes.add(txtFax);
						txtFax.setBounds(244, 76, 114, 23);
						txtFax.setEditable(false);
					}
					{
						lblCel = new JLabel();
						pnlClientes.add(lblCel);
						lblCel.setText("Celular:");
						lblCel.setBounds(199, 50, 47, 16);
					}
					{
						txtCel = new JTextField();
						pnlClientes.add(txtCel);
						txtCel.setBounds(244, 47, 114, 23);
						txtCel.setEditable(false);
					}
				}
			}
			
			txtPrecioVentaCompra = new JTextField();
			pnlAbajo.add(txtPrecioVentaCompra);
			txtPrecioVentaCompra.setBounds(658, 0, 82, 21);

			lblPrecioVenta = new JLabel();
			pnlAbajo.add(lblPrecioVenta);
			lblPrecioVenta.setText("Precio Venta:");
			lblPrecioVenta.setBounds(472, 4, 80, 14);

			lblIgv = new JLabel();
			pnlAbajo.add(lblIgv);
			lblIgv.setText("IGV:");
			lblIgv.setBounds(472, 30, 37, 14);

			lblTotal = new JLabel();
			pnlAbajo.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(472, 54, 44, 14);

			txtPrecioVenta = new JTextField();
			pnlAbajo.add(txtPrecioVenta);
			txtPrecioVenta.setBounds(564, 1, 82, 21);

			txtIgv = new JTextField();
			pnlAbajo.add(txtIgv);
			txtIgv.setBounds(564, 26, 82, 21);

			txtTotal = new JTextField();
			pnlAbajo.add(txtTotal);
			txtTotal.setBounds(564, 52, 82, 21);

			txtIgvCompra = new JTextField();
			pnlAbajo.add(txtIgvCompra);
			txtIgvCompra.setBounds(658, 26, 82, 21);

			txtTotalIgv = new JTextField();
			pnlAbajo.add(txtTotalIgv);
			txtTotalIgv.setBounds(658, 52, 82, 21);

			txtPrecioVentaDif = new JTextField();
			pnlAbajo.add(txtPrecioVentaDif);
			txtPrecioVentaDif.setBounds(752, 1, 82, 21);

			txtIgvDif = new JTextField();
			pnlAbajo.add(txtIgvDif);
			txtIgvDif.setBounds(752, 26, 82, 21);

			txtTotalDif = new JTextField();
			pnlAbajo.add(txtTotalDif);
			txtTotalDif.setBounds(752, 52, 82, 21);

			btnGuardar = new JButton();
			pnlAbajo.add(btnGuardar);
			btnGuardar.setText("Guardar");
			btnGuardar.setBounds(27, 12, 89, 24);

			btnGuardarCotizacionFinal = new JButton();
			pnlAbajo.add(btnGuardarCotizacionFinal);
			btnGuardarCotizacionFinal.setText("Guardar Cotizacion Final");
			btnGuardarCotizacionFinal.setBounds(257, 12, 189, 24);

			lblPesoTotal = new JLabel();
			pnlAbajo.add(lblPesoTotal);
			lblPesoTotal.setText("PesoTotal:");
			lblPesoTotal.setBounds(1019, 3, 74, 16);

			txtPesoTotal = new JTextField();
			pnlAbajo.add(txtPesoTotal);
			txtPesoTotal.setBounds(1079, 1, 84, 24);

			btnEnviar = new JButton();
			pnlAbajo.add(btnEnviar);
			btnEnviar.setText("Enviar");
			btnEnviar.setBounds(136, 12, 101, 24);

			txtPrueba = new JTextField();
			pnlAbajo.add(txtPrueba);
			txtPrueba.setBounds(933, 31, 122, 20);
			txtPrueba.setVisible(false);

			txtPrueba2 = new JTextField();
			pnlAbajo.add(txtPrueba2);
			txtPrueba2.setBounds(933, 55, 122, 20);
			txtPrueba2.setVisible(false);

			txtRuta = new JTextField();
			pnlAbajo.add(txtRuta);
			txtRuta.setBounds(27, 47, 325, 21);
			txtRuta.setEditable(false);

			btnAdjuntar = new JButton();
			pnlAbajo.add(btnAdjuntar);
			btnAdjuntar.setText("Adjuntar");
			btnAdjuntar.setBounds(358, 46, 88, 26);
			btnAdjuntar.setSize(88, 24);

			pnlFactura = new JPanel();
			pnlAbajo.add(pnlFactura);
			pnlFactura.setBorder(BorderFactory.createTitledBorder("Generar Factura"));
			pnlFactura.setLayout(null);
			pnlFactura.setBounds(875, 25, 288, 69);
			{
				txtPorcentaje = new JTextField();
				pnlAbajo.add(txtPorcentaje);
				txtPorcentaje.setBounds(939, 1, 75, 21);
			}
			{
				lblPorcentaje = new JLabel();
				pnlAbajo.add(lblPorcentaje);
				lblPorcentaje.setText("Porcentaje:");
				lblPorcentaje.setBounds(876, 3, 69, 16);
			}

			btnFactura = new JButton();
			pnlFactura.add(btnFactura);
			btnFactura.setText("Generar Factura");
			btnFactura.setBounds(151, 21, 126, 21);

			lblSoles = new JLabel();
			pnlFactura.add(lblSoles);
			lblSoles.setText("Soles(S/.):");
			lblSoles.setBounds(7, 21, 63, 14);

			lblDolares = new JLabel();
			pnlFactura.add(lblDolares);
			lblDolares.setText("Dolares($):");
			lblDolares.setBounds(7, 42, 63, 14);

			rdbSoles = new JRadioButton();
			pnlFactura.add(rdbSoles);
			rdbSoles.setBounds(72, 21, 21, 21);
			rdbSoles.setEnabled(false);
			rdbSoles.addActionListener(this);

			rdbDolares = new JRadioButton();
			pnlFactura.add(rdbDolares);
			rdbDolares.setBounds(72, 41, 21, 21);
			rdbDolares.setEnabled(false);

			rdbDolares.addActionListener(this);

			btnFactura.addActionListener(this);

			btnAdjuntar.addActionListener(this);

			btnEnviar.addActionListener(this);

			btnGuardarCotizacionFinal.addActionListener(this);

			btnGuardar.addActionListener(this);

			cboSexo.addItem("¿?");
			cboSexo.addItem("Masculino");
			cboSexo.addItem("Femenino");

			scrLista = new JScrollPane();
			pnlMedio.add(scrLista);
			scrLista.setBounds(12, 93, 918, 421);
			scrLista.setPreferredSize(new java.awt.Dimension(1073, 402));

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);

			
			btnFactura.setEnabled(false);
			
			//btnEnviarCliente.setLayout(btnVerificarClienteLayout);

			//objBuscarCliAut= new BuscarClienteAut();
			
			//objBuscarProdAgregar = new BuscarProdMantCot();
			objCambiarCant = new CambiarCant();
			objCamTiemEntrega =new CambiarTiempoEntrega();
			objCambPeso = new CambiarPeso();

//String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Unit$","P.Total$","P.Costo$","C.Total$","Dif.$","Fecha","%","Proveedor"};			
			TableColumn Cant = tblLista.getColumn ("Cant"),Und = tblLista.getColumn ("Und"),Descripcion = tblLista.getColumn ("Descripcion")
			,Marca = tblLista.getColumn ("Marca"),Modelo = tblLista.getColumn ("Modelo"),PTotal= tblLista.getColumn ("P.Unit$"),IGV$=tblLista.getColumn ("IGV$"),TotalD = tblLista.getColumn ("P.Total$")
			,Totales$= tblLista.getColumn ("Totales $"),Costo  = tblLista.getColumn ("P.Costo$")
			,Total = tblLista.getColumn ("C.Total$"),Dif = tblLista.getColumn ("Dif.$")
			,PunitS= tblLista.getColumn ("P.Unit S/."),IGVS= tblLista.getColumn ("IGV S/."),PTotalS= tblLista.getColumn ("P.Total S/.")
			,TotalesS= tblLista.getColumn ("Totales S/."),Fecha = tblLista.getColumn ("Fecha"),por = tblLista.getColumn ("%")
			,Proveedor = tblLista.getColumn ("Proveedor"),iD = tblLista.getColumn ("Id"),tiempo = tblLista.getColumn ("Tiempo Entrega")
			,peso = tblLista.getColumn ("Peso Prod."), pesoCarr= tblLista.getColumn ("P.Carrete");
			//Id
			//"P.Unit S/.","IGV S/.","P.Total S/."
			iD.setPreferredWidth(10);
			Cant.setPreferredWidth(13);
			Und.setPreferredWidth(13);
			Descripcion.setPreferredWidth(370);
			Marca.setPreferredWidth(40);
			Modelo.setPreferredWidth(40);
			PTotal.setPreferredWidth(35);
			IGV$.setPreferredWidth(35);
			TotalD.setPreferredWidth(35);
			Totales$.setPreferredWidth(35);
			Costo.setPreferredWidth(35);
			Total.setPreferredWidth(35);
			Dif.setPreferredWidth(35);
			PunitS.setPreferredWidth(35);
			IGVS.setPreferredWidth(35);
			PTotalS.setPreferredWidth(35);
			TotalesS.setPreferredWidth(35);
			Fecha.setPreferredWidth(50);
			por.setPreferredWidth(30);
			Proveedor.setPreferredWidth(50);
			tiempo.setPreferredWidth(80);
			peso.setPreferredWidth(50);
			pesoCarr.setPreferredWidth(50);
			

			pack();
			
			 /*Tcol=tblLista.getColumnModel().getColumn(23);
	 		 Tcol.setCellEditor(tblLista.getDefaultEditor(Boolean.class));  
	 		 Tcol.setCellRenderer(tblLista.getDefaultRenderer(Boolean.class));
	 		 chkheader=new JCheckBoxHeader2(tblLista);
	 		 Tcol.setHeaderRenderer(chkheader);*/
			
			if(objReporte.entrada==1){
				System.out.println("ENTROOOOOOOO");
				listarCotiTarea(); 
			}else{
				listarCot();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void listarCotiTarea(){

		
			objBuscarCotTarea = new BuscarCotizacionTarea();
			String agente="",nomagen="";
			
			 CODCOT=objBuscarCotTarea.COD_COT;
	         txtNCotizacion.setText(CODCOT);
	         IDECOT =objBuscarCotTarea.IDE_COT;
	         txtNroModificacion.setText(IDECOT);
	         txtSeñores2.setText(objBuscarCotTarea.NOM_CLI);
	         txtAtencion2.setText(objBuscarCotTarea.CONA_CLI);
	         txtReferencia.setText(objBuscarCotTarea.REF_COT);
	         txtFecha.setText(objBuscarCotTarea.FEC_COT);
	         agente=objBuscarCotTarea.AGE_CLI;
	         if(agente.equals("0")){
	        	 nomagen="";
	         }else if(agente.equals("1")){
	        	 nomagen="Con Agente de Retencion";
	        	 txtAgente.setBackground(Color.red);
	        	 txtAgente.setForeground(Color.white);
	         }else{
	        	 nomagen="Sin Agente de Retencion";
	         }
	         txtAgente.setText(nomagen);
	         txtEmail1.setText(objBuscarCotTarea.MAILA_CLI);
	         txtEmail2.setText(objBuscarCotTarea.MAILB_CLI);
	         txtEmpEst.setText("ELECTRO CORNEJO");
	         txtTel1.setText(objBuscarCotTarea.TEL1);
	         txtTel2.setText(objBuscarCotTarea.TEL2);
	         txtFax.setText(objBuscarCotTarea.FAX);
	         txtRpm.setText(objBuscarCotTarea.RPM);
	         txtNextel.setText(objBuscarCotTarea.NEXTEL);
	         txtCel.setText(objBuscarCotTarea.CEL);
	         cboSexo.setSelectedIndex(Integer.parseInt(objBuscarCotTarea.SEX_CLI));
	         	         
	         if(verificarCot(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT))==1){
    	         listarCotizacion(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
    	     }else{
    	         listarCotizacionFinal(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
    	     }
	         
	         rdbDolares.setEnabled(true);
	         rdbSoles.setEnabled(true);
	         calcular();
	         objBuscarCot=null;
	         estado=0;
	    

	 		 
		
	}
	
	
	
	public void listarCot(){
		
		String agente="",nomagen="";
		
		objBuscarCot= new BuscarCotizacion();
		
        	 CODCOT=objBuscarCot.COD_COT;
	         txtNCotizacion.setText(CODCOT);
	         IDECOT =objBuscarCot.IDE_COT;
	         txtNroModificacion.setText(IDECOT);
	         txtSeñores2.setText(objBuscarCot.NOM_CLI);
	         txtAtencion2.setText(objBuscarCot.CONA_CLI);
	         txtReferencia.setText(objBuscarCot.REF_COT);
	         txtFecha.setText(objBuscarCot.FEC_COT);
	         agente=objBuscarCot.AGE_CLI;
	         est=objBuscarCot.estado;
	         if(agente.equals("0")){
	        	 nomagen="";
	         }else if(agente.equals("1")){
	        	 nomagen="Con Agente de Retencion";
	        	 txtAgente.setBackground(Color.red);
	        	 txtAgente.setForeground(Color.white);
	         }else{
	        	 nomagen="Sin Agente de Retencion";
	         }
	         txtAgente.setText(nomagen);
	         txtEmail1.setText(objBuscarCot.MAILA_CLI);
	         txtEmail2.setText(objBuscarCot.MAILB_CLI);
	         txtTel1.setText(objBuscarCot.TEL1);
	         txtTel2.setText(objBuscarCot.TEL2);
	         txtFax.setText(objBuscarCot.FAX);
	         txtRpm.setText(objBuscarCot.RPM);
	         txtNextel.setText(objBuscarCot.NEXTEL);
	         txtCel.setText(objBuscarCot.CEL);
	         cboSexo.setSelectedIndex(Integer.parseInt(objBuscarCot.SEX_CLI));
	         if(est==1){
	        	 txtEmpEst.setText("ELECTRO CORNEJO");
	         }else{
	        	 txtEmpEst.setText("CyE Global Electric");
	         }
	         
	         	    	         
	         if(verificarCot(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT))==1){
    	         listarCotizacion(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
    	     }else{
    	         listarCotizacionFinal(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
	    	     }
	         
	         rdbDolares.setEnabled(true);
	         rdbSoles.setEnabled(true);
	         calcular();
	         objBuscarCot=null;
	         estado=0;
	         System.out.println("0");//ACEPTAR
         
		
	}
	
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=2;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	public  Double formato2(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=2;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	public double pasarPorceGana(int cod_prod){
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs =  null;
		double porce=0;
		
		try {
		objAccesoBD.crearConexion();
		String sql="SELECT RUB.POR_RUBRO FROM tb_producto PROD INNER JOIN tb_rubro RUB " +
				" ON PROD.COD_RUBRO=RUB.COD_RUBRO " +
				" WHERE PROD.COD_PROD='"+cod_prod+"';";
		
	    rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
			    porce=rs.getDouble(1);
				return porce;		
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		return porce;
	}
	
	public void calcularParte(int i){
		
		double costoreal,igv$,punits,igvs,ptotals;
		BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
		double porc=0;
		if(cambiaPor==0){
			System.out.println("CEROOOOOOOOOO");
			porc=pasarPorceGana(Integer.parseInt(objCotVarios.getCodprod()));
		}else{
			System.out.println("UNOOOOOOOOOOO");
			porc=Double.parseDouble(objCotVarios.getPorgacot());
		}
		String cantiViene=""+modelo2.getValueAt(i, 1);
		double cantViene=Double.parseDouble(cantiViene.trim());
		costoreal=formato(Double.parseDouble(objCotVarios.getCoste()));	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		double precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		igv$=precioConPorceXCant*0.18;
		igv$=formato(igv$);
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		punits=precioConPorce*tipoCambioVenta();
		igvs=igv$*tipoCambioVenta();
		ptotals=precioConPorceXCant*tipoCambioVenta();
		double peso=0;
		String pesoprod=objCotVarios.getPesoprod();
		if(pesoprod.equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(objCotVarios.getPesoprod());
		}
			
		String pesofinal=""+peso;
		objCotVarios.setCosteEntreporc(""+precioConPorce);
		objCotVarios.setIgv$(""+igv$);
		objCotVarios.setCosteXporcXcant(""+precioConPorceXCant);
		objCotVarios.setCoste(""+costoreal);
		objCotVarios.setCosteXcant(""+costoRealXCant);
		objCotVarios.setDife(""+dife);
		objCotVarios.setPunits(""+punits);
		objCotVarios.setIgvs(""+igvs);
		objCotVarios.setPtotals(""+ptotals);
		
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorce)), i, 6);//P.Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(igv$)), i, 7);//igv$
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorceXCant)), i, 8);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoreal)), i, 10);//Costo $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoRealXCant)), i, 11);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(dife)), i, 12);//Dif. $
		 modelo2.setValueAt(Double.parseDouble(""+formato(punits)), i, 13);//punits
		 modelo2.setValueAt(Double.parseDouble(""+formato(igvs)), i, 14);//igvs
		 modelo2.setValueAt(Double.parseDouble(""+formato(ptotals)), i, 15);//ptotals
		 modelo2.setValueAt(Double.parseDouble(""+porc), i, 18);//%
		 modelo2.setValueAt(Double.parseDouble(""+pesofinal), i, 21);//Peso
		 
		 	 
		 
	}
	
  /*****************************************************************************************/
	
	public void calcularTotales(){
		
		double totales$=0,totalesS=0,Ptotal$=0,PtotalS=0;
		int fila = tblLista.getSelectedRow();
		//int cont=0;
		
		
		for (int i = fila; i < modelo2.getRowCount(); i++) {
			
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")){
				
			}else{
				/*cont++;
				if(cont==46){
					numeroDeFilasFac=cont;
				}*/
				BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
				
				if(fila==0){
					
					Ptotal$=Double.parseDouble(""+modelo2.getValueAt(i, 8));
					PtotalS=Double.parseDouble(""+modelo2.getValueAt(i, 15));
					if(i==fila){
						//System.out.println("FILA ES CERO");
						totales$=Ptotal$;
						objCotVarios.setTotal$(""+totales$);
						modelo2.setValueAt(Double.parseDouble(""+formato(totales$)), i, 9);
	                      
						totalesS=PtotalS;
						objCotVarios.setTotals(""+totalesS);
						modelo2.setValueAt(Double.parseDouble(""+formato(totalesS)), i, 16);
					}else{
						//System.out.println("FILA ES DIFERENTE DE CERO");
						totales$=Double.parseDouble(""+modelo2.getValueAt(i-1, 9))+
						Double.parseDouble(""+modelo2.getValueAt(i, 8));
						objCotVarios.setTotal$(""+totales$);
						modelo2.setValueAt(Double.parseDouble(""+formato(totales$)), i,9);
						
						totalesS=Double.parseDouble(""+modelo2.getValueAt(i-1, 16))+
						Double.parseDouble(""+modelo2.getValueAt(i, 15));
						objCotVarios.setTotals(""+totalesS);
						modelo2.setValueAt(Double.parseDouble(""+formato(totalesS)), i, 16);
					}
					
					
				}else{
					//System.out.println("FILA ES MAYOR CERO");
					totales$=Double.parseDouble(""+modelo2.getValueAt(i-1, 9))+
					Double.parseDouble(""+modelo2.getValueAt(i,8));
					objCotVarios.setTotal$(""+totales$);
					modelo2.setValueAt(Double.parseDouble(""+formato(totales$)), i, 9);
					
					totalesS=Double.parseDouble(""+modelo2.getValueAt(i-1, 16))+
					Double.parseDouble(""+modelo2.getValueAt(i, 15));
					objCotVarios.setTotals(""+totalesS);
					modelo2.setValueAt(Double.parseDouble(""+formato(totalesS)), i, 16);
				}
				
				//contaFilasFac++;
			}
			
		}
		
	}
/*******************************************************************************************/
      public void calcularTotalesBorrar(){
		
		double totales$=0,totalesS=0,Ptotal$=0,PtotalS=0;
		
		
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")){
				
			}else{
				
				BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
				
				if(i==0){
					Ptotal$=Double.parseDouble(""+modelo2.getValueAt(i, 8));
					PtotalS=Double.parseDouble(""+modelo2.getValueAt(i, 15));
				}
				/****************************************************************/
				if(i==1){
					totales$=Ptotal$+Double.parseDouble(""+modelo2.getValueAt(i, 8));
					objCotVarios.setTotal$(""+totales$);
					modelo2.setValueAt(Double.parseDouble(""+formato(totales$)), i, 9);
                     	
					totalesS=PtotalS+Double.parseDouble(""+modelo2.getValueAt(i, 15));
					objCotVarios.setTotals(""+totalesS);
					modelo2.setValueAt(Double.parseDouble(""+formato(totalesS)), i, 16);
					
				}else{
					totales$=totales$+Double.parseDouble(""+modelo2.getValueAt(i, 8));
					objCotVarios.setTotal$(""+totales$);
					modelo2.setValueAt(Double.parseDouble(""+formato(totales$)), i, 9);
                     	
					totalesS=totalesS+Double.parseDouble(""+modelo2.getValueAt(i, 15));
					objCotVarios.setTotals(""+totalesS);
					modelo2.setValueAt(Double.parseDouble(""+formato(totalesS)), i, 16);
				
					
				}
				
				
			}
			
		}
		
	}
   /********************************************************************************************/
	
    public void calcularParte(int i,Double por){
		
		double costoreal,igv$,punits,igvs,ptotals;
		BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
		//double porc=pasarPorceGana(Integer.parseInt(objCotVarios.getCodprod()));
		String cantiViene=""+modelo2.getValueAt(i, 1);
		int cantViene=Integer.parseInt(cantiViene.trim());
		costoreal=formato(Double.parseDouble(objCotVarios.getCoste()));	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		double precioConPorce=costoreal/por;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		igv$=precioConPorceXCant*0.18;
		igv$=formato(igv$);
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		punits=precioConPorce*tipoCambioVenta();
		igvs=igv$*tipoCambioVenta();
		ptotals=precioConPorceXCant*tipoCambioVenta();
		double peso=0;
		String pesoprod=objCotVarios.getPesoprod();
		if(pesoprod.equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(objCotVarios.getPesoprod());
		}
		
		String pesofinal=""+peso;
		objCotVarios.setCosteEntreporc(""+precioConPorce);
		objCotVarios.setIgv$(""+igv$);
		objCotVarios.setCosteXporcXcant(""+precioConPorceXCant);
		objCotVarios.setCoste(""+costoreal);
		objCotVarios.setCosteXcant(""+costoRealXCant);
		objCotVarios.setDife(""+dife);
		objCotVarios.setPunits(""+punits);
		objCotVarios.setIgvs(""+igvs);
		objCotVarios.setPtotals(""+ptotals);
		
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorce)), i, 6);//P.Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(igv$)), i, 7);//igv$
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorceXCant)), i, 8);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoreal)), i, 10);//Costo $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoRealXCant)), i, 11);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(dife)), i, 12);//Dif. $
		 modelo2.setValueAt(Double.parseDouble(""+formato(punits)), i, 13);//punits
		 modelo2.setValueAt(Double.parseDouble(""+formato(igvs)), i, 14);//igvs
		 modelo2.setValueAt(Double.parseDouble(""+formato(ptotals)), i, 15);//ptotals
		 modelo2.setValueAt(Double.parseDouble(""+por), i, 18);//%
		 modelo2.setValueAt(Double.parseDouble(""+pesofinal), i, 21);//Peso
		
		
	}
/*	private boolean  abrirArchivo(){
		  String vieneArchivo="";
	        JFileChooser selectorArchivo=new JFileChooser();
	        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        
	        int resultado=selectorArchivo.showOpenDialog(this);
	        
	        if(resultado==JFileChooser.CANCEL_OPTION)
	            return false;
	        
	        File archivo=selectorArchivo.getSelectedFile();
	        
	        if(archivo==null||archivo.getName().equals("")){
	            JOptionPane.showMessageDialog(this,"Nombre Del Archivo Incorrecto",
	            "Nombre Del Archivo Incorrecto",JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        vieneArchivo=""+archivo;
	        txtNCotizacion.setText(vieneArchivo.trim());
	        
	        try {
				arrayExcel.cargarExcel(vieneArchivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int tam=arrayExcel.tamaño();
			 System.out.println("ESTE ES EL TAMAÑO DE TRANSCOTIAUTOMATICA:"+tam);
				if(tam>0){for (int i = 0; i < arrayExcel.tamaño(); i++) {
					
							BeanExcel objExcel=arrayExcel.obtener(i);
							
	
							Object obj[]={objExcel.getId(),objExcel.getCant(),objExcel.getUmedida(),objExcel.getDescripcion(),objExcel.getMarca()	};
								
							modelo2.addRow(obj);			
							
				}	}
				BeanExcel objExcel=arrayExcel.obtener(5);
				txtSeñores.setText(objExcel.getSeñor());
				txtSeñores2.setText(objExcel.getSeñor());
				txtAtencion.setText(objExcel.getAtencion());
				txtAtencion2.setText(objExcel.getAtencion());
	        
				   return true; 
	         }*/
	/********CODIGO DE LA ULTIMA FECHA************************/
	public int codigoFecha(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				int cod=Integer.parseInt(rs.getString(1));
				return cod;		
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		return 0;
	}
	/***********************************************/
	/********TIPO DE CAMBIO************************/
	public double tipoCambioVenta(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				double cambio=rs.getDouble(4);
				return cambio;		
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
	/***********************************************/
	/***********************************************/
	 public int retornaUltimoIdCotizacion(){
		 
		 
			AccesoBD objAccesoBD = new AccesoBD();
			ResultSet rs =  null;
			
			try {
			objAccesoBD.crearConexion();
			BeanCotizacionVarios objBeanCotVar=objServletCotVarios.obtener(0);
			String codCot=objBeanCotVar.getCodcot();
			//SELECT max(ide_cot) FROM cotizacion where cod_Cot='3';
			String maxCodPregunta="SELECT max(ide_cot) FROM tb_cotizacion where cod_Cot='"+codCot+"';";
			System.out.println();
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=0;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					cod=cod+1;
					return cod;
					}
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
	/******************************************/
	 /******************************************/
	 public void  datosCliente(String cod_cli){
		 
			AccesoBD objAccesoBD = new AccesoBD();
			ResultSet rs = null;
			
			try {
				
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT CLI.COD_CLI,CLI.NOM_CLI,CLI.CONA_CLI,CLI.SEX_CLI,CLI.DIR_CLI,CLI.TEL1A_CLI," +
					" CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,TIPCLI.nom_tipo,CLI.ruc_cli FROM tb_CLIENTE CLI "+
                    " INNER JOIN tb_tipocliente TIPCLI ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                    " WHERE COD_CLI='"+cod_cli+"';";
			
			//String insertarPregunta="INSERT INTO VALUES("""""")"
			rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			
			
				int cod = 0;
				while(rs.next()){
					BeanCliente objCli= new BeanCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12),rs.getString(13));
					objServletCliente.adicionar(objCli);
													
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				objAccesoBD.cerrarResultSet(rs);
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}
		
		 } 
	/******************************************/
	 /******************************************/
	 public void  datosClientecye(String cod_cli){
		 
		 
			AccesoBD2 objAccesoBD = new AccesoBD2();
			ResultSet rs = null;
			
			try {
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT CLI.COD_CLI,CLI.NOM_CLI,CLI.CONA_CLI,CLI.SEX_CLI,CLI.DIR_CLI,CLI.TEL1A_CLI," +
					" CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,TIPCLI.nom_tipo,CLI.ruc_cli FROM tb_CLIENTE CLI "+
                    " INNER JOIN tb_tipocliente TIPCLI ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                    " WHERE COD_CLI='"+cod_cli+"';";
			
			rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			
			
				int cod = 0;
				while(rs.next()){
					BeanCliente objCli= new BeanCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
							rs.getString(12),rs.getString(13));
					objServletCliente.adicionar(objCli);
													
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				objAccesoBD.cerrarResultSet(rs);
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}
		
		 } 
	/******************************************/
	
	public void calcular(){
		
		
        //String titulo2[]={"Cant","Und","Descripcion","Marca","P.Total $",
		//"Total $","Costo $","Total$","Dif. $","Fecha","%","Proveedor"};		
		double precioTsuma = 0,costoTsuma = 0,difTsuma = 0,
		precioTsumaSigv = 0,costoTsumaSigv = 0,difTsumaSigv = 0,
		precioTsumaCigv = 0,costoTsumaCigv = 0,difTsumaCigv = 0;
		double pesoTotal=0;
		double TotalPunit=0,PUnit=0,sumaTotal=0;
		int cont=0;
		double porc=0,canti=0;
	
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")){
				
			}else{
				cont++;
				if(cont==46){
					numeroDeFilasFac=cont;
				}
			
		    canti=Double.parseDouble(""+modelo2.getValueAt(i, 1));
			precioTsuma=precioTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 8));
			costoTsuma=costoTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 11));
			difTsuma=difTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 12));
			
			pesoTotal+=(canti*(Double.parseDouble(""+modelo2.getValueAt(i, 21))))+
			(Double.parseDouble(""+modelo2.getValueAt(i, 22)));
			
			PUnit=((Double.parseDouble(""+modelo2.getValueAt(i, 6)))*tipoCambioVenta()*canti);
			sumaTotal+=PUnit;
			contaFilasFac++;
			}
			
		}
		/*PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 5)))*tipoCambioVenta();
	    Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));*/
		
		precioTsumaSigv=precioTsuma*0.18;
		costoTsumaSigv=costoTsuma*0.18;
		difTsumaSigv=difTsuma*0.18;
		
		precioTsumaCigv=precioTsumaSigv+precioTsuma;
		costoTsumaCigv=costoTsumaSigv+costoTsuma;
		difTsumaCigv=difTsumaSigv+difTsuma;   
		TotalPunit=sumaTotal*1.18;
		
		porc=(precioTsuma/costoTsuma)-1;
		
		
		txtPrecioVenta.setText(""+formato(precioTsuma));
		txtPrecioVentaCompra.setText(""+formato(costoTsuma));
		txtPrecioVentaDif.setText(""+formato(difTsuma));
		
		txtIgv.setText(""+formato(precioTsumaSigv));
		txtIgvCompra.setText(""+formato(costoTsumaSigv));
		txtIgvDif.setText(""+formato(difTsumaSigv));
		
		txtTotal.setText(""+formato(precioTsumaCigv));
		txtTotalIgv.setText(""+formato(costoTsumaCigv));
		txtTotalDif.setText(""+formato(difTsumaCigv));
		txtPesoTotal.setText(""+formato(pesoTotal));
		txtPrueba2.setText(""+formato2(TotalPunit));

		txtPorcentaje.setText(""+formato(porc));
		
		/*System.out.println("Igv :"+formato2(STotal*0.18));
		System.out.println("Suma total :"+formato2(STotal*1.18));*/
		//TotalFac=formato2(TotalPunit);
	}
/***********************************************/
	
	public void borrarTodo(){
		txtNCotizacion.setText("");
		txtNroModificacion.setText("");
		txtAtencion2.setText("");
		txtSeñores2.setText("");
		txtPrecioVenta.setText("");
		txtIgv.setText("");
		txtIgvCompra.setText("");
		txtIgvDif.setText("");
		txtPrecioVentaCompra.setText("");
		txtPrecioVentaDif.setText("");
		txtTotal.setText("");
		txtTotalDif.setText("");
		txtTotalIgv.setText("");
		txtReferencia.setText("");
		txtPesoTotal.setText("");
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		objServletCotVarios.eliminarTodo();
		objCambiarCant=null;
		objCambiarCant= new CambiarCant();
		objCamTiemEntrega=null;
		objCamTiemEntrega=new CambiarTiempoEntrega();
		
		
	}
	
	public Double precioCodigos(String codprod,String codprove,String codmar,String codumed){
		Double costeviene = null;
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT PROD.NOM_PROD,PROVE.NOM_PROVE,UMED.NOM_UMED,MAR.NOM_MAR,DET.MON_DET,IF((DET.IGV_DET=0),'Con IGV','Mas IGV') AS IGV,DET.COS_DET, "+
				" ROUND((( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))  "+
			"    )) ,3)   as COSTO "+
			"   FROM tb_proveprodmarumed1 DET "+
			"  INNER JOIN tb_producto PROD "+
			"    ON DET.COD_PROD=PROD.COD_PROD "+
			"  INNER JOIN tb_proveedor PROVE "+
			"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"   INNER JOIN tb_marcas MAR "+
			"   ON MAR.COD_MAR=DET.COD_MAR "+
			"   INNER JOIN tb_umed UMED "+
			"   ON UMED.COD_UMED=DET.COD_UMED "+
			"   INNER JOIN tb_rubro RUB "+
			"   ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
			"  WHERE  DET.COD_PROD='"+codprod+"' AND DET.COD_PROVE='"+codprove+"' AND DET.COD_UMED='"+codumed+"' AND DET.COD_MAR='"+codmar+"' ; " ;
			
	
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			if(rs.next()){
				costeviene=rs.getDouble(7);			
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		return costeviene;
	}
	
	public Integer verificarCero(String codcos,Integer i){
		Integer codcosnuevo;
		if(codcos.equals("0")){
		String	codprodp=objServletCotVarios.obtener(i).getCodprod();
		String	 codprovep=objServletCotVarios.obtener(i).getCodprove();
		String	 codmarp=objServletCotVarios.obtener(i).getCodmar();
		String	 codumedp=objServletCotVarios.obtener(i).getCodumed();
		Double costever=precioCodigos(codprodp, codprovep, codmarp, codumedp);
		 codcosnuevo=ingresarCosto(costever)	;
			
			
		}else{
			codcosnuevo=Integer.parseInt(codcos);
		}
		return codcosnuevo;
		
	}
	public int guardarFinal(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//NOTA :AL GUARDAR SE TIENE QUE DAR CUENTA QUE NO GUARDE CUANDO HAY ERROR
		int tam= objServletCotVarios.tamaño();
		int ide_cot=retornaUltimoIdCotizacion();
		int op = 0;
		 ref=txtReferencia.getText();
		String guardarCotizacion = null;
		if(ide_cot==0){
			objGUI.mostrarAviso("HUBO UN ERROR EN EL IDE_COT");
		}else{
			
		
			if(tam>0){
				
				try {
					for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
										
						BeanCotizacionVarios objCotVarios = objServletCotVarios.obtener(i);
						guardarCotizacion="INSERT INTO tb_cotizacion(cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli,cod_cos , " +
								" cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot,tiempo_entrega,est_emp,pesoCarr,est_envio) VALUES('"+objCotVarios.getCodcot()+"','"+modelo2.getValueAt(i, 0)+"','"+objCotVarios.getCodprove()+"','"
						+objCotVarios.getCodprod()+"','"+objCotVarios.getCodmar()+"','"+objCotVarios.getCodumed()+"','"+objCotVarios.getCodcli()+"','"
						+verificarCero(objCotVarios.getCodCoste(), i)+
						"','"+codigoFecha()+
						"','"+ref+"','"+objCotVarios.getCancot()+"','"+modelo2.getValueAt(i, 18)+"',CURDATE(),'"
						+objGlobal.COD_VEN+"','"+0+"','"+1+"','"+ide_cot+"','"+objCotVarios.getTiempoentrega()+"','"+est+"','"+modelo2.getValueAt(i, 22)+"','0');";
							System.out.println(guardarCotizacion);
							
								 op= objAccesoBD.ejecutarActualizacion(guardarCotizacion);
						
					}
					
					if(op==0){
						ide_cot=0;
						System.out.println(guardarCotizacion);
						objGUI.mostrarAviso("Hubo un error al Ingresar su cotizacion");
						objGUI.mostrarAviso("Este puede ser un posible ERROR\n"+
								guardarCotizacion);
						System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
					}else{
						objGUI.mostrarAviso("Se ingreso su Cotizacion");
						System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
					}
				
		        }finally{
					//objAccesoBD.cerrarResultSet(rs);
					objAccesoBD.cerrarStatement();
					objAccesoBD.cerrarConexion();  
		        }
		}
	  }
	
		return ide_cot;
	}
/**************************************************************************************************************************/
	  public int guardar(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//NOTA :AL GUARDAR SE TIENE QUE DAR CUENTA QUE NO GUARDE CUANDO HAY ERROR
		int tam= objServletCotVarios.tamaño();
		int ide_cot=retornaUltimoIdCotizacion();
		int op = 0;
		Integer numItem=0;
		 ref=txtReferencia.getText();
		String guardarCotizacion = null;
		if(ide_cot==0){
			objGUI.mostrarAviso("HUBO UN ERROR EN EL IDE_COT");
		}else{
			
		
		if(tam>0){for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
			numItem=numItem+1;
			BeanCotizacionVarios objCotVarios = objServletCotVarios.obtener(i);
			
        //cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, cod_prodalt,
		//cod_cam, can_cot, porga_cot, fec_cot, cod_ven, ide_cot                //cod_umed, cod_cli,cod_cos ,cod_prodalt,
			guardarCotizacion="INSERT INTO tb_cotizacion(cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, " +
					" cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot,tiempo_entrega,est_emp,pesoCarr,est_envio) VALUES('"+objCotVarios.getCodcot()+"','"+numItem+"','"+objCotVarios.getCodprove()+"','"
			+objCotVarios.getCodprod()+"','"+objCotVarios.getCodmar()+"','"+objCotVarios.getCodumed()+"','"+objCotVarios.getCodcli()+"','"+codigoFecha()+
			"','"+ref+"','"+objCotVarios.getCancot()+"','"+modelo2.getValueAt(i, 18)+"',CURDATE(),'"
			+objGlobal.COD_VEN+"','"+0+"','"+1+"','"+ide_cot+"','"+objCotVarios.getTiempoentrega()+"','"+est+"','"+modelo2.getValueAt(i, 22)+"','0');";
				System.out.println(guardarCotizacion);
				try {
					 op= objAccesoBD.ejecutarActualizacion(guardarCotizacion);
				} catch (Exception e) {
					// TODO: handle exception
					op=0;
					System.out.println("ESTO NO KISO GUARDAR:"+guardarCotizacion);
				}finally{
					if(op==0){
						objGUI.mostrarAviso("HUBO UN ERROR");
					}
				}
				
			}	
		if(op==0){ide_cot=0;
		System.out.println(guardarCotizacion);
		objGUI.mostrarAviso("Hubo un error al Ingresar su cotisacion");
		objGUI.mostrarAviso("Este puede ser un posible ERROR\n"+
				guardarCotizacion);
		System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
		}else{
			objGUI.mostrarAviso("Se ingreso su Cotizacion");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
		}
		
		}}//
		objAccesoBD.cerrarConexion();
		return ide_cot;
			}
   /**************************************************************************************************************/
	
	  void pasarExcel(int ide_cot) {
		     
		     
		     datosCliente(objServletCotVarios.obtener(0).getCodcli()) ;
		     
			 int tam=objServletCotVarios.tamaño();
			 int item=-1;
			 referencia_coti=txtReferencia.getText();
			 BeanCliente objCliente = objServletCliente.obtener(0);
			 if(tam>0){for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
				
				BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
				nomEmpresa=objCliente.getNomcli();
				arregloCadenas[0]=objCliente.getNomcli().toString().toUpperCase();
				if(txtContacto.getText().equals("")){
					arregloCadenas[1]=objCliente.getContacto1cli().toString().toUpperCase();
				}else{
					arregloCadenas[1]=txtContacto.getText().toUpperCase();
				}
				arregloCadenas[2]=objCliente.getDireccion1cli().toString().toUpperCase();
				String rpm=objCliente.getRpm1cli(),nex=objCliente.getNextel(),rpmnextel="";
				if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
					rpmnextel=" NEX:"+nex;
				}else{
					rpmnextel=" RPM:"+rpm;
				}
				
				arregloCadenas[3]="TEL:"+objCliente.getTelefono1cli()+rpmnextel+" CEL:"+objCliente.getCel1cli()+" E-MAIL:"+objCliente.getEmail1cli();
				arregloCadenas[4]=objGlobal.COD_VEN;
				arregloCadenas[5]=objCliente.getTipocli().toString().toUpperCase();
				arregloCadenas[6]=objCliente.getCodcli();
				arregloCadenas[7]="COTIZACION Nº"+objCotVarios.getCodcot()+"-"+ide_cot;
				arregloCadenas[8]=objFecha.fechaActual();
				arregloCadenas[9]=Double.parseDouble(""+tipoCambioVenta());
				arregloCadenas[10]=ref.toString().toUpperCase();
					item=item+1;
				  for (int j = 0; j <13; j++) {
						if(j==0){
							//System.out.println("esto sale poseacso:"+objCotVarios.getCancot());
						arregloObjetos[item][j]=Integer.parseInt(""+objCotVarios.getCancot());	
						}else if(j==1){
						arregloObjetos[item][j]=objCotVarios.getUmedprod().toString().toUpperCase();	
						}else if(j==2){
						arregloObjetos[item][j]=objCotVarios.getNomprod().toString().toUpperCase();
						}else if(j==3){
						arregloObjetos[item][j]=objCotVarios.getNommar().toString().toUpperCase();		
						}else if(j==4){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 6));		
						}else if(j==5){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 10));			
						}else if(j==6){
						arregloObjetos[item][j]=""+modelo2.getValueAt(i, 17).toString();	
						}else if(j==7){
						arregloObjetos[item][j]=""+modelo2.getValueAt(i, 19).toString();	
						}else if(j==8){
						arregloObjetos[item][j]=""+objCotVarios.getCodprove().toUpperCase();	
						}else if(j==9){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 21).toString();
						}else if(j==10){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 22).toString();
						}else if(j==11){
						arregloObjetos[item][j]=""+objCotVarios.getTiempoentrega().toUpperCase();		
						}else{
						arregloObjetos[item][j]=""+objCotVarios.getModprod().toUpperCase();
						}
					}
				}//
				}
			 
			 //objServletCliente.eliminarTodo();
			 
   }

	public boolean pasarExcel2(int cant) throws FileNotFoundException, IOException{
		
		 boolean devuelve=true;
	     datosCliente(objServletCotVarios.obtener(0).getCodcli()) ;
		
		 int tam=tamañodelExcel();
		 int item=-1;
		 double peso=0;
		 String pesototal="",pesofinal="";
		 referencia_coti=txtReferencia.getText();
		 BeanCliente objCliente = objServletCliente.obtener(0);
		 BeanCotizacionVarios objCotVarios;
		 
		 if(tam>0){for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
				
	    objCotVarios=objServletCotVarios.obtener(i);
	    nomEmpresa=objCliente.getNomcli();
	    codigocliente=objCliente.getCodcli();
	    nombreCliente=objCliente.getContacto1cli();
		arregloCadenas1[0]=objCliente.getNomcli().toString().toUpperCase();
		if(txtContacto.getText().equals("")){
			arregloCadenas1[1]=objCliente.getContacto1cli().toString().toUpperCase();
		}else{
			arregloCadenas1[1]=txtContacto.getText().toUpperCase();
		}
		arregloCadenas1[2]=objCliente.getDireccion1cli().toString().toUpperCase();
		String rpm=objCliente.getRpm1cli(),nex=objCliente.getNextel(),rpmnextel="";
		if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
			rpmnextel=" NEX:"+nex;
		}else{
			rpmnextel=" RPM:"+rpm;
		}
		arregloCadenas1[3]="TEL:"+objCliente.getTelefono1cli()+rpmnextel+" CEL:"+objCliente.getCel1cli()+" E-MAIL:"+objCliente.getEmail1cli();
		arregloCadenas1[4]=objGlobal.COD_VEN;
		arregloCadenas1[5]=objCliente.getTipocli().toString().toUpperCase();
		arregloCadenas1[6]=objCliente.getCodcli();
		arregloCadenas1[7]="COTIZACION CORREO Nº"+objCotVarios.getCodcot()+"-"+objCotVarios.getIdecot();
		arregloCadenas1[8]=objFecha.fechaActual();
		arregloCadenas1[9]=Double.parseDouble(""+tipoCambioCompra());
		arregloCadenas1[10]=txtReferencia.getText().toString().toUpperCase();
		item=item+1;
		 for (int j = 0; j < 13; j++) {
				if(j==0){
				arregloObjetos1[item][j]=Integer.parseInt(""+objCotVarios.getCancot());	
				}else if(j==1){
				arregloObjetos1[item][j]=objCotVarios.getUmedprod().toString();	
				}else if(j==2){
				arregloObjetos1[item][j]=objCotVarios.getNomprod().toString().toUpperCase()+"@"+objCotVarios.getEspprod();	
				}else if(j==3){
				arregloObjetos1[item][j]=objCotVarios.getNommar().toString();	
				}else if(j==4){
				arregloObjetos1[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 6));		
				}else if(j==5){
				arregloObjetos1[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 10));			
				}else if(j==6){
				arregloObjetos1[item][j]="";	
				}else if(j==7){
				arregloObjetos1[item][j]="";	
				}else if(j==8){
					pesototal=objCotVarios.getPesoprod().toString();
					if(pesototal.equals("")){
						peso=0;
					}else{
						peso=Double.parseDouble(pesototal);
					}
					pesofinal=""+formato2(peso);
				arregloObjetos1[item][j]=pesofinal;
				}else if(j==9){
					arregloObjetos1[item][j]=""+modelo2.getValueAt(i, 22);
				}else if(j==10){
					//
				}else if(j==11){
				arregloObjetos1[item][j]=""+objCotVarios.getTiempoentrega().toUpperCase();		
				}else{
				arregloObjetos1[item][j]=""+objCotVarios.getModprod().toUpperCase();	
				}
			}
		}
				}
        return devuelve;
		
	}
	String cuartoNumUno(int num){
		
		String numletras=""+num,
		cad="",palabra="";
		int cont=0;
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(numletras.length()>=5){
				if(cont==4){
					if(cad.equals("1")){
						palabra=" un";
					}
				}
				if(cont==5){
					if(cad.equals("1")){
						palabra="";
					}
				}
			}else{
				break;
			}
			
		}
			
		return palabra;
	}
	/**********************************************************************************************************/
	void pasarExcelFactura() throws FileNotFoundException, IOException{
		
	    double num=0;
	    int contaNum=0,sindec=0,numMil=0,numero=0,numero2=0,numMillon;
	    String mil="";
		String millon="",moneda="";
	    
		 datosCliente(objServletCotVarios.obtener(0).getCodcli());
		
		
		 int tam=objServletCotVarios.tamaño();
		 int item=-1;
		 String fechaFormal="Lima, "+objFecha.fechaDia()+" de "+objFecha.fechaMes()+" del "+objFecha.fechaAño();
		 double PUnit=0,Total=0,STotal=0;
		
		 BeanCliente objCliente = objServletCliente.obtener(0);
		 String cant="",umed="",prod="",punit="",total="";
		 
		 if(tam>0){
			 System.out.println("CANT "+"\t"+"UMED "+"\t"+palabra85("PROD")+" \t"+
					 "PUNIT "+"\t"+"TOTAL "+"\t");
			 System.out.println("==== "+"\t"+"==== "+"\t"+palabra85("====")+" \t"+
					 "===== "+"\t"+"===== "+"\t");
			 
			 for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
			numeroDeFilasFac++;
			
			arregloCadenas2[0]=fechaFormal;//objCliente.getNomcli().toString().toUpperCase();
			arregloCadenas2[1]=objCliente.getNomcli().toUpperCase();
			arregloCadenas2[2]=objCliente.getDireccion1cli().toString().toUpperCase();
			arregloCadenas2[3]=objCliente.getRuc();
			item=item+1;
			  for (int j = 0; j <5; j++) {
				  
				  if(selecciona==1){
					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)))*tipoCambioVenta();
					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
					  TIPO_MONEDA="S/.";
					  moneda=" nuevos soles";
				  }else if(selecciona==2){
					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)));
					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
					  TIPO_MONEDA="$";
					  moneda=" dolares";
				  }else{
					//NADA
				  }
				  
					if(j==0){
					arregloObjetos2[item][j]=Integer.parseInt(""+modelo2.getValueAt(i, 1));	
					cant=""+arregloObjetos2[item][j];
					}else if(j==1){
					arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 2);	
					umed=""+arregloObjetos2[item][j];
					}else if(j==2){	
					arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 3);
					prod=""+arregloObjetos2[item][j];                                       
					}else if(j==3){
					arregloObjetos2[item][j]=formato2(PUnit);
					punit=""+arregloObjetos2[item][j];
					}else{
					arregloObjetos2[item][j]=formato2(Total);	
					total=""+arregloObjetos2[item][j];
					STotal+=formato2(Total);
					}
					
				}
			  System.out.println(cant+" \t"+umed+" \t"+palabra85(prod)+" \t"+punit+"\t"+total+"\t");
			}
			
		    TotalFac=formato2(STotal*1.18);
		    txtPrueba.setText(""+TotalFac);//DESPUES BORRAR ESTE CODIGO
		    num=TotalFac;
		    contaNum=ContaNum(TotalFac);
		    sindec=SinDecimal(TotalFac);
		    
			 if(contaNum>3){
				 
				//System.out.println("QQQQQQQQQQQQQQQQ1");
			    	numMil=numMillar(sindec);
			    	mil=Millar(numMil);
			 }
			 if(contaNum>6){
				//System.out.println("QQQQQQQQQQQQQQQ2");	
				 numMillon=numMillon(sindec);
			     millon=Millon(numMillon);
			 }
			 
			 if(contaNum==1){
				 NumeroEnLetras=Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda; 
			 }else if(contaNum==2){
				 NumeroEnLetras=Decenas(sindec)+" "+Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda;
			 }else if(contaNum==3){
				 NumeroEnLetras=Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda; 
			 }else if(contaNum==4){
				 NumeroEnLetras=mil+" "+Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero2)+" con "+centavos(num)+"/100"+moneda; 
			 }else{
				 NumeroEnLetras=millon+mil+" "+Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero2)+" con "+centavos(num)+"/100"+moneda;
			 }
		 
		   IGVFAC=formato2(STotal*0.18);
		   System.out.println("Igv :"+formato2(STotal*0.18));
		   System.out.println("Suma total :"+formato2(STotal*1.18));
		   System.out.println("Numero de Filas de la Factura :"+numeroDeFilasFac);                                                                                                                                                                                                      
		}
		 
		 //objServletCliente.eliminarTodo();
		 
	}
	/******************************************************************************************************/
	/******************************************************************************************************/
	void pasarExcelFactura2() throws FileNotFoundException, IOException{
		
	    double num=0;
	    int contaNum=0,sindec=0,numMil=0,numero=0,numero2=0,numMillon;
	    String mil="",millon="",moneda="";
		
	     
	    datosCliente(objServletCotVarios.obtener(0).getCodcli());
	     
		 
		 int tam=objServletCotVarios.tamaño();
		 int item=-1;
		 String fechaFormal="Lima, "+objFecha.fechaDia()+" de "+objFecha.fechaMes()+" del "+objFecha.fechaAño();
		 double PUnit=0,Total=0,STotal=0;
		 int contafilas=0,conti=0;
		
		 BeanCliente objCliente = objServletCliente.obtener(0);
		 String cant="",umed="",prod="",punit="",total="";
		 
		 if(tam>0){
			 System.out.println("CANT "+"\t"+"UMED "+"\t"+palabra85("PROD")+" \t"+
					 "PUNIT "+"\t"+"TOTAL "+"\t");
			 System.out.println("==== "+"\t"+"==== "+"\t"+palabra85("====")+" \t"+
					 "===== "+"\t"+"===== "+"\t");
			
			for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
				
				contafilas++;
				if(contafilas<=46 && estado==0){
					//System.out.println("PRIMERA VEZ");
					conti++;
            	conta2++;
            	arregloCadenas2[0]=fechaFormal;//objCliente.getNomcli().toString().toUpperCase();
    			arregloCadenas2[1]=objCliente.getNomcli().toUpperCase();
    			arregloCadenas2[2]=objCliente.getDireccion1cli().toString().toUpperCase();
    			arregloCadenas2[3]=objCliente.getRuc();
    			item=item+1;
    			  for (int j = 0; j <5; j++) {
    				  
    				  if(selecciona==1){
    					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)))*tipoCambioVenta();
    					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
    					  TIPO_MONEDA="S/.";
    					  moneda=" nuevos soles";
    				  }else if(selecciona==2){
    					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)));
    					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
    					  TIPO_MONEDA="$";
    					  moneda=" dolares";
    				  }else{
    					  //NADA
    				  }
                      
    				  if(j==0){
    						arregloObjetos2[item][j]=Integer.parseInt(""+modelo2.getValueAt(i, 1));	
    						cant=""+arregloObjetos2[item][j];
    						}else if(j==1){
    						arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 2);	
    						umed=""+arregloObjetos2[item][j];
    						}else if(j==2){	
    						arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 3);
    						prod=""+arregloObjetos2[item][j];                                       
    						}else if(j==3){
    						arregloObjetos2[item][j]=formato2(PUnit);
    						punit=""+arregloObjetos2[item][j];
    						}else{
    						arregloObjetos2[item][j]=formato2(Total);	
    						total=""+arregloObjetos2[item][j];
    						STotal+=formato2(Total);
    						}	
    				}
			   }
			   if(estado==1){
				   
				   if(i>=46){
					   //System.out.println("SEGUNDA VEZ");
					   conti++;
				    arregloCadenas2[0]=fechaFormal;//objCliente.getNomcli().toString().toUpperCase();
	    			arregloCadenas2[1]=objCliente.getNomcli().toUpperCase();
	    			arregloCadenas2[2]=objCliente.getDireccion1cli().toString().toUpperCase();
	    			arregloCadenas2[3]=objCliente.getRuc();
	    			item=item+1;
	    			  for (int j = 0; j <5; j++) {
	    				  
	    				  if(selecciona==1){
	    					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)))*tipoCambioVenta();
	    					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
	    					  TIPO_MONEDA="S/.";
	    					  moneda=" nuevos soles";
	    				  }else if(selecciona==2){
	    					  PUnit=(Double.parseDouble(""+modelo2.getValueAt(i, 6)));
	    					  Total=PUnit*Integer.parseInt(""+modelo2.getValueAt(i, 1));	
	    					  TIPO_MONEDA="$";
	    					  moneda=" dolares";
	    				  }else{
	    					 //NADA
	    				  }
	                      
	    				  if(j==0){
	    						arregloObjetos2[item][j]=Integer.parseInt(""+modelo2.getValueAt(i, 1));	
	    						cant=""+arregloObjetos2[item][j];
	    						}else if(j==1){
	    						arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 2);	
	    						umed=""+arregloObjetos2[item][j];
	    						}else if(j==2){	
	    						arregloObjetos2[item][j]=""+modelo2.getValueAt(i, 3);
	    						prod=""+arregloObjetos2[item][j];                                       
	    						}else if(j==3){
	    						arregloObjetos2[item][j]=formato2(PUnit);
	    						punit=""+arregloObjetos2[item][j];
	    						}else{
	    						arregloObjetos2[item][j]=formato2(Total);	
	    						total=""+arregloObjetos2[item][j];
	    						STotal+=formato2(Total);
	    						}	
	    				}
				     }  
				     
				  }
			   
			   if(contafilas<=46 && estado==0){
				   System.out.println(cant+" \t"+umed+" \t"+palabra85(prod)+" \t"+punit+"\t"+total+"\t");
			   }
			   if(estado==1 && i>=46){
				   System.out.println(cant+" \t"+umed+" \t"+palabra85(prod)+" \t"+punit+"\t"+total+"\t");
			   }
			}
		    TotalFac=formato2(STotal*1.18);
		    txtPrueba.setText(""+TotalFac);//DESPUES BORRAR ESTE CODIGO
		    num=TotalFac;
		    contaNum=ContaNum(TotalFac);
		    sindec=SinDecimal(TotalFac);
		    
			 if(contaNum>3){
				 //System.out.println("QQQQQQQQQQQQQQQQ3");
			    	numMil=numMillar(sindec);
			    	mil=Millar(numMil);
			    }
			 if(contaNum>6){
				 //System.out.println("QQQQQQQQQQQQQQQQ4");	
				 numMillon=numMillon(sindec);
			     millon=Millon(numMillon);
			 }
			 
			 
			 if(contaNum==1){
				 NumeroEnLetras=Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda; 
			 }else if(contaNum==2){
				 NumeroEnLetras=Decenas(sindec)+" "+Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda; 
			 }else if(contaNum==3){
				 NumeroEnLetras=Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero)+" con "+centavos(num)+"/100"+moneda; 
			 }else if(contaNum==4){
				 NumeroEnLetras=mil+" "+Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero2)+" con "+centavos(num)+"/100"+moneda;  
			 }else{
				 NumeroEnLetras=millon+mil+" "+Centenas(sindec)+" "+Decenas(sindec)+" "+Unidad(sindec,numero2)+" con "+centavos(num)+"/100"+moneda;
			 }
		 
		   IGVFAC=formato2(STotal*0.18);
		   System.out.println("Igv :"+formato2(STotal*0.18));
		   System.out.println("Suma total :"+formato2(STotal*1.18));
		   System.out.println("Numero de Filas de la Factura :"+conti);
		   conti=0;
		}
		 //shey chavez obregon
		 //objServletCliente.eliminarTodo();
		 
	}
	/************************************************************************************************************/
	 public double tipoCambioCompra(){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					double cambio=rs.getDouble(4);
					return cambio;		
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 0;
		}
	  
	  
	public void listarCotizacion(int codcot,int idecot){
		
		int n=modelo2.getRowCount();
		double pesototal=0;                                             
		//String pesofinal="";
		double total$=0,totals=0;
	
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
			
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
		objAccesoBD.crearConexion();
		PintarFila();
		
				String sql="SELECT COT.COD_COT,COT.IDE_COT,COT.NUM_ITEM, COT.COD_CLI ,COT.CAN_COT,UMED.NOM_UMED, "+
				     "PROD.NOM_PROD,PROD.COD_PROD,MAR.NOM_MAR, "+
					 "ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				     "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))))/ COT.PORGA_COT) ,3)   'P.Total $', "+
					 "((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
         		     "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT)*0.18 'IGV$', "+
					 "(ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT 'Total $', "+
					 "ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))))) ,3)   'Costo $', "+
					 "(ROUND(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
					 "FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
					 "FROM tb_cambio)))/1.18) ))),3))*COT.CAN_COT    'Total $', "+
					 "((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT) - "+
					 "((ROUND(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
					 "FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
					 "FROM tb_cambio)))/1.18) ))),3))*COT.CAN_COT)  'Dif. $', "+
					 "(ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3))* "+
					 "((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'P.Unit S', "+
                     "(((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
         		     "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT)*0.18)* "+
					 "((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'IGV S', "+
                     "((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					 "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
					 "WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT) * "+
					 "((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'Total S', "+
                     "DET.FEC_DET,COT.COD_CAM,COT.COD_VEN,COT.PORGA_COT,PROVE.NOM_PROVE, PROVE.COD_PROVE,MAR.COD_MAR,UMED.COD_UMED,PROD.PESO_PROD,COT.TIEMPO_ENTREGA,COT.PESOCARR,PROD.MOD_PROD,PROD.ESP_PROD "+
					 "FROM tb_cotizacion COT INNER JOIN tb_proveprodmarumed1 DET "+
					 "ON  DET.COD_PROVE=COT.COD_PROVE AND DET.COD_PROD=COT.COD_PROD "+
					 "AND DET.COD_MAR=COT.COD_MAR AND DET.COD_UMED=COT.COD_UMED INNER JOIN tb_producto PROD "+
					 "ON PROD.COD_PROD=COT.COD_PROD INNER JOIN tb_marcas MAR "+
					 "ON MAR.COD_MAR=COT.COD_MAR INNER JOIN tb_umed UMED "+
					 "ON UMED.COD_UMED=COT.COD_UMED INNER JOIN tb_proveedor PROVE "+
					 "ON PROVE.COD_PROVE=COT.COD_PROVE "+
					 "WHERE COT.COD_COT='"+codcot+"' AND COT.IDE_COT='"+idecot+"' AND DET.EST_DET='ACTIVADO' ORDER BY  COT.NUM_ITEM ;";
				
				System.out.println("REVOLUCION CABRONES:"+sql);
				rs = objAccesoBD.ejecutarConsulta(sql);
				
					while(rs.next()){
	                        //String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Total  $","Total $","Costo $","Total$","Dif. $","Fecha","%","Proveedor"};
					
							//COD_COT, IDE_COT, NUM_ITEM, COD_CLI, CAN_COT,
							//UMED_PROD, NOM_PRODALT, COD_PROD, COD_PRODALT,
					    	//NOM_MAR, P.Total $, Total $, Costo $, Total $,
							//Dif. $, FEC_DET, COD_CAM, COD_VEN, PORGA_COT, NOM_PROVE, COD_PROVE
						
						total$+=Double.parseDouble(rs.getString(13));
						totals+=Double.parseDouble(rs.getString(20));
						
						BeanCotizacionVarios objCotVarios=new BeanCotizacionVarios(rs.getString(1), rs.getString(2),
								rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
								rs.getString(9),""+formato(Double.parseDouble(rs.getString(10))),
								""+formato(Double.parseDouble(rs.getString(11))),""+formato(Double.parseDouble(rs.getString(12))),""+formato(total$),
								""+formato(Double.parseDouble(rs.getString(13))),""+formato(Double.parseDouble(rs.getString(14))),
							    ""+formato(Double.parseDouble(rs.getString(15))), ""+formato(Double.parseDouble(rs.getString(16))),
								""+formato(Double.parseDouble(rs.getString(17))), ""+formato(Double.parseDouble(rs.getString(18))),""+formato(totals),
								rs.getString(19),rs.getString(20), rs.getString(21), 
								rs.getString(22), rs.getString(23), rs.getString(24),rs.getString(25),rs.getString(26),"0",rs.getString(27),rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31));
								 
								objServletCotVarios.adicionar(objCotVarios);
							
					}
					 
				}catch (SQLException e) {
					e.printStackTrace();
				}finally{
					objAccesoBD.cerrarResultSet(rs);
					objAccesoBD.cerrarStatement();
					objAccesoBD.cerrarConexion();  
				}
				
				for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
					
					BeanCotizacionVarios objCotisacionVarios=objServletCotVarios.obtener(i) ;
                     if(objCotisacionVarios.getPesoprod().equals("")){
						pesototal=0;
					}else{
					    pesototal=Double.parseDouble(objCotisacionVarios.getPesoprod());
					}
                     //pesofinal=""+formato(pesototal);
					Object[] array={ Integer.parseInt(objCotisacionVarios.getNumitem()),Integer.parseInt( objCotisacionVarios.getCancot())
							,objCotisacionVarios.getUmedprod(), objCotisacionVarios.getNomprod(),
							objCotisacionVarios.getNommar(),objCotisacionVarios.getModprod(),Double.parseDouble(objCotisacionVarios.getCosteEntreporc()) ,Double.parseDouble(objCotisacionVarios.getIgv$()),
							Double.parseDouble(objCotisacionVarios.getCosteXporcXcant()),Double.parseDouble(objCotisacionVarios.getTotal$()),
							Double.parseDouble(objCotisacionVarios.getCoste()),Double.parseDouble(objCotisacionVarios.getCosteXcant()),
							Double.parseDouble(objCotisacionVarios.getDife()),Double.parseDouble(objCotisacionVarios.getPunits()),
							Double.parseDouble(objCotisacionVarios.getIgvs()),Double.parseDouble(objCotisacionVarios.getPtotals()), 
							Double.parseDouble(objCotisacionVarios.getTotals()),objCotisacionVarios.getFecdet(),
							Double.parseDouble(objCotisacionVarios.getPorgacot()), 
							objCotisacionVarios.getNomprove(),objCotisacionVarios.getTiempoentrega(),formato2(pesototal),formato2(Double.parseDouble(objCotisacionVarios.getPesoCarrete())),};
					modelo2.addRow(array);
					
					
				}
					
	}
	
	/*******************************************************************************************************************************************************************/
	/*******************************************************************************************************************************************************************/
	
	public int tamañodelExcel(){
			 int item=0;
			for (int i = 0; i < objServletCotVarios.tamaño(); i++) 
				item=item+1;	
			return item;
    }
	
	
	public void pasar(){
		
		cod_cot=null;
		cod_cot=txtNCotizacion.getText();
		EnviarOrdenCompraProveedor objEnviarOrdenCompraCliente = 
			new EnviarOrdenCompraProveedor();
		objEnviarOrdenCompraCliente.setVisible(true);
		
		objEnviarOrdenCompraCliente.pack();
		
	}
	
	public Integer ingresarCosto(Double cos){
	Integer cod_cos=0;
	AccesoBD objAc= new AccesoBD();
	objAc.crearConexion();
	
	String sql="insert into tb_costo(cod_cos,cos_cos,fec_cos,est_cos) values (null,'"+cos+"',concat(curdate(),' ',curtime()), " +
			" '3' ); ";
	String sql2="select max(cod_cos) from tb_costo; ";
	try {
		objAc.ejecutarActualizacion(sql);
	} catch (Exception e) {
		// TODO: handle exception
	}
	objAc.cerrarConexion();
	AccesoBD objAc2= new AccesoBD();
	objAc2.crearConexion();
	ResultSet rs= objAc2.ejecutarConsulta(sql2);
	try {
		if(rs.next()){
			cod_cos=rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	objAc2.cerrarConexion();
	return cod_cos;
	}
	
	public Double calcularNuevoPrecio(double precioNuevo,int ffila){
		Fecha objF= new Fecha();
		Double porc=0.0;
		Double precioVenta=Double.parseDouble(""+modelo2.getValueAt(ffila, 6));
		Double precioTotalGan=Double.parseDouble(""+modelo2.getValueAt(ffila, 8));
		Double difer;
		Integer canti=Integer.parseInt(""+modelo2.getValueAt(ffila, 1));
		Double precioTotalPro;
		porc=precioVenta/precioNuevo;
		precioTotalPro=precioNuevo*canti;
		precioTotalPro=formato(precioTotalPro);
		difer=precioTotalGan-precioTotalPro;
		modelo2.setValueAt(precioNuevo, ffila, 10);
		modelo2.setValueAt(precioTotalPro, ffila, 11);
		modelo2.setValueAt(difer, ffila, 12);
		modelo2.setValueAt(objF.fechaActual(),ffila, 17);
		modelo2.setValueAt(porc, ffila, 18);
		
		return porc;
		
	}
	public Integer verificarCot(Integer codcot,Integer idecot){
		
		Integer val = null;
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs= null;
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT ISNULL(COT.COD_COS) FROM tb_cotizacion COT "
				+ " WHERE COT.COD_COT='"+codcot+"' AND COT.IDE_COT='"+idecot+"' ;";
		rs=objAccesoBD.ejecutarConsulta(sql);
		
			if(rs.next()){
				val=rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		return val;
	}

	public void listarCotizacionFinal(Integer codcot,Integer idecot){
		
		int n=modelo2.getRowCount();
		double pesototal=0;
		String pesofinal="";
		double total$=0,totals=0;
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
		objAccesoBD.crearConexion();
		PintarFila();
				
				String sql="SELECT COT.COD_COT,COT.IDE_COT,COT.NUM_ITEM, COT.COD_CLI ,COT.CAN_COT,UMED.NOM_UMED, "+
			    " PROD.NOM_PROD,PROD.COD_PROD,MAR.NOM_MAR, "+
				" ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3)   'P.Total $', "+
				" ((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
        		" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT)*0.18 'IGV$', "+
				" (ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT 'Total $', "+
				" ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))))) ,3)   'Costo $', "+
				" (ROUND(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
				" FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
				" FROM tb_cambio)))/1.18) ))),3))*COT.CAN_COT    'Total $', "+
				" ((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT) - "+
				" ((ROUND(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),COS.COS_COS,(COS.COS_COS/1.18))), "+
				" (IF((DET.IGV_DET=1),(COS.COS_COS/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
				" FROM tb_cambio))),((COS.COS_COS/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) "+
				" FROM tb_cambio)))/1.18) ))),3))*COT.CAN_COT)  'Dif. $', "+
				" (ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))),  "+
        		" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3))* "+
			    " ((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'P.Unit S', "+
                " (((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
                " (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
			    " WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT)*0.18) * "+
				"  ((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'IGV S', "+
                " ((ROUND(((IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio "+
				" WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) /COT.PORGA_COT) ,3) )*COT.CAN_COT) * "+
				" ((SELECT VENTA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))'Total S', "+
                " COS.FEC_COS,COT.COD_CAM,COT.COD_VEN,COT.PORGA_COT,PROVE.NOM_PROVE, PROVE.COD_PROVE,MAR.COD_MAR,UMED.COD_UMED,COT.COD_COS,PROD.PESO_PROD,COT.TIEMPO_ENTREGA,COT.PESOCARR,PROD.MOD_PROD,PROD.ESP_PROD  "+
				" FROM tb_cotizacion COT INNER JOIN tb_proveprodmarumed1 DET "+
				" ON  DET.COD_PROVE=COT.COD_PROVE AND DET.COD_PROD=COT.COD_PROD "+
				" AND DET.COD_MAR=COT.COD_MAR AND DET.COD_UMED=COT.COD_UMED "+
				" INNER JOIN tb_producto PROD 	ON PROD.COD_PROD=COT.COD_PROD "+
				" INNER JOIN tb_marcas MAR 	ON MAR.COD_MAR=COT.COD_MAR "+
				" INNER JOIN tb_umed UMED 	ON UMED.COD_UMED=COT.COD_UMED "+
				" INNER JOIN tb_proveedor PROVE 	ON PROVE.COD_PROVE=COT.COD_PROVE "+
				" INNER JOIN TB_COSTO COS ON COS.COD_COS=COT.COD_COS "+
				" WHERE COT.COD_COT='"+codcot+"' AND COT.IDE_COT='"+idecot+"' AND DET.EST_DET='ACTIVADO' ;";
					
				System.out.println("REVOLUCION CABRONES 2:"+sql);
				rs = objAccesoBD.ejecutarConsulta(sql);
				
					while(rs.next()){
	               //String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Total  $","Total $","Costo $","Total$","Dif. $","Fecha","%","Proveedor"};
					
							//COD_COT, IDE_COT, NUM_ITEM, COD_CLI, CAN_COT,
							//UMED_PROD, NOM_PRODALT, COD_PROD, COD_PRODALT,
							//NOM_MAR, P.Total $, Total $, Costo $, Total $,
							//Dif. $, FEC_DET, COD_CAM, COD_VEN, PORGA_COT, NOM_PROVE, COD_PROVE
						total$+=Double.parseDouble(rs.getString(13));
						totals+=Double.parseDouble(rs.getString(20));
						
						BeanCotizacionVarios objCotVarios=new BeanCotizacionVarios(rs.getString(1), rs.getString(2),
								rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
								rs.getString(9),""+formato(Double.parseDouble(rs.getString(10))),
								""+formato(Double.parseDouble(rs.getString(11))),""+formato(Double.parseDouble(rs.getString(12))),""+formato(total$),
								""+formato(Double.parseDouble(rs.getString(13))),""+formato(Double.parseDouble(rs.getString(14))),
							    ""+formato(Double.parseDouble(rs.getString(15))), ""+formato(Double.parseDouble(rs.getString(16))),
								""+formato(Double.parseDouble(rs.getString(17))), ""+formato(Double.parseDouble(rs.getString(18))),""+formato(totals),
								rs.getString(19),rs.getString(20), rs.getString(21), 
								rs.getString(22), rs.getString(23), rs.getString(24),rs.getString(25),rs.getString(26),"0",rs.getString(27),rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31));
										 
								objServletCotVarios.adicionar(objCotVarios);

						
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}finally{
					objAccesoBD.cerrarResultSet(rs);
					objAccesoBD.cerrarStatement();
					objAccesoBD.cerrarConexion();  
				}
				
				objAccesoBD.cerrarConexion();
				for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
					BeanCotizacionVarios objCotisacionVarios=objServletCotVarios.obtener(i) ;
					if(objCotisacionVarios.getPesoprod().equals("")){
						pesototal=0;
					}else{
						pesototal=Double.parseDouble(objCotisacionVarios.getPesoprod());
					}
					pesofinal=""+formato(pesototal);
					
					Object[] array={ Integer.parseInt(objCotisacionVarios.getNumitem()),Integer.parseInt( objCotisacionVarios.getCancot())
							,objCotisacionVarios.getUmedprod(), objCotisacionVarios.getNomprod(),
							objCotisacionVarios.getNommar(),objCotisacionVarios.getModprod(),Double.parseDouble(objCotisacionVarios.getCosteEntreporc()) ,Double.parseDouble(objCotisacionVarios.getIgv$()),
							Double.parseDouble(objCotisacionVarios.getCosteXporcXcant()),Double.parseDouble(objCotisacionVarios.getTotal$()),
							Double.parseDouble(objCotisacionVarios.getCoste()),Double.parseDouble(objCotisacionVarios.getCosteXcant()),
							Double.parseDouble(objCotisacionVarios.getDife()),Double.parseDouble(objCotisacionVarios.getPunits()),
							Double.parseDouble(objCotisacionVarios.getIgvs()),Double.parseDouble(objCotisacionVarios.getPtotals()), 
							Double.parseDouble(objCotisacionVarios.getTotals()),objCotisacionVarios.getFecdet(),
							Double.parseDouble(objCotisacionVarios.getPorgacot()), 
							objCotisacionVarios.getNomprove(),objCotisacionVarios.getTiempoentrega(),formato2(pesototal),formato2(Double.parseDouble(objCotisacionVarios.getPesoCarrete()))};
					modelo2.addRow(array);
					
					
				}
		
	}
	public String precioXcodCosto(String codCos){
		
		String precio = null;
		AccesoBD objAccesoBD= new AccesoBD();
		ResultSet rs= null;	
				
		try {
		objAccesoBD.crearConexion();
		
		String sql="SELECT COS_COS FROM TB_COSTO WHERE COD_COS='"+codCos+"';";
		rs=objAccesoBD.ejecutarConsulta(sql);
		
		
			if(rs.next()){
				precio=rs.getString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		return precio;
		
	}
	/********************************************************************************************************/
	public String primeraPalabra(String cad){
    	String pal="",pal2="";
    	
    	for(int i=0;i<cad.length();i++){
    		 pal=""+cad.charAt(i);
    		if(pal.equals(" ")){
    			pal2+="_";
    		}else{
    			pal2+=pal;
    		}
    		
    	}
    	return pal2;
    }
	/************************************************************************************************************/
	public String sinEspacio(String cad){
    	String pal="",pal2="";
    	
    	for(int i=0;i<cad.length();i++){
    		 pal=""+cad.charAt(i);
    		if(pal.equals(" ")){
    			pal2+="_";
    		}else{
    			pal2+=pal;
    		}
    		
    	}
    	return pal2;
    }
	
	public void cargarEnviarCorreos(){
		GlobalesCorreo objGlobal = null;
				
				if(est==1){
					datosCliente(objServletCotVarios.obtener(0).getCodcli());
			        coti="CORPORACION CORPELIMA";
				}else{
					datosClientecye(objServletCotVarios.obtener(0).getCodcli());
			        coti="COTIZACION - CyE GLOBAL ELECTRIC";
				}
				
				/**
				 * para modificar y arreglar esta parte @gcorreageek
				 * asuntoGmail=PRUEBA CONSORCIO CEM
				 */
				coti = objGlobal.asunto;
		        

				BeanCliente objCliente = objServletCliente.obtener(0);
				boolean valor=true;
				correo1=objCliente.getEmail1cli();
				correo2=objCliente.getEmail2cli();
				sexo=objCliente.getSexcli();
				referencia_coti=txtReferencia.getText();
				int tam=tamañodelExcel();//ESTE ES EL TAMAÑO REAL
				
				boolean devuelve = false;
				arregloCadenas1= new Object[11];
				arregloObjetos1= new Object[tam][13];
				//int resto=excelUsar(tam);
		
				try {
					
					devuelve=pasarExcel2(tam);
					objPasarExcelCorreo= new PasarExcelCorreo();
					objPasarExcelCorreo.crearExcel(arregloCadenas1,arregloObjetos1);
					rutaGlobal=objPasarExcelCorreo.fileGlobal;
					System.out.println("la ruta global1:"+rutaGlobal);
					valor=true;
				} catch (FileNotFoundException e1) {
					valor=false;
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
					valor=false;
				}finally{
					if(!valor){
						System.out.println("Este es el error!");
						objGUI.mostrarAviso("Hubo un ERROR!");
					}
				}
				
				if(devuelve){
					ideCot=txtNroModificacion.getText();
					numCot=txtNCotizacion.getText();
					ruta=txtRuta.getText();
					nombreArchivosAdjuntos=nombreAdjuntos;
					objEnvioMail=null;
					objEnvioMail= new EnvioMail();
					objEnvioMail.setVisible(false);
					objEnvioMail.aMostrar();
					System.out.println("la ruta global2:"+rutaGlobal);
					objEnvioMail.envio1();//ESTE ES
					
					/**
					 * Codigo Comentado para que no se envie solo los correos @gcorreageek
					if(objEnvioMail.buscarRepetidos()==0){
							objEnvioMail.ingresarMailsAuto();
					}
					*/
					if(objEnvioMail.buscarRepetidos2()==0){
							objEnvioMail.agregarReporte(numCot,ideCot,referencia_coti);
					}
					
					
						
				}
				
	}
	public int totalArchivos(){
		
		  int total = 0;
		  String carpeta = p.getProperty("speachCotizacion").trim();
		  File directorio = new File (carpeta);
		  String[] arrArchivos = directorio.list();
		  total += arrArchivos.length;
		  File tmpFile;
		  for(int i=0; i<arrArchivos.length; ++i){
		    tmpFile = new File(directorio.getPath() + "/" +arrArchivos[i]);
		    if(tmpFile.isDirectory()){
		      total += totalArchivos();
		    }
		  }
		  return total;
		}
	/*********************************************************************************************************/
	public String PalabraAlReves(String cad){
		
		String cadena="",cadena2="";
		int conta=0;
		for(int i=cad.length()-1;i>=0;i--){
			cadena=""+cad.charAt(i);
			conta++;
			if(conta>4){
				cadena2=cadena+cadena2;
			}
			if(cadena.equals(" ")){
				break;
			}
		}
		
		return cadena2.trim();
	}
	
	/**************************************************************************************************************/
	public  String rutaArchivo(){
		
	try {
		String nomdia=objFecha.fechaActual4();
		String tiempo=objFecha.fechaActual5();
		int hora=Integer.parseInt(tiempo);
		
		String nombres="",momenDia="",ruta="";
		int contador=0;
		String carpeta = "";
		if(nomdia.equals("lun")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/lunes";
			
		}else if(nomdia.equals("mar")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/martes";
			
		}else if(nomdia.equals("mié")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/miercoles";
			
		}else if(nomdia.equals("jue")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/jueves";
			
		}else if(nomdia.equals("vie")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/viernes";
			
		}else if(nomdia.equals("sáb")){
			
			carpeta = p.getProperty("speachCotizacion").trim()+"/sabado";
			
		}else{
			carpeta = "";
		}
		File directorio = new File (carpeta);
		File[] archivos = directorio.listFiles();
		for(File file:archivos){
			contador++;
				nombres = file.getName();
				momenDia=PalabraAlReves(nombres);
				if(momenDia.equals("MAÑANA") && hora<12){
					ruta=nombres;
					break;
				}else if(momenDia.equals("TARDE") && hora>=12){
					ruta=nombres;
					break;
				}else{
					System.out.println("NOTHING");
				}
		}

	return ruta;
	
	} catch (Exception e) {
		   System.out.println("NADAAAA");
	}
	return "";

	}
	
	/****************************************************************************************************************/
	public int aleatorio(int min,int max) {
	    return (int) Math.round(Math.random()*(max-min)+min);
	}
	/****************************************************************************************************************/
	public String palabra85(String cad){
    	String pal="",pal2="";
    	int total=ContaLetras(cad),conta=0;
    	for(int i=0;i<85;i++){
    		
    		 conta++;
    		if(total>=conta){
    			pal=""+cad.charAt(i);
    			pal2+=pal;
    		}else{
    			pal2+=" ";
    		}
    		
    	}
    	return pal2;
    }
	
	/****************************************************************************************************************/
    public int ContaLetras(String palabra){
		
		int cont1=0;
		
		for(int i=0;i<palabra.length();i++){
				cont1++;	
		}
		return cont1;
	}

    /****************************************************************************************************************/
    
	public int ContaNum(double num){
		
		int cont1=0;
		String numletras=""+num,cad="";
		for(int i=0;i<numletras.length();i++){
			cad=""+numletras.charAt(i);
					
			if(cad.equals(".")){
				break;
			}else{
				cont1++;
			}
		}
		return cont1;
	}

    /****************************************************************************************************************/
    public int ContaCentavos(double num){
		
		int cont1=0;
		String numletras=""+num,cad="";
		for(int i=numletras.length()-1;i>=0;i--){//54461.66
			cad=""+numletras.charAt(i);
					
			if(cad.equals(".")){
				break;
			}else{
			cont1++;
			}
		}
		return cont1;
	}

    /****************************************************************************************************************/
   
    public int SinDecimal(double num){
		
		String numletras=""+num,cad="",cad2="";
		for(int i=0;i<numletras.length();i++){
			cad=""+numletras.charAt(i);
			if(cad.equals(".")){
				break;
			}else{
				cad2+=cad;
			}
		}
		return Integer.parseInt(cad2);
	}
	/****************************************************************************************************************/
    public int numMillar(int num){
		
		String numletras=""+num,cad="",cad2="";
		int cont=0,cont2=0;
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(cont>=4){//1311.48
				cont2++;
				cad2=cad+cad2;//8'746,879
				if(cont2==3){
					break;
				}
			}
		}
		return Integer.parseInt(cad2);
	}
	/*****************************************************************************************************************/
    public int numMillon(int num){
		
		String numletras=""+num,cad="",cad2="";
		int cont=0,cont2=0;
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(cont>=7){//EL NUMERO 7 INDICA LA POSICION DEL NUMERO QUE SE LE MANDA
				cont2++;
				cad2=cad+cad2;//8'746,879
				if(cont2==3){
					break;
				}
			}
		}
		return Integer.parseInt(cad2);
	}
	/*****************************************************************************************************************/
    
    public String centavos(double num){
    	
		String numletras=""+num,
		cad="",palabra="";
		int contdec=ContaCentavos(num);
		for(int i=numletras.length()-1;i>=0;i--){//678.89
			cad=""+numletras.charAt(i);
			
			if(cad.equals(".")){
				break;
			}else{
				if(contdec<=1){
					palabra="0"+palabra;
				}
				palabra=cad+palabra;
				
			}
		}
    	return palabra;
    }
    /****************************************************************************************************************/
    public String Unidad(int num,int num2){
		
		int cont=0;
		int conta=ContaNum(TotalFac);
		String numletras=""+num,
		cad="",palabra="";
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(cont==1){
				if(cad.equals("0")){
					palabra="";
				}else if(cad.equals("1")){
					
					if(num2==0){
						palabra="uno";
					}else if(num2==1 && conta<4){
						palabra="uno";
					}else{
						System.out.println("UNIDAD1");
						palabra="";
					}
				}else if(cad.equals("2")){
					palabra="dos";
				}else if(cad.equals("3")){
					palabra="tres";
				}else if(cad.equals("4")){
					palabra="cuatro";
				}else if(cad.equals("5")){
					palabra="cinco";
				}else if(cad.equals("6")){
					palabra="seis";
				}else if(cad.equals("7")){
					palabra="siete";
				}else if(cad.equals("8")){
					palabra="ocho";
				}else{
					palabra="nueve";
				}
			}else if(cont==2){
				if(cad.equals("1")){
					palabra="";
				}else if(cad.equals("2")){
					palabra="";
				}else{
					break;
				}
			}
			
			
		}
		return palabra;
	}
    /****************************************************************************************************************/
    public String Unidad2(int num,int num2){
		
		int cont=0;
		int conta=ContaNum(TotalFac);
		String numletras=""+num,
		cad="",palabra="";//8510045.65
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(cont==1){
				if(cad.equals("0")){
					palabra="";
				}else if(cad.equals("1")){
					if(num2==0){
						System.out.println("UNIDAD2-1");
						palabra="un";
					}else if(num2==1 && conta<4){
						System.out.println("UNIDAD2-2");
						palabra="un";
					}else{
						palabra="";
					}
				}else if(cad.equals("2")){
					palabra="dos";
				}else if(cad.equals("3")){
					palabra="tres";
				}else if(cad.equals("4")){
					palabra="cuatro";
				}else if(cad.equals("5")){
					palabra="cinco";
				}else if(cad.equals("6")){
					palabra="seis";
				}else if(cad.equals("7")){
					palabra="siete";
				}else if(cad.equals("8")){
					palabra="ocho";
				}else{
					palabra="nueve";
				}
			}else if(cont==2){
				if(cad.equals("1")){
					palabra="";
				}else if(cad.equals("2")){
					palabra="";
				}else{
					break;
				}
			}
			
			
		}
		return palabra;
	}
    /****************************************************************************************************************/
	public String Decenas(int num){
		
		int cont=0,est=0;
		String numletras=""+num,
		cad="",palabra="",cad2="",cad3="";
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			cad2=cad+cad2;
			if(cont==1){
								
				if(cad.equals("0")){
					cad3="";
				}else{
					cad3=" y";
					if(cad.equals("1")){
					   	est=1;
					}
				}
			}else if(cont==2){//7816.58
				if(cad.equals("0")){
					palabra="";
				}else if(cad.equals("1")){
					
					if(cad2.equals("10")){
						palabra="diez";
					}else if(cad2.equals("11")){//7421
						palabra="once";
					}else if(cad2.equals("12")){
						palabra="doce";
					}else if(cad2.equals("13")){
						palabra="trece";
					}else if(cad2.equals("14")){
						palabra="catorce";
					}else if(cad2.equals("15")){
						palabra="quince";
					}else if(cad2.equals("16")){
						palabra="dieciseis";
					}else if(cad2.equals("17")){
						palabra="diecisiete";
					}else if(cad2.equals("18")){
						palabra="dieciocho";
					}else{
						palabra="diecinueve";
					}
				}else if(cad.equals("2")){
					
					if(cad2.equals("20")){
						palabra="veinte";
					}else if(cad2.equals("21")){//7421
						if(est==0){
							palabra="veintiuno";
						}else{
							palabra="veinte y";
						}
						
					}else if(cad2.equals("22")){
						palabra="veintidós";
					}else if(cad2.equals("23")){
						palabra="veintitrés";
					}else if(cad2.equals("24")){
						palabra="veinticuatro";
					}else if(cad2.equals("25")){
						palabra="veinticinco";
					}else if(cad2.equals("26")){
						palabra="veintiséis";
					}else if(cad2.equals("27")){
						palabra="veintisiete";
					}else if(cad2.equals("28")){
						palabra="veintiocho";
					}else{
						palabra="veintinueve";
					}
				}else if(cad.equals("3")){
					palabra="treinta"+cad3;
				}else if(cad.equals("4")){
					palabra="cuarenta"+cad3;
				}else if(cad.equals("5")){
					palabra="cincuenta"+cad3;
				}else if(cad.equals("6")){
					palabra="sesenta"+cad3;
				}else if(cad.equals("7")){
					palabra="setenta"+cad3;
				}else if(cad.equals("8")){
					palabra="ochenta"+cad3;
				}else{
					palabra="noventa"+cad3;
				}
			}else{
				break;
			}
			
		}
		return palabra;
	} 
	/****************************************************************************************************************/
    public String Centenas(int num){
		
    	int cont=0;
		String numletras=""+num,
		cad="",palabra="",cad2="",
		primCer="",segCer="";
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			cad2=cad+cad2;
			if(cont==1){
				if(cad.equals("0")){
					primCer="0";
				}else{
					//NADA
				}
			}else if(cont==2){
				if(cad.equals("0")){
					segCer="0";
				}else{
					//NADA
				}
			}else if(cont==3){//7816.58
				if(cad.equals("0")){
					palabra="";
				}else if(cad.equals("1")){
					if(primCer.equals("0") && segCer.equals("0")){
						palabra="cien";
					}else{
						palabra="ciento";
					}
				}else if(cad.equals("2")){
					palabra="doscientos";
				}else if(cad.equals("3")){
					palabra="trescientos";
				}else if(cad.equals("4")){
					palabra="cuatrocientos";
				}else if(cad.equals("5")){
					palabra="quinientos";
				}else if(cad.equals("6")){
					palabra="seiscientos";
				}else if(cad.equals("7")){
					palabra="setecientos";
				}else if(cad.equals("8")){
					palabra="ochocientos";
				}else{
					palabra="novecientos";
				}
			}else{
				break;
			}
			
		}
		return palabra;
	}
	/****************************************************************************************************************/
    public String Millar(int num){
		
		    int contaNum=ContaNum(TotalFac);
		    int sindec=SinDecimal(TotalFac);
		    String numUno="";
		    
		    for(int i=0;i<contaNum;i++){//1311.48
		    	
		    	if(i==3){
		    		numUno=cuartoNumUno(sindec);
		    	}
		    	if(i==4){
		    		
		    	}
		    }
		    /*if(contaNum>4){
		    	
		    }*/
    	
    	int number=1;
		String palabra=Centenas(num)+" "+Decenas(num)+" "+Unidad(num,number)+numUno+" mil";
		return palabra;
	}
	/****************************************************************************************************************/
   public String Millon(int num){
	   int number=1;
		String palabra=Centenas(num)+" "+Decenas(num)+" "+Unidad2(num,number)+" "+letraMillon(num);
		return palabra;
	}
	/****************************************************************************************************************/
   public String letraMillon(int num){
		
	   // ESTE METODO RECIBE EL NUMERO A PARTIR DE LA POSICION DEL MILLON EJEMPLO SI RECIBE ESTE NUMERO
	   //8'746,579 ENTONCES LO UE RECIBE SOLO ES EL 8
		int cont=0;
		String numletras=""+num,
		cad="",palabra="";//8'746,579 
		for(int i=numletras.length()-1;i>=0;i--){
			cad=""+numletras.charAt(i);
			cont++;
			if(cont==1){
				if(cad.equals("1")){
					palabra="un millon ";
				}else{
					palabra="millones ";
				}
		    }
		}
		return palabra;
	}
   /****************************************************************************************************************/
   public void modificarCorreos(){
		
	   
	   String cSexo="";
	   if(cboSexo.getSelectedIndex()==0){
		   cSexo=",";
	   }else{
		   cSexo=", SEX_CLI='"+cboSexo.getSelectedIndex()+"', ";
	   }
	   
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
		objAccesoBD.crearConexion();
		
			String sql="UPDATE tb_cliente SET CONA_CLI='"+txtAtencion2.getText()+"', MAILA_CLI='"+txtEmail1.getText()+"'"+cSexo+
				"MAILB_CLI='"+txtEmail2.getText()+"' "+
				" WHERE COD_CLI="+objBuscarCot.COD_CLI+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			System.out.println("Hubo un error al modificar el Cliente");
			objGUI.mostrarAviso("Hubo un error al modificar los datos del Cliente");
		}else{
			System.out.println("Se modifico el Cliente");
			objGUI.mostrarAviso("Se modifico los datos del Cliente");
		}
		
		}finally{
			
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
	
	}
   /****************************************************************************************************************/
   public void modificarCorreosCye(){
		
	   
	   String cSexo="";
	   if(cboSexo.getSelectedIndex()==0){
		   cSexo=",";
	   }else{
		   cSexo=", SEX_CLI='"+cboSexo.getSelectedIndex()+"', ";
	   }
	   
		AccesoBD2 objAccesoBD=  new AccesoBD2();
		
		try{
			
		
		objAccesoBD.crearConexion();
		
			String sql="UPDATE tb_cliente SET CONA_CLI='"+txtAtencion2.getText()+"', MAILA_CLI='"+txtEmail1.getText()+"'"+cSexo+
				"MAILB_CLI='"+txtEmail2.getText()+"' "+
				" WHERE COD_CLI="+objBuscarCot.COD_CLI+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			System.out.println("Hubo un error al modificar el Cliente");
		}else{
			System.out.println("Se modifico el Cliente");
		}
		
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}	
		
	
	}
   public  String link(String cad){
	   
	   String pal="",pal2="";
	   
	   for(int i=cad.length()-1;i>=0;i--){
		   
		   pal=""+cad.charAt(i);
		   if(pal.equals("@")){
			   break;
		   }else{
			   pal2=pal+pal2;
		   }
		   
	   }
	   
	return pal2;
	   
   }
   
    public  String sinLink(String cad){
	   
	   String pal="",pal2="";
	   
	   for(int i=0;i<cad.length();i++){
		   
		   pal=""+cad.charAt(i);
		   if(pal.equals("@")){
			   break;
		   }else{
			   pal2+=pal;
		   }
		   
	   }
	   
	return pal2;
	   
   }
   
   /******************************************************************************************************************/
   public void forzarCerrado() { 
		
		try { 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setClosed(true); 
		this.setEnabled(false);

		} catch (PropertyVetoException ex) { 
		
		}
	}
   /*****************************************************************************************************************/
   
   public void listarBuscarCoti(){
	   
	   objBuscarCot= new BuscarCotizacion();
		String[] botones1 = {"Aceptar","Cancelar"};//Esto es el nombre
        int showOptionDialog = JOptionPane.showOptionDialog(
    		   this,                             			
    		   objBuscarCot,                                    
    		   "Buscar Cotizacion", 		
    		    0,          						        
    		   -1,            								
    		   null,                                       
    		  botones1,
    		   "Cerrar"
    		                                  	
    	);
        
        if(showOptionDialog==0){//ACEPTAR
       	    
        	//System.out.println("YESSSS");
       	    TranCotizacionAutMant objMant= new TranCotizacionAutMant();
			objMenu.jDesktopPane1.add(objMant);
       	    objBuscarCot=null;
       	
        }else if(showOptionDialog==1){
	        objBuscarCot=null;
	       	System.out.println("1");//CANCELAR
        }else{
        	objBuscarCot=null;
       	    System.out.println("2");//CERRAR
        }
	   
   }
   /*****************************************************************************************************************/
   public void  PintarFila(){
		
		TableColumn column2 = tblLista.getColumn(tblLista.getColumnName(2));
		TableColumn column12 = tblLista.getColumn(tblLista.getColumnName(12));
		TableColumn column18 = tblLista.getColumn(tblLista.getColumnName(18));
		
		column2.setCellRenderer(renderer);
		column12.setCellRenderer(renderer);
		column18.setCellRenderer(renderer);
	} 
   /*****************************************************************************************************************/
   
   public void borrarFilaCotizacion(){
	   
	       
		int row= tblLista.getSelectedRow();
		//int cant=tblLista.getSelectedRowCount();
		//int total= row+cant;	
		
		int array []=tblLista.getSelectedRows();	     
		int cont=-1;
		double pesototal=0;
		BeanCotizacionVarios objCotisacionVarios=null;
				   
		   if(row==-1){
	    	   JOptionPane.showMessageDialog(null, "0 filas seleccionadas", "", 1);    	  
	       }else{
	    	   
	    	    for (int i : array){
	    	    	
	    	    	System.out.println("YYYY: "+i);
					cont++;
					objServletCotVarios.eliminar(i-cont);
					modelo2.removeRow(i-cont);					
	    	    }
   	    
	    	    int contM=0;				
				int n=modelo2.getRowCount();
				
				for (int i=0; i<n; i++)
				modelo2.removeRow(0);				
				
				
				for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
					
					contM=contM+1;
					objCotisacionVarios=objServletCotVarios.obtener(i);
					objCotisacionVarios.setNumitem(""+contM);
					
					if(objCotisacionVarios.getPesoprod().equals("")){
						pesototal=0;
					}else{
						pesototal=Integer.parseInt(objCotisacionVarios.getCancot())*Double.parseDouble(objCotisacionVarios.getPesoprod());
					}
					//System.out.println("GGGG: "+objCotisacionVarios.getNumitem());
					Object[] array1={ Integer.parseInt(""+contM), Integer.parseInt(objCotisacionVarios.getCancot()), 
							objCotisacionVarios.getUmedprod(), objCotisacionVarios.getNomprod(),
							objCotisacionVarios.getNommar(),objCotisacionVarios.getModprod(),Double.parseDouble(objCotisacionVarios.getCosteEntreporc()) ,
							Double.parseDouble(objCotisacionVarios.getIgv$()),Double.parseDouble(objCotisacionVarios.getCosteXporcXcant()),
							Double.parseDouble(objCotisacionVarios.getTotal$()),Double.parseDouble(objCotisacionVarios.getCoste()),
							Double.parseDouble(objCotisacionVarios.getCosteXcant()),Double.parseDouble(objCotisacionVarios.getDife()), 
							Double.parseDouble(objCotisacionVarios.getPunits()),Double.parseDouble(objCotisacionVarios.getIgvs()),
							Double.parseDouble(objCotisacionVarios.getPtotals()),Double.parseDouble(objCotisacionVarios.getTotals()),
							objCotisacionVarios.getFecdet() ,Double.parseDouble(objCotisacionVarios.getPorgacot()) , 
							objCotisacionVarios.getNomprove(),objCotisacionVarios.getTiempoentrega(),formato2(pesototal),
							formato2(Double.parseDouble(objCotisacionVarios.getPesoCarrete()))};
					modelo2.addRow(array1);
				 
				}
				
				calcularTotalesBorrar();
				calcular();
				
	       }
	    	 
	    	 
	       
	   
   }
    public void actionPerformed(ActionEvent e){
    	
    	/*for(int i=0;i<tblLista.getRowCount();i++){
	   	     if(tblLista.getValueAt(i, 23)!=null){
	   	      chkheader.chk.setSelected(false);
	   	      tblLista.setValueAt(false, i, 23);
	   	      repaint();
	   	      tblLista.updateUI();
	   	     }
         }*/
    	
			
		if(e.getSource()==btnGuardarCotizacionFinal){
			try {
				int cod=guardarFinal();
				int tam=tamañodelExcel();
				arregloCadenas= new Object[11];
				arregloObjetos= new Object[tam][13];
				//este es para ver elk tamaño
				
				try {
				pasarExcel(cod);
				objPasarExcel= new PasarExcelTransCotMant();
				objPasarExcel.crearExcel(arregloCadenas,arregloObjetos);
				
				} catch (IOException e1) {
				e1.printStackTrace();
				}
				//borrarTodo();
			} catch (Exception e2) {
				objGUI.mostrarAviso("Debe Buscar una Cotizacion");
			}
			forzarCerrado();
			listarBuscarCoti();
			/*TranCotizacionAutMant objMant= new TranCotizacionAutMant();
			objMenu.jDesktopPane1.add(objMant);*/
		}		
		if(e.getSource()==btnGuardar){
			
				int cod=guardar();
				int tam=tamañodelExcel();
				arregloCadenas= new Object[11];
				arregloObjetos= new Object[tam][13];
				//este es para ver elk tamaño
				try {
				pasarExcel(cod);
				//System.out.println("NNNNNNNNNNNNN");
				objPasarExcel= new PasarExcelTransCotMant();
				objPasarExcel.crearExcel2(arregloCadenas,arregloObjetos);
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			borrarTodo();
			forzarCerrado();
			listarBuscarCoti();
			/*TranCotizacionAutMant objMant= new TranCotizacionAutMant();
			objMenu.jDesktopPane1.add(objMant);*/
			
		}
		
		if(e.getSource()==btnBuscarCotizacion){
			
			try {
				
				String agente="",nomagen="";
				
				//objBuscarTipoCot=null;
        		objBuscarCot= new BuscarCotizacion();
        		
        		 String[] botones1 = {"Aceptar","Cancelar"};//Esto es el nombre
    	         int showOptionDialog = JOptionPane.showOptionDialog(
    	     		   this,                             			
    	     		  objBuscarCot,                                    
    	     		   "Buscar Cotizacion", 		
    	     		    0,          						        
    	     		   -1,            								
    	     		   null,                                       
    	     		  botones1,
    	     		   "Cerrar"
    	     		                                  	
    	     	);
    	         if(showOptionDialog==0){
    	        	 
    	         
    	         System.out.println("ESTADO RECIBIDO:"+estado);
    	        /* if(estado==0){
    	        	 System.out.println("NO HAY NADA");
    	         }else{*/
    	         
    	        	 CODCOT=objBuscarCot.COD_COT;
	    	         txtNCotizacion.setText(CODCOT);
	    	         IDECOT =objBuscarCot.IDE_COT;
	    	         txtNroModificacion.setText(IDECOT);
	    	         txtSeñores2.setText(objBuscarCot.NOM_CLI);
	    	         txtAtencion2.setText(objBuscarCot.CONA_CLI);
	    	         txtReferencia.setText(objBuscarCot.REF_COT);
	    	         agente=objBuscarCot.AGE_CLI;
	    	         if(agente.equals("0")){
	    	        	 nomagen="";
	    	         }else if(agente.equals("1")){
	    	        	 nomagen="Con Agente de Retencion";
	    	         }else{
	    	        	 nomagen="Sin Agente de Retencion";
	    	         }
	    	         txtAgente.setText(nomagen);
	    	         txtEmail1.setText(objBuscarCot.MAILA_CLI);
	    	         txtEmail2.setText(objBuscarCot.MAILB_CLI);
	    	         txtEmpEst.setText("ELECTRO CORNEJO");
	    	         	    	         
	    	         if(verificarCot(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT))==1){
		    	         listarCotizacion(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
		    	     }else{
		    	         listarCotizacionFinal(Integer.parseInt(CODCOT), Integer.parseInt(IDECOT));
	 	    	     }
	    	         
	    	         rdbDolares.setEnabled(true);
	    	         rdbSoles.setEnabled(true);
	    	         calcular();
	    	         objBuscarCot=null;
	    	         estado=0;
	    	         System.out.println("0");//ACEPTAR
    	         }else if(showOptionDialog==1){
    	        	 objBuscarCot=null;
		        	 System.out.println("1");//CANCELAR
		         }else{
		        	 objBuscarCot=null;
		        	 System.out.println("2");//CERRAR
		         } 
				
			} catch (Exception e2) {
				//NADA
			}
			  
		}
		if(e.getSource()==btnAgregar){
			
			double pesototal=0;
			BuscarProdMantCotDialog objDialogBuscarProdMantCot = new BuscarProdMantCotDialog(objMenuP);
			//PruebaJDialog dialogoModal = new PruebaJDialog(objMenuP);
			
			objDialogBuscarProdMantCot.setVisible(true);
			objDialogBuscarProdMantCot.pack();  // para darle tamaño automático a la ventana.
			if(objDialogBuscarProdMantCot.NOM_PROD==null){
				System.out.println("ENTRO AL NULL");
			}else{//ACEPTAR 	 

		         
		         COD_PROD=objDialogBuscarProdMantCot.COD_PROD;
		         NOM_PROD=objDialogBuscarProdMantCot.NOM_PROD;
		         COSTE=objDialogBuscarProdMantCot.COSTE;
		         COD_MAR=objDialogBuscarProdMantCot.COD_MAR;
		         MARCA=objDialogBuscarProdMantCot.MARCA;
		         CUMED=objDialogBuscarProdMantCot.CUMED;
		         UMED=objDialogBuscarProdMantCot.UMED;
		         FECHA=objDialogBuscarProdMantCot.FECHA;
		         COD_PROVEE=objDialogBuscarProdMantCot.COD_PROVEE;
		         PROVEEDOR=objDialogBuscarProdMantCot.PROVEEDOR;
		         COD_PROD1=objDialogBuscarProdMantCot.COD_PROD1;
		         NOM_PROD1=objDialogBuscarProdMantCot.NOM_PROD1;
		         PESO_PROD=objDialogBuscarProdMantCot.PESO_PRODUCTO;
		         TIEMPOENTREGA="1 Dia";
		         MODPROD=objDialogBuscarProdMantCot.MODPROD;
		         
		         
		         System.out.println("ESTO ES LO QUE VIENE DESPUES DE BUSCAR 1:  "
		        		 +COD_PROD+","+NOM_PROD+","+COSTE+","+MARCA+","+UMED+","+FECHA+","+COD_PROVEE
		        		 +","+PROVEEDOR);
		         
		         System.out.println("el tamaño actual del arreglo es:"+objServletCotVarios.tamaño());
		       
		        BeanCotizacionVarios objCotisacionVarios=objServletCotVarios.obtener(objServletCotVarios.tamaño()-1) ;
		        System.out.println("HHHH: "+objCotisacionVarios.getNumitem());
	
		        
	 BeanCotizacionVarios objCotVarios=new BeanCotizacionVarios(objCotisacionVarios.getCodcot(),objCotisacionVarios.getIdecot(),
	 ""+(Integer.parseInt(objCotisacionVarios.getNumitem())+1), objCotisacionVarios.getCodcli(),"0", UMED, NOM_PROD, COD_PROD,
	  MARCA,""+formato(Double.parseDouble(""+COSTE)) ,"",""+formato(Double.parseDouble(""+COSTE)),"",""+formato(Double.parseDouble(""+COSTE)),
	 ""+formato(Double.parseDouble(""+COSTE)),""+formato(Double.parseDouble(""+COSTE)),"","","","",FECHA,objCotisacionVarios.getCodcam(), objCotisacionVarios.getCodven(), 
	 "1",PROVEEDOR, COD_PROVEE,COD_MAR,CUMED,"0",PESO_PROD,TIEMPOENTREGA,"0",MODPROD,"");
									 
							objServletCotVarios.adicionar(objCotVarios);
		      
		         objCotVarios.setCodprod(COD_PROD);
		         objCotVarios.setCoste(COSTE);
		         objCotVarios.setNommar(MARCA);
		         objCotVarios.setCodumed(CUMED);
		         objCotVarios.setUmedprod(UMED);
		         objCotVarios.setFecdet(FECHA);
		         objCotVarios.setCodprove(COD_PROVEE);
		         objCotVarios.setNomprove(PROVEEDOR);
		         objCotVarios.setNomprod(NOM_PROD);
		         objCotVarios.setPesoprod(PESO_PROD);
		         objCotVarios.setTiempoentrega(TIEMPOENTREGA);
		         objCotVarios.setPesoCarrete("0");
		         objCotVarios.setModprod(MODPROD);
		         
		         /*BeanCotizacionVarios objCotVarios		 
				 objServletCotVarios.adicionar(objCotVarios);*/
		         
		       System.out.println("KKKKKKKKKKKKK:"+objCotVarios.getNomprod());
		 
              BeanCotizacionVarios objCotisacionV=objServletCotVarios.obtener(objServletCotVarios.tamaño()-1) ;
		      System.out.println("LLLLLLLLLLLLL:"+objCotisacionV.getNomprod());
		        
		            if(objCotVarios.getPesoprod().equals("")){
						pesototal=0;
					}else{
						pesototal=(Integer.parseInt(objCotVarios.getCancot())
						  *Double.parseDouble(objCotVarios.getPesoprod()));
					}
		            
					Object[] array={ Integer.parseInt(objCotisacionV.getNumitem()), Integer.parseInt(objCotisacionV.getCancot()), 
							objCotisacionV.getUmedprod(), objCotisacionV.getNomprod(),
							objCotisacionV.getNommar(),objCotisacionV.getModprod(),Double.parseDouble(objCotisacionV.getCosteEntreporc()) ,
							Double.parseDouble("0"),Double.parseDouble("0"),
							Double.parseDouble("0"),Double.parseDouble("0"),
							Double.parseDouble("0"),Double.parseDouble("0"), 
							Double.parseDouble("0"),Double.parseDouble("0"),
							Double.parseDouble("0"),Double.parseDouble("0"),
							objCotisacionV.getFecdet() ,Double.parseDouble(objCotisacionV.getPorgacot()) , 
							objCotisacionV.getNomprove(),objCotisacionV.getTiempoentrega(),formato2(pesototal),
							formato2(Double.parseDouble(objCotisacionV.getPesoCarrete()))};
					modelo2.addRow(array);
					
			 }
		       
		}
		
		if(e.getSource()==btnBorrar){
			
			borrarFilaCotizacion();
			
		}
		if(e.getSource()==btnEnviar){
			
			
				cargarEnviarCorreos();
				forzarCerrado();
				/*TranCotizacionAutMant objMant= new TranCotizacionAutMant();
				objMenu.jDesktopPane1.add(objMant);*/
			
		}
		
		if(e.getSource()==btnFactura){
			
				try {
				
						int tam=tamañodelExcel();
					    int tam2=numeroDeFilasFac;
						
                        if(contaFilasFac<=46){
							
							arregloCadenas2= new Object[5];
							arregloObjetos2= new Object[tam][5];
							pasarExcelFactura();
							objPasarExcelFactura= new PasarExcelFactura();
							objPasarExcelFactura.crearExcel(arregloCadenas2,arregloObjetos2);
						}else{
							
								arregloCadenas2= new Object[5];
								arregloObjetos2= new Object[tam2][5];
								pasarExcelFactura2();
								objPasarExcelFactura= new PasarExcelFactura();
								objPasarExcelFactura.crearExcel(arregloCadenas2,arregloObjetos2);
							if(conta2==46){
								
								System.out.println("VAMOS CARAJO");	
								estado=1;
								arregloCadenas2= new Object[5];
								arregloObjetos2= new Object[(tam-tam2)][5];
								pasarExcelFactura2();
								objPasarExcelFactura= new PasarExcelFactura();
								objPasarExcelFactura.crearExcel(arregloCadenas2,arregloObjetos2);
							}
							
						}
					
						forzarCerrado();
						TranCotizacionAutMant objMant= new TranCotizacionAutMant();
						objMenu.jDesktopPane1.add(objMant);
						
					
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				numeroDeFilasFac=0;
				//estado=0;
				//borrarTodo();
			
		
		}
		if(e.getSource()==btnPrueba){
			
			for(int i=0;i<tblLista.getRowCount();i++){
		   	     
				if(tblLista.getValueAt(i, 23)!=null){
					
				      chkheader.chk.setSelected(false);
				      tblLista.setValueAt(false, i, 23);
				      System.out.println("fila:"+i);
				      repaint();
				      tblLista.updateUI();
				 }
		   	     
	        }
			
		}
		
		
		/*if(e.getSource()==btnpruebas){
		
			int tam=tamañodelExcel();
		   
			try {
					arregloCadenas2= new Object[5];
					arregloObjetos2= new Object[tam][5];
					pasarExcelFactura();
					objPasarExcelFactura= new PasarExcelFactura();
					objPasarExcelFactura.crearExcel(arregloCadenas2,arregloObjetos2);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			numeroDeFilasFac=0;
		}*/
		
		if(e.getSource()== btnAdjuntar){
			
			JFileChooser selector=new JFileChooser();
			int r=selector.showOpenDialog(TranCotizacionAutMant.this);
			if(r==JFileChooser.APPROVE_OPTION){
				
				File f=selector.getSelectedFile();
				String nombre=f.getName();
				//DecimalFormat dc=new DecimalFormat("0.00");
				//Double peso=(f.length()/1024.0);
				String ubicacion=f.getAbsolutePath();
				numarchivos++;
				System.out.println("numarchivos: "+numarchivos);
				
				if(numarchivos==1){
					acumulaCadena=ubicacion;
					nombreAdjuntos=nombre;
				}else{
					acumulaCadena+=";"+ubicacion;
					nombreAdjuntos+=";"+nombre;
				}
				
				System.out.println("RUTA: "+acumulaCadena);
				txtRuta.setText(acumulaCadena);
				
				/*modelo.setValueAt(nombre, numarchivos, 0);
				modelo.setValueAt(dc.format(peso)+" Kb", numarchivos, 1);
				modelo.setValueAt(ubicacion, numarchivos, 2);
				archvos.add(f);
				numarchivos++;*/
			}
		}
		if(e.getSource()==btnModificar){
			
			if(est==1){
				modificarCorreos();
			}else{
				modificarCorreosCye();
			}
			
			
		}
		if(e.getSource()==rdbSoles){
			rdbSoles.setSelected(true);
			rdbDolares.setSelected(false);
			btnFactura.setEnabled(true);
			selecciona=1;
		}
		if(e.getSource()==rdbDolares){
			rdbSoles.setSelected(false);
			rdbDolares.setSelected(true);
			btnFactura.setEnabled(true);
			selecciona=2;
		}
		
	}
	/**************************************************************************************************************
	 ***************************************************************************************************************/
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==1){
				
				int fila = tblLista.getSelectedRow();
				BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(fila);
				
				objCambiarCant =  new CambiarCant();
				objCambiarCant.txtCantidad.setText(""+modelo2.getValueAt(fila, 1));
				
				String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
		         int showOptionDialog = JOptionPane.showOptionDialog(
		     		   this,                             			
		     		  objCambiarCant,                                    
		     		   "Cambiar Cantidad", 		
		     		    0,          						        
		     		   -1,            							
		     		   null,                                       
		     		  botones,
		     		   "Cerrar"
		     		                               	
		     	);
		         
		         if(showOptionDialog==1||showOptionDialog==-1){
		        	 //x--->no cogio nada
		         }else{
		        	 
		        	 String cant=objCambiarCant.txtCantidad.getText();
		        	 
		        	 if(objCambiarCant.chkCantidad.isSelected()){
		        		
		        		System.out.println("Encendido");  		
		           		objCotVarios=objServletCotVarios.obtener(fila);
		        		
		 		        System.out.println("ES LA FILA :"+fila);
		 		        modelo2.setValueAt(Double.parseDouble(cant), fila, 1);
		 		        System.out.println("TOTAL: "+modelo2.getRowCount());
		 		        objCotVarios.setCancot(cant);
		 		        calcularParte(fila);
		 		        //calcularTotales();
		 		        //calcular(); 
		        		 
		        		 for(int i=0;i<modelo2.getRowCount();i++){
		        			 		        			    
		        		    objCotVarios=objServletCotVarios.obtener(i);
	        			    
			 		        System.out.println("ES LA FILA :"+i);
			 		        modelo2.setValueAt(Double.parseDouble(cant), i, 1);
			 		        objCotVarios.setCancot(cant);
			 		        calcularParte(i);
			 		        
		        		 }
		        		 
		        		 calcularTotales();
			 		     calcular(); 
		        		
		        	 }else{
		        		 
		        		//String cant=objCambiarCant.txtCantidad.getText();
		        		System.out.println("Apagado");
		 		        System.out.println("K CANTIDAD LE PASA?:"+cant);
		 		        
		 		        System.out.println("ES LA FILA :"+fila);
		 		        modelo2.setValueAt(Double.parseDouble(cant), fila, 1);
		 		        objCotVarios.setCancot(cant);
		 		        calcularParte(fila);
		 		        calcularTotales();
		 		        //AQUI VA EL METODO PARA CALCULAR LOS TOTALES $ Y TOTALES S/.
		 		        calcular(); 
		        		 
		        	 }
		        	 
		        
		         
		         }
		         
				
			}
			/************************************************************************************************/
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==20){
				
				int fila = tblLista.getSelectedRow();
				objCamTiemEntrega.txtCantidad.setText(""+modelo2.getValueAt(fila, 20));
				String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
		         int showOptionDialog = JOptionPane.showOptionDialog(
		     		   this,                             			
		     		  objCamTiemEntrega,                                    
		     		   "Cambiar Tiempo Entrega", 		
		     		    0,          						        
		     		   -1,            								
		     		   null,                                       
		     		  botones,
		     		   "Cerrar"
		     		                                  	
		     	);
		         if(showOptionDialog==1||showOptionDialog==-1){
		        	 //x--->no cogio nada
		         }else{
		        String tiempo=objCamTiemEntrega.txtCantidad.getText();
		        System.out.println("K TIEMPO LE PASA?:"+tiempo);
		         BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(fila);
		         System.out.println("ES LA FILA :"+fila);
		         modelo2.setValueAt(tiempo, fila, 20);
		         objCotVarios.setTiempoentrega(tiempo);
		      
		         //calcularParte(fila);
		         //calcular(); 
		         }
		         
				
			}
			/************************************************************************************************/
			
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==3){
				
				int fila = tblLista.getSelectedRow();
				System.out.println("ENTRO ALA FILA:"+fila);
				//int columna=tblLista.getSelectedColumn();
				String canti=""+modelo2.getValueAt(fila, 1),recibe="";
				double cant=Double.parseDouble(canti);
				double pesototal=0;
				String peso="";
				nombre=(String) modelo2.getValueAt(fila, 3);
				marca=(String) modelo2.getValueAt(fila, 4);//PERO DEBERIA ESTAR EN 4,PORK HAY ESTA LA MARCA
				objBuscarProd=new BuscarProd();
				objBuscarProd.txtAlternativo.setText(nombre);
				objBuscarProd.txtMarca2.setText(marca);
				System.out.println("SE TIENE QUE MOSTAR:"+nombre+"-"+marca);
			
					String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
			         int showOptionDialog = JOptionPane.showOptionDialog(
			     		   this,                             			
			     		  objBuscarProd,                                    
			     		   "Buscar Producto", 		
			     		    0,          						        
			     		   -1,            								
			     		   null,                                       
			     		  botones,
			     		   "Cerrar"
			     		                                  	
			     	);
			         if(showOptionDialog==1||showOptionDialog==-1){//CANCELAR Y X
			         System.out.println("NO COGIO NADA");
			         }else{//ACEPTAR 	 
			         COD_PROD=objBuscarProd.COD_PROD;
		
			         NOM_PROD=objBuscarProd.NOM_PROD;
			         COSTE=objBuscarProd.COSTE;
			         COD_MAR=objBuscarProd.COD_MAR;
			         MARCA=objBuscarProd.MARCA;
			         CUMED=objBuscarProd.CUMED;
			         UMED=objBuscarProd.UMED;
			         FECHA=objBuscarProd.FECHA;
			         COD_PROVEE=objBuscarProd.COD_PROVEE;
			         PROVEEDOR=objBuscarProd.PROVEEDOR;
			         COD_PROD1=objBuscarProd.COD_PROD1;
			         NOM_PROD1=objBuscarProd.NOM_PROD1;
			         PESO_PROD=objBuscarProd.PESO_PRODUC;
			         TIEMPOENTREGA=""+modelo2.getValueAt(fila, 20);
			         MODPROD=objBuscarProd.PESO_PRODUC;
			         
			         System.out.println("ESTO ES LO QUE VIENE DESPUES DE BUSCAR "
			        		 +COD_PROD+","+NOM_PROD+","+COSTE+","+MARCA+","+UMED+","+FECHA+","+COD_PROVEE
			        		 +","+PROVEEDOR);
			       //COD_COT, IDE_COT, NUM_ITEM, COD_CLI, CAN_COT,
			     	//UMED_PROD, NOM_PRODALT, COD_PROD, COD_PRODALT,
			     	//NOM_MAR, P.Total $, Total $, Costo $, Total $,
			     	//Dif. $, FEC_DET, COD_CAM, COD_VEN, PORGA_COT, NOM_PROVE, COD_PROVE
			         System.out.println("el tamaño actual del arreglo es:"+objServletCotVarios.tamaño());
			         System.out.println("el escogido es:"+objServletCotVarios.obtener(fila).getNomprod());
			         BeanCotizacionVarios objCotVarios= objServletCotVarios.obtener(fila);
			      
			         objCotVarios.setCodprod(COD_PROD);
			         objCotVarios.setCoste(COSTE);
			         objCotVarios.setCodmar(COD_MAR);
			         objCotVarios.setNommar(MARCA);
			         objCotVarios.setCodumed(CUMED);
			         objCotVarios.setUmedprod(UMED);
			         objCotVarios.setFecdet(FECHA);
			         objCotVarios.setCodprove(COD_PROVEE);
			         objCotVarios.setNomprove(PROVEEDOR);
			        //objCotVarios.setCodprodalt(COD_PROD);
			         objCotVarios.setNomprod(NOM_PROD);
			         objCotVarios.setPesoprod(PESO_PROD);
			         objCotVarios.setTiempoentrega(TIEMPOENTREGA);
			         if(PESO_PROD.equals("")){
			        	 pesototal=0;
			         }else{
			        	 pesototal=Double.parseDouble(PESO_PROD);
			         }
			         peso=""+formato(pesototal);
			         objCotVarios.setModprod(MODPROD);
			         
			         modelo2.setValueAt(UMED, fila, 2);
			         modelo2.setValueAt(NOM_PROD, fila, 3);
			         modelo2.setValueAt(MARCA, fila, 4);
			         modelo2.setValueAt(FECHA, fila, 17);//Fecha
					 modelo2.setValueAt(PROVEEDOR, fila, 19);//Proveedor
					 modelo2.setValueAt(TIEMPOENTREGA, fila, 20);//Tiempo
					 modelo2.setValueAt(peso, fila, 21);//PesoTotal
					 modelo2.setValueAt(MODPROD, fila, 5);//MODELO
					 
			         calcularParte(fila);//PARA QUE SE CALCULE Y SE MUESTRE EN LA TABLA
			         calcularTotales();
			         //LA PARTE DESDE LA MARCA 4
			         calcular();//PARA QUE CALCULE EL TOTAL ABAJO
				
				 }
				
				
				}
			if(e.getSource()==tblLista&(
					
					tblLista.getSelectedColumn()==6||
					tblLista.getSelectedColumn()==7||
					tblLista.getSelectedColumn()==8||
					tblLista.getSelectedColumn()==9||
					tblLista.getSelectedColumn()==10||
					tblLista.getSelectedColumn()==11||
					tblLista.getSelectedColumn()==12)){
				
				int ffila = tblLista.getSelectedRow();
				 codprodpasar=objServletCotVarios.obtener(ffila).getCodprod();
				 codprovepasar=objServletCotVarios.obtener(ffila).getCodprove();
				 codmarpasar=objServletCotVarios.obtener(ffila).getCodmar();
				 codumedpasar=objServletCotVarios.obtener(ffila).getCodumed();
				String codCos=objServletCotVarios.obtener(ffila).getCodCoste();
				
				if(codCos.equals("0")){
					cOs="0";
				}else{
					cOs=precioXcodCosto(codCos);
				}
				objCambiarCosto = new CambiarCosto();
				
			String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
		    int showOptionDialog=JOptionPane.showOptionDialog(this,objCambiarCosto,"Cambiar de Coste de Compra!",0,-1,null,botones,"Cerrar");  
		    if(showOptionDialog==1||showOptionDialog==-1){//CANCELAR Y X
		         System.out.println("NO COGIO NADA");
		         
		         
		    }else{
		    	
		    	if(objCambiarCosto.txtCostoNuevoTransformado.getText().equals("")&&objCambiarCosto.txtCostoRealNuevo.getText().equals("")){
		    		
		    	}else{
		    	Double costo= Double.parseDouble( "" +objCambiarCosto.txtCostoRealNuevo.getText());
		    	Double costoTrans= Double.parseDouble( "" +objCambiarCosto.txtCostoNuevoTransformado.getText());
		    	Integer cod_cos=ingresarCosto(costo);
		    	
		    	if(cod_cos==0){
		    		
		    		objGUI.mostrarAviso("ERRROR!");
		    	}else{
		    		BeanCotizacionVarios objCotVarios= objServletCotVarios.obtener(ffila);
				                       
			         objCotVarios.setCodCoste(cod_cos.toString());
			         objCotVarios.setCoste(costoTrans.toString())  ;                                                                            
			         Double porc=calcularNuevoPrecio(costoTrans,ffila) ; 
			         //calcularParte(ffila);
			         calcularTotales();
			         calcular();
			         
			         //modelo2.setValueAt(Double.parseDouble(objescCal.txtPTotal.getText()), fila, 5);
		    		
		    	}
		    	
		    	}  	
		    }
	
				
		}
			
	  /**************************************************************************************************/
			if(e.getSource()==tblLista&(tblLista.getSelectedColumn()==18)){
				
				cambiaPor=1;
				int fila = tblLista.getSelectedRow();
				System.out.println("TOTAL: "+ modelo2.getRowCount());
				System.out.println("ESTE ES LA FILA QUE ESTA AGARRANDO:"+fila);
			    String porce="";
				BeanCotizacionVarios objCotVarios = objServletCotVarios.obtener(fila);
				
				cantidadpasar=Integer.parseInt(""+objCotVarios.getCancot());
				costepasar=Double.parseDouble(""+objCotVarios.getCoste());
				System.out.println("EL COSTE REAL ANTES:"+costepasar);
				
				poner="3";
				objescCal= new EscogerCalcular();
				objescCal.txtPTotal.setText(""+modelo2.getValueAt(fila, 6));
				objescCal.txtTotal.setText(""+modelo2.getValueAt(fila, 8));
				objescCal.txtCostoTotal.setText(""+modelo2.getValueAt(fila, 10));
				objescCal.txtTotalCosto.setText(""+modelo2.getValueAt(fila, 11));
				objescCal.txtDiferencia.setText(""+modelo2.getValueAt(fila, 12));
				objescCal.txtFactor.setText(""+modelo2.getValueAt(fila, 18));
				
				String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
		         int showOptionDialog = JOptionPane.showOptionDialog(
		     		   this,                             			
		     		  objescCal,                                    
		     		   "Calcular Producto", 		
		     		    0,          						        
		     		   -1,            								
		     		   null,                                       
		     		  botones,
		     		   "Cerrar"
		     		                                  	
		     	);
		         
		        if(showOptionDialog==1||showOptionDialog==-1){//CANCELAR Y X
			         System.out.println("NO COGIO NADA");
			    }else{//ACEPTAR s
			        
							if(objescCal.chkEscoger.isSelected()){
								
								System.out.println("Encendido");	
								objCotVarios.setPorgacot(""+Double.parseDouble(objescCal.txtFactor.getText()));
						        modelo2.setValueAt(Double.parseDouble(objescCal.txtPTotal.getText()), fila, 6);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtTotal.getText()), fila, 8);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtCostoTotal.getText()), fila, 10);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtTotalCosto.getText()), fila, 11);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtDiferencia.getText()), fila, 12);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtFactor.getText()), fila, 18);
								double porcentaje=Double.parseDouble(objescCal.txtPorc.getText());
								
								calcularParte(fila);
								calcularTotales();
								calcular();
								
								for(int i=0;i<modelo2.getRowCount();i++){
									
									objCotVarios = objServletCotVarios.obtener(i);								
									cantidadpasar=Integer.parseInt(""+objCotVarios.getCancot());
									costepasar=Double.parseDouble(""+objCotVarios.getCoste());
									
									objescCal= new EscogerCalcular();
									objescCal.txtPTotal.setText(""+modelo2.getValueAt(i, 6));
									objescCal.txtTotal.setText(""+modelo2.getValueAt(i, 8));
									objescCal.txtCostoTotal.setText(""+modelo2.getValueAt(i, 10));
									objescCal.txtTotalCosto.setText(""+modelo2.getValueAt(i, 11));
									objescCal.txtDiferencia.setText(""+modelo2.getValueAt(i, 12));
									objescCal.txtFactor.setText(""+modelo2.getValueAt(i, 18));
									objescCal.calcular2(porcentaje);
									
									objCotVarios.setPorgacot(""+Double.parseDouble(objescCal.txtFactor.getText()));
							        modelo2.setValueAt(Double.parseDouble(objescCal.txtPTotal.getText()), i, 6);
									modelo2.setValueAt(Double.parseDouble(objescCal.txtTotal.getText()), i, 8);
									modelo2.setValueAt(Double.parseDouble(objescCal.txtCostoTotal.getText()), i, 10);
									modelo2.setValueAt(Double.parseDouble(objescCal.txtTotalCosto.getText()), i, 11);
									modelo2.setValueAt(Double.parseDouble(objescCal.txtDiferencia.getText()), i, 12);
									modelo2.setValueAt(Double.parseDouble(objescCal.txtFactor.getText()), i, 18);
									calcularParte(i);
									
									
								}
								
								calcularTotales();
								calcular();	
								
							}else{
								
								System.out.println("Apagado");								
								porce=""+objCotVarios.getPorgacot();
							    System.out.println("PORCENTAJE: "+porce);
							   
								objCotVarios.setPorgacot(""+Double.parseDouble(objescCal.txtFactor.getText()));
						        modelo2.setValueAt(Double.parseDouble(objescCal.txtPTotal.getText()), fila, 6);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtTotal.getText()), fila, 8);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtCostoTotal.getText()), fila, 10);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtTotalCosto.getText()), fila, 11);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtDiferencia.getText()), fila, 12);
								modelo2.setValueAt(Double.parseDouble(objescCal.txtFactor.getText()), fila, 18);
								calcularParte(fila);
								calcularTotales();
								calcular();	
								
							}
										
			    }
		
		        poner=null;
		
			}
			/* Cuando quieren cambiar a un Proveedor! */
			if(e.getSource()==tblLista&(tblLista.getSelectedColumn()==19)){
				
				int fila = tblLista.getSelectedRow();
				System.out.println("ENTRO ALA FILA:"+fila);
				int columna=tblLista.getSelectedColumn();
				nombre=(String) modelo2.getValueAt(fila, 3);
				marca=(String) modelo2.getValueAt(fila, 4);//PERO DEBERIA ESTAR EN 4,PORK HAY ESTA LA MARCA
				Double precioVenta=Double.parseDouble(modelo2.getValueAt(fila, 6).toString());
				objBuscarProd=new BuscarProd();
				objBuscarProd.txtAlternativo.setText(nombre);
				objBuscarProd.txtMarca2.setText(marca);
				System.out.println("SE TIENE QUE MOSTAR:"+nombre+"-"+marca);
			
					String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
			         int showOptionDialog = JOptionPane.showOptionDialog(
			     		   this,                             			
			     		  objBuscarProd,                                    
			     		   "Buscar Producto", 		
			     		    0,          						        
			     		   -1,            								
			     		   null,                                       
			     		  botones,
			     		   "Cerrar"
			     		                                  	
			     	);
			         if(showOptionDialog==1||showOptionDialog==-1){//CANCELAR Y X
			         System.out.println("NO COGIO NADA");
			         }else{//ACEPTAR 	 
			         COD_PROD=objBuscarProd.COD_PROD;
			         NOM_PROD=objBuscarProd.NOM_PROD;
			         COSTE=objBuscarProd.COSTE;
			         COD_MAR=objBuscarProd.COD_MAR;
			         MARCA=objBuscarProd.MARCA;
			         CUMED=objBuscarProd.CUMED;
			         UMED=objBuscarProd.UMED;
			         FECHA=objBuscarProd.FECHA;
			         COD_PROVEE=objBuscarProd.COD_PROVEE;
			         PROVEEDOR=objBuscarProd.PROVEEDOR;
			         COD_PROD1=objBuscarProd.COD_PROD1;
			         NOM_PROD1=objBuscarProd.NOM_PROD1;
			         PESO_PROD=objBuscarProd.PESO_PRODUC;
			         TIEMPOENTREGA=""+modelo2.getValueAt(fila, 20);
			         MODPROD=objBuscarProd.MODPROD;
			         System.out.println("ESTO ES LO QUE VIENE DESPUES DE BUSCAR "
			        		 +COD_PROD+","+NOM_PROD+","+COSTE+","+MARCA+","+UMED+","+FECHA+","+COD_PROVEE
			        		 +","+PROVEEDOR);
			         System.out.println("el tamaño actual del arreglo es:"+objServletCotVarios.tamaño());
			         System.out.println("el escogido es:"+objServletCotVarios.obtener(fila).getNomprod());
			         BeanCotizacionVarios objCotVarios= objServletCotVarios.obtener(fila);
			         objCotVarios.setCodprod(COD_PROD);
			         objCotVarios.setCoste(COSTE);
			         objCotVarios.setCodmar(COD_MAR);
			         objCotVarios.setNommar(MARCA);
			         objCotVarios.setCodumed(CUMED);
			         objCotVarios.setUmedprod(UMED);
			         objCotVarios.setFecdet(FECHA);
			         objCotVarios.setCodprove(COD_PROVEE);
			         objCotVarios.setNomprove(PROVEEDOR);
			         //objCotVarios.setCodprodalt(COD_PRODALT);
			         objCotVarios.setNomprod(NOM_PROD);
			         objCotVarios.setPesoprod(PESO_PROD);
			         objCotVarios.setTiempoentrega(TIEMPOENTREGA);
			         objCotVarios.setModprod(MODPROD);
			         //objCotVarios.setCodcot("0");
			         //0->numero
			         //1->und
			         Double porc=precioVenta/formato(Double.parseDouble(COSTE));
			         modelo2.setValueAt(UMED, fila, 2);
			         modelo2.setValueAt(NOM_PROD, fila, 3);
			         modelo2.setValueAt(MARCA, fila, 4);
			         modelo2.setValueAt(FECHA, fila, 17);//Fecha
					 modelo2.setValueAt(PROVEEDOR, fila, 19);//Proveedor
					 modelo2.setValueAt(PESO_PROD, fila, 21);//Peso
					 modelo2.setValueAt(TIEMPOENTREGA, fila, 20);//Tiempo
					 modelo2.setValueAt(MODPROD, fila, 5);//MODELO
					 System.out.println("SALEEEEEE PORCCC: "+porc);
			         calcularParte(fila,porc);//PARA QUE SE CALCULE Y SE MUESTRE EN LA TABLA
			         calcularTotales();
			         //LA PARTE DESDE LA MARCA 4
			         calcular();//PARA QUE CALCULE EL TOTAL ABAJO
				
				 }
		
			}
			/****************************************************************************************/
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==22){
				
				int fila = tblLista.getSelectedRow();
				objCambPeso.txtPeso.setText(""+modelo2.getValueAt(fila, 22));
				String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
		         int showOptionDialog = JOptionPane.showOptionDialog(
		     		   this,                             			
		     		  objCambPeso,                                    
		     		   "Cambiar Peso", 		
		     		    0,          						        
		     		   -1,            	
		     		   null,                                       
		     		  botones,
		     		   "Cerrar"
		     		                                  	
		     	);
		         if(showOptionDialog==1||showOptionDialog==-1){
		        	 //x--->no cogio nada
		         }else{
		         String peso=objCambPeso.txtPeso.getText();
		         System.out.println("K PESO LE PASA?:"+peso);
		         BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(fila);
		         System.out.println("ES LA FILA :"+fila);
		         modelo2.setValueAt(formato2(Double.parseDouble(peso)), fila, 22);
		         objCotVarios.setPesoCarrete(peso);
		         calcularParte(fila);
		         //calcularTotales();
		         calcular(); 
		         
		         }
		         
				
			}
			/************************************************************************************************/
			
			
			if(e.getSource()==tblLista){
				
				//cant=tblLista.getSelectedRowCount();
				//fila= tblLista.getSelectedRow();
				//String ide=""+modelo2.getValueAt(fila, 0);
				//id=Integer.parseInt(ide);
				//System.out.println("id:"+id);
				//System.out.println("ESTE ES EL N:"+fila);
				//System.out.println(""+modelo2.getValueAt(fila, 23));
		
			}
			
		}
		public void mouseReleased(MouseEvent e) {
			
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
						
		}

}
