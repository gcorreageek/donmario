package beta;
import java.io.*;
import java.util.Date;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
 
public class DemoJExcel
{
    public static void main(String[] args)
    {
        escribirExcel();
 
        leerExcel();
 
        System.out.println("Ejemplo Finalizado.");
    }
 
    public static void escribirExcel()
    {
        try
        {
            //Se crea el libro Excel
            WritableWorkbook workbook =
                    Workbook.createWorkbook(new File("EXPORTAR.xls"));
 
            //Se crea una nueva hoja dentro del libro
            WritableSheet sheet =
                    workbook.createSheet("Hoja1", 0);
            
            //Creamos celdas de varios tipos
            sheet.addCell(new jxl.write.Number(0, 0, 0));
            sheet.addCell(new jxl.write.Number(1, 0, 0));
            sheet.addCell(new jxl.write.Number(2, 0, 0));
            sheet.addCell(new jxl.write.Number(3, 0, 0));
            sheet.addCell(new jxl.write.Number(4, 0, 0));
            sheet.addCell(new jxl.write.Number(5, 0, 0));
            //*******************************************
            sheet.addCell(new jxl.write.Number(0, 1, 0));
            sheet.addCell(new jxl.write.Number(1, 1, 0));
            sheet.addCell(new jxl.write.Number(2, 1, 0));
            sheet.addCell(new jxl.write.Number(3, 1, 0));
            sheet.addCell(new jxl.write.Number(4, 1, 0));
            sheet.addCell(new jxl.write.Number(5, 1, 0));
            //*******************************************
            sheet.addCell(new jxl.write.Number(0, 2, 0));
            sheet.addCell(new jxl.write.Number(1, 2, 0));
            sheet.addCell(new jxl.write.Number(2, 2, 0));
            sheet.addCell(new jxl.write.Number(3, 2, 0));
            sheet.addCell(new jxl.write.Number(4, 2, 0));
            sheet.addCell(new jxl.write.Number(5, 2, 0));
            //*******************************************
            sheet.addCell(new jxl.write.Number(0, 3, 0));
            sheet.addCell(new jxl.write.Number(1, 3, 0));
            sheet.addCell(new jxl.write.Number(2, 3, 0));
            sheet.addCell(new jxl.write.Number(3, 3, 0));
            sheet.addCell(new jxl.write.Number(4, 3, 0));
            sheet.addCell(new jxl.write.Number(5, 3, 0));
            //*******************************************
            sheet.addCell(new jxl.write.Label(0, 4, "CANTIDAD"));
            sheet.addCell(new jxl.write.Label(1, 4, "UNIDAD"));
            sheet.addCell(new jxl.write.Label(2, 4, "DESCRIPCION"));
            sheet.addCell(new jxl.write.Label(3, 4, "MARCA"));
            sheet.addCell(new jxl.write.Label(4, 4, "MODELO"));
            sheet.addCell(new jxl.write.Label(5, 4, "CODIGO PROMELSA"));
            //*******************************************
            //indicando un patón de formatM            
            sheet.addCell(new jxl.write.Label(0, 5, "13"));
            sheet.addCell(new jxl.write.Label(1, 5, "U"));
            sheet.addCell(new jxl.write.Label(2, 5, "MASTIL DE FOGO DE 1 X 3 MTS."));
            sheet.addCell(new jxl.write.Label(3, 5, ""));
            sheet.addCell(new jxl.write.Label(4, 5, ""));
            sheet.addCell(new jxl.write.Label(5, 5, ""));
            workbook.write();
            workbook.close();
            leerExcel(); 
            System.out.println("Ejemplo finalizado.");
        }
        catch (IOException ex)
        {
            System.out.println("Error al crear el fichero.");
        }
        catch (WriteException ex)
        {
            System.out.println("Error al escribir el fichero.");
        }
    }
 
    public static void leerExcel()
    {
        try
        {
            //Se abre el fichero Excel
            Workbook workbook = Workbook.getWorkbook(new File("EXPORTAR.xls"));
 
            //Se obtiene la primera hoja
            Sheet sheet = workbook.getSheet(0);
 
            //Se leen las primeras 5 celdas
            for(int i=0; i<5; i++)
            {
                //Se obtiene la celda i-esima
                Cell cell = sheet.getCell(i,0);
 
                //Se imprime en pantalla la celda según su tipo
                if (cell.getType() == CellType.NUMBER)
                {
                    System.out.println("Número: " + ((NumberCell)cell).getValue());
                }
                else if (cell.getType() == CellType.LABEL)
                {
                    System.out.println("String: " + ((LabelCell)cell).getString());
                }
                else if (cell.getType() == CellType.BOOLEAN)
                {
                    System.out.println("Boolean: " + ((BooleanCell)cell).getValue());
                }
                else if (cell.getType() == CellType.DATE)
                {
                    System.out.println("Fecha: " + ((DateCell)cell).getDate());
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error!");
        }
    }
}
			/*v.addElement("0 ,0,0,0,0,0, 0 ");
			v.addElement("0 ,0,0,0,0,0, 0 ");
			v.addElement("0 ,0,0,0,0,0, 0 ");
			v.addElement("0 ,0,0,0,0,0, 0 ");
			v.addElement("CANTIDAD ,UNIDAD,DESCRIPCION,MARCA,MODELO,CODIGO PROMELSA ");
			v.addElement("8,mts,MALLA OLIMPICA 2 X 2 ALAMBRE # 10,,,");
			v.addElement("9,U,ALAMBRE DE ALUMINIO PARA AMARRE 6mm,,,");
			v.addElement("4,U,MEDIDOR ELECTRONICO MONOFASICO DE 05 A 40 AMP 2 HILOS 220 VOL 60 HZ A 200 LCD,,,");
*/