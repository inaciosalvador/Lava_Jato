package entidades;

public class Servico {
	
	private Integer id_servico;
	private String descricao;
	private Double preco;
	
	public Servico() {		
	}

	public Servico(Integer id_servico, String descricao, Double preco) {
		this.id_servico = id_servico;
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
		return "Servico [id_servico="
				+ id_servico
				+ ", descricao="
				+ descricao
				+ ", preco="
				+ preco
				+ "]";
	}
	

}
