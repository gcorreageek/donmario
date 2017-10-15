package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioCliente;

public class ServletEnvioCliente {

	List<BeanEnvioCliente> array;

	public ServletEnvioCliente() {
		array= new ArrayList<BeanEnvioCliente>();
	}
	public  void adicionar(BeanEnvioCliente exel){
		array.add(exel);
	}
	public void eliminarTodo(){
		array.clear();
	}
	public BeanEnvioCliente obtener(int alt){
		return array.get(alt);
	}
	public int tamaño(){
		return array.size();
	}
	public BeanEnvioCliente eliminar(int alt){
		return array.remove(alt);
	}
}
