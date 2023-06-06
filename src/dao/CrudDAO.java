package dao;

import entities.Servico;

public interface CrudDAO<t> {
	
	t create();
	t read(t id);
	t update(t id);
	t delete(t id);

}
