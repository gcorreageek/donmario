package gui;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Propiedades;

import miLib.AccesoBD;
import miLib.EnviarMail;
import miLib.Fecha;
import miLib.GUI;
import beans.Globales;

import com.hexidec.ekit.Ekit;


	
	
	public class EnvioMailsAutoProveProdPrec  extends Ekit implements ActionListener{
		JFrame frame;
		JPanel panel;
		JButton btnIniciar,btnParar,btnReset;
		JLabel lblTime;
		Timer timer;
		int segundos;//manejar el valor del contador
		boolean frozen;//manejar el estado del contadorpublic
		EnviarMail objEnviar;
		GUI objGUI;
		String texto,texto2,texto3,texto4;
		Globales objGlo;
		Fecha objfec;
		Logeo objLogeo;
		String nomven,nomprove,sexprove,fecp,fecs,cod_ref,referencia;
		Propiedades p=new Propiedades();
		
		EnvioMailsAutoProveProdPrec() {
			
			super.ekitCore.jtpMain.setVisible(false);
			
			 //iniciamos el estado en congelado
			segundos = 0;
			if(objLogeo.est==1){
				aMostrar();
			}else{
				aMostrar2();
			}
			
			
		}
		
		 public String fecha(String fec){
				String cad="";
				for(int i=0 ;i<fec.length();i++){
					    if(i<16){
					    	cad=cad+fec.charAt(i);
					    }else{
					    	break;
					    }
				}
				return cad.trim();
			}
	 /****************************************************************************************************************************************/
	 /******************************************ENVIO DE MAILS PROVEEDORES PARA PRECIOS Y PRODUCTOS*******************************************/
     /****************************************************************************************************************************************/
		public void envio2(){
			
			String fec=objfec.fechaActual2();
			String correo1=objLogeo.correoProv;
			String cc="";
			String asunto1="";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			String ref="";
			
			if(fecha(fecp).compareTo(fecha(fec))==0){
				if(cod_ref.equals("CP1")){
					asunto1=cargar2(0);
				}else{
					asunto1=cargar2(2);
				}
				
			}else{
                if(cod_ref.equals("CP1")){
                	cargar2(1);
					texto2=texto2.replace("[Asun]", ref.toUpperCase());
					asunto1=texto2;
				}else{
					cargar2(3);
					texto2=texto2.replace("[Asun]", ref.toUpperCase());
					asunto1=texto2;
				}
			}
			
			for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(cc==null||cc.trim().equals("")){
				System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
					sale=objEnviar.Enviar2(correo1, asunto1, archivo1, mensaje1);			
			}
			else{
				System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar2(correo1,asunto1, archivo1, mensaje1);		
			}	
			if(sale==0){
				System.out.println("Se Mando su Mensaje!");
			}else{
				System.out.println("Hubo un ERROR!");
			}
				
		}
		
		public void cargar(int num){
			String letra="";
			
			if(num==0){
				letra=p.getProperty("cAutoProveedorProductos")+"ENVIO PRIMER CORREO.txt";
			}else if(num==1){
				letra=p.getProperty("cAutoProveedorProductos")+"ENVIO SEGUNDO CORREO.txt";
			}else if(num==2){
				letra=p.getProperty("cAutoProveedorProductos")+"ENVIO PRIMER CORREO.txt";
			}else{
				
				String nomdia=objfec.fechaActual4();
				String nom=rutaArchivo();
				
				if(nomdia.equals("lun")){
					
					letra = p.getProperty("cAutoSolProve")+"lunes/"+nom;
					
				}else if(nomdia.equals("mar")){
					
					letra = p.getProperty("cAutoSolProve")+"martes/"+nom;
					
				}else if(nomdia.equals("mié")){
					
					letra = p.getProperty("cAutoSolProve")+"miercoles/"+nom;
					
				}else if(nomdia.equals("jue")){
					
					letra = p.getProperty("cAutoSolProve")+"jueves/"+nom;
					
				}else if(nomdia.equals("vie")){
					
					letra = p.getProperty("cAutoSolProve")+"viernes/"+nom;
					
				}else if(nomdia.equals("sáb")){
					
					letra = p.getProperty("cAutoSolProve")+"sabado/"+nom;
					
				}else{
					letra = "";
				}
				
			}
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    
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
		        // System.out.println(""+texto);
		        
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
		
		public String cargar2(int num){
			String letra="";
			
			if(num==0){
				letra=p.getProperty("cAutoProveedorProductos")+"ASUNTO PRIMER CORREO.txt";
			}else if(num==1){
				letra=p.getProperty("cAutoProveedorProductos")+"ASUNTO SEGUNDO CORREO.txt";
			}else if(num==2){
				letra=p.getProperty("cAutoProveedorProductos")+"ASUNTO PRIMER CORREO.txt";
			}else{
				letra=p.getProperty("cAutoProveedorProductos")+"ASUNTO SEGUNDO CORREO.txt";
			}
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		   
			try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (letra);
		         fr = new FileReader (archivo);
		       //  in = getClass().getResourceAsStream("/File/"+letra);
		         /* InputStream in = getClass().getResourceAsStream("archivo.txt");
	        		BufferedReader bufferde = new BufferedReader(new
					InputStreamReader(in)); */
		         //br = new BufferedReader(new InputStreamReader(in));
		         br = new BufferedReader(fr);
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		        	
		        		 texto2=texto2+linea;
		         }
		        // System.out.println(""+texto);
		        
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
			return texto2;		    
		}
		
		public void aMostrar(){
			texto="";
			texto2="";
			String fechact=objfec.fechaActual2();
			String sexo="";
			String refi="";
			sexprove=objLogeo.sexProv;
			nomven=objLogeo.nomvendProv;
			nomprove=objLogeo.nomProv;
			fecp=objLogeo.fecpProv;
			fecs=objLogeo.fecsProv;
			cod_ref=objLogeo.codRef;
			referencia="";
			
			
			//señores="Estimado(a) Sr(a). "+objEnvioCot.nombreCliente+"\n\n";
			if(sexprove.equals("0")){
				sexo="o(a)";
			}else if(sexprove.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			
			if(referencia.equals("")){
				refi="";
			}else{
				refi=referencia;
			}
			if(cod_ref.equals("CP1")){
				//CP1
				if(fecha(fecp).compareTo(fecha(fechact))==0){
					
					cargar(0);
					texto=texto.replace("[oa]", sexo);
					texto=texto.replace("[Nombre]", nomprove );
					texto=texto.replace("[Vendedor]", nomven);
					texto=texto.replace("[Ref]", refi.toLowerCase());
					super.ekitCore.jtpMain.setText(texto);
				
				}else{
					cargar(1);
					texto=texto.replace("[oa]", sexo);
					texto=texto.replace("[Nombre]", nomprove );
					texto=texto.replace("[Vendedor]", nomven);
					texto=texto.replace("[Ref]", refi.toLowerCase());
					super.ekitCore.jtpMain.setText(texto);
				}
			}else{
				//CP2
				if(fecha(fecp).compareTo(fecha(fechact))==0){
					cargar(2);
					texto=texto.replace("[oa]", sexo);
					texto=texto.replace("[Nombre]", nomprove );
					texto=texto.replace("[Vendedor]", nomven);
					texto=texto.replace("[Ref]", refi.toLowerCase());
					super.ekitCore.jtpMain.setText(texto);
				
				}else{
					cargar(3);
					texto=texto.replace("[oa]", sexo);
					texto=texto.replace("[Nombre]", nomprove );
					texto=texto.replace("[Vendedor]", nomven);
					texto=texto.replace("[Ref]", refi.toLowerCase());
					super.ekitCore.jtpMain.setText(texto);
				}
				
			}
			
				
		}
		/****************************************************************************************************************************/
		/****************************************************************************************************************************/
		
		public String  Asunto(){
			
			String letra="";
			if(objLogeo.est==2){
			    letra=p.getProperty("cAutoSolProve")+"Contesto/ASUNTO SI.txt";
			}else {
				letra=p.getProperty("cAutoSolProve")+"Contesto/ASUNTO NO.txt";
			}
           
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		   
			try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (letra);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		        	
		        		 texto4=texto4+linea;
		         }
		        // System.out.println(""+texto);
		        
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
			return texto4;		    
		}
		
		public void aMostrar2(){
			
			texto3="";
			texto4="";
			String sexo="",refi="",letra="";
			
			//señores="Estimado(a) Sr(a). "+objEnvioCot.nombreCliente+"\n\n";
			if(objLogeo.sex_prove.equals("0")){
				sexo="o(a)";
			}else if(objLogeo.sex_prove.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			
			if(objLogeo.est==2){
				letra=p.getProperty("cAutoSolProve")+"Contesto/CONTESTO PROVEEDOR SI.html";
			}else{
				letra=p.getProperty("cAutoSolProve")+"Contesto/CONTESTO PROVEEDOR NO.html";
			}
			
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    
			try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (letra);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		        	
		        		 texto3=texto3+linea;
		         }
		        // System.out.println(""+texto);
		        
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
			
		      texto3=texto3.replace("[oa]", sexo);
		      texto3=texto3.replace("[Nombre]", objLogeo.per_prove );
		      texto3=texto3.replace("[Vendedor]", objLogeo.nVendedor);
		      texto3=texto3.replace("[Ref]", refi.toLowerCase());
			  super.ekitCore.jtpMain.setText(texto3);
	
		}
		
         public void envio3(){
			
			String correo1=objLogeo.mail_prove;
			String cc="";
			String asunto1="";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			String ref="";
			
			
			asunto1=Asunto();
			texto4=texto4.replace("[Asun]", ref.toUpperCase());
			asunto1=texto4;
			
	    	for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(cc==null||cc.trim().equals("")){
				System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
					sale=objEnviar.Enviar2(correo1, asunto1, archivo1, mensaje1);			
			}
			else{
				System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar2(correo1,asunto1, archivo1, mensaje1);		
			}	
			if(sale==0){
				System.out.println("Se Mando su Mensaje!");
			}else{
				System.out.println("Hubo un ERROR!");
			}
				
		}
		
        /***********************************************CREACIONES DE LOS METODOS*********************************************************/

		public void cambiarAenviado(String cad) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_ENVIOMAILSPROVE SET EST_MAIL = 1 " +
					   "WHERE cod_ref='"+cad+"' and fec_pemail='"+fecp+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
		
		public void cambiarAenviado2(String cad) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_ENVIOMAILSPROVE SET EST_MAIL2 = 1 " +
					   "WHERE cod_ref='"+cad+"' and fec_semail='"+fecs+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
		
        public void cambiarAenviado3(String cad) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_SOLPROVE SET EST_ENVIO_MAIL = 1 " +
					   "WHERE cod_solprove='"+cad+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
		
		
		public  String rutaArchivo(){
			
			try {
				String nomdia=objfec.fechaActual4();
				String tiempo=objfec.fechaActual5();
				int hora=Integer.parseInt(tiempo);
				
				String nombres="",momenDia="",ruta="";
				int contador=0;
				String carpeta = "";
				if(nomdia.equals("lun")){
				
					carpeta = p.getProperty("cAutoSolProve")+"lunes";
					
				}else if(nomdia.equals("mar")){
					
					carpeta = p.getProperty("cAutoSolProve")+"martes";
					
				}else if(nomdia.equals("mié")){
					
					carpeta = p.getProperty("cAutoSolProve")+"miercoles";
					
				}else if(nomdia.equals("jue")){
					
					carpeta = p.getProperty("cAutoSolProve")+"jueves";
					
				}else if(nomdia.equals("vie")){
					
					carpeta = p.getProperty("cAutoSolProve")+"viernes";
					
				}else if(nomdia.equals("sáb")){
				
					carpeta = p.getProperty("cAutoSolProve")+"sabado";
					
				}else{
					carpeta = "";
				}
				File directorio = new File (carpeta);
				File[] archivos = directorio.listFiles();
				for(File file:archivos){
					contador++;
						nombres = file.getName();
						momenDia=PalabraAlReves(nombres);
						//System.out.println("momendia:"+momenDia);
						if(momenDia.equals("MAÑANA.") && hora<12){
							ruta=nombres;
							break;
						}else if(momenDia.equals("TARDE.") && hora>=12){
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
		
		
 }
			
	
		
		
		
		
		
		

	

	
	
	



