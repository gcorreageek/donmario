package pOp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.GUI;
import servlet.ServletProdAltCogido;

import com.cloudgarden.layout.AnchorConstraint;


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
public class BuscarUmed extends JDialog implements MouseListener, ActionListener, KeyListener {
	private JLabel lblProducto2;
	private JPanel pnlMedio;
	private JButton btnListar;
	private JButton btnBuscar;
	private JTextField txtUmed;
	private JLabel lblUmed;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTable tblLista;
	private JScrollPane scrLista;
	static public JTextField txtAlternativo;
	static public JTextField txtMarca2;
	GUI objGUI;
	boolean valor=true;
	boolean valor2=false;
	public static JButton botones[] = new JButton[2];

	ServletProdAltCogido objServletProdAltCog= new 	ServletProdAltCogido();
	String titulo2[]={"Cumed","Umed"};
	
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_UMED,NOM_UMED;
	 
	 //Global
	 String cod_producto;
	 int veces=0;
	public BuscarUmed(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);
		
		try {
			this.setPreferredSize(new java.awt.Dimension(520, 279));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);

			pnlArriba = new JPanel();
			FlowLayout pnlArribaLayout = new FlowLayout();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(514, 62));

			lblProducto2 = new JLabel();
			pnlArriba.add(lblProducto2);
			lblProducto2.setText("Alternativo:");
			lblProducto2.setVisible(false);
			lblProducto2.setBounds(6, 35, 65, 14);

			txtMarca2 = new JTextField();
			pnlArriba.add(txtMarca2);
			txtMarca2.setVisible(false);
			txtMarca2.setBounds(637, 5, 133, 22);
			txtMarca2.addKeyListener(this);

			txtAlternativo = new JTextField();
			pnlArriba.add(txtAlternativo);
			txtAlternativo.setVisible(false);
			txtAlternativo.setBounds(77, 31, 548, 21);

			lblUmed = new JLabel();
			pnlArriba.add(lblUmed);
			lblUmed.setText("Umedida:");
			lblUmed.setBounds(26, 12, 74, 14);

			txtUmed = new JTextField();
			pnlArriba.add(txtUmed);
			txtUmed.setBounds(100, 9, 389, 21);
			txtUmed.addKeyListener(this);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(118, 36, 117, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(302, 36, 117, 21);
			btnListar.addActionListener(this);

			txtAlternativo.addKeyListener(this);
			txtAlternativo.addActionListener(this);

			pnlMedio = new JPanel();
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			pnlMedio.setPreferredSize(new java.awt.Dimension(924, 144));

			scrLista = new JScrollPane();
			pnlMedio.add(scrLista);
			pnlMedio.add(scrLista, new AnchorConstraint(-864, 1014, 1100, -11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			scrLista.setPreferredSize(new java.awt.Dimension(918, 73));

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);
			tblLista.addKeyListener(this);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(275, 355, 114, 21);
			btnAceptar.setPreferredSize(new java.awt.Dimension(136, 21));
			btnAceptar.addMouseListener(this);
			btnAceptar.addKeyListener(this);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(518, 355, 114, 21);
			btnCancelar.setPreferredSize(new java.awt.Dimension(136, 21));
			btnCancelar.addMouseListener(this);
			btnCancelar.addKeyListener(this);
			btnCancelar.addActionListener(this);

			listarUmed();
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void listarUmed(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_UMED,NOM_UMED FROM tb_umed WHERE EST_UMED='ACTIVADO';" ;

		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
	//String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
	//
				Object obj[]={rs.getInt(1),rs.getString(2)};
				
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	
	public void buscarDetalle(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_UMED=txtUmed.getText();

		String sql="SELECT COD_UMED,NOM_UMED FROM tb_umed " +
				" WHERE EST_UMED='ACTIVADO' AND NOM_UMED LIKE '%"+NOM_UMED+"%';" ;

		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2)};
				
				modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		
	}
	public void cargarProdAlternativo(){
		//Obtener fila seleccionada de la tabla
		int fila = tblLista.getSelectedRow();
		/*String titulo2[]={"COD","PRODUCTO","COSTE","CMAR","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
		 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
		 public static String  COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT,NOM_PRODALT;
		 */
		 COD_UMED=""+ modelo2.getValueAt(fila, 0);
		 NOM_UMED=""+ modelo2.getValueAt(fila, 1);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnListar){
			listarUmed();
		}
		if(e.getSource()==btnBuscar){
			buscarDetalle();
		}
		if(e.getSource()==btnAceptar){
			cargarProdAlternativo();
			setVisible(false);
		}
		if(e.getSource()==btnCancelar){
			NOM_UMED=null;
			setVisible(false);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtUmed){
			buscarDetalle();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
