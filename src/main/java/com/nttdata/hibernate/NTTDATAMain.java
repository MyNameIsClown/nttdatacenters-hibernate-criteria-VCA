package com.nttdata.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Client;
import com.nttdata.services.ClientManagmentServiceI;
import com.nttdata.services.ClientManagmentServiceImpl;

/**
 * Clase principal
 * 
 * @author Victor Carrasco
 *
 */
public class NTTDATAMain {
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicializamos la sesion
		final Session mySession = NTTDataHibernateUtil.getSessionFactory().openSession();
		
		// Se da de alta los servicios
		final ClientManagmentServiceI clientService = new ClientManagmentServiceImpl(mySession);
		
		// Creacion de los clientes
		Client cliente1 = new Client();
		cliente1.setName("Juan");
		cliente1.setSurname("Lopez");
		cliente1.setSecondSurname("Lopez");
		cliente1.setDni("12345678V");
		
		Client cliente2 = new Client();
		cliente2.setName("Mario");
		cliente2.setSurname("Ballano");
		cliente2.setSecondSurname("Velazquez");
		cliente2.setDni("81763433F");
		
		Client cliente3 = new Client();
		cliente3.setName("Lola");
		cliente3.setSurname("Marquez");
		cliente3.setSecondSurname("del Rosario");
		cliente3.setDni("11134985G");
		
		clientService.insertClient(cliente1);
		clientService.insertClient(cliente2);
		clientService.insertClient(cliente3);
		
		List<Client> clientesRegistrados = clientService.listAll();
		
		System.out.println(clientesRegistrados);
		
		System.out.println(clientService.listByFullName("Juan", "Lopez", "Lopez"));
		
		
		
	}
}
