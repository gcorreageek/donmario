package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import miLib.Fecha;

public class CustomTableCellRenderer2 extends DefaultTableCellRenderer{

	Fecha objFecha;
    public CustomTableCellRenderer2(){
    	
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                                                                      
        setBackground(Color.red);
        setForeground(Color.white);
        setHorizontalAlignment(RIGHT);
        
        if(isSelected){
        	setBackground(new Color(189, 214, 231));
        	setForeground(Color.black);
        }
        else{
        	setBackground(Color.red);
        	setForeground(Color.white);
        }
            
        return cell;
    }
    
}