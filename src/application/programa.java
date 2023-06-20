package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import entities.Cliente;
import entities.Veiculo;

public class programa {

	public static void main(String[] args) throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		
					// cadastrar cliente
		/*
		Cliente c = new Cliente();
		Veiculo v = new Veiculo();
		ClienteDAO cdao = new ClienteDAO();
		
		c.create();
		v.createVeiculo();
		cdao.create(c, v);
		*/
		
		
		//-------------------------------------------------------
		
					// Listar todos os clientes
		
		/*
		ClienteDAO cdao = new ClienteDAO();
		cdao.read();
		*/
		
		//-------------------------------------------------------
		
						// editar clientes
		/*
		Cliente cliente = new Cliente(); // está recebendo o cliente do banco 
		ClienteDAO c = new ClienteDAO(); // usado para operar no banco
		Cliente cliente1 = new Cliente(); // usado para atualizar o objeto na classe 
				
		System.out.println("Informe o Nº de documento: ");
		String doc = teclado.nextLine();
		
		cliente = c.findByID(doc); 
		cliente1 = cliente.update(cliente); // contem o objeto alterado
		c.update(cliente1);
		*/
		
		//-------------------------------------------------------
		
					// deletar clientes
		
		 /*
		Cliente c = new Cliente();
		ClienteDAO cdao = new ClienteDAO();
		
		System.out.println("Informe o Nº de documento: ");
		String doc = teclado.nextLine();
		
		c = cdao.findByID(doc); // guarda o cliente que será apagado
		cdao.delete(c);
		*/
		
		
		
	}
}
