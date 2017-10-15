package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanListarCliCorreo;

public class ServletListarCliCorreo {

	 List<BeanListarCliCorreo> array;

		public ServletListarCliCorreo() {
			array= new ArrayList<BeanListarCliCorreo>();
		}
		public  void adicionar(BeanListarCliCorreo exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanListarCliCorreo obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanListarCliCorreo eliminar(int alt){
			return array.remove(alt);
		}		

}
