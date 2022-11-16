package com.nttdata.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Implementacion de la interfaz GenericDaoI 
 * @author Victor Carrasco
 *
 * @param <T>
 */
public class GenericDaoImpl<T> implements GenericDaoI<T> {
	/** Session */
	private Session session;

	/** Clase */
	private Class<T> elementClassType;

	/**
	 * Public Constructor
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(Session session) {
		this.session = session;
		elementClassType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T c) {
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercion
		session.save(c);
		session.flush();

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void update(T c) {
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualizacion
		session.saveOrUpdate(c);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void delete(T c) {
		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualizacion
		session.delete(c);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public T listById(int id) {

		// Verificacion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Hacer consulta
		return session.get(elementClassType, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		return session.createQuery("FROM " + this.elementClassType.getName()).list();
	}
}
