package pe.edu.sistemas.microservices.accounts;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase define al modelo USUARIO de la base 
 * de datos con la cual se esta trabajando
 * 
 * */
@Entity
@Table(name = "USUARIO")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	protected Long id;
	
	@Column(name = "code")
	protected String number;

	@Column(name = "name")
	protected String owner;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "eap")
	protected String eap;


	protected static Long getNextId() {
		synchronized (nextId) {
			return nextId++;
		}
	}

	
	protected Account() {
	}

	public Account(String number, String owner) {
		id = getNextId();
		this.number = number;
		this.owner = owner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
