package gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JButton;
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
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.EditorArchivo;
import miLib.Fecha;
import miLib.GUI;
import miLib.Metodos;
import miLib.PasarExcel;
import miLib.PasarProdExcel;
import miLib.ServletExcel;
import miLib.ServletVarios;
import pOp.BuscarClienteAut;
import pOp.CambiarCant;
import pOp.CambiarTiempoEntrega;
import pOp.CargarCotInc;
import pOp.EscogerCalcular;
import servlet.ServletCliCoti;
import servlet.ServletCotiBorrar;
import servlet.ServletCotizacionInconclusa;
import servlet.ServletGuardarProdNoEncontrado;
import servlet.ServletGuardarProdNoEncontrado0;
import servlet.ServletGuardarProdNoEncontrado1;
import servlet.ServletProveCorreo;
import beans.BeanCliCoti;
import beans.BeanCoti_borrar;
import beans.BeanCotizacionInconclusa;
import beans.BeanExcel;
import beans.BeanGuardarProdNoEncontrados;
import beans.BeanGuardarProdNoEncontrados1;
import beans.BeanProveCorreo;
import beans.BeanVarios;
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
public  class NuevoCotizadorPorParametro extends  JInternalFrame implements ActionListener, MouseListener{
	private JButton btnBuscar;
	private JPanel pnlPricncipal;
	private JLabel lblTotal;
	private JLabel lblAtencion;
	private JTextField txtSeñores;
	private JLabel lblSeñores;
	private JButton btnGuardar;
	private JTextField txtTotalDif;
	private JTextField txtIgvDif;
	private JTextField txtPrecioVentaDif;
	private JTextField txtTotalIgv;
	private JTextField txtIgvCompra;
	private JLabel lblIgv;
	private JLabel lblPrecioVenta;
	private JRadioButton rdbCel;
	private JRadioButton rdbCye;
	private JButton btnBorrar;
	private JTextField txtAtencion2;
	private JPanel pnlMedio;
	private JButton btnCargar;
	private JButton btnGuardarTemp;
	private JTextField txtReferencia;
	private JLabel lblReferencia;
	private JButton btnBuscarCliente;
	private JLabel lblAntencion;
	private JTextField txtSeñores2;
	private JLabel lblSeñores2;
	private JTextField txtAtencion;
	private JTextField txtPrecioVentaCompra;
	private JTextField txtTotal;
	private JTextField txtIgv;
	private JTextField txtPrecioVenta;
	private JPanel pnlAbajo;
	private JTable tblLista;
	private JScrollPane scrLista;
	private JTextField txtRuta;
	private JLabel lblRuta;
	private EditorArchivo archivoDatos;
	private JButton btngprod;
	
	String cadenar="D:/ProyectoCEL(1.0.0.0)/Cotizaciones/Cotizaciones/";
	Fecha objFecha;
	Metodos objMetodo;
	GUI objGUI;
	Globales objGlobal;
	//BuscarProdAut objBuscarProdAut;
	BuscarClienteAut objBuscarCliAut;
	CargarCotInc objCargarCotInc;
	String COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,COD_UMED,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT,
	NOM_PRODALT,COD_DET_DIF,PESO_PRODUCTO;
	public static String nombreProd="";
	public static int cantidad=0;
	   MenuPrincipal objMenuP;
	public static int cantidadpasar=0;
	public static double costepasar;
	public static String poner;
	public static String sexprove,nomprove,correo;
	
	ServletVarios objServletVarios = new 	ServletVarios();

    ServletExcel arrayExcel= new ServletExcel();
    ServletCotiBorrar objCotizacionBorrar= new ServletCotiBorrar();
    CambiarCant objCambiarCant;
   
    EscogerCalcular objescCal;
	  Object[] arregloCadenas;
	  Object[][] arregloObjetos;
	  Object[] arregloCadenas1;
	  Object[][] arregloObjetos2;
	  
	PasarExcel objPasarExcel;
	String ref="";
	String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Unit$","P.Total$","P.Costo$","C.Total$","Dif.$","Fecha","%","Proveedor","Peso Producto","T.Entrega"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 String ide_cot_inc,nom_cli,cona_cli,fecha_coti;
	 int desc_prod;
	 ServletCotizacionInconclusa objSCotInc= new ServletCotizacionInconclusa();
	 ServletCliCoti objCliCoti =new ServletCliCoti();
	 ServletGuardarProdNoEncontrado objSGuarProd=new ServletGuardarProdNoEncontrado();
	 ServletGuardarProdNoEncontrado0 objSGuarProd0=new ServletGuardarProdNoEncontrado0();
	 ServletGuardarProdNoEncontrado1 objSGuarProd1=new ServletGuardarProdNoEncontrado1();
	 ServletProveCorreo objSProvCorreo =new ServletProveCorreo();
	 EnvioMailsAutoProve objMailProv;
	 
	 int contador,conta,conta1,verificar;
	 PasarProdExcel objProdExcel;
	 public static String rutaGlobal;
	 int est,contar,num;
     int estGTemp;
	 DocumentRenderer objPrint;
	 CambiarTiempoEntrega objCamTiemEntrega;
	 public static int estado;
     
	public NuevoCotizadorPorParametro() {
		super("Cotizacion Ingreso Por Plantilla", true, true, true, true);
		try {

			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(1173, 636));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setBounds(0, 0, 1173, 636);
			this.setIcon(true);

			pnlPricncipal = new JPanel();
			getContentPane().add(pnlPricncipal, BorderLayout.NORTH);
			pnlPricncipal.setLayout(null);
			pnlPricncipal.setBounds(0, -533, 943, 88);
			pnlPricncipal.setPreferredSize(new java.awt.Dimension(943, 106));

			pnlMedio = new JPanel();
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			pnlMedio.setPreferredSize(new java.awt.Dimension(943, 417));

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setLayout(null);
			pnlAbajo.setBounds(12, 525, 918, 76);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(943, 77));

			txtPrecioVentaCompra = new JTextField();
			pnlAbajo.add(txtPrecioVentaCompra);
			txtPrecioVentaCompra.setBounds(618, 2, 82, 21);

			lblPrecioVenta = new JLabel();
			pnlAbajo.add(lblPrecioVenta);
			lblPrecioVenta.setText("Precio Venta:");
			lblPrecioVenta.setBounds(444, 4, 80, 14);

			lblIgv = new JLabel();
			pnlAbajo.add(lblIgv);
			lblIgv.setText("IGV:");
			lblIgv.setBounds(472, 29, 37, 14);

			lblTotal = new JLabel();
			pnlAbajo.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(472, 54, 44, 14);

			txtPrecioVenta = new JTextField();
			pnlAbajo.add(txtPrecioVenta);
			txtPrecioVenta.setBounds(530, 1, 82, 21);

			txtIgv = new JTextField();
			pnlAbajo.add(txtIgv);
			txtIgv.setBounds(530, 26, 82, 21);

			txtTotal = new JTextField();
			pnlAbajo.add(txtTotal);
			txtTotal.setBounds(530, 51, 82, 21);

			txtIgvCompra = new JTextField();
			pnlAbajo.add(txtIgvCompra);
			txtIgvCompra.setBounds(618, 26, 82, 21);

			txtTotalIgv = new JTextField();
			pnlAbajo.add(txtTotalIgv);
			txtTotalIgv.setBounds(618, 51, 82, 21);

			txtPrecioVentaDif = new JTextField();
			pnlAbajo.add(txtPrecioVentaDif);
			txtPrecioVentaDif.setBounds(706, 2, 82, 21);

			txtIgvDif = new JTextField();
			pnlAbajo.add(txtIgvDif);
			txtIgvDif.setBounds(706, 26, 82, 21);

			txtTotalDif = new JTextField();
			pnlAbajo.add(txtTotalDif);
			txtTotalDif.setBounds(706, 51, 82, 21);

			btnGuardar = new JButton();
			pnlAbajo.add(btnGuardar);
			btnGuardar.setText("Guardar");
			btnGuardar.setBounds(46, 27, 97, 21);

			btnGuardarTemp = new JButton();
			pnlAbajo.add(btnGuardarTemp);
			btnGuardarTemp.setText("G.Temporalmente");
			btnGuardarTemp.setBounds(159, 27, 135, 21);

			btnCargar = new JButton();
			pnlAbajo.add(btnCargar);
			btnCargar.setText("Cargar");
			btnCargar.setPreferredSize(new java.awt.Dimension(111, 21));
			btnCargar.setSize(111, 21);
			btnCargar.setBounds(308, 27, 111, 20);

			btnCargar.addActionListener(this);

			btnGuardarTemp.addActionListener(this);

			btnGuardar.addActionListener(this);

			scrLista = new JScrollPane();
			pnlMedio.add(scrLista);
			scrLista.setBounds(12, 89, 918, 436);
			scrLista.setPreferredSize(new java.awt.Dimension(987, 420));

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setDefaultRenderer(Object.class, new miLib.MiRender());
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);

			btnBuscar = new JButton();
			pnlPricncipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(786, 5, 93, 27);

			lblRuta = new JLabel();
			pnlPricncipal.add(lblRuta);
			lblRuta.setText("Ruta:");
			lblRuta.setBounds(12, 10, 60, 16);

			txtRuta = new JTextField();
			pnlPricncipal.add(txtRuta);
			txtRuta.setBounds(78, 5, 696, 23);

			lblSeñores = new JLabel();
			pnlPricncipal.add(lblSeñores);
			lblSeñores.setText("Señores:");
			lblSeñores.setBounds(12, 34, 60, 14);

			txtSeñores = new JTextField();
			pnlPricncipal.add(txtSeñores);
			txtSeñores.setBounds(78, 32, 365, 21);

			lblAtencion = new JLabel();
			pnlPricncipal.add(lblAtencion);
			lblAtencion.setText("Atencion:");
			lblAtencion.setBounds(448, 34, 61, 16);

			txtAtencion = new JTextField();
			pnlPricncipal.add(txtAtencion);
			txtAtencion.setBounds(514, 32, 260, 21);

			lblSeñores2 = new JLabel();
			pnlPricncipal.add(lblSeñores2);
			lblSeñores2.setText("Señores:");
			lblSeñores2.setBounds(12, 59, 53, 14);

			txtSeñores2 = new JTextField();
			pnlPricncipal.add(txtSeñores2);
			txtSeñores2.setBounds(77, 55, 365, 21);

			lblAntencion = new JLabel();
			pnlPricncipal.add(lblAntencion);
			lblAntencion.setText("Atencion:");
			lblAntencion.setBounds(448, 59, 66, 14);

			txtAtencion2 = new JTextField();
			pnlPricncipal.add(txtAtencion2);
			txtAtencion2.setBounds(514, 55, 260, 21);

			btnBuscarCliente = new JButton();
			pnlPricncipal.add(btnBuscarCliente);
			btnBuscarCliente.setText("Buscar Cliente");
			btnBuscarCliente.setBounds(891, 37, 118, 24);
			btnBuscarCliente.setEnabled(false);

			lblReferencia = new JLabel();
			pnlPricncipal.add(lblReferencia);
			lblReferencia.setText("Referencia:");
			lblReferencia.setBounds(12, 82, 65, 14);

			txtReferencia = new JTextField();
			pnlPricncipal.add(txtReferencia);
			txtReferencia.setBounds(77, 79, 697, 21);

			btngprod = new JButton();
			pnlPricncipal.add(btngprod);
			btngprod.setText("gurdarProd");
			btngprod.setBounds(786, 69, 100, 26);

			btnBorrar = new JButton();
			pnlPricncipal.add(btnBorrar);
			btnBorrar.setText("Borrar");
			btnBorrar.setBounds(891, 69, 85, 26);

			rdbCye = new JRadioButton();
			pnlPricncipal.add(rdbCye);
			rdbCye.setBounds(783, 39, 49, 21);
			rdbCye.setText("CYE");
			rdbCye.addActionListener(this);

			rdbCel = new JRadioButton();
			pnlPricncipal.add(rdbCel);
			rdbCel.setText("CEL");
			rdbCel.setBounds(840, 37, 47, 24);
			rdbCel.addActionListener(this);

			btnBorrar.addActionListener(this);

			btngprod.addActionListener(this);

			btnBuscarCliente.addActionListener(this);
			btnBuscar.addActionListener(this);

			//objBuscarProdAut=new BuscarProdAut();
			
			

//String titulo2[]={"Cant","Und","Descripcion","Marca","P.Total $","Total $","Costo $","Total $","Dif. $","Fecha","%","Proveedor"};			
//String titulo2[]={"Id","Cant","Und","Descripcion","Marca","P.Unit$","P.Total$","P.Costo$","C.Total$","Dif.$","Fecha","%","Proveedor"};		
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
			

			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}

	public double pasarPorceGana(int cod_prod){
		/*SELECT RUB.POR_RUBRO FROM PRODUCTO PROD INNER JOIN RUBRO RUB
        ON PROD.COD_RUBRO=RUB.COD_RUBRO
        WHERE PROD.COD_PROD='1';*/
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
	
	public void calcularParte(int i){
		
		double costoreal;
		double porc=pasarPorceGana(Integer.parseInt(COD_PROD));
		String cantiViene=""+modelo2.getValueAt(i, 1);
		int cantViene=Integer.parseInt(cantiViene.trim());
		//costoreal=objGUI.convertidor(Double.parseDouble(COSTE));	
		costoreal=Double.parseDouble(COSTE);	
		double costoRealXCant=costoreal*cantViene;
		//costoRealXCant=objGUI.convertidor(costoRealXCant);
		costoRealXCant=costoRealXCant;
		double precioConPorce=costoreal/porc;
		//precioConPorce=objGUI.convertidor(precioConPorce);
		precioConPorce=precioConPorce;
		double precioConPorceXCant=precioConPorce*cantViene;
		//precioConPorceXCant=objGUI.convertidor(precioConPorceXCant);
		precioConPorceXCant=precioConPorceXCant;
		double dife=precioConPorceXCant-costoRealXCant;
		//dife=objGUI.convertidor(dife);
		dife=dife;
		
		 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
		 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
		 modelo2.setValueAt(costoreal, i, 7);//Costo $
		 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
		 modelo2.setValueAt(dife, i, 9);//Dif. $
		 modelo2.setValueAt(FECHA, i, 10);//Fecha
		 modelo2.setValueAt(porc, i, 11);//%
		 modelo2.setValueAt(PROVEEDOR, i, 12);//Proveedor
		 
		 
	}
	/***********************************************************************/
	public void calcularParte1(int i){
		
		double costoreal;
		BeanVarios objCotVarios=objServletVarios.obtener(i);
		double porc=pasarPorceGana(objCotVarios.getCodprod());
		String cantiViene=""+modelo2.getValueAt(i, 1);
		int cantViene=Integer.parseInt(cantiViene.trim());
		costoreal=formato(objCotVarios.getCostoreal());/////////////////////	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		double precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		double peso=0;
		String pesoprod=""+modelo2.getValueAt(i, 13);
		if(pesoprod.equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(pesoprod);
		}
			
		String pesofinal=""+peso;
		/*objCotVarios.setCosteXporc(""+precioConPorce);
		objCotVarios.setCosteXporcXcant(""+precioConPorceXCant);
		objCotVarios.setCoste(""+costoreal);
		objCotVarios.setCosteXcant(""+costoRealXCant);
		objCotVarios.setDife(""+dife);*/
		
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorce)), i, 5);//P.Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorceXCant)), i, 6);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoreal)), i, 7);//Costo $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoRealXCant)), i, 8);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(dife)), i, 9);//Dif. $
		 modelo2.setValueAt(Double.parseDouble(""+porc), i, 11);//%
		 modelo2.setValueAt(Double.parseDouble(""+pesofinal), i, 13);//Peso

	}
	/***********************************************************************/
	public void calcularParte2(int i){
		
		double costoreal;
		BeanCotizacionInconclusa objCotIncon=objSCotInc.obtener(i);
		double porc=pasarPorceGana(objCotIncon.getCod_prod());
		String cantiViene=""+modelo2.getValueAt(i, 1);
		int cantViene=Integer.parseInt(cantiViene.trim());
		costoreal=formato(objCotIncon.getCosto());/////////////////////	
		double costoRealXCant=costoreal*cantViene;
		costoRealXCant=formato(costoRealXCant);
		double precioConPorce=costoreal/porc;
		precioConPorce=formato(precioConPorce);
		double precioConPorceXCant=precioConPorce*cantViene;
		precioConPorceXCant=formato(precioConPorceXCant);
		double dife=precioConPorceXCant-costoRealXCant;
		dife=formato(dife);
		double peso=0;
		String pesoprod=""+modelo2.getValueAt(i, 13);
		if(pesoprod.equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(pesoprod);
		}
			
		String pesofinal=""+peso;
		/*objCotVarios.setCosteXporc(""+precioConPorce);
		objCotVarios.setCosteXporcXcant(""+precioConPorceXCant);
		objCotVarios.setCoste(""+costoreal);
		objCotVarios.setCosteXcant(""+costoRealXCant);
		objCotVarios.setDife(""+dife);*/
		
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorce)), i, 5);//P.Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(precioConPorceXCant)), i, 6);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoreal)), i, 7);//Costo $
		 modelo2.setValueAt(Double.parseDouble(""+formato(costoRealXCant)), i, 8);//Total $
		 modelo2.setValueAt(Double.parseDouble(""+formato(dife)), i, 9);//Dif. $
		 modelo2.setValueAt(Double.parseDouble(""+porc), i, 11);//%
		 modelo2.setValueAt(Double.parseDouble(""+pesofinal), i, 13);//Peso

	}
	/*****************************************************/
	
	
	public String primeraSinS(String cad){
		
		String pal="",pal2="";
		int conta=0;
		for(int i=cad.length()-1;i>=0;i--){
			conta++;
			
			if(conta==1){
				pal2=""+cad.toLowerCase().charAt(i);
				if(pal2.equals("s")){
					//pal=" ";
				}else{
					pal=cad.toLowerCase().charAt(i)+pal;
				}
			}else{
				pal=cad.toLowerCase().charAt(i)+pal;
			}
		}
		return pal.trim();
	}
    public	String primerapal(String cad){
		
		String pal="",pal2="";
		for(int i=0;i<cad.length();i++){
			pal2=""+cad.toLowerCase().charAt(i);
			if(pal2.equals(" ")){
				break;
			}else{
				pal+=cad.toLowerCase().charAt(i);
			}
		}
		return pal.trim();
	}
    
    public String sinAlgunasPalabrasYSimbolos(String cad){
    	
    	cad.toLowerCase();
    	
    	cad=cad.replaceAll("nº", "");
    	cad=cad.replace("de", "%");
    	cad=cad.replaceAll("para", "");
    	cad=cad.replaceAll("/", "%");
    	cad=cad.replaceAll("electrico", "");
    	cad=cad.replaceAll("x", "%");
    	cad=cad.replaceAll("-", "%");
    	cad=cad.replaceAll("awg","%awg");
    	cad=cad.replaceAll(",", "");
    	cad=cad.replaceAll("aº", "");
    	cad=cad.replaceAll("gº", "");
    	cad=cad.replaceAll("mm","%mm");
        /*cad13=cad12.replaceAll("long", "");
        cad14=cad13.replaceAll(".", "");
        cad15=cad14.replaceAll("c/", "");
        cad16=cad15.replaceAll("p/", "");*/
    	
    	return cad;
    }
    
	
	public String completarOracion(String word){
		
		String cad="",cad2="";
		int conta=0;
		for(int i=0;i<word.length();i++){
			cad=""+word.toLowerCase().charAt(i);
			
			if(cad.equals(" ")){
				cad2=cad2+"%";
				conta++;
			}
			else{
				if(conta==0){
				   //nada				
				}else{
					cad2+=word.toLowerCase().charAt(i);
				}
			}
		}
		
		return cad2.toLowerCase();
	}
		
	public String  encontrarProducto(String cad){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_producto "+
                    "where NOM_PROD like" +
                    " (select(lcase(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace('"+cad+"','long','')," +
                    " 'c/',''),'p/',''),'n.','%'),'ø',''),'lela',''),'amarres',''),'recocidos',''),'longitud',''),'.','%'),'ag',''),'*','%'),'mm2','%mm'),'Ø',''),'mt','%mt'),'acometida',''),'dom',''),'\"','')))) " +
                    " and EST_PROD='ACTIVADO' limit 1;";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		String nom="";
		try {
		if(rs.next()){
			String prod=rs.getString(2).toString();
			nom=prod;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
		return nom;
	}
	
    public String  encontrarModelo(String cad){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_producto "+
                    "where MOD_PROD='"+cad+"' " +
                    " and EST_PROD='ACTIVADO' limit 1;";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		String nom="";
		try {
		if(rs.next()){
			String prod=rs.getString(2).toString();
			nom=prod;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
		return nom;
	}

    public String  encontrarCodPromelsa(String cad){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_producto "+
                   "where CODPRO_PROD='"+cad+"' " +
		           "and EST_PROD='ACTIVADO' limit 1;";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		String nom="";
		try {
		if(rs.next()){
			String prod=rs.getString(2).toString();
			nom=prod;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
		return nom;
	}
	
	
	public String conU(String cad){
		
		String cad1="",cad2="";
		for(int i=0;i<cad.length();i++){
			cad1=""+cad.charAt(i);
			if(cad1.toLowerCase().equals("u")){
				cad2="UND";
				break;
			}else{
				cad2+=cad1;
			}
		}
		
		
		return cad2;
	}
	
	public String sinPorcentaje(String cad){
		
		String cad1="",cad2="";
		int cont=0;
		for(int i=0;i<cad.length();i++){
			  cad1=""+cad.charAt(i);
			if(cad1.equals("%")){
				cont++;
				if(cont>1){
					cad2+="";
				}else{
					cad2+=cad1;
				}
			}else{
				cad2+=cad1;
				cont=0;
			}
		}
		return cad2;
	}
	
	public String existeProd(String cad){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_producto "+
                    "where NOM_PROD='"+cad+"' " +
                    " and EST_PROD='ACTIVADO' limit 1;";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		String nom="";
		try {
		if(rs.next()){
			String prod=rs.getString(2).toString();
			nom=prod;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
		
		return nom;
	}
		

	public void reescribir(){
		
		String nom0="",nom1="",nom2="",nom3="";
		
		 for (int i = 0; i < modelo2.getRowCount(); i++){
			 
			 BeanExcel objExcel=arrayExcel.obtener(i);
			
			 String productoViene=""+modelo2.getValueAt(i, 3);
			 String uMed=""+modelo2.getValueAt(i, 2),modelo=objExcel.getModelo().trim(),codprom=objExcel.getCodPromelsa().trim();
		     
			 nom0=primeraSinS(primerapal(productoViene.trim()))+sinAlgunasPalabrasYSimbolos((completarOracion(productoViene.trim())));
		     
		    //System.out.println("NOM 0:"+nom0);  
		    //System.out.println("mod:"+modelo+"    "+"cod:"+codprom+"   "+"nom:"+productoViene);
			   
		        if(modelo.equals("") || modelo.equals("null")){
		        	nom3="";
		        }else{
		        	 nom3=encontrarModelo(modelo);
		        }
			   
		         if(nom3.equals("")){//MODELO
		        	 if(codprom.equals("") || codprom.equals("null")){
		        		 nom3="";  
	        		 }else{
	        			 nom3=encontrarCodPromelsa(codprom);
	        		 }
	        		 if(nom3.equals("")){//COD. PROMELSA
	        			 if(productoViene.equals("") || productoViene.equals("null")){
			        		 nom3=""; 
		        		 }else{
		        			 if(nom0.equals("") || nom0.equals("0.0") || nom0.equals("null")){
		        			      nom3=""; 
	        			     }else{
	        			    	 nom1="%"+nom0+"%"; 
	        			         nom2=sinPorcentaje(nom1).trim();
	        			     }
		        			 nom3=encontrarProducto(nom2);
		        		 }
		        		 if(nom3.equals("")){//NOMBRE DE PRODUCTO
		        			 modelo2.setValueAt(conU(uMed), i, 2);
		    				 modelo2.setValueAt(productoViene, i, 3); 
		        		 }else{
		        			 modelo2.setValueAt(conU(uMed), i, 2);
							 modelo2.setValueAt(nom3, i, 3);
		        		 }
	           		 }else{
	        			 modelo2.setValueAt(conU(uMed), i, 2);
						 modelo2.setValueAt(nom3, i, 3);
	        		 }
		         }else{
		        	 modelo2.setValueAt(conU(uMed), i, 2);
					 modelo2.setValueAt(nom3, i, 3);
		         }
		         
		       
		}
	} 
	
	public  void buscarDetalles(){
		
		double porc=0;
		System.out.println("ENTRO AL BUSCAR DETALLE,\nY EL TAMAÑO ES:"+modelo2.getRowCount());
	    for (int i = 0; i < modelo2.getRowCount(); i++) {
	
		
      int  codprod = 0,codmar=0,codprove=0,cod_prodalt=0,cod_umed=0;		 
	  String producto="",mon="",umed="",obsprod="",obsdet="",igv="",marcar="",proveedor="",fec="",nom_prodalt="",cod_det_dif="",tiempo_entrega="";
	  double costoreal=0,costoprove=0,peso=0;
		
		
		String productoViene=""+modelo2.getValueAt(i, 3);
		//String nom="%"+primeraSinS(primerapal(productoViene))+completarOracion(productoViene)+"%";
		//String nom2=encontrarPalabras(nom);
		
		String marcaViene=""+modelo2.getValueAt(i, 4);
		String cantiViene=""+modelo2.getValueAt(i, 1);
		String umedViene=""+modelo2.getValueAt(i, 2);
		int cantViene=Integer.parseInt(cantiViene.trim());
		//System.out.println("Entraaaaa2222:  "+productoViene);

		String vamosAver=objMetodo.traeNFilas(productoViene.trim());
		
		if(vamosAver.equals("0")){

			        if(existeProd(productoViene).equals("")){
			        	modelo2.setValueAt("No existe", i, 4);//Marca
			        }else{
			        	modelo2.setValueAt("Sin Precio", i, 4);//Marca
			        }
			         modelo2.setValueAt("ERROR 0", i, 5);//P.Total $
					 modelo2.setValueAt("ERROR 0", i, 6);//Total $
					 modelo2.setValueAt("ERROR 0", i, 7);//Costo $
					 modelo2.setValueAt("ERROR 0", i, 8);//Total $
					 modelo2.setValueAt("ERROR 0", i, 9);//Dif. $
					 modelo2.setValueAt("ERROR 0", i, 10);//Fecha
					 modelo2.setValueAt("ERROR 0", i, 11);//%
					 modelo2.setValueAt("ERROR 0", i, 12);//Proveedor
					 modelo2.setValueAt("ERROR 0", i, 13);//PesoTotal
					 modelo2.setValueAt("ERROR 0", i, 14);//Tiempo Entrega
			 	
		}else if(vamosAver.equals("1")){
			//BACAN IMPRIME NO MAS LO QUE ENCONTRO (SERIA PERFECTO)
			int viene=objMetodo.buscar1parte1(productoViene.trim(),umedViene.trim());//PERATE
			if(viene==0){
				// modelo2.setValueAt("ERROR 1", i, 2);//Marca
				 modelo2.setValueAt("ERROR 1", i, 5);//P.Total $
				 modelo2.setValueAt("ERROR 1", i, 6);//Total $
				 modelo2.setValueAt("ERROR 1", i, 7);//Costo $
				 modelo2.setValueAt("ERROR 1", i, 8);//Total $
				 modelo2.setValueAt("ERROR 1", i, 9);//Dif. $
				 modelo2.setValueAt("ERROR 1", i, 10);//Fecha
				 modelo2.setValueAt("ERROR 1", i, 11);//%
				 modelo2.setValueAt("ERROR 1", i, 12);//Proveedor
				 modelo2.setValueAt("ERROR 1", i, 13);//PesoTotal
				 modelo2.setValueAt("ERROR 1", i, 14);//Tiempo Entrega
			    }else{
				//System.out.println("MAMITA SALVAMOS DE ESTA");
				codprod=objMetodo.codprod;codmar=objMetodo.codmar;codprove=objMetodo.codprove;cod_umed=objMetodo.cod_umed;
				producto=objMetodo.producto;mon=objMetodo.mon;umed=objMetodo.umed;obsprod=objMetodo.obsprod;
				obsdet=objMetodo.obsdet;igv=objMetodo.igv;marcar=objMetodo.marca;proveedor=objMetodo.proveedor;
				fec=objMetodo.fec;cod_prodalt=objMetodo.cod_prodalt;nom_prodalt=objMetodo.nom_prodalt;
				costoreal=objMetodo.costoreal;costoprove=objMetodo.costoprove;peso=objMetodo.peso;
				porc=pasarPorceGana(codprod);
				
		
				
				//--------------------------------------------------------------------------
				if(umedViene.equals(umed)){
					
				costoreal=formato(costoreal);	
				double costoRealXCant=costoreal*cantViene;
				costoRealXCant=formato(costoRealXCant);
				double precioConPorce=costoreal/porc;
				precioConPorce=formato(precioConPorce);
				double precioConPorceXCant=precioConPorce*cantViene;
				precioConPorceXCant=formato(precioConPorceXCant);
				double dife=precioConPorceXCant-costoRealXCant;
				double pesoTotal=peso;
				dife=formato(dife);
				pesoTotal=formato(pesoTotal);
				 modelo2.setValueAt(umed, i, 2);
				 modelo2.setValueAt(marcar, i, 4);//Marca
				 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
				 modelo2.setValueAt(precioConPorceXCant,i, 6);//Total $
				 modelo2.setValueAt(costoreal, i, 7);//Costo $
				 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
				 modelo2.setValueAt(dife, i, 9);//Dif. $
				 modelo2.setValueAt(fec, i, 10);//Fecha
				 modelo2.setValueAt(porc, i, 11);//%
				 modelo2.setValueAt(proveedor, i, 12);//Proveedor
				 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
				 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
				 
			
				}else{
					if(vamosAver.equals("1")){
						costoreal=formato(costoreal);	
						double costoRealXCant=costoreal*cantViene;
						costoRealXCant=formato(costoRealXCant);
						double precioConPorce=costoreal/porc;
						precioConPorce=formato(precioConPorce);
						double precioConPorceXCant=precioConPorce*cantViene;
						precioConPorceXCant=formato(precioConPorceXCant);
						double dife=precioConPorceXCant-costoRealXCant;
						double pesoTotal=peso;
						dife=formato(dife);
						pesoTotal=formato(pesoTotal);
						 modelo2.setValueAt(umed, i, 2);
						 modelo2.setValueAt(marcar, i, 4);//Marca
						 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
						 modelo2.setValueAt(precioConPorceXCant,i, 6);//Total $
						 modelo2.setValueAt(costoreal, i, 7);//Costo $
						 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
						 modelo2.setValueAt(dife, i, 9);//Dif. $
						 modelo2.setValueAt(fec, i, 10);//Fecha
						 modelo2.setValueAt(porc, i, 11);//%
						 modelo2.setValueAt(proveedor, i, 12);//Proveedor
						 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
						 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
						
					}else{
						System.out.println("NADA 100000");
						 modelo2.setValueAt("UND", i, 5);//P.Total $
						 modelo2.setValueAt("UND",i, 6);//Total $
						 modelo2.setValueAt("UND", i, 7);//Costo $
						 modelo2.setValueAt("UND", i, 8);//Total $
						 modelo2.setValueAt("UND", i, 9);//Dif. $
						 modelo2.setValueAt("UND", i, 10);//Fecha
						 modelo2.setValueAt("UND", i, 11);//%
						 modelo2.setValueAt("UND", i, 12);//Proveedor
						 modelo2.setValueAt("UND", i, 13);//PesoTotal
						 modelo2.setValueAt("UND", i, 14);//Tiempo Entrega
					}
					
				}
				
				
			}
			
			
		}
		//SI ES MAYOR QUE 2
		else{
			//ESTE ELSE SIGNIFICA QUE ENCONTRO EL PRODUCTO PERO HAY MAS DE UN PROVEEDOR
			//QUE VENDE ESTE PRODUCTO POR ESO QUE SALEN VARIOS CON DIFERENTES PRECIOS
			int viene=objMetodo.buscar2parte1(productoViene.trim(),umedViene.trim());
			if(viene==0){
				
				 modelo2.setValueAt("ERROR 2", i, 5);//P.Total $
				 modelo2.setValueAt("ERROR 2", i, 6);//Total $
				 modelo2.setValueAt("ERROR 2", i, 7);//Costo $
				 modelo2.setValueAt("ERROR 2", i, 8);//Total $
				 modelo2.setValueAt("ERROR 2", i, 9);//Dif. $
				 modelo2.setValueAt("ERROR 2", i, 10);//Fecha
				 modelo2.setValueAt("ERROR 2", i, 11);//%
				 modelo2.setValueAt("ERROR 2", i, 12);//Proveedor
				 modelo2.setValueAt("ERROR 2", i, 13);//PesoTotal
				 modelo2.setValueAt("ERROR 2", i, 14);//Tiempo Entrega
				//ESTO SI ES UN GRAN ERROR ,QUE NO CREO QUE SALGA NUNCA
			}else if(viene==1){/*ESTE BUSCA SI HAY UN PRODUCTO CON EL MISMO PRECIO(MINIMO)*/
				//chevre encontro e imprime
				//System.out.println("PAPITO SALVAMOS DE ESTA");
				codprod=objMetodo.codprod;codmar=objMetodo.codmar;codprove=objMetodo.codprove;cod_umed=objMetodo.cod_umed;
				producto=objMetodo.producto;mon=objMetodo.mon;umed=objMetodo.umed;obsprod=objMetodo.obsprod;
				obsdet=objMetodo.obsdet;igv=objMetodo.igv;marcar=objMetodo.marca;proveedor=objMetodo.proveedor;
				fec=objMetodo.fec;cod_prodalt=objMetodo.cod_prodalt;nom_prodalt=objMetodo.nom_prodalt;
				costoreal=objMetodo.costoreal;costoprove=objMetodo.costoprove;peso=objMetodo.peso;
				porc=pasarPorceGana(codprod);
				//--------------------------------------------------------------------------
				if(umedViene.equals(umed)){
					umed=umed;
				costoreal=formato(costoreal);	
				double costoRealXCant=costoreal*cantViene;
				costoRealXCant=formato(costoRealXCant);
				double precioConPorce=costoreal/porc;
				precioConPorce=formato(precioConPorce);
				double precioConPorceXCant=precioConPorce*cantViene;
				precioConPorceXCant=formato(precioConPorceXCant);
				double dife=precioConPorceXCant-costoRealXCant;
				double pesoTotal=peso;
				dife=formato(dife);
				pesoTotal=formato(pesoTotal);
				 modelo2.setValueAt(umed, i, 2);
				 modelo2.setValueAt(marcar, i, 4);//Marca
				 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
				 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
				 modelo2.setValueAt(costoreal, i, 7);//Costo $
				 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
				 modelo2.setValueAt(dife, i, 9);//Dif. $
				 modelo2.setValueAt(fec, i, 10);//Fecha
				 modelo2.setValueAt(porc, i, 11);//%
				 modelo2.setValueAt(proveedor, i, 12);//Proveedor
				 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
				 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
				 
				}else{
					if(vamosAver.equals("2")){
						costoreal=formato(costoreal);	
						double costoRealXCant=costoreal*cantViene;
						costoRealXCant=formato(costoRealXCant);
						double precioConPorce=costoreal/porc;
						precioConPorce=formato(precioConPorce);
						double precioConPorceXCant=precioConPorce*cantViene;
						precioConPorceXCant=formato(precioConPorceXCant);
						double dife=precioConPorceXCant-costoRealXCant;
						double pesoTotal=peso;
						dife=formato(dife);
						 modelo2.setValueAt(umed, i, 2);
						 modelo2.setValueAt(marcar, i, 4);//Marca
						 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
						 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
						 modelo2.setValueAt(costoreal, i, 7);//Costo $
						 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
						 modelo2.setValueAt(dife, i, 9);//Dif. $
						 modelo2.setValueAt(fec, i, 10);//Fecha
						 modelo2.setValueAt(porc, i, 11);//%
						 modelo2.setValueAt(proveedor, i, 12);//Proveedor
						 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
						 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
					
					}else{
						System.out.println("NADA 01");
						 modelo2.setValueAt("UND", i, 5);//P.Total $
						 modelo2.setValueAt("UND",i, 6);//Total $
						 modelo2.setValueAt("UND", i, 7);//Costo $
						 modelo2.setValueAt("UND", i, 8);//Total $
						 modelo2.setValueAt("UND", i, 9);//Dif. $
						 modelo2.setValueAt("UND", i, 10);//Fecha
						 modelo2.setValueAt("UND", i, 11);//%
						 modelo2.setValueAt("UND", i, 12);//Proveedor
						 modelo2.setValueAt("UND", i, 13);//PesoTotal
						 modelo2.setValueAt("UND", i, 14);//Tiempo Entrega
					}
			
					
				}
				
			}else{//SINO TIENE EL MISMO PRECIO MAS DE 2 PRODUCTOS
				//se supone que le pasa la marca
				
				int viene2=objMetodo.buscar2parte1(productoViene.trim(),"mayyyyyyyyyy");
				if(viene2==0){
					 modelo2.setValueAt("ERROR 2.2", i, 4);//Marca
					 modelo2.setValueAt("ERROR 2.2", i, 5);//P.Total $
					 modelo2.setValueAt("ERROR 2.2", i, 6);//Total $
					 modelo2.setValueAt("ERROR 2.2", i, 7);//Costo $
					 modelo2.setValueAt("ERROR 2.2", i, 8);//Total $
					 modelo2.setValueAt("ERROR 2.2", i, 9);//Dif. $
					 modelo2.setValueAt("ERROR 2.2", i, 10);//Fecha
					 modelo2.setValueAt("ERROR 2.2", i, 11);//%
					 modelo2.setValueAt("ERROR 2.2", i, 12);//Proveedor
					 modelo2.setValueAt("ERROR 2.2", i, 13);//PesoTotal
					 modelo2.setValueAt("ERROR 2.2", i, 14);//Tiempo Entrega
				}else if(viene2==1){
					//CHEVRE PORQUE YA ENCONTRO EL PRODUCTO INDICADO POR LA MARCA
					//chevre encontro e imprime
					codprod=objMetodo.codprod;codmar=objMetodo.codmar;codprove=objMetodo.codprove;cod_umed=objMetodo.cod_umed;
					producto=objMetodo.producto;mon=objMetodo.mon;umed=objMetodo.umed;obsprod=objMetodo.obsprod;
					obsdet=objMetodo.obsdet;igv=objMetodo.igv;marcar=objMetodo.marca;proveedor=objMetodo.proveedor;
					fec=objMetodo.fec;cod_prodalt=objMetodo.cod_prodalt;nom_prodalt=objMetodo.nom_prodalt;
					costoreal=objMetodo.costoreal;costoprove=objMetodo.costoprove;peso=objMetodo.peso;
					porc=pasarPorceGana(codprod);
					//--------------------------------------------------------------------------
					if(umedViene.equals(umed)){
						umed=umed;
						costoreal=formato(costoreal);	
					double costoRealXCant=costoreal*cantViene;
					costoRealXCant=formato(costoRealXCant);
					double precioConPorce=costoreal/porc;
					precioConPorce=formato(precioConPorce);
					double precioConPorceXCant=precioConPorce*cantViene;
					precioConPorceXCant=formato(precioConPorceXCant);
					double dife=precioConPorceXCant-costoRealXCant;
					double pesoTotal=peso;
					dife=formato(dife);
					pesoTotal=formato(pesoTotal);
					modelo2.setValueAt(umed, i, 2);
					 modelo2.setValueAt(marcar, i, 4);//Marca
					 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
					 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
					 modelo2.setValueAt(costoreal, i, 7);//Costo $
					 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
					 modelo2.setValueAt(dife, i, 9);//Dif. $
					 modelo2.setValueAt(obsdet, i, 10);//Fecha
					 modelo2.setValueAt(porc, i, 11);//%
					 modelo2.setValueAt(proveedor, i, 12);//Proveedor
					 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
					 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
				
					}else{
						 modelo2.setValueAt("UND", i, 5);//P.Total $
						 modelo2.setValueAt("UND",i, 6);//Total $
						 modelo2.setValueAt("UND", i, 7);//Costo $
						 modelo2.setValueAt("UND", i, 8);//Total $
						 modelo2.setValueAt("UND", i, 9);//Dif. $
						 modelo2.setValueAt("UND", i, 10);//Fecha
						 modelo2.setValueAt("UND", i, 11);//%
						 modelo2.setValueAt("UND", i, 12);//Proveedor
						 modelo2.setValueAt("UND", i, 13);//PesoTotal
						 modelo2.setValueAt("UND", i, 14);//Tiempo Entrega
					}
					
				}else{
					//MAL PORQUE SIGEN HABIENDO 2 O MAS PRODUCTOS CON EL MISMO PRECIO Y CON LA MISMA MARCA
					// PERO = QUE SALGA LO QUE SALGA ES LO MISMO
					codprod=objMetodo.codprod;codmar=objMetodo.codmar;codprove=objMetodo.codprove;cod_umed=objMetodo.cod_umed;
					producto=objMetodo.producto;mon=objMetodo.mon;umed=objMetodo.umed;obsprod=objMetodo.obsprod;
					obsdet=objMetodo.obsdet;igv=objMetodo.igv;marcar=objMetodo.marca;proveedor=objMetodo.proveedor;
					fec=objMetodo.fec;cod_prodalt=objMetodo.cod_prodalt;nom_prodalt=objMetodo.nom_prodalt;
					costoreal=objMetodo.costoreal;costoprove=objMetodo.costoprove;peso=objMetodo.peso;
					porc=pasarPorceGana(codprod);
					//--------------------------------------------------------------------------
					if(umedViene.equals(umed)){
						umed=umed;
						costoreal=formato(costoreal);	
					double costoRealXCant=costoreal*cantViene;
					costoRealXCant=formato(costoRealXCant);
					double precioConPorce=costoreal/porc;
					precioConPorce=formato(precioConPorce);
					double precioConPorceXCant=precioConPorce*cantViene;
					precioConPorceXCant=formato(precioConPorceXCant);
					double dife=precioConPorceXCant-costoRealXCant;
					double pesoTotal=peso;
					dife=formato(dife);
					pesoTotal=formato(pesoTotal);
					 modelo2.setValueAt(umed, i, 2);
					 modelo2.setValueAt(marcar, i, 4);//Marca
					 modelo2.setValueAt(precioConPorce, i, 5);//P.Total $
					 modelo2.setValueAt(precioConPorceXCant, i, 6);//Total $
					 modelo2.setValueAt(costoreal, i, 7);//Costo $
					 modelo2.setValueAt(costoRealXCant, i, 8);//Total $
					 modelo2.setValueAt(dife, i, 9);//Dif. $
					 modelo2.setValueAt(fec, i, 10);//Fecha
					 modelo2.setValueAt(porc, i, 11);//%
					 modelo2.setValueAt(proveedor, i, 12);//Proveedor
					 modelo2.setValueAt(pesoTotal, i, 13);//PesoTotal
					 modelo2.setValueAt("1 Dia", i, 14);//Tiempo Entrega
					 
					}else{
						 modelo2.setValueAt("UND", i, 5);//P.Total $
						 modelo2.setValueAt("UND",i, 6);//Total $
						 modelo2.setValueAt("UND", i, 7);//Costo $
						 modelo2.setValueAt("UND", i, 8);//Total $
						 modelo2.setValueAt("UND", i, 9);//Dif. $
						 modelo2.setValueAt("UND", i, 10);//Fecha
						 modelo2.setValueAt("UND", i, 11);//%
						 modelo2.setValueAt("UND", i, 12);//Proveedor
						 modelo2.setValueAt("UND", i, 13);//PesoTotal
						 modelo2.setValueAt("UND", i, 14);//Tiempo Entrega
						 
					}
					
				}
				
			}
			
		}
	  
		/*int  codprod,codmar,codprove;		 
		  String producto,mon,umed,obsprod,obsdet,igv,marcar,proveedor,fec;
		  double costoreal,costoprove;
		  
		  int codprod,codmar,codprove,cod_umed;			 
		  String producto,mon,umed,obsprod,obsdet,igv,marca,proveedor,nom_prodalt;
		  double costoreal,costoprove;
		  String fec,cod_det_dif;
		  */
		BeanVarios objVar=new BeanVarios(codprod,codmar, codprove,cod_umed,
				producto,  mon, umed,  obsprod,obsdet,igv, marcar, proveedor,nom_prodalt,
				costoreal,costoprove,fec, cod_det_dif);
				 
		objServletVarios.adicionar(objVar);
		
		/*******************************************************************************************************
		 * *****************************************************************************************************
		 */
		BeanCoti_borrar objcotborrar=new BeanCoti_borrar((""+modelo2.getValueAt(i, 1)),(""+modelo2.getValueAt(i, 2)),
				(""+modelo2.getValueAt(i, 3)),(""+modelo2.getValueAt(i, 4)),(""+modelo2.getValueAt(i, 5)),
				(""+modelo2.getValueAt(i, 6)),(""+modelo2.getValueAt(i, 7)),(""+modelo2.getValueAt(i, 8)),
				(""+modelo2.getValueAt(i, 9)),(""+modelo2.getValueAt(i, 10)),(""+modelo2.getValueAt(i, 11)),
				(""+modelo2.getValueAt(i, 12)),(""+modelo2.getValueAt(i, 13)),(""+modelo2.getValueAt(i, 14)));
		
		objCotizacionBorrar.adicionar(objcotborrar);
		
		//AQUI TIENES QUE PONER EL BEANS DONDE SE VA AGUARDAR UNA VES YA PUESTO,
		//PERO ANTES QUE VALLA A BUSCAR AL OTRO PRODUCTO		
	}
  }
	
   
	
	/***********************************************/
	private boolean  abrirArchivo(){
		  String vieneArchivo="";
	        //JFileChooser selectorArchivo=new JFileChooser();
	        //selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        
	        int resultado=0;//selectorArchivo.showOpenDialog(this);
	        
	        if(resultado==JFileChooser.CANCEL_OPTION)
	            return false;
	        
	        File archivo= new File("D:\\EXPORTAR.xls"); //selectorArchivo.getSelectedFile();
	        
	        if(archivo==null||archivo.getName().equals("")){
	            JOptionPane.showMessageDialog(this,"Nombre Del Archivo Incorrecto",
	            "Nombre Del Archivo Incorrecto",JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        vieneArchivo=""+archivo;
	        txtRuta.setText(vieneArchivo.trim());
	        objGUI.mostrarAviso("Este es la Ruta:"+vieneArchivo.trim());
	        
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
				if(tam>0){
					for (int i = 0; i < arrayExcel.tamaño(); i++){
					
							BeanExcel objExcel=arrayExcel.obtener(i);
							
							//System.out.println("Promelsa: "+objExcel.getCodPromelsa());
	                          
							Object obj[]={objExcel.getId(),objExcel.getCant(),objExcel.getUmedida(),objExcel.getDescripcion(),
									objExcel.getMarca()	};
								
							modelo2.addRow(obj);			
							
				   }	
				
				}
				/*String CODCLI,NOMCLI,TIPCLI,RUCCLI,LUGCLI,CONACLI,TEL1ACLI,TEL2ACLI,RPMACLI,NEXACLI,CELACLI,MAILCLI;*/
				BeanExcel objExcel=arrayExcel.obtener(0);
				txtSeñores.setText(objExcel.getSeñor());
				txtSeñores2.setText(objExcel.getSeñor());
				txtAtencion.setText(objExcel.getAtencion());
				txtAtencion2.setText(objExcel.getAtencion());
	        
				   return true; 
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
	/********TIPO DE CAMBIO************************/
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
	/******************************************/
	 public int retornaUltimoCodCotizacion(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT max(cod_cot) FROM tb_cotizacion";
			

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
	
	 /*****************************************************
	 /*****************************************************/
	 
	 public int retornaUltimoCodCotizacionInconclusa(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT max(ide_cot_inc) FROM tb_cotizacioninconclusa";
			

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
	 
	 public int retornaUltimoCodCotizacionInconclusa2(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String maxCodPregunta="SELECT max(ide_cot_inc) FROM tb_cotizacioninconclusa";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=1;
					}else{
					cod= Integer.parseInt(rs.getString(1));
					cod=cod;
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
	 
	 /*****************************************************/
	 
	 public void cargarCotizacionInc(){
			
			//int tipcomrep=cboTipoCom.getSelectedIndex(),
			//calrep=cboCalif.getSelectedIndex();
		    int cod_ven=objGlobal.COD_VEN;
			objSCotInc.eliminarTodo();
			int n=modelo2.getRowCount();
			String cant="";
			//String NOM_CLI=txtCliente.getText();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			AccesoBD objA = new AccesoBD();
			objA.crearConexion();
			
			String sql="select ide_cot_inc,num_item,cod_ven,cod_cli,fecha_coti,cantidad,unimedida,desc_prod,marca,precio_unit,precio_total, "+
			"precio_costo,costo_total,diferencia,fecha,porcentaje,nom_prove,cod_prove,cod_prod,cod_mar," +
			"cod_umed,peso_prod,tiempo_entrega,costo from tb_cotizacioninconclusa "+
			"where FECHA_COTI='"+fecha_coti+"' and COD_VEN='"+cod_ven+"' and IDE_COT_INC='"+ide_cot_inc+"'; ";
	     	 //  "where CLI.NOM_CLI like '%"+NOM_CLI+"%';";
	               
			
			ResultSet rs=objA.ejecutarConsulta(sql);
			try {
				
				while(rs.next()){
					//conta_coti++;
				BeanCotizacionInconclusa objR= new BeanCotizacionInconclusa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), Integer.parseInt(rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18),
						rs.getInt(19), rs.getInt(20), rs.getInt(21), rs.getString(22),rs.getString(23),rs.getDouble(24));
				objSCotInc.adicionar(objR);
				
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objA.cerrarConexion();
			
			for (int i = 0; i < objSCotInc.tamaño(); i++) {
				
				Object[] obj={objSCotInc.obtener(i).getNum_item(),objSCotInc.obtener(i).getCant(),
						objSCotInc.obtener(i).getUnimedida(),objSCotInc.obtener(i).getDesc_prod(),
						objSCotInc.obtener(i).getMarca(),objSCotInc.obtener(i).getPrecio_unit(),
						objSCotInc.obtener(i).getPrecio_total(),objSCotInc.obtener(i).getPrecio_costo(),
						objSCotInc.obtener(i).getCosto_total(),objSCotInc.obtener(i).getDiferencia(),
						objSCotInc.obtener(i).getFecha(),objSCotInc.obtener(i).getPorcentaje(),
						objSCotInc.obtener(i).getNom_prove(),objSCotInc.obtener(i).getPeso_prod(),
						objSCotInc.obtener(i).getTiempo_entrega()
				};
				modelo2.addRow(obj);
				/******************************************************************************************/
				cant=""+objSCotInc.obtener(i).getCant();
				BeanCoti_borrar objcotborrar=new BeanCoti_borrar(cant,
						objSCotInc.obtener(i).getUnimedida(),objSCotInc.obtener(i).getDesc_prod(),
						objSCotInc.obtener(i).getMarca(),objSCotInc.obtener(i).getPrecio_unit(),
						objSCotInc.obtener(i).getPrecio_total(),objSCotInc.obtener(i).getPrecio_costo(),
						objSCotInc.obtener(i).getCosto_total(),objSCotInc.obtener(i).getDiferencia(),
						objSCotInc.obtener(i).getFecha(),objSCotInc.obtener(i).getPorcentaje(),
						objSCotInc.obtener(i).getNom_prove(),objSCotInc.obtener(i).getPeso_prod(),
						objSCotInc.obtener(i).getTiempo_entrega());
				
				objCotizacionBorrar.adicionar(objcotborrar);
				
			}
		}
	 
	 /***********************************************************/
	 /***********************************************************/
	 
	 public void cargarCliCoti(){
		//int tipcomrep=cboTipoCom.getSelectedIndex(),
			//calrep=cboCalif.getSelectedIndex();
		    int cod_ven=objGlobal.COD_VEN;
			objCliCoti.eliminarTodo();
			int n=modelo2.getRowCount();
			//String NOM_CLI=txtCliente.getText();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			AccesoBD objA = new AccesoBD();
			objA.crearConexion();
			
			String sql="SELECT CLI.NOM_CLI,CLI.CONA_CLI,CLI.DIR_CLI,CLI.TEL1A_CLI,CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,TIPCLI.nom_tipo "+
			 "FROM tb_cliente CLI INNER JOIN tb_cotizacioninconclusa COTINC " +
			 "ON CLI.COD_CLI=COTINC.COD_CLI " +
			 "INNER JOIN tb_tipocliente TIPCLI "+
             "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
			 "WHERE COTINC.FECHA_COTI='"+fecha_coti+"' AND COTINC.COD_VEN='"+cod_ven+"' AND COTINC.IDE_COT_INC='"+ide_cot_inc+"';";
	
			ResultSet rs=objA.ejecutarConsulta(sql);
			try {
				
				while(rs.next()){
					//conta_coti++;
				BeanCliCoti objR= new BeanCliCoti(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				objCliCoti.adicionar(objR);
				
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objA.cerrarConexion();
			
			/*for (int i = 0; i < objSCotInc.tamaño(); i++) {
				
				Object[] obj={objSCotInc.obtener(i).getNum_item(),objSCotInc.obtener(i).getCant(),
						objSCotInc.obtener(i).getUnimedida(),objSCotInc.obtener(i).getDesc_prod(),
						objSCotInc.obtener(i).getMarca(),objSCotInc.obtener(i).getPrecio_unit(),
						objSCotInc.obtener(i).getPrecio_total(),objSCotInc.obtener(i).getPrecio_costo(),
						objSCotInc.obtener(i).getCosto_total(),objSCotInc.obtener(i).getDiferencia(),
						objSCotInc.obtener(i).getFecha(),objSCotInc.obtener(i).getPorcentaje(),
						objSCotInc.obtener(i).getNom_prove()
				};
				modelo2.addRow(obj);
				
			}*/
	 }
	 
	 /***********************************************************/
	 /***********************************************************/	 
	
	
   
	
	public void calcular(){
//String titulo2[]={"Cant","Und","Descripcion","Marca","P.Total $",
		//"Total $","Costo $","Total$","Dif. $","Fecha","%","Proveedor"};		
		double precioTsuma = 0,costoTsuma = 0,difTsuma = 0,
		precioTsumaSigv = 0,costoTsumaSigv = 0,difTsumaSigv = 0,
		precioTsumaCigv = 0,costoTsumaCigv = 0,difTsumaCigv = 0;
		double pesoTotal=0;
		int canti=0;
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")
			||modelo2.getValueAt(i, 11).equals("UND")){
				
			}else{
			canti=Integer.parseInt(""+modelo2.getValueAt(i, 1));
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
	
	public int guardar(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//NOTA :AL GUARDAR SE TIENE QUE DAR CUENTA QUE NO GUARDE CUANDO HAY ERROR
		int tam= arrayExcel.tamaño();
		int cod_cot=retornaUltimoCodCotizacion();
		ref=txtReferencia.getText();
		int op = 0;
		int numi=0;
		String guardarCotizacion = null;
		//String tiempo="";
		if(tam>0){
			for (int i = 0; i < arrayExcel.tamaño(); i++) {
			
			BeanExcel objExcel=arrayExcel.obtener(i);
			BeanVarios objVarios = objServletVarios.obtener(i);
			//tiempo=""+modelo2.getValueAt(i, 14);
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){
				
			}else{
				if(objExcel.getCod_cli()==0){
					System.out.println("ES CERO CAUSA");
				}else{
					numi=numi+1;
				//cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli,
                //cod_prodalt, cod_cam, can_cot, porga_cot, fec_cot, cod_ven, ide_cot
                /*cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, cod_cos, cod_prodalt, 
                * cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot*/
			guardarCotizacion="INSERT INTO tb_cotizacion(cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, " +
					" cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot,tiempo_entrega,est_emp,pesoCarr,est_envio) VALUES('"+cod_cot+"','"+numi+"','"+objVarios.getCodprove()
			+"','"+objVarios.getCodprod()+"','"+objVarios.getCodmar()+"','"+objVarios.getCod_umed()+"','"+objExcel.getCod_cli()+"','"+codigoFecha()+
			"','"+ref.toString().toUpperCase()+"','"+objExcel.getCant()+"','"+modelo2.getValueAt(i, 11)+"',curdate(),'"
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
				
		  }	
		   if(op==0){
			  objGUI.mostrarAviso("Hubo un Error22");
		   }else{
			 objGUI.mostrarAviso("Se ingreso su Cotizacion");
		   }
		
	  }
	   else{
			for (int i = 0; i < objSCotInc.tamaño(); i++) {
				
				BeanCotizacionInconclusa objExcel=objSCotInc.obtener(i);
				//BeanVarios objVarios = objServletVarios.obtener(i);
				
				if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
				||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){
					
				}else{
					if(objExcel.getCod_cli().equals("0")){
						System.out.println("ES CERO CAUSA");
					}else{
						numi=numi+1;
						System.out.println("Estos son los codigos que salen: "+objExcel.getCod_prove()+" /"+objExcel.getCod_prod()+" /"+objExcel.getCod_mar()+" /"
								+objExcel.getCod_umed()+"/"+objExcel.getCod_prod()); 
				
				guardarCotizacion="INSERT INTO tb_cotizacion(cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, " +
						" cod_cam, ref_cot, can_cot, porga_cot, fec_cot, cod_ven, esten_cot, estoc_cot, ide_cot,tiempo_entrega,est_emp,pesoCarr,est_envio) VALUES('"+cod_cot+"','"+numi+"','"+objExcel.getCod_prove()
				+"','"+objExcel.getCod_prod()+"','"+objExcel.getCod_mar()+"','"+objExcel.getCod_umed()+"','"+objExcel.getCod_cli()+"','"+codigoFecha()+
				"','"+ref.toString().toUpperCase()+"','"+objExcel.getCant()+"','"+modelo2.getValueAt(i, 11)+"',curdate(),'"
				+objGlobal.COD_VEN+"','"+0+"','"+1+"','"+0+"','"+modelo2.getValueAt(i, 14)+"','"+estado+"','0','0');"; 
				
					System.out.println(guardarCotizacion);
					try {
						 op= objAccesoBD.ejecutarActualizacion(guardarCotizacion);
					} catch (Exception e) {
						
						op=0;
						
					}finally{
						
						if(op==0){ 
							objGUI.mostrarAviso("HUBO UN ERROR333");
						}
					}
					
					}
				}
					
			}	
			if(op==0){
				objGUI.mostrarAviso("Hubo un Error444");
			}else{
				objGUI.mostrarAviso("Se ingreso su Cotizacion");
			}
		}
		objAccesoBD.cerrarConexion();
		return cod_cot;
		
	}
  
	/***********************************************
	/***********************************************/
	public void guardarTemp(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlobal.COD_VEN;
		int tam= arrayExcel.tamaño();
		int ide_cot_inc=retornaUltimoCodCotizacionInconclusa();
		//int cod_cot=retornaUltimoCodCotizacion();
		ref=txtReferencia.getText();
		int op = 0;
		int numi=0;
		String fechaActual=objFecha.fechaActual();
		//int est=1;

		if(tam>0){
			for (int i = 0; i < arrayExcel.tamaño(); i++) {
			
			BeanExcel objExcel=arrayExcel.obtener(i);
			BeanVarios objVarios=objServletVarios.obtener(i);
				if(objExcel.getCod_cli()==0){
					System.out.println("ES CERO CAUSA");
				}else{
					numi=numi+1;
			 String insertarPregunta="INSERT INTO tb_cotizacionINCONCLUSA(ide_cot_inc,num_item,cod_ven,cod_cli,fecha_coti, cantidad," +
			 	" unimedida, desc_prod, marca, precio_unit, " +
				" precio_total, precio_costo, costo_total, diferencia, fecha, porcentaje, nom_prove,cod_prove,cod_prod,cod_mar,cod_umed,peso_prod,tiempo_entrega,est_emp,costo) VALUES('"+ide_cot_inc+"','"+numi+"','"+codven
				+"','"+objExcel.getCod_cli()+"','"+fechaActual+"','"+objExcel.getCant()+"','"+modelo2.getValueAt(i, 2)+"','"+modelo2.getValueAt(i, 3)+"','"+modelo2.getValueAt(i, 4)+
				"','"+modelo2.getValueAt(i, 5)+"','"+modelo2.getValueAt(i, 6)+"','"+modelo2.getValueAt(i, 7)+"','"
				+modelo2.getValueAt(i, 8)+"','"+modelo2.getValueAt(i, 9)+"','"+modelo2.getValueAt(i, 10)+"','"+modelo2.getValueAt(i, 11)+"','"+modelo2.getValueAt(i, 12)+"','"+objServletVarios.obtener(i).getCodprove()+
				"','"+objServletVarios.obtener(i).getCodprod()+"','"+objServletVarios.obtener(i).getCodmar()+"','"+objServletVarios.obtener(i).getCod_umed() +
				"','"+modelo2.getValueAt(i, 13)+"','"+modelo2.getValueAt(i, 14)+"','"+estado+"','"+objVarios.getCostoreal()+"');";
			System.out.println(insertarPregunta);

			try {
				 op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			} catch (Exception e) {
				// TODO: handle exception
				op=0;
				//System.out.println("ESTO NO KISO GUARDAR:"+guardarCotizacion);
			}finally{
				if(op==0){ 
					objGUI.mostrarAviso("HUBO UN ERROR");
					
				}
			}
			
			}
			
		}	
	if(op==0){
		objGUI.mostrarAviso("Debe de buscar un cliente");
	}else{
		objGUI.mostrarAviso("Se guardo temporalmente su Cotizacion");
	}
	
	}
	objAccesoBD.cerrarConexion();
	}
   /*****************************************************/
	void pasarExcel(int cod){
		int item=-1;
		if(objServletVarios.tamaño()!=0){
			for (int i = 0; i < arrayExcel.tamaño(); i++) {
				

			BeanExcel objExcel=arrayExcel.obtener(i);
			BeanVarios objVarios = objServletVarios.obtener(i);
			if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
			||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){		
			}else{
				item=item+1;
				arregloCadenas[0]=objExcel.getSeñor().toString().toUpperCase();
				arregloCadenas[1]=objExcel.getAtencion().toString().toUpperCase();
				arregloCadenas[2]=objExcel.getDireccion().toString().toUpperCase();
				String rpm=objExcel.getRpm(),nex=objExcel.getNextel(),rpmnextel="";
				if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
					rpmnextel=" NEX:"+nex;
				}else{
					rpmnextel=" RPM:"+rpm;
				}
				arregloCadenas[3]="TEL:"+objExcel.getTelefono()+rpmnextel+" CEL:"+objExcel.getCel()+" E-MAIL:"+objExcel.getMail();
				arregloCadenas[4]=objGlobal.COD_VEN;
				arregloCadenas[5]=objExcel.getTipocliente().toString().toUpperCase();
				arregloCadenas[6]=objExcel.getCod_cli();
				arregloCadenas[7]="COTIZACION Nº"+cod;
				arregloCadenas[8]=objFecha.fechaActual();
				arregloCadenas[9]=Double.parseDouble(""+tipoCambioVenta());
				arregloCadenas[10]=ref.toString().toUpperCase();
			    for (int j = 0; j < 10; j++) {
					if(j==0){
					arregloObjetos[item][j]=Integer.parseInt(""+objExcel.getCant());	
					}else if(j==1){
					arregloObjetos[item][j]=objVarios.getUmed().toString();	
					}else if(j==2){
					arregloObjetos[item][j]=objVarios.getProducto().toString().toUpperCase();	
					}else if(j==3){
					arregloObjetos[item][j]=objVarios.getMarca().toString().toUpperCase();		
					}else if(j==4){
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 5));		
					}else if(j==5){
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 7));			
					}else if(j==6){
					arregloObjetos[item][j]=modelo2.getValueAt(i, 10).toString();	
					}else if(j==7){
					arregloObjetos[item][j]=modelo2.getValueAt(i, 12).toString();	
					}else if(j==8){
					arregloObjetos[item][j]=""+objVarios.getCodprove();	
					}else{
					arregloObjetos[item][j]=modelo2.getValueAt(i, 13).toString();		
					}
					
				}
			}
		}
	  }else{
		  for (int i = 0; i < objSCotInc.tamaño(); i++) {
				BeanCotizacionInconclusa objExcel=objSCotInc.obtener(i);
				BeanCliCoti objclinc = objCliCoti.obtener(i);
				if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
				||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){		
				}else{
					item=item+1;
					arregloCadenas[0]=objclinc.getSeñor().toString().toUpperCase();
					arregloCadenas[1]=objclinc.getAtencion().toString().toUpperCase();
					arregloCadenas[2]=objclinc.getDireccion().toString().toUpperCase();
					String rpm=objclinc.getRpm(),nex=objclinc.getNextel(),rpmnextel=objclinc.getNextel();
					if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
						rpmnextel=" NEX:"+nex;
					}else{
						rpmnextel=" RPM:"+rpm;
					}
					arregloCadenas[3]="TEL:"+objclinc.getTelefono()+rpmnextel+" CEL:"+objclinc.getCel()+" E-MAIL:"+objclinc.getMail();
					arregloCadenas[4]=objGlobal.COD_VEN;
					arregloCadenas[5]=objclinc.getTipocliente().toString().toUpperCase();
					arregloCadenas[6]=objExcel.getCod_cli();
					arregloCadenas[7]="COTIZACION Nº"+cod;
					arregloCadenas[8]=objFecha.fechaActual();
					arregloCadenas[9]=Double.parseDouble(""+tipoCambioVenta());
					arregloCadenas[10]=ref.toString().toUpperCase();
				    for (int j = 0; j < 10; j++) {
						if(j==0){
						arregloObjetos[item][j]=Integer.parseInt(""+objExcel.getCant());	
						}else if(j==1){
						arregloObjetos[item][j]=objExcel.getUnimedida().toString();	
						}else if(j==2){
						arregloObjetos[item][j]=objExcel.getDesc_prod().toString().toUpperCase();	
						}else if(j==3){
						arregloObjetos[item][j]=objExcel.getMarca().toString().toUpperCase();		
						}else if(j==4){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 5));		
						}else if(j==5){
						arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 7));			
						}else if(j==6){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 10).toString();	
						}else if(j==7){
						arregloObjetos[item][j]=modelo2.getValueAt(i, 12).toString();	
						}else if(j==8){
						arregloObjetos[item][j]=""+objExcel.getCod_prove();		
					    }else{
						arregloObjetos[item][j]=modelo2.getValueAt(i, 13).toString();	
						}
						
					}
				}
			}
	  }
		
	}
	public int tamañodelExcel() {
			 int tam=arrayExcel.tamaño();
			 int item=0;
			for (int i = 0; i < arrayExcel.tamaño(); i++) {
				BeanExcel objExcel=arrayExcel.obtener(i);
				BeanVarios objVarios = objServletVarios.obtener(i);
				if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
				||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){	
					
				}
				else{
					item=item+1;	
				
				}
		}

			return item;
		}
	
	public int tamañodelexcel2(){
		 
		   int tam=objSCotInc.tamaño();
	       int item=0;
	    for (int i = 0; i < objSCotInc.tamaño(); i++) {
		BeanCotizacionInconclusa objExcel=objSCotInc.obtener(i);
		//BeanVarios objVarios = objServletVarios.obtener(i);
		if(modelo2.getValueAt(i, 11).equals("ERROR 0")||modelo2.getValueAt(i, 11).equals("ERROR 1")
		||modelo2.getValueAt(i, 11).equals("ERROR 2")||modelo2.getValueAt(i, 11).equals("ERROR 2.2")||modelo2.getValueAt(i, 11).equals("UND")){	
			
		}
		else{
			item=item+1;	
		}
}

	return item;
	}
	public void eliminarCotInc(){
		int cod_ven=objGlobal.COD_VEN;
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		//String codigorep=objS.equals(codrep);
		/*(COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP) */
		String sql="DELETE FROM tb_cotizacioninconclusa "+
                   "WHERE IDE_COT_INC='"+ide_cot_inc+"' AND COD_VEN='"+cod_ven+"';";
		//" AND COD_MAR='"+COD_MAR+"'  AND cod_umed='"+COD_UMED+"' ;";
		System.out.println(sql);

		
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			//objGUI.mostrarAviso("Debe seleccioar un reporte");
		}else{
			//objGUI.mostrarAviso("Se Elimino Correctamente ");
			
		}
		objAccesoBD.cerrarConexion();	
		
	}
	
	public void eliminarCotInc2(){
		int cod_ven=objGlobal.COD_VEN;
		int id=retornaUltimoCodCotizacionInconclusa2();
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		//String codigorep=objS.equals(codrep);
		/*(COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP) */
		String sql="DELETE FROM tb_cotizacioninconclusa "+
                   "WHERE IDE_COT_INC='"+id+"' AND COD_VEN='"+cod_ven+"';";
		//" AND COD_MAR='"+COD_MAR+"'  AND cod_umed='"+COD_UMED+"' ;";
		System.out.println(sql);

		
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			//objGUI.mostrarAviso("Debe seleccioar un reporte");
		}else{
			//objGUI.mostrarAviso("Se Elimino Correctamente ");
			
		}
		objAccesoBD.cerrarConexion();	
		
	}
	
	public void guardarprod(int num){
		
		
		int cod_prueba=num;
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		
		for (int i = 0; i < objSGuarProd.tamaño(); i++) {
			
			BeanGuardarProdNoEncontrados objCotVarios = objSGuarProd.obtener(i);
			if(objCotVarios.getCod_rubro().equals("0")){
				//nada
			}else{
				String sql="INSERT INTO tb_prueba(cod_prueba,cod_rubro,nom_rubro,nom_prod,uni_prod,cant_prod,est_prueba) " +
				"VALUES('"+cod_prueba+
						"','"+objCotVarios.getCod_rubro()+
						"','"+objCotVarios.getNom_rubro()+"','"
						+objCotVarios.getNom_prod()+"','"+objCotVarios.getUnidad()+"','"+objCotVarios.getCantidad()+"','ACTIVADO');";
						System.out.println(sql);
				
						
						int op=objAccesoBD.ejecutarActualizacion(sql);
						if(op==0){
							//objGUI.mostrarAviso("Debe seleccioar un reporte");
						}else{
							System.out.println("Se Ingreso los prod no existentes Correctamente ");
							
						}
			}
			
			
			}
		objAccesoBD.cerrarConexion();
		objSGuarProd.eliminarTodo();
		
	}
	/****************************************************************************************************/
    public void listarProdNoEncontrados(){
		
    	int cod_prueba=retornaUltimoCodProdInexistente2();
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
			
		String sql="select cod_rubro,nom_rubro,nom_prod,uni_prod,cant_prod from tb_prueba "+
                   " where est_prueba='ACTIVADO' " +
                   " order by (cod_rubro) asc;";   
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
				BeanGuardarProdNoEncontrados objR= new BeanGuardarProdNoEncontrados(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5));
				objSGuarProd.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
	}
    /****************************************************************************************************/
    public void listarProdNoEncontradosPorRubro(String cad){
		
    	objSGuarProd1.eliminarTodo();
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
			
		String sql="select cod_rubro,nom_rubro,nom_prod,uni_prod,cant_prod from tb_prueba"+
                   " where nom_rubro='"+cad+"' and est_prueba='ACTIVADO';";   
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
				conta1=conta1+1;
				BeanGuardarProdNoEncontrados1 objR= new BeanGuardarProdNoEncontrados1(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5));
				objSGuarProd1.adicionar(objR);
			
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
	}
    /****************************************************************************************************/
    public int contarProdNoEncontrados(){
		
    	int cont=0;
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		
		String sql="select cod_rubro,nom_rubro,nom_prod,uni_prod,cant_prod from tb_prueba" +
				   " where est_prueba='ACTIVADO' "+
                   " group by cod_rubro;";   
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
				cont++;
			
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
	
		return cont;
	}
	/******************************************************************************************************/
     public boolean pasarProdExcel() throws FileNotFoundException, IOException{
		                                                         
		 boolean devuelve=true;
		 //String fecR=objFecha.convrtidorFec2(btnFecha2.getDate());
		 BeanGuardarProdNoEncontrados1 objRep;
		 int tam=objSGuarProd.tamaño();
		 int item=-1;
		 int cant=0,cantletras=0;;
		 if(tam>0){
			 for (int i = 0; i < objSGuarProd1.tamaño(); i++) {
			 
				 objRep=objSGuarProd1.obtener(i);
				
		         arregloCadenas1[0]="SOLICITUD COTIZACION";
		
		          item=item+1;
		
			 for (int j = 0; j < 4; j++) {
		                
					    if(j==0){
						arregloObjetos2[item][j]=objRep.getCantidad().toUpperCase();	
						}else if(j==1){
						arregloObjetos2[item][j]=objRep.getUnidad().toUpperCase();	
						}else if(j==2){
						arregloObjetos2[item][j]=objRep.getNom_prod().toUpperCase();
						}else {
						arregloObjetos2[item][j]=objRep.getNom_rubro().toUpperCase();	
						}
		    }
		 }
       }
        
       return devuelve;		
    }

    /*********************************************************************************************************/
	public int retornaUltimoCodProdInexistente(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT max(cod_prueba) FROM TB_prueba";
		

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
	/****************************************************************************************************/
	public int tamañoProdExcel() {
		 int item=0;
		for (int i = 0; i < objSGuarProd.tamaño(); i++) 
			item=item+1;	
		return item;
	}
	/****************************************************************************************************/
	public int retornaUltimoCodProdInexistente2(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String maxCodPregunta="SELECT max(cod_prueba) FROM TB_prueba ";
		

		ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
		try {
		
			int cod = 0;
			while(rs.next()){
				
				if(rs.getString(1)==null){
					cod=1;
				}else{
				cod= Integer.parseInt(rs.getString(1));
				cod=cod+0;
				return cod;
				}
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		return 0;
	 } 
	/****************************************************************************************************/
	public int cantPalabras(String cad){
		
		String cad1="";
		int cont=0;
		
		for(int i=0;i<cad.length();i++){
			cad1=""+cad.trim().charAt(i);
			
			if(cad1.equals("")){
				//NADA
			}else{
				cont++;
			}
		}
		
		
		return cont;
	}
	/****************************************************************************************************/
    public String palabrasSinespacio(String cad){
		
		String cad1="",cad2="";
		int cont=0;
		
		for(int i=0;i<cad.length();i++){
			cad1=""+cad.trim().charAt(i);
			
			if(cad1.equals(" ")){
				cad2+="_";
			}else{
				cad2+=cad1;
			}
		}
		
		
		return cad2;
	}
	/****************************************************************************************************/
    public void eliminarProdInex(){
    	
    	int cod_prueba=retornaUltimoCodProdInexistente2();
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="UPDATE tb_prueba set est_prueba='DESACTIVADO' "+
                    " WHERE cod_prueba ='"+cod_prueba+"';";
		System.out.println(sql);

		
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			//objGUI.mostrarAviso("Debe seleccioar un reporte");
		}else{
			//objGUI.mostrarAviso("Se Elimino Correctamente ");
			
		}
		objAccesoBD.cerrarConexion();	
		
	}
    /****************************************************************************************************/
    public void listarProveedoresCorreo(String cod){
		
    	objSProvCorreo.eliminarTodo();
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
			
		String sql="SELECT  PROVE.COD_PROVE,PRU.cod_rubro,PROVE.PER_PROVE, PROVE.SEX_PROVE,PROVE.MAIL_PROVE "+
				   "FROM tb_rubro RUB "+
				   "INNER JOIN TB_PRUEBA PRU "+
				   "ON PRU.cod_rubro = RUB.COD_RUBRO "+
			       "INNER JOIN TB_PROVERUBMAR PROVERUB "+
			       "ON PROVERUB.cod_rubro = RUB.COD_RUBRO "+
			       "INNER JOIN tb_proveedor PROVE "+
			       "ON PROVERUB.cod_prove = PROVE.COD_PROVE "+
				   "WHERE PRU.est_prueba='ACTIVADO' AND pru.cod_rubro='"+cod+"' "+
			       "group by prove.COD_PROVE;";   
		
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			
			while(rs.next()){
				
				BeanProveCorreo objPC= new BeanProveCorreo(rs.getString(1), rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5));
				objSProvCorreo.adicionar(objPC);
			
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		objA.cerrarConexion();
		
	}
    /****************************************************************************************************/
     public void ingresarMailsAutoProve(String cod_prov){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlobal.COD_VEN;
		//String codi_clie=objEnvioCot.codigocliente;
		String cod_ref="CP1";
		String newfecha2="";
		int est_mail=0,est_mail2=0;
	    newfecha2="(DATE_ADD(now(), INTERVAL 1 hour)),";
	
			 String insertarPregunta="INSERT INTO tb_enviomailsprove (COD_REF, FEC_PEMAIL, FEC_SEMAIL, COD_VEN, COD_PROVE, EST_MAIL, EST_MAIL2)" +
		    		" VALUES('"+cod_ref+"',DATE_ADD(now(), INTERVAL 10 minute)," +newfecha2+
		    		" '"+codven+"','"+cod_prov+"','"+est_mail+"','"+est_mail2+"');";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			
				if(op==0){
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			    }	
			    else{
				  System.out.println("Se ingreso Correctamente los MailsProvee "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
			   }
				objAccesoBD.cerrarConexion();
		
	}
    /****************************************************************************************************/
     public void tiempoEntrega(){
    	 int fila = tblLista.getSelectedRow();
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
	        	 //x--->no cogio nada
	         }else{
	        String tiempo=objCamTiemEntrega.txtCantidad.getText();
	        System.out.println("K TIEMPO LE PASA?:"+tiempo);
	         //BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(fila);
	         System.out.println("ES LA FILA :"+fila);
	         modelo2.setValueAt(tiempo, fila, 14);
	         //objCotVarios.setTiempoentrega(tiempo);
	      
	         //calcularParte(fila);
	         //calcular(); 
	         }
     }
 	public void carga_inmediata_excel()
 	{
 		abrirArchivo();	
 		reescribir();
 		buscarDetalles();
 		calcular();
 	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBuscarCliente){
			objBuscarCliAut= new BuscarClienteAut();
			objBuscarCliAut.txtCliente.setText(txtSeñores.getText());
			String[] botones = {"Aceptar"};//Esto es el nombre
	         int showOptionDialog = JOptionPane.showOptionDialog(
	     		   this,                             			
	     		  objBuscarCliAut,                                    
	     		  "Buscar Cliente", 		
	     		    0,          						        
	     		   -1,            								
	     		   null,                                       
	     		  botones,
	     		  "Cerrar"
	     		                                  	
	     	);
	         try {
				int tam=arrayExcel.tamaño();
				if(tam>0){for (int i = 0; i < arrayExcel.tamaño(); i++) {
					
				BeanExcel objExcel=arrayExcel.obtener(i);
				objExcel.setCod_cli(Integer.parseInt(objBuscarCliAut.codcli));
				objExcel.setSeñor(objBuscarCliAut.nomcli);
				objExcel.setDireccion(objBuscarCliAut.lugcli);
				objExcel.setAtencion(objBuscarCliAut.conacli);
				objExcel.setTelefono(objBuscarCliAut.tel1acli);
				objExcel.setRpm(objBuscarCliAut.rpmacli);
				objExcel.setCel(objBuscarCliAut.celacli);
				objExcel.setMail(objBuscarCliAut.mailacli);
				objExcel.setTipocliente(objBuscarCliAut.tipcli);
							
				}	
				}
				
				BeanExcel objExcel=arrayExcel.obtener(0);
				txtSeñores.setText(objExcel.getSeñor());
				txtSeñores2.setText(objExcel.getSeñor());
				txtAtencion2.setText(objExcel.getAtencion());
				txtAtencion2.setText(objExcel.getAtencion());
			} catch (Exception e2) {
				// TODO: handle exception
			}
	        
		}
        if(e.getSource()==btnGuardar){
			
        	if(txtReferencia.getText().equals("")){
        		objGUI.mostrarAviso("Debe Escribir la Referencia");
        	}
        	else{
        	
        	int cod=guardar();
			int tam=tamañodelExcel();
			int tamaño=tamañodelexcel2();
			
			if(objServletVarios.tamaño()!=0){
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
			
			else{
				System.out.println("Si entra a guardar pero hay null pointer exception   "+cod);
				arregloCadenas= new Object[11];
			    arregloObjetos= new Object[tamaño][10];
			//este es para ver elk tamañp
			pasarExcel(cod);
			eliminarCotInc();
			
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
		if(e.getSource()==btnBuscar){
			
			abrirArchivo();	
			reescribir();
			buscarDetalles();
			calcular();
			//zz*/
		}
		if(e.getSource()==btnGuardarTemp){
			estGTemp=1;
			guardarTemp();
		}
		
		if(e.getSource()== btnCargar ){
			
			if(objServletVarios.tamaño()==0){
				//cargarCotizacionInc();
				
			objCargarCotInc= new CargarCotInc();
			int est=0;
			//objBuscarCliAut.txtCliente.setText(txtSeñores.getText());
			String[] botones = {"Aceptar"};//Esto es el nombre
	         int showOptionDialog = JOptionPane.showOptionDialog(
	     		   this,                             			
	     		  objCargarCotInc,                                    
	     		   "Cargar Cotizacion Inconclusa", 		
	     		    0,          						        
	     		   -1,            								
	     		   null,                                       
	     		  botones,
	     		   "Cerrar"
	     		                                  	
	     	);
	         try {
				ide_cot_inc=objCargarCotInc.ide_cot_inc;
				nom_cli=objCargarCotInc.nom_cli;
				fecha_coti=objCargarCotInc.fec_coti;
				cona_cli=objCargarCotInc.cona_cli;
				est=objCargarCotInc.est_emp;
				txtSeñores.setText(nom_cli);
				txtSeñores2.setText(nom_cli);
				txtAtencion2.setText(cona_cli);
				if(est==1){
					rdbCel.setSelected(true);
					estado=1;
				}else if(est==2){
					rdbCye.setSelected(true);
					estado=2;
					
				}
				rdbCel.setEnabled(false);
				rdbCye.setEnabled(false);
				cargarCliCoti();
				cargarCotizacionInc();
				calcular();
				
				//System.out.println("qqqqqqqqq: "+ide_cot_inc);
			} catch (Exception e2) {
				// TODO: handle exceptions
			}
			}
			
	    
		}

		if(e.getSource()==btngprod){
			
			NuevoCotizadorPorParametro objtrans=new NuevoCotizadorPorParametro();
			
			int codi=retornaUltimoCodProdInexistente();
			int codi1=retornaUltimoCodProdInexistente2();

			//System.out.println("ESTE ES EL CODIGO: "+codi);		
			est=objMenuP.estado;
		    contar=objMenuP.conta;
		    num=objMenuP.num;
		    //System.out.println("nnnnnnnnnnnnnnnn: "+est);
		    // System.out.println("FFFFFFFFF:"+num);
		    
			if(est==1){
				//System.out.println("WWWWWWssssss:"+contar);
				if(contar>=1){
					guardarprod(codi1+contar-num);
				    System.out.println("estado 1");
				}

			}else{
				//System.out.println("WWWWWWqqqqqq:"+contar);
				if(contar>=1){
					guardarprod(codi1+contar-num);
					System.out.println("estado 0");
				}
				
			}
			
			listarProdNoEncontrados();
		
			if(tamañoProdExcel()!=0){
				
				
				boolean valor=true;
				int tam=0;//ESTE ES EL TAMAÑO REAL
				int tamPC=0;
				boolean devuelve = false;
				String numCoti=""+retornaUltimoCodProdInexistente2(),
				cod_rubro="";
				int cont=0,cantLetras=0,
				cantLetras1=0;
            	
			
				for(int i = 0; i < contarProdNoEncontrados(); i++){
				try {
					
					cont++;
					BeanGuardarProdNoEncontrados objProd=objSGuarProd.obtener(i+conta1);
					cantLetras1=cantPalabras(objProd.getNom_rubro());
					
					 if(cont==1){
						 
						 cantLetras=cantPalabras(objProd.getNom_rubro());
						 if(cantLetras==cantLetras1){
							 conta1=conta1-1;
							 listarProdNoEncontradosPorRubro(objProd.getNom_rubro());
							 listarProveedoresCorreo(objProd.getCod_rubro());
							 tamPC=objSProvCorreo.tamaño();
							 /**********************************************************************************************/		 
							 tam=objSGuarProd1.tamaño();
							    arregloCadenas1= new Object[1];
							    arregloObjetos2= new Object[tam][4];
							    devuelve=pasarProdExcel();
							    objProdExcel= new PasarProdExcel();
								objProdExcel.crearExcel(arregloCadenas1,arregloObjetos2,numCoti,palabrasSinespacio(objProd.getNom_rubro()));
								rutaGlobal=objProdExcel.fileGlobal;
							    valor=true;
							    
							    for(int j=0;j<tamPC;j++){
									 BeanProveCorreo objPc=objSProvCorreo.obtener(j);
									 ingresarMailsAutoProve(objPc.getCod_prove());
									 sexprove=objPc.getSex_prove();
									 nomprove=objPc.getPer_prove();
									 correo=objPc.getMail_prove();
									 objMailProv=null;
									 objMailProv=new EnvioMailsAutoProve();
									 objMailProv.setVisible(false);
									 objMailProv.envio1();
									 System.out.println("CORREO PROVE: "+objPc.getPer_prove()+"/ "+objPc.getMail_prove());
								 }
						 }
					 }else{
						 
						 conta1=conta1-1;
						 if(cantLetras==cantLetras1){
							 listarProdNoEncontradosPorRubro(objProd.getNom_rubro());
							 listarProveedoresCorreo(objProd.getCod_rubro());
							 tamPC=objSProvCorreo.tamaño();
							 /**********************************************************************************************/
							 tam=objSGuarProd1.tamaño();
							    arregloCadenas1= new Object[1];
							    arregloObjetos2= new Object[tam][4];
							    devuelve=pasarProdExcel();
							    objProdExcel= new PasarProdExcel();
								objProdExcel.crearExcel(arregloCadenas1,arregloObjetos2,numCoti,palabrasSinespacio(objProd.getNom_rubro()));
								rutaGlobal=objProdExcel.fileGlobal;
							    valor=true;
							    
							    for(int j=0;j<tamPC;j++){
									 BeanProveCorreo objPc=objSProvCorreo.obtener(j);
									 ingresarMailsAutoProve(objPc.getCod_prove());
									 sexprove=objPc.getSex_prove();
									 nomprove=objPc.getPer_prove();
									 correo=objPc.getMail_prove();
									 objMailProv=null;
									 objMailProv=new EnvioMailsAutoProve();
									 objMailProv.setVisible(false);
									 objMailProv.envio1();
									 System.out.println("CORREO PROVE: "+objPc.getPer_prove()+"/ "+objPc.getMail_prove());
								 }
						 }
						 else{
							
							 cantLetras=cantPalabras(objProd.getNom_rubro());
							 listarProdNoEncontradosPorRubro(objProd.getNom_rubro());
							 listarProveedoresCorreo(objProd.getCod_rubro());
							 tamPC=objSProvCorreo.tamaño();
							 /*************************************************************************************************/
							 tam=objSGuarProd1.tamaño();
							    arregloCadenas1= new Object[1];
							    arregloObjetos2= new Object[tam][4];
							    devuelve=pasarProdExcel();
							    objProdExcel= new PasarProdExcel();
								objProdExcel.crearExcel(arregloCadenas1,arregloObjetos2,numCoti,palabrasSinespacio(objProd.getNom_rubro()));
								rutaGlobal=objProdExcel.fileGlobal;
							    valor=true;
							    
							    for(int j=0;j<tamPC;j++){
									 BeanProveCorreo objPc=objSProvCorreo.obtener(j);
									 ingresarMailsAutoProve(objPc.getCod_prove());
									 sexprove=objPc.getSex_prove();
									 nomprove=objPc.getPer_prove();
									 correo=objPc.getMail_prove();
									 objMailProv=null;
									 objMailProv=new EnvioMailsAutoProve();
									 objMailProv.setVisible(false);
									 objMailProv.envio1();
									 System.out.println("CORREO PROVE: "+objPc.getPer_prove()+"/ "+objPc.getMail_prove());
								}
						 }
						
					 }			 
				
				} catch (FileNotFoundException e1) {
					valor=false;
					e1.printStackTrace();
					System.out.println("ERRORRRRRRRRRRRRRRR");
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
			 }
				objSGuarProd.eliminarTodo();
			}
			conta1=0;
			eliminarProdInex();
			
			
		}
		
		if(e.getSource()==btnBorrar){
			
			try {
				int tam= arrayExcel.tamaño();
				int fila1 =tblLista.getSelectedRow();
				
				int contM=0;
				System.out.println("ESTE ES EL N DE FILA PARA BORRAR:"+fila1);
				int n=modelo2.getRowCount();
				for (int fila=0; fila<n; fila++)
				modelo2.removeRow(0);
				if(tam>0){
					objCotizacionBorrar.eliminar(fila1);
					arrayExcel.eliminar(fila1);
					objServletVarios.eliminar(fila1);
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
				}else{
					objCotizacionBorrar.eliminar(fila1);
					objSCotInc.eliminar(fila1);
					for (int i = 0; i < objCotizacionBorrar.tamaño(); i++) {
						contM=contM+1;
						
						BeanCoti_borrar objcotborrar=objCotizacionBorrar.obtener(i) ;
						
						Object[] array={Integer.parseInt(""+contM), objcotborrar.getCant(),objcotborrar.getUnd(),
								objcotborrar.getDesc(),objcotborrar.getMarca(),objcotborrar.getPunit(),objcotborrar.getPtotal(),
								objcotborrar.getPcosto(),objcotborrar.getCtotal(),objcotborrar.getDif(),objcotborrar.getFecha(),
								objcotborrar.getPorc(),objcotborrar.getProv(),objcotborrar.getPestotal(),objcotborrar.getTiempo_entrega()};
						modelo2.addRow(array);
					 
					}
					calcular();
				}
			} catch (Exception e2) {
				objGUI.mostrarAviso("Debe Seleccionar Primero un Item");
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
	/*********************************************************************************************************************************
	 * *******************************************************************************************************************************
	 */
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==1){
				
				int fila = tblLista.getSelectedRow();
				 String Punit=""+modelo2.getValueAt(fila, 5);
				
				 if(objServletVarios.tamaño()!=0){
					 
					 if(Punit.equals("ERROR 0") || Punit.equals("ERROR 1")
								|| Punit.equals("ERROR 2") || Punit.equals("ERROR 2.2")){
							//System.out.println("NADAAAA");
						}else{
							objCambiarCant = new CambiarCant();
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
					       
					        BeanExcel objExcel=arrayExcel.obtener(fila);
					        System.out.println("ES LA FILA :"+fila);
					        
					        modelo2.setValueAt(Integer.parseInt(cant), fila, 1);
					        objExcel.setCant(Integer.parseInt(cant));
					        calcularParte1(fila);
					        calcular();
					        
					       }
						}
				 }else{
					 
					 if(Punit.equals("ERROR 0") || Punit.equals("ERROR 1")
								|| Punit.equals("ERROR 2") || Punit.equals("ERROR 2.2")){
							//System.out.println("NADAAAA");
						}else{
							objCambiarCant = new CambiarCant();
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
					       
					       // BeanExcel objExcel=arrayExcel.obtener(fila);
					        BeanCotizacionInconclusa objCotInc=objSCotInc.obtener(fila);
					        System.out.println("ES LA FILA :"+fila);
					        
					        modelo2.setValueAt(Integer.parseInt(cant), fila, 1);
					        objCotInc.setCant(Integer.parseInt(cant));
					        calcularParte2(fila);
					        calcular();
					        
					       }
						}
					 
				 }
				 
				
				
			}
			/************************************************************************************************************/
			
			
			
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==3){
				
				//wweerww
				
				int fila = tblLista.getSelectedRow();
				
						
				int cod_ven=objGlobal.COD_VEN;
				int ide_cot=retornaUltimoCodCotizacionInconclusa2();
				String tiempoEntrega=""+modelo2.getValueAt(fila, 14);
				tiempoEntrega=tiempoEntrega.trim();
				/* if(estGTemp==0){
						ide_cot=retornaUltimoCodCotizacionInconclusa();
					}
					else{
						ide_cot=retornaUltimoCodCotizacionInconclusa2();
					}
			    */
			    String fech=objFecha.fechaActual();
			    
			    //obtengo la cantidad del producto
			    String cant=""+modelo2.getValueAt(fila, 1);
				
			    
				nombreProd=(String) modelo2.getValueAt(fila, 3);
				cantidad=Integer.parseInt(cant.trim());
				
				BuscarProductoCotizacion  objBuscarProdCot = new BuscarProductoCotizacion(objMenuP);
				
				objBuscarProdCot.setVisible(true);
				objBuscarProdCot.pack();  // para darle tamaño automático a la ventana.
				
				
			         if(objBuscarProdCot.COD_PROD==null){
			        //ACA SE GUARDARAN LOS PRODUCTOS QUE NO EXISTAN EN LA BD PARA LUEGO ENVIARLOS
			        //A LOS PROVEEDORES POR CORREOS	 
			        try {
			        	
			        	for (int i = 0; i < 1; i++){
			        		 BeanGuardarProdNoEncontrados objVar=new BeanGuardarProdNoEncontrados(
			        				 "","","","","");
			        							 
			        					objSGuarProd.adicionar(objVar);
			        	 }
			        	 
			         String und="",canti="",cod_rubro="",nom_prod="",nom_rubro="",codi_rub="";
			         
			         canti=""+ modelo2.getValueAt(fila, 1);
			         und=""+  modelo2.getValueAt(fila, 2);
			
			         cod_rubro=objBuscarProdCot.COD_RUBRO;
			         nom_rubro=objBuscarProdCot.NOM_RUBRO;
			         nom_prod=objBuscarProdCot.NOM_PRODUCTO;
			         System.out.println("AAA: "+cod_rubro);
			         System.out.println("uni:"+und+"  "+"canti:"+canti);
			         
			        if(cod_rubro==null || cod_rubro.equals("")){
			        	codi_rub="0";
			        }else{
			        	codi_rub=cod_rubro;
			        }
			        //System.out.println("DDD: "+codi_rub);
			        	   BeanGuardarProdNoEncontrados objProd=objSGuarProd.obtener(objSGuarProd.tamaño()-1);
			        	    
			        	    objProd.setCod_rubro(codi_rub);
						    objProd.setNom_rubro(nom_rubro);
						    objProd.setNom_prod(nom_prod);	 
						    objProd.setUnidad(und);
						    objProd.setCantidad(canti);
						         
						    System.out.println("ESTO ES LO QUE SE OBTIENE :"+cod_rubro+" / "+nom_rubro+" / "+nom_prod+" / "+und+" / "+canti);
					        verificar=1;
			         
			        
			         
			         
					} catch (Exception e2) {
						System.out.println("NO COGIO NADA");
						verificar=0;
					} 
			           
			         
			       }else{
			        
			       
			         COD_PROD=objBuscarProdCot.COD_PROD;
			         System.out.println("ESTE ES EL PRIMER CODIGO DEL PRODUCTO:"+COD_PROD);
			         NOM_PROD=objBuscarProdCot.NOM_PROD;
			         COSTE=objBuscarProdCot.COSTE;
			         COD_MAR=objBuscarProdCot.COD_MAR;
			         MARCA=objBuscarProdCot.MARCA;
			         COD_UMED=objBuscarProdCot.COD_UMED;
			         UMED=objBuscarProdCot.UMED;
			         FECHA=objBuscarProdCot.FECHA;
			         COD_PROVEE=objBuscarProdCot.COD_PROVEE;
			         PROVEEDOR=objBuscarProdCot.PROVEEDOR;
			         COD_PRODALT=objBuscarProdCot.COD_PROD1;
			         NOM_PRODALT=objBuscarProdCot.NOM_PROD1;
			         PESO_PRODUCTO=objBuscarProdCot.PESO_PROD;
                     
			         
			         System.out.println("ESTO ES LO QUE VIENE DESPUES DE BUSCAR 1:"
			        		 +COD_PROD+","+NOM_PROD+","+COSTE+","+MARCA+","+UMED+","+FECHA+","+COD_PROVEE
			        		 +","+PROVEEDOR+","+COD_PRODALT);
			         System.out.println("TAMAÑO:"+objServletVarios.tamaño());
			         if(objServletVarios.tamaño()!=0){
			        	BeanVarios objVarios=objServletVarios.obtener(fila);
			        
			       
			         objVarios.setCodmar(0);
			         objVarios.setCodprod(Integer.parseInt(COD_PROD));
			         objVarios.setCodprove(Integer.parseInt(COD_PROVEE));
			         objVarios.setCostoprove(Double.parseDouble(COSTE));
			         objVarios.setCostoreal( Double.parseDouble(COSTE));
			         objVarios.setFec(FECHA);
			         objVarios.setIgv("");
			         objVarios.setCodmar(Integer.parseInt(COD_MAR));
			         objVarios.setMarca(MARCA);
			         objVarios.setMon("");
			         objVarios.setObsdet("");
			         objVarios.setObsprod("");
			         objVarios.setProducto(NOM_PROD);
			         objVarios.setProveedor(PROVEEDOR);
			         objVarios.setCod_umed(Integer.parseInt(COD_UMED));
			         objVarios.setUmed(UMED);
			         //objVarios.setCod_prodalt(Integer.parseInt(COD_PRODALT));
			         objVarios.setNom_prodalt(NOM_PROD);
			         System.out.println("ESTOS SON DIFERENTES:"+NOM_PROD+"||"+NOM_PRODALT);
			         modelo2.setValueAt(NOM_PRODALT, fila, 3);//Marca
			         modelo2.setValueAt(MARCA, fila, 4);
			         modelo2.setValueAt(UMED, fila, 2);//Marca
			         modelo2.setValueAt(PESO_PRODUCTO, fila, 13);//Peso
			         if(tiempoEntrega.equals("ERROR 0") ||tiempoEntrega.equals("ERROR 1")||tiempoEntrega.equals("ERROR 2")||
			        		 tiempoEntrega.equals("ERROR 2.2") ||tiempoEntrega.equals("UND") ){
			        	 modelo2.setValueAt("1 Dia", fila, 14);//Tiempo Entrega
			        	 tiempoEntrega();
			         }
			         calcularParte(fila);//PARA QUE SE CALCULE Y SE MUESTRE EN LA TABLA	
			         calcular();//PARA QUE CALCULE EL TOTAL ABAJO
			         
							    
						 
			         
			         /********************************************************************************/
			         if(estGTemp==0){
			        	 //NADA
			        	 System.out.println("NADAAAAAAA");
			         }else{
			        	 AccesoBD objAccesoBD=  new AccesoBD();
				 			objAccesoBD.crearConexion();
				 			/* ide_cot_inc,num_item,cod_ven,cod_cli,fecha_coti,cantidad,unimedida,desc_prod,marca,precio_unit,precio_total,
		                     precio_costo,costo_total,diferencia,fecha,prorcentaje,nom_prove;*/
				 			System.out.println("UPDATE1");
				 			String sql="update tb_cotizacioninconclusa set "+
							"cantidad='"+modelo2.getValueAt(fila, 1)+"',unimedida='"+modelo2.getValueAt(fila, 2)+"', "+
							"desc_prod='"+modelo2.getValueAt(fila, 3)+"',marca='"+modelo2.getValueAt(fila, 4)+"', "+
							" precio_unit='"+modelo2.getValueAt(fila, 5)+"',precio_total='"+modelo2.getValueAt(fila, 6)+"',precio_costo='"+modelo2.getValueAt(fila, 7)+"', "+
							" costo_total='"+modelo2.getValueAt(fila, 8)+"',diferencia='"+modelo2.getValueAt(fila, 9)+"',fecha='"+modelo2.getValueAt(fila, 10)+"'," +
							" porcentaje='"+modelo2.getValueAt(fila, 11)+"',nom_prove='"+modelo2.getValueAt(fila, 12)+"',cod_prove='"+COD_PROVEE+"' ,"+
							" cod_prod='"+COD_PROD+"',cod_mar='"+COD_MAR+"',cod_umed='"+COD_UMED+"',"+
							" peso_prod='"+modelo2.getValueAt(fila, 13)+"',tiempo_entrega='"+modelo2.getValueAt(fila, 14)+"',COSTO='"+formato(Double.parseDouble(COSTE))+"' "+ 
							" WHERE num_item='"+modelo2.getValueAt(fila, 0)+"' and FECHA_COTI='"+fech+"' and COD_VEN='"+cod_ven+"' and IDE_COT_INC = '"+ide_cot+"';"; 
									//" AND REP.COD_REP='"+cod_rep+"'; ";

						   System.out.println(sql);

						   int op=objAccesoBD.ejecutarActualizacion(sql);
						   if(op==0){
						   
							//objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
						   }else{
							 //objGUI.mostrarAviso("Se modifico el Cliente y el Reporte");
						   }
						
						   objAccesoBD.cerrarConexion(); 
			         }
			         	
					
				       /*************************************************************************************************************/ 
			       }
			       else{
				        	 BeanCotizacionInconclusa objCoti=objSCotInc.obtener(fila);
				        	 //BeanVarios objVarios=objServletVarios.obtener(fila);
				        	 
				
				        	// objVarios.setCodmar(0);
					        // objVarios.setCodprod(Integer.parseInt(COD_PROD));
					        // objVarios.setCodprove(Integer.parseInt(COD_PROVEE));
					         //objVarios.setCostoprove(Double.parseDouble(COSTE));
					         //objVarios.setCostoreal( Double.parseDouble(COSTE));
				        	 objCoti.setFecha(FECHA);
					        // objVarios.setIgv("");
					         //objVarios.setCodmar(Integer.parseInt(COD_MAR));
				        	 objCoti.setMarca(MARCA);
					         //objVarios.setMon("");
					         //objVarios.setObsdet("");
					         //objVarios.setObsprod("");
				        	 objCoti.setDesc_prod(NOM_PROD);
				        	 objCoti.setNom_prove(PROVEEDOR);
					         //objVarios.setCod_umed(Integer.parseInt(COD_UMED));
					         objCoti.setUnimedida(UMED);
					         objCoti.setPeso_prod(PESO_PRODUCTO);
					         objCoti.setCosto(Double.parseDouble(COSTE));
					         //PESO_PRODUCTO=objBuscarProdCot.PESO_PROD;
					         
					         //objVarios.setCod_prodalt(Integer.parseInt(COD_PRODALT));
					        // objCoti.setNom_prodalt("");
					         System.out.println("ESTOS SON DIFERENTES:"+NOM_PROD+"||"+NOM_PRODALT);
					         
					         modelo2.setValueAt(NOM_PRODALT, fila, 3);//Marca
					         modelo2.setValueAt(MARCA, fila, 4);
					         modelo2.setValueAt(UMED, fila, 2);//Marca
					         modelo2.setValueAt(PESO_PRODUCTO, fila, 13);//Peso
					         //modelo2.setValueAt("1 Dia", fila, 14);//Tiempo Entrga
					         if(tiempoEntrega.equals("ERROR 0") ||tiempoEntrega.equals("ERROR 1")||tiempoEntrega.equals("ERROR 2")||
					        		 tiempoEntrega.equals("ERROR 2.2") ||tiempoEntrega.equals("UND") ){
					        	 modelo2.setValueAt("1 Dia", fila, 14);//Tiempo Entrega
					        	 tiempoEntrega();
					         }
					         System.out.println(modelo2.getValueAt(fila, 13));
					         
					         calcularParte(fila);//PARA QUE SE CALCULE Y SE MUESTRE EN LA TABLA	
					         calcular();//PARA QUE CALCULE EL TOTAL ABAJO 
					         /********************************************************************************/
					         AccesoBD objAccesoBD2=  new AccesoBD();
					 			objAccesoBD2.crearConexion();
					 			/* ide_cot_inc,num_item,cod_ven,cod_cli,fecha_coti,cantidad,unimedida,desc_prod,marca,precio_unit,precio_total,
			                     precio_costo,costo_total,diferencia,fecha,prorcentaje,nom_prove;*/
					 			System.out.println("UPDATE2");
					 			String sql2="update tb_cotizacioninconclusa set "+
								"cantidad='"+modelo2.getValueAt(fila, 1)+"',unimedida='"+modelo2.getValueAt(fila, 2)+"', "+
								"desc_prod='"+modelo2.getValueAt(fila, 3)+"',marca='"+modelo2.getValueAt(fila, 4)+"', "+
								" precio_unit='"+modelo2.getValueAt(fila, 5)+"',precio_total='"+modelo2.getValueAt(fila, 6)+"',precio_costo='"+modelo2.getValueAt(fila, 7)+"', "+
								" costo_total='"+modelo2.getValueAt(fila, 8)+"',diferencia='"+modelo2.getValueAt(fila, 9)+"',fecha='"+modelo2.getValueAt(fila, 10)+"'," +
								" porcentaje='"+modelo2.getValueAt(fila, 11)+"',nom_prove='"+modelo2.getValueAt(fila, 12)+"',cod_prove='"+COD_PROVEE+"' ,"+
								" cod_prod='"+COD_PROD+"',cod_mar='"+COD_MAR+"',cod_umed='"+COD_UMED+"',"+
								" peso_prod='"+modelo2.getValueAt(fila, 13)+"',tiempo_entrega='"+modelo2.getValueAt(fila, 14)+"',COSTO='"+formato(Double.parseDouble(COSTE))+"' "+ 
								"WHERE num_item='"+modelo2.getValueAt(fila, 0)+"' and FECHA_COTI='"+fecha_coti+"' and COD_VEN='"+cod_ven+"' and IDE_COT_INC = '"+ide_cot_inc+"';"; 
										//" AND REP.COD_REP='"+cod_rep+"'; ";

							   System.out.println(sql2);

							   int op2=objAccesoBD2.ejecutarActualizacion(sql2);
							   if(op2==0){
								//objGUI.mostrarAviso("Debe Selecionar un Registro de la Lista del Reporte");
							   }else{
								 //objGUI.mostrarAviso("Se modifico el Cliente y el Reporte");
							   }
							
							   objAccesoBD2.cerrarConexion();	
							   cargarCotizacionInc();
						       /*************************************************************************************************************/
				         }
			         }
				}
			if(e.getSource()==tblLista&(tblLista.getSelectedColumn()==5||
					tblLista.getSelectedColumn()==6||
					tblLista.getSelectedColumn()==7||
					tblLista.getSelectedColumn()==8||
					tblLista.getSelectedColumn()==9)){
				
				int cod_ven=objGlobal.COD_VEN;
			    //int ide_cot=retornaUltimoCodCotizacionInconclusa2();
			    String fech=objFecha.fechaActual();
				int fila = tblLista.getSelectedRow();
				
				if(objServletVarios.tamaño()!=0){
					System.out.println("ESTE ES LA FILA QUE ESTA AGARRANDO:"+fila);
				BeanExcel	objExcel=arrayExcel.obtener(fila);
				BeanVarios	objVarios=objServletVarios.obtener(fila);
				
				cantidadpasar=objExcel.getCant();
				costepasar=objVarios.getCostoreal();
				System.out.println("EL COSTE REAL ANTES:"+costepasar);
				poner="0";
				objescCal= new EscogerCalcular();
				
				objescCal.txtPTotal.setText(""+modelo2.getValueAt(fila, 5));
				objescCal.txtTotal.setText(""+modelo2.getValueAt(fila, 6));
				objescCal.txtCostoTotal.setText(""+modelo2.getValueAt(fila, 7));
				objescCal.txtTotalCosto.setText(""+modelo2.getValueAt(fila, 8));
				objescCal.txtDiferencia.setText(""+modelo2.getValueAt(fila, 9));
				objescCal.txtFactor.setText(""+modelo2.getValueAt(fila, 11));
				}else{
					//int fila = tblLista.getSelectedRow();
					System.out.println("ESTE ES LA FILA QUE ESTA AGARRANDOSSSSS:"+fila);
					BeanCotizacionInconclusa objCoti=objSCotInc.obtener(fila);
					//BeanVarios	objVarios=objServletVarios.obtener(fila);
					
					cantidadpasar=objCoti.getCant();
					costepasar=Double.parseDouble(COSTE);
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
			        objGUI.mostrarAviso("este es el valor:"+objescCal.txtFactor.getText());
			        modelo2.setValueAt(objescCal.txtPTotal.getText(), fila, 5);
					modelo2.setValueAt(objescCal.txtTotal.getText(), fila, 6);
					modelo2.setValueAt(objescCal.txtCostoTotal.getText(), fila, 7);
					modelo2.setValueAt(objescCal.txtTotalCosto.getText(), fila, 8);
					modelo2.setValueAt(objescCal.txtDiferencia.getText(), fila, 9);
					modelo2.setValueAt(objescCal.txtFactor.getText(), fila, 11);
					calcular();	 
			        }
		         poner=null;
			}
			
			/************************************************************************************************/
			if(e.getSource()==tblLista&tblLista.getSelectedColumn()==14){
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
		        	 //x--->no cogio nada
		         }else{
		        String tiempo=objCamTiemEntrega.txtCantidad.getText();
		        System.out.println("K TIEMPO LE PASA?:"+tiempo);
		         //BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(fila);
		         System.out.println("ES LA FILA :"+fila);
		         modelo2.setValueAt(tiempo, fila, 14);
		         //objCotVarios.setTiempoentrega(tiempo);
		      
		         //calcularParte(fila);
		         //calcular(); 
		         }
			  }   
				
			}
			/************************************************************************************************/
			
			
			
	    }
		public void mouseReleased(MouseEvent e) {}
	
	
	

}
