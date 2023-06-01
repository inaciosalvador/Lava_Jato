package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.entities.OrdemServico;
import model.entities.Servico;

public class ClienteDaoJDBC implements ClienteDao{
	
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn; 
		/* Dependencia com a conexão para evitar
		 *  a criação de objetos em outros metodos
		 */
	}

	@Override
	public void inserir(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente pesquisaId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"select c.*, o.observacao "
					+"from cliente c "
					+"join os o on c.id_cliente = o.id_cliente "
					+"where c.id_cliente = ?");	
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				
				OrdemServico os = new OrdemServico();
				os.setObservacao(rs.getString("observacao"));
				Cliente cl = new Cliente();
				cl.setId_cliente(rs.getInt("id_cliente"));
				cl.setNome(rs.getString("nome"));
				cl.setTelefone(rs.getString("telefone"));
				cl.setCpf_cnpj(rs.getString("cpf_cnpj"));
				// erro na consulta do banco
				
			}
			
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
