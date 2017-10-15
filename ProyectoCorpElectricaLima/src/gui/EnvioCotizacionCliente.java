package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import miLib.PasarExcelCorreo;
import pOp.BuscarCorreoCliente;
import servlet.ServletCliente;
import servlet.ServletCotizacionVarios;
import beans.BeanCliente;
import beans.BeanCotizacionVarios;
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
public class EnvioCotizacionCliente extends JInternalFrame implements MouseListener, ActionListener{

	
	private JPanel pnlPricncipal;
	private JLabel lblTotal;
	private JButton btnSiguiente;
	private JTextField txtTotalDolarCONigv;
	private JTextField txtSumaTotalDigv;
	private JTextField txtSumaTotalD;
	private JLabel lblIgv;
	private JLabel lblPrecioVenta;
	private JTextField txtReferencia;
	private JLabel lblReferencia;
	private JPanel pnlPrincipal;
	private JTextField txtFecha;
	private JButton btnCancelar;
	private JButton btnConfigurarEmail;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField txtTipoCambio;
	private JLabel lblTipoCambio;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JLabel lblTelefonos;
	private JLabel lblDireccion;
	private JTextField txtNroModificacion;
	private JLabel lblNroModificacion;
	private JLabel lblFecha;
	private JTextField txtAtencion;
	private JLabel lblSeñores2;
	private JTextField txtTotalSolesCONigv;
	private JTextField txtSumaTotalSigv;
	private JTextField txtSumaTotalS;
	private JPanel pnlAbajo;
	private JTable tblLista;
	private JScrollPane scrLista;
	public static JTextField txtNCotizacion;
	private JLabel lblRuta;
	private JTextField txtSeñores;
	private JLabel lblSeñores;
	/////////////////////////////////////GLOBALES/////////////////////////////////////////////
	String cc;
	String sex;
	public static String correo1;
	public static String correo2;//D:\ProyectoCEL(1.0.0.0)\Cotizaciones\CotizacionesModificadas\Cotizaciones para Cliente\CORREO
	public static String sexo;
	private EditorArchivo archivoDatos;//D:\ProyectoCEL(1.0.0.0)\Cotizaciones\CotizacionesModificadas\Cotizaciones para Cliente\CORREO
	public static boolean valorCerrado=true;
	public static String rutaGlobal;
	Object[] arregloCadenas;
	Object[][] arregloObjetos;
	public static String nombreCliente,codigocliente,referencia_coti;
	////////////////////////////////////CLASES/////////////////////////////////////////////////
    ServletCliente objServletCliente = new ServletCliente();
    Fecha objFecha;
	Metodos objMetodo;
	GUI objGUI;
	Globales objGlobal;
	BuscarCorreoCliente objCorreoCliente;
	public static ServletCotizacionVarios  objTransacionAutomaticaAutMant;
	//EnvioCorreo objEnvioCorreo;
	EnvioMail objEnvioMail;
	MenuPrincipal objMenu;
	TranCotizacionAutMant objTranCotAutMant;
	PasarExcelCorreo objPasarExcelCorreo;
   /*------------------------------------------------------------------------------------------------------*/
	
	
	String titulo2[]={"CANT","U","DESCRIPCION","MARCA","P.UNIT $","TOTAL $","P.UNIT S/","TOTAL S/"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 
	public EnvioCotizacionCliente() {
	
		super("Verificacion Cotizacion", true, true, true, true);
		try {
			//System.out.println("EL TAMAÑON:"+objTransacionAutomaticaAutMant.objServletCotVarios.tamaño());
			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(933, 518));
			this.setLayout(null);
			this.setBounds(0, 0, 945, 636);

			pnlPrincipal = new JPanel();
			this.add(pnlPrincipal);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setBounds(0, 0, 933, 505);

			pnlAbajo = new JPanel();
			pnlPrincipal.add(pnlAbajo);
			pnlAbajo.setLayout(null);
			pnlAbajo.setBounds(6, 416, 844, 79);

			lblPrecioVenta = new JLabel();
			pnlAbajo.add(lblPrecioVenta);
			lblPrecioVenta.setText("Precio Venta:");
			lblPrecioVenta.setBounds(472, 7, 80, 14);

			lblIgv = new JLabel();
			pnlAbajo.add(lblIgv);
			lblIgv.setText("IGV:");
			lblIgv.setBounds(472, 30, 37, 14);

			lblTotal = new JLabel();
			pnlAbajo.add(lblTotal);
			lblTotal.setText("Total:");
			lblTotal.setBounds(472, 54, 44, 14);

			txtSumaTotalS = new JTextField();
			pnlAbajo.add(txtSumaTotalS);
			txtSumaTotalS.setBounds(564, 2, 82, 21);

			txtSumaTotalSigv = new JTextField();
			pnlAbajo.add(txtSumaTotalSigv);
			txtSumaTotalSigv.setBounds(564, 25, 82, 21);

			txtTotalSolesCONigv = new JTextField();
			pnlAbajo.add(txtTotalSolesCONigv);
			txtTotalSolesCONigv.setBounds(564, 48, 82, 21);

			txtSumaTotalD = new JTextField();
			pnlAbajo.add(txtSumaTotalD);
			txtSumaTotalD.setBounds(752, 2, 82, 21);

			txtSumaTotalDigv = new JTextField();
			pnlAbajo.add(txtSumaTotalDigv);
			txtSumaTotalDigv.setBounds(752, 25, 82, 21);

			txtTotalDolarCONigv = new JTextField();
			pnlAbajo.add(txtTotalDolarCONigv);
			txtTotalDolarCONigv.setBounds(752, 48, 82, 21);

			btnSiguiente = new JButton();
			pnlAbajo.add(btnSiguiente);
			btnSiguiente.setText("Siguiente");
			btnSiguiente.setBounds(45, 24, 97, 24);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(170, 24, 106, 24);
			btnCancelar.addActionListener(this);

			btnSiguiente.addActionListener(this);

			scrLista = new JScrollPane();
			pnlPrincipal.add(scrLista);
			scrLista.setBounds(6, 148, 922, 267);

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);

			pnlPricncipal = new JPanel();
			pnlPrincipal.add(pnlPricncipal);
			pnlPricncipal.setLayout(null);
			pnlPricncipal.setBounds(0, 0, 921, 142);

			lblRuta = new JLabel();
			pnlPricncipal.add(lblRuta);
			lblRuta.setText("Nro.Cotizacion:");
			lblRuta.setBounds(244, 8, 87, 16);

			txtNCotizacion = new JTextField();
			pnlPricncipal.add(txtNCotizacion);
			txtNCotizacion.setBounds(335, 5, 150, 23);

			lblSeñores2 = new JLabel();
			pnlPricncipal.add(lblSeñores2);
			lblSeñores2.setText("Atencion:");
			lblSeñores2.setBounds(12, 57, 69, 14);

			txtAtencion = new JTextField();
			pnlPricncipal.add(txtAtencion);
			txtAtencion.setBounds(88, 55, 634, 19);

			lblFecha = new JLabel();
			pnlPricncipal.add(lblFecha);
			lblFecha.setText("Fecha:");
			lblFecha.setBounds(729, 31, 57, 14);

			txtFecha = new JTextField();
			pnlPricncipal.add(txtFecha);
			txtFecha.setBounds(788, 28, 90, 22);

			lblNroModificacion = new JLabel();
			pnlPricncipal.add(lblNroModificacion);
			lblNroModificacion.setText("Nro Modificacion:");
			lblNroModificacion.setBounds(490, 9, 100, 14);

			txtNroModificacion = new JTextField();
			pnlPricncipal.add(txtNroModificacion);
			txtNroModificacion.setBounds(590, 6, 38, 21);

			lblDireccion = new JLabel();
			pnlPricncipal.add(lblDireccion);
			lblDireccion.setText("Direccion:");
			lblDireccion.setBounds(12, 78, 69, 14);

			lblTelefonos = new JLabel();
			pnlPricncipal.add(lblTelefonos);
			lblTelefonos.setText("Telefonos:");
			lblTelefonos.setBounds(12, 100, 69, 14);

			txtDireccion = new JTextField();
			pnlPricncipal.add(txtDireccion);
			txtDireccion.setBounds(88, 76, 634, 19);

			txtTelefono = new JTextField();
			pnlPricncipal.add(txtTelefono);
			txtTelefono.setBounds(88, 98, 480, 19);

			lblTipoCambio = new JLabel();
			pnlPricncipal.add(lblTipoCambio);
			lblTipoCambio.setText("Tipo C:");
			lblTipoCambio.setBounds(815, 98, 47, 17);

			txtTipoCambio = new JTextField();
			pnlPricncipal.add(txtTipoCambio);
			txtTipoCambio.setBounds(862, 96, 48, 19);

			lblEmail = new JLabel();
			pnlPricncipal.add(lblEmail);
			lblEmail.setText("E-mail:");
			lblEmail.setBounds(575, 100, 41, 14);

			txtEmail = new JTextField();
			pnlPricncipal.add(txtEmail);
			txtEmail.setBounds(616, 98, 181, 21);

			btnConfigurarEmail = new JButton();
			pnlPricncipal.add(btnConfigurarEmail);
			btnConfigurarEmail.setText("E-mail");
			btnConfigurarEmail.setBounds(728, 72, 70, 21);

			lblSeñores = new JLabel();
			pnlPricncipal.add(lblSeñores);
			lblSeñores.setText("Señores:");
			lblSeñores.setBounds(12, 34, 69, 14);

			txtSeñores = new JTextField();
			pnlPricncipal.add(txtSeñores);
			txtSeñores.setBounds(88, 30, 634, 23);

			lblReferencia = new JLabel();
			pnlPricncipal.add(lblReferencia);
			lblReferencia.setText("Referencia:");
			lblReferencia.setBounds(12, 123, 76, 14);

			txtReferencia = new JTextField();
			pnlPricncipal.add(txtReferencia);
			txtReferencia.setBounds(88, 120, 710, 21);

			btnConfigurarEmail.addActionListener(this);

			String titulo2[]={"CANT","U","DESCRIPCION","MARCA","P.UNIT $","TOTAL $","P.UNIT S/","TOTAL S/"};
			TableColumn Cant = tblLista.getColumn ("CANT"),Und = tblLista.getColumn ("U"),Descripcion = tblLista.getColumn ("DESCRIPCION")
			,Marca = tblLista.getColumn ("MARCA"),PunitD= tblLista.getColumn ("P.UNIT $"),TotalD = tblLista.getColumn ("TOTAL $"),PunitS  = tblLista.getColumn ("P.UNIT S/")
			,TotalS = tblLista.getColumn ("TOTAL S/");
			//Id
			Cant.setPreferredWidth(12);
			Und.setPreferredWidth(12);
			Descripcion.setPreferredWidth(390);
			Marca.setPreferredWidth(30);
			PunitD.setPreferredWidth(35);
			TotalD.setPreferredWidth(35);
			PunitS.setPreferredWidth(35);
			TotalS.setPreferredWidth(35);

//String titulo2[]={"Cant","Und","Descripcion","Marca","P.Total $","Total $","Costo $","Total $","Dif. $","Fecha","%","Proveedor"};			
			
			datosDelCliente();
			listar();
			
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
	 public void  datosCliente(String cod_cli){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
		
			String maxCodPregunta="SELECT CLI.COD_CLI,CLI.NOM_CLI,cli.CONA_CLI, CLI.SEX_CLI,CLI.DIR_CLI,CLI.TEL1A_CLI,CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,"+
		        " CLI.MAILA_CLI,CLI.MAILB_CLI,TIPCLI.nom_tipo,CLI.ruc_cli FROM tb_cliente CLI "+
		        " INNER JOIN tb_tipocliente TIPCLI "+
		        " ON CLI.COD_TIPO=TIPCLI.COD_TIPO "+
		        " where CLI.COD_CLI='"+cod_cli+"';";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					BeanCliente objcli= new BeanCliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
														 
							objServletCliente.adicionar(objcli);
									}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
		
		 } 
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
	 public int retornaUltimoIdCotizacion(){
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			
			System.out.println("EL TAMAÑO DE COT VARIOS ES:"+objTransacionAutomaticaAutMant.tamaño());
			BeanCotizacionVarios objBeanCotVar=objTransacionAutomaticaAutMant.obtener(0);
			String codCot=objBeanCotVar.getCodcot();
			//SELECT max(ide_cot) FROM cotizacion where cod_Cot='3';
			String maxCodPregunta="SELECT max(ide_cot) FROM tb_cotizacion where cod_Cot='"+codCot+"';";
			//String insertarPregunta="INSERT INTO VALUES("""""")"

			ResultSet rs = objAccesoBD.ejecutarConsulta(maxCodPregunta);
			try {
			
				int cod = 0;
				while(rs.next()){
					
					if(rs.getString(1)==null){
						cod=0;
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
			return 0;
		 } 
	 public int tamañodelExcel() {
		 int item=0;
		for (int i = 0; i < objTransacionAutomaticaAutMant.tamaño(); i++) 
			item=item+1;	
		return item;
	}
	
	public boolean pasarExcel(int cant) throws FileNotFoundException, IOException{
		
			boolean devuelve=true;
		
			 datosCliente(objTransacionAutomaticaAutMant.obtener(0).getCodcli()) ;
			 int tam=objTransacionAutomaticaAutMant.tamaño();
			 int item=-1;
			 double peso=0;
			 String pesototal="",pesofinal="";
			 BeanCliente objCliente = objServletCliente.obtener(0);
			 BeanCotizacionVarios objCotVarios;
			 if(tam>0){for (int i = 0; i < objTransacionAutomaticaAutMant.tamaño(); i++) {
					
		    objCotVarios=objTransacionAutomaticaAutMant.obtener(i);
		    codigocliente=objCliente.getCodcli();
		    nombreCliente=objCliente.getContacto1cli();;
			arregloCadenas[0]=objCliente.getNomcli().toString().toUpperCase();
			arregloCadenas[1]=objCliente.getContacto1cli().toString().toUpperCase();
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
			arregloCadenas[7]="COTIZACION CORREO Nº"+objCotVarios.getCodcot()+"-"+objCotVarios.getIdecot();
			arregloCadenas[8]=objFecha.fechaActual();
			arregloCadenas[9]=Double.parseDouble(""+tipoCambioCompra());
			arregloCadenas[10]=txtReferencia.getText().toString().toUpperCase();
			item=item+1;
			 for (int j = 0; j < 10; j++) {
					if(j==0){
					arregloObjetos[item][j]=Integer.parseInt(""+objCotVarios.getCancot());	
					}else if(j==1){
					arregloObjetos[item][j]=objCotVarios.getUmedprod().toString();	
					}else if(j==2){
					arregloObjetos[item][j]=objCotVarios.getNomprod().toString();	
					}else if(j==3){
					arregloObjetos[item][j]=objCotVarios.getNommar().toString();		
					}else if(j==4){
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 4));		
					}else if(j==5){
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 5));			
					}else if(j==6){
					arregloObjetos[item][j]="";	
					}else if(j==7){
					arregloObjetos[item][j]="";	
					}else if(j==8){
						pesototal=objCotVarios.getPesoprod().toString();
						if(pesototal.equals("")){
							peso=0;
						}else{
							peso=Integer.parseInt(""+objCotVarios.getCancot())*
							Double.parseDouble(pesototal);
						}
						pesofinal=""+formato(peso);
					arregloObjetos[item][j]=pesofinal;
					}else{
					arregloObjetos[item][j]="";	
					}	
				}
			}
					}
	    
	        
	        return devuelve;
			
		}
	public void datosDelCliente(){
		int ide_cot=retornaUltimoIdCotizacion();
		 datosCliente(objTransacionAutomaticaAutMant.obtener(0).getCodcli()) ;
		 BeanCliente objCliente = objServletCliente.obtener(0);
		 txtNCotizacion.setText(objTransacionAutomaticaAutMant.obtener(0).getCodcot());
		 txtNroModificacion.setText(""+ide_cot);
		 txtFecha.setText(""+objFecha.fechaActual());
		 txtSeñores.setText(""+objCliente.getNomcli());
		 txtAtencion.setText(""+objCliente.getContacto1cli());
		 txtDireccion.setText(""+objCliente.getDireccion1cli());
		 txtTelefono.setText("TEL:"+objCliente.getTelefono1cli()+" RPM:"+objCliente.getRpm1cli()
				 +" CEL:"+objCliente.getCel1cli());
		 txtEmail.setText(""+objCliente.getEmail1cli());
		 cc=""+objCliente.getEmail2cli();
		 sex=""+objCliente.getSexcli();
		 txtTipoCambio.setText(""+tipoCambioCompra());
		 txtReferencia.setText(objTranCotAutMant.ref);
	
	}
	

	public void listar(){

		double tipocambio=tipoCambioCompra();
		double sumaTOTALSOL=0,sumaPUNITDOLAR=0,sumaTOTALDOLAR=0;
		 double sumaTOTALSOLIGV=0,sumaPUNITDOLARIGV=0,sumaTOTALDOLARIGV=0;
		 double sumaTOTALSOLCONIGV=0,sumaPUNITDOLARCONIGV=0,sumaTOTALDOLARCONIGV=0;
		 
		 double sumaTOTALPUNIT=0,sumaTOTALCOSTO=0,sumaTOTALDIFERENCIA=0;
		 double sumaTOTALPUNITIGV=0,sumaTOTALCOSTOIGV=0,sumaTOTALDIFERENCIAIGV=0;
		 double sumaTOTALPUNITCONIGV=0,sumaTOTALCOSTOCONIGV=0,sumaTOTALDIFERENCIACONIGV=0;
		
		for (int i = 0; i < objTransacionAutomaticaAutMant.tamaño(); i++) {
			BeanCotizacionVarios objCotisacionVarios=objTransacionAutomaticaAutMant.obtener(i) ;
			double costeXporc=Double.parseDouble(""+objCotisacionVarios.getCosteEntreporc());
			double costeXporcXcant=Double.parseDouble(""+objCotisacionVarios.getCosteXporcXcant());
			
			Object[] array={ objCotisacionVarios.getCancot()
					, objCotisacionVarios.getUmedprod(), objCotisacionVarios.getNomprod(),
					objCotisacionVarios.getNommar(),formato(costeXporc) ,
					formato(costeXporcXcant),formato(costeXporc*tipocambio),formato(costeXporcXcant*tipocambio) };
			modelo2.addRow(array);
		sumaTOTALSOL=sumaTOTALSOL+costeXporcXcant;
		sumaTOTALDOLAR=sumaTOTALDOLAR+(costeXporcXcant*tipocambio);
		sumaTOTALSOLIGV=sumaTOTALSOL*0.18;
		sumaTOTALDOLARIGV=sumaTOTALDOLAR*0.18;
		sumaTOTALSOLCONIGV=sumaTOTALSOLIGV+sumaTOTALSOL;
		sumaTOTALDOLARCONIGV=sumaTOTALDOLARIGV+sumaTOTALDOLAR;
			
		}
		txtSumaTotalS.setText(""+formato(sumaTOTALSOL));
		txtSumaTotalD.setText(""+formato(sumaTOTALDOLAR));
		txtSumaTotalSigv.setText(""+formato(sumaTOTALSOLIGV));
		txtSumaTotalDigv.setText(""+formato(sumaTOTALDOLARIGV));
		txtTotalSolesCONigv.setText(""+formato(sumaTOTALSOLCONIGV));
		txtTotalDolarCONigv.setText(""+formato(sumaTOTALDOLARCONIGV));
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancelar){
			System.out.println("ESTA ENTRANDO MANOI");
			objTranCotAutMant.objEnvioCotCliente=null;
			this.setVisible(false);
			//objTranCotAutMant.objEnvioCotCliente.setVisible(false);
		}
		if(e.getSource()==btnConfigurarEmail){
			objCorreoCliente= new BuscarCorreoCliente();
			objCorreoCliente.txtNombre.setText(txtSeñores.getText().trim());
	       
			String[] botones = {"Aceptar","Cancelar"};//Esto es el nombre
	         int showOptionDialog = JOptionPane.showOptionDialog(
	     		   this,                             			
	     		  objCorreoCliente,                                    
	     		   "Buscar Correo", 		
	     		    0,          						        
	     		   -1,            								
	     		   null,                                       
	     		  botones,
	     		   "Cerrar"
	     		                                  	
	     	);
	         if(showOptionDialog==1||showOptionDialog==-1){//CANCELAR Y X
	         System.out.println("NO COGIO NADA");
	         }else{//ACEPTAR 	
	        	correo1= objCorreoCliente.txtCorreo1.getText();
	        	correo2= objCorreoCliente.txtCorreo2.getText();
	        	txtEmail.setText(correo1);
		
		 }
			
		}
		/*	if(e.getSource()==btnGuardar){
			int cod=guardar();
			int tam=tamañodelExcel();
			arregloCadenas= new Object[10];
			arregloObjetos= new Object[tam][9];
			//este es para ver elk tamañp
			
			try {pasarExcel(cod);
				objPasarExcel.crearExcel(arregloCadenas,arregloObjetos);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			borrarTodo();
			
			
		}*/
		if(e.getSource()==btnSiguiente){
			boolean valor=true;
			correo1=txtEmail.getText();
			correo2=cc.trim();
			sexo=sex.trim();
			referencia_coti=txtReferencia.getText();
			int tam=objTransacionAutomaticaAutMant.tamaño();//ESTE ES EL TAMAÑO REAL
			//String nom=objTransacionAutomaticaAutMant.obtener(1).getCodcot();
			boolean devuelve = false;
			arregloCadenas= new Object[11];
			arregloObjetos= new Object[tam][10];
			//int resto=excelUsar(tam);

			try {
				devuelve=pasarExcel(tam);
				objPasarExcelCorreo= new PasarExcelCorreo();
				objPasarExcelCorreo.crearExcel(arregloCadenas,arregloObjetos);
				rutaGlobal=objPasarExcelCorreo.fileGlobal;
				valor=true;
			} catch (FileNotFoundException e1) {
				System.out.println("MALOOOO");
				valor=false;
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
				valor=false;
			}finally{
				if(!valor){
					objGUI.mostrarAviso("Hubo un ERROR!");
				}
			}
			if(devuelve){/*
			if(objEnvioCorreo==null||objEnvioCorreo.isClosed()){
				//objGUI.mostrarAviso("En Construccion.....!!");
				objEnvioCorreo= new EnvioCorreo();
				objEnvioCorreo.setVisible(true);
				objMenu.jDesktopPane1.add(objEnvioCorreo);
			try{this.setClosed(true);
				}catch(PropertyVetoException e1){e1.printStackTrace();}
			try {objEnvioCorreo.setSelected(true);} catch (java.beans.PropertyVetoException ee) {}
					}		
			*/
				
				
				//	ESTE CODIGO ES PAARA ABRIR LA VENTANA DEL CORREO
				if(objEnvioMail==null||objEnvioMail.isClosed()){
					//objGUI.mostrarAviso("En Construccion.....!!");
					objEnvioMail= new EnvioMail();
					objEnvioMail.setVisible(true);
					objMenu.jDesktopPane1.add(objEnvioMail);
				try{this.setClosed(true);
					}catch(PropertyVetoException e1){e1.printStackTrace();}
				try {objEnvioMail.setSelected(true);} catch (java.beans.PropertyVetoException ee) {}
						}	
			}else{
				objGUI.mostrarAviso("Hubo un error al pasar al excel!");
			}
		
		}
		
	}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
