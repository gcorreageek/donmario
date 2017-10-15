package pOp;

import gui.TranCotizacionAutomatica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

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
public class BuscarTipoCot extends JPanel implements ActionListener, MouseListener, KeyListener {

	TranCotizacionAutomatica objTranCotAut;
	GUI objGUI;
	private JLabel lblBuscar;
	private JRadioButton rdbCotizacion;
	private JRadioButton rdbExcel;
	boolean valor=true;
	public static int selecciona=0;

	String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
	
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT,NOM_PRODALT;
	
	 //Global
	 String cod_producto;
	
	 
	public BuscarTipoCot() {
		try {
			this.setPreferredSize(new java.awt.Dimension(256, 37));
			this.setBounds(10, 10, 240, 360);
			this.setLayout(null);

			rdbExcel = new JRadioButton();
			this.add(rdbExcel);
			rdbExcel.setText("Excel");
			rdbExcel.setBounds(78, 12, 66, 18);
			rdbExcel.addActionListener(this);

			rdbCotizacion = new JRadioButton();
			this.add(rdbCotizacion);
			rdbCotizacion.setText("Cotizacion");
			rdbCotizacion.setBounds(149, 12, 89, 18);
			rdbCotizacion.addActionListener(this);

			lblBuscar = new JLabel();
			this.add(lblBuscar);
			lblBuscar.setText("Buscar:");
			lblBuscar.setBounds(12, 14, 54, 14);

			this.setVisible(true);
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==rdbCotizacion){
		rdbCotizacion.setSelected(true);
		rdbExcel.setSelected(false);
		selecciona=1;
	}else{
		rdbCotizacion.setSelected(false);
		rdbExcel.setSelected(true);
		selecciona=2;
	}
	
		
	}

	
	
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {}
	
	public void keyPressed(KeyEvent arg0) {}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {	}
	
	
	
	
	
	
	
	
	
	
	
}
