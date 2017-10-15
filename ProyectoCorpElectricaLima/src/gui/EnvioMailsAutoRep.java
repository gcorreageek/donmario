package gui;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
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


	
	
	public class EnvioMailsAutoRep  extends Ekit implements ActionListener{
		JFrame frame;
		JPanel panel;
		JButton btnIniciar,btnParar,btnReset;
		JLabel lblTime;
		Timer timer;
		int segundos;//manejar el valor del contador
		boolean frozen;//manejar el estado del contadorpublic
		EnviarMail objEnviar;
		GUI objGUI;
		String texto;
		Globales objGlo;
		Fecha objfec;
		Logeo objLogeo;
		String nom_ven,nom_cli,sex_cli,fecc_rep,cod_cli;
		Propiedades p=new Propiedades();
		
		EnvioMailsAutoRep() {
			
			super.ekitCore.jtpMain.setVisible(false);
			
			frozen = true; //iniciamos el estado en congelado
			segundos = 0;
			aMostrar2();
		}
		
		public void envio3(){
			String fec=objfec.fechaActual();
			String correo1=objLogeo.correo_rep;
			String cc="";
			String asunto1="CALIDAD Y EXPERIENCIA – ELECTRO CORNEJO";
			String archivo1="";
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			
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
				System.out.println("Se Mando su Mensaje del Reporte!");
			}else{
				System.out.println("Hubo un ERROR!");
			}
				
		}
		public  String rutaArchivo(){
			
			try {
				String nomdia=objfec.fechaActual4();
				String tiempo=objfec.fechaActual5();
				//int hora=Integer.parseInt(tiempo);
				
				String nombres="",ruta="";
				int contador=0;
				String carpeta = "";
				if(nomdia.equals("lun")){
					carpeta = p.getProperty("reporte")+"lunes";
				}else if(nomdia.equals("mar")){
					carpeta = p.getProperty("reporte")+"martes";
				}else if(nomdia.equals("mié")){
					carpeta = p.getProperty("reporte")+"miercoles";
				}else if(nomdia.equals("jue")){
					carpeta = p.getProperty("reporte")+"jueves";
				}else if(nomdia.equals("vie")){
					carpeta = p.getProperty("reporte")+"viernes";
				}else if(nomdia.equals("sáb")){
					carpeta = p.getProperty("reporte")+"sabado";
				}else{
					carpeta = "";
				}
				File directorio = new File (carpeta);
				File[] archivos = directorio.listFiles();
				for(File file:archivos){
					contador++;
						nombres = file.getName();
						ruta=nombres;
						
				}

			return ruta;
			
			} catch (Exception e) {
				   System.out.println("NADAAAA");
			}
			return "";

			}
			
			/****************************************************************************************************************/
			
		
		public void cargar(int num){
			
			String nom=rutaArchivo();
			String nomdia=objfec.fechaActual4();
			String letra="";
			
			if(num==2){
				
				if(nomdia.equals("lun")){
					letra = p.getProperty("reporte")+"lunes/"+nom;
				}else if(nomdia.equals("mar")){
					letra = p.getProperty("reporte")+"martes/"+nom;
				}else if(nomdia.equals("mié")){
					letra = p.getProperty("reporte")+"miercoles/"+nom;
				}else if(nomdia.equals("jue")){
					letra = p.getProperty("reporte")+"jueves/"+nom;
				}else if(nomdia.equals("vie")){
					letra = p.getProperty("reporte")+"viernes/"+nom;
				}else if(nomdia.equals("sáb")){
					letra = p.getProperty("reporte")+"sabado/"+nom;
				}else{
					letra = "";
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
		
		public void aMostrar2(){
			texto="";
			String fechact=objfec.fechaActual();
			String sexo="";
			sex_cli=objLogeo.sex_clie;
			nom_ven=objLogeo.nom_vendedor;
			nom_cli=objLogeo.nom_clien;
			fecc_rep=objLogeo.fecc_rep;
			
			//señores="Estimado(a) Sr(a). "+objEnvioCot.nombreCliente+"\n\n";
			if(sex_cli.equals("0")){
				sexo="o(a)";
			}else if(sex_cli.equals("1")){
				sexo="o";
			}else{
				sexo="a";
			}
			
			
				cargar(2);
				texto=texto.replace("[oa]", sexo);
				texto=texto.replace("[Nombre]", nom_cli );
				texto=texto.replace("[Vendedor]", nom_ven);
				super.ekitCore.jtpMain.setText(texto);
			
				
		}
		
		 public void agregarReporte(){
				
//				AccesoBD objAccesoBD = new AccesoBD();
//				objAccesoBD.crearConexion();

				int codven=objGlo.COD_VEN;
				cod_cli=objLogeo.cod_cli;
				String nomdia=objfec.fechaActual4();
				String fec=objfec.fechaActual();
				String newfecha2="";
				int tip_rep=3,cal_rep=3;
				int est=0;
				String obs="";
				String hora="09:00:00";
				System.out.println(nomdia);
				if(nomdia.equals("mié")){
					newfecha2=objfec.convrtidorFec(objfec.FechaRep(5));
					obs="NO SE LE UBICO A ESTE CLIENTE SE LE ENVIO UN MENSAJE EN AUTOMATICO LLAMARLO NUEVAMENTE PARA VER NOVEDADES.";
				}
				else if(nomdia.equals("jue")){
					newfecha2=objfec.convrtidorFec(objfec.FechaRep(4));
					obs="NO SE LE UBICO A ESTE CLIENTE SE LE ENVIO UN MENSAJE EN AUTOMATICO LLAMARLO NUEVAMENTE PARA VER NOVEDADES.";
					
				}else if(nomdia.equals("vie")){
					newfecha2=objfec.convrtidorFec(objfec.FechaRep(4));
					obs="NO SE LE UBICO A ESTE CLIENTE SE LE ENVIO UN MENSAJE EN AUTOMATICO LLAMARLO NUEVAMENTE PARA VER NOVEDADES.";
				}else if(nomdia.equals("sáb")){
					fec=objfec.convrtidorFec(objfec.FechaRep(1));
					newfecha2=objfec.convrtidorFec(objfec.FechaRep(1));
				}else{
					newfecha2=objfec.convrtidorFec(objfec.FechaRep(3));
					obs="NO SE LE UBICO A ESTE CLIENTE SE LE ENVIO UN MENSAJE EN AUTOMATICO LLAMARLO NUEVAMENTE PARA VER NOVEDADES.";
				}

					 String insertarPregunta="INSERT INTO tb_reporte (COD_CLI, COD_VEN, FEC_REP, FECC_REP, TIP_REP, CAL_REP, OBS_REP, EST_REP, HORA) " +
				    		" VALUES('"+cod_cli+"','"+codven+"','"+fec+"','"
					+newfecha2+"','"+tip_rep+"','"+cal_rep+"','"+obs+"','"+est+"','"+hora+"');";
					//comentado para que no envie automaticamente @gcorreageek
//					System.out.println(insertarPregunta);

//					int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
//					
//					    if(op==0){
//						System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
//					    }	
//					    else{
//						  System.out.println("Se ingreso Correctamente el reporte "+"¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
//					    }
//						objAccesoBD.cerrarConexion();
			
			}
		
 }
			
	
		
		
		
		
		
		

	

	
	
	



