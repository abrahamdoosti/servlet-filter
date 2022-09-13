package com.example.servletfilter.config;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.servletfilter.service.AgeFilter;
import com.example.servletfilter.service.FirstNameFilter;
import com.example.servletfilter.service.MyServlet;

@Configuration
public class WebConfig {
	
	private static final String TEST_URL="/test/*";
	private static final String DO_URL="/do/*";
	@Bean
	public ServletRegistrationBean<HttpServlet> countryServlet() {
		ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		servRegBean.setServlet(new MyServlet());
		servRegBean.addUrlMappings(TEST_URL);
		servRegBean.setLoadOnStartup(1);
		return servRegBean;
	}

	@Bean
	public FilterRegistrationBean<FirstNameFilter> firstNameFilter() {
		FilterRegistrationBean<FirstNameFilter> filterRegBean = new FilterRegistrationBean<>();
		filterRegBean.setFilter(new FirstNameFilter());
		filterRegBean.addUrlPatterns(DO_URL,TEST_URL);
		filterRegBean.setOrder(1);
		return filterRegBean;
	}
	
	@Bean
	public FilterRegistrationBean<AgeFilter> ageFilter() {
		FilterRegistrationBean<AgeFilter> filterRegBean = new FilterRegistrationBean<>();
		filterRegBean.setFilter(new AgeFilter());
		filterRegBean.addUrlPatterns(DO_URL,TEST_URL);
		filterRegBean.setOrder(2);
		return filterRegBean;
	}

}
