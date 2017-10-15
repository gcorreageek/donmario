package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import miLib.AccesoBD;
import miLib.AccesoBD2;
import miLib.EnviarMail;
import miLib.Fecha;
import miLib.GUI;
import miLib.PasarExcelCorreo;
import pOp.VistaPrevia;
import util.Propiedades;
import beans.Globales;
import beans.GlobalesCorreo;
import beans.GlobalesCorreocCye;

import com.hexidec.ekit.Ekit;


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
public class EnvioMail extends Ekit implements ActionListener, MouseListener, KeyListener {
	private JButton btnEnviar;
	private JButton btnCancelar;
	private JButton btnPrueba;
	private JButton btnVista;
	public static JTextPane txtA;
	private JLabel lblCorreoCC;
	private JTextField txtCorreoCC;
	public static JTextField txtPara;
	GUI objGUI;
	EnvioCotizacionCliente objEnvioCot;
	EnviarMail objEnviar;
	String texto="",firma="";
	VistaPrevia objVistaPrevia;
	MenuPrincipal objMenu;
	GlobalesCorreo objGloCorreo;
	GlobalesCorreocCye objGloCorreoCye;
	Globales objGlo;
	String nombreRuta;
	String rutaAr=null;
	String cc=null;
	Fecha objfec;
	TranCotizacionAutMant objTranCotAutMant;
	PasarExcelCorreo objExcCorreo;
	ArrayList <String> archvos;
	
	
	public EnvioMail() {
		try {
			
			super.pnlArriba.setPreferredSize(new java.awt.Dimension(867, 120));
			super.pnlMedio.setPreferredSize(new java.awt.Dimension(867, 120));
			super.pnlAbajo.setPreferredSize(new java.awt.Dimension(867, 372));
			this.setTitle("Envio Correo");
			super.pnlAbajo.setSize(900, 372);
			super.pnlArriba.setSize(867, 120);
			super.pnlMedio.setSize(867, 120);
			super.txtPara.setBounds(93, 0, 680, 21);
			super.txtAsunto.setBounds(93, 42, 680, 21);
			super.lblAsunto.setBounds(11, 42, 80, 21);
			super.txtRuta.setBounds(93, 65, 680, 21);
			super.jLabel1.setBounds(11, 65, 80, 21);
			super.cboTipoCliente.setBounds(11, 65, 250, 21);
			super.lblTipoCliente.setBounds(11, 88, 80, 21);
			super.cboTipoCliente.setBounds(93, 88, 170, 21);
			super.cboTipoCliente.setPreferredSize(new java.awt.Dimension(206, 21));
			super.cboTipoCliente.addActionListener(this);

			btnEnviar = new JButton();
			super.pnlArriba.add(btnEnviar);
			btnEnviar.setText("Enviar");
			btnEnviar.setBounds(463, 88, 90, 21);
			btnEnviar.addActionListener(this);
			super.txtPara.setText(objEnvioCot.correo1);
			super.txtRuta.setText(objEnvioCot.rutaGlobal);
			

			btnCancelar = new JButton();
			super.pnlArriba.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(353, 88, 92, 21);

			btnVista = new JButton();
			super.pnlArriba.add(btnVista);
			btnVista.setText("Vista");
			btnVista.setBounds(571, 88, 97, 21);
			btnVista.addActionListener(this);

			btnPrueba = new JButton();
			super.pnlArriba.add(btnPrueba);
			btnPrueba.setText("Prueba");
			btnPrueba.setBounds(679, 88, 93, 21);

			txtCorreoCC = new JTextField();
			super.pnlArriba.add(txtCorreoCC);
			txtCorreoCC.setBounds(93, 21, 679, 21);

			lblCorreoCC = new JLabel();
			super.pnlArriba.add(lblCorreoCC);
			lblCorreoCC.setText("CC:");
			lblCorreoCC.setBounds(12, 24, 76, 14);

			btnPrueba.addActionListener(this);

			btnCancelar.addActionListener(this);

			txtA=super.ekitCore.jtpMain;
			txtPara=super.txtPara;
			txtCorreoCC.setText(objEnvioCot.correo2);
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void cargar(){
		
		objTranCotAutMant=new TranCotizacionAutMant();
		/*int totalarchivos= objTranCotAutMant.totalArchivos();
		int aleatorio= objTranCotAutMant.aleatorio(1,totalarchivos);*/
		String nom=objTranCotAutMant.rutaArchivo();
		String nomdia=objfec.fechaActual4();
		String letra="";
		Propiedades p=new Propiedades();
		
		if(nomdia.equals("lun")){
			
			letra = p.getProperty("speachCotizacion")+"/lunes/"+nom;
			
		}else if(nomdia.equals("mar")){
			
			letra = p.getProperty("speachCotizacion")+"/martes/"+nom;
			
		}else if(nomdia.equals("mié")){
			
			letra = p.getProperty("speachCotizacion")+"/miercoles/"+nom;
			
		}else if(nomdia.equals("jue")){
			
			letra = p.getProperty("speachCotizacion")+"/jueves/"+nom;
			
		}else if(nomdia.equals("vie")){
			
			letra = p.getProperty("speachCotizacion")+"/viernes/"+nom;
			
		}else if(nomdia.equals("sáb")){
			
			letra = p.getProperty("speachCotizacion")+"/sabado/"+nom;
			
		}else{
			letra = "";
		}
		
		System.out.println(letra);
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    //InputStream in=null;
	    
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (letra);
	         fr = new FileReader (archivo);
	       
	         br = new BufferedReader(fr);
	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null){
	        	
	        		 texto=texto+linea;
	         }
	        
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	public void aMostrar(){
		texto="";
		String clienteAntiguo="";
		String clienteNuevo="";
		String señores="";
		String sexo="";
		
		if(objTranCotAutMant.sexo.equals("0")){
			sexo="o(a)";
		}else if(objTranCotAutMant.sexo.equals("1")){
			sexo="o";
		}else{
			sexo="a";
		}

			cargar();
			texto=texto.replace("[oa]", sexo);
			texto=texto.replace("[Nombre]", objTranCotAutMant.nombreCliente );
			texto=texto.replace("[Vendedor]", objGlo.NOM_VEN);
			//super.ekitCore.jtpMain.setText(señores+clienteAntiguo);
			//txtAMensaje.setText(señores+clienteAntiguo);
			super.ekitCore.jtpMain.setText(texto);
		
	}

	public void envio(){
		String correo1=txtPara.getText();
		cc=txtCorreoCC.getText();
		String asunto1=txtAsunto.getText();
		String archivo1=txtRuta.getText();
		String mensaje1=super.ekitCore.jtpMain.getText();
		int sale = 1;
		String sCadenaInvertida = "";
		String nombreRuta="";
		for (int x=archivo1.length()-1;x>=0;x--)
			sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
		//System.out.println(sCadenaInvertida);
		nombreRuta=archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("/",0), archivo1.length());
		//System.out.println(ruta.);
		//ruta=ruta.substring(ruta.lastIndexOf("\""), ruta.length());
		
		if(cc==null||cc.trim().equals("") || cc.trim().equals("0")){
			System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar(correo1, asunto1, nombreRuta, archivo1, mensaje1);
		}
		else{
			System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
			sale=objEnviar.Enviar(correo1, cc, asunto1, nombreRuta, archivo1, mensaje1);
		}
		
		if(sale==0){
			cambiarAenviado(2);
			//objGUI.mostrarAviso("Se Mando su Mensaje!");
			System.out.println("Se Mando su Mensaje!");
		}else{
			cambiarAenviado(1);
			//objGUI.mostrarAviso("Hubo un ERROR!");
			System.out.println("Hubo un ERROR!");
		}
		
		
	}
	
	public String SinBarras(String cad){
		
		String cadena="",palabra="";
		String pal="\\";
		for(int i=cad.length()-1;i>=0;i--){
			cadena=""+cad.charAt(i);
			if(cadena.equals(pal) || cadena.equals("/") ){
				break;
			}else{
				palabra=cadena+palabra;
			}
		}
		return palabra;
	}

	public void envio1(){
		
		//Propiedades p=new Propiedades();
		String correo1=objTranCotAutMant.correo1;
		cc=objTranCotAutMant.correo2;
		String asunto1=objTranCotAutMant.coti;
		String archivo1=objExcCorreo.fileGlobal;
		String archivos_adjuntos=objTranCotAutMant.ruta;
		String nombre_archivos_adjuntos=objTranCotAutMant.nombreArchivosAdjuntos;
		
		
		String mensaje1=super.ekitCore.jtpMain.getText();
		int sale = 1;
		String sCadenaInvertida = "";
		int adjuntos=0;
		//archvos=new ArrayList<String>();
		
		//String nombreRuta1="";
		for (int x=archivo1.length()-1;x>=0;x--)
			sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
		
	    if(archivos_adjuntos.equals("")){
        	nombreRuta=archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("/",0), archivo1.length());
		}else{
					
			nombreRuta=(archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("/",0), archivo1.length()))+";"+nombre_archivos_adjuntos;
			archivo1=archivo1+";"+archivos_adjuntos;
			adjuntos=1;
			/*
			archvos.add(archivo1);
			archvos.add(archivos_adjuntos);	
			//String ruta="D:/ProyectoCEL/Cotizaciones/CotCorreo/"+
			//String ruta="//Mario/d/ProyectoCEL/Cotizaciones/CotCorreo/"+
			String ruta=p.getProperty("ruta").trim()+
			archivo1.substring(archivo1.length()-sCadenaInvertida.indexOf("/",0), archivo1.length())+".zip";
			//System.out.println("ruta: "+ruta);
			try {
				ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(ruta));
				zos.setLevel(9);
				System.out.println("tanaño: "+archvos.size());
				for(int i=0;i<archvos.size();i++){
					ZipEntry entrada=new ZipEntry(SinBarras(archvos.get(i).trim()));
					//System.out.println("SSS: "+archvos.get(i));
					zos.putNextEntry(entrada);
					FileInputStream fis=new FileInputStream(archvos.get(i));
					byte []bufer=new byte[1024];
					int leido=0;
					while(0<(leido=fis.read(bufer))){
						zos.write(bufer, 0, leido);
					}
					fis.close();
					zos.closeEntry();
				}
				zos.close();
				
				nombreRuta=SinBarras(ruta);
				archivo1=ruta;
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}*/
			
		}
	    
	    System.out.println("Correo1: "+correo1+"\n"+
	    				   "Correo2: "+cc+"\n"+ 
	    				   "Asunto: "+asunto1+"\n"+ 
	    				   "nombreArchivo: "+nombreRuta+"\n"+ 
	    				   "rutaArchivo: "+archivo1+"\n"+ 
	    				   "mensaje: "+	mensaje1+"\n"+
	    				   "adjuntos: "+ adjuntos);
				
	    sale=objEnviar.EnviarCorreoCotizacionMant(correo1, cc, asunto1, nombreRuta, archivo1, mensaje1,adjuntos);
	    
//		if(cc==null||cc.trim().equals("") || cc.trim().equals("0")){
//			System.out.println("Sin segundo correo");
//			System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
//			sale=objEnviar.Enviar(correo1, asunto1, nombreRuta, archivo1, mensaje1);
//		}
//		else{
//			System.out.println("Con los dos correos");
//			System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
//			sale=objEnviar.Enviar(correo1, cc, asunto1, nombreRuta, archivo1,mensaje1);
//		}
		
		if(sale==0){
			cambiarAenviado(2);
			objGUI.mostrarAviso("Se Mando su Mensaje!");
			System.out.println("Se Mando su Mensaje!");
		}else{
			cambiarAenviado(1);
			objGUI.mostrarAviso("Hubo un ERROR!");
			System.out.println("Hubo un ERROR!");
		}
		
		
	}
	private void cambiarAenviado(Integer num) {
		AccesoBD objA= new AccesoBD();
		
		objA.crearConexion();
		String sql="UPDATE tb_cotizacion SET ESTEN_COT='"+num+"'  " +
				" WHERE COD_COT='"+objTranCotAutMant.numCot.trim()+"'   " +
				" AND  IDE_COT='"+pasarIdeCot(Integer.parseInt(objTranCotAutMant.numCot.trim()))+"' ;";
		System.out.println(sql);
		int res=objA.ejecutarActualizacion(sql);
		
		objA.cerrarConexion();
		
	}

	
	public Integer pasarIdeCot(Integer codCot){
		
		Integer ideCot = null;
		String ide_cot=objTranCotAutMant.ideCot;
		AccesoBD objA = new AccesoBD();
		
		objA.crearConexion();
		String sql="SELECT IDE_COT FROM tb_cotizacion WHERE COD_COT='"+codCot+"' and ide_cot='"+ide_cot+"'";
		ResultSet res=objA.ejecutarConsulta(sql);
		try {
			if(res.next()){
				ideCot=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		return ideCot;
		
		
		
	}
	public void pruebaEnviarCorreo(){
		
		String correo1="";
		correo1=objGloCorreo.correo;
		
		String asunto1=txtAsunto.getText();
		String ruta=txtRuta.getText();
		String mensaje1=super.ekitCore.jtpMain.getText();
		int sale = 1;
		String sCadenaInvertida = "";
		String nombreAr;
	
		if(ruta==null){
			
		}else{
			System.out.println(rutaAr);
			System.out.println(nombreRuta);
			System.out.println(ruta);
			rutaAr=ruta;
			for (int x=ruta.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + ruta.charAt(x);
			//System.out.println(sCadenaInvertida);
			System.out.println("A ver:"+sCadenaInvertida.indexOf("/",0));
			nombreAr=ruta.substring(ruta.length()-sCadenaInvertida.indexOf("/",0), ruta.length());
			//System.out.println(ruta.);
			//ruta=ruta.substring(ruta.lastIndexOf("\""), ruta.length());
			nombreRuta=nombreAr;
			System.out.println(rutaAr);
			System.out.println(nombreRuta);
			//txtRuta.setText(rutaAr);
			
		}
		
		System.out.println(correo1+"|"+ asunto1+"|"+ nombreRuta+"|"+ rutaAr+"|"+ mensaje1);
	
			sale=objEnviar.Enviar(correo1, asunto1, nombreRuta, rutaAr, mensaje1);
		
		
		if(sale==0){
			objGUI.mostrarAviso("Se Mando su Mensaje!");
		}else{
			objGUI.mostrarAviso("Hubo un ERROR!");
		}
		
	}
	
	public void ingresarMailsAuto(){
		
		objTranCotAutMant=new TranCotizacionAutMant();
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		String codi_clie=objTranCotAutMant.codigocliente;
		String nomdia=objfec.fechaActual4();
		String newfecha2="";
		String ref=objTranCotAutMant.referencia_coti;
		int est_mail=0,est_mail2=0;
	    if(nomdia.equals("sáb")){
			newfecha2="(DATE_ADD(now(), INTERVAL 48 hour)),";
		}else{
			newfecha2="(DATE_ADD(now(), INTERVAL 24 hour)),";
		}
		
		
			 String insertarPregunta="INSERT INTO tb_enviomails (FEC_PEMAIL, FEC_SEMAIL, COD_VEN, COD_CLI, EST_MAIL, EST_MAIL2, REF,EST_EMP)" +
		    		" VALUES(DATE_ADD(now(), INTERVAL 5 minute)," +newfecha2+
		    		" '"+codven+"','"+codi_clie+"','"+est_mail+"','"+est_mail2+"','"+ref+"','1');";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			
				if(op==0){
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
			    }	
			    else{
				  System.out.println("Se ingreso Correctamente los Mails "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
			   }
				objAccesoBD.cerrarConexion();
		
	}
	/**********************************************************************************************************/
   
    public void agregarReporte(String codCot,String ideCot,String ref){
		
//		AccesoBD objAccesoBD = new AccesoBD();
//		objAccesoBD.crearConexion();

		int codven=objGlo.COD_VEN;
		String codi_clie=objTranCotAutMant.codigocliente;
		String nomdia=objfec.fechaActual4();
		String fec=objfec.fechaActual();
		String newfecha2="";
		int tip_rep=3,cal_rep=1;
		int est=0;
		String hora="09:00:00";
		String obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE ENVIO" +
		" LA COTIZACION Nº"+codCot+"-"+ideCot+" "+ref+
		" LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
		
		System.out.println(nomdia);
		
		if(nomdia.equals("mié")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
			/*obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";*/
		}
		else if(nomdia.equals("jue")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
			/*obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";*/
			
		}else if(nomdia.equals("vie")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
			/*obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";*/
		}else if(nomdia.equals("sáb")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(2));
			/*obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";*/
		}else{
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
			/*obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 3 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";*/
		}
	   String insertarPregunta="INSERT INTO tb_reporte (COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP, HORA) " +
		    		" VALUES('"+codi_clie+"','"+codven+"','"+fec+"','"
			+newfecha2+"','"+tip_rep+"','"+cal_rep+"','"+obs+"','"+est+"','"+hora+"');";
	   //comentado para que no envie automaticamente @gcorreageek
//			System.out.println(insertarPregunta);
//			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
//			    if(op==0){
//				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
//			    }	
//			    else{
//				  System.out.println("Se ingreso Correctamente el reporte "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
//			    }
//				objAccesoBD.cerrarConexion();
	
	}
    /***************************************************************************************************************/
      public void agregarReporteCye(){
		
//		AccesoBD2 objAccesoBD2 = new AccesoBD2();
//		objAccesoBD2.crearConexion();

		int codven=objGlo.COD_VEN;
		String codi_clie=objTranCotAutMant.codigocliente;
		String nomdia=objfec.fechaActual4();
		String fec=objfec.fechaActual();
		String newfecha2="";
		int tip_rep=3,cal_rep=1;
		int est=0;
		String hora="09:00:00";
		String obs="";
		System.out.println(nomdia);
		if(nomdia.equals("mié")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(5));
			obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
		}
		else if(nomdia.equals("jue")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(5));
			obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
			
		}else if(nomdia.equals("vie")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(5));
			obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
		}else if(nomdia.equals("sáb")){
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(5));
			obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 5 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
		}else{
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(3));
			obs="OBSERVACION: MENSAJE AUTOMATICO, A ESTE CLIENTE SE LE PASO" +
			" COTIZACION HACE 3 DIAS LLAMARLO PARA VER NOVEDADES O AVERIGUAR SI HA CONTESTADO.";
		}
		//comentado para que no envie automaticamente @gcorreageek
	   String insertarPregunta="INSERT INTO tb_reporte (COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP, HORA) " +
		    		" VALUES('"+codi_clie+"','"+codven+"','"+fec+"','"
			+newfecha2+"','"+tip_rep+"','"+cal_rep+"','"+obs+"','"+est+"','"+hora+"');";
//			System.out.println(insertarPregunta);
//
//			int op= objAccesoBD2.ejecutarActualizacion(insertarPregunta);
//			
//			    if(op==0){
//				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
//			    }	
//			    else{
//				  System.out.println("Se ingreso Correctamente el reporte "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
//			    }
//				objAccesoBD2.cerrarConexion();
	
	}
    
    public int buscarRepetidos(){
    	
    	objTranCotAutMant = new TranCotizacionAutMant();
    	
    	AccesoBD objAccesoBD = new AccesoBD();
    	String codi_clie=objTranCotAutMant.codigocliente;
		objAccesoBD.crearConexion();
		String Pregunta="SELECT * from tb_enviomails " +
			   " where date(fec_pemail)=curdate() and cod_cli='"+codi_clie+"' and est_emp='1';";
		System.out.println(Pregunta);
		ResultSet rs = objAccesoBD.ejecutarConsulta(Pregunta);
		int dia=0;
		try {
		while(rs.next()){
			dia++;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
			
		return dia;
	}
    
    public int buscarRepetidos2(){
    	String codi_clie=objTranCotAutMant.codigocliente;
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String Pregunta="SELECT * from tb_reporte " +
			   " where fec_rep=curdate() and cod_cli='"+codi_clie+"';";
		System.out.println(Pregunta);
		ResultSet rs = objAccesoBD.ejecutarConsulta(Pregunta);
		int dia=0;
		try {
		while(rs.next()){
			dia++;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
			
		return dia;
	}
    
    /*******************************************************************************************************/
 
    public int buscarRepetidos2Cye(){
    	
    	String codi_clie=objTranCotAutMant.codigocliente;
		AccesoBD2 objAccesoBD2 = new AccesoBD2();
		objAccesoBD2.crearConexion();
		String Pregunta="SELECT * from tb_reporte " +
			   " where fec_rep=curdate() and cod_cli='"+codi_clie+"';";
		System.out.println(Pregunta);
		ResultSet rs = objAccesoBD2.ejecutarConsulta(Pregunta);
		int dia=0;
		try {
		while(rs.next()){
			dia++;
			}
		rs.close();	
		} catch (Exception e) {System.out.println(e);}
			
		return dia;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVista){
			if(objVistaPrevia==null||objVistaPrevia.isClosed()){
				objVistaPrevia= new VistaPrevia();
				//this.add(objVistaPrevia);
				objMenu.jDesktopPane1.add(objVistaPrevia);
				
				}
			try {objVistaPrevia.setSelected(true);
			} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==cboTipoCliente){
			aMostrar();
		}
		if(e.getSource()==btnEnviar){
			System.out.println(super.ekitCore.jtpMain.getText());
			envio();
//			if(buscarRepetidos()==0){
//				ingresarMailsAuto();
//			}
			if(buscarRepetidos2()==0){
		        //agregarReporte();
			}
			
			
		}
		if(e.getSource()==btnPrueba){
			pruebaEnviarCorreo();
		}
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
