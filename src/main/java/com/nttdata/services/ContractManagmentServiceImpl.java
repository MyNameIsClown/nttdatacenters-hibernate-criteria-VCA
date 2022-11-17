package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.Contract;
import com.nttdata.persistence.dao.ContractDaoI;
import com.nttdata.persistence.dao.ContractDaoImpl;

public class ContractManagmentServiceImpl implements ContractManagmentServiceI {
	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(ContractManagmentServiceImpl.class);

	/** Contract Dao */
	ContractDaoI contractDao;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ContractManagmentServiceImpl(Session session) {
		contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertContract(Contract c) {
		if (c != null && c.getId() == null) {
			LOG.debug("Contrato valido, insertando...");
			contractDao.insert(c);
		} else {
			LOG.debug("Contrato invalido, cancelando insercion...");
		}

	}

	@Override
	public void updateContract(Contract c) {
		if (c != null && c.getId() != null) {
			LOG.debug("Contrato valido, actualizando...");
			contractDao.update(c);
		} else {
			LOG.debug("Contrato invalido, cancelando actualizacion...");
		}

	}

	@Override
	public void deleteContract(Contract c) {
		if (c != null && c.getId() != null) {
			LOG.debug("Contrato valido, eliminando...");
			contractDao.delete(c);
		} else {
			LOG.debug("Contrato invalido, cancelando borrado...");
		}

	}

	@Override
	public List<Contract> listAll() {
		return contractDao.listAll();
	}

}
