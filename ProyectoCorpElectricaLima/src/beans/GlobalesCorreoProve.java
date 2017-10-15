package beans;

import util.Propiedades;

public class GlobalesCorreoProve {
	
	static Propiedades p=new Propiedades();

	public static String extension=p.getProperty("extensionGmailProve");
	public static String correo=p.getProperty("correoGmailProve");
	public static String pass=p.getProperty("passGmailProve");
	public static String nombre=p.getProperty("nombreGmailProve");
	public static String correoError=p.getProperty("correoErrorGmailProve");
	
	
}
