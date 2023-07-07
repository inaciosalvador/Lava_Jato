package entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.ServicoDao;
import dao.VeiculoDao;

public class OrdemServico {
	
	private Integer id_ordem;
	private Cliente id_cliente;
	private Veiculo id_veiculo;
	private String observacao;
	private Double valor_os;
	Scanner teclado = new Scanner(System.in);
	
	private List<Pedido> item = new ArrayList<>(); // 'OS' contem varios itens 
	
	public OrdemServico() {		
	}

	public OrdemServico(Cliente id_cliente, Veiculo id_veiculo, String observacao,List<Servico> itens, Double valor_os) {
		this.id_cliente = id_cliente;
		this.id_veiculo = id_veiculo;
		this.observacao = observacao;
		this.valor_os = valor_os;
	}



	public Integer getId_ordem() {
		return id_ordem;
	}

	public void setId_ordem(Integer id_ordem) {
		this.id_ordem = id_ordem;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValor_os() {
		return valor_os;
	}

	public void setValor_os(Double valor_os) {
		this.valor_os = valor_os;
	}

	@Override
	public String toString() {
		return "OrdemServico [id_ordem="
				+ id_ordem
				+ ", id_cliente="
				+ id_cliente
				+ ", observacao="
				+ observacao
				+ "]";
	}
	
	public void addItem(Pedido item) {
		this.item.add(item); // Adicionar item a 'OS'
	}
	
	public void removeItem(Pedido item) {
		this.item.remove(item); // remover item da 'OS'
	}
	
	public OrdemServico gerarOrdem() throws SQLException {
		
		 Cliente cliente = new Cliente();
		 ClienteDAO c1 = new ClienteDAO();
		 Veiculo veiculo = new Veiculo();
		 VeiculoDao v1 = new VeiculoDao();
		 Servico ServicoEscolhido = new Servico();
		 List<Servico> servico = new ArrayList(); // contem todos os serviços escolhidos
		 ServicoDao s1 = new ServicoDao();
		 
		 
		 System.out.println("Informe o Nº de documento: ");
		 String doc = teclado.nextLine();
		 
		 System.out.println("Informe agora a placa do veiculo: ");
		 String placa = teclado.nextLine();

		 cliente = c1.findByDoc(doc);
		 System.out.println("Cliente escolhido" + cliente.getNome());
		 veiculo = v1.findByPlaca(placa);
		 System.out.println("placa do carro: " + veiculo.getPlaca());
		
		 int escolha = 1;
		 
		 while(escolha == 1) {
			 System.out.println("Insira o codigo do serviço: ");
			 int serv = teclado.nextInt();
			 ServicoEscolhido = s1.findById(serv);
			 System.out.println("Serviço escolhido: " + ServicoEscolhido.getDescricao());
			 servico.add(ServicoEscolhido);
			 
			 System.out.println("Deseja inserir outro serviço? ");
			 System.out.println("1 - sim");
			 System.out.println("2 - não");
			 
			 escolha = teclado.nextInt();
			 
		 }
		 
		 teclado.next();
		 
		 System.out.println("Observação: ");
		 String observaca = teclado.nextLine();
		 
		 
		 OrdemServico os = new OrdemServico(cliente, veiculo, observaca, servico, servico.get(0).getPreco());
		 
		  return os; // pensar numa solução
		 
	}
}
