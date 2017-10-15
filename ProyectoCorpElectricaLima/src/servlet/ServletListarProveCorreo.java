package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanListarProveCorreo;

public class ServletListarProveCorreo {

	 List<BeanListarProveCorreo> array;

		public ServletListarProveCorreo() {
			array= new ArrayList<BeanListarProveCorreo>();
		}
		public  void adicionar(BeanListarProveCorreo exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanListarProveCorreo obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanListarProveCorreo eliminar(int alt){
			return array.remove(alt);
		}		

}
