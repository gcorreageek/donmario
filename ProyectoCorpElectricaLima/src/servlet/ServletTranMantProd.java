package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanTranMantProd;
public class ServletTranMantProd
{
	 List<BeanTranMantProd> array;

		public ServletTranMantProd() {
			array= new ArrayList<BeanTranMantProd>();
		}
		public  void adicionar(BeanTranMantProd exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanTranMantProd obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanTranMantProd eliminar(int alt){
			return array.remove(alt);
		}

}