package miLib;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;







public class MiRender extends DefaultTableCellRenderer{

   public Component getTableCellRendererComponent(JTable table,
		   Object value, boolean isSelected,boolean hasFocus, int row, int column) {

      super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
   
    
	 
     
         
      
      return this;
   }
}
