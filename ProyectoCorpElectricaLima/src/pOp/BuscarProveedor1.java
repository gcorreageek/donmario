package pOp;
import gui.BuscarProductoCotizacion;

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
public class BuscarProveedor1 extends JDialog implements ActionListener, MouseListener, KeyListener {
	private JButton btnListar;
	private JTable jTable1;
	private JTextField txtNombreC;
	private JScrollPane scrListaProveedor;
	private JButton btnBuscar;
	private JLabel lblNombreC;
	private JLabel lblNombre;
	private JTextField txtNombreProve;
	private JPanel pnlMedio;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel pnlAbajo;
	private JPanel pnlArriba;

	String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","NOMC_PROVE","CARC_PROVE"};
	
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 int  cod1;
	 public static int  codProve;
	 public static String  nomProve,ruc,NombreContactoProve;
	 int veces=0;
	 BuscarProductoCotizacion objBCoti;
	 String NOMBREPROVEE;


	 public BuscarProveedor1(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);
		try {
			//setVisible(true);
			this.setSize(869, 487);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(99, 21));
			btnAceptar.addMouseListener(this);
			btnAceptar.addKeyListener(this);
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(99, 21));
			btnCancelar.addMouseListener(this);
			btnCancelar.addKeyListener(this);
			btnCancelar.addActionListener(this);

			pnlMedio = new JPanel();
			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			pnlMedio.setPreferredSize(new java.awt.Dimension(859, 299));

			scrListaProveedor = new JScrollPane();
			pnlMedio.add(scrListaProveedor);
			scrListaProveedor.setBounds(14, 74, 723, 242);

			jTable1 = new JTable();
			scrListaProveedor.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addKeyListener(this);
			jTable1.addMouseListener(this);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setBounds(0, 0, 744, 77);
			pnlArriba.setPreferredSize(new java.awt.Dimension(861, 44));

			txtNombreProve = new JTextField();
			pnlArriba.add(txtNombreProve);
			txtNombreProve.setBounds(73, 16, 468, 21);
			txtNombreProve.setText(objBCoti.NOMBRE_PROVEE);
			
			

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(14, 19, 59, 14);

			lblNombreC = new JLabel();
			pnlArriba.add(lblNombreC);
			lblNombreC.setText("N.Contacto:");
			lblNombreC.setBounds(17, 45, 86, 14);
			lblNombreC.setVisible(false);

			txtNombreC = new JTextField();
			pnlArriba.add(txtNombreC);
			txtNombreC.setBounds(115, 42, 426, 21);
			txtNombreC.setVisible(false);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(563, 16, 94, 21);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(685, 16, 94, 21);
			btnListar.addActionListener(this);

			btnBuscar.addActionListener(this);

			txtNombreProve.addKeyListener(this);

		    buscarCliente(txtNombreProve.getText());
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/********BUSCAR CLIENTES************************/
	public void buscarCliente(String nom){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		NOMBREPROVEE=nom;
		/*
		String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","COD_DEP","COD_PRO","COD_DIS","DIR_PROVE","BAN_PROVE","NCUD_PROVE","NCUS_PROVE","TEL1_PROVE",
				"TEL2_PROVE","RPM_PROVE","NEX_PROVE","CEL_PROVE","FAX_PROVE","MAIL_PROVE","WEB_PROVE","OBS_PROVE","EST_PROVE","NOMC_PROVE","CARC_PROVE","CELC_PROVE","OBSC_PROVE"};
		*/
		String sql=" SELECT COD_PROVE,NOM_PROVE,RUC_PROVE,TIP_PROVE," +
				" NOMC_PROVE,CARC_PROVE  FROM tb_proveedor WHERE   NOM_PROVE LIKE '"+NOMBREPROVEE.trim()+"%' " +
				" AND EST_PROVE='ACTIVADO'"+
	//	" AND NOMC_PROVE LIKE '%"+NOMC_PROVE.trim()+"%' ORDER BY COD_PROVE;" ;
		"  ORDER BY COD_PROVE;" ;
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)};
			
						
				modelo2.addRow(obj);
				
				
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	
	/********LISTAR CLIENTES************************/
	public void listarCliente(){
		System.out.println("ENTRA AL LISTAR");
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		/*String titulo2[]={"COD_PROVE","NOM_PROVE","RUC_PROVE","TIP_PROVE","NOMC_PROVE","CARC_PROVE"};*/
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_PROVE,NOM_PROVE,RUC_PROVE,TIP_PROVE," +
				" NOMC_PROVE,CARC_PROVE FROM tb_proveedor";
		
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6)};
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	/***********************************************/
	public void cargar(){
		//Obtener fila seleccionada de la tabla
		int fila = jTable1.getSelectedRow();
		//System.out.println(var);
		Object codProvee=modelo2.getValueAt(fila, 0),nomProvee=modelo2.getValueAt(fila,1),
		rucs=modelo2.getValueAt(fila,2),NombreContactoProvee=modelo2.getValueAt(fila, 4);
		
		txtNombreProve.setText((String)nomProvee);
		
		txtNombreC.setText((String)NombreContactoProvee);
		codProve=Integer.parseInt(""+codProvee);
		nomProve=(String) nomProvee;
		ruc=(String) rucs;
		NombreContactoProve=(String) NombreContactoProvee;
		//nomProve,ruc,NombreContactoProve;
	}
	/***********************************************/
    public String actulizaNombre(String nom){
    	 String palabra="";
    	for(int i=0;i<nom.length()-1;i++){
    		palabra+=nom.charAt(i);
    	}
    	 return palabra;
    	
    }
	/***********************************************/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscar){
			buscarCliente(txtNombreProve.getText());
		}
		if(e.getSource()==btnListar){
			listarCliente();
		}
		if(e.getSource()==btnAceptar){
			cargar();
			setVisible(false);
		}
		if(e.getSource()==btnCancelar){
			
			nomProve=null;
		
			setVisible(false);
		}
		
		
	}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent e) {
		cargar();
	}



	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtNombreProve){
			
            String nom="";
            int key = e.getKeyCode();
            
			if(KeyEvent.VK_DOWN==key){//flecha abajo
				
				NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
			}
            else if(KeyEvent.VK_UP==key){//flecha abajo
            	
            	NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
			}
            else if(KeyEvent.VK_LEFT==key){//flecha abajo
            	NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				System.out.println(nom);
				buscarCliente(nom);
			}
            else if(KeyEvent.VK_RIGHT==key){//flecha abajo
            	NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
			}
			
            else if(KeyEvent.VK_SHIFT==key){//flecha abajo
            	NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
			}
            else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("retroceso")){
				NOMBREPROVEE="";
				nom=actulizaNombre(txtNombreProve.getText().trim());
				//System.out.println(nom);
				buscarCliente(nom);
			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("introduzca")){
				
				NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("espacio")){
				
				NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
				
			}else if(e.getKeyText(e.getKeyCode()).toLowerCase().equals("bloqueo de mayúsculas")){
				
				NOMBREPROVEE="";
				nom=txtNombreProve.getText().trim();
				//System.out.println(nom);
				buscarCliente(nom);
				
		   }
			else{
				NOMBREPROVEE=txtNombreProve.getText().concat(e.getKeyText(e.getKeyCode()).toLowerCase());
				//System.out.println(NOMBREPROVEE);
				buscarCliente(NOMBREPROVEE);
			}
			
		}
		
		if(e.getSource()==jTable1){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				cargar();
				setVisible(false);
			}
			if(KeyEvent.VK_TAB==key){
				
				btnAceptar.requestFocus();
				//System.out.println("entra men!");
				//txtCompra.requestFocus();
			}
		}
	
		if(e.getSource()==btnAceptar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				cargar();
				setVisible(false);
			}
			if(KeyEvent.VK_TAB==key){
				btnCancelar.requestFocus();
			}
		}
		if(e.getSource()==btnCancelar){
			int key = e.getKeyCode();
			if(KeyEvent.VK_ENTER==key){
				nomProve=null;
				setVisible(false);
			}
		}
		//KeyStroke.getKeyStroke("Ctrl C")
		//System.out.println(KeyStroke.getkey);
		
		//System.out.println("ya:"+e.getKeyText(e.getKeyCode()));
		/***********************************************************************************************/
		/*                                        BOTON "+"                                            */
		if(e.getKeyText(e.getKeyCode()).equals("+ de teclado numérico")){
		if(veces==0){
			this.setSize(1187, 566);
			veces=1;
		}else if(veces==1){
			this.setSize(1392, 652);
			veces=2;
			//1392,height=652
		}else if(veces==2){//width=1427,height=815
			this.setSize(1427, 815);
			veces=3;
		}else{
			this.setSize(917, 422);
			veces=0;
		}
		}
		/************************************************************************************************/
		/***********************************************************************************************/
		/*                                        BOTON "ESCAPE"                                      */
		if(e.getKeyText(e.getKeyCode()).equals("Escape")){
			nomProve=null;
			setVisible(false);
			}
		/***********************************************************************************************/
		
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	
	
	
	
	
	
	
	
	
	

}
