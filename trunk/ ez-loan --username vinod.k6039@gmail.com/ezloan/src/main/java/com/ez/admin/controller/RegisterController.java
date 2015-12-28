/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ez.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ez.admin.service.CustomerService;
import com.ez.common.util.DESedeEncryption;
import com.ez.model.Customer;
import com.ez.model.EmailNotificateVO;


@Controller
@RequestMapping("/auth")
public class RegisterController {
	
	private  static Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;
	
	//@Autowired
	//@Qualifier("JMSMessageSenderService")
	//private JMSMessageSender jmsMessageSender;
	
	
	/*The value attribute indicates the URL to which the handler method is mapped 
	and the method attribute defines the service method to handle HTTP GET request.*/
	@RequestMapping(value="register.htm", method=RequestMethod.GET)
	public String showRegister(ModelMap model) {
		Customer customer=new Customer();
		model.addAttribute("CUSTOMER",customer);
		return "Register";
		
	}
	
	
	/*The value attribute indicates the URL to which the handler method is mapped 
	and the method attribute defines the service method to handle HTTP GET request.*/
	@RequestMapping(value="register.htm",method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute(value="CUSTOMER") Customer customer) {
		DESedeEncryption deSedeEncryption=null;
		try {
			deSedeEncryption = new DESedeEncryption();
		} catch (Exception e) {
			logger.error(e);
		}
		customer.setPassword(deSedeEncryption.encrypt(customer.getPassword()));
		customerService.addCustomer(customer);
		EmailNotificateVO emailNotificateVO=new EmailNotificateVO();
		emailNotificateVO.setDescription("This is email message");
		emailNotificateVO.setMessage("You are successfully registered with EZLoan!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		emailNotificateVO.setSubject("Regarding new customer registration!");
		emailNotificateVO.setReceiverEmail(customer.getEmail());
		emailNotificateVO.setSenderEmail("desibankproject@gmail.com");
		//This is calling a method to send message to the jms queue
		//jmsMessageSender.sendEmailMessageToQueue(emailNotificateVO);
		return "index";
	}
	
/*private void sendMessageToQueue(EmailNotificateVO emailNotificateVO){
		Context context = null;
		Queue queue = null;
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces"); // this the ip of the
														// JNDI service
		properties.put("java.naming.provider.url","jnp://localhost:1099");
        try {
			context = new InitialContext(properties);
			getQueueSender(context,queue,emailNotificateVO);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getQueueSender(Context context,Queue queue, EmailNotificateVO emailNotificateVO) throws JMSException,NamingException {
        queue = (Queue)context.lookup("queue/synergisitic");
        QueueConnectionFactory queueFactory = (QueueConnectionFactory)context.lookup("ConnectionFactory");
        QueueConnection queueConnection = queueFactory.createQueueConnection();
        QueueSession queueSession = queueConnection.createQueueSession(false,
             javax.jms.Session.AUTO_ACKNOWLEDGE);
        QueueSender queueSender  = queueSession.createSender(queue);
      //2. Sending ObjectMessage to the Queue
        ObjectMessage objMsg = queueSession.createObjectMessage();
        objMsg.setObject(emailNotificateVO);
        System.out.println("2. Sent ObjectMessage to the Queue");
        queueSender.send(queue, objMsg);
        System.out.println("########MESSAGE IS SEND TO QUEUE (objMsg)= "+objMsg);
        
}*/

}
