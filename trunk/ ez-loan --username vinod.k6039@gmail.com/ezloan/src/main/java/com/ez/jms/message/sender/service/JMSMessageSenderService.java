/*package com.ez.jms.message.sender.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.ez.model.EmailNotificateVO;

*//**
 * @author nagendra.yadav
 * 
 *  The class which would send message to JMS queue
 *  by using Spring Template
 *//*
@Service("JMSMessageSenderService")
public class JMSMessageSenderService implements JMSMessageSender{
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Override
	public String sendEmailMessageToQueue(final EmailNotificateVO emailNotificateVO) {
		jmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException	{
					ObjectMessage message = session.createObjectMessage();
					message.setObject(emailNotificateVO);
					return message;
			}
		});
		return "done";
	}
	
	

}
*/