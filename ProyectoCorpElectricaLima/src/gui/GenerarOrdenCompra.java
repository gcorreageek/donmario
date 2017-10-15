package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import miLib.GUI;
import miLib.PasarExcelOC;
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
public class GenerarOrdenCompra extends JInternalFrame implements ActionListener, MouseListener {
	private JPanel pnlArriba;
	private JPanel pnlAbajo;
	private JButton btnListar;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton btnBuscar;
	private JTextField txtNCotizacion;
	private JLabel lblNCotizacion;
	private JPanel pnlCentro;
	Object[] arregloCadenas;
	Object[][] arregloObjetos;
	public static Object[] objPasarEnviar;
	//Globales
	public static String cod_cot;
	//Clases
	GUI objGUI;
	EnviarOrdenCompraProveedor objEnviarOC;
	MenuPrincipal objMenu;
	String titulo2[]={"CodCot","NomCli","ConCli","Fecha","Ven","IdeCot","Estado"};
	ArrayList<BeanEnvioOC> arrayConfig2;
	
	DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	public GenerarOrdenCompra(){

		super("Generar Orden Compra", true, true, true, true);
		try {
			
			this.setPreferredSize(new java.awt.Dimension(924, 446));
			this.setBounds(0, 0, 924, 446);

			pnlArriba = new JPanel();
			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			pnlArriba.setLayout(null);
			pnlArriba.setPreferredSize(new java.awt.Dimension(709, 44));
			pnlArriba.setLayout(null);

			lblNCotizacion = new JLabel();
			pnlArriba.add(lblNCotizacion);
			lblNCotizacion.setText("N.Cotizacion:");
			lblNCotizacion.setBounds(12, 12, 88, 16);

			txtNCotizacion = new JTextField();
			pnlArriba.add(txtNCotizacion);
			txtNCotizacion.setBounds(100, 9, 369, 23);
			txtNCotizacion.addActionListener(this);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(481, 9, 76, 23);
			btnBuscar.addActionListener(this);

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(565, 9, 72, 23);
			btnListar.addActionListener(this);

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);

			pnlCentro = new JPanel();
			GridLayout pnlCentroLayout = new GridLayout(1, 1);
			pnlCentroLayout.setHgap(5);
			pnlCentroLayout.setVgap(5);
			pnlCentroLayout.setColumns(1);
			pnlCentro.setLayout(pnlCentroLayout);
			getContentPane().add(pnlCentro, BorderLayout.CENTER);

			jScrollPane1 = new JScrollPane();
			pnlCentro.add(jScrollPane1);

			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(modelo2);
			jTable1.addMouseListener(this);
			
			listarCot();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public  Double formato(double numero) {
		// declara objeto para formato con decimales
		String miformato;

		Integer decimales=3;
		// establece el numero de decimales
		miformato=String.format(Locale.US,"%1."+decimales+"f",numero);
		
		// devuelve numero con formato establecido
		return Double.parseDouble(miformato);
	}
	public void listarCot(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);

		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql=" SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI," +
		"  COT.FEC_COT , VEN.NOM_VEN ,MAX(COT.IDE_COT)  ,IF(MAX(COT.ESTOC_COT)=0,'Nada',IF(MAX(COT.ESTOC_COT)=1,'NO OC','SI OC'))  " +
		" FROM tb_cotizacion COT INNER JOIN tb_cliente CLI " +
		" ON CLI.COD_CLI=COT.COD_CLI " +
		" INNER JOIN tb_vendedores VEN " +
		"  ON VEN.COD_VEN=COT.COD_VEN " +
		" WHERE ISNULL(COT.COD_COS)=0 and COT.fec_cot>='2011-05-20' " +
		" GROUP BY COT.COD_COT , COT.IDE_COT  ORDER BY  COT.COD_COT DESC";

		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				int codcot=Integer.parseInt(rs.getString(1));
				String nomcli=rs.getString(2);
				String contactocli=rs.getString(3);
				String feccot=rs.getString(4);
				String nomven=rs.getString(5);
				int idcot=Integer.parseInt(rs.getString(6));
				String ref=rs.getString(7);
				Object obj[]={codcot,nomcli,
						contactocli,feccot,nomven,
						idcot,ref
				};
						
				modelo2.addRow(obj);
				 
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
	}
	public List<String> tamCotizacion(){
		List<String> array;
		array= new ArrayList<String>();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT COT.COD_COT FROM tb_cotizacion COT " +
		"  GROUP BY COT.COD_COT ORDER BY  COT.COD_COT DESC";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		try {
			while(rs.next()){
				array.add(rs.getString(1));
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		return array;
		
	}
	
	public void buscarCot(){
		int n=modelo2.getRowCount();
		for (int fila=0; fila<n; fila++)
		modelo2.removeRow(0);
		
		String cod_cot=txtNCotizacion.getText();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="  SELECT COT.COD_COT , CLI.NOM_CLI ,CLI.CONA_CLI, "+
        "  COT.FEC_COT , VEN.NOM_VEN ,MAX(COT.IDE_COT)  , IF(COT.ESTOC_COT=0,'Nada',IF(COT.ESTOC_COT=1,'NO OC','SI OC')) "+
        "  FROM tb_cotizacion COT INNER JOIN tb_cliente CLI "+
        "  ON CLI.COD_CLI=COT.COD_CLI "+
        "  INNER JOIN tb_vendedores VEN "+
        "  ON VEN.COD_VEN=COT.COD_VEN "+
        "  WHERE ISNULL(COT.COD_COS)=0 AND COT.COD_COT='"+cod_cot+"'  AND  COT.IDE_COT= (SELECT  MAX(IDE_COT) FROM tb_cotizacion WHERE COD_COT='"+cod_cot+"') "+
        "  GROUP BY COT.COD_COT , COT.IDE_COT  ORDER BY  COT.COD_COT DESC";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				int codcot=Integer.parseInt(rs.getString(1));
				String nomcli=rs.getString(2);
				String contactocli=rs.getString(3);
				String feccot=rs.getString(4);
				String nomven=rs.getString(5);
				int idcot=Integer.parseInt(rs.getString(6));
				String ref=rs.getString(7);
				Object obj[]={codcot,nomcli,
						contactocli,feccot,nomven,
						idcot,ref
				};
						
				modelo2.addRow(obj);
				 
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();
		
	}
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
	

	public Integer numeroProveedores(){
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		Integer c=0;
		String sql="SELECT " +
				"  * " +
				" FROM tb_cotizacion where cod_cot='"+cod_cot+"'and ide_cot= "+
		" (select max(ide_cot) from tb_cotizacion where cod_cot='"+cod_cot+"') group by  cod_prove;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {while(rs.next()){c=c+1;}rs.close();} 
		catch (Exception e1){e1.printStackTrace();}
		objAccesoBD.cerrarConexion();
		return c; 	
		}
	public Object[] arreg(){
		Object[] arrayg= new Object[arregloCodProvee().length];
		return arrayg;
	}
	public Object[] arregloCodProvee(){
		//Se crea el arreglo con el Numero de Proveedores
		Object[] arrayProvee= new Object[numeroProveedores()];

		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT " +
		"  * " +
		" FROM tb_cotizacion where cod_cot='"+cod_cot+"'and ide_cot= "+
		" (select max(ide_cot) from tb_cotizacion where cod_cot='"+cod_cot+"') group by  cod_prove;";
		
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			int c=-1;
			while(rs.next()){c=c+1;
			arrayProvee[c]=rs.getString("cod_prove");
			}
		rs.close();}
		catch (Exception e1){e1.printStackTrace();}
		objAccesoBD.cerrarConexion();
		return arrayProvee;}
	
	public Integer maximoCodOrdenCompra(){
		Integer cod_oc=null;
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT IFNULL(MAX(COD_OC),0) FROM tb_ordencompra  ";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				cod_oc=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cod_oc;
	}
	
	public Integer ingresoOrdenCompra(){
		Integer valor=0;
		int cod_oc=maximoCodOrdenCompra();
		//Esto es una prueba porque en realidad
		//Se va aver cual es el codigo maximo de las ordenes de compras
		Object[] obj=arregloCodProvee();
		for (int i = 0; i < arregloCodProvee().length; i++) {
			cod_oc=cod_oc+1;
			AccesoBD objAccesoBD = new AccesoBD();
			objAccesoBD.crearConexion();
		
			String sql= "Select cot.cod_cot, cot.num_item,cot.cod_prove,cot.cod_prod,cot.cod_mar, "+
			" cot.cod_umed,cot.cod_cli,cot.ide_cot " +
			" FROM tb_cotizacion cot " +
			" inner join tb_proveprodmarumed1 det " +
			"on det.cod_prove=cot.cod_prove and det.cod_prod=cot.cod_prod and det.cod_mar=cot.cod_mar and det.cod_umed=cot.cod_umed " +
			"inner join tb_producto prod " +
			"on prod.cod_prod=det.cod_prod " +
			"inner join tb_proveedor prove " +
			"on prove.cod_prove=det.cod_prove " +
			"inner join tb_marcas mar " +
			"on mar.cod_mar=det.cod_mar " +
			"inner join tb_umed umed " +
			" on umed.cod_umed=det.cod_umed" +
			" where cod_cot='"+cod_cot+"' and ide_cot= " +
			"(select max(ide_cot) from tb_cotizacion where cod_cot='"+cod_cot+"') and cot.cod_prove='"+obj[i]+"' "; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " ;

			ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
			try {
				while(rs.next()){
				//Ingreso de Orden de Compra, pero
				//nosotros le ponemos cod_oc
				AccesoBD objAccesoBD2 = new AccesoBD();
				objAccesoBD2.crearConexion();
				//cod_cot, num_item, cod_prove, cod_prod, cod_mar, cod_umed, cod_cli, ide_cot, cod_oc, fec_oc, esten_oc
				String guardarCotizacion="INSERT INTO TB_ORDENCOMPRA VALUES('"+rs.getString(1)+"','"+
				rs.getString(2)+"','"+rs.getString(3)+"','"+rs.getString(4)+"','"+
				rs.getString(5)+"','"+rs.getString(6)+"','"+
				rs.getString(7)+"','"+rs.getString(8)+"','"+cod_oc+"',concat(curdate(),' ',curtime()),'"+"0"+"');";
					
				try {
				int op= objAccesoBD2.ejecutarActualizacion(guardarCotizacion);
				valor=1;
			    } catch (Exception e) {
			    	valor=0;
				objGUI.mostrarAviso("Hubo un ERROR al Ingresar\n la Orden de Compra:"+cod_oc);
			    }finally{
			    	if(valor==0){
			    		valor=0;
			    	}else{
			    		valor=1;
			    	}
			    	
			    }
				objAccesoBD2.cerrarConexion();
				
				}
				rs.close();
				} 
			catch (Exception e1){e1.printStackTrace();}
			objAccesoBD.cerrarConexion();



}
		return valor;
		
		
		
		
		
	}

	public void modificaCotizacion(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="UPDATE tb_cotizacion SET ESTOC_COT='2' " +
		" WHERE COD_cot='"+cod_cot+"' and ide_cot=(select max(ide_cot) from tb_ordencompra where cod_cot='"+cod_cot+"');";
		System.out.println(sql);
		int op= objAccesoBD.ejecutarActualizacion(sql);
		if(op==0){
			objGUI.mostrarAviso("ERROR AL MODIFICAR LA COTIZACION");}
		objAccesoBD.cerrarConexion();	
			
	}
	public boolean verificar(String cod_cot){
		String codcot=cod_cot;
		boolean valor=false;
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT ESTOC_COT FROM tb_cotizacion WHERE COD_COT='"+codcot+"' AND " +
				" IDE_COT=(SELECT MAX(IDE_COT) FROM tb_cotizacion WHERE COD_COT='"+codcot+"');";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				Integer val=rs.getInt(1);
				if(val==0)
					valor=true;
				else if(val==1)
					valor=true;
				else
					valor=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(valor);
		return valor;
	}
	
	/*public void datosProveedor(){
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT ESTOC_COT FROM tb_cotizacion WHERE COD_COT='"+codcot+"' AND " +
				" IDE_COT=(SELECT MAX(IDE_COT) FROM tb_cotizacion WHERE COD_COT='"+codcot+"');";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		
		
		
	}*/
	/*public void pasarExcel(){
		arregloCadenas[0]=" 1223-2007";
		arregloCadenas[1]="15 de Junio del 2008";
		arregloCadenas[2]="TECSUR";
		arregloCadenas[3]="DANIEL MEGO";
		arregloCadenas[4]="MZ BBB2 LT 40 LA FLORESTA DE PRO";
		arregloCadenas[5]="TEL:540-2606";
		arregloCadenas[6]="GCORREACAJA@HOTMAIL.COM";
		arregloCadenas[7]="SOLES";
		arregloCadenas[8]="BCP -  $  1911720012168";
		arregloCadenas[9]="BCP -  S/ 1911708290054";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 7; j++) {
				if(j==0){
				arregloObjetos[i][j]="SOLES";	
				}else if(j==1){
				arregloObjetos[i][j]="10";	//cantidad
				}else if(j==2){
				arregloObjetos[i][j]="UND";	
				}else if(j==3){
				arregloObjetos[i][j]="CABLE DE ACERO";		
				}else if(j==4){
				arregloObjetos[i][j]="3M";		
				}else if(j==5){
				arregloObjetos[i][j]=45.5;		
				}else{
				arregloObjetos[i][j]=0;	//CON IGV
				}	
			}
		}
		
	/*	for (int i = 0; i < objServletCotVarios.tamaño(); i++) {
			
			BeanCotizacionVarios objCotVarios=objServletCotVarios.obtener(i);
			arregloCadenas[0]=objCliente.getNomcli().toString().toUpperCase();
			arregloCadenas[1]=objCliente.getContacto1cli().toString().toUpperCase();
			arregloCadenas[2]=objCliente.getDireccion1cli().toString(S).toUpperCase();
			String rpm=objCliente.getRpm1cli(),nex=objCliente.getNextel(),rpmnextel="";
			if(rpm.equals("0")||rpm.equals("")||rpm.equals(" ")){
				rpmnextel=" NEX:"+nex;
			}else{
				rpmnextel=" RPM:"+rpm;
			}
			arregloCadenas[3]="TEL:"+objCliente.getTelefono1c()+rpmnextel+" CEL:"+objCliente.getCel1cli()+" E-MAIL:"+objCliente.getEmail1cli();
			arregloCadenas[4]=objGlobal.COD_VEN;
			arregloCadenas[5]=objCliente.getTipocli().toString().toUpperCase();
			arregloCadenas[6]=objCliente.getCodcli();
			arregloCadenas[7]="COTIZACION Nº"+objCotVarios.getCodcot()+"-"+ide_cot;
			arregloCadenas[8]=objFecha.fechaActual();
			arregloCadenas[9]=Double.parseDouble(""+tipoCambioVenta());
			arregloCadenas[10]=ref.toString().toUpperCase();
				item=item+1;
			  for (int j = 0; j < 9; j++) {
					if(j==0){
						//System.out.println("esto sale poseacso:"+objCotVarios.getCancot());
					arregloObjetos[item][j]=Integer.parseInt(""+objCotVarios.getCancot());	
					}else if(j==1){
					arregloObjetos[item][j]=objCotVarios.getUmedprod().toString().toUpperCase();	
					}else if(j==2){
					arregloObjetos[item][j]=objCotVarios.getNomprodalt().toString().toUpperCase();	
					}else if(j==3){
					arregloObjetos[item][j]=objCotVarios.getNommar().toString().toUpperCase();		
					}else if(j==4){
						
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 5));		
					}else if(j==5){
					arregloObjetos[item][j]=Double.parseDouble(""+modelo2.getValueAt(i, 7));			
					}else if(j==6){
					arregloObjetos[item][j]=""+modelo2.getValueAt(i, 10).toString();	
					}else if(j==7){
					arregloObjetos[item][j]=""+modelo2.getValueAt(i, 12).toString();	
					}else{
					arregloObjetos[item][j]=""+objCotVarios.getCodprove().toUpperCase();		
					}	
				}
			}*/
	/*}*/
	public Integer numeroProductoXproveedor(String cod_cot,String ide_cot){
	  /*SELECT COUNT(*) FROM TB_ORDENCOMPRA WHERE COD_COT='2817' AND COD_OC='1';*/
	  Integer cantid=0;
	  AccesoBD objAccesoBD=  new AccesoBD();
	  objAccesoBD.crearConexion();
	  String sql="SELECT COUNT(*) FROM TB_ORDENCOMPRA WHERE COD_COT='"+cod_cot+"' AND COD_OC='"+ide_cot+"';";

		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				cantid=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantid;
	}
	
	public Double tipoCambioCompra(){
		Double cam = null;
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		String sql="(SELECT COMPRA FROM tb_cambio "+
				"WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))";
		ResultSet res=objA.ejecutarConsulta(sql);
	
		try {
			if(res.next()){
				cam=res.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cam;
	}
	public Double tipoCambioVenta(){
		Double cam = null;
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		String sql="(SELECT venta FROM tb_cambio "+
				"WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))";
		ResultSet res=objA.ejecutarConsulta(sql);
	
		try {
			if(res.next()){
				cam=res.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cam;
	}
	public Integer ideCotXcodCotYcodOc(Integer codCot,Integer codOc){
		Integer ide_cot=null;
		AccesoBD objA = new AccesoBD();
		objA.crearConexion();
		String sql="SELECT IDE_COT FROM TB_ORDENCOMPRA WHERE COD_COT='"+codCot+"' AND COD_OC='"+codOc+"';";
		ResultSet rs=objA.ejecutarConsulta(sql);
		try {
			if(rs.next()){
				ide_cot=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		objA.cerrarConexion();
		return ide_cot;
	}
	
	public Object[] metodoAbrirExcel(){
		
		Object[] arregloPasar= new Object[2];
			
		//AQUI DEBE DE HABER UN FOR QUE HAGA QUE
		//SALGA LOS EXCEL X PROVEEDOR
		List<String> array=NumeroDeProveedores(cod_cot);
		String[] arrayRuta= new String[array.size()];
		for (int x = 0; x < array.size(); x++) {
			arregloCadenas= new Object[15];
			arregloObjetos= new Object[numeroProductoXproveedor(cod_cot, array.get(x))][7];
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT OC.COD_OC,CURDATE(),PROVE.NOM_PROVE ,PROVE.PER_PROVE,PROVE.DIR_PROVE, "+
		" CONCAT('TEL1:',PROVE.TEL1_PROVE,',RPM:',PROVE.RPM_PROVE,',NEX:',PROVE.NEX_PROVE,',CEL:',PROVE.CEL_PROVE),PROVE.MAIL_PROVE,IF(DET.MON_DET='$','DOLARES','SOLES') 'MON_DET', "+
			" CONCAT('$  -',PROVE.NCUD_PROVE),CONCAT('S/.-',PROVE.NCUS_PROVE), "+
			"  COT.CAN_COT,UMED.NOM_UMED,PROD.NOM_PROD,MAR.NOM_MAR,DET.COS_DET,DET.IGV_DET,PROVE.BAN_PROVE, PROVE.CONDI_PROVE, PROVE.LUGENTRE_PROVE, PROVE.TIEMPENTRE_PROVE   FROM TB_ORDENCOMPRA OC  "+
			" INNER JOIN tb_cotizacion COT "+
			" ON COT.COD_COT=OC.COD_COT AND COT.IDE_COT=OC.IDE_COT AND COT.NUM_ITEM=OC.NUM_ITEM AND COT.COD_PROVE=OC.COD_PROVE "+
			" AND COT.COD_PROD=OC.COD_PROD AND COT.COD_MAR=OC.COD_MAR AND COT.COD_UMED=OC.COD_UMED AND COT.COD_CLI=OC.COD_CLI "+
			" INNER JOIN tb_proveprodmarumed1 DET  "+
			" ON DET.COD_PROVE=OC.COD_PROVE AND DET.COD_PROD=OC.COD_PROD AND DET.COD_MAR=OC.COD_MAR AND DET.COD_UMED=OC.COD_UMED "+
			" INNER JOIN tb_proveedor PROVE "+
			" ON PROVE.COD_PROVE=OC.COD_PROVE "+
			" INNER JOIN tb_producto PROD "+
			" ON PROD.COD_PROD=OC.COD_PROD "+
			" INNER JOIN tb_marcas MAR "+
			" ON MAR.COD_MAR=OC.COD_MAR "+
			" INNER JOIN tb_umed UMED "+
			" ON UMED.COD_UMED=OC.COD_UMED "+
			" INNER JOIN tb_cliente CLI "+
			" ON CLI.COD_CLI=OC.COD_CLI "+
			" WHERE OC.COD_COT='"+cod_cot+"' and OC.cod_oc='"+array.get(x)+"' "; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det ;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);	
		try {
			String mon = null;//'DOLARES','SOLES'
			String igv = null;//'0'--->CON IGV,'1'--->MAS IGV
			final Double compra=tipoCambioCompra();
			final Double venta=tipoCambioVenta();
			Integer i=-1;
			
			while(rs.next()){
				
				//System.out.println("CODIGO.OC:"+rs.getString(1)+"  "+"FECHA:"+rs.getString(2));
				
				i=i+1;
				
				if(i==0){
				Integer ideCot=ideCotXcodCotYcodOc(Integer.parseInt(cod_cot),Integer.parseInt(rs.getString(1)) );
				arregloCadenas[0]=rs.getString(1);//CODIGO OC
				arregloCadenas[1]=rs.getString(2);//FECHA
				arregloCadenas[2]=rs.getString(3);//NOM_PROVE
				arregloCadenas[3]=rs.getString(4);//personal
				arregloCadenas[4]=rs.getString(5);//dir
				arregloCadenas[5]=rs.getString(6);//tel1
				arregloCadenas[6]=rs.getString(7);//mail
				arregloCadenas[7]=rs.getString(8);//Moneda
				arregloCadenas[8]=rs.getString(9);//ncuenta en dolares
				arregloCadenas[9]=rs.getString(10);	//ncuenta en soles
				arregloCadenas[10]=cod_cot+"-"+ideCot;	//ncuenta en soles
				arregloCadenas[11]=rs.getString(17);//BANCO
				arregloCadenas[12]=rs.getString(18);
				arregloCadenas[13]=rs.getString(19);
				arregloCadenas[14]=rs.getString(20);
				
				arregloObjetos[i][0]=arregloCadenas[7];	
				arregloObjetos[i][1]=rs.getString(11);	//cantidad
				arregloObjetos[i][2]=rs.getString(12);	
				arregloObjetos[i][3]=rs.getString(13);		
				arregloObjetos[i][4]=rs.getString(14);
				arregloObjetos[i][5]=rs.getString(15);	//Costo	
				arregloObjetos[i][6]=rs.getString(16);	//CON IGV	
				
				mon=arregloCadenas[7].toString();//'DOLARES','SOLES'
				igv=arregloObjetos[0][6].toString();//'0'--->CON IGV,'1'--->MAS IGV
				
				
				}else{
					if(i!=0){
					//System.out.println("Moneda:"+mon+","+"Igv:"+igv);
					Double costo;
					arregloCadenas[0]=rs.getString(1);
					arregloCadenas[1]=rs.getString(2);
					arregloCadenas[2]=rs.getString(3);
					arregloCadenas[3]=rs.getString(4);
					arregloCadenas[4]=rs.getString(5);
					arregloCadenas[5]=rs.getString(6);
					arregloCadenas[6]=rs.getString(7);
					arregloCadenas[7]=rs.getString(8);//Moneda
					arregloCadenas[8]=rs.getString(9);
					arregloCadenas[9]=rs.getString(10);		
						
					arregloObjetos[i][0]=arregloCadenas[7];	
					arregloObjetos[i][1]=rs.getString(11);//cantidad
					arregloObjetos[i][2]=rs.getString(12);	
					arregloObjetos[i][3]=rs.getString(13);		
					arregloObjetos[i][4]=rs.getString(14);
					costo=Double.parseDouble(""+rs.getString(15));
					//arregloObjetos[i][5]=rs.getString(15);	//Costo	
					arregloObjetos[i][6]=rs.getString(16);	//CON IGV	
					//System.out.println("El primer Costo "+i+":"+costo);
					//System.out.println(arregloCadenas[7]+"="+mon);
						if(!arregloCadenas[7].equals(mon)){//Aqui nos damos cuenta que la moneda es distinta
							if(mon.equals("DOLARES")){//Chekeamos que tipo de Moneda es
								costo=formato(Double.parseDouble(""+costo)/compra);
							}else{
								costo=formato(Double.parseDouble(""+costo)*venta);
							}
						}else{
							//System.out.println("melas 1");
						}
					//System.out.println("El segundo Costo "+i+":"+costo);
						if(!arregloObjetos[i][6].equals(igv)){
							//'0'--->CON IGV,'1'--->MAS IGV
							if(igv.equals("0")){
								costo=formato(Double.parseDouble(""+costo)*1.18);
							}else{
								costo=formato(Double.parseDouble(""+costo)/1.18);
							}
						}else{
							//System.out.println("melas 2");
						}
					//System.out.println("El tercer Costo "+i+":"+costo);
						arregloObjetos[i][5]=costo;

					}
				}
			  
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		try {
			PasarExcelOC objPasarOC= new PasarExcelOC();
			
			
			String ruta=objPasarOC.crearExcel(arregloCadenas,arregloObjetos);
			arrayRuta[x]=ruta;
			
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		arregloPasar[0]=arrayRuta;//ArregloRutas
		arregloPasar[1]=array;//ArregloProveedoresCod
		return arregloPasar;
		
	}
	
	
	public List<String> NumeroDeProveedores(String cod_cot){
		List<String> array;
		array= new ArrayList<String>();
		String codcot=cod_cot;
		/*SELECT * FROM tb_ordencompra WHERE COD_COT='2817' GROUP BY COD_OC  ORDER BY COD_OC;*/
		AccesoBD objAccesoBD=  new AccesoBD();
		objAccesoBD.crearConexion();
		String sql="SELECT OC.cod_cot,OC.num_item,OC.cod_prove,OC.cod_prod,OC.cod_mar,OC.cod_umed, "+
                   "OC.cod_cli,OC.ide_cot,OC.cod_oc,OC.fec_oc,OC.esten_oc  "+
				   "FROM tb_ordencompra  OC   "+
				   "INNER JOIN tb_cotizacion COT  "+
				   "ON OC.cod_cot = COT.cod_cot AND OC.num_item = COT.num_item "+
				   "AND OC.cod_prove = COT.cod_prove  "+
				   "AND OC.cod_prod = COT.cod_prod AND OC.cod_mar = COT.cod_mar "+
				   "AND OC.cod_umed = COT.cod_umed AND OC.cod_cli = COT.cod_cli "+
				   "AND OC.ide_cot = COT.ide_cot  "+
				   "INNER JOIN tb_proveprodmarumed1 DET  "+
				   "ON DET.COD_PROVE=OC.COD_PROVE AND DET.COD_PROD=OC.COD_PROD AND DET.COD_MAR=OC.COD_MAR  "+
				   "AND DET.COD_UMED=OC.COD_UMED  "+
				   "WHERE OC.COD_COT='"+codcot+"' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det  "+
			       "GROUP BY OC.COD_OC  ORDER BY OC.COD_OC;";
			
			
		//"SELECT * FROM tb_ordencompra WHERE COD_COT='"+codcot+"' GROUP BY COD_OC  ORDER BY COD_OC;";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				array.add(rs.getString("cod_oc"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	public boolean pasarIdeCot(Integer codCot){
		boolean ideCot = false;
		AccesoBD objA = new AccesoBD();
		
		objA.crearConexion();
		String sql="select esten_OC from tb_ORDENCOMPRA   WHERE COD_COT='"+codCot+"' "+
                   "AND  IDE_COT=(SELECT MAX(IDE_COT) FROM tb_cotizacion WHERE COD_COT='"+codCot+"');";
		System.out.println(sql);
		ResultSet res=objA.ejecutarConsulta(sql);
		try {
			if(res.next()){
				if(res.getString(1).equals("0")){
					ideCot=false;
				}else if(res.getString(1).equals("1")){
					ideCot=false;
				}else{
					ideCot=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objA.cerrarConexion();
		return ideCot;
		
		
		
	}
	public void cargarCOD_OC(){
		int valor;
		int fila = jTable1.getSelectedRow();
		cod_cot=(modelo2.getValueAt(fila, 0)+" ").trim();
		if(verificar(cod_cot)){
		try {
			 valor=ingresoOrdenCompra();
		} catch (Exception e) {
			valor=0;
		}
		System.out.println("El valor:"+valor);
		if(valor!=0){
			modificaCotizacion();	
		}	
		}else
			System.out.println("YA ESTA INGRESADA LA ORDEN DE COMPRA");
			//objGUI.mostrarAviso("Ya esta Ingresada la Orden de Compra!");
		objPasarEnviar=metodoAbrirExcel();
		
		if(pasarIdeCot(Integer.parseInt(cod_cot))){
			objGUI.mostrarAviso("YA ESTAN ENVIADAS LAS ORDENES DE COMPRA");
			System.out.println("YA ESTAN ENVIADAS LAS ORDENES DE COMPRA");
		}else{
	
			System.out.println("NO ESTAN ENVIADAS");
			
			
		}
	
			if(objEnviarOC==null||objEnviarOC.isClosed()){
			//objGUI.mostrarAviso("En Construccion.....!!");
			objEnviarOC= new EnviarOrdenCompraProveedor();
			objEnviarOC.setVisible(true);
			//arrayConfig2=objEnviarOC.arrayConfig;
			//objEnviarOC.enviarCorreos(arrayConfig2);
		
			objMenu.jDesktopPane1.add(objEnviarOC);
		try{this.setClosed(true);
			}catch(PropertyVetoException e1){e1.printStackTrace();}
		/*try {
			objEnviarOC.setSelected(true);
			}
		catch (java.beans.PropertyVetoException ee) {}*/
		}
		
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(btnBuscar==e.getSource()){
			buscarCot();
		}
		if(e.getSource()==btnListar){
			listarCot();
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
			MouseEvent evento=e;
			
			if(evento.getSource()==jTable1){
				
				if(evento.getClickCount()==2){
					cargarCOD_OC();
					setVisible(false);
					//ELIMINAR TODOS LOS SERVLETS
					
					
					try {
						this.setClosed(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
