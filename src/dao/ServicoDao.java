package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import entities.Servico;

public class ServicoDao {

	Connection connection = null;

	public void create(Servico servico) throws SQLException {
		String sql = "INSERT INTO servico (descricao, preco)" + " VALUES (?, ?)";

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement statementServico = connection.prepareStatement(sql);
			statementServico.setString(1, servico.getDescricao());
			statementServico.setDouble(2, servico.getPreco());
			statementServico.executeUpdate();

			statementServico.close();
			connection.commit();

		} catch (SQLException e) {

			connection.rollback();
			System.out.println("Erro ao cadastrar serviço: " + e.getMessage());
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

		String sqlServico = "select * from servico";

		PreparedStatement st1 = null;
		ResultSet rs1 = null;

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlServico);
			rs1 = st1.executeQuery();

			List<Servico> servicos = new ArrayList<>(); // guardará todos os resultados do banco para ser impresso
														// depois

			while (rs1.next()) {
				Servico servico = new Servico(); // guarda o objeto atual do loop

				servico.setId_servico(rs1.getInt("id_servico"));
				servico.setDescricao(rs1.getString("descricao"));
				servico.setPreco(rs1.getDouble("preco"));

				servicos.add(servico); // adiciona o objeto atual na lista a ser impressa no forech abaixo

			}

			for (Servico servico : servicos) {
				System.out.println("Id serviço: " + servico.getId_servico());
				System.out.println("Descrição: " + servico.getDescricao());
				System.out.println("Preço cadastrado: " + servico.getPreco());
				System.out.println("-----------------------------------------");
			}

			connection.commit(); // Confirmação para efetuar os comandos.

		} catch (Exception e) {
			connection.rollback();
			System.out.println("Não encontrado: ");
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs1);
			DB.closeStatement(st1);
			DB.closeConnection();
		}
	}

	public Servico findById(int id) throws SQLException {

		String sqlBusca = "select * from servico where id_servico = (?)";
		PreparedStatement st1 = null;
		ResultSet rs1 = null;

		Servico servico = new Servico();

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sqlBusca);
			st1.setInt(1, id); // buscando o veiculo com a placa passada como argumento
			rs1 = st1.executeQuery(); // resultado da busca

			while (rs1.next()) {
				System.out.println("Id servico: " + rs1.getInt("id_servico"));
				servico.setId_servico(rs1.getInt("id_servico"));
				servico.setDescricao(rs1.getString("descricao"));
				servico.setPreco(rs1.getDouble("preco"));
			}

			connection.commit(); // Confirmação para efetuar os comandos.

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs1);
			DB.closeStatement(st1);
		}

		return servico;
	}

	public void updateServico(Servico servico) throws SQLException {

		String sqlUpdate = "update servico set descricao = (?), preco = (?) where id_servico = (?)";

		PreparedStatement statementUpdate = null;

		try {

			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			statementUpdate = connection.prepareStatement(sqlUpdate);
			statementUpdate.setString(1, servico.getDescricao());
			statementUpdate.setDouble(2, servico.getPreco());
			statementUpdate.setDouble(3, servico.getId_servico());

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

	public void deleteServico(Servico servico) throws SQLException {

		String sqlDeleteServico = "delete from servico where id_servico = (?)";

		PreparedStatement stServico = null;

		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			stServico = connection.prepareStatement(sqlDeleteServico);
			stServico.setInt(1, servico.getId_servico());
			stServico.executeUpdate();

			connection.commit(); // Confirmação para efetuar os comandos.
			System.out.println("Serviço deletado com exito! ");
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			DB.closeStatement(stServico);
			DB.closeConnection();
		}

	}
}
