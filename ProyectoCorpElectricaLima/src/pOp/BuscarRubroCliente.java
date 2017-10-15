package pOp;
import gui.MantCliente;

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
import servlet.ServletCliRubro;
import beans.BeanClienteRubro;

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
public class BuscarRubroCliente extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
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
	
	String titulo2[]={"CODIGO_CLIENTE","NOMBRE_CLIENTE","NOMBRE_RUBRO"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletCliRubro objCliRub= new ServletCliRubro();
	int codigocliRubro,cod,codrubro,est,verificar;
	String CODCLI;
	MantCliente objcli;
	GUI objGUI;
	
	
	public BuscarRubroCliente(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(726, 318);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(756, 83));

			lblRubro = new JLabel();
			pnlArriba.add(lblRubro);
			lblRubro.setText("Rubro:");
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
			txtNombre.setText(objcli.nomcli);

			chkRubro = new JCheckBox();
			pnlArriba.add(chkRubro);
			chkRubro.setBounds(309, 51, 21, 21);

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
			
			listarCliRubroXCod();
			cargarRubro();
			verificar=0;

		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	/********LISTAR CLIENTE-RUBRO************************/
	public void listarCliRubro(){
		
		objCliRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="select clirubro.cod_clirubro,clirubro.cod_cli,cli.NOM_CLI,clirubro.cod_rubro,rub.NOM_RUBRO "+ 
            "from tb_clienterubro clirubro inner join tb_cliente cli "+ 
            "on clirubro.cod_cli = CLI.COD_CLI "+ 
            "inner join tb_rubro rub "+ 
            "on clirubro.cod_rubro = rub.COD_RUBRO "+ 
            "order by cli.nom_cli asc; ";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanClienteRubro objBean=new BeanClienteRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objCliRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objCliRub.tamaño(); i++) {
			BeanClienteRubro objBean=objCliRub.obtener(i) ;
			Object[] array={ objBean.getCod_cli(),objBean.getNom_cli(),
					objBean.getNom_rubro()};
			modelo2.addRow(array);
			
		}
		
		
	}
	
	/********LISTAR CLIENTE-RUBROXCODIGO************************/
	public void listarCliRubroXCod(){	
		
		objCliRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objcli=new MantCliente();
		codigocliRubro=objcli.codclirubro;
		
		String sql="select clirubro.cod_clirubro,clirubro.cod_cli,cli.NOM_CLI,clirubro.cod_rubro,rub.NOM_RUBRO "+
            "from tb_clienterubro clirubro inner join tb_cliente cli "+
            "on clirubro.cod_cli = CLI.COD_CLI "+
            "inner join tb_rubro rub "+
            "on clirubro.cod_rubro = rub.COD_RUBRO "+
            "where clirubro.cod_cli='"+codigocliRubro+"' " +
            "order by rub.nom_rubro asc;";
			
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanClienteRubro objBean=new BeanClienteRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objCliRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objCliRub.tamaño(); i++) {
			
			BeanClienteRubro objBean=objCliRub.obtener(i) ;
			Object[] array={ objBean.getCod_cli(),objBean.getNom_cli(),
					objBean.getNom_rubro()};
			modelo2.addRow(array);
			
		}
		
		
	}
	/********************************Cargar Rubros***************************************************/
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
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();	
	}
	/***********************************************************************************************/
     public void buscarCliRubXRubro(){	
		
    	est=2;
    	objCliRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objcli=new MantCliente();
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
		
		String sql="select clirubro.cod_clirubro,clirubro.cod_cli,cli.NOM_CLI,clirubro.cod_rubro,rub.NOM_RUBRO "+
	        "from tb_clienterubro clirubro inner join tb_cliente cli "+
	        "on clirubro.cod_cli = CLI.COD_CLI "+
	        "inner join tb_rubro rub "+
	        "on clirubro.cod_rubro = rub.COD_RUBRO "+
	        "where rub.COD_Rubro='"+codRubro+"' " +
	        "order by cli.nom_cli asc;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanClienteRubro objBean=new BeanClienteRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objCliRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objCliRub.tamaño(); i++) {
			BeanClienteRubro objBean=objCliRub.obtener(i) ;
			Object[] array={ objBean.getCod_cli(),objBean.getNom_cli(),
					objBean.getNom_rubro()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***********************************************************************************************/
     public void buscarCliRubroXCliente(){	
		
    	est=1;
    	objCliRub.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		objcli=new MantCliente();
		String nomcli=""+txtNombre.getText().trim();
		
		String sql="select clirubro.cod_clirubro,clirubro.cod_cli,cli.NOM_CLI,clirubro.cod_rubro,rub.NOM_RUBRO "+
        "from tb_clienterubro clirubro inner join tb_cliente cli "+
        "on clirubro.cod_cli = CLI.COD_CLI "+
        "inner join tb_rubro rub "+
        "on clirubro.cod_rubro = rub.COD_RUBRO "+
        "where cli.nom_cli like '%"+nomcli+"%' " +
        "order by rub.nom_rubro asc;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
	     BeanClienteRubro objBean=new BeanClienteRubro(rs.getInt(1), rs.getInt(2),
			rs.getString(3), rs.getInt(4), rs.getString(5));
	     objCliRub.adicionar(objBean);
		}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objCliRub.tamaño(); i++) {
			BeanClienteRubro objBean=objCliRub.obtener(i) ;
			Object[] array={ objBean.getCod_cli(),objBean.getNom_cli(),
					objBean.getNom_rubro()};
			modelo2.addRow(array);
			
		}
		
		
	}
     /***************************************************************************************************/
     public void eliminarRubroCliente(){
    	
    	 try {
    		 int fila = jTable1.getSelectedRow();
    	 		BeanClienteRubro objcliRubro=objCliRub.obtener(fila) ;
    	 		
    	 		cod=(objcliRubro.getCod_clirubro());
    	 		AccesoBD objAccesoBD=  new AccesoBD();
    	 		objAccesoBD.crearConexion();
    	 	
    	 		String sql="DELETE FROM  tb_clienterubro " +
    	 		" WHERE cod_clirubro='"+cod+"';";
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
 
     /********AGREGAR RUBRO AL CLIENTE************************/
 	 public void agregarMarcaProveedor(){
 		 
 		 if(verificar==0){
 			objcli=new MantCliente();
			CODCLI=""+objcli.codclirubro;
			est=1;
 		 }
 		 
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		
 		String COD_RUBRO=""+cboRubro.getSelectedItem(),EST_CLIRUBRO="ACTIVADO";
 		COD_RUBRO=COD_RUBRO.substring(COD_RUBRO.indexOf("-")+1,COD_RUBRO.length());
 		
 		String insertarPregunta="INSERT INTO tb_clienterubro(cod_cli, cod_rubro, est_clirubro)" +
 					" VALUES('"+CODCLI+"','"+COD_RUBRO+"','"+EST_CLIRUBRO+"');";
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
     public void modificarRubroCliente(){
    	 
    	 try {
    		 
    	int fila = jTable1.getSelectedRow();
 	 	BeanClienteRubro objCliRubro=objCliRub.obtener(fila) ;
 	    
 	 	cod=(objCliRubro.getCod_clirubro());
 		String codRubro=""+cboRubro.getSelectedItem();
 		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length() );
  		AccesoBD objAccesoBD=  new AccesoBD();
  		objAccesoBD.crearConexion();
  			
  			String sql="UPDATE tb_clienterubro SET " +
  				"COD_RUBRO='"+codRubro+"' "+
  				" WHERE cod_clirubro='"+cod+"';";
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
 		listarCliRubro();
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
				buscarCliRubroXCliente();
			}else if(est==2){
				System.out.println("EST2");
				buscarCliRubXRubro();
			}else{
				System.out.println("EST3");
				listarCliRubro();
			}
		}
		
		if(e.getSource()==btnModificar){
			
			modificarRubroCliente();
			if(est==1){
				System.out.println("EST1");
				buscarCliRubroXCliente();
			}else if(est==2){
				System.out.println("EST2");
				buscarCliRubXRubro();
			}else{
				System.out.println("EST3");
				listarCliRubro();
			}
			
			
		}
		
        if(e.getSource()==btnBuscar){
        	buscarCliRubroXCliente();
		}
                
        if(e.getSource()==btnListar){
        	est=3;
        	listarCliRubro();
			limpia();
		}
		
		if(e.getSource()==btnEliminar){
			eliminarRubroCliente();
			if(est==1){
				System.out.println("EST1");
				buscarCliRubroXCliente();
			}else if(est==2){
				System.out.println("EST2");
				buscarCliRubXRubro();
			}else{
				System.out.println("EST3");
				listarCliRubro();
			}
			limpia();
		}
		
		if(e.getSource()==cboRubro){
			
			if(chkRubro.isSelected()){
				//est=2;
				buscarCliRubXRubro();
			}else{
				cargarRubro();
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
	 		BeanClienteRubro objCliRubro=objCliRub.obtener(fila) ;
	 		
			if(evento.getClickCount()==1){
				
				verificar=1;
				txtNombre.setText(""+objCliRubro.getNom_cli());
				CODCLI=""+objCliRubro.getCod_cli();
				if(chkRubro.isSelected()){
					chkRubro.setSelected(false);
					cboRubro.setSelectedItem(""+objCliRubro.getNom_rubro()+"-"+objCliRubro.getCod_rubro());
				}else{
					cboRubro.setSelectedItem(""+objCliRubro.getNom_rubro()+"-"+objCliRubro.getCod_rubro());
				}
				
			
			}
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
