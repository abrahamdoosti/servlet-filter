package com.example.servletfilter.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;

public class FirstNameFilter implements Filter {
	FilterConfig filterConfig = null;
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(FirstNameFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		LOGGER.info("Inside doFilter method before getting paramertes");
		// out.println("my-param (InitParameter): " +
		// filterConfig.getInitParameter("my-param \n"));
		Enumeration<String> parameters = request.getParameterNames();
		if (parameters.hasMoreElements()) {
			while (parameters.hasMoreElements()) {
				String name = parameters.nextElement();
				String value = request.getParameter(name);
				out.println("<p>" + name + ": " + value + "<p/>");
				LOGGER.info("Request parameter : {} {}", name, value);
			}
		} else {
			out.println("---None---<br/>");
		}
		LOGGER.info("Inside doFilter method after getting paramertes");
		String firstName = request.getParameter("first_name");
		if (null == firstName || firstName.length() < 3) {
			out.print("<br/>first_name can't be less than three characters<br/>");
			LOGGER.info("Short length first_name : {}", firstName);
		} else {
			out.println("<br/>Start Regular Content:<br/><hr/>");
			filterChain.doFilter(request, response);
			out.println("<br/><hr/>End Regular Content:<br/>");
		}

	}

	/*
	 * public void doFilter(ServletRequest request, ServletResponse response,
	 * FilterChain filterChain) throws IOException, ServletException {
	 * 
	 * }
	 */

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
