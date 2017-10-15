package pOp;
import gui.EnviarOrdenCompraProveedor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import servlet.ServletEnvioProveedor;
import beans.BeanEnvioOC;

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
public class ConfigCorreoProveOC extends JInternalFrame implements ActionListener, MouseListener {
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JButton btnCancelar;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JButton btnAceptar;
	private JPanel pnlCentro;
	 
	public EnviarOrdenCompraProveedor objEnviarOC;
	 ArrayList<BeanEnvioOC> objConf=objEnviarOC.arrayConfig;
	//public ServletEnvioProveedor objServlet=objEnviarCorreoProve.objServletStatic ;
	int row=-1;
	public static ServletEnvioProveedor objServletNuevo=null;
	String titulo2[]={"[Cod]","[Empresa]","[Nombre]","[Mail1]","[Mail2]","[S]","[OA]","[OA-]","[Ruta]"};
	DefaultTableModel modelo2 = new DefaultTableModel(null, titulo2);
	public ConfigCorreoProveOC() {
		super("Configurar Cuentas", true, true, true, true);
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
		
	
		
		
		for (int i = 0; i < objConf.size(); i++) {
			Object[] obj={objConf.get(i).getCod(),objConf.get(i).getEmp(),
					objConf.get(i).getNom(),objConf.get(i).getMail1(),
					objConf.get(i).getMail2(),
					objConf.get(i).getSexoS(),objConf.get(i).getSexoAO(),
					objConf.get(i).getSexoOA(),objConf.get(i).getRuta()};
			
			modelo2.addRow(obj);
		
			
		}
	}
	
	public void agregar(){
		Object[] obj={"","",
				"","",
				"","",""};
		
		modelo2.addRow(obj);
	}
	public void borrar(){
		
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
	
		
	}
	
	public void guardarListado(){
		objConf.clear();
		objConf=null;
		objConf= new ArrayList<BeanEnvioOC>();
		for (int i = 0; i < modelo2.getRowCount(); i++) {
			
			BeanEnvioOC obj = new BeanEnvioOC(modelo2.getValueAt(i, 0)+"", modelo2.getValueAt(i, 1)+"", 
					modelo2.getValueAt(i, 2)+"", modelo2.getValueAt(i, 3)+"", modelo2.getValueAt(i, 4)+"", 
					modelo2.getValueAt(i, 5)+"", modelo2.getValueAt(i, 6)+"", modelo2.getValueAt(i, 7)+"", modelo2.getValueAt(i, 8)+"");
			
			objConf.add(obj);
		}
		objEnviarOC.arrayConfig.clear();
		objEnviarOC.arrayConfig=objConf;
	}
	public void cancelarListado(){ 
		// objServletNuevo=objServletNuevo;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar){
			guardarListado();
		//	objEnviarCorreoProve.objServletStatic=objServletNuevo;
			setVisible(false);
		
			//objEnviarCorreoProve.objConfigCorreoProve.dispose();
		}
		if(e.getSource()==btnCancelar){
			cancelarListado();
			setVisible(false);
			
		}
		if(e.getSource()==btnAgregar){
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
