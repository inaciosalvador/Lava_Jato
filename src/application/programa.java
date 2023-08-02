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
		 * Cliente cliente = new Cliente(); // está recebendo o cliente do banco
		 * ClienteDAO c = new ClienteDAO(); // usado para operar no banco Cliente
		 * Cliente cliente1 = new Cliente(); // usado para atualizar o objeto na classe
		 * 
		 * System.out.println("Informe o Nº de documento: "); String doc =
		 * teclado.nextLine();
		 * 
		 * cliente = c.findByDoc(doc); cliente1 = cliente.update(cliente);
		 * c.update(cliente1);
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
		 * ServicoAlterado = new Servico(); ServicoDao s = new ServicoDao();
		 * 
		 * System.out.println("Insira o codigo do serviço a ser alterado: "); int codigo
		 * = teclado.nextInt();
		 * 
		 * servicoMemoria = s.findById(codigo); ServicoAlterado =
		 * servicoMemoria.update(servicoMemoria); s.updateServico(ServicoAlterado);
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
		 * 
		 * ClienteDAO c = new ClienteDAO(); VeiculoDao v = new VeiculoDao(); ServicoDao
		 * s = new ServicoDao(); Servico servs = new Servico(); Cliente c1 = new
		 * Cliente(); osDao gerarOrdem = new osDao();
		 * 
		 * System.out.println("Insira o numero de documento do cliente: "); String doc =
		 * teclado.next();
		 * 
		 * c1 = c.findByDoc(doc);
		 * 
		 * 
		 * for (Veiculo veiculo : c1.getVeiculos()) { System.out.println("Placa: " +
		 * veiculo.getPlaca()); }
		 * 
		 * List<Servico> pedido = new ArrayList<>(); int resp = 1;
		 * 
		 * System.out.println("   ");
		 * 
		 * while(resp == 1) { System.out.println("Insira o codigo do pedido: "); int
		 * serv = teclado.nextInt(); servs = s.findById(serv); pedido.add(servs);
		 * 
		 * System.out.println("Deseja incluir outro serviço? ");
		 * System.out.println("1 para sim"); System.out.println("2 para não"); resp =
		 * teclado.nextInt(); }
		 * 
		 * 
		 * teclado.nextLine(); // Consumir a quebra de linha pendente
		 * 
		 * System.out.println(" - Observações adicionais - "); String observacao =
		 * teclado.nextLine();
		 * 
		 * Double valorTotal = 0d ;
		 * 
		 * for(Servico ss : pedido) { valorTotal += ss.getPreco(); }
		 * 
		 * OrdemServico os = new OrdemServico(c1, observacao, pedido, valorTotal);
		 * gerarOrdem.gerarOrdem(os);
		 * 
		 * System.out.println("");
		 * System.out.println("=======================================================")
		 * ; System.out.println("             Ordem de Serviço");
		 * System.out.println("=======================================================")
		 * ; System.out.println(""); System.out.println("             Numero de Ordem: "
		 * + os.getId_ordem()); System.out.println("             Cliente: " +
		 * os.getId_cliente().getNome());
		 * System.out.println("             Serviços escolhidos: ");
		 * System.out.println(" ");
		 * 
		 * for(Servico ser : pedido) { System.out.println(" * " + ser.getDescricao() +
		 * ": R$ " + ser.getPreco()); }
		 * 
		 * System.out.println(" ");
		 * 
		 * System.out.println("Observações adicionais: " + os.getObservacao());
		 * System.out.println("=======================================================")
		 * ; System.out.println("Valor total do Pedido: " + "R$ " + valorTotal);
		 * System.out.println("=======================================================")
		 * ;
		 */

		// -------------------------------------------------------

		int respostaPrincipal = 1;

		while (respostaPrincipal != 6) {

			System.out.println("                  Bem vindo! ");
			System.out.println("=============================================");

			System.out.println("Escolha uma sessão: ");
			System.out.println(" ");
			System.out.println("1 - Clientes ");
			System.out.println("2 - Veiculos ");
			System.out.println("3 - Serviços ");
			System.out.println("4 - Vendas ");
			System.out.println("5 - Relatórios ");
			System.out.println("6 - Sair ");

			int esc = teclado.nextInt();

			switch (esc) {
			case 1: // SESSÃO CLIENTES

				int resposta0 = 0;
				while (resposta0 != 6) {
					System.out.println("1 - Cadastrar Cliente");
					System.out.println("2 - Listar Clientes ");
					System.out.println("3 - Buscar Cliente ");
					System.out.println("4 - Atualizar Cadastro ");
					System.out.println("5 - Deletar Cliente ");
					System.out.println("6 - Sair");
					resposta0 = teclado.nextInt();

					switch (resposta0) {
					case 1: // Cadastro de clientes

						int resposta = 1;
						while (resposta == 1) {
							Cliente c1 = new Cliente();
							Veiculo v = new Veiculo();
							ClienteDAO cdao = new ClienteDAO();
							c1.create();
							v.createVeiculo();
							cdao.create(c1, v);
							System.out.println(" ------------------------");
							System.out.println("1 - Fazer novo cadastro ");
							System.out.println("2 - Voltar ao menu ");
							resposta = teclado.nextInt();
						}

						break;

					case 2: // Listar todos os clientes

						int resposta1 = 1;
						while (resposta1 == 1) {
							ClienteDAO cldao = new ClienteDAO();
							cldao.read();
							System.out.println("------------------------------------------");
							System.out.println("1 - Recarregar a lista ");
							System.out.println("2 - Voltar ao menu ");
							resposta1 = teclado.nextInt();
						}
						break;
					case 3: // Buscar cliente

						int resposta2 = 1;
						while (resposta2 == 1) {

							Cliente clienteB = new Cliente();
							ClienteDAO cc = new ClienteDAO();

							System.out.println("Informe o Nº de documento: ");
							String doc1 = teclado.nextLine();
							clienteB = cc.findByDoc(doc1);

							System.out.println("Dados do Cliente: ");
							System.out.println("Nome: " + clienteB.getNome());
							System.out.println("Telefone: " + clienteB.getTelefone());
							System.out.println("Documento: " + clienteB.getCpf_cnpj());

							for (Veiculo vv : clienteB.getVeiculos()) {
								System.out.println(" - Veiculo - ");
								System.out.println(vv.getPlaca());
								System.out.println(vv.getModelo());
							}

							System.out.println("            --        ");
							System.out.println("1 - Buscar outro cliente ");
							System.out.println("2 - Voltar ao menu ");
							resposta2 = teclado.nextInt();
						}
						break;
					case 4: // Atualizar cadastro

						int resposta4 = 1;
						while (resposta4 == 1) {
							System.out.println("  - Atualizar cadastro de cliente - ");
							Cliente cliente2 = new Cliente(); // está recebendo o cliente do banco
							ClienteDAO c2 = new ClienteDAO(); // usado para operar no banco Cliente
							Cliente cliente3 = new Cliente(); // usado para atualizar o objeto na classe

							System.out.println("Informe o Nº de documento: ");
							String documento = teclado.nextLine();

							cliente2 = c2.findByDoc(documento);
							cliente3 = cliente2.update(cliente2);
							c2.update(cliente3);

							System.out.println("1 - Atualizar outro cliente ");
							System.out.println("2 - Voltar ao menu ");
							resposta4 = teclado.nextInt();
						}
						break;
					case 5: // Deletar cliente

						int resposta5 = 1;
						while (resposta5 == 1) {
							System.out.println(" - Deletar cliente - ");

							Cliente c4 = new Cliente();
							ClienteDAO cdao1 = new ClienteDAO();

							System.out.println("Informe o Nº de documento: ");
							String doc2 = teclado.nextLine();

							c4 = cdao1.findByDoc(doc2); // guarda o cliente que será apagado
							cdao1.delete(c4);

							System.out.println("1 - Deletar outro cliente ");
							System.out.println("2 - Voltar ao menu ");
							resposta5 = teclado.nextInt();
						}
						break;
					case 6:
						break;
					default:
						System.out.println("Insira uma opção valida");
					}
				}
				break;
			case 2: // SESSÃO VEICULO

				int resposta1 = 0;
				while (resposta1 != 6) {
					System.out.println("1 - Cadastrar Novo Veiculo ");
					System.out.println("2 - Listar Veiculos ");
					System.out.println("3 - Buscar Veiculo ");
					System.out.println("4 - Atualizar Cadastro de Veiculo ");
					System.out.println("5 - Deletar Veiculo ");
					System.out.println("6 - Sair");
					resposta1 = teclado.nextInt();

					switch (resposta1) {
					case 1: // Cadastrar novo veiculo

						int resposta2 = 1;
						while (resposta2 == 1) {
							Scanner tec = new Scanner(System.in);
							Veiculo veiculo = new Veiculo();
							VeiculoDao vDao = new VeiculoDao();

							System.out.println("Insira o numero de documento do cliente: ");
							String doc = tec.nextLine();

							vDao.addNewVeiculo(doc, veiculo.createVeiculo());
							System.out.println(" ");

							System.out.println("1 - Cadastrar outro veiculo ");
							System.out.println("2 - Voltar ao menu ");
							resposta2 = teclado.nextInt();
						}
						break;
					case 2: // Listar todos os veiculos

						int resposta3 = 1;
						while (resposta3 == 1) {
							VeiculoDao v = new VeiculoDao();
							v.read();

							System.out.println("1 - Recarregar a lista ");
							System.out.println("2 - Voltar ao menu ");
							resposta3 = teclado.nextInt();
						}
						break;
					case 3: // Pesquisar por placa

						int resposta4 = 1;
						while (resposta4 == 1) {

							Veiculo veic = new Veiculo();
							VeiculoDao vd = new VeiculoDao();

							System.out.print("Insira a placa do veiculo: ");
							String placa = teclado.nextLine();

							// Atribuindo o veiculo retornado pelo banco
							// a variavel veic, e imprimindo logo abaixo
							veic = vd.findByPlaca(placa);

							System.out.println("          ==  Veiculo  ==  ");
							System.out.println("Id Veiculo: " + veic.getId_veiculo());
							System.out.println("Codigo do Proprietario: " + veic.getProprietario());
							System.out.println("Placa: " + veic.getPlaca());
							System.out.println("Fabricante: " + veic.getFabricante());
							System.out.println("Modelo: " + veic.getModelo());
							System.out.println("Tipo de veiculo: " + veic.getTipo_veiculo());
							System.out.println("===================================================");
							System.out.println("1 - Realizar nova pesquisa ");
							System.out.println("2 - Voltar ao menu ");
							resposta4 = teclado.nextInt();
						}
						break;
					case 4: // Atualizar cadastro de veiculo
						
						int resposta5 = 1;
						while(resposta5 == 1) {
						 	
							Veiculo veiculoMemoria = new Veiculo(); // recebe o cliente do banco Veiculo
							Veiculo veiculoAlterado = new Veiculo(); 
							VeiculoDao v = new VeiculoDao();
								 
						    System.out.println("Insira a placa do carro: "); 
						    String placa = teclado.nextLine();
							
						    // veiculoMemoria recebe o veiculo vindo do banco
							veiculoMemoria = v.findByPlaca(placa);	 
							
							// veiculoAlterado recebe o veiculo com os novos dados
							veiculoAlterado = veiculoMemoria.update(veiculoMemoria);
							
							// este comando faz a atualização do objeto no banco
						    v.updateVeiculo(veiculoAlterado); 
							
							System.out.println("===================================================");
							System.out.println("1 - Atualizar outro veiculo ");
							System.out.println("2 - Voltar ao menu ");
							resposta5 = teclado.nextInt();
						}
						break;
					case 5: // Deletar veiculo 
						
						int resposta6 = 1;
						while(resposta6 == 1) {
							
							Veiculo v = new Veiculo(); 
							VeiculoDao vdao = new VeiculoDao();
						
							System.out.println("Informe a placa do veiculo a ser deletado: "); 
							String placaDelete = teclado.nextLine();
							  
						    v = vdao.findByPlaca(placaDelete); 
							vdao.deleteVeiculo(v);
							
							System.out.println("===================================================");
							System.out.println("1 - Deletar outro veiculo ");
							System.out.println("2 - Voltar ao menu ");
							resposta6 = teclado.nextInt();
						}
						break;
					case 6:
						break;
					default:
						System.out.println("Atenção! Insira uma opção valida! ");
					}
				}
				break;
			case 3: // SESSÃO SERVIÇOS
				
				int resposta2 = 1;
				while(resposta2 != 6) {
					
					System.out.println("1 - Cadastrar Serviço");
					System.out.println("2 - Listar Serviços ");
					System.out.println("3 - Buscar Serviço ");
					System.out.println("4 - Atualizar Cadastro de Serviço ");
					System.out.println("5 - Deletar Serviço ");
					System.out.println("6 - Sair");
					resposta2 = teclado.nextInt();
					
					switch(resposta2) {
					case 1: // Cadastrar Serviço
						
						int resposta7 = 1;
						while(resposta7 == 1) {
							
							Servico serv = new Servico();
							ServicoDao servDao = new ServicoDao();
							
							servDao.create(serv.create());
							
							System.out.println("===================================================");
							System.out.println("1 - Cadastrar outro serviço ");
							System.out.println("2 - Voltar ao menu ");
							resposta7 = teclado.nextInt();
						}
						break;
					case 2: // Listar serviços
						
						int resposta8 = 1;
						while(resposta8 == 1) {
							
							ServicoDao s = new ServicoDao(); 
							s.read();
							
							System.out.println("===================================================");
							System.out.println("1 - Recarregar a lista ");
							System.out.println("2 - Voltar ao menu ");
							resposta8 = teclado.nextInt();
						}
						break;
					case 3: // Buscar Serviços 
						
						int resposta9 = 1;
						while(resposta9 == 1) {
							
							Servico serv = new Servico();
							ServicoDao servDao = new ServicoDao();
							
							System.out.println("Insira o id do serviço: ");
							int id = teclado.nextInt();
							serv = servDao.findById(id);
							
							System.out.println("  * Informações do serviço * ");
							System.out.println(" ");
							System.out.println("Id: " + serv.getId_servico());
							System.out.println("Descrição: " + serv.getDescricao());
							System.out.println("Preço: " + serv.getPreco());	
							
							System.out.println("===================================================");
							System.out.println("1 - Buscar outro serviço ");
							System.out.println("2 - Voltar ao menu ");
							resposta9 = teclado.nextInt();
						}
						break;
					case 4: // Atualizar serviços
						
						int resposta10 = 1;
						while(resposta10 == 1) {
							
							Servico servicoMemoria = new Servico(); // recebe o servico do banco Servico
							Servico ServicoAlterado = new Servico(); 
							ServicoDao s = new ServicoDao();
							  
							System.out.println("Insira o codigo do serviço a ser alterado: ");
							int codigo = teclado.nextInt();
							
							// recebe o serviço do banco e aloca em memoria
							servicoMemoria = s.findById(codigo);
							
							// recebe o serviço já alterado
							ServicoAlterado = servicoMemoria.update(servicoMemoria); 
							
							// executa a troca no banco
							s.updateServico(ServicoAlterado);
						
							System.out.println("===================================================");
							System.out.println("1 - Atualizar outro serviço ");
							System.out.println("2 - Voltar ao menu ");
							resposta10 = teclado.nextInt();
						}
						break;
					case 5: // deletar serviço
						
						int resposta11 = 1;
						while(resposta11 == 1) {
							
							Servico s = new Servico();
							ServicoDao sDao = new ServicoDao();
							
							System.out.println("Informe o codigo do serviço a ser deletado: ");
							int idServico = teclado.nextInt();
							
							s = sDao.findById(idServico); 
							sDao.deleteServico(s);
							
							System.out.println("===================================================");
							System.out.println("1 - Atualizar outro serviço ");
							System.out.println("2 - Voltar ao menu ");
							resposta11 = teclado.nextInt();
						}
						break;
					case 6:
						break;	
					default: 
						System.out.println("Insira uma opção valida! ");
					}
				}
				break;
			case 4: // SESSÃO VENDAS
				System.out.println("1 - Gerar Pedido ");
			case 5: // SESSÃO RELATORIOS
				System.out.println("1 - Consultar Venda ");
				System.out.println("2 - Relatório de Vendas ");
				break;
			case 6: // FINALIZAR PROGRAMA
				break;
			default:
				System.out.println("Insira uma opção valida! ");
				break;
			}

		}

	}
}
