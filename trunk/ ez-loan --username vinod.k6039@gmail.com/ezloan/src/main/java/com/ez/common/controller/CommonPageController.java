package com.ez.common.controller;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ez.admin.service.CustomerService;
import com.ez.model.Customer;


/**
 * 
 * @author nagendra.yadav
 * This is common page Controller
 * which will be used to display the 
 * customer,admin, sadmin page 
 */

@Controller
@RequestMapping("/common")
public class CommonPageController {


	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
		
	@RequestMapping(value="/homescreen.htm",method = RequestMethod.GET)
	public ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nextPage="guest";
		// Retrieve user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //retrieving the role of the logged in user.
        Collection<? extends GrantedAuthority> grantedList=authentication.getAuthorities();
        //Here we are assuming last role present inside the list will be actual role of
        //logged in user.
        if(grantedList!=null && grantedList.size()>0){
        	Iterator<? extends GrantedAuthority> iterator=grantedList.iterator();
        	if(iterator.hasNext()){
        		GrantedAuthority ga=iterator.next();
        	    nextPage=ga.getAuthority();
        	}
        }
        //Setting the logged user information into the session 
        Customer luser=customerService.findCustomerByUserName(authentication.getName());
		request.getSession().setAttribute("USER_SESSION",luser);
		nextPage="welcome";
        ModelAndView modelAndView=new ModelAndView(nextPage);
	    return modelAndView;
	}
}
