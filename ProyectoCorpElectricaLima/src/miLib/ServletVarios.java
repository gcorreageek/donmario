package miLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanVarios;

public class ServletVarios {
	
	/*TranCotizacionAutomatica objTranAut;
	  Metodos objMetodo;
	 List<BeanExcel> array;

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
	/***********************************************/
	/*
	///////////////////////////////////TAMAÑO DE LAS FILAS DE EXCEL
	public  int tamañodelExcel(String cadenar){
		 boolean valor=true;
		 int tamaño=0;
			 
			try {
				POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				
				while (valor) {
					try {
						HSSFCell cell = wb.getSheetAt(0).getRow(tamaño).getCell((short)3);
		    	
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
	}*/
	/********CARGAR DE EXCEL
	 * @throws IOException 
	 * @throws FileNotFoundException ***********************/
	/*
	 public  void cargarExcel(String cadenar) throws FileNotFoundException, IOException{
		 
		 HSSFCell cantidad = null,producto = null,marca = null;
		 POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
		 HSSFWorkbook wb = new HSSFWorkbook(fs);
		 for (int i = 0; i < tamañodelExcel(cadenar.trim()); i++) {
			 String cadena;
		cantidad = wb.getSheetAt(0).getRow(i).getCell((short)0);
		producto = wb.getSheetAt(0).getRow(i).getCell((short)1);	
		marca = wb.getSheetAt(0).getRow(i).getCell((short)2);	
		cadena=""+producto;
		cadena=cadena.trim();
		
			
		cadena=objMetodo.eliminaSignos(""+cadena);
		cadena=objMetodo.eliminaEspacio(cadena);
		cadena=objMetodo.retoque(cadena);
	//	trans=Integer.parseInt(""+cantidad);
		
		 String cant=""+cantidad,mar=""+marca;
		 cant=cant.substring(0, cant.indexOf("."));
		 int canti=Integer.parseInt(cant);
		 BeanExcel objAlt=new BeanExcel("Gustavo", 1, canti, "K", cadena, mar);
		 adicionar(objAlt);
		
		
		
		}
		
		 
		 
	 }
	 */
	
	 List<BeanVarios> array;

	public ServletVarios() {
		array= new ArrayList<BeanVarios>();
	}
	public  void adicionar(BeanVarios exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanVarios obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanVarios eliminar(int alt){
		return array.remove(alt);
	}

}
