package Buscar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.datatransfer.*;
import java.util.*;
public class ExcelAdapter implements ActionListener
   {
   private String rowstring,value,value1;
   private Clipboard system;
   private StringSelection stsel,stse2;
   private JTable jTable1 ;
public ExcelAdapter(JTable myJTable)
   {
      jTable1 = myJTable;
      KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
      KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
jTable1.registerKeyboardAction(this,"Copy",copy,JComponent.WHEN_FOCUSED);
jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);
      system = Toolkit.getDefaultToolkit().getSystemClipboard();
   }

public JTable getJTable() {return jTable1;}
public void setJTable(JTable jTable1) {this.jTable1=jTable1;}
public void actionPerformed(ActionEvent e)
   {
	/*try {
		DefaultTableModel modelo = (DefaultTableModel) jTable1
				.getModel();
		int filas = jTable1.getRowCount();
		for (int ii = 1; filas > ii; ii++) {
			modelo.removeRow(0);
		}
	} catch (Exception ee) {
		JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	}*/
      if (e.getActionCommand().compareTo("Copy")==0)
      {
         StringBuffer sbf=new StringBuffer();
         // Check to ensure we have selected only a contiguous block of
         // cells
         int numcols=jTable1.getSelectedColumnCount();
         int numrows=jTable1.getSelectedRowCount();
         int[] rowsselected=jTable1.getSelectedRows();
         int[] colsselected=jTable1.getSelectedColumns();
         if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
                numrows==rowsselected.length) &&
(numcols-1==colsselected[colsselected.length-1]-colsselected[0] &&
                numcols==colsselected.length)))
         {
            JOptionPane.showMessageDialog(null, "Invalid Copy Selection",
                                          "Invalid Copy Selection",
                                          JOptionPane.ERROR_MESSAGE);
            return;
         }
         for (int i=0;i<numrows;i++)
         {
            for (int j=0;j<numcols;j++)
            {
sbf.append(jTable1.getValueAt(rowsselected[i],colsselected[j]));
               if (j<numcols-1) sbf.append("\t");
            }
            sbf.append("\n");
         }
         stse2= new StringSelection(sbf.toString());
         stsel  = new StringSelection(sbf.toString());
         system = Toolkit.getDefaultToolkit().getSystemClipboard();
         system.setContents(stsel,stsel);
      }
      if (e.getActionCommand().compareTo("Paste")==0)
      {
          System.out.println("Trying to Paste");
          int startRow=(jTable1.getSelectedRows())[0];
          int startCol=(jTable1.getSelectedColumns())[0];
          int startCo2= (jTable1.getSelectedColumns())[0];
          int startRow1=(jTable1.getSelectedRows())[0];
          try
          {
        	 String trstring1= (String)(system.getContents(this).getTransferData(DataFlavor.stringFlavor));
             String trstring= (String)(system.getContents(this).getTransferData(DataFlavor.stringFlavor));
             
             System.out.println("String is:"+trstring);
             System.out.println("String is:"+trstring);
             StringTokenizer st1=new StringTokenizer(trstring,"\n");
             for(int i=0;st1.hasMoreTokens();i++)
             {
                rowstring=st1.nextToken();
                StringTokenizer st2=new StringTokenizer(rowstring,"\t");
                for(int j=0;st2.hasMoreTokens();j++)
                {
                   value=(String)st2.nextToken();
                   value1=(String)st2.nextToken();
                   
                   if(startRow1+i<jTable1.getRowCount() &&
                   	  startCo2+ i<jTable1.getColumnCount())
                	   jTable1.setValueAt(value,startRow+i,startCo2+j);
                   ((DefaultTableModel) jTable1.getModel())
                   .setRowCount(jTable1.getRowCount() + 2);
                   System.out.println("Putting"+ value+"atrow="+startRow1+i+"column="+startCo2+j);
                   
                   if (startRow+i< jTable1.getRowCount()  &&
                       startCol+j< jTable1.getColumnCount())
                      jTable1.setValueAt(value,startRow+i,startCol+j);
                   ((DefaultTableModel) jTable1.getModel())
					.setRowCount(jTable1.getRowCount() + 1);
                   System.out.println("Putting "+ value+"atrow="+startRow+i+"column="+startCol+j);
                   
                   if(startRow+i< jTable1.getRowCount() &&
                		   startCo2 +i<jTable1.getColumnCount())
                	   jTable1.setValueAt(value, startRow1+i, startCol+j);
                   ((DefaultTableModel)jTable1.getModel())
                   .setRowCount(jTable1.getRowCount() +4);
                  System.out.println("Putting"+ value+"atrow="+startRow1+i+"column="+startCo2+i);
               }
            }
         }
         catch(Exception ex){ex.printStackTrace();}
      }
   }
}