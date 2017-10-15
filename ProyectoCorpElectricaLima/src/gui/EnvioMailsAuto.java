package gui;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

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

	
	public class EnvioMailsAuto  extends Ekit implements ActionListener{
		
		JFrame frame;
		JPanel panel;
		JButton btnIniciar,btnParar,btnReset;
		JLabel lblTime;
		//Timer timer;
		int segundos;//manejar el valor del contador
		boolean frozen;//manejar el estado del contadorpublic
		EnviarMail objEnviar;
		GUI objGUI;
		String texto,texto2,texto3,texto4,texto5,texto6;
		Globales objGlo;
		Fecha objfec;
		Logeo objLogeo= new Logeo();
		String nomven,nomcli,sexcli,fecp,fecs,referencia;
		Propiedades p=new Propiedades();
		
		EnvioMailsAuto() {
			
			super.ekitCore.jtpMain.setVisible(false);
			
			frozen = true; //iniciamos el estado en congelado
			segundos = 0;
			
			if(objLogeo.numorden==1){
				aMostrar();
			}else if(objLogeo.numorden==2){
				aMostrar2();
			}else{
				aMostrar3();
			}
    
			
		}
		
		 public String fecha(String fec){
				String cad="";
				for(int i=0 ;i<fec.length();i++){
					    if(i<10){
					    	cad=cad+fec.charAt(i);
					    }else{
					    	break;
					    }
				}
				return cad.trim();
			}
		
		public void envio2(){
			String fec=objfec.fechaActual();
			String correo1=objLogeo.correo;
			String cc="";
			String asunto1="";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			String ref=objLogeo.refe;
			//texto=texto.replace("[oa]", sexo);
			if(fecha(fecp).equals(fec)){
				asunto1=cargar2(0);
				
			}
			if(fecha(fecs).equals(fec)){
				cargar2(1);
				texto2=texto2.replace("[Asun]", ref.toUpperCase());
				asunto1=texto2;
			}

			for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(cc==null||cc.trim().equals("")){
				System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
					sale=objEnviar.Enviar1(correo1, asunto1, archivo1, mensaje1);			
			}
			else{
				System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar1(correo1,asunto1, archivo1, mensaje1);		
			}	
			if(sale==0){
				System.out.println("Se Mando su Mensaje!");
			}else{
				System.out.println("Hubo un ERROR!");
			}
				
		}
		
		/********************************************************************************************************/
		
		public void envioSolCli(){
			
			String correo1=objLogeo.mailcli,correo2=objLogeo.mailbcli;
			String asunto="";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			
			if(objLogeo.est_llamada.equals("2")){
				asunto=asunto(0);
				
			}else{
				asunto=asunto(1);
			}

			for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(correo2==null || correo2.equals("0") || correo2.equals("")){
				System.out.println(correo1+"|"+asunto+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar1(correo1, asunto, archivo1, mensaje1);
			}else{
				System.out.println(correo1+"|"+correo2+"|"+asunto+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.EnviarConCopia(correo1, correo2, asunto, mensaje1);
			}
			
			if(sale==0){
				//objGUI.mostrarAviso("Se Mando su Mensaje!");
				System.out.println("Se Mando su Mensaje!");
			}else{
				//objGUI.mostrarAviso("Hubo un ERROR!");
				System.out.println("Hubo un ERROR!");
			}
				
		}
/********************************************************************************************************/
		
		public void envioNoContestoCoti(){
			
			String correo1=objLogeo.mail1,correo2=objLogeo.mail2;
			String asunto="";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			asunto=asunto2();
				
			

			for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(correo2==null || correo2.equals("0") || correo2.equals("")){
				System.out.println(correo1+"|"+asunto+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar1(correo1, asunto, archivo1, mensaje1);
			}else{
				System.out.println(correo1+"|"+correo2+"|"+asunto+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.EnviarConCopia(correo1, correo2, asunto, mensaje1);
			}
			
			if(sale==0){
				//objGUI.mostrarAviso("Se Mando su Mensaje!");
				System.out.println("Se Mando su Mensaje!");
			}else{
				//objGUI.mostrarAviso("Hubo un ERROR!");
				System.out.println("Hubo un ERROR!");
			}
				
		}
		
		public void cargar(int num){
			String letra="";
			
			if(objLogeo.est_emp.equals("1")){
				if(num==0){
					letra=p.getProperty("seguimientoCot1")+"ENVIO PRIMER CORREO.txt";
				}else{
					letra=p.getProperty("seguimientoCot1")+"ENVIO SEGUNDO CORREO.txt";
				}
			}else{
				if(num==0){
					letra=p.getProperty("seguimientoCot2")+"ENVIO PRIMER CORREO.txt";
				}else{
					letra=p.getProperty("seguimientoCot2")+"ENVIO SEGUNDO CORREO.txt";
				}
			}
					   
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    InputStream in=null;
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
			
			
			if(objLogeo.est_emp.equals("1")){
				if(num==0){
					letra=p.getProperty("seguimientoCot1")+"ASUNTO PRIMER CORREO.txt";
				}else{
					letra=p.getProperty("seguimientoCot1")+"ASUNTO SEGUNDO CORREO.txt";
				}
			}else{
				
				if(num==0){
					letra=p.getProperty("seguimientoCot2")+"ASUNTO PRIMER CORREO.txt";
				}else{
					letra=p.getProperty("seguimientoCot2")+"ASUNTO SEGUNDO CORREO.txt";
				}
			}
					   
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    InputStream in=null;
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
		/***********************************************************************************************************/
		
		public void cargar3(int num){
			String letra="";
			
			if(num==0){
				letra=p.getProperty("contestareManiana")+"TE CONTESTARE MAÑANA.html";
			}else{
				letra=p.getProperty("recibiSolicitud")+"RECIBI SOLICITUD.html";
			}
			
					   
			System.out.println(letra);
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    InputStream in=null;
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
		}
		public String asunto(int num){
			String letra="";
				
			if(num==0){
				letra=p.getProperty("contestareManiana")+"ASUNTO.txt";		
			}else{
				letra=p.getProperty("recibiSolicitud")+"ASUNTO.txt";
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
		
		public void cargar4(){
			String letra="";
			
			letra=p.getProperty("noRespondeCotizacion")+"NO CONTESTO COTIZACION.html";
					   
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
		        	
		        		 texto5=texto5+linea;
		         }
		        // System.out.println(""+texto);
		        
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         //
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }		    
		}
		
		public String asunto2(){
			String letra="";
				
			letra=p.getProperty("noRespondeCotizacion")+"ASUNTO.txt";		
					   
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
		        	
		        		 texto6=texto6+linea;
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
			return texto6;		    
		}
		
		public void aMostrar(){
			texto="";
			texto2="";
			String fechact=objfec.fechaActual();
			String sexo="";
			String refi="";
			sexcli=objLogeo.sexcli;
			nomven=objLogeo.nomvend;
			nomcli=objLogeo.nomclien;
			fecp=objLogeo.fecp;
			fecs=objLogeo.fecs;
			referencia=objLogeo.refe;
			String ref=objLogeo.refe;
			
			//señores="Estimado(a) Sr(a). "+objEnvioCot.nombreCliente+"\n\n";
			if(sexcli.equals("0")){
				sexo="o(a)";
			}else if(sexcli.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			
			if(referencia.equals("")){
				refi="";
			}else{
				refi=referencia;
			}
			
			if(fecha(fecp).compareTo(fechact)==0){
				cargar(0);
				texto=texto.replace("[oa]", sexo);
				texto=texto.replace("[Nombre]", nomcli );
				texto=texto.replace("[Vendedor]", nomven);
				texto=texto.replace("[Ref]", refi.toLowerCase());
				super.ekitCore.jtpMain.setText(texto);
			
			}else{
				cargar(1);
				texto=texto.replace("[oa]", sexo);
				texto=texto.replace("[Nombre]", nomcli );
				texto=texto.replace("[Vendedor]", nomven);
				texto=texto.replace("[Ref]", refi.toLowerCase());
				super.ekitCore.jtpMain.setText(texto);
			}
				
		}
		/***************************************************************************************************/
		public void aMostrar2(){
			
			texto3="";
			texto4="";
			String sexocli="",nomvendedor="",nomcliente="",sexo="",est_llamada="";
			
			sexocli=objLogeo.sexocli;
			nomvendedor=objLogeo.nvendeor;
			nomcliente=objLogeo.ncli;
			est_llamada=objLogeo.est_llamada;
			
			if(sexocli.equals("0")){
				sexo="o(a)";
			}else if(sexocli.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			
			if(est_llamada.equals("2")){
				cargar3(0);
				texto3=texto3.replace("[oa]", sexo);
				texto3=texto3.replace("[Nombre]", nomcliente );
				texto3=texto3.replace("[Vendedor]", nomvendedor);
				super.ekitCore.jtpMain.setText(texto3);
			}else{
				cargar3(1);
				texto3=texto3.replace("[oa]", sexo);
				texto3=texto3.replace("[Nombre]", nomcliente );
				texto3=texto3.replace("[Vendedor]", nomvendedor);
				super.ekitCore.jtpMain.setText(texto3);
			}
			
			
				
		}
		/***************************************************************************************************/
		public void aMostrar3(){
			
			texto3="";
			texto4="";
			String sexocli="",nomvendedor="",nomcliente="",sexo="";
			
			sexocli=objLogeo.sexcliente;
			nomvendedor=objLogeo.vendedor;
			nomcliente=objLogeo.conacli;
			
			if(sexocli.equals("0")){
				sexo="o(a)";
			}else if(sexocli.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			cargar4();
			texto5=texto5.replace("[oa]", sexo);
			texto5=texto5.replace("[Nombre]", nomcliente );
			texto5=texto5.replace("[Vendedor]", nomvendedor);
			super.ekitCore.jtpMain.setText(texto5);
				
		}
		public void cambiarAenviado() {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_ENVIOMAILS SET EST_MAIL = 1 " +
					   "WHERE fec_pemail='"+fecp+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
		
		public void cambiarAenviado2() {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_ENVIOMAILS SET EST_MAIL2 = 1 " +
					   "WHERE fec_semail='"+fecs+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
		
        public void cambiarAenviado3(String cod) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_REPORTESOLPROVE SET EST_ENVIO_MAIL = 1 " +
					   "WHERE cod_sol='"+cod+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
        public void cambiarAenviado4(String cod) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_REPORTESOLPROVE SET EST_ENVIO_MAIL2 = 1 " +
					   "WHERE cod_sol='"+cod+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
        
        public void cambiarAenviado5(String cod) {
			
			AccesoBD objA= new AccesoBD();
			
			objA.crearConexion();
			String sql="UPDATE TB_ENVIOMAILSCLIENTE SET EST_ENVIO = 1 " +
					   "WHERE cod_envio='"+cod+"';" ;
					
			System.out.println(sql);
			objA.ejecutarActualizacion(sql);
			
			objA.cerrarConexion();
			
		}
        
        public void agregarReporte(){
			
//			AccesoBD objAccesoBD = new AccesoBD();
//			objAccesoBD.crearConexion();

			int codven=1;
			String cod_cli=objLogeo.codigocliente;
			String fec=objfec.fechaActual();
			String newfecha2="";
			int tip_rep=3,cal_rep=3;
			int est=0;
			String obs="";
			String hora="09:00:00";
			//System.out.println(nomdia);
			
			newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
			obs="LLAMAR A ESTE CLIENTE DE TODAS MANERAS YA QUE SE LE HA HECHO COTIZACION Y SEGUIMIENTO " +
				"Y A PESAR DE TODO NO CONTESTA PARA DEFINIR LA VENTA O REPROGRAMARLO.";


				String insertarPregunta="INSERT INTO tb_reporte (COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP, HORA) " +
			    		" VALUES('"+cod_cli+"','"+codven+"','"+fec+"','"
				+newfecha2+"','"+tip_rep+"','"+cal_rep+"','"+obs+"','"+est+"','"+hora+"');";
//				System.out.println(insertarPregunta);

//				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
//				
//				    if(op==0){
//					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
//				    }	
//				    else{
//					  System.out.println("Se ingreso Correctamente el reporte "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
//				    }
//					objAccesoBD.cerrarConexion();
		
		}
 }
			
	
		
		
		
		
		
		

	

	
	
	



