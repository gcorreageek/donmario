package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProdAltCogido;

public class ServletProdAltCogido {

	

	 List<BeanProdAltCogido> array;

		public ServletProdAltCogido() {
			array= new ArrayList<BeanProdAltCogido>();
		}
		public  void adicionar(BeanProdAltCogido exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanProdAltCogido obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanProdAltCogido eliminar(int alt){
			return array.remove(alt);
		}
		
	
	
	
	
	
}
