package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanGuardarProdNoEncontrados;


public class ServletGuardarProdNoEncontrado {

	 List<BeanGuardarProdNoEncontrados> array;

		public ServletGuardarProdNoEncontrado() {
			array= new ArrayList<BeanGuardarProdNoEncontrados>();
		}
		public  void adicionar(BeanGuardarProdNoEncontrados exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanGuardarProdNoEncontrados obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanGuardarProdNoEncontrados eliminar(int alt){
			return array.remove(alt);
		}

}
