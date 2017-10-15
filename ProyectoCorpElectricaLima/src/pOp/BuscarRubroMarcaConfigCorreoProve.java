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
import servlet.ServletProveRubro;
import beans.BeanProveRubro;

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
public class BuscarRubroMarcaConfigCorreoProve extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblddd;
	private JScrollPane jScrollPane1;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JComboBox cboRubro;
	private JButton btnListar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JLabel lblRubro;
	private JTable jTable1;
	private JPanel pnlCentro;
	private JCheckBox chkRubro;
	
	String titulo2[]={"CODIGO_PROVEEDOR","NOMBRE_PROVEEDOR","NOMBRE_RUBRO","NOMBRE_MARCA"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletProveRubro objProRub = new ServletProveRubro();
	int codigoProvRub,cod,codrubro,est,verificar;
	String CODPROVE;
	private JCheckBox chkMarcas;
	private JComboBox cboMarcas;
	private JLabel lblMarca;
	ConfigCorreoProve objCorreo;
	GUI objGUI;
	
	
	public BuscarRubroMarcaConfigCorreoProve(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(726, 362);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(710, 109));

			lblRubro = new JLabel();
			pnlArriba.add(lblRubro);
			lblRubro.setText("Rubro:");
			lblRubro.setBounds(32, 51, 46, 16);

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

			cboRubro = new JComboBox();
			pnlArriba.add(cboRubro);
			cboRubro.addItem("");
			cboRubro.setBounds(78, 47, 229, 25);
			cboRubro.addActionListener(this);

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(22, 19, 57, 16);

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(79, 15, 365, 25);
			txtNombre.setText(objCorreo.nomprove);
			
			

			chkRubro = new JCheckBox();
			pnlArriba.add(chkRubro);
			chkRubro.setBounds(309, 51, 21, 21);

			lblMarca = new JLabel();
			pnlArriba.add(lblMarca);
			lblMarca.setText("Marcas:");
			lblMarca.setBounds(23, 81, 46, 16);

			cboMarcas = new JComboBox();
			pnlArriba.add(cboMarcas);
			cboMarcas.addItem("");
			cboMarcas.setBounds(78, 77, 229, 25);
			cboMarcas.addActionListener(this);

			chkMarcas = new JCheckBox();
			pnlArriba.add(chkMarcas);
			chkMarcas.setBounds(309, 79, 21, 21);

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
			
			listarProveRubXCod();
			codigoProvRub=0;
			cargarRubro();
			cargarMarcas();
			verificar=0;

		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	/********LISTAR PROVEEDOR-RUBRO-MARCAS************************/
	public void listarProveRubro(){
		
		objProRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="select provrub.cod_prm,provrub.cod_prove,prove.NOM_PROVE,provrub.cod_rubro,rub.NOM_RUBRO, "+
            "provrub.cod_mar,mar.NOM_MAR "+
            "from tb_proverubmar provrub inner join tb_proveedor prove "+
            "on provrub.cod_prove = prove.COD_PROVE inner join tb_rubro rub "+
            "on provrub.cod_rubro = rub.COD_RUBRO inner join tb_marcas mar "+
            "on provrub.cod_mar = mar.COD_MAR "+
            "where provrub.est_proverubmar='ACTIVADO' "+
            "order by prove.nom_prove,rub.NOM_RUBRO,mar.NOM_MAR asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveRubro objBean=new BeanProveRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	       objProRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProRub.tamaño(); i++) {
			BeanProveRubro objBean=objProRub.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_rubro(),objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
	
	/********LISTAR PROVEEDOR-RUBRO************************/
	public void listarProveRubXCod(){	
		
		objProRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objCorreo= new ConfigCorreoProve();
		codigoProvRub=objCorreo.codproverubro;
		System.out.println("RECIBE:"+codigoProvRub);
		
		String sql="select provrub.cod_prm,provrub.cod_prove,prove.NOM_PROVE,provrub.cod_rubro,rub.NOM_RUBRO, "+
		        "provrub.cod_mar,mar.NOM_MAR "+
		        "from tb_proverubmar provrub inner join tb_proveedor prove "+
		        "on provrub.cod_prove = prove.COD_PROVE inner join tb_rubro rub "+
		        "on provrub.cod_rubro = rub.COD_RUBRO inner join tb_marcas mar "+
		        "on provrub.cod_mar = mar.COD_MAR "+
		        "where provrub.cod_prove='"+codigoProvRub+"' and provrub.est_proverubmar='ACTIVADO' "+
		        "order by rub.nom_rubro asc;";
			
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveRubro objBean=new BeanProveRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	       objProRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProRub.tamaño(); i++) {
			
			BeanProveRubro objBean=objProRub.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_rubro(),objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
	/********************************Cargar Rubro***************************************************/
	public void cargarRubro(){
		

		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_rubro WHERE EST_RUBRO='ACTIVADO' order by nom_rubro asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			
			cboRubro.addItem(rs.getString(2)+"-"+rs.getString(1));
			
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			
		}

		objAccesoBD.cerrarConexion();
		
		
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
     public void buscarProveRubXRubro(){	
		
    	est=2;
		objProRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
		
		
		String sql="select provrub.cod_prm,provrub.cod_prove,prove.NOM_PROVE,provrub.cod_rubro,rub.NOM_RUBRO, "+
		        "provrub.cod_mar,mar.NOM_MAR "+
		        "from tb_proverubmar provrub inner join tb_proveedor prove "+
		        "on provrub.cod_prove = prove.COD_PROVE inner join tb_rubro rub "+
		        "on provrub.cod_rubro = rub.COD_RUBRO inner join tb_marcas mar "+
		        "on provrub.cod_mar = mar.COD_MAR "+
		        "where rub.cod_rubro='"+codRubro+"' and provrub.est_proverubmar='ACTIVADO' "+
		        "order by prove.nom_prove asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveRubro objBean=new BeanProveRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	       objProRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProRub.tamaño(); i++) {
			BeanProveRubro objBean=objProRub.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_rubro(),objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***********************************************************************************************/
     public void buscarProveRubXMarca(){	
		
    	est=2;
		objProRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		
		String codMarcas=""+cboMarcas.getSelectedItem();
		codMarcas=codMarcas.substring(codMarcas.indexOf("-")+1,codMarcas.length());
		
		
		String sql="select provrub.cod_prm,provrub.cod_prove,prove.NOM_PROVE,provrub.cod_rubro,rub.NOM_RUBRO, "+
		        "provrub.cod_mar,mar.NOM_MAR "+
		        "from tb_proverubmar provrub inner join tb_proveedor prove "+
		        "on provrub.cod_prove = prove.COD_PROVE inner join tb_rubro rub "+
		        "on provrub.cod_rubro = rub.COD_RUBRO inner join tb_marcas mar "+
		        "on provrub.cod_mar = mar.COD_MAR "+
		        "where mar.cod_mar='"+codMarcas+"' and provrub.est_proverubmar='ACTIVADO' "+
		        "order by mar.nom_mar asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveRubro objBean=new BeanProveRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	       objProRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProRub.tamaño(); i++) {
			BeanProveRubro objBean=objProRub.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_rubro(),objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***********************************************************************************************/
     public void buscarProveRubXProveedor(){	
		
    	est=1;
		objProRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		
		String nomProvee=""+txtNombre.getText().trim();
		
		String sql="select provrub.cod_prm,provrub.cod_prove,prove.NOM_PROVE,provrub.cod_rubro,rub.NOM_RUBRO, "+
		        "provrub.cod_mar,mar.NOM_MAR "+
		        "from tb_proverubmar provrub inner join tb_proveedor prove "+
		        "on provrub.cod_prove = prove.COD_PROVE inner join tb_rubro rub "+
		        "on provrub.cod_rubro = rub.COD_RUBRO inner join tb_marcas mar "+
		        "on provrub.cod_mar = mar.COD_MAR "+
		        "where prove.nom_prove like '%"+nomProvee+"%' and provrub.est_proverubmar='ACTIVADO' "+
		        "order by rub.nom_rubro asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanProveRubro objBean=new BeanProveRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7));
	       objProRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objProRub.tamaño(); i++) {
			BeanProveRubro objBean=objProRub.obtener(i) ;
			Object[] array={ objBean.getCod_prove(),objBean.getNom_prove(),
					objBean.getNom_rubro(),objBean.getNom_mar()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***************************************************************************************************/
     public void eliminarRubroProveedor(){
    	
    	 try {
    		 int fila = jTable1.getSelectedRow();
    	 		BeanProveRubro objProveRubro=objProRub.obtener(fila) ;
    	 		
    	 		cod=(objProveRubro.getCod_proverubro());
    	 		AccesoBD objAccesoBD=  new AccesoBD();
    	 		objAccesoBD.crearConexion();
    	 	
    	 		String sql="DELETE FROM  tb_proverubmar " +
    	 		" WHERE cod_prm='"+cod+"';";
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
 
     /********AGREGAR RUBRO Y MARCA AL PROVEEDOR************************/
 	 public void agregarRubroProveedor(){
 		 
 		 if(verificar==0){
 			objCorreo=new ConfigCorreoProve();
			CODPROVE=""+objCorreo.codproverubro;
			est=1;
 		 }
 		 
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		
 		String COD_RUBRO=""+cboRubro.getSelectedItem(),EST_PROVERUBRO="ACTIVADO";
 		COD_RUBRO=COD_RUBRO.substring(COD_RUBRO.indexOf("-")+1,COD_RUBRO.length());
 		
 		String COD_MARCA=""+cboMarcas.getSelectedItem();
 		COD_MARCA=COD_MARCA.substring(COD_MARCA.indexOf("-")+1,COD_MARCA.length());
 		
 		String insertarPregunta="INSERT INTO tb_proverubmar(cod_prove, cod_rubro, cod_mar, est_proverubmar)" +
 					" VALUES('"+CODPROVE+"','"+COD_RUBRO+"','"+COD_MARCA+"','"+EST_PROVERUBRO+"');";
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
 	 	BeanProveRubro objProveRubro=objProRub.obtener(fila) ;
 	 	
 	 	cod=(objProveRubro.getCod_proverubro());
 		String codRubro=""+cboRubro.getSelectedItem();
 		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
 		
 		String COD_MARCA=""+cboMarcas.getSelectedItem();
 		COD_MARCA=COD_MARCA.substring(COD_MARCA.indexOf("-")+1,COD_MARCA.length());
  		AccesoBD objAccesoBD=  new AccesoBD();
  		objAccesoBD.crearConexion();
  			
  			String sql="UPDATE tb_proverubmar SET " +
  				"COD_RUBRO='"+codRubro+"', COD_MAR='"+COD_MARCA+"' "+
  				" WHERE cod_prm='"+cod+"';";
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
 		cboRubro.setSelectedIndex(0);
 		chkRubro.setSelected(false);
 		cboMarcas.setSelectedIndex(0);
 		chkMarcas.setSelected(false);
 		listarProveRubro();
 	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource()==btnAceptar){
			setVisible(false);
			objProRub.eliminarTodo();
		}
		
		if(e.getSource()==btnAgregar){
			agregarRubroProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveRubXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveRubXRubro();
			}else{
				System.out.println("EST3");
				listarProveRubro();
			}
		}
		
		if(e.getSource()==btnModificar){
			
			modificarRubroProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveRubXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveRubXRubro();
			}else{
				System.out.println("EST3");
				listarProveRubro();
			}
			
			
		}
		
        if(e.getSource()==btnBuscar){
        	buscarProveRubXProveedor();
		}
                
        if(e.getSource()==btnListar){
        	est=3;
			listarProveRubro();
			limpia();
		}
		
		if(e.getSource()==btnEliminar){
			eliminarRubroProveedor();
			if(est==1){
				System.out.println("EST1");
				buscarProveRubXProveedor();
			}else if(est==2){
				System.out.println("EST2");
				buscarProveRubXRubro();
			}else{
				System.out.println("EST3");
				listarProveRubro();
			}
			limpia();
		}
		
		if(e.getSource()==cboRubro){
			
			if(chkRubro.isSelected()){
				//est=2;
				buscarProveRubXRubro();
			}else{
			cargarRubro();
			}
			
		}
		
         if(e.getSource()==cboMarcas){
			
			if(chkMarcas.isSelected()){
				//est=2;
				buscarProveRubXMarca();
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
	 		BeanProveRubro objProveRubro=objProRub.obtener(fila) ;
	 		
			if(evento.getClickCount()==1){
				
				verificar=1;
				txtNombre.setText(""+objProveRubro.getNom_prove());
				CODPROVE=""+objProveRubro.getCod_prove();
				if(chkRubro.isSelected()){
					chkRubro.setSelected(false);
					cboRubro.setSelectedItem(""+objProveRubro.getNom_rubro()+"-"+objProveRubro.getCod_rubro());
				}else{
					cboRubro.setSelectedItem(""+objProveRubro.getNom_rubro()+"-"+objProveRubro.getCod_rubro());
				}
				
				if(chkMarcas.isSelected()){
					chkMarcas.setSelected(false);
					cboMarcas.setSelectedItem(""+objProveRubro.getNom_mar()+"-"+objProveRubro.getCod_mar());
				}else{
					cboMarcas.setSelectedItem(""+objProveRubro.getNom_mar()+"-"+objProveRubro.getCod_mar());
				}
			
			}
			/*if(evento.getClickCount()==2){
				
				setVisible(false);
			}*/
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
