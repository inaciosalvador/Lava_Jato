package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import entities.Cliente;
import entities.Veiculo;

public class CadastrarNovoClienteDAO {

	public void create(Cliente cliente, Veiculo veiculo) throws SQLException {

		String sqlCliente = "INSERT INTO cliente (nome, telefone, cpf_cnpj)" + " VALUES (?, ?, ?)";
		String sqlVeiculo = "INSERT INTO veiculo (proprietario, placa, fabricante, modelo, tipo_veiculo)" + " VALUES (?, ?, ?, ?, ?)";

		Connection connection = null;

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			PreparedStatement statementCliente = connection.prepareStatement(sqlCliente,
					Statement.RETURN_GENERATED_KEYS);
			statementCliente.setString(1, cliente.getNome());
			statementCliente.setString(2, cliente.getTelefone());
			statementCliente.setString(3, cliente.getCpf_cnpj());
			statementCliente.executeUpdate();

			// retorna o id gerado pelo banco
			ResultSet chaveGerada = statementCliente.getGeneratedKeys();
			if (chaveGerada.next()) {
				int idGerado = chaveGerada.getInt(1);
				cliente.setId_cliente(idGerado);
			}

			statementCliente.close();

			// -----------------------------------------------------------------

			PreparedStatement statementVeiculo = connection.prepareStatement(sqlVeiculo);
			statementVeiculo.setInt(1, cliente.getId_cliente());
			statementVeiculo.setString(2, veiculo.getPlaca());
			statementVeiculo.setString(3, veiculo.getFabricante());
			statementVeiculo.setString(4, veiculo.getModelo());
			statementVeiculo.setString(5, veiculo.getTipo_veiculo());
			statementVeiculo.executeUpdate();
			statementVeiculo.close();

			connection.commit(); // Confirmação para efetuar os comandos.
			System.out.println("Cliente e veiculo cadastrado com sucesso! ");

		} catch (SQLException e) {

			connection.rollback();
			System.out.println("Erro ao cadastrar cliente: " + e.getMessage());

		} finally {

			if (connection != null) {
				try {
					
					connection.close(); // Conexão fechada
	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
