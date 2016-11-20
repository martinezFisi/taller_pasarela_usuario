package pe.edu.sistemas.microservices.services.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import pe.edu.sistemas.microservices.payment.paymentCOnfiguration;
import pe.edu.sistemas.microservices.payment.paymentRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(paymentCOnfiguration.class)
/** 
 * Este es el servidor de los payments los cuales 
 * reunen a todos los micro-servicios
 * */
public class paymentsServer {
	
	@Autowired
	protected paymentRepository paymentRepository;

	
	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "payments-server");

		SpringApplication.run(paymentsServer.class, args);
	}
	
}
