package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import beans.BeanCargarProductos;

public class ServletCargarProductos {

	 List<BeanCargarProductos> array;

		public ServletCargarProductos() {
			array= new ArrayList<BeanCargarProductos>();
		}
		public  void adicionar(BeanCargarProductos exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCargarProductos obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCargarProductos eliminar(int alt){
			return array.remove(alt);
		}
		
		
		public  int tamañodelExcel(String cadenar){
			 boolean valor=true;
			 int tamaño=0;
				 
				try {
					POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
					HSSFWorkbook wb = new HSSFWorkbook(fs);
					
					while (valor) {
						try {
							HSSFCell cell = wb.getSheet("Hoja1").getRow(tamaño).getCell((int)0);
							
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
						}
						tamaño++;
					
			    	}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				return tamaño-1;
		}
		
		
		public String SinAsterisco(String cad){
			   
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
		
		 /*************************************************************************************************************************************/
		 
	     public  void cargarExcel(String cadenar) throws FileNotFoundException, IOException{
			 
			 HSSFCell cod_prod=null,nom_prod=null,cod_rubro = null,obs_prod = null,est_prod=null,
			 peso_prod=null,act_prod=null,mod_prod=null,esp_prod=null,mar_prod=null,codpro_prod=null;
			 
			 POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
			 HSSFWorkbook wb = new HSSFWorkbook(fs);
			int tamañ=tamañodelExcel(cadenar.trim());
			int fila=0;
			//System.out.println("EL TAMAÑO DEL EXCEL ES:"+tamañ);
			
			 for (int i = 0; i < tamañ; i++) {
				 
				
				if(i==0){
					//NADAAAAAAA
				}else{
					
					
					cod_prod  = wb.getSheetAt(0).getRow(i).getCell((int)0);
					nom_prod  = wb.getSheetAt(0).getRow(i).getCell((int)1);	
					cod_rubro = wb.getSheetAt(0).getRow(i).getCell((int)2);
					obs_prod  = wb.getSheetAt(0).getRow(i).getCell((int)3);	
					est_prod  = wb.getSheetAt(0).getRow(i).getCell((int)4);
					peso_prod = wb.getSheetAt(0).getRow(i).getCell((int)5);	
					act_prod  = wb.getSheetAt(0).getRow(i).getCell((int)6);	
					mod_prod  = wb.getSheetAt(0).getRow(i).getCell((int)7);	
					esp_prod  = wb.getSheetAt(0).getRow(i).getCell((int)8);
					mar_prod  = wb.getSheetAt(0).getRow(i).getCell((int)9);	
					codpro_prod = wb.getSheetAt(0).getRow(i).getCell((int)10);
						
						System.out.println(cod_prod+"--"+nom_prod+"--"+cod_rubro+"--"+
								obs_prod+"--"+est_prod+"--"+peso_prod+"--"+act_prod+"--"+mod_prod+"--"+
								esp_prod+"--"+mar_prod+"--"+codpro_prod+"--"+fila+"\n");
					
					    	
			    	BeanCargarProductos objPre=new BeanCargarProductos(""+cod_prod,SinAsterisco(""+nom_prod),
			    			""+cod_rubro,""+obs_prod,""+est_prod,""+peso_prod,""+act_prod,""+mod_prod,""+esp_prod,""+mar_prod,""+codpro_prod);
					 
					  adicionar(objPre);
						
									  	
				}
			}
			 
			 
		 }
		

}
