package bussines.services.interfaces;

import domain.models.Endereco;

public interface IEnderecoServices extends IServices<Endereco>{
	Endereco BuscarPorClienteId(int usuarioid);
}
