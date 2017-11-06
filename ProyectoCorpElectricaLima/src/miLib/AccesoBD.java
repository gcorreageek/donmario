package miLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * Clase que permite crear y cerrar una conexión. Además tiene
 * métodos que ejecuta sentencias SQL: INSERT, DELETE, UPDATE mario	
 * y SELECT.
 */

public class AccesoBD {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
 public void crearConexion(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(
					//donde la ip=192.168.1.42=ip donde esta la BD
					//el cual la maquina donde esta la BD tiene que tener las IPS
					//de la maquina que se van a conectar con ip//maskara
					//por ejemplo la selora charo su IP ES 192.168.1.42
					//y la de daniel es 192.168.1.43 , donde en la
					//maquina de la señora charo he puesto la 
					// la ip de daniel asi: 192.168.1.43//255.255.255.0
					"jdbc:mysql://localhost:3306/bd_cel3","root","mysql");//PONER ESTA PARA LA APLICACION
			//"jdbc:mysql://192.168.0.20:3306/bd_cel2","casa","casa");
			
			
					//"jdbc:mysql://localhost:3306/bd_cel","root","admin");
					 //"jdbc:mysql://72.55.174.111:3306/corplima_bd_cel","corplima_root","admin");
					//"jdbc:mysql://192.168.1.41:3306/bd_avaintel","mario","admin");
		
		}catch(Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con la Base de Datos","",0);
			System.out.println("Salir");
			System.exit(0);
  
		}
	}
 
	 
	 public Connection getCon() {
	     return cn;
	 }
	 
	
	public int ejecutarActualizacion(String sql){
		try {
			st = cn.createStatement();
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	
	public int ejecutarPreparedStatement(String sql){
		try {
			pst = cn.prepareStatement(sql);
			return pst.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	
	public ResultSet ejecutarPreparedStatementConsulta(String sql){
		try {
			pst = cn.prepareStatement(sql);
			return pst.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	//Ejecuta sentencias SQl de consulta: SELECT
	public ResultSet ejecutarConsulta(String sql){
		try {
			st = cn.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	/*Metodos para cerrar conexion, resultset y statement*/
	
	public void cerrarConexion(){
		try {
			cn.close();
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
	
	public void cerrarPreparedStatement(){
		
		try {
            pst.close();
		} catch (SQLException e) {
            e.printStackTrace();
		}
	}
	
}
