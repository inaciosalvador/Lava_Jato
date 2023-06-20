package entities;

import java.util.Scanner;

public class Cliente {

	Scanner teclado = new Scanner(System.in);

	private Integer id_cliente;
	private String nome;
	private String telefone;
	private String cpf_cnpj;

	public Cliente() {
	}

	public Cliente(String nome, String telefone, String cpf_cnpj) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf_cnpj = cpf_cnpj;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome=" + nome + ", telefone=" + telefone + ", cpf_cnpj="
				+ cpf_cnpj + "]";
	}

	public Cliente create() {

		System.out.println("=== Cadastro de Cliente ===");

		System.out.println("Insira o nome do cliente: ");
		nome = teclado.nextLine();

		System.out.println("Insira o numero de telefone: (DDD + numero) sem espaços. ");
		telefone = teclado.nextLine();

		System.out.println("Insira o CPF ou CNPJ: ");
		cpf_cnpj = teclado.nextLine();

		Cliente novoCliente = new Cliente(nome, telefone, cpf_cnpj);
		return novoCliente;

	}

	public Cliente update(Cliente cliente) {

		int escolha;
		int resposta = 1;
				
		while(resposta == 1) {
			System.out.println("Quais dados deseja alterar? ");
			System.out.println("1 - nome");
			System.out.println("2 - telefone");
			System.out.println("3 - CPF/CNPJ");
			System.out.println(" ");
			System.out.println("Escolha uma opção");
			
			escolha = teclado.nextInt();
			teclado.nextLine();
			
			switch (escolha) {
			case 1: 				
				System.out.println("Informe o novo NOME: ");
				String nome = teclado.nextLine();
				cliente.setNome(nome);
				break;
			case 2:				
				System.out.println("Informe o novo telefone: ");
				String telefone = teclado.next();
				cliente.setTelefone(telefone);
				break;
			case 3:
				System.out.println("Informe o novo CPF/CNPJ: ");
				String doc = teclado.next();
				cliente.setCpf_cnpj(doc);
				break;
			default:
				System.out.println("Escolha uma opção valida");
			}
			
			System.out.println("Deseja alterar mais algum dado? ");
			System.out.println("1 - sim ");
			System.out.println("2 - Não ");
			resposta = teclado.nextInt();
			teclado.nextLine();
			
		}
		
		return cliente;

	}

}
