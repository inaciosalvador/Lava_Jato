package application;

import java.sql.SQLException;

import dao.CadastrarNovoClienteDAO;
import entities.Cliente;
import entities.Veiculo;

public class programa {

	public static void main(String[] args) throws SQLException {

		Cliente c = new Cliente();
		Veiculo v = new Veiculo();
		CadastrarNovoClienteDAO novoCliente = new CadastrarNovoClienteDAO();
		c.create();
		v.create();
		novoCliente.create(c, v);
		
	}
}
