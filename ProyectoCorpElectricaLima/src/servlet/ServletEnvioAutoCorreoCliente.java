package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioCliente;

public class ServletEnvioAutoCorreoCliente
{
	 List<BeanEnvioCliente> array;

		public ServletEnvioAutoCorreoCliente() {
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
		public int tama�o(){
			return array.size();
		}
		public BeanEnvioCliente eliminar(int alt){
			return array.remove(alt);
		}

}