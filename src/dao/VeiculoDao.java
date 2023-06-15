package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DB;
import db.DbException;
import entities.Cliente;
import entities.Veiculo;

public class VeiculoDao {

	public void create(Veiculo veiculo) {
		
		String sql = "INSERT INTO veiculo (placa, fabricante, modelo, tipo_veiculo)" +
		             " VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
				
		try {
			
			connection = DB.getConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, veiculo.getPlaca());
			statement.setString(2, veiculo.getFabricante());
			statement.setString(3, veiculo.getModelo());
			statement.setString(4, veiculo.getTipo_veiculo());
			statement.executeUpdate();
			
			System.out.println("Veiculo cadastrato! ");

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
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

	public void insertProprietario(Cliente cliente) {
		String sql = "UPDATE veiculo SET proprietario = ? WHERE proprietario IS NULL";

		try (Connection connection = DB.getConnection()) {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, cliente.getId_cliente());
			statement.executeUpdate();
			
			System.out.println("Proprietário associado corretamente");

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
	}
}
