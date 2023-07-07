package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.ServicoDao;
import dao.VeiculoDao;
import entities.Cliente;
import entities.OrdemServico;
import entities.Servico;
import entities.Veiculo;



public class programa  {
	public static void main(String[] args) throws SQLException {
		
		 Scanner teclado = new Scanner(System.in);

		// cadastrar cliente
		/*
		 * Cliente c = new Cliente(); Veiculo v = new Veiculo(); ClienteDAO cdao = new
		 * ClienteDAO();
		 * 
		 * c.create(); v.createVeiculo(); cdao.create(c, v);
		 */

		// -------------------------------------------------------

		// Listar todos os clientes

		
		 // ClienteDAO cdao = new ClienteDAO(); cdao.read();
		 

		// -------------------------------------------------------

		// editar clientes
		/*
		 * Cliente cliente = new Cliente(); // está recebendo o cliente do banco
		 * ClienteDAO c = new ClienteDAO(); // usado para operar no banco Cliente
		 * cliente1 = new Cliente(); // usado para atualizar o objeto na classe
		 * 
		 * System.out.println("Informe o Nº de documento: "); String doc =
		 * teclado.nextLine();
		 * 
		 * cliente = c.findByID(doc); cliente1 = cliente.update(cliente); // contem o
		 * objeto alterado c.update(cliente1);
		 */

		// -------------------------------------------------------

		// deletar clientes

		/*
		 * Cliente c = new Cliente(); 
		 * ClienteDAO cdao = new ClienteDAO();
		 * 
		 * System.out.println("Informe o Nº de documento: "); 
		 * String doc = teclado.nextLine();
		 * 
		 * c = cdao.findByID(doc); // guarda o cliente que será apagado cdao.delete(c);
		 */
		
		// -------------------------------------------------------
		// -------------------------------------------------------
		// -------------------------------------------------------
		// -------------------------------------------------------
		// -------------------------------------------------------
		
					// read veiculos
		/*
		VeiculoDao v = new VeiculoDao();
		v.read();
		*/
		
		// -------------------------------------------------------
		
							// update veiculo
		/*
		Veiculo veiculoMemoria = new Veiculo(); // recebe o cliente do banco
		Veiculo veiculoAlterado = new Veiculo(); 
		VeiculoDao v = new VeiculoDao();
		
		System.out.println("Insira a placa do carro: ");
		String placa = teclado.nextLine();
		
		veiculoMemoria = v.findByPlaca(placa); 
		// objeto de memoria recebe o veiculo do banco,
		// que foi buscado atraves da placa
		
		veiculoAlterado = veiculoMemoria.update(veiculoMemoria);
		// veiculo alterado recebeu o veiculo de memoria executando o update em memoria
		
		v.updateVeiculo(veiculoAlterado);
		// executando o update no banco passando o novo veiculo.
		*/
		 
		 
		// -------------------------------------------------------
		
		 				// delete Veiculo 
		 /*
		 Veiculo v = new Veiculo();
		 VeiculoDao vdao = new VeiculoDao();
		 
		 System.out.println("Informe a placa do veiculo a ser deletado: ");
		 String placaDelete = teclado.nextLine();
		 
		 v = vdao.findByPlaca(placaDelete);
		 vdao.deleteVeiculo(v);
		 */
		 
		// -------------------------------------------------------
		 
		 // cadastrar servico 
		 
		 
		 
		 
		// -------------------------------------------------------
		 				// read serviços
		/* 
		 ServicoDao s = new ServicoDao();
		 s.read();
		 */
		// -------------------------------------------------------
		 			// update servico
		 /*
		 Servico servicoMemoria = new Servico(); // recebe o servico do banco
		 Servico ServicoAlterado = new Servico();
		 ServicoDao s = new ServicoDao();
		 
		 System.out.println("Insira o codigo do serviço a ser alterado: ");
		 int codigo = teclado.nextInt();
		 
		 servicoMemoria = s.findById(codigo); 
		 // servicoMemoria recebe o servico escolhido
		 // e enviará para a classe/entidade de alteração em memoria
		 
		 ServicoAlterado = servicoMemoria.update(servicoMemoria);
		 // serviçoAlterado recebe o servico de memoria já modificado pela classe/entidade
		 
		 s.updateServico(ServicoAlterado);
		 // executa a mudança no banco atualizando o novo serviço
		  * */
		  
		 	 
		// -------------------------------------------------------
		  						//delete
		  /*
		  Servico s = new Servico();
		  ServicoDao sDao = new ServicoDao();
		  
		  System.out.println("Informe o codigo do serviço a ser deletado: ");
		  int idServico = teclado.nextInt();
		  
		  s = sDao.findById(idServico);
		  sDao.deleteServico(s);
		  */
		 
		// -------------------------------------------------------
		 
		 			//gerar ordem de serviço
		 
		 OrdemServico o = new OrdemServico();
		 OrdemServico o1 = new OrdemServico();
		 
		 o1 = o.gerarOrdem();
		 
		 System.out.println(o1);
		 
		 
		 		 
		 
	}

}
