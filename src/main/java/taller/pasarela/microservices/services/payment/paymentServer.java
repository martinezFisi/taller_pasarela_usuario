package taller.pasarela.microservices.services.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import taller.pasarela.microservices.payment.paymentRepository;
import taller.pasarela.microservices.payment.paymentCOnfiguration;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(paymentCOnfiguration.class)

public class paymentServer {
	
	@Autowired
	protected paymentRepository paymentRepository;

	
	public static void main(String[] args) {
		
		System.setProperty("spring.config.name", "payment-server");

		SpringApplication.run(paymentServer.class, args);
	}
	
}
