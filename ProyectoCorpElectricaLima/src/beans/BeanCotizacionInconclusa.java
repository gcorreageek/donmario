package beans;

public class BeanCotizacionInconclusa {
String ide_cot_inc;
String num_item;
String cod_ven;
String cod_cli;
String fecha_coti;
int cant;
String unimedida;
String desc_prod;
String marca;
String precio_unit;
String precio_total;
String precio_costo;
String costo_total;
String diferencia;
String fecha;
String porcentaje;
String nom_prove;
int cod_prove;
int cod_prod;
int cod_mar;
int cod_umed;
String peso_prod;
String tiempo_entrega;
double costo;


/*-codigo de proveedor
-codigo de producto
-codigo de marca
-codigo de unimedida
-codigo de pord_alternativo*/




public BeanCotizacionInconclusa() {
	super();
}


public BeanCotizacionInconclusa(String ide_cot_inc, String num_item,
		String cod_ven, String cod_cli, String fecha_coti, int cant,
		String unimedida, String desc_prod, String marca, String precio_unit,
		String precio_total, String precio_costo, String costo_total,
		String diferencia, String fecha, String porcentaje, String nom_prove,
		int cod_prove, int cod_prod, int cod_mar, int cod_umed,
		String peso_prod, String tiempo_entrega, double costo) {
	super();
	this.ide_cot_inc = ide_cot_inc;
	this.num_item = num_item;
	this.cod_ven = cod_ven;
	this.cod_cli = cod_cli;
	this.fecha_coti = fecha_coti;
	this.cant = cant;
	this.unimedida = unimedida;
	this.desc_prod = desc_prod;
	this.marca = marca;
	this.precio_unit = precio_unit;
	this.precio_total = precio_total;
	this.precio_costo = precio_costo;
	this.costo_total = costo_total;
	this.diferencia = diferencia;
	this.fecha = fecha;
	this.porcentaje = porcentaje;
	this.nom_prove = nom_prove;
	this.cod_prove = cod_prove;
	this.cod_prod = cod_prod;
	this.cod_mar = cod_mar;
	this.cod_umed = cod_umed;
	this.peso_prod = peso_prod;
	this.tiempo_entrega = tiempo_entrega;
	this.costo = costo;
}


public String getIde_cot_inc() {
	return ide_cot_inc;
}


public void setIde_cot_inc(String ide_cot_inc) {
	this.ide_cot_inc = ide_cot_inc;
}


public String getNum_item() {
	return num_item;
}


public void setNum_item(String num_item) {
	this.num_item = num_item;
}


public String getCod_ven() {
	return cod_ven;
}


public void setCod_ven(String cod_ven) {
	this.cod_ven = cod_ven;
}


public String getCod_cli() {
	return cod_cli;
}


public void setCod_cli(String cod_cli) {
	this.cod_cli = cod_cli;
}


public String getFecha_coti() {
	return fecha_coti;
}


public void setFecha_coti(String fecha_coti) {
	this.fecha_coti = fecha_coti;
}


public int getCant() {
	return cant;
}


public void setCant(int cant) {
	this.cant = cant;
}


public String getUnimedida() {
	return unimedida;
}


public void setUnimedida(String unimedida) {
	this.unimedida = unimedida;
}


public String getDesc_prod() {
	return desc_prod;
}


public void setDesc_prod(String desc_prod) {
	this.desc_prod = desc_prod;
}


public String getMarca() {
	return marca;
}


public void setMarca(String marca) {
	this.marca = marca;
}


public String getPrecio_unit() {
	return precio_unit;
}


public void setPrecio_unit(String precio_unit) {
	this.precio_unit = precio_unit;
}


public String getPrecio_total() {
	return precio_total;
}


public void setPrecio_total(String precio_total) {
	this.precio_total = precio_total;
}


public String getPrecio_costo() {
	return precio_costo;
}


public void setPrecio_costo(String precio_costo) {
	this.precio_costo = precio_costo;
}


public String getCosto_total() {
	return costo_total;
}


public void setCosto_total(String costo_total) {
	this.costo_total = costo_total;
}


public String getDiferencia() {
	return diferencia;
}


public void setDiferencia(String diferencia) {
	this.diferencia = diferencia;
}


public String getFecha() {
	return fecha;
}


public void setFecha(String fecha) {
	this.fecha = fecha;
}


public String getPorcentaje() {
	return porcentaje;
}


public void setPorcentaje(String porcentaje) {
	this.porcentaje = porcentaje;
}


public String getNom_prove() {
	return nom_prove;
}


public void setNom_prove(String nom_prove) {
	this.nom_prove = nom_prove;
}


public int getCod_prove() {
	return cod_prove;
}


public void setCod_prove(int cod_prove) {
	this.cod_prove = cod_prove;
}


public int getCod_prod() {
	return cod_prod;
}


public void setCod_prod(int cod_prod) {
	this.cod_prod = cod_prod;
}


public int getCod_mar() {
	return cod_mar;
}


public void setCod_mar(int cod_mar) {
	this.cod_mar = cod_mar;
}


public int getCod_umed() {
	return cod_umed;
}


public void setCod_umed(int cod_umed) {
	this.cod_umed = cod_umed;
}


public String getPeso_prod() {
	return peso_prod;
}


public void setPeso_prod(String peso_prod) {
	this.peso_prod = peso_prod;
}


public String getTiempo_entrega() {
	return tiempo_entrega;
}


public void setTiempo_entrega(String tiempo_entrega) {
	this.tiempo_entrega = tiempo_entrega;
}


public double getCosto() {
	return costo;
}


public void setCosto(double costo) {
	this.costo = costo;
}


}
