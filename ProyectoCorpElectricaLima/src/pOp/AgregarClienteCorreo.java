package pOp;
import gui.MantProveedor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import miLib.AccesoBD;
import miLib.GUI;
import servlet.ServletListarCliCorreo;
import beans.BeanListarCliCorreo;

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
public class AgregarClienteCorreo extends JDialog implements ActionListener, MouseListener, KeyListener  {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JLabel lblNomContacto;
	private JTable tblListarCli;
	private JScrollPane jScrollPane1;
	private JComboBox cboSexo;
	private JLabel lblSexo;
	private JTextField txtEmail;
	private JLabel lblemail;
	private JTextField txtNomContacto;
	private JTextField txtNomCli;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JPanel pnlCentro;

	MantProveedor objprove;
	GUI objGUI;
	String titulo2[]={"COD.CLI","NOM.CLI","EMAIL","SEXO"};
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	ServletListarCliCorreo objList = new ServletListarCliCorreo();
	public static int codCli=0,sexCli=0;
	public static String nomCli="",conaCli="",mailCli="";
	int est=0;
	
	public AgregarClienteCorreo(Frame padre) {
		
		 super((Frame)padre, true);
		 
		try {
			
			this.setSize(597, 294);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(710, 109));

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(22, 19, 57, 16);

			txtNomCli = new JTextField();
			pnlArriba.add(txtNomCli);
			txtNomCli.setBounds(79, 15, 378, 25);
			txtNomCli.addKeyListener(this);

			lblNomContacto = new JLabel();
			pnlArriba.add(lblNomContacto);
			lblNomContacto.setText("N.Contacto:");
			lblNomContacto.setBounds(6, 49, 65, 17);

			txtNomContacto = new JTextField();
			pnlArriba.add(txtNomContacto);
			txtNomContacto.setBounds(79, 45, 223, 20);
			txtNomContacto.setSize(223, 25);

			lblemail = new JLabel();
			pnlArriba.add(lblemail);
			lblemail.setText("Email:");
			lblemail.setBounds(37, 80, 37, 16);

			txtEmail = new JTextField();
			pnlArriba.add(txtEmail);
			txtEmail.setBounds(79, 78, 223, 20);
			txtEmail.setSize(223, 25);

			lblSexo = new JLabel();
			pnlArriba.add(lblSexo);
			lblSexo.setText("Sexo:");
			lblSexo.setBounds(308, 49, 38, 16);

			cboSexo = new JComboBox();
			pnlArriba.add(cboSexo);
			cboSexo.addItem("");
			cboSexo.addItem("Masculino");
			cboSexo.addItem("Femenino");
			cboSexo.setBounds(346, 45, 111, 25);

			pnlAbajo = new JPanel();
			FlowLayout pnlAbajoLayout = new FlowLayout();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setLayout(pnlAbajoLayout);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(468, 35));

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(576, 46, 106, 26);
			btnAceptar.setBackground(new java.awt.Color(255,0,0));
			btnAceptar.setPreferredSize(new java.awt.Dimension(85, 26));
			btnAceptar.addActionListener(this);

			pnlCentro = new JPanel();
			GridLayout pnlCentroLayout = new GridLayout(1, 1);
			pnlCentroLayout.setColumns(1);
			pnlCentroLayout.setHgap(5);
			pnlCentroLayout.setVgap(5);
			getContentPane().add(pnlCentro, BorderLayout.CENTER);
			pnlCentro.setLayout(pnlCentroLayout);
			pnlCentro.setPreferredSize(new java.awt.Dimension(710, 74));

			jScrollPane1 = new JScrollPane();
			pnlCentro.add(jScrollPane1);
			
			tblListarCli = new JTable();
			jScrollPane1.setViewportView(tblListarCli);
			tblListarCli.setModel(modelo2);
			tblListarCli.addMouseListener(this);

			TableColumn cod = tblListarCli.getColumn ("COD.CLI"),
			nom = tblListarCli.getColumn ("NOM.CLI"),email = tblListarCli.getColumn ("EMAIL"),
			sexo = tblListarCli.getColumn ("SEXO");
			
			cod.setPreferredWidth(13);
			nom.setPreferredWidth(220);
			email.setPreferredWidth(105);
			sexo.setPreferredWidth(7);
			
			listarCli();
			
			
		} catch(Exception e) {
			System.out.println("chekea el catch");
			e.printStackTrace();
		}
	}
	
	
	
	public void listarCli(){

		
		objList.eliminarTodo();
		int n=modelo2.getRowCount();
		
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COD_CLI, NOM_CLI,CONA_CLI,MAILA_CLI,SEX_CLI " +
				"FROM tb_cliente WHERE NOM_CLI LIKE '"+txtNomCli.getText().trim()+"%' AND " +
				"EST_CLI='ACTIVADO'";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while(rs.next()){
				
				BeanListarCliCorreo objP= new BeanListarCliCorreo(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				
				objList.adicionar(objP);
				
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
		for (int i = 0; i < objList.tamaño(); i++) {
			
			BeanListarCliCorreo objProve=objList.obtener(i) ;
			Object obj[]={Integer.parseInt(""+objProve.getCod_cli()),
					objProve.getNom_cli(),objProve.getMail_cli(),
					Integer.parseInt(""+objProve.getSex_cli())
			};
				
			modelo2.addRow(obj);
		}	
	}
	
	public void cargarlistaProve(){
		
		int fila = tblListarCli.getSelectedRow();
		est=1;
		codCli=objList.obtener(fila).getCod_cli();
		nomCli=objList.obtener(fila).getNom_cli();
		conaCli=objList.obtener(fila).getCona_cli();
		mailCli=objList.obtener(fila).getMail_cli();
		sexCli=objList.obtener(fila).getSex_cli();
		
		txtNomCli.setText(""+objList.obtener(fila).getNom_cli());
		txtNomContacto.setText(""+objList.obtener(fila).getCona_cli());
		txtEmail.setText(""+objList.obtener(fila).getMail_cli());
		cboSexo.setSelectedIndex(objList.obtener(fila).getSex_cli());
		
		
	}
	
	public void limpiar(){
		
		txtNomContacto.setText("");
		txtEmail.setText("");
		cboSexo.setSelectedIndex(0);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnAceptar){
			
			/*insertarProveedor();
			agregarRubroYMarcaProveedor();*/
			
			if(est==0){
				objGUI.mostrarAviso("Debe Seleccionar un Cliente");
			}else{
				setVisible(false);
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if(arg0.getSource()==txtNomCli){
			listarCli();
			limpiar();
		}
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
	public void mousePressed(MouseEvent e) {
        
		cargarlistaProve();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
