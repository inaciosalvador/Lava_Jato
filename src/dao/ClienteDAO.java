package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.entities.Cliente;
import model.entities.Veiculo;

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

		String sqlCliente = "SELECT * FROM CLIENTE ORDER BY id_cliente;";
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

			List<Veiculo> veiculos = new ArrayList<>();

			while (rs2.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setProprietario(rs2.getInt("proprietario"));
				veiculo.setPlaca(rs2.getString("placa"));
				veiculo.setFabricante(rs2.getString("fabricante"));
				veiculo.setModelo(rs2.getString("modelo"));
				veiculo.setTipo_veiculo(rs2.getString("tipo_veiculo"));
				veiculos.add(veiculo);
			}

			System.out.println(" ===== Lista de clientes ===== ");
			System.out.println("");

			while (rs1.next()) {

				System.out.println("Id Cliente: " + rs1.getInt("id_cliente"));
				System.out.println("Nome: " + rs1.getString("nome"));
				System.out.println("Telefone: " + rs1.getString("telefone"));
				System.out.println("Numero de Documento: " + rs1.getString("cpf_cnpj"));

				System.out.println("             ---            ");

				int countVeiculo = 1;

				for (Veiculo veiculo : veiculos) {

					if (veiculo.getProprietario() == rs1.getInt("id_cliente")) {
						System.out.println("Veiculo: " + countVeiculo);
						System.out.println("Modelo: " + veiculo.getModelo());
						System.out.println("Placa: " + veiculo.getPlaca());
						countVeiculo++;
						System.out.println("      -      ");
					}
				}
			}

			connection.commit(); // Confirmação para efetuar os comandos.

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs1);
			DB.closeStatement(st1);
			DB.closeResultSet(rs2);
			DB.closeStatement(st2);
			DB.closeConnection();
		}
	}

	public Cliente findByDoc(String doc) throws SQLException {

		String sqlbusca = "select * from cliente where cpf_cnpj = (?)";
		String sqlVeiculo = "select * from veiculo where proprietario = (?)";
		
		PreparedStatement st1 = null;
		ResultSet rs1 = null;
		
		PreparedStatement st2 = null;
		ResultSet rs2 = null;

		
		Cliente cliente = new Cliente();
		List<Veiculo> v = new ArrayList<>();

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlbusca);
			st1.setString(1, doc); // buscando o cliente com o cpf passado como argumento
			rs1 = st1.executeQuery(); // resultado da busca
			
			

		
			while (rs1.next()) {
		
				System.out.println("Cliente: " + rs1.getString("nome"));
				cliente.setId_cliente(rs1.getInt("id_cliente"));
				cliente.setNome(rs1.getString("nome"));
				cliente.setTelefone(rs1.getString("telefone"));
				cliente.setCpf_cnpj(rs1.getString("cpf_cnpj"));
			}
			
			st2 = connection.prepareStatement(sqlVeiculo);
			st2.setInt(1, cliente.getId_cliente()); // buscando o veiculo do cliente
			rs2 = st2.executeQuery(); // resultado da busca	
				
				while(rs2.next()) {
					Veiculo veiculos = new Veiculo();
					veiculos.setId_veiculo(rs2.getInt("id_veiculo"));
					veiculos.setProprietario(rs2.getInt("proprietario"));
					veiculos.setPlaca(rs2.getString("placa"));
					veiculos.setFabricante(rs2.getString("fabricante"));
					veiculos.setModelo(rs2.getString("modelo"));
					veiculos.setTipo_veiculo(rs2.getString("tipo_veiculo"));
					v.add(veiculos);
				}
				
				cliente.setVeiculos(v);
			connection.commit(); // Confirmação para efetuar os comandos.
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			
		}
		
		return cliente; 
	}

	public void update(Cliente cliente) throws SQLException {

		String sqlUpdate = "update cliente set nome = (?), telefone = (?), cpf_cnpj = (?)" + " where id_cliente = (?)";
		PreparedStatement statementUpdate = null;

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			statementUpdate = connection.prepareStatement(sqlUpdate);
			statementUpdate.setString(1, cliente.getNome());
			statementUpdate.setString(2, cliente.getTelefone());
			statementUpdate.setString(3, cliente.getCpf_cnpj());
			statementUpdate.setInt(4, cliente.getId_cliente());
			statementUpdate.executeUpdate();
			connection.commit(); // Confirmação para efetuar os comandos.

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeStatement(statementUpdate);
			DB.closeConnection();
		}

	}

	public void delete(Cliente cliente) throws SQLException {

		String sqlDeleteVeiculo = "DELETE FROM veiculo WHERE proprietario = (?);";
		String sqlDeleteCliente = "DELETE FROM cliente WHERE id_cliente = (?);";

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlDeleteVeiculo);
			st2 = connection.prepareStatement(sqlDeleteCliente);

			st1.setInt(1, cliente.getId_cliente());
			st1.executeUpdate();
			st2.setInt(1, cliente.getId_cliente());
			st2.executeUpdate();

			connection.commit(); // Confirmação para efetuar os comandos.

			System.out.println("Cliente deletado");

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeStatement(st1);
			DB.closeConnection();
		}

	}

}
