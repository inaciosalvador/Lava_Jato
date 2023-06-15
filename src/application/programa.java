package application;

import java.sql.SQLException;

import dao.VeiculoDao;
import entities.Cliente;
import entities.Veiculo;

public class programa {

	public static void main(String[] args) throws SQLException {

		/*Cliente c = new Cliente();
		Veiculo v = new Veiculo();
		ClienteDAO novoCliente = new ClienteDAO();
		c.create();
		v.createVeiculo();
		novoCliente.create(c, v);*/
		
		
		
		// adicionando um veiculo ao cliente id = 25 (lucas w)
		Veiculo v = new Veiculo();
		Cliente c = new Cliente();
		VeiculoDao vDao = new VeiculoDao();
		v.createVeiculo();
		vDao.addNewVeiculo(c.readByDoc(), v);
		
		
		
		
		
	}
}
