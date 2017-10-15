package servlet;

import java.util.ArrayList;
import java.util.List;

import beans.BeanEnvioCorreoCli;

public class ServletSolCliMailAuto {

	 List<BeanEnvioCorreoCli> array;

		public ServletSolCliMailAuto() {
			array= new ArrayList<BeanEnvioCorreoCli>();
		}
		public  void adicionar(BeanEnvioCorreoCli exel){
			array.add(exel);
		}
		public void eliminarTodo(){
			array.clear();
		}
		public BeanEnvioCorreoCli obtener(int alt){
			return array.get(alt);
		}
		public int tamaño(){
			return array.size();
		}
		public BeanEnvioCorreoCli eliminar(int alt){
			return array.remove(alt);
		}		

}
