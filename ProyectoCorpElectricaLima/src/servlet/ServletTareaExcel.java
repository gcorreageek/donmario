package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanTareaAExcel;

   
public class ServletTareaExcel
{
	 List<BeanTareaAExcel> array;

		public ServletTareaExcel() {
			array= new ArrayList<BeanTareaAExcel>();
		}
		public  void adicionar(BeanTareaAExcel exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanTareaAExcel obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanTareaAExcel eliminar(int alt){
			return array.remove(alt);
		}
		

}