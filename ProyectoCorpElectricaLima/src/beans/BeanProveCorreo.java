package beans;

public class BeanProveCorreo {
	
	String cod_prove,cod_rubro,per_prove,sex_prove,mail_prove;

	public BeanProveCorreo() {
		super();
	}

	public BeanProveCorreo(String cod_prove, String cod_rubro,
			String per_prove, String sex_prove, String mail_prove) {
		super();
		this.cod_prove = cod_prove;
		this.cod_rubro = cod_rubro;
		this.per_prove = per_prove;
		this.sex_prove = sex_prove;
		this.mail_prove = mail_prove;
	}

	public String getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(String cod_prove) {
		this.cod_prove = cod_prove;
	}

	public String getCod_rubro() {
		return cod_rubro;
	}

	public void setCod_rubro(String cod_rubro) {
		this.cod_rubro = cod_rubro;
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
	
	
	
}
