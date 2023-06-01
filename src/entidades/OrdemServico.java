package entidades;

public class OrdemServico {
	
	private Integer id_ordem;
	private Cliente id_cliente;
	private String observacao;
	
	public OrdemServico() {		
	}

	public OrdemServico(Integer id_ordem, Cliente id_cliente, String observacao) {
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
	
	
	
	
	
	

}
