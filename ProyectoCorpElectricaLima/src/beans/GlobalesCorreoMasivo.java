package beans;

import util.Propiedades;

public class GlobalesCorreoMasivo {

	static Propiedades p=new Propiedades();
	
	public static String extension=p.getProperty("extension");
	public static String correo=p.getProperty("correo");
	public static String pass=p.getProperty("pass");
	public static String nombre=p.getProperty("nombre");
	public static String correoError=p.getProperty("correoError");
	public static boolean valor=false;
	
//	public static String extension="mail.corporacionelectricalima.com";
//	public static String correo="contacto@corporacionelectricalima.com";
//	public static String pass="contacto2011";
//	public static String nombre="Mario Mendoza";
//	public static String correoError="contacto@corporacionelectricalima.com";
//	public static boolean valor=false;
	
	/*public static String extension="smtp.gmail.com";
	public static String correo="corporacionelectricalima@gmail.com";
	public static String pass="marioalberto2011";
	public static String nombre="Corporacion Electrica Lima";
	public static String correoError="corporacionelectricalima@gmail.com";
	*/
	
	
}
