package taller.pasarela.microservices.accounts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface AccountRepository extends Repository<Account, Long> {
	
	public Account findByNumber(String accountNumber);

	/**
	 * Find accounts whose owner name contains the specified string
	 * 
	 * @param partialName
	 *            Any alphabetic string.
	 * @return The list of matching accounts - always non-null, but may be
	 *         empty.
	 */
	public List<Account> findByOwnerContainingIgnoreCase(String partialName);

	/**
	 * Fetch the number of accounts known to the system.
	 * 
	 * @return The number of accounts.
	 */
	@Query("SELECT count(*) from Account")
	public int countAccounts();
}