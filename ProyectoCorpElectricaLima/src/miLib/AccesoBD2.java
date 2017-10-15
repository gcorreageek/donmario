package miLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Clase que permite crear y cerrar una conexión. Además tiene
 * métodos que ejecuta sentencias SQL: INSERT, DELETE, UPDATE mario	
 * y SELECT.
 */

public class AccesoBD2 {

	Connection c=null;
	Statement st =null;
	ResultSet rs = null;
	
	public void crearConexion(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");//estop es en logeo:jar:file:/D:/WK/CyE/jar/Imagenes.jar!/Images/logeo.jpg
			c = DriverManager.getConnection(
					//donde la ip=192.168.1.42=ip donde esta la BD
					//el cual la maquina donde esta la BD tiene que tener las IPS
					//de la maquina que se van a conectar con ip//maskara
					//por ejemplo la selora charo su IP ES 192.168.1.42
					//y la de daniel es 192.168.1.43 , donde en la
					//maquina de la señora charo he puesto la 
					// la ip de daniel asi: 192.168.1.43//255.255.255.0
					"jdbc:mysql://25.172.14.90:3306/bd_cyeglobalelectric","192.168.0.20","admin");
		            //"jdbc:mysql://localhost:3306/bd_cyeglobalelectric","root","admin");
					//"jdbc:mysql://192.168.4.41:3306/bd_cel","mario","admin");
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error"+e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error"+e);
		}
	}
	
	//Ejecuta cualquier sentencias SQL que realice cambios en la tabla:
	//INSERT, DELETE y UPDATE.
	public int ejecutarActualizacion(String sql){
		try {
			st = c.createStatement();
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	
	//Ejecuta sentencias SQl de consulta: SELECT
	public ResultSet ejecutarConsulta(String sql){
		try {
			st = c.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	/*Metodos para cerrar conexion, resultset y statement*/
	
	public void cerrarConexion(){
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cerrarStatement(){
		try {
            st.close();
		} catch (SQLException e) {
            e.printStackTrace();
		} 
	}
	
	
	public void cerrarResultSet(ResultSet rs){
		
		if (rs != null){
	        try {
	                rs.close();
	        } catch (SQLException e) {
	                e.printStackTrace();
	        }       
		}
	}

}





