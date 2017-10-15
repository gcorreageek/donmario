package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.Fecha;
import miLib.GUI;
import miLib.Metodos;
import miLib.PasarExcel;
import pOp.BuscarCliente;
import pOp.BuscarProd;
import pOp.BuscarProductoCotUnItem;
import pOp.CambiarCant;
import pOp.CambiarTiempoEntrega;
import pOp.EscogerCalcular;
import pOp.NuevoCliente;
import servlet.ServletCotiBorrar;
import servlet.ServletCotizacion;
import servlet.ServletCotizacionUnItem;
import beans.BeanCoti_borrar;
import beans.BeanCotizacionUnItem;
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

public class TranCotizacionDato extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JLabel lblCliente;
	private JTextField txtProducto;
	private JLabel lblProducto;
	private JLabel lblIgv;
	private JTextField txtIgvDif;
	private JTextField txtIgvCompra;
	private JTextField txtIgv;
	private JButton btnGuardar;
	private JTextField txtTotalDif;
	private JTextField txtPrecioVentaDif;
	private JTextField txtTotalIgv;
	private JTextField txtPrecioVentaCompra;
	private JTextField txtTotal;
	private JTextField txtPrecioVenta;
	private JLabel lblTotal;
	private JLabel lblSubtotal;
	private JButton btnBorrar;
	private JButton btnBuscarProducto;
	private JTextField txtMarca;
	private JLabel lblMarca;
	private JTextField txtProveedor;
	private JLabel lblProveedor;
	private JPanel pnlProducto;
	private JButton btnBuscarCliente;
	private JTextField txtContacto;
	private JTextField txtRuc;
	private JLabel lblContacto;
	private JLabel lblRuc;
	private JTextField txtCliente;
	private JPanel pnlPrincipal;
	private JPanel pnlAbajo;
	int id=0;
	Globales objGlobal;
	GUI objGUI;
	Metodos objMetodo;
	ServletCotizacion objServletCotizacion = new 	ServletCotizacion();
	Fecha objFecha;
	String cadenar="D:/ProyectoCEL(1.0.0.0)/Cotizaciones/";
	BuscarCliente objBuscarCliente;
	NuevoCliente objNuevoCliente;
	BuscarProd objBuscarProd;
	EscogerCalcular objescCal;
	String OBS_DET="";
	public static int cantidadpasar;
	public static double costepasar;
	public static String valor="T+";
	MenuPrincipal objMenuP;
	ServletCotizacionUnItem objCot =new ServletCotizacionUnItem();
	CambiarCant objCambiarCant;
	CambiarTiempoEntrega objCamTiemEntrega;
	int est=1;
   
	//VARIABLES DE PRODALTERNATIVO
	 String NOMBRE_PROD,NOMBRE_PROVEE,COD_PROVE,
		COD_PROD,COD_MAR,MARCA,COD_UMED,UMED,CODIGO_PROVEPRODMARUMED,COS_DET,FECHA,
		PESO_PROD,PORGACOT,COSTOVENTA,COSTO,COD_PRODALT;
	 int conta;
	 public static String poner;
	 ServletCotiBorrar objCotizacionBorrar= new ServletCotiBorrar();
	 String ref="";
	 
	// String  COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT;
	 //VARIABLES DE CLIENTE
	 String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli,
	 mailbcli,dircli;
	 private JButton btnNuevoCliente;
	 private JRadioButton rdbCye;
	 private JRadioButton rdbCel;
	 Object[] arregloCadenas;
	 Object[][] arregloObjetos;
	 PasarExcel objPasarExcel;
	 public static int estado;
	 
	 private JTextField txtReferencia;
	 private JLabel lblReferencia;
	 private JTextField txtEmail2;
	 private JTextField txtEmail1;
	 private JLabel lblMail2;
	 private JLabel lblMail1;
	 public JTable tblLista;
	 private JScrollPane scrLista;
	 private JPanel pnlCentro;
	 private JPanel pnlCliente;

	 String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Unit$","P.Total$","P.Costo$","C.Total$","Dif.$","Fecha","%","Proveedor","Peso Producto","T.Entrega"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public TranCotizacionDato() {
		super("Cotizacion Ingreso", true, true, true, true);
		try {				
			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(1176, 578));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setBounds(0, 0, 1176, 578);
			this.setIcon(true);

			pnlCentro = new JPanel();
			getContentPane().add(pnlCentro, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlCentro.setLayout(pnlMedioLayout);
			pnlCentro.setPreferredSize(new java.awt.Dimension(1166, 280));
			

			scrLista = new JScrollPane();
			pnlCentro.add(scrLista);
			scrLista.setBounds(0, 0, 1166, 311);

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setDefaultRenderer(Object.class, new miLib.MiRender());
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.NORTH);
			pnlPrincipal.setBounds(12, 13, 867, 336);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setEnabled(false);
			pnlPrincipal.setOpaque(false);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(1166, 254));

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);pnlAbajo.setLayout(null);
			pnlAbajo.setEnabled(false);
			pnlAbajo.setOpaque(false);
			pnlAbajo.setBounds(56, 220, 797, 413);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(1166, 89));


			lblSubtotal = new JLabel();
			pnlAbajo.add(lblSubtotal);
			lblSubtotal.setText("Precio Venta:");
			lblSubtotal.setBounds(361, 9, 77, 14);

			lblTotal = new JLabel();
			pnlAbajo.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(410, 58, 42, 14);

			txtPrecioVenta = new JTextField();
			pnlAbajo.add(txtPrecioVenta);
			txtPrecioVenta.setBounds(445, 9, 98, 21);

			txtTotal = new JTextField();
			pnlAbajo.add(txtTotal);
			txtTotal.setBounds(445, 58, 98, 21);

			txtTotalIgv = new JTextField();
			pnlAbajo.add(txtTotalIgv);
			txtTotalIgv.setBounds(550, 58, 91, 21);

			txtPrecioVentaDif = new JTextField();
			pnlAbajo.add(txtPrecioVentaDif);
			txtPrecioVentaDif.setBounds(650, 9, 98, 21);

			txtTotalDif = new JTextField();
			pnlAbajo.add(txtTotalDif);
			txtTotalDif.setBounds(650, 58, 98, 21);

			txtIgv = new JTextField();
			pnlAbajo.add(txtIgv);
			txtIgv.setBounds(445, 33, 98, 21);

			txtIgvCompra = new JTextField();
			pnlAbajo.add(txtIgvCompra);
			txtIgvCompra.setBounds(550, 33, 91, 21);

			txtIgvDif = new JTextField();
			pnlAbajo.add(txtIgvDif);
			txtIgvDif.setBounds(650, 34, 98, 21);

			lblIgv = new JLabel();
			pnlAbajo.add(lblIgv);
			lblIgv.setText("Igv:");
			lblIgv.setBounds(417, 32, 28, 14);

			txtPrecioVentaCompra = new JTextField();
			pnlAbajo.add(txtPrecioVentaCompra);
			txtPrecioVentaCompra.setBounds(550, 9, 91, 21);

			btnGuardar = new JButton();
			pnlAbajo.add(btnGuardar);
			btnGuardar.setText("Guardar");
			btnGuardar.setBounds(30, 28, 98, 21);

			btnGuardar.addActionListener(this);

			pnlProducto = new JPanel();
			pnlPrincipal.add(pnlProducto);
			pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
			pnlProducto.setBounds(6, 137, 806, 111);
			pnlProducto.setLayout(null);
			pnlProducto.setOpaque(false);

			pnlCliente = new JPanel();
			pnlPrincipal.add(pnlCliente);
			pnlCliente.setLayout(null);
			pnlCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
			pnlCliente.setBounds(6, 0, 806, 133);

			lblCliente = new JLabel();
			pnlCliente.add(lblCliente);
			lblCliente.setText("Cliente:");
			lblCliente.setBounds(17, 21, 52, 14);

			lblRuc = new JLabel();
			pnlCliente.add(lblRuc);
			lblRuc.setText("Ruc:");
			lblRuc.setBounds(32, 47, 37, 14);

			txtCliente = new JTextField();
			pnlCliente.add(txtCliente);
			txtCliente.setBounds(73, 18, 599, 21);

			txtRuc = new JTextField();
			pnlCliente.add(txtRuc);
			txtRuc.setBounds(73, 46, 167, 21);

			lblContacto = new JLabel();
			pnlCliente.add(lblContacto);
			lblContacto.setText("Contacto:");
			lblContacto.setBounds(247, 49, 55, 14);

			txtContacto = new JTextField();
			pnlCliente.add(txtContacto);
			txtContacto.setBounds(308, 46, 364, 21);

			btnBuscarCliente = new JButton();
			pnlCliente.add(btnBuscarCliente);
			btnBuscarCliente.setText("Buscar Cliente");
			btnBuscarCliente.setBounds(678, 44, 118, 24);
			btnBuscarCliente.setEnabled(false);

			lblMail1 = new JLabel();
			pnlCliente.add(lblMail1);
			lblMail1.setText("Mail1:");
			lblMail1.setBounds(28, 73, 35, 16);

			lblMail2 = new JLabel();
			pnlCliente.add(lblMail2);
			lblMail2.setText("Mail2:");
			lblMail2.setBounds(367, 77, 39, 16);

			txtEmail1 = new JTextField();
			pnlCliente.add(txtEmail1);
			txtEmail1.setBounds(73, 75, 280, 20);

			txtEmail2 = new JTextField();
			pnlCliente.add(txtEmail2);
			txtEmail2.setBounds(411, 75, 261, 20);

			lblReferencia = new JLabel();
			pnlCliente.add(lblReferencia);
			lblReferencia.setText("Referencia:");
			lblReferencia.setBounds(5, 105, 68, 16);

			txtReferencia = new JTextField();
			pnlCliente.add(txtReferencia);
			txtReferencia.setBounds(73, 103, 280, 20);

			rdbCel = new JRadioButton();
			pnlCliente.add(rdbCel);
			rdbCel.setText("CEL");
			rdbCel.setBounds(678, 16, 47, 24);
			rdbCel.addActionListener(this);

			rdbCye = new JRadioButton();
			pnlCliente.add(rdbCye);
			rdbCye.setText("CYE");
			rdbCye.setBounds(733, 16, 47, 24);

			btnNuevoCliente = new JButton();
			pnlCliente.add(btnNuevoCliente);
			btnNuevoCliente.setText("Nuevo Cliente");
			btnNuevoCliente.setBounds(678, 72, 118, 26);
			btnNuevoCliente.setSize(118, 24);
			btnNuevoCliente.addActionListener(this);

			rdbCye.addActionListener(this);

			btnBuscarCliente.addActionListener(this);

			lblProducto = new JLabel();
			pnlProducto.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(9, 24, 68, 14);

			txtProducto = new JTextField();
			pnlProducto.add(txtProducto);
			txtProducto.setBounds(82, 21, 711, 21);
			txtProducto.setEditable(false);

			lblProveedor = new JLabel();
			pnlProducto.add(lblProveedor);
			lblProveedor.setText("Proveedor:");
			lblProveedor.setBounds(9, 49, 66, 14);

			txtProveedor = new JTextField();
			pnlProducto.add(txtProveedor);
			txtProveedor.setBounds(82, 48, 472, 21);
			txtProveedor.setEditable(false);

			lblMarca = new JLabel();
			pnlProducto.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(564, 51, 47, 14);

			txtMarca = new JTextField();
			pnlProducto.add(txtMarca);
			txtMarca.setBounds(620, 48, 173, 21);
			txtMarca.setEditable(false);

			btnBuscarProducto = new JButton();
			pnlProducto.add(btnBuscarProducto);
			btnBuscarProducto.setText("Buscar Producto");
			btnBuscarProducto.setBounds(564, 75, 133, 24);

			btnBorrar = new JButton();
			pnlProducto.add(btnBorrar);
			btnBorrar.setText("Borrar");
			btnBorrar.setBounds(711, 75, 83, 24);
			btnBorrar.addActionListener(this);
			btnBuscarProducto.addActionListener(this);
			
			
			TableColumn Cant = tblLista.getColumn ("Cant"),Und = tblLista.getColumn ("Und"),Descripcion = tblLista.getColumn ("Descripcion")
			,Marca = tblLista.getColumn ("Marca"),PTotal= tblLista.getColumn ("P.Unit$"),TotalD = tblLista.getColumn ("P.Total$"),Costo  = tblLista.getColumn ("P.Costo$")
			,Total = tblLista.getColumn ("C.Total$"),Dif = tblLista.getColumn ("Dif.$"),Fecha = tblLista.getColumn ("Fecha"),por = tblLista.getColumn ("%")
			,Proveedor = tblLista.getColumn ("Proveedor"),iD = tblLista.getColumn ("Id"),Peso=tblLista.getColumn("Peso Producto");
			//Id
			iD.setPreferredWidth(10);
			Cant.setPreferredWidth(13);
			Und.setPreferredWidth(13);
			Descripcion.setPreferredWidth(370);
			Marca.setPreferredWidth(40);
			PTotal.setPreferredWidth(30);
			TotalD.setPreferredWidth(30);
			Costo.setPreferredWidth(30);
			Total.setPreferredWidth(30);
			Dif.setPreferredWidth(30);
			Fecha.setPreferredWidth(50);
			por.setPreferredWidth(10);
			Proveedor.setPreferredWidth(50);
			Peso.setPreferredWidth(50);

			//objBuscarCliente =new BuscarCliente();
			//objBuscarProd = new BuscarProd();
			
			
			
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


    /*****************************************************************************************/
	 public double pasarPorceGana(int cod_prod){
		 
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT RUB.POR_RUBRO FROM tb_producto PROD INNER JOIN tb_rubro RUB " +
					" ON PROD.COD_RUBRO=RUB.COD_RUBRO " +
					" WHERE PROD.COD_PROD='"+cod_prod+"';";
			double porce=0;
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
				    porce=rs.getDouble(1);
					return porce;		
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
		
			return porce;
			
		}
	 /************************************************************************/
	 public  Double formato(double numero) {
			// declara objeto para formato con decimales
			String miformato;

			Integer decimales=3;
			// establece el numero de decimales
			miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
			
			// devuelve numero con formato establecido
			return Double.parseDouble(miformato);
		}
	 
	/***********************************************************************/
	public void calcularParte1(int i){
		
		double costoreal;
		double porc=pasarPorceGana(Integer.parseInt(COD_PROD));
		//double porc=pasarPorceGana(Integer.parseInt("3"));
		String cantiViene=""+modelo2.getValueAt(i, 1);
		int cantViene=Integer.parseInt(cantiViene.trim());	
		costoreal=Double.parseDouble(COSTO);	
		double costoRealXCant=costoreal*cantViene;
		double precioConPorce=costoreal/porc;
		double precioConPorceXCant=precioConPorce*cantViene;
		double dife=precioConPorceXCant-costoRealXCant;
		
		 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
		 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
		 modelo2.setValueAt(costoreal, i, 7);//Costo $
		 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
		 modelo2.setValueAt(dife, i, 9);//Dif. $
		 modelo2.setValueAt(FECHA, i, 10);//Fecha
		 modelo2.setValueAt(porc, i, 11);//%
		 modelo2.setValueAt(NOMBRE_PROVEE, i, 12);//Proveedor
		 
		 
	}
	/*****************************************************/
	public void calcular(){
		//String titulo2[]={"Cant","Und","Descripcion","Marca","P.Total $",
				//"Total $","Costo $","Total$","Dif. $","Fecha","%","Proveedor"};		
				double precioTsuma = 0,costoTsuma = 0,difTsuma = 0,
				precioTsumaSigv = 0,costoTsumaSigv = 0,difTsumaSigv = 0,
				precioTsumaCigv = 0,costoTsumaCigv = 0,difTsumaCigv = 0;
				double pesoTotal=0;
				for (int i = 0; i < modelo2.getRowCount(); i++) {
					if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
					||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")
					||modelo2.getValueAt(i, 11).equals("UND")){
						
					}else{
					precioTsuma=precioTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 6));
					costoTsuma=costoTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 8));
					difTsuma=difTsuma+Double.parseDouble(""+modelo2.getValueAt(i, 9));
					pesoTotal+=Double.parseDouble(""+modelo2.getValueAt(i, 13));
					}
					
				}
				precioTsumaSigv=precioTsuma*0.18;
				costoTsumaSigv=costoTsuma*0.18;
				difTsumaSigv=difTsuma*0.18;
				
				precioTsumaCigv=precioTsumaSigv+precioTsuma;
				costoTsumaCigv=costoTsumaSigv+costoTsuma;
				difTsumaCigv=difTsumaSigv+difTsuma;
				
				txtPrecioVenta.setText(""+formato(precioTsuma));
				txtPrecioVentaCompra.setText(""+formato(costoTsuma));
				txtPrecioVentaDif.setText(""+formato(difTsuma));
				
				txtIgv.setText(""+formato(precioTsumaSigv));
				txtIgvCompra.setText(""+formato(costoTsumaSigv));
				txtIgvDif.setText(""+formato(difTsumaSigv));
				
				txtTotal.setText(""+formato(precioTsumaCigv));
				txtTotalIgv.setText(""+formato(costoTsumaCigv));
				txtTotalDif.setText(""+formato(difTsumaCigv));
				
				
				
			}
		/***********************************************/
	 public int retornaUltimoCodCotizacion(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT max(cod_cot) FROM tb_cotizacion";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=1;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					cod=cod+1;
					return cod;
					}
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 1;
		 } 
	/******************************************/
	/********TIPO DE CAMBIO COMPRA************************/
		public double tipoCambioCompra(){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM CAMBIO); ";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					double cambio=rs.getDouble(3);
					return cambio;		
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
			return 0;
		}
	/*****************************************************************************/
	/********TIPO DE CAMBIO VENTA************************/
		public double tipoCambioVenta(){
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					//System.out.println(rs.getString(2));
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
		/***********************************************/
		/*****************************************************/
		void pasarExcel(int cod){
			int item=-1;
			if(objCot.tamaño()!=0){
				for (int i = 0; i < objCot.tamaño(); i++) {
					

				BeanCotizacionUnItem objExcel=objCot.obtener(i);

				if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
				||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){		
				}else{
					item=item+1;
					arregloCadenas[0]=nomcli.toString().toUpperCase();
					arregloCadenas[1]=conacli.toString().toUpperCase();
					arregloCadenas[2]=dircli.toString().toUpperCase();
					String rpm=rpmacli,nex=nexacli,rpmnextel="";
					if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
						rpmnextel=" NEX:"+nex;
					}else{
						rpmnextel=" RPM:"+rpm;
					}
					arregloCadenas[3]="TEL:"+tel1acli+rpmnextel+" CEL:"+celacli+" E-MAIL:"+mailacli;
					arregloCadenas[4]=objGlobal.COD_VEN;
					arregloCadenas[5]=tipcli.toString().toUpperCase();
					arregloCadenas[6]=codcli;
					arregloCadenas[7]="COTIZACION Nº"+cod;
					arregloCadenas[8]=objFecha.fechaActual();
					arregloCadenas[9]=Double.parseDouble(""+tipoCambioVenta());
					arregloCadenas[10]=ref.toString().toUpperCase();
				    for (int j = 0; j < 10; j++) {
						if(j==0){
						arregloObjetos[item][j]=Integer.parseInt(""+objExcel.getCancot());	
						}else if(j==1){
						arregloObjetos[item][j]=objExcel.getUmedprod().toString();	
						}else if(j==2){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 3).toString().toUpperCase();	
						}else if(j==3){
						arregloObjetos[item][j]=objExcel.getNommar().toString().toUpperCase();		
						}else if(j==4){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 5));		
						}else if(j==5){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 7));			
						}else if(j==6){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 10).toString();	
						}else if(j==7){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 12).toString();	
						}else if(j==8){
						arregloObjetos[item][j]=""+objExcel.getCodprove();	
						}else{
						arregloObjetos[item][j]=modelo2.getValueAt(i, 13).toString();		
						}
						
					}
				}
			}
		  }
			
		}
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
		public void llenar_tabla(
				int tf,String TNOMBRE_PROD,String TNOMBRE_PROVEE,String TCOD_PROVE,String TCOD_PROD,
				String TCOD_MAR,String TMARCA,String TCOD_UMED,String TUMED,String TCODIGO_PROVEPRODMARUMED,
				String TCOS_DET,String TFECHA,String TPESOTOTAL,
				String TPORGACOT,String TCOSTOVENTA,String TCOSTO,String TCOD_PRODALT)
		{		
			System.out.println(tf);
				if(conta>=0){				
					 if(est==0){
						 objGUI.mostrarAviso("Primero debe Colocar la Cantidad Del Producto");
					 }else{ 						 
							double pesototal=0;
							String peso="";							
							CODIGO_PROVEPRODMARUMED=TCODIGO_PROVEPRODMARUMED;
					        COD_PROD=TCOD_PROD;
					        NOMBRE_PROD=TNOMBRE_PROD;
					        COD_PROVE=TCOD_PROVE;
					        NOMBRE_PROVEE=TNOMBRE_PROVEE;
					        COD_MAR=TCOD_MAR;
					        MARCA=TMARCA;
					        COD_UMED=TCOD_UMED;
					        UMED=TUMED;
					        COS_DET=TCOS_DET;
					        FECHA=TFECHA;
					        PESO_PROD=TPESOTOTAL;
					        PORGACOT=TPORGACOT;
					        COSTOVENTA=TCOSTOVENTA;
					        COSTO=TCOSTO;
					        conta++;//=conta+1;
					        COD_PRODALT=TCOD_PRODALT;
					        txtProducto.setText(NOMBRE_PROD);
					        txtProveedor.setText(NOMBRE_PROVEE);
					        txtMarca.setText(MARCA);
					        System.out.println("Recibe codigo:"+COD_PROD);
					        if(PESO_PROD.equals("")){
					        	 pesototal=0;
					         }else{
					        	 pesototal=Double.parseDouble(PESO_PROD);
					         }
					         peso=""+formato(pesototal);			
					         System.out.println("ssssssssssssssssssssssssss"+COS_DET+COSTO);
					        /*BeanCotizacionUnItem objCotiUnItem=new BeanCotizacionUnItem(""+(retornaUltimoCodCotizacion()),
					        		"0",""+conta, 
					        		 codcli,"0", UMED, NOMBRE_PROD, COD_PROD,
					        		 MARCA,""+formato(Double.parseDouble(""+COS_DET)) ,""+
					        		 formato(Double.parseDouble(""+COS_DET)),""+formato(Double.parseDouble(""+COSTO)),
					        		 ""+formato(Double.parseDouble(""+COS_DET)),""+
					        		 formato(Double.parseDouble(""+COS_DET)),FECHA,COD_MAR, "", 
					        		 "1",NOMBRE_PROVEE, COD_PROVE,COD_MAR,COD_UMED,"0",peso,"1 Dia");*/
					         BeanCotizacionUnItem objCotiUnItem=new BeanCotizacionUnItem(""+(retornaUltimoCodCotizacion()),
						        		"0",""+conta, 
						        		 codcli,"0", UMED, NOMBRE_PROD, COD_PROD,
						        		 MARCA,""+formato(Double.parseDouble(""+"5.55")) ,""+formato(Double.parseDouble(""+"5.55")),""+formato(Double.parseDouble(""+"5.55")),
						        		 ""+formato(Double.parseDouble(""+"5.55")),""+formato(Double.parseDouble(""+"5.55")),FECHA,COD_MAR, "", 
						        		 "1",NOMBRE_PROVEE, COD_PROVE,COD_MAR,COD_UMED,"0",peso,"1 Dia");
					        		objCot.adicionar(objCotiUnItem);		        
					        Object[] array={objCotiUnItem.getNumitem(),
									objCotiUnItem.getCancot(),objCotiUnItem.getUmedprod(),
									objCotiUnItem.getNomprodalt(),objCotiUnItem.getNommar() ,
									COSTOVENTA,"0",
									COSTO,"0",
									"0" ,objCotiUnItem.getFecdet() , 
									PORGACOT,objCotiUnItem.getNomprove(),objCotiUnItem.getPesoprod(),objCotiUnItem.getTiempoentrega()};
							        modelo2.addRow(array);							     
							BeanCoti_borrar objcotborrar=new BeanCoti_borrar((""+modelo2.getValueAt(conta-1, 1)),(""+modelo2.getValueAt(conta-1, 2)),
											(""+modelo2.getValueAt(conta-1, 3)),(""+modelo2.getValueAt(conta-1, 4)),(""+modelo2.getValueAt(conta-1, 5)),
											(""+modelo2.getValueAt(conta-1, 6)),(""+modelo2.getValueAt(conta-1, 7)),(""+modelo2.getValueAt(conta-1, 8)),
											(""+modelo2.getValueAt(conta-1, 9)),(""+modelo2.getValueAt(conta-1, 10)),(""+modelo2.getValueAt(conta-1, 11)),
											(""+modelo2.getValueAt(conta-1, 12)),(""+modelo2.getValueAt(conta-1, 13)),(""+modelo2.getValueAt(conta-1, 14)));									
							objCotizacionBorrar.adicionar(objcotborrar);
							calcularParte1(conta-1);
						    calcular();
						    est=0;
						 }
					 }
				}	
     /***********************************************************************************************/
	
	public int guardar(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//NOTA :AL GUARDAR SE TIENE QUE DAR CUENTA QUE NO GUARDE CUANDO HAY ERROR
		int tam= objCot.tamaño();
		int cod_cot=retornaUltimoCodCotizacion();
		ref=txtReferencia.getText();
		int op = 0;
		int numi=0;
		String guardarCotizacion = null;
		
		if(tam>0){
			for (int i = 0; i < objCot.tamaño(); i++) {
			
			BeanCotizacionUnItem objCoti=objCot.obtener(i);
			//System.out.println("Final cod:"+objCoti.getCodprod());
			
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){
				
			}else{
				numi=numi+1;
				
				guardarCotizacion="INSERT INTO tb_cotizacion(cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, " +
					" cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot,tiempo_entrega,est_emp,pesoCarr,est_envio) VALUES('"+cod_cot+"','"+numi+"','"+objCoti.getCodprove()
			+"','"+objCoti.getCodprod()+"','"+objCoti.getCodmar()+"','"+objCoti.getCodumed()+"','"+codcli+"','"+codigoFecha()+
			"','"+ref.toString().toUpperCase()+"','"+objCoti.getCancot()+"','"+modelo2.getValueAt(i, 11)+"',curdate(),'"
			+objGlobal.COD_VEN+"','"+0+"','"+1+"','"+0+"','"+modelo2.getValueAt(i, 14)+"','"+estado+"','0','0');";
				System.out.println(guardarCotizacion);
				try {
					 op= objAccesoBD.ejecutarActualizacion(guardarCotizacion);
				} catch (Exception e) {
					// TODO: handle exception
					op=0;
					
				}finally{
					if(op==0){ 
						objGUI.mostrarAviso("HUBO UN ERROR11");
						
					}
				}
			}	
				
		  }	
		   if(op==0){
			  objGUI.mostrarAviso("Hubo un Error22");
		   }else{
			 objGUI.mostrarAviso("Se ingreso su Cotizacion");
		   }
		
	   }
		objAccesoBD.cerrarConexion();
		return cod_cot;
		
		
 }
  
	/***********************************************/
	public void cargar(){
		//Obtener fila seleccionada de la tabla
		int fila = tblLista.getSelectedRow();
		
		txtProducto.setText(""+modelo2.getValueAt(fila, 3));
		txtMarca.setText(""+modelo2.getValueAt(fila, 4));
		txtProveedor.setText(""+modelo2.getValueAt(fila, 12));
		
	}
		
	/***********************************************/
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBuscarCliente){
			objBuscarCliente= new BuscarCliente();
			String[] botones = {"Aceptar"};//Esto es el nombre
			 int showOptionDialog = JOptionPane.showOptionDialog(
	    		   this,                             			
	    		   objBuscarCliente,                                    
	    		   "Buscar Cliente", 		
	    		    0,          						        
	    		   -1,            								
	    		   null,                                       
	    		  botones,
	    		  "Cerrar"
	    		                                  	
	    	);
			
	        codcli=objBuscarCliente.codcli;   
	        nomcli=objBuscarCliente.nomcli;
	        tipcli=objBuscarCliente.tipcli;
	        ruccli=objBuscarCliente.ruccli;
	        lugcli=objBuscarCliente.lugcli;
	        conacli=objBuscarCliente.conacli;
	        tel1acli=objBuscarCliente.tel1acli;
	        tel2acli=objBuscarCliente.tel2acli;
	        rpmacli=objBuscarCliente.rpmacli;
	        nexacli=objBuscarCliente.nexacli;
	        celacli=objBuscarCliente.celacli;
	        mailacli=objBuscarCliente.mailacli;
	        mailbcli=objBuscarCliente.mailbcli;
	        dircli=objBuscarCliente.dircli;
	        
	        txtCliente.setText(nomcli);
			txtRuc.setText(ruccli);
			txtContacto.setText(conacli);
			txtEmail1.setText(mailacli);
			txtEmail2.setText(mailbcli);
		}
		if(e.getSource()==btnNuevoCliente){
			
			objNuevoCliente= new NuevoCliente();
			String[] botones = {"Aceptar"};//Esto es el nombre
			 int showOptionDialog = JOptionPane.showOptionDialog(
	    		   this,                             			
	    		   objNuevoCliente,                                    
	    		   "Nuevo Cliente", 		
	    		    0,          						        
	    		   -1,            								
	    		   null,                                       
	    		  botones,
	    		  "Cerrar"
	    		                                  	
	    	);
		}
		
		if(e.getSource()==btnBuscarProducto){
			
			if(conta>=0){
			
				 if(est==0){
					 objGUI.mostrarAviso("Primero debe Colocar la Cantidad Del Producto");
				 }else{
					  
						BuscarProductoCotUnItem objBuscarProdUnItem =
					    new BuscarProductoCotUnItem(objMenuP); 
						
						objBuscarProdUnItem.setVisible(true);
						objBuscarProdUnItem.pack();  
						 
						double pesototal=0;
						String peso="";
						
						CODIGO_PROVEPRODMARUMED=objBuscarProdUnItem.CODIGO_PROVEPRODMARUMED;
				        COD_PROD=objBuscarProdUnItem.COD_PROD;
				        NOMBRE_PROD=objBuscarProdUnItem.NOMBRE_PROD;
				        COD_PROVE=objBuscarProdUnItem.COD_PROVE;
				        NOMBRE_PROVEE=objBuscarProdUnItem.NOMBRE_PROVEE;
				        COD_MAR=objBuscarProdUnItem.COD_MAR;
				        MARCA=objBuscarProdUnItem.MARCA;
				        COD_UMED=objBuscarProdUnItem.COD_UMED;
				        UMED=objBuscarProdUnItem.UMED;
				        COS_DET=objBuscarProdUnItem.COS_DET;
				        FECHA=objBuscarProdUnItem.FECHA;
				        PESO_PROD=objBuscarProdUnItem.PESOTOTAL;
				        PORGACOT=objBuscarProdUnItem.PORGACOT;
				        COSTOVENTA=objBuscarProdUnItem.COSTOVENTA;
				        COSTO=objBuscarProdUnItem.COSTO;
				        conta++;//=conta+1;
				        COD_PRODALT=objBuscarProdUnItem.COD_PRODALT;
				        txtProducto.setText(NOMBRE_PROD);
				        txtProveedor.setText(NOMBRE_PROVEE);
				        txtMarca.setText(MARCA);
				        System.out.println("Recibe codigo:"+COD_PROD);
				       
				        /* codcot,idecot,numitem,codcli,cancot,umedprod,nomprodalt,codprod,
				         * codprodalt,nommar,costeXporc,
				        costeXporcXcant,coste,costeXcant,dife,fecdet,codcam,codven,
				        porgacot,nomprove,codprove,codmar,codumed,codCoste,pesoprod,tiempoentrega;*/
				        //BeanCotizacionUnItem objCotisacionVarios=objCot.obtener(objCot.tamaño()-1) ; 
				        if(PESO_PROD.equals("")){
				        	 pesototal=0;
				         }else{
				        	 pesototal=Double.parseDouble(PESO_PROD);
				         }
				         peso=""+formato(pesototal);
				        
				        BeanCotizacionUnItem objCotiUnItem=new BeanCotizacionUnItem(""+(retornaUltimoCodCotizacion()),
				        		"0",""+conta, 
				        		 codcli,"0", UMED, NOMBRE_PROD, COD_PROD,
				        		 MARCA,""+formato(Double.parseDouble(""+COS_DET)) ,""+formato(Double.parseDouble(""+COS_DET)),""+formato(Double.parseDouble(""+COSTO)),
				        		 ""+formato(Double.parseDouble(""+COS_DET)),""+formato(Double.parseDouble(""+COS_DET)),FECHA,COD_MAR, "", 
				        		 "1",NOMBRE_PROVEE, COD_PROVE,COD_MAR,COD_UMED,"0",peso,"1 Dia");				        		
				        		objCot.adicionar(objCotiUnItem);
				        		/* "", "", 
				        		nomprodalt, codprod, codprodalt, nommar, 
				        		costeXporc, costeXporcXcant, coste, costeXcant,
			                    dife, fecdet, codcam, codven, porgacot, 
			                    nomprove, codprove, codmar, codumed, codCoste,
			                    pesoprod, tiempoentrega);*/
				        //int fila2 = tblLista.				        
				        Object[] array={objCotiUnItem.getNumitem(),
								objCotiUnItem.getCancot(),objCotiUnItem.getUmedprod(),
								objCotiUnItem.getNomprodalt(),objCotiUnItem.getNommar() ,
								COSTOVENTA,"0",
								COSTO,"0",
								"0" ,objCotiUnItem.getFecdet() , 
								PORGACOT,objCotiUnItem.getNomprove(),objCotiUnItem.getPesoprod(),objCotiUnItem.getTiempoentrega()};
						        modelo2.addRow(array);
						        
						     
						BeanCoti_borrar objcotborrar=new BeanCoti_borrar((""+modelo2.getValueAt(conta-1, 1)),(""+modelo2.getValueAt(conta-1, 2)),
										(""+modelo2.getValueAt(conta-1, 3)),(""+modelo2.getValueAt(conta-1, 4)),(""+modelo2.getValueAt(conta-1, 5)),
										(""+modelo2.getValueAt(conta-1, 6)),(""+modelo2.getValueAt(conta-1, 7)),(""+modelo2.getValueAt(conta-1, 8)),
										(""+modelo2.getValueAt(conta-1, 9)),(""+modelo2.getValueAt(conta-1, 10)),(""+modelo2.getValueAt(conta-1, 11)),
										(""+modelo2.getValueAt(conta-1, 12)),(""+modelo2.getValueAt(conta-1, 13)),(""+modelo2.getValueAt(conta-1, 14)));
								
						objCotizacionBorrar.adicionar(objcotborrar);
						calcularParte1(conta-1);
					    calcular();
					    est=0;
					 }
				 }
				        
	}
		
		if(e.getSource()==btnGuardar){
			
			if(txtReferencia.getText().equals("")){
        		objGUI.mostrarAviso("Debe Escribir la Referencia");
        	}
        	else{
        	
        	int cod=guardar();
			int tam=objCot.tamaño();
			
			if(objCot.tamaño()!=0){
				arregloCadenas= new Object[11];
			    arregloObjetos= new Object[tam][10];
			
			pasarExcel(cod);
			
			try {
				objPasarExcel= new PasarExcel();
				objPasarExcel.crearExcel(arregloCadenas,arregloObjetos);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//le das a otro excel tu codigo 
			}
			
			
          }
			
		}
	/*********************************************************************************/
		
		if(e.getSource()==btnBorrar){
			
			try {
				int tam= objCotizacionBorrar.tamaño();
				int fila1 =tblLista.getSelectedRow();

				int contM=0;
				System.out.println("ESTE ES EL N DE FILA PARA BORRAR:"+fila1);
				int n=modelo2.getRowCount();
				for (int fila=0; fila<n; fila++)
				modelo2.removeRow(0);
				if(tam>0){
					conta--;
					objCotizacionBorrar.eliminar(fila1);
					objCot.eliminar(fila1);
					for (int i = 0; i < objCotizacionBorrar.tamaño(); i++) {
						contM=contM+1;
						
						BeanCoti_borrar objcotborrar=objCotizacionBorrar.obtener(i) ;
						
						Object[] array={ Integer.parseInt(""+contM), objcotborrar.getCant(),objcotborrar.getUnd(),
								objcotborrar.getDesc(),objcotborrar.getMarca(),objcotborrar.getPunit(),objcotborrar.getPtotal(),
								objcotborrar.getPcosto(),objcotborrar.getCtotal(),objcotborrar.getDif(),objcotborrar.getFecha(),
								objcotborrar.getPorc(),objcotborrar.getProv(),objcotborrar.getPestotal(),objcotborrar.getTiempo_entrega()};
						modelo2.addRow(array);
					 
					}
					calcular();
				}
				else{
					if(conta<=0){
						conta=1;
					}
				}
			} catch (Exception e2) {
				objGUI.mostrarAviso("No Ha Seleccionado Un Item");
			}
		}
		
		if(e.getSource()==rdbCel){
			rdbCye.setSelected(false);
			btnBuscarCliente.setEnabled(true);
			estado=1;
		}
		
        if(e.getSource()==rdbCye){
			rdbCel.setSelected(false);
			btnBuscarCliente.setEnabled(true);
			estado=2;
		}
		
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==tblLista){
			cargar();
		}
		
		if(e.getSource()==tblLista&tblLista.getSelectedColumn()==1){
			
			objCambiarCant = new CambiarCant();
			int fila = tblLista.getSelectedRow();
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
	        System.out.println("K CANTIDAD LE PASA?:"+cant);
	        System.out.println("ES LA FILA :"+fila);
	        BeanCotizacionUnItem objCotVarios=objCot.obtener(fila);
	        BeanCoti_borrar objcotB=objCotizacionBorrar.obtener(fila);
	        modelo2.setValueAt(Integer.parseInt(cant), fila, 1);
	        objCotVarios.setCancot(cant);
	        objcotB.setCant(cant);
	        calcularParte1(fila);
	        objcotB.setPunit(""+modelo2.getValueAt(fila, 5));
			objcotB.setPtotal(""+modelo2.getValueAt(fila, 6));
			objcotB.setPcosto(""+modelo2.getValueAt(fila, 7));
			objcotB.setCtotal(""+modelo2.getValueAt(fila, 8));
			objcotB.setDif(""+modelo2.getValueAt(fila, 9));
			objcotB.setPorc(""+modelo2.getValueAt(fila, 11));
	        calcular(); 
	        est=1;
	        
	        
	        
	        
	        
	       }
	         
			
		}
		/************************************************************************************************/
		
		if(e.getSource()==tblLista&(tblLista.getSelectedColumn()==5||
				tblLista.getSelectedColumn()==6||
				tblLista.getSelectedColumn()==7||
				tblLista.getSelectedColumn()==8||
				tblLista.getSelectedColumn()==9)){
			
			objescCal= new EscogerCalcular();
			int cod_ven=objGlobal.COD_VEN;
		    String fech=objFecha.fechaActual();
			int fila = tblLista.getSelectedRow();
			
			if(objCot.tamaño()!=0){
				System.out.println("ESTE ES LA FILA QUE ESTA AGARRANDO:"+fila);
		    BeanCotizacionUnItem objcoti=objCot.obtener(fila);
			
			
			cantidadpasar=Integer.parseInt(objcoti.getCancot());
			costepasar=Double.parseDouble(objcoti.getCoste());//DHDHDHDHDHDHDHH
			System.out.println("EL COSTE REAL ANTES:"+costepasar);
			poner="0";
			objescCal= new EscogerCalcular();
			
			objescCal.txtPTotal.setText(""+modelo2.getValueAt(fila, 5));
			objescCal.txtTotal.setText(""+modelo2.getValueAt(fila, 6));
			objescCal.txtCostoTotal.setText(""+modelo2.getValueAt(fila, 7));
			objescCal.txtTotalCosto.setText(""+modelo2.getValueAt(fila, 8));
			objescCal.txtDiferencia.setText(""+modelo2.getValueAt(fila, 9));
			objescCal.txtFactor.setText(""+modelo2.getValueAt(fila, 11));
			}
			
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
		         }else{//ACEPTAR 
	        	BeanCotizacionUnItem objCotVarios=objCot.obtener(fila);
	 	 	    BeanCoti_borrar objcotB=objCotizacionBorrar.obtener(fila);
	 	 	    
		        objGUI.mostrarAviso("este es el valor:"+objescCal.txtFactor.getText());
		        modelo2.setValueAt(objescCal.txtPTotal.getText(), fila, 5);
				modelo2.setValueAt(objescCal.txtTotal.getText(), fila, 6);
				modelo2.setValueAt(objescCal.txtCostoTotal.getText(), fila, 7);
				modelo2.setValueAt(objescCal.txtTotalCosto.getText(), fila, 8);
				modelo2.setValueAt(objescCal.txtDiferencia.getText(), fila, 9);
				modelo2.setValueAt(objescCal.txtFactor.getText(), fila, 11);
				objcotB.setPunit(""+modelo2.getValueAt(fila, 5));
				objcotB.setPtotal(""+modelo2.getValueAt(fila, 6));
				objcotB.setPcosto(""+modelo2.getValueAt(fila, 7));
				objcotB.setCtotal(""+modelo2.getValueAt(fila, 8));
				objcotB.setDif(""+modelo2.getValueAt(fila, 9));
				objcotB.setPorc(""+modelo2.getValueAt(fila, 11));
				calcular();	 
				
		        }
	         poner=null;
		}
		/************************************************************************************************/
		if(e.getSource()==tblLista&tblLista.getSelectedColumn()==14){
			
			objCamTiemEntrega =new CambiarTiempoEntrega();
			int fila = tblLista.getSelectedRow();
			String tiempoEntrega=""+modelo2.getValueAt(fila, 14);
			if(tiempoEntrega.equals("ERROR 0") ||tiempoEntrega.equals("ERROR 1")||tiempoEntrega.equals("ERROR 2")||
	        		 tiempoEntrega.equals("ERROR 2.2") ||tiempoEntrega.equals("UND") ){
				//NADA
			}else{
				
			
			objCamTiemEntrega= null;
			objCamTiemEntrega= new CambiarTiempoEntrega();
			objCamTiemEntrega.txtCantidad.setText(""+modelo2.getValueAt(fila, 14));
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
	        	 
	         }else{
	        BeanCotizacionUnItem objCotVarios=objCot.obtener(fila);
	 	    BeanCoti_borrar objcotB=objCotizacionBorrar.obtener(fila);
	        String tiempo=objCamTiemEntrega.txtCantidad.getText();
	        System.out.println("K TIEMPO LE PASA?:"+tiempo);
	        System.out.println("ES LA FILA :"+fila);
	        modelo2.setValueAt(tiempo, fila, 14);
	        objCotVarios.setTiempoentrega(tiempo);
	        objcotB.setTiempo_entrega(tiempo);
	         //calcularParte(fila);
	         //calcular(); 
	         }
		  }   
			
		}
		/************************************************************************************************/
	}
	public void mouseReleased(MouseEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e) {}
	
	

}
