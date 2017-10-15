package beans;

public class BeanEnvioMailsCli {
	
	String cod_envio;
	String nom_ven;
	String cod_cli;
	String cona_cli;
	String sex_cli;
	String maila_cli;
	String mailb_cli;
	String fecha;
	String est_envio;
	
	public BeanEnvioMailsCli(String cod_envio, String nom_ven, String cod_cli,
			String cona_cli, String sex_cli, String maila_cli,
			String mailb_cli, String fecha, String est_envio) {
		super();
		this.cod_envio = cod_envio;
		this.nom_ven = nom_ven;
		this.cod_cli = cod_cli;
		this.cona_cli = cona_cli;
		this.sex_cli = sex_cli;
		this.maila_cli = maila_cli;
		this.mailb_cli = mailb_cli;
		this.fecha = fecha;
		this.est_envio = est_envio;
	}

	public String getCod_envio() {
		return cod_envio;
	}

	public void setCod_envio(String cod_envio) {
		this.cod_envio = cod_envio;
	}

	public String getNom_ven() {
		return nom_ven;
	}

	public void setNom_ven(String nom_ven) {
		this.nom_ven = nom_ven;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getCona_cli() {
		return cona_cli;
	}

	public void setCona_cli(String cona_cli) {
		this.cona_cli = cona_cli;
	}

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getMaila_cli() {
		return maila_cli;
	}

	public void setMaila_cli(String maila_cli) {
		this.maila_cli = maila_cli;
	}

	public String getMailb_cli() {
		return mailb_cli;
	}

	public void setMailb_cli(String mailb_cli) {
		this.mailb_cli = mailb_cli;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEst_envio() {
		return est_envio;
	}

	public void setEst_envio(String est_envio) {
		this.est_envio = est_envio;
	}
	
	

}
