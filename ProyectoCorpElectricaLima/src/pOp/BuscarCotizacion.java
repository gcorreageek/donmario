package pOp;

import gui.EnvioMailsAutoCliente;
import gui.MenuPrincipal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.GUI;
import servlet.ServletBuscaCotiMant;
import beans.BeanBuscaCotiMant;
import calendar.DateButton;


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
public class BuscarCotizacion extends JPanel implements ActionListener, KeyListener, MouseListener {


	MenuPrincipal objMenu;
	GUI objGUI;
	private JRadioButton rdbCliente;
	private JRadioButton rdbFechas;
	private JRadioButton rdbNCotizacion;
	private JLabel lblFechas;
	private JScrollPane scrListar;
	private JTable tblListar;
	private JButton btnListar;
	private JTextField txtCliente;
	private JButton btnBuscar;
	private JTextField txtNCotizacion;
	private JLabel lblNombreCliente;
	private JLabel lblNumeroCotizacion;
	boolean valor=true;
	public static int est=0;
	public static int estado;
	private DateButton btnFecha1;
	private DateButton btnFecha2;
	ServletBuscaCotiMant objBCM= new ServletBuscaCotiMant();
	String titulo2[]={"COD", "NOMCLI", "CON", "FEC", "VEN", "IDE","REF","ENVIO","ESTADO","CONTESTO"};

	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_COT, NOM_CLI, CONA_CLI, FEC_COT, VEN, IDE_COT,REF_COT,AGE_CLI,MAILA_CLI,MAILB_CLI,COD_CLI,
	                       EST_EMP,SEX_CLI,TEL1,TEL2,FAX,RPM,NEXTEL,CEL;
	
	 //Global
	 String cod_producto;
	 CambiarLlamada objLlamada;
	 int codicli;
	 public static String nom_conacli,correo1,correo2,sexcli,nom_ven;
	 private JRadioButton rdbCel;
	 private JRadioButton rdbCye;
	 public static int abrir=0;
	 EnvioMailsAutoCliente objEnvioMail;
	 
	public BuscarCotizacion() {
		
		 //super((Frame)padre, true);
		
		try {
			this.setPreferredSize(new java.awt.Dimension(958, 366));
			this.setBounds(0, 0, 240, 360);
			this.setLayout(null);

			this.setVisible(true);

			lblNumeroCotizacion = new JLabel();
			this.add(lblNumeroCotizacion);
			lblNumeroCotizacion.setText("NºCotizacion:");
			lblNumeroCotizacion.setBounds(20, 12, 78, 14);

			lblNombreCliente = new JLabel();
			this.add(lblNombreCliente);
			lblNombreCliente.setText("Cliente:");
			lblNombreCliente.setBounds(20, 38, 60, 14);

			txtNCotizacion = new JTextField();
			this.add(txtNCotizacion);
			txtNCotizacion.setBounds(98, 9, 74, 21);
			txtNCotizacion.addKeyListener(this);

			txtCliente = new JTextField();
			this.add(txtCliente);
			txtCliente.setBounds(98, 35, 428, 21);
			txtCliente.addKeyListener(this);

			btnBuscar = new JButton();
			this.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(317, 62, 85, 22);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			this.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(439, 62, 86, 21);
			btnListar.setEnabled(false);
			btnListar.addActionListener(this);

			scrListar = new JScrollPane();
			this.add(scrListar);
			scrListar.setBounds(20, 88, 913, 258);

			lblFechas = new JLabel();
			this.add(lblFechas);
			lblFechas.setText("Fechas:");
			lblFechas.setBounds(177, 12, 60, 14);

			tblListar = new JTable();
			scrListar.setViewportView(tblListar);
			tblListar.setModel(modelo2);
			tblListar.addMouseListener(this);
			
			btnFecha1 = new DateButton();
			btnFecha1.setFont(new Font("dialog",0,12));
			this.add(btnFecha1);
			btnFecha1.setBounds(241, 8, 139, 22);
			
			btnFecha2 = new DateButton();
			btnFecha2.setFont(new Font("dialog",0,12));
			this.add(btnFecha2);
			btnFecha2.setBounds(387, 8, 139, 22);

			rdbNCotizacion = new JRadioButton();
			this.add(rdbNCotizacion);
			rdbNCotizacion.setText("NºCotizacion");
			rdbNCotizacion.setBounds(20, 62, 104, 20);
			rdbNCotizacion.addActionListener(this);

			rdbFechas = new JRadioButton();
			this.add(rdbFechas);
			rdbFechas.setText("Fechas");
			rdbFechas.setBounds(129, 63, 69, 18);
			rdbFechas.addActionListener(this);

			rdbCliente = new JRadioButton();
			this.add(rdbCliente);
			rdbCliente.setText("Cliente");
			rdbCliente.setBounds(203, 63, 67, 18);
			rdbCliente.addActionListener(this);
			 
			rdbCel = new JRadioButton();
			this.add(rdbCel);
			rdbCel.setText("CEL");
			rdbCel.setBounds(555, 8, 48, 24);
			rdbCel.addActionListener(this);
		
		
			rdbCye = new JRadioButton();
			this.add(rdbCye);
			rdbCye.setText("CyE");
			rdbCye.setBounds(556, 34, 49, 22);
			rdbCye.addActionListener(this);
			
           

			//listarCot();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void listarCot(){
		
		objBCM.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql=" SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI," +
				"  COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
				"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
				"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
				"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 		        "CLI.NEXA_CLI, CLI.CELA_CLI " +
				" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
				" ON CLI.COD_CLI=COT.COD_CLI " +
				" INNER JOIN tb_vendedores VEN " +
				"  ON VEN.COD_VEN=COT.COD_VEN " +
				" where COT.est_emp=1 " +
				" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		//System.out.println();
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
				BeanBuscaCotiMant objB= new BeanBuscaCotiMant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
						rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22));
				objBCM.adicionar(objB);
				 
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
         for (int i = 0; i < objBCM.tamaño(); i++) {
         	

			Object[] obj={objBCM.obtener(i).getCod_cot(),objBCM.obtener(i).getNom_cli(),objBCM.obtener(i).getCona_cli(),
					objBCM.obtener(i).getFec(),objBCM.obtener(i).getNom_ven(),objBCM.obtener(i).getIde_cot(),
					objBCM.obtener(i).getRef(),objBCM.obtener(i).getEnvio(),objBCM.obtener(i).getEstado(),objBCM.obtener(i).getEst_envio()
			};
			modelo2.addRow(obj);
			
		}
         
	}
	
	public void buscarCoti(int sel){
		
		objBCM.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql=" SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI," +
		"  COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
		"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
		"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
		"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
	    "CLI.NEXA_CLI, CLI.CELA_CLI " +
		" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
		" ON CLI.COD_CLI=COT.COD_CLI " +
		" INNER JOIN tb_vendedores VEN " +
		"  ON VEN.COD_VEN=COT.COD_VEN" +
		" where COT.est_emp=1 " +
		" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		if(sel==0){
			
		}else if(sel==1){//numero cotizacion
			
			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
			" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT ,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
			"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
			"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
			"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
		    "CLI.NEXA_CLI, CLI.CELA_CLI " +
			" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
			" ON CLI.COD_CLI=COT.COD_CLI" +
			" INNER JOIN tb_vendedores VEN " +
			" ON VEN.COD_VEN=COT.COD_VEN " +
			" WHERE COT.COD_COT = '"+txtNCotizacion.getText()+"'  and COT.est_emp=1 " +
			" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		}else if(sel==2){//fechas
			
			
			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
			" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT ,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
			"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
			"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
			"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
		    "CLI.NEXA_CLI, CLI.CELA_CLI " +
			" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
			" ON CLI.COD_CLI=COT.COD_CLI" +
			" INNER JOIN tb_vendedores VEN " + 
			" ON VEN.COD_VEN=COT.COD_VEN " +
			" WHERE COT.FEC_COT BETWEEN  '"+btnFecha1.getText().substring(6, 10)+"-"+btnFecha1.getText().substring(3, 5)+"-"+btnFecha1.getText().substring(0, 2)+
			"' AND '"+btnFecha1.getText().substring(6, 10)+"-"+btnFecha1.getText().substring(3, 5)+"-"+btnFecha1.getText().substring(0, 2)+"' and COT.est_emp=1 "+
			" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		}else{//cliente
		
  
			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
				" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
				"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
				"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
				"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 		        "CLI.NEXA_CLI, CLI.CELA_CLI " +
				" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
				" ON CLI.COD_CLI=COT.COD_CLI" +
				" INNER JOIN tb_vendedores VEN " +
				" ON VEN.COD_VEN=COT.COD_VEN " +
				" WHERE CLI.NOM_CLI LIKE '%"+txtCliente.getText()+"%' and COT.est_emp=1 " +
				" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		}
		
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
				BeanBuscaCotiMant objB= new BeanBuscaCotiMant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
						rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22));
				objBCM.adicionar(objB);
				 
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
         for (int i = 0; i < objBCM.tamaño(); i++) {
			
			Object[] obj={objBCM.obtener(i).getCod_cot(),objBCM.obtener(i).getNom_cli(),objBCM.obtener(i).getCona_cli(),
					objBCM.obtener(i).getFec(),objBCM.obtener(i).getNom_ven(),objBCM.obtener(i).getIde_cot(),
					objBCM.obtener(i).getRef(),objBCM.obtener(i).getEnvio(),objBCM.obtener(i).getEstado(),objBCM.obtener(i).getEst_envio()
			};
			modelo2.addRow(obj);
			
		}
		
	}
    /***************************************METODOS CLIENTES DE CYE******************************************/
	/********************************************************************************************************/
	
     public void listarCotCye(){
		
		objBCM.eliminarTodo();
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql=" SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI," +
				"  COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
				"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
				"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
				"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 		        "CLI.NEXA_CLI, CLI.CELA_CLI " +
				" FROM tb_cotizacion COT INNER JOIN bd_cyeglobalelectric.tb_cliente CLI " +
				" ON CLI.COD_CLI=COT.COD_CLI " +
				" INNER JOIN tb_vendedores VEN " +
				"  ON VEN.COD_VEN=COT.COD_VEN " +
				" where COT.est_emp=2 " +
				" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
		//System.out.println();
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				
				BeanBuscaCotiMant objB= new BeanBuscaCotiMant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
						rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22));
				objBCM.adicionar(objB);
				 
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
         for (int i = 0; i < objBCM.tamaño(); i++) {
         	

			Object[] obj={objBCM.obtener(i).getCod_cot(),objBCM.obtener(i).getNom_cli(),objBCM.obtener(i).getCona_cli(),
					objBCM.obtener(i).getFec(),objBCM.obtener(i).getNom_ven(),objBCM.obtener(i).getIde_cot(),
					objBCM.obtener(i).getRef(),objBCM.obtener(i).getEnvio(),objBCM.obtener(i).getEstado(),objBCM.obtener(i).getEst_envio()
			};
			modelo2.addRow(obj);
			
		}
         
	}
	
     public void buscarCotiCye(int sel){
 		
 		objBCM.eliminarTodo();
 		int n=modelo2.getRowCount();
 		for (int fila=0; fila<n; fila++)
 		modelo2.removeRow(0);
 		AccesoBD objAccesoBD = new AccesoBD();
 		objAccesoBD.crearConexion();
 		String sql=" SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI," +
 		"  COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
 		"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
 		"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
 		"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
        "CLI.NEXA_CLI, CLI.CELA_CLI " +
 		" FROM tb_cotizacion COT INNER JOIN bd_cyeglobalelectric.tb_cliente CLI " +
 		" ON CLI.COD_CLI=COT.COD_CLI " +
 		" INNER JOIN tb_vendedores VEN " +
 		"  ON VEN.COD_VEN=COT.COD_VEN" +
 		" where COT.est_emp=2 " +
 		" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
 		if(sel==0){
 			
 		}else if(sel==1){//numero cotizacion
 			
 			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
 			" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT ,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
 			"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
 			"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
 			"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 	        "CLI.NEXA_CLI, CLI.CELA_CLI " +
 			" FROM tb_cotizacion COT INNER JOIN bd_cyeglobalelectric.tb_cliente CLI " +
 			" ON CLI.COD_CLI=COT.COD_CLI" +
 			" INNER JOIN tb_vendedores VEN " +
 			" ON VEN.COD_VEN=COT.COD_VEN " +
 			" WHERE COT.COD_COT = '"+txtNCotizacion.getText()+"'  and COT.est_emp=2 " +
 			" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
 		}else if(sel==2){//fechas
 			
 			
 			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
 			" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT ,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
 			"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
 			"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
 			"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 	        "CLI.NEXA_CLI, CLI.CELA_CLI " +
 			" FROM tb_cotizacion COT INNER JOIN bd_cyeglobalelectric.tb_cliente CLI " +
 			" ON CLI.COD_CLI=COT.COD_CLI" +
 			" INNER JOIN tb_vendedores VEN " + 
 			" ON VEN.COD_VEN=COT.COD_VEN " +
 			" WHERE COT.FEC_COT BETWEEN  '"+btnFecha1.getText().substring(6, 10)+"-"+btnFecha1.getText().substring(3, 5)+"-"+btnFecha1.getText().substring(0, 2)+
 			"' AND '"+btnFecha1.getText().substring(6, 10)+"-"+btnFecha1.getText().substring(3, 5)+"-"+btnFecha1.getText().substring(0, 2)+"' and COT.est_emp=2 "+
 			" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
 		}else{//cliente
 		
   
 			 sql="SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, " +
 				" COT.FEC_COT , VEN.NOM_VEN , COT.IDE_COT , COT.REF_COT,IF(COT.ESTEN_COT='0','NADA',IF(COT.ESTEN_COT='1','NO ENVIO','SI ENVIO')),IF(ISNULL(COT.COD_COS)=1,'','FINAL'),CLI.AGE_CLI," +
 				"CLI.MAILA_CLI,CLI.MAILB_CLI,CLI.COD_CLI,COT.est_emp,CLI.SEX_CLI, " +
 				"IF(COT.EST_ENVIO=0,'',IF(COT.EST_ENVIO=1,'Si Contesto',IF(COT.EST_ENVIO=2,'No Contesto',''))), " +
 				"CLI.TEL1A_CLI, CLI.TEL2A_CLI,CLI.FAXA_CLI,CLI.RPMA_CLI, "+
 		        "CLI.NEXA_CLI, CLI.CELA_CLI " +
 				" FROM tb_cotizacion COT INNER JOIN bd_cyeglobalelectric.tb_cliente CLI " +
 				" ON CLI.COD_CLI=COT.COD_CLI" +
 				" INNER JOIN tb_vendedores VEN " +
 				" ON VEN.COD_VEN=COT.COD_VEN " +
 				" WHERE CLI.NOM_CLI LIKE '%"+txtCliente.getText()+"%' and COT.est_emp=2 " +
 				" GROUP BY COT.COD_COT , COT.IDE_COT order by cot.cod_cot desc ,cot.ide_cot desc";
 		}
 		
 		System.out.println(sql);
 		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
 		try {
 			while(rs.next()){
 				
 				BeanBuscaCotiMant objB= new BeanBuscaCotiMant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), 
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),
						rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22));
				objBCM.adicionar(objB);
 				 
 				}
 			rs.close();
 		} catch (Exception e1) {
 			e1.printStackTrace();
 		}
 		objAccesoBD.cerrarConexion();
 		
          for (int i = 0; i < objBCM.tamaño(); i++) {
 			
 			Object[] obj={objBCM.obtener(i).getCod_cot(),objBCM.obtener(i).getNom_cli(),objBCM.obtener(i).getCona_cli(),
 					objBCM.obtener(i).getFec(),objBCM.obtener(i).getNom_ven(),objBCM.obtener(i).getIde_cot(),
 					objBCM.obtener(i).getRef(),objBCM.obtener(i).getEnvio(),objBCM.obtener(i).getEstado(),objBCM.obtener(i).getEst_envio()
 			};
 			modelo2.addRow(obj);
 			
 		}
 		
 	}
     
	
	/************************************************FIN*****************************************************/
	/********************************************************************************************************/
	
	public void cargarlistaCot(){
		//Obtener fila seleccionada de la tabla
		int fila = tblListar.getSelectedRow();
		//Cargar los datos de la fila seleccionada al panel de datos

		// public static String  COD_COT, NOM_CLI, CONA_CLI, FEC_COT, VEN, IDE_COT;
		
	  COD_COT=objBCM.obtener(fila).getCod_cot();
	  NOM_CLI=objBCM.obtener(fila).getNom_cli();
	  CONA_CLI=objBCM.obtener(fila).getCona_cli();
	  FEC_COT=objBCM.obtener(fila).getFec();
	  VEN=objBCM.obtener(fila).getNom_ven();
	  IDE_COT=objBCM.obtener(fila).getIde_cot();
	  REF_COT=objBCM.obtener(fila).getRef();
	  AGE_CLI=objBCM.obtener(fila).getAge_cli();
	  MAILA_CLI=objBCM.obtener(fila).getMaila_cli();
	  MAILB_CLI=objBCM.obtener(fila).getMailb_cli();
	  COD_CLI=objBCM.obtener(fila).getCod_cli();
	  EST_EMP=objBCM.obtener(fila).getEst_emp();
	  SEX_CLI=objBCM.obtener(fila).getSex_cli();
	  codicli=Integer.parseInt(COD_CLI);
	  TEL1=objBCM.obtener(fila).getTel1();
      TEL2=objBCM.obtener(fila).getTel2();
      FAX=objBCM.obtener(fila).getFax();
      RPM=objBCM.obtener(fila).getRpm();
      NEXTEL=objBCM.obtener(fila).getNextel();
      CEL=objBCM.obtener(fila).getCel();
	  
	}
	
	public void frenarMailsAuto(){
		
		AccesoBD objA= new AccesoBD();
		
		objA.crearConexion();
		String sql="UPDATE TB_ENVIOMAILS SET EST_MAIL = 1, EST_MAIL2 = 1 " +
				   "WHERE date(fec_pemail)=curdate() and cod_cli='"+COD_CLI+"';" ;
				
		System.out.println(sql);
		objGUI.mostrarAviso("Se Cancelaron los Correos Automaticos");
		objA.ejecutarActualizacion(sql);
		
		objA.cerrarConexion();
		
	}
	
    public void cambiarEstado(String est){
		
		AccesoBD objA= new AccesoBD();
		
		objA.crearConexion();
		String sql="UPDATE tb_cotizacion SET EST_ENVIO ='"+est+"' " +
				   "WHERE cod_cot='"+COD_COT+"';" ;
				
		System.out.println(sql);
		System.out.println("Se modifico el estado de Envio");
		objA.ejecutarActualizacion(sql);
		
		objA.cerrarConexion();
		
	}
	
	/***************************************************************************************************************/
	public void agregarEnvioMailsCli(){
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
			String insertarPregunta="INSERT INTO TB_ENVIOMAILSCLIENTE VALUES("+null+",'"+VEN+"','"
			+COD_CLI+"','"+CONA_CLI+"','"+SEX_CLI+"','"+MAILA_CLI+"','"+MAILB_CLI+"',CURDATE(),'0')";
			System.out.println(insertarPregunta);

			int op= objAccesoBD.ejecutarActualizacion(insertarPregunta);
			//System.out.println(insertarPregunta);
			if(op==0){
				System.out.println("Hubo un ERROR al Ingresar\nlos datos");
			}else{
				System.out.println("Se Ingreso Correctamente el EnvioMail");
			}
		objAccesoBD.cerrarConexion();
	}
		
	/***********************************************/
	
	
	int selecionado=0;
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==rdbNCotizacion){
			rdbNCotizacion.setSelected(true);
			rdbFechas.setSelected(false);
			rdbCliente.setSelected(false);
			selecionado=1;
		} 
		if(e.getSource()==rdbFechas){
			rdbNCotizacion.setSelected(false);
			rdbFechas.setSelected(true);
			rdbCliente.setSelected(false);
			selecionado=2;
		}
		if(e.getSource()==rdbCliente){
			rdbCliente.setSelected(true);
			rdbNCotizacion.setSelected(false);
			rdbFechas.setSelected(false);
			selecionado=3;
		}
		if(e.getSource()==btnBuscar){
			
			if(estado==1){
				buscarCoti(selecionado);
			}else if(estado==2){
				buscarCotiCye(selecionado);
			}
			
		}
		if(e.getSource()==btnListar){
			
			if(estado==1){
				listarCot();
			}else if(estado==2){
				listarCotCye();
			}
			
			
		}
		if(e.getSource()==rdbCel){
			//System.out.println("11");
			rdbCye.setSelected(false);
			btnListar.setEnabled(true);
			estado=1;
		}
		
        if(e.getSource()==rdbCye){
        	//System.out.println("22");
			rdbCel.setSelected(false);
			btnListar.setEnabled(true);
		    estado=2;
		}

		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource()==txtCliente){
			buscarCoti(selecionado);
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
	public void mousePressed(MouseEvent e) {
		
		if(e.getSource()==tblListar){
			
			MouseEvent evento=e;
			if(evento.getClickCount()==1){
				cargarlistaCot();
			    est=1;
			    System.out.println("ESTADO:"+est);
			    
			    if(tblListar.getSelectedColumn()==9){
			    	
			    	String[] botones = {"Si","No"};//Esto es el nombre
			         int showOptionDialog = JOptionPane.showOptionDialog(
			     		   this,                             			
			     		   objLlamada,                                    
			     		   "Contesto Llamada", 		
			     		   0,          						        
			     		   -1,            					
			     		   null,                                       
			     		   botones,
			     		   "Cerrar"
			     		                                  	
			     	);
			         if(showOptionDialog==0){
			        	//Aca entra al boton SI
			        	 cambiarEstado("1");
			        	 frenarMailsAuto();
			        	 listarCot();
			        	 
			         }
			         else if(showOptionDialog==1){
			        	 //Aca entra al boton NO
			        	 
			        	 if(codicli!=0){
			        		 cambiarEstado("2");
			        		 agregarEnvioMailsCli();
			        		 listarCot();
			 			
			 			}else{
			 				objGUI.mostrarAviso("Seleccione un Cliente");
			 			}
			        	 
			         }else{
			        	 //CERRAR
			        	 
			         }
			    	
			    }
			}
			if(evento.getClickCount()==2){
			
				/*TranCotizacionAutMant objMant= new TranCotizacionAutMant();
				objMenu.jDesktopPane1.add(objMant);*/
				
			}
			
		}
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
