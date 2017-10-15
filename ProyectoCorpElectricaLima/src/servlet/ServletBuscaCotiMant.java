package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanBuscaCotiMant;
public class ServletBuscaCotiMant
{
	 List<BeanBuscaCotiMant> array;

		public ServletBuscaCotiMant() {
			array= new ArrayList<BeanBuscaCotiMant>();
		}
		public  void adicionar(BeanBuscaCotiMant exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanBuscaCotiMant obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanBuscaCotiMant eliminar(int alt){
			return array.remove(alt);
		}

}