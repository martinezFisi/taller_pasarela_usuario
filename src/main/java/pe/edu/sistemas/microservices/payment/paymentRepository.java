package taller.pasarela.microservices.payment;

import java.util.List;

import org.springframework.data.repository.Repository;

import taller.pasarela.microservices.accounts.Account;


public interface paymentRepository extends Repository<payment, Long>  {
	
public payment findByconcepto(String paymentId);
	
	
Iterable<payment> findAll();


public List<Account> findByconceptoContainingIgnoreCase(String concepto);

}
