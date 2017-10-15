package beans;

public class BeanEnvioProveedor {
	String codigo;
	String nombre;
	String empresa;
	Integer sexo;
	String correo,correo2;
	
	
	public BeanEnvioProveedor(String codigo, String nombre, String empresa,
			Integer sexo, String correo, String correo2) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.empresa = empresa;
		this.sexo = sexo;
		this.correo = correo;
		this.correo2 = correo2;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public Integer getSexo() {
		return sexo;
	}


	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCorreo2() {
		return correo2;
	}


	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}
	
}
