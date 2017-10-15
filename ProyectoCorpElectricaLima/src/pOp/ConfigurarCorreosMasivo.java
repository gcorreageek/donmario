package pOp;
import gui.MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.CargadorDeTexto;
import miLib.ClaseCargadora;
import miLib.GUI;
import miLib.LectorExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
public class ConfigurarCorreosMasivo extends JInternalFrame implements ActionListener, MouseListener  {
	private JPanel pnlArriba;
	private JButton btnGuardarExcel;
	private JLabel lblTipo;
	private JButton btnListaTodo;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JPanel pnlAbajo;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel jPanel1;
	private JComboBox cboTipo;
	private JButton btnVerDetalle;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JButton btnSeleccionarTodo;
	private JButton btnCargarExcel;
	private JButton btnVerificar;
	private JPanel pnlDetalleBotones;
	
	CargadorDeTexto obj;
	LectorExcel lectorExcel;
	ClaseCargadora cargarArchivo;

	private MenuPrincipal objMenuP;
	GUI objGUI;
	String titulo2[]={"Codigo","Empresa","Nombre1","Correo1","SexAO1","Tipo","#Publi","Publi","Fecha","Asunto","#Veces"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
		
		 public static Object[][] arregloTabla;
		 public static String cod_cli;
	
	
	public ConfigurarCorreosMasivo() {
		 super("Configurar Correos", true, true, true, true);
		
		try {
			
			this.setPreferredSize(new java.awt.Dimension(918, 331));
			this.setBounds(0, 0, 918, 331);

			//pnlArriba.setLayout(null);

			jPanel1 = new JPanel();
			getContentPane().add(jPanel1, BorderLayout.SOUTH);
			jPanel1.setPreferredSize(new java.awt.Dimension(859,29));

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.CENTER);
			GridLayout pnlAbajoLayout = new GridLayout(1, 1);
			pnlAbajoLayout.setColumns(1);
			pnlAbajoLayout.setHgap(5);
			pnlAbajoLayout.setVgap(5);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(908, 213));
			pnlAbajo.setLayout(pnlAbajoLayout);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(908, 51));
			pnlArriba.setLayout(null);

			btnGuardarExcel = new JButton();
			pnlArriba.add(btnGuardarExcel);
			btnGuardarExcel.setText("Guardar Excel");
			btnGuardarExcel.setVisible(false);
			btnGuardarExcel.setBounds(195, 19, 131, 23);

			lblTipo = new JLabel();
			pnlArriba.add(lblTipo);
			lblTipo.setText("Tipo:");
			lblTipo.setBounds(12, 12, 27, 16);

			cboTipo = new JComboBox();
			pnlArriba.add(cboTipo);
			cboTipo.setBounds(57, 8, 167, 20);

			btnListaTodo = new JButton();
			pnlArriba.add(btnListaTodo);
			btnListaTodo.setText("Lista Todo");
			btnListaTodo.setBounds(230, 7, 93, 26);
			btnListaTodo.setSize(93, 20);

			pnlDetalleBotones = new JPanel();
			pnlArriba.add(pnlDetalleBotones);
			pnlDetalleBotones.setBorder(BorderFactory.createTitledBorder("Detalle"));
			pnlDetalleBotones.setBounds(328, 7, 539, 44);
			pnlDetalleBotones.setLayout(null);

			btnVerificar = new JButton();
			pnlDetalleBotones.add(btnVerificar);
			btnVerificar.setText("Verificar");
			btnVerificar.setVisible(false);
			btnVerificar.setBounds(331, 16, 83, 21);

			btnCargarExcel = new JButton();
			pnlDetalleBotones.add(btnCargarExcel, "East");
			btnCargarExcel.setText("Cargar Excel");
			btnCargarExcel.setBounds(9, 17, 107, 20);

			btnSeleccionarTodo = new JButton();
			pnlDetalleBotones.add(btnSeleccionarTodo, "East");
			btnSeleccionarTodo.setText("Seleccionar Todo");
			btnSeleccionarTodo.setVerticalTextPosition(SwingConstants.TOP);
			btnSeleccionarTodo.setBounds(229, 17, 133, 20);

			btnAgregar = new JButton();
			pnlDetalleBotones.add(btnAgregar);
			btnAgregar.setText("Agregar");
			btnAgregar.setBounds(362, 17, 92, 20);

			btnBorrar = new JButton();
			pnlDetalleBotones.add(btnBorrar);
			btnBorrar.setText("Borrar");
			btnBorrar.setBounds(454, 17, 80, 20);

			btnVerDetalle = new JButton();
			pnlDetalleBotones.add(btnVerDetalle);
			btnVerDetalle.setText("Ver Detalle");
			btnVerDetalle.setBounds(123, 17, 96, 25);
			btnVerDetalle.setSize(96, 20);

			btnBorrar.addActionListener(this);

			btnAgregar.addActionListener(this);

			btnSeleccionarTodo.addActionListener(this);

			btnCargarExcel.addActionListener(this);

			btnVerificar.addActionListener(this);

			btnListaTodo.addActionListener(this);

			cboTipo.addActionListener(this);

			btnGuardarExcel.addActionListener(this);

			jScrollPane1 = new JScrollPane();
			pnlAbajo.add(jScrollPane1);
			jScrollPane1.setPreferredSize(new java.awt.Dimension(908, 193));

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);

			btnAceptar = new JButton();
			jPanel1.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(126,21));

			btnCancelar = new JButton();
			jPanel1.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(131,21));
			btnCancelar.addActionListener(this);

			btnAceptar.addActionListener(this);

			pnlDetalleBotones.setLayout(null);

			this.setVisible(true);
			listaTipo();
			listaTodo();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void cargarExcel(){
		Object[][] arrayLector=null;
		String file=cargarArchivo.cargarArchivo(ConfigurarCorreosMasivo.this);
		try {
		 arrayLector=lectorExcel.optenerFilasColumnasExcel(titulo2.length, file);
		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < arrayLector.length; i++) {
			
			if(i!=0){
			Object[] t= new Object[titulo2.length];
			for (int j = 0; j < titulo2.length; j++) {
				//System.out.print("VALOR:"+arrayLector[i][j]+"-");
				//System.out.println("t["+j+"]=arrayLector["+i+"]["+j+"]");
					t[j]=arrayLector[i][j];	
			}
			modelo2.addRow(t);	
			}
		}
	}
	private void guardarExcel() {
		// TODO Auto-generated method stub
		
	}
	private void verificar() {
		for (int i = 0; i < titulo2.length; i++) {


		}
	
		
	}
	private Object[][] seleccionados(){
		int filas=0;
		int columnas=0;
		filas=jTable1.getSelectedRows().length;
		columnas=jTable1.getColumnCount();
		Object[][] arrayTabla= new Object[filas][columnas];
		int sele[] = jTable1.getSelectedRows();
		for (int i = 0; i < sele.length; i++) {
			for (int j = 0; j < columnas ; j++) {
				Object objeto=modelo2.getValueAt(sele[i], j);//System.out.println("El Objecto["+i+"]["+j+"]:"+objeto);
				arrayTabla[i][j]=objeto;
			}
		}
		
		return arrayTabla;
	}

	private void aceptar() {
		arregloTabla=seleccionados();
		//setVisible(false);
	}
	private void cancelar() {
		GUI.mostrarAviso("mierda");
		//setVisible(false);
		
	}
	private void seleccionaCombo() {
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);	
		String cboSeleccionado="";
		if(cboTipo.getSelectedIndex()==0){
			listaTodo();
		}else{
		cboSeleccionado=(String) cboTipo.getSelectedItem();
		cboSeleccionado=cboSeleccionado.substring(0,cboSeleccionado.indexOf("-") );
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT CLI.COD_CLI,TRIM(CLI.NOM_CLI),TRIM(CLI.CONA_CLI),TRIM(CLI.MAILA_CLI),CLI.SEX_CLI,tipocli.nom_tipo, "+
			" (SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI AND FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI)) "+
			 " 'CPUBLI ULTIMO', "+
			 " (SELECT PUBLIC.NOM_PUBLI FROM tb_masivo masi "+
			 " inner join tb_publicidad public "+
			 "  on PUBLIC.cod_publi=masi.cod_publi "+
			 " inner join tb_cliente clie "+
			 " on clie.cod_cli=masi.cod_cli "+
			 " where CLIe.cod_cli=CLI.COD_CLI "+
			 " AND "+
			 " PUBLIC.COD_PUBLI=(SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI "+
			 " AND   FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI))) "+
			 " 'NPUBLI ULTIMO', "+
			 "  (SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) "+
			 "  AS FPUBLI_ULTIMO, "+
			 " (SELECT MASI.ASU_MAS FROM tb_masivo masi "+
			 " inner join tb_publicidad public "+
			 "  on PUBLIC.cod_publi=masi.cod_publi "+
 			"  inner join tb_cliente clie "+
			 " on clie.cod_cli=masi.cod_cli "+
			 "  where CLIe.cod_cli=CLI.COD_CLI AND PUBLIC.COD_PUBLI=(SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI "+
			 "  AND   FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI))) "+
			 "  'ASUNTO ULTIMO', "+
			 "  (SELECT COUNT(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) "+
			 " 'CONTADOR MENSAJES' "+
			 " FROM tb_masivo mas "+
			 " , tb_publicidad pub  , tb_cliente cli, tb_tipocliente tipocli "+
			 " WHERE TIPOCLI.NOM_TIPO='"+cboSeleccionado+"'  AND pub.cod_publi=mas.cod_publi  AND TIPOCLI.COD_TIPO=CLI.COD_TIPO "+
			 " AND IF(CLI.MAILA_CLI='',0, "+
			 " IF(CLI.MAILA_CLI='0',0, "+
			 " IF(CLI.MAILA_CLI='@',0, "+
			 " IF(LOCATE('/',CLI.MAILA_CLI)!='0',0, "+
			 " IF(LOCATE(',',CLI.MAILA_CLI)!='0',0, "+
			 " IF(LOCATE(' ',TRIM(CLI.MAILA_CLI))!='0',0, "+
			 " IF(CLI.CONA_CLI='0',0, "+
			 " IF(CLI.CONA_CLI=' ',0,1))))))))=1 "+
			 " GROUP BY CLI.COD_CLI;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		}
	}
	private void listaTipo() {
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT * FROM tb_tipocliente WHERE est_tipo='ACTIVADO';";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while (rs.next()) {
			cboTipo.addItem( rs.getString(2)+"-"+rs.getString(1));
			}
			rs.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
			// TODO: handle exception
		}

		objAccesoBD.cerrarConexion();
	}
	private void listaTodo() {
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);	
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT CLI.COD_CLI,TRIM(CLI.NOM_CLI),TRIM(CLI.CONA_CLI),TRIM(CLI.MAILA_CLI),CLI.SEX_CLI,tipocli.nom_tipo, "+
  " (SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI AND FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI)) "+
			 "  'CPUBLI ULTIMO', "+
			 " (SELECT PUBLIC.NOM_PUBLI FROM tb_masivo masi "+
			 " inner join tb_publicidad public "+
			 " on PUBLIC.cod_publi=masi.cod_publi "+
			 " inner join tb_cliente clie "+
			 " on clie.cod_cli=masi.cod_cli "+
			 " where CLIe.cod_cli=CLI.COD_CLI "+
			 " AND "+
			 " PUBLIC.COD_PUBLI=(SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI "+
			 " AND   FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI))) "+
			 " 'NPUBLI ULTIMO', "+
			 " (SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) "+
			 "  AS FPUBLI_ULTIMO, "+
			 " (SELECT MASI.ASU_MAS FROM tb_masivo masi "+
			 " inner join tb_publicidad public "+
			 " on PUBLIC.cod_publi=masi.cod_publi "+
			 " inner join tb_cliente clie "+
			 " on clie.cod_cli=masi.cod_cli "+
			 "  where CLIe.cod_cli=CLI.COD_CLI AND PUBLIC.COD_PUBLI=(SELECT MAX(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI "+
			 "  AND   FEC_MAS=(SELECT MAX(FEC_MAS) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI))) "+
			 " 'ASUNTO ULTIMO', "+
			 "  (SELECT COUNT(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) "+
			 "  'CONTADOR MENSAJES' "+
			 " FROM tb_masivo mas "+
			 " , tb_publicidad pub  , tb_cliente cli, tb_tipocliente tipocli "+
			 " WHERE pub.cod_publi=mas.cod_publi  AND TIPOCLI.COD_TIPO=CLI.COD_TIPO "+
			 " AND IF(CLI.MAILA_CLI='',0, "+
			 " IF(CLI.MAILA_CLI='0',0, "+
			 " IF(CLI.MAILA_CLI='@',0, "+
			 " IF(LOCATE('/',CLI.MAILA_CLI)!='0',0, "+
			 " IF(LOCATE(',',CLI.MAILA_CLI)!='0',0, "+
			 " IF(LOCATE(' ',TRIM(CLI.MAILA_CLI))!='0',0, "+
			 " IF(CLI.CONA_CLI='0',0, "+
			 " IF(CLI.CONA_CLI=' ',0,1))))))))=1 "+
			 " GROUP BY CLI.COD_CLI;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				Object obj[]={rs.getInt(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11)
				};
						
				modelo2.addRow(obj);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
	}
	
	private void seleccionaTodo() {
		System.out.println("hey!");
		jTable1.selectAll();
		
	}	
	private void borrar() {
	//System.out.println("row1:"+modelo2.get)	;
	//System.out.println("row2:"+jTable1.getSelectedRow())	;
	//	jTable1.getselect
		modelo2.removeRow(jTable1.getSelectedRow());
		
	}
	private void agregar() {
	Object[] obj= {"","","","","","","","","","",""};
			
	
	modelo2.addRow(obj);
		
	}
	private void cargarHistorial() {
		GUI.mostrarAviso("BIEN");
		
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
	public void mousePressed(MouseEvent e2) {
		if(e2.getSource()==jTable1){
			MouseEvent evento=e2;
			if(evento.getSource()==jTable1){
				if(evento.getClickCount()==2){
					System.out.println("entra px ");
					cargarHistorial();
					setVisible(false);
					//ELIMINAR TODOS LOS SERVLETS
					
					
					
					
					
				}
			}
			
			
			
		}
		
	}




	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnCargarExcel ){
			cargarExcel();
		}
		if(e.getSource()==btnGuardarExcel){
			guardarExcel();
		}
		if(e.getSource()==btnAceptar){
			aceptar();
		}
		if(e.getSource()==btnCancelar){
			cancelar();
		}
		if(e.getSource()==btnVerificar){
			verificar();
		}
	
		if(e.getSource()==cboTipo){
			seleccionaCombo();
		}
		if(e.getSource()==btnListaTodo){
			listaTodo();		
		}
		if(e.getSource()==btnSeleccionarTodo){
			seleccionaTodo();
		}
		if(e.getSource()==btnAgregar){
			agregar();
		}
		if(e.getSource()==btnBorrar){
			borrar();
		}
		
	}

}
