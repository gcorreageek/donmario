package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioMailsCli;
   
public class ServletEnvioMailAutoCli
{
	 List<BeanEnvioMailsCli> array;

		public ServletEnvioMailAutoCli() {
			array= new ArrayList<BeanEnvioMailsCli>();
		}
		public  void adicionar(BeanEnvioMailsCli exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioMailsCli obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioMailsCli eliminar(int alt){
			return array.remove(alt);
		}

}