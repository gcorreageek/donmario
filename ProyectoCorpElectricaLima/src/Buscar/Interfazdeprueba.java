/**
 * 
 */
package Buscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import miLib.AccesoBD;
import beans.BeanBuscarTransProd;

/**
 * @author pcjose
 *
 */
public class Interfazdeprueba {
	private Connection c;
	/**
	 * 
	 */
	public Interfazdeprueba() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(
			// la ip de daniel asi: 192.168.1.43//255.255.255.0
					"jdbc:mysql://10.0.0.66:3306/bd_cel", "casa", "casa");
			// "jdbc:mysql://localhost:3306/bd_cel","pcjose","pcjose");
			// "jdbc:mysql://localhost:3306/bd_cel","root","");
			// "jdbc:mysql://192.168.1.41:3306/bd_avaintel","mario","admin");
			String sql="SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, "+
	                   "UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , "+
				       "DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, "+
					   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) "+ 
					   "))   as costo , "+
					   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
					   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) "+
					   ")/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD  "+
					   "FROM tb_proveprodmarumed1 DET "+
					   "INNER JOIN tb_producto PROD "+
					   "ON DET.COD_PROD=PROD.COD_PROD "+
					   "INNER JOIN tb_proveedor PROVE "+
					   "ON PROVE.COD_PROVE=DET.COD_PROVE "+
					   "INNER JOIN tb_marcas MAR "+
					   "ON MAR.COD_MAR=DET.COD_MAR "+
					   "INNER JOIN tb_umed UMED "+
					   "ON UMED.COD_UMED=DET.COD_UMED "+
					   "INNER JOIN tb_rubro RUB "+
					   "ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
					   "where det.est_det='ACTIVADO'  AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
					   "group by DET.cod_proveprodmarumed ORDER BY costoVenta asc limit 10;";
			System.out.println(sql);
			// pst = c.prepareStatement("SELECT * from tb_nalternativos");
			pst = c.prepareStatement(sql);
			rs = pst.executeQuery();
			int u = 0;
			while (rs.next()) {
				System.out.println(u+"::::"+rs.getInt(1)
				 +"---"+rs.getString(2)
				 +"---"+rs.getString(3)
				 +"---"+rs.getString(4)
				 +"---"+rs.getString(5)
				 +"---"+rs.getString(6)
				 +"---"+rs.getString(7)
				 +"---"+rs.getString(8)
				 +"---"+rs.getString(9)
				 +"---"+rs.getString(10)
				 +"---"+rs.getString(11)
				 +"---"+rs.getString(12)+"\n");
				u++;
			}
			System.out.println("total filas: "+u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("error" + e);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error" + e);
		}
		
		//}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SELECT DET.cod_proveprodmarumed,PROVE.COD_PROVE,PROVE.NOM_PROVE,PROD.COD_PROD,PROD.NOM_PROD,MAR.COD_MAR,MAR.NOM_MAR, "+
                "UMED.cod_umed,UMED.NOM_UMED,DET.COS_DET,DET.MON_DET,DET.igv_det , "+
			       "DET.OBS_DET,DET.FEC_DET,RUB.NOM_RUBRO,RUB.POR_RUBRO, "+
				   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) "+ 
				   "))   as costo , "+
				   "(( IF((DET.MON_DET='$'),(IF((DET.IGV_DET=1),DET.COS_DET,(DET.COS_DET/1.18))), "+
				   "(IF((DET.IGV_DET=1),(DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio))),((DET.COS_DET/(SELECT COMPRA FROM tb_cambio WHERE COD_CAM=(SELECT MAX(COD_CAM) FROM tb_cambio)))/1.18) ))) "+
				   ")/RUB.POR_RUBRO)  as costoVenta ,PROD.PESO_PROD,PROD.MOD_PROD,RUB.COD_RUBRO,PROD.MAR_PROD,PROD.CODPRO_PROD  "+
				   "FROM tb_proveprodmarumed1 DET "+
				   "INNER JOIN tb_producto PROD "+
				   "ON DET.COD_PROD=PROD.COD_PROD "+
				   "INNER JOIN tb_proveedor PROVE "+
				   "ON PROVE.COD_PROVE=DET.COD_PROVE "+
				   "INNER JOIN tb_marcas MAR "+
				   "ON MAR.COD_MAR=DET.COD_MAR "+
				   "INNER JOIN tb_umed UMED "+
				   "ON UMED.COD_UMED=DET.COD_UMED "+
				   "INNER JOIN tb_rubro RUB "+
				   "ON RUB.COD_RUBRO=PROD.COD_RUBRO "+
				   "where det.est_det='ACTIVADO'  AND PROD.EST_PROD='ACTIVADO' AND RUB.EST_RUBRO='ACTIVADO' AND PROVE.EST_PROVE='ACTIVADO' "+ //and  DATE_SUB(CURDATE(),INTERVAL 90 DAY) <= DET.fec_det "+
				   "group by DET.cod_proveprodmarumed ORDER BY costoVenta asc limit 10;");
		Interfazdeprueba d1 = new Interfazdeprueba();

	}

}
