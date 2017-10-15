package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanClienteCError;

public class ServletClienteError {

	
	 List<BeanClienteCError> array;

		public ServletClienteError() {
			array= new ArrayList<BeanClienteCError>();
		}
		public  void adicionar(BeanClienteCError exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanClienteCError obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanClienteCError eliminar(int alt){
			return array.remove(alt);
		}
}
