package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contract;

/**
 * Servicio de la clase Contract
 * 
 * @author Victor Carrasco
 *
 */
public interface ContractManagmentServiceI {
	/**
	 * Inserta un contrato en BBDD
	 * 
	 * @param c
	 */
	public void insertContract(Contract c);
	
	/**
	 * Actualiza un contrato en BBDD
	 * 
	 * @param c
	 */
	public void updateContract(Contract c);
	
	/**
	 * Elimina un contrato en BBDD
	 * 
	 * @param c
	 */
	public void deleteContract(Contract c);
	
	/**
	 * Lista todos los contratos de la BBDD
	 * 
	 * @return
	 */
	public List<Contract> listAll();
	
	/**
	 * Lista los contratos por el precio
	 * 
	 * @param price
	 * @return
	 */
	public List<Contract> listByPrice(Integer price);
}
