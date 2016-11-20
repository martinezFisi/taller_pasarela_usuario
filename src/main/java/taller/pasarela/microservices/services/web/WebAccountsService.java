package taller.pasarela.microservices.services.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import taller.pasarela.microservices.exceptions.AccountNotFoundException;

/**
 * Ocultar el acceso al microservicio dentro de este servicio local.
 * 
 */
@Service
public class WebAccountsService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(WebAccountsService.class
			.getName());

	public WebAccountsService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	/**
	 * 
	 * El RestTemplate funciona porque utiliza una fábrica 
	 * de solicitud personalizada que utiliza
	 * Ribbon to look-up para buscar el servicio a utilizar.
	 * Este método simplemente existe para mostrar
	 * 
	 */
	@PostConstruct
	public void demoOnly() {
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}

	public Account findByNumber(String accountNumber) {

		logger.info("findByNumber() invoked: for " + accountNumber);
		return restTemplate.getForObject(serviceUrl + "/accounts/{number}",
				Account.class, accountNumber);
	}

	public List<Account> byOwnerContains(String name) {
		logger.info("byOwnerContains() invoked:  for " + name);
		Account[] accounts = null;

		try {
			accounts = restTemplate.getForObject(serviceUrl
					+ "/accounts/owner/{name}", Account[].class, name);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		if (accounts == null || accounts.length == 0)
			return null;
		else
			return Arrays.asList(accounts);
	}

	public Account getByNumber(String accountNumber) {
		Account account = restTemplate.getForObject(serviceUrl
				+ "/accounts/{number}", Account.class, accountNumber);

		if (account == null)
			throw new AccountNotFoundException(accountNumber);
		else
			return account;
	}
}
