package beans;

public class BeanEnvioMailsAutoProv {
	
	String nom_prove,sexprove,mail_prove,nom_ven,cod_ref,fec_pemail,fec_semail,est_mail,est_mail2;

	public BeanEnvioMailsAutoProv() {
		super();
	}

	

	public BeanEnvioMailsAutoProv(String nom_prove, String sexprove,
			String mail_prove, String nom_ven, String cod_ref,
			String fec_pemail, String fec_semail, String est_mail,
			String est_mail2) {
		super();
		this.nom_prove = nom_prove;
		this.sexprove = sexprove;
		this.mail_prove = mail_prove;
		this.nom_ven = nom_ven;
		this.cod_ref = cod_ref;
		this.fec_pemail = fec_pemail;
		this.fec_semail = fec_semail;
		this.est_mail = est_mail;
		this.est_mail2 = est_mail2;
	}



	public String getNom_prove() {
		return nom_prove;
	}



	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}



	public String getSexprove() {
		return sexprove;
	}



	public void setSexprove(String sexprove) {
		this.sexprove = sexprove;
	}



	public String getMail_prove() {
		return mail_prove;
	}



	public void setMail_prove(String mail_prove) {
		this.mail_prove = mail_prove;
	}



	public String getNom_ven() {
		return nom_ven;
	}



	public void setNom_ven(String nom_ven) {
		this.nom_ven = nom_ven;
	}



	public String getCod_ref() {
		return cod_ref;
	}



	public void setCod_ref(String cod_ref) {
		this.cod_ref = cod_ref;
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
	

}
