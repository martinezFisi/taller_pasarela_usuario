package taller.pasarela.microservices.services.web;


import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("Account")
public class Account {

	protected Long id;
	protected String number;
	protected String owner;

	protected Account() {

	}

	public long getId() {
		return id;
	}


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

}
