package com.example.zuulservice.filter;

import org.springframework.stereotype.Component;



import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZuulLoggingFilter   {

	// public Object run()   {
	// 	log.info("**************** printing logs: ");
	//
	// 	RequestContext ctx = RequestContext.getCurrentContext();
	// 	HttpServletRequest request = ctx.getRequest();
	// 	log.info("**************** " + request.getRequestURI());
	//
	// 	return null;
	// }
	//
	// @Override
	// public String filterType() {
	// 	return "pre";
	// }
	//
	// @Override
	// public int filterOrder() {
	// 	return 1;
	// }
	//
	// @Override
	// public boolean shouldFilter() {
	// 	return true;
	// }
}