package miLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LectorExcel {

	
	public static Integer tamaño(Sheet sheet1){
		Integer tam=0;
		for (Row row : sheet1) {
			tam=tam+1;
		}
		return tam;
	}
	public static Object[][] optenerFilasColumnasExcel(Integer columnasLeer,String ruta) throws InvalidFormatException, IOException{
	InputStream inp = new FileInputStream(ruta);
    //InputStream inp = new FileInputStream("workbook.xlsx");

    Workbook wb = WorkbookFactory.create(inp);
    Sheet sheet1 = wb.getSheetAt(0);
    //Integer columnasLeer=8;
    //[fila][columna]
    Integer filasAdentro=-1;
   
    Integer filas=tamaño(sheet1);
    Integer columnas=columnasLeer;
    Object[][] obj = new Object[filas][columnas];
    for (Row row : sheet1) {
    	filasAdentro=filasAdentro+1;
    	 Integer columnasAdentro=-1;
    	for (Cell cell : row) {
    		columnasAdentro=columnasAdentro+1;
    		if(cell.getColumnIndex()==columnasLeer){
    			break;
    		}
    		//System.out.print("getColumnIndex():"+cell.getColumnIndex());
    		//System.out.print("getRow():"+cell.getRow());
    		//System.out.println("obj["+filasAdentro+"]"+"["+columnasAdentro+"]");
    		switch(cell.getCellType()) {
          case Cell.CELL_TYPE_STRING:
        	  obj[filasAdentro][columnasAdentro]=cell.getRichStringCellValue().getString();
            //System.out.println(cell.getRichStringCellValue().getString());
            break;
          case Cell.CELL_TYPE_NUMERIC:
            if(DateUtil.isCellDateFormatted(cell)) {
            	  obj[filasAdentro][columnasAdentro]=cell.getDateCellValue();;
              //System.out.println(cell.getDateCellValue());
            } else {
            	 obj[filasAdentro][columnasAdentro]=cell.getNumericCellValue();
              //System.out.println(cell.getNumericCellValue());
            }
            break;
          case Cell.CELL_TYPE_BOOLEAN:
        	  obj[filasAdentro][columnasAdentro]=cell.getBooleanCellValue();
            //System.out.println(cell.getBooleanCellValue());
            break;
          case Cell.CELL_TYPE_FORMULA:
        	  obj[filasAdentro][columnasAdentro]=cell.getCellFormula();
           // System.out.println(cell.getCellFormula());
            break;
          default:
        	  //obj[filasAdentro][columnasAdentro]=cell.getCellFormula();
            System.out.println();
          
    		}
    		  
    	}
    }
    
	return obj;	
	}
}
