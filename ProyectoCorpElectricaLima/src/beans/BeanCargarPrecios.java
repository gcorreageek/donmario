package beans;

public class BeanCargarPrecios {
      String codProducto,descripcion,modelo,cod_prove,cod_mar,cod_umed,cod_rubro,cos_det,mon_det,igv_det;

	public BeanCargarPrecios(String codProducto, String descripcion,
			String modelo, String cod_prove, String cod_mar, String cod_umed,
			String cod_rubro, String cos_det, String mon_det, String igv_det) {
		super();
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.cod_prove = cod_prove;
		this.cod_mar = cod_mar;
		this.cod_umed = cod_umed;
		this.cod_rubro = cod_rubro;
		this.cos_det = cos_det;
		this.mon_det = mon_det;
		this.igv_det = igv_det;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(String cod_prove) {
		this.cod_prove = cod_prove;
	}

	public String getCod_mar() {
		return cod_mar;
	}

	public void setCod_mar(String cod_mar) {
		this.cod_mar = cod_mar;
	}

	public String getCod_umed() {
		return cod_umed;
	}

	public void setCod_umed(String cod_umed) {
		this.cod_umed = cod_umed;
	}

	public String getCod_rubro() {
		return cod_rubro;
	}

	public void setCod_rubro(String cod_rubro) {
		this.cod_rubro = cod_rubro;
	}

	public String getCos_det() {
		return cos_det;
	}

	public void setCos_det(String cos_det) {
		this.cos_det = cos_det;
	}

	public String getMon_det() {
		return mon_det;
	}

	public void setMon_det(String mon_det) {
		this.mon_det = mon_det;
	}

	public String getIgv_det() {
		return igv_det;
	}

	public void setIgv_det(String igv_det) {
		this.igv_det = igv_det;
	}

  
}
