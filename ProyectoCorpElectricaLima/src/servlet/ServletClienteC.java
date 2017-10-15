package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanClienteC;

public class ServletClienteC {

	 List<BeanClienteC> array;

		public ServletClienteC() {
			array= new ArrayList<BeanClienteC>();
		}
		public  void adicionar(BeanClienteC exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanClienteC obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanClienteC eliminar(int alt){
			return array.remove(alt);
		}

}
