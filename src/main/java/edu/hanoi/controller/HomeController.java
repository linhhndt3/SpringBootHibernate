package edu.hanoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView sayHello() {
		System.out.println("----- hello hanoi java clazz");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Hello Java Clazz");
		return mv;
	}
	
	@RequestMapping(value="/dang-nhap")
	public ModelAndView login(@RequestParam(value="error", required=false) String error) {
		System.out.println("----- inside controller dang-nhap");
		ModelAndView mv = new ModelAndView("login");
		if(error != null) mv.addObject("error", error);
		return mv;
	}
	
	@RequestMapping(value="/nguoi-dung")
	public ModelAndView forUser() {
		System.out.println("----- inside controller nguoi-dung");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "This is a protected page");
		return mv;
	}
}
