package com.SpringMVC;

import org.springframework.web.servlet.ModelAndView;

import com.SpringMVC.HelloController;

import junit.framework.TestCase;

public class HelloControllerTests extends TestCase {

	public void testHandleRequestView() throws Exception{
		
		HelloController controller = new com.SpringMVC.HelloController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
//		assertEquals("test/hello.jsp",modelAndView.getViewName());//测试是否返回正确的view名称
		
		assertEquals("test/hello.jsp", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		String nowValue = (String) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
		
	}
	
}
