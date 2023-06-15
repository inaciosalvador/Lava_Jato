package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.DB;
import db.DbException;
import entities.Cliente;
import entities.Veiculo;

public class VeiculoDao {

	public void addNewVeiculo(String cpf_cnpj, Veiculo veiculo) throws SQLException {
		
		String sqlAddVeiculo = "INSERT INTO veiculo (proprietario, placa, fabricante, modelo, tipo_veiculo)" +
		             " VALUES (?, ?, ?, ?, ?)";
		
		String retornarProprietario = "SELECT id_cliente FROM cliente WHERE cpf_cnpj = (?)";
		
		int idCliente = -1; // Para guardar o ID do cliente
		
		
		Connection connection = null;
				
		try {
			
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit
			
			
			PreparedStatement statementIdCliente = connection.prepareStatement(retornarProprietario);
			statementIdCliente.setString(1, cpf_cnpj);
			ResultSet resultSet = statementIdCliente.executeQuery();
			if(resultSet.next()) {
				idCliente = resultSet.getInt("id_cliente"); // id do proprietario
			}

			PreparedStatement statementNewVeiculo = connection.prepareStatement(sqlAddVeiculo);
			statementNewVeiculo.setInt(1, idCliente);
			statementNewVeiculo.setString(2, veiculo.getPlaca());
			statementNewVeiculo.setString(3, veiculo.getFabricante());
			statementNewVeiculo.setString(4, veiculo.getModelo());
			statementNewVeiculo.setString(5, veiculo.getTipo_veiculo());
			statementNewVeiculo.executeUpdate();
			connection.commit(); // Confirmação para efetuar os comandos.
			
			System.out.println("Veiculo associado ao cliente " + idCliente + " com sucesso! ");

		} catch (SQLException e) {
			connection.rollback();
			System.out.println("Erro ao cadastrar veiculo: " + e.getMessage());
			
		} finally {
			if(connection != null) {
				try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
			}
		}
		
	}
	
}
