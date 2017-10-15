package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCotizacionInconclusa;

   
public class ServletCotizacionInconclusa
{
	 List<BeanCotizacionInconclusa> array;

		public ServletCotizacionInconclusa() {
			array= new ArrayList<BeanCotizacionInconclusa>();
		}
		public  void adicionar(BeanCotizacionInconclusa exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCotizacionInconclusa obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCotizacionInconclusa eliminar(int alt){
			return array.remove(alt);
		}
		

}