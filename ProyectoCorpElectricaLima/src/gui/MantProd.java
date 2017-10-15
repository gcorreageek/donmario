package gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Prueba.JCheckBoxHeader;
import beans.BeanCargarPrecios;
import beans.BeanCargarProductos;
import beans.BeanMantProducto;

import servlet.ServletCargarPrecios;
import servlet.ServletCargarProductos;
import servlet.ServletMantProducto;

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
public class MantProd extends JInternalFrame implements ActionListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlProducto;
	private JLabel lblNombre;
	private JTextField txtNombre,txtPeso;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnListar;
	private JTextArea txtAObservacionProd;
	private JScrollPane scrObservacion;
	private JLabel lblObservacion,lblPeso;
	private JTable jTable1;
	private JScrollPane scrProducto;
	private JButton btnAgregar;
	private JButton btnModificar;
	GUI objGUI;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JLabel lblRubro;
	

	
	int seg;
    Timer timer;
	int contador; 

	String titulo2[]={"COD_PROD","NOM_PROD","COD_RUBRO","RUBRO","OBS_PROD","PESO","MODELO","MARCA","COD.PROMELSA","ESPECIFICACION"};
			
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 String  COD_PROD;
	 String codprod="",nomprod="";
	 private JFormattedTextField txtFormato;
	 private JButton btnCargar;
	 private JButton btnReemplazar;
	 private JTextField txtReemplazar;
	 private JLabel lblReemplazar;
	 private JLabel lblBuscar;
	 private JTextField txtBuscar;
	 private JTextField txtCodPromelsa;
	 private JTextField txtMarca;
	 private JLabel lblCodPromelsa;
	 private JLabel lblMarca;
	 private JTextArea txtAEspicificacion;
	 private JScrollPane srcEspicificacion;
	 private JLabel lblEspecificacion;
	 private JComboBox cboRubro;
	 private TableColumn Tcol;
	 private JCheckBoxHeader chkheader;
	 
	 public MantProd(){
		 super("Mant Producto", true, true, true, true);
		 initGUI();
	 }
	 
	 ServletCargarProductos objProd= new ServletCargarProductos();
	 ServletMantProducto objMant = new ServletMantProducto();
	
	private void initGUI() {
		try {
	
				this.setPreferredSize(new java.awt.Dimension(927, 507));
				this.setBounds(0, 0, 927, 507);
				getContentPane().setLayout(null);
				
					pnlProducto = new JPanel();
					getContentPane().add(pnlProducto);
					pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
					pnlProducto.setLayout(null);
					pnlProducto.setBounds(12, 7, 618, 169);
			
					lblNombre = new JLabel();
					pnlProducto.add(lblNombre);
					lblNombre.setText("Nombre:");
					lblNombre.setBounds(17, 26, 60, 14);
			
				
					txtNombre = new JTextField();
					pnlProducto.add(txtNombre);
					txtNombre.setBounds(77, 23, 524, 21);
					txtNombre.addKeyListener(this);

				

					lblObservacion = new JLabel();
					pnlProducto.add(lblObservacion);
					lblObservacion.setText("Observacion:");
					lblObservacion.setBounds(9, 127, 78, 14);
				
				
					scrObservacion = new JScrollPane();
					pnlProducto.add(scrObservacion);
					scrObservacion.setBounds(95, 107, 217, 51);

					lblRubro = new JLabel();
					pnlProducto.add(lblRubro);
					lblRubro.setText("Rubro:");
					lblRubro.setBounds(17, 50, 54, 14);

					
					cboRubro = new JComboBox();
					pnlProducto.add(cboRubro);
					cboRubro.addItem("");
					cboRubro.setBounds(77, 47, 217, 21);

					lblPeso = new JLabel();
					pnlProducto.add(lblPeso);
					lblPeso.setText("Peso:");
					lblPeso.setBounds(312, 49, 39, 16);

					txtPeso = new JTextField();
					pnlProducto.add(txtPeso);
					txtPeso.setBounds(349, 47, 88, 20);
					
					lblModelo = new JLabel();
					pnlProducto.add(lblModelo);
					lblModelo.setText("Modelo:");
					lblModelo.setBounds(443, 49, 49, 16);
				
					txtModelo = new JTextField();
					pnlProducto.add(txtModelo);
					txtModelo.setBounds(491, 47, 110, 23);
					txtModelo.setSize(110, 20);

					lblEspecificacion = new JLabel();
					pnlProducto.add(lblEspecificacion);
					lblEspecificacion.setText("E.Tecnica:");
					lblEspecificacion.setBounds(318, 126, 63, 16);

					srcEspicificacion = new JScrollPane();
					pnlProducto.add(srcEspicificacion);
					srcEspicificacion.setBounds(381, 107, 218, 52);

					lblMarca = new JLabel();
					pnlProducto.add(lblMarca);
					lblMarca.setText("Marca:");
					lblMarca.setBounds(18, 80, 47, 16);

					lblCodPromelsa = new JLabel();
					pnlProducto.add(lblCodPromelsa);
					lblCodPromelsa.setText("Cod.Promelsa:");
					lblCodPromelsa.setBounds(253, 80, 89, 16);

					txtMarca = new JTextField();
					pnlProducto.add(txtMarca);
					txtMarca.setBounds(77, 77, 161, 22);

					txtCodPromelsa = new JTextField();
					pnlProducto.add(txtCodPromelsa);
					txtCodPromelsa.setBounds(349, 77, 160, 21);	

					txtAEspicificacion = new JTextArea();
					srcEspicificacion.setViewportView(txtAEspicificacion);

					txtAObservacionProd = new JTextArea();
					scrObservacion.setViewportView(txtAObservacionProd);
					txtAObservacionProd.setPreferredSize(new java.awt.Dimension(211, 46));

					btnListar = new JButton();
					getContentPane().add(btnListar);
					btnListar.setText("Listar");
					btnListar.setBounds(490, 182, 87, 26);
					btnListar.addActionListener(this);
				
					btnBuscar = new JButton();
					getContentPane().add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setBounds(369, 182, 86, 26);
					btnBuscar.addActionListener(this);
				
					btnEliminar = new JButton();
					getContentPane().add(btnEliminar);
					btnEliminar.setText("Eliminar");
					btnEliminar.setBounds(253, 182, 85, 26);
					btnEliminar.addActionListener(this);
				
					btnModificar = new JButton();
					getContentPane().add(btnModificar);
					btnModificar.setText("Modificar");
					btnModificar.setBounds(135, 182, 88, 26);
					btnModificar.addActionListener(this);
				
					btnAgregar = new JButton();
					getContentPane().add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(31, 182, 87, 26);
					btnAgregar.addActionListener(this);
				
				
					scrProducto = new JScrollPane();
					getContentPane().add(scrProducto);
					scrProducto.setBounds(12, 215, 895, 198);
					
					btnCargar = new JButton();
					getContentPane().add(btnCargar);
					btnCargar.setText("Cargar Productos");
					btnCargar.setBounds(604, 184, 150, 23);
					
					txtBuscar = new JTextField();
					getContentPane().add(txtBuscar);
					txtBuscar.setBounds(642, 31, 271, 23);
				
				
					lblBuscar = new JLabel();
					getContentPane().add(lblBuscar);
					lblBuscar.setText("Buscar:");
					lblBuscar.setBounds(642, 12, 54, 16);
					
		
					lblReemplazar = new JLabel();
					getContentPane().add(lblReemplazar);
					lblReemplazar.setText("Reemplazar:");
					lblReemplazar.setBounds(642, 73, 74, 16);
				
				
					txtReemplazar = new JTextField();
					getContentPane().add(txtReemplazar);
					txtReemplazar.setBounds(642, 92, 271, 23);
				
				
					btnReemplazar = new JButton();
					getContentPane().add(btnReemplazar);
					btnReemplazar.setText("Reemplazar");
					btnReemplazar.setBounds(642, 127, 126, 23);
					btnReemplazar.addActionListener(this);
		
					btnCargar.addActionListener(this);
					

					jTable1 = new JTable();
					scrProducto.setViewportView(jTable1);
					jTable1.setModel(modelo2);
					jTable1.setSize(2004,0);
					jTable1.addMouseListener(this);
					
//					Tcol=jTable1.getColumnModel().getColumn(0);
//					Tcol.setCellEditor(jTable1.getDefaultEditor(null));  
//					Tcol.setCellRenderer(jTable1.getDefaultRenderer(null));
//					chkheader=new JCheckBoxHeader(jTable1);
//					Tcol.setHeaderRenderer(chkheader);
					
					setVisible(true);
					listarProducto();
				//	cargarMarcas();
					cargarRubro();
					pack();
					//ordenar();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/********LISTAR PRODUCTO************************/
	public void listarProducto(){
		
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
			objAccesoBD.crearConexion();
			
			String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD," +
					" RUB.COD_RUBRO,RUB.NOM_RUBRO,PROD.OBS_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.MAR_PROD,PROD.CODPRO_PROD,PROD.ESP_PROD" +
					" FROM tb_producto PROD " +
					" INNER JOIN tb_rubro RUB" +
					" ON RUB.COD_RUBRO=PROD.COD_RUBRO " +
					" WHERE PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' ORDER BY PROD.NOM_PROD ASC limit 1000;";
			rs = objAccesoBD.ejecutarConsulta(sql);
						
				while(rs.next()){
					
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)
					};
							
					modelo2.addRow(obj);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
	}
	/***********************************************/

	/********AGREGAR PRODUCTO************************/
	public void agregarProducto(){
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		double peso=0;
		int act=0;
		
		String NOM_PROD=txtNombre.getText()//,NOM_MAR=(String)cboMarca.getSelectedItem()
		,NOM_RUB=(String)cboRubro.getSelectedItem(),
		OBS_PROD=txtAObservacionProd.getText(),EST_PROD="ACTIVADO",ESP_PROD=txtAEspicificacion.getText(),
		MAR_PROD=txtMarca.getText(),CODPROD_PROD=txtCodPromelsa.getText();
	
		if(cboRubro.getSelectedIndex()==0){
			NOM_RUB="56";
		}else{
			NOM_RUB=NOM_RUB.substring(NOM_RUB.indexOf("-")+1,NOM_RUB.length() );
		}
		
		if(txtPeso.getText().equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(txtPeso.getText());
		}
		
        //COD_PROD, NOM_PROD, COD_RUBRO, OBS_PROD, EST_PROD
		String insertarPregunta="INSERT INTO tb_producto VALUES("+null+",'"+NOM_PROD+"','"
		+NOM_RUB+"',CONCAT(CURDATE(),'-','"+OBS_PROD+"' ),'"+EST_PROD+"','"+peso+"','"+act+"','"+txtModelo.getText().trim()+"','"+ESP_PROD+"','"+MAR_PROD+"','"+CODPROD_PROD+"')";
		System.out.println("ESTO SALE ANTES DE INGRESAR Y ERROR:"+insertarPregunta);

		int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error a Ingresar el producto");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
			objGUI.mostrarAviso("Se a ingresado satisfactoriamenete el producto");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar producto !!!!!!!");
			}
		
	     objAccesoBD.cerrarConexion();
			
		listarProducto();
			if(op!=0){
				maxCodProducto();	
			}
		
	}
	/***********************************************/
	/********MODIFICAR PRODUCTO**********************/
	public void modificarProducto(){
		double peso=0;
		
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();

		String NOM_RUB=(String)cboRubro.getSelectedItem();
		if(cboRubro.getSelectedIndex()==0){
			NOM_RUB="56";
		}else{
			NOM_RUB=NOM_RUB.substring(NOM_RUB.indexOf("-")+1,NOM_RUB.length() );
		}
		
	
		if(txtPeso.getText().equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(txtPeso.getText());
		}
		
			String sql="UPDATE tb_producto SET NOM_PROD='"+txtNombre.getText()+"' , " +
				" COD_RUBRO='"+NOM_RUB+"' , "+
				"OBS_PROD='"+txtAObservacionProd.getText()+"' , EST_PROD='"+"ACTIVADO"+"' , PESO_PROD='"+peso+"', " +
				" MOD_PROD='"+txtModelo.getText().trim()+"',ESP_PROD='"+txtAEspicificacion.getText().trim()+"',MAR_PROD='"+txtMarca.getText().trim()+"',CODPRO_PROD='"+txtCodPromelsa.getText().trim()+"' "+
				" WHERE COD_PROD='"+COD_PROD+"';";
		System.out.println(sql);

		int op= objAccesoBD.ejecutarActualizacion(sql);
		//System.out.println(insertarPregunta);
		if(op==0){
			objGUI.mostrarAviso("Hubo un error a modificar el producto");
			System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{
		
			//modificarProductoAlt();
			objGUI.mostrarAviso("Se a modificado  el producto");
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar product0 !!!!!!!");
		}
		
		objAccesoBD.cerrarConexion();	
	
		
		listarProducto();
	}
	/*************************************************************/
	/********ELIMINAR PRODUCTO**********************/
	public void eliminarProducto(){
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
			System.out.println("¡¡¡¡¡¡¡¡ GRACIAS eliminar product0 !!!!!!!");
			//eliminarProductoAlt();
			}
		
		objAccesoBD.cerrarConexion();	
		listarProducto();
	}
	/***********************************************/
	/********ELIMINAR PRODUCTO**********************/
	/*public int consultarProdEli(){
	AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_prodmarprove  where cod_prod='"+COD_PROD+"';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		int valor=0;
		try {
			while(rs.next()){
				if(rs.getString(8).equals("DESACTIVADO")){
					valor=1;
				return valor; 	
				}else{valor=2;//activado
					return valor;
				}
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		return valor;
	}*/
	/***********************************************/
	/********BUSCAR PRODUCTO************************/
	public void buscarProducto(){
		
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_PROD=txtNombre.getText(),
		MOD_PROD=txtModelo.getText(),
		ESP_PROD=txtAEspicificacion.getText(),
		MAR_PROD=txtMarca.getText(),
		CODPROD_PROD=txtCodPromelsa.getText();
		//String NOM_MAR=(String)cboMarca.getSelectedItem();
		/*if(cboMarca.getSelectedIndex()==0){
			NOM_MAR="293";
			NOM_MAR="";
		}else{
			NOM_MAR=NOM_MAR.substring(NOM_MAR.indexOf("-")+1,NOM_MAR.length() );
		}*/
		//NOM_MAR="";UMED_PROD="";
		
		
		String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD," +
				" RUB.COD_RUBRO,RUB.NOM_RUBRO,PROD.OBS_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.MAR_PROD,PROD.CODPRO_PROD,PROD.ESP_PROD " +
				" FROM tb_producto PROD  " +
				" INNER JOIN tb_rubro RUB " +
				" ON RUB.COD_RUBRO=PROD.COD_RUBRO" +
				" WHERE PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' " +
				" AND  PROD.NOM_PROD LIKE '%"+NOM_PROD.trim()+"%' AND PROD.MOD_PROD LIKE '%"+MOD_PROD.trim()+"%' " +
				" AND PROD.ESP_PROD LIKE '%"+ESP_PROD.trim()+"%' AND PROD.MAR_PROD LIKE '%"+MAR_PROD.trim()+"%' AND PROD.CODPRO_PROD LIKE '%"+CODPROD_PROD.trim()+"%' " +
				" ORDER BY PROD.NOM_PROD ASC;" ;
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	/********BUSCAR PRODUCTO************************/
	public void maxCodProducto(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*select cod_prod, nom_prod from producto
        where cod_prod = ( select max(cod_prod) from producto);*/
		String sql=" select cod_prod, nom_prod from tb_producto" +
				"  where cod_prod = ( select max(cod_prod) from tb_producto);" ;
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				codprod=rs.getString(1);
				nomprod=rs.getString(2);
			}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		//agregarProductoAlt();
	}
	/***********************************************/
	public void cargarRubro(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_rubro WHERE EST_RUBRO='ACTIVADO' ORDER BY NOM_RUBRO;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboRubro.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	
	public void ordenar(){
		
		ArrayList lista = new ArrayList ();
		  lista.add ("z");
		  lista.add ("a");
		  lista.add ("m");
		  // muestro la salida desordenada
		  for (int i = 0; i < lista.size (); i++) {
		    System.out.println (i + " - " + lista.get (i));
		  }
		  // este metodo es el encargado de ordenar la lista
		  Collections.sort (lista);
		  // muestro la salida ordenada
		  for (int i = 0; i < lista.size (); i++) {
		    System.out.println (i + " - " + lista.get (i));
		  } 
	}
	
	
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarProducto(){
		
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+ modelo2.getValueAt(fila, 0));
		COD_PROD=String.valueOf(cod);
		  
		txtNombre.setText((String)modelo2.getValueAt(fila, 1));
		String cod_RUB=(String) modelo2.getValueAt(fila, 2),nom_RUB=(String)modelo2.getValueAt(fila, 3),
		
		uni2=nom_RUB+"-"+cod_RUB;
		cboRubro.setSelectedItem(uni2);
	
		
		txtAObservacionProd.setText((String)modelo2.getValueAt(fila, 4));
		txtPeso.setText((String)modelo2.getValueAt(fila, 5));
		txtModelo.setText((String)modelo2.getValueAt(fila, 6));
		txtMarca.setText((String)modelo2.getValueAt(fila, 7));
		txtCodPromelsa.setText((String)modelo2.getValueAt(fila, 8));
		txtAEspicificacion.setText((String)modelo2.getValueAt(fila, 9));
	}
	 
	/******************************************************************************************************************************/
	private boolean  abrirArchivo(){
		  String vieneArchivo="";
	        JFileChooser selectorArchivo=new JFileChooser();
	        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        
	        int resultado=selectorArchivo.showOpenDialog(this);
	        
	        if(resultado==JFileChooser.CANCEL_OPTION)
	            return false;
	        
	        File archivo=selectorArchivo.getSelectedFile();
	        
	        if(archivo==null||archivo.getName().equals("")){
	            JOptionPane.showMessageDialog(this,"Nombre Del Archivo Incorrecto",
	            "Nombre Del Archivo Incorrecto",JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        vieneArchivo=""+archivo;
	        //txtRuta.setText(vieneArchivo.trim());
	        objGUI.mostrarAviso("Este es la Ruta:"+vieneArchivo.trim());
	        
	        try {
	        	objProd.cargarExcel(vieneArchivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true; 
	}	
	
	 /***************************************************************************************************/
    public int encontrarProducto(String codigo){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		ResultSet rs =null;
		int cod=0;
		
		try{
			
			objAccesoBD.crearConexion();
			 
			String sql="SELECT count(*) FROM tb_producto "+
	                   " where cod_prod='"+codigo+"' and est_prod='ACTIVADO';";
			
			rs = objAccesoBD.ejecutarConsulta(sql);		
			
			 	if(rs.next()){			
			 		cod=rs.getInt(1);			
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		return cod;
	}
  /**************************************************************************************************************/
	
    public void agregarProductos(String NOM_PROD,String COD_RUB,String OBS_PROD,String EST_PROD,
    		String peso,String act,String MOD_PROD,String ESP_PROD,String MAR_PROD,String CODPROD_PROD){
    	
    	    	
    	if(NOM_PROD==null || NOM_PROD.equals("null")){
    		NOM_PROD="";
    	}
    	
    	if(COD_RUB==null || COD_RUB.equals("null")){
    		COD_RUB="";
    	}
    	
    	if(OBS_PROD==null || OBS_PROD.equals("null")){
    		OBS_PROD="";
    	}
    	
    	if(EST_PROD==null || EST_PROD.equals("null")){
    		EST_PROD="";
    	}
    	
    	if(peso==null || peso.equals("null")){
    		peso="";
    	}
    	
    	if(act==null || act.equals("null")){
    		act="";
    	}
    	
    	if(ESP_PROD==null || ESP_PROD.equals("null")){
    		ESP_PROD="";
    	}
    	
    	if(MAR_PROD==null || MAR_PROD.equals("null")){
    		MAR_PROD="";
    	}
    	
    	if(CODPROD_PROD==null || CODPROD_PROD.equals("null")){
    		CODPROD_PROD="";
    	}
   	 
		AccesoBD objAccesoBD = new AccesoBD();
		
		try{
			
		objAccesoBD.crearConexion();
		     
				String insertarPregunta="INSERT INTO tb_producto VALUES("+null+",'"+NOM_PROD+"','"
				+COD_RUB+"',CONCAT(CURDATE(),'-','"+OBS_PROD+"' ),'"+EST_PROD+"','"+peso+"','"+act+"','" +
						""+MOD_PROD+"','"+ESP_PROD+"','"+MAR_PROD+"','"+CODPROD_PROD+"')";
				
				int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
				
				if(op==0){
					System.out.println("Hubo un error a Ingresar el producto");
				}
				else{
					System.out.println("Se a ingresado satisfactoriamenete el producto");
				}
				
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		    
	}
   
    /***************************************************************************************************************/
    public void actualizarProductos(String COD_PROD,String NOM_PROD,String COD_RUB,String OBS_PROD,String EST_PROD,
    		String peso,String act,String MOD_PROD,String ESP_PROD,String MAR_PROD,String CODPROD_PROD){
		
    	if(COD_PROD==null || COD_PROD.equals("null")){
    		COD_PROD="";
    	}
    	
    	if(NOM_PROD==null || NOM_PROD.equals("null")){
    		NOM_PROD="";
    	}
    	
    	if(COD_RUB==null || COD_RUB.equals("null")){
    		COD_RUB="";
    	}
    	
    	if(OBS_PROD==null || OBS_PROD.equals("null")){
    		OBS_PROD="";
    	}
    	
    	if(EST_PROD==null || EST_PROD.equals("null")){
    		EST_PROD="";
    	}
    	
    	if(peso==null || peso.equals("null")){
    		peso="";
    	}
    	
    	if(act==null || act.equals("null")){
    		act="";
    	}
    	
    	if(ESP_PROD==null || ESP_PROD.equals("null")){
    		ESP_PROD="";
    	}
    	
    	if(MAR_PROD==null || MAR_PROD.equals("null")){
    		MAR_PROD="";
    	}
    	
    	if(CODPROD_PROD==null || CODPROD_PROD.equals("null")){
    		CODPROD_PROD="";
    	}
    	
    	
	   	AccesoBD objAccesoBD=  new AccesoBD();
	   	
	   	try{
			objAccesoBD.crearConexion();
				
				String sql="UPDATE tb_producto SET NOM_PROD='"+NOM_PROD+"'," +
						"COD_RUBRO='"+COD_RUB+"',"+
						"OBS_PROD='"+OBS_PROD+"' , EST_PROD='"+EST_PROD+"' , PESO_PROD='"+peso+"', " +
						"MOD_PROD='"+MOD_PROD+"',ESP_PROD='"+ESP_PROD+"',MAR_PROD='"+MAR_PROD+"',CODPRO_PROD='"+CODPROD_PROD+"' "+
						"WHERE COD_PROD='"+COD_PROD+"';";
			System.out.println(sql);
	
			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				System.out.println("Hubo un ERROR al Modificar los datos");
			}else{
				System.out.println("Se Modificaron Correctamente ");
			}
			
	   	}finally{
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
		}
		
		
	}
    
  /***************************************************************************************************************/
    
	public void cargarProductos(){
	
	int tam=objProd.tamaño();
	System.out.println("ESTE ES EL TAMAÑO DE TRANSPRODUCTO:"+tam);
	
	int fila=0;
	int contaInsert=0,contaUpdate=0;
	
		if(tam>0){		
								
			for (int i = 0; i < objProd.tamaño(); i++) {
			
					fila++;
					BeanCargarProductos objExcel=objProd.obtener(i); 
					
					try {
											
						if((encontrarProducto(objExcel.getCod_prod()))==0){
							contaInsert++;
							agregarProductos(objExcel.getNom_prod(),objExcel.getCod_rubro(),
									objExcel.getObs_prod(),objExcel.getEst_prod(),objExcel.getPeso_prod(),
									objExcel.getAct_prod(),objExcel.getMod_prod(),objExcel.getEsp_prod(),
									objExcel.getMar_prod(),objExcel.getCodpro_prod());
						}else{
							contaUpdate++;
							actualizarProductos(objExcel.getCod_prod(),objExcel.getNom_prod(),objExcel.getCod_rubro(),
									objExcel.getObs_prod(),objExcel.getEst_prod(),objExcel.getPeso_prod(),
									objExcel.getAct_prod(),objExcel.getMod_prod(),objExcel.getEsp_prod(),
									objExcel.getMar_prod(),objExcel.getCodpro_prod());
						}
						
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null,"Se detuvo en la fila: "+(fila+1)+" de la plantilla.");
						break;
					}		
			}
			System.out.println("Productos Nuevos: "+contaInsert+"  Productos actualizados: "+contaUpdate);
			JOptionPane.showMessageDialog(null,"Productos Nuevos: "+contaInsert+"  Productos actualizados: "+contaUpdate);
			contaInsert=0;
			contaUpdate=0;			
			
		}
}
 
	/***************************************************************************************************************************************************/
	
	public void busarNombre(){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		ResultSet rs =null;
		String cadena="";
		String reemplazar="";
		int cod=0;
		
		try{
			
			objAccesoBD.crearConexion();
			 
			String sql="SELECT cod_prod, nom_prod from tb_producto "+
					   "WHERE nom_prod like'%"+txtBuscar.getText().trim()+"%'and est_prod='ACTIVADO';";
			
			rs = objAccesoBD.ejecutarConsulta(sql);		
			
			 	while(rs.next()){			
			 		cod=rs.getInt(1);
			 		cadena=(rs.getString(2)).toLowerCase().trim();
			 		
			 		BeanMantProducto obj= new BeanMantProducto(""+cod, cadena);
			 		objMant.adicionar(obj);
			 		
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		
		
	}
	
	/***************************************************************************************************************************************************/
	
	public void reemplaza(){
		
		String reemplazar="";
		
		for(int i=0;i<objMant.tamaño();i++){
			BeanMantProducto objmant=objMant.obtener(i);
			
			reemplazar = objmant.getNombreProducto().replace(txtBuscar.getText().toLowerCase().trim(), txtReemplazar.getText().toLowerCase().trim());
	 		reemplazarNombreProducto(eliminarCaracteres(objmant.getCodigoProducto()), reemplazar.toUpperCase());
		}
		
		JOptionPane.showMessageDialog(null,"Termino Correctamente");
	}
	
	public void reemplazarNombreProducto(String codigo,String nombre){
				
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{		
		objAccesoBD.crearConexion();

		String sql="UPDATE tb_producto SET NOM_PROD='"+nombre+"'" +
			       " WHERE COD_PROD='"+codigo+"';";
		System.out.println(sql);
		objAccesoBD.ejecutarActualizacion(sql);
		
		}finally{
		objAccesoBD.cerrarStatement();
		objAccesoBD.cerrarConexion();  
		}
		
	}
	
		public String eliminarCaracteres(String cad){
		
		String palabra="";
		
		for(int i=0;i<cad.length();i++){
			
			if((""+cad.charAt(i)).equals("\"") || (""+cad.charAt(i)).equals("\'")){
				palabra+="";
			}else{
				palabra+=""+cad.charAt(i);
			}
		}
		
		return palabra;
	}
	
	public void iniciar(){
		
		
		timer = new Timer();  
		//le asignamos una tarea al timer  
		timer.schedule(new RemindTask(),0, 1*1000);
		
	}
	
	class RemindTask extends TimerTask {
		  
		  public void run(){
			
			    seg++;
			    //System.out.println("SEG_RUN:"+seg);
			    
			    if(seg==1){  
					buscarProducto();
				}
			    if(seg==3){
			    	timer.cancel();
			    	contador=0;
			    }
		  }
		  
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
			eliminarProducto();
		}
		if(e.getSource()==btnBuscar){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			buscarProducto();
		}
		if(e.getSource()==btnListar){
			listarProducto();
		    System.out.println("ESTO ES:"+txtFormato.getText());
		}	
		if(e.getSource()==btnCargar){
			abrirArchivo();
			cargarProductos();
			listarProducto();
		}
		if(e.getSource()==btnReemplazar){
			busarNombre();
			reemplaza();
			listarProducto();
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
			
            int n=modelo2.getRowCount();

			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			
			contador++;
			//System.out.println("CONTA:"+contador);
			seg=0;
			if(contador==1){
				iniciar();
			}
			
		}
		
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}

}
