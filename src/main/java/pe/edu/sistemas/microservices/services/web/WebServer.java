package pe.edu.sistemas.microservices.services.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) 
public class WebServer {
	
	/**
	 * Dirección URL utiliza el nombre lógico de 
	 * account-service: mayúsculas o minúsculas,
	 */
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";
	public static final String PAYMENTS_SERVICE_URL = "http://PAYMENTS-SERVICE";
	/**
	 * 
	 * Ejecute la aplicación mediante Spring Boot y un
	 *  motor de servlet incorporado.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	/**
	 * 
	 * Un RestTemplate personalizado que tiene incorporado 
	 * el equilibrador de carga de la cinta.
	 * 
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * El AccountService encapsula la interacción con el micro-servicio.
	 * 
	 * @return Una nueva instancia de servicio.
	 */
	@Bean
	public WebAccountsService accountsService() {
		return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	}
	
	@Bean
	public WebpaymentsService paymentsService() {
		return new WebpaymentsService(PAYMENTS_SERVICE_URL);
	}
	

	/**
	 * 
	 * Cree el controlador, pasándole el  {@link WebAccountsService} para usar.
	 * 
	 * @return
	 */
	@Bean
	public WebAccountsController accountsController() {
		return new WebAccountsController(accountsService());
	}
	
	@Bean
	public WebpaymentsController paymentsController() {
		return new WebpaymentsController(paymentsService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
