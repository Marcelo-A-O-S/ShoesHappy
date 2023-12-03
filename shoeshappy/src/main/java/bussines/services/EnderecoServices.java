package bussines.services;

import java.util.List;

import bussines.repositories.EnderecoRepository;
import bussines.services.interfaces.IEnderecoServices;
import domain.models.Endereco;

public class EnderecoServices implements IEnderecoServices {
	private EnderecoRepository repositorio;
	public EnderecoServices(EnderecoRepository _repositorio) {
		this.repositorio = _repositorio;
	}
	@Override
	public void Salvar(Endereco entidade) {
		// TODO Auto-generated method stub
		if(entidade.Id == 0) {
			this.repositorio.Salvar(entidade);
		}else {
			this.repositorio.Atualizar(entidade);
		}
		
	}

	@Override
	public Endereco BuscarPorId(int id) {
		// TODO Auto-generated method stub
		Endereco endereco = this.repositorio.BuscarPorId(id);
		return endereco;
	}

	@Override
	public List<Endereco> Listar() {
		// TODO Auto-generated method stub
		List<Endereco> enderecos = this.repositorio.Listar();
		return enderecos;
	}
	@Override
	public void Deletar(Endereco entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DeletarPorId(int id) {
		// TODO Auto-generated method stub
		this.repositorio.DeletarPorId(id);
	}
	@Override
	public Endereco BuscarPorClienteId(int usuarioid) {
		// TODO Auto-generated method stub
		Endereco endereco = this.repositorio.BuscarPorPropriedadeValor("clienteId", usuarioid);
		return endereco;
	}

}
