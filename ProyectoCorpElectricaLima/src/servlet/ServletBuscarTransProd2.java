package servlet;

import java.util.ArrayList;
import java.util.List;
import beans.BeanBuscarTransProd2;

public class ServletBuscarTransProd2
{
	    List<BeanBuscarTransProd2> array;

		public ServletBuscarTransProd2() {
			array= new ArrayList<BeanBuscarTransProd2>();
		}
		public  void adicionar(BeanBuscarTransProd2 exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanBuscarTransProd2 obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanBuscarTransProd2 eliminar(int alt){
			return array.remove(alt);
		}

}