package pe.edu.sistemas.microservices.services.web;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Este es modelo Account para la tabla usuario, la cual se comunica 
 * con la Webserver y los microservicios.
 * 
 */


@JsonRootName("Account")
public class Account {

	protected Long id;
	protected String number;
	protected String owner;
	protected String email;
	protected String eap;

	/**
	 * Default constructor for JPA only.
	 */
	protected Account() {
	}

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}
	
	



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return number + " [" + owner + "]: $";
	}

	public String getEap() {
		return eap;
	}

	public void setEap(String eap) {
		this.eap = eap;
	}

	
}
