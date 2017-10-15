package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProveedor;

public class ServletProveedor {

	List<BeanProveedor> array;

	public ServletProveedor() {
		array= new ArrayList<BeanProveedor>();
	}
	public  void adicionar(BeanProveedor exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanProveedor obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanProveedor eliminar(int alt){
		return array.remove(alt);
	}

}
