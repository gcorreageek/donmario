package gui;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.GUI;
import pOp.BuscarProveedor1;
import servlet.ServletBuscarProdCoti;
import servlet.ServletTranMantProd;
import beans.BeanBuscarProdCoti;
import beans.BeanTranMantProd;

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
public class BuscarProductoCotizacion extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblProducto;
	private JButton btnBorrar;
	private JTextField txtPromelsa;
	private JLabel lblCodPromelsa;
	private JTextField txtModelo;
	private JButton btnBuscar2;
	private JLabel lblModelo;
	private JPanel pnlBusProd;
	private JPanel pnlTransProducto;
	private JButton btnProcesar;
	private JComboBox cboRubro;
	private JLabel lblRubro;
	private JLabel lblProveedor;
	private JTextField txtProveedor;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JTextField txtProducto;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JTextField txtProducto2;
	private JComboBox cboMarca;
	private JComboBox cboProducto2;
	private JComboBox cboProducto1;
	private JPanel pnlCentro;
	MenuPrincipal objMenuP;
	private JLabel lblMarca1;
	private JComboBox cboMarca1;
	private JLabel lblUMedida;
	private JComboBox cboUMedida;
	private JButton btnModificar;
	private JLabel lblMoneda;
	private JComboBox cboMoneda;
	private JLabel lblIgv;
	private JComboBox cboIgv;
	private JLabel lblCosto;
	private JTextField txtCosto;
	TranCotizacionAutomatica objTranCotAut;
	String act_prod;
    
	
	String titulo2[]={"COD","PRODUCTO","COSTE","CMAR","MARCA","MODELO","CUMED","UMED","FECHA","COD_PROV","PROVEEDOR","COD_PROD","NOM_PROD"};

	public static String  COD_PROD=null,NOM_PROD,COSTE,COD_MAR,MARCA,COD_UMED,UMED,FECHA,COD_PROVEE,
	PROVEEDOR,COD_PROD1,NOM_PROD1,PESO_PROD,NOM_PRODUCTO,COD_RUBRO,NOM_RUBRO;
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	String NOMBREPROD;
	ServletBuscarProdCoti objSB=new ServletBuscarProdCoti();
	int conta,est,est1,COD_PROVE,contador;
    GUI objGUI;
    public static String  NOMBRE_PROVEE;
    ServletTranMantProd objTranMantProd= new ServletTranMantProd();
    TableCellRenderer renderer = new CustomTableCellRendererBP2();
    int segundos;
    private JCheckBox chkRubro;
	public boolean frozen;
	Timer timer = new Timer();
    
	public  BuscarProductoCotizacion(Frame padre) {
		
		 // padre y modal
	    super( (Frame)padre, true);
		try {
			COD_PROD=null;
				this.setPreferredSize(new java.awt.Dimension(1054, 467));
				this.setBounds(0, 0, 1054, 467);
				
					pnlArriba = new JPanel();
					pnlArriba.setLayout(null);
					getContentPane().add(pnlArriba, BorderLayout.NORTH);
					pnlArriba.setPreferredSize(new java.awt.Dimension(1038, 165));

					lblRubro = new JLabel();
					pnlArriba.add(lblRubro);
					lblRubro.setText("Rubro:");
					lblRubro.setBounds(555, 8, 45, 16);

					cboRubro = new JComboBox();
					pnlArriba.add(cboRubro);
					cboRubro.addItem("");
					cboRubro.setBounds(621, 6, 218, 23);

					btnProcesar = new JButton();
					pnlArriba.add(btnProcesar);
					btnProcesar.setText("Guardar Producto");
					btnProcesar.setBounds(845, 6, 160, 23);

					pnlTransProducto = new JPanel();
					pnlArriba.add(pnlTransProducto);
					pnlTransProducto.setBorder(BorderFactory.createTitledBorder("Transaccion Producto"));
					pnlTransProducto.setBounds(556, 30, 449, 128);
					pnlTransProducto.setLayout(null);

					pnlBusProd = new JPanel();
					pnlArriba.add(pnlBusProd);
					pnlBusProd.setBorder(BorderFactory.createTitledBorder("Datos Productos-Proveedor"));
					pnlBusProd.setBounds(6, 6, 544, 152);
					pnlBusProd.setLayout(null);
					{
						chkRubro = new JCheckBox();
						pnlArriba.add(chkRubro);
						chkRubro.setBounds(596, 10, 19, 17);
					}

					lblProveedor = new JLabel();
					pnlBusProd.add(lblProveedor);
					lblProveedor.setText("Proveedor:");
					lblProveedor.setBounds(7, 97, 70, 16);

					txtProveedor = new JTextField();
					pnlBusProd.add(txtProveedor);
					txtProveedor.setBounds(76, 95, 462, 23);

					txtProducto2 = new JTextField();
					pnlBusProd.add(txtProducto2);
					txtProducto2.setBounds(76, 70, 462, 23);

					cboMarca = new JComboBox();
					pnlBusProd.add(cboMarca);
					cboMarca.addItem("");
					cboMarca.setBounds(388, 45, 150, 23);

					cboProducto2 = new JComboBox();
					pnlBusProd.add(cboProducto2);
					cboProducto2.setBounds(232, 45, 150, 23);

					cboProducto1 = new JComboBox();
					pnlBusProd.add(cboProducto1);
					cboProducto1.addItem("");
					cboProducto1.setBounds(76, 45, 150, 23);

					txtProducto = new JTextField();
					pnlBusProd.add(txtProducto);
					txtProducto.setText(objTranCotAut.nombreProd);
					txtProducto.setBounds(76, 21, 462, 23);

					lblProducto = new JLabel();
					pnlBusProd.add(lblProducto);
					lblProducto.setText("Producto:");
					lblProducto.setBounds(10, 25, 62, 16);
					
					lblModelo = new JLabel();
					pnlBusProd.add(lblModelo);
					lblModelo.setText("Modelo:");
					lblModelo.setBounds(24, 125, 47, 16);
				
				
					btnBuscar2 = new JButton();
					pnlBusProd.add(btnBuscar2);
					btnBuscar2.setText("Buscar");
					btnBuscar2.setBounds(386, 122, 75, 23);
					btnBuscar2.addActionListener(this);
					
					
					txtModelo = new JTextField();
					pnlBusProd.add(txtModelo);
					txtModelo.setBounds(76, 122, 117, 23);
				
				
					lblCodPromelsa = new JLabel();
					pnlBusProd.add(lblCodPromelsa);
					lblCodPromelsa.setText("Cod.Promelsa:");
					lblCodPromelsa.setBounds(195, 125, 86, 16);
				
				
					txtPromelsa = new JTextField();
					pnlBusProd.add(txtPromelsa);
					txtPromelsa.setBounds(284, 122, 100, 24);
				
				
					btnBorrar = new JButton();
					pnlBusProd.add(btnBorrar);
					btnBorrar.setText("Borrar");
					btnBorrar.setBounds(463, 122, 75, 23);
					btnBorrar.addActionListener(this);
					

					txtProducto.addActionListener(this);
					cboProducto1.addActionListener(this);
					cboProducto2.addActionListener(this);
					cboMarca.addActionListener(this);
					txtProducto2.addKeyListener(this);
					txtProducto2.addActionListener(this);

					btnBuscar = new JButton();
					pnlTransProducto.add(btnBuscar);
					btnBuscar.setText("B");
					btnBuscar.setBounds(334, 20, 42, 23);

					btnEliminar = new JButton();
					pnlTransProducto.add(btnEliminar);
					btnEliminar.setText("E");
					btnEliminar.setBounds(380, 20, 41, 23);

					btnAgregar = new JButton();
					pnlTransProducto.add(btnAgregar);
					btnAgregar.setText("Agregar");
					btnAgregar.setBounds(330, 76, 92, 21);

					lblMarca1 = new JLabel();
					pnlTransProducto.add(lblMarca1);
					lblMarca1.setText("Marca:");
					lblMarca1.setBounds(221, 53, 45, 16);

					cboMarca1 = new JComboBox();
					pnlTransProducto.add(cboMarca1);
					cboMarca1.addItem("");
					cboMarca1.setBounds(265, 49, 157, 21);

					lblUMedida = new JLabel();
					pnlTransProducto.add(lblUMedida);
					lblUMedida.setText("U.Medida:");
					lblUMedida.setBounds(62, 75, 62, 17);

					cboUMedida = new JComboBox();
					pnlTransProducto.add(cboUMedida);
					cboUMedida.addItem("");
					cboUMedida.setBounds(122, 76, 84, 21);
						

					btnModificar = new JButton();
					pnlTransProducto.add(btnModificar);
					btnModificar.setText("modificar");
					btnModificar.setBounds(218, 76, 96, 21);

					lblMoneda = new JLabel();
					pnlTransProducto.add(lblMoneda);
					lblMoneda.setText("Moneda:");
					lblMoneda.setBounds(69, 23, 60, 15);

					cboMoneda = new JComboBox();
					pnlTransProducto.add(cboMoneda);
					cboMoneda.addItem("");
					cboMoneda.addItem("$");
					cboMoneda.addItem("S/.");
					cboMoneda.setBounds(122, 19, 84, 23);

					lblIgv = new JLabel();
					pnlTransProducto.add(lblIgv);
					lblIgv.setText("Igv:");
					lblIgv.setBounds(97, 52, 32, 13);

					cboIgv = new JComboBox();
					pnlTransProducto.add(cboIgv);
					cboIgv.addItem("");
					cboIgv.addItem("Con IGV");	
					cboIgv.addItem("Mas IGV");
					cboIgv.setBounds(122, 49, 84, 21);

					lblCosto = new JLabel();
					pnlTransProducto.add(lblCosto);
					lblCosto.setText("Costo:");
					lblCosto.setBounds(219, 26, 54, 15);

					txtCosto = new JTextField();
					pnlTransProducto.add(txtCosto);
					txtCosto.setBounds(263, 20, 64, 23);

					btnModificar.addActionListener(this);

					btnAgregar.addActionListener(this);

					btnEliminar.addActionListener(this);

					btnBuscar.addActionListener(this);

					btnProcesar.addActionListener(this);

					pnlAbajo = new JPanel();
					getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
					pnlAbajo.setPreferredSize(new java.awt.Dimension(968, 14));

					pnlCentro = new JPanel();
					GridLayout pnlCentroLayout = new GridLayout(1, 1);
					pnlCentroLayout.setHgap(5);
					pnlCentroLayout.setVgap(5);
					pnlCentroLayout.setColumns(1);
					pnlCentro.setLayout(pnlCentroLayout);
					getContentPane().add(pnlCentro, BorderLayout.CENTER);
					pnlCentro.setPreferredSize(new java.awt.Dimension(1038, 181));

					jScrollPane1 = new JScrollPane();
					pnlCentro.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(1038, 175));

					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(modelo2);
					jTable1.addMouseListener(this);

					TableColumn Prod = jTable1.getColumn ("PRODUCTO");
					Prod.setPreferredWidth(450);
					
					try {
						buscarProducto1();//ESTE METODO CARGA EL COMBO PRODUCTO 1(cboProducto1)
						buscarProdxCaracter();//ESTE METODO CARGA EL COMBO PRODUCTO 2(cboProducto2)         
						muestraComboBox();
						buscarDetalle4();
						//buscarprodfaltantes();
						conta=0;
						cargarMarcas();
						cargarRubro();
						//APARTIR DE ACA SE CARGAN LOS COMBO DE MARCA Y U.MEDIDA
						cargarMarcas1();
						cargarUMed();
						start(1);

					} catch (Exception e) {
						
					}
					
		} catch(Exception e) { 
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("SALIO");
				segundos=0;
				timer.cancel();
		    }
		});
	}
	
	
	public void muestraComboBox(){
		
		String nomProd=txtProducto.getText();
		String nomProd1,nomProd2;
		nomProd=nomProd.trim();
		nomProd1= nomProd.substring(0, nomProd.indexOf(" "));
		nomProd=nomProd.replaceAll("  ", " ");
		nomProd=nomProd.replaceAll("  ", " ");
		nomProd=nomProd.replaceAll(" PARA ", " ");
		nomProd=nomProd.replaceAll(" TIPO ", " ");
		nomProd=nomProd.replaceAll(" CON ", " ");
		nomProd=nomProd.replaceAll(" DE ", " ");
		nomProd=nomProd.replaceAll("  ", " ");
		nomProd=nomProd.replaceAll("  ", " ");
		nomProd=nomProd+" "+" ";
		nomProd1=nomProd.substring(0, nomProd.indexOf(" "));
		nomProd2=nomProd.substring( nomProd.indexOf(" ")+1, nomProd.indexOf(" ", nomProd.indexOf(" ")+1));
		
		System.out.println("Epale:"+nomProd1);
		System.out.println("Epale:"+nomProd2);
		for (int i = 0; i < cboProducto1.getItemCount(); i++) {
			if(cboProducto1.getItemAt(i).equals(nomProd1)){
				cboProducto1.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < cboProducto2.getItemCount(); i++) {
			if(cboProducto2.getItemAt(i).equals(nomProd2)){
				cboProducto2.setSelectedIndex(i);
			}
		}
		txtProducto2.setText(txtProducto.getText());	
	}
	
	public void buscarNormal(String nom){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		int contCosas=0;
		
		NOMBREPROD=nom;
		
		String nommar,cbomar=""+cboMarca.getSelectedItem();
		cbomar=cbomar.trim();
		if(cbomar.equals("")){
			nommar="%";
		}else{System.out.println(cbomar);
			System.out.println(cbomar.indexOf("-"));
				nommar=cbomar.substring(0, cbomar.indexOf("-"));
		//codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
		}
		
		objSB.eliminarTodo();
		
		try {
			
			objAccesoBD.crearConexion();			
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			"DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			",PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"FROM tb_proveprodmarumed1 DET " +			
			"INNER JOIN tb_producto PROD "+
			"ON DET.COD_PROD=PROD.COD_PROD "+
			"INNER JOIN tb_proveedor PROVE "+
			"ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"INNER JOIN tb_marcas MAR "+
			"ON DET.COD_MAR=MAR.COD_MAR "+
			"INNER JOIN tb_umed UMED "+
			"ON DET.COD_UMED=UMED.COD_UMED "+
			"INNER JOIN tb_rubro RUB "+
			"ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
			"WHERE PROD.NOM_PROD LIKE '"+eliminarCaracteres(NOMBREPROD)+"%' AND MAR.NOM_MAR LIKE '%"+nommar+"%' " +
			"AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ // AND DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc; ";
		
			rs = objAccesoBD.ejecutarConsulta(sql);
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), 
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contCosas=contCosas+1;
    	   contador++;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		
	}
	/**************************************************************************************************************************************/
	
	public void buscarNormalConRubro(String nom,String codRubro){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		int contCosas=0;
		
		NOMBREPROD=nom;
		
		String nommar,cbomar=""+cboMarca.getSelectedItem();
		cbomar=cbomar.trim();
		if(cbomar.equals("")){
			nommar="%";
		}else{System.out.println(cbomar);
			System.out.println(cbomar.indexOf("-"));
				nommar=cbomar.substring(0, cbomar.indexOf("-"));
		//codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
		}
		
		objSB.eliminarTodo();
		
		try {
			
			objAccesoBD.crearConexion();			
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			"DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			",PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"FROM tb_proveprodmarumed1 DET " +			
			"INNER JOIN tb_producto PROD "+
			"ON DET.COD_PROD=PROD.COD_PROD "+
			"INNER JOIN tb_proveedor PROVE "+
			"ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"INNER JOIN tb_marcas MAR "+
			"ON DET.COD_MAR=MAR.COD_MAR "+
			"INNER JOIN tb_umed UMED "+
			"ON DET.COD_UMED=UMED.COD_UMED "+
			"INNER JOIN tb_rubro RUB "+
			"ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
			"WHERE rub.COD_RUBRO='"+codRubro+"' AND PROD.NOM_PROD LIKE '"+eliminarCaracteres(NOMBREPROD)+"%' AND MAR.NOM_MAR LIKE '%"+nommar+"%' " +
			"AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ // AND DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc; ";
		
			rs = objAccesoBD.ejecutarConsulta(sql);
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), 
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contCosas=contCosas+1;
    	   contador++;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		
	}
	/**************************************************************************************************************************************/
	
	public String eliminarCaracteres(String cad){
		
		String palabra="";
		
		for(int i=0;i<cad.length();i++){
			
			if((""+cad.charAt(i)).equals("-") || (""+cad.charAt(i)).equals(" ") || (""+cad.charAt(i)).equals("+")
					|| (""+cad.charAt(i)).equals("/") || (""+cad.charAt(i)).equals("x") || 
					(""+cad.charAt(i)).equals("*")|| (""+cad.charAt(i)).equals(",")){
				palabra+="%";
			}else{
				palabra+=""+cad.charAt(i);
			}
		}
		
		return palabra;
	}
	/************************************************************************************************************************************/
     public void buscar(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs =null;
		int contCosas=0;
		
		PintarTabla();
		try {
			
			objAccesoBD.crearConexion();
		    act_prod="";
		    
		    String modelo="",codpromelsa="";
			   
			   if(txtModelo.getText().equals("")){
				   codpromelsa=" PROD.CODPRO_PROD='"+txtPromelsa.getText().trim()+"' ";
			   }else{
				   modelo=" PROD.MOD_PROD='"+txtModelo.getText().trim()+"' ";
			   }
			
			objSB.eliminarTodo();
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			"DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			",PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
			"ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"INNER JOIN tb_producto PROD "+
			"ON DET.COD_PROD=PROD.COD_PROD "+
			"INNER JOIN tb_marcas MAR "+
			"ON DET.COD_MAR=MAR.COD_MAR "+
			"INNER JOIN tb_umed UMED "+
		    "ON DET.COD_UMED=UMED.COD_UMED "+
			"WHERE "+modelo+codpromelsa+" "+
			"AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ // AND DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"ORDER BY COSTE asc; ";
			
			rs = objAccesoBD.ejecutarConsulta(sql);
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
							rs.getString(16), rs.getString(17),rs.getInt(18));
					act_prod=""+rs.getInt(18);
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contCosas=contCosas+1;
    	   contador++;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}	
		
	}
   /********************************************************************************************************************/
     public void buscar2(){
    	 
		   int n=modelo2.getRowCount();
		   for (int fila=0; fila<n; fila++)
		   modelo2.removeRow(0);
		   
		   String modelo="",codpromelsa="";
		   
		   if(txtModelo.getText().equals("")){
			   codpromelsa="and PROD.CODPRO_PROD='"+txtPromelsa.getText().trim()+"' ";
		   }else{
			   modelo="and PROD.MOD_PROD='"+txtModelo.getText().trim()+"' ";
		   }
    	 
		   objTranMantProd.eliminarTodo();
		   AccesoBD objAccesoBD = new AccesoBD();
		   ResultSet rs = null;
		   
		   try {
			
			objAccesoBD.crearConexion();
			String sql="select prod.COD_PROD,prod.nom_prod,'','','',prod.mod_prod,'','','','','',prod.COD_PROD,prod.nom_prod from tb_producto prod "+
				       "where prod.EST_PROD='ACTIVADO' and prod.EST_PROD='ACTIVADO' " +
				       modelo+codpromelsa+
				       "and prod.ACT_PROD=0 "+
				       "order by prod.NOM_PROD asc;";
			System.out.println(sql);
			rs = objAccesoBD.ejecutarConsulta(sql);			
			
				while (rs.next()) {
					BeanTranMantProd objB=new BeanTranMantProd(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
					        objTranMantProd.adicionar(objB);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				objAccesoBD.cerrarResultSet(rs);
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}

			for (int i = 0; i < objTranMantProd.tamaño(); i++) {
				BeanTranMantProd objBus=objTranMantProd.obtener(i) ;
				
				Object[] array={objBus.getCod_prod1(),objBus.getNom_prod1(),objBus.getCoste(),
						objBus.getCod_mar(),objBus.getNom_mar(),objBus.getMod_prod(),objBus.getCod_umed(),objBus.getNom_umed(),
						objBus.getFecha(),objBus.getCod_prove(),objBus.getNom_prove(),objBus.getCod_prod(),
						objBus.getNom_prod()};
				modelo2.addRow(array);
				
			}
			
		}
		
	/**************************************************************************************************************************************/
	
//	 public int retornaValor(String nom){
//		 
//    	AccesoBD objAccesoBD = new AccesoBD();
//    	ResultSet rs = null;
//    	objSB.eliminarTodo();
//    	int cod = 0;
//    	
//    	try {
//    		
//		objAccesoBD.crearConexion();		
//		String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
//		"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
//		"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
//		" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
//		"  	 ,PROD.COD_PROD,PROD.NOM_PROD ,PROD.PESO_PROD"+
//		"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
//		" 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
//		" 	 INNER JOIN tb_producto PROD "+
//		" 	 ON DET.COD_PROD=PROD.COD_PROD "+
//		" 	 INNER JOIN tb_marcas MAR "+
//		" 	 ON DET.COD_MAR=MAR.COD_MAR "+
//		" 	 INNER JOIN tb_umed UMED "+
//		"    ON DET.COD_UMED=UMED.COD_UMED "+
//		"  	 WHERE PROD.NOM_PROD LIKE '"+nom+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
//		"    AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //AND  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
//		"  	 ORDER BY COSTE asc;";
//	
//		rs = objAccesoBD.ejecutarConsulta(sql);
//
//		
//			while(rs.next()){
//				
//				if(rs.getString(1).equals("")){
//					cod=0;
//				}
//				else{
//					cod=1;
//				}
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			objAccesoBD.cerrarResultSet(rs);
//			objAccesoBD.cerrarStatement();
//			objAccesoBD.cerrarConexion();  
//		}
//	
//		return cod;
//	 } 
	 /*************************************************************************************************************************************/
	 
	 public String cadenaReducida(String cad){
		String cadena="",cadena2="";
		int cont=0;
		for(int i=0;i<cad.length();i++){
			 cadena=""+cad.charAt(i);
			if(cadena.equals("%")){
				cadena2+=cadena;
				cont++;
				if(cont==5){
					break;
				}
			}else{
				cadena2+=cadena;
				
			}
		}
		 return cadena2;
	 }
	 /*************************************************************************************************************************************/
//		public void buscarprodfaltantesq(){
//			/*int n=modelo2.getRowCount();
//			for (int fila=0; fila<n; fila++)
//			modelo2.removeRow(0);*/
//			
//			objTranMantProd.eliminarTodo();
//			AccesoBD objAccesoBD = new AccesoBD();
//			ResultSet rs = null;
//			
//			String NOM_PROD=txtProducto2.getText().trim(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
//			objTranCotAut=new TranCotizacionAutomatica();
//			NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
//			objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
//			NOM_PROD2="%"+NOM_PROD1+"%"; 
//			NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
//			int num=retornaValor(NOM_PROD3);
//			if(num==0){
//				PROD=""+cadenaReducida(NOM_PROD3);
//			}else{
//				PROD=""+NOM_PROD3;
//			}
//			
//			try {
//			
//				objAccesoBD.crearConexion();			
//				String sql="select prod.COD_PROD,prod.nom_prod,'','','',prod.mod_prod,'','','','','',prod.COD_PROD,prod.nom_prod from tb_producto prod "+
//		    		       "where prod.EST_PROD='ACTIVADO' and prod.EST_PROD='ACTIVADO' " +
//					       "and prod.NOM_PROD like '"+PROD+"' and prod.ACT_PROD=0 "+
//					       "order by prod.NOM_PROD asc;";
//				System.out.println(sql);
//				rs = objAccesoBD.ejecutarConsulta(sql);
//				
//				
//					while (rs.next()) {
//						BeanTranMantProd objB=new BeanTranMantProd(rs.getString(1),rs.getString(2),rs.getString(3),
//								rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
//								rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
//						    
//						objTranMantProd.adicionar(objB);
//					}
//					
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}finally{
//				objAccesoBD.cerrarResultSet(rs);
//				objAccesoBD.cerrarStatement();
//				objAccesoBD.cerrarConexion();  
//			}
//
//			
//			for (int i = 0; i < objTranMantProd.tamaño(); i++) {
//				BeanTranMantProd objBus=objTranMantProd.obtener(i) ;
//				
//				Object[] array={objBus.getCod_prod1(),objBus.getNom_prod1(),objBus.getCoste(),
//						objBus.getCod_mar(),objBus.getNom_mar(),objBus.getMod_prod(),objBus.getCod_umed(),objBus.getNom_umed(),
//						objBus.getFecha(),objBus.getCod_prove(),objBus.getNom_prove(),objBus.getCod_prod(),
//						objBus.getNom_prod()};
//				modelo2.addRow(array);
//				
//			}
//			
//		}
		/**********************************************************************************************************/
		public void buscarNormal2(String nom){
			/*int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);*/
			
			objTranMantProd.eliminarTodo();
			AccesoBD objAccesoBD = new AccesoBD();
			ResultSet rs = null;
			
			NOMBREPROD=nom;
			
			String nommar,cbomar=""+cboMarca.getSelectedItem(),codmar;
			cbomar=cbomar.trim();
			if(cbomar.equals("")){
				nommar="%";
			}else{System.out.println(cbomar);
				System.out.println(cbomar.indexOf("-"));
					nommar=cbomar.substring(0, cbomar.indexOf("-"));
			}
			
			try {
			
			objAccesoBD.crearConexion();
			String sql="select prod.COD_PROD,prod.nom_prod,'','','',prod.mod_prod,'','','','','',prod.COD_PROD,prod.nom_prod from tb_producto prod "+
				       "where prod.EST_PROD='ACTIVADO' " +
				       "and prod.NOM_PROD like '"+NOMBREPROD+"%' and prod.ACT_PROD=0 "+
				       "order by prod.NOM_PROD asc;";
			System.out.println(sql);
			rs = objAccesoBD.ejecutarConsulta(sql);
						
				while (rs.next()) {
					BeanTranMantProd objB=new BeanTranMantProd(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
					        objTranMantProd.adicionar(objB);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				objAccesoBD.cerrarResultSet(rs);
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}
			
			for (int i = 0; i < objTranMantProd.tamaño(); i++) {
				BeanTranMantProd objBus=objTranMantProd.obtener(i) ;
				
				Object[] array={objBus.getCod_prod1(),objBus.getNom_prod1(),objBus.getCoste(),
						objBus.getCod_mar(),objBus.getNom_mar(),objBus.getMod_prod(),objBus.getCod_umed(),objBus.getNom_umed(),
						objBus.getFecha(),objBus.getCod_prove(),objBus.getNom_prove(),objBus.getCod_prod(),
						objBus.getNom_prod()};
				modelo2.addRow(array);
				
			}
			
		}
		/**********************************************************************************************************/
	 
	public void buscarDetalle4(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		PintarTabla();
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText().trim(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=NOM_PROD3;
		
		int contCosas=0;
		objSB.eliminarTodo();
		
		
		try {
		
			objAccesoBD.crearConexion();
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			"DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			",PROD.COD_PROD,PROD.NOM_PROD ,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"FROM tb_proveprodmarumed1 DET " +			
			"INNER JOIN tb_producto PROD "+
			"ON DET.COD_PROD=PROD.COD_PROD "+
			"INNER JOIN tb_proveedor PROVE "+
			"ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"INNER JOIN tb_marcas MAR "+
			"ON DET.COD_MAR=MAR.COD_MAR "+
			"INNER JOIN tb_umed UMED "+
			"ON DET.COD_UMED=UMED.COD_UMED "+
			"INNER JOIN tb_rubro RUB "+
			"ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
			"WHERE PROD.NOM_PROD LIKE '"+PROD+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
			"AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc;";
		
			rs = objAccesoBD.ejecutarConsulta(sql);		
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), 
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contador++;
    	   contCosas=contCosas+1;
			Object[] obj={
					objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
       
//       	if(contCosas==0){
//			//buscarDetalle3();
//		}else{
//		txtProducto2.setText(PROD);
//		}
		txtProducto2.setText(PROD);
		
	}
	
	/***********************************************/
	/********BUSCAR DETALLE************************/
	public void buscarDetalle3(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
	
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=""+NOM_PROD3;
		int contCosas=0;
		
		try {
			
			objAccesoBD.crearConexion();	
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			"  	 ,PROD.COD_PROD,PROD.NOM_PROD ,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
			" 	 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
			" 	 	 INNER JOIN tb_producto PROD "+
			" 	 	 ON DET.COD_PROD=PROD.COD_PROD "+
			" 	 	 INNER JOIN tb_marcas MAR "+
			" 	  	 ON DET.COD_MAR=MAR.COD_MAR "+
			" 	  INNER JOIN tb_umed UMED "+
			" 	 	 ON DET.COD_UMED=UMED.COD_UMED "+
			"  	 WHERE PROD.NOM_PROD LIKE '"+PROD+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
			" AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"  	ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc; ";
			
			rs = objAccesoBD.ejecutarConsulta(sql);		
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), 
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contCosas=contCosas+1;
    	   contador++;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		
		
		if(contCosas==0){
			buscarDetalle2();
		}else{
		txtProducto2.setText(PROD);
		}
		
		
	}
	
	/***********************************************/
	/********BUSCAR DETALLE************************/
	public void buscarDetalle2(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
		
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=""+NOM_PROD3;
		int contCosas=0;
		
		try {
			
			objAccesoBD.crearConexion();
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			"  	 ,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
			" 	 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
			" 	 	 INNER JOIN tb_producto PROD "+
			" 	 	 ON DET.COD_PROD=PROD.COD_PROD "+
			" 	 	 INNER JOIN tb_marcas MAR "+
			" 	  	 ON DET.COD_MAR=MAR.COD_MAR "+
			" 	  INNER JOIN tb_umed UMED "+
			 		  " 	 	 ON DET.COD_UMED=UMED.COD_UMED "+
			"  	 WHERE PROD.NOM_PROD LIKE '"+PROD+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
			" AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"  	 ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc;";
			
			rs = objAccesoBD.ejecutarConsulta(sql);
			
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contador++;
    	   contCosas=contCosas+1;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		if(contCosas==0){
			buscarDetalle1();
		}else{
		txtProducto2.setText(PROD);
		}
	
		
	}
	
	/***********************************************/
	/********BUSCAR DETALLE************************/
	public void buscarDetalle1(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
		
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=""+NOM_PROD3;
		int contCosas=0;
		
		try {
			
		objAccesoBD.crearConexion();
		String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
		"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
		" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
		"  	 ,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
		"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
		" 	 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
		" 	 	 INNER JOIN tb_producto PROD "+
		" 	 	 ON DET.COD_PROD=PROD.COD_PROD "+
		" 	 	 INNER JOIN tb_marcas MAR "+
		" 	  	 ON DET.COD_MAR=MAR.COD_MAR "+
		" 	  INNER JOIN tb_umed UMED "+
		 		  " 	 	 ON DET.COD_UMED=UMED.COD_UMED "+
		"  	 WHERE PROD.NOM_PROD LIKE '"+PROD+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
		" AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
		"  	ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc; ";
		
		rs = objAccesoBD.ejecutarConsulta(sql);
		
		
			while(rs.next()){
				
				BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
						rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
						rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
				objSB.adicionar(objB);
			}	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contador++;
    	   contCosas=contCosas+1;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		if(contCosas==0){
			buscarDetalle0();
		}else{
		txtProducto2.setText(PROD);
		}
		
	}
	public void buscarDetalle0(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
		
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=""+NOM_PROD3;
		int contCosas=0;
	
		try {
			
			objAccesoBD.crearConexion();
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			"  	 ,PROD.COD_PROD,PROD.NOM_PROD ,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
			" 	 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
			" 	 	 INNER JOIN tb_producto PROD "+
			" 	 	 ON DET.COD_PROD=PROD.COD_PROD "+
			" 	 	 INNER JOIN tb_marcas MAR "+
			" 	  	 ON DET.COD_MAR=MAR.COD_MAR "+
			" 	  INNER JOIN tb_umed UMED "+
			 		  " 	 	 ON DET.COD_UMED=UMED.COD_UMED "+
			"  	 WHERE PROD.NOM_PROD LIKE '"+PROD+"' AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
			" AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"  	ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc;";
			rs = objAccesoBD.ejecutarConsulta(sql);		
			
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contador++;
    	   contCosas=contCosas+1;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
       
		if(contCosas==0){
			buscarDetalle01();
		}else{
		txtProducto2.setText(PROD);
		}
		
	}
	public void buscarDetalle01(){
		
		contador=0;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		String NOM_PROD=txtProducto2.getText(),NOM_PROD1,NOM_PROD2,NOM_PROD3,PROD;
		
		objTranCotAut=new TranCotizacionAutomatica();
		NOM_PROD1=objTranCotAut.primeraSinS(objTranCotAut.primerapal(NOM_PROD))+
		objTranCotAut.sinAlgunasPalabrasYSimbolos((objTranCotAut.completarOracion(NOM_PROD)));
		NOM_PROD2="%"+NOM_PROD1+"%"; 
		NOM_PROD3=objTranCotAut.sinPorcentaje(NOM_PROD2).trim();
		PROD=""+NOM_PROD3;
		int contCosas=0;
	
		try {
		
			objAccesoBD.crearConexion();
			String sql=" SELECT DET.COD_PROVEPRODMARUMED, "+
			"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) AS COSTE,  "+
			" 	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			"  	 ,PROD.COD_PROD,PROD.NOM_PROD ,PROD.PESO_PROD,PROD.MOD_PROD,PROD.ACT_PROD "+
			"    FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
			" 	 	 ON PROVE.COD_PROVE=DET.COD_PROVE "+
			" 	 	 INNER JOIN tb_producto PROD "+
			" 	 	 ON DET.COD_PROD=PROD.COD_PROD "+
			" 	 	 INNER JOIN tb_marcas MAR "+
			" 	  	 ON DET.COD_MAR=MAR.COD_MAR "+
			" 	  INNER JOIN tb_umed UMED "+
			 		  " 	 	 ON DET.COD_UMED=UMED.COD_UMED "+
			"  	 WHERE PROD.NOM_PROD LIKE '"+PROD+"'AND MAR.NOM_MAR LIKE '%"+"%"+"%' " +
			" AND DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND MAR.EST_MAR='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
			"  	ORDER BY COSTE asc, PROD.NOM_PROD asc, DET.fec_det desc; ";
			
			rs = objAccesoBD.ejecutarConsulta(sql);
					
				while(rs.next()){
					
					BeanBuscarProdCoti objB= new BeanBuscarProdCoti(rs.getInt(1), rs.getString(2), 
							rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), 
							rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17),rs.getInt(18));
					objSB.adicionar(objB);
				}	
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}	
					
       for (int i = 0; i < objSB.tamaño(); i++) {
    	   contador++;
    	   contCosas=contCosas+1;
			Object[] obj={objSB.obtener(i).getCod_prod(),
					objSB.obtener(i).getNom_prod(),objSB.obtener(i).getCoste(),
					objSB.obtener(i).getCod_mar(),objSB.obtener(i).getNom_mar(),objSB.obtener(i).getMod_prod(),
					objSB.obtener(i).getCod_umed(),objSB.obtener(i).getNom_umed(),objSB.obtener(i).getFec_det(),
					objSB.obtener(i).getCod_prove(),objSB.obtener(i).getNom_prove(),
					objSB.obtener(i).getCod_prod(),objSB.obtener(i).getNom_prod()
			};
			modelo2.addRow(obj);
			
		}
		if(contCosas==0){
			txtProducto2.setText(NOM_PROD);
		}else{
		txtProducto2.setText(PROD);
		}
		
	}
	/***********************************************/
	
	public void buscarProducto1(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT COD_PROD,SUBSTRING_INDEX(NOM_PROD, ' ',1) " +
				" FROM tb_producto GROUP BY SUBSTRING(NOM_PROD ,1,POSITION(' ' IN NOM_PROD)) " +
				" order by NOM_PROD asc; ";
				System.out.println("Mirame:"+sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboProducto1.addItem( rs.getString(2));
			}
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
		
	}
	
	public void buscarProdxCaracter(){
		//valor2=true;
		cboProducto2.removeAllItems();
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs =null;
		
		String nomProdAlt=""+ cboProducto1.getSelectedItem();
		nomProdAlt=nomProdAlt.trim();
		int tam= nomProdAlt.length();
		
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='PARA')" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7)))" +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='TIPO')" +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		"  ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='CON') " +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+6),(LOCATE(' ' , NOM_PROD, ("+tam+"+6))-("+tam+"+6))) " +
		"  ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='DE')" +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+5),(LOCATE(' ' , NOM_PROD, ("+tam+"+5))-("+tam+"+5))) " +
		"  ,SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))) " +
		" ))))))) FROM tb_producto " +
		"  WHERE NOM_PROD LIKE '"+nomProdAlt+" %' group by " +
		" IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='PARA') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='TIPO') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+7),(LOCATE(' ' , NOM_PROD, ("+tam+"+7))-("+tam+"+7))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='CON')" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+6),(LOCATE(' ' , NOM_PROD, ("+tam+"+6))-("+tam+"+6))) " +
		" ,(IF(((SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2))))='DE') " +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+5),(LOCATE(' ' , NOM_PROD, ("+tam+"+5))-("+tam+"+5)))" +
		" ,SUBSTRING(NOM_PROD ,("+tam+"+2),(LOCATE(' ' , NOM_PROD, ("+tam+"+2))-("+tam+"+2)))" +
		"   )) )) )) );";
				
		System.out.println(sql);
		rs = objAccesoBD.ejecutarConsulta(sql);
				
			while (rs.next()) {
				cboProducto2.addItem( rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
	}
	
	public void cargarMarcas(){
		AccesoBD objAccesoBD = new AccesoBD();		
		ResultSet rs = null;
		
		try {
		
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_marcas WHERE EST_MAR='ACTIVADO' " +
				"order by nom_mar asc;";
		rs = objAccesoBD.ejecutarConsulta(sql);		
			
			while (rs.next()) {
				cboMarca.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		
	}
	
	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	public  Double formato2(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=2;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	
	public void cargarProdAlternativo(){
		
		//Obtener fila seleccionada de la tabla
		
		int fila = jTable1.getSelectedRow();
		double peso=0;
		objTranCotAut=new TranCotizacionAutomatica();
		String pesoprod="";
		int cant=objTranCotAut.cantidad;
		BeanBuscarProdCoti objB=objSB.obtener(fila) ;
		
		COD_PROD1=""+ objB.getCod_prod();
		NOM_PROD1=""+ objB.getNom_prod();
		COSTE=""+ objB.getCoste();
		COD_MAR=""+objB.getCod_mar();
		MARCA=""+ objB.getNom_mar();
		COD_UMED=""+objB.getCod_umed();
		UMED=""+ objB.getNom_umed();
	    FECHA=""+ objB.getFec_det();
		PROVEEDOR=""+ objB.getNom_prove();
		COD_PROD=""+ objB.getCod_prod();
		NOM_PROD=""+ objB.getNom_prod();
		COD_PROVEE=""+ objB.getCod_prove();
		pesoprod=""+objB.getPeso_prod();
		
		if(pesoprod.equals("")){
			peso=0;
		}else{
			peso=Double.parseDouble(objB.getPeso_prod());
		}
		
		PESO_PROD=""+formato2(peso);
		System.out.println("ESTO ES LO QUE VIENE DESPUES DE BUSCAR 0:"+COD_PROD1+"||"+COSTE+"||"+MARCA
		+"||"+COD_MAR+"||"+UMED+"||"+FECHA+"||"+PROVEEDOR+"||"+COD_PROD+"||"+NOM_PROD+"||"+COD_PROVEE);

	}

	/********AGREGAR DETALLE************************/
	public void agregarDetalle(){
		
		//COD_PROD,COD_PROVE,COS_DET,MON_DET,IGV_DET,OBS_DET,EST_DET
		AccesoBD objAccesoBD = new AccesoBD();
		
		try {
			
		int fila = jTable1.getSelectedRow();		
		objAccesoBD.crearConexion();
		String cod_prod="";
		String COS_DET=txtCosto.getText(),MON_DET=(String)cboMoneda.getSelectedItem(),
		IGV_DET=(String)cboIgv.getSelectedItem(),OBS_DET="";
		String cbomar=""+cboMarca1.getSelectedItem();
		String codmar;
		String cboUMed=""+cboUMedida.getSelectedItem();
		String codUmed;
		int est_rubro1=1,codi_prove=0;
		
		if(est1==0){
			BeanBuscarProdCoti objB=objSB.obtener(fila) ;
			codi_prove=Integer.parseInt(objB.getCod_prove());
			cod_prod=objB.getCod_prod();
			OBS_DET=objB.getObs_prod();
		}else{
			codi_prove=COD_PROVE;
			cod_prod=COD_PROD;
			OBS_DET="";
			
		}
		System.out.println("cod_prove:"+codi_prove);
		System.out.println("cod_prod:"+cod_prod);
		System.out.println("obs_det:"+OBS_DET);
		
		if(IGV_DET.equals("Con IGV")){
			IGV_DET="0";
		}else if(IGV_DET.equals("Mas IGV")) {
			IGV_DET="1";
		}else{
			IGV_DET="3";
		}
		if(cbomar.equals("")){
			codmar="1";
		}else{
			codmar=cbomar.substring( cbomar.indexOf("-")+1,cbomar.length() );
		}
		if(cboUMed.equals("")){
			codUmed="1";
		}else{
			codUmed=cboUMed.substring( cboUMed.indexOf("-")+1,cboUMed.length() );
		}
		if(COS_DET.equals("")){
			COS_DET="0";
		}
		
			//tb_prodmarprove
			//cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det
		try{   
			String insertarPregunta="INSERT INTO tb_proveprodmarumed1(cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det,est_rubro1)" +
					" VALUES('"+codi_prove+"','"+cod_prod+"','"+codmar+"','"+codUmed+"','"
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
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Nadaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		
		
	}
	
	
	/******************************************************************************************************/
	
	public void cargarMarcas1(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_marcas WHERE EST_MAR='ACTIVADO';";
			rs = objAccesoBD.ejecutarConsulta(sql);		
				
				while (rs.next()) {
					cboMarca1.addItem( rs.getString(2)+"-"+rs.getString(1));
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
		ResultSet rs = null;
		
		try {
			
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
			
	}
	
	/************************************************************************************************************************************/
	public void modificarDetalle(){
		
		int fila = jTable1.getSelectedRow();
		BeanBuscarProdCoti objB=objSB.obtener(fila) ;
		AccesoBD objAccesoBD=  new AccesoBD();
		
		int CODIGO_PROVEPRODMARUMED=objB.getCod_proveprodmarumed();
		String COS_DET=txtCosto.getText().trim(),MON_DET=(String)cboMoneda.getSelectedItem(),
		IGV_DET=(String)cboIgv.getSelectedItem(),OBS_DET=objB.getObs_prod();
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
		
		try{
			
			objAccesoBD.crearConexion();
				//cod_prove, cod_prod, cod_mar, cod_umed, cos_det, mon_det, igv_det, obs_det, fec_det, est_det
				String sql="UPDATE tb_proveprodmarumed1 SET " +
					"COS_DET='"+COS_DET+"' , MON_DET='"+MON_DET+"' , "+
					"IGV_DET='"+IGV_DET+"' ,OBS_DET= CONCAT(CURDATE(),'-','"+OBS_DET+"' ), FEC_DET=CURDATE()  "+
					" WHERE COD_PROVEPRODMARUMED='"+CODIGO_PROVEPRODMARUMED+"';";
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
	
	/********************************************************************************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
     public void cargarDetalle(){
    	 
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		BeanBuscarProdCoti objB=objSB.obtener(fila) ;
		int igv;
		String mon;
		double costo;
		
		igv=objB.getIgv_det();
		mon=objB.getMon_det();
		costo=objB.getCos_det();
		String cod_mar="",cod_umed="";
		cod_mar=objB.getCod_mar() ;
		String nom_mar=objB.getNom_mar(),
		uni=nom_mar+"-"+cod_mar;
		//System.out.println("LA MARCA MAS - Y COD:"+uni);
		cboMarca1.setSelectedItem(uni);
		cod_umed=objB.getCod_umed() ;
		String nom_UMED=objB.getNom_umed(),
		uni2=nom_UMED+"-"+cod_umed;
		//System.out.println("LA MARCA MAS - Y COD:"+uni);
		cboUMedida.setSelectedItem(uni2);
		txtProveedor.setText(""+objB.getNom_prove());
		txtCosto.setText(""+costo);
		if(igv==0){
			cboIgv.setSelectedIndex(1);
		}else if(igv==1){
			cboIgv.setSelectedIndex(2);
		}else{
			cboIgv.setSelectedIndex(0);
		}
		
		if(mon.equals("$")){
			cboMoneda.setSelectedIndex(1);
		}else if(mon.equals("S/.")){
			cboMoneda.setSelectedIndex(2);
		}else{
			cboMoneda.setSelectedIndex(0);
		}
		
	}
     /**********************************************/
     
     public void eliminarDetalle(){
    	 
        int fila = jTable1.getSelectedRow();
 		BeanBuscarProdCoti objB=objSB.obtener(fila) ;
    	int CODIGO_PROVEPRODMARUMED=objB.getCod_proveprodmarumed();
    	 
 		AccesoBD objAccesoBD=  new AccesoBD();
 		
 		//String est="DESACTIVADO";
 		
 		try{
 			
 			objAccesoBD.crearConexion();	
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
 		
 	}
     
     /********ACTUALIZAR ESTADO DEL DETALLE**********************/
 	public void actualizarEstDetalle(){
 		AccesoBD objAccesoBD=  new AccesoBD();
 		
 		try{
 			
 			objAccesoBD.crearConexion();
	 		String sql="update tb_proveprodmarumed1 set "+
	           "est_det='DESACTIVADO' where DATE_SUB(CURDATE(),INTERVAL 90 DAY) > fec_det;";
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
     
	/***********************************************/
     
     public void limpia(){
 		cboUMedida.setSelectedIndex(0);
 		cboMarca1.setSelectedIndex(0);
 		cboMoneda.setSelectedIndex(0);
 		cboIgv.setSelectedIndex(0);
 		txtCosto.setText("");
 		txtProveedor.setText("");
 	
 		
 	}
     
	/***********************************************/
     
     public void metodoBuscarProve(){
    	 
 		NOMBRE_PROVEE=txtProveedor.getText();
 		BuscarProveedor1 objBuscarProveedor = new BuscarProveedor1(objMenuP);
 		
 		objBuscarProveedor.setVisible(true);
 		objBuscarProveedor.pack();  // para darle tamaño automático a la ventana.
 		if(objBuscarProveedor.nomProve==null){
 			System.out.println("ENTRO AL NULL");
 		}else{//ACEPTAR 
 	
 			  txtProveedor.setText(objBuscarProveedor.nomProve);
 		      COD_PROVE=objBuscarProveedor.codProve;
 		      est=1;
 	    }
 		
 	}
     
    /****************************************************************************************************/
 	public void cargarRubro(){
 		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_rubro WHERE EST_RUBRO='ACTIVADO' order by nom_rubro asc;";
		rs = objAccesoBD.ejecutarConsulta(sql);		
			
			while (rs.next()) {
				cboRubro.addItem(rs.getString(2)+"-"+rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
	}
	
	public void cargarProductoNoEncontrado(){
		
		String codRubro=""+cboRubro.getSelectedItem();
		codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length());
		COD_RUBRO=codRubro;
		NOM_RUBRO=NomRubro(""+cboRubro.getSelectedItem());
		NOM_PRODUCTO=""+txtProducto.getText();
		
	}
     
    /*********************************************************************************************************/
	public String NomRubro(String cadena){
		String rubro="",nom="";
		
		  for(int i=0;i<cadena.length();i++){
			  rubro=""+cadena.charAt(i);
			  if(rubro.equals("-")){
				  break;
			  }else{
				  nom+=""+cadena.charAt(i);
			  }
			  
		  }
		return nom;
	}
    /********************************************************************************************************/
	
	public void actualizarProducto(int num){
		
		AccesoBD objAccesoBD=  new AccesoBD();
		
		try{
			
			objAccesoBD.crearConexion();
			String sql="update tb_producto set "+
	          "act_prod='"+num+"' where cod_prod='"+COD_PROD+"';";
			System.out.println(sql);
				
			int op=objAccesoBD.ejecutarActualizacion(sql);
			if(op==0){
				System.out.println("Hubo un ERROR al actualizar ACT_PROD");
			}else{
				System.out.println("Se actualizo Correctamentettttt");
				
			}
			
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
	}
	
	/**************************************************************************************************************/
	
	public void  PintarTabla(){
		
		TableColumn column0 = jTable1.getColumn(jTable1.getColumnName(0));
		TableColumn column1 = jTable1.getColumn(jTable1.getColumnName(1));
		TableColumn column2 = jTable1.getColumn(jTable1.getColumnName(2));
		TableColumn column3 = jTable1.getColumn(jTable1.getColumnName(3));
		TableColumn column4 = jTable1.getColumn(jTable1.getColumnName(4));
		TableColumn column5 = jTable1.getColumn(jTable1.getColumnName(5));
		TableColumn column6 = jTable1.getColumn(jTable1.getColumnName(6));
		TableColumn column7 = jTable1.getColumn(jTable1.getColumnName(7));
		TableColumn column8 = jTable1.getColumn(jTable1.getColumnName(8));
		TableColumn column9 = jTable1.getColumn(jTable1.getColumnName(9));
		TableColumn column10 = jTable1.getColumn(jTable1.getColumnName(10));
		TableColumn column11 = jTable1.getColumn(jTable1.getColumnName(11));
		TableColumn column12 = jTable1.getColumn(jTable1.getColumnName(12));
		
		column0.setCellRenderer(renderer);
		column1.setCellRenderer(renderer);
		column2.setCellRenderer(renderer);
		column3.setCellRenderer(renderer);
		column4.setCellRenderer(renderer);
		column5.setCellRenderer(renderer);
		column6.setCellRenderer(renderer);
		column7.setCellRenderer(renderer);
		column8.setCellRenderer(renderer);
		column9.setCellRenderer(renderer);
		column10.setCellRenderer(renderer);
		column11.setCellRenderer(renderer);
		column12.setCellRenderer(renderer);
	} 
	
	/**************************************************************************************************************/

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== btnModificar){
			
			if(est==1){
				modificarDetalle();
				actualizarProducto(1);
			    buscarDetalle4();
			    limpia();
			    est=0;
			}else{
				objGUI.mostrarAviso("Seleccione lo que va a modificar");
			}
		}
		
		if(e.getSource()==btnAgregar){
			
			if(est==1){
				agregarDetalle();
				actualizarProducto(1);
				//actualizarEstDetalle();
				buscarDetalle4();
				limpia();
			    est=0;
			    est1=0;
			}else{
				objGUI.mostrarAviso("Seleccione lo que va Agregar");
			}
			
		}
		
       if(e.getSource()==btnEliminar){
			
			if(est==1){
				eliminarDetalle();
				actualizarProducto(0);
				buscarDetalle4();
				limpia();
			    est=0;
			    est1=0;
			}else{
				objGUI.mostrarAviso("Seleccione lo que va Eliminar");
			}
			
		}
       
       if(e.getSource()==btnBuscar){
    	   
    	   est1=1;
    	   metodoBuscarProve();
       }
       
		if(e.getSource()==cboProducto1){
		buscarProdxCaracter();


		try {
			String nomProdAlt=""+ cboProducto1.getSelectedItem();
		
		nomProdAlt=nomProdAlt.trim().substring(0, (nomProdAlt.trim().length()-2));
		txtProducto2.setText(""+(nomProdAlt)+"%");
		if(conta==0){
			
		}else{
			buscarNormal(txtProducto2.getText().trim());
			buscarNormal2(txtProducto2.getText().trim());
		}
		
		} catch (Exception e2) {
			System.out.println("errrrrrror");
			System.out.println(e2.getMessage());
			// TODO: handle exception
		}
		
		}
		if(e.getSource()==cboProducto2){
			try {
				
			String nomProd=""+cboProducto1.getSelectedItem(),nomProd2=""+cboProducto2.getSelectedItem();
			nomProd=nomProd.trim().substring(0, (nomProd.trim().length()-2));
			nomProd2=nomProd2.trim().substring(0, (nomProd2.trim().length()-2));	
			
				txtProducto2.setText(""+nomProd.trim()+"%"+nomProd2.trim()+"%");
				if(conta==0){
					
				}else{
					buscarNormal(txtProducto2.getText().trim());
					buscarNormal2(txtProducto2.getText().trim());
				}
				
			} catch (Exception e2) {
				System.out.println("errror 2");
				System.out.println(e2.getMessage());
			}
		}
		
		if(e.getSource()==cboMarca){
			try {
				if(conta==0){
					
				}else{
					buscarNormal(txtProducto2.getText().trim());
					buscarNormal2(txtProducto2.getText().trim());
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		if(e.getSource()==btnProcesar){
			
			int fila = jTable1.getSelectedRow();
			String cod=""+modelo2.getValueAt(fila, 2);
			if(cod.equals("")){
				objGUI.mostrarAviso("No se Puede Guardar");
			}else{
				cargarProductoNoEncontrado();
				objGUI.mostrarAviso("Se Guardo Correctamente");
				setVisible(false);
			}
			
		}
		if(e.getSource()==btnBuscar2){
			
			buscar();
			if(act_prod.equals("")){
				buscar2();
			}
			
			
		
		}
		if(e.getSource()==btnBorrar){
			//DATOS DE LA BUSQUEDA
	    	cboProducto1.setSelectedIndex(0);
	    	txtProducto2.setText("%");
	    	cboRubro.setSelectedIndex(0);
	    	txtModelo.setText("");
	    	txtPromelsa.setText("");
	    	//TRANSACCION PRODUCTO
	    	limpia();
		}
		
		if(e.getSource()==cboRubro){
			
			if(chkRubro.isSelected()){
				reset();
			}
		}
	}

	/***********************************************/
	
    public String actulizaNombre(String nom){
    	 String palabra="";
    	for(int i=0;i<nom.length()-1;i++){
    		palabra+=nom.charAt(i);
    	}
    	 return palabra.trim();
    	
    }
    
	/***********************************************/
    public String sinEnter(String nom){
   	 String palabra="";
   	 int cont=0;
 	for(int i=nom.length();i>0;i--){
 		//palabra=nom.charAt(i)+palabra;
 		cont++;
 		if(cont<10){
		palabra+="";
 		}else{
 			palabra=nom.charAt(i)+palabra;
 		}
 	}
 	 return palabra.trim();
   	
   }
   /***********************************************/

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==jTable1){
			MouseEvent evento=e;
            int fila = jTable1.getSelectedRow();
			
			String codi= ""+modelo2.getValueAt(fila, 2);
			if(evento.getSource()==jTable1){
				
				if(evento.getClickCount()==1){
					if(codi.equals("")){
						
						cboMarca1.setEnabled(true);
						cboUMedida.setEnabled(true);
						btnModificar.setEnabled(false);
						btnAgregar.setEnabled(true);
						btnEliminar.setEnabled(false);
						BeanTranMantProd objB=objTranMantProd.obtener(fila-contador) ;
						COD_PROD=objB.getCod_prod();
						System.out.println("CODIGO:"+COD_PROD);
						limpia();
						
					}else{
						cboMarca1.setEnabled(true);
						cboUMedida.setEnabled(false);
						btnModificar.setEnabled(true);
						btnAgregar.setEnabled(true);
						btnEliminar.setEnabled(true);
						cargarDetalle();
						
						est=1;
					}
					
				}
				
				if(evento.getClickCount()==2){
					try {
						cargarProdAlternativo();
						setVisible(false);	
						stop();
					} catch (Exception e2) {
						System.out.println("Visible False");
					}
					
					
				}
			}
		}
			
				
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
//		if(e.getSource()==txtProducto2){
//			conta=1;
//			
//				String nom="";
//            int key = e.getKeyCode();
//			if(KeyEvent.VK_DOWN==key){//flecha abajo
//				NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}
//            else if(KeyEvent.VK_UP==key){//flecha abajo
//            	NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}
//            else if(KeyEvent.VK_LEFT==key){//flecha abajo
//            	NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}
//            else if(KeyEvent.VK_RIGHT==key){//flecha abajo
//            	NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}
//			
//            else if(KeyEvent.VK_SHIFT==key){//flecha abajo
//            	NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}
//            else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("retroceso")){
//				NOMBREPROD="";
//				nom=actulizaNombre(txtProducto2.getText().trim());
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("introduzca")){
//				
//				NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("espacio")){
//				
//				NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//				
//			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("bloqueo de mayúsculas")){
//				
//				NOMBREPROD="";
//				nom=txtProducto2.getText().trim();
//				//System.out.println(nom);
//				buscarNormal(nom);
//				buscarNormal2(nom);
//				
//			}else{
//				NOMBREPROD=txtProducto2.getText().concat(e.getKeyText(e.getKeyCode()).toLowerCase());
//				//System.out.println(NOMBREPROD);
//				buscarNormal(NOMBREPROD);
//				buscarNormal2(NOMBREPROD);
//			}
//			
//            
//			
//		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
			
		if(e.getSource()==txtProducto2){
			conta=1;
			reset();
		}
	}
	
	/******************************************************************************************************************
	 ******************************************************************************************************************/
	
	class RemindTask extends TimerTask {
		
				
		public void run(){
			
			segundos++;
			System.out.println(segundos);
			
			if(frozen==true && segundos==2){
				
				NOMBREPROD="";
				String nom="";
				nom=txtProducto2.getText().trim();
				buscarNormal(nom);								
				System.out.println("HEY");
				
				if(chkRubro.isSelected() && txtProducto2.getText().length()>0){
					String codRubro=""+cboRubro.getSelectedItem();
					codRubro=codRubro.substring(codRubro.indexOf("-")+1,codRubro.length());
					buscarNormalConRubro(nom, codRubro);
					System.out.println("OYE");
				}
				
				buscarNormal2(nom);
			}
							
		}
	
	}
	 
	public void start(int pSeg) throws Exception {
		frozen = false;
		// le asignamos una tarea al timer
		timer.schedule(new RemindTask(), 0, pSeg * 400);
	}// end Start
	
	public void stop() {
			System.out.println("Stop");
			frozen = true;
			segundos=0;
			timer.cancel();/////////////////////////////////////////////
	}// end Stop
	 	
	public void reset() {
			System.out.println("Reset");
			frozen = true;
			segundos = 0;
	}// end Reset

}
