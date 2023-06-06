package entities;

import java.util.Date;

public class Pedido {
	
	private Date data_servico;
	private OrdemServico id_ordem;
	private Servico id_servico;
	private Integer quantidade;
	private Double preco_venda;
	
	public Pedido() {
	}

	public Pedido(OrdemServico id_ordem, Servico id_servico, Date data_servico, Integer quantidade) {
		this.data_servico = data_servico;
		this.quantidade = quantidade;
	}

	public Date getData_servico() {
		return data_servico;
	}

	public void setData_servico(Date data_servico) {
		this.data_servico = data_servico;
	}

	public OrdemServico getId_ordem() {
		return id_ordem;
	}

	public void setId_ordem(OrdemServico id_ordem) {
		this.id_ordem = id_ordem;
	}

	public Servico getId_servico() {
		return id_servico;
	}

	public void setId_servico(Servico id_servico) {
		this.id_servico = id_servico;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
	}

	@Override
	public String toString() {
		return "Pedido [data_servico="
				+ data_servico
				+ ", id_ordem="
				+ id_ordem
				+ ", id_servico="
				+ id_servico
				+ ", quantidade="
				+ quantidade
				+ ", Preco_venda="
				+ preco_venda
				+ "]";
	}

	public double subTotal() {
		return preco_venda * quantidade; 
	}

	
}
