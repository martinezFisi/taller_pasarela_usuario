package pe.edu.sistemas.microservices.services.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 * Manipula la DATA con la cual se redirecciona a las otras vistas
 * */
public class SearchCriteria {
	private String accountNumber;

	private String searchText;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public boolean isValid() {
		if (StringUtils.hasText(accountNumber))
			return !(StringUtils.hasText(searchText));
		else
			return (StringUtils.hasText(searchText));
	}

	public boolean validate(Errors errors) {
		if (StringUtils.hasText(accountNumber)) {
			if (accountNumber.length() != 8)
				errors.rejectValue("accountNumber", "badFormat",
						"El codigo de usuario debe ser un numero de 8 digitos");
			else {
				try {
					Integer.parseInt(accountNumber);
				} catch (NumberFormatException e) {
					errors.rejectValue("accountNumber", "badFormat",
							"El codigo de usuario debe ser un numero de 8 digitos");
				}
			}

			if (StringUtils.hasText(searchText)) {
				errors.rejectValue("searchText", "nonEmpty",
						"No se puede especificar el texto de busqueda");
			}
		} else if (StringUtils.hasText(searchText)) {
			; // Nothing to do
		} else {
			errors.rejectValue("accountNumber", "nonEmpty",
					"Debe especificar un número de cuenta o un texto de búsqueda");

		}

		return errors.hasErrors();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (StringUtils.hasText(accountNumber) ? "number: " + accountNumber
				: "")
				+ (StringUtils.hasText(searchText) ? " text: " + searchText
						: "");
	}
}
