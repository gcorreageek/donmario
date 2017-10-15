package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanClienteRubro;
   
public class ServletCliRubro
{
	 List<BeanClienteRubro> array;

		public ServletCliRubro() {
			array= new ArrayList<BeanClienteRubro>();
		}
		public  void adicionar(BeanClienteRubro exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanClienteRubro obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanClienteRubro eliminar(int alt){
			return array.remove(alt);
		}

}