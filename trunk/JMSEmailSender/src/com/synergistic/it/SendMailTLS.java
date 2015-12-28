package com.synergistic.it;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 *  @author nagendra.yadav
 * 
 *   Java code to send the email using email api.
 *   Here in order to send the email we are using smtp host from gmail.
 *
 */
public class SendMailTLS {
	
	public static void main(String[] args) {
		sendEmail("I am fine here and doing email = ","bharath.suresh@gmail.com","I am fine");
	}
 
	public static void sendEmail(String smessage,String toEmailId,String subject) {
		
	    String host = "smtp.gmail.com";
		int port = 587;
		//String username = "nagendra.yadav.niit";//sender email id
		String username = "desibankproject";
		String password = "desibank"; //password for sender 
		String from="desibankproject@gmail.com";
		
		//String to="nagendra.yadav.niit@gmail.com";
		String to=toEmailId;
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
      // props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
      //  props.put("mail.debug", "true");
 
		Session session = Session.getInstance(props);
		try {
 
			SmtpAuthenticator authentication = new SmtpAuthenticator();
			javax.mail.Message message = new MimeMessage(Session
			                    .getDefaultInstance(props, authentication));
			//Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(smessage);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);
			System.out.println("QQQQQQQQQQQQQQQQQQQ");
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}