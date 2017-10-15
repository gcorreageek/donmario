package beans;

public class BeanSolProveMailAuto {
	
	String cod_solprove,cod_ven,nom_ven,fec_sol,cod_prove,nom_prove,per_prove,sex_prove,
	mail_prove,hora_llamada,est_llamada,est_envio_mail;

	public BeanSolProveMailAuto(String cod_solprove, String cod_ven,
			String nom_ven, String fec_sol, String cod_prove, String nom_prove,
			String per_prove, String sex_prove, String mail_prove,
			String hora_llamada, String est_llamada, String est_envio_mail) {
		super();
		this.cod_solprove = cod_solprove;
		this.cod_ven = cod_ven;
		this.nom_ven = nom_ven;
		this.fec_sol = fec_sol;
		this.cod_prove = cod_prove;
		this.nom_prove = nom_prove;
		this.per_prove = per_prove;
		this.sex_prove = sex_prove;
		this.mail_prove = mail_prove;
		this.hora_llamada = hora_llamada;
		this.est_llamada = est_llamada;
		this.est_envio_mail = est_envio_mail;
	}

	public String getCod_solprove() {
		return cod_solprove;
	}

	public void setCod_solprove(String cod_solprove) {
		this.cod_solprove = cod_solprove;
	}

	public String getCod_ven() {
		return cod_ven;
	}

	public void setCod_ven(String cod_ven) {
		this.cod_ven = cod_ven;
	}

	public String getNom_ven() {
		return nom_ven;
	}

	public void setNom_ven(String nom_ven) {
		this.nom_ven = nom_ven;
	}

	public String getFec_sol() {
		return fec_sol;
	}

	public void setFec_sol(String fec_sol) {
		this.fec_sol = fec_sol;
	}

	public String getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(String cod_prove) {
		this.cod_prove = cod_prove;
	}

	public String getNom_prove() {
		return nom_prove;
	}

	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}

	public String getPer_prove() {
		return per_prove;
	}

	public void setPer_prove(String per_prove) {
		this.per_prove = per_prove;
	}

	public String getSex_prove() {
		return sex_prove;
	}

	public void setSex_prove(String sex_prove) {
		this.sex_prove = sex_prove;
	}

	public String getMail_prove() {
		return mail_prove;
	}

	public void setMail_prove(String mail_prove) {
		this.mail_prove = mail_prove;
	}

	public String getHora_llamada() {
		return hora_llamada;
	}

	public void setHora_llamada(String hora_llamada) {
		this.hora_llamada = hora_llamada;
	}

	public String getEst_llamada() {
		return est_llamada;
	}

	public void setEst_llamada(String est_llamada) {
		this.est_llamada = est_llamada;
	}

	public String getEst_envio_mail() {
		return est_envio_mail;
	}

	public void setEst_envio_mail(String est_envio_mail) {
		this.est_envio_mail = est_envio_mail;
	}

}
