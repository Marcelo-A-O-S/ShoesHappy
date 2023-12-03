package domain.models;

import utils.services.PrimaryKey;

public class Usuario {
	@PrimaryKey
	public Integer Id;
	public String usuario;
	public String email;
	public String password;
	
	public Usuario() {
		
	}
	public Usuario(Integer id, String usuario, String email, String password) {
		this.Id = id;
		this.usuario = usuario;
		this.email = email;
		this.password = password;
	}
	public Boolean VerificarPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	public Integer getId() {
		return this.Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
