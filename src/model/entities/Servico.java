package model.entities;

import java.util.List;
import java.util.Scanner;


public class Servico{
	
	Scanner teclado = new Scanner(System.in);

	private Integer id_servico;
	private String descricao;
	private Double preco;

	public Servico() {
	}

	public Servico(String descricao, Double preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getId_servico() {
		return id_servico;
	}

	public void setId_servico(Integer id_servico) {
		this.id_servico = id_servico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Servico [id_servico=" + id_servico + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

	public Servico create() {
		
		System.out.println("===== Cadastro de Serviços =====");

		System.out.println("Digite o nome do serviço: ");
		descricao = teclado.nextLine();
		
		System.out.println("Informe o preço unitario: ");
		preco = teclado.nextDouble();
		
		Servico novoServico = new Servico(descricao, preco);
		return novoServico;

	}
	
	public Servico update(Servico servico) {
		
		int escolha;
		int resposta = 1;
		
		while(resposta == 1) {
			System.out.println("Quais dados deseja alterar? ");
			System.out.println("1 - descrição");
			System.out.println("2 - preço");
			System.out.println(" ");
			System.out.println("Escolha uma opção");
			
			escolha = teclado.nextInt();
			teclado.nextLine();
			
			switch (escolha) {

			case 1:
				System.out.println("Informe a nova descrição: ");
				String descricao = teclado.nextLine();
				servico.setDescricao(descricao);
				break;
			case 2:
				System.out.println("Informe o novo preço: (00,00) ");
				double preco = teclado.nextDouble();
				servico.setPreco(preco);
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
		
		return servico;
	}
	
	

}
