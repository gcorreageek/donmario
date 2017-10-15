package miLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class CargadorDeTexto {
	
	public CargadorDeTexto(){
		
	}
	public static Integer tamaño(BufferedReader br){
		   String linea;
		   Integer tama=0;
		try {
			while((linea=br.readLine())!=null){
				if(linea.equals("**")){break;}
				tama=tama+1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tama;
		
	}
	public static Integer tamaño1(BufferedReader br){
		String linea1;
		Integer tama1=0;
		try {
			while((linea1=br.readLine())!=null){
				if(linea1.equals("**")){break;}
				tama1=tama1+1;
			}
		} catch (IOException e) {
			// e.: handle exception
			e.printStackTrace();
		}
		return tama1;
		
	}
	 public static String[] cargar(String letra){
			String[] arregloTextos=null;
		
		
			File archivo = null;
		    FileReader fr = null;
		    FileReader fr2 = null;
		    BufferedReader br = null;
		    BufferedReader br2 = null;
		    //String[] apellidos = new String[nombres.length];
			try {
				archivo = new File (letra);
		        fr = new FileReader (archivo);
		        br = new BufferedReader(fr);
		        
		         String linea;
		         int count=-1;
		       arregloTextos =  new String[tamaño(br)];
		       fr2 = new FileReader (archivo);
		       br2 = new BufferedReader(fr2);
		       while((linea=br2.readLine())!=null){
		    	  // System.out.println("oe k!");
		    	   if(linea.equals("**")){break;}
		    	  /* System.out.println("Esto es la linea:"+linea);
		    	   System.out.println(linea.indexOf("["));
		    	   String ar=linea.substring(linea.indexOf("["), linea.indexOf("]")+1);
					System.out.println("El nombre es:"+ar);*/
		    	   /*count=count+1;
					String ar=linea.substring(linea.indexOf("["), linea.indexOf("]")+1);
					System.out.println("El nombre es:"+ar);
					arregloTextos[count]=ar;*/
					Integer valor1=linea.indexOf("[");
					Integer valor2=linea.indexOf("]");
		    	   if(valor1!=-1&&valor2!=-1){
		    		   //System.out.println("Esto es la linea:"+linea);
		    		   //System.out.println(linea.indexOf("["));
						count=count+1;
						String ar=linea.substring(linea.indexOf("["), linea.indexOf("]")+1);
						System.out.println("El nombre es:"+ar);
						arregloTextos[count]=ar;
						
					}	else{
						System.out.println("ERROR-"+"Se puso mal los []");
						GUI.mostrarAviso("ERROR!\nEl error es por los []\ndel Archivo PARAMETROS.txt");
						GUI.mostrarAviso("Porfavor Cerrar la Aplicacion de Correo masivo\ny poner el nombre []");
					}
		    	   if(valor1!=-1 && valor2!=-1){
		    		   count=count+1;
		    		   String ar= linea.substring(linea.indexOf("["), linea.indexOf("[")+1);
		    		   System.out.println("El nombre es:"+ar);
		    		   arregloTextos[count]=ar;
		    	   }else{
		    		   System.out.println("ERROR-"+"Se puso mal los[]");
		    		   GUI.mostrarAviso("ERROR!\n El error es por los []\ndel Archivo PARAMETROS.txt");
		    		   GUI.mostrarAviso("Porfavor Cerrar la Aplicacion de Correo masivo\ny poner el nombre []");
		    		   
		    	   }
		         }
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }

		    return arregloTextos;
		}
	

}
