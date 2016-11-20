package pe.edu.sistemas.microservices.services.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Aqui se reune
 * Todo lo que necesita para ejecutar un servidor de registro Eureka.
 * 
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

	/**
	 * Este es el que ejecuta el motor de Spring Boot 
	 * con el servlet incorporado
	 * @param args Program arguments - ignored.
	 *            
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "registration-server");

		SpringApplication.run(RegistrationServer.class, args);
	}
}
