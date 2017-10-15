package beans;

public class BeanEnvioCorreoCli {
   String cod_sol,cod_cli,cona_cli,sex_cli,maila_cli,mailb_cli,cod_ven,nom_ven,est_llamada,est_envio_mail,est_envio_mail2;

public BeanEnvioCorreoCli(String cod_sol, String cod_cli, String cona_cli,
		String sex_cli, String maila_cli, String mailb_cli, String cod_ven,
		String nom_ven, String est_llamada, String est_envio_mail,
		String est_envio_mail2) {
	super();
	this.cod_sol = cod_sol;
	this.cod_cli = cod_cli;
	this.cona_cli = cona_cli;
	this.sex_cli = sex_cli;
	this.maila_cli = maila_cli;
	this.mailb_cli = mailb_cli;
	this.cod_ven = cod_ven;
	this.nom_ven = nom_ven;
	this.est_llamada = est_llamada;
	this.est_envio_mail = est_envio_mail;
	this.est_envio_mail2 = est_envio_mail2;
}

public String getCod_sol() {
	return cod_sol;
}

public void setCod_sol(String cod_sol) {
	this.cod_sol = cod_sol;
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

public String getEst_envio_mail2() {
	return est_envio_mail2;
}

public void setEst_envio_mail2(String est_envio_mail2) {
	this.est_envio_mail2 = est_envio_mail2;
}

   
}
