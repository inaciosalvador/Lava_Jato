package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import entities.Servico;

public class ServicoDao {

	public void create(Servico servico) throws SQLException {
		String sql = "INSERT INTO servico (descricao, preco)" + " VALUES (?, ?)";

		Connection connection = null;

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
}
