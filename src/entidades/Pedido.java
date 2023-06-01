package entidades;

import java.util.Date;

public class Pedido {
	
	private Date data_servico;
	private Servico id_servico;
	private OrdemServico id_ordem;
	private Integer quantidade;
	
	public Pedido() {
	}

	public Pedido(Date data_servico, Servico id_servico, OrdemServico id_ordem, Integer quantidade) {
		this.data_servico = data_servico;
		this.id_servico = id_servico;
		this.id_ordem = id_ordem;
		this.quantidade = quantidade;
	}

	public Date getData_servico() {
		return data_servico;
	}

	public void setData_servico(Date data_servico) {
		this.data_servico = data_servico;
	}

	public Servico getId_servico() {
		return id_servico;
	}

	public void setId_servico(Servico id_servico) {
		this.id_servico = id_servico;
	}

	public OrdemServico getId_ordem() {
		return id_ordem;
	}

	public void setId_ordem(OrdemServico id_ordem) {
		this.id_ordem = id_ordem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Pedido [data_servico="
				+ data_servico
				+ ", id_servico="
				+ id_servico
				+ ", id_ordem="
				+ id_ordem
				+ ", quantidade="
				+ quantidade
				+ "]";
	}
	
	
}
