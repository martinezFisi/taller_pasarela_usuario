package pe.edu.sistemas.microservices.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase define al modelo CONCEPTO de la base 
 * de datos con la cual se esta trabanjo
 * 
 * */
@Entity
@Table(name = "CONCEPTO")
public class payment implements Serializable{
	
private static final long serialVersionUID = 1L;
	
public static Long nextId = 0L;

@Id
protected Long id_p;
		
	
@Column(name = "id_concepto")
protected String concepto;	

@Column(name = "descripcion")
protected String descripcion;

@Column(name = "monto")
protected String monto;

protected static Long getNextId() {
	synchronized (nextId) {
		return nextId++;
	}
}
public long getId_p() {
	return id_p;
}

/**
 * Set JPA id - for testing and JPA only. Not intended for normal use.
 * 
 * @param id
 *            The new id.
 */
protected void setId_p(long id_p) {
	this.id_p = id_p;
}
public payment(String concepto, String monto) {
	id_p = getNextId();
	this.concepto = concepto;
	this.monto = monto;
}

protected payment() {
}


public String getConcepto() {
	return concepto;
}

public void setConcepto(String concepto) {
	this.concepto = concepto;
}

public String getMonto() {
	return monto;
}

public void setMonto(String monto) {
	this.monto = monto;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

}