package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import db.DB;
import model.entities.OrdemServico;
import model.entities.Servico;

public class osDao {
	
	Connection connection = null;
	
	public void gerarOrdem(OrdemServico os) throws SQLException {
		
		String sql = "insert into os (id_cliente, observacao, valor_os) values (?, ?, ?)";
		String sql2 = "insert into pedido (data_servico, id_servico, id_ordem) values (?,?,?)";
		PreparedStatement st1 = null;
		ResultSet rs1 = null;
		
		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit

			st1 = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			st1.setInt(1, os.getId_cliente().getId_cliente()); 
			st1.setString(2, os.getObservacao());
			st1.setDouble(3, os.getValor_os());
			st1.executeUpdate();
			
			 ResultSet generatedKeys = st1.getGeneratedKeys();
	            int idOrdem = 0;

	            if (generatedKeys.next()) {
	                idOrdem = generatedKeys.getInt(1);
	            }
  
			st1 = connection.prepareStatement(sql2);
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime data = LocalDateTime.now();
			
			java.sql.Timestamp time = java.sql.Timestamp.valueOf(data);

			for(Servico s : os.getServico()) {
				st1.setTimestamp(1, time); // data a ser armazenada
				st1.setInt(2, s.getId_servico()); // id do serviço
				st1.setInt(3, idOrdem); // id da ordem de serviço
				st1.executeUpdate();
			}		
			
			connection.commit();
			os.setId_ordem(idOrdem); // entregando o id da ordem de serviço
			
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
	
	public void consultarVenda(int id) throws SQLException {
		
		String sql = "select * from os where id_ordem = (?)";
		PreparedStatement st1 = null;
		ResultSet rs1 = null;
		
		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit
			st1 = connection.prepareStatement(sql);
			st1.setInt(1, id);
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				System.out.println("================================================");
				System.out.println("  Id Ordem de serviço: " + rs1.getInt("id_ordem"));
				System.out.println("  Id Cliente: " + rs1.getInt("id_cliente"));
				System.out.println("  Observação: " + rs1.getString("observacao"));
				System.out.println("  Valor total: " + rs1.getDouble("valor_os"));
				System.out.println("================================================");
			}
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
}
