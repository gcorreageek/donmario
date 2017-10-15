package Prueba;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Principal extends JApplet {
 
 JTable tabla;
 JScrollPane scroll;
 DefaultTableModel modelo;
 Object [] nomcolumnas={"","Nombre","Url"};
 Object [][] datos=new Object[2][2];
 TableColumn Tcol;
 JCheckBoxHeader chkheader; 
 JButton eliminar;
 
 public void init(){
  
  modelo=new DefaultTableModel(datos, nomcolumnas);
  tabla=new JTable(modelo);
  
  tabla.setValueAt("Java Zone", 0, 1);
  tabla.setValueAt("www.java-elrincondetucasa.tk", 0, 2);
  tabla.setValueAt("Google", 1, 1);
  tabla.setValueAt("www.google.com.co", 1, 2);
  
  Tcol=tabla.getColumnModel().getColumn(0);
  Tcol.setCellEditor(tabla.getDefaultEditor(Boolean.class));  
  Tcol.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
  chkheader=new JCheckBoxHeader(tabla);
  Tcol.setHeaderRenderer(chkheader);
 
  eliminar=new JButton("Eliminar");
  eliminar.addActionListener(new ActionListener(){


   @Override
   public void actionPerformed(ActionEvent e) {
      for(int i=0;i<tabla.getRowCount();i++){
	     if(tabla.getValueAt(i, 0)!=null){
	      chkheader.chk.setSelected(false);
	      tabla.setValueAt(false, i, 0);
	      tabla.setValueAt("", i, 1);
	      tabla.setValueAt("", i, 2);
	      repaint();
	      tabla.updateUI();
	     }
      }
   }
   
  });
  scroll=new JScrollPane(tabla);
  add(scroll);
  JPanel pboton=new JPanel();
  pboton.add(eliminar);
  add(pboton,BorderLayout.SOUTH);  
 }
}

