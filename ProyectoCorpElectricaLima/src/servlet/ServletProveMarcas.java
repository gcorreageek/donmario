package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProveMarcas;
   
public class ServletProveMarcas
{
	 List<BeanProveMarcas> array;

		public ServletProveMarcas() {
			array= new ArrayList<BeanProveMarcas>();
		}
		public  void adicionar(BeanProveMarcas exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanProveMarcas obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanProveMarcas eliminar(int alt){
			return array.remove(alt);
		}

}