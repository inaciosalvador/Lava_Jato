package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.entities.Cliente;
import model.entities.Veiculo;

public class VeiculoDao {

	Connection connection = null;

	public void addNewVeiculo(String cpf_cnpj, Veiculo veiculo) throws SQLException {

		String sqlAddVeiculo = "INSERT INTO veiculo (proprietario, placa, fabricante, modelo, tipo_veiculo)"
				+ " VALUES (?, ?, ?, ?, ?)";

		String retornarProprietario = "SELECT id_cliente FROM cliente WHERE cpf_cnpj = (?)";

		int idCliente = -1; // Para guardar o ID do cliente

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			PreparedStatement statementIdCliente = connection.prepareStatement(retornarProprietario);
			statementIdCliente.setString(1, cpf_cnpj);
			ResultSet resultSet = statementIdCliente.executeQuery();
			if (resultSet.next()) {
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
			if (connection != null) {
				try {
					connection.close();
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

			List<Cliente> clientes = new ArrayList<>();

			while (rs1.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs1.getInt("id_cliente"));
				cliente.setNome(rs1.getString("nome"));
				cliente.setTelefone(rs1.getString("telefone"));
				cliente.setCpf_cnpj(rs1.getString("cpf_cnpj"));
				clientes.add(cliente);

			}

			System.out.println(" ===== Lista de Veiculo ===== ");
			System.out.println("");

			while (rs2.next()) {

				System.out.println("Id veiculo: " + rs2.getInt("id_veiculo"));
				System.out.println("Placa: " + rs2.getString("placa"));

				System.out.println("             ***            ");

				for (Cliente cliente : clientes) {

					if (cliente.getId_cliente() == rs2.getInt("proprietario")) {
						System.out.println("Proprietario: " + cliente.getNome());
						System.out.println("Nº doc: " + cliente.getCpf_cnpj());
					}
				}

				System.out.println("=================================================");

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

	public Veiculo findByPlaca(String placa) throws SQLException {

		String sqlbusca = "select * from veiculo where placa = (?)";
		PreparedStatement st1 = null;
		ResultSet rs1 = null;

		Veiculo veiculo = new Veiculo(); // guardar o veiculo que veio do banco

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlbusca);
			st1.setString(1, placa); // buscando o veiculo com a placa passada como argumento

			rs1 = st1.executeQuery(); // resultado da busca

			while (rs1.next()) {
				System.out.println("Id proprietario " + rs1.getString("proprietario"));
				veiculo.setId_veiculo(rs1.getInt("id_veiculo"));
				veiculo.setProprietario(rs1.getInt("proprietario"));
				veiculo.setPlaca(rs1.getString("placa"));
				veiculo.setFabricante(rs1.getString("fabricante"));
				veiculo.setModelo(rs1.getString("modelo"));
				veiculo.setTipo_veiculo(rs1.getString("tipo_veiculo"));
			}

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs1);
			DB.closeStatement(st1);
		}

		return veiculo; // veiculo será usado para o metodo update abaixo

	}

	public void updateVeiculo(Veiculo veiculo) throws SQLException {
		String sqlUpdate = "update veiculo set" + " placa = (?)," + " fabricante = (?)," + " modelo = (?),"
				+ " tipo_veiculo = (?)" + " where id_veiculo = (?)";
		PreparedStatement statementUpdate = null;

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			statementUpdate = connection.prepareStatement(sqlUpdate);
			statementUpdate.setString(1, veiculo.getPlaca());
			statementUpdate.setString(2, veiculo.getFabricante());
			statementUpdate.setString(3, veiculo.getModelo());
			statementUpdate.setString(4, veiculo.getTipo_veiculo());
			statementUpdate.setInt(5, veiculo.getId_veiculo());
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

	public void deleteVeiculo(Veiculo veiculo) throws SQLException {

		String sqlDeleteVeiculo = "delete from veiculo where placa = (?)";

		PreparedStatement stVeiculo = null;

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit
			
			stVeiculo = connection.prepareStatement(sqlDeleteVeiculo);
			stVeiculo.setString(1, veiculo.getPlaca());
			stVeiculo.executeUpdate();
			
			connection.commit(); // Confirmação para efetuar os comandos.
			System.out.println("Veiculo deletado");

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeStatement(stVeiculo);
			DB.closeConnection();
		}
	}
}
