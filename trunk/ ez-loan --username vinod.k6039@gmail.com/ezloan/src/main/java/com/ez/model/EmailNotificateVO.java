package com.ez.model;

import java.io.Serializable;

/**
 * @author nagendra.yadav
 *   VO which carry the message to send the customer
 * 
 */
public class EmailNotificateVO implements Serializable {
	
	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String subject;
	private String message;
	private String senderEmail;
	private String receiverEmail;
	private String description;
	
	public EmailNotificateVO() {
	}

	public EmailNotificateVO(String subject, String message,
			String senderEmail, String receiverEmail, String description) {
		super();
		this.subject = subject;
		this.message = message;
		this.senderEmail = senderEmail;
		this.receiverEmail = receiverEmail;
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EmailNotificateVO [subject=" + subject + ", message=" + message
				+ ", senderEmail=" + senderEmail + ", receiverEmail="
				+ receiverEmail + ", description=" + description + "]";
	}
}
