package edu.hanoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView sayHello() {
		System.out.println("----- hello hanoi java clazz");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Hello Java Clazz");
		return mv;
	}
}
