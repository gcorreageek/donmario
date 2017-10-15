package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import miLib.Fecha;

public class CustomTableCellRendererModificarAgregarProdMant extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Fecha objFecha;
    public CustomTableCellRendererModificarAgregarProdMant(){
    	
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        String fecha = "";
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        fecha = table.getValueAt(row, 7).toString();
        
        setFont(new Font(null, Font.BOLD, 12));
        
        if(fecha.equals("")){                                                        
            setBackground(Color.white);
            setForeground(Color.black);
            if(isSelected){
            	setBackground(new Color(189, 214, 231));
            }
            else{
            	setBackground(Color.white);
            }
                
        }
        else{
        	if(diferenciaFechas(fecha)> 30){
                setBackground(Color.red);
                setForeground(Color.white);
                if(isSelected){
                	setBackground(new Color(189, 214, 231));
                	setForeground(Color.black);
                }
                else{
                	setBackground(Color.red);
                	setForeground(Color.white);
                }
                    
            }
            else{
            	setBackground(new Color(11, 28, 232));
                setForeground(Color.white);
                if(isSelected){
                	setBackground(new Color(189, 214, 231));
                	setForeground(Color.black);
                }
                else{
                	setBackground(new Color(11, 28, 232));
                }
                    
            }
        }
        
        return cell;
    }

    public int diferenciaFechas(String fec){
        
    	int año = 0;
        int mes = 0;
        int dia = 0;
        int año2 = 0;
        int mes2 = 0;
        int dia2 = 0;
        int rango = 0;
        
        año = Integer.parseInt(año(fec));
        mes = Integer.parseInt(mes(fec));
        dia = Integer.parseInt(dia(fec));
        
        año2 = Integer.parseInt(año(objFecha.fechaActual()));
        mes2 = Integer.parseInt(mes(objFecha.fechaActual()));
        dia2 = Integer.parseInt(dia(objFecha.fechaActual()));
        
        GregorianCalendar date1 = new GregorianCalendar(año, mes, dia);
        GregorianCalendar date2 = new GregorianCalendar(año2, mes2, dia2);
        int diasAnyo = date1.isLeapYear(date1.get(1)) ? 366 : 365;
        int rangoAnyos = date2.get(1) - date1.get(1);
        rango = rangoAnyos * diasAnyo + (date2.get(6) - date1.get(6));
        return rango;
    }

    public String año(String fec){
    	
        String cad = "";
        for(int i = 0; i < fec.length(); i++){
            if(i<4){
            	cad+=fec.charAt(i);
            }else{
            	break;
            }     
        }
        return cad;
    }

    public String mes(String fec){
    	
        String cad = "";
        int cont = 0;
        int cont2 = 0;
        for(int i = 0; i < fec.length(); i++){
        	       
            if(cont>= 5 && i < 7){
            	cont2++;
            	if(cont2==1 && (""+fec.charAt(i)).equals("0")){
            		cad="";
            	}else{
            		cad+=""+fec.charAt(i);
            	}
                
            } 
            else{
                cont++;
            }
        }
        return cad;
    }

    public String dia(String fec){
        String cad = "";
        int cont = 0;
        for(int i = 0; i < fec.length(); i++){
        	if(cont >= 8 && i < fec.length()){
        		cad += ""+fec.charAt(i);
        	}
            else{
               cont++;
            }
               
        }
        return cad;
    }
    
}