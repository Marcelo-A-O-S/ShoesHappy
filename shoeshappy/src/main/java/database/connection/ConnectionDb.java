package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.connection.interfaces.IConnectionDb;
/*
 * Classe de implementação de tudo que envolve conexão com banco de dados
 * 
 * */
public class ConnectionDb implements IConnectionDb {
	public String host = "jdbc:mysql://localhost:3306/teste";
	public String user = "root";
	public String password = "123456";
	public Connection conn;
	public PreparedStatement statement;
	public ConnectionDb() {
		
	}
	/*
	 * Metodo de inicialização da conexão com o banco de dados
	 * */
	public void Initialize() {
		try {
			
			if(this.conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.conn = DriverManager.getConnection(this.host,this.user,this.password);
			}
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public String QueryInsert(String tabela, String colunas, String valores) {
		return String.format("insert into %s (%s) values(%s)", tabela, colunas, valores);
	}
	@Override
	public String QuerySelect(String tabela) {
		return String.format("select * from %s", tabela);
	}
	@Override
	public String QueryUpdate(String tabela, String valores, String identificador) {
		// TODO Auto-generated method stub
		return String.format("Update %s set %s where %s ", tabela, valores, identificador);
	}
	@Override
	public String QueryDelete() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void PreparedStatement(String sql) {
		try {
			this.statement = this.conn.prepareStatement(sql);
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
		}
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public int ExecuteUpdate() {
		// TODO Auto-generated method stub
		try {
			return this.statement.executeUpdate();
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
			return 0;
		}
		
	}
	@Override
	public ResultSet ExecuteQuery() {
		// TODO Auto-generated method stub
		try {
			return this.statement.executeQuery();
		}catch(SQLException ex) {
			System.out.print(ex.getMessage());
			return null;
		}
	}
	@Override
	public void Close() {
		// TODO Auto-generated method stub
		try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.conn != null && !this.conn.isClosed()) {
                this.conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	@Override
	public String QuerySelectPorPropriedade(String tabela, String propriedade, String valor) {
		// TODO Auto-generated method stub
		return String.format("select * from %s where %s = %s;", tabela, propriedade, valor);
	}
	@Override
	public String QuerySelectPorId(String tabela, String id) {
		// TODO Auto-generated method stub
		return String.format("select * from %s where Id = %s", tabela, id);
	}
	@Override
	public String QueryDeletePorId(String tabela, String id) {
		// TODO Auto-generated method stub
		return String.format("delete from %s where Id = %s", tabela, id);
	}
}
