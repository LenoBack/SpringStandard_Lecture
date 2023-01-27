package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Locale;

@Controller
public class HomeController {
	@Autowired
	WebApplicationContext servletAC; // Servlet AC

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request, Model model) {
		// 원래는 request.getServletContext()지만, 컨트롤러는 HttpServlet을 상속받지 않아서 아래와 같이 해야함.
		ServletContext sc = request.getSession().getServletContext(); // ApplicationContextFacade
		WebApplicationContext rootAC = WebApplicationContextUtils.getWebApplicationContext(sc); // Root AC

		System.out.println("webApplicationContext = " + rootAC);
		System.out.println("servletAC = " + servletAC);

		System.out.println("rootAC.getBeanDefinitionNames() = " + Arrays.toString(rootAC.getBeanDefinitionNames()));
		System.out.println("servletAC.getBeanDefinitionNames() = " + Arrays.toString(servletAC.getBeanDefinitionNames()));

		System.out.println("rootAC.getBeanDefinitionCount() = " + rootAC.getBeanDefinitionCount());
		System.out.println("servletAC.getBeanDefinitionCount() = " + servletAC.getBeanDefinitionCount());

		System.out.println("servletAC.getParent()==rootAC = " + (servletAC.getParent() == rootAC)); // servletAC.getParent()==rootAC = true
		return "home";
	}
}