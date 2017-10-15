package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author CHENAO
 * 
 */
public class LeerProperties {

	public static void main(String arg[]) {

		//LeerProperties miPrincipal = new LeerProperties();
		//miPrincipal.leerArchivo();
	}

	/**
	 * Lee un archivo de propiedades desde una ruta especifica y se imprime en
	 * pantalla.
	 */
	public void leerArchivo() {
		try {

			/** Creamos un Objeto de tipo Properties */
			Properties propiedades = new Properties();

			/** Cargamos el archivo desde la ruta especificada */
			propiedades.load(new FileInputStream("C:/archivo.properties"));

			/** Obtenemos los parametros definidos en el archivo */
			String nombre = propiedades.getProperty("nombre");
			String pagina = propiedades.getProperty("pagina");

			/** Imprimimos los valores */
			System.out.println("Nombre: " + nombre + "\n" + "Pagina: " + pagina);

		} catch (FileNotFoundException e) {
			System.out.println("Error, El archivo no exite");
		} catch (IOException e) {
			System.out.println("Error, No se puede leer el archivo");
		}
	}
}