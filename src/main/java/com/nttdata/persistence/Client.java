package com.nttdata.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Objeto cliente que hace referencia a un tabla T_CLIENT
 * 
 * @author Victor Carrasco
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client implements Serializable {

	///////////////
	// VARIABLES //
	///////////////

	/** Serial version UID */
	private static final long serialVersionUID = 1L;

	/** Id */
	private Integer id;

	/** Name */
	private String name;

	/** Surname */
	private String surname;

	/** Second Surname */
	private String secondSurname;

	/** Dni */
	private String dni;

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////

	/**
	 * @return the id
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */

	@Column(name = "SURNAME")
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the secondSurname
	 */

	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the dni
	 */

	@Column(name = "DNI", length = 9, unique = true, nullable = false)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Client \n\t[id=" + id + ",\n\t name=" + name + ",\n\t surname=" + surname + ",\n\t secondSurname=" + secondSurname
				+ ",\n\t dni=" + dni + "]\n";
	}
	
	

}
