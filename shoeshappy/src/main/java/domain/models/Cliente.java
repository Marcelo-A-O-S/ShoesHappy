package domain.models;

import domain.enums.Modalidade;
import utils.services.PrimaryKey;

public class Cliente {
	@PrimaryKey
	public Integer Id;
	public String nome;
	public String modalidade;
	public String email;
	
	public Cliente() {
		
	}
	public Cliente(Integer id, String nome, String modalidade, String email) {
		this.Id = id;
		this.nome = nome;
		this.modalidade = modalidade;
		this.email = email;
	}
	public Integer getId() {
		return this.Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModalidade() {
		return this.modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade.toString();
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
