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

import gui.TranCotizacion;
import gui.TranCotizacionAutMant;
import gui.TranCotizacionAutomatica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
//import java.io.InputStreamReader;

import util.Propiedades;

public class PasarExcel {
	 public static Class clss=null;
	 public static InputStream in;
	 public static ClassLoader cl = null;
//	 public static String in2;
	//ClassLoader cls = this .getClass().getClassLoader(); 
	static Workbook wb;
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
    
    
  
   public PasarExcel() throws IOException{  
	  clss=this. getClass();
	   cl= this .getClass().getClassLoader(); 
   }
		
     
   //D:\ProyectoCEM\Cotizaciones\CotCorreo
   
   

	public static String cargar(int fila){
		   TranCotizacionAutomatica objCot;
	       objCot=new TranCotizacionAutomatica();
	       TranCotizacion objCoti;
	       objCoti=new TranCotizacion();
	       Propiedades p=new Propiedades();
	       String texto="";
	       
	       if(objCot.estado==1){
	    	   texto = p.getProperty("condicionesExcel");
	       }else  if(objCot.estado==2){
	    	   texto = p.getProperty("condicionesExcel");
	       }else  if(objCoti.estado==1){
	    	   texto = p.getProperty("condicionesExcel");
	       }else{
	    	   texto = p.getProperty("condicionesExcel");
	       }
		
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
			archivo = new File (texto);
	        fr = new FileReader (archivo);
			//in=clss.getResourceAsStream("/File/CONDICIONESEXCEL.txt");
		//	br = new BufferedReader(new  InputStreamReader(in));
	        br = new BufferedReader(fr);
	         // Lectura del fichero
	         String linea;
	         int count=0;
	         while((linea=br.readLine())!=null){
	        	 count=count+1;
	        	if(fila==count){
	        		 texto=linea;
	        		break;
	        	}
	        
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }

	    return texto;
	}
	
	public static   void crearExcel2(Object[] nombre,Object[][] datos)throws IOException{
		  
		   
		   TranCotizacionAutMant objCot;
	       objCot=new TranCotizacionAutMant();
	       String nomEmp=objCot.nomEmpresa,referencia=objCot.referencia_coti;
	       String cadena=objCot.primeraPalabra(nomEmp);
		   String ref=objCot.sinEspacio(referencia);
		   Propiedades p=new Propiedades();
		   
	 	   wb = new HSSFWorkbook();
	 	  
	 	   arreglo_nombre=nombre;
	 	   arreglo_datos=datos;
	        metodoCotizacionInterna();
	        metodoCotizacionClientes();
	        metodoCorreoCel();
	        
	        // Write the output to a file
	        System.out.println(arreglo_nombre[7]);
	        String numCot=""+arreglo_nombre[7].toString();
	        numCot=numCot.replaceAll("  ", "");
	        numCot=numCot.replaceAll(" ", "");
	        numCot=numCot.trim();//D:\ProyectoCEM\Cotizaciones\Coti-------D:/ProyectoCEM/Cotizaciones/Cot/
	        String fileRaiz="D:/ProyectoCEM/Cotizaciones/Cot/";
	        String file =fileRaiz+numCot+"-"+cadena+"-"+ref+".xls";
	       // if(wb instanceof XSSFWorkbook) file += "x";
	        GUI objGUI=new GUI() ;
	      //  objGUI.mostrarAviso("EL File:"+file);
	 	         FileOutputStream out = new FileOutputStream(file);
	       
	      //GUI.mostrarAviso("puro:"+cl.getResource(file));
	      //System.out.println("K MELA PASA AKA:"+ objCargar.getCls());
          //System.out.println("AKAAAAAAAAAAAAAAA TYO MIRA ESTO:"+objCargar.getCls().getResource(file));
          //System.out.println("AKAAAAAAAAAAAAAAA TYO MIRA ESTO:"+objCargar.getCls().getResource(file).toString());
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

   public static   void crearExcel(Object[] nombre,Object[][] datos)throws IOException{
	   ClaseCargadora objCargar= new ClaseCargadora();
	   
	  
 	    wb = new HSSFWorkbook();
 	  
 	    arreglo_nombre=nombre;
 	    arreglo_datos=datos;
        metodoCotizacionInterna();
        metodoCotizacionClientes();
        metodoCorreoCel();
        Propiedades p=new Propiedades();
        
        // Write the output to a file
        System.out.println(arreglo_nombre[7]);
        String numCot=""+arreglo_nombre[7].toString();
        numCot=numCot.replaceAll("  ", "");
        numCot=numCot.replaceAll(" ", "");
        numCot=numCot.trim();//D:\ProyectoCEM\Cotizaciones\Coti
        String fileRaiz="D:/ProyectoCEM/Cotizaciones/Cot/";
        String file =fileRaiz+numCot+".xls";
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
	   CreationHelper createHiperVinculo = wb.getCreationHelper();
       Map<String, CellStyle> styles = createStyles(wb);

       ////////////////////////////////////////////////////////////////////////////////////////////
       /******************************************************************************************/
       /********************************COTIZACION - CLIENTE************************************/
       Sheet sheet = wb.createSheet("COTIZACION - CLIENTE");
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
      sheet.setColumnWidth(0, 800); //30 characters wide
      sheet.setColumnWidth(1, 2200);
      sheet.setColumnWidth(2, 1800);
      sheet.setColumnWidth(3, 20000); //10 characters wide
      sheet.setColumnWidth(4, 6000);
      sheet.setColumnWidth(5, 3000);
      sheet.setColumnWidth(6, 3000);
      sheet.setColumnWidth(7, 3000);
      sheet.setColumnWidth(8, 3000);
      sheet.setColumnWidth(9, 3000);
      sheet.setColumnWidth(10, 3000);//'HOJA DE COSTOS  INTERNA'!D1
      // titleRow.setHeightInPoints(45);//lo alto
      Row fila7=sheet.createRow(6);
      Cell cotizacion =fila7.createCell(3);
      cotizacion.setCellFormula("'HOJA DE COSTOS  INTERNA'!D1");
      cotizacion.setCellStyle(styles.get("titleMedio"));
      //'HOJA DE COSTOS  INTERNA'!G2
      Row fila9=sheet.createRow(8);
      Cell fecha =fila9.createCell(4);
      fecha.setCellFormula("'HOJA DE COSTOS  INTERNA'!G2");
      fecha.setCellStyle(styles.get("title"));
      
      
      Row fila10=sheet.createRow(10);
       Cell senores =fila10.createCell(1);
       senores.setCellValue("SEÑORES:");
       senores.setCellStyle(styles.get("title"));
       Cell senoresr =fila10.createCell(3);
       senoresr.setCellFormula("'HOJA DE COSTOS  INTERNA'!D3");
       senoresr.setCellStyle(styles.get("title"));
       
       Row fila11=sheet.createRow(11);
        Cell atencion = fila11.createCell(1);
        atencion.setCellValue("ATENCION:");
        atencion.setCellStyle(styles.get("title"));
        Cell atencionr =fila11.createCell(3);
        atencionr.setCellFormula("'HOJA DE COSTOS  INTERNA'!D4");
        atencionr.setCellStyle(styles.get("title"));
        
       Row fila12=sheet.createRow(12); 
        Cell direccion = fila12.createCell(1);
        direccion.setCellValue("DIRECCION:");
        direccion.setCellStyle(styles.get("title"));
        Cell direccionr =fila12.createCell(3);
        direccionr.setCellFormula("'HOJA DE COSTOS  INTERNA'!D5");
        direccionr.setCellStyle(styles.get("title"));
        
       Row fila14=sheet.createRow(13);
        Cell telefono = fila14.createCell(1);
        telefono.setCellValue("TELEFONO:");
        telefono.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell telefonor =fila14.createCell(3);
        telefonor.setCellFormula("'HOJA DE COSTOS  INTERNA'!D6");
        telefonor.setCellStyle(styles.get("title"));

        Row filaNueva=sheet.createRow(14);
        Cell referencia = filaNueva.createCell(1);
        referencia.setCellValue("REFERENCIA:");
        referencia.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell referenciar =filaNueva.createCell(3);
        referenciar.setCellFormula("'HOJA DE COSTOS  INTERNA'!D7");
        referenciar.setCellStyle(styles.get("title"));
        
        Cell tipo = filaNueva.createCell(7);
        tipo.setCellValue("T.C.");
        tipo.setCellStyle(styles.get("titleCostadoCuadro"));

        Cell cambio = filaNueva.createCell(8);
        cambio.setCellValue(Double.parseDouble(""+arreglo_nombre[9]));
        cambio.setCellStyle(styles.get("titleCostadoCuadro"));
        
        
        Row fila15=sheet.createRow(15);
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
        
        for (int i = 0; i < arreglo_datos.length+3; i++) {//numero de filas 9 //aka se pone el arreglo
      	  Row fila16=sheet.createRow(16+i);
      	  for (int j = 0; j < 10; j++) {//numero de columnas 
      		  if(i==0){
      		  if(j==4){
      			  Cell celda5a10seiz=fila16.createCell(j+1);
      	          celda5a10seiz.setCellValue("US$");
      	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
      	          celda5a10seiz.setCellStyle(styles.get("ralla"));
      	      }else if(j==5){
      			  Cell celda5a10seiz=fila16.createCell(j+1);
      	          celda5a10seiz.setCellValue("US$");
      	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
      	          celda5a10seiz.setCellStyle(styles.get("ralla"));
      		  }else if(j==6){
      		  
      			  Cell celda5a10seiz=fila16.createCell(j+1);
      	          celda5a10seiz.setCellValue("S/.");
      	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
      	          celda5a10seiz.setCellStyle(styles.get("ralla"));
      		  }else if(j==7){
      			  Cell celda5a10seiz=fila16.createCell(j+1);
      	          celda5a10seiz.setCellValue("S/.");
      	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
      	          celda5a10seiz.setCellStyle(styles.get("ralla"));
      		  }else if(j==8){
      			  Cell celda5a10seiz=fila16.createCell(j+1);
    	          celda5a10seiz.setCellValue("Kg");
    	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
    	          celda5a10seiz.setCellStyle(styles.get("ralla"));
      		  }else if(j==9){
        			Cell celda1y16=fila16.createCell(1+j);
    				celda1y16.setCellStyle(styles.get("titleMedio"));
    				celda1y16.setCellStyle(styles.get("ralla"));
          	  }else{
      			Cell celda1y16=fila16.createCell(1+j);
				celda1y16.setCellStyle(styles.get("titleMedio"));
				celda1y16.setCellStyle(styles.get("ralla"));
      		  }
      		  }else if(i<arreglo_datos.length+1){//ACA SE OBTIENE LOS DATOS PARA PONERLOS EN EL EXCEL
      			  if(j==0){
          	        Cell cell1 = fila16.createCell(j+1);//
          	        cell1.setCellFormula("'HOJA DE COSTOS  INTERNA'!B"+(10+i));
          	        cell1.setCellStyle(styles.get("rrallamediosimple")); 
      			  }else if(j==1){
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("'HOJA DE COSTOS  INTERNA'!C"+(10+i));
      				cell2.setCellStyle(styles.get("rrallamediosimple"));  
      			  }else if(j==2){//'HOJA DE COSTOS  INTERNA'!D10
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("'HOJA DE COSTOS  INTERNA'!D"+(10+i));
      				cell2.setCellStyle(styles.get("rrallacostadosimple")); 
      			  }else if(j==3){
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("+'HOJA DE COSTOS  INTERNA'!E"+(10+i));
      				cell2.setCellStyle(styles.get("rrallacostadosimple"));   
      			  }else if(j==4){//+'HOJA DE COSTOS  INTERNA'!F10
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("+'HOJA DE COSTOS  INTERNA'!F"+(10+i));
      				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3"))  ;
      			  }else if(j==5){//+'HOJA DE COSTOS  INTERNA'!G10
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("+'HOJA DE COSTOS  INTERNA'!G"+(10+i));
      				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));  
      			  }else if(j==6){//+F18*$I$15
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("+F"+(17+i)+"*$I$15");
      				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3")); 
      			  }else if(j==7){//+H18*B18
        				Cell cell2 = fila16.createCell(j+1);//
          				cell2.setCellFormula("+H"+(17+i)+"*B"+(17+i));
          				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
          		  }else if(j==8){//+H18*B18
      				Cell cell2 = fila16.createCell(j+1);//
      				cell2.setCellFormula("+'HOJA DE COSTOS  INTERNA'!O"+(10+i));
      				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
      		       }else{
          	        Cell cell122 = fila16.createCell(j+1);//'HOJA DE COSTOS  INTERNA'!B10
          	        //cell1.setCellFormula("'HOJA DE COSTOS  INTERNA'!B"+(9+i));
          	      cell122.setCellStyle(styles.get("ralla")); 
      			  }
      		  }else{
      			Cell celda1y16=fila16.createCell(1+j);
				//celda1y16.setCellStyle(styles.get("titleMedio"));
				celda1y16.setCellStyle(styles.get("ralla"));
      		  }
      		  
				
				
			}
      	  
		}
        /*
      		Row fila17=sheet.createRow(arreglo_datos.length+17);
      		for (int j = 0; j < 8; j++) {//numero de columnas 
      			Cell celda1y17=fila17.createCell(j+1);
        			celda1y17.setCellStyle(styles.get("dobleRallaHor"));}*/
        Row fila17=sheet.createRow((arreglo_datos.length)+18);
  		Row fila18=sheet.createRow((arreglo_datos.length)+19);
  		Row fila19=sheet.createRow((arreglo_datos.length)+20);
  		Row fila20=sheet.createRow((arreglo_datos.length)+21);
  		//Row fila33=sheet.createRow((arreglo_datos.length)+22);
  		for (int i = 0; i < 4; i++) {//0,1,2=3
  		for (int j = 0; j < 11; j++) {//numero de columnas YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
  			if(i==0){
  			if(j!=0){
  			if(j==6){
  				Cell celda10y0=fila17.createCell(j);
      			celda10y0.setCellValue("$");
      			celda10y0.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==7){
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellValue("S/.");
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==8){//SUMA(I10:I12)
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellValue("S/.");
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==9){
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==10){
  				//NADA
  			}else{
  				Cell celda1y17=fila17.createCell(j);
    			celda1y17.setCellStyle(styles.get("dobleRallaHor"));
    		}	
  			}
  					
  			}else if(i==1){
  				if(j>4){
  				if(j==5){
  					Cell celda10y0=fila18.createCell(j);
  	      			celda10y0.setCellValue("P. VENTA");
  	      			celda10y0.setCellStyle(styles.get("cell"));
  				}else if(j==6){
  	  				Cell celda10y0=fila18.createCell(j);//SUMA(G18:G117)
  	      			celda10y0.setCellFormula("SUM(G18:G"+((arreglo_datos.length)+17)+")");
  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==7){
  	  				Cell celda1y17=fila18.createCell(j);//SUMA(H18:H117)
  	  				celda1y17.setCellFormula("SUM(H18:H"+((arreglo_datos.length)+17)+")");
  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==8){//SUMA(I18:I117)
  	  				Cell celda1y17=fila18.createCell(j);
  	  				celda1y17.setCellFormula("SUM(I18:I"+((arreglo_datos.length)+17)+")");
  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==9){//SUMA(I18:I117)
  	  			    Cell celda10y0=fila18.createCell(j);
	      			celda10y0.setCellValue("T.PESO");
	      			celda10y0.setCellStyle(styles.get("cell"));
  	  			}else if(j==10){
  	  			Cell celda1y17=fila18.createCell(j);
  				celda1y17.setCellFormula("SUM(J18:J"+((arreglo_datos.length)+17)+")");
  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else{
  	  				Cell celda1y17=fila18.createCell(j);
  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	    		}	
  				}
  							
  			}else if(i==2){
  				if(j>4){
  	  				if(j==5){
  	  					Cell celda10y0=fila19.createCell(j);
  	  	      			celda10y0.setCellValue("IGV");
  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  				}else if(j==6){//+G118*0,19
  	  	  				Cell celda10y0=fila19.createCell(j);//SUMA(G18:G117)
  	  	      			celda10y0.setCellFormula("+G"+((arreglo_datos.length)+20)+"*0.18");
  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==7){//+H118*0,19
  	  	  				Cell celda1y17=fila19.createCell(j);//SUMA(H18:H117)
  	  	  				celda1y17.setCellFormula("+H"+((arreglo_datos.length)+20)+"*0.18");
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==8){//+I118*0,19
  	  	  				Cell celda1y17=fila19.createCell(j);
  	  	  				celda1y17.setCellFormula("+I"+((arreglo_datos.length)+20)+"*0.18");
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==9){
  	  	  				//NADA
  	  	  			}else if(j==10){
  	  	  				//NADA
  	  	  			}/**/else{
  	  	  				Cell celda1y17=fila19.createCell(j);
  	  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	  	    		}	
  	  			}
  			}else{
  				if(j>4){
  	  				if(j==5){
  	  					Cell celda10y0=fila20.createCell(j);
  	  	      			celda10y0.setCellValue("TOTAL");
  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  				}else if(j==6){//SUMA(G118:G119)
  	  	  				Cell celda10y0=fila20.createCell(j);//SUMA(G18:G117)
  	  	      			celda10y0.setCellFormula("G"+((arreglo_datos.length)+20)+"+G"+((arreglo_datos.length)+21));
  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==7){//SUMA(H118:H119)
  	  	  				Cell celda1y17=fila20.createCell(j);//SUMA(H18:H117)
  	  	  				celda1y17.setCellFormula("H"+((arreglo_datos.length)+20)+"+H"+((arreglo_datos.length)+21));
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==8){//SUMA(I118:I119)
  	  	  				Cell celda1y17=fila20.createCell(j);
  	  	  				celda1y17.setCellFormula("I"+((arreglo_datos.length)+20)+"+I"+((arreglo_datos.length)+21));
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==9){
  	  	  				//NADA
  	  	  			}else if(j==10){
  	  	  				//NADA
  	  	  			}/**/else{
  	  	  				Cell celda1y17=fila20.createCell(j);
  	  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	  	    		}	
  	  			}
  				
  				
  			}
  			
  			}
  		}//AKA TERMINA EL ULTIMO BUCLE
  		
  		//Row fila21=sheet.createRow((arreglo_datos.length)+21+i);

  		for (int i = 0; i < 43; i++) {
  			Row fila21=sheet.createRow((arreglo_datos.length)+22+i);
  	  		if(i==0){
  	  		Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(1));
			celda10y0.setCellStyle(styles.get("titleSubRallado"));
  	  		}else if(i==1){
			
  	  		}else if(i==2){
  	  		Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(3));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==3){
  	  	  	Cell celda10y0=fila21.createCell(3);
				celda10y0.setCellValue(cargar(4));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==4){
  	  	  		Cell celda10y0=fila21.createCell(3);
				celda10y0.setCellValue(cargar(5));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
  	  	  	}else if(i==5){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(6));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
  	  	  	}else if(i==6){
  	  		
  	  	  	//cargar(7);
	  	  		
  	  	  	}else if(i==7){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(8));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	
	  	  		
  	  	  	}else if(i==8){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(9));//titleCostadoSimple
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
  	  	  	
  	  	  	}else if(i==9){
  	  	  	//cargar(10)
  	  	  	}else if(i==10){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(11));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
	  	  		
  	  	  	}else if(i==11){
  	  	  	//cargar(12)
	  	  	}else if(i==12){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(13));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
	  	  	}else if(i==13){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(14));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==14){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(15));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
	  	  	}else if(i==15){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(16));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==16){
	  	  	/*Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(17));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));*/
	  	  	//cargar(17)
	  	  	}else if(i==17){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(18));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
				
		  	}else if(i==18){
		   	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(19));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
		  	  		
		  	}else if(i==19){
		  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(20));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
					
			}else if(i==20){
			Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(21));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		}else if(i==21){
  	  			////////////////
  	  		}
  	  	 else if(i==22){
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(23));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 		  	}else if(i==23){
 		   	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(24));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 		  	  		
 		  	}else if(i==24){
 		  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(25));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 					
 			}else if(i==25){
 			Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(26));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
   	  		}else if(i==26){
   	  			//NADA
   	  		}
 	  	  	else if(i==27){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(28);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
   	  		Cell atte=fila21.createCell(5);
 			atte.setCellValue(sfila);
 			//	atte.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	}else if(i==28){
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(29));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  		
 	  	  	}else if(i==29){
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(30));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 		  	}else if(i==30){
 		  		Cell celda10y0=fila21.createCell(3);
 				celda10y0.setCellValue(cargar(31));
 				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 				
 	  	  	}else if(i==31){
 	  	  	//cargar(22)
 	  	  	
 			
 	  	  	}else if(i==32){
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(33));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	}else if(i==33){
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(34));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	
 			
 	  	  	}else if(i==34){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(35);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}	
 	  	  		
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 			Cell mario=fila21.createCell(5);
 			mario.setCellValue(sfila);//titleMedioDobleRallaAriva
 			sheet.addMergedRegion(CellRangeAddress.valueOf("$F$"+(57+arreglo_datos.length)+":$G$"+(57+arreglo_datos.length)));
 			mario.setCellStyle(styles.get("dobleRallaHor"));
 			Cell mario2=fila21.createCell(6);
 			mario2.setCellStyle(styles.get("dobleRallaHor"));
 			
 	  	  	}else if(i==35){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(36);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}	
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
 			Cell ventas=fila21.createCell(5);
 			sheet.addMergedRegion(CellRangeAddress.valueOf("$F$"+(58+arreglo_datos.length)+":$G$"+(58+arreglo_datos.length)));
 			ventas.setCellValue(sfila);//titleMedioSimple
 			ventas.setCellStyle(styles.get("titleMedioSimple"));	
 	  	  	}else if(i==36){
 	  	  	
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(37));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
 	  	  	}else if(i==37){
 	  	  	
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(cargar(38));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	
 	  	  	}else if(i==38){
 	  	  	Cell celda10y0=fila21.createCell(3);
 	  	  	celda10y0.setCellValue(cargar(39));
 	  	  	Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_URL);
 	  	    link.setAddress(cargar(29));	
 	  	    celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));  	  
 	  	  	}else if(i==39){
 				//cargar(35)
 	  	  	}else if(i==40){
 	  	  	String variableka= cargar(41);
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(variableka);
 			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
 			link.setAddress("mailto:"+variableka+"?subject=Hyperlinks");
 			System.out.println("mailto:"+variableka+"?subject=Hyperlinks");
 			celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
 	  	  		
 	  	  	}else if(i==41){
 	  	  	String variableta= cargar(42);
 	  	  	Cell celda10y0=fila21.createCell(3);
 			celda10y0.setCellValue(variableta);
 			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
 			link.setAddress("mailto:"+variableta+"?subject=Hyperlinks");
 			System.out.println("mailto:"+variableta+"?subject=Hyperlinks");
 			celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
 	  	  	}
   	  	  	else{	
   	  		}
			
 	       
  	      
			
		}//aka termina el for
      		
       
        sheet.setZoom(3, 4);
   }
   public static void metodoCotizacionInterna(){
	   CreationHelper createHiperVinculo = wb.getCreationHelper();
	   Map<String, CellStyle> styles = createStyles(wb);
	   ////////////////////////////////////////////////////////////////////////////////////////////
       /******************************************************************************************/
       /********************************HOJA DE COSTOS  INTERNA************************************/
       Sheet sheet2 = wb.createSheet("HOJA DE COSTOS  INTERNA");
       PrintSetup printSetup2 = sheet2.getPrintSetup();
       printSetup2.setLandscape(true);
       sheet2.setFitToPage(true);
       sheet2.setSelected(true);
       sheet2.setHorizontallyCenter(true);
      for (int i = 0; i < 250; i++) {	sheet2.createRow(i).setHeightInPoints(10);}
			
      CellStyle style2;
      style2 = wb.createCellStyle();
      style2.setAlignment(CellStyle.BORDER_MEDIUM);
      style2.setWrapText(true);
      style2.setAlignment(CellStyle.BORDER_THIN);
     // style.setBorderRight(CellStyle.BORDER_THIN);
       //finally set column widths, the width is measured in units of 1/256th of a character width
      sheet2.setColumnWidth(0, 1900); //30 characters wide
      sheet2.setColumnWidth(1, 2200);
      sheet2.setColumnWidth(2, 1800);
      sheet2.setColumnWidth(3, 20000); //10 characters wide
      sheet2.setColumnWidth(4, 6000);
      sheet2.setColumnWidth(5, 3000);
      sheet2.setColumnWidth(6, 3000);
      sheet2.setColumnWidth(7, 3000);
      sheet2.setColumnWidth(8, 3000);
      sheet2.setColumnWidth(9, 3000);
      sheet2.setColumnWidth(10, 4500);
      sheet2.setColumnWidth(12, 6000);
      Cell cotizacion2 = sheet2.createRow(0).createCell(3);
      cotizacion2.setCellValue(arreglo_nombre[7].toString());
      cotizacion2.setCellStyle(styles.get("titleMedio"));
     //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11"));
      //G2
      Cell fechas = sheet2.createRow(1).createCell(6);
      fechas.setCellValue(arreglo_nombre[8].toString());
      fechas.setCellStyle(styles.get("title"));
      
      // titleRow.setHeightInPoints(45);//lo alto
      Row fila2= sheet2.createRow(2);
       Cell senores2 = fila2.createCell(0);
       senores2.setCellValue("SEÑORES:");
       senores2.setCellStyle(styles.get("title"));
      //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11"));
       Cell senores2r = fila2.createCell(3);
       senores2r.setCellValue(arreglo_nombre[0].toString());
       senores2r.setCellStyle(styles.get("title"));
       
       Row fila4=sheet2.createRow(3);
        Cell atencion2 = fila4.createCell(0);
        atencion2.setCellValue("ATENCION:");
        atencion2.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell atencionr = fila4.createCell(3);
        atencionr.setCellValue(arreglo_nombre[1].toString());
        atencionr.setCellStyle(styles.get("title"));
        
        Cell visto = fila4.createCell(6);
        visto.setCellValue("VISTO POR         :");
        visto.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell vistor = fila4.createCell(7);
        vistor.setCellValue(arreglo_nombre[4].toString());
        vistor.setCellStyle(styles.get("title"));
        
        Row fila5=sheet2.createRow(4);
        Cell direccion2 = fila5.createCell(0);
        direccion2.setCellValue("DIRECCION:");
        direccion2.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell direccionr = fila5.createCell(3);
        direccionr.setCellValue(arreglo_nombre[2].toString());
        direccionr.setCellStyle(styles.get("title"));
        
        Cell tipo = fila5.createCell(6);
        tipo.setCellValue("TIPO CLIENTE     :");
        tipo.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11")); 
        Cell tipor = fila5.createCell(7);
        tipor.setCellValue(arreglo_nombre[5].toString());
        tipor.setCellStyle(styles.get("title"));
        
        Row fila6=sheet2.createRow(5);
        Cell telefono2 = fila6.createCell(0);
        telefono2.setCellValue("TELEFONO:");
        telefono2.setCellStyle(styles.get("title"));
        Cell telefonor = fila6.createCell(3);
        telefonor.setCellValue(arreglo_nombre[3].toString());
        telefonor.setCellStyle(styles.get("title"));
        
        Cell codigo = fila6.createCell(6);
        codigo.setCellValue("CODIGO CLIENTE:");
        codigo.setCellStyle(styles.get("title"));
        Cell codigor = fila6.createCell(7);
        codigor.setCellValue(arreglo_nombre[6].toString());
        codigor.setCellStyle(styles.get("title"));
        
        Row fila7=sheet2.createRow(6);
        Cell referencia2 = fila7.createCell(0);
        referencia2.setCellValue("REFERENCIA:");
        referencia2.setCellStyle(styles.get("title"));
        Cell referenciar = fila7.createCell(3);
        referenciar.setCellValue(arreglo_nombre[10].toString());
        referenciar.setCellStyle(styles.get("title"));
        
        
        /////////////////////////////////////////////////////////////////////////////////
        ///////////////////APARTIR DE ACA TIENES QUE AUMENTAR 1/////////////////////////
        Row fila9=sheet2.createRow(8);
        Row fila10=sheet2.createRow(9);
        
        
        fila9.createCell(0).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(0).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell0 =fila9.getCell(0);
        cell0.setCellValue("ITEM");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$A$9:$A$10"));
        
        
        fila9.createCell(1).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(1).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell1 = fila9.getCell(1);
        cell1.setCellValue("CANT");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$B$9:$B$10"));
   
        fila9.createCell(2).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(2).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell2 = fila9.getCell(2);
        cell2.setCellValue("UND");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$C$9:$C$10"));
        
        fila9.createCell(3).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(3).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell3 = fila9.getCell(3);
        cell3.setCellValue("DESCRIPCION");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$D$9:$D$10"));
        
        fila9.createCell(4).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(4).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell4 = fila9.getCell(4);
        cell4.setCellValue("MARCA");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$E$9:$E$10"));
        
        fila9.createCell(5).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(5).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell58 = fila9.getCell(5);
        Cell cell59 = fila10.getCell(5);
        cell58.setCellValue("P. UNIT.");
        cell59.setCellValue("US$");
        
        fila9.createCell(6).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(6).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell68 = fila9.getCell(6);
        Cell cell69 = fila10.getCell(6);
        cell68.setCellValue("TOTAL");
        cell69.setCellValue("US$");
        
        fila9.createCell(7).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(7).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell78 = fila9.getCell(7);
        Cell cell79 = fila10.getCell(7);
        cell78.setCellValue("COSTO");
        cell79.setCellValue("US$");
        
        fila9.createCell(8).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(8).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell88 = fila9.getCell(8);
        Cell cell89 = fila10.getCell(8);
        cell88.setCellValue("TOTAL");
        cell89.setCellValue("US$");
        
        fila9.createCell(9).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(9).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell98 = fila9.getCell(9);
        Cell cell99 = fila10.getCell(9);
        cell98.setCellValue("DIF.");
        cell99.setCellValue("US$");
        
        fila9.createCell(10).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(10).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell10 = fila9.getCell(10);
        cell10.setCellValue("FECHA");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$K$9:$K$10"));
        
        fila9.createCell(11).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(11).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell11 = fila9.getCell(11);
        cell11.setCellValue("%");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$L$9:$L$10"));
        
        fila9.createCell(12).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(12).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell12 = fila9.getCell(12);
        cell12.setCellValue("PROV");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$M$9:$M$10"));
        
        fila9.createCell(13).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        fila10.createCell(13).setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        Cell cell13 = fila9.getCell(13);
        cell13.setCellValue("CODIGO");
        sheet2.addMergedRegion(CellRangeAddress.valueOf("$N$9:$N$10"));
        
        
        fila9.createCell(14).setCellStyle(styles.get("mediaCajaArriba"));
        fila10.createCell(14).setCellStyle(styles.get("mediaCajaAbajo"));
        Cell cell144 = fila9.getCell(14);
        Cell cell145 = fila10.getCell(14);
        cell144.setCellValue("PESO");
        cell145.setCellValue("Kg");
       
      
        
      
        System.out.println("tamaño del array es:"+arreglo_datos.length);
       // System.out.println("Primero:"+arreglo_datos[1][1]);
        for (int i = 0; i < arreglo_datos.length+1; i++) {//numero de filas 8 //aka se pone el arreglo
        	//ESTE ES FILA11
        	Row fila11=sheet2.createRow(10+i);
        	  for (int j = 0; j < 16; j++) {//numero de columnas 
        		if(i==0&&j==0){
        			Cell celda10A=fila11.createCell(j);
        			celda10A.setCellValue(Integer.parseInt("1"));
        			celda10A.setCellStyle(styles.get("rrallamediosimple"));	
        		}
        		if(j==0){
        			if(i!=0&&i<arreglo_datos.length){//1.0,2.0
        				Cell celda11A=fila11.createCell(j);
        				celda11A.setCellFormula("A"+(10+i)+"+1");
        				celda11A.setCellStyle(styles.get("rrallamediosimple"));		
        			}
        		}else if(j==1){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(Integer.parseInt(""+arreglo_datos[i][0]));
            		//	celda10y0.setCellFormula("H"+(arreglo_datos.length+i)+"*B"+(arreglo_datos.length+i));
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        		}else if(j==2){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(""+arreglo_datos[i][1]);
            		//	celda10y0.setCellFormula("H"+(arreglo_datos.length+i)+"*B"+(arreglo_datos.length+i));
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			
        			
        		}else if(j==3){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(""+arreglo_datos[i][2]);
            		//	celda10y0.setCellFormula("H"+(arreglo_datos.length+i)+"*B"+(arreglo_datos.length+i));
          				celda10y0.setCellStyle(styles.get("rrallacostadosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			
        			
        		}else if(j==4){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(""+arreglo_datos[i][3]);
            		//	celda10y0.setCellFormula("H"+(arreglo_datos.length+i)+"*B"+(arreglo_datos.length+i));
          				celda10y0.setCellStyle(styles.get("rrallacostadosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        		}else if(j==5){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][4]));
            			//OE BUEY ACA SE PONE EL COSTO
          				celda10y0.setCellStyle(styles.get("rrallamediosimpleFormat3"))		;
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        		}else if(j==6){
        			if(i<arreglo_datos.length){//ESTE CREOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        			Cell celda10y0=fila11.createCell(j);//(F10*B10)
        			celda10y0.setCellFormula("F"+(11+i)+"*B"+(11+i));
        			//el formato tiene 3 digitos
      				celda10y0.setCellStyle(styles.get("rrallamediosimpleFormat2"));		
        			}else{
        			Cell celda10y0=fila11.createCell(j);//(F10*B10)
          			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
        			}
        		}else if(j==7){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][5]) );
          				celda10y0.setCellStyle(styles.get("rrallamediosimpleFormat3"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
            	}else if(j==8){
        			if(i<arreglo_datos.length){
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
            			celda10y0.setCellFormula("H"+(11+i)+"*B"+(11+i));
          				celda10y0.setCellStyle(styles.get("rrallamediosimpleFormat2"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);//(F10*B10)
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==9){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellFormula("G"+(11+i)+"-I"+(11+i));
          				celda10y0.setCellStyle(styles.get("rrallamediosimpleFormat2"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==10){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellValue(""+arreglo_datos[i][6]);
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==11){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellFormula("J"+(11+i)+"/G"+(11+i));
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==12){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellValue(""+arreglo_datos[i][7]);
          				celda10y0.setCellStyle(styles.get("rrallacostadosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==13){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellValue(""+arreglo_datos[i][8]);
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else if(j==14){//J10/G10
        			if(i<arreglo_datos.length){//
            			Cell celda10y0=fila11.createCell(j);
            			celda10y0.setCellValue(Double.parseDouble(""+arreglo_datos[i][9]));
          				celda10y0.setCellStyle(styles.get("rrallamediosimple"));		
            			}else{
            			Cell celda10y0=fila11.createCell(j);
              			celda10y0.setCellStyle(styles.get("rrallamediosimple"));	
            			}
        			//(G10-I10)
        		}else{
        		Cell celda10y0=fila11.createCell(j);
  				//celda1y16.setCellStyle(styles.get("titleMedio"));
  				celda10y0.setCellStyle(styles.get("ralla"));		
        			
        		}
  				
  			}
        	  
  		}
      //SUMA(G10:G214)
  	  //if(i==(arreglo_datos.length)){
  		Row fila17=sheet2.createRow((arreglo_datos.length)+11);
  		Row fila18=sheet2.createRow((arreglo_datos.length)+12);
  		Row fila19=sheet2.createRow((arreglo_datos.length)+13);
  		
  		for (int i = 0; i < 3; i++) {//0,1,2=3
  		for (int j = 0; j < 15; j++) {//NUMERO DE COLUMNAS 
  			if(i==0){
  			if(j==5){
  				Cell celda10y0=fila17.createCell(j);
      			celda10y0.setCellValue("P.VENTA");
      			celda10y0.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==6){
  				Cell celda1y17=fila17.createCell(j);//AKI TANBIEN FLATYA CREO
  				celda1y17.setCellFormula("SUM(G11:G"+(10+(arreglo_datos.length))+")");
  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  			}else if(j==8){//SUMA(I10:I12)
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellFormula("SUM(I11:I"+(10+(arreglo_datos.length))+")");
  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  			}else if(j==9){//SUMA(J10:J12)
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellFormula("SUM(J11:J"+(10+(arreglo_datos.length))+")");
  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  			}else if(j==11){//=(J13/G13)
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellFormula("J"+(12+(arreglo_datos.length))+"/G"+(12+(arreglo_datos.length)));
  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  			}else if(j==13){
  				Cell celda10y0=fila17.createCell(j);
      			celda10y0.setCellValue("T.PESO");
      			celda10y0.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==14){
  				Cell celda1y17=fila17.createCell(j);
  				celda1y17.setCellFormula("SUM(O11:O"+(10+(arreglo_datos.length))+")");
  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  			}else{
  			Cell celda1y17=fila17.createCell(j);
    			celda1y17.setCellStyle(styles.get("dobleRallaHor"));}		
  			}else if(i==1){
  				if(j==5){
  	  				Cell celda10y0=fila18.createCell(j);
  	      			celda10y0.setCellValue("IGV");
  	      			celda10y0.setCellStyle(styles.get("titleMedio"));
  	  			}else if(j==6){//+G215*0.18
  	  				Cell celda1y17=fila18.createCell(j);
  	  				celda1y17.setCellFormula("+G"+(12+(arreglo_datos.length))+"*0.18");
  	  			celda1y17.setCellStyle(styles.get("titleMedioSimpleFormat"));
  	  			}else if(j==8){//+I215*0.18
  	  				Cell celda1y17=fila18.createCell(j);
  	  				celda1y17.setCellFormula("+I"+(12+(arreglo_datos.length))+"*0.18");
  	  				celda1y17.setCellStyle(styles.get("titleMedioSimpleFormat"));
  	  			}else if(j==9){//=+J215*0.18
  	  				Cell celda1y17=fila18.createCell(j);
  	  				celda1y17.setCellFormula("+J"+(12+(arreglo_datos.length))+"*0.18");
  	  				celda1y17.setCellStyle(styles.get("titleMedioSimpleFormat"));
  	  			}else if(j==11){//=(J216/G216)
  	  				Cell celda1y17=fila18.createCell(j);
  	  				celda1y17.setCellFormula("J"+(13+(arreglo_datos.length))+"/G"+(13+(arreglo_datos.length)));
  	  				celda1y17.setCellStyle(styles.get("titleMedioSimpleFormat"));
  	  			}/**/else{
  	  				//Cell celda1y17=fila17.createCell(j);
  	    			//celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	    			}		
  			}else{
  				if(j==5){
  	  				Cell celda10y0=fila19.createCell(j);
  	      			celda10y0.setCellValue("TOTAL");
  	      			celda10y0.setCellStyle(styles.get("titleMedio"));
  	  			}else if(j==6){//G216+G215
  	  				Cell celda1y17=fila19.createCell(j);
  	  				celda1y17.setCellFormula("G"+(13+(arreglo_datos.length))+"+G"+(12+(arreglo_datos.length)));
  	  			celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	  			}else if(j==8){//=SUMA(I215:I216)
  	  				Cell celda1y17=fila19.createCell(j);
  	  			celda1y17.setCellFormula("I"+(13+(arreglo_datos.length))+"+I"+(12+(arreglo_datos.length)));
  	  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	  			}else if(j==9){//SUMA(J215:J216)
  	  				Cell celda1y17=fila19.createCell(j);
  	  			celda1y17.setCellFormula("J"+(13+(arreglo_datos.length))+"+J"+(12+(arreglo_datos.length)));
  	  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	  			}else if(j==11){//(J217/G217)
  	  				Cell celda1y17=fila19.createCell(j);
  	  				celda1y17.setCellFormula("J"+(14+(arreglo_datos.length))+"/G"+(14+(arreglo_datos.length)));
  	  				celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	  			}/**/else{
  	  				//Cell celda1y17=fila17.createCell(j);
  	    			//celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  	    			}
  			}
  			
  			}
  		}//AKA TERMINA EL ULTIMO BUCLE
  		
  		for (int i = 0; i < 43; i++) {
  			Row fila21=sheet2.createRow((arreglo_datos.length)+14+i);
  	  		if(i==0){
  	  		Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(1));
			celda10y0.setCellStyle(styles.get("titleSubRallado"));
  	  		}else if(i==1){
			
  	  		}else if(i==2){
  	  		Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(3));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==3){
  	  	  	Cell celda10y0=fila21.createCell(3);
				celda10y0.setCellValue(cargar(4));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==4){
  	  	  		Cell celda10y0=fila21.createCell(3);
				celda10y0.setCellValue(cargar(5));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
  	  	  	}else if(i==5){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(6));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
  	  	  	}else if(i==6){
  	  		
  	  	  	//cargar(7);
	  	  		
  	  	  	}else if(i==7){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(8));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	
	  	  		
  	  	  	}else if(i==8){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(9));//titleCostadoSimple
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
  	  	  	
  	  	  	}else if(i==9){
  	  	  	//cargar(10)
  	  	  	}else if(i==10){
  	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(11));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
	  	  		
  	  	  	}else if(i==11){
  	  	  	//cargar(12)
	  	  	}else if(i==12){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(13));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
	  	  	}else if(i==13){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(14));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==14){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(15));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
	  	  	}else if(i==15){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(16));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==16){
	  	  	/*Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(17));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));*/
	  	  	//cargar(17)
	  	  	}else if(i==17){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(18));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
				
		  	}else if(i==18){
		   	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(19));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
		  	  		
		  	}else if(i==19){
		  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(20));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
					
			}else if(i==20){
			Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(21));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		}else if(i==21){
  	  			//NADA
  	  		}
  	  	    else if(i==22){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(23));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
		  	}else if(i==23){
		   	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(24));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
		  	  		
		  	}else if(i==24){
		  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(25));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
					
			}else if(i==25){
			Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(26));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		}else if(i==26){
  	  			//NADA
  	  		}
	  	  	else if(i==27){
	  	  	String filaSeparada="",pfila="",sfila="";
	  	  	filaSeparada=cargar(28);
	  	  	if(filaSeparada.indexOf("|")==-1){
	  	  		
	  	  	}else{
	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
	  	  	}
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(pfila);
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		Cell atte=fila21.createCell(5);
			atte.setCellValue(sfila);
			//	atte.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	}else if(i==28){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(29));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
	  	  	}else if(i==29){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(30));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
		  	}else if(i==30){
		  		Cell celda10y0=fila21.createCell(3);
				celda10y0.setCellValue(cargar(31));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
				
	  	  	}else if(i==31){
	  	  	//cargar(22)
	  	  	
			
	  	  	}else if(i==32){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(33));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	}else if(i==33){
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(34));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	
			
	  	  	}else if(i==34){
	  	  	String filaSeparada="",pfila="",sfila="";
	  	  	filaSeparada=cargar(35);
	  	  	if(filaSeparada.indexOf("|")==-1){
	  	  		
	  	  	}else{
	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
	  	  	}	
	  	  		
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(pfila);
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			Cell mario=fila21.createCell(5);
			mario.setCellValue(sfila);//titleMedioDobleRallaAriva
			sheet2.addMergedRegion(CellRangeAddress.valueOf("$F$"+(49+arreglo_datos.length)+":$G$"+(49+arreglo_datos.length)));
			mario.setCellStyle(styles.get("dobleRallaHor"));
			Cell mario2=fila21.createCell(6);
			mario2.setCellStyle(styles.get("dobleRallaHor"));
			
	  	  	}else if(i==35){
	  	  	String filaSeparada="",pfila="",sfila="";
	  	  	filaSeparada=cargar(36);
	  	  	if(filaSeparada.indexOf("|")==-1){
	  	  		
	  	  	}else{
	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
	  	  	}	
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(pfila);
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
			Cell ventas=fila21.createCell(5);
			sheet2.addMergedRegion(CellRangeAddress.valueOf("$F$"+(50+arreglo_datos.length)+":$G$"+(50+arreglo_datos.length)));
			ventas.setCellValue(sfila);//titleMedioSimple
			ventas.setCellStyle(styles.get("titleMedioSimple"));	
	  	  	}else if(i==36){
	  	  	
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(37));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
	  	  	}else if(i==37){
	  	  	
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(38));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	
	  	  	}else if(i==38){
	  	  	Cell celda10y0=fila21.createCell(3);
	  	  	celda10y0.setCellValue(cargar(39));
	  	  	Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_URL);
	  	    link.setAddress(cargar(29));	
	  	    celda10y0.setHyperlink(link);
			celda10y0.setCellStyle(styles.get("titleHipervinculo"));  	  
	  	  	}else if(i==39){
				//cargar(35)
	  	  	}else if(i==40){
	  	  	String variableka= cargar(41);
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(variableka);
			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
			link.setAddress("mailto:"+variableka+"?subject=Hyperlinks");
			System.out.println("mailto:"+variableka+"?subject=Hyperlinks");
			celda10y0.setHyperlink(link);
			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
	  	  		
	  	  	}else if(i==41){
	  	  	String variableta= cargar(42);
	  	  	Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(variableta);
			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
			link.setAddress("mailto:"+variableta+"?subject=Hyperlinks");
			System.out.println("mailto:"+variableta+"?subject=Hyperlinks");
			celda10y0.setHyperlink(link);
			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
	  	  	}
  	  	  	else{	
  	  		}
			
 	       
  	      
			
		}//aka termina el for
			
			
		
  	 
        
        sheet2.setZoom(3, 4);
   }
 
   public static void metodoCorreoCel() throws IOException{
	   CreationHelper createHiperVinculo = wb.getCreationHelper();
	   Map<String, CellStyle> styles = createStyles(wb);
	   ////////////////////////////////////////////////////////////////////////////////////////////
       /******************************************************************************************/
       /**************************************CORREO CEL******************************************/
       Sheet sheet3 = wb.createSheet("CORREO CEL");
       PrintSetup printSetup3 = sheet3.getPrintSetup();
       printSetup3.setLandscape(true);
       sheet3.setFitToPage(true);
       sheet3.setHorizontallyCenter(true);
       sheet3.setPrintGridlines(false);//PARA QUE 	
       sheet3.setDisplayGridlines(false);//SALGA BLANCO TODOO!
          
       /*  
       Row titleRow = sheet3.createRow(0);
       //  titleRow.setHeightInPoints(45);//lo alto
         Cell titleCell = titleRow.createCell(0);
         titleCell.setCellValue("Corporacion Electrica Lima");
         titleCell.setCellStyle(styles.get("title"));
         sheet3.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));
  */
       
    
       
     // for (int i = 0; i < 250; i++) {	sheet3.createRow(i).setHeightInPoints(10);}
			
      CellStyle style3;
      style3 = wb.createCellStyle();
      style3.setAlignment(CellStyle.BORDER_MEDIUM);
      style3.setWrapText(true);
      style3.setAlignment(CellStyle.BORDER_THIN);
     // style.setBorderRight(CellStyle.BORDER_THIN);
       //finally set column widths, the width is measured in units of 1/256th of a character width
      sheet3.setColumnWidth(0, 800); //30 characters wide
      sheet3.setColumnWidth(1, 2200);
      sheet3.setColumnWidth(2, 1800);
      sheet3.setColumnWidth(3, 20000); //10 characters wide
      sheet3.setColumnWidth(4, 6000);
      sheet3.setColumnWidth(5, 3000);
      sheet3.setColumnWidth(6, 3000);
      sheet3.setColumnWidth(7, 3000);
      sheet3.setColumnWidth(8, 3000);
      sheet3.setColumnWidth(9, 3000);
      sheet3.setColumnWidth(10, 3000);
      
      //add picture data to this workbook.
     // URL cad=cl.getResource("Images/LOGO.JPG");
     // in=clss.getResourceAsStream("/File/CONDICIONESEXCEL.txt");
     // Icon imagen2  = new ImageIcon(cl.getResource("Images/LOGO.JPG"));
     // br = new BufferedReader(new  InputStreamReader(in));
   // public static InputStream in;
      //FileInputStream("image1.jpeg");

      //InputStream is = new FileInputStream("Images/LOGO.JPG");
     
  	//cl.getResource("Images/logeo.jpg");
      TranCotizacionAutomatica objCot;
      objCot=new TranCotizacionAutomatica();
      TranCotizacion objCoti;
      objCoti=new TranCotizacion();
      
      String imagen="";
      
      if(objCot.estado==1){
    	  imagen="Images/LOGOelecorp.jpg";
    	  imagen="Images/LOGO.JPG"; 
      }else if(objCot.estado==2) {
    	  imagen="Images/LOGO-CYE.JPG";
      }else if(objCoti.estado==1) {
    	  imagen="Images/LOGOelecorp.jpg";
    	  imagen="Images/LOGO.JPG"; 
      }else{
    	  imagen="Images/LOGO-CYE.JPG";
      }
  
  	  InputStream is = (cl.getResourceAsStream(imagen));
      byte[] bytes = IOUtils.toByteArray(is);
      int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
      is.close();
      
      CreationHelper helper = wb.getCreationHelper();
      
      // Create the drawing patriarch.  This is the top level container for all shapes. 
      Drawing drawing = sheet3.createDrawingPatriarch();

     
      //add a picture shape
      ClientAnchor anchor = helper.createClientAnchor();
      //set top-left corner of the picture,
      //subsequent call of Picture#resize() will operate relative to it
     // anchor.setCol1(3);
      //  anchor.setRow1(2);
      anchor.setCol1(1);
      anchor.setRow1(0);
      Picture pict = drawing.createPicture(anchor, pictureIdx);

      //auto-size picture relative to its top-left corner
     //pict.resize();
      
      
      
      
      // titleRow.setHeightInPoints(45);//lo alto
      Cell cotizacion3 = sheet3.createRow(10).createCell(3);
      cotizacion3.setCellValue("COTIZACION");//=+'COTIZACION - CLIENTE'!D7
      cotizacion3.setCellFormula("'HOJA DE COSTOS  INTERNA'!D1");
      cotizacion3.setCellStyle(styles.get("titleMedio"));
      //+'HOJA DE COSTOS  INTERNA'!G2
      
      Cell fecha = sheet3.createRow(12).createCell(4);
      fecha.setCellFormula("+'HOJA DE COSTOS  INTERNA'!G2");
      fecha.setCellStyle(styles.get("title"));
      
      Row fila14=sheet3.createRow(14);
       Cell senores = fila14.createCell(1);
       senores.setCellValue("SEÑORES:");
       senores.setCellStyle(styles.get("title"));
       Cell senoresr = fila14.createCell(3);
       senoresr.setCellFormula("+'COTIZACION - CLIENTE'!D11");
       senoresr.setCellStyle(styles.get("title"));
      //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11"));
       
       Row fila15=sheet3.createRow(15);
        Cell atencion = fila15.createCell(1);
        atencion.setCellValue("ATENCION:");
        atencion.setCellStyle(styles.get("title"));
        Cell atencionr = fila15.createCell(3);
        
        
        
        
        
        
        atencionr.setCellFormula("+'COTIZACION - CLIENTE'!D12");
        atencionr.setCellStyle(styles.get("title"));
       
       Row fila16=sheet3.createRow(16);
        Cell direccion =fila16.createCell(1);
        direccion.setCellValue("DIRECCION:");
        direccion.setCellStyle(styles.get("title"));
        Cell direccionr =fila16.createCell(3);
        direccionr.setCellFormula("+'COTIZACION - CLIENTE'!D13");
        direccionr.setCellStyle(styles.get("title"));
        
       Row fila17=sheet3.createRow(17);
        Cell telefono = fila17.createCell(1);
        telefono.setCellValue("TELEFONO:");
        telefono.setCellStyle(styles.get("title"));
        Cell telefonor = fila17.createCell(3);
        telefonor.setCellFormula("+'COTIZACION - CLIENTE'!D14");
        telefonor.setCellStyle(styles.get("title"));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Row filanUEVA=sheet3.createRow(18);
        Cell referencia= filanUEVA.createCell(1);
        referencia.setCellValue("REFERENCIA:");
        referencia.setCellStyle(styles.get("title"));
        Cell referenciar = filanUEVA.createCell(3);
        referenciar.setCellFormula("+'COTIZACION - CLIENTE'!D15");
        referenciar.setCellStyle(styles.get("title"));

        
        Cell tipo = filanUEVA.createCell(7);
        tipo.setCellValue("T.C.");
        tipo.setCellStyle(styles.get("titleCostadoCuadro"));

        Cell cambio = filanUEVA.createCell(8);
        cambio.setCellValue(Double.parseDouble(""+arreglo_nombre[9]));
        cambio.setCellStyle(styles.get("titleCostadoCuadro"));
        
        
        Row fila18=sheet3.createRow(19);
        Cell celda1=fila18.createCell(1);
        celda1.setCellValue("CANT");
        celda1.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda2=fila18.createCell(2);
        celda2.setCellValue("U");
        celda2.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda3=fila18.createCell(3);
        celda3.setCellValue("DESCRIPCION");
        celda3.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda4=fila18.createCell(4);
        celda4.setCellValue("MARCA");
        celda4.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda5=fila18.createCell(5);
        celda5.setCellValue("P.UNIT.");
        celda5.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda6=fila18.createCell(6);
        celda6.setCellValue("TOTAL");
        celda6.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda7=fila18.createCell(7);
        celda7.setCellValue("P.UNIT.");
        celda7.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda8=fila18.createCell(8);
        celda8.setCellValue("TOTAL");
        celda8.setCellStyle(styles.get("titleCostadoCuadro"));
        
        Cell celda9=fila18.createCell(9);
        celda9.setCellValue("PESO");
        celda9.setCellStyle(styles.get("titleCostadoCuadro"));
        
        for (int i = 0; i < arreglo_datos.length+3; i++) {//numero de filas 8 //aka se pone el arreglo
        	  Row fila19=sheet3.createRow(20+i);
        	  for (int j = 0; j < 10; j++) {//numero de columnas 
        		  if(i==0){
        		  if(j==4){
        			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("US$");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        	      }else if(j==5){
        			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("US$");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        		  }else if(j==6){
        		  
        			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("S/.");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        		  }else if(j==7){
        			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("S/.");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        		  }else if(j==8){
        			  Cell celda5a10seiz=fila19.createCell(1+j);
          			  celda5a10seiz.setCellValue("Kg");
          			  celda5a10seiz.setCellStyle(styles.get("titleMedio"));
          			  celda5a10seiz.setCellStyle(styles.get("ralla"));
        		  }else if(j==9){
        			  Cell celda1y16=fila19.createCell(1+j);
    				  celda1y16.setCellStyle(styles.get("titleMedio"));
    				  celda1y16.setCellStyle(styles.get("ralla"));
        		  } else{
        			Cell celda1y16=fila19.createCell(1+j);
  				celda1y16.setCellStyle(styles.get("titleMedio"));
  				celda1y16.setCellStyle(styles.get("ralla"));
        		  }
        		  }else if(i<arreglo_datos.length+1){
        			  if(j==0){
            	        Cell cell1 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!B18
            	        cell1.setCellFormula("+'COTIZACION - CLIENTE'!B"+(17+i));
            	        cell1.setCellStyle(styles.get("rrallamediosimple")); 
        			  }else if(j==1){//+'COTIZACION - CLIENTE'!C18
        				Cell cell2 = fila19.createCell(j+1);//
        				cell2.setCellFormula("+'COTIZACION - CLIENTE'!C"+(17+i));
        				cell2.setCellStyle(styles.get("rrallamediosimple"));  
        			  }else if(j==2){//+'COTIZACION - CLIENTE'!D18
        				Cell cell2 = fila19.createCell(j+1);//
        				cell2.setCellFormula("+'COTIZACION - CLIENTE'!D"+(17+i));
        				cell2.setCellStyle(styles.get("rrallacostadosimple"));
        			  }else if(j==3){
        				Cell cell2 = fila19.createCell(j+1);//+'HOJA DE COSTOS  INTERNA'!E10
        				cell2.setCellFormula("+'COTIZACION - CLIENTE'!E"+(17+i));
        				cell2.setCellStyle(styles.get("rrallacostadosimple"));   
        			  }else if(j==4){
        				Cell cell2 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!F18
        				cell2.setCellFormula("+'COTIZACION - CLIENTE'!F"+(17+i));
        				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3"));  
        			  }else if(j==5){
        				Cell cell2 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!G18
        				cell2.setCellFormula("+'COTIZACION - CLIENTE'!G"+(17+i));
        				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));  
        			  }else if(j==6){
        				Cell cell2 = fila19.createCell(j+1);//+F22*$I$19
        				cell2.setCellFormula("+F"+(21+i)+"*$I$19");
        				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3")); 
        			  }else if(j==7){//+H22*B22
          				Cell cell2 = fila19.createCell(j+1);//
            				cell2.setCellFormula("+H"+(21+i)+"*B"+(21+i));
            				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
            		  }else if(j==8){//+H22*B22
          				Cell cell2 = fila19.createCell(j+1);//
          				cell2.setCellFormula("+'COTIZACION - CLIENTE'!J"+(17+i));
            			cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
            		  }/**/else{
            	        Cell cell122 = fila19.createCell(j+1);//'HOJA DE COSTOS  INTERNA'!B10
            	        //cell1.setCellFormula("'HOJA DE COSTOS  INTERNA'!B"+(9+i));
            	      cell122.setCellStyle(styles.get("ralla")); 
        			  }
        		  }else{
        			Cell celda1y16=fila19.createCell(1+j);
  				//celda1y16.setCellStyle(styles.get("titleMedio"));
  				celda1y16.setCellStyle(styles.get("ralla"));
        		  }
        		  
  				
  				
  			}
        	  
  		}
        
        Row fila20=sheet3.createRow((arreglo_datos.length)+22);
  		Row fila21=sheet3.createRow((arreglo_datos.length)+23);
  		Row fila22=sheet3.createRow((arreglo_datos.length)+24);
  		Row fila23=sheet3.createRow((arreglo_datos.length)+25);
  		for (int i = 0; i < 4; i++) {//0,1,2=3
  		for (int j = 0; j < 11; j++) {//numero de columnas 
  			if(i==0){
  			if(j!=0){
  			if(j==6){
  				Cell celda10y0=fila20.createCell(j);
      			celda10y0.setCellValue("$");
      			celda10y0.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==7){
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellValue("S/.");
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==8){//SUMA(I10:I12)
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellValue("S/.");
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==9){//SUMA(I10:I12)
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==10){
  				//NADA
  			}else{
  				Cell celda1y17=fila20.createCell(j);
    			celda1y17.setCellStyle(styles.get("dobleRallaHor"));
    		}	
  			}
  					
  			}else if(i==1){
  				if(j>4){
  				if(j==5){
  					Cell celda10y0=fila21.createCell(j);
  	      			celda10y0.setCellValue("P. VENTA");
  	      			celda10y0.setCellStyle(styles.get("cell"));
  				}else if(j==6){
  	  				Cell celda10y0=fila21.createCell(j);//SUMA(G18:G117)
  	      			celda10y0.setCellFormula("SUM(G22:G"+((arreglo_datos.length)+21)+")");
  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==7){
  	  				Cell celda1y17=fila21.createCell(j);//SUMA(H18:H117)
  	  				celda1y17.setCellFormula("SUM(H22:H"+((arreglo_datos.length)+21)+")");
  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==8){//SUMA(I18:I117)
  	  				Cell celda1y17=fila21.createCell(j);
  	  				celda1y17.setCellFormula("SUM(I22:I"+((arreglo_datos.length)+21)+")");
  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  			}else if(j==9){
  	  			    Cell celda10y0=fila21.createCell(j);
	      			celda10y0.setCellValue("T.PESO");
	      			celda10y0.setCellStyle(styles.get("cell"));
	  	  		}else if(j==10){
	  	  		    Cell celda10y0=fila21.createCell(j);//SUMA(G18:G117)
	      			celda10y0.setCellFormula("SUM(J22:J"+((arreglo_datos.length)+21)+")");
	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
	  	  		}else{
  	  				Cell celda1y17=fila21.createCell(j);
  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	    		}	
  				}
  							
  			}else if(i==2){
  				if(j>4){
  	  				if(j==5){
  	  					Cell celda10y0=fila22.createCell(j);
  	  	      			celda10y0.setCellValue("IGV");
  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  				}else if(j==6){//+G118*0,19
  	  	  				Cell celda10y0=fila22.createCell(j);//SUMA(G18:G117)
  	  	      			celda10y0.setCellFormula("+G"+((arreglo_datos.length)+24)+"*0.18");
  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==7){//+H118*0,19
  	  	  				Cell celda1y17=fila22.createCell(j);//SUMA(H18:H117)
  	  	  				celda1y17.setCellFormula("+H"+((arreglo_datos.length)+24)+"*0.18");
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==8){//+I118*0,19
  	  	  				Cell celda1y17=fila22.createCell(j);
  	  	  				celda1y17.setCellFormula("+I"+((arreglo_datos.length)+24)+"*0.18");
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==9){//SUMA(I18:I117)
  	  	  				//NADA
  	  	  			}else if(j==10){//SUMA(I18:I117)
  	  	  				//NADA
  	  	  			}else{
  	  	  				Cell celda1y17=fila22.createCell(j);
  	  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	  	    		}	
  	  			}
  			}else{
  				if(j>4){
  	  				if(j==5){
  	  					Cell celda10y0=fila23.createCell(j);
  	  	      			celda10y0.setCellValue("TOTAL");
  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  				}else if(j==6){//SUMA(G118:G119)
  	  	  				Cell celda10y0=fila23.createCell(j);//SUMA(G18:G117)
  	  	      			celda10y0.setCellFormula("G"+((arreglo_datos.length)+24)+"+G"+((arreglo_datos.length)+25));
  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==7){//SUMA(H118:H119)
  	  	  				Cell celda1y17=fila23.createCell(j);//SUMA(H18:H117)
  	  	  				celda1y17.setCellFormula("H"+((arreglo_datos.length)+24)+"+H"+((arreglo_datos.length)+25));
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==8){//SUMA(I118:I119)
  	  	  				Cell celda1y17=fila23.createCell(j);
  	  	  				celda1y17.setCellFormula("I"+((arreglo_datos.length)+24)+"+I"+((arreglo_datos.length)+25));
  	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  			}else if(j==9){
  	  	  				//NADA
  	  	  			}else if(j==10){
  	  	  				//NADA
  	  	  			}else{
  	  	  				Cell celda1y17=fila23.createCell(j);
  	  	    			celda1y17.setCellStyle(styles.get("cuadradoSimpleChico"));
  	  	    		}	
  	  			}/**/
  				
  				
  			}
  			
  			}
  		}//AKA TERMINA EL ULTIMO BUCLE
        
  		for (int i = 0; i < 43; i++) {
  			Row fila24=sheet3.createRow((arreglo_datos.length)+26+i);
  	  		if(i==0){
  	  		Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(1));
			celda10y0.setCellStyle(styles.get("titleSubRallado"));
  	  		}else if(i==1){
			
  	  		}else if(i==2){
  	  		Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(3));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==3){
  	  	  	Cell celda10y0=fila24.createCell(3);
				celda10y0.setCellValue(cargar(4));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==4){
  	  	  		Cell celda10y0=fila24.createCell(3);
				celda10y0.setCellValue(cargar(5));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
  	  	  	}else if(i==5){
  	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(6));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
  	  	  	}else if(i==6){
  	  		
  	  	  	//cargar(7);
	  	  		
  	  	  	}else if(i==7){
  	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(8));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	
	  	  		
  	  	  	}else if(i==8){
  	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(9));//titleCostadoSimple
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
  	  	  	
  	  	  	}else if(i==9){
  	  	  	//cargar(10)
  	  	  	}else if(i==10){
  	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(11));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
	  	  		
  	  	  	}else if(i==11){
  	  	  	//cargar(12)
	  	  	}else if(i==12){
	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(13));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
	  	  	}else if(i==13){
	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(14));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==14){
	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(15));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
	  	  	}else if(i==15){
	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(16));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
	  	  	}else if(i==16){
	  	  	/*Cell celda10y0=fila21.createCell(3);
			celda10y0.setCellValue(cargar(17));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));*/
	  	  	//cargar(17)
	  	  	}else if(i==17){
	  	  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(18));
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
				
		  	}else if(i==18){
		   	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(19));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
		  	  		
		  	}else if(i==19){
		  	Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(20));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
					
			}else if(i==20){
			Cell celda10y0=fila24.createCell(3);
			celda10y0.setCellValue(cargar(21));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		}else if(i==21){
  	  			
  	  		}
  	  	 else if(i==22){
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(23));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 		  	}else if(i==23){
 		   	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(24));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 		  	  		
 		  	}else if(i==24){
 		  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(25));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 					
 			}else if(i==25){
 			Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(26));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
   	  		}else if(i==26){
   	  			//NADA
   	  		}
 	  	  	else if(i==27){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(28);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
   	  		Cell atte=fila24.createCell(5);
 			atte.setCellValue(sfila);
 			//	atte.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	}else if(i==28){
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(29));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  		
 	  	  	}else if(i==29){
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(30));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 		  	}else if(i==30){
 		  		Cell celda10y0=fila24.createCell(3);
 				celda10y0.setCellValue(cargar(31));
 				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 				
 				
 	  	  	}else if(i==31){
 	  	  	//cargar(22)
 	  	  	
 			
 	  	  	}else if(i==32){
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(33));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	}else if(i==33){
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(34));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	
 			
 	  	  	}else if(i==34){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(35);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}	
 	  	  		
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 			Cell mario=fila24.createCell(5);
 			mario.setCellValue(sfila);//titleMedioDobleRallaAriva
 			sheet3.addMergedRegion(CellRangeAddress.valueOf("$F$"+(61+arreglo_datos.length)+":$G$"+(61+arreglo_datos.length)));
 			mario.setCellStyle(styles.get("dobleRallaHor"));
 			Cell mario2=fila24.createCell(6);
 			mario2.setCellStyle(styles.get("dobleRallaHor"));
 			
 	  	  	}else if(i==35){
 	  	  	String filaSeparada="",pfila="",sfila="";
 	  	  	filaSeparada=cargar(36);
 	  	  	if(filaSeparada.indexOf("|")==-1){
 	  	  		
 	  	  	}else{
 	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
 	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
 	  	  	}	
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(pfila);
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
 			Cell ventas=fila24.createCell(5);
 			sheet3.addMergedRegion(CellRangeAddress.valueOf("$F$"+(62+arreglo_datos.length)+":$G$"+(62+arreglo_datos.length)));
 			ventas.setCellValue(sfila);//titleMedioSimple
 			ventas.setCellStyle(styles.get("titleMedioSimple"));	
 	  	  	}else if(i==36){
 	  	  	
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(37));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));		
 	  	  	}else if(i==37){
 	  	  	
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(cargar(38));
 			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
 	  	  	
 	  	  	}else if(i==38){
 	  	  	Cell celda10y0=fila24.createCell(3);
 	  	  	celda10y0.setCellValue(cargar(39));
 	  	  	Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_URL);
 	  	    link.setAddress(cargar(29));	
 	  	    celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));  	  
 	  	  	}else if(i==39){
 				//cargar(35)
 	  	  	}else if(i==40){
 	  	  	String variableka= cargar(41);
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(variableka);
 			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
 			link.setAddress("mailto:"+variableka+"?subject=Hyperlinks");
 			System.out.println("mailto:"+variableka+"?subject=Hyperlinks");
 			celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
 	  	  		
 	  	  	}else if(i==41){
 	  	  	String variableta= cargar(42);
 	  	  	Cell celda10y0=fila24.createCell(3);
 			celda10y0.setCellValue(variableta);
 			Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_EMAIL);
 			link.setAddress("mailto:"+variableta+"?subject=Hyperlinks");
 			System.out.println("mailto:"+variableta+"?subject=Hyperlinks");
 			celda10y0.setHyperlink(link);
 			celda10y0.setCellStyle(styles.get("titleHipervinculo"));
 	  	  	}
   	  	  	else{	
   	  		}
			
 	       
  	      
			
		}//aka termina el for
  		
        sheet3.setZoom(3, 4);
      
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
        titleFont.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
        titleFont.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(titleFont);
        styles.put("title", style);

      //CUADRADO MEDIO Y ABAJO DOBLE RALLA
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setBorderLeft(CellStyle.BORDER_THIN);
        Font rrallamediosimple = wb.createFont();
        rrallamediosimple.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
        style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
        style.setFont(rrallamediosimple);
        styles.put("rrallamediosimple", style);
        
       
        /*    style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);*/
        Font TITULOmEDIOaMARRILO = wb.createFont();
        TITULOmEDIOaMARRILO.setFontHeightInPoints((short)12);//Esto es para ponerle el tamaño al titulo
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
