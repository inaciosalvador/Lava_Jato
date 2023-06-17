package application;

import java.sql.SQLException;

import dao.ClienteDAO;
import dao.VeiculoDao;
import entities.Cliente;
import entities.Veiculo;

public class programa {

	public static void main(String[] args) throws SQLException {

		ClienteDAO c = new ClienteDAO();
		c.read();
		
	}
}
