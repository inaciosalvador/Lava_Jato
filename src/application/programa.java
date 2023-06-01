package application;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class programa {

	public static void main(String[] args) {
		
		ClienteDao clienteDao = DaoFactory.CadClienteDao();
		
		Cliente cliente = clienteDao.pesquisaId(1);
		
		System.out.println(cliente);
		
		
		/*
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select o.id_ordem, c.nome, v.placa, p.data_servico, s.descricao, o.observacao\r\n"
					+ "from os o\r\n" + "join cliente c on o.id_cliente = c.id_cliente\r\n"
					+ "join veiculo v on v.proprietario = c.id_cliente\r\n"
					+ "join pedido p on p.id_ordem = o.id_ordem\r\n"
					+ "join servico s on s.id_servico = p.id_servico;");

			while (rs.next()) {
				System.out.println(rs.getInt("id_ordem") + ", " + rs.getString("nome") + ", " + rs.getString("placa")
						+ ", " + rs.getDate("data_servico") + ", " + rs.getString("descricao") + ", "
						+ rs.getString("observacao")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		*/
	}
}
