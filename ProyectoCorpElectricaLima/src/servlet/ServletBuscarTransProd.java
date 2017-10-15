package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanBuscarTransProd;
public class ServletBuscarTransProd
{
	    List<BeanBuscarTransProd> array;

		public ServletBuscarTransProd() {
			array= new ArrayList<BeanBuscarTransProd>();
		}
		public  void adicionar(BeanBuscarTransProd exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanBuscarTransProd obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanBuscarTransProd eliminar(int alt){
			return array.remove(alt);
		}

}