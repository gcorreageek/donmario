package beans;

public class BeanClienteRubro {

	int cod_clirubro,cod_cli;
	String nom_cli;
	int cod_rubro;
	String nom_rubro;
	
	
	public BeanClienteRubro() {
		super();
	}


	public BeanClienteRubro(int cod_clirubro, int cod_cli, String nom_cli,
			int cod_rubro, String nom_rubro) {
		super();
		this.cod_clirubro = cod_clirubro;
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.cod_rubro = cod_rubro;
		this.nom_rubro = nom_rubro;
	}


	public int getCod_clirubro() {
		return cod_clirubro;
	}


	public void setCod_clirubro(int cod_clirubro) {
		this.cod_clirubro = cod_clirubro;
	}


	public int getCod_cli() {
		return cod_cli;
	}


	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}


	public String getNom_cli() {
		return nom_cli;
	}


	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
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
	
	
}
