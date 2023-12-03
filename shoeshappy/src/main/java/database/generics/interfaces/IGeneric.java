package database.generics.interfaces;

import java.util.List;

public interface IGeneric<T> {
	void Salvar(T entidade);
	List<T> Listar();
	void Deletar(T entidade);
	void DeletarPorId(int id);
	void Atualizar(T entidade);
	T BuscarPorId(int id);
	T BuscarPorPropriedadeValor(String propriedade, Object valor);
}
