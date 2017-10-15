/*
	Programa: Editor Compilador en java
	Autor: Borja
	Web: http://todojava.awardspace.com/
	Version: 1.0
	
	Descripción: Editor de texto que compila y ejecuta programas en java
	
	Dificultad: Media
*/

//	Clase para establecer colores de fondo y texto
package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;

class ElegirColor extends JDialog implements ActionListener
{
	JColorChooser jcolor=new JColorChooser();
	JButton btAceptar=new JButton("Aceptar");
	Editor ed;
	String tipo;
	
ElegirColor(JInternalFrame Dcolor,String s,boolean b,String tip)
 {
 	super();
 	
 	ed=(Editor)Dcolor;
 	setLayout(new FlowLayout());
 	add(jcolor);
 	add(btAceptar);
 	btAceptar.addActionListener(this);
 	setTitle("Elegir color...");
	setSize(400,440);
	setResizable(false);
	setLocation(200,250);
    setVisible(true);
    tipo=tip;
 }
 	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btAceptar){
			if(tipo.equals("fondo")){
			ed.Texto.setBackground(jcolor.getColor());
			ed.Errores.setBackground(jcolor.getColor());
			ed.colorFondo.setBackground(jcolor.getColor());
			}
			if(tipo.equals("texto")){
			ed.Texto.setForeground(jcolor.getColor());
			ed.Errores.setForeground(jcolor.getColor());
			ed.colorTexto.setBackground(jcolor.getColor());
			}		
		}
		dispose();
	}
}