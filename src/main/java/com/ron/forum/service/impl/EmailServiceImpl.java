package com.ron.forum.service.impl;

import javax.mail.MessagingException;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ron.forum.domain.Email;
import com.ron.forum.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void createEmail(String receiverEmailAddr) {
		Email email = new Email();
		email.setSender("me");
		email.setReceiver(receiverEmailAddr);
		email.setSubject("论坛用户激活");
		email.setContent("http://www.baidu.com");
		jmsTemplate.convertAndSend(new ActiveMQQueue("email-handler.queue"), email);
	}

	@JmsListener(destination = "email-handler.queue")
	void send(Email email) {
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage());
		try {
			messageHelper.setFrom(email.getSender());
			messageHelper.setTo(email.getReceiver());
			messageHelper.setSubject(email.getSubject());
			messageHelper.setText(email.getContent());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(messageHelper.getMimeMessage());
	}
	
}
