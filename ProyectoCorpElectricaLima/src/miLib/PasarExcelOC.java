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



import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
//import java.io.InputStreamReader;

import util.Propiedades;

public class PasarExcelOC {
	
	public static Class clss=null;
	public static InputStream in;
	public static ClassLoader cl = null;
	static Workbook wb;
    public static  Object[] arreglo_nombre ;
    public static Object[][] arreglo_datos ;
   
    static Integer igv;
    static Integer igv1;
    static List<Integer> array= new ArrayList<Integer>();
    
  
	//array= new ArrayList<String>();
  
   public PasarExcelOC() throws IOException{  
	  clss=this. getClass();
	   cl= this .getClass().getClassLoader(); 
   }
		  

	public static String cargar(int fila){
		
		Propiedades p=new Propiedades();
		String texto=p.getProperty("condicionesExcelOC");
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		try {
			archivo = new File (texto);
	        fr = new FileReader (archivo);
			//in=clss.getResourceAsStream("/File/CODICIONESEXCELOC.txt");
			br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea,linea1;
	         int count=0;
	         int count1=0;
	         while((linea=br.readLine())!=null){
	        	 count=count+1;
	        	if(fila==count){
	        		 texto=linea;
	        		break;
	        	}
	        
	         }
	         while((linea1=br.readLine())!=null){
	        	 count1=count1+1;
	        	 if(fila==count1){
	        		 texto=linea1;
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
	


   public static   String crearExcel(Object[] nombre,Object[][] datos)throws IOException{
	   ClaseCargadora objCargar= new ClaseCargadora();
	  
	   Propiedades p=new Propiedades();
 	   wb = new HSSFWorkbook();
 	  
 	   arreglo_nombre=nombre;
 	   arreglo_datos=datos;
 	   //metodoCotizacionInterna();
       //metodoCotizacionClientes();
       metodoCorreoCel();
        
        // Write the output to a file
        String nomProve=""+arreglo_nombre[2].toString();
        nomProve=nomProve.replaceAll
        ("  ", "");
        nomProve=nomProve.replaceAll(" ", "");
        nomProve=nomProve.trim();
        String codMantCot=""+arreglo_nombre[10].toString();
       
        codMantCot=codMantCot.trim();
        String numCot=""+arreglo_nombre[0].toString();
        numCot=numCot.replaceAll
        ("  ", "");
        numCot=numCot.replaceAll(" ", "");
        numCot=numCot.trim();//D:\ProyectoCEM\Cotizaciones\Coti
        //String fileRaiz="\\\\Mario\\d\\ProyectoCEM\\Cotizaciones\\OrdenCompra\\"; 
       String fileRaiz=p.getProperty("fileRaizOC");  
       //String fileRaiz="D:/ProyectoCEM/Cotizaciones/OrdenCompra/"; //UTILIZAR CUANDO SE VAN HACER PRUEBAS 
       String nombreR="OC"+numCot+"COT"+codMantCot+""+nomProve;
       System.out.println(nombreR);
       String file =fileRaiz+nombreR+".xls";
 
        GUI objGUI=new GUI() ;
 	         FileOutputStream out = new FileOutputStream(file);
       
    
 	         wb.write(out);
 	         out.close();
 	         try {
 	        	Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
 	  
 	         } catch (Exception e) {
 	        	Runtime.getRuntime().exec("cmd /c start "+file.replace("/", "\\"));
			 	  
 	         }
			return file;
 	         
    }
   public static void metodoCorreoCel() throws IOException{
	   CreationHelper createHiperVinculo = wb.getCreationHelper();
	   Map<String, CellStyle> styles = createStyles(wb);
	   ////////////////////////////////////////////////////////////////////////////////////////////
       /******************************************************************************************/
       /**************************************CORREO CEL******************************************/
       Sheet sheet3 = wb.createSheet("ORDEN DE COMPRA");
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
      sheet3.setColumnWidth(0, 3000); //30 characters wide
      sheet3.setColumnWidth(1, 2700);
      sheet3.setColumnWidth(2, 17000);
      sheet3.setColumnWidth(3, 6000); //10 characters wide
      sheet3.setColumnWidth(4, 5500);
      sheet3.setColumnWidth(5, 5500);
      
  
      //add picture data to this workbook.
     // URL cad=cl.getResource("Images/LOGO.JPG");
     // in=clss.getResourceAsStream("/File/CONDICIONESEXCEL.txt");
     // Icon imagen2  = new ImageIcon(cl.getResource("Images/LOGO.JPG"));
     // br = new BufferedReader(new  InputStreamReader(in));
   // public static InputStream in;
      //FileInputStream("image1.jpeg");

      //InputStream is = new FileInputStream("Images/LOGO.JPG");
     
  	//cl.getResource("Images/logeo.jpg");
  	 InputStream is = (cl.getResourceAsStream("Images/LOGO3.jpg"));
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
      anchor.setCol1(0);
      anchor.setRow1(0);
      Picture pict = drawing.createPicture(anchor, pictureIdx);

      //auto-size picture relative to its top-left corner
      //pict.resize();
      
      Cell cotizacion3 = sheet3.createRow(13).createCell(0);
      sheet3.addMergedRegion(CellRangeAddress.valueOf("$A$"+(14)+":$F$"+(14)));
      cotizacion3.setCellValue("ORDEN DE COMPRA Nº"+arreglo_nombre[0]);//=+'COTIZACION - CLIENTE'!D7
      cotizacion3.setCellStyle(styles.get("titleMedio"));
      
      Cell fecha = sheet3.createRow(15).createCell(4);
      System.out.println("SALEEEEOOOO: "+arreglo_nombre[1].toString());
      fecha.setCellValue(arreglo_nombre[1].toString());
      fecha.setCellStyle(styles.get("title"));
      
      Row fila14=sheet3.createRow(16);
       Cell senores = fila14.createCell(0);
       senores.setCellValue("SEÑORES:");
       senores.setCellStyle(styles.get("title"));
       Cell senoresr = fila14.createCell(2);
       senoresr.setCellValue(arreglo_nombre[2].toString());
       senoresr.setCellStyle(styles.get("title"));
      //sheet.addMergedRegion(CellRangeAddress.valueOf("B11:C11"));

      
       Row fila15=sheet3.createRow(17);
        Cell atencion = fila15.createCell(0);
        atencion.setCellValue("ATENCION:");
        atencion.setCellStyle(styles.get("title"));
        Cell atencionr = fila15.createCell(2);
        atencionr.setCellValue(arreglo_nombre[3].toString());
        atencionr.setCellStyle(styles.get("title"));
   
       Row fila16=sheet3.createRow(18);
        Cell direccion =fila16.createCell(0);
        direccion.setCellValue("DIRECCION:");
        direccion.setCellStyle(styles.get("title"));
        Cell direccionr =fila16.createCell(2);
        direccionr.setCellValue(arreglo_nombre[4].toString());
        direccionr.setCellStyle(styles.get("title"));
            
       Row fila17=sheet3.createRow(19);
        Cell telefono = fila17.createCell(0);
        telefono.setCellValue("TELEFONO:");
        telefono.setCellStyle(styles.get("title"));
        Cell telefonor = fila17.createCell(2);
        telefonor.setCellValue(arreglo_nombre[5].toString());
        telefonor.setCellStyle(styles.get("title"));
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
        Row filanUEVA=sheet3.createRow(20);
        Cell referencia= filanUEVA.createCell(0);
        referencia.setCellValue("MAIL:");
        referencia.setCellStyle(styles.get("title"));
        Cell referenciar = filanUEVA.createCell(2);
        referenciar.setCellValue(arreglo_nombre[6].toString());
        referenciar.setCellStyle(styles.get("title"));

        
        
        Row fila18=sheet3.createRow(22);
        Cell celda1=fila18.createCell(0);
        celda1.setCellValue("CANT");
        celda1.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
         
        Cell celda2=fila18.createCell(1);
        celda2.setCellValue("U");
        celda2.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
         
        Cell celda3=fila18.createCell(2);
        celda3.setCellValue("DESCRIPCION");
        celda3.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        
        Cell celda4=fila18.createCell(3);
        celda4.setCellValue("MARCA");
        celda4.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
       
        Cell celda5=fila18.createCell(4);
        celda5.setCellValue("P.UNIT.");
        celda5.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        
        Cell celda6=fila18.createCell(5);
        celda6.setCellValue("TOTAL");
        celda6.setCellStyle(styles.get("cuadradoMedioDobleRalla"));
        
        //+2 PORK LE AUMENTAS UNA FILA ADELANTE Y UNA ATRAS
        for (int i = 0; i < arreglo_datos.length+2; i++) {//numero de filas 8 //aka se pone el arreglo
        	  Row fila19=sheet3.createRow(23+i);
        	
        	  for (int j = 0; j < 7; j++) {//numero de columnas 
        		  if(i==0){
        		  if(j==4){
        			  igv=Integer.parseInt(""+arreglo_datos[i][6]);
        			  Cell celda5a10seiz=fila19.createCell(j);
        	          celda5a10seiz.setCellValue(arreglo_datos[i][0].toString());
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        	      }else if(j==5){
        			  Cell celda5a10seiz=fila19.createCell(j);
        	          celda5a10seiz.setCellValue(arreglo_datos[i][0].toString());
        	          celda5a10seiz.setCellStyle(styles.get("titleMedio"));
        	          celda5a10seiz.setCellStyle(styles.get("ralla"));
        		  } else if(j==6){
        			Cell celda1y16=fila19.createCell(j);
  					celda1y16.setCellStyle(styles.get("titleMedio"));
  					celda1y16.setCellStyle(styles.get("ralla"));
        		  }else{
        			Cell celda1y16=fila19.createCell(j);
    				celda1y16.setCellStyle(styles.get("titleMedio"));
    				celda1y16.setCellStyle(styles.get("ralla")); 
        			  
        			  
        		  }
        		  }else if(i<arreglo_datos.length+1){
        			  int num=0;
        			  if(j==0){
            	        Cell cell1 = fila19.createCell(j);
            	        if((""+arreglo_datos[i-1][1]).equals("null")){
            	        	num=0;
            	        }else{
            	        	num=Integer.parseInt(""+arreglo_datos[i-1][1]);
            	        }
            	        cell1.setCellValue(num);
            	        cell1.setCellStyle(styles.get("rrallamediosimple")); 
        			  }else if(j==1){//+'COTIZACION - CLIENTE'!C18
        				Cell cell2 = fila19.createCell(j);//
        				cell2.setCellValue(arreglo_datos[i-1][2].toString());
        				cell2.setCellStyle(styles.get("rrallamediosimple"));  
        			  }else if(j==2){//+'COTIZACION - CLIENTE'!D18
        				Cell cell2 = fila19.createCell(j);//
        				cell2.setCellValue(arreglo_datos[i-1][3].toString());
        				cell2.setCellStyle(styles.get("rrallacostadosimple"));
        			  }else if(j==3){
        				Cell cell2 = fila19.createCell(j);//
        				cell2.setCellValue(arreglo_datos[i-1][4].toString());
        				cell2.setCellStyle(styles.get("rrallacostadosimple"));   
        			  }else if(j==4){
        				Cell cell2 = fila19.createCell(j);//
        				cell2.setCellValue(Double.parseDouble(""+arreglo_datos[i-1][5]));
        				cell2.setCellStyle(styles.get("rrallamediosimpleFormat3")); 
        				//aca data
        			  }else if(j==5){
        				 
        				Cell cellFOR = fila19.createCell(j);//
        				//cellFOR.setCellValue("=E"+(25+(i-1))+"*A"+(25+(i-1)));
        				cellFOR.setCellFormula("E"+(25+(i-1))+"*A"+(25+(i-1)));
        				cellFOR.setCellStyle(styles.get("rrallamediosimpleFormat2"));  
        			  }else{
            	        Cell cell122 = fila19.createCell(j);//'HOJA DE COSTOS  INTERNA'!B10
            	        cell122.setCellStyle(styles.get("titleMedio"));
            	        cell122.setCellStyle(styles.get("ralla"));
        			  }
        		  }else{
        		  
        			Cell celda1y16=fila19.createCell(j);
  				//celda1y16.setCellStyle(styles.get("titleMedio"));
  				celda1y16.setCellStyle(styles.get("ralla"));
        		  }
        
  			}
        	  
  		}
        
		Row fila20=sheet3.createRow((arreglo_datos.length)+25);
  		Row fila21=sheet3.createRow((arreglo_datos.length)+26);
  		Row fila22=sheet3.createRow((arreglo_datos.length)+27);
  		Row filanosed=sheet3.createRow((arreglo_datos.length)+28);
  		
  		for (int i = 0; i < 4; i++) {//0,1,2=3
  		for (int j = 0; j < 7; j++) {//numero de columnas
  			/*CUANDO EL IGV_DET=1  ES IGUAL A MAS IGV*/
  			/*CUANDO EL IGV_DET=0  ES IGUAL A CON IGV*/
  			
  				//CUANDO EL IGV_DET=0  ES IGUAL A CON IGV
  				if(i==0){
  		  			 if(j==5){//SUMA(I10:I12)
  		  				Cell celda1y17=fila20.createCell(j);
  		  				String sd="";
  		  				if(arreglo_datos[0][0].equals("SOLES")){
  		  					sd="S/.";
  		  				}else{
  		  					sd="$";
  		  				}
  		  				celda1y17.setCellValue(sd);
  		  				celda1y17.setCellStyle(styles.get("titleMedioDobleRallaAriva"));
  		  			}else if(j==6){
  		  				
  		  			}else{
  		  				Cell celda1y17=fila20.createCell(j);
  		    			celda1y17.setCellStyle(styles.get("dobleRallaHor"));
  		    		}		
  		  			}else if(i==1){
  		  				
  		  			if(igv==0){
  		  			if(j>3){
  		  			if(j==4){
		  					Cell celda10y0=fila21.createCell(j);
		  	      			celda10y0.setCellValue("TOTAL");
		  	      			celda10y0.setCellStyle(styles.get("cell"));
		  			}else if(j==5){
		  	  				Cell celda10y0=fila21.createCell(j);//SUMA(G18:G117)
		  	      			celda10y0.setCellFormula("SUM(F25:F"+((arreglo_datos.length)+24)+")");
		  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
		  	  		}else{}	
  		  			}
  		  			
  		  			
		  			}else if(igv==1){
		  			if(j>3){
		  	  		if(j==4){
		  	  		Cell celda10y0=fila21.createCell(j);
		  	  	    celda10y0.setCellValue("SUB-TOTAL");
		  	  	    celda10y0.setCellStyle(styles.get("cell"));
		  	  		}else if(j==5){
		  	  	  	Cell celda10y0=fila21.createCell(j);//SUMA(G18:G117)
		  	  	    celda10y0.setCellFormula("SUM(F25:F"+((arreglo_datos.length)+24)+")");
		  	  	    celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
		  	  	  	}else{}
		  	  		}	
		  				
		  			}else{}
  		  			
  		  			
  		  			}else if(i==2){
  		  			if(igv==1){
  		  			if(j>3){
  	  	  				if(j==4){
  	  	  					Cell celda10y0=fila22.createCell(j);
  	  	  	      			celda10y0.setCellValue("IGV 19%");
  	  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  	  				}else if(j==5){
  	  	  	  				Cell celda10y0=fila22.createCell(j);//+E20*0.18
  	  	  	  				//celda10y0.setCellValue("+F"+(27+(arreglo_datos.length))+"*0.18");
  	  	  	      			celda10y0.setCellFormula("+F"+(27+(arreglo_datos.length))+"*0.18");
  	  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  	  			}else{

  	  	  	    		}	
  	  	  				}	
  		  			}
  		  			
  		  			}else if(i==3){
  		  			if(igv==1){
  		  			if(j>3){
  	  	  				if(j==4){
  	  	  					Cell celda10y0=filanosed.createCell(j);
  	  	  	      			celda10y0.setCellValue("TOTAL");
  	  	  	      			celda10y0.setCellStyle(styles.get("cell"));
  	  	  				}else if(j==5){
  	  	  	  				Cell celda10y0=filanosed.createCell(j);//SUMA(E20:E21)
  	  	  	      			celda10y0.setCellFormula("SUM(F"+(27+(arreglo_datos.length))+":F"+(28+(arreglo_datos.length))+")");
  	  	  	      			celda10y0.setCellStyle(styles.get("cuadradoSimpleChicoFormat"));
  	  	  	  			}else{

  	  	  	    		}	
  	  	  				}	
  		  			}
  		  			}else{
  		  				
  		  			}
  		  			
  			}
  		}
  		//AKA TERMINA EL ULTIMO BUCLE	
		
  		for (int i = 0; i < 18; i++) {
  	  		Row fila24=sheet3.createRow((arreglo_datos.length)+29+i);
  	  		if(i==0){
  	  		Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(1));
			celda10y0.setCellStyle(styles.get("titleSubRallado"));
  	  		}else if(i==1){
  	  		Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(2));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		}else if(i==2){
  	  		
  	  	  		
  	  	  	}else if(i==3){
  	  	  	Cell celda10y0=fila24.createCell(2);
				celda10y0.setCellValue(cargar(4));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  		
  	  	  	}else if(i==4){
  	  	  		Cell celda10y0=fila24.createCell(2);
				celda10y0.setCellValue(cargar(5));
				celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
				
  	  	  	}else if(i==5){
  	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(6));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
  	  	  	}else if(i==6){
  	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(7));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  		
  	  	  	}else if(i==7){
  	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue("BANCO:"+arreglo_nombre[11]);//titleCostadoSimple
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  		
  	  	  	}else if(i==8){
  	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue("NºCUENTA:"+arreglo_nombre[8]);//titleCostadoSimple
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	}else if(i==9){
  	  	  	Cell celda10y0=fila24.createCell(2);
  			celda10y0.setCellValue("NºCUENTA:"+arreglo_nombre[9]);
  			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	
  	  	  	}else if(i==10){
  	  	  	Cell celda10y0=fila24.createCell(2);
  			celda10y0.setCellValue("CONDICIONES DE PAGO :"+arreglo_nombre[12]);
  			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	  	
  	  	  	}else if(i==11){
	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue("LUGAR DE ENTREGA :"+arreglo_nombre[13]);
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  	  	  	
  	  	  	}else if(i==12){
	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue("TIEMPO DE ENTREGA :"+arreglo_nombre[14]);
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	    	  	  	
  	    	}else if(i==13){
	  	  		
  	  	  	}else if(i==14){
  	  	  	String filaSeparada="",pfila="",sfila="";
	  	  	filaSeparada=cargar(11);
	  	  	if(filaSeparada.indexOf("|")==-1){
	  	  		
	  	  	}else{
	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
	  	  	}
  	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(pfila);
			celda10y0.setCellStyle(styles.get("titleMedioAmarillo"));
			Cell celda10y1=fila24.createCell(3);
			celda10y1.setCellValue(sfila);
			celda10y1.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	}else if(i==15){
	  	  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(12));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
  	  			  	  		
	  	  	}else if(i==16){
		  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(cargar(13));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
	  	  	
	  	  	}else if(i==17){
	  	  	String filaSeparada="",pfila="",sfila="";
	  	  	filaSeparada=cargar(14);
	  	  	if(filaSeparada.indexOf("|")==-1){
	  	  		
	  	  	}else{
	  	  	pfila=filaSeparada.substring(0, filaSeparada.indexOf("|"));
	  	  	sfila=filaSeparada.substring(filaSeparada.indexOf("|")+1, filaSeparada.length());
	  	  	}
		  	Cell celda10y0=fila24.createCell(2);
			celda10y0.setCellValue(pfila);
			//sheet3.addMergedRegion(CellRangeAddress.valueOf("$F$"+(51+arreglo_datos.length)+":$G$"+(51+arreglo_datos.length)));
			celda10y0.setCellStyle(styles.get("titleCostadoSimple"));
			
			Cell celda10y2=fila24.createCell(3);
			celda10y2.setCellValue(sfila);
			celda10y2.setCellStyle(styles.get("dobleRallaHor"));
			
	  	  	}
  	  	  	else{	
  	  		}
		}
  		
        sheet3.setZoom(3, 4);
      
   }

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
        Font titleFontMedio = wb.createFont();
        titleFontMedio.setFontHeightInPoints((short)14);//Esto es para ponerle el tamaño al titulo
        titleFontMedio.setBoldweight(Font.COLOR_NORMAL);//Si es Negrita O no Es Negrita
        style = wb.createCellStyle();
        style.setWrapText(true);
        style.setAlignment(CellStyle.ALIGN_CENTER);//Centro,Costados
        style.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);//Centro,Costados
        style.setFont(titleFontMedio);
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
