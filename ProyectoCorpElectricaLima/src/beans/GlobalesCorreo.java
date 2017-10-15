package beans;

import util.Propiedades;

public class GlobalesCorreo {

	/*public static String extension="smtp.gmail.com";
	public static String correo="corporacionelectricalima@gmail.com";
	public static String pass="marggiohafid";
	public static String nombre="Corporacion Electrica Lima";
	public static String correoError="corporacionelectricalima@gmail.com";*/
	
	static Propiedades p=new Propiedades();
	
	public static String extension=p.getProperty("extensionGmail");
	public static String correo=p.getProperty("correoGmail");
	public static String pass=p.getProperty("passGmail");
	public static String nombre=p.getProperty("nombreGmail");
	public static String correoError=p.getProperty("correoErrorGmail");
	public static String asunto=p.getProperty("asuntoGmail");
	
	
}
