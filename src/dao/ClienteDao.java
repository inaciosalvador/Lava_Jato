package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import entities.Cliente;

public class ClienteDao {
	
	public void create(Cliente cliente) {
		
		String sql = "INSERT INTO cliente (nome, telefone, cpf_cnpj)" + 
					 " VALUES (?, ?, ?)";

		try (Connection connection = DB.getConnection()) {
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getTelefone());
			statement.setString(3, cliente.getCpf_cnpj());
			statement.executeUpdate();
			
			
			ResultSet chaveGerada = statement.getGeneratedKeys();
			if(chaveGerada.next()) {
			  int idGerado = chaveGerada.getInt(1);
			  // retorna o id gerado pelo banco para associar o veiculo ao cliente
			  cliente.setId_cliente(idGerado); 			
			}
			
			System.out.println("Cliente cadastrado com sucesso! ");
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
