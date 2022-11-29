package com.nttdata.persistence.dao;

import java.util.List;

import com.nttdata.persistence.Contract;

/**
 * Dao de los contratos
 * 
 * @author Victor Carrasco
 *
 */
public interface ContractDaoI extends GenericDaoI<Contract>{
	/**
	 * Lista los contratos por el id
	 * @param price
	 * @return
	 */
	public List<Contract> listByPrice (Integer price);

}
