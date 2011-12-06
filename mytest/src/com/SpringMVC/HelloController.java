package com.SpringMVC;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.testibatis.User;
import com.testibatis.service.IUserService;

public class HelloController implements Controller {

	protected Logger logger = Logger.getLogger(getClass());
	private IUserService userService;
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		String now = new Date().toString();
		
		logger.info("Returning hello view "+now);
		
//		return new ModelAndView("/WEB-INF/jsp/test/hello.jsp");
		User user = null;
		try {
			user = userService.getUserById("100");
		} catch (Exception e) {
			logger.error("数据访问出错:\n"+e);
		}
		
		System.out.println("------------- user is :"+user);
		
		//Decouple the view from the controller,see config in mytestapp-servlet.xml
		return new ModelAndView("hello","now",now);
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
}
