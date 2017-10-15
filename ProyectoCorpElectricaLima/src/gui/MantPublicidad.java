package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
public class MantPublicidad extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	private JPanel pnlProducto;
	private JLabel lblNombre;
	private JTextField txtNombre,txtPeso;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnListar;
	private JTable jTable1;
	private JScrollPane scrProducto;
	private JButton btnAgregar;
	private JButton btnModificar;
	GUI objGUI;
	private JTextField txtRuta;
	private JButton btnAdjuntar;
	String titulo2[]={"COD_PUBLI","NOM_PUBLI","RUTA_PUBLI"};
			
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 String  COD_PROD;
	 String codprod="",nomprod="";
	 public MantPublicidad(){
		 super("Mant Publicidad", true, true, true, true);
		 initGUI();
	 }
	
	private void initGUI() {
		try {
	
				this.setPreferredSize(new java.awt.Dimension(635, 285));
				this.setBounds(0, 0, 635, 285);
				getContentPane().setLayout(null);
				
					pnlProducto = new JPanel();
					getContentPane().add(pnlProducto);
					pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos de la Publicidad"));
					pnlProducto.setLayout(null);
					pnlProducto.setBounds(12, 7, 618, 77);

						lblNombre = new JLabel();
						pnlProducto.add(lblNombre);
						lblNombre.setText("Nombre:");
						lblNombre.setBounds(17, 26, 78, 14);
				
					
						txtNombre = new JTextField();
						pnlProducto.add(txtNombre);
						txtNombre.setBounds(107, 23, 494, 21);

						btnAdjuntar = new JButton();
						pnlProducto.add(btnAdjuntar);
						btnAdjuntar.setText("Adjuntar");
						btnAdjuntar.setBounds(11, 50, 86, 26);
						btnAdjuntar.setSize(86, 20);
						btnAdjuntar.addActionListener(this);

						txtRuta = new JTextField();
						pnlProducto.add(txtRuta);
						txtRuta.setBounds(108, 50, 493, 20);

						txtNombre.addKeyListener(this);

					btnListar = new JButton();
					getContentPane().add(btnListar);
					btnListar.setText("Listar");
					btnListar.setBounds(432, 90, 87, 26);
					btnListar.setSize(87, 20);
					btnListar.addActionListener(this);
				
					btnBuscar = new JButton();
					getContentPane().add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setBounds(335, 90, 86, 26);
					btnBuscar.setSize(87, 20);
					btnBuscar.addActionListener(this);
				
					btnEliminar = new JButton();
					getContentPane().add(btnEliminar);
					btnEliminar.setText("Eliminar");
					btnEliminar.setBounds(235, 90, 85, 26);
					btnEliminar.setSize(87, 20);
					btnEliminar.addActionListener(this);
				
					btnModificar = new JButton();
					getContentPane().add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(129, 90, 95, 20);
					btnModificar.addActionListener(this);
				
					btnAgregar = new JButton();
					getContentPane().add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(31, 90, 87, 26);
					btnAgregar.setSize(87, 20);
					btnAgregar.addActionListener(this);
				
				
					scrProducto = new JScrollPane();
					getContentPane().add(scrProducto);
					scrProducto.setBounds(7, 115, 615, 136);
					
						
						jTable1 = new JTable();
						scrProducto.setViewportView(jTable1);
						jTable1.setModel(modelo2);
						jTable1.setSize(2004,0);
						jTable1.addMouseListener(this);
					
						setVisible(true);
						listarProducto();
					//	cargarMarcas();
					
						pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/********LISTAR PRODUCTO************************/
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
		String sql="SELECT * FROM TB_PUBLICIDAD;";
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
		
		
		String NOM_PROD=txtNombre.getText()//,NOM_MAR=(String)cboMarca.getSelectedItem()
		,NOM_RUt=txtRuta.getText(),EST_PROD="ACTIVADO";
	/*	if(cboMarca.getSelectedIndex()==0){
			NOM_MAR="293";
		}else{
			NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
		}*/
		
//COD_PROD, NOM_PROD, COD_RUBRO, OBS_PROD, EST_PROD
		String insertarPregunta="INSERT INTO TB_PUBLICIDAD VALUES("+null+",'"+NOM_PROD+"','"
		+NOM_RUt+"')";
		System.out.println("ESTO SALE ANTES DE INGRESAR Y ERROR:"+insertarPregunta);

		
		String aumentoBackSlash=insertarPregunta.replace("\\", "\\\\");
		System.out.println("Ahora como se ve:"+aumentoBackSlash);
		int op= objAccesoBD.ejecutarActualizacion(aumentoBackSlash);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error a Ingresar la publicidad");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a ingresado satisfactoriamenete el producto");
			System.out.println("　　　　 GRACIAS insertar producto !!!!!!!");
			}
		//objAccesoBD.cerrarConexion();
	objAccesoBD.cerrarConexion();
			
		listarProducto();
		
		
	}
	/***********************************************/
	
	/********MODIFICAR PRODUCTO**********************/
	public void modificarProducto(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		String insertarPregunta=txtRuta.getText().trim();
		String aumentoBackSlash=insertarPregunta.replace("\\", "\\\\");
		
			String sql="UPDATE TB_publicidad  SET nom_publi='"+txtNombre.getText()+"' , " +
				" ruta_publi='"+aumentoBackSlash+"'  "+
				" WHERE COD_publi='"+COD_PROD+"';";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error a modificar la publicidad");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			//modificarProductoAlt();
			objGUI.mostrarAviso("Se a modificado  el producto");
			System.out.println("　　　　 GRACIAS insertar product0 !!!!!!!");}
		
		objAccesoBD.cerrarConexion();	
	
		
		listarProducto();
	}
	/*************************************************************/
	/********ELIMINAR PRODUCTO**********************/
/*	public void eliminarProducto(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String est="DESACTIVADO";
		String sql="UPDATE tb_producto SET EST_PROD='"+est+"'  WHERE COD_PROD="+COD_PROD+";";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error al eliminar el producto");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a eliminado  el producto");
			System.out.println("　　　　 GRACIAS eliminar product0 !!!!!!!");
			eliminarProductoAlt();}
		
		objAccesoBD.cerrarConexion();	
		listarProducto();
	}*/
	/***********************************************/

	/********BUSCAR PRODUCTO************************/
	public void buscarProducto(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		

		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_PROD=txtNombre.getText(),EST_PROD="ACTIVADO";
		//String NOM_MAR=(String)cboMarca.getSelectedItem();
		/*if(cboMarca.getSelectedIndex()==0){
			NOM_MAR="293";
			NOM_MAR="";
		}else{
			NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
		}*/
		//NOM_MAR="";UMED_PROD="";
	
		
		String sql=" SELECT * from tb_publicidad where nom_publi " +
				"  LIKE '%"+NOM_PROD.trim()+"%';" ;
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


	public void cargarProducto(){
		
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+ modelo2.getValueAt(fila, 0));
		COD_PROD=String.valueOf(cod);
		  
		txtNombre.setText((String)modelo2.getValueAt(fila, 1));
		//String cod_mar=(String) modelo2.getValueAt(fila, 2),nom_mar=(String)modelo2.getValueAt(fila, 3),
		//uni=nom_mar+"-"+cod_mar;
		//cboMarca.setSelectedItem(uni);
		//String cod_RUB=(String) modelo2.getValueAt(fila, 2),nom_RUB=(String)modelo2.getValueAt(fila, 3),
		txtRuta.setText((String)modelo2.getValueAt(fila, 2));
	}
	private String adjuntarArchivo() {
		String sale="";
		File archivo =null;
		JFileChooser selectorArchivo=new JFileChooser();
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int resultado=selectorArchivo.showOpenDialog(this);
        
        if(resultado==JFileChooser.CANCEL_OPTION){
        	archivo=null;
        	sale="";
        }
        
        
          archivo = selectorArchivo.getSelectedFile();
        
        if(archivo==null||archivo.getName().equals("")){
        	sale="";
        }else{
        	sale=archivo+"";
            sale= sale.trim();
        }
        return sale;
		
	}

	/***********************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAgregar){
			agregarProducto();
		}
		if(e.getSource()==btnModificar){
			modificarProducto();
		}
		if(e.getSource()==btnEliminar){
			
			
		}
		if(e.getSource()==btnBuscar){
			buscarProducto();
		}
		if(e.getSource()==btnListar){
			listarProducto();	
		}
		if(e.getSource()==btnAdjuntar){
			txtRuta.setText(adjuntarArchivo());
		}
	}
	/***********EVENTOS DE CARGA PARA EL COMBOBOX MARCAS*************/


	public void mouseClicked(MouseEvent e) {

		
	}
	/*****************************************************************/
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarProducto();}}
	public void mouseReleased(MouseEvent e) {}


	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()==txtNombre){
			buscarProducto();
		}
		
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}

}
