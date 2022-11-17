package com.nttdata.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Objeto cliente que hace referencia a un tabla T_CLIENT
 * 
 * @author Victor Carrasco
 *
 */
@Entity
@Table(name = "T_CLIENT")
public class Client extends AbstractEntity{

	///////////////
	// VARIABLES //
	///////////////

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long idClient;

	/** Name */
	private String name;

	/** Surname */
	private String surname;

	/** Second Surname */
	private String secondSurname;

	/** Dni */
	private String dni;
	
	/** Contratos del cliente */
	private List<Contract> contracts;

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	/**
	 * @return the idClient
	 */
	@Id
	@Column(name="C_CLIENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClientID")
	@SequenceGenerator(name = "seqClientID", sequenceName = "SEQ_T_CLIENT")
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the name
	 */

	@Column(name = "C_CLIENT_NAME")
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

	@Column(name = "C_CLIENT_SURNAME")
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

	@Column(name = "C_CLIENT_SECOND_SURNAME")
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

	@Column(name = "C_CLIENT_DNI", length = 9, unique = true, nullable = false)
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
	 * @return the contracts
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	public List<Contract> getContracts() {
		return contracts;
	}

	/**
	 * @param contracts the contracts to set
	 */
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public String toString() {
		return "Client \n\t[id=" + idClient + ",\n\t name=" + name + ",\n\t surname=" + surname + ",\n\t secondSurname=" + secondSurname
				+ ",\n\t dni=" + dni + "]\n";
	}

	@Override
	@Transient
	public Long getId() {
		return this.getIdClient();
	}
	
	

}
