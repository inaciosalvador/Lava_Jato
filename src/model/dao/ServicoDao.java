package model.dao;

import java.util.List;

import model.entities.Servico;

public interface ServicoDao {
	
	public void inserir(Servico obj);
	public void atualizar(Servico obj);
	public void deletarPorId(Integer id);
	public Servico pesquisaId(Integer id);
	List<Servico> buscarTodos();

}
