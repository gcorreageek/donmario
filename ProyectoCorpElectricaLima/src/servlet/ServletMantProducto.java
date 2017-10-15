package servlet;

import java.util.ArrayList;
import java.util.List;
import beans.BeanMantProducto;


public class ServletMantProducto{
	
	 List<BeanMantProducto> array;

		public ServletMantProducto() {
			array= new ArrayList<BeanMantProducto>();
		}
		public  void adicionar(BeanMantProducto exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanMantProducto obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanMantProducto eliminar(int alt){
			return array.remove(alt);
		}

}