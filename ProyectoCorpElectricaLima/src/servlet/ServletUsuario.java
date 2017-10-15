package servlet;

import java.util.ArrayList;
import java.util.List;
import beans.BeanUsuario;

public class ServletUsuario{
	
	 	List<BeanUsuario> array;

		public ServletUsuario() {
			array= new ArrayList<BeanUsuario>();
		}
		public  void adicionar(BeanUsuario exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanUsuario obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanUsuario eliminar(int alt){
			return array.remove(alt);
		}

}