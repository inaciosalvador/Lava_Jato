package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
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
	
	
}