package com.nttdata.persistence.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.Contract;

/**
 * Implementacion del dao de contratos
 * 
 * @author Victor Carrasco
 *
 */
public class ContractDaoImpl extends GenericDaoImpl<Contract> implements ContractDaoI {
	/** Session */
	Session sessionContract;

	/** Logger */
	public static final Logger LOG = LoggerFactory.getLogger(ContractDaoImpl.class);

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.sessionContract = session;
	}

	@Override
	public List<Contract> listByPrice(Integer price) {
		// Verificacion de sesion abierta
		if (!sessionContract.getTransaction().isActive()) {
			LOG.info("Transaccion innactiva, inicializando...");
			sessionContract.getTransaction().begin();
		}
		// Criteria Builder
		final CriteriaBuilder cb = sessionContract.getCriteriaBuilder();
		final CriteriaQuery<Contract> cQuery = cb.createQuery(Contract.class);
		final Root<Contract> rootC = cQuery.from(Contract.class);

		// Condición
		final Predicate pr1 = cb.equal(rootC.get("price"), price);

		// Consulta
		LOG.info("Creando la consulta para los siguientes parametros de entrada {" + price + "}");
		cQuery.select(rootC).where(pr1);

		// Ejecucion de la consulta
		return sessionContract.createQuery(cQuery).getResultList();
	}

}
