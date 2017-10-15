package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
public class MantMarcas extends JInternalFrame implements KeyListener, ActionListener, MouseListener {
	private JPanel pnlPrincipal;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JScrollPane scrLista;
	private JButton btnModificar;
	private JButton btnIngreso;
	private JLabel lblMarca;
	private JTextField txtMarca;

	String cod_mar,nom_mar;
	private JTable jTable1;
	GUI objGUI;

	String titulo2[]={"COD_MARCA","NOM_MARCA"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public MantMarcas() {
		super("Mant Marca", true, true, true, true);
		try {
			
			this.setPreferredSize(new java.awt.Dimension(434, 276));
			this.setBounds(0, 0, 434, 276);

			pnlPrincipal = new JPanel();
			pnlPrincipal.setLayout(null);
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(359, 255));

			txtMarca = new JTextField();
			pnlPrincipal.add(txtMarca);
			txtMarca.setBounds(69, 9, 357, 21);
			txtMarca.addKeyListener(this);

			lblMarca = new JLabel();
			pnlPrincipal.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(12, 12, 50, 14);

			btnIngreso = new JButton();
			pnlPrincipal.add(btnIngreso);
			btnIngreso.setText("Ingreso");
			btnIngreso.setBounds(12, 38, 89, 21);
			btnIngreso.addActionListener(this);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(112, 38, 91, 21);
			btnModificar.addActionListener(this);

			scrLista = new JScrollPane();
			pnlPrincipal.add(scrLista);
			scrLista.setBounds(7, 64, 419, 179);

			
			jTable1 = new JTable();
			scrLista.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(224, 38, 93, 21);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(328, 38, 93, 21);
			btnBuscar.addActionListener(this);
			setVisible(true);
			pack();
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
			//COD_MAR, NOM_MAR, EST_MAR
			String sql="SELECT COD_MAR, NOM_MAR FROM tb_marcas WHERE EST_MAR='ACTIVADO' " +
					" order by nom_mar asc;";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2)};
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
//			String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			Calendar c = new GregorianCalendar();
			String dia, mes, annio;
			dia = Integer.toString(c.get(Calendar.DATE));
			mes = Integer.toString(c.get(Calendar.MONTH));
			annio = Integer.toString(c.get(Calendar.YEAR));
			String FEC=annio+"-"+mes+"-"+dia;
			
			
			String NOM_MARCA=txtMarca.getText();
		
	//COD_PROD, NOM_PROD, COD_RUBRO, OBS_PROD, EST_PROD
			String insertarPregunta="INSERT INTO tb_marcas VALUES("+null+",'"+NOM_MARCA+"','ACTIVADO')";
			System.out.println("ESTO SALE ANTES DE INGRESAR Y ERROR:"+insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un error a Ingresar LA MARCA");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
			else{
				objGUI.mostrarAviso("Se a ingresado satisfactoriamenete LA MARCA");
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
//			String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
			
			String NOM_MARCA=txtMarca.getText();
			
			
				String sql="UPDATE tb_marcas SET NOM_MAR='"+NOM_MARCA+"' " +
					" WHERE COD_mar='"+cod_mar+"';";
			System.out.println(sql);

			int op= objAccesoBD.ejecutarActualizacion(sql);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un error AL modificar la marca");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
			else{
				objGUI.mostrarAviso("Se a modificado  LA MARCA");
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
			String sql="UPDATE tb_marcas SET EST_MAR='DESACTIVADO' " +
			" WHERE COD_mar='"+cod_mar+"';";
			System.out.println(sql);

			int op= objAccesoBD.ejecutarActualizacion(sql);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un error al eliminar la marca");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
			else{
				objGUI.mostrarAviso("Se a eliminado  la marca");
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
			String nom_mar=txtMarca.getText(),EST_PROD="ACTIVADO";
			//String NOM_MAR=(String)cboMarca.getSelectedItem();
			/*if(cboMarca.getSelectedIndex()==0){
				NOM_MAR="293";
				NOM_MAR="";
			}else{
				NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
			}*/
			//NOM_MAR="";UMED_PROD="";
		
			
			String sql=" SELECT COD_MAR, NOM_MAR FROM  tb_marcas " +
					" WHERE  nom_mar LIKE '%"+nom_mar.trim()+"%' AND EST_MAR='ACTIVADO' " +
							" order by nom_mar asc;" ;
			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2)
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
			cod_mar=""+cod;
			cod_mar=cod_mar.trim();
			nom_mar=  modelo2.getValueAt(fila, 1).toString();
			txtMarca.setText(nom_mar);
		}
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getSource()==txtMarca){
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
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnIngreso){
				agregarProducto();
			}
			if(e.getSource()==btnEliminar){
				eliminarProducto();
			}
			if(e.getSource()==btnModificar){
				
				modificarProducto();
			}
			if(e.getSource()==btnBuscar){
				buscarProducto();
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
			if(arg0.getSource()==jTable1){
				cargarProducto();
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		/********PARA CARGAR LOS DATOS DEL TABLA********/


}
