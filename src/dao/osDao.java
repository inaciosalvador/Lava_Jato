package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import db.DB;
import model.entities.OrdemServico;

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

			st1 = connection.prepareStatement(sql);
			
			st1.setInt(1, os.getId_cliente().getId_cliente()); 
			st1.setString(2, os.getObservacao());
			st1.setDouble(3, os.getValor_os());
			rs1 = st1.executeQuery();
			
			int idOrdem = rs1.getInt("id_ordem"); // guarda o id da ordem de serviço, gerado pelo banco.
			
			st1 = connection.prepareStatement(sql2);
			
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime data = LocalDateTime.now();
			
			java.sql.Timestamp time = java.sql.Timestamp.valueOf(data);
			
			st1.setTimestamp(1, time);
			st1.setInt(2, os.getId_ordem());
			 // criar um loop para armazenar a lista de serviços
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			connection.rollback();
			System.out.println("Não encontrado: ");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
