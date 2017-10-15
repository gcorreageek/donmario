package beans;

public class BeanClienteCorreoMasivo {

	private String cod_cli;
	private String nom_cli;
	private String cona_cli;
	private String malia_cli;
	private String sex_cli;
	private String nom_tipo;
	private String cod_publi;
	private String nom_publi;
	private String fec_mas;
	private String asu_mas;
	private String num_veces;
	
	public BeanClienteCorreoMasivo(String cod_cli, String nom_cli,
			String cona_cli, String malia_cli, String sex_cli, String nom_tipo,
			String cod_publi, String nom_publi, String fec_mas, String asu_mas,
			String num_veces) {
		super();
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.cona_cli = cona_cli;
		this.malia_cli = malia_cli;
		this.sex_cli = sex_cli;
		this.nom_tipo = nom_tipo;
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

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getCona_cli() {
		return cona_cli;
	}

	public void setCona_cli(String cona_cli) {
		this.cona_cli = cona_cli;
	}

	public String getMalia_cli() {
		return malia_cli;
	}

	public void setMalia_cli(String malia_cli) {
		this.malia_cli = malia_cli;
	}

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getNom_tipo() {
		return nom_tipo;
	}

	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
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
