package bussines.services.interfaces;

import domain.models.Cliente;

public interface IClienteServices extends IServices<Cliente> {
	Cliente BuscarPorEmail(String _email);
	Cliente BuscarPorNome(String _nome);
	void DeletarPorClienteId(Integer id);
}
