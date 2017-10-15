package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProveProdMarUmed;

public class ServletProveProdMarUmed {

	
	 List<BeanProveProdMarUmed> array;

		public ServletProveProdMarUmed() {
			array= new ArrayList<BeanProveProdMarUmed>();
		}
		public  void adicionar(BeanProveProdMarUmed exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanProveProdMarUmed obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanProveProdMarUmed eliminar(int alt){
			return array.remove(alt);
		}
		
	
	
}
