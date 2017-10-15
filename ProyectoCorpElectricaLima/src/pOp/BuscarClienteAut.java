package pOp;
import gui.TranCotizacionAutomatica;

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
import miLib.AccesoBD2;

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
public class BuscarClienteAut extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JLabel lblCliente;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton btnListar;
	private JButton btnBuscar;
	public static JTextField txtCliente;
	public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;
	/* public static String codcli="0",
	 nomcli="ERROR",tipcli,ruccli,lugcli,conacli="ERROR",tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
	String titulo2[]={"COD_CLI","NOM_CLI","TIP_CLI","RUC_CLI","CONA_CLI",
			          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 
	 TranCotizacionAutomatica objcot= new TranCotizacionAutomatica();
	public BuscarClienteAut() {
		try {
			
			this.setPreferredSize(new java.awt.Dimension(735, 275));
			this.setLayout(null);

			lblCliente = new JLabel();
			this.add(lblCliente);
			lblCliente.setText("Cliente:");
			lblCliente.setBounds(22, 19, 58, 14);

			txtCliente = new JTextField();
			this.add(txtCliente);
			txtCliente.setBounds(80, 16, 364, 21);
			txtCliente.addKeyListener(this);

			jScrollPane1 = new JScrollPane();
			this.add(jScrollPane1);
			jScrollPane1.setBounds(22, 48, 701, 222);

			
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			btnBuscar = new JButton();
			this.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(521, 16, 78, 21);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			this.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(618, 16, 78, 21);
			btnListar.addActionListener(this);
			this.setVisible(true);
			
			if(objcot.estado==1){
				listarCliente();
			}else if(objcot.estado==2){
				listarCliente2();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		buscarCliente();
	}
	/********BUSCAR CLIENTE************************/
	public void buscarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtCliente.getText();
	/*SELECT COD_CLI,NOM_CLI,RUC_CLI,LUG_CLI,CONA_CLI,TEL1A_CLI,
	TEL2A_CLI,RPMA_CLI,NEXA_CLI,CELA_CLI,MAILA_CLI
	fROM CLIENTE  WHERE EST_CLI='ACTIVADO'
	AND  NOM_CLI like '%CONSTRUCTORA INMOBILIARIA SAN LUIS%';*/
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI,"+
                   "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI "+
	               "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' "+
                   "AND  CLI.NOM_CLI LIKE '%"+NOM_CLI+"%' order by CLI.COD_CLI asc;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	
	/***********************************************/
	public void buscarCliente2(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD2 objAccesoBD2 = new AccesoBD2();
		objAccesoBD2.crearConexion();
		String NOM_CLI=txtCliente.getText();
	/*SELECT COD_CLI,NOM_CLI,RUC_CLI,LUG_CLI,CONA_CLI,TEL1A_CLI,
	TEL2A_CLI,RPMA_CLI,NEXA_CLI,CELA_CLI,MAILA_CLI
	fROM CLIENTE  WHERE EST_CLI='ACTIVADO'
	AND  NOM_CLI like '%CONSTRUCTORA INMOBILIARIA SAN LUIS%';*/
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI,"+
                   "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI "+
	               "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' "+
                   "AND  CLI.NOM_CLI LIKE '%"+NOM_CLI+"%' order by CLI.COD_CLI asc;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD2.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD2.cerrarConexion();
	}
	
	/***********************************************/
	/********LISTAR CLIENTE************************/
	public void listarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI, "+
                   "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI "+
                   "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI asc;"; 
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	public void listarCliente2(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD2 objAccesoBD2 = new AccesoBD2();
		objAccesoBD2.crearConexion();
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI, "+
                   "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI "+
                   "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI asc;"; 
		ResultSet rs = objAccesoBD2.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD2.cerrarConexion();
	}
	/***********************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarCliente(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		/*public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		 codcli= ""+modelo2.getValueAt(fila, 0);
		 nomcli= ""+modelo2.getValueAt(fila, 1);
		 tipcli= ""+modelo2.getValueAt(fila, 2);
		 ruccli= ""+modelo2.getValueAt(fila, 3);
		 lugcli= ""+modelo2.getValueAt(fila, 4);
		 conacli= ""+modelo2.getValueAt(fila, 5);
		 tel1acli= ""+modelo2.getValueAt(fila, 6);
		 tel2acli= ""+modelo2.getValueAt(fila, 7);
		 rpmacli= ""+modelo2.getValueAt(fila, 8);
		 nexacli= ""+modelo2.getValueAt(fila, 9);
		 celacli= ""+modelo2.getValueAt(fila, 10);
		 mailacli= ""+modelo2.getValueAt(fila, 11);
	}
	/***********************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			/*try {
				if(objcot.estado==1){
					buscarCliente();
				}else if(objcot.estado==2){
					buscarCliente2();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}*/buscarCliente();
			
		}
		if(e.getSource()==btnListar){
			buscarCliente();/*if(objcot.estado==1){
				listarCliente();
			}else if(objcot.estado==2){
				listarCliente2();
			}*/
			
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
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarCliente();}}
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
