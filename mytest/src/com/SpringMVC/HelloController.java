package com.SpringMVC;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	protected Logger logger = Logger.getLogger(getClass());
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		String now = new Date().toString();
		
		logger.info("Returning hello view "+now);
		
//		return new ModelAndView("test/hello.jsp");
		return new ModelAndView("test/hello.jsp","now",now);
	}

}
