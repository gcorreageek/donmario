package miLib;

/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */



import gui.TranCotizacionAutMant;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import java.io.InputStreamReader;

import util.Propiedades;

public class PasarExcelFactura {
	 public static Class clss=null;
	 public static InputStream in;
	 public static ClassLoader cl = null;
//	 public static String in2;
	//ClassLoader cls = this .getClass().getClassLoader(); 
	static Workbook wb;
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
    
    
  
   public PasarExcelFactura() throws IOException{  
	  clss=this. getClass();
	   cl= this .getClass().getClassLoader(); 
   }
		
     
   //D:\ProyectoCEM\Cotizaciones\CotCorreo
 
   public static   void crearExcel(Object[] nombre,Object[][] datos)throws IOException{
	   ClaseCargadora objCargar= new ClaseCargadora();
	   
	   Fecha objfec;
	   objfec =new Fecha();
	   Propiedades p=new Propiedades();
	  
 	   wb = new HSSFWorkbook();
 	  
 	   arreglo_nombre=nombre;
 	   arreglo_datos=datos;

        metodoCotizacionClientes();
     
        
        // Write the output to a file
        System.out.println(arreglo_nombre[1]);
        String fec=objfec.fechaActual7();
        String numCot=""+arreglo_nombre[1].toString();
        numCot=numCot.replaceAll("  ", "");
        numCot=numCot.replaceAll(" ", "");
        numCot=numCot.trim();//D:\ProyectoCEM\Cotizaciones\Coti
        String fileRaiz="D:/ProyectoCEL/Facturas/";
        String file =fileRaiz+numCot+fec+".xls";
       // if(wb instanceof XSSFWorkbook) file += "x";
        GUI objGUI=new GUI() ;
      //  objGUI.mostrarAviso("EL File:"+file);
 	         FileOutputStream out = new FileOutputStream(file);
       
      //  GUI.mostrarAviso("puro:"+cl.getResource(file));
       // System.out.println("K MELA PASA AKA:"+ objCargar.getCls());
//        System.out.println("AKAAAAAAAAAAAAAAA TYO MIRA ESTO:"+objCargar.getCls().getResource(file));
//        System.out.println("AKAAAAAAAAAAAAAAA TYO MIRA ESTO:"+objCargar.getCls().getResource(file).toString());
        	//FileOutputStream out = new FileOutputStream(cl.getResource(file).toString());
 	         wb.write(out);
 	         out.close();
 	         int io=0;
 	         try {
 	        	Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
			} catch (Exception e) {
				Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
				io=1;
			}finally{
				if(io==1){
					System.out.println("Version de Oficce Antigua");
					//objGUI.mostrarAviso("VERSION DE OFFICE!");
				}
				//objGUI.mostrarAviso("ERROR DE VERSION DE OFFICE!");
			}
 	        
 	        
 	  
    }
     
   public static void  metodoCotizacionClientes(){
	   
	   TranCotizacionAutMant objCot;
       objCot=new TranCotizacionAutMant();
	   CreationHelper createHiperVinculo = wb.getCreationHelper();
       Map<String, CellStyle> styles = createStyles(wb);

       ////////////////////////////////////////////////////////////////////////////////////////////
       /******************************************************************************************/
       /********************************COTIZACION - CLIENTE************************************/
       Sheet sheet = wb.createSheet("FACTURA - CLIENTE");
       PrintSetup printSetup = sheet.getPrintSetup();
       printSetup.setLandscape(true);
       sheet.setFitToPage(true);
       sheet.setHorizontallyCenter(true);
      for (int i = 0; i < 250; i++) {	sheet.createRow(i).setHeightInPoints(10);}
			
      CellStyle style;
      style = wb.createCellStyle();
      style.setAlignment(CellStyle.BORDER_MEDIUM);
      style.setWrapText(true);
      style.setAlignment(CellStyle.BORDER_THIN);
     // style.setBorderRight(CellStyle.BORDER_THIN);
       //finally set column widths, the width is measured in units of 1/256th of a character width
      sheet.setColumnWidth(0, 0); //30 characters wide
      sheet.setColumnWidth(1, 2150);
      sheet.setColumnWidth(2, 2200);
      sheet.setColumnWidth(3, 19650); //10 characters wide
      sheet.setColumnWidth(4, 3900);
      sheet.setColumnWidth(5, 3350);
      sheet.setColumnWidth(6, 3000);
      sheet.setColumnWidth(7, 3000);
      sheet.setColumnWidth(8, 3000);
      sheet.setColumnWidth(9, 3000);
      sheet.setColumnWidth(10, 6500);//'HOJA DE COSTOS  INTERNA'!D1
     // sheet.setColumnWidth(11, 6500);
      // titleRow.setHeightInPoints(45);//lo alto
     
        
     /*******************************************************************************************************************************/ 
        
     
      
        Row fila12=sheet.createRow(21);
        Cell fecha =fila12.createCell(2);
        fecha.setCellValue(arreglo_nombre[0].toString());//FECHA
        fecha.setCellStyle(styles.get("title"));
        
        Row fila14=sheet.createRow(24);
        Cell cliente =fila14.createCell(2);
        Cell ruc=fila14.createCell(4);
        
        cliente.setCellValue(arreglo_nombre[1].toString());
        cliente.setCellStyle(styles.get("title"));
        
        ruc.setCellValue(arreglo_nombre[3].toString());
        ruc.setCellStyle(styles.get("title"));
        
       

        Row fila16=sheet.createRow(27);
        Cell direccion =fila16.createCell(2);
        direccion.setCellValue(arreglo_nombre[2].toString());
        direccion.setCellStyle(styles.get("title"));
        
       /* Cell tipo = filaNueva.createCell(7);
        tipo.setCellValue("T.C.");
        tipo.setCellStyle(styles.get("titleCostadoCuadro"));

        Cell cambio = filaNueva.createCell(8);
        cambio.setCellValue(Double.parseDouble(""+arreglo_nombre[9]));
        cambio.setCellStyle(styles.get("titleCostadoCuadro"));
        */
        
       /* Row fila15=sheet.createRow(15);
        Cell celda1=fila15.createCell(1);
        celda1.setCellValue("CANT");
        celda1.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda2=fila15.createCell(2);
        celda2.setCellValue("U");
        celda2.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda3=fila15.createCell(3);
        celda3.setCellValue("DESCRIPCION");
        celda3.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda4=fila15.createCell(4);
        celda4.setCellValue("MARCA");
        celda4.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda5=fila15.createCell(5);
        celda5.setCellValue("P.UNIT.");
        celda5.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda6=fila15.createCell(6);
        celda6.setCellValue("TOTAL");
        celda6.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda7=fila15.createCell(7);
        celda7.setCellValue("P.UNIT.");
        celda7.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda8=fila15.createCell(8);
        celda8.setCellValue("TOTAL");
        celda8.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda9=fila15.createCell(9);
        celda9.setCellValue("PESO");
        celda9.setCellStyle(styles.get("titleCostadoCuadro"));
        
        
        Cell celda11=fila15.createCell(10);
        celda11.setCellValue("TIEMPO DE ENTREGA");
        celda11.setCellStyle(styles.get("titleCostadoCuadro"));*/
        String numeroLetras=objCot.NumeroEnLetras; 
        double totalfac=objCot.TotalFac,
               igvFac=objCot.IGVFAC;
        
        int cantArreglo=arreglo_datos.length+6;
        int conta=0;
        System.out.println("TOTAL ARREGLOS"+arreglo_datos.length);
        for (int i = 0; i < cantArreglo; i++){//numero de filas 9 //aka se pone el arreglo
      	  Row fila20=sheet.createRow(33+i);
      	  conta++;
      	  
      	  for (int j = 0; j < 5; j++) {//numero de columnas 
      		  if(i==0){
      			  //PRIMERA FILA DE LOS DATOS QUE ESTAN EN EL ARCHIVO EXCEL
      			 if(j==0){
   				    if(i<arreglo_datos.length){
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			celda10y0.setCellValue(Integer.parseInt(""+arreglo_datos[i][0]));
         			celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
         			}else{
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
         			}
   			  }else if(j==1){
   				    if(i<arreglo_datos.length){
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			celda10y0.setCellValue(""+arreglo_datos[i][1]);
         			celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
         			}else{
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
         			}
   			  }else if(j==2){//'HOJA DE COSTOS  INTERNA'!D10
   				    if(i<arreglo_datos.length){
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			celda10y0.setCellValue(""+arreglo_datos[i][2]);
         			celda10y0.setCellStyle(styles.get("title"));		
         			}else{
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
         			}
   			  }else if(j==3){
   				    if(i<arreglo_datos.length){
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][3]));
         			celda10y0.setCellStyle(styles.get("2decimales"));		
         			}else{
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
           			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
         			}
   			  }else{//+'HOJA DE COSTOS  INTERNA'!F10
   				    if(i<arreglo_datos.length){
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
         			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][4]));
       				celda10y0.setCellStyle(styles.get("2decimalesder"));		
         			}else{
         			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
           			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
         			}
   			  }
   		  
      		}else if(i<arreglo_datos.length){//ACA SE OBTIENE LOS DATOS PARA PONERLOS EN EL EXCEL
      			 //SEGUNDA FILA HACIA ADELANTE DE LOS DATOS QUE ESTAN EN EL ARCHIVO EXCEL
      			  if(j==0){
      				    if(i<arreglo_datos.length){
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			celda10y0.setCellValue(Integer.parseInt(""+arreglo_datos[i][0]));
            			celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
      			  }else if(j==1){
      				    if(i<arreglo_datos.length){
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			celda10y0.setCellValue(""+arreglo_datos[i][1]);
            			celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
      			  }else if(j==2){//'HOJA DE COSTOS  INTERNA'!D10
      				    if(i<arreglo_datos.length){
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			celda10y0.setCellValue(""+arreglo_datos[i][2]);
            			celda10y0.setCellStyle(styles.get("title"));		
            			}else{
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
      			  }else if(j==3){
      				    if(i<arreglo_datos.length){
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][3]));
            			celda10y0.setCellStyle(styles.get("2decimales"));		
            			}else{
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
              			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
      			  }else{//+'HOJA DE COSTOS  INTERNA'!F10
      				    if(i<arreglo_datos.length){
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
            			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][4]));
          				celda10y0.setCellStyle(styles.get("2decimalesder"));		
            			}else{
            			Cell celda10y0=fila20.createCell(j+1);//(F10*B10)
              			//celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
      			  }
      		  }else{
      			Cell celda1y16=fila20.createCell(1+j);
      			celda1y16.setCellValue("");
      			celda1y16.setCellStyle(styles.get("2decimales"));	
      		  }
      		  
			}
      	  
		}
        System.out.println("FILAS EXCEL: "+conta);
        
        int fin=51-conta+1;
		for (int i = 0; i < fin; i++){
			
			Row fila21=sheet.createRow(33+conta+i);//EL NUMERO 33 ES DE DONDE EMPIEZA A LLENAR LOS DATOS
			
			for (int j = 0; j < 5; j++) {
				if(j==0){
					Cell celda21=fila21.createCell(j+1);
					celda21.setCellValue("");
					celda21.setCellStyle(styles.get("2decimales"));
				}else if(j==1){
					Cell celda21=fila21.createCell(j+1);
					celda21.setCellValue("");
					celda21.setCellStyle(styles.get("2decimales"));
				}else if(j==2){
					Cell celda21=fila21.createCell(j+1);
					celda21.setCellValue("");
					celda21.setCellStyle(styles.get("2decimales"));
				}else if(j==3){
					Cell celda21=fila21.createCell(j+1);
					celda21.setCellValue("");
					celda21.setCellStyle(styles.get("2decimales"));
				}else{
					Cell celda21=fila21.createCell(j+1);
					celda21.setCellValue("");
					celda21.setCellStyle(styles.get("2decimales"));
				}
			}
		}
		conta=0;
		
        Row fila61=sheet.createRow(82);//ACA ESTA LA CLAVE PARA AUMENTAR DE ESPACIOS HACIA ABAJO
        Row fila64=sheet.createRow(82+3);
        Row fila67=sheet.createRow(82+6);
  		for (int i = 0; i < 4; i++) {//0,1,2=3
  		for (int j = 0; j < 5; j++) {//numero de columnas YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
  			if(i==0){
  			if(j!=0){
  			if(j==1){
  				Cell celda10y0=fila61.createCell(j+1);
	      			celda10y0.setCellValue(numeroLetras.toUpperCase());
	      			celda10y0.setCellStyle(styles.get("title"));
  			}else if(j==3){
  				
  			}else{
  			
  			}	
  			
  			}
  					
  			}else if(i==1){
  				if(j>1){
  				if(j==2){
  					
  				}else if(j==3){
  	  				Cell celda10y0=fila61.createCell(j+1);//SUMA(G18:G117)
  	      			celda10y0.setCellValue(objCot.TIPO_MONEDA);
  	      			celda10y0.setCellStyle(styles.get("derecha"));
  	  			}else {
  	  			   Cell celda10y0=fila61.createCell(j+1);//SUMA
	      			celda10y0.setCellFormula("SUM(F34:F"+(79)+")");
	      			celda10y0.setCellStyle(styles.get("2decimalesder"));
  	  			}	
  			}
  							
  			}else if(i==2){
  				if(j>1){
  	  				if(j==2){
  	  					//NADA
  	  				}else if(j==3){//+G118*0,19
  	  	  				Cell celda10y0=fila64.createCell(j+1);//SUMA(G18:G117)
  	  	      			celda10y0.setCellValue(objCot.TIPO_MONEDA);
  	  	      			celda10y0.setCellStyle(styles.get("derecha"));
  	  	  			}else{//+H118*0,19
  	  	  				Cell celda1y17=fila64.createCell(j+1);//SUMA(H18:H117)
  	  	  				celda1y17.setCellValue(igvFac);
  	  	  				celda1y17.setCellStyle(styles.get("2decimalesder"));
  	  	  			}	
  	  			}
  			}else{
  				if(j>1){
  	  				if(j==2){
  	  					//NADA
  	  				}else if(j==3){
  	  	  				Cell celda10y0=fila67.createCell(j+1);//SUMA(G18:G117)
  	  	      			celda10y0.setCellValue(objCot.TIPO_MONEDA);
  	  	      			celda10y0.setCellStyle(styles.get("derecha"));
  	  	  			}else{//SUMA(H118:H119)
  	  	  				Cell celda1y17=fila67.createCell(j+1);//SUMA(H18:H117)
  	  	  				celda1y17.setCellValue(totalfac);//("SUM(F"+(62)+":F"+(65)+")");
  	  	  				celda1y17.setCellStyle(styles.get("2decimalesder"));
  	  	  			}
  	  	    	}	
  	  	    }
  				
  				
  		  }
  			
  	   }
  		///AKA TERMINA EL ULTIMO BUCLE
  		sheet.setZoom(3, 4);
   }
  
    /**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb){
    	 DataFormat format = wb.createDataFormat();
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;
        //TITULO.
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        titleFont.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(titleFont);
        styles.put("title", style);

      //CUADRADO MEDIO Y ABAJO DOBLE RALLA
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        //style.setBorderLeft(CellStyle.BORDER_THIN);
        Font rrallamediosimple = wb.createFont();
        rrallamediosimple.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        rrallamediosimple.setBoldweight(Font.COLOR_NORMAL);
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(rrallamediosimple);
        styles.put("rrallamediosimple", style);
        
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_RIGHT);//Centro,Costados
        //style.setBorderLeft(CellStyle.BORDER_THIN);
        Font pegadoder = wb.createFont();
        pegadoder.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        pegadoder.setBoldweight(Font.COLOR_NORMAL);
        style.setFont(pegadoder);
        styles.put("derecha", style);
        
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        //style.setBorderLeft(CellStyle.BORDER_THIN);
        Font dosdecimeles = wb.createFont();
        dosdecimeles.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        dosdecimeles.setBoldweight(Font.COLOR_NORMAL);
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setDataFormat(format.getFormat("0.00"));
        style.setFont(dosdecimeles);
        styles.put("2decimales", style);
        
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_RIGHT);//Centro,Costados
        Font dosdecimelesder = wb.createFont();
        dosdecimelesder.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        dosdecimelesder.setBoldweight(Font.COLOR_NORMAL);
        style.setDataFormat(format.getFormat("0.00"));
        style.setFont(dosdecimelesder);
        styles.put("2decimalesder", style);
        
       
        /*    style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);*/
        Font TITULOmEDIOaMARRILO = wb.createFont();
        TITULOmEDIOaMARRILO.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        TITULOmEDIOaMARRILO.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(TITULOmEDIOaMARRILO);
        //style.bo
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styles.put("titleMedioAmarillo", style);
        
        
        
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setBorderLeft(CellStyle.BORDER_THIN);
        Font rrallamediosimpleFormat3 = wb.createFont();
        rrallamediosimpleFormat3.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setDataFormat(format.getFormat("0.000"));
        style.setFont(rrallamediosimpleFormat3);
        styles.put("rrallamediosimpleFormat3", style);
        //rrallamediosimpleFormat
        //-------------------------------------
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setBorderLeft(CellStyle.BORDER_THIN);
        Font rrallamediosimpleFormat2 = wb.createFont();
        rrallamediosimpleFormat2.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setDataFormat(format.getFormat("0.00"));
        style.setFont(rrallamediosimpleFormat2);
        styles.put("rrallamediosimpleFormat2", style);
        
        
        //-------------------------------------
        			
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font cuadradoSimpleChicoFormat = wb.createFont();
        cuadradoSimpleChicoFormat.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setFont(cuadradoSimpleChicoFormat);
        style.setDataFormat(format.getFormat("0.00"));
        styles.put("cuadradoSimpleChicoFormat", style);
        
        
      //CUADRADO MEDIO Y ABAJO DOBLE RALLA
        style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        Font titleMediaCajaArriba = wb.createFont();
        titleMediaCajaArriba.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleMediaCajaArriba.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(titleMediaCajaArriba);
        styles.put("mediaCajaArriba", style);
      //CUADRADO MEDIO Y ABAJO DOBLE RALLA
        style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_DOUBLE);
        Font titleMediaCajaAbajo = wb.createFont();
        titleMediaCajaAbajo.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleMediaCajaAbajo.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(titleMediaCajaArriba);
        styles.put("mediaCajaAbajo", style);
        //CUADRADO MEDIO Y ABAJO DOBLE RALLA
        style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_DOUBLE);
        Font titleMedioCuaDoRaja = wb.createFont();
        titleMedioCuaDoRaja.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleMedioCuaDoRaja.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(titleMedioCuaDoRaja);
        styles.put("cuadradoMedioDobleRalla", style);
        
        //PINTA LAS RALLAS 
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
       style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
       style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font titleFontMedios = wb.createFont();
        titleFontMedios.setBoldweight(Font.COLOR_NORMAL);
        style.setFont(titleFont);
        styles.put("cell", style);
        //PINTA LAS RALLAS 
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font cuadradoSimpleChico = wb.createFont();
        cuadradoSimpleChico.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setFont(cuadradoSimpleChico);
        styles.put("cuadradoSimpleChico", style);
      //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setBorderTop(CellStyle.BORDER_DOUBLE);
        Font medioDobleRallaArriba = wb.createFont();
        medioDobleRallaArriba.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        medioDobleRallaArriba.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setFont(titleFont);
        styles.put("titleMedioDobleRallaAriva", style);
        //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        Font titleFontMedio = wb.createFont();
        titleFontMedio.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleFontMedio.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setFont(titleFont);
        styles.put("titleMedio", style);
        //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        Font titleCostadoSimple = wb.createFont();
        titleCostadoSimple.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleCostadoSimple.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setFont(titleCostadoSimple);
        styles.put("titleCostadoSimple", style);
      //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       // style.setFont(wb.)
        Font titleHipervinculo = wb.createFont();
        titleHipervinculo.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleHipervinculo.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
       // titleHipervinculo.setFontName(Font.)
        titleHipervinculo.setUnderline (Font.U_SINGLE);
        titleHipervinculo.setColor (IndexedColors.BLUE.getIndex ());
        style.setFont(titleHipervinculo);
        styles.put("titleHipervinculo", style);
      //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       // style.setBorderBottom(CellStyle.FINE_DOTS);
        //style.setBorderBottom()
        Font titleSubRallado = wb.createFont();
        titleSubRallado.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleSubRallado.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        titleSubRallado.setUnderline(Font.DEFAULT_CHARSET);
        style.setFont(titleSubRallado);
        styles.put("titleSubRallado", style);
        //PINTA LAS RALLAS 
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setBorderLeft(CellStyle.BORDER_THIN);
        Font titleralla = wb.createFont();
        titleralla.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleralla.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style.setFont(titleralla);
        styles.put("ralla", style);
        //TITULO.
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        Font titleMedioSimple = wb.createFont();
        titleMedioSimple.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setFont(titleMedioSimple);
        styles.put("titleMedioSimple", style);
        
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        Font titleMedioSimpleFormat = wb.createFont();
        titleMedioSimpleFormat.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setFont(titleMedioSimpleFormat);
        style.setDataFormat(format.getFormat("0.00"));
        styles.put("titleMedioSimpleFormat", style);
        
        //DESPUES DEL TITULO
        Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short)11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);

      
        
        //DOBLE RALLA ABAJO
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setBorderTop(CellStyle.BORDER_DOUBLE);
        style.setDataFormat(format.getFormat("0.00"));
        styles.put("dobleRallaHor", style);
        
        
        
        //PINTA LAS RALLAS 
        /*
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setFont(titleFont);
        styles.put("pinta", style);*/

        //EL FORMATO DE LOS NUMEROS EN LAS CELDAS
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula", style);

        //EL OTRO FORMATO DE LOS NUMEROS
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula_2", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setBorderLeft(CellStyle.BORDER_THIN);
        Font rrallacostadosimple = wb.createFont();
        rrallacostadosimple.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(rrallacostadosimple);
        styles.put("rrallacostadosimple", style);
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
       style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
       style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        Font titleCostadoCuadro = wb.createFont();
        titleCostadoCuadro.setFontHeightInPoints((short)11);
        titleCostadoCuadro.setBoldweight(Font.COLOR_NORMAL);
        style.setFont(titleCostadoCuadro);
        styles.put("titleCostadoCuadro", style);
        
        return styles;
    }
}
