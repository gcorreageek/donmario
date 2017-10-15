package beans;

public class BeanGuardarProdNoEncontrados {
	
	String cod_rubro,nom_rubro,nom_prod,unidad,cantidad;

	public BeanGuardarProdNoEncontrados() {
		super();
	}

	public BeanGuardarProdNoEncontrados(String cod_rubro, String nom_rubro,
			String nom_prod, String unidad, String cantidad) {
		super();
		this.cod_rubro = cod_rubro;
		this.nom_rubro = nom_rubro;
		this.nom_prod = nom_prod;
		this.unidad = unidad;
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCod_rubro() {
		return cod_rubro;
	}

	public void setCod_rubro(String cod_rubro) {
		this.cod_rubro = cod_rubro;
	}

	public String getNom_rubro() {
		return nom_rubro;
	}

	public void setNom_rubro(String nom_rubro) {
		this.nom_rubro = nom_rubro;
	}

	public String getNom_prod() {
		return nom_prod;
	}

	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}



}
