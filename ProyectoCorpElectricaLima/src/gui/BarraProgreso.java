package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class BarraProgreso extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FlowLayout v = new FlowLayout();
	JButton boton = new JButton("Aumentar nivel barra de progreso");
	JProgressBar barra = new JProgressBar(0, 10); // min,max
	int i = 0;
	int n=0;
	Timer t;

	public BarraProgreso() {
		add(boton);
		add(barra);
		getContentPane().setLayout(v);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 150);
		setVisible(true);
		// Evento al pulsar boton
		boton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				i = i + 1;
				barra.setValue(i);
				t=new Timer();
			}
		});
	}

	public static void main(String[] args) {
		new BarraProgreso();
	}

}
