package beans;

public class BeanBuscarProdCoti {
	
	int cod_proveprodmarumed;
	String coste;
	double cos_det;
	String mon_det;
	int igv_det;
	String cod_mar,nom_mar,cod_umed,nom_umed,obs_prod,fec_det,
	cod_prove,nom_prove,cod_prod,nom_prod,peso_prod,mod_prod;
	int act_prod;
	
	public BeanBuscarProdCoti() {
		super();
	}

	public BeanBuscarProdCoti(int cod_proveprodmarumed, String coste,
			double cos_det, String mon_det, int igv_det, String cod_mar,
			String nom_mar, String cod_umed, String nom_umed, String obs_prod,
			String fec_det, String cod_prove, String nom_prove,
			String cod_prod, String nom_prod, String peso_prod,
			String mod_prod, int act_prod) {
		super();
		this.cod_proveprodmarumed = cod_proveprodmarumed;
		this.coste = coste;
		this.cos_det = cos_det;
		this.mon_det = mon_det;
		this.igv_det = igv_det;
		this.cod_mar = cod_mar;
		this.nom_mar = nom_mar;
		this.cod_umed = cod_umed;
		this.nom_umed = nom_umed;
		this.obs_prod = obs_prod;
		this.fec_det = fec_det;
		this.cod_prove = cod_prove;
		this.nom_prove = nom_prove;
		this.cod_prod = cod_prod;
		this.nom_prod = nom_prod;
		this.peso_prod = peso_prod;
		this.mod_prod = mod_prod;
		this.act_prod = act_prod;
	}

	public int getCod_proveprodmarumed() {
		return cod_proveprodmarumed;
	}

	public void setCod_proveprodmarumed(int cod_proveprodmarumed) {
		this.cod_proveprodmarumed = cod_proveprodmarumed;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public double getCos_det() {
		return cos_det;
	}

	public void setCos_det(double cos_det) {
		this.cos_det = cos_det;
	}

	public String getMon_det() {
		return mon_det;
	}

	public void setMon_det(String mon_det) {
		this.mon_det = mon_det;
	}

	public int getIgv_det() {
		return igv_det;
	}

	public void setIgv_det(int igv_det) {
		this.igv_det = igv_det;
	}

	public String getCod_mar() {
		return cod_mar;
	}

	public void setCod_mar(String cod_mar) {
		this.cod_mar = cod_mar;
	}

	public String getNom_mar() {
		return nom_mar;
	}

	public void setNom_mar(String nom_mar) {
		this.nom_mar = nom_mar;
	}

	public String getCod_umed() {
		return cod_umed;
	}

	public void setCod_umed(String cod_umed) {
		this.cod_umed = cod_umed;
	}

	public String getNom_umed() {
		return nom_umed;
	}

	public void setNom_umed(String nom_umed) {
		this.nom_umed = nom_umed;
	}

	public String getObs_prod() {
		return obs_prod;
	}

	public void setObs_prod(String obs_prod) {
		this.obs_prod = obs_prod;
	}

	public String getFec_det() {
		return fec_det;
	}

	public void setFec_det(String fec_det) {
		this.fec_det = fec_det;
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

	public String getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(String cod_prod) {
		this.cod_prod = cod_prod;
	}

	public String getNom_prod() {
		return nom_prod;
	}

	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}

	public String getPeso_prod() {
		return peso_prod;
	}

	public void setPeso_prod(String peso_prod) {
		this.peso_prod = peso_prod;
	}

	public String getMod_prod() {
		return mod_prod;
	}

	public void setMod_prod(String mod_prod) {
		this.mod_prod = mod_prod;
	}

	public int getAct_prod() {
		return act_prod;
	}

	public void setAct_prod(int act_prod) {
		this.act_prod = act_prod;
	}

}
