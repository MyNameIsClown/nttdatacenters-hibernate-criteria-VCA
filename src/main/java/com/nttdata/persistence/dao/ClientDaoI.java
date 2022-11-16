package com.nttdata.persistence.dao;

import java.util.List;

import com.nttdata.persistence.Client;

/**
 * DAO de tabla T_CLIENT
 * 
 * @author Victor Carrasco
 *
 */
public interface ClientDaoI extends GenericDaoI<Client>{
	/**
	 * Lista los clientes por su nombre y apellidos
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return
	 */
	public List<Client> listByFullName (String name, String surname, String secondSurname);
}
