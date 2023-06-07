package entities;

import java.util.Scanner;

import dao.CrudDAO;

public class Servico implements CrudDAO<Servico> {
	
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

	@Override
	public Servico read(Servico id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servico update(Servico id) {
		
		return null;
	}

	@Override
	public Servico delete(Servico id) {
		
		return null;
	}

}
