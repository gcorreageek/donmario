package pOp;
import gui.EnviarCorreoProveedor;
import gui.MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
public class ConfigCorreoProve extends JInternalFrame implements ActionListener, MouseListener {
	
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JButton btnCancelar;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JButton btnAceptar;
	private JPanel pnlCentro;
	 
	public EnviarCorreoProveedor objEnviarCorreoProve;
	//public ServletEnvioProveedor objServlet=objEnviarCorreoProve.objServletStatic ;
	int row=-1;
	public static ServletEnvioProveedor objServletNuevo=null;
	String titulo2[]={"[Cod]","[Empresa]","[Nombre]","[Mail]","[S]","[OA]","[OA-]"};
	DefaultTableModel modelo2 = new DefaultTableModel(null, titulo2);
	MenuPrincipal objMenu;
	AgregarProveCorreo objAProve;
	public static int codproverubro;
	public static String nomprove;
	
	public ConfigCorreoProve() {
		super("Configurar Cuentas", true, true, true, true);
		//super((Frame)padre,true);
	   // super( (Frame)padre, false);
		objServletNuevo=objEnviarCorreoProve.objServletStatic;
		System.out.println("entra al constructor de ConfigCorreoProve!");
		try {

			System.out.println("entra al nuevo configurar Correo");
			pnlArriba = new JPanel();
			FlowLayout pnlArribaLayout = new FlowLayout();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(673, 39));
			pnlArriba.setLayout(pnlArribaLayout);

			btnAgregar = new JButton();
			pnlArriba.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setPreferredSize(new java.awt.Dimension(127, 23));
			btnAgregar.addActionListener(this);

			btnBorrar = new JButton();
			pnlArriba.add(btnBorrar);
			btnBorrar.setText("Borrar");
			btnBorrar.setPreferredSize(new java.awt.Dimension(127, 23));
			btnBorrar.addActionListener(this);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(673, 28));

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(90, 23));
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(90, 23));
			btnCancelar.addActionListener(this);

			pnlCentro = new JPanel();
			GridLayout pnlCentroLayout = new GridLayout(1, 1);
			pnlCentroLayout.setHgap(5);
			pnlCentroLayout.setVgap(5);
			pnlCentroLayout.setColumns(1);
			pnlCentro.setLayout(pnlCentroLayout);
			getContentPane().add(pnlCentro, BorderLayout.CENTER);
			pnlCentro.setPreferredSize(new java.awt.Dimension(673, 247));

			jScrollPane1 = new JScrollPane();
			pnlCentro.add(jScrollPane1);

		
			
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			cargarListado();
			this.setSize(769, 400);
			this.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public  void cargarListado(){
	//	System.out.println(.tamaño());
		
		for (int i = 0; i < objServletNuevo.tamaño(); i++) {
			String sexoS="",sexoOA="",sexoOANegativo="";
			System.out.println("Sexo k viene:"+objServletNuevo.obtener(i).getSexo());
			String sexoKviene=""+objServletNuevo.obtener(i).getSexo();
			sexoKviene=sexoKviene.trim();
			if(sexoKviene.equals("0")){
				sexoS="Sro(a)";//hombre y mujer
			}else if(sexoKviene.equals("1")){
				sexoS="Sr";//hombre
			}else{//mujer
				sexoS="Srta";
			}/*TERMINA EL IF*/
			if(sexoKviene.equals("0")){
				sexoOA="o(a)";
			}else if(sexoKviene.equals("1")){
				sexoOA="o";
			}else{
				sexoOA="a";
			}/*TERMINA EL IF*/
			/*TERMINA EL IF*/
			if(sexoKviene.equals("0")){
				sexoOANegativo="o(a)";
			}else if(sexoKviene.equals("1")){
				sexoOANegativo="a";
			}else{
				sexoOANegativo="o";
			}/*TERMINA EL IF*/
			
			System.out.println("Sexo:"+
					sexoS+"+"+sexoOA+"+"+sexoOANegativo);
			Object[] obj={objServletNuevo.obtener(i).getCodigo(),objServletNuevo.obtener(i).getEmpresa(),
					objServletNuevo.obtener(i).getNombre(),objServletNuevo.obtener(i).getCorreo(),
					sexoS,sexoOA,sexoOANegativo};
			
			modelo2.addRow(obj);
		
			
		}
	}
	
	public void agregar(){
		
		String cod_prove="",nom_prove="",per_prove="",mail_prove="",sex_prove="",
		S="",OA="",OA2="";

		/*AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT cod_prove,nom_prove,per_prove,mail_prove,sex_prove FROM tb_proveedor "+
		"WHERE COD_PROVE=(SELECT max(COD_PROVE) FROM tb_proveedor);";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				cod_prove=""+rs.getInt(1);
				nom_prove=rs.getString(2);
				per_prove=rs.getString(3);
				mail_prove=rs.getString(4);
				sex_prove=""+rs.getInt(5);
				
			}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();*/
		
		cod_prove=""+objAProve.codProve;
		nom_prove=objAProve.nomProve;
		per_prove=objAProve.perProve;
		mail_prove=objAProve.mailProve;
		sex_prove=""+objAProve.sexProve;
		
		if(sex_prove.equals("0")){
			S="Sro(a)";
			OA="o(a)";
			OA2="o(a)";
		}else if(sex_prove.equals("1")){
			S="Sr";
			OA="o";
			OA2="a";
		}else{
			S="Srta";
			OA="a";
			OA2="o";
		}
		
		Object[] obj={cod_prove,nom_prove,per_prove,mail_prove,S,OA,OA2};
		modelo2.addRow(obj);
	}
	public void borrar(){
		
		try {
			int[] arraySelecte1=jTable1.getSelectedRows();
			int[] arraySelecte2=jTable1.getSelectedRows();
			
			if(arraySelecte1.length>0){
			for (int i = 0; i < arraySelecte1.length; i++) {
			//	System.out.println("Tamaño 1:"+arraySelecte1.length);
			//	System.out.println("Numero 1:"+arraySelecte1[0]);
				for (int j = 0; j < arraySelecte1.length; j++) {
					int num = arraySelecte2[i];
					//System.out.println("Borrar:"+num);
					modelo2.removeRow(num);
					
					arraySelecte2=jTable1.getSelectedRows();
					//System.out.println("Tamaño 2:"+arraySelecte2.length);
					
				}
				
			}
				
			}
		} catch (Exception e) {
			System.out.println("no pasa nada");
		}
		
	
		
	}
	
	public void guardarListado(){
		 objServletNuevo.eliminarTodo();
		 objServletNuevo=null;
		 objServletNuevo= new ServletEnvioProveedor();
		for (int i = 0; i < modelo2.getRowCount(); i++) {
//			(String codigo, String nombre, String empresa,Integer sexo, String correo)
			String sexoS=""+modelo2.getValueAt(i, 4);
			String sexoOA=""+modelo2.getValueAt(i, 5);
			String sexoOANegativo=""+modelo2.getValueAt(i, 6);
			int c;
			sexoOANegativo=sexoOANegativo.trim();
		
			
			if(sexoOA.equals("o(a)")){
				c=0;
			}else if(sexoOA.equals("o")){
				c=1;
			}else{
				c=2;
			}
			System.out.println("Esto va a salir:"+modelo2.getValueAt(i, 0)+""+ modelo2.getValueAt(i,2)+""+	modelo2.getValueAt(i,1)+ c +
					""+ modelo2.getValueAt(i, 3));
				
			BeanEnvioProveedor obj = new BeanEnvioProveedor(""+modelo2.getValueAt(i, 0),""+ modelo2.getValueAt(i, 2),
				""+	modelo2.getValueAt(i,1), c ,""+ modelo2.getValueAt(i, 3),"");
			
			
			objServletNuevo.adicionar(obj);
		}
	}
	public void cancelarListado(){ 
		// objServletNuevo=objServletNuevo;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar){
			guardarListado();
			objEnviarCorreoProve.objServletStatic=objServletNuevo;
			setVisible(false);
			System.out.println("MIRA:"+objServletNuevo);
			//objEnviarCorreoProve.objConfigCorreoProve.dispose();
		}
		if(e.getSource()==btnCancelar){
			cancelarListado();
			setVisible(false);
			
		}
		if(e.getSource()==btnAgregar){
			
			AgregarProveCorreo objProve= new AgregarProveCorreo(objMenu);
			objProve.setTitle("Agregar Proveedor");
			objProve.setVisible(true);
			objProve.pack(); 
			
			
			
			agregar();
		}
		if(e.getSource()==btnBorrar){
			borrar();
		}
		
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(jTable1==e.getSource()){
			row=jTable1.getSelectedRow();
		}
		
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
		
		MouseEvent evento=e;
		if(evento.getClickCount()==2){
			int fila = jTable1.getSelectedRow();
			
			codproverubro=Integer.parseInt(""+modelo2.getValueAt(fila,0));
			//System.out.println("COD:"+codproverubro);
			nomprove=""+modelo2.getValueAt(fila,1);
			BuscarRubroMarcaConfigCorreoProve objProRub= new BuscarRubroMarcaConfigCorreoProve(objMenu);
			
			objProRub.setTitle("Proveedor Rubro Marca");
			objProRub.setVisible(true);
			objProRub.pack(); 
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
