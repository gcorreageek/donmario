package beans;

public class BeanExcelRepSol {

	String nom_prove,telf1_prove,telf2_prove,per_prove,fecha,referencia,nom_cliente,est_llamada,nom_ven;

	public BeanExcelRepSol(String nom_prove, String telf1_prove,
			String telf2_prove, String per_prove, String fecha,
			String referencia, String nom_cliente, String est_llamada,
			String nom_ven) {
		super();
		this.nom_prove = nom_prove;
		this.telf1_prove = telf1_prove;
		this.telf2_prove = telf2_prove;
		this.per_prove = per_prove;
		this.fecha = fecha;
		this.referencia = referencia;
		this.nom_cliente = nom_cliente;
		this.est_llamada = est_llamada;
		this.nom_ven = nom_ven;
	}

	public String getNom_prove() {
		return nom_prove;
	}

	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}

	public String getTelf1_prove() {
		return telf1_prove;
	}

	public void setTelf1_prove(String telf1_prove) {
		this.telf1_prove = telf1_prove;
	}

	public String getTelf2_prove() {
		return telf2_prove;
	}

	public void setTelf2_prove(String telf2_prove) {
		this.telf2_prove = telf2_prove;
	}

	public String getPer_prove() {
		return per_prove;
	}

	public void setPer_prove(String per_prove) {
		this.per_prove = per_prove;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getEst_llamada() {
		return est_llamada;
	}

	public void setEst_llamada(String est_llamada) {
		this.est_llamada = est_llamada;
	}

	public String getNom_ven() {
		return nom_ven;
	}

	public void setNom_ven(String nom_ven) {
		this.nom_ven = nom_ven;
	}
	
}
