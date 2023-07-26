package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Text;

import dao.ClienteDAO;
import dao.ServicoDao;
import dao.VeiculoDao;
import dao.osDao;
import model.entities.Cliente;
import model.entities.OrdemServico;
import model.entities.Servico;
import model.entities.Veiculo;

public class programa {
	public static void main(String[] args) throws SQLException {

		Scanner teclado = new Scanner(System.in);

		// cadastrar cliente
		

		 

		// -------------------------------------------------------

		// Listar todos os clientes

		// 

		// -------------------------------------------------------

		// editar clientes
		/*
		  Cliente cliente = new Cliente(); // está recebendo o cliente do banco
		  ClienteDAO c = new ClienteDAO(); // usado para operar no banco Cliente
		  Cliente cliente1 = new Cliente(); // usado para atualizar o objeto na classe
		  
		  System.out.println("Informe o Nº de documento: "); String doc =
		  teclado.nextLine();
		  
		  cliente = c.findByDoc(doc);
		  cliente1 = cliente.update(cliente); 
		  c.update(cliente1);
		 */

		// -------------------------------------------------------

		// deletar clientes

		/*
		 * Cliente c = new Cliente(); ClienteDAO cdao = new ClienteDAO();
		 * 
		 * System.out.println("Informe o Nº de documento: "); String doc =
		 * teclado.nextLine();
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
		 * VeiculoDao v = new VeiculoDao(); v.read();
		 */

		// -------------------------------------------------------

		// update veiculo
		/*
		 * Veiculo veiculoMemoria = new Veiculo(); // recebe o cliente do banco Veiculo
		 * veiculoAlterado = new Veiculo(); VeiculoDao v = new VeiculoDao();
		 * 
		 * System.out.println("Insira a placa do carro: "); String placa =
		 * teclado.nextLine();
		 * 
		 * veiculoMemoria = v.findByPlaca(placa); // objeto de memoria recebe o veiculo
		 * do banco, // que foi buscado atraves da placa
		 * 
		 * veiculoAlterado = veiculoMemoria.update(veiculoMemoria); // veiculo alterado
		 * recebeu o veiculo de memoria executando o update em memoria
		 * 
		 * v.updateVeiculo(veiculoAlterado); // executando o update no banco passando o
		 * novo veiculo.
		 */

		// -------------------------------------------------------

		// delete Veiculo
		/*
		 * Veiculo v = new Veiculo(); VeiculoDao vdao = new VeiculoDao();
		 * 
		 * System.out.println("Informe a placa do veiculo a ser deletado: "); String
		 * placaDelete = teclado.nextLine();
		 * 
		 * v = vdao.findByPlaca(placaDelete); vdao.deleteVeiculo(v);
		 */

		// -------------------------------------------------------

		// cadastrar servico

		// -------------------------------------------------------
		// read serviços
		/*
		 * ServicoDao s = new ServicoDao(); s.read();
		 */
		// -------------------------------------------------------
		// update servico
		/*
		 * Servico servicoMemoria = new Servico(); // recebe o servico do banco Servico
		 * ServicoAlterado = new Servico(); 
		 * ServicoDao s = new ServicoDao();
		 * 
		 * System.out.println("Insira o codigo do serviço a ser alterado: "); 
		 * int codigo = teclado.nextInt();
		 * 
		 * servicoMemoria = s.findById(codigo); 
		 * ServicoAlterado = servicoMemoria.update(servicoMemoria); 
		 * s.updateServico(ServicoAlterado); 
		 */

		// -------------------------------------------------------
		// delete
		/*
		 * Servico s = new Servico(); ServicoDao sDao = new ServicoDao();
		 * 
		 * System.out.println("Informe o codigo do serviço a ser deletado: "); int
		 * idServico = teclado.nextInt();
		 * 
		 * s = sDao.findById(idServico); sDao.deleteServico(s);
		 */

		// -------------------------------------------------------

		// gerar ordem de serviço
		
		/*

		ClienteDAO c = new ClienteDAO();
		VeiculoDao v = new VeiculoDao();
		ServicoDao s = new ServicoDao();
		Servico servs = new Servico();
		Cliente c1 = new Cliente();
		osDao gerarOrdem = new osDao();
		
		System.out.println("Insira o numero de documento do cliente: ");
		String doc = teclado.next();
		
		c1 = c.findByDoc(doc);
		
		
		for (Veiculo veiculo : c1.getVeiculos()) {
			System.out.println("Placa: " + veiculo.getPlaca());
		}	
		
		List<Servico> pedido = new ArrayList<>();
		int resp = 1;
		
		System.out.println("   ");
		
		while(resp == 1) {
			System.out.println("Insira o codigo do pedido: ");	
			int serv = teclado.nextInt();
			servs = s.findById(serv);
			pedido.add(servs);
			
			System.out.println("Deseja incluir outro serviço? ");
			System.out.println("1 para sim");
			System.out.println("2 para não");
			resp = teclado.nextInt();
		}
		
		
		teclado.nextLine(); // Consumir a quebra de linha pendente
		
		System.out.println(" - Observações adicionais - ");
		String observacao = teclado.nextLine();
		
		Double valorTotal = 0d ;
		
		for(Servico ss : pedido) {
			valorTotal += ss.getPreco();
		}
		
		OrdemServico os = new OrdemServico(c1, observacao, pedido, valorTotal);
		gerarOrdem.gerarOrdem(os);
		
		System.out.println("");
		System.out.println("=======================================================");
		System.out.println("             Ordem de Serviço");
		System.out.println("=======================================================");
		System.out.println("");
		System.out.println("             Numero de Ordem: " + os.getId_ordem());
		System.out.println("             Cliente: " + os.getId_cliente().getNome());
		System.out.println("             Serviços escolhidos: ");
		System.out.println(" ");
		
		for(Servico ser : pedido) {
			System.out.println(" * " + ser.getDescricao() + ": R$ " + ser.getPreco());
		}
		
		System.out.println(" ");
		
		System.out.println("Observações adicionais: " + os.getObservacao());
		System.out.println("=======================================================");
		System.out.println("Valor total do Pedido: " + "R$ " + valorTotal);
		System.out.println("=======================================================");
		*/

		// -------------------------------------------------------
		
		System.out.println("                  Bem vindo! ");
		
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Clientes ");
		System.out.println("2 - Veiculos ");
		System.out.println("3 - Serviços ");
		System.out.println("4 - Vendas ");
		System.out.println("5 - Relatórios ");
		System.out.println("6 - Sair ");

		int esc = teclado.nextInt();
		
		switch (esc) {
		case 1:
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Listar Clientes ");
			System.out.println("3 - Buscar Cliente ");
			System.out.println("4 - Atualizar Cadastro ");
			System.out.println("5 - Deletar Cliente ");
			
		int n1 = teclado.nextInt();
			switch (n1) {
			case 1: // Cadastro de clientes
			    Cliente c1 = new Cliente(); 
			    Veiculo v = new Veiculo(); 
			    ClienteDAO cdao = new ClienteDAO();
				c1.create(); v.createVeiculo(); cdao.create(c1, v);
				break;
			case 2:	// Listar todos os clientes 
				ClienteDAO cldao = new ClienteDAO(); 
				cldao.read();
				break;
			case 3:	// Buscar cliente
				Cliente clienteB = new Cliente();
				ClienteDAO cc = new ClienteDAO();
				
				System.out.println("Informe o Nº de documento: ");
				String doc1 = teclado.nextLine();
				clienteB = cc.findByDoc(doc1);
				
				System.out.println("Dados do Cliente: ");
				System.out.println("Nome: " + clienteB.getNome());
				System.out.println("Telefone: " + clienteB.getTelefone());
				System.out.println("Documento: " + clienteB.getCpf_cnpj());
				
				for(Veiculo vv : clienteB.getVeiculos()) {
					System.out.println(" - Veiculo - ");
					System.out.println(vv.getPlaca());
					System.out.println(vv.getModelo());
				}
				
				System.out.println("            --        ");
				break;	
			case 4:	// Atualizar cadastro
				System.out.println("  - Atualizar cadastro de cliente - ");
				Cliente cliente2 = new Cliente(); // está recebendo o cliente do banco
			    ClienteDAO c2 = new ClienteDAO(); // usado para operar no banco Cliente
				Cliente cliente3 = new Cliente(); // usado para atualizar o objeto na classe
				  
				System.out.println("Informe o Nº de documento: "); 
				String documento = teclado.nextLine();
				  
				cliente2 = c2.findByDoc(documento);
				cliente3 = cliente2.update(cliente2); 
				c2.update(cliente3);
				break;	
			case 5: // Deletar cliente
				System.out.println(" - Deletar cliente - ");
				
				Cliente c4 = new Cliente(); 
				ClienteDAO cdao1 = new ClienteDAO();
				 
				System.out.println("Informe o Nº de documento: "); 
				String doc2 = teclado.nextLine();
				
				c4 = cdao1.findByDoc(doc2); // guarda o cliente que será apagado 
				cdao1.delete(c4);
				
			default:
				
				break;
			}
			break;
		case 2:
			System.out.println("1 - Cadastrar Novo Veiculo ");
			System.out.println("2 - Listar Veiculos ");
			System.out.println("3 - Buscar Veiculo ");
			System.out.println("4 - Atualizar Cadastro de Veiculo ");
			System.out.println("5 - Deletar Veiculo ");
			break;
		case 3:
			System.out.println("1 - Cadastrar Serviço");
			System.out.println("2 - Listar Serviços ");
			System.out.println("3 - Buscar Serviço ");
			System.out.println("4 - Atualizar Cadastro de Serviço ");
			System.out.println("5 - Deletar Serviço ");
			break;	
		case 4:
			System.out.println("1 - Gerar Pedido ");
		case 5:
			System.out.println("1 - Consultar Venda ");
			System.out.println("2 - Relatório de Vendas ");
			break;		
		default:
			System.out.println("Insira uma opção valida! ");
			break;
		}
		
	
	}
}
