package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCargarTareasReporte;

   
public class ServletCargarTareasReporte
{
	 List<BeanCargarTareasReporte> array;

		public ServletCargarTareasReporte() {
			array= new ArrayList<BeanCargarTareasReporte>();
		}
		public  void adicionar(BeanCargarTareasReporte exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCargarTareasReporte obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCargarTareasReporte eliminar(int alt){
			return array.remove(alt);
		}
		

}