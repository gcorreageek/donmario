package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanReporte;

   
public class ServletReporte
{
	 List<BeanReporte> array;

		public ServletReporte() {
			array= new ArrayList<BeanReporte>();
		}
		public  void adicionar(BeanReporte exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanReporte obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanReporte eliminar(int alt){
			return array.remove(alt);
		}
		

}