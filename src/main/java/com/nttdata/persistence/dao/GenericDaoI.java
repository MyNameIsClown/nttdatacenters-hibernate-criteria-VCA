package com.nttdata.persistence.dao;

import java.util.List;

/**
 * Dao generico
 * 
 * @author Victor Carrasco
 *
 * @param <T>
 */
public interface GenericDaoI<T> {
	/**
	 * Inserta un registro en BBDD
	 * 
	 * @param c
	 */
	public void insert(T element);
	
	/**
	 * Actualiza un resgistro en BBDD
	 * 
	 * @param c
	 */
	public void update(T element);
	
	/**
	 * Elimina un registro en BBDD
	 * 
	 * @param c
	 */
	public void delete(T element);
	
	/**
	 * Lista un elemento por el id
	 * 
	 * @param id
	 * @return
	 */
	public T listById(int id);
	
	/**
	 * Lista todos los elementos
	 * 
	 * @return
	 */
	public List<T> listAll();
}
