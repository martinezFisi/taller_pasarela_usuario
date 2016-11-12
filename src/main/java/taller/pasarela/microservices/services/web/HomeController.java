package io.pivotal.microservices.services.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home page controller.
 * 
 * @author Paul Chapman
 */
@Controller
public class HomeController {

//	@RequestMapping("/")
//	@RequestMapping(value = "/accounts/search", method = RequestMethod.GET)
//	public String home() {
//		return "index";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchForm(Model model) {
		model.addAttribute("searchCriteria", new SearchCriteria());
		return "accountSearch";
	}


}
