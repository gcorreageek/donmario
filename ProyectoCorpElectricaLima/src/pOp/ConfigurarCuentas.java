package pOp;
import gui.MenuPrincipal;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.CargadorDeTexto;
import miLib.ClaseCargadora;
import miLib.GUI;
import miLib.LectorExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import servlet.ServletClienteCorreoMas;
import servlet.ServletMasivoPub;
import beans.BeanClienteCorreoMasivo;
import beans.BeanMasivoPub;

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
public class ConfigurarCuentas extends JDialog implements MouseListener, ActionListener, KeyListener {
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JTextField areatexto;
	CargadorDeTexto obj;
	LectorExcel lectorExcel;
	ClaseCargadora cargarArchivo;

	private MenuPrincipal objMenuP;
	GUI objGUI;
	String titulo2[]={"Codigo","Empresa","Nombre1","Correo1","SexAO1","Tipo","#Publi","Publi","Fecha","Asunto","#Veces"};
			
	
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
		//public static DefaultTableModel modelo=null;
		//public static String titulo[]=null;
		 public static Object[][] arregloTabla;
		 public static String cod_cli;
		
	 boolean  valorChess=false;
	 private JButton btnCancelar;
	 private JButton btnAceptar;
	 private JPanel jPanel1;
	 
	//public static boolean valor=false;
	
	private JScrollPane jScrollPane1;
	private JButton btnVerificar;
	private JTable jTable1;
	JButton btnCargarExcel;
	JButton btnGuardarExcel;
	private JButton btnListaTodo;
	private JButton btnBorrar;
	private JButton btnAgregar;
	private JButton btnSeleccionarTodo;
	private JComboBox cboTipo;
	private JLabel lblTipo;
	private JPanel pnlDetalleBotones;
	private JButton btnVerDetalle;
	ServletClienteCorreoMas objCliCorrMas =new ServletClienteCorreoMas();
	ServletMasivoPub objMasPub= new ServletMasivoPub();
	
	public ConfigurarCuentas(Frame padre) {
		
		super( (Frame)padre, true);
		try {
			obj = new CargadorDeTexto();
			
			pnlArriba = new JPanel();

			pnlAbajo = new JPanel();
			GridLayout pnlAbajoLayout = new GridLayout(1, 1);
			pnlAbajoLayout.setHgap(5);
			pnlAbajoLayout.setVgap(5);
			pnlAbajoLayout.setColumns(1);
			pnlAbajo.setLayout(pnlAbajoLayout);
			getContentPane().add(pnlAbajo, BorderLayout.CENTER);
			pnlAbajo.setPreferredSize(new java.awt.Dimension(859, 429));
			
				jScrollPane1 = new JScrollPane();
				pnlAbajo.add(jScrollPane1);
				jScrollPane1.setPreferredSize(new java.awt.Dimension(859, 467));

					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(modelo2);
					jTable1.addMouseListener(this);

			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setPreferredSize(new java.awt.Dimension(892, 42));
			pnlArriba.setLayout(null);

			 btnGuardarExcel = new JButton("Guardar Excel");
			btnGuardarExcel.setBounds(195, 19, 131, 23);
			btnGuardarExcel.setVisible(false);
			pnlArriba.add(btnGuardarExcel);

				pnlDetalleBotones = new JPanel();
				pnlDetalleBotones.setLayout(null);
				pnlArriba.add(pnlDetalleBotones);
				pnlDetalleBotones.setBounds(379, 0, 575, 42);
				pnlDetalleBotones.setBorder(BorderFactory.createTitledBorder("Detalle"));

				btnVerificar = new JButton();
				pnlDetalleBotones.add(btnVerificar);
				btnVerificar.setText("Verificar");
				btnVerificar.setBounds(331, 16, 83, 21);
				btnVerificar.setVisible(false);
				btnVerificar.addActionListener(this);

				btnCargarExcel = new JButton("Cargar Excel");
				pnlDetalleBotones.add(btnCargarExcel, "East");
				btnCargarExcel.setBounds(9, 17, 111, 19);

				btnSeleccionarTodo = new JButton();
				pnlDetalleBotones.add(btnSeleccionarTodo, "East");
				btnSeleccionarTodo.setText("Seleccionar Todo");
				btnSeleccionarTodo.setBounds(124, 17, 134, 19);
				btnSeleccionarTodo.setVerticalTextPosition(SwingConstants.TOP);

				btnAgregar = new JButton();
				pnlDetalleBotones.add(btnAgregar);
				btnAgregar.setText("Agregar");
				btnAgregar.setBounds(402, 15, 86, 20);
				btnAgregar.addActionListener(this);

				btnBorrar = new JButton();
				pnlDetalleBotones.add(btnBorrar);
				btnBorrar.setText("Borrar");
				btnBorrar.setBounds(493, 15, 77, 20);

				btnVerDetalle = new JButton();
				pnlDetalleBotones.add(btnVerDetalle);
				btnVerDetalle.setText("Ver Detalle");
				btnVerDetalle.setBounds(263, 16, 96, 20);
				
				btnVerDetalle.addActionListener(this);
				btnBorrar.addActionListener(this);
				btnSeleccionarTodo.addActionListener(this);
				btnCargarExcel.addActionListener(this);
							
				lblTipo = new JLabel();
				pnlArriba.add(lblTipo);
				lblTipo.setText("Tipo:");
				lblTipo.setBounds(20, 9, 36, 14);
			

		
			cboTipo = new JComboBox();
			pnlArriba.add(cboTipo);
			cboTipo.setBounds(56, 7, 197, 19);
			cboTipo.addActionListener(this);

			btnListaTodo = new JButton();
			pnlArriba.add(btnListaTodo);
			btnListaTodo.setText("Lista Todo");
			btnListaTodo.setBounds(259, 7, 94, 20);
			btnListaTodo.setEnabled(false);
			btnListaTodo.addActionListener(this);

			btnGuardarExcel.addActionListener(this);

			jPanel1 = new JPanel();
			getContentPane().add(jPanel1, BorderLayout.SOUTH);
			jPanel1.setPreferredSize(new java.awt.Dimension(859, 29));

			btnAceptar = new JButton();
			jPanel1.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(126, 21));
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			jPanel1.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(131, 21));
			btnCancelar.addActionListener(this);
			listaTipo();
			//listaTodo();
			listarClientesMasivoPubli();
			this.setSize(1000, 300);	
			
			}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	private void cargarExcel(){
		Object[][] arrayLector=null;
		String file=cargarArchivo.cargarArchivo(ConfigurarCuentas.this);
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
		setVisible(false);
	}
	private void cancelar() {
		setVisible(false);
		
	}
	
	/*private void seleccionaCombo() {
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
			 " WHERE TIPOCLI.NOM_TIPO='"+cboSeleccionado+"'  AND pub.cod_publi=mas.cod_publi  AND TIPOCLI.COD_TIPO=CLI.COD_TIPO AND cli.EST_CLI='ACTIVADO' "+
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
	}*/
	
	private void listaTipo() {
		
		AccesoBD objAccesoBD = new AccesoBD();
		ResultSet rs = null;
		
		try {
			
			objAccesoBD.crearConexion();
			String sql="SELECT * FROM tb_tipocliente WHERE est_tipo='ACTIVADO';";
			rs = objAccesoBD.ejecutarConsulta(sql);
				
				while (rs.next()) {
					cboTipo.addItem( rs.getString(2)+"-"+rs.getString(1));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
	}
	
	/*private void listaTodo() {
		
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
	}*/
	
	/************************************************************************************************************/
//       public void listarClientesMasivoPubli(){
//		  
//    	objCliCorrMas.eliminarTodo();
//       	objMasPub.eliminarTodo(); 
//       	
//    	   
//		int n=modelo2.getRowCount();
//		for (int fila=0; fila<n; fila++)
//		modelo2.removeRow(0);
//		
//		AccesoBD objAccesoBD = new AccesoBD();
//		ResultSet rs=null;
//		ResultSet rs2=null;
//		
//		String codicli1="",codicli2="";		
//		String cod_publi="",nom_publi="",fec_mas="",asu_mas="",num_veces="";
//		
//		try {
//			
//			objAccesoBD.crearConexion();
//			
//				
//			String sql="select CLI.COD_CLI,cli.nom_cli,cli.cona_cli,cli.maila_cli,CLI.SEX_CLI," +
//					   "tipcli.nom_tipo from tb_cliente cli "+
//	                   "inner join tb_tipocliente tipcli "+
//	                   "on cli.COD_TIPO = tipcli.cod_tipo " +
//	                   "where cli.est_cli='ACTIVADO' "+
//	                   "order by CLI.COD_CLI;";
//			
//			String sql2="select CLI.COD_CLI,pub.cod_publi,pub.nom_publi,mas.fec_mas, "+
//	                    "mas.asu_mas,(SELECT COUNT(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) as 'conta' "+
//	                    "from tb_cliente cli "+
//	                    "inner join tb_masivo mas "+
//	                    "on mas.cod_cli = CLI.COD_CLI "+
//	                    "inner join tb_publicidad pub "+
//	                    "on mas.cod_publi = pub.cod_publi "+
//	                    "where CLI.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where CLI.COD_CLI=cod_cli);";
//	               
//			
//			 rs=objAccesoBD.ejecutarConsulta(sql);
//			 rs2=objAccesoBD.ejecutarConsulta(sql2);
//				
//			while(rs.next()){
//			BeanClienteCorreoMasivo objC= new BeanClienteCorreoMasivo(rs.getString(1), rs.getString(2),
//					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//			objCliCorrMas.adicionar(objC);
//			}
//			
//			
//			while(rs2.next()){
//				BeanMasivoPub objM= new BeanMasivoPub(rs2.getString(1), rs2.getString(2),
//						rs2.getString(3), rs2.getString(4), rs2.getString(5),rs2.getString(6));
//				objMasPub.adicionar(objM);					
//			}
//				
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			objAccesoBD.cerrarResultSet(rs);
//			objAccesoBD.cerrarResultSet(rs2);
//			objAccesoBD.cerrarStatement();
//			objAccesoBD.cerrarConexion();  
//		}
//		
//		for (int i = 0; i < objCliCorrMas.tamaño(); i++) {
//			
//			
//			for(int j = 0; j < objMasPub.tamaño(); j++){
//				
//				codicli2=objCliCorrMas.obtener(i).getCod_cli();
//				codicli1=objMasPub.obtener(j).getCod_cli();
//				
//				if(codicli2.equals(codicli1)){
//					 cod_publi=objMasPub.obtener(j).getCod_publi();
//					 nom_publi=objMasPub.obtener(j).getNom_publi();
//					 fec_mas=objMasPub.obtener(j).getFec_mas();
//					 asu_mas=objMasPub.obtener(j).getAsu_mas();
//					 num_veces=objMasPub.obtener(j).getNum_veces();
//					 break;
//				}else{
//					 cod_publi="";
//					 nom_publi="";
//					 fec_mas="";
//					 asu_mas="";
//					 num_veces="";
//				
//				}
//				
//			}
//			
//			Object[] obj={objCliCorrMas.obtener(i).getCod_cli(),objCliCorrMas.obtener(i).getNom_cli(),
//	    	              objCliCorrMas.obtener(i).getCona_cli(),objCliCorrMas.obtener(i).getMalia_cli(),
//	    	              objCliCorrMas.obtener(i).getSex_cli(),objCliCorrMas.obtener(i).getNom_tipo(),cod_publi,
//	    	              nom_publi,fec_mas,asu_mas,num_veces
//					
//			};
//			
//			modelo2.addRow(obj);
//			
//		}
//		
//	}

    /****************************************************************************************************************/
//       
//       public void seleccionaCombo2(){
//    	 
//    	objCliCorrMas.eliminarTodo();
//    	objMasPub.eliminarTodo();
//    	
//   		int n=modelo2.getRowCount();
//   		for (int fila=0; fila<n; fila++)
//   		modelo2.removeRow(0);
//   		
//   		AccesoBD objAccesoBD = new AccesoBD();
//   		ResultSet rs= null;
//   		ResultSet rs2=null;
//   		
//   		String codicli1="",codicli2="";
//   		String cboSeleccionado="";
//   		String cod_publi="",nom_publi="",fec_mas="",asu_mas="",num_veces="";
//   		
//   		try {
//   			
//	   		objAccesoBD.crearConexion();
//	   		
//	   		
//	   		if(cboTipo.getSelectedIndex()==0){
//	   		 
//	   			listarClientesMasivoPubli();
//	   			
//	   						
//			}else{
//				cboSeleccionado=(String) cboTipo.getSelectedItem();
//				//System.out.println("PINTA: "+cboSeleccionado.indexOf("-"));
//				cboSeleccionado=cboSeleccionado.substring(0,cboSeleccionado.indexOf("-") );
//			
//	   		
//	   			
//	   		String sql="select CLI.COD_CLI,cli.nom_cli,cli.cona_cli,cli.maila_cli,CLI.SEX_CLI, " +
//	   				      "tipcli.nom_tipo from tb_cliente cli "+
//	                      "inner join tb_tipocliente tipcli "+
//	                      "on cli.COD_TIPO = tipcli.cod_tipo "+
//	                      "WHERE tipcli.NOM_TIPO='"+cboSeleccionado+"' AND CLI.EST_CLI='ACTIVADO' order by CLI.COD_CLI;";
//	   		
//	   		String sql2="select CLI.COD_CLI,pub.cod_publi,pub.nom_publi,mas.fec_mas, "+
//	                       "mas.asu_mas,(SELECT COUNT(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) as 'conta' "+
//	                       "from tb_cliente cli "+
//	                       "inner join tb_masivo mas "+
//	                       "on mas.cod_cli = CLI.COD_CLI "+
//	                       "inner join tb_publicidad pub "+
//	                       "on mas.cod_publi = pub.cod_publi "+
//	                       "where CLI.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where CLI.COD_CLI=cod_cli);";
//	                  
//	   		
//	   		rs=objAccesoBD.ejecutarConsulta(sql);
//	   		rs2=objAccesoBD.ejecutarConsulta(sql2);
//	   		
//	   		
//	   			
//	   			while(rs.next()){
//	   			BeanClienteCorreoMasivo objC= new BeanClienteCorreoMasivo(rs.getString(1), rs.getString(2),
//	   					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//	   			objCliCorrMas.adicionar(objC);
//	   			}
//	   			
//	   			
//	   			while(rs2.next()){
//	   				BeanMasivoPub objM= new BeanMasivoPub(rs2.getString(1), rs2.getString(2),
//	   						rs2.getString(3), rs2.getString(4), rs2.getString(5),rs2.getString(6));
//	   				objMasPub.adicionar(objM);
//	   			}
//	   				   			
//			}
//	   		
//   		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			objAccesoBD.cerrarResultSet(rs);
//			objAccesoBD.cerrarResultSet(rs2);
//			objAccesoBD.cerrarStatement();
//			objAccesoBD.cerrarConexion();  
//		}
//   		
//   		for (int i = 0; i < objCliCorrMas.tamaño(); i++) {
//   			
//   			
//   			for(int j = 0; j < objMasPub.tamaño(); j++){
//   				
//   				//conta++;
//   				codicli2=objCliCorrMas.obtener(i).getCod_cli();
//   				codicli1=objMasPub.obtener(j).getCod_cli();
//   				
//   				if(codicli2.equals(codicli1)){
//   					 cod_publi=objMasPub.obtener(j).getCod_publi();
//   					 nom_publi=objMasPub.obtener(j).getNom_publi();
//   					 fec_mas=objMasPub.obtener(j).getFec_mas();
//   					 asu_mas=objMasPub.obtener(j).getAsu_mas();
//   					 num_veces=objMasPub.obtener(j).getNum_veces();
//   					 break;
//   				}else{
//   					 cod_publi="";
//   					 nom_publi="";
//   					 fec_mas="";
//   					 asu_mas="";
//   					 num_veces="";
//   				}
//   				
//   			}
//   			
//   			Object[] obj={objCliCorrMas.obtener(i).getCod_cli(),objCliCorrMas.obtener(i).getNom_cli(),
//   	    	              objCliCorrMas.obtener(i).getCona_cli(),objCliCorrMas.obtener(i).getMalia_cli(),
//   	    	              objCliCorrMas.obtener(i).getSex_cli(),objCliCorrMas.obtener(i).getNom_tipo(),cod_publi,
//   	    	              nom_publi,fec_mas,asu_mas,num_veces
//   					
//   			};
//   			
//   			modelo2.addRow(obj);
//   			
//   		}
//    }
   	

       
     /****************************************************************************************************************/

       public void listarClientesMasivoPubli(){
    	 
    	objCliCorrMas.eliminarTodo();
    	
   		int n=modelo2.getRowCount();
   		for (int fila=0; fila<n; fila++)
   		modelo2.removeRow(0);
   		
   		AccesoBD objAccesoBD = new AccesoBD();
   		ResultSet rs= null;
   		String cboSeleccionado="";
   		
   		try {
   			
	   		objAccesoBD.crearConexion();
	   		cboSeleccionado=(String) cboTipo.getSelectedItem();
			cboSeleccionado=cboSeleccionado.substring(0,cboSeleccionado.indexOf("-") );
			
	   		String sql="select c.cod_cli,c.nom_cli,c.cona_cli,c.maila_cli,c.SEX_CLI, "+
						"tipcli.nom_tipo, "+
						"/*PRIMERA COLUMNA*/ "+
						"if(c.COD_CLI=(select cli.COD_CLI "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND "+
						"mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1) "+
						",(select pub.cod_publi "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1),'') as 'cod_publi', "+
						""+
						"/*SEGUNDA COLUMNA*/ "+
						"if(c.COD_CLI=(select cli.COD_CLI "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND "+
						"mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1) "+
						",(select pub.nom_publi "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1),'') as 'nom_publi', "+
						""+
						"/*TERCERA COLUMNA*/ "+
						"if(c.COD_CLI=(select cli.COD_CLI "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND "+
						"mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1) "+
						",(select mas.fec_mas "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1),'') as 'fec_mas', "+
						""+
						"/*CUARTA COLUMNA*/ "+
						"if(c.COD_CLI=(select cli.COD_CLI "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND "+
						"mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1) "+
						",(select mas.asu_mas "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1),'') as 'asu_mas', "+
						""+
						"/*QUINTA COLUMNA*/ "+
						"if(c.COD_CLI=(select cli.COD_CLI "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND "+
						"mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1) "+
						",(select (SELECT COUNT(COD_PUBLI) FROM tb_masivo WHERE COD_CLI=CLI.COD_CLI) "+
						"from tb_cliente cli "+
						"inner join tb_masivo mas "+
						"on mas.cod_cli = cli.COD_CLI "+
						"inner join tb_publicidad pub "+
						"on mas.cod_publi = pub.cod_publi "+
						"where c.cod_cli=cli.COD_CLI AND cli.EST_CLI='ACTIVADO' AND mas.fec_mas=(select MAX(fec_mas) from tb_masivo where cli.COD_CLI=cod_cli) limit 1),0) as 'conta' "+
						""+
						"from tb_cliente c "+
						"inner join tb_tipocliente tipcli "+
						"on c.COD_TIPO = tipcli.cod_tipo "+
						"WHERE tipcli.NOM_TIPO='"+cboSeleccionado+"' AND c.EST_CLI='ACTIVADO' order by c.COD_CLI;";
	                  
	   		
	   		rs=objAccesoBD.ejecutarConsulta(sql);  		
	   		
	   			
	   			while(rs.next()){
	   			BeanClienteCorreoMasivo objC= new BeanClienteCorreoMasivo(rs.getString(1), rs.getString(2),
	   					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
	   					, rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
	   			objCliCorrMas.adicionar(objC);
	   			}
	   				   			
			
	   		
   		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			objAccesoBD.cerrarResultSet(rs);
			objAccesoBD.cerrarStatement();
			objAccesoBD.cerrarConexion();  
		}
   		
   		for (int i = 0; i < objCliCorrMas.tamaño(); i++) { 			
   			
   				   			
   			Object[] obj={objCliCorrMas.obtener(i).getCod_cli(),objCliCorrMas.obtener(i).getNom_cli(),
   	    	              objCliCorrMas.obtener(i).getCona_cli(),objCliCorrMas.obtener(i).getMalia_cli(),
   	    	              objCliCorrMas.obtener(i).getSex_cli(),objCliCorrMas.obtener(i).getNom_tipo(),
   	    	              objCliCorrMas.obtener(i).getCod_publi(),objCliCorrMas.obtener(i).getNom_publi(),
   	    	              objCliCorrMas.obtener(i).getFec_mas(),objCliCorrMas.obtener(i).getAsu_mas(),
   	    	              objCliCorrMas.obtener(i).getNum_veces()   					
   						};
   			
   			modelo2.addRow(obj);
   			
   		
        }
  }

	private void seleccionaTodo() {
		System.out.println("hey!");
		jTable1.selectAll();
		
	}	
	private void borrar() {
   
		 int fila = jTable1.getSelectedRow();
//	     int cant = jTable1.getSelectedRowCount();
//	     int total= fila+cant;
	     
	     int array []=jTable1.getSelectedRows();	     
	     int cont=-1;
	     
	     if(fila==-1) {			
	    	 objGUI.mostrarAviso("Debe Seleccionar Un Cliente");
	     }else {
			
	    	 for (int i : array) {
					
				 //System.out.println("YYYY: "+i);
	    		 cont++;
	    		 modelo2.removeRow(i-cont);
								    					
			 }
	     }
	
		
	}
	private void agregar() {
	
    	
	Object[] obj= {"","","","","","","","","","",""};	
	modelo2.addRow(obj);
		
	}

	void cargarHistorial(){
		
		
		
		cod_cli=modelo2.getValueAt(jTable1.getSelectedRow(), 0).toString();
		
		ListarHisClientes objListarHis = new ListarHisClientes(objMenuP);
		objListarHis.setLocation(200, 50);		
		objListarHis.setVisible(true);
	
		objListarHis.pack();
			
	}

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
			listarClientesMasivoPubli();
		}
		if(e.getSource()==btnListaTodo){
			//listaTodo();		
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
		if(e.getSource()==btnVerDetalle&&jTable1.getSelectedRow()!=-1){
			cargarHistorial();
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e2) {
		if(e2.getSource()==jTable1){
						
		}
		
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
