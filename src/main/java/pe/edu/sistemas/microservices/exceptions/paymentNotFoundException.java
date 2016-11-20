package pe.edu.sistemas.microservices.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

/**
 * La clase se utiliza para cuando hay fallas al extraer 
 * registros a la BD
 * */
public class paymentNotFoundException extends RuntimeException {


private static final long serialVersionUID = 1L;

		public paymentNotFoundException(String concepto) {
			super("No such concept: " + concepto);

	}

}
