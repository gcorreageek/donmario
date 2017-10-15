package miLib;
import gui.TranCotizacionAutMant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
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

import util.Propiedades;


public class PasarExcelCorreo {
	 public static Class clss=null;
	 public static InputStream in;
	 public static ClassLoader cl = null;
	 
	 /////////////////////////////
	
	static Workbook wb;
	
	public static String fileGlobal="";
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
    public PasarExcelCorreo() {
       clss=this. getClass();
 	   cl= this .getClass().getClassLoader(); 
    	
    }
    public static String cargar(int fila){
    	
    	Propiedades p=new Propiedades();
	    String texto="";
	    String letra=p.getProperty("condicionesExcel");//"CONDICIONESEXCEL.txt";
	   
	       
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         //archivo = new File (letra);
	         //fr = new FileReader (archivo);
	       //   br = new BufferedReader(fr);
			archivo = new File (letra);
	        fr = new FileReader (archivo);
	           // in=clss.getResourceAsStream("/File/CONDICIONESEXCEL.txt");
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
    
   
    
    public static   void crearExcel(Object[] nombre,Object[][] datos)throws IOException{
    	
    	TranCotizacionAutMant objCot;
    	objCot=new TranCotizacionAutMant();
    	String nomEmp=objCot.nomEmpresa,referencia=objCot.referencia_coti;
    	
    	System.out.println("nomEmp:"+nomEmp);
    	System.out.println("referencia:"+referencia);
    	String cadena=objCot.primeraPalabra(nomEmp);
    	String ref=objCot.sinEspacio(referencia);
    	Propiedades p=new Propiedades();
    	
  	   wb = new HSSFWorkbook();
  	   arreglo_nombre=nombre;
  	   arreglo_datos=datos;
         metodoCorreoCel();
         System.out.println(arreglo_nombre[7]);
         String numCot=""+arreglo_nombre[7].toString();
         numCot=numCot.replaceAll("  ", "");
         numCot=numCot.replaceAll(" ", "");
         numCot=numCot.trim();
         String fileRaiz="D:/ProyectoCEL/Cotizaciones/CotCorreo/";
         //String fileRaiz="//Mario/d/ProyectoCEM/Cotizaciones/CotCorreo/";
         String file =fileRaiz+numCot+"-"+cadena+"-"+ref+".xls";
         fileGlobal=file;
         // if(wb instanceof XSSFWorkbook) file += "x";
  	         FileOutputStream out = new FileOutputStream(file);
  	         wb.write(out);
  	         out.close();
  	       Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
  	  
     }
    /* public PasarExcel() throws IOException{    
     }
   public static   void crearExcel(Object[] nombre,Object[][] datos)throws IOException{
 	   wb = new HSSFWorkbook();
 	   arreglo_nombre=nombre;
 	   arreglo_datos=datos;
 	   System.out.println(arreglo_nombre.length);
        metodoCotizacionInterna();
        metodoCotizacionClientes();
        metodoCorreoCel();
        
        // Write the output to a file
        System.out.println(arreglo_nombre[7]);
        String numCot=""+arreglo_nombre[7].toString();
        numCot=numCot.replaceAll("  ", "");
        numCot=numCot.replaceAll(" ", "");
        numCot=numCot.trim();
        String file =numCot+".xls";
       // if(wb instanceof XSSFWorkbook) file += "x";
 	         FileOutputStream out = new FileOutputStream(file);
 	         wb.write(out);
 	         out.close();
 	  
    }*/
    
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
       sheet3.setColumnWidth(9, 4000);
       sheet3.setColumnWidth(10, 4000);
       sheet3.setColumnWidth(11, 4000);
       sheet3.setColumnWidth(12, 6500);
       sheet3.setColumnWidth(13, 5500);
       
       //add picture data to this workbook.//Images/INICIO.GIF
       TranCotizacionAutMant objCot;
       objCot=new TranCotizacionAutMant();
       String imagen="";
       //Ruta para elegir la imagen del excel a mostrarse
       imagen="Images/LOGOelecorp.jpg";
       imagen="Images/LOGO.JPG";
       
       

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
       Cell cotizacion3 = sheet3.createRow(13).createCell(3);
       cotizacion3.setCellValue(arreglo_nombre[7].toString());//=+'COTIZACION - CLIENTE'!D7
       cotizacion3.setCellStyle(styles.get("titleMedio"));
       //+'HOJA DE COSTOS  INTERNA'!G2
       
       Cell fecha = sheet3.createRow(12).createCell(4);
       fecha.setCellValue(arreglo_nombre[8].toString());//fecha.setCellFormula("+'HOJA DE COSTOS  INTERNA'!G2");
       fecha.setCellStyle(styles.get("title"));
       
       Row fila14=sheet3.createRow(14);
        Cell senores = fila14.createCell(1);
        senores.setCellValue("SEÑORES:");
        senores.setCellStyle(styles.get("title"));
        Cell senoresr = fila14.createCell(3);
        senoresr.setCellValue(arreglo_nombre[0].toString());// senoresr.setCellFormula("+'COTIZACION - CLIENTE'!D11");
        senoresr.setCellStyle(styles.get("title"));
       //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11"));
        
        Row fila15=sheet3.createRow(15);
         Cell atencion = fila15.createCell(1);
         atencion.setCellValue("ATENCION:");
         atencion.setCellStyle(styles.get("title"));
         Cell atencionr = fila15.createCell(3);
         atencionr.setCellValue(arreglo_nombre[1].toString());//atencionr.setCellFormula("+'COTIZACION - CLIENTE'!D12");
         atencionr.setCellStyle(styles.get("title"));
        
        Row fila16=sheet3.createRow(16);
         Cell direccion =fila16.createCell(1);
         direccion.setCellValue("DIRECCION:");
         direccion.setCellStyle(styles.get("title"));
         Cell direccionr =fila16.createCell(3);
         direccionr.setCellValue(arreglo_nombre[2].toString()); //direccionr.setCellFormula("+'COTIZACION - CLIENTE'!D13");
         direccionr.setCellStyle(styles.get("title"));
         
        Row fila17=sheet3.createRow(17);
         Cell telefono = fila17.createCell(1);
         telefono.setCellValue("TELEFONO:");
         telefono.setCellStyle(styles.get("title"));
         Cell telefonor = fila17.createCell(3);
         telefonor.setCellValue(arreglo_nombre[3].toString());//telefonor.setCellFormula("+'COTIZACION - CLIENTE'!D14");
         telefonor.setCellStyle(styles.get("title"));
         /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         Row filanUEVA=sheet3.createRow(18);
         Cell referencia = filanUEVA.createCell(1);
         referencia.setCellValue("REFERENCIA:");
         referencia.setCellStyle(styles.get("title"));
         Cell referenciar = filanUEVA.createCell(3);
         referenciar.setCellValue(arreglo_nombre[10].toString());
         referenciar.setCellStyle(styles.get("title"));
         
         
         
         Cell tipo = filanUEVA.createCell(7);
         tipo.setCellValue("T.C.");
         tipo.setCellStyle(styles.get("titleCostadoCuadroRojo"));

         Cell cambio = filanUEVA.createCell(8);
         cambio.setCellValue(Double.parseDouble(""+arreglo_nombre[9]));
         cambio.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         
         Row fila18=sheet3.createRow(19);
         Cell celda1=fila18.createCell(1);
         celda1.setCellValue("CANT");
         celda1.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda2=fila18.createCell(2);
         celda2.setCellValue("U");
         celda2.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda3=fila18.createCell(3);
         celda3.setCellValue("DESCRIPCION");
         celda3.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda4=fila18.createCell(4);
         celda4.setCellValue("MARCA");
         celda4.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda5=fila18.createCell(5);
         celda5.setCellValue("P.UNIT.");
         celda5.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda6=fila18.createCell(6);
         celda6.setCellValue("TOTAL");
         celda6.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda7=fila18.createCell(7);
         celda7.setCellValue("P.UNIT.");
         celda7.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda8=fila18.createCell(8);
         celda8.setCellValue("TOTAL");
         celda8.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda9=fila18.createCell(9);
         celda9.setCellValue("PESO UNIT.");
         celda9.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda10=fila18.createCell(10);
         celda10.setCellValue("PESO CARRET.");
         celda10.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda11=fila18.createCell(11);
         celda11.setCellValue("PESO TOTAL");
         celda11.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda12=fila18.createCell(12);
         celda12.setCellValue("TIEMPO DE ENTREGA");
         celda12.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         Cell celda13=fila18.createCell(13);
         celda13.setCellValue("MODELO");
         celda13.setCellStyle(styles.get("titleCostadoCuadroRojo"));
         
         
         for (int i = 0; i < arreglo_datos.length+3; i++){//numero de filas 8 //aka se pone el arreglo
         	  Row fila19=sheet3.createRow(20+i);
         	  for (int j = 0; j < 14; j++) {//numero de columnas 
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
         			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("Kg");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
         			
         		  }else if(j==9){
          			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("Kg");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
          		  }else if(j==10){
          			  Cell celda5a10seiz=fila19.createCell(j+1);
        	          celda5a10seiz.setCellValue("Kg");
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
          		  }else if(j==11){
            			Cell celda1y16=fila19.createCell(1+j);
        				celda1y16.setCellStyle(styles.get("titleMedio"));
        				celda1y16.setCellStyle(styles.get("ralla"));
              	  }else if(j==12){
    	      			Cell celda1y16=fila19.createCell(1+j);
    					celda1y16.setCellStyle(styles.get("titleMedio"));
    					celda1y16.setCellStyle(styles.get("ralla"));
          	      }else if(j==13){
  	      			Cell celda1y16=fila19.createCell(1+j);
  					celda1y16.setCellStyle(styles.get("titleMedio"));
  					celda1y16.setCellStyle(styles.get("ralla"));
        	      }else{
    	      			Cell celda1y16=fila19.createCell(1+j);
    					celda1y16.setCellStyle(styles.get("titleMedio"));
    					celda1y16.setCellStyle(styles.get("ralla"));
          		  }
         		  /*  private static Object[][] arreglo_datos = {
  	  {"100", "UND", "AISLADOR DE PORCELANA 52-3 SUSPENSION ANSI  SOCKET BOLA 1","GAMMA",15.8,15, "09/07/2009","TECSUR S.A.","P0010"},
  	  {"100", "GR", "AISLADOR DE PORCELANA 52-3 SUSPENSION ANSI  SOCKET BOLA 18","SANTANA",16.85,16, "22/05/2008","EDEX REPRESENTACIONES S.A.C.","P0005"}
  	    };*/
         		  }else if(i<arreglo_datos.length+1){
         			  
         			  if(j==0){
             	        Cell cell1 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!B18
             	       cell1.setCellValue(Integer.parseInt(arreglo_datos[i-1][j]+"") );// cell1.setCellFormula("+'COTIZACION - CLIENTE'!B"+(16+i));
             	        cell1.setCellStyle(styles.get("rrallamediosimple")); //cantidad
         			  }else if(j==1){//+'COTIZACION - CLIENTE'!C18
         				Cell cell2 = fila19.createCell(j+1);//
         				cell2.setCellValue(arreglo_datos[i-1][j].toString() );//cell2.setCellFormula("+'COTIZACION - CLIENTE'!C"+(16+i));
         				cell2.setCellStyle(styles.get("rrallamediosimple"));  //unidad
         			  }else if(j==2){//+'COTIZACION - CLIENTE'!D18
         				String vinculo="",sinVinculo="";
          				Cell cell2 = fila19.createCell(j+1);//descripcion
//          				sinVinculo=""+arreglo_datos[i-1][j];
//          				cell2.setCellValue(objCot.sinLink(sinVinculo));
//          				Hyperlink link = createHiperVinculo.createHyperlink(Hyperlink.LINK_URL);
//          				vinculo=objCot.link(""+arreglo_datos[i-1][j]);
////          				System.out.println("VINCULO: "+vinculo);
//          				
//          				if(vinculo.equals("")){
//          					vinculo="http://electrocornejo.com/";
//          				}
//          				link.setAddress(vinculo);	
//          				cell2.setHyperlink(link);
          				cell2.setCellValue(""+arreglo_datos[i-1][j]);
          				cell2.setCellStyle(styles.get("rrallacostadosimple")); 
         			  }else if(j==3){
         				Cell cell2 = fila19.createCell(j+1);//+'HOJA DE COSTOS  INTERNA'!E10
         				cell2.setCellValue(arreglo_datos[i-1][j].toString());//cell2.setCellFormula("+'COTIZACION - CLIENTE'!E"+(16+i));
         				cell2.setCellStyle(styles.get("rrallacostadosimple"));//marca
         			  }else if(j==4){
         				Cell cell2 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!F18
         				cell2.setCellValue(Double.parseDouble(""+arreglo_datos[i-1][j]));//cell2.setCellFormula("+'COTIZACION - CLIENTE'!F"+(16+i));
         				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3"));//p.unit
         			  }else if(j==5){
         				Cell cell2 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!G18
         				//cell2.setCellValue(Double.parseDouble(""+arreglo_datos[i-1][j]) );//cell2.setCellFormula("+'COTIZACION - CLIENTE'!G"+(16+i));
         				cell2.setCellFormula("F"+(21+i)+"*B"+(21+i));//+F21*B21
         				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));//  
         			  }else if(j==6){
         				Cell cell2 = fila19.createCell(j+1);//+F22*$I$19
         				cell2.setCellFormula("F"+(21+i)+"*I19");
         				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3")); 
         			  }else if(j==7){//+H22*B22
           				Cell cell2 = fila19.createCell(j+1);//
             				cell2.setCellFormula("H"+(21+i)+"*B"+(21+i));
             				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
             		  }else if(j==8){
         				Cell cell2 = fila19.createCell(j+1);//+'COTIZACION - CLIENTE'!F18
         				cell2.setCellValue(Double.parseDouble(""+arreglo_datos[i-1][j]));//cell2.setCellFormula("+'COTIZACION - CLIENTE'!F"+(16+i));
         				cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));//p.unit
         			  }else if(j==9){//+H22*B22
         				Cell cell2 = fila19.createCell(j+1);//
           				cell2.setCellValue(Double.parseDouble(""+arreglo_datos[i-1][j]));
             			cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
            	      }else if(j==10){//+H22*B22
            	    	Cell cell2 = fila19.createCell(j+1);//
                      	cell2.setCellFormula("(J"+(21+i)+"*B"+(21+i)+")+K"+(21+i));
              			cell2.setCellStyle(styles.get("rrallamediosimpleFormat2")); 
            				
                	  }else if(j==11){//+H22*B22
                		Cell cell2 = fila19.createCell(j+1);//
            			cell2.setCellValue(""+arreglo_datos[i-1][j]);
              			cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));
                	  }else if(j==12){//+H22*B22
                  		Cell cell2 = fila19.createCell(j+1);//
              			cell2.setCellValue(""+arreglo_datos[i-1][j]);
                		cell2.setCellStyle(styles.get("rrallamediosimpleFormat2"));
                  	  }else{
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
   		for (int j = 0; j < 15; j++) {//numero de columnas 
   			if(i==0){
   			if(j!=0){
   			if(j==6){
   				Cell celda10y0=fila20.createCell(j);
       			celda10y0.setCellValue("$");
       			celda10y0.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
   			}else if(j==7){
   				Cell celda1y17=fila20.createCell(j);
   				//celda1y17.setCellValue("S/.");
   				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
   			}else if(j==8){//SUMA(I10:I12)
   				Cell celda1y17=fila20.createCell(j);
   				celda1y17.setCellValue("S/.");
   				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
   			}else if(j==9){//SUMA(I10:I12)
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==10){
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==11){
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==12){
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==13){
  				Cell celda1y17=fila20.createCell(j);
  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  			}else if(j==14){
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
   	  				celda1y17.setCellValue("P. VENTA");
   	  				//celda1y17.setCellFormula("SUM(H22:H"+((arreglo_datos.length)+21)+")");
   	  				celda1y17.setCellStyle(styles.get("cell"));
   	  			}else if(j==8){//SUMA(I18:I117)
   	  				Cell celda1y17=fila21.createCell(j);
   	  				celda1y17.setCellFormula("SUM(I22:I"+((arreglo_datos.length)+21)+")");
   	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
   	  			}else if(j==9){
   	  			    Cell celda10y0=fila21.createCell(j);
	      			celda10y0.setCellValue("T.PESO");
	      			celda10y0.setCellStyle(styles.get("cell"));
   	   			}else if(j==10){//SUMA(J10:J12)
   	   			    Cell celda10y0=fila21.createCell(j);//SUMA(G18:G117)
	      			celda10y0.setCellFormula("SUM(L22:L"+((arreglo_datos.length)+21)+")");
	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
   	   			}else if(j==11){
	  	  				//NADA
	  	  		}else if(j==12){
	  	  				//NADA
	  	  		}else if(j==13){
	  	  				//NADA
	  	  		}else if(j==14){
  	  				//NADA
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
   	  	      			celda10y0.setCellFormula("G"+((arreglo_datos.length)+24)+"*0.18");
   	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
   	  	  			}else if(j==7){//+H118*0,19
   	  	  				Cell celda1y17=fila22.createCell(j);//SUMA(H18:H117)
   	  	  				celda1y17.setCellValue("IGV");
   	  	  				//celda1y17.setCellFormula("+H"+((arreglo_datos.length)+24)+"*0.18");
   	  	  				celda1y17.setCellStyle(styles.get("cell"));
   	  	  			}else if(j==8){//+I118*0,19
   	  	  				Cell celda1y17=fila22.createCell(j);
   	  	  				celda1y17.setCellFormula("I"+((arreglo_datos.length)+24)+"*0.18");
   	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
   	  	  			}else if(j==9){
   	    				//NADA
   	    			}else if(j==10){
   	    				//NADA
   	    			}else if(j==11){
	  	  				//NADA
   		  	  		}else if(j==12){
	  	  				//NADA
  		  	  		}else if(j==13){
	  	  				//NADA
  		  	  		}else if(j==14){
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
   	  	  				celda1y17.setCellValue("TOTAL");
   	  	  				//celda1y17.setCellFormula("H"+((arreg		lo_datos.length)+24)+"+H"+((arreglo_datos.length)+25));
   	  	  				celda1y17.setCellStyle(styles.get("cell"));
   	  	  			}else if(j==8){//SUMA(I118:I119)
   	  	  				Cell celda1y17=fila23.createCell(j);
   	  	  				celda1y17.setCellFormula("I"+((arreglo_datos.length)+24)+"+I"+((arreglo_datos.length)+25));
   	  	  				celda1y17.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
   	  	  			}else if(j==9){
   	    				//NADA
   	    			}else if(j==10){
   	    				//NADA
   	    			}else if(j==11){
	  	  				//NADA
   		  	  		}else if(j==12){
	  	  				//NADA
  		  	  		}else if(j==13){
	  	  				//NADA
  		  	  		}else if(j==14){
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
       TITULOmEDIOaMARRILO.setColor(HSSFColor.WHITE.index);
       style = wb.createCellStyle();
       style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
       style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       style.setFont(TITULOmEDIOaMARRILO); 
       style.setFillForegroundColor(IndexedColors.RED.getIndex());
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
       
       Font titleCostadoCuadroRojo = wb.createFont();
       titleCostadoCuadroRojo.setFontHeightInPoints((short)11);
       titleCostadoCuadroRojo.setBoldweight(Font.COLOR_NORMAL);
       titleCostadoCuadroRojo.setColor(HSSFColor.WHITE.index);
       style.setFillForegroundColor(IndexedColors.RED.getIndex());
       style.setFillPattern(CellStyle.SOLID_FOREGROUND);
       style.setFont(titleCostadoCuadroRojo);
       styles.put("titleCostadoCuadroRojo", style);
       
       
//       style = wb.createCellStyle();
//       style.setWrapText(true);
//       style.setBorderRight(CellStyle.BORDER_THIN);
//       style.setRightBorderColor(IndexedColors.BLACK.getIndex());
//       style.setBorderLeft(CellStyle.BORDER_THIN);
//       style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
//      style.setBorderTop(CellStyle.BORDER_THIN);
//       style.setTopBorderColor(IndexedColors.BLACK.getIndex());
//      style.setBorderBottom(CellStyle.BORDER_THIN);
//       style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//       style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
//       style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
//       
//       Font titleCostadoCuadroRojo = wb.createFont();
//       titleCostadoCuadroRojo.setFontHeightInPoints((short)11);
//       titleCostadoCuadroRojo.setBoldweight(Font.COLOR_NORMAL);
//       style.setFillForegroundColor(IndexedColors.RED.getIndex());
//       style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//       style.setFont(titleCostadoCuadroRojo);
//       styles.put("titleCostadoCuadroRojo", style);
       
       
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
       
      //TITULO NUMERO 2.
       style = wb.createCellStyle();
       style.setWrapText(true);
       style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
       style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//Centro,Costados
       Font titleFontMedio2 = wb.createFont();
       titleFontMedio2.setFontHeightInPoints((short)11);//Esto es para ponerle el tamaño al titulo
       titleFontMedio2.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
       style.setFont(titleFont);
       styles.put("titleMedio2", style);
       
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
