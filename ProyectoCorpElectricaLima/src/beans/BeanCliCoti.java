package beans;

public class BeanCliCoti {
	String se�or,atencion,direccion,telefono,rpm,nextel,cel,mail,tipocliente;
	

	public BeanCliCoti() {
		super();
	}

	public BeanCliCoti(String se�or, String atencion, String direccion,
			String telefono, String rpm, String nextel, String cel,
			String mail, String tipocliente) {
		super();
		this.se�or = se�or;
		this.atencion = atencion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.rpm = rpm;
		this.nextel = nextel;
		this.cel = cel;
		this.mail = mail;
		this.tipocliente = tipocliente;
	}

	public String getSe�or() {
		return se�or;
	}

	public void setSe�or(String se�or) {
		this.se�or = se�or;
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

	public String getNextel() {
		return nextel;
	}

	public void setNextel(String nextel) {
		this.nextel = nextel;
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

	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	
}
