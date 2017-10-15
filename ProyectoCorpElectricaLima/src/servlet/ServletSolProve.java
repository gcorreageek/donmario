package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanSolProve;

public class ServletSolProve {

	 List<BeanSolProve> array;

		public ServletSolProve() {
			array= new ArrayList<BeanSolProve>();
		}
		public  void adicionar(BeanSolProve exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanSolProve obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanSolProve eliminar(int alt){
			return array.remove(alt);
		}		

}
