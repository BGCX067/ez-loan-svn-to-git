package com.synergistic.it;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.ez.model.EmailNotificateVO;

/**
 * Message-Driven Bean implementation class for:
 * 
 * @author nagendra.yadav
 */

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "/queue/synergisitic"), })
//@Pool(value = PoolDefaults.POOL_IMPLEMENTATION_STRICTMAX, maxSize = 50, timeout = 10000)
public class MessageProcessBean implements MessageListener {
	@Resource
	private MessageDrivenContext context;

	/**
	 * @param message
	 *            this is message which will come from the query
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void onMessage(javax.jms.Message message) {
		System.out.println("_____________onMessage()_____________");
		try {
			if (message instanceof TextMessage) {
				System.out.println("Queue: I received a TextMessage at "
						+ new Date());
				System.out.println("!!!!!! = " + ((TextMessage) message).getText());
			} else if (message instanceof ObjectMessage) {
				System.out.println("Queue: I received an ObjectMessage "
						+ " at " + new Date());
				ObjectMessage msg = (ObjectMessage) message;
				EmailNotificateVO emailNotificateVO = (EmailNotificateVO) msg
						.getObject();
				SendMailTLS.sendEmail(emailNotificateVO.getMessage(), emailNotificateVO.getReceiverEmail(),emailNotificateVO.getSubject());
			} else {
				System.out.println("Not valid message for this Queue MDB");
			}
			System.out.println("----------------");
		} catch (JMSException sqle) {
			sqle.printStackTrace();
			context.setRollbackOnly();
		}

	}

}
