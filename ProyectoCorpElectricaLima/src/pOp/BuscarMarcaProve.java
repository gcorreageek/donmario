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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.GUI;
import servlet.ServletProveMarcas;
import beans.BeanProveMarcas;

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
public class BuscarMarcaProve extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblddd;
	private JScrollPane jScrollPane1;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JComboBox cboMarcas;
	private JButton btnListar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JLabel lblRubro;
	private JTable jTable1;
	private JPanel pnlCentro;
	private JCheckBox chkMarca;
	
	String titulo2[]={"CODIGO_PROVEEDOR","NOMBRE_PROVEEDOR","NOMBRE_MARCA"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletProveMarcas objProMar = new ServletProveMarcas();
	int codigoProvMar,cod,codrubro,est,verificar;
	String CODPROVE;
	MantProveedor objmant;
	GUI objGUI;
	
	
	public BuscarMarcaProve(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(726, 318);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(756, 83));

			lblRubro = new JLabel();
			pnlArriba.add(lblRubro);
			lblRubro.setText("Marcas:");
			lblRubro.setBounds(26, 51, 46, 16);

			btnAgregar = new JButton();
			pnlArriba.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(456, 14, 108, 26);

			btnModificar = new JButton();
			pnlArriba.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(575, 14, 107, 26);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlArriba.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(576, 46, 106, 26);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(335, 46, 108, 26);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(456, 46, 109, 26);
			btnListar.addActionListener(this);

			cboMarcas = new JComboBox();
			pnlArriba.add(cboMarcas);
			cboMarcas.addItem("");
			cboMarcas.setBounds(78, 47, 229, 25);
			cboMarcas.addActionListener(this);

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(22, 19, 57, 16);

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(79, 15, 365, 25);
			txtNombre.setText(objmant.nomprove);

			chkMarca = new JCheckBox();
			pnlArriba.add(chkMarca);
			chkMarca.setBounds(309, 51, 21, 21);

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
			
			listarProveMarXCod();
			cargarMarcas();
			verificar=0;

		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	/********LISTAR PROVEEDOR-RUBRO************************/
	public void listarProveMarcas(){
		
		objProMar.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="select provemar.cod_provemar,provemar.cod_prove,prove.NOM_PROVE,provemar.cod_mar,mar.NOM_MAR "+
            "from tb_proveemar provemar inner join tb_proveedor prove "+
            "on provemar.cod_prove = prove.COD_PROVE "+
            "inner join tb_marcas mar "+
            "on provemar.cod_mar = mar.COD_MAR "+
            "order by prove.nom_prove asc;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveMarcas objBean=new BeanProveMarcas(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	       objProMar.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProMar.tamaño(); i++) {
			BeanProveMarcas objBean=objProMar.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
	
	/********LISTAR PROVEEDOR-MARCA************************/
	public void listarProveMarXCod(){	
		
		objProMar.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objmant=new MantProveedor();
		codigoProvMar=objmant.codprovemar;
		
		String sql="select provemar.cod_provemar,provemar.cod_prove,prove.NOM_PROVE,provemar.cod_mar,mar.NOM_MAR "+
            "from tb_proveemar provemar inner join tb_proveedor prove "+
            "on provemar.cod_prove = prove.COD_PROVE "+
            "inner join tb_marcas mar "+
            "on provemar.cod_mar = mar.COD_MAR "+
            "where provemar.cod_prove='"+codigoProvMar+"' " +
            "order  by mar.nom_mar asc;";
			
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveMarcas objBean=new BeanProveMarcas(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	       objProMar.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProMar.tamaño(); i++) {
			
			BeanProveMarcas objBean=objProMar.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
	/********************************Cargar Marcas***************************************************/
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_marcas WHERE EST_MAR='ACTIVADO' order by nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
				cboMarcas.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();	
	}
	/***********************************************************************************************/
     public void buscarProveMarXMarca(){	
		
    	est=2;
		objProMar.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objmant=new MantProveedor();
		String codMarcas=""+cboMarcas.getSelectedItem();
		codMarcas=codMarcas.substring(codMarcas.indexOf("-")+1,codMarcas.length() );
		
		
		String sql="select provemar.cod_provemar,provemar.cod_prove,prove.NOM_PROVE,provemar.cod_mar,mar.NOM_MAR "+
            "from tb_proveemar provemar inner join tb_proveedor prove "+
            "on provemar.cod_prove = prove.COD_PROVE "+
            "inner join tb_marcas mar "+
            "on provemar.cod_mar = mar.COD_MAR "+
            "where mar.COD_MAR ='"+codMarcas+"' "+
            "order by prove.nom_prove asc; ";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveMarcas objBean=new BeanProveMarcas(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objProMar.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProMar.tamaño(); i++) {
			BeanProveMarcas objBean=objProMar.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***********************************************************************************************/
     public void buscarProveMarXProveedor(){	
		
    	est=1;
		objProMar.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objmant=new MantProveedor();
		String nomProvee=""+txtNombre.getText().trim();
		
		String sql="select provemar.cod_provemar,provemar.cod_prove,prove.NOM_PROVE,provemar.cod_mar,mar.NOM_MAR "+
                    "from tb_proveemar provemar inner join tb_proveedor prove "+
			        "on provemar.cod_prove = prove.COD_PROVE "+
			        "inner join tb_marcas mar "+
			        "on provemar.cod_mar = mar.COD_MAR "+
			        "where prove.nom_prove like '%"+nomProvee+"%' " +
                    "order by mar.nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveMarcas objBean=new BeanProveMarcas(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objProMar.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProMar.tamaño(); i++) {
			BeanProveMarcas objBean=objProMar.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***************************************************************************************************/
     public void eliminarMarcaProveedor(){
    	
    	 try {
    		 int fila = jTable1.getSelectedRow();
    	 		BeanProveMarcas objProveMarca=objProMar.obtener(fila) ;
    	 		
    	 		cod=(objProveMarca.getCod_proveemar());
    	 		AccesoBD objAccesoBD=  new AccesoBD();
    	 		objAccesoBD.crearConexion();
    	 	
    	 		String sql="DELETE FROM  tb_proveemar " +
    	 		" WHERE cod_provemar='"+cod+"';";
    	 		System.out.println(sql);

    	 		
    	 		int op=objAccesoBD.ejecutarActualizacion(sql);
    	 		if(op==0){
    	 			objGUI.mostrarAviso("Debe Seleccionar el Dato a Eliminar");
    	 		}else{
    	 			objGUI.mostrarAviso("Se Elimino Correctamente ");
    	 			
    	 		}
    	 		objAccesoBD.cerrarConexion();	
			
		} catch (Exception e) {
			objGUI.mostrarAviso("Debe Seleccionar el Dato a Eliminar");
		}
    	
 	
 	}
 
     /********AGREGAR MARCA AL PROVEEDOR************************/
 	 public void agregarMarcaProveedor(){
 		 
 		 if(verificar==0){
 			objmant=new MantProveedor();
			CODPROVE=""+objmant.codprovemar;
			est=1;
 		 }
 		 
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		
 		String COD_MAR=""+cboMarcas.getSelectedItem(),EST_PROVEMAR="ACTIVADO";
 		COD_MAR=COD_MAR.substring(COD_MAR.indexOf("-")+1,COD_MAR.length());
 		
 		String insertarPregunta="INSERT INTO tb_proveemar(cod_prove, cod_mar, est_provemar)" +
 					" VALUES('"+CODPROVE+"','"+COD_MAR+"','"+EST_PROVEMAR+"');";
 			System.out.println(insertarPregunta);

 			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
 			//System.out.println(insertarPregunta);
 			if(op==0){
 				objGUI.mostrarAviso("Hubo un ERROR al Imgresar los datos");
 				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");	
 			}	
 			else{
 				objGUI.mostrarAviso("Se ingreso Correctamente ");
 				System.out.println("¡¡¡¡¡¡¡¡ GRACIAS TOTALES !!!!!!!");
 			}
 			//objAccesoBD.cerrarConexion();
 		objAccesoBD.cerrarConexion();	
 		
 	}
    /********************************************************************************************************/
     public void modificarRubroProveedor(){
    	 
    	 try {
    		 
    	int fila = jTable1.getSelectedRow();
 	 	BeanProveMarcas objProveMarca=objProMar.obtener(fila) ;
 	    
 	 	cod=(objProveMarca.getCod_proveemar());
 		String codMarca=""+cboMarcas.getSelectedItem();
 		codMarca=codMarca.substring(codMarca.indexOf("-")+1,codMarca.length() );
  		AccesoBD objAccesoBD=  new AccesoBD();
  		objAccesoBD.crearConexion();
  			
  			String sql="UPDATE tb_proveemar SET " +
  				"COD_MAR='"+codMarca+"' "+
  				" WHERE cod_provemar='"+cod+"';";
  		System.out.println(sql);

  		int op=objAccesoBD.ejecutarActualizacion(sql);
  		if(op==0){
  			objGUI.mostrarAviso("Hubo un ERROR al Modificar los datos");
  		}else{
  			objGUI.mostrarAviso("Se Modificaron Correctamente ");		
  		}
  		objAccesoBD.cerrarConexion();	
			
		} catch (Exception e) {
			objGUI.mostrarAviso("Debe Seleccionar los datos a Modificar");
		}
    	
 		
 	}

 	/***********************************************/
     public void limpia(){
    	 
 		txtNombre.setText("");
 		cboMarcas.setSelectedIndex(0);
 		chkMarca.setSelected(false);
 		listarProveMarcas();
 	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==btnAceptar){
			setVisible(false);
		}
		
		if(e.getSource()==btnAgregar){
			agregarMarcaProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveMarXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveMarXMarca();
			}else{
				System.out.println("EST3");
				listarProveMarcas();
			}
		}
		
		if(e.getSource()==btnModificar){
			
			modificarRubroProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveMarXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveMarXMarca();
			}else{
				System.out.println("EST3");
				listarProveMarcas();
			}
			
			
		}
		
        if(e.getSource()==btnBuscar){
        	buscarProveMarXProveedor();
		}
                
        if(e.getSource()==btnListar){
        	est=3;
        	listarProveMarcas();
			limpia();
		}
		
		if(e.getSource()==btnEliminar){
			eliminarMarcaProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveMarXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveMarXMarca();
			}else{
				System.out.println("EST3");
				listarProveMarcas();
			}
			limpia();
		}
		
		if(e.getSource()==cboMarcas){
			
			if(chkMarca.isSelected()){
				//est=2;
				buscarProveMarXMarca();
			}else{
				cargarMarcas();
			}
			
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
	 		BeanProveMarcas objProveMarca=objProMar.obtener(fila) ;
	 		
			if(evento.getClickCount()==1){
				
				verificar=1;
				txtNombre.setText(""+objProveMarca.getNom_prove());
				CODPROVE=""+objProveMarca.getCod_prove();
				if(chkMarca.isSelected()){
					chkMarca.setSelected(false);
					cboMarcas.setSelectedItem(""+objProveMarca.getNom_mar()+"-"+objProveMarca.getCod_mar());
				}else{
					cboMarcas.setSelectedItem(""+objProveMarca.getNom_mar()+"-"+objProveMarca.getCod_mar());
				}
				
			
			}
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
