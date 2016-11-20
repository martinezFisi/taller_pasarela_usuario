package taller.pasarela.microservices.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class paymentNotFoundException extends RuntimeException {


private static final long serialVersionUID = 1L;

		public paymentNotFoundException(String concepto) {
			super("No such concept: " + concepto);

	}

}
