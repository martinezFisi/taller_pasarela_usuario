package pe.edu.sistemas.microservices.services.accounts;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import pe.edu.sistemas.microservices.accounts.AccountRepository;
import pe.edu.sistemas.microservices.accounts.AccountsConfiguration;

/**
 * Ejecutar  un micro-servicio, registrándose con el Discovery Server (Eureka).
 * 
 *Tenga en cuenta que la configuración de esta aplicación se importa desde
 * {@link AccountsConfiguration}. This is a deliberate separation of concerns.
 * 
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountsServer {

	@Autowired
	protected AccountRepository accountRepository;

	protected Logger logger = Logger.getLogger(AccountsServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
	
		System.setProperty("spring.config.name", "accounts-server");

		SpringApplication.run(AccountsServer.class, args);
	}
}
