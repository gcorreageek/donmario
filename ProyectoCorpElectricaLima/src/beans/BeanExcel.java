package beans;

/**
 * @author Gustavo
 *
 */
public class BeanExcel {

	String señor,umedida,descripcion,marca,atencion,direccion,telefono,rpm,nextel,cel,mail,referencia,tipocliente,modelo,codpromelsa;
	int cant,id,cod_cli;
	
	
	
	
	public BeanExcel(String señor, int id, int cant, String umedida,
				String descripcion, String marca,String atencion,String direccion
				,String telefono,String rpm,String nextel,String cel,String mail,String referencia,int cod_cli,String tipocliente,
				String modelo,String codpromelsa) {
			super();
			this.señor = señor;
			this.id = id;
			this.cant = cant;
			this.umedida = umedida;
			this.descripcion = descripcion;
			this.marca = marca;
			this.atencion=atencion;
			this.direccion=direccion;
			this.telefono=telefono;
			this.rpm=rpm;
			this.nextel=nextel;
			this.cel=cel;
			this.mail=mail;
			this.referencia=referencia;
			this.cod_cli=cod_cli;
			this.tipocliente=tipocliente;
			this.modelo=modelo;
			this.codpromelsa=codpromelsa;
		}




	public String getNextel() {
		return nextel;
	}




	public void setNextel(String nextel) {
		this.nextel = nextel;
	}




	public String getSeñor() {
		return señor;
	}




	public void setSeñor(String señor) {
		this.señor = señor;
	}




	public String getUmedida() {
		return umedida;
	}




	public void setUmedida(String umedida) {
		this.umedida = umedida;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getMarca() {
		return marca;
	}




	public void setMarca(String marca) {
		this.marca = marca;
	}




	public String getAtencion() {
		return atencion;
	}




	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getRpm() {
		return rpm;
	}




	public void setRpm(String rpm) {
		this.rpm = rpm;
	}




	public String getCel() {
		return cel;
	}




	public void setCel(String cel) {
		this.cel = cel;
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public String getReferencia() {
		return referencia;
	}




	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}




	public String getTipocliente() {
		return tipocliente;
	}




	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}




	public int getCant() {
		return cant;
	}




	public void setCant(int cant) {
		this.cant = cant;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getCod_cli() {
		return cod_cli;
	}




	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCodPromelsa() {
		return codpromelsa;
	}


	public void setCodPromelsa(String codpromelsa) {
		this.codpromelsa = codpromelsa;
	}



	
	
	
	
	
	
	
	
	
	
}
