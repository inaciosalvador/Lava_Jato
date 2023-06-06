package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import db.DB;
import db.DbException;
import entities.Servico;

public class ServicoDao {

	public void create(Servico servico) {
		String sql = "INSERT INTO servico (descricao, preco)" + " VALUES (?, ?)";

		try (Connection connection = DB.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, servico.getDescricao());
			statement.setDouble(2, servico.getPreco());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
