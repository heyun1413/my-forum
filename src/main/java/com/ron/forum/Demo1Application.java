package com.ron.forum;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.ron.forum")
@EnableTransactionManagement
@EnableWebMvc
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	EmbeddedServletContainerFactory servletContainer() {

		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected void postProcessContext(Context context) {

				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}
	
	@Bean
	DelegatingFilterProxy delegatingFilterProxy() {
		return new DelegatingFilterProxy();
	}
	
	@Bean
    public FilterRegistrationBean indexFilterRegistration(DelegatingFilterProxy delegatingFilterProxy) {
        FilterRegistrationBean registration = new FilterRegistrationBean(delegatingFilterProxy);
        registration.addUrlPatterns("/");
        return registration;
    }

	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://he:3306/myforum?useUnicode=true&characterEncoding=utf8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("ily");
		dataSource.setMinIdle(10);
		dataSource.setInitialSize(10);
		dataSource.setMaxTotal(200);
		dataSource.setMaxWaitMillis(2000);
		return dataSource;
	}

	@Bean
	SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		Resource[] resources;
		try {
			resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/ron/forum/mapper/*.xml");
		} catch (IOException e) {
			throw new BeanCreationException("创建Bean失败！");
		}
		sqlSessionFactory.setMapperLocations(resources);
		return sqlSessionFactory;
	}

	@Bean
	DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

}
