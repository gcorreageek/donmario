package pOp;
import gui.TranCotizacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
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
public class BuscarCliente extends JPanel implements MouseListener, ActionListener {
	private JPanel pnlPrincipal;
	private JTextField txtNombre;
	private JTable jTable1;
	private JButton btnListar;
	private JScrollPane jScrollPane1;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JPanel pnlBuscarCliente;
	String titulo2[]={"COD_CLI","NOM_CLI","TIP_CLI","RUC_CLI",
	          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAILA","MAILB","DIRCLI"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli,mailbcli,dircli;
	 
	 TranCotizacion objcot =new TranCotizacion();
	
	 public BuscarCliente() {
		try {
			System.out.println("entra al BuscarCliente");

			//getContentPane().add(pnlPrincipal, BorderLayout.CENTER);

			setVisible(true);

			pnlPrincipal = new JPanel();
			this.add(pnlPrincipal);

			pnlBuscarCliente = new JPanel();
			pnlPrincipal.add(pnlBuscarCliente);

			lblNombre = new JLabel();

			txtNombre = new JTextField();

			btnBuscar = new JButton();
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(440, 55, 97, 23);
			btnBuscar.addActionListener(this);

			txtNombre.setBounds(85, 28, 660, 21);

			pnlBuscarCliente.add(lblNombre);
			pnlBuscarCliente.add(txtNombre);
			pnlBuscarCliente.add(btnBuscar);

			btnListar = new JButton();
			pnlBuscarCliente.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(219, 55, 97, 23);
			btnListar.addActionListener(this);

			lblNombre.setText("Nombre:");
			lblNombre.setBounds(17, 31, 61, 14);

			pnlBuscarCliente.setBorder(BorderFactory.createTitledBorder("Buscar Cliente"));
			pnlBuscarCliente.setBounds(0, 6, 757, 82);
			pnlBuscarCliente.setLayout(null);

			jScrollPane1 = new JScrollPane();
			pnlPrincipal.add(jScrollPane1);
			jScrollPane1.setBounds(0, 94, 767, 240);

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(790, 346));

			//objcot =new TranCotizacion();
			if(objcot.estado==1){
				listarCliente();
			}else if(objcot.estado==2){
				listarCliente2();
			}
			
			
			//pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/********BUSCAR CLIENTE************************/
	public void buscarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtNombre.getText();
	/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
	          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI,"+
		           "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.DIR_CLI "+
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
						rs.getString(4),rs.getString(5),rs.getString(6)
						,rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10),rs.getString(11),rs.getString(12)
						,rs.getString(13),rs.getString(14)
				};modelo2.addRow(obj);}
			
			rs.close();
		} catch (Exception e1) {e1.printStackTrace();}	
			
		objAccesoBD.cerrarConexion();
	}
	
	/***********************************************/
	public void buscarCliente2(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD2 objAccesoBD = new AccesoBD2();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtNombre.getText();
	/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
	          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI,"+
		           "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.DIR_CLI "+
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
						rs.getString(4),rs.getString(5),rs.getString(6)
						,rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10),rs.getString(11),rs.getString(12)
						,rs.getString(13),rs.getString(14)
				};modelo2.addRow(obj);
		}
			
			rs.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		
		}	
			
		objAccesoBD.cerrarConexion();
	}
	/****************************************LISTAR CLIENTE****************************************/
	public void listarCliente(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
        "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
        DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);*/

        String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI, "+
		           "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.DIR_CLI "+
		           "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)
						,rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10),rs.getString(11),rs.getString(12)
						,rs.getString(13),rs.getString(14)
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
	public void listarCliente2(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	
		
		AccesoBD2 objAccesoBD = new AccesoBD2();
		objAccesoBD.crearConexion();
		
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI,CLI.TEL2A_CLI, "+
		           "CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.DIR_CLI "+
		           "FROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI " +
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI asc;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)
						,rs.getString(7),rs.getString(8),rs.getString(9)
						,rs.getString(10),rs.getString(11),rs.getString(12)
						,rs.getString(13),rs.getString(14)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarCliente(){
		/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
        "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);

public static String codcli,
nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		int fila = jTable1.getSelectedRow();
		int cod=  Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		codcli=String.valueOf(cod);
		nomcli=(String)modelo2.getValueAt(fila, 1);
		txtNombre.setText(nomcli);
		tipcli=(String)modelo2.getValueAt(fila, 2);
		ruccli=(String)modelo2.getValueAt(fila, 3);
		lugcli=(String)modelo2.getValueAt(fila, 4);
		conacli=(String)modelo2.getValueAt(fila, 5);
		tel1acli=(String)modelo2.getValueAt(fila, 6);
		tel2acli=(String)modelo2.getValueAt(fila, 7);
		rpmacli=(String)modelo2.getValueAt(fila, 8);
		nexacli=(String)modelo2.getValueAt(fila, 9);
		celacli=(String)modelo2.getValueAt(fila, 10);
		mailacli=(String)modelo2.getValueAt(fila, 11);
		mailbcli=(String)modelo2.getValueAt(fila, 12);
		dircli=(String)modelo2.getValueAt(fila, 13);
		System.out.println("ESTOS ES LO QUE DIJISTES:"+
				codcli+","+nomcli+","+tipcli+","+ruccli+","+lugcli+","+conacli+","+tel1acli+","
				+tel2acli+","+rpmacli+","+nexacli+","+celacli+","+mailacli);
	}
	/***********************************************/
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarCliente();}}
	public void mouseReleased(MouseEvent e) {}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBuscar){
			try {
				if(objcot.estado==1){
					buscarCliente();
				}else if(objcot.estado==2){
					buscarCliente2();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
		if(e.getSource()==btnListar){
			if(objcot.estado==1){
				listarCliente();
			}else if(objcot.estado==2){
				listarCliente2();
			}
			
		}
	
	}

}
