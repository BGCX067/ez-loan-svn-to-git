package com.ez.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author nagendra.yadav Simple Interceptor example Each interceptor you define
 *         must implement org.springframework.web.servlet.HandlerInterceptor
 *         interface. There are three methods that need to be implemented.
 * 
 */
public class AdminInterceptor implements HandlerInterceptor {

	// preHandle(..) is called before the actual handler is executed;
	// The preHandle(..) method returns a boolean value. You can use this method
	// to break or continue the processing of the execution chain. When this
	// method returns true, the handler execution chain will continue; when it
	// returns false, the DispatcherServlet assumes the interceptor itself has
	// taken care of requests (and, for example, rendered an appropriate view)
	// and does not continue executing the other interceptors and the actual
	// handler in the execution chain.
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//System.out.println("____ADMIN PreHandle________");
		return true;
	}

	// postHandle(..) is called after the handler is executed;
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("____ADMIN postHandle________");

	}

	// afterCompletion(..) is called after the complete request has finished.
	// These three methods should provide enough flexibility to do all kinds of
	// preprocessing and postprocessing.
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("____ADMIN afterCompletion________");

	}

}
