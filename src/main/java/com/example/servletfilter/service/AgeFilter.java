package com.example.servletfilter.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;

public class AgeFilter implements Filter {
	FilterConfig filterConfig = null;
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AgeFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		Integer age = request.getParameter("age")==null?null:Integer.valueOf(request.getParameter("age"));

		if (null != age && age >= 0) {
			filterChain.doFilter(request, response);
		} else {
			out.println("Age can't be less than zero or null");
			LOGGER.info("Negative age provided: {}", age);
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
