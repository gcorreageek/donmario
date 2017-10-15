package beans;

public class BeanEnvioMailAutoRep {
	
	String cod_cli;
	String nom_cli;
	String sex_cli;
	String mail_cli;
	String nom_ven; 
	String fec_rep;
	String fecc_rep;
	String est_rep;
	
	public BeanEnvioMailAutoRep() {
		super();
	}

	public BeanEnvioMailAutoRep(String cod_cli, String nom_cli, String sex_cli,
			String mail_cli, String nom_ven, String fec_rep, String fecc_rep,
			String est_rep) {
		super();
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.sex_cli = sex_cli;
		this.mail_cli = mail_cli;
		this.nom_ven = nom_ven;
		this.fec_rep = fec_rep;
		this.fecc_rep = fecc_rep;
		this.est_rep = est_rep;
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

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getMail_cli() {
		return mail_cli;
	}

	public void setMail_cli(String mail_cli) {
		this.mail_cli = mail_cli;
	}

	public String getNom_ven() {
		return nom_ven;
	}

	public void setNom_ven(String nom_ven) {
		this.nom_ven = nom_ven;
	}

	public String getFec_rep() {
		return fec_rep;
	}

	public void setFec_rep(String fec_rep) {
		this.fec_rep = fec_rep;
	}

	public String getFecc_rep() {
		return fecc_rep;
	}

	public void setFecc_rep(String fecc_rep) {
		this.fecc_rep = fecc_rep;
	}

	public String getEst_rep() {
		return est_rep;
	}

	public void setEst_rep(String est_rep) {
		this.est_rep = est_rep;
	}
	
}
	
	
	