package com.ron.forum;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class SpringMVCConfig {

	@Bean
	FreeMarkerViewResolver viewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
		viewResolver.setViewClass(FreeMarkerView.class);
		viewResolver.setContentType("text/html;charset=utf-8");
		viewResolver.setSuffix(".ftl");
		viewResolver.setPrefix("/templates/");
		return viewResolver;
	}
	
	@Bean
    HttpMessageConverters jacksonHttpMessageConverters(){
		MappingJackson2HttpMessageConverter jacksonMessageConverter = new MappingJackson2HttpMessageConverter();
		StringHttpMessageConverter stringMessageConverter = new StringHttpMessageConverter();
        return new HttpMessageConverters(jacksonMessageConverter, stringMessageConverter);
    }
}
