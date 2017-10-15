package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioMailsAutoProv;
   
public class ServletEnvioMailsAutoProve
{
	 List<BeanEnvioMailsAutoProv> array;

		public ServletEnvioMailsAutoProve() {
			array= new ArrayList<BeanEnvioMailsAutoProv>();
		}
		public  void adicionar(BeanEnvioMailsAutoProv exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioMailsAutoProv obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioMailsAutoProv eliminar(int alt){
			return array.remove(alt);
		}

}