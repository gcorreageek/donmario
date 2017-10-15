package pOp;
import gui.CustomTableCellRendererModificarAgregarProdMant;

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
import servlet.ServletProdAltCogido;

import com.cloudgarden.layout.AnchorConstraint;

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
public class BuscarProdMantCotDialog extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JLabel lblProducto;
	private JLabel lblProducto2;
	private JPanel pnlMedio;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnBuscar;
	private JButton btnListar;
	private JTable tblLista;
	private JScrollPane scrLista;
	static public JTextField txtProducto;
	private JLabel lblMarca2;
	GUI objGUI;
	boolean valor=true;
	boolean valor2=false;
	public static JButton botones[] = new JButton[2];

	ServletProdAltCogido objServletProdAltCog= new 	ServletProdAltCogido();
	String titulo2[]={"Cprod","Producto","Coste","CMar","Marca","CUmed","Umed","Fecha","Cprov","Prove","Calt","Nalt","Peso","Modelo"};
	
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,COSTE,COD_MAR,MARCA,CUMED,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PROD1,NOM_PROD1,PESO_PRODUCTO,MODPROD;
	 
	 //Global
	 String cod_producto;
	 int veces=0;
	 TableCellRenderer renderer = new CustomTableCellRendererModificarAgregarProdMant();
	 
	public BuscarProdMantCotDialog(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);
		
		try {
			
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setSize(917, 422);

			pnlArriba = new JPanel();
			FlowLayout pnlArribaLayout = new FlowLayout();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(1179, 82));

			lblProducto2 = new JLabel();
			pnlArriba.add(lblProducto2);
			lblProducto2.setText("Alternativo:");
			lblProducto2.setVisible(false);
			lblProducto2.setBounds(6, 35, 65, 14);

			lblProducto = new JLabel();
			pnlArriba.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(12, 34, 59, 14);

			txtProducto = new JTextField();
			pnlArriba.add(txtProducto);
			txtProducto.setBounds(77, 31, 534, 21);
			txtProducto.addKeyListener(this);
			txtProducto.addActionListener(this);

			lblMarca2 = new JLabel();
			pnlArriba.add(lblMarca2);
			lblMarca2.setText("Marca:");
			lblMarca2.setBounds(29, 57, 42, 17);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(494, 55, 117, 21);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(372, 55, 117, 21);
			
			lblModelo = new JLabel();
			pnlArriba.add(lblModelo);
			lblModelo.setText("Modelo:");
			lblModelo.setBounds(194, 57, 52, 16);		
		
			txtModelo = new JTextField();
			pnlArriba.add(txtModelo);
			txtModelo.setBounds(250, 55, 102, 21);		
			
			txtMarca = new JTextField();
			pnlArriba.add(txtMarca);
			txtMarca.setBounds(77, 54, 110, 21);
			
			btnBuscar.addActionListener(this);
			btnListar.addActionListener(this);

			pnlMedio = new JPanel();
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			pnlMedio.setPreferredSize(new java.awt.Dimension(1179, 411));

			scrLista = new JScrollPane();
			pnlMedio.add(scrLista);
			pnlMedio.add(scrLista, new AnchorConstraint(-864, 1014, 1100, -11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			scrLista.setPreferredSize(new java.awt.Dimension(1179, 413));

			tblLista = new JTable();
			scrLista.setViewportView(tblLista);
			tblLista.setModel(modelo2);
			tblLista.addMouseListener(this);
			tblLista.addKeyListener(this);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(275, 355, 114, 21);
			btnAceptar.addMouseListener(this);
			btnAceptar.addKeyListener(this);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(518, 355, 114, 21);
			btnCancelar.addMouseListener(this);
			btnCancelar.addKeyListener(this);
			btnCancelar.addActionListener(this);

			listarDetalle();
		
			TableColumn cprod = tblLista.getColumn ("Cprod"),producto= tblLista.getColumn ("Producto"),coste = tblLista.getColumn ("Coste")
			,marca = tblLista.getColumn ("Marca"),cumed= tblLista.getColumn ("CUmed"),umed= tblLista.getColumn ("Umed"),fecha = tblLista.getColumn ("Fecha"),cprove  = tblLista.getColumn ("Cprov")
			,provee = tblLista.getColumn ("Prove"),codalt = tblLista.getColumn ("Calt"),nomAlt = tblLista.getColumn ("Nalt"), modelo= tblLista.getColumn ("Modelo");
			//Id
			cprod.setPreferredWidth(10);
			producto.setPreferredWidth(370);
			coste.setPreferredWidth(30);
			marca.setPreferredWidth(50);
			cumed.setPreferredWidth(10);
			umed.setPreferredWidth(10);
			fecha.setPreferredWidth(70);
			cprove.setPreferredWidth(10);
			provee.setPreferredWidth(50);
			codalt.setPreferredWidth(10);
			nomAlt.setPreferredWidth(100);
			modelo.setPreferredWidth(70);
			/*iD.setPreferredWidth(10);
			Cant.setPreferredWidth(13);
			Und.setPreferredWidth(13);
			Descripcion.setPreferredWidth(370);
			Marca.setPreferredWidth(40);
			PTotal.setPreferredWidth(30);
			TotalD.setPreferredWidth(30);
			Costo.setPreferredWidth(30);
			Total.setPreferredWidth(30);
			Dif.setPreferredWidth(30);
			Fecha.setPreferredWidth(50);
			por.setPreferredWidth(10);
			Proveedor.setPreferredWidth(50);*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void  PintarFila(){
		
		TableColumn column0 = tblLista.getColumn(tblLista.getColumnName(0));
		TableColumn column1 = tblLista.getColumn(tblLista.getColumnName(1));
		TableColumn column2 = tblLista.getColumn(tblLista.getColumnName(2));
		TableColumn column3 = tblLista.getColumn(tblLista.getColumnName(3));
		TableColumn column4 = tblLista.getColumn(tblLista.getColumnName(4));
		TableColumn column5 = tblLista.getColumn(tblLista.getColumnName(5));
		TableColumn column6 = tblLista.getColumn(tblLista.getColumnName(6));
		TableColumn column7 = tblLista.getColumn(tblLista.getColumnName(7));
		TableColumn column8 = tblLista.getColumn(tblLista.getColumnName(8));
		TableColumn column9 = tblLista.getColumn(tblLista.getColumnName(9));
		TableColumn column10 = tblLista.getColumn(tblLista.getColumnName(10));
		TableColumn column11 = tblLista.getColumn(tblLista.getColumnName(11));
		TableColumn column12 = tblLista.getColumn(tblLista.getColumnName(12));
		TableColumn column13 = tblLista.getColumn(tblLista.getColumnName(13));
		
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
		column13.setCellRenderer(renderer);
	} 
	
	/********LISTAR DETALLE************************/
	 
		public void listarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			
			PintarFila();
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();

			
			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
				 " IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))), "+
				"  DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD "+
				"  FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
				"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
				" INNER JOIN tb_producto PROD "+
				" ON DET.COD_PROD=PROD.COD_PROD "+
				"  INNER JOIN tb_marcas MAR "+
				"  ON DET.COD_MAR=MAR.COD_MAR "+
				"  INNER JOIN tb_umed UMED "+
				"  ON DET.COD_UMED=UMED.COD_UMED "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
				"  PROD.NOM_PROD LIKE  '%%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
				" ORDER BY "+
				"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) limit 200; " ;

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
		//String titulo2[]={"Cprod","Producto","Coste","CMar","Marca","Cmed","Umed","Fecha","Cprov","Prove","Calt","Nalt"};
		//
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(12),rs.getString(13),
							rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
					modelo2.addRow(obj);
					}
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
		}
		/***********************************************/
		/********BUSCAR DETALLE************************/
		public void buscarDetalle(){
			
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String NOM_PROD=eliminarCaracteres(txtProducto.getText()),
					MARCA=txtMarca.getText();
			System.out.println("ESTO ES EL PRODUCTO:"+NOM_PROD);
			
			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
				" IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"   (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))), "+
				"   DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,PROD.PESO_PROD,PROD.MOD_PROD "+
				"  FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
				"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
				"  INNER JOIN tb_producto PROD "+
				"  ON DET.COD_PROD=PROD.COD_PROD "+
				"  INNER JOIN tb_marcas MAR "+
				"  ON DET.COD_MAR=MAR.COD_MAR "+
				"   INNER JOIN tb_umed UMED "+
				"  ON DET.COD_UMED=UMED.COD_UMED "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
				"  PROD.NOM_PROD LIKE  '%"+NOM_PROD+"%' AND  MAR.NOM_MAR LIKE '%"+MARCA+"%' AND PROD.MOD_PROD LIKE '%"+txtModelo.getText()+"%' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
			    " ORDER BY "+
				"   IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )));" ;

			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(7),rs.getString(8),rs.getString(9),
							rs.getString(10),rs.getString(12),rs.getString(13),
							rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18)};
					modelo2.addRow(obj);}
				
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			
			objAccesoBD.cerrarConexion();
			
		}
	
	
		/********PARA CARGAR LOS DATOS DEL TABLA********/
		public void cargarProdAlternativo(){
			//Obtener fila seleccionada de la tabla
			int fila = tblLista.getSelectedRow();
			//Cargar los datos de la fila seleccionada al panel de datos		
// public static String  COD_PROD,NOM_PROD,COSTE,MARCA,UMED,FECHA,COD_PROVEE,PROVEEDOR,COD_PRODALT;			
//String titulo2[]={"COD","PRODUCTO","COSTE","MARCA","UMED","FECHA","COD","PROVEEDOR","COD_ALT","NOM_ALT"};
			 COD_PROD=""+ modelo2.getValueAt(fila, 0);
			 NOM_PROD=""+ modelo2.getValueAt(fila, 1);
			 COSTE=""+ modelo2.getValueAt(fila, 2);
			 COD_MAR=""+modelo2.getValueAt(fila, 3);
			 MARCA=""+ modelo2.getValueAt(fila, 4);
			 CUMED=""+ modelo2.getValueAt(fila, 5);
			 UMED=""+ modelo2.getValueAt(fila, 6);
			
			 FECHA=""+ modelo2.getValueAt(fila, 7);
			 COD_PROVEE=""+ modelo2.getValueAt(fila,8);
			 PROVEEDOR=""+ modelo2.getValueAt(fila, 9);
			 COD_PROD1=""+ modelo2.getValueAt(fila, 10);
			 NOM_PROD1=""+ modelo2.getValueAt(fila, 11);
			 PESO_PRODUCTO=""+ modelo2.getValueAt(fila, 12);
			 MODPROD=""+ modelo2.getValueAt(fila, 13);
			 
			System.out.println("K MELA HAY N EL NOM_PROD:"+NOM_PROD);

		}
		/**********************************************************************************************************/
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
		/**********************************************************************************************************/
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==txtProducto){
				buscarDetalle();
			}
			
			if(e.getSource()==btnBuscar){
				buscarDetalle();
			}
			if(e.getSource()==btnListar){
				listarDetalle();
			}
			if(e.getSource()==btnAceptar){
				cargarProdAlternativo();
				setVisible(false);
			}
			if(e.getSource()==btnCancelar){
				NOM_PROD=null;
				setVisible(false);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getSource()==txtProducto){
				buscarDetalle();
			}
			
			if(e.getSource()==tblLista){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					cargarProdAlternativo();
					setVisible(false);
				}
				if(KeyEvent.VK_TAB==key){
					
					btnAceptar.requestFocus();
					System.out.println("entra men!");
					//txtCompra.requestFocus();
				}
			}
		
			if(e.getSource()==btnAceptar){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					cargarProdAlternativo();
					setVisible(false);
				}
				if(KeyEvent.VK_TAB==key){
					btnCancelar.requestFocus();
				}
			}
			if(e.getSource()==btnCancelar){
				int key = e.getKeyCode();
				if(KeyEvent.VK_ENTER==key){
					NOM_PROD=null;
					setVisible(false);
				}
			}
			//KeyStroke.getKeyStroke("Ctrl C")
			//System.out.println(KeyStroke.getkey);
			
			System.out.println("ya:"+e.getKeyText(e.getKeyCode()));
			/***********************************************************************************************/
			/*                                        BOTON "+"                                            */
			if(e.getKeyText(e.getKeyCode()).equals("+ de teclado numérico")){
			if(veces==0){
				this.setSize(1284, 566);
				veces=1;
			}else if(veces==1){
				this.setSize(1392, 652);
				veces=2;
				//1392,height=652
			}else if(veces==2){//width=1427,height=815
				this.setSize(1427, 815);
				veces=3;
			}else{
				this.setSize(917, 422);
				veces=0;
			}
			}
			/************************************************************************************************/
			/***********************************************************************************************/
			/*                                        BOTON "ESCAPE"                                      */
			if(e.getKeyText(e.getKeyCode()).equals("Escape")){
				NOM_PROD=null;
				setVisible(false);
				}
			/***********************************************************************************************/
		

		
			
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
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==btnAceptar){
				cargarProdAlternativo();
				setVisible(false);
			}
			if(e.getSource()==btnCancelar){
				//cboProducto.requestFocus();
				NOM_PROD=null;
				setVisible(false);
			}
			
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
			if(e.getSource()==tblLista){
				cargarProdAlternativo();
			}
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
