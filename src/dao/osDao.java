package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
	
	public void consultarFaturamento(String inicio, String fim) throws SQLException {
		
		String sql = "SELECT sum(preco) FROM pedido p "
				+ "JOIN servico s ON p.id_servico = s.id_servico "
				+ "WHERE data_servico BETWEEN (?) AND (?) "
				+ "ORDER BY preco DESC;";
		
		PreparedStatement st1 = null;
		ResultSet rs1 = null;
		
		try {
			connection = DB.getConnection();
			connection.setAutoCommit(false); // desativando o autocommit
			st1 = connection.prepareStatement(sql);
			st1.setString(1, inicio);
			st1.setString(2, fim);
			rs1 = st1.executeQuery();
			
			DateTimeFormatter userInputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			String inicio1 = LocalDate.parse(inicio, userInputFormatter)
                       .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			String fim1 = LocalDate.parse(fim, userInputFormatter)
                     .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			NumberFormat faturamento = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			while(rs1.next()) {
				System.out.println("================================================");
				System.out.println("Valor faturado entre " + inicio1 +" e " + fim1 + " é de: R$ " + faturamento.format(rs1.getDouble("sum(preco)")));
				System.out.println("================================================");
			}
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		
		
		
	}
}
