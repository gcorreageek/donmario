package beans;

public class BeanMasivoPub {
	
	String cod_cli,cod_publi,nom_publi,fec_mas,asu_mas,num_veces;

	public BeanMasivoPub(String cod_cli, String cod_publi, String nom_publi,
			String fec_mas, String asu_mas, String num_veces) {
		super();
		this.cod_cli = cod_cli;
		this.cod_publi = cod_publi;
		this.nom_publi = nom_publi;
		this.fec_mas = fec_mas;
		this.asu_mas = asu_mas;
		this.num_veces = num_veces;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getCod_publi() {
		return cod_publi;
	}

	public void setCod_publi(String cod_publi) {
		this.cod_publi = cod_publi;
	}

	public String getNom_publi() {
		return nom_publi;
	}

	public void setNom_publi(String nom_publi) {
		this.nom_publi = nom_publi;
	}

	public String getFec_mas() {
		return fec_mas;
	}

	public void setFec_mas(String fec_mas) {
		this.fec_mas = fec_mas;
	}

	public String getAsu_mas() {
		return asu_mas;
	}

	public void setAsu_mas(String asu_mas) {
		this.asu_mas = asu_mas;
	}

	public String getNum_veces() {
		return num_veces;
	}

	public void setNum_veces(String num_veces) {
		this.num_veces = num_veces;
	}
	

}
