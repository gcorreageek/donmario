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
import pOp.BuscarUmed;


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
public class MantUmedAlt extends JInternalFrame implements KeyListener, MouseListener, ActionListener  {
	private JPanel pnlPrincipal;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnIngresar;

	String cod_rub,nom_rub;
	double porcentaje;
	GUI objGUI;
	private JTextField txtUmedAlt;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton btnBuscarUmed;
	private JTextField txtUmed;
	private JLabel lblUmedAlt;
	private JLabel lblUmed;
	MenuPrincipal objMenuP;
	String COD_UMED,COD_UMEDALT,UMED,UMEDALT;
	String titulo2[]={"CUMED","NOMUMED","CUMEDALT","NOMUMEDALT"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	public MantUmedAlt() {
		super("Mant UmedAlt", true, true, true, true);
		try {
			
			this.setPreferredSize(new java.awt.Dimension(449, 351));
			this.setBounds(0, 0, 449, 351);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(434, 332));

			btnIngresar = new JButton();
			pnlPrincipal.add(btnIngresar);
			btnIngresar.setText("Ingresar");
			btnIngresar.setBounds(13, 69, 97, 21);
			btnIngresar.addActionListener(this);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(119, 69, 97, 21);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(230, 69, 97, 21);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(337, 69, 97, 21);
			
				lblUmed = new JLabel();
				pnlPrincipal.add(lblUmed);
				lblUmed.setText("Umed:");
				lblUmed.setBounds(12, 12, 65, 14);
			
				lblUmedAlt = new JLabel();
				pnlPrincipal.add(lblUmedAlt);
				lblUmedAlt.setText("Umed Alt:");
				lblUmedAlt.setBounds(12, 38, 65, 14);
			
				txtUmedAlt = new JTextField();
				pnlPrincipal.add(txtUmedAlt);
				txtUmedAlt.setBounds(77, 35, 357, 21);
				txtUmedAlt.addKeyListener(this);

				txtUmed = new JTextField();
				pnlPrincipal.add(txtUmed);
				txtUmed.setBounds(77, 9, 221, 21);
				txtUmed.addKeyListener(this);

				btnBuscarUmed = new JButton();
				pnlPrincipal.add(btnBuscarUmed);
				btnBuscarUmed.setText("Buscar Umed");
				btnBuscarUmed.setBounds(312, 9, 123, 21);
				btnBuscarUmed.addActionListener(this);

				jScrollPane1 = new JScrollPane();
				pnlPrincipal.add(jScrollPane1);
				jScrollPane1.setBounds(12, 101, 422, 221);
				
				
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(modelo2);
				jTable1.addMouseListener(this);

			btnBuscar.addActionListener(this);
			listarProductoAlt();
			setVisible(true);
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/********LISTAR PRODALT************************/
	public void listarProductoAlt(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*SELECT UMED.COD_UMED,UMED.NOM_UMED,UMEDALT.COD_UMEDALT,UMEDALT.NOM_UMEDALT
		  FROM tb_umed UMED INNER JOIN tb_umedALT UMEDALT
		  ON UMED.COD_UMED=UMEDALT.COD_UMED ORDER BY UMED.COD_UMED;*/
		String sql="SELECT UMED.COD_UMED,UMED.NOM_UMED,UMEDALT.COD_UMEDALT,UMEDALT.NOM_UMEDALT " +
				" FROM tb_umed UMED INNER JOIN tb_umedALT UMEDALT " +
				" ON UMED.COD_UMED=UMEDALT.COD_UMED WHERE UMEDALT.EST_UMEDALT='ACTIVADO' ORDER BY UMED.COD_UMED;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4)
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
	/********AGREGAR PRODALT************************/
	public void agregarUmedAlt(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_UMEDALT=txtUmedAlt.getText(),EST_UMEDALT="ACTIVADO";
	
		
			String insertarPregunta="INSERT INTO tb_umedALT VALUES("+null+",'"+COD_UMED+"','"
			+NOM_UMEDALT+"','"+EST_UMEDALT+"')";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un ERROR al Ingresar\nlos datos");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
			}else{
				objGUI.mostrarAviso("Se Ingreso Correctamente: \n " +
						"UMED Alternativo:"+NOM_UMEDALT+"\n ");
				System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
			}
		objAccesoBD.cerrarConexion();
		
		listarProductoAlt();
	}
	/***********************************************/
	/********MODIFICAR PRODALT**********************/
	public void modificarUmedAlt(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
			String sql="UPDATE tb_umedALT SET COD_UMED='"+COD_UMED+"' , " +
				"NOM_UMEDALT='"+txtUmedAlt.getText()+"'  " +
				" WHERE COD_UMEDALT="+COD_UMEDALT+";";
			System.out.println(sql);
			int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){objGUI.mostrarAviso("Hubo un ERROR al Modificar\nlos datos");
			
		}else{
			objGUI.mostrarAviso("Se Modifico Correctamente: \n " +
					"uMED Alternativo:"+txtUmedAlt.getText()+"\n ");
		}
			objAccesoBD.cerrarConexion();	
		
		listarProductoAlt();
	}
	
	/***********************************************/

	/********ELIMINAR PRODALT**********************/
	public void eliminarUmedAlt(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="UPDATE tb_umedALT SET EST_UMEDALT='DESACTIVADO' " +
				   " WHERE COD_UMEDALT="+COD_UMEDALT+";";
		System.out.println(sql);

		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){objGUI.mostrarAviso("Hubo un ERROR al Eliminar\nlos datos");
		}else{
			objGUI.mostrarAviso("Se Elimino Correctamente: \n " +
					"UMED Alternativo:"+txtUmedAlt.getText()+"\n ");
		}
		
		objAccesoBD.cerrarConexion();	
		listarProductoAlt();
	}
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargaruMEDAlt(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		//Cargar los datos de la fila seleccionada al panel de datos
		COD_UMED=""+ modelo2.getValueAt(fila, 0);
		COD_UMED=COD_UMED.trim();
		txtUmed.setText(""+modelo2.getValueAt(fila, 1));
		COD_UMEDALT=""+modelo2.getValueAt(fila, 2);
		COD_UMEDALT=COD_UMEDALT.trim();
		txtUmedAlt.setText(""+modelo2.getValueAt(fila, 3));

	}
	/***********************************************/
	/***********************************************/
	/********BUSCAR PRODALT************************/
	public void buscarUmedAlt(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String nomProd=txtUmed.getText();
		/*SELECT PROD.COD_PROD, PROD.NOM_PROD, ALT.COD_PRODALT, ALT.NOM_PRODALT FROM
		 PRODUCTO PROD INNER JOIN PRODUCTOALTER ALT
		 ON PROD.COD_PROD=ALT.COD_PRODALT
		 WHERE PROD.COD_PROD='' AND ALT.NOM_PRODALT='';*/
		String sql="SELECT UMED.COD_UMED,UMED.NOM_UMED,UMEDALT.COD_UMEDALT,UMEDALT.NOM_UMEDALT " +
				" FROM tb_umed UMED INNER JOIN tb_umedALT UMEDALT " +
				" ON UMED.COD_UMED=UMEDALT.COD_UMED WHERE UMEDALT.EST_UMEDALT='ACTIVADO'" +
				" AND  UMED.NOM_UMED LIKE '%"+nomProd+"%' "+
				" AND UMEDALT.NOM_UMEDALT LIKE '%"+txtUmedAlt.getText()+"%' " +
				" ORDER BY UMED.COD_UMED;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4)};
				modelo2.addRow(obj);}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	
	
	public void buscarUmed(){
		BuscarUmed objBuscarUmed = new BuscarUmed(objMenuP);
		//PruebaJDialog dialogoModal = new PruebaJDialog(objMenuP);
		
		objBuscarUmed.setVisible(true);
		//this.setSize(920, 422);
		//dialogoModal.setSize(920, 422);
		objBuscarUmed.pack();  // para darle tamaño automático a la ventana.
		if(objBuscarUmed.NOM_UMED==null){
			System.out.println("ENTRO AL NULL");
		}else{//ACEPTAR 
	
			txtUmed.setText(objBuscarUmed.NOM_UMED);
			COD_UMED=objBuscarUmed.COD_UMED;
	}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIngresar){
			agregarUmedAlt();
		}
		if(e.getSource()==btnModificar){
			modificarUmedAlt();
		}
		if(e.getSource()==btnEliminar){
			eliminarUmedAlt();
		}
		if(e.getSource()==btnBuscar){
			buscarUmedAlt();
		}
		if(e.getSource()==btnBuscarUmed){
			buscarUmed();
		}
		
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseClicked(MouseEvent e) {
	if(e.getSource()==jTable1){
		cargaruMEDAlt();
	}
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
