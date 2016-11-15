package taller.pasarela.microservices.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import taller.pasarela.microservices.payment.paymentRepository;


@RestController
public class paymentController {
	
	protected paymentRepository  PaymentRepository;
	
	@Autowired
	public paymentController(paymentRepository paymentRepository) {
		this.PaymentRepository = paymentRepository;
	}
	
	}

