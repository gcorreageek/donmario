package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanBusProd;
public class ServletBusProd
{
	 List<BeanBusProd> array;

		public ServletBusProd() {
			array= new ArrayList<BeanBusProd>();
		}
		public  void adicionar(BeanBusProd exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanBusProd obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanBusProd eliminar(int alt){
			return array.remove(alt);
		}

}