package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioMailAutoCye;
   
public class ServletEnvioMailAutoCye
{
	 List<BeanEnvioMailAutoCye> array;

		public ServletEnvioMailAutoCye() {
			array= new ArrayList<BeanEnvioMailAutoCye>();
		}
		public  void adicionar(BeanEnvioMailAutoCye exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioMailAutoCye obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioMailAutoCye eliminar(int alt){
			return array.remove(alt);
		}

}