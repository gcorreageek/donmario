package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCotizacionUnItem;

public class ServletCotizacionUnItem {

	 List<BeanCotizacionUnItem> array;

		public ServletCotizacionUnItem() {
			array= new ArrayList<BeanCotizacionUnItem>();
		}
		public  void adicionar(BeanCotizacionUnItem exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCotizacionUnItem obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCotizacionUnItem eliminar(int alt){
			return array.remove(alt);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
