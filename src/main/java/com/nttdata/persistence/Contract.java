package com.nttdata.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
/**
 * Clase contrato
 * 
 * @author Victor Carrasco
 *
 */
@Entity
@Table(name="T_CONTRACT")
public class Contract extends AbstractEntity{
	
	///////////////
	// VARIABLES //
	///////////////
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Long idContrato;

	/** Fecha de Vigencia */
	private Date effectiveDate;
	
	/** Fecha de caducidad */
	private Date expirityDate;
	
	/** Precio mensual */
	private Integer price;
	
	/** Cliente al que pertenece el contrato */
	private Client client;

	/////////////////////////
	// GETTERS AND SETTERS //
	/////////////////////////
	
	/**
	 * @return the idContrato
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqContractID")
	@SequenceGenerator(name = "seqContractID", sequenceName = "SEQ_T_CONTRACT")
	public Long getIdContrato() {
		return idContrato;
	}

	/**
	 * @param idContrato the idContrato to set
	 */
	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @return the effectiveDate
	 */
	@Column(name = "C_CONTRACT_EFFECTIVE_DATE")
	@Temporal(TemporalType.DATE)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the expirityDate
	 */
	@Column(name="C_CONTRACT_EXPIRITY_DATE")
	@Temporal(TemporalType.DATE)
	public Date getExpirityDate() {
		return expirityDate;
	}

	/**
	 * @param expirityDate the expirityDate to set
	 */
	public void setExpirityDate(Date expirityDate) {
		this.expirityDate = expirityDate;
	}

	/**
	 * @return the price
	 */
	@Column(name="C_CONTRACT_PRICE")
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the client
	 */
	@ManyToOne
	@JoinColumn(name="C_CLIENT_ID_FK")
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	@Transient
	public Long getId() {
		return this.getIdContrato();
	}
	
}
