package miLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import servlet.ServletCargarPrecios;
import beans.BeanExcel;


public class ServletExcel {
	//TranCotizacionAutomatica objTranAut;
	 ServletCargarPrecios objCPrecios= new ServletCargarPrecios();
	 List<BeanExcel> array;
	 private  String codcli="0",
	 nomcli="",tipcli,ruccli,lugcli,conacli="",tel1acli,tel2acli,rpmacli,nexacli,celacli,mailacli;
	 /*SELECT COD_CLI,NOM_CLI,RUC_CLI,LUG_CLI,CONA_CLI,TEL1A_CLI, " +
				" TEL2A_CLI,RPMA_CLI,NEXA_CLI,CELA_CLI,MAILA_CLI " +*/

	public ServletExcel() {
		array= new ArrayList<BeanExcel>();
	}
	public  void adicionar(BeanExcel exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanExcel obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanExcel eliminar(int alt){
		return array.remove(alt);
	}
	/*
	public  String eliminaEspacio(String cadena){
		//quitar espacios alos caostados 
		cadena=cadena.trim();
		cadena=cadena.replaceAll("  ", " ");
		cadena=cadena.replaceAll("   ", " ");
		cadena=cadena.replaceAll("    ", " ");
		return cadena;	
	}
	public  String eliminaSignos(String cadena){
		cadena=cadena.replace("(", " ");
		cadena=cadena.replace(")", " ");
		cadena=cadena.replaceAll("\"", " ");
		cadena=cadena.replaceAll(",", " ");
		cadena=cadena.replaceAll(";", " ");
		cadena=cadena.replaceAll("-", " ");
		cadena=cadena.replace("-", " ");
		return cadena;
		
	}
	public  String retoque(String cadena){
		cadena=cadena.replaceAll("  ", " ");
		System.out.println(cadena);
		
		return cadena;
		
	}*/
	/*
	public void listarAlternativaXCodPre(Object cod_pre0){
		String cod_pre1=(String) cod_pre0;
		int cod_pre=Integer.parseInt(cod_pre1);
		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		
		String sql="SELECT cod_alt,nom_alt,tip_alt  FROM alternativa where cod_pre='"+cod_pre+"'";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				//Object obj[]={rs.getString(1),rs.getString(2),rs.getString(3)};
				int cod_alt=Integer.parseInt(rs.getString(1));
				String nom_alt=rs.getString(2),tip_alt=rs.getString(3);
				BeanAlternativa objAlt=new BeanAlternativa(cod_alt,nom_alt,tip_alt);
				adicionar(objAlt);
				}
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		objAccesoBD.cerrarConexion();}
	*/
	
	
	/********************************************************************************************************/
	/********BUSCAR CLIENTE************************/
	public void buscarCliente(String nombreCliente){
		nombreCliente=nombreCliente.trim();		
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String NOM_CLI=nombreCliente;
	/*SELECT COD_CLI,NOM_CLI,RUC_CLI,LUG_CLI,CONA_CLI,TEL1A_CLI,
	TEL2A_CLI,RPMA_CLI,NEXA_CLI,CELA_CLI,MAILA_CLI
	fROM CLIENTE  WHERE EST_CLI='ACTIVADO'
	AND  NOM_CLI like '%CONSTRUCTORA INMOBILIARIA SAN LUIS%';*/
		String sql="SELECT CLI.COD_CLI,CLI.NOM_CLI,TIPCLI.nom_tipo,CLI.RUC_CLI,CLI.LUG_CLI,CLI.CONA_CLI,CLI.TEL1A_CLI, "+
			       "CLI.TEL2A_CLI,CLI.RPMA_CLI,CLI.NEXA_CLI,CLI.CELA_CLI,CLI.MAILA_CLI "+
			       "fROM tb_cliente CLI "+
                   "INNER JOIN tb_tipocliente TIPCLI "+
                   "ON CLI.COD_TIPO = TIPCLI.cod_tipo "+
                   "WHERE CLI.EST_CLI='ACTIVADO' "+
				  " AND  NOM_CLI = '"+NOM_CLI+"';";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				codcli=rs.getString(1);
				nomcli=rs.getString(2);
				tipcli=rs.getString(3);
				ruccli=rs.getString(4);
				lugcli=rs.getString(5);
				conacli=rs.getString(6);
				tel1acli=rs.getString(7);
				tel2acli=rs.getString(8);
				rpmacli=rs.getString(9);
				nexacli=rs.getString(10);
				celacli=rs.getString(11);
				mailacli=rs.getString(12);
			
			}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
	}
	
	/***********************************************/
	/***********************************************/
	///////////////////////////////////TAMAÑO DE LAS FILAS DE EXCEL
	public  int tamañodelExcel(String cadenar){
		 boolean valor=true;
		 int tamaño=0;
			 
			try {
				POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				
				while (valor) {
					try {
						//HSSFCell cell = wb.getSheetAt("Hoja1").getRow(tamaño).getCell((short)0);
						HSSFCell cell = wb.getSheet("Hoja1").getRow(tamaño).getCell((short)0);
						
						if(cell.equals("")||cell==null||cell.equals(" ")){
							valor=false;
						}
						
						if(cell==null){
							valor=false;
						}
						if(cell.equals(" ")){
							valor=false;
						}
						if(cell.equals("")){
							valor=false;
						}
						if(cell.equals(null)){
							valor=false;
						}
		    	
		    	
					} catch (Exception e) {
						valor=false;
						// TODO: handle exception
					}
					tamaño++;
				
		    	}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//ESTE TAMAÑO ES EL TAMAÑO PERO TIENES QUE DISMINUIRLE -1
			return tamaño-1;
	}
	
	public String buscartb_umed(String umed){
		String regre="";
		String u=umed;
		u=u.toString().toUpperCase();
		u=u.trim();
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*SELECT UMED.NOM_UMED FROM tb_umed UMED
		WHERE UMED.NOM_UMED='UND'*/
		String sql=" SELECT UMED.NOM_UMED FROM tb_umed UMED " +
					" WHERE UMED.NOM_UMED='"+u+"';";

		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
			regre=rs.getString(1);
			}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		return regre;
	}
	public String buscarTabla(String umed){
		String regre="";
		String u=umed;
		u=u.toString().toUpperCase();
		u=u.trim();
		
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		/*SELECT UMED.NOM_UMED FROM tb_umed UMED
		INNER JOIN tb_umedALT UMEDALT
		ON UMED.COD_UMED=UMEDALT.COD_UMED
		WHERE UMEDALT.NOM_UMEDALT='UNIDAD'*/
		String sql=" SELECT UMED.NOM_UMED FROM tb_umed UMED " +
					" INNER JOIN tb_umedALT UMEDALT " +
					" ON UMED.COD_UMED=UMEDALT.COD_UMED " +
					" WHERE UMEDALT.NOM_UMEDALT='"+u+"';";
	
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
			regre=rs.getString(1);
			}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		return regre;
	}
	
	public String SinC(String cad){
		   
		   String pal="",pal2="";
		   for(int i=0;i<cad.length();i++){
			   pal=""+cad.charAt(i);
			   if(pal.equals("*")){
				   break;
			   }else{
				   pal2+=pal;
			   }
		   }
		   
		return pal2; 
	 }
	
	/********CARGAR DE EXCEL
	 * @throws IOException 
	 * @throws FileNotFoundException ***********************/
	 public  void cargarExcel(String cadenar) throws FileNotFoundException, IOException{
		 
		 HSSFCell cantidad = null,producto = null,umed = null,marca=null,modelo=null,codpromelsa=null;
		 POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
		 HSSFWorkbook wb = new HSSFWorkbook(fs);
		int tamañ=tamañodelExcel(cadenar.trim());
		//System.out.println("EL TAMAÑO DEL EXCEL ES:"+tamañ);
		int id=1,codi=0;
		 for (int i = 0; i < tamañ; i++) {
		String cadena;
		
		if(i==0){
			buscarCliente(""+wb.getSheetAt(0).getRow(i).getCell((short)1));	
			//objTranAut.txtSeñores.setText(""+wb.getSheetAt(0).getRow(i).getCell((short)1));
			
			
			
		}else if(i==1||i==2||i==3){
			//System.out.println("NADA");
			
		}else{
		cantidad = wb.getSheetAt(0).getRow(i).getCell((short)0);
		umed = wb.getSheetAt(0).getRow(i).getCell((short)1);	
		producto = wb.getSheetAt(0).getRow(i).getCell((short)2);	
		marca = wb.getSheetAt(0).getRow(i).getCell((short)3);	
		modelo= wb.getSheetAt(0).getRow(i).getCell((short)4);	
		codpromelsa= wb.getSheetAt(0).getRow(i).getCell((short)5);	
		cadena=""+producto;
		cadena=cadena.trim();
		String cadena2,cadena3,cadena4;
		//System.out.println("Modelo: "+wb.getSheetAt(0).getRow(i).getCell((short)4));
		//System.out.println("Promelsa: "+wb.getSheetAt(0).getRow(i).getCell((short)5));
		cadena4=cadena;	
	
		//if(cantidad)
	
		
		
		int canti = 0;
		 String cant=""+cantidad,ume=""+umed,mod=""+modelo,codprom=""+codpromelsa;
		 
		 ume=ume.trim();
		// System.out.println("el primero"+ume);
		 String viene=buscarTabla(ume);
		 if(viene.equals("")){
			 //ESTA EN LA TABLA UMED
			 String viene2=buscartb_umed(ume);
			 if(viene2.equals("")){
				 ume=ume;
			 }else if(viene2==null){
				 ume=ume;
			 }else{
				 ume=viene2;
			 }
		 }else if(viene==null){
			//ESTA EN LA TABLA UMED 
			 String viene2=buscartb_umed(ume);
			 if(viene2.equals("")){
				 ume=ume;
			 }else if(viene2==null){
				 ume=ume;
			 }else{
				 ume=viene2;
			 }
		 }else{
			//YA LO ENCONTRA PORK ESTABA EN LA TABLA UMEDALT 
			 ume=viene;
		 }
		// System.out.println("el segundo"+ume);
		 try {
			 if(cant.indexOf(".")==-1){//entonces es un entero
			 canti=Integer.parseInt(cant);
		 }else{//es un doble
			cant=cant.substring(0, cant.indexOf("."));
			canti=Integer.parseInt(cant);
		 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
				
		//cant=cant.substring(0, cant.indexOf("."));//ESTO ES UN PROBLEMA
		  //canti=Integer.parseInt(cant.trim());	 
		// BeanExcel objAlt=new BeanExcel("Gustavo", 0, canti, "K", cadena4, ume); 
		 /* System.out.println("ESTO ES LO 1ERO QUE SALE:\n"+
				  nomcli+","+i+canti+","+ume+","+cadena4.toString().toUpperCase()+","+marca+","+conacli+","+lugcli+","+tel1acli+","+
				  rpmacli+","+celacli+","+
				  mailacli+","+"VACIO"+","+
				  codcli+
				  ","+tipcli  );*/
		  BeanExcel objAlt=new BeanExcel(nomcli.toString().toUpperCase(), id++ , canti, ume.toString().toUpperCase(),
				  cadena4.toString().toUpperCase(),""+marca,conacli,lugcli
					,tel1acli,rpmacli,nexacli,celacli,mailacli,"VACIO",Integer.parseInt(codcli),tipcli,SinC(mod),SinC(codprom));
		 
		adicionar(objAlt);	
		 
		 
		 
		 
		 
		 
		}
		
		
		
		
		}
		 
		 
	 }
	
}
