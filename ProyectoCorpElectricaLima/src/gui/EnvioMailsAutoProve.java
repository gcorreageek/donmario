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

import miLib.EnviarMailProve;
import miLib.Fecha;
import miLib.GUI;
import miLib.PasarProdExcel;
import beans.Globales;

import com.hexidec.ekit.Ekit;


	
	
	public class EnvioMailsAutoProve  extends Ekit implements ActionListener{
		JFrame frame;
		JPanel panel;
		JButton btnIniciar,btnParar,btnReset;
		JLabel lblTime;
		Timer timer;
		int segundos;//manejar el valor del contador
		boolean frozen;//manejar el estado del contadorpublic
		EnviarMailProve objEnviar;
		GUI objGUI;
		String texto,texto2;
		Globales objGlo;
		Fecha objfec;
		TranCotizacionAutomatica objTCotAut;
		String nomven,nomprove,sexprove,fecp,fecs,referencia;
		PasarProdExcel objPasarProdCorreo;
		Propiedades p=new Propiedades();
		
		EnvioMailsAutoProve() {
			
			super.ekitCore.jtpMain.setVisible(false);
			
			frozen = true; //iniciamos el estado en congelado
			segundos = 0;
			aMostrar();
		}
		
		public String retornaPalabra(String textoCompleto){
			String texto="";
			String nombre= textoCompleto;
			int c=0;
			int buscado = 0;
			for (int i = 0; i < nombre.length(); i++) {
				c=c+1;
				int reg=nombre.indexOf("\\", nombre.length()-c);	
				if(reg!=-1){
					buscado=reg;
					break;
				}
			}
			texto=nombre.substring(buscado+1, nombre.length());
			return texto;
		}
		
		public String retornaNombre(String cad){
			
			String texto="",palabra="";
			int cont=0;
			
			for(int i=0;i<cad.length();i++){
				texto=""+cad.charAt(i);
				if(texto.equals("P")){
					cont++;
				}
				if(cont>=3){
					palabra+=texto;
				}
			}

			return palabra;
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
		
		public void envio1(){
			
			String fec=objfec.fechaActual();
			String correo1=objTCotAut.correo;
			String cc="";
			String asunto1="";
			String archivo1=objPasarProdCorreo.fileGlobal;
			String mensaje1=super.ekitCore.jtpMain.getText();
			int sale = 1;
			String sCadenaInvertida = "";
			String nombreRuta="";
			String pal="";
			
			if(!archivo1.trim().equals("")){
			 pal=retornaNombre(archivo1);	
			}
			asunto1=cargar2(0);

			for (int x=archivo1.length()-1;x>=0;x--)
				sCadenaInvertida = sCadenaInvertida + archivo1.charAt(x);
			
			if(cc==null||cc.trim().equals("")){
				System.out.println(correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
					sale=objEnviar.Enviar(correo1, asunto1,pal,archivo1,mensaje1);			
			}
			else{
				System.out.println(cc+"|"+correo1+"|"+asunto1+"|"+nombreRuta+"|"+archivo1+"|"+mensaje1);
				sale=objEnviar.Enviar(correo1,asunto1,pal,archivo1,mensaje1);		
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
				letra=p.getProperty("proveedorProductosCot")+"ENVIO PRIMER CORREO.txt";
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
		
		public String cargar2(int num){
			String letra="";
			
			if(num==0){
				letra=p.getProperty("proveedorProductosCot")+"ASUNTO PRIMER CORREO.txt";
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
		
		public void aMostrar(){
			
			texto="";
			texto2="";
			String sexo="";
			String refi="";
			sexprove=objTCotAut.sexprove;
			nomven=objGlo.NOM_VEN;
			nomprove=objTCotAut.nomprove;
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
			
			cargar(0);
			texto=texto.replace("[oa]", sexo);
			texto=texto.replace("[Nombre]", nomprove );
			texto=texto.replace("[Vendedor]", nomven);
			texto=texto.replace("[Ref]", refi.toLowerCase());
			super.ekitCore.jtpMain.setText(texto);
				
		}
		
		
 }
			
	
		
		
		
		
		
		

	

	
	
	



