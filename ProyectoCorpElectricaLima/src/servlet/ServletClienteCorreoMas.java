package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanClienteCorreoMasivo;
public class ServletClienteCorreoMas
{
	 List<BeanClienteCorreoMasivo> array;

		public ServletClienteCorreoMas() {
			array= new ArrayList<BeanClienteCorreoMasivo>();
		}
		public  void adicionar(BeanClienteCorreoMasivo exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanClienteCorreoMasivo obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanClienteCorreoMasivo eliminar(int alt){
			return array.remove(alt);
		}

}