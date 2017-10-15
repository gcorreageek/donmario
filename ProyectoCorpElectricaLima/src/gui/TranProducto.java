package gui;
import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import miLib.AccesoBD;
import miLib.GUI;
import pOp.BuscarProducto;
import pOp.BuscarProveedor;
import servlet.ServletCargarPrecios;
import servlet.ServletProveProdMarUmed;
import beans.BeanCargarPrecios;
import beans.BeanProveProdMarUmed;

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
public class TranProducto extends JInternalFrame implements MouseListener, ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlPrincipal;
	private JLabel lblNombreContacto;
	private JComboBox cboMarca;
	private JLabel lblCosto;
	private JLabel lblMarca;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnBuscarProveedor;
	private JButton btnCargar;
	private JComboBox cboUMedida;
	private JLabel lblUMedida;
	private JButton btnBuscarProductos;
	private JButton btnListar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JTextArea txtAObservacionD;
	private JScrollPane scrObservacionD;
	private JLabel lblObservacionD;
	private JComboBox cboIgv;
	private JLabel lblIgv;
	private JComboBox cboMoneda;
	private JLabel lblMoneda;
	private JTextField txtCosto;
	private JTextField txtNombreContacto;
	private JTextField txtRuc;
	private JLabel lblRuc;
	private JTextField txtNombreProveedor;
	private JLabel lblNombreProveedor;
	private JPanel pnlProducto;
	private JPanel pnlProveedor;
	private JTable jTable1;
	private JScrollPane scrListaCliente;
	private JScrollPane scrLargo;
	private JPanel AbajoListado;
	private JPanel pnlArriba;
	BuscarProveedor objBuscarProveedor;
	BuscarProducto objBuscarProducto;
	//GLOBALES
	int COD_PROVE,COD_PROD,COD_MAR,COD_UMED,CODIGO_PROVEPRODMARUMED;
	
	public static String  NOMBRE_PROD,NOMBRE_PROVEE;
	//JProgressBar pbar;
	/**
	SELECT PROVE.COD_PROVE , PROVE.NOM_PROVE ,
	PRO.COD_PROD, PRO.NOM_PROD ,MAR.NOM_MAR  ,PRO.UMED_PROD ,PRO.OBS_PROD ,
 	DET.COS_DET,DET.MON_DET ,DET.IGV_DET, DET.OBS_DET
	FROM DET_PROVE_PROD DET INNER JOIN PROVEEDOR PROVE
	ON PROVE.COD_PROVE=DET.COD_PROVE
 	INNER JOIN PRODUCTO PRO
	ON DET.COD_PROD=PRO.COD_PROD
	INNER JOIN MARCAS MAR
	ON PRO.COD_MAR=MAR.COD_MAR;
	 **/

	String titulo2[]={"NPROVE","NPROD","NMAR","UMED"
			,"COS","MONT","IGV","FEC","OBS"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 int  cod1;
	 GUI objGUI;
	 MenuPrincipal objMenuP;
	 ServletProveProdMarUmed objArray= new ServletProveProdMarUmed();
	 ServletCargarPrecios objPrecios= new ServletCargarPrecios();
	 //SwingProgressBarExample objBar = new SwingProgressBarExample();
	 
	public TranProducto() {
		super("Tran Producto", true, true, true, true);
		try {

			setVisible(true);
			this.setIcon(true);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(852, 473));
			pnlPrincipal.setLayout(null);

			pnlArriba = new JPanel();
			pnlPrincipal.add(pnlArriba);
			pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos de la Transaccion"));
			pnlArriba.setLayout(null);
			pnlArriba.setBounds(5, 5, 842, 248);

			AbajoListado = new JPanel();
			pnlPrincipal.add(AbajoListado);
			BorderLayout AbajoListadoLayout = new BorderLayout();
			AbajoListado.setLayout(AbajoListadoLayout);
			AbajoListado.setBounds(12, 288, 832, 180);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(221, 259, 90, 24);
			btnModificar.addKeyListener(this);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(333, 259, 90, 24);
			btnEliminar.addKeyListener(this);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(452, 259, 90, 24);
			btnBuscar.addKeyListener(this);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlPrincipal.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(565, 259, 90, 24);
			btnListar.addKeyListener(this);
			btnListar.addActionListener(this);

			btnAgregar = new JButton();
			pnlPrincipal.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(113, 259, 90, 24);

			btnCargar = new JButton();
			pnlPrincipal.add(btnCargar);
			btnCargar.setText("Cargar Precios");
			btnCargar.setBounds(678, 259, 120, 24);
			btnCargar.addActionListener(this);

			btnAgregar.addKeyListener(this);

			btnAgregar.addActionListener(this);

			scrLargo = new JScrollPane();
			AbajoListado.add(scrLargo, BorderLayout.CENTER);
			scrLargo.setPreferredSize(new java.awt.Dimension(919, 163));
			{
				scrListaCliente = new JScrollPane();
				AbajoListado.add(scrListaCliente, BorderLayout.CENTER);
				scrListaCliente.setBounds(12, 687, 1329, 164);
				scrListaCliente.setSize(2000, 120);
				scrListaCliente.setPreferredSize(new java.awt.Dimension(832, 193));
				{
					jTable1 = new JTable();
					scrListaCliente.setViewportView(jTable1);
					jTable1.setModel(modelo2);
					jTable1.setSize(2000, 120);
					jTable1.addKeyListener(this);
					jTable1.addMouseListener(this);
				}
			}

			pnlProveedor = new JPanel();
			pnlArriba.add(pnlProveedor);
			pnlProveedor.setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
			pnlProveedor.setBounds(17, 19, 812, 70);
			pnlProveedor.setLayout(null);

			pnlProducto = new JPanel();
			pnlArriba.add(pnlProducto);
			pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
			pnlProducto.setBounds(17, 95, 812, 51);
			pnlProducto.setLayout(null);

			lblCosto = new JLabel();
			pnlArriba.add(lblCosto);
			lblCosto.setText("Costo:");
			lblCosto.setBounds(692, 155, 47, 14);

			txtCosto = new JTextField();
			pnlArriba.add(txtCosto);
			txtCosto.setBounds(739, 152, 86, 21);

			lblMoneda = new JLabel();
			pnlArriba.add(lblMoneda);
			lblMoneda.setText("Moneda:");
			lblMoneda.setBounds(449, 155, 59, 14);

			cboMoneda = new JComboBox();
			pnlArriba.add(cboMoneda);
			cboMoneda.addItem("");
			cboMoneda.addItem("$");
			cboMoneda.addItem("S/.");
			cboMoneda.setBounds(513, 152, 67, 21);

			lblIgv = new JLabel();
			pnlArriba.add(lblIgv);
			lblIgv.setText("Igv:");
			lblIgv.setBounds(584, 155, 31, 14);

			cboIgv = new JComboBox();
			pnlArriba.add(cboIgv);
			cboIgv.addItem("");
			cboIgv.addItem("Con IGV");
			cboIgv.addItem("Mas IGV");
			cboIgv.setBounds(615, 152, 73, 21);

			lblObservacionD = new JLabel();
			pnlArriba.add(lblObservacionD);
			lblObservacionD.setText("Observacion:");
			lblObservacionD.setBounds(29, 181, 73, 14);

			scrObservacionD = new JScrollPane();
			pnlArriba.add(scrObservacionD);
			scrObservacionD.setBounds(107, 179, 718, 63);

			cboMarca = new JComboBox();
			pnlArriba.add(cboMarca);
			cboMarca.addItem("VACIO");
			cboMarca.addMouseListener(this);
			cboMarca.setBounds(262, 152, 182, 21);

			lblMarca = new JLabel();
			pnlArriba.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(212, 155, 50, 14);

			lblUMedida = new JLabel();
			pnlArriba.add(lblUMedida);
			lblUMedida.setText("U.Medida:");
			lblUMedida.setBounds(24, 155, 62, 14); 
			
			cboUMedida = new JComboBox();
			pnlArriba.add(cboUMedida);
			cboUMedida.addItem("UMED");
			cboUMedida.setBounds(90, 152, 115, 21);

			txtAObservacionD = new JTextArea();
			scrObservacionD.setViewportView(txtAObservacionD);
			txtAObservacionD.setPreferredSize(new java.awt.Dimension(702, 58));
			txtAObservacionD.addKeyListener(this);

			lblNombre = new JLabel();
			pnlProducto.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(17, 26, 62, 14);

			txtNombre = new JTextField();
			pnlProducto.add(txtNombre);
			txtNombre.setBounds(79, 23, 631, 21);
			txtNombre.addKeyListener(this);

			btnBuscarProductos = new JButton();
			pnlProducto.add(btnBuscarProductos);
			btnBuscarProductos.setText("Buscar");
			btnBuscarProductos.setBounds(716, 19, 81, 26);
			btnBuscarProductos.addKeyListener(this);
			btnBuscarProductos.addActionListener(this);

			lblNombreProveedor = new JLabel();
			pnlProveedor.add(lblNombreProveedor);
			lblNombreProveedor.setText("Nombre:");
			lblNombreProveedor.setBounds(17, 19, 53, 14);

			txtNombreProveedor = new JTextField();
			pnlProveedor.add(txtNombreProveedor);
			txtNombreProveedor.setBounds(70, 16, 641, 21);
			txtNombreProveedor.addKeyListener(this);

			lblRuc = new JLabel();
			pnlProveedor.add(lblRuc);
			lblRuc.setText("Ruc:");
			lblRuc.setBounds(17, 44, 34, 14);

			txtRuc = new JTextField();
			pnlProveedor.add(txtRuc);
			txtRuc.setBounds(70, 41, 130, 21);

			lblNombreContacto = new JLabel();
			pnlProveedor.add(lblNombreContacto);
			lblNombreContacto.setText("N.Contacto:");
			lblNombreContacto.setBounds(206, 44, 91, 14);

			txtNombreContacto = new JTextField();
			pnlProveedor.add(txtNombreContacto);
			txtNombreContacto.setBounds(297, 41, 414, 21);

			btnBuscarProveedor = new JButton();
			btnBuscarProveedor.setLayout(null);
			pnlProveedor.add(btnBuscarProveedor);
			btnBuscarProveedor.setText("Buscar");
			btnBuscarProveedor.setBounds(717, 19, 84, 38);
			btnBuscarProveedor.addKeyListener(this);
			btnBuscarProveedor.addActionListener(this);
			
			
			
			listarDetalle();
			cargarMarcas();
			cargarUMed();
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/********LISTAR DETALLES************************/
	public void listarDetalle(){
		objArray.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs =null;
		try{
		objAccesoBD.crearConexion();
		String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE , PROVE.NOM_PROVE ,"+
			" PROD.COD_PROD, PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR,"+
 			" UMED.COD_UMED,UMED.NOM_UMED, "+
			" DET.COS_DET,DET.MON_DET,DET.IGV_DET, DET.OBS_DET,DET.FEC_DET,DET.EST_DET" +
			" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE " +
			" ON PROVE.COD_PROVE=DET.COD_PROVE " +
			" INNER JOIN tb_producto PROD " +
			" ON DET.COD_PROD=PROD.COD_PROD " +
			" INNER JOIN tb_marcas MAR " +
			" ON DET.COD_MAR=MAR.COD_MAR " +
			" INNER JOIN tb_umed UMED " +
			" ON DET.COD_UMED=UMED.COD_UMED WHERE DET.EST_DET='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
			" ORDER BY DET.fec_det DESC;";
			rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				
		        BeanProveProdMarUmed objProveProdMarUmed=new BeanProveProdMarUmed(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
				rs.getString(9),rs.getDouble(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
		        objArray.adicionar(objProveProdMarUmed);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		/*String titulo2[]={"NPROVE","NPROD","NMAR","UMED"
			,"COS","MONT","IGV","FEC","OBS"};*/
		for (int i = 0; i < objArray.tamaño(); i++) {
			BeanProveProdMarUmed objProveProdMarUmed=objArray.obtener(i) ;
			Object[] array={ objProveProdMarUmed.getNomProve(), objProveProdMarUmed.getNomProd()
					, objProveProdMarUmed.getNomMar(), objProveProdMarUmed.getNomUmed(),
					objProveProdMarUmed.getCosDet(),objProveProdMarUmed.getMonDet() ,
					objProveProdMarUmed.getIgvDet(),objProveProdMarUmed.getFecDet(),
					objProveProdMarUmed.getObsDet()};
			modelo2.addRow(array);
			
		}
		
			
		
		
	}
	/********AGREGAR DETALLE************************/
	public void agregarDetalle(){
		/*String titulo2[]={"COD_PROVE","NOM_PROVE","COD_PROD","NOM_PROD","NOM_MAR","UMED_PROD",
			"OBS_PROD","COS_DET","MON_DET","IGV_DET","OBS_DET"};*/
		//COD_PROD,COD_PROVE,COS_DET,MON_DET,IGV_DET,OBS_DET,EST_DET
		AccesoBD objAccesoBD = new AccesoBD();
		
		try{
			objAccesoBD.crearConexion();
			
			String COS_DET=txtCosto.getText(),MON_DET=(String)cboMoneda.getSelectedItem(),
			IGV_DET=(String)cboIgv.getSelectedItem(),OBS_DET=txtAObservacionD.getText();
			String cbomar=""+cboMarca.getSelectedItem();
			String codmar;
			String cboUMed=""+cboUMedida.getSelectedItem();
			String codUmed;
			int est_rubro1=1;
			if(IGV_DET.equals("Con IGV")){
				IGV_DET="0";
			}else if(IGV_DET.equals("Mas IGV")) {
				IGV_DET="1";
			}else{
				IGV_DET="3";
			}
			if(cbomar.equals("VACIO")){
				codmar="1";
			}else{
					//nommar=cbomar.substring(0, cbomar.indexOf("-"));
			codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
			}
			if(cboUMed.equals("UMED")){
				codUmed="1";
			}else{
					//nommar=cboUMed.substring(0, cboUMed.indexOf("-"));
					codUmed=cboUMed.substring( cboUMed.indexOf("-")+1,cboUMed.length() );
			}
			if(COS_DET.equals("")){
				COS_DET="0";
			}
		
			//tb_prodmarprove
			//cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det
		     
			String insertarPregunta="INSERT INTO tb_proveprodmarumed1(cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det,est_rubro1)" +
					" VALUES('"+COD_PROVE+"','"+COD_PROD+"','"+codmar+"','"+codUmed+"','"
			+COS_DET+"','"+MON_DET+"','"+IGV_DET+"',CONCAT(CURDATE(),'-','"+OBS_DET+"' ),CURDATE(),'"+"ACTIVADO"+"','"+est_rubro1+"');";
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
			
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		listarDetalle();
	}

	public void modificarDetalle(){
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
			
			objAccesoBD.crearConexion();
			String COS_DET=txtCosto.getText().trim(),MON_DET=(String)cboMoneda.getSelectedItem(),
			IGV_DET=(String)cboIgv.getSelectedItem(),OBS_DET=txtAObservacionD.getText();
			if(IGV_DET.equals("Con IGV")){
				IGV_DET="0";
			}else if(IGV_DET.equals("Mas IGV")) {
				IGV_DET="1";
			}else{
				IGV_DET="3";
			}
			
			if(COS_DET.equals("")){
				COS_DET="0";
			}
				//cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det
				String sql="UPDATE tb_proveprodmarumed1 SET " +
					"COS_DET='"+COS_DET+"' , MON_DET='"+MON_DET+"' , "+
					"IGV_DET='"+IGV_DET+"' ,OBS_DET= CONCAT(CURDATE(),'-','"+OBS_DET+"' ), FEC_DET=CURDATE()  "+
					" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
			System.out.println(sql);
	
			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				objGUI.mostrarAviso("Hubo un ERROR al Modificar los datos");
			}else{
				objGUI.mostrarAviso("Se Modificaron Correctamente ");
			}

		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		listarDetalle();
	}

	/********ELIMINAR DETALLE**********************/
	public void eliminarDetalle(){
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
			objAccesoBD.crearConexion();
			//String est="DESACTIVADO";
			String sql="UPDATE tb_proveprodmarumed1 SET " +
			"EST_DET='DESACTIVADO'  "+
			" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
			/*" WHERE COD_PROD='"+COD_PROD+"' AND COD_PROVE='"+COD_PROVE+"' " +
			" AND COD_MAR='"+COD_MAR+"'  AND cod_umed='"+COD_UMED+"' ;";*/
			System.out.println(sql);
	
			
			int op=objAccesoBD.ejecutarActualizacion(sql);
			
			if(op==0){
				objGUI.mostrarAviso("Hubo un ERROR al Eliminar los datos");
			}else{
				objGUI.mostrarAviso("Se Elimino Correctamente ");
				
			}
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		listarDetalle();
	}
	public void eliminarDetalle1(){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
			objAccesoBD.crearConexion();
			//String est="DESACTIVADO";
			String sql="DELETE FROM  tb_proveprodmarumed1 " +
			" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
			System.out.println(sql);
	
			
			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				objGUI.mostrarAviso("Debe Seleccionar el Dato a Eliminar");
			}else{
				objGUI.mostrarAviso("Se Elimino Correctamente ");
				
			}
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		listarDetalle();
	}

	/***********************************************/
	/********BUSCAR DETALLE************************/
	public void buscarDetalle(){
		objArray.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		try{
			objAccesoBD.crearConexion();
			String nomprove=txtNombreProveedor.getText(),nomprod=txtNombre.getText();
			String COS_DET=txtCosto.getText(),IGV_DET=(String)cboIgv.getSelectedItem();
			if(IGV_DET.equals("Con IGV")){
				IGV_DET="0";
			}else if(IGV_DET.equals("Mas IGV")) {
				IGV_DET="1";
			}else{
				IGV_DET="3";
			}
			
			if(COS_DET.equals("")){
				COS_DET="0";
			}
			
			String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE , PROVE.NOM_PROVE ,"+
			" PROD.COD_PROD, PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR,"+
			" UMED.COD_UMED,UMED.NOM_UMED, "+
			" DET.COS_DET,DET.MON_DET,DET.IGV_DET, DET.OBS_DET,DET.FEC_DET,DET.EST_DET" +
			" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE " +
			" ON PROVE.COD_PROVE=DET.COD_PROVE " +
			" INNER JOIN tb_producto PROD " +
			" ON DET.COD_PROD=PROD.COD_PROD " +
			" INNER JOIN tb_marcas MAR " +
			" ON DET.COD_MAR=MAR.COD_MAR " +
			" INNER JOIN tb_umed UMED " +
			" ON DET.COD_UMED=UMED.COD_UMED WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO'" +
			" AND PROD.NOM_PROD LIKE '%"+nomprod+"%' AND PROVE.NOM_PROVE LIKE '%"+nomprove+"%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det" +
			" ORDER BY DET.fec_det DESC;";
			System.out.println(sql);
			
			rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				
				BeanProveProdMarUmed objProveProdMarUmed=new BeanProveProdMarUmed(rs.getString(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
		        rs.getString(9),rs.getDouble(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
		        objArray.adicionar(objProveProdMarUmed);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		
		/*String titulo2[]={"NPROVE","NPROD","NMAR","UMED"
			,"COS","MONT","IGV","FEC","OBS"};*/
		for (int i = 0; i < objArray.tamaño(); i++){
			BeanProveProdMarUmed objProveProdMarUmed=objArray.obtener(i) ;
			Object[] array={ objProveProdMarUmed.getNomProve(), objProveProdMarUmed.getNomProd()
					, objProveProdMarUmed.getNomMar(), objProveProdMarUmed.getNomUmed(),
					objProveProdMarUmed.getCosDet(),objProveProdMarUmed.getMonDet() ,
					objProveProdMarUmed.getIgvDet(),objProveProdMarUmed.getFecDet(),
					objProveProdMarUmed.getObsDet()};
			modelo2.addRow(array);
			
		}
	}
	/***********************************************/

	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarDetalle(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		BeanProveProdMarUmed objProveProdMarUmed=objArray.obtener(fila) ;
		String nom_igv;//int COD_PROVE,COD_PROD,COD_MAR,COD_UMED;
		//Cargar los datos de la fila seleccionada al panel de datos
		CODIGO_PROVEPRODMARUMED=Integer.parseInt(objProveProdMarUmed.getCodigo_proveprodmarumed());
		COD_PROVE=Integer.parseInt(objProveProdMarUmed.getCodProve());
		txtNombreProveedor.setText(objProveProdMarUmed.getNomProve());
		//System.out.println(""+modelo2.getValueAt(fila, 0));
		COD_PROD=Integer.parseInt(objProveProdMarUmed.getCodProd());
		txtNombre.setText(objProveProdMarUmed.getNomProd());
		COD_MAR=Integer.parseInt(objProveProdMarUmed.getCodMar()) ;
		String nom_mar=objProveProdMarUmed.getNomMar(),
		uni=nom_mar+"-"+COD_MAR;
		System.out.println("LA MARCA MAS - Y COD:"+uni);
		cboMarca.setSelectedItem(uni);
		COD_UMED=Integer.parseInt(objProveProdMarUmed.getCodUmed()) ;
		String nom_UMED=objProveProdMarUmed.getNomUmed(),
		uni2=nom_UMED+"-"+COD_UMED;
		System.out.println("LA MARCA MAS - Y COD:"+uni);
		cboUMedida.setSelectedItem(uni2);
		txtCosto.setText(""+objProveProdMarUmed.getCosDet());
		cboMoneda.setSelectedItem(objProveProdMarUmed.getMonDet());
		int sale_igv=Integer.parseInt(objProveProdMarUmed.getIgvDet());
		if(sale_igv==0){
			nom_igv="Con IGV";
		}else if(sale_igv==1){
			nom_igv="Mas IGV";
		}else{
			nom_igv="";
		}
		cboIgv.setSelectedItem(nom_igv);
		txtAObservacionD.setText(objProveProdMarUmed.getObsDet());
		System.out.println(objProveProdMarUmed.getObsDet());
		System.out.println(objProveProdMarUmed.getFecDet());
		}
	/***********************************************/
	
	/*
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_marcas;";
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
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_marcas WHERE EST_MAR='ACTIVADO' ORDER BY NOM_MAR;";
		    rs = objAccesoBD.ejecutarConsulta(sql);
						
			while (rs.next()) {
				cboMarca.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		
	}
	public void cargarUMed(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_umed WHERE EST_UMED='ACTIVADO';";
			rs = objAccesoBD.ejecutarConsulta(sql);
						
			while (rs.next()) {
				cboUMedida.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	public void metodoBuscarProd(){
		NOMBRE_PROD=txtNombre.getText();
		System.out.println(NOMBRE_PROD);
		BuscarProducto objBuscarProducto = new BuscarProducto(objMenuP);
		//PruebaJDialog dialogoModal = new PruebaJDialog(objMenuP);
		
	objBuscarProducto.setVisible(true);
		//this.setSize(920, 422);
		//dialogoModal.setSize(920, 422);
	objBuscarProducto.pack();  // para darle tamaño automático a la ventana.
		if(objBuscarProducto.COD_PROD==null){
			System.out.println("ENTRO AL NULL");
		}else{//ACEPTAR 
	
        COD_PROD=Integer.parseInt(objBuscarProducto.COD_PROD);    
        txtNombre.setText(objBuscarProducto.NOM_PROD);
        cboMarca.setSelectedItem(objBuscarProducto.NOM_MAR);
	    }
	}
	
	/*******************************************************************************************************************************/
	
	public void metodoBuscarProve(){
		NOMBRE_PROVEE=txtNombreProveedor.getText();
		BuscarProveedor objBuscarProveedor = new BuscarProveedor(objMenuP);
		//PruebaJDialog dialogoModal = new PruebaJDialog(objMenuP);
		
		objBuscarProveedor.setVisible(true);
		//this.setSize(920, 422);
		//dialogoModal.setSize(920, 422);
		objBuscarProveedor.pack();  // para darle tamaño automático a la ventana.
		if(objBuscarProveedor.nomProve==null){
			System.out.println("ENTRO AL NULL");
		}else{//ACEPTAR 
	
			txtNombreProveedor.setText(objBuscarProveedor.nomProve);
		    txtRuc.setText(objBuscarProveedor.ruc);
		    txtNombreContacto.setText(objBuscarProveedor.NombreContactoProve);
		    COD_PROVE=objBuscarProveedor.codProve;
	   }
	}
	/********ACTUALIZAR ESTADO DEL DETALLE**********************/
	public void actualizarEstDetalle(){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
				objAccesoBD.crearConexion();
				//String est="DESACTIVADO";
				String sql="update tb_proveprodmarumed1 set "+
		          "est_det='DESACTIVADO' where DATE_SUB(CURDATE(),INTERVAL 90 DAY) > fec_det;";
				/*" WHERE COD_PROD='"+COD_PROD+"' AND COD_PROVE='"+COD_PROVE+"' " +
				" AND COD_MAR='"+COD_MAR+"'  AND cod_umed='"+COD_UMED+"' ;";*/
				System.out.println(sql);
		
				
				int op=objAccesoBD.ejecutarActualizacion(sql);
				if(op==0){
					System.out.println("Hubo un ERROR al Eliminar los datos");
				}else{
					System.out.println("Se actualizo est_det Correctamente");
					
				}

		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
	}
	/******************************************************************************************************/
	
	public void actualizarProducto(int num,int cprod){
		
		int codi_prod=0;
		
		if(cprod ==0){
			codi_prod=COD_PROD;
		}else{
			codi_prod=cprod;
		}
		
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
		objAccesoBD.crearConexion();
		String sql="update tb_producto set "+
          "act_prod='"+num+"' where cod_prod='"+codi_prod+"';";
		System.out.println(sql);

		
		int op=objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			System.out.println("Hubo un ERROR al actualizar ACT_PROD");
		}else{
			System.out.println("Se actualizo Correctamente");
			
		}
		
		}finally{
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		
		
	}
	
	/********CODIGO DE LA ULTIMA FECHA************************/
	public int codigoFecha(){
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs=null;
		
		try{
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
			rs = objAccesoBD.ejecutarConsulta(sql);
			
				while(rs.next()){
					int cod=Integer.parseInt(rs.getString(1));
					return cod;		
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}

		return 0;
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
	        	objPrecios.cargarExcel(vieneArchivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true; 
	}	
	/**
	 * 
	 * ********************************************************************************************************/
		
	public void updateBar(int newValue) {
		//pbar.setValue(newValue);
	}
	
	public void compararProdPrecios(){
		
		int tam=objPrecios.tamaño();
		System.out.println("ESTE ES EL TAMAÑO DE TRANSPRODUCTO:"+tam);
		int codprove=0,codrubro=0,codmar=0,codumed=0,cod_prod=0,cod_prod2=0;
		String modelo="",descripcion="";
		int contInsert=0,contUpdate=0,
				contaProducto=0,fila=0;
				
		
//		ProgressBarStep obj= new ProgressBarStep();
//		obj.setVisible(true);
//		obj.ejecutar(50);
		
			if(tam>0){		
									
				for (int i = 0; i < objPrecios.tamaño(); i++) {
						
						fila++;
						BeanCargarPrecios objExcel=objPrecios.obtener(i); 
						try {
							descripcion=objExcel.getDescripcion();
							modelo=objExcel.getModelo();
							System.out.println("COD_PROVE: "+objExcel.getCod_prove());							
							codprove=Integer.parseInt(objExcel.getCod_prove());
							codmar=Integer.parseInt(objExcel.getCod_mar());
							codumed=Integer.parseInt(objExcel.getCod_umed());
							codrubro=Integer.parseInt(objExcel.getCod_rubro());
							cod_prod=encontrarProducto(objExcel.getCodProducto());
							System.out.println(cod_prod+"---"+descripcion+"---"+modelo+"---"+codprove+"---"+codmar+"---"+codumed+"---"+codrubro+"---"+cod_prod+" int "+"\n");
							
							if(cod_prod==0){
								agregarProducto(codrubro, descripcion, modelo);
								cod_prod2=encontrarUltimoProducto();
								contInsert++;
								contaProducto++;
								agregarPreciosxProductos(codprove,cod_prod2,codmar,codumed,objExcel.getCos_det(),
										objExcel.getMon_det(),objExcel.getIgv_det());
								//actualizarEstDetalle();
								actualizarProducto(1,cod_prod2);
								
							}else{
								
								if(encontrarTransaccion(codprove,cod_prod,codmar,codumed).equals("") || 
										encontrarTransaccion(codprove,cod_prod,codmar,codumed).equals("0")){
									contInsert++;
									agregarPreciosxProductos(codprove,cod_prod,codmar,codumed,objExcel.getCos_det(),
											objExcel.getMon_det(),objExcel.getIgv_det());
									actualizarProducto(1,cod_prod);
								}else{
									contUpdate++;
									actualizarPreciosxProductos(codprove,cod_prod,codmar,codumed,objExcel.getCos_det(),
											objExcel.getMon_det(),objExcel.getIgv_det());
									actualizarProducto(1,cod_prod);
								}
							}
							
						}catch (Exception e) {
							JOptionPane.showMessageDialog(null,"Se detuvo en la fila: "+(fila+1)+" de la plantilla.");
							break;
						}		
				}
				
				System.out.println("ESTE ES EL TAMAÑO DE DATOS:"+tam);
				System.out.println("Productos nuevos: "+contaProducto+"  "+"Precios nuevos: "+contInsert+"  "+"Precios actualizados: "+contUpdate);
				JOptionPane.showMessageDialog(null,"Productos nuevos: "+contaProducto+"  "+"Precios nuevos: "+contInsert+"  "+"Precios actualizados: "+contUpdate);
				contInsert=0;
				contUpdate=0;
				contaProducto=0;
			}
	}
	/***************************************************************************************************/
     public String  encontrarTransaccion(int prove, int prod, int mar, int umed){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		ResultSet rs=null;
		String nom="";
		
		try{
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_proveprodmarumed1 "+
                    " where cod_prove='"+prove+"' and cod_prod='"+prod+"' and cod_mar='"+mar+"' " +
                    " and cod_umed='"+umed+"' and est_det='ACTIVADO' limit 1;";
		//System.out.println(sql);
		rs = objAccesoBD.ejecutarConsulta(sql);
		
		
		if(rs.next()){
			String codi=""+rs.getInt(1);
			nom=codi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
		return nom;
	}
     
     /***************************************************************************************************/
     public int encontrarProducto(String codigo){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		ResultSet rs =null;
		int cod=0;
		try{
			
		objAccesoBD.crearConexion();
		 
		String sql="SELECT * FROM tb_producto "+
                    " where cod_prod='"+codigo+"' and est_prod='ACTIVADO' ;";
		
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
     
     /***************************************************************************************************/
     public int encontrarUltimoProducto(){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		ResultSet rs =null;
		int cod=0;
		try{
			
		objAccesoBD.crearConexion();
		 
		String sql="SELECT max(cod_prod) FROM tb_producto "+
                   "WHERE est_prod='ACTIVADO';";
		
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
     int ayayaya=0;
     public void agregarPreciosxProductos(int prove, int cod_prod, int mar, int umed,String cos_det,String mon_det,String igv_det){
    	 
 		AccesoBD objAccesoBD = new AccesoBD();
 		try{
 		objAccesoBD.crearConexion();
 		     
 			String insertarPregunta="INSERT INTO tb_proveprodmarumed1(cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det,est_rubro1)" +
 					" VALUES('"+prove+"','"+cod_prod+"','"+mar+"','"+umed+"','"
 			+cos_det+"','"+mon_det+"','"+igv_det+"',CONCAT(CURDATE(),'-','' ),CURDATE(),'"+"ACTIVADO"+"','1');";
 			System.out.println(""+ayayaya+" "+insertarPregunta);
 			ayayaya++;
 			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
 			if(op==0){
 				System.out.println("Hubo un ERROR al Ingresar los datos");
 			}	
 			else{
 				System.out.println("Se ingreso Correctamente ");
 			}
 		}finally{
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
 		    
 	}
   /***************************************************************************************************************/
     public void actualizarPreciosxProductos(int prove, int prod, int mar, int umed, String cos_det,String mon_det,String igv_det){
 		
    	AccesoBD objAccesoBD=  new AccesoBD();
    	
    	try{
 		objAccesoBD.crearConexion();
 			
 		String sql="UPDATE tb_proveprodmarumed1 SET " +
 				"COS_DET='"+cos_det+"' , MON_DET='"+mon_det+"' , "+
 				"IGV_DET='"+igv_det+"' ,OBS_DET= CONCAT(CURDATE(),'-','' ), FEC_DET=CURDATE()  "+
 				" WHERE COD_PROVE='"+prove+"' and COD_PROD='"+prod+"' and COD_MAR='"+mar+"' and COD_UMED='"+umed+"' " +
 				" and EST_DET='ACTIVADO';";
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
 
 	public void agregarProducto(int cod_rubro,String descripcion,String modelo){

 		
 		AccesoBD objAccesoBD = new AccesoBD();
 		
 		try{
 			
	 		objAccesoBD.crearConexion(); 		
	 		String insertarPregunta="INSERT INTO tb_producto VALUES("+null+",'"+descripcion+"','"
	 		+cod_rubro+"',CONCAT(CURDATE(),'-','' ),'ACTIVADO','','0','"+modelo.trim()+"','','','')";
	 		//System.out.println("ESTO SALE ANTES DE INGRESAR Y ERROR:"+insertarPregunta);
	
	 		int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
	 		//System.out.println(insertarPregunta);
	 		if(op==0){
	 			System.out.println("Hubo un error al Ingresar el producto");
	 		}
	 		else{
	 			System.out.println("Se ha ingresado satisfactoriamenete el producto");
	 		}
 		
 		}finally{
 			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
 		}
 		
 	}
   /****************************************************************************************************************/
     public void limpia(){
		cboUMedida.setSelectedIndex(0);
		cboMarca.setSelectedIndex(0);
		cboMoneda.setSelectedIndex(0);
		cboIgv.setSelectedIndex(0);
		txtCosto.setText("");
		txtAObservacionD.setText("");
		
	}

	
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnBuscarProveedor){
		
		metodoBuscarProve();
	}
	
	if(e.getSource()==btnBuscarProductos){
		metodoBuscarProd();
		
	}
	
	
	if(e.getSource()==btnAgregar){
		
		agregarDetalle();
		//actualizarEstDetalle();
		actualizarProducto(1,0);
		limpia();
		}
	if(e.getSource()==btnModificar){
		modificarDetalle();
		actualizarProducto(1,0);
		limpia();
	}
	if(e.getSource()==btnBuscar){
		buscarDetalle();
	}
	if(e.getSource()==btnListar){
		listarDetalle();
		limpia();
	}
	if(e.getSource()==btnEliminar){
		eliminarDetalle();
		actualizarProducto(0,0);
		limpia();
	}
	
	if(e.getSource()==btnCargar){
		
		abrirArchivo();
		compararProdPrecios();
		listarDetalle();
		limpia();
	}
	
	}
	
	/***********EVENTOS DE CARGA PARA EL COMBOBOX MARCAS*************/
	
	public void mouseClicked(MouseEvent e) {
	
		
	}
	/*****************************************************************/
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarDetalle();}}
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtNombre){
		int key = e.getKeyCode();
		if(KeyEvent.VK_ENTER==key){
			metodoBuscarProd();
			txtNombre.requestFocus();
		}	
		if(KeyEvent.VK_DOWN==key){//flecha abajo
			System.out.println("este es el down");
			cboUMedida.requestFocus();
			
		}
		if(KeyEvent.VK_LEFT==key){//izquierda
			System.out.println("este es el left");
		}
		if(KeyEvent.VK_RIGHT==key){//derecha
			System.out.println("este es el right");		
		}
		if(KeyEvent.VK_UP==key){//arriba
			System.out.println("este es el up");
		}
		}
		if(e.getSource()==txtNombreProveedor){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				metodoBuscarProve();
				txtNombreProveedor.requestFocus();
				//setVisible(false);
			}
			if(KeyEvent.VK_DOWN==key){//flecha abajo
				System.out.println("este es el down");
				txtNombre.requestFocus();
			}
		}
		if(e.getSource()==txtAObservacionD){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key||KeyEvent.VK_TAB==key||KeyEvent.VK_DOWN==key){
				btnAgregar.requestFocus();
			}
		}
		if(e.getSource()==jTable1){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				cargarDetalle();
			}
			if(KeyEvent.VK_TAB==key){
				txtNombreProveedor.requestFocus();
			}
		}
	
		
		/**************************************************************************************************/
		/*                      PARA LOS "ENTER" EN LOS BOTONES  										 */
		if(e.getSource()==btnBuscarProveedor){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				metodoBuscarProve();
				//setVisible(false);
			}
		
		}
		if(e.getSource()==btnBuscarProductos){
			int key = e.getKeyCode();
			NOMBRE_PROD=txtNombre.getText();
			if(KeyEvent.VK_ENTER==key){
				metodoBuscarProd();
				NOMBRE_PROD=txtNombre.getText();
				//setVisible(false);
			}
			
		}
		
		
		
		if(e.getSource()==btnAgregar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				agregarDetalle();
				//setVisible(false);
			}

			if(KeyEvent.VK_LEFT==key){//izquierda
				System.out.println("este es el left");
				txtAObservacionD.requestFocus();
			}
			
			if(KeyEvent.VK_RIGHT==key){//derecha
				System.out.println("este es el right");	
				btnModificar.requestFocus();
			}
			
			}
		if(e.getSource()==btnModificar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				modificarDetalle();
				//setVisible(false);
			}
			if(KeyEvent.VK_LEFT==key){//izquierda
				System.out.println("este es el left");
				btnAgregar.requestFocus();
			}
			
			if(KeyEvent.VK_RIGHT==key){//derecha
				System.out.println("este es el right");	
				btnEliminar.requestFocus();
			}
		
		}
		if(e.getSource()==btnEliminar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				eliminarDetalle();
				//setVisible(false);
			}
			if(KeyEvent.VK_LEFT==key){//izquierda
				System.out.println("este es el left");
				btnModificar.requestFocus();
			}
			
			if(KeyEvent.VK_RIGHT==key){//derecha
				System.out.println("este es el right");	
				btnBuscar.requestFocus();
			}
			
		}
		if(e.getSource()==btnBuscar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				buscarDetalle();
				//setVisible(false);
			}
			if(KeyEvent.VK_LEFT==key){//izquierda
				System.out.println("este es el left");
				btnEliminar.requestFocus();
			}
			
			if(KeyEvent.VK_RIGHT==key){//derecha
				System.out.println("este es el right");	
				btnListar.requestFocus();
			}
		
		}
		if(e.getSource()==btnListar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				listarDetalle();
				//setVisible(false);
			}
			if(KeyEvent.VK_LEFT==key){//izquierda
				System.out.println("este es el left");
				btnBuscar.requestFocus();
				
			}
			
			if(KeyEvent.VK_RIGHT==key){//derecha
				System.out.println("este es el right");	
				jTable1.requestFocus();
			}
			
		}
		
		/**************************************************************************************************/
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
