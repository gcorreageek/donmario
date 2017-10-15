package beans;

public class BeanEnvioMailAuto {
  
	String id_mail;
	String fec_pemail;
	String fec_semail;
	String cod_ven;
	String nom_ven;
	String time_ven;
	String cod_cli;
	String nom_cli;
	String mail_cli;
	String sex_cli;
	String est_mail;
	String est_mail2;
	String ref;
	String est_emp;
	
	public BeanEnvioMailAuto() {
		super();
	}

	public BeanEnvioMailAuto(String id_mail, String fec_pemail,
			String fec_semail, String cod_ven, String nom_ven, String time_ven,
			String cod_cli, String nom_cli, String mail_cli, String sex_cli,
			String est_mail, String est_mail2, String ref, String est_emp) {
		super();
		this.id_mail = id_mail;
		this.fec_pemail = fec_pemail;
		this.fec_semail = fec_semail;
		this.cod_ven = cod_ven;
		this.nom_ven = nom_ven;
		this.time_ven = time_ven;
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.mail_cli = mail_cli;
		this.sex_cli = sex_cli;
		this.est_mail = est_mail;
		this.est_mail2 = est_mail2;
		this.ref = ref;
		this.est_emp = est_emp;
	}

	public String getId_mail() {
		return id_mail;
	}

	public void setId_mail(String id_mail) {
		this.id_mail = id_mail;
	}

	public String getFec_pemail() {
		return fec_pemail;
	}

	public void setFec_pemail(String fec_pemail) {
		this.fec_pemail = fec_pemail;
	}

	public String getFec_semail() {
		return fec_semail;
	}

	public void setFec_semail(String fec_semail) {
		this.fec_semail = fec_semail;
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

	public String getTime_ven() {
		return time_ven;
	}

	public void setTime_ven(String time_ven) {
		this.time_ven = time_ven;
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

	public String getMail_cli() {
		return mail_cli;
	}

	public void setMail_cli(String mail_cli) {
		this.mail_cli = mail_cli;
	}

	public String getSex_cli() {
		return sex_cli;
	}

	public void setSex_cli(String sex_cli) {
		this.sex_cli = sex_cli;
	}

	public String getEst_mail() {
		return est_mail;
	}

	public void setEst_mail(String est_mail) {
		this.est_mail = est_mail;
	}

	public String getEst_mail2() {
		return est_mail2;
	}

	public void setEst_mail2(String est_mail2) {
		this.est_mail2 = est_mail2;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getEst_emp() {
		return est_emp;
	}

	public void setEst_emp(String est_emp) {
		this.est_emp = est_emp;
	}
	

}