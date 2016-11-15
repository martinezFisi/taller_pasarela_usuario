package taller.pasarela.microservices.payment;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CONCEPTO")
public class payment implements Serializable{
	
	
public static Long nextId = 0L;

@Id
protected Long id_p;
		
	
@Column(name = "id_concepto")
protected String concepto;	

@Column(name = "monto")
protected String monto;

protected static Long getNextId() {
	synchronized (nextId) {
		return nextId++;
	}
}

public payment(String concepto, String monto) {
	id_p = getNextId();
	this.concepto = concepto;
	this.monto = monto;
}

protected payment() {
}


public String getconcepto() {
	return concepto;
}

public void setconcepto(String concepto) {
	this.concepto = concepto;
}

public String getMonto() {
	return monto;
}

public void setMonto(String monto) {
	this.monto = monto;
}



}
