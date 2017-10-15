package miLib;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ClaseCargadora {
	
	public ClassLoader cls=this .getClass().getClassLoader(); 

	public ClaseCargadora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassLoader getCls() {
		return cls;
	}

	public void setCls(ClassLoader cls) {
		this.cls = cls;
	}
	
	public static String cargarArchivo(Component claseInvoca){
		/***************************************************************
		 * Cargado del Archivo                                          
		 * *************************************************************/
		String vieneArchivo="";
		  JFileChooser selectorArchivo=new JFileChooser();
	        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        
	        int resultado=selectorArchivo.showOpenDialog(claseInvoca);
	        
	        if(resultado==JFileChooser.CANCEL_OPTION)
	            return "";
	        
	        File archivo=selectorArchivo.getSelectedFile();
	        
	        if(archivo==null||archivo.getName().equals("")){
	            JOptionPane.showMessageDialog(claseInvoca,"Nombre Del Archivo Incorrecto",
	            "Nombre Del Archivo Incorrecto",JOptionPane.ERROR_MESSAGE);
	            return "";
	        }
	    	/***************************************************************
			 * Cargado del Archivo                                          
			 * *************************************************************/
	        vieneArchivo=archivo.toString();
	        return vieneArchivo;
	}
	
	
	
	/*
	ClassLoader cl = this .getClass().getClassLoader(); 
	Icon imagen  = new ImageIcon(cl.getResource("Images/logeo.jpg"));*/
	
	
	
}
