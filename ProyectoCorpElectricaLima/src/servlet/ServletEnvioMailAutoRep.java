package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioMailAutoRep;
   
public class ServletEnvioMailAutoRep
{
	 List<BeanEnvioMailAutoRep> array;

		public ServletEnvioMailAutoRep() {
			array= new ArrayList<BeanEnvioMailAutoRep>();
		}
		public  void adicionar(BeanEnvioMailAutoRep exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioMailAutoRep obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioMailAutoRep eliminar(int alt){
			return array.remove(alt);
		}

}