package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import entities.Cliente;

public class programa {

	public static void main(String[] args) throws SQLException {
		
		Scanner teclado = new Scanner(System.in);
		
		/*Cliente cliente = new Cliente(); // está recebendo o cliente do banco 
		ClienteDAO c = new ClienteDAO(); // usado para operar no banco
		Cliente cliente1 = new Cliente(); // usado para atualizar o objeto na classe 
				
		System.out.println("Informe o Nº de documento: ");
		String doc = teclado.nextLine();
		
		cliente = c.findByID(doc); 
		cliente1 = cliente.update(cliente); // contem o objeto alterado
		c.update(cliente1);*/
		
		//-------------------------------------------------------
		
		Cliente c = new Cliente();
		ClienteDAO cdao = new ClienteDAO();
		
		System.out.println("Informe o Nº de documento: ");
		String doc = teclado.nextLine();
		
		c = cdao.findByID(doc); // guarda o cliente que será apagado
		System.out.println(c);
		cdao.delete(c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//c1.update(cliente1);
		
		
		
		
		
		
		
		
		
		
		
	}
}
