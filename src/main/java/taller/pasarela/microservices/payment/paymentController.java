package taller.pasarela.microservices.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taller.pasarela.microservices.accounts.Account;
import taller.pasarela.microservices.exceptions.AccountNotFoundException;
import taller.pasarela.microservices.exceptions.paymentNotFoundException;
import taller.pasarela.microservices.payment.paymentRepository;

/**
 * Un controlador RESTFul para acceder a la información de la CONCEPTO.
 */
@RestController
public class paymentController {
	
	protected paymentRepository  PaymentRepository;
	
	@Autowired
	public paymentController(paymentRepository paymentRepository) {
		this.PaymentRepository = paymentRepository;
	}
	
	@RequestMapping("/payments/")
	public List<payment> getpayments() {
				List<payment> payments = (List<payment>) PaymentRepository.findAll();
			return payments;
	}
	
	/**
	 *	Cree una instancia que conecte el repositorios que vamos a usar.
	 * @param concepto Implementación de un repositorio de cuentas.        
	 */
	@RequestMapping("/payments/{concepto}")
	public payment byConcepto(@PathVariable("concepto") String concepto) {

		payment payment = PaymentRepository.findByconcepto(concepto);

		if (payment == null)
			throw new paymentNotFoundException(concepto);
		else {
			return payment;
		}
	}
	}

