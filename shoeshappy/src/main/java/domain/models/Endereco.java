package domain.models;

import utils.services.PrimaryKey;

public class Endereco {
	@PrimaryKey
	public Integer Id;
	public Integer clienteId;
	public String cidade;
	public String bairro;
	public String estado;
	public String rua;
	public Integer numero;
	public Integer getId() {
		return this.Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public Integer getClienteId() {
		return this.clienteId;
	}
	public void setClienteId(Integer usuarioId) {
		this.clienteId = usuarioId;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return this.bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRua() {
		return this.rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return this.numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
