package pOp;
import java.awt.Font;
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
import miLib.Fecha;
import beans.Globales;
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
public class CargarCotInc extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JLabel lblCliente;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton btnListar;
	private JButton btnBuscar;
	private DateButton btnFecha1;
	public static JTextField txtCliente;
	public static String ide_cot_inc,
	 nom_cli,cona_cli,fec_coti,ref_cot_inc;
	public static int est_emp;
	Globales objGlo; 
	 Fecha objFecha;
	/* public static String codcli="0",
	 nomcli="ERROR",tipcli,ruccli,lugcli,conacli="ERROR",tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
	String titulo2[]={"IDE_COT_INC","NOM_CLI","CONTACTO","FECHA_COTINC","EMPRESA"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	public CargarCotInc() {
		try {
			
			this.setPreferredSize(new java.awt.Dimension(725, 301));
			this.setLayout(null);

			lblCliente = new JLabel();
			this.add(lblCliente);
			lblCliente.setText("Cliente:");
			lblCliente.setBounds(22, 19, 58, 14);

			txtCliente = new JTextField();
			this.add(txtCliente);
			txtCliente.setBounds(71, 16, 364, 21);
			txtCliente.addKeyListener(this);

			jScrollPane1 = new JScrollPane();
			this.add(jScrollPane1);
			jScrollPane1.setBounds(12, 74, 701, 222);

			
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			
			btnFecha1 = new DateButton();
			this.add(btnFecha1);
			btnFecha1.setFont(new Font("dialog",0,12));
			btnFecha1.setBounds(466, 16, 135, 22);
			btnFecha1.setSize(135, 21);

			btnBuscar = new JButton();
			this.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(611, 16, 102, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			this.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(611, 43, 102, 21);
			btnListar.addActionListener(this);
			this.setVisible(true);
			listarCoti_Inconclusa();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/********BUSCAR COTI_INCONCLUSA************************/
	public void buscarCoti_Inconclusa(){
		int cod_ven=Globales.COD_VEN;
		String fec=objFecha.convrtidorFec(btnFecha1.getDate());
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtCliente.getText();

		String sql="SELECT COTI.IDE_COT_INC,CLI.NOM_CLI,CLI.CONA_CLI,COTI.FECHA_COTI,coti.est_emp FROM tb_cotizacioninconclusa COTI INNER JOIN tb_cliente CLI "+
		" ON COTI.COD_CLI = CLI.COD_CLI INNER JOIN tb_vendedores VEN ON COTI.COD_VEN = VEN.COD_VEN "+
		" WHERE COTI.NUM_ITEM=1 AND COTI.COD_VEN='"+cod_ven+"' AND CLI.NOM_CLI LIKE '%"+NOM_CLI+"%' AND COTI.FECHA_COTI='"+fec+"';";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	
	/***********************************************/
	/********LISTAR COTI_INCONCLUSA************************/
	public void listarCoti_Inconclusa(){
		int cod_ven=Globales.COD_VEN;
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COTI.IDE_COT_INC,CLI.NOM_CLI,CLI.CONA_CLI,COTI.FECHA_COTI,coti.est_emp FROM tb_cotizacioninconclusa COTI INNER JOIN tb_cliente CLI "+
		"ON COTI.COD_CLI = CLI.COD_CLI INNER JOIN tb_vendedores VEN ON COTI.COD_VEN = VEN.COD_VEN "+
		"WHERE COTI.NUM_ITEM=1 AND COTI.COD_VEN='"+cod_ven+"';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarCoti_Inc(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		/*public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		 ide_cot_inc= ""+modelo2.getValueAt(fila, 0);
		 nom_cli= ""+modelo2.getValueAt(fila, 1);
		 cona_cli=""+modelo2.getValueAt(fila, 2);
		 fec_coti= ""+modelo2.getValueAt(fila, 3);
		 est_emp= Integer.parseInt(""+modelo2.getValueAt(fila,4));
		 
	}
	/***********************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			try {
				buscarCoti_Inconclusa();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		if(e.getSource()==btnListar){
			listarCoti_Inconclusa();
		}
		
		
	}
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
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarCoti_Inc();}}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	/*	if(e.getSource()==txtCliente){
			try {
				buscarCliente();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}*/
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
