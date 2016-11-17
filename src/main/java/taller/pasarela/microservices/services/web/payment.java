package taller.pasarela.microservices.services.web;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("payment")
public class payment {

	protected Long id_p;
	protected String concepto;	
	protected String monto;
	
	
	public payment() {
	}
	public Long getId_p() {
		return id_p;
	}
	public void setId_p(Long id_p) {
		this.id_p = id_p;
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
	
	

}
