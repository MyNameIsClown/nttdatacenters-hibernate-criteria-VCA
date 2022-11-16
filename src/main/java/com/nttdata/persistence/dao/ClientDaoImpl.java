package com.nttdata.persistence.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.persistence.Client;

/**
 * Implementacion del dao de cliente
 * 
 * @author Victor Carrasco
 *
 */
public class ClientDaoImpl extends GenericDaoImpl<Client> implements ClientDaoI {
	/** Sesion de conexion con la BBDD */
	Session sessionC;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.sessionC = session;
	}

	@Override
	public List<Client> listByFullName(String name, String surname, String secondSurname) {
		// Verificacion de sesion abierta
		if (!sessionC.getTransaction().isActive()) {
			sessionC.getTransaction().begin();
		}
		// Criteria Builder
		final CriteriaBuilder cb = sessionC.getCriteriaBuilder();
		final CriteriaQuery<Client> cQuery = cb.createQuery(Client.class);
		final Root<Client> rootC = cQuery.from(Client.class);
		
		
		// Condición
		final Predicate pr1 = cb.equal(rootC.get("name"), name);
		final Predicate pr2 = cb.equal(rootC.get("surname"), surname);
		final Predicate pr3 = cb.equal(rootC.get("secondSurname"), secondSurname);
		
		// Consulta
		cQuery.select(rootC).where(cb.and(pr1, pr2, pr3));
		
		// Ejecucion de la consulta
		return sessionC.createQuery(cQuery).getResultList();
	}

}
