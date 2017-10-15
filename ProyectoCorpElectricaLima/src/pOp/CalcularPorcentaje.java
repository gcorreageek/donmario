package pOp;
import gui.BuscarProducto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miLib.GUI;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class CalcularPorcentaje extends JPanel implements KeyListener, ActionListener {
	private JLabel lblCosto;
	private JLabel lblPrecio;
	private JButton btnCalcular;
	public static JTextField txtPorcentaje;
	private JLabel lblPorcentaje;
	public static JTextField txtDiferencia;
	public static JTextField txtPorcentajeAprox;
	public static JTextField txtPrecio;
	public static JTextField txtCosto;
	private JLabel lblDiferencia;
	private JLabel lblPorcentajeAprox;
	BuscarProducto objBProd;
	GUI objGUI;

	public CalcularPorcentaje() {
		try {
			
			this.setPreferredSize(new java.awt.Dimension(541, 124));
			this.setLayout(null);

			lblCosto = new JLabel();
			this.add(lblCosto);
			lblCosto.setText("Costo V:");
			lblCosto.setBounds(8, 52, 55, 16);

			lblPrecio = new JLabel();
			this.add(lblPrecio);
			lblPrecio.setText("Precio V:");
			lblPrecio.setBounds(329, 52, 53, 16);

			lblPorcentajeAprox = new JLabel();
			this.add(lblPorcentajeAprox);
			lblPorcentajeAprox.setText("% Aprox:");
			lblPorcentajeAprox.setBounds(8, 92, 73, 16);

			lblDiferencia = new JLabel();
			this.add(lblDiferencia);
			lblDiferencia.setText("Factor:");
			lblDiferencia.setBounds(190, 52, 45, 16);

			txtCosto = new JTextField();
			this.add(txtCosto);
			txtCosto.setBounds(60, 49, 112, 23);
			txtCosto.setForeground(new java.awt.Color(128,0,128));
			txtCosto.setBackground(new java.awt.Color(255,0,0));
			txtCosto.setEnabled(false);

			txtPrecio = new JTextField();
			this.add(txtPrecio);
			txtPrecio.setBounds(384, 49, 132, 23);
		
			txtPrecio.setForeground(new java.awt.Color(255,255,255));
			txtPrecio.setEnabled(false);
			txtPrecio.setBackground(new java.awt.Color(255,0,0));

			txtPorcentajeAprox = new JTextField();
			this.add(txtPorcentajeAprox);
			txtPorcentajeAprox.setBounds(61, 89, 76, 23);
			txtPorcentajeAprox.setEnabled(false);
			txtPorcentajeAprox.setForeground(new java.awt.Color(255,0,0));
			txtPorcentajeAprox.setBackground(new java.awt.Color(255,0,0));

			txtDiferencia = new JTextField();
			this.add(txtDiferencia);
			txtDiferencia.setBounds(235, 49, 76, 23);
			txtDiferencia.setEnabled(false);
			txtDiferencia.setBackground(new java.awt.Color(255,0,0));

			lblPorcentaje = new JLabel();
			this.add(lblPorcentaje);
			lblPorcentaje.setText("Porcentaje:");
			lblPorcentaje.setBounds(73, 17, 87, 16);

			txtPorcentaje = new JTextField();
			this.add(txtPorcentaje);
			txtPorcentaje.setBounds(148, 14, 63, 23);
			txtPorcentaje.addKeyListener(this);

			btnCalcular = new JButton();
			this.add(btnCalcular);
			btnCalcular.setText("Calcular");
			btnCalcular.setBounds(296, 14, 96, 23);

			btnCalcular.addActionListener(this);


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	public  Double formato2(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=2;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	void calcular(){
	
		double costo=Double.parseDouble(txtCosto.getText()),
		precio=Double.parseDouble(txtPrecio.getText()),dif=0;
		double porc=Double.parseDouble(txtPorcentaje.getText()),porcAprox=0;
		
		precio=(costo*porc)+costo;
		dif=formato(costo/precio);//1.779063   0.9499382540134891
		precio=costo/dif;
		porcAprox=formato2(((precio/costo)-1)*100);
		txtCosto.setText(""+costo);
		txtPrecio.setText(""+precio);
		txtDiferencia.setText(""+dif);
	    txtPorcentajeAprox.setText(""+porcAprox+"%");
	
	}
	

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCalcular){
			if(txtPorcentaje.getText().equals("")){
				//NADA
			}else{
			   calcular();
			}
			
		}
		
	}

}
