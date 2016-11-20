package pe.edu.sistemas.microservices.accounts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.sistemas.microservices.exceptions.AccountNotFoundException;

/**
 * Un controlador RESTFul para acceder a la información de la USUARIO.
 */
@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class
			.getName());
	protected AccountRepository accountRepository;

	/**
	 *	Cree una instancia que conecte el repositorios que vamos a usar.
	 * @param accountRepository Implementación de un repositorio de cuentas.        
	 */
	@Autowired
	public AccountsController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;

		logger.info("AccountRepository says system has "
				+ accountRepository.countAccounts() + " accounts");
	}

	/**
	 * Este metodo extrae la data del usuario dependiendo del codigo
	 * @accountNumber: hace referencia a la codigo del alumno
	 * */
	@RequestMapping("/accounts/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);
		Account account = accountRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber() found: " + account);

		if (account == null)
			throw new AccountNotFoundException(accountNumber);
		else {
			return account;
		}
	}

	/**
	 * Este metodo extrae la data del la base de datos y lo coloca en el URL 
	 * la cual se pasa en el @RequestMapping
	 * @RequestMapping: se coloca la pagina que se va usar.
	 * @accountNumber: hace referencia al parametro que se desea para extraer data.
	 * */
	
	@RequestMapping("/accounts/owner/{name}")
	public List<Account> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts-service byOwner() invoked: "
				+ accountRepository.getClass().getName() + " for "
				+ partialName);

		List<Account> accounts = accountRepository
				.findByOwnerContainingIgnoreCase(partialName);
		logger.info("accounts-service byOwner() found: " + accounts);

		if (accounts == null || accounts.size() == 0)
			throw new AccountNotFoundException(partialName);
		else {
			return accounts;
		}
	}
}
