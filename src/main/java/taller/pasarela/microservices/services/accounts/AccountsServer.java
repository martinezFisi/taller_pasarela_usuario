package taller.pasarela.microservices.services.accounts;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import taller.pasarela.microservices.users.AccountRepository;
import taller.pasarela.microservices.users.AccountsConfiguration;


@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(AccountsConfiguration.class)
public class AccountsServer {

	@Autowired
	protected AccountRepository accountRepository;

	protected Logger logger = Logger.getLogger(AccountsServer.class.getName());


	public static void main(String[] args) {

		System.setProperty("spring.config.name", "accounts-server");

		SpringApplication.run(AccountsServer.class, args);
	}
}
