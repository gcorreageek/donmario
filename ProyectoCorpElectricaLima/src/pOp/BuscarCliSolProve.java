package pOp;
import gui.ReporteSolProve;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import servlet.ServletCliCita;
import beans.BeanCliCita;

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
public class BuscarCliSolProve extends JPanel implements MouseListener, ActionListener,KeyListener {
	private JPanel pnlPrincipal;
	private JTextField txtNombre;
	private JTable jTable1;
	private JButton btnListar;
	private JScrollPane jScrollPane1;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JPanel pnlBuscarCliente;
	ServletCliCita objS= new ServletCliCita();
	String titulo2[]={"CODIGO","NOMBRE","LUGAR DEL CLIENTE"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String codcli;
	ReporteSolProve objrep;
	//String nombreclien=objrep.nombrecliente;
	 
	 public BuscarCliSolProve() {
		try {
			System.out.println("entra al BuscarCliente");
			// nombreclien=objrep.nombrecliente;

			//getContentPane().add(pnlPrincipal, BorderLayout.CENTER);

			GridLayout thisLayout = new GridLayout(1, 1);
			thisLayout.setHgap(5);
			thisLayout.setVgap(5);
			thisLayout.setColumns(1);
			this.setLayout(thisLayout);
			setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(826, 272));

			pnlPrincipal = new JPanel();
			this.add(pnlPrincipal);

			pnlBuscarCliente = new JPanel();
			pnlPrincipal.add(pnlBuscarCliente);

			lblNombre = new JLabel();

			txtNombre = new JTextField();

			btnBuscar = new JButton();
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(683, 15, 97, 23);
			btnBuscar.addActionListener(this);

			txtNombre.setBounds(78, 16, 497, 21);
			txtNombre.addKeyListener(this);

			pnlBuscarCliente.add(lblNombre);
			pnlBuscarCliente.add(txtNombre);
			
			pnlBuscarCliente.add(btnBuscar);

			btnListar = new JButton();
			pnlBuscarCliente.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(581, 15, 97, 23);
			btnListar.addActionListener(this);

			lblNombre.setText("Nombre:");
			lblNombre.setBounds(12, 19, 61, 14);

			pnlBuscarCliente.setBorder(BorderFactory.createTitledBorder("Buscar Cliente"));
			pnlBuscarCliente.setBounds(0, 6, 791, 44);
			pnlBuscarCliente.setLayout(null);

			jScrollPane1 = new JScrollPane();
			pnlPrincipal.add(jScrollPane1);
			jScrollPane1.setBounds(0, 56, 826, 209);

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(815, 242));

			listarCliente();
			//pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/********BUSCAR CLIENTE************************/
	public void buscarCliente(){
		objS.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
			
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=txtNombre.getText();
	    String sql="SELECT CLI.COD_CLI,cli.NOM_CLI,TIPCLI.COD_TIPO," +
	    "if(CLI.SEX_CLI=0,'Sexo',if(CLI.SEX_CLI=1,'Masculino','Femenino')), " +
	    "cli.LUG_CLI,cli.DIR_CLI,cli.CONA_CLI, "+
        " cli.TEL1A_CLI,cli.TEL2A_CLI,cli.CELA_CLI,cli.RPMA_CLI,cli.NEXA_CLI,cli.FAXA_CLI,cli.MAILA_CLI ,"+
        "cli.CONB_CLI,cli.TEL1B_CLI,cli.CELB_CLI,cli.RPMB_CLI,cli.NEXB_CLI,cli.MAILB_CLI ,"+
        "CLI.COD_DEP,CLI.COD_PRO,cli.cod_dis , " +
        "(select nombre from tb_ubigeo "+
        "where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento',(select nombre from tb_ubigeo "+ 
        "where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', (select nombre from tb_ubigeo "+ 
        "where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' " +
        " FROM tb_cliente CLI  INNER JOIN tb_tipocliente TIPCLI " +
        " ON CLI.COD_TIPO=TIPCLI.COD_TIPO "+
        "where cli.NOM_CLI like '"+NOM_CLI+"%' and cli.EST_CLI='ACTIVADO';";

		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
              while(rs.next()){
				BeanCliCita objB = new BeanCliCita(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), 
						rs.getString(22), rs.getString(23), rs.getString(24),
						rs.getString(25),rs.getString(26));
				
				objS.adicionar(objB);
				
				}
			rs.close();
		} catch (Exception e1) {e1.printStackTrace();}	
			
		objAccesoBD.cerrarConexion();
          for (int i = 0; i < objS.tamaño(); i++) {
			
			Object obj[]={objS.obtener(i).getCodcli(),objS.obtener(i).getNomcli(),
					objS.obtener(i).getLugcli()
					
			};
			modelo2.addRow(obj);
			
		}
	}
	
	/***********************************************/
	/********LISTAR CLIENTE************************/
	public void listarCliente(){
		objS.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
			String sql="SELECT CLI.COD_CLI,cli.NOM_CLI,TIPCLI.COD_TIPO," +
		"if(CLI.SEX_CLI=0,'Sexo',if(CLI.SEX_CLI=1,'Masculino','Femenino')), " +
		"cli.LUG_CLI,cli.DIR_CLI,cli.CONA_CLI, "+
        " cli.TEL1A_CLI,cli.TEL2A_CLI,cli.CELA_CLI,cli.RPMA_CLI,cli.NEXA_CLI,cli.FAXA_CLI,cli.MAILA_CLI ,"+
        "cli.CONB_CLI,cli.TEL1B_CLI,cli.CELB_CLI,cli.RPMB_CLI,cli.NEXB_CLI,cli.MAILB_CLI ,"+
        "CLI.COD_DEP,CLI.COD_PRO,cli.cod_dis , " +
        "(select nombre from tb_ubigeo "+
        "where cod_dep=CLI.COD_DEP and cod_pro='00' and COD_DIS='00') 'departamento',(select nombre from tb_ubigeo "+ 
        "where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and COD_DIS='00') 'provincia', (select nombre from tb_ubigeo "+ 
        "where cod_dep=CLI.COD_DEP and cod_pro=CLI.COD_PRO and CLI.COD_DIS=cod_dis) 'distrito' " +
        " FROM tb_cliente CLI  INNER JOIN tb_tipocliente TIPCLI " +
        " ON CLI.COD_TIPO=TIPCLI.COD_TIPO "+
        " where cli.EST_CLI='ACTIVADO' " +
        "ORDER BY CLI.COD_CLI ASC;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
				BeanCliCita objB = new BeanCliCita(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10), rs.getString(11), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18),
						rs.getString(19), rs.getString(20), rs.getString(21), 
						rs.getString(22), rs.getString(23), rs.getString(24),
						rs.getString(25),rs.getString(26));
				
				objS.adicionar(objB);
				
						
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objS.tamaño(); i++) {
			
			Object obj[]={objS.obtener(i).getCodcli(),objS.obtener(i).getNomcli(),
					objS.obtener(i).getLugcli()
					
			};
			modelo2.addRow(obj);
			
		}
		
	}
	/***********************************************/
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarCliente(){
		
		int fila = jTable1.getSelectedRow();
		codcli=objS.obtener(fila).getCodcli();
			
	}
	/***********************************************/
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {if(e.getSource()==jTable1){cargarCliente();}}
	public void mouseReleased(MouseEvent e) {}
	
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnBuscar){
		buscarCliente();
	}
	if(e.getSource()==btnListar){
	    listarCliente();	
	
	}
	
	}

	public void keyPressed(KeyEvent arg0) {
		if(arg0.getSource()==txtNombre){
			buscarCliente();
			
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

}
