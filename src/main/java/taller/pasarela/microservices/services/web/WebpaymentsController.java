package taller.pasarela.microservices.services.web;
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

import taller.pasarela.microservices.services.web.payment;

@Controller
public class WebpaymentsController {
	
	@Autowired
	protected WebpaymentsService paymentsService;

	protected Logger logger = Logger.getLogger(WebpaymentsController.class
			.getName());

	public WebpaymentsController(WebpaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}
	
	@RequestMapping("/payments")
	public String goHome() {
		return "index";
	}

	
}
