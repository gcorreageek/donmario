package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanBuscarProdCoti;


public class ServletBuscarProdCoti {

	 List<BeanBuscarProdCoti> array;

		public ServletBuscarProdCoti() {
			array= new ArrayList<BeanBuscarProdCoti>();
		}
		public  void adicionar(BeanBuscarProdCoti exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanBuscarProdCoti obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanBuscarProdCoti eliminar(int alt){
			return array.remove(alt);
		}

}
