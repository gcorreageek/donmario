package beans;


public class BeanCotizacion {
	
	int cant,cod_ven,id_cot;
	String cod_provee,cod_cli2,cod_prod2,cod_prodalt,coste;
	double precioConPorce,precioConPorceXCant,costoReal,costoRealXCant,dif,porce;
	String fec_cot,nom_prod,umed,marca,nom_prove;//util
	
	public BeanCotizacion(int cant, String cod_cli2, String cod_prod2,
			String cod_provee, int cod_ven, String coste, double dif,
			String fec_cot, int id_cot, String marca, String nom_prod,
			String nom_prove, double precioConPorce, double precioConPorceXCant, double costoReal,
			double costoRealXCant, String umed,double porce,String cod_prodalt) {
		super();
		this.cant = cant;
		this.cod_cli2 = cod_cli2;
		this.cod_prod2 = cod_prod2;
		this.cod_provee = cod_provee;
		this.cod_ven = cod_ven;
		this.coste = coste;
		this.dif = dif;
		this.fec_cot = fec_cot;
		this.id_cot = id_cot;
		this.marca = marca;
		this.nom_prod = nom_prod;
		this.nom_prove = nom_prove;
		this.precioConPorce = precioConPorce;
		this.precioConPorceXCant = precioConPorceXCant;
		this.costoReal = costoReal;
		this.costoRealXCant = costoRealXCant;
		this.umed = umed;
		this.porce=porce;
		this.cod_prodalt=cod_prodalt;
	}

	
	
	public String getCod_prodalt() {
		return cod_prodalt;
	}



	public void setCod_prodalt(String cod_prodalt) {
		this.cod_prodalt = cod_prodalt;
	}



	public double getPorce() {
		return porce;
	}



	public void setPorce(double porce) {
		this.porce = porce;
	}



	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int getCod_ven() {
		return cod_ven;
	}

	public void setCod_ven(int cod_ven) {
		this.cod_ven = cod_ven;
	}

	public int getId_cot() {
		return id_cot;
	}

	public void setId_cot(int id_cot) {
		this.id_cot = id_cot;
	}

	public String getCod_provee() {
		return cod_provee;
	}

	public void setCod_provee(String cod_provee) {
		this.cod_provee = cod_provee;
	}

	public String getCod_cli2() {
		return cod_cli2;
	}

	public void setCod_cli2(String cod_cli2) {
		this.cod_cli2 = cod_cli2;
	}

	public String getCod_prod2() {
		return cod_prod2;
	}

	public void setCod_prod2(String cod_prod2) {
		this.cod_prod2 = cod_prod2;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public double getPrecioConPorce() {
		return precioConPorce;
	}

	public void setPrecioConPorce(double precioConPorce) {
		this.precioConPorce = precioConPorce;
	}

	public double getPrecioConPorceXCant() {
		return precioConPorceXCant;
	}

	public void setPrecioConPorceXCant(double precioConPorceXCant) {
		this.precioConPorceXCant = precioConPorceXCant;
	}

	public double getCostoReal() {
		return costoReal;
	}

	public void setCostoReal(double costoReal) {
		this.costoReal = costoReal;
	}

	public double getCostoRealXCant() {
		return costoRealXCant;
	}

	public void setCostoRealXCant(double costoRealXCant) {
		this.costoRealXCant = costoRealXCant;
	}

	public double getDif() {
		return dif;
	}

	public void setDif(double dif) {
		this.dif = dif;
	}

	public String getFec_cot() {
		return fec_cot;
	}

	public void setFec_cot(String fec_cot) {
		this.fec_cot = fec_cot;
	}

	public String getNom_prod() {
		return nom_prod;
	}

	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}

	public String getUmed() {
		return umed;
	}

	public void setUmed(String umed) {
		this.umed = umed;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNom_prove() {
		return nom_prove;
	}

	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}

	


	
	

	
	
	
	
}
