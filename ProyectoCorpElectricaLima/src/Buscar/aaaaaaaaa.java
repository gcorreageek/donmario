/**
 * 
 */
package Buscar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @author Daniel
 *
 */
public class aaaaaaaaa {

	/**
	 * 
	 */
	public aaaaaaaaa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String file;
	    //file = "//Willy/d(d)/SOLICITUD_PROVEEDORES/FALTANTES_FERRE_MIGUEL.xls";
	    //tblSolicitud.getValueAt(i, 5).toString();
	    //file.replaceAll("D:/SOLICITUD_PROVEEDORES/", "//Willy/d(d)/SOLICITUD_PROVEEDORES/");
   	    //System.out.println(""+file);
		/*File dir = new File("//Willy/d(d)/SOLICITUD_PROVEEDORES/");
		String[] ficheros = dir.list();
		if (ficheros == null)
			  System.out.println("No hay ficheros en el directorio especificado");
			else { 
			  for (int x=0;x<15;x++)
			    System.out.println(ficheros[x]);
			}
		
	*/
	    String file = "//Willy/d(d)/SOLICITUD_PROVEEDORES/"+"CRUCETAMADERA.xls";
	    //tblSolicitud.getValueAt(i, 5).toString();
	    //file.replaceAll("D:/SOLICITUD_PROVEEDORES/", "//Willy/d(d)/SOLICITUD_PROVEEDORES/");
   	    System.out.println(""+file);
	    Runtime.getRuntime().exec("C:/Archivos de programa/Microsoft Office/Office12/excel.exe "+file);
	  
	}
	

}
