package pe.edu.sistemas.microservices.services.web;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.edu.sistemas.microservices.services.web.payment;

/*
* Client controller, recupera la información de la cuenta desde el microservicio
*
*/
@Controller
public class WebpaymentsController {
	
	@Autowired
	protected WebpaymentsService paymentsService;

	protected Logger logger = Logger.getLogger(WebpaymentsController.class
			.getName());

	public WebpaymentsController(WebpaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	
	@RequestMapping("/payments")
	public String goHome() {
		return "index";
	}

}
