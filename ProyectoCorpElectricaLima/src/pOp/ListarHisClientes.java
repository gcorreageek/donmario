package pOp;
import java.awt.BorderLayout;
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
import javax.swing.JDialog;
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
public class ListarHisClientes extends JDialog implements MouseListener, ActionListener, KeyListener {
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JTextField areatexto;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JPanel jPanel1;
	 String titulo2[]={"Publicidad"};
	//String cod_cli;		
	
	  DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	//public static DefaultTableModel modelo=null;
	

	
	
	public ListarHisClientes(Frame padre) {
		
		super( (Frame)padre, true);
		try {
			//this.cod_cli=cod_cli;
			lblNombre = new JLabel();
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(17, 15, 48, 16);
			txtNombre = new JTextField();
			txtNombre.setBounds(77, 13, 323, 20);

			pnlArriba = new JPanel();

			pnlAbajo = new JPanel();
			GridLayout pnlAbajoLayout = new GridLayout(1, 1);
			pnlAbajoLayout.setHgap(5);
			pnlAbajoLayout.setVgap(5);
			pnlAbajoLayout.setColumns(1);
			pnlAbajo.setLayout(pnlAbajoLayout);
			getContentPane().add(pnlAbajo, BorderLayout.CENTER);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(859, 429));

			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(892, 42));
			pnlArriba.setLayout(null);
			pnlArriba.add(lblNombre);
			pnlArriba.add(txtNombre);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(325, 10, 81, 26);
			btnBuscar.setVisible(false);
			btnBuscar.addActionListener(this);

			jPanel1 = new JPanel();
			getContentPane().add(jPanel1, BorderLayout.SOUTH);
			jPanel1.setPreferredSize(new java.awt.Dimension(412, 5));
			
			jScrollPane1 = new JScrollPane();
			pnlAbajo.add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(859, 467));
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			

			this.setSize(428, 266);	
			getNombre(ConfigurarCuentas.cod_cli);
			listarXcod(ConfigurarCuentas.cod_cli);
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void listarXcod(String cod_cli){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//String NOM_CLI=txtProducto2.getText();
	/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
	          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		String sql="SELECT publi.nom_publi FROM tb_masivo mas "+
			" inner join tb_publicidad publi "+
			" on publi.cod_publi=mas.cod_publi "+
			" inner join tb_cliente cli "+
			" on CLI.COD_CLI=mas.cod_cli "+
			" where mas.cod_cli='"+cod_cli+"';";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getString(1)
				};
				
			
				modelo2.addRow(obj);
				}
			
			rs.close();
		} catch (Exception e1) {e1.printStackTrace();}	
			
		objAccesoBD.cerrarConexion();
	}

	public void getNombre(String cod_cli){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
	/*	String titulo2[]={"COD_CLI","NOM_CLI","RUC_CLI",
	          "LUG_CLI","CONA_CLI","TEL1","TEL2","RPMA","NEXTEL","CEL","MAIL"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String codcli,
	 nomcli,tipcli,ruccli,lugcli,conacli,tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;*/
		String sql="SELECT nom_cli from tb_cliente where "+
		           " cod_cli='"+cod_cli+"';";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		String nomp="";
		try {
			if(rs.next()){
				nomp=rs.getString(1);
				};
			
			rs.close();
		} catch (Exception e1) {e1.printStackTrace();}	
			
		objAccesoBD.cerrarConexion();
		txtNombre.setText(nomp);
		}

	


	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnBuscar){
			listarXcod(ConfigurarCuentas.cod_cli);
		}
	
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
		
		
	}

	@Override
	public void mousePressed(MouseEvent e2) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e2) {
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
