package pOp;

import gui.TranCotizacionAutomatica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class BuscarProdAlt extends JPanel implements ActionListener, KeyListener, MouseListener {

	public static  JTextField txtMarca2;
	private JLabel lblMarca2;
	public static  JTextField txtProducto2;
	private JLabel lblProducto2;
	private JTable tblLista;
	private JScrollPane scrLista;
	private JButton btnListar;
	private JButton btnBuscar;
	TranCotizacionAutomatica objTranCotAut;
	GUI objGUI;
	boolean valor=true;

	String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_PROD","NOM_PROD"};
			
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT,NOM_PRODALT;
	 //Global
	 String cod_producto;
	
	 
	public BuscarProdAlt() {
		try {
			//[846, 281]
			this.setPreferredSize(new java.awt.Dimension(846, 281));
			this.setBounds(10, 10, 240, 360);
			this.setLayout(null);

			btnBuscar = new JButton();
			this.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(247, 36, 117, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			this.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(441, 36, 117, 21);
			btnListar.addActionListener(this);

			scrLista = new JScrollPane();
			this.add(scrLista);
			scrLista.setBounds(12, 89, 824, 180);

			lblProducto2 = new JLabel();
			this.add(lblProducto2);
			lblProducto2.setText("Producto:");
			lblProducto2.setBounds(12, 12, 61, 14);

			txtProducto2 = new JTextField();
			this.add(txtProducto2);
			txtProducto2.setBounds(77, 9, 560, 21);
			txtProducto2.addKeyListener(this);

			lblMarca2 = new JLabel();
			this.add(lblMarca2);
			lblMarca2.setText("Marca:");
			lblMarca2.setBounds(641, 12, 56, 14);

			txtMarca2 = new JTextField();
			this.add(txtMarca2);
			txtMarca2.setBounds(701, 9, 133, 21);
			txtMarca2.addKeyListener(this);

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);
		

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
