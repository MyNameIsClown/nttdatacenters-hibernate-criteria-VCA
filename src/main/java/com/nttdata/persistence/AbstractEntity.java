package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Entidad abstracta que es contiene campos de auditoria y id
 * 
 * @author Victor Carrasco
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Auditoria | Nombre de usuario */
	private String auditUsername;
	
	/** Auditoria | Fecha de cambios */
	private Date auditChangesDate;

	/**
	 * @return the id
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return the auditUsername
	 */
	@Column(name="C_AUDIT_USERNAME", nullable= false)
	public String getAuditUsername() {
		return auditUsername;
	}

	/**
	 * @param auditUsername the auditUsername to set
	 */
	public void setAuditUsername(String auditUsername) {
		this.auditUsername = auditUsername;
	}

	/**
	 * @return the auditChangesDate
	 */
	@Column(name="C_AUDIT_CHANGES_DATE", nullable = false)
	public Date getAuditChangesDate() {
		return auditChangesDate;
	}

	/**
	 * @param auditChangesDate the auditChangesDate to set
	 */
	public void setAuditChangesDate(Date auditChangesDate) {
		this.auditChangesDate = auditChangesDate;
	}
	
	/**
	 * Establece todos los parametros de auditoria
	 * 
	 * @param username
	 * @param changesDate
	 */
	public void setAudit(String username, Date changesDate) {
		this.setAuditUsername(username);
		this.setAuditChangesDate(changesDate);
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
