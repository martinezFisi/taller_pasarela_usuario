package taller.pasarela.microservices.accounts;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import taller.pasarela.microservices.users.AccountsConfiguration;


@SpringBootApplication
@Import(AccountsConfiguration.class)
class AccountsMain {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "accounts-server");
		SpringApplication.run(AccountsMain.class, args);
	}
}

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsMain.class)
public class AccountsControllerIntegrationTests extends AbstractAccountControllerTests {

}
