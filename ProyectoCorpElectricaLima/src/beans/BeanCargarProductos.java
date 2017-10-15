package beans;

public class BeanCargarProductos {
	
      private String cod_prod;
      private String nom_prod;
      private String cod_rubro;
      private String obs_prod;
      private String est_prod;
      private String peso_prod;
      private String act_prod;
      private String mod_prod;
      private String esp_prod;
      private String mar_prod;
      private String codpro_prod;
      
	public BeanCargarProductos(String cod_prod, String nom_prod,
			String cod_rubro, String obs_prod, String est_prod,
			String peso_prod, String act_prod, String mod_prod,
			String esp_prod, String mar_prod, String codpro_prod) {
		super();
		this.cod_prod = cod_prod;
		this.nom_prod = nom_prod;
		this.cod_rubro = cod_rubro;
		this.obs_prod = obs_prod;
		this.est_prod = est_prod;
		this.peso_prod = peso_prod;
		this.act_prod = act_prod;
		this.mod_prod = mod_prod;
		this.esp_prod = esp_prod;
		this.mar_prod = mar_prod;
		this.codpro_prod = codpro_prod;
	}
      
    
	public BeanCargarProductos(){
		
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


	public String getCod_rubro() {
		return cod_rubro;
	}


	public void setCod_rubro(String cod_rubro) {
		this.cod_rubro = cod_rubro;
	}


	public String getObs_prod() {
		return obs_prod;
	}


	public void setObs_prod(String obs_prod) {
		this.obs_prod = obs_prod;
	}


	public String getEst_prod() {
		return est_prod;
	}


	public void setEst_prod(String est_prod) {
		this.est_prod = est_prod;
	}


	public String getPeso_prod() {
		return peso_prod;
	}


	public void setPeso_prod(String peso_prod) {
		this.peso_prod = peso_prod;
	}


	public String getAct_prod() {
		return act_prod;
	}


	public void setAct_prod(String act_prod) {
		this.act_prod = act_prod;
	}


	public String getMod_prod() {
		return mod_prod;
	}


	public void setMod_prod(String mod_prod) {
		this.mod_prod = mod_prod;
	}


	public String getEsp_prod() {
		return esp_prod;
	}


	public void setEsp_prod(String esp_prod) {
		this.esp_prod = esp_prod;
	}


	public String getMar_prod() {
		return mar_prod;
	}


	public void setMar_prod(String mar_prod) {
		this.mar_prod = mar_prod;
	}


	public String getCodpro_prod() {
		return codpro_prod;
	}


	public void setCodpro_prod(String codpro_prod) {
		this.codpro_prod = codpro_prod;
	}

  
}
