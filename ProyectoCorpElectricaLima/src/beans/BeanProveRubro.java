package beans;

public class BeanProveRubro {
	
	int cod_proverubro,cod_prove;
	String nom_prove;
	int cod_rubro;
	String nom_rubro;
	int cod_mar;
	String nom_mar;
	
	public BeanProveRubro() {
		super();
	}

	public BeanProveRubro(int cod_proverubro, int cod_prove, String nom_prove,
			int cod_rubro, String nom_rubro, int cod_mar, String nom_mar) {
		super();
		this.cod_proverubro = cod_proverubro;
		this.cod_prove = cod_prove;
		this.nom_prove = nom_prove;
		this.cod_rubro = cod_rubro;
		this.nom_rubro = nom_rubro;
		this.cod_mar = cod_mar;
		this.nom_mar = nom_mar;
	}

	public int getCod_proverubro() {
		return cod_proverubro;
	}

	public void setCod_proverubro(int cod_proverubro) {
		this.cod_proverubro = cod_proverubro;
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

	public int getCod_rubro() {
		return cod_rubro;
	}

	public void setCod_rubro(int cod_rubro) {
		this.cod_rubro = cod_rubro;
	}

	public String getNom_rubro() {
		return nom_rubro;
	}

	public void setNom_rubro(String nom_rubro) {
		this.nom_rubro = nom_rubro;
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
