package pOp;
import gui.MantProveedor;

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
import servlet.ServletProveRubro;

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
public class BuscarTipoCliente extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblddd;
	private JScrollPane jScrollPane1;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JTable jTable1;
	private JPanel pnlCentro;

	String titulo2[]={"COD_TIPO","NOM_TIPO"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletProveRubro objProRub = new ServletProveRubro();
	int cod;
	MantProveedor objmant;
	GUI objGUI;
	public static int verificar=0;
	
	
	public BuscarTipoCliente(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(396, 318);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(756, 83));

			btnAgregar = new JButton();
			pnlArriba.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(22, 46, 108, 26);

			btnModificar = new JButton();
			pnlArriba.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(142, 46, 107, 26);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlArriba.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(260, 46, 108, 26);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(261, 14, 108, 26);
			btnBuscar.addActionListener(this);

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Tipo Cliente:");
			lblNombre.setBounds(22, 19, 73, 16);

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(95, 15, 154, 25);
			

			btnAgregar.addActionListener(this);

			pnlAbajo = new JPanel();
			FlowLayout pnlAbajoLayout = new FlowLayout();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setLayout(pnlAbajoLayout);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(756, 35));

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(576, 46, 106, 26);
			btnAceptar.setBackground(new java.awt.Color(255,0,0));
			btnAceptar.setPreferredSize(new java.awt.Dimension(85, 26));
			btnAceptar.addActionListener(this);

			pnlCentro = new JPanel();
			GridLayout pnlCentroLayout = new GridLayout(1, 1);
			pnlCentroLayout.setColumns(1);
			pnlCentroLayout.setHgap(5);
			pnlCentroLayout.setVgap(5);
			getContentPane().add(pnlCentro, BorderLayout.CENTER);
			pnlCentro.setLayout(pnlCentroLayout);
			pnlCentro.setPreferredSize(new java.awt.Dimension(756, 308));

			jScrollPane1 = new JScrollPane();
			pnlCentro.add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(824, 226));


			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			
			listarTipoCliente();
			

		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	
	
	/********LISTAR PROVEEDOR-RUBRO************************/
	public void listarTipoCliente(){	
		
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT COD_TIPO, NOM_TIPO FROM tb_tipocliente WHERE EST_TIPO='ACTIVADO' " +
				" ORDER BY NOM_TIPO;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		
	}

     /***********************************************************************************************/
     public void buscarTipoCliente(){	
		
    	int n=modelo2.getRowCount();
 		for (int fila=0; fila<n; fila++)
 		modelo2.removeRow(0);
 		
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		String NOM=txtNombre.getText();
 		NOM=NOM.trim();
 		
 		String sql=" SELECT COD_TIPO, NOM_TIPO from tb_tipocliente " +
 				" WHERE  nom_TIPO LIKE '%"+NOM+"%' AND EST_TIPO='ACTIVADO' ORDER BY NOM_TIPO;" ;
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
     /***************************************************************************************************/
     public void eliminarTipoCliente(){
    	
    	 try {
    		   AccesoBD objAccesoBD=  new AccesoBD();
    	 		objAccesoBD.crearConexion();
    	 	
    	 		String sql="UPDATE tb_tipocliente set est_tipo='DESACTIVADO' " +
    	 		" WHERE cod_tipo='"+cod+"';";
    	 		System.out.println(sql);

    	 		
    	 		int op=objAccesoBD.ejecutarActualizacion(sql);
    	 		if(op==0){
    	 			objGUI.mostrarAviso("Debe Seleccionar el Dato a Eliminar");
    	 		}else{
    	 			objGUI.mostrarAviso("Se Elimino Correctamente ");
    	 			verificar=1;
    	 			
    	 		}
    	 		objAccesoBD.cerrarConexion();	
			
		} catch (Exception e) {
			objGUI.mostrarAviso("Debe Seleccionar el Dato a Eliminar");
		}
    	
 	
 	}
 
     /********AGREGAR RUBRO AL PROVEEDOR************************/
 	 public void agregarTipoCliente(){
 		 
 		String nom=txtNombre.getText();
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		
 		String insertarPregunta="INSERT INTO tb_tipocliente(nom_tipo, est_tipo)" +
 					" VALUES('"+nom+"','ACTIVADO');";
 			System.out.println(insertarPregunta);

 			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
 			//System.out.println(insertarPregunta);
 			if(op==0){
 				objGUI.mostrarAviso("Hubo un ERROR al Imgresar los datos");
 				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
 			}	
 			else{
 				objGUI.mostrarAviso("Se ingreso Correctamente ");
 				verificar=1;
 				System.out.println("　　　　 GRACIAS TOTALES !!!!!!!");
 			}
 			//objAccesoBD.cerrarConexion();
 		objAccesoBD.cerrarConexion();	
 		
 	}
    /********************************************************************************************************/
     public void modificarTipoCliente(){
    	 
    	 try {
    		 
 	 	String nom=txtNombre.getText();
  		AccesoBD objAccesoBD=  new AccesoBD();
  		objAccesoBD.crearConexion();
  			
  			String sql="UPDATE tb_tipocliente SET " +
  				"nom_tipo='"+nom+"' "+
  				" WHERE cod_tipo='"+cod+"';";
  		System.out.println(sql);

  		int op=objAccesoBD.ejecutarActualizacion(sql);
  		if(op==0){
  			objGUI.mostrarAviso("Hubo un ERROR al Modificar los datos");
  		}else{
  			objGUI.mostrarAviso("Se Modificaron Correctamente ");	
  			verificar=1;
  		}
  		objAccesoBD.cerrarConexion();	
			
		} catch (Exception e) {
			objGUI.mostrarAviso("Debe Seleccionar los datos a Modificar");
		}
    	
 		
 	}

 	/***********************************************/
     public void limpia(){
    	txtNombre.setText("");
    	listarTipoCliente();
 	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==btnAceptar){
			setVisible(false);
		}
		
		if(e.getSource()==btnAgregar){
			agregarTipoCliente();
			limpia();
		}
		
		if(e.getSource()==btnModificar){
			modificarTipoCliente();
			limpia();
		}
		
        if(e.getSource()==btnBuscar){
        	buscarTipoCliente();
		}
		
		if(e.getSource()==btnEliminar){
			eliminarTipoCliente();
			limpia();
		}

		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		
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
	public void mousePressed(MouseEvent e) {
        
		if(e.getSource()==jTable1){
			MouseEvent evento=e;
			int fila = jTable1.getSelectedRow();
	 		int codigo=Integer.parseInt(""+modelo2.getValueAt(fila, 0));
			if(evento.getClickCount()==1){
				
			cod=codigo;
			txtNombre.setText((String)modelo2.getValueAt(fila, 1));
	
			}
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
