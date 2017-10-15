package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioMailAuto;
   
public class ServletEnvioMailAuto
{
	 List<BeanEnvioMailAuto> array;

		public ServletEnvioMailAuto() {
			array= new ArrayList<BeanEnvioMailAuto>();
		}
		public  void adicionar(BeanEnvioMailAuto exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioMailAuto obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioMailAuto eliminar(int alt){
			return array.remove(alt);
		}

}