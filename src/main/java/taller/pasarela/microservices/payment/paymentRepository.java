package taller.pasarela.microservices.payment;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface paymentRepository extends Repository<payment, Long>  {
	
	
Iterable<payment> findAll();
	
}
