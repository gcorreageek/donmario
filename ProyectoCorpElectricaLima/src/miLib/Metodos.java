package miLib;
/*
 * CAMINO DE VIDA -->IGLESIA DEL PASTOR CLAUDIO
 * WWW.CAMINODEVIDA.COM
 * 
 */

import java.sql.ResultSet;

public class Metodos {
	/*
	-- ELECTRO FERRETERO FRANCO -->CON IGV
	-- Y TECSUR VENDE -->MAS IGV
	-- ASI QUE EN LA APLICACION "0" SE IGNIFICA CON IGV Y "1" ES MAS IGV
	-- 0=CON IGV
	-- 1=MAS IGV
	*/
	
	public static int  codprod,codmar,codprove,cod_prodalt,cod_umed;		 
	public static String producto,mon,umed,obsprod,obsdet,igv,marca,proveedor,nom_prodalt;
	public static double costoreal,costoprove,peso;
	public static String fec;
	GUI objGUI;

	public static String eliminaEspacio(String cadena){
		//quitar espacios alos caostados 
		cadena=cadena.trim();
		cadena=cadena.replaceAll("  ", " ");
		cadena=cadena.replaceAll("   ", " ");
		cadena=cadena.replaceAll("    ", " ");
		return cadena;	
	}
	public static String eliminaSignos(String cadena){
		cadena=cadena.replace("(", " ");
		cadena=cadena.replace(")", " ");
		cadena=cadena.replaceAll("\"", " ");
		cadena=cadena.replaceAll(",", " ");
		cadena=cadena.replaceAll(";", " ");
		cadena=cadena.replaceAll("-", " ");
		cadena=cadena.replace("-", " ");
		return cadena;
		
		
	}
	public static String retoque(String cadena){
		cadena=cadena.replaceAll("  ", " ");
		//System.out.println(cadena);
		
		return cadena;
		
	}
	/*public static String convertirFecha(String fechare){
		String fechare1 = fechare.trim();
		String fechare2;
		fechare2=fechare1.substring(0, fechare1.indexOf(":")-3);
		return fechare2;
	}*/

	
	
	/********METODO GENERAL PARA VER DONDE BUSCAR Y COMO HACERLO************************/
	public static String traeNFilas(String NOM_PROD){
		System.out.println("ENTRA AL METODO TRAENFILAS CON:"+NOM_PROD);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String mandalo = "";

		String sql="SELECT CASE (SELECT COUNT(PROD.NOM_PROD) "+
		" FROM tb_proveprodmarumed1 DET INNER JOIN tb_producto PROD "+
		" ON PROD.COD_PROD=DET.COD_PROD " +
		" where PROD.NOM_PROD='"+NOM_PROD+"' AND PROD.EST_PROD='ACTIVADO' AND DET.EST_DET='ACTIVADO' "+ //and DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det " +
		" order by DET.cos_det) "+
		" WHEN 0 THEN '0' "+
		" WHEN 1 THEN '1' "+
		"  ELSE '2'  END;  ";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			while(rs.next()){
				mandalo=rs.getString(1);
				}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		objAccesoBD.cerrarConexion();
		System.out.println("SALE DEL METODO TRAENFILAS CON:"+mandalo);
		return mandalo;
	}
	
	/*ENTONCES:SI ES "0" HAY 2 OPCIONES: QUE LE PRODUCTO EN SI NO ESTA, O QUE EL PRODUCTO
	 * ESTA INGRESADO PERO NO ESTA CON PRECIO.
	 * CLARO EN LAS 2 OPCIONES UNO TIENE QUE DARLE INGRESAR ALTERNATIVO
	 * PORQUE PUEDE SER QUE NO ESTE EL PRODUCTO(AKA SE SUPONE QUE EL PRODCUTO NO ESTA
	 *  Y NO SABE DE QUE PRODUCTO SE TRATA ENTONCES SIMPLEMENTE SE DEJA CON
	 *  ERROR) O QUE NO ESTE CON EL NOMBRE
	 * QUE CORRESPONDE (AQUI UNO TIENE QUE INGRESARLE COMO NOMBRE ALTERNATIVO) */
	

	/***********************************************/
	/************METODO PARA BUSCAR CUANDO ES "1" *******************/

	public static int buscar1parte1(String cadena,String uMED){
		System.out.println("ENTRA AL METODO BUSCAR1PARTE1 CON:"+cadena+"Y"+uMED);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//String mandalo = "";
		int c=0;
		
	
        String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD, " +
		" IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), " +
		" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))), " +
		" DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.PESO_PROD " +
		" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE " +
		" ON PROVE.COD_PROVE=DET.COD_PROVE " +
		" INNER JOIN tb_producto PROD " +
		" ON DET.COD_PROD=PROD.COD_PROD " +
		" INNER JOIN tb_marcas MAR " +
		" ON DET.COD_MAR=MAR.COD_MAR " +
		" INNER JOIN tb_umed UMED " +
		" ON UMED.COD_UMED=DET.COD_UMED " +
		" WHERE PROD.EST_PROD='ACTIVADO' AND DET.EST_DET='ACTIVADO' AND "+
		//" ALT.NOM_PRODALT = '"+cadena+"' AND UMED.NOM_UMED='"+uMED+"' order by DET.cos_det;";
		" PROD.NOM_PROD = '"+cadena+"' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det  " +
		" order by DET.cos_det;";
		System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			String pes="";
			//VA REGRESAR UN C=0 SI NO ENCUENTRA NADA (OSEA PONEMOS ERROR)
			while(rs.next()){
				c++;
				if(c==1){
					/*{"COD","PRODUCTO","COSTO REAL","COSTO PROVE","MON","IGV",
					"COD","MAR","UMED","OBS","COD","PROVEE","OBS"};*/
					codprod= Integer.parseInt(rs.getString(1));
					producto= rs.getString(2).toString().toUpperCase();
					costoreal= Double.parseDouble(rs.getString(3));
					costoprove= Double.parseDouble(rs.getString(4));
					mon= rs.getString(5);
					igv=rs.getString(6);
					codmar=Integer.parseInt(rs.getString(7));
					marca=rs.getString(8).toString().toUpperCase();
					cod_umed=Integer.parseInt(rs.getString(9));
					umed=rs.getString(10);
					obsprod=rs.getString(11);
					String vamos=rs.getString(12).toString();
					fec=vamos;
					codprove=Integer.parseInt(rs.getString(13));
					proveedor=rs.getString(14);
					cod_prodalt=codprod;
					nom_prodalt=producto;
					pes=rs.getString(15);
					if(pes.equals("")){
						peso=0;
					}else{
						peso=Double.parseDouble(rs.getString(15));
					}
					
				}else{
					//System.out.println("ES MAS DE UNOOOOOOOOOOOOOOOOOOOOOO ");
					//ANTES NO HABIA NADA POR ACA, ASI QUE PUSE ESTO "MUCHAS GRACIAS"
					
				}
				
			}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		System.out.println("SALE DEL METODO BUSCAR1PARTE1 CON:"+c);
		return c ;
	}
	
	/***************************************************************/
	/********METODO PARA BUSCAR CON "2 o MAS" ************************/
	public static int buscar2parte1(String cadena,String uMED){
		System.out.println("ENTRA AL METODO BUSCAR2PARTE1 CON:"+cadena+" Y "+uMED);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		//String mandalo = "";
		int c=0;
		System.out.println("cad:"+cadena);
		if(cadena.equals("")){
			cadena="null";
		}
		
		String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD, " +
				"  IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), " +
				" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))), " +
				"  DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.PESO_PROD " +
				" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE " +
				" ON PROVE.COD_PROVE=DET.COD_PROVE " +
				" INNER JOIN tb_producto PROD " +
				" ON DET.COD_PROD=PROD.COD_PROD " +
				" INNER JOIN tb_marcas MAR " +
				" ON DET.COD_MAR=MAR.COD_MAR " +
				" INNER JOIN tb_umed UMED " +
				" ON DET.COD_UMED=UMED.COD_UMED " +
				" WHERE  PROD.EST_PROD='ACTIVADO'  AND DET.EST_DET='ACTIVADO' AND " +
				" PROD.NOM_PROD='"+cadena+"' "+
				" AND " +
				" IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), " +
				" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) " +
				" = " +
				" (SELECT MIN(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), " +
				" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))))" +
				" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE" +
				" ON PROVE.COD_PROVE=DET.COD_PROVE " +
				" INNER JOIN tb_producto PROD" +
				" ON DET.COD_PROD=PROD.COD_PROD" +
				" INNER JOIN tb_marcas MAR" +
				" ON DET.COD_MAR=MAR.COD_MAR" +
				" WHERE PROD.EST_PROD='ACTIVADO' AND DET.EST_DET='ACTIVADO' AND " +
				"  PROD.NOM_PROD='"+cadena+"')"; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det );";
		//System.out.println(sql);
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			String pes="";
			while(rs.next()){
				c++;
				if(c==1){
					
					//System.out.println("NOMBRE DEL PRODUCTIÑO;"+rs.getString(2));
					codprod= Integer.parseInt(rs.getString(1));
					producto= rs.getString(2).toString().toUpperCase();
					costoreal= Double.parseDouble(rs.getString(3));
					costoprove= Double.parseDouble(rs.getString(4));
					mon= rs.getString(5);
					igv=rs.getString(6);
					codmar=Integer.parseInt(rs.getString(7));
					marca=rs.getString(8).toString().toUpperCase();
					cod_umed=Integer.parseInt(rs.getString(9));
					umed=rs.getString(10);
					obsprod=rs.getString(11);
					String vamos=rs.getString(12).toString();
					//System.out.println("LA FLECHA CONVERTIDA ES:"+vamos);
					fec=vamos;
					codprove=Integer.parseInt(rs.getString(13));
					proveedor=rs.getString(14);
					cod_prodalt=codprod;
					nom_prodalt=producto;
					pes=rs.getString(15);
					if(pes.equals("")){
						peso=0;
					}else{
						peso=Double.parseDouble(rs.getString(15));
					}
					
					//System.out.println("EL COSTE REAL CHE VOLUDONSIO ES:"+costoreal);
					
				}else{
					//System.out.println("ES MAS DE UNOOOOOOOOOOOOOOOOOOOOOO ");
					
				}
				
				}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		objAccesoBD.cerrarConexion();
		System.out.println("SALE DEL METODO BUSCAR2PARTE1 CON:"+c);
		return c ;
	}
	
	/***********************************************/
	/********METODO PARA BUSCAR CON "2 o MAS" ************************/
	public static int buscar2parte2(String cadena,String marcas,String uMED){
		System.out.println("ENTRA AL METODO BUSCAR2PARTE2 CON:"+cadena+"Y"+marcas+"Y"+uMED);
		AccesoBD objAccesoBD = new AccesoBD();
		objAccesoBD.crearConexion();
		String mandalo = "";
		int c=0;
	
		String sql="SELECT PROD.COD_PROD,PROD.NOM_PROD, "+
		 " IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18)))," +
		 " (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))),"+
		"	 DET.COS_DET,DET.MON_DET,DET.IGV_DET,MAR.COD_MAR,MAR.NOM_MAR,UMED.COD_UMED,UMED.NOM_UMED,PROD.OBS_PROD,DET.FEC_DET,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.PESO_PROD "+
		" FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
		" ON PROVE.COD_PROVE=DET.COD_PROVE "+
		" INNER JOIN tb_producto PROD "+
		" ON DET.COD_PROD=PROD.COD_PROD "+
		" INNER JOIN tb_marcas MAR "+
		" ON DET.COD_MAR=MAR.COD_MAR "+
		" INNER JOIN tb_umed UMED "+
		" ON DET.COD_UMED=UMED.COD_UMED "+
		" WHERE PROD.EST_PROD='ACTIVADO' AND DET.EST_DET='ACTIVADO' AND " +
		"  PROD.NOM_PROD='"+cadena+"' AND MAR.NOM_MAR LIKE '%"+marcas+"%'   "+
		" AND "+
		" IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		" (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) "+
		"	 = "+
		" (SELECT MIN(IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
		"   (IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) )))) "+
		"  FROM tb_proveprodmarumed1 DET INNER JOIN tb_proveedor PROVE "+
		" ON PROVE.COD_PROVE=DET.COD_PROVE "+
		" INNER JOIN tb_producto PROD "+
		" ON DET.COD_PROD=PROD.COD_PROD "+
		" INNER JOIN tb_marcas MAR "+
		" ON DET.COD_MAR=MAR.COD_MAR "+
		" INNER JOIN tb_umed UMED "+
		" ON DET.COD_UMED=UMED.COD_UMED "+
		" WHERE  PROD.EST_PROD='ACTIVADO' AND DET.EST_DET='ACTIVADO' AND  " +
		" PROD.NOM_PROD='"+cadena+"' AND MAR.NOM_MAR LIKE '%"+marcas+"%')"; //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det);";
		ResultSet rs = objAccesoBD.ejecutarConsulta(sql);
		try {
			String pes="";
			//VA REGRESAR UN C=0 SI NO ENCUENTRA NADA ESO SIGNIFICA
			//QUE EL PRODUCTO NO ESTA EN EL ALTERNATIVO
			while(rs.next()){
				c++;
				if(c==1){//PONIENDOLE LA MARCA ENCONTRO UNO NO MAS (BUENO)
					/*{"COD","PRODUCTO","COSTO REAL","COSTO PROVE","MON","IGV",
					"COD","MAR","UMED","OBS","COD","PROVEE","OBS"};*/
					codprod= Integer.parseInt(rs.getString(1));
					producto= rs.getString(2).toString().toUpperCase();
					costoreal= Double.parseDouble(rs.getString(3));
					costoprove= Double.parseDouble(rs.getString(4));
					mon= rs.getString(5);
					igv=rs.getString(6);
					codmar=Integer.parseInt(rs.getString(7));
					marca=rs.getString(8).toString().toUpperCase();
					cod_umed=Integer.parseInt(rs.getString(9));
					umed=rs.getString(10);
					obsprod=rs.getString(11);
					String vamos=rs.getString(12).toString();
					//System.out.println("LA FLECHA CONVERTIDA ES:"+vamos);
					fec=vamos;
					codprove=Integer.parseInt(rs.getString(13));
					proveedor=rs.getString(14);
					cod_prodalt=codprod;
					nom_prodalt=producto;
					pes=rs.getString(15);
					if(pes.equals("")){
						peso=0;
					}else{
						peso=Double.parseDouble(rs.getString(15));
					}
					
				}else{//PONIENDOLE LA MARCA Y SIGUEN HABIENDO 2
					//System.out.println("ES MAS DE UNOOOOOOOOOOOOOOOOOOOOOO ");
				//	buscar2parte1(cadena);
					
				}
				
				}
			
			rs.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		
		
		objAccesoBD.cerrarConexion();
		System.out.println("SALE DEL METODO BUSCAR2PARTE2 CON:"+c);
		return c ;
	}
	
	/***********************************************/

	
	
	
	
	}

