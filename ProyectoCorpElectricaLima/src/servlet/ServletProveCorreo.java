package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanProveCorreo;

public class ServletProveCorreo {

	List<BeanProveCorreo> array;

	public ServletProveCorreo() {
		array= new ArrayList<BeanProveCorreo>();
	}
	public  void adicionar(BeanProveCorreo exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanProveCorreo obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanProveCorreo eliminar(int alt){
		return array.remove(alt);
	}

}
