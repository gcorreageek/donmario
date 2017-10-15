package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanSolProveMailAuto;

public class ServletSolProveMailAuto {

	 List<BeanSolProveMailAuto> array;

		public ServletSolProveMailAuto() {
			array= new ArrayList<BeanSolProveMailAuto>();
		}
		public  void adicionar(BeanSolProveMailAuto exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanSolProveMailAuto obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanSolProveMailAuto eliminar(int alt){
			return array.remove(alt);
		}		

}
