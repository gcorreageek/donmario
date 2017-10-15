// Decompiled by DJ v3.9.9.91 Copyright 2005 Atanas Neshkov  Date: 08/02/2010 19:10:20
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   BeanCliente.java

package beans;


public class BeanCliente
{
	 	String codcli;
	    String nomcli;
	    String contacto1cli;
	    String sexcli;
	    String direccion1cli;
	    String telefono1cli;
	    String rpm1cli;
	    String nextel;
	    String cel1cli;
	    String email1cli;
	    String email2cli;
	    String tipocli;
	    String ruc;
    
    public BeanCliente(String codcli, String nomcli, String contacto1cli,
				String sexcli, String direccion1cli, String telefono1cli,
				String rpm1cli, String nextel, String cel1cli,
				String email1cli, String email2cli, String tipocli, String ruc) {
			super();
			this.codcli = codcli;
			this.nomcli = nomcli;
			this.contacto1cli = contacto1cli;
			this.sexcli = sexcli;
			this.direccion1cli = direccion1cli;
			this.telefono1cli = telefono1cli;
			this.rpm1cli = rpm1cli;
			this.nextel = nextel;
			this.cel1cli = cel1cli;
			this.email1cli = email1cli;
			this.email2cli = email2cli;
			this.tipocli = tipocli;
			this.ruc = ruc;
		}

	public String getCodcli() {
		return codcli;
	}

	public void setCodcli(String codcli) {
		this.codcli = codcli;
	}

	public String getNomcli() {
		return nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public String getContacto1cli() {
		return contacto1cli;
	}

	public void setContacto1cli(String contacto1cli) {
		this.contacto1cli = contacto1cli;
	}

	public String getSexcli() {
		return sexcli;
	}

	public void setSexcli(String sexcli) {
		this.sexcli = sexcli;
	}

	public String getDireccion1cli() {
		return direccion1cli;
	}

	public void setDireccion1cli(String direccion1cli) {
		this.direccion1cli = direccion1cli;
	}

	public String getTelefono1cli() {
		return telefono1cli;
	}

	public void setTelefono1cli(String telefono1cli) {
		this.telefono1cli = telefono1cli;
	}

	public String getRpm1cli() {
		return rpm1cli;
	}

	public void setRpm1cli(String rpm1cli) {
		this.rpm1cli = rpm1cli;
	}

	public String getNextel() {
		return nextel;
	}

	public void setNextel(String nextel) {
		this.nextel = nextel;
	}

	public String getCel1cli() {
		return cel1cli;
	}

	public void setCel1cli(String cel1cli) {
		this.cel1cli = cel1cli;
	}

	public String getEmail1cli() {
		return email1cli;
	}

	public void setEmail1cli(String email1cli) {
		this.email1cli = email1cli;
	}

	public String getEmail2cli() {
		return email2cli;
	}

	public void setEmail2cli(String email2cli) {
		this.email2cli = email2cli;
	}

	public String getTipocli() {
		return tipocli;
	}

	public void setTipocli(String tipocli) {
		this.tipocli = tipocli;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

    
   
}