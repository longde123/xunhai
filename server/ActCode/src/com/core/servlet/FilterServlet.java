package com.core.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author barsk
 * 2014-3-24
 * 拦截器
 */
public class FilterServlet implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		/*HttpServletRequest request = ((HttpServletRequest)req);
		String remoteAddr = request.getRemoteHost();
		String localAddr = InetAddress.getLocalHost().getHostAddress();
		
		// 验证ip
		if (remoteAddr == null || !localAddr.equals(remoteAddr)) return;
		 */	
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
