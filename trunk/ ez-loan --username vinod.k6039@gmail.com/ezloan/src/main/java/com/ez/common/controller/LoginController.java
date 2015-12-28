package com.ez.common.controller;

/**
 * This is the login and logout controller
 */

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.admin.service.CustomerService;
import com.ez.common.constant.ApplicationConstant;
import com.ez.common.util.Encrypter;
import com.ez.model.Customer;

/**
 * 
 * @author Sid CTR+SHIFT+O =to remove unused import statement
 * 
 */
@Controller
@RequestMapping("/auth")
@Scope("request")
public class LoginController implements ApplicationConstant {
	
	//@Autowired
	//@Qualifier("UserSessionVO")
	//private UserSessionVO sessionVO;

	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;

	@RequestMapping(value = "wwelcome.htm", method = RequestMethod.GET)
	public String welcomePage() {
		return "index";
	}
	

	@RequestMapping(value = "goToErrorPage.htm", method = RequestMethod.GET)
	public String errorPage() {
		return "InvalidSession";
	}

	/**
	 * 
	 * @param uname
	 * @param password
	 * @param session
	 * @return
	 */

	@RequestMapping(value = "validate.htm", method = RequestMethod.POST)
	public String foome(@RequestParam("username") String uname,
			@RequestParam("password") String password, HttpSession session,
			Model model) {
		Encrypter encrypter = new Encrypter();
		String result = customerService.validateCustomer(uname,
				encrypter.encrypt(password));

		String[] applicationTypes = this.applicationTypes;
		List<Customer> newCustomers = customerService.customerList("NEW");
		model.addAttribute("newCustomers", newCustomers);
		model.addAttribute("applicationTypes", applicationTypes);

		if (result.equalsIgnoreCase("welcome")) {
			//sessionVO.setUsername(uname);
			session.setAttribute("uname",uname);
			return "welcome";
		} else
			return "InvalidSession";
	}
	
	@RequestMapping(value="goHome.htm", method=RequestMethod.GET)
	public String goHome(Model model){
		
		String[] applicationTypes = this.applicationTypes;
		List<Customer> newCustomers = customerService.customerList("NEW");
		model.addAttribute("newCustomers", newCustomers);
		model.addAttribute("applicationTypes", applicationTypes);

		return "welcome";
		
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

}