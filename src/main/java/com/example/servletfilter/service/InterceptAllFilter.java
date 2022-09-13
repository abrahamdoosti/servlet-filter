package com.example.servletfilter.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class InterceptAllFilter
 */
@Component
@Order(3)
public class InterceptAllFilter implements Filter {


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out=response.getWriter();
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		response.getWriter().println("<br> Inside InterceptAllFilter Filter<br/>");
		//System.out.println("Inside InterceptAllFilter Filter");
		
		boolean doNotBlock= Boolean.parseBoolean(req.getParameter("do_not_block"));
		 if(doNotBlock) {
			// pass the request along the filter chain
			 chain.doFilter(request, response);			 
			 //If there is no servlet to match the request URL, then a 404 will be sent at the end of the filter chain.doFilter()
			 System.out.println("No resource found matching your request, but I can atleast exit gracefully!");
		 }else {
			 out.println("<br> Request Blocked because query param do_not_block was set to false or missing<br/>");
		 }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
