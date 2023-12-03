package database.connection.interfaces;

import java.sql.ResultSet;

public interface IConnectionDb {
	void Initialize();
	String QueryInsert(String tabela, String colunas, String valores);
	String QuerySelect(String tabela);
	String QueryUpdate(String tabela, String valores, String identificador);
	String QueryDelete();
	void PreparedStatement(String sql);
	int ExecuteUpdate();
	ResultSet ExecuteQuery();
	void Close();
	String QuerySelectPorPropriedade(String tabela, String propriedade, String valor);
	String QuerySelectPorId(String tabela, String id);
	String QueryDeletePorId(String tabela, String id);
}
