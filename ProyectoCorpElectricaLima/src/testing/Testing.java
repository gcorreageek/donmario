package testing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String cadena="PZA";
//		int numero=10;
//		System.out.println("retorno: "+isNumber(cadena));
//		System.out.println("retorno2: "+isNumber(numero+""));
		
		String cadena = "ABRAZADERA CONDUIT DE 1 OREJA DE 1/2 ";
		String buscar="CONDUIT";
		String reemplazar="TUBOS CURVOS";
//		String salida="";
//		
//		String cad="",cad2="";
//		
//		for (int i=0;i<cadena.length();i++) {
//			
//			cad=""+cadena.charAt(i);
//			
//			if(cad.equals(" ")){
//				if(cad2.equals(buscar)){
//					salida=reemplazar;
//					cad2="";
//				}else{
//					salida+=cad2+" ";
//					cad2="";
//				}
//			}else{
//				cad2+=cad;
//			}
//			
//		}
//		
//		//System.out.println(salida);
//		
//		String sentence = "Define, Measure, Analyze, Design and Verify";

        String str = cadena.replace(buscar, reemplazar);
        System.out.println(str);

	}
	
	 public static boolean isNumber(String string){
 	    if(string ==null || string.isEmpty()){
 	       return false;
 	    }
 	    int i=0;
 	    if(string.charAt(0)=='-'){
 		if(string.length()>1){
 		  i++;
 	        }else{
 		   return false;
 		}
 	    }
 	    for (; i<string.length();i++){
 		if(!Character.isDigit(string.charAt(i))){
 		   return false;
 		}
 	    }
 	    return true;
 	}	
	 
	 public String getObjects(String databaseConnectable) throws NamingException, SQLException, ParserConfigurationException, IOException, TransformerException{
         Statement statement = null;
         Connection conn = null;
         ResultSet rs = null;
       try{
        // Aqui va la crear la conexion a la bd, consulta del rs, etc.
                 
         } finally {
                 if (rs != null){
                         try {
                                 rs.close();
                         } catch (SQLException e) {
                                 // TODO Controlar exception
                                 e.printStackTrace();
                         }       
                 }
                 try {
                         statement.close();
                 } catch (SQLException e) {
                         // TODO Controlar exception
                         e.printStackTrace();
                 }       
                 
                 if (conn != null){
                         try {
                                 conn.close();
                         } catch (SQLException e) {
                                 // TODO Controlar exception
                                 e.printStackTrace();
                         }       
                 }
         }
	return databaseConnectable;
  }

}
