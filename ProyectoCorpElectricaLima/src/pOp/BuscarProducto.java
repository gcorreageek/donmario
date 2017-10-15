package pOp;
import gui.TranProducto;

import java.awt.BorderLayout;
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
public class BuscarProducto extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JTextField txtNombre;
	private JPanel pnlArriba;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JTable tblProducto;
	private JScrollPane scrProducto;

	 private JButton btnListar;
	String titulo2[]={"COD_PROD","NOM_PROD","OBS_PROD"};
	int veces=0;
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,NOM_MAR;
	 private JPanel pnlMedio;
	 private JButton btnCancelar;
	 private JButton btnAceptar;
	 private JPanel pnlAbajo;
	 TranProducto objProd;
	 String NOMBREPROD;

	 public BuscarProducto(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);

	    try{
			pnlArriba = new JPanel();

			pnlMedio = new JPanel();

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setBounds(0, 303, 751, 28);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(107, 21));
			btnAceptar.addMouseListener(this);
			btnAceptar.addKeyListener(this);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(107, 21));
			btnCancelar.addMouseListener(this);
			btnCancelar.addKeyListener(this);
			btnCancelar.addActionListener(this);

			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			pnlMedio.setBounds(0, 74, 748, 229);
			pnlMedio.setPreferredSize(new java.awt.Dimension(788, 293));

			scrProducto = new JScrollPane();
			pnlMedio.add(scrProducto);
			scrProducto.setBounds(19, 73, 718, 247);

			tblProducto = new JTable();
			scrProducto.setViewportView(tblProducto);
			tblProducto.setModel(modelo2);
			tblProducto.addKeyListener(this);
			tblProducto.addMouseListener(this);

			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			//pnlArriba.setLayout(pnlArribaLayout);
			pnlArriba.setBounds(0, 0, 748, 74);

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(21, 12, 53, 14);
			lblNombre.setPreferredSize(new java.awt.Dimension(71, 14));

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(79, 9, 450, 21);
			txtNombre.setPreferredSize(new java.awt.Dimension(489, 21));
			txtNombre.setText(objProd.NOMBRE_PROD);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(192, 36, 108, 26);
			btnBuscar.setPreferredSize(new java.awt.Dimension(95, 21));

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(326, 35, 101, 27);
			btnListar.setPreferredSize(new java.awt.Dimension(74, 21));
			btnListar.addActionListener(this);

			btnBuscar.addActionListener(this);

			txtNombre.addKeyListener(this);

			buscarProducto(txtNombre.getText());
			//setVisible(true);
			this.setSize(781, 425);
			//cargarMarcas();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	 

	/********BUSCAR PRODUCTO************************/
	public void buscarProducto(String nom){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		 //nom=txtNombre.getText();
		 NOMBREPROD=nom;
		
		/*if(cboMarca.getSelectedIndex()==0){
			NOM_MAR="293";
			NOM_MAR="";
		}else{
			NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
		}
		*/
		String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD,PROD.OBS_PROD " +
				"FROM tb_producto PROD  WHERE PROD.EST_PROD='ACTIVADO'" +
				"  AND  PROD.NOM_PROD LIKE '"+NOMBREPROD.trim()+"%'  ORDER BY PROD.COD_PROD; ";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3)
						
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	
	/********LISTAR PRODUCTO************************/
	public void listarProducto(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD,PROD.OBS_PROD" +
				" FROM tb_producto PROD WHERE PROD.EST_PROD='ACTIVADO'";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}

	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarProducto(){
		//Obtener fila seleccionada de la tabla
		int fila = tblProducto.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		COD_PROD=String.valueOf(cod);
		//String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		  NOM_PROD=(String)modelo2.getValueAt(fila, 1);
		txtNombre.setText(NOM_PROD);/*
		String cod_mar=(String) modelo2.getValueAt(fila, 2),nom_mar=(String)modelo2.getValueAt(fila, 3);
		NOM_MAR=nom_mar+"-"+cod_mar;
		cboMarca.setSelectedItem(NOM_MAR);*/
	}
	/***********************************************/
    public String actulizaNombre(String nom){
    	 String palabra="";
    	for(int i=0;i<nom.length()-1;i++){
    		palabra+=nom.charAt(i);
    	}
    	 return palabra;
    	
    }
	/***********************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar ){
			buscarProducto(txtNombre.getText());
		}
		if(e.getSource()==btnListar ){
		listarProducto();
		}
		if(e.getSource()==btnAceptar){
			cargarProducto();
			setVisible(false);
		}
		if(e.getSource()==btnCancelar){
			COD_PROD=null;
			setVisible(false);
		}
	}

	/***********EVENTOS DE CARGA PARA EL COMBOBOX MARCAS*************/

	public void mouseClicked(MouseEvent e) {
		//cargarComboBox();
		
		
	}
	/*****************************************************************/
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {if(e.getSource()==tblProducto){cargarProducto();}}
	public void mouseReleased(MouseEvent e) {}



	public void keyPressed(KeyEvent e) {
		
		if(e.getSource()==txtNombre) {
			String nom="";
			 int key = e.getKeyCode();
				if(KeyEvent.VK_DOWN==key){//flecha abajo
					
					NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
				}
	            else if(KeyEvent.VK_UP==key){//flecha abajo
	            	NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
				}
	            else if(KeyEvent.VK_LEFT==key){//flecha abajo
	            	NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
				}
	            else if(KeyEvent.VK_RIGHT==key){//flecha abajo
	            	NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
				}
				
	            else if(KeyEvent.VK_SHIFT==key){//flecha abajo
	            	NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
				}
	            else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("retroceso")){
				NOMBREPROD="";
				nom=actulizaNombre(txtNombre.getText().trim());
				System.out.println(nom);
				buscarProducto(nom);
			   }else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("introduzca")){
				
				NOMBREPROD="";
				nom=txtNombre.getText().trim();
				System.out.println(nom);
				buscarProducto(nom);
			    }else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("espacio")){
				
				NOMBREPROD="";
				nom=txtNombre.getText().trim();
				System.out.println(nom);
				buscarProducto(nom);
				
			  }else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("bloqueo de mayúsculas")){
					
					NOMBREPROD="";
					nom=txtNombre.getText().trim();
					System.out.println(nom);
					buscarProducto(nom);
					
			  }else{
				NOMBREPROD=txtNombre.getText().concat(e.getKeyText(e.getKeyCode()).toLowerCase());
				System.out.println(NOMBREPROD);
				buscarProducto(NOMBREPROD);
			 }
			  
		}
		
		if(e.getSource()==tblProducto){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				cargarProducto();
				setVisible(false);
			}
			if(KeyEvent.VK_TAB==key){
				
				btnAceptar.requestFocus();
				System.out.println("entra men!");
				//txtCompra.requestFocus();
			}
		}
	
		if(e.getSource()==btnAceptar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				cargarProducto();
				setVisible(false);
			}
			if(KeyEvent.VK_TAB==key){
				btnCancelar.requestFocus();
			}
		}
		if(e.getSource()==btnCancelar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				COD_PROD=null;
				setVisible(false);
			}
		}
		//KeyStroke.getKeyStroke("Ctrl C")
		//System.out.println(KeyStroke.getkey);
		System.out.println("ya:"+e.getKeyText(e.getKeyCode()));
		System.out.println("esto es "+NOMBREPROD);
		System.out.println("AAAAA:  "+e.getKeyText(e.getKeyCode()));
	
		/***********************************************************************************************/
		/*                                        BOTON "+"                                            */
		if(e.getKeyText(e.getKeyCode()).equals("+ de teclado numérico")){
		if(veces==0){
			this.setSize(1187, 566);
			veces=1;
		}else if(veces==1){
			this.setSize(1392, 652);
			veces=2;
			//1392,height=652
		}else if(veces==2){//width=1427,height=815
			this.setSize(1427, 815);
			veces=3;
		}else{
			this.setSize(917, 422);
			veces=0;
		}
		}
		/************************************************************************************************/
		/***********************************************************************************************/
		/*                                        BOTON "ESCAPE"                                      */
		if(e.getKeyText(e.getKeyCode()).equals("Escape")){
			NOM_PROD=null;
			setVisible(false);
			}
		/***********************************************************************************************/
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}

}
