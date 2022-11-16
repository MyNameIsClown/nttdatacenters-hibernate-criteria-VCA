package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.dao.ClientDaoI;
import com.nttdata.persistence.dao.ClientDaoImpl;

/**
 * Implementacion del servicio de gestion de clientes
 * 
 * @author Victor Carrasco
 *
 */
public class ClientManagmentServiceImpl implements ClientManagmentServiceI {

	/** Client Dao */
	private ClientDaoI clientDao;

	/** LOGGER */
	public static final Logger LOG = LoggerFactory.getLogger(ClientManagmentServiceImpl.class);

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ClientManagmentServiceImpl(Session session) {
		clientDao = new ClientDaoImpl(session);
	}

	@Override
	public void insertClient(Client newClient) {

		if (newClient != null && newClient.getId() == null) {
			LOG.debug("Cliente verificado, insertando...");
			clientDao.insert(newClient);
		} else {
			LOG.debug("Cliente no verificado, cancelando insert...");
		}

	}

	@Override
	public void updateClient(Client newClient) {
		if (newClient != null && newClient.getId() != null) {
			LOG.debug("Cliente verificado, actualizando...");
			clientDao.update(newClient);
		} else {
			LOG.debug("Cliente no verificado, cancelando update...");
		}

	}

	@Override
	public void deleteClient(Client newClient) {
		if (newClient != null && newClient.getId() != null) {
			LOG.debug("Cliente verificado, actualizando...");
			clientDao.delete(newClient);
		} else {
			LOG.debug("Cliente no verificado, cancelando delete...");
		}

	}

	@Override
	public Client listClientById(Integer id) {
		Client nextClient = new Client();

		if (id != null) {
			LOG.debug("Listando por ID");
			nextClient = clientDao.listById(id);
		}

		return nextClient;
	}

	@Override
	public List<Client> listAll() {

		return clientDao.listAll();
	}

	@Override
	public List<Client> listByFullName(String name, String surname, String secondsurname) {
		List<Client> clientes = new ArrayList<>();
		if(name!=null && surname!=null && secondsurname!=null) {
			LOG.debug("Listando los clientes por su nombre completo");
			clientes = clientDao.listByFullName(name, surname, secondsurname);
		}
		return clientes;
	}
	
	

}
