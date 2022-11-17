package com.nttdata.persistence.dao;

import org.hibernate.Session;

import com.nttdata.persistence.Contract;

/**
 * Implementacion del dao de contratos
 * 
 * @author Victor Carrasco
 *
 */
public class ContractDaoImpl extends GenericDaoImpl<Contract> implements ContractDaoI{
	/** Session */
	Session sessionContract;
	
	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.sessionContract = session;
	}

}
