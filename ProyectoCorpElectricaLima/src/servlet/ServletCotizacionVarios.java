package servlet;

import java.util.ArrayList;

import beans.BeanCotizacionVarios;

public class ServletCotizacionVarios {

	 ArrayList<BeanCotizacionVarios> array;

		public ServletCotizacionVarios() {
			array= new ArrayList<BeanCotizacionVarios>();
		}
		public  void adicionar(BeanCotizacionVarios exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCotizacionVarios obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCotizacionVarios eliminar(int alt){
			return array.remove(alt);
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
