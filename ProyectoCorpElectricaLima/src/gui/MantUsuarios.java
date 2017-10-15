package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import beans.BeanBuscarTransProd;
import beans.BeanUsuario;
import beans.Globales;
import servlet.ServletUsuario;
import miLib.AccesoBD;
import miLib.GUI;



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
public class MantUsuarios extends JInternalFrame implements KeyListener, MouseListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pnlPrincipal;
	private JTable jTable1;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnIngresar;
	private JScrollPane scrListado;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JTextField txtNombre;
	private JLabel lblNombre;

	
	GUI objGUI;
	private JPasswordField txtPassword;
	private JLabel lblPassword;

	String titulo2[]={"NOMBRE","USUARIO"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	Globales objG;
	ServletUsuario objUsuario= new ServletUsuario();
	
	public MantUsuarios() {
		
		super("Mantenimiento Usuario", true, true, true, true);
		
		try {
			
			this.setPreferredSize(new java.awt.Dimension(414, 372));
			this.setBounds(0, 0, 414, 372);

			pnlPrincipal = new JPanel();
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setLayout(null);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(410, 348));

			lblNombre = new JLabel();
			pnlPrincipal.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(17, 12, 74, 14);

			txtNombre = new JTextField();
			pnlPrincipal.add(txtNombre);
			txtNombre.setBounds(102, 9, 270, 21);
			txtNombre.addKeyListener(this);

			lblUsuario = new JLabel();
			pnlPrincipal.add(lblUsuario);
			lblUsuario.setText("Usuario:");
			lblUsuario.setBounds(16, 39, 73, 14);

			txtUsuario = new JTextField();
			pnlPrincipal.add(txtUsuario);
			txtUsuario.setBounds(102, 35, 129, 21);

			scrListado = new JScrollPane();
			pnlPrincipal.add(scrListado);
			scrListado.setBounds(17, 121, 370, 215);
			scrListado.addMouseListener(this);

			
			jTable1 = new JTable();
			scrListado.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			btnIngresar = new JButton();
			pnlPrincipal.add(btnIngresar);
			btnIngresar.setText("Ingresar");
			btnIngresar.setBounds(17, 95, 88, 21);
			btnIngresar.addActionListener(this);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(110, 95, 96, 21);
			btnModificar.addActionListener(this);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(212, 95, 84, 21);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(302, 95, 84, 21);
			
			lblPassword = new JLabel();
			pnlPrincipal.add(lblPassword);
			lblPassword.setText("Password:");
			lblPassword.setBounds(16, 64, 73, 16);
		
		
			txtPassword = new JPasswordField();
			pnlPrincipal.add(txtPassword);
			txtPassword.setBounds(101, 61, 130, 21);
			
			btnBuscar.addActionListener(this);
			setVisible(true);
			listarUsuario(objG.COD_VEN);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**********************LISTAR USUARIO**********************/
	
	public void listarUsuario(int codigo){		
		
		
		int n=modelo2.getRowCount();		
		objUsuario.eliminarTodo();
		
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		String sql="";
		
		if(codigo==9){
			sql="SELECT cod_ven,nom_ven,login_ven,pass_ven "+
			    "FROM tb_vendedores;";
		}else{
			sql="SELECT cod_ven,nom_ven,login_ven,pass_ven "+
			    "FROM tb_vendedores where cod_ven="+codigo+";";
		}
		
		try {
			
		objAccesoBD.crearConexion();		
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				
				BeanUsuario objU= new BeanUsuario(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				        objUsuario.adicionar(objU);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		for(int i=0;i<objUsuario.tamaño();i++){
			
			BeanUsuario objUsu=objUsuario.obtener(i) ;
			
			Object[] array={ objUsu.getNombre(),objUsu.getUsuario()};
			modelo2.addRow(array);
		}
		
	}
	

	/*************************AGREGAR USUARIO************************/
	public void agregarUsuario(){

		AccesoBD objAccesoBD = new AccesoBD();
		
		try{
			objAccesoBD.crearConexion();		
			
			String insertarPregunta="INSERT INTO tb_vendedores VALUES("+null+",'"+txtNombre.getText().trim()+"'" +
					",'','','"+txtUsuario.getText().trim()+"','"+(String.valueOf(txtPassword.getPassword())).trim()+"',0,0)";
			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			if(op==0){
				objGUI.mostrarAviso("Hubo un error a Ingresar el Usuario");
				System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
			}
			else{
				objGUI.mostrarAviso("Se a ingresado satisfactoriamenete el Usuario");
				System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar Usuario !!!!!!!");
			}
			
		}finally{
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
	
		
	}
	
	/**********************MODIFICAR USUARIO**********************/
	
	public void modificarUsuario(){
		
		int fila = jTable1.getSelectedRow();
		
		if(fila==-1){
	    	JOptionPane.showMessageDialog(null, "Debe Seleccionar Usuario", "", 1);    	  
	    }else{
	    	BeanUsuario objUsu=objUsuario.obtener(fila);
			AccesoBD objAccesoBD=  new AccesoBD();
			
			try{
				
				objAccesoBD.crearConexion();
				String sql="UPDATE tb_vendedores SET nom_ven='"+txtNombre.getText().trim()+"'" +
						", login_ven='"+txtUsuario.getText()+"', pass_ven='"+(String.valueOf(txtPassword.getPassword())).trim()+"'" +
						" WHERE cod_ven='"+objUsu.getCodigo()+"';";
				System.out.println(sql);

				int op= objAccesoBD.ejecutarActualizacion(sql);
				
				if(op==0){
					objGUI.mostrarAviso("Hubo un error AL modificar el Usuario");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
				}
				else{
					objGUI.mostrarAviso("Se a modificado el Usuario");
					System.out.println("¡¡¡¡¡¡¡¡ GRACIAS insertar Usuario !!!!!!!");
				}
			
			}finally{
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}
	    }
			
		
	}
	
	/*******************ELIMINAR USUARIO**********************/
	
	public void eliminarUsuario(){
		
		int fila = jTable1.getSelectedRow();
		
		if(fila==-1){
	    	JOptionPane.showMessageDialog(null, "Debe Seleccionar Usuario", "", 1);    	  
	    }else{
	    	BeanUsuario objUsu=objUsuario.obtener(fila);
			AccesoBD objAccesoBD=  new AccesoBD();
			
			try{
				objAccesoBD.crearConexion();
				String sql="DELETE FROM tb_vendedores "+
						   "WHERE cod_ven='"+objUsu.getCodigo()+"';";
				System.out.println(sql);
		
				int op= objAccesoBD.ejecutarActualizacion(sql);
				if(op==0){
					objGUI.mostrarAviso("Hubo un error al eliminar el Usuario");
					System.out.println("HORRRROR !!!!!!!!!!!!!!!!!!!!!!!!");
				}
				else{
					objGUI.mostrarAviso("Se a eliminado  el Usuario");
					System.out.println("¡¡¡¡¡¡¡¡ GRACIAS eliminar product0 !!!!!!!");
				}
			}finally{
				objAccesoBD.cerrarStatement();
				objAccesoBD.cerrarConexion();  
			}	
	    }
		
	}

	/*************************BUSCAR USUARIO************************/
	
	public void buscarUsuario(){
		
		int n=modelo2.getRowCount();		
		objUsuario.eliminarTodo();
		
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
	
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
		objAccesoBD.crearConexion();
		String sql="SELECT cod_ven,nom_ven,login_ven,pass_ven "+
			    "FROM tb_vendedores " +
			    "WHERE nom_ven like'%"+txtNombre.getText().trim()+"%';";
		rs = objAccesoBD.ejecutarConsulta(sql);
		
			while(rs.next()){
				
				BeanUsuario objU= new BeanUsuario(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				        objUsuario.adicionar(objU);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
		
		for(int i=0;i<objUsuario.tamaño();i++){
			
			BeanUsuario objUsu=objUsuario.obtener(i) ;
			
			Object[] array={ objUsu.getNombre(),objUsu.getUsuario()};
			modelo2.addRow(array);
		}
		
	}
	/***********************************************/

	public void cargarUsuario(){
		
		int fila = jTable1.getSelectedRow();
		BeanUsuario objUsu=objUsuario.obtener(fila);
				
		txtNombre.setText(objUsu.getNombre());
		txtUsuario.setText(objUsu.getUsuario());
		txtPassword.setText(objUsu.getPassword());
		
	}
	
	/***********************************************/

	public void limpiar(){
						
		txtNombre.setText("");
		txtUsuario.setText("");
		txtPassword.setText("");
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
				
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		if(arg0.getSource()==jTable1){
			cargarUsuario();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIngresar){
			
			if(objG.COD_VEN==9){
				agregarUsuario();
				listarUsuario(objG.COD_VEN);
				limpiar();
			}else{
				JOptionPane.showMessageDialog(null, "Usted no tiene permisos de Adminstrador", "", 2);  
			}
			
		}
		
		if(e.getSource()==btnModificar){
			
			modificarUsuario();	
			listarUsuario(objG.COD_VEN);
			limpiar();
			
		}
		
		if(e.getSource()==btnEliminar){
			
			if(objG.COD_VEN==9){
				eliminarUsuario();
				listarUsuario(objG.COD_VEN);
				limpiar();
			}else{
				JOptionPane.showMessageDialog(null, "Usted no tiene permisos de Adminstrador", "", 2);  
			}
			
		}
		
		if(e.getSource()==btnBuscar){
			
			if(objG.COD_VEN==9){
				buscarUsuario();
			}else{
				JOptionPane.showMessageDialog(null, "Usted no tiene permisos de Adminstrador", "", 2);  
			}
			
		}
		
		
	}

}
