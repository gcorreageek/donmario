package Prueba;

import util.Propiedades;

public class Leer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String nombre="",pagina="";
		
		try{
			Propiedades p=new Propiedades();
			nombre=p.getProperty("correoGmail");
			p.setProperty("hola","Hola Mundo!!!");
			System.out.println(nombre+"\n"+pagina);
			
		}catch(Exception e){
			
		}	
	}

}
