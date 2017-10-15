package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanRepSolProve;

public class ServletRepSolProve {

	 List<BeanRepSolProve> array;

		public ServletRepSolProve() {
			array= new ArrayList<BeanRepSolProve>();
		}
		public  void adicionar(BeanRepSolProve exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanRepSolProve obtener(int alt){
			return  array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanRepSolProve eliminar(int alt){
			return array.remove(alt);
		}		

}
