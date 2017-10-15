package beans;

public class BeanUsuario {

	private String codigo;
	private String nombre;
	private String usuario;
	private String password;
	
	
	public BeanUsuario(String codigo, String nombre, String usuario,
			String password) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
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


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
