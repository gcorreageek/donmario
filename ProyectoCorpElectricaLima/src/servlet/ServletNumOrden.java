package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanNumOrden;

   
public class ServletNumOrden
{
	 List<BeanNumOrden> array;

		public ServletNumOrden() {
			array= new ArrayList<BeanNumOrden>();
		}
		public  void adicionar(BeanNumOrden exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanNumOrden obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanNumOrden eliminar(int alt){
			return array.remove(alt);
		}
		

}