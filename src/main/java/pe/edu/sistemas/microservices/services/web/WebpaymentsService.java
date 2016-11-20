package pe.edu.sistemas.microservices.services.web;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import pe.edu.sistemas.microservices.exceptions.AccountNotFoundException;

/**
 * Ocultar el acceso al microservicio dentro de este servicio local.
 * 
 */
@Service
public class WebpaymentsService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;
	
	protected Logger logger = Logger.getLogger(WebpaymentsService.class
			.getName());
	
	public WebpaymentsService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public List<payment> getpayments() {
		
		payment[] payments = null;

		try {
			payments = restTemplate.getForObject(serviceUrl
					+ "/payments/", payment[].class);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		if (payments == null || payments.length == 0)
			return null;
		else
			return Arrays.asList(payments);
	}
	
	@PostConstruct
	public void demoOnly() {
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}


}
