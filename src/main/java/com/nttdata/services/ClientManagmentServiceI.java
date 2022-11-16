package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Client;
/**
 * Interfaz del servicio de cliente
 * 
 * @author Victor Carrasco
 *
 */
public interface ClientManagmentServiceI {
	
	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertClient(Client newClient);
	
	/**
	 * Actualiza un cliente
	 * 
	 * @param newClient
	 */
	public void updateClient(Client newClient);
	
	/**
	 * Elimina un cliente
	 * 
	 * @param newClient
	 */
	public void deleteClient(Client newClient);
	
	/**
	 * Lista un cliente por su id
	 * 
	 * @param id
	 * @return
	 */
	public Client listClientById(Integer id);
	
	/**
	 * Lista todos los clientes
	 * 
	 * @return
	 */
	public List<Client> listAll();
	
	/**
	 * Lista los clientes con el nombre completo
	 * @return
	 */
	public List<Client> listByFullName(String name, String surname, String secondsurname);
}
 