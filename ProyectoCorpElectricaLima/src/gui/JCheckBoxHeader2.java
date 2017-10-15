package gui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


public class JCheckBoxHeader2 extends JPanel implements TableCellRenderer, MouseListener {
    
  int column;  
  boolean mousePressed = false;  
  JTable tabla;
  JCheckBox chk;
  
  public JCheckBoxHeader2(JTable t){
  tabla=t;
  chk=new JCheckBox();
  chk.addItemListener(new ItemListener(){


  @Override
  public void itemStateChanged(ItemEvent e) {
       for(int x = 0; x<tabla.getRowCount(); x++){  
         tabla.setValueAt(new Boolean(chk.isSelected()),x,23);  
       }  
       
  }
    
    });
  add(chk);
  }  
  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {  
    if (table != null) {  
      JTableHeader cabecera = table.getTableHeader(); 
      if (cabecera != null) {
      cabecera.addMouseListener(this);  
      }  
    }  
    return this;  
  }  
  
  public void seleccionar(MouseEvent e){
	  TableColumnModel Modelocolumna = tabla.getColumnModel();  
	  int columnaactual = Modelocolumna.getColumnIndexAtX(e.getX());    


	  if (columnaactual == 23) {  
		   if(chk.isSelected()){
		    chk.setSelected(false);
		   }else{
		    chk.setSelected(true);
		   }
		  }
		    ((JTableHeader)e.getSource()).repaint(); 
	  }
  
  public void seleccionados(){
	  
	  for(int x = 0; x<tabla.getRowCount(); x++){ 
		  
			if(chk.isSelected()){
				System.out.println("TRUE");
			}else{
				System.out.println("FALSE");
			} 
	  }
  }
  
   
  public void mouseClicked(MouseEvent e) {  
  seleccionar(e);
  }  
  public void mousePressed(MouseEvent e) {  
  seleccionar(e); 
  }  
  public void mouseReleased(MouseEvent e) {  
  }  
  public void mouseEntered(MouseEvent e) {  
  }  
  public void mouseExited(MouseEvent e) {  
  }  
}
