package beans;

public class BeanClienteCError {

	
	String  codigo,empresa,lugar,nombre,apellido,sexo,mail1,contacto,mail2;

	public BeanClienteCError(String codigo, String empresa, String lugar, String nombre,
			String apellido, String sexo, String mail1, String contacto,
			String mail2) {
		super();
		this.codigo = codigo;
		this.empresa = empresa;
		this.lugar = lugar;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.mail1 = mail1;
		this.contacto = contacto;
		this.mail2 = mail2;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMail1() {
		return mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getMail2() {
		return mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
		
}
