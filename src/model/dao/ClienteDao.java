package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {
	
	public void inserir(Cliente obj);
	public void atualizar(Cliente obj);
	public void deletarPorId(Integer id);
	public Cliente pesquisaId(Integer id);
	List<Cliente> buscarTodos();

}
