package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
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
public class MantRubro extends JInternalFrame implements KeyListener, MouseListener, ActionListener {
	private JPanel pnlPrincipal;
	private JTable jTable1;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnIngresar;
	private JScrollPane scrListado;
	private JTextField txtPorcentaje;
	private JLabel lblPorcentaje;
	private JTextField txtRubro;
	private JLabel lblRubro;

	String cod_rub,nom_rub;
	double porcentaje;
	GUI objGUI;

	String titulo2[]={"COD","NOM_RUBRO","PORCENTAJE"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	public MantRubro() {
		super("Mant Rubro", true, true, true, true);
		try {
			
			this.setPreferredSize(new java.awt.Dimension(395, 355));
			this.setBounds(0, 0, 395, 355);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(381, 324));

			lblRubro = new JLabel();
			pnlPrincipal.add(lblRubro);
			lblRubro.setText("Rubro");
			lblRubro.setBounds(17, 12, 74, 14);

			txtRubro = new JTextField();
			pnlPrincipal.add(txtRubro);
			txtRubro.setBounds(102, 9, 270, 21);
			txtRubro.addKeyListener(this);

			lblPorcentaje = new JLabel();
			pnlPrincipal.add(lblPorcentaje);
			lblPorcentaje.setText("%Ganancia:");
			lblPorcentaje.setBounds(16, 36, 73, 14);

			txtPorcentaje = new JTextField();
			pnlPrincipal.add(txtPorcentaje);
			txtPorcentaje.setBounds(101, 33, 270, 21);

			scrListado = new JScrollPane();
			pnlPrincipal.add(scrListado);
			scrListado.setBounds(10, 101, 371, 218);
			scrListado.addMouseListener(this);

			
			jTable1 = new JTable();
			scrListado.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			btnIngresar = new JButton();
			pnlPrincipal.add(btnIngresar);
			btnIngresar.setText("Ingresar");
			btnIngresar.setBounds(6, 69, 84, 21);
			btnIngresar.addActionListener(this);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(108, 69, 84, 21);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(203, 69, 84, 21);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(298, 69, 84, 21);
			btnBuscar.addActionListener(this);
			setVisible(true);
			listarProducto();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void listarProducto(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","COD_RUBRO","RUBRO","OBS_PROD"};
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*
		 SELECT PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR,PROD.UMED_PROD,RUB.COD_RUBRO,RUB.NOM_RUBRO,PROD.OBS_PROD
  		FROM PRODUCTO PROD INNER JOIN MARCAS MAR
         ON PROD.COD_MAR=MAR.COD_MAR
          INNER JOIN RUBRO RUB
          ON RUB.COD_RUBRO=PROD.COD_RUBRO
         WHERE PROD.EST_PROD='ACTIVADO';*/
		String sql="SELECT COD_RUBRO, NOM_RUBRO, POR_RUBRO FROM tb_rubro WHERE EST_RUBRO='ACTIVADO' " +
				" order by nom_rubro;";
		//COD_RUBRO, NOM_RUBRO, POR_RUBRO, EST_RUBRO
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
	/***********************************************/

	/********AGREGAR PRODUCTO************************/
	public void agregarProducto(){
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		
		String NOM=txtRubro.getText();
		NOM=NOM.trim();
		double porce=Double.parseDouble(txtPorcentaje.getText());
//COD_PROD, NOM_PROD, COD_RUBRO, OBS_PROD, EST_PROD
		String insertarPregunta="INSERT INTO tb_rubro VALUES("+null+",'"+NOM+"',"+porce+",'ACTIVADO');";
		System.out.println("ESTO SALE ANTES DE INGRESAR Y ERROR:"+insertarPregunta);

		int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error a Ingresar el rubro");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a ingresado satisfactoriamenete el rubro");
			System.out.println("　　　　 GRACIAS insertar producto !!!!!!!");
			}
		//objAccesoBD.cerrarConexion();
	objAccesoBD.cerrarConexion();
			
		listarProducto();
	
		
	}
	/********MODIFICAR PRODUCTO**********************/
	public void modificarProducto(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		String NOM=txtRubro.getText();
		NOM=NOM.trim();
		double porce=Double.parseDouble(txtPorcentaje.getText());
		
			String sql="UPDATE tb_rubro SET nom_rubro='"+NOM+"', por_rubro='"+porce+"' " +
				" WHERE COD_rubro='"+cod_rub+"';";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error AL modificar el rubro");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a modificado  el rubro");
			System.out.println("　　　　 GRACIAS insertar product0 !!!!!!!");}
		
		objAccesoBD.cerrarConexion();	
	
		
		listarProducto();
	}
	/*************************************************************/
	/********ELIMINAR PRODUCTO**********************/
	public void eliminarProducto(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String est="DESACTIVADO";
		String sql="UPDATE tb_rubro SET  EST_RUBRO='"+est+"' " +
		" WHERE COD_rubro='"+cod_rub+"';";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al eliminar el rubro");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a eliminado  el rubro");
			System.out.println("　　　　 GRACIAS eliminar product0 !!!!!!!");
			}
		
		objAccesoBD.cerrarConexion();	
		listarProducto();
	}
	/***********************************************/

	/********BUSCAR PRODUCTO************************/
	public void buscarProducto(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM=txtRubro.getText(),EST_PROD="ACTIVADO";
		NOM=NOM.trim();
		//String NOM_MAR=(String)cboMarca.getSelectedItem();
		/*if(cboMarca.getSelectedIndex()==0){
			NOM_MAR="293";
			NOM_MAR="";
		}else{
			NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
		}*/
		//NOM_MAR="";UMED_PROD="";
	
		String sql=" SELECT COD_RUBRO, NOM_RUBRO, POR_RUBRO from tb_rubro " +
				" WHERE  nom_rubro LIKE '%"+NOM.trim()+"%' AND EST_RUBRO='ACTIVADO' " +
				" order by nom_rubro;" ;
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
	/***********************************************/

	public void cargarProducto(){
		//String cod_mar,nom_mar;
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+ modelo2.getValueAt(fila, 0));
		cod_rub=""+cod;
		cod_rub=cod_rub.trim();
		nom_rub=  modelo2.getValueAt(fila, 1).toString();
		txtRubro.setText(nom_rub);
		porcentaje=Double.parseDouble(""+modelo2.getValueAt(fila, 2)) ;
		txtPorcentaje.setText(""+porcentaje);
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()==txtRubro){
			buscarProducto();
		}
		
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
		if(arg0.getSource()==jTable1){
			cargarProducto();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIngresar){
			agregarProducto();
		}
		if(e.getSource()==btnModificar){
			
			modificarProducto();
		}
		if(e.getSource()==btnEliminar){
		eliminarProducto();	
		}
		if(e.getSource()==btnBuscar){
		buscarProducto();	
		}
		
		
	}

}
