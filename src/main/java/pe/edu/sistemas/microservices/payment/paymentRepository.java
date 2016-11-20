package pe.edu.sistemas.microservices.payment;

import java.util.List;

import org.springframework.data.repository.Repository;

import pe.edu.sistemas.microservices.accounts.Account;


public interface paymentRepository extends Repository<payment, Long>  {
	
public payment findByconcepto(String paymentId);
	
	
Iterable<payment> findAll();


public List<Account> findByconceptoContainingIgnoreCase(String concepto);

}
