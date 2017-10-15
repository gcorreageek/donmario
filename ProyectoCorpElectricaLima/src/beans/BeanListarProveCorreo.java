package beans;

public class BeanListarProveCorreo {

int cod_prove;
String nom_prove,per_prove,mail_prove;
int sex_prove;

public BeanListarProveCorreo(int cod_prove, String nom_prove, String per_prove,
		String mail_prove, int sex_prove) {
	super();
	this.cod_prove = cod_prove;
	this.nom_prove = nom_prove;
	this.per_prove = per_prove;
	this.mail_prove = mail_prove;
	this.sex_prove = sex_prove;
}

public int getCod_prove() {
	return cod_prove;
}

public void setCod_prove(int cod_prove) {
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

public String getMail_prove() {
	return mail_prove;
}

public void setMail_prove(String mail_prove) {
	this.mail_prove = mail_prove;
}

public int getSex_prove() {
	return sex_prove;
}

public void setSex_prove(int sex_prove) {
	this.sex_prove = sex_prove;
}


}
