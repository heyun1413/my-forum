package com.ron.forum;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMQConfiguration {

	
	private ConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://he:61616");
		return connectionFactory;
	}
	
	@Bean
	ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setTargetConnectionFactory(activeMQConnectionFactory());
		connectionFactory.setSessionCacheSize(100);
		return connectionFactory;
	}
	
	@Bean
	JmsTemplate jmsQueueTemplate(ConnectionFactory connectionFactory) {
		return new JmsTemplate(connectionFactory);
	}
	
	@Bean
	JmsMessagingTemplate jmsMessagingTemplate(JmsTemplate jmsTemplate) {
		return new JmsMessagingTemplate(jmsTemplate);
	}
}
