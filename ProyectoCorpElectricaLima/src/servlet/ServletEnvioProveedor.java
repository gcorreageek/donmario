package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioProveedor;

public class ServletEnvioProveedor {

	List<BeanEnvioProveedor> array;

	public ServletEnvioProveedor() {
		array= new ArrayList<BeanEnvioProveedor>();
	}
	public  void adicionar(BeanEnvioProveedor exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanEnvioProveedor obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanEnvioProveedor eliminar(int alt){
		return array.remove(alt);
	}
}
