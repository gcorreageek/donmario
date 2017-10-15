package pOp;
import gui.TranCotizacionAutMant;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class CambiarCosto extends JPanel implements KeyListener {
	private JComboBox cboMarca;
	private JLabel lblMoneda;
	private JLabel lblMarca;
	private JComboBox cboUMedida;
	private JLabel lblUMedida;
	private JTextField txtProveedor;
	private JLabel lblProveedor;
	private JTextField txtProducto;
	public static JTextField txtCostoActualTransformado;
	public static JTextField txtCostoNuevoTransformado;
	private JLabel lblCostoNuevoTransformado;
	private JLabel lblCostoActualTransformado;
	public static JTextField txtCostoRealNuevo;
	private JLabel lblCostoRealNuevo;
	public static JTextField txtCostoRealActual;
	private JLabel lblCostoRealActual;
	private JComboBox cboIgv;
	private JLabel lblIgv;
	private JComboBox cboMoneda;
	private JLabel lblProducto;
	public TranCotizacionAutMant objTraCotMant;

	public CambiarCosto() {
		try {
			
			this.setName("Cambiar Costo de Compra");

			this.setSize(310, 101);
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(603, 161));

			lblProducto = new JLabel();
			this.add(lblProducto);
			lblProducto.setText("Producto:");
			lblProducto.setBounds(14, 10, 70, 14);

			txtProducto = new JTextField();
			this.add(txtProducto);
			txtProducto.setBounds(84, 7, 507, 21);
			txtProducto.setEnabled(false);

			lblProveedor = new JLabel();
			this.add(lblProveedor);
			lblProveedor.setText("Proveedor:");
			lblProveedor.setBounds(13, 38, 70, 14);

			txtProveedor = new JTextField();
			this.add(txtProveedor);
			txtProveedor.setBounds(84, 35, 507, 21);
			txtProveedor.setEnabled(false);

			lblUMedida = new JLabel();
			this.add(lblUMedida);
			lblUMedida.setText("U.Medida:");
			lblUMedida.setBounds(14, 67, 70, 14);

			
			cboUMedida = new JComboBox();
			this.add(cboUMedida);
			cboUMedida.setBounds(84, 63, 70, 21);
			cboUMedida.setEnabled(false);

			lblMarca = new JLabel();
			this.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(158, 67, 55, 14);

			lblMoneda = new JLabel();
			this.add(lblMoneda);
			lblMoneda.setText("Moneda:");
			lblMoneda.setBounds(323, 67, 61, 14);

			
			cboMarca = new JComboBox();
			this.add(cboMarca);
			cboMarca.setBounds(212, 63, 104, 23);
			cboMarca.setEnabled(false);

			
			cboMoneda = new JComboBox();
			this.add(cboMoneda);
			cboMoneda.setBounds(383, 63, 48, 23);
			cboMoneda.setEnabled(false);

			lblIgv = new JLabel();
			this.add(lblIgv);
			lblIgv.setText("Igv:");
			lblIgv.setBounds(437, 66, 35, 16);

			
			cboIgv = new JComboBox();
			this.add(cboIgv);
			cboIgv.setBounds(472, 63, 119, 23);
			cboIgv.setEnabled(false);

			lblCostoRealActual = new JLabel();
			this.add(lblCostoRealActual);
			lblCostoRealActual.setText("Costo Real Actual:");
			lblCostoRealActual.setBounds(20, 96, 116, 16);

			txtCostoRealActual = new JTextField();
			this.add(txtCostoRealActual);
			txtCostoRealActual.setBounds(142, 92, 80, 23);
			txtCostoRealActual.setEnabled(false);
			txtCostoRealActual.setSize(80, 21);
			txtCostoRealActual.setForeground(new java.awt.Color(64,0,64));

			lblCostoRealNuevo = new JLabel();
			this.add(lblCostoRealNuevo);
			lblCostoRealNuevo.setText("Costo Real Nuevo:");
			lblCostoRealNuevo.setBounds(234, 95, 116, 16);

			txtCostoRealNuevo = new JTextField();
			this.add(txtCostoRealNuevo);
			txtCostoRealNuevo.setBounds(356, 91, 80, 23);
			txtCostoRealNuevo.setSize(80, 21);
			txtCostoRealNuevo.addKeyListener(this);

			lblCostoActualTransformado = new JLabel();
			this.add(lblCostoActualTransformado);
			lblCostoActualTransformado.setText("Costo Actual Tras:");
			lblCostoActualTransformado.setBounds(20, 125, 104, 16);

			txtCostoActualTransformado = new JTextField();
			this.add(txtCostoActualTransformado);
			this.add(getJLabel1());
			this.add(getTxtCostoNuevoTransformado());
			txtCostoActualTransformado.setBounds(142, 121, 80, 23);
			txtCostoActualTransformado.setEnabled(false);
			txtCostoActualTransformado.setSize(80, 21);
			txtCostoActualTransformado.setForeground(new java.awt.Color(64,0,64));

			verificar();
		} catch(Exception e) {
			e.printStackTrace();
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
	public Double cambioCompraMax(){
		Double num=0.0;
		AccesoBD objA= new AccesoBD();
		objA.crearConexion();
		
		String sql= "SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)";
		ResultSet rs=objA.ejecutarConsulta(sql);
		
		try {
			if(rs.next()){
				num=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public Double calcular(){
		Double cost=Double.parseDouble(txtCostoRealNuevo.getText());
		Double costTrans=0.0;
		if(cboMoneda.getSelectedItem().equals("$")){
			if(cboIgv.getSelectedItem().equals("Mas IGV")){	
				costTrans=cost;
			}else{
				costTrans=cost/1.18;
			}
		}else{
			if(cboIgv.getSelectedItem().equals("Con IGV")){	
				costTrans=(cost/cambioCompraMax())/1.18;
			}else{
				costTrans=cost/cambioCompraMax();
			}	
		}
		return formato(costTrans);
	}
	public void verificar(){
		String cos=objTraCotMant.cOs;
		if(cos.equals("0")){
			txtCostoNuevoTransformado.setText("");
			metodoSacarDatos();
		}else{
			metodoSacarDatos();
			txtCostoRealActual.setText(cos);
			txtCostoRealNuevo.setText(cos);
			Double cost=calcular();
			txtCostoActualTransformado.setText(cost.toString());
			txtCostoRealNuevo.setText("");
			txtCostoNuevoTransformado.setText("");
			
		}
		
		
		
		
		
		
	}
	public void metodoSacarDatos(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT PROD.NOM_PROD,PROVE.NOM_PROVE,UMED.NOM_UMED,MAR.NOM_MAR,DET.MON_DET,IF((DET.IGV_DET=0),'Con IGV','Mas IGV') AS IGV,DET.COS_DET, "+
				" ROUND((( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
			"  (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))  "+
			"    )) ,3)   as COSTO "+
			"   FROM tb_proveprodmarumed1 DET "+
			"  INNER JOIN tb_producto PROD "+
			"    ON DET.COD_PROD=PROD.COD_PROD "+
			"  INNER JOIN tb_proveedor PROVE "+
			"  ON PROVE.COD_PROVE=DET.COD_PROVE "+
			"   INNER JOIN tb_marcas MAR "+
			"   ON MAR.COD_MAR=DET.COD_MAR "+
			"   INNER JOIN tb_umed UMED "+
			"   ON UMED.COD_UMED=DET.COD_UMED "+
			"   INNER JOIN tb_rubro RUB "+
			"   ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
			"  WHERE  DET.COD_PROD='"+objTraCotMant.codprodpasar+"' AND DET.COD_PROVE='"+objTraCotMant.codprovepasar+"' AND DET.COD_UMED='"+objTraCotMant.codumedpasar+"' AND DET.COD_MAR='"+objTraCotMant.codmarpasar+"' "; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det  ;";
	
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				txtProducto.setText(rs.getString(1));
				txtProveedor.setText(rs.getString(2));
				cboUMedida.addItem(rs.getString(3));
				cboMarca.addItem(rs.getString(4));
				cboMoneda.addItem(rs.getString(5));
				cboIgv.addItem(rs.getString(6));
				txtCostoRealActual.setText(rs.getString(7));
				txtCostoActualTransformado.setText(rs.getString(8));
				
				
			}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		objAccesoBD.cerrarConexion();
		}

	@Override
	public void keyPressed(KeyEvent e) {
	
		if(e.getSource()==txtCostoRealNuevo){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				txtCostoNuevoTransformado.setText(calcular().toString());
			}	
			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JLabel getJLabel1() {
		if(lblCostoNuevoTransformado == null) {
			lblCostoNuevoTransformado = new JLabel();
			lblCostoNuevoTransformado.setText("Costo Nuevo Tras:");
			lblCostoNuevoTransformado.setBounds(234, 125, 104, 16);
		}
		return lblCostoNuevoTransformado;
	}
	
	private JTextField getTxtCostoNuevoTransformado() {
		if(txtCostoNuevoTransformado == null) {
			txtCostoNuevoTransformado = new JTextField();
			txtCostoNuevoTransformado.setBounds(356, 122, 80, 21);
		}
		return txtCostoNuevoTransformado;
	}

}
