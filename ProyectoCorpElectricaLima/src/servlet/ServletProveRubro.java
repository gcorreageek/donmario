package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProveRubro;
   
public class ServletProveRubro
{
	 List<BeanProveRubro> array;

		public ServletProveRubro() {
			array= new ArrayList<BeanProveRubro>();
		}
		public  void adicionar(BeanProveRubro exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanProveRubro obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanProveRubro eliminar(int alt){
			return array.remove(alt);
		}

}