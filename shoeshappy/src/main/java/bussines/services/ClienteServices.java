package bussines.services;

import java.util.List;

import bussines.repositories.ClienteRepository;
import bussines.services.interfaces.IClienteServices;
import domain.models.Cliente;

public class ClienteServices implements IClienteServices{
	private ClienteRepository repositorio;
	public ClienteServices(ClienteRepository _repositorio) {
		this.repositorio = _repositorio;
	}
	@Override
	public void Salvar(Cliente entidade) {
		// TODO Auto-generated method stub
		if(entidade.Id == 0) {
			this.repositorio.Salvar(entidade);
		}else {
			this.repositorio.Atualizar(entidade);
		}
	}

	@Override
	public Cliente BuscarPorId(int id) {
		// TODO Auto-generated method stub
		Cliente cliente = this.repositorio.BuscarPorId(id);
		return cliente;
	}

	@Override
	public List<Cliente> Listar() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = this.repositorio.Listar();
		return clientes;
	}
	@Override
	public void Deletar(Cliente entidade) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DeletarPorId(int id) {
		// TODO Auto-generated method stub
		this.repositorio.DeletarPorId(id);
	}
	@Override
	public Cliente BuscarPorEmail(String _email) {
		// TODO Auto-generated method stub
		Cliente cliente = this.repositorio.BuscarPorPropriedadeValor("email", _email);
		return cliente;
	}
	@Override
	public Cliente BuscarPorNome(String _nome) {
		// TODO Auto-generated method stub
		Cliente cliente = this.repositorio.BuscarPorPropriedadeValor("nome", _nome);
		return cliente;
	}
	@Override
	public void DeletarPorClienteId(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
