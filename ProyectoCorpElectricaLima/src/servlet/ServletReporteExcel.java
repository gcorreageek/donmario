package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanReporteAExcel;

   
public class ServletReporteExcel
{
	 List<BeanReporteAExcel> array;

		public ServletReporteExcel() {
			array= new ArrayList<BeanReporteAExcel>();
		}
		public  void adicionar(BeanReporteAExcel exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanReporteAExcel obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanReporteAExcel eliminar(int alt){
			return array.remove(alt);
		}
		

}