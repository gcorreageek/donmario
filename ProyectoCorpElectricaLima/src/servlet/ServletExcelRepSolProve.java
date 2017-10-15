package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanExcelRepSol;

public class ServletExcelRepSolProve {

	 List<BeanExcelRepSol> array;

		public ServletExcelRepSolProve() {
			array= new ArrayList<BeanExcelRepSol>();
		}
		public  void adicionar(BeanExcelRepSol exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanExcelRepSol obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanExcelRepSol eliminar(int alt){
			return array.remove(alt);
		}		

}
