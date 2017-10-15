package Prueba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RestoreBD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//RestaurarBackup("D://ProyectoCEL/backups/2013-08-04_bd_cel.sql");
		try{
            Runtime.getRuntime().exec("C:\\SCM Files\\SQL Backup\\mysqldump.exe -uroot -p123 rr -r\"C:\\SCM Files\\SQL Backup\\RR.sql");
            javax.swing.JOptionPane.showMessageDialog(null, "Successfully restored");
        }catch(java.lang.Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Not able to restore");
        }
	}

	public static void RestaurarBackup(String rutaFile) {

		//String rutaMySqlDump = "C:\\Archivos de programa\\MySQL\\MySQL Server 5.0\\bin\\mysqldump.exe";
	    String rutaMySql = "C:\\Archivos de programa\\MySQL\\MySQL Server 5.6\\bin\\mysql.exe";
	    String contrasenia ="admin";
	    String usuario = "root";
	    String dataBase = "bd_cel";
	    
	    try{
            String cad = "\"" + rutaMySql + "\" --password=" + contrasenia + " --user=" + usuario + " " + dataBase + " < \"" + rutaFile +"\"\n";

            File fcopi = new File("copia_seguridad.bat");
            FileWriter fw = new FileWriter(fcopi);
            fw.write(cad, 0, cad.length());
            fw.close();
            Runtime.getRuntime().exec("copia_Seguridad.bat");
         }catch(Exception ex){
             ex.printStackTrace();
         }

	}

}
