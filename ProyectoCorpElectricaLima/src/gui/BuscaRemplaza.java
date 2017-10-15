/*
	Programa: Editor Compilador en java
	Autor: Borja
	Web: http://todojava.awardspace.com/
	Version: 1.0
	
	Descripción: Editor de texto que compila y ejecuta programas en java
	
	Dificultad: Media
*/

//	Clase de Buscar y Remplazar
package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BuscaRemplaza extends JDialog implements ActionListener
{
	JLabel LBusc=new JLabel("Buscar                 ",JLabel.LEFT);
	JLabel LRemp=new JLabel("Reemplazar por:",JLabel.LEFT);
	JTextField TBusc=new JTextField(15);
	JTextField TRemp=new JTextField(15);
	
	
	
	JButton Buscar=new JButton("Buscar");
	JButton ReemplazarTodo=new JButton("Reemplazar Todo");
	JButton Reemplazar=new JButton("Reemplazar");
	
	Editor ed;
	int Posicion=0;
	BuscaRemplaza(JInternalFrame DBusRem,String s,boolean b)
	{
	super();
	
	ed=(Editor)DBusRem;
	setLayout(new FlowLayout());
	add(LBusc);
	add(TBusc);
	add(LRemp);
	add(TRemp);
	JPanel Botones=new JPanel();
	Botones.add(Buscar);
	Buscar.addActionListener(this);
	Botones.add(Reemplazar);
	Reemplazar.addActionListener(this);
	Botones.add(ReemplazarTodo);
	ReemplazarTodo.addActionListener(this);
	add(Botones,"South");
	
	setTitle("Buscar y reemplazar");
	setSize(350,130);
	setResizable(false);
	setLocation(200,250);
    setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Buscar)
		{
			Buscame();
		}
		if(ae.getSource()==ReemplazarTodo)
		{
			ed.Texto.requestFocus();
			String Texto="";
			Texto=ed.Texto.getText().toLowerCase();
			String s=Texto.replaceAll(TBusc.getText().toLowerCase(),TRemp.getText()); //Remplazar todo
			ed.Texto.setText(s.toUpperCase());
			
			Posicion=Texto.indexOf(TBusc.getText().toLowerCase(),Posicion+0);
		 	if(Posicion==-1)
		 	JOptionPane.showMessageDialog(this,"No se ha encontrado: " + TBusc.getText().toLowerCase());
		}
		if(ae.getSource()==Reemplazar)
		{
			ed.Texto.requestFocus();
			String Texto="";
			Texto=ed.Texto.getText().toLowerCase();
			String s=Texto.replaceFirst(TBusc.getText().toLowerCase(),TRemp.getText()); //Remplazar todo
			ed.Texto.setText(s.toUpperCase());
			
			Posicion=Texto.indexOf(TBusc.getText().toLowerCase(),Posicion+0);
		 	if(Posicion==-1)
		 	 JOptionPane.showMessageDialog(this,"No se ha encontrado: " + TBusc.getText().toLowerCase());	 
		}
		setVisible(true);
	}
	void Buscame()
	{
			ed.Texto.requestFocus();
			String Palabra="";
			String TextoBusc="";
		 	Palabra=TBusc.getText().toLowerCase();
		 	TextoBusc=ed.Texto.getText().toLowerCase();
		 	//busca
		 	Posicion=TextoBusc.indexOf(Palabra,Posicion+1);
		 	if(Posicion!=-1)
		 	ed.Texto.select(Posicion,Posicion + Palabra.length()); //Reemplaza 
		 	else JOptionPane.showMessageDialog(this,"No se ha encontrado: " + Palabra);	 
	}
}