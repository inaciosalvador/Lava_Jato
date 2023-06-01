package model.dao;

import db.DB;
import model.dao.impl.ClienteDaoJDBC;

public class DaoFactory {
	
	public static ClienteDao CadClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	} // Para Instanciar ClienteDao Cl = DaoFactory.CadClienteDao();
	
	/*public static ClienteDao CadVeiculoDao() {
		return new ClienteDaoJDBC();
	}
	
	public static ClienteDao CadServicoDao() {
		return new ClienteDaoJDBC();
	}*/
	
}
