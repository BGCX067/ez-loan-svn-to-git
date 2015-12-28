package com.ez.jms.message.sender.service;

import com.ez.model.EmailNotificateVO;

/**
 *  @author nagendra.yadav
 *  This is contract to interact with JMS queue. 
 */
public interface JMSMessageSender {
	public String sendEmailMessageToQueue(EmailNotificateVO emailNotificateVO);
}
