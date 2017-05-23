package com.ron.forum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableRedisHttpSession
public class RedisConfiguration {

	
	private JedisPoolConfig poolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(600);
		poolConfig.setMaxWaitMillis(1000);
		poolConfig.setMaxIdle(300);
		return poolConfig;
	}
	
	@Bean
	JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("he");
		connectionFactory.setPort(6379);
		connectionFactory.setPoolConfig(poolConfig());
		return connectionFactory;
	}
	
}
