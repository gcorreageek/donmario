package beans;

public class BeanProveMarcas {
	
	int cod_proveemar,cod_prove;
	String nom_prove;
	int cod_mar;
	String nom_mar;
	
	public BeanProveMarcas() {
		super();
	}

	public BeanProveMarcas(int cod_proveemar, int cod_prove, String nom_prove,
			int cod_mar, String nom_mar) {
		super();
		this.cod_proveemar = cod_proveemar;
		this.cod_prove = cod_prove;
		this.nom_prove = nom_prove;
		this.cod_mar = cod_mar;
		this.nom_mar = nom_mar;
	}

	public int getCod_proveemar() {
		return cod_proveemar;
	}

	public void setCod_proveemar(int cod_proveemar) {
		this.cod_proveemar = cod_proveemar;
	}

	public int getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(int cod_prove) {
		this.cod_prove = cod_prove;
	}

	public String getNom_prove() {
		return nom_prove;
	}

	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}

	public int getCod_mar() {
		return cod_mar;
	}

	public void setCod_mar(int cod_mar) {
		this.cod_mar = cod_mar;
	}

	public String getNom_mar() {
		return nom_mar;
	}

	public void setNom_mar(String nom_mar) {
		this.nom_mar = nom_mar;
	}
	
	

}
