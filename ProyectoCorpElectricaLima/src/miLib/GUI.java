package miLib;

import javax.swing.JOptionPane;

public class GUI {
	//static ClassLoader cls = this .getClass().getClassLoader(); 
	
	public static String getString(String mensaje){
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public static int getInt(String mensaje){
		int valor=0;
		boolean error;
		do{
			try {
				error=false;
				valor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			} catch (NumberFormatException e) {
				error = true;
				mostrarAviso("Debe ingresar un valor entero.");
			}
		}while(error);
		return valor; 
	}
	
	public static double getDouble(String numero){
		double valor = 1;
		numero.trim();
		
			try {
				if(numero.length()>1){
					for (int i = 0; i < numero.length(); i++) {
					int y=i+2;
					if(numero.charAt(i)=='.'|((numero.charAt(y)=='0')||
							(numero.charAt(y)=='1')||(numero.charAt(y)=='2')
							||(numero.charAt(y)=='3')||(numero.charAt(y)=='4')
							||(numero.charAt(y)=='5')||(numero.charAt(y)=='6')
							||(numero.charAt(y)=='7')||(numero.charAt(y)=='8')
							||(numero.charAt(y)=='9'))){
						//Aqui resien es un double
						
						valor=Double.parseDouble(numero);
						return valor;
					}else{
						//aqui se manda 1 
						return valor;
					}
				}
				
				}
				
			} catch (NumberFormatException e) {
				System.out.println(numero+"-"+e);
			}
		
		return valor; 
	}


	
	public static void mostrarAviso(String mensaje){
	    //   System.out.println("AKAAAAAAAAAAAAAAA TYO MIRA ESTO:"+cls.getResource(""));
		JOptionPane.showMessageDialog(null,mensaje);
	}

	public static int mostrarAvisoRetorno(String mensaje){
		int op=JOptionPane.showConfirmDialog(null, mensaje);
		return op;
	}
	
}
