package pOp;

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
public class BuscarCorreoCliente extends JPanel implements MouseListener, ActionListener {

	private JPanel pnlPrincipal;
	public static  JTextField txtNombre;
	private JLabel lblCorreo2;
	private JLabel lblCorreo1;
	private JTable jTable1;
	private JButton btnListar;
	private JScrollPane jScrollPane1;
	
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JPanel pnlBuscarCliente;
	
	String titulo2[]={"COD_CLI","NOM_CLI","CONA_CLI","CONB_CLI","MAILA_CLI","MAILB_CLI","OBS_CLI"};
						
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	
	 public static String COD_CLI,NOM_CLI,CONA_CLI,CONB_CLI,MAILA_CLI,MAILB_CLI,OBS_CLI;
	 public static JTextField txtCorreo1;
	 public static JTextField txtCorreo2;

	 public BuscarCorreoCliente() {
		try {

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
			btnBuscar.setBounds(273, 40, 97, 23);
			btnBuscar.addActionListener(this);

			txtNombre.setBounds(85, 16, 660, 21);

			pnlBuscarCliente.add(lblNombre);
			pnlBuscarCliente.add(txtNombre);
			pnlBuscarCliente.add(btnBuscar);

			btnListar = new JButton();
			pnlBuscarCliente.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(381, 40, 97, 23);

			btnListar.addActionListener(this);

			lblNombre.setText("Nombre:");
			lblNombre.setBounds(12, 19, 61, 14);

			pnlBuscarCliente.setBorder(BorderFactory.createTitledBorder("Buscar Cliente"));
			pnlBuscarCliente.setBounds(0, -1, 757, 67);
			pnlBuscarCliente.setLayout(null);

			jScrollPane1 = new JScrollPane();
			pnlPrincipal.add(jScrollPane1);
			jScrollPane1.setBounds(0, 124, 790, 159);

			txtCorreo2 = new JTextField();
			pnlPrincipal.add(txtCorreo2);
			txtCorreo2.setBounds(85, 95, 455, 20);

			txtCorreo1 = new JTextField();
			pnlPrincipal.add(txtCorreo1);
			txtCorreo1.setBounds(85, 69, 455, 20);

			lblCorreo2 = new JLabel();
			pnlPrincipal.add(lblCorreo2);
			lblCorreo2.setText("Correo Nº2:");
			lblCorreo2.setBounds(12, 98, 61, 14);

			lblCorreo1 = new JLabel();
			pnlPrincipal.add(lblCorreo1);
			lblCorreo1.setText("Correo Nº1:");
			lblCorreo1.setBounds(12, 72, 68, 14);

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(790, 283));
			listarCliente();
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
		/*SELECT COD_CLI,NOM_CLI,CONA_CLI,CONB_CLI,MAILA_CLI,MAILB_CLI,OBS_CLI
		fROM tb_CLIENTE  WHERE EST_CLI='ACTIVADO'
		AND  NOM_CLI like '%CONSTRUCTORA INMOBILIARIA SAN LUIS%';*/
			String sql=" SELECT COD_CLI,NOM_CLI,CONA_CLI,CONB_CLI,MAILA_CLI,MAILB_CLI,OBS_CLI " +
					" fROM tb_CLIENTE  WHERE EST_CLI='ACTIVADO' " +
					"  AND  NOM_CLI LIKE '%"+NOM_CLI+"%';";
			System.out.println(sql);
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
					};modelo2.addRow(obj);}
				rs.close();
			} catch (Exception e1) {	e1.printStackTrace();}
			objAccesoBD.cerrarConexion();
		}
		public void listarCliente(){
			int n=modelo2.getRowCount();
			for (int fila=0; fila<n; fila++)
			modelo2.removeRow(0);
		//	String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
			
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
			String sql=" SELECT COD_CLI,NOM_CLI,CONA_CLI,CONB_CLI,MAILA_CLI,MAILB_CLI,OBS_CLI "+
			" fROM tb_CLIENTE  WHERE EST_CLI='ACTIVADO' " +
			"  AND  NOM_CLI LIKE '%%';";
			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
					Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
					};modelo2.addRow(obj);}
				
				rs.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			objAccesoBD.cerrarConexion();
		}
		/***********************************************/
		/********PARA CARGAR LOS DATOS DEL TABLA********/
		public void cargarCliente(){
			//Obtener fila seleccionada de la tabla
			int fila = jTable1.getSelectedRow();
/*String titulo2[]={"COD_CLI","NOM_CLI","CONA_CLI","CONB_CLI","MAILA_CLI","MAILB_CLI","OBS_CLI"};*/
			COD_CLI= ""+modelo2.getValueAt(fila, 0);
			NOM_CLI= ""+modelo2.getValueAt(fila, 1);
			CONA_CLI= ""+modelo2.getValueAt(fila, 2);
			CONB_CLI= ""+modelo2.getValueAt(fila, 3);
			MAILA_CLI= ""+modelo2.getValueAt(fila, 4);
			MAILB_CLI= ""+modelo2.getValueAt(fila, 5);
			txtCorreo1.setText(MAILA_CLI);
			txtCorreo2.setText(MAILB_CLI);
			OBS_CLI= ""+modelo2.getValueAt(fila, 6);
		}
		/***********************************************/
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			buscarCliente();
		}
		if(e.getSource()==btnListar){
			listarCliente();
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
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==jTable1){
			cargarCliente();
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
	
	
	
}
