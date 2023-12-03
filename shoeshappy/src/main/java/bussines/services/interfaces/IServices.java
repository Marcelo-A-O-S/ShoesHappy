package bussines.services.interfaces;

import java.util.List;

public interface IServices<T> {
	void Salvar(T entidade);
	T BuscarPorId(int id);
	List<T> Listar();
	void Deletar(T entidade);
	void DeletarPorId(int id);
	
}
