package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCliCita;
   
public class ServletCliCita
{
	 List<BeanCliCita> array;

		public ServletCliCita() {
			array= new ArrayList<BeanCliCita>();
		}
		public  void adicionar(BeanCliCita exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanCliCita obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanCliCita eliminar(int alt){
			return array.remove(alt);
		}

}