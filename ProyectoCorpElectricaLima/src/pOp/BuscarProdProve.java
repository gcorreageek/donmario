package pOp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.Metodos;

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
public class BuscarProdProve extends JPanel implements MouseListener, ActionListener, KeyListener {
	private JPanel pnlPrincipal;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JButton btnListar;
	private JButton btnBuscar;
	private JPanel pnlBuscar;
	private JComboBox cboMarca;
	private JTextField txtProducto;
	private JLabel lblMarca;
	private JLabel lblProducto;
	private JScrollPane scrLargo;
	private JPanel pnlListado;
	Metodos objMetodo;
	String titulo2[]={"COD","PRODUCTO","COSTE","COSTO","MON","IGV",
			"COD","MAR","UMED","OBS","FEC","COD","PROVEE"};
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,COSTO,MON_DET,IGV_DET,COD_MAR,MAR,UMED_PROD,OBS_DET
	 ,FEC,COD,PROVEE;
	

	 
	
	
	public  BuscarProdProve() {
		
		try {
			 
		

			pnlPrincipal = new JPanel();
			this.add(pnlPrincipal);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(829, 485));
			pnlPrincipal.setLayout(null);

			pnlBuscar = new JPanel();
			pnlPrincipal.add(pnlBuscar);
			pnlBuscar.setLayout(null);
			pnlBuscar.setBorder(BorderFactory.createTitledBorder("Buscar Producto"));
			pnlBuscar.setBounds(12, 0, 810, 75);

			pnlListado = new JPanel();
			pnlPrincipal.add(pnlListado);
			pnlListado.setLayout(null);
			pnlListado.setBounds(12, 72, 810, 413);

			scrLargo = new JScrollPane();
			pnlListado.add(scrLargo);
			scrLargo.setBounds(0, 0, 804, 405);

			jScrollPane1 = new JScrollPane();
			scrLargo.setViewportView(jScrollPane1);
			jScrollPane1.setBounds(14, 8, 1250, 257);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(1249, 382));

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			cboMarca = new JComboBox();
			pnlBuscar.add(cboMarca);
			cboMarca.setBounds(81, 46, 183, 21);
			cboMarca.setEditable(true);
			cboMarca.addItem("VACIO");
			cboMarca.addMouseListener(this);

			txtProducto = new JTextField();
			pnlBuscar.add(txtProducto);
			txtProducto.setBounds(81, 19, 712, 21);
			txtProducto.addKeyListener(this);

			lblMarca = new JLabel();
			pnlBuscar.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(10, 49, 59, 14);

			lblProducto = new JLabel();
			pnlBuscar.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(11, 22, 64, 14);

			btnBuscar = new JButton();
			pnlBuscar.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(474, 46, 99, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlBuscar.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(667, 46, 99, 21);
			btnListar.addActionListener(this);
			
			/*String titulo2[]={"COD","PRODUCTO","COSTO","MON","IGV",
			"COD","MAR","UMED","OBS","COD","PROVEE","OBS"};
			*/
			
		
			
			/*
			TableColumn NOM_PROD = jTable1.getColumn ("NOM_PROD");
			NOM_PROD.setPreferredWidth(320);
			TableColumn COS_DET = jTable1.getColumn ("COS_DET");
			COS_DET.setPreferredWidth(4);
			TableColumn MON_DET = jTable1.getColumn ("MON_DET");
			MON_DET.setPreferredWidth(2);
			TableColumn IGV_DET = jTable1.getColumn ("IGV_DET");
			IGV_DET.setPreferredWidth(2);
			TableColumn COD_MAR = jTable1.getColumn ("COD_MAR");
			COD_MAR.setPreferredWidth(2);
			TableColumn NOM_MAR = jTable1.getColumn ("NOM_MAR");
			NOM_MAR.setPreferredWidth(4);
			*/
			
			
			
			
			listarDetalle();
			cargarComboMarcas();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/********LISTAR DETALLE************************/
	  /*SELECT PROD.COD_PROD,PROD.NOM_PROD,
IF((IGV_DET=1),COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18),
DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,PROD.UMED_PROD,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE
FROM DET_PROVE_PROD DET INNER JOIN PROVEEDOR PROVE
ON PROVE.COD_PROVE=DET.COD_PROVE
INNER JOIN PRODUCTO PROD
ON DET.COD_PROD=PROD.COD_PROD
		INNER JOIN MARCAS MAR
		ON PROD.COD_MAR=MAR.COD_MAR
	  WHERE PROD.NOM_PROD LIKE '%%' AND MAR.NOM_MAR LIKE '%%'
	  ORDER BY
   IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,
(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18);*/
		public void listarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			/*String titulo2[]={"COD","PRODUCTO","COSTE","COSTO","MON","IGV",
			"COD","MAR","UMED","OBS","FEC","COD","PROVEE"};*/
			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
				" IF((IGV_DET=1),COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18), "+
			" DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,PROD.UMED_PROD,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
			" FROM DET_PROVE_PROD DET INNER JOIN PROVEEDOR PROVE "+
			" ON PROVE.COD_PROVE=DET.COD_PROVE "+
			" INNER JOIN PRODUCTO PROD "+
			" ON DET.COD_PROD=PROD.COD_PROD "+
			" INNER JOIN MARCAS MAR  " +
			" ON PROD.COD_MAR=MAR.COD_MAR " +
			" WHERE PROD.NOM_PROD LIKE '%%' AND MAR.NOM_MAR LIKE '%%' AND DET.EST_DET='ACTIVADO'" +
			" ORDER BY " +
			" IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1, " +
			" (SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18); " ;

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
							rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
							rs.getString(12)
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
	/*****************CARGAR COMBOBOX MARCAS******************************/
	int c=0;
	public void cargarComboMarcas(){
		c++;
		if(c==1){
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
		}
	}
	/***********************************************************************/
	/*****************CARGAR COMBOBOX PROVEEDOR******************************/
	/*int c2=0;
	public void cargarComboProveedor(){
		c2++;
		if(c2==1){
			System.out.println("entra al combo proveedor");
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM PROVEEDOR;";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			
			try {
				while (rs.next()) {
				cboProveedor.addItem( rs.getString(2)+"-"+rs.getString(1));
				}
				rs.close();
				
			} catch (Exception ex) {
				System.out.println(ex);
				// TODO: handle exception
			}

			objAccesoBD.cerrarConexion();
		}
	}*/
	/***********************************************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarDetalle(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		COD_PROD=String.valueOf(cod);
/*	String titulo2[]={"COD","PRODUCTO","COSTE","COSTO","MON","IGV",
			"COD","MAR","UMED","OBS","FEC","COD","PROVEE"};
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,COSTO,MON_DET,IGV_DET,COD_MAR,MAR,UMED_PROD,OBS_DET
	 ,FEC,COD,PROVEE;
	*/
		
		
		NOM_PROD=(String)modelo2.getValueAt(fila, 1);
		txtProducto.setText(NOM_PROD);
		COSTE=(String) modelo2.getValueAt(fila, 2);
		COSTO=(String) modelo2.getValueAt(fila, 3);
		MON_DET=(String) modelo2.getValueAt(fila, 4);
		IGV_DET=(String) modelo2.getValueAt(fila, 5);
		COD_MAR=(String) modelo2.getValueAt(fila, 6);
		MAR=(String) modelo2.getValueAt(fila, 7);
		UMED_PROD=(String) modelo2.getValueAt(fila, 8);
		OBS_DET=(String) modelo2.getValueAt(fila, 9);
		FEC=(String) modelo2.getValueAt(fila, 10);
		COD=(String) modelo2.getValueAt(fila, 11);
		PROVEE=(String) modelo2.getValueAt(fila, 12);
	}
	/***********************************************/

	/********BUSCAR DETALLE************************/
	public void buscarDetalle(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_PROD=txtProducto.getText(),EST_DET="ACTIVADO",MARCA=paraCombo(""+cboMarca.getSelectedItem());
		/*SELECT PROD.COD_PROD,PROD.NOM_PROD,
IF((IGV_DET=1),COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18),
DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,PROD.UMED_PROD,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE
FROM DET_PROVE_PROD DET INNER JOIN PROVEEDOR PROVE
ON PROVE.COD_PROVE=DET.COD_PROVE
INNER JOIN PRODUCTO PROD
ON DET.COD_PROD=PROD.COD_PROD
	INNER JOIN MARCAS MAR
	ON PROD.COD_MAR=MAR.COD_MAR
  WHERE PROD.NOM_PROD LIKE '%%' AND MAR.NOM_MAR LIKE '%%'
  ORDER BY
 IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,
(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18);*/
	
		String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
		" IF((IGV_DET=1),COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1,(SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18), "+
		" DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,PROD.UMED_PROD,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE "+
		" FROM DET_PROVE_PROD DET INNER JOIN PROVEEDOR PROVE "+
			" ON PROVE.COD_PROVE=DET.COD_PROVE "+
		" INNER JOIN PRODUCTO PROD "+
		" ON DET.COD_PROD=PROD.COD_PROD "+
		" INNER JOIN MARCAS MAR " +
		" ON PROD.COD_MAR=MAR.COD_MAR " +
		" WHERE PROD.NOM_PROD LIKE '%"+NOM_PROD+"%' AND MAR.NOM_MAR LIKE '%"+MARCA+"%' " +
		" ORDER BY " +
		" IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/IF(DET.MON_DET='$',1," +
		" (SELECT VENTA FROM CAMBIO WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM CAMBIO))))/1.18);";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12)
				};
				modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		
	}
	
	/***********************************************/
	public String paraCombo(String cadena){
		cadena=cadena.trim();
		String cadenar = null;
		try {
			cadenar=cadena.substring(0, cadena.indexOf("-"));
		} catch (Exception e) {
			cadenar="";
			// TODO: handle exception
		}
		
		return cadenar;
	}

	public void mouseClicked(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==jTable1){cargarDetalle();}
	
	}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			buscarDetalle();
			System.out.println("filas buscar:"+modelo2.getRowCount());
		}
		if(e.getSource()==btnListar){
			listarDetalle();
			System.out.println("filas listar:"+modelo2.getRowCount());
		}
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==txtProducto){
			buscarDetalle();
			
			
			
			
		}
		
		
		
		
		
	}
	public void keyTyped(KeyEvent e) {}
	

}
