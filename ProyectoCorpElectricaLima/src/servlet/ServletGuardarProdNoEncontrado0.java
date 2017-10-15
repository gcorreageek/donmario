package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanGuardarProdNoEncontrados0;


public class ServletGuardarProdNoEncontrado0 {

	 List<BeanGuardarProdNoEncontrados0> array;

		public ServletGuardarProdNoEncontrado0() {
			array= new ArrayList<BeanGuardarProdNoEncontrados0>();
		}
		public  void adicionar(BeanGuardarProdNoEncontrados0 exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanGuardarProdNoEncontrados0 obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanGuardarProdNoEncontrados0 eliminar(int alt){
			return array.remove(alt);
		}

}
