package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import db.DB;
import entities.Cliente;
import entities.Veiculo;

public class ClienteDAO {

	Connection connection = null;

	public void create(Cliente cliente, Veiculo veiculo) throws SQLException {

		String sqlCliente = "INSERT INTO cliente (nome, telefone, cpf_cnpj)" + " VALUES (?, ?, ?)";
		String sqlVeiculo = "INSERT INTO veiculo (proprietario, placa, fabricante, modelo, tipo_veiculo)"
				+ " VALUES (?, ?, ?, ?, ?)";

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

	public void read() throws SQLException {

		String sqlCliente = "SELECT * FROM CLIENTE;";
		String sqlVeiculo = "SELECT * FROM VEICULO;";

		PreparedStatement st1 = null;
		ResultSet rs1 = null;

		PreparedStatement st2 = null;
		ResultSet rs2 = null;

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlCliente);
			rs1 = st1.executeQuery();

			st2 = connection.prepareStatement(sqlVeiculo);
			rs2 = st2.executeQuery();
			
			
			System.out.println(" ===== Lista de clientes ===== ");
			System.out.println("");

			while (rs1.next()) {
			
				System.out.println("Id Cliente: " + rs1.getInt("id_cliente"));
				System.out.println("Nome: " + rs1.getString("nome"));
				System.out.println("Telefone: " + rs1.getString("telefone"));
				System.out.println("Numero de Documento: " + rs1.getString("cpf_cnpj"));

				System.out.println("             ***            ");
				
				//logica para mostrar os veiculos aqui
				

				System.out.println("=================================================");

			}

			connection.commit(); // Confirmação para efetuar os comandos.

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs1);
			DB.closeStatement(st1);
			DB.closeConnection();
		}
	}
}
