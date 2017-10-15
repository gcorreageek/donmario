package beans;

public class BeanNumOrden {

	String cod_ven;
	int num_orden;
	
	public BeanNumOrden() {
		super();
	}
	
	public BeanNumOrden(String cod_ven, int num_orden) {
		super();
		this.cod_ven = cod_ven;
		this.num_orden = num_orden;
	}
	
	public String getCod_ven() {
		return cod_ven;
	}
	public void setCod_ven(String cod_ven) {
		this.cod_ven = cod_ven;
	}
	public int getNum_orden() {
		return num_orden;
	}
	public void setNum_orden(int num_orden) {
		this.num_orden = num_orden;
	}

}
