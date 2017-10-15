package beans;

public class BeanListarCliCorreo {

	int cod_cli;
	String nom_cli,cona_cli,mail_cli;
	int sex_cli;
	
	public BeanListarCliCorreo(int cod_cli, String nom_cli, String cona_cli,
			String mail_cli, int sex_cli) {
		super();
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.cona_cli = cona_cli;
		this.mail_cli = mail_cli;
		this.sex_cli = sex_cli;
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

	public String getCona_cli() {
		return cona_cli;
	}

	public void setCona_cli(String cona_cli) {
		this.cona_cli = cona_cli;
	}

	public String getMail_cli() {
		return mail_cli;
	}

	public void setMail_cli(String mail_cli) {
		this.mail_cli = mail_cli;
	}

	public int getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(int sex_cli) {
		this.sex_cli = sex_cli;
	}
	
}
