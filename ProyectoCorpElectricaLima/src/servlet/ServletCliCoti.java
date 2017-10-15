package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCliCoti;
   
public class ServletCliCoti
{
	 List<BeanCliCoti> array;

		public ServletCliCoti() {
			array= new ArrayList<BeanCliCoti>();
		}
		public  void adicionar(BeanCliCoti exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCliCoti obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCliCoti eliminar(int alt){
			return array.remove(alt);
		}

}