package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanGuardarProdNoEncontrados1;


public class ServletGuardarProdNoEncontrado1 {

	 List<BeanGuardarProdNoEncontrados1> array;

		public ServletGuardarProdNoEncontrado1() {
			array= new ArrayList<BeanGuardarProdNoEncontrados1>();
		}
		public  void adicionar(BeanGuardarProdNoEncontrados1 exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanGuardarProdNoEncontrados1 obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanGuardarProdNoEncontrados1 eliminar(int alt){
			return array.remove(alt);
		}

}
