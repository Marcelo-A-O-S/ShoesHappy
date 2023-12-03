package database.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connection.ConnectionDb;
import database.generics.interfaces.IGeneric;
import utils.services.PrimaryKey;

public class Generic<T> implements IGeneric<T>{

	@Override
	public void Salvar(T entidade) {
		try {
			List<String> nomeColunas = new ArrayList<String>();
			List<String> valorColunas = new ArrayList<String>();
			String nomeTabela = entidade.getClass().getSimpleName().toLowerCase();
			Field[] campos = entidade.getClass().getDeclaredFields();
			for (Field campo : campos) {
				campo.setAccessible(true);
				if(!campo.isAnnotationPresent(PrimaryKey.class)) {
					String nomeColuna = campo.getName();
					nomeColunas.add(nomeColuna);
					Object valorDoCampo = campo.get(entidade);
					if(valorDoCampo instanceof String) {
						valorColunas.add(String.format("\"%s\"", valorDoCampo));
					}
					if(valorDoCampo instanceof Integer) {
						valorColunas.add(String.format("%d", valorDoCampo));
					}
				}
	        }
			String colunas = String.join(",",nomeColunas);
			String valores = String.join(",", valorColunas);
			ConnectionDb conn = new ConnectionDb();
			String query = conn.QueryInsert(nomeTabela, colunas, valores);
			System.out.println(query);
			conn.Initialize();
			conn.PreparedStatement(query);
			int result = conn.ExecuteUpdate();
			conn.Close();
			if(result > 0 ) {
				return;
			}else {
				System.out.println("Não foi salvo com sucesso");
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public List<T> Listar() {
		// TODO Auto-generated method stub
		try {
			List<T> listaGenerica = new ArrayList<T>();
			Type tipoGenerico = getClass().getGenericSuperclass();
			ParameterizedType tipoParametrizado = (ParameterizedType) tipoGenerico;
			Class<T> type = (Class<T>) tipoParametrizado.getActualTypeArguments()[0];
			String nomeTabela = type.getSimpleName().toLowerCase();
			Field[] campos = type.getDeclaredFields();
			
			try {
				ConnectionDb conn = new ConnectionDb();
				conn.Initialize();
				String query = conn.QuerySelect(nomeTabela);
				conn.PreparedStatement(query);
				ResultSet result = conn.ExecuteQuery();
				
				while(result.next()) {
					T instance = type.newInstance();
					for(Field campo:campos) {
						System.out.println(campo.getType());
						if(campo.getType() == Integer.class) {
							System.out.println(result.getInt(campo.getName()));
							campo.set(instance, result.getInt(campo.getName()));
						}
						if(campo.getType() == String.class) {
							System.out.println(result.getString(campo.getName()));
							campo.set(instance, result.getString(campo.getName()));
						}
					}
					listaGenerica.add(instance);
				}
				conn.Close();
				return listaGenerica;
			}catch(SQLException ex) {
				System.out.print(ex.getMessage());
			}
		}catch(Exception err) {
			System.out.print(err.getMessage());
			return null;
		}
		return null;
	}

	@Override
	public void Deletar(T entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeletarPorId(int id) {
		Type tipoGenerico = getClass().getGenericSuperclass();
		ParameterizedType tipoParametrizado = (ParameterizedType) tipoGenerico;
		Class<T> type = (Class<T>) tipoParametrizado.getActualTypeArguments()[0];
		String nomeTabela = type.getSimpleName().toLowerCase();
		String QueryValor = String.format("%d", id);
		ConnectionDb conn = new ConnectionDb();
		String query = conn.QueryDeletePorId(nomeTabela, QueryValor);
		conn.Initialize();
		conn.PreparedStatement(query);
		int result = conn.ExecuteUpdate();
		conn.Close();
		if(result > 0) {
			return;
		}else {
			System.out.println("Ocorreu algum problema ao deletar o registro");
		}
		
	}

	@Override
	public void Atualizar(T entidade) {
		// TODO Auto-generated method stub
		try {
			String Identificador = "";
			List<String> nomeColunas = new ArrayList<String>();
			List<String> valorColunas = new ArrayList<String>();
			List<String> valoresAtribuidos = new ArrayList<String>();
			String nomeTabela = entidade.getClass().getSimpleName().toLowerCase();
			Field[] campos = entidade.getClass().getDeclaredFields();
			for(Field campo:campos) {
				if(campo.isAnnotationPresent(PrimaryKey.class)) {
					Object valorDoCampo = campo.get(entidade);
					if(valorDoCampo instanceof String) {
						Identificador = String.format("%s = \"%s\"",campo.getName() , valorDoCampo);
					}
					if(valorDoCampo instanceof Integer) {
						Identificador = String.format("%s = %d",campo.getName() ,valorDoCampo);
					}
				}else {
					Object valorDoCampo = campo.get(entidade);
					if(valorDoCampo instanceof String) {
						valorColunas.add(String.format("\"%s\"", valorDoCampo));
						valoresAtribuidos.add(String.format("%s =  \"%s\"", campo.getName(), valorDoCampo));
					}
					if(valorDoCampo instanceof Integer) {
						valorColunas.add(String.format("%d", valorDoCampo));
						valoresAtribuidos.add(String.format("%s =  %d", campo.getName(), valorDoCampo));
					}
				}
				
			}
			String valores = String.join(",", valoresAtribuidos);
			ConnectionDb conn = new ConnectionDb();
			String query = conn.QueryUpdate(nomeTabela, valores, Identificador);
			System.out.println(query);
			conn.Initialize();
			conn.PreparedStatement(query);
			int result = conn.ExecuteUpdate();
			conn.Close();
			if(result > 0) {
				return;
			}else {
				System.out.println("Houve problema ao atualiza os dados");
			}
			
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}

	@Override
	public T BuscarPorId(int id) {
		// TODO Auto-generated method stub
		try {
			Type tipoGenerico = getClass().getGenericSuperclass();
			ParameterizedType tipoParametrizado = (ParameterizedType) tipoGenerico;
			Class<T> type = (Class<T>) tipoParametrizado.getActualTypeArguments()[0];
			String nomeTabela = type.getSimpleName().toLowerCase();
			Field[] campos = type.getDeclaredFields();
			String QueryValor = String.format("%d", id);
			T instance = type.newInstance();
			ConnectionDb conn = new ConnectionDb();
			String query = conn.QuerySelectPorId(nomeTabela, QueryValor);
			conn.Initialize();
			conn.PreparedStatement(query);
			ResultSet result = conn.ExecuteQuery();
			while(result.next()) {
				for(Field campo:campos) {
					if(campo.getType() == Integer.class) {
						campo.set(instance, result.getInt(campo.getName()));
					}
					if(campo.getType() == String.class) {
						campo.set(instance, result.getString(campo.getName()));
					}
				}
			}
			conn.Close();
			return instance;
		}catch(Exception err) {
			System.out.print(err.getMessage());
			return null;
		}
		
	}

	@Override
	public T BuscarPorPropriedadeValor(String propriedade, Object valor) {
		// TODO Auto-generated method stub
		try {
			String QueryValor = "";
			Type tipoGenerico = getClass().getGenericSuperclass();
			ParameterizedType tipoParametrizado = (ParameterizedType) tipoGenerico;
			Class<T> type = (Class<T>) tipoParametrizado.getActualTypeArguments()[0];
			String nomeTabela = type.getSimpleName().toLowerCase();
			Field[] campos = type.getDeclaredFields();
			T instance = type.newInstance();
			if(valor instanceof Integer) {
				QueryValor = String.format("%d", valor);
			}
			if(valor instanceof String) {
				QueryValor = String.format("\"%s\"", valor);
			}
			ConnectionDb conn = new ConnectionDb();
			String query = conn.QuerySelectPorPropriedade(nomeTabela, propriedade, QueryValor);
			conn.Initialize();
			conn.PreparedStatement(query);
			ResultSet result = conn.ExecuteQuery();
			while(result.next()) {
				for(Field campo:campos) {
					System.out.println(campo.getType());
					if(campo.getType() == Integer.class) {
						campo.set(instance, result.getInt(campo.getName()));
					}
					if(campo.getType() == String.class) {
						campo.set(instance, result.getString(campo.getName()));
					}
				}
			}
			conn.Close();
			return instance;
		}catch(Exception err) {
			System.out.print(err.getMessage());
		}
		return null;
	}

}
