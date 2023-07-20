package model.entities;

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
	private String observacao;
	private Double valor_os;
	Scanner teclado = new Scanner(System.in);
	
	private List<Servico> servico = new ArrayList<>(); // 'OS' contem varios itens 
	
	// revisar a classe
	
	public OrdemServico() {		
	}

	public OrdemServico(Cliente id_cliente, String observacao, List<Servico> servicos, Double valor_os) {
		this.id_cliente = id_cliente;
		this.observacao = observacao;
		this.servico = servicos;
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
	
	public List<Servico> getServico() {
		return servico;
	}

	@Override
	public String toString() {
		return "OrdemServico [id_ordem="
				+ id_ordem 
				+ ", id_cliente=" 
				+ id_cliente 
				+ ", observacao=" 
				+ observacao 
				+ ", valor_os=" 
				+ valor_os +
				"]";
	}
	
	
}
