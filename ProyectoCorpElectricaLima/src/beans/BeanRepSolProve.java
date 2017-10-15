package beans;

public class BeanRepSolProve {

	String cod_sol,cod_cli,nom_cli,cod_ven,nom_ven,ruta_sol,ref_sol,fec_sol,est_llamada,est_envio_mail,idArchivo;

	public BeanRepSolProve(String cod_sol, String cod_cli, String nom_cli,
			String cod_ven, String nom_ven, String ruta_sol, String ref_sol,
			String fec_sol, String est_llamada, String est_envio_mail, String idArchivo) {
		super();
		this.cod_sol = cod_sol;
		this.cod_cli = cod_cli;
		this.nom_cli = nom_cli;
		this.cod_ven = cod_ven;
		this.nom_ven = nom_ven;
		this.ruta_sol = ruta_sol;
		//System.out.println(ruta_sol+"--");
		this.ref_sol = ref_sol;
		this.fec_sol = fec_sol;
		this.est_llamada = est_llamada;
		this.est_envio_mail = est_envio_mail;
		this.idArchivo = idArchivo;
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

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
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

	public String getRuta_sol() {
		return ruta_sol;//"//Willy/d(d)/SOLICITUD_PROVEEDORES/";//ruta_sol;
	}

	public void setRuta_sol(String ruta_sol) {
		this.ruta_sol = ruta_sol;
	}

	public String getRef_sol() {
		return ref_sol;
	}

	public void setRef_sol(String ref_sol) {
		this.ref_sol = ref_sol;
	}

	public String getFec_sol() {
		return fec_sol;
	}

	public void setFec_sol(String fec_sol) {
		this.fec_sol = fec_sol;
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

	public String getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(String idArchivo) {
		this.idArchivo = idArchivo;
	}

	
	
}
