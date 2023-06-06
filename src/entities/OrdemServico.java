package entities;

import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
	
	private Integer id_ordem;
	private Cliente id_cliente;
	private String observacao;
	
	private List<Pedido> item = new ArrayList<>(); // 'OS' contem varios itens 
	
	public OrdemServico() {		
	}

	public OrdemServico(Cliente id_cliente, String observacao) {
		this.observacao = observacao;
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
	
}
