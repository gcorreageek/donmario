package gui;




//	Clase de Buscar

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


class Busca extends JDialog implements ActionListener
{
	JLabel LBus=new JLabel("Buscar:");
	JTextField TPalabra=new JTextField(10);
	JButton Buscar=new JButton("Buscar Siguiente");
	int Posicion;
	
	Editor ed;
	MenuPrincipal men;

	
	public Busca(JInternalFrame DBuscar,String s,boolean b)
	{
    
	super();
	ed=(Editor)DBuscar;
	
	Buscar.addActionListener(this);
	setLayout(new GridLayout(1,3));
	setLayout(new FlowLayout());
	add(LBus);
	add(TPalabra);
	add(Buscar);
	
	setTitle("Buscar...");
	setSize(325,75);
	setResizable(false);
	setLocation(100,100);
    setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Buscar)
		{
			ed.Texto.requestFocus();
			String Palabra="";
			String TextoBusc="";
		 	Palabra=TPalabra.getText().toLowerCase();
		 	TextoBusc=ed.Texto.getText().toLowerCase();
		 	Posicion=TextoBusc.indexOf(Palabra,Posicion);
		 	if(Posicion!=-1)
		 	ed.Texto.select(Posicion,Posicion + Palabra.length()); 
		 	else JOptionPane.showMessageDialog(this,"No se ha encontrado: " + Palabra);
		 	Posicion++;	 

		}
		setVisible(true);
	}
}