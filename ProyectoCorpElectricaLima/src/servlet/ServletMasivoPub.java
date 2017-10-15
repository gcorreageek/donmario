package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanMasivoPub;
public class ServletMasivoPub
{
	 List<BeanMasivoPub> array;

		public ServletMasivoPub() {
			array= new ArrayList<BeanMasivoPub>();
		}
		public  void adicionar(BeanMasivoPub exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanMasivoPub obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanMasivoPub eliminar(int alt){
			return array.remove(alt);
		}

}