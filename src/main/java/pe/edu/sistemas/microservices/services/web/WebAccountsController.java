package pe.edu.sistemas.microservices.services.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * Client controller, recupera la información de la cuenta desde el microservicio
 * {@link WebAccountsService}.
 * 
 */
@Controller
public class WebAccountsController {

	@Autowired
	protected WebAccountsService accountsService;
	
	@Autowired
	protected WebpaymentsService paymentsService;

	protected Logger logger = Logger.getLogger(WebAccountsController.class
			.getName());

	public WebAccountsController(WebAccountsService accountsService) {

		this.accountsService = accountsService;
	}

//	public WebAccountsController(WebpaymentsService paymentsService) {
//		this.paymentsService = paymentsService;
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields();
	}

	@RequestMapping("/accounts")
	public String goHome() {
		return "index";
	}

	@RequestMapping("/accounts/{accountNumber}")
	public String byNumber(Model model,
			@PathVariable("accountNumber") String accountNumber) {
		
		List<payment> payment = new ArrayList();
	    model.addAttribute("payment", payment);
		logger.info("web-service byNumber() invoked: " + accountNumber);
		model.addAttribute("payment", new payment());
		List <payment> payments = paymentsService.getpayments();
		model.addAttribute("paymentList" , payments);
		Account account = accountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() fo	und: " + account);
		model.addAttribute("account", account);
		return "account";
		
	}
	
//	@Bean
//	public String displayPayment(Model model){
//		model.addAttribute("payment", new payment()); 
//		return "payment";
//	}
//	
//	
//	@RequestMapping("")
//	public String getPay(Model model) {
//		List <payment> payments = paymentsService.getpayments();
//		model.addAttribute("paymentList" , payments);
//		return "paymentList";
//	}
	
  	@RequestMapping("/accounts/owner/{text}")
	public String ownerSearch(Model model, @PathVariable("text") String name) {
		logger.info("web-service byOwner() invoked: " + name);

		List<Account> accounts = accountsService.byOwnerContains(name);
		logger.info("web-service byOwner() found: " + accounts);
		model.addAttribute("search", name);
		if (accounts != null)
			model.addAttribute("accounts", accounts);
		return "accounts";
	}
  	
  	
	@RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "accountSearch";
	}

	@RequestMapping(value = "/accounts/payments")
	public String doSearch(Model model, SearchCriteria criteria,
			BindingResult result) {
		logger.info("web-service search() invoked: " + criteria);

		criteria.validate(result);

		if (result.hasErrors())
			return "accountSearch";
		String accountNumber = criteria.getAccountNumber();
		return byNumber(model, accountNumber);
	}
	
	@RequestMapping("/accounts/pagos")
	public String pasarela(Model model, ReturnMonto returnmonto) {
		String total = returnmonto.getMonto();
		return procesar(model, total);
	}
	
	@RequestMapping("/accounts/{total}")
	public String procesar(Model model, @PathVariable("total") String total){
		model.addAttribute("total", total);
		return "pasarela";
	}
	
	@RequestMapping("/accounts/exito")
	public String complete(){
		return "empty";
	}
}
