//paquete al que pertence esta clase
package web;
//librerías a solicitar
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//clase que hace referencia a la base de datos web
public class WebBdatos {
    int cant=0;//referencia al total de filas
    
    //elimina dato de la web por código de fila
    public void EliminarDatoWeb(int cod_fila){
    try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            s.executeUpdate ("DELETE FROM `productos_cotizar1` WHERE cod_fila='"+cod_fila+"'");         
             // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            //devuelve error del còdigo dentro del try
            e.printStackTrace();
        }
    }
    
    //ingresar datos a la web por filas, es decir fila por fila
    public void IngresarDatoWeb
            (String imagen,int cod_fila,String nom_umed,int codigo,
             String nombre,String modelo,String marca,float cost_det,
             String mon_det,String igv_det,float costo_final,
             float utilidad,float precio_venta_dolares,float precio_venta_soles,
             String rubro, String fichatecnica ){
    try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
             System.out.println("Envio :"+(cant++)+"\nINSERT INTO productos_cotizar1 VALUES ('"
                                + imagen+"',"+cod_fila+",'"+nom_umed+"',"+codigo+",'"
                                +nombre+"','"+modelo+"','"+marca+"',"+cost_det+",'"
                                +mon_det+"',"+igv_det+","+costo_final+","+utilidad+","
                                +precio_venta_dolares+","+precio_venta_soles+","+rubro+","+fichatecnica+")");
             //ejecuta consulta para ingresar nueva fila de datos en la base de datos
           s.executeUpdate ("INSERT INTO productos_cotizar1 VALUES ('"
                             + imagen+"',"+cod_fila+",'"+nom_umed+"',"+codigo+",'"
                             +nombre+"','"+modelo+"','"+marca+"',"+cost_det+",'"
                             +mon_det+"',"+igv_det+","+costo_final+","+utilidad+","
                             +precio_venta_dolares+","+precio_venta_soles+",'"+rubro+"',"+fichatecnica+")");
           
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    //funcion que permite ingresar datos a la web por lotes
     public void IngresarDatoWeb_porlote(String sentencia){
    try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            System.out.println(sentencia);
             //ejecuta sentencia o consulta en la base de datos de la web
            s.executeUpdate (sentencia);
           
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //devuelve el total de filas que posee la tabla determinada en la base de datos 
    //de la web
    int Total_filas(){
        //contiene el total de filas que se devolverà a travès de este entero
        int total =0;
        
            try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            ResultSet rs = s.executeQuery("SELECT cod_fila FROM `productos_cotizar1`"); 
            while (rs.next())
            {
             total++;
            }
            // Se cierra la conexión con la base de datos.            
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return total;
    }
    
    int codigoseguir(){
        //contiene el total de filas que se devolverà a travès de este entero
        int total =0;
        
            try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            // Se realiza la consulta. Los resultados se guardan en el 
            ResultSet rs = s.executeQuery("SELECT cod_fila FROM `productos_cotizar1`"); 
            while (rs.next())
            {
             total=rs.getInt(1);
            }
            // Se cierra la conexión con la base de datos.            
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return total;
    }
    //función ejecuta formulas de sacar precios de venta tanto en dolar y soles
    public void ejecucionFormulas()
    {
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://72.55.174.111/corplima_wordpress","corplima_root", "admin");
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            //imprime la consulta que se esta realizando
            String consulta=
            "UPDATE productos_cotizar1 SET costo_final= cos_det WHERE igv_det=1 and mon_det='$';\n"+
            "UPDATE productos_cotizar1 SET costo_final= cos_det/2.65 WHERE igv_det=1 and mon_det='S/.';\n"+
            "UPDATE productos_cotizar1 SET costo_final= (cos_det/1.18)/2.65 WHERE igv_det=0 and mon_det='S/.';\n"+
            "UPDATE productos_cotizar1 SET costo_final= cos_det/1.18 WHERE igv_det=0 and mon_det='$';\n"+
            "UPDATE productos_cotizar1 SET utilidad=costo_final*0.10;\n"+
            "UPDATE productos_cotizar1 SET precio_venta_dolares=utilidad+costo_final;\n"+
            "UPDATE productos_cotizar1 SET precio_venta_soles=precio_venta_dolares*2.69;\n";
            System.out.println(consulta);
            //s.executeUpdate (consulta);      
            //Se realiza la consulta
            //conjunto de comandos sql que actualizan los datos según condiciones propuestas
            s.executeUpdate("UPDATE productos_cotizar1 SET costo_final= cos_det WHERE igv_det=1 and mon_det='$';");
            s.executeUpdate("UPDATE productos_cotizar1 SET costo_final= cos_det/2.65 WHERE igv_det=1 and mon_det='S/.';");
            s.executeUpdate("UPDATE productos_cotizar1 SET costo_final= (cos_det/1.18)/2.65 WHERE igv_det=0 and mon_det='S/.';");
            s.executeUpdate("UPDATE productos_cotizar1 SET costo_final= cos_det/1.18 WHERE igv_det=0 and mon_det='$';");
            s.executeUpdate("UPDATE productos_cotizar1 SET utilidad=costo_final*0.10;");
            s.executeUpdate("UPDATE productos_cotizar1 SET precio_venta_dolares=utilidad+costo_final;");
            s.executeUpdate("UPDATE productos_cotizar1 SET precio_venta_soles=precio_venta_dolares*2.69;");
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            //imprime error de consulta
            e.printStackTrace();
        }                    
    }
 
    //Función que 
        /*  public static void main(String args[]) {
            WebBdatos d1 = new WebBdatos();
             System.out.println(d1.Total_filas());
        }*/
}
