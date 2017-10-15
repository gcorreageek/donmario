package pOp;


import gui.BuscarProducto;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
public class MantProducto extends JDialog implements ActionListener, MouseListener, KeyListener {
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
    BuscarProducto objprod;	

	
	int seg;
    Timer timer;
	int contador; 

	String titulo2[]={"COD_PROD","NOM_PROD","COD_RUBRO","RUBRO","OBS_PROD","PESO","MODELO","MARCA","COD.PROMELSA","ESPECIFICACION"};
			
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 String  COD_PROD;
	 String codprod="",nomprod="";
	 private JTextField txtCodPromelsa;
	 private JTextField txtMarca;
	 private JLabel lblCodPromelsa;
	 private JLabel lblMarca;
	 private JTextArea txtAEspicificacion;
	 private JScrollPane srcEspicificacion;
	 private JLabel lblEspecificacion;
	 private JComboBox cboRubro;
	 public MantProducto(Frame padre){
		 super((Frame)padre, true);
		 initGUI();
	 }
	
	private void initGUI() {
		try {
	
			this.setPreferredSize(new java.awt.Dimension(786, 507));
			this.setBounds(0, 0, 786, 507);
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
				txtNombre.setText(objprod.nombreProducto);
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
				scrProducto.setBounds(12, 215, 752, 198);
				
					
				jTable1 = new JTable();
				scrProducto.setViewportView(jTable1);
				jTable1.setModel(modelo2);
				jTable1.setSize(2004,0);
				jTable1.addMouseListener(this);
					
					
					//setVisible(true);
					buscarProducto();
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
		int cont=0;
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD," +
				" RUB.COD_RUBRO,RUB.NOM_RUBRO,PROD.OBS_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.MAR_PROD,PROD.CODPRO_PROD,PROD.ESP_PROD" +
				" FROM tb_producto PROD " +
				" INNER JOIN tb_rubro RUB" +
				" ON RUB.COD_RUBRO=PROD.COD_RUBRO " +
				" WHERE PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' ORDER BY PROD.NOM_PROD ASC limit 7000;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			
			/*ArrayList lista = new ArrayList ();
			cont++;*/
		
			while(rs.next()){
				//lista.add(rs.getString(2));
				 // muestro la salida desordenada
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
			  /* System.out.println("DESORDENADOS");
			      for (int i = 0; i < 6; i++) {
				    System.out.println (i + " - " + lista.get (i));
				  }
				  // este metodo es el encargado de ordenar la lista
				  Collections.sort (lista);
				  // muestro la salida ordenada
				  System.out.println("ORDENADOS");
				  for (int i = 0; i < lista.size(); i++) {
					  Object obj[]={"",lista.get (i),"",
								"","","",""};
					  modelo2.addRow(obj);
				    //System.out.println (i + " - " + lista.get (i));
				  } */
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
		String peso=txtPeso.getText();
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
			System.out.println("　　　　 GRACIAS insertar producto !!!!!!!");
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
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();

		String NOM_RUB=(String)cboRubro.getSelectedItem();
		if(cboRubro.getSelectedIndex()==0){
			NOM_RUB="56";
		}else{
			NOM_RUB=NOM_RUB.substring(NOM_RUB.indexOf("-")+1,NOM_RUB.length() );
		}
		
	
			String sql="UPDATE tb_producto SET NOM_PROD='"+txtNombre.getText()+"' , " +
				" COD_RUBRO='"+NOM_RUB+"' , "+
				"OBS_PROD='"+txtAObservacionProd.getText()+"' , EST_PROD='"+"ACTIVADO"+"' , PESO_PROD='"+txtPeso.getText()+"', " +
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
	
	/*
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM marcas;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboMarca.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
		
	}*/
	
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
