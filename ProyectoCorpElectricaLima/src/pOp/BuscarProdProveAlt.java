package pOp;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;

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
public class BuscarProdProveAlt extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JLabel lblProducto;
	private JTextField txtProducto;
	private JPanel pnlOtros;
	private JTable jTable1;
	private JPanel pnlBotones;
	private JScrollPane scrDetalle;
	private JButton btnListar;
	private JButton btnBuscar;
	
	String titulo2[]={"COD","PRODUCTO","MAR","OBS","PROVEE","OBS"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String COD_PROD;
	public static String NOM_PROD, NOM_MAR;
	public  BuscarProdProveAlt() {
		try {

			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);

			pnlBotones = new JPanel();
			this.add(pnlBotones, BorderLayout.CENTER);
			pnlBotones.setPreferredSize(new java.awt.Dimension(647, 62));

			lblProducto = new JLabel();
			pnlBotones.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setPreferredSize(new java.awt.Dimension(53, 19));

			txtProducto = new JTextField();
			pnlBotones.add(txtProducto);
			txtProducto.setPreferredSize(new java.awt.Dimension(550, 19));
			txtProducto.addKeyListener(this);

			pnlOtros = new JPanel();
			pnlBotones.add(pnlOtros);
			pnlOtros.setPreferredSize(new java.awt.Dimension(583, 39));

			btnBuscar = new JButton();
			pnlOtros.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setPreferredSize(new java.awt.Dimension(76, 22));
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlOtros.add(btnListar);
			GridLayout btnListarLayout = new GridLayout(1, 1);
			btnListarLayout.setColumns(1);
			btnListarLayout.setHgap(5);
			btnListarLayout.setVgap(5);
			btnListar.setLayout(btnListarLayout);
			btnListar.setText("Listar");
			btnListar.setPreferredSize(new java.awt.Dimension(76, 22));
			btnListar.addActionListener(this);

			scrDetalle = new JScrollPane();
			this.add(scrDetalle, BorderLayout.SOUTH);
			scrDetalle.setPreferredSize(new java.awt.Dimension(647, 277));

			
			
			jTable1 = new JTable();
			scrDetalle.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			setVisible(true);
			
			listarDetalle();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
//String titulo2[]={"COD","PRODUCTO","MAR","OBS","PROVEE","OBS"};
	/********LISTAR DETALLE************************/
	  /*SELECT PROD.COD_PROD,PROD.NOM_PROD,MAR.NOM_MAR,PROD.OBS_PROD,PROVE.NOM_PROVE,PMP.OBS_DET
		FROM TB_PRODMARPROVE PMP INNER JOIN TB_PRODMAR PM
		ON PM.COD_PROD=PMP.COD_PROD AND PM.COD_MAR=PMP.COD_MAR
    INNER JOIN tb_proveedor PROVE
		ON PROVE.COD_PROVE=PMP.COD_PROVE
		INNER JOIN tb_producto PROD
		ON PROD.COD_PROD=PMP.COD_PROD AND PROD.COD_PROD=PM.COD_PROD
    INNER JOIN tb_marcas MAR
    ON MAR.COD_MAR=PMP.COD_MAR AND MAR.COD_MAR=PM.COD_MAR
    WHERE PMP.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO';*/
		public void listarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
		//	String titulo2[]={"COD","PRODUCTO","MAR","OBS","PROVEE","OBS"};
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();

			String sql="  SELECT PROD.COD_PROD,PROD.NOM_PROD,MAR.NOM_MAR,PROD.OBS_PROD,PROVE.NOM_PROVE,DET.OBS_DET "+
				"  FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
				"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
				"  INNER JOIN tb_producto PROD "+
				"  ON PROD.COD_PROD=DET.COD_PROD "+
				" INNER JOIN tb_marcas MAR "+
				" ON MAR.COD_MAR=DET.COD_MAR "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' "; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det;";

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6)
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
		/********PARA CARGAR LOS DATOS DEL TABLA********/
		public void cargarDetalle(){
			//Obtener fila seleccionada de la tabla
			int fila = jTable1.getSelectedRow();
			int cod=  Integer.parseInt(""+modelo2.getValueAt(fila, 0));
			COD_PROD=String.valueOf(cod);
//			String titulo2[]={"COD","PRODUCTO","MAR","OBS","PROVEE","OBS"};
			NOM_PROD=(String)modelo2.getValueAt(fila, 1);
			txtProducto.setText(NOM_PROD);
			NOM_MAR=(String)modelo2.getValueAt(fila, 2);
			
		}
		/***********************************************/
		/********BUSCAR DETALLE************************/
		public void buscarDetalle(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
			
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String NOM_PROD=txtProducto.getText(),EST_DET="ACTIVADO";
			String sql=" SELECT PROD.COD_PROD,PROD.NOM_PROD,MAR.NOM_MAR,PROD.OBS_PROD,PROVE.NOM_PROVE,DET.OBS_DET "+
				"  FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
				"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
				"  INNER JOIN tb_producto PROD "+
				"  ON PROD.COD_PROD=DET.COD_PROD "+
				"  INNER JOIN tb_marcas MAR "+
				"  ON MAR.COD_MAR=DET.COD_MAR "+
				"  WHERE DET.EST_DET='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND "+
				"  PROD.NOM_PROD LIKE '%"+NOM_PROD+"%' "; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det;";
			System.out.println(sql);
			
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6)
					};
					modelo2.addRow(obj);}
				
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
			
			
			objAccesoBD.cerrarConexion();
			
		}
		
		/***********************************************/
	
		
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			
			buscarDetalle();
		}
		if(e.getSource()==btnListar){
			listarDetalle();
		}
		
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==jTable1){cargarDetalle();}
	}
	public void mouseReleased(MouseEvent e) {}
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource()==txtProducto){
			buscarDetalle();
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}


} 
