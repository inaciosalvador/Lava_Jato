package model.dao;

import java.util.List;

import model.entities.Veiculo;

public interface VeiculoDao {
	
	public void inserir(Veiculo obj);
	public void atualizar(Veiculo obj);
	public void deletarPorId(Integer id);
	public Veiculo pesquisaId(Integer id);
	List<Veiculo> buscarTodos();

}
