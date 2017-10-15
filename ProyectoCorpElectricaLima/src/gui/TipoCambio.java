package gui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import miLib.AccesoBD;
import calendar.DateButton;


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
public class TipoCambio extends JInternalFrame implements ActionListener {
	private JPanel pnlPrincipal;
	private JButton btnCancelar;
	private JButton btnAyer;
	private JButton btnAceptar;
	private JTextField txtVenta;
	private JTextField txtCompra;
	private JComboBox cboMoneda;
	private JLabel lblVenta;
	private JLabel lblCompra;
	private JLabel lblMoneda;
	private JLabel lblFecha;
	private JPanel pnlTipoCambio;
	private DateButton btnFecha;
    
	
	public TipoCambio() {
		super("Tipo de Cambio", true, true, true, true);
		try {
			setVisible(true);
			
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(388, 221));

					pnlTipoCambio = new JPanel();
					pnlPrincipal.add(pnlTipoCambio);
					pnlTipoCambio.setBorder(BorderFactory.createTitledBorder("Tipo de Cambio"));
					pnlTipoCambio.setBounds(12, 12, 240, 173);
					pnlTipoCambio.setLayout(null);

					btnAceptar = new JButton();
					pnlPrincipal.add(btnAceptar);
					btnAceptar.setText("Aceptar");
					btnAceptar.setBounds(264, 32, 94, 23);
					btnAceptar.addActionListener(this);

					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(262, 124, 94, 23);
					btnCancelar.addActionListener(this);

					btnAyer = new JButton();
					pnlPrincipal.add(btnAyer);
					btnAyer.setText("Fecha Anterior");
					btnAyer.setBounds(263, 75, 94, 23);

					btnAyer.addActionListener(this);

					lblFecha = new JLabel();
					pnlTipoCambio.add(lblFecha);
					lblFecha.setText("Fecha:");
					lblFecha.setBounds(17, 27, 44, 14);

					lblMoneda = new JLabel();
					pnlTipoCambio.add(lblMoneda);
					lblMoneda.setText("Moneda:");
					lblMoneda.setBounds(17, 65, 51, 14);

					lblCompra = new JLabel();
					pnlTipoCambio.add(lblCompra);
					lblCompra.setText("Compra:");
					lblCompra.setBounds(17, 103, 51, 14);

					lblVenta = new JLabel();
					pnlTipoCambio.add(lblVenta);
					lblVenta.setText("Venta:");
					lblVenta.setBounds(17, 137, 51, 14);

					
					
					cboMoneda = new JComboBox();
					pnlTipoCambio.add(cboMoneda);
					cboMoneda.addItem("Dolar $");
					cboMoneda.addItem("Euro  €");
				
					cboMoneda.setBounds(75, 62, 139, 22);
					cboMoneda.setEnabled(false);

					txtCompra = new JTextField();
					pnlTipoCambio.add(txtCompra);
					txtCompra.setBounds(75, 100, 139, 22);

					txtVenta = new JTextField();
					pnlTipoCambio.add(txtVenta);
					txtVenta.setBounds(75, 134, 139, 22);
					
					btnFecha = new DateButton();
					btnFecha.setFont(new Font("dialog",0,12));
					pnlTipoCambio.add(btnFecha);
					btnFecha.setBounds(79, 23, 139, 22);
					
					cargarTipoCambio();

					
			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/********CARGA LAS FECHAS********************************/
	
	/*SELECT * FROM cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM)
FROM CAMBIO WHERE FECHA='2009-11-26');*/
	

	public void cargarTipoCambio(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String fecha=btnFecha.getText(),
		dia=fecha.substring(0, fecha.indexOf("-")),
		mes=fecha.substring(3, 5),
		año=fecha.substring(6, 10);
		fecha=año+"-"+mes+"-"+dia;
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM)" +
				" FROM tb_cambio WHERE FECHA='"+fecha+"'); ";

		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				if(rs.getString(1).equals("")){
					System.out.println("No hay fecha para hoy"+rs.getString(1));
				}else{
				txtCompra.setText(rs.getString(3));
				txtVenta.setText(rs.getString(4));		
				}
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	
	
	/*********************************************************/
	
	/********AGREGAR TIPO DE CAMBIO************************/
	public void agregarTipoCambio(){
//		String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String compra=txtCompra.getText(),venta=txtVenta.getText(),moneda=(String)cboMoneda.getSelectedItem(),fecha=btnFecha.getText(),
		dia=fecha.substring(0, fecha.indexOf("-")),
		mes=fecha.substring(3, 5),
		año=fecha.substring(6, 10);
		fecha=año+"-"+mes+"-"+dia;
		
		
		String insertarCambio="INSERT INTO tb_cambio VALUES("+null+",'"+fecha+"','"+compra+"','"+venta+"')";
		System.out.println(insertarCambio);
		int op= objAccesoBD.ejecutarActualizacion(insertarCambio);
		//System.out.println(insertarPregunta);
		if(op==0){System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");}
		else{System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar product0 !!!!!!!");}
		//objAccesoBD.cerrarConexion();
	objAccesoBD.cerrarConexion();
		
	}
	/***********************************************/
	/********ULTIMA FECHA************************/
	public void ultimaFecha(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_cambio WHERE COD_CAM = ( SELECT  MAX(COD_CAM) FROM tb_cambio); ";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				txtCompra.setText(rs.getString(3));
				txtVenta.setText(rs.getString(4));		
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar){
	
			agregarTipoCambio();
		
			
		}
		if(e.getSource()==btnAyer){
			ultimaFecha();
		}
		
		
		
	}
	
	
	
	
	

}
