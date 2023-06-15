package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
	
	Scanner teclado = new Scanner(System.in);
	
	private Integer id_cliente;
	private String nome;
	private String telefone;
	private String cpf_cnpj;
	
	private List<Veiculo> veiculo = new ArrayList<>();
	
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
		return "Cliente [id_cliente="
				+ id_cliente
				+ ", nome="
				+ nome
				+ ", telefone="
				+ telefone
				+ ", cpf_cnpj="
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
	
	// metodo envia o cpf ou cnpj para outras classes,
	// até o momento está sendo usado para cadastrar um novo veiculo ao cliente
	public String readByDoc() {
		
		System.out.println("Insira o CPF ou CNPJ do cliente (SEM PONTOS E TRAÇOS): ");
		String docCliente = teclado.nextLine();
		
		return docCliente;		
	}

}
