package servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import beans.BeanCargarPrecios;

public class ServletCargarPrecios {

	 List<BeanCargarPrecios> array;

		public ServletCargarPrecios() {
			array= new ArrayList<BeanCargarPrecios>();
		}
		public  void adicionar(BeanCargarPrecios exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCargarPrecios obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCargarPrecios eliminar(int alt){
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
							//HSSFCell cell = wb.getSheetAt("Hoja1").getRow(tamaño).getCell((short)0);
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
		
		
		public String Sindecimal(String cad){
			   
			   String pal="",pal2="";
			   for(int i=0;i<cad.length();i++){
				   pal=""+cad.charAt(i);
				   if(pal.equals(".")){
					   break;
				   }else{
					   pal2+=pal;
				   }
			   }
			   
			return pal2; 
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
			 
			 HSSFCell cod_prod=null,descripcion=null,modelo=null,cod_prove = null,cod_mar = null,cod_umed=null,
			 cod_rubro=null,cos_det=null,mon_det=null,igv_det=null;
			 POIFSFileSystem  fs = new POIFSFileSystem(new FileInputStream(cadenar.trim()));
			 HSSFWorkbook wb = new HSSFWorkbook(fs);
			int tamañ=tamañodelExcel(cadenar.trim());
			int fila=0;
			//System.out.println("EL TAMAÑO DEL EXCEL ES:"+tamañ);
			
			 for (int i = 0; i < tamañ; i++) {
				 
				
				if(i==0){
					//NADAAAAAAA
				}else{
					
					
					    cod_prod= wb.getSheetAt(0).getRow(i).getCell((int)0);
						descripcion= wb.getSheetAt(0).getRow(i).getCell((int)1);
						modelo = wb.getSheetAt(0).getRow(i).getCell((int)2);	
						cod_prove = wb.getSheetAt(0).getRow(i).getCell((int)3);
						cod_mar = wb.getSheetAt(0).getRow(i).getCell((int)4);	
						cod_umed = wb.getSheetAt(0).getRow(i).getCell((int)5);
	                    cod_rubro=wb.getSheetAt(0).getRow(i).getCell((int)6);	
						cos_det= wb.getSheetAt(0).getRow(i).getCell((int)7);	
						mon_det= wb.getSheetAt(0).getRow(i).getCell((int)8);	
						igv_det= wb.getSheetAt(0).getRow(i).getCell((int)9);
						System.out.println(cod_prod+"--"+descripcion+"--"+modelo+"--"+cod_prove+"--"+
						cod_mar+"--"+cod_umed+"--"+cod_rubro+"--"+cos_det+"--"+mon_det+"--"+
								igv_det+"--"+fila+"\n");
						
//						if(isNumber(cod_prove.toString())){
//							
//						}else{
//							System.out.println("descripcion: "+descripcion);
//							System.out.println("cod_prove: "+cod_prove+" "+"fila: "+i);
//							System.out.println("QQQ: "+tamañ);
//							break;
//						}
						
					    //if(descripcion.equals("")){
					    	//NADA
					    	//System.out.println("nada");
					    //}else{
					    	//System.out.println("si");
					    	
					    	BeanCargarPrecios objPre=new BeanCargarPrecios(""+cod_prod,""+descripcion,SinAsterisco(""+modelo),
					    			  Sindecimal(""+cod_prove),Sindecimal(""+cod_mar),Sindecimal(""+cod_umed),
					    			  Sindecimal(""+cod_rubro),""+cos_det,""+mon_det,Sindecimal(""+igv_det));
							 
							  adicionar(objPre);
					    //}
					
					
					
				  	
				}
			}
			 
			 
		 }
		 /********************************************************************************************************************************************/

	     public static boolean isNumber(String string){
	    	    if(string ==null || string.isEmpty()){
	    	       return false;
	    	    }
	    	    int i=0;
	    	    if(string.charAt(0)=='-'){
	    		if(string.length()>1){
	    		  i++;
	    	        }else{
	    		   return false;
	    		}
	    	    }
	    	    for (; i<string.length();i++){
	    		if(!Character.isDigit(string.charAt(i))){
	    		   return false;
	    		}
	    	    }
	    	    return true;
	    	}	
		

}
