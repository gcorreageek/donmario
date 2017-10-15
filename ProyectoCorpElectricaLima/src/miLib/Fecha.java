package miLib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
	public Fecha(){
		
	}
	/**
	 * Devuelve la fecha del sistema con el formato
	 * YYYY-MM-DD
	 **/
	public static String fechaActual(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		return formato.format(fecha);
	}
	public static String fechaActual1(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(fecha);
	}
	public static String fechaActual21(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"+" "+"H:mm");
		return formato.format(fecha);
	}
	
	public static String fechaActual2(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"+" "+"H:mm:ss");
		return formato.format(fecha);
	}
	public static String fechaActual3(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("h"+":"+"mm a");
		return formato.format(fecha);
	}
	public static String fechaActual4(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("E");
		return formato.format(fecha);	

	}
	public static String fechaActual5(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("H");
		return formato.format(fecha);
	}
	public static String fechaActual6(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("H:mm:ss ");
		return formato.format(fecha);
	}
	public static String fechaActual7(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("h"+"_"+"mm_ss");
		return formato.format(fecha);
	}
	public static String fechaDia(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd");
		return formato.format(fecha);
	}
	public static String fechaMes(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("MMMM");
		return formato.format(fecha);
	}
	public static String fechaAño(){
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy");
		return formato.format(fecha);
	}
	public static Date FechaRep (int d) {	
	    Calendar hoy = Calendar.getInstance();
	    hoy.add(Calendar.DATE, d);
	    return hoy.getTime();
	}

	public static String convrtidorFec(Date fec){

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		return formato.format(fec);
	}
	public static String convrtidorFec2(Date fec){
        
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		return formato.format(fec);
	}
    
	public static void main(String[] args) {
	     
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	  
	try{ 
      Date today = df.parse("20/12/2005");             
	 System.out.println("Today = " + df.format(today)); 
	} catch (ParseException e) {         
       e.printStackTrace(); 
	   }    
	
	   
	} 
	 public Date StrtoDate(String pformat, String pdatestr){ 
	       Date date = null;     
	   SimpleDateFormat df = new SimpleDateFormat(pformat); 
	       try {            
	    	   date = df.parse(pdatestr);   
	     } catch (ParseException e) {        
	    // TODO Auto-generated catch block          
	  e.printStackTrace();   
	     }    
	   return date;    
	}
	 
	 

}
