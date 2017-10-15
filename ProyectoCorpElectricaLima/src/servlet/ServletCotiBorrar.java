package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanCoti_borrar;


public class ServletCotiBorrar {

	List<BeanCoti_borrar> array;

	public ServletCotiBorrar() {
		array= new ArrayList<BeanCoti_borrar>();
	}
	public  void adicionar(BeanCoti_borrar exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanCoti_borrar obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanCoti_borrar eliminar(int alt){
		return array.remove(alt);
	}
	
}
