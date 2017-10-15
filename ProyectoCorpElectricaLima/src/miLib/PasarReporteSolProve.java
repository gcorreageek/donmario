package miLib;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import util.Propiedades;

public class PasarReporteSolProve {
	 public static Class clss=null;
	 public static InputStream in;
	 public static ClassLoader cl = null;
	 /////////////////////////////
	
	static Workbook wb;
	
	public static String fileGlobal="";
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
    public static String fecc_Rep=""; 
   // public static String fecc_Rep=""; 
    public PasarReporteSolProve() {
       clss=this. getClass();
 	   cl= this .getClass().getClassLoader(); 
 	 //Fecha objFecha;
    }
    public static String cargar(int fila){
		String texto="";
		String letra="File/CONDICIONESEXCEL.txt";
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         //archivo = new File (letra);
	         //fr = new FileReader (archivo);
	       //   br = new BufferedReader(fr);
	            in=clss.getResourceAsStream("/File/CONDICIONESEXCEL.txt");
				br = new BufferedReader(new  InputStreamReader(in));
	        

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
	        System.out.println("El numero de filas DEL txt:"+count);
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
    public static   void crearExcelTarea(Object[] nombre,Object[][] datos,String feccRep)throws IOException{
  	   wb = new HSSFWorkbook();
  	   arreglo_nombre=nombre;
  	   arreglo_datos=datos;
  	   fecc_Rep=feccRep;
         metodoCorreoCel();
         Propiedades p=new Propiedades();
        Fecha objFec = null;
       //objFec.convrtidorFec3(fec_Rep)
         String numCot=""+"Reportes Pendientes("+fecc_Rep+")" ;
         numCot=numCot.replaceAll("  ", "");
         numCot=numCot.replaceAll(" ", "");
         numCot=numCot.trim();
         String fileRaiz="D:/ProyectoCEL/Cotizaciones/Repsol/";
         String file =fileRaiz+numCot+".xls";
         fileGlobal=file;
         // if(wb instanceof XSSFWorkbook) file += "x";
  	         FileOutputStream out = new FileOutputStream(file);
  	         wb.write(out);
  	         out.close();
  	       Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
  	  
     }
        
    public static void metodoCorreoCel() throws IOException{
    	//Fecha objFecha=null;
 	   CreationHelper createHiperVinculo = wb.getCreationHelper();
 	   Map<String, CellStyle> styles = createStyles(wb);
 	   ////////////////////////////////////////////////////////////////////////////////////////////
        /******************************************************************************************/
        /**************************************CORREO CEL******************************************/
        Sheet sheet3 = wb.createSheet("TAREA DEL DIA " + fecc_Rep);
        PrintSetup printSetup3 = sheet3.getPrintSetup();
        printSetup3.setLandscape(true);
        sheet3.setFitToPage(true);
        sheet3.setHorizontallyCenter(true);
        sheet3.setPrintGridlines(true);//PARA QUE 	
        sheet3.setDisplayGridlines(false);//SALGA BLANCO TODOO!
        
        
      // for (int i = 0; i < 250; i++) {	sheet3.createRow(i).setHeightInPoints(10);}
 			
       CellStyle style3;
       style3 = wb.createCellStyle();
       style3.setAlignment(CellStyle.BORDER_MEDIUM);
       style3.setWrapText(true);
       style3.setAlignment(CellStyle.BORDER_THIN);
      // style.setBorderRight(CellStyle.BORDER_THIN);
        //finally set column widths, the width is measured in units of 1/256th of a character width
       sheet3.setColumnWidth(0, 800); //30 characters wide
       sheet3.setColumnWidth(1, 6500);
       sheet3.setColumnWidth(2, 4000);
       sheet3.setColumnWidth(3, 6500); //10 characters wide
       sheet3.setColumnWidth(4, 3000);
       sheet3.setColumnWidth(5, 6500);
       sheet3.setColumnWidth(6, 6500);
      
           
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
      // Picture pict = drawing.createPicture(anchor, pictureIdx);

       //auto-size picture relative to its top-left corner
       //pict.resize();
       
       
       
       
       // titleRow.setHeightInPoints(45);//lo alto
       Cell titulo = sheet3.createRow(5).createCell(3);
       titulo.setCellValue(arreglo_nombre[0].toString());//=+'COTIZACION - CLIENTE'!D7
       titulo.setCellStyle(styles.get("title"));
       //+'HOJA DE COSTOS  INTERNA'!G2
       
      /* Cell fecha = sheet3.createRow(12).createCell(4);
       fecha.setCellValue(arreglo_nombre[8].toString());//fecha.setCellFormula("+'HOJA DE COSTOS  INTERNA'!G2");
       fecha.setCellStyle(styles.get("title"));*/
       
        Row fila10=sheet3.createRow(6);
       
         Cell celda1=fila10.createCell(1);
         celda1.setCellValue("NOM.PROVEEDOR");
         celda1.setCellStyle(styles.get("titleCostadoCuadro"));
         //cell122.setCellStyle(styles.get("ralla")); 
         
         Cell celda2=fila10.createCell(2);
         celda2.setCellValue("TELF.");
         celda2.setCellStyle(styles.get("titleCostadoCuadro"));
         
         Cell celda3=fila10.createCell(3);
         celda3.setCellValue("NOM.CONTACTO");
         celda3.setCellStyle(styles.get("titleCostadoCuadro"));
         
         Cell celda4=fila10.createCell(4);
         celda4.setCellValue("FECHA");
         celda4.setCellStyle(styles.get("titleCostadoCuadro"));
         
         Cell celda5=fila10.createCell(5);
         celda5.setCellValue("REFERENCIA");
         celda5.setCellStyle(styles.get("titleCostadoCuadro"));
         
         Cell celda6=fila10.createCell(6);
         celda6.setCellValue("NOM.CLIENTE");
         celda6.setCellStyle(styles.get("titleCostadoCuadro"));
         
         
         for (int i = 0; i < arreglo_datos.length+1; i++) {//numero de filas 8 //aka se pone el arreglo
         	 
        	 Row  fila11=sheet3.createRow(7+i);
          	  
             for (int j = 0; j < 7; j++) {//numero de columnas 
            	 
         		  if(i<arreglo_datos.length && arreglo_datos[i][j]!=null){
         			 
         			  if(j==0){
             	        Cell cell1 = fila11.createCell(j+1);//+'COTIZACION - CLIENTE'!B18
             	      //  System.out.println("PINTA LENGUA:"+arreglo_datos[i-1][j].toString());
             	        cell1.setCellStyle(styles.get("pinta"));
             	        cell1.setCellValue(arreglo_datos[i][j].toString());// cell1.setCellFormula("+'COTIZACION - CLIENTE'!B"+(16+i));
             	       // cell1.setCellStyle(styles.get("rrallamediosimpleFormat3"));
             	      }
         			  else if(j==1){//+'COTIZACION - CLIENTE'!C18
         				Cell cell2 = fila11.createCell(j+1);//
         				cell2.setCellValue(arreglo_datos[i][j].toString());//cell2.setCellFormula("+'COTIZACION - CLIENTE'!C"+(16+i));
         				cell2.setCellStyle(styles.get("pinta"));  //unidad
         			  }else if(j==2){//+'COTIZACION - CLIENTE'!D18
         				Cell cell2 = fila11.createCell(j+1);//
         				cell2.setCellValue(arreglo_datos[i][j].toString() );//cell2.setCellFormula("+'COTIZACION - CLIENTE'!D"+(16+i));
         				cell2.setCellStyle(styles.get("pinta")); //descripcion
         			  }else if(j==3){
         				Cell cell2 = fila11.createCell(j+1);//+'HOJA DE COSTOS  INTERNA'!E10
         				cell2.setCellValue(arreglo_datos[i][j].toString() );//cell2.setCellFormula("+'COTIZACION - CLIENTE'!E"+(16+i));
         				cell2.setCellStyle(styles.get("pinta"));//marca
         			  }else if(j==4){
         				Cell cell2 = fila11.createCell(j+1);//+'COTIZACION - CLIENTE'!F18
         				cell2.setCellValue(arreglo_datos[i][j].toString());//cell2.setCellFormula("+'COTIZACION - CLIENTE'!F"+(16+i));
         				cell2.setCellStyle(styles.get("pinta"));//p.unit
         			  }else if(j==5){
         				Cell cell2 = fila11.createCell(j+1);//+'COTIZACION - CLIENTE'!G18
         				cell2.setCellValue(arreglo_datos[i][j] +"");//cell2.setCellFormula("+'COTIZACION - CLIENTE'!G"+(16+i));
         				//cell2.setCellFormula(arreglo_datos[i-1][j].toString());//+F21*B21
         				cell2.setCellStyle(styles.get("pinta"));//  
         			  }else{
         				  
         			  }
         				
         			  
         		  }else{
         			
         		  }	
         		 
   			}
	  
         	  
   		}
           		
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
       Font titleCostadoCuadroAmarillo = wb.createFont();
       titleCostadoCuadroAmarillo.setFontHeightInPoints((short)11);
       titleCostadoCuadroAmarillo.setBoldweight(Font.COLOR_NORMAL);
       style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
       style.setFillPattern(CellStyle.SOLID_FOREGROUND);
       style.setFont(titleCostadoCuadroAmarillo);
       styles.put("titleCostadoCuadroAmarillo", style);
       
       
       style = wb.createCellStyle();
       style.setAlignment(CellStyle.ALIGN_FILL);//Centro,Costados
       style.setBorderLeft(CellStyle.BORDER_THIN);
       Font rrallamediosimpleFormat2 = wb.createFont();
       rrallamediosimpleFormat2.setFontHeightInPoints((short)10);//Esto es para ponerle el tamaño al titulo
       style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);//Centro,Costados
       style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       style.setDataFormat(format.getFormat("0.00"));
       style.setFont(rrallamediosimpleFormat2);
       styles.put("rrallamediosimpleFormat2", style);
       
       //---------------------------------------------
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
       //---------------------------------------------
       		
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
      // titleralla.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
      // titleralla.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
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
       style.setBorderTop(CellStyle.BORDER_THIN);
       style.setDataFormat(format.getFormat("0.00"));
       styles.put("dobleRallaHor", style);
       
       //RALLA ABAJO
       style = wb.createCellStyle();
       style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
       style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       style.setBorderTop(CellStyle.BORDER_THIN);
       style.setDataFormat(format.getFormat("0.00"));
       styles.put("rallaAbajo", style);
       
       
       
       //PINTA LAS RALLAS 
       
       style = wb.createCellStyle();
      // style.setHidden(true);
       style.setWrapText(true);
       style.setAlignment(CellStyle.BORDER_THIN);
       style.setBorderRight(CellStyle.BORDER_THIN);
       style.setBorderLeft(CellStyle.BORDER_THIN);
       style.setBorderTop(CellStyle.BORDER_THIN);
       style.setBorderBottom(CellStyle.BORDER_THIN);
       //style.setFont(titleFont);
       styles.put("pinta", style);

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
