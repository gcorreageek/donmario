package Buscar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class casdasdsa extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					casdasdsa frame = new casdasdsa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public casdasdsa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		jTextFieldProducto = new JTextField();
		jTextFieldProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//casdasdasdasd();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				String cadena ="";
			}
		});
		contentPane.add(jTextFieldProducto, BorderLayout.NORTH);
		jTextFieldProducto.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, BorderLayout.CENTER);
	}

	String producto(){
		// TODO Auto-generated method stub
		String cadena="";
		String entrada = jTextFieldProducto.getText();		
		entrada = entrada.trim();
		String separa[] = entrada.split(" ");
		for(int comenzar=0;comenzar<separa.length;comenzar++)
		{
				int yu=comenzar;
				System.out.println("entrada:  "+separa[yu]+"\n");
					int largo = separa[yu].length();
					if(largo > 4 ){
						String sal1 = separa[yu].substring((largo - 2), largo);
						String sal2 = separa[yu].substring((largo - 1), largo);
						System.out.println("tienes es o s:  "+sal1+"\n");
						if(sal1.equals("es")  || sal1.equals("ss"))
						{
							cadena+= sal1 = separa[yu].substring(0, (largo - 2))+" ";
							System.out.println(" -1 "+sal1+"\n");									
						}else if(sal2.equals("s"))
						{
							cadena+= sal1 = separa[yu].substring(0, (largo - 1))+" ";
						    System.out.println(" -2 "+sal1+"\n");			
						}
					}else
					{
						cadena+= separa[yu]+" ";
					}		
		}
		for (int comenzar=0;comenzar<separa.length;comenzar++){
			int yi= comenzar;
			System.out.println("entrada:   "+ separa[yi]+"\n");
			int largo= separa[yi].length();
			if(largo>4){
				String sali= separa[yi].substring((largo - 3), largo);
				String salo= separa[yi].substring((largo - 4), largo);
				if(sali.equals("es")  ||  sali.equals("ss")){
					
					cadena+= sali=separa[yi].substring(0,(largo - 2))+"";
					System.out.println(" -1"+sali+"\n");
				}else if(salo.equals("s")){
					cadena+= sali = separa[yi].substring(0, (largo - 1))+" ";
				    System.out.println(" -2 "+sali+"\n");	
				}
			}else{
				 cadena+=separa[yi]+" ";
			}
		}
		System.out.println("total: "+separa.length
				+"producto final:  "+cadena+"\n");
		return cadena;
	}
	
	}
	