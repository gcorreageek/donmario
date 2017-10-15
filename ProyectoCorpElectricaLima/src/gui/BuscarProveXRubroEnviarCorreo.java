package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import servlet.ServletEnvioProveedor;
import beans.BeanEnvioProveedor;

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
public class BuscarProveXRubroEnviarCorreo extends JInternalFrame implements KeyListener, ActionListener, MouseListener {
	private JPanel pnlArriba;
	private JPanel pnlMedio;
	private JScrollPane jScrollPane1;
	private JButton btnEnviar;
	private JPanel pnlAbajo;
	private JTable jTable1;
	private JButton btnBuscar;
	public static ServletEnvioProveedor objServlet=null;
	MenuPrincipal objMenu;
	EnviarCorreoProveedor objEnviarProveedores;
	JComboBox cboRubro;
	JLabel lblRubro ;
	String titulo2[]={"CodProve","Prove","Prod","Rubro"};
	
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	//COD_PROVE, NOM_PROVE, COD_PROD, NOM_PROD, COD_MAR, NOM_MAR, COD_UMED, NOM_UMED, COS_DET, MON_DET, IGV_DET, FEC_DET, NOM_RUBRO, POR_RUBRO, costo, costoVenta
	public BuscarProveXRubroEnviarCorreo() {
		super("Buscar Proveedor x Rubro", true, true, true, true);
		try {
			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(830, 434));
			this.setBounds(0, 0, 830, 434);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(828, 44));
			pnlArriba.setLayout(null);

			pnlMedio = new JPanel();
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			getContentPane().add(pnlMedio, BorderLayout.CENTER);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			btnEnviar = new JButton();
			pnlAbajo.add(btnEnviar);
			btnEnviar.setText("Enviar");
			btnEnviar.setPreferredSize(new java.awt.Dimension(113, 23));
			btnEnviar.addActionListener(this);

			jScrollPane1 = new JScrollPane();
			pnlMedio.add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(610, 314));

		
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);

				btnBuscar = new JButton();
				pnlArriba.add(btnBuscar);
				btnBuscar.setText("Buscar");
				btnBuscar.setBounds(476, 10, 102, 21);

				 lblRubro = new JLabel();
				pnlArriba.add(lblRubro);
				lblRubro.setText("Rubro:");
				lblRubro.setBounds(18, 12, 63, 16);

				
				cboRubro = new JComboBox();
				cboRubro.addItem("");
				pnlArriba.add(cboRubro);
				cboRubro.setBounds(76, 9, 357, 23);
				cboRubro.addActionListener(this);

				btnBuscar.addMouseListener(this);
				btnBuscar.addKeyListener(this);
				btnBuscar.addActionListener(this);

				listarProducto();
				cargarRubro();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
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
		String sql="SELECT  PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.NOM_PROD,RUB.NOM_RUBRO "+
					" FROM tb_proveprodmarumed1 DET "+
					" INNER JOIN tb_proveedor PROVE "+
					" ON PROVE.COD_PROVE=DET.COD_PROVE "+
					" INNER JOIN tb_producto PROD "+
					" ON PROD.COD_PROD = DET.COD_PROD "+
					" INNER JOIN tb_rubro RUB "+
					" ON RUB.COD_RUBRO =PROD.COD_RUBRO "+
					" WHERE  PROVE.EST_PROVE='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
					" AND RUB.NOM_RUBRO LIKE '%%' "+
					" GROUP BY PROVE.NOM_PROVE  ;";
		System.out.println("LISTA:"+sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	public void cargarRubro(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_rubro WHERE EST_RUBRO='ACTIVADO';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboRubro.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			
		}

		objAccesoBD.cerrarConexion();
		
		
	}
	public void buscarProducto(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String nomRubro=""+cboRubro.getSelectedItem();
		nomRubro=nomRubro.substring(nomRubro.indexOf("-")+1,nomRubro.length() );
		String sql="SELECT  PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.NOM_PROD,RUB.NOM_RUBRO "+
		" FROM tb_proveprodmarumed1 DET "+
		" INNER JOIN tb_proveedor PROVE "+
		" ON PROVE.COD_PROVE=DET.COD_PROVE "+
		" INNER JOIN tb_producto PROD "+
		" ON PROD.COD_PROD = DET.COD_PROD "+
		" INNER JOIN tb_rubro RUB "+
		" ON RUB.COD_RUBRO =PROD.COD_RUBRO "+
		" WHERE  PROVE.EST_PROVE='ACTIVADO' AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
		" AND RUB.COD_RUBRO = '"+nomRubro+"' "+
		" GROUP BY PROVE.NOM_PROVE;";
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}


	public boolean guardarLosCorreos(){
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		boolean valor = true;
		objServlet= new ServletEnvioProveedor();
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			Object obj=modelo2.getValueAt(i, 0);
			/*COD_PROVE, NOM_PROVE, RUC_PROVE, TIP_PROVE, COD_DEP, COD_PRO, 
			 * COD_DIS, PER_PROVE, SEX_PROVE, DIR_PROVE, BAN_PROVE, NCUD_PROVE, 
			 * NCUS_PROVE, TEL1_PROVE, TEL2_PROVE, RPM_PROVE, NEX_PROVE, CEL_PROVE, 
			 * FAX_PROVE, MAIL_PROVE, WEB_PROVE, OBS_PROVE, NOMC_PROVE, CARC_PROVE, 
			 * TELC_PROVE, CELC_PROVE, MAILC_PROVE, RPMC_PROVE, NEXC_PROVE, OBSC_PROVE, EST_PROVE*/
			String sql="SELECT COD_PROVE,NOM_PROVE,PER_PROVE,SEX_PROVE,MAIL_PROVE,MAILC_PROVE FROM tb_proveedor WHERE COD_PROVE='"+obj+"'";
			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				if(rs.next()){
		BeanEnvioProveedor objbean= 
		new BeanEnvioProveedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
					
		objServlet.adicionar(objbean);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		System.out.println("tam:"+objServlet.tamaño());
		if(objServlet==null)
			valor=false;
		else
			valor=true;
		
		
		return valor;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cboRubro){
			buscarProducto();
		}
		if(e.getSource()==btnBuscar){
			buscarProducto();
		}
		if(e.getSource()==btnEnviar){
			guardarLosCorreos();
			System.out.println(objServlet.tamaño());
			
			
			

			if(objEnviarProveedores==null||objEnviarProveedores.isClosed()){
				//objGUI.mostrarAviso("En Construccion.....!!");
				objEnviarProveedores= new EnviarCorreoProveedor();
				objEnviarProveedores.setVisible(true);
				objMenu.jDesktopPane1.add(objEnviarProveedores);
			try{this.setClosed(true);
				}catch(PropertyVetoException e1){e1.printStackTrace();}
			try {objEnviarProveedores.setSelected(true);} catch (java.beans.PropertyVetoException ee) {}
					}
		}
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
	
		
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
