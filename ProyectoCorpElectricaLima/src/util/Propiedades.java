package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Propiedades {

	Properties properties = null;

	public Propiedades() {

		properties = new Properties();
		String ruta = ""; 
		ruta = "//192.168.0.20/D/ProyectoCEL/archivo2.properties"; 
		ruta = "//192.168.0.20/D/ProyectoCEM/archivo2.properties"; 
		
		

		try {
			properties.load(new FileInputStream(ruta));
		} catch (IOException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"La siguiente ruta especificada no existe:" + "\n" + ruta,"", 0);
		}
	}

	/**
	 * Retorna la propiedad de configuración solicitada
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(String key) {
		return this.properties.getProperty(key);
	}

	public void setProperty(String key, String value) {
		this.properties.setProperty(key,value);
	}

}