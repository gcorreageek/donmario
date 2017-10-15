package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCliente;
public class ServletCliente
{
	 List<BeanCliente> array;

		public ServletCliente() {
			array= new ArrayList<BeanCliente>();
		}
		public  void adicionar(BeanCliente exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCliente obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCliente eliminar(int alt){
			return array.remove(alt);
		}

}