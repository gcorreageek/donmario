package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCotizacion;


public class ServletCotizacion {

	 List<BeanCotizacion> array;

		public ServletCotizacion() {
			array= new ArrayList<BeanCotizacion>();
		}
		public  void adicionar(BeanCotizacion exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCotizacion obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCotizacion eliminar(int alt){
			return array.remove(alt);
		}
		
	
	
	
	
	
	
	
	
	
	
	
}
