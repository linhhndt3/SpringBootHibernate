package edu.hanoi.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.hanoi.jazz.dao.GroupDAO;
import edu.hanoi.jazz.model.Group;

@Controller
@RequestMapping(value="/nhom")
public class GroupController {
	
	private final static Logger LOGGER = Logger.getLogger(GroupController.class);
	
	@Autowired
	private GroupDAO groupDAO;
	
	@RequestMapping(value="/them", method = {RequestMethod.GET})
	public ModelAndView addForm() {
		return new ModelAndView("group.form", "command", new Group());
	}
	
	@RequestMapping(value="/luu", method = {RequestMethod.POST})
	public ModelAndView addNew(@Valid @ModelAttribute("command") Group group, BindingResult result) {
		LOGGER.info("--- group info:" + group);
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("group.form", "command", group);
			mv.addObject("errors", result);
			return mv;
		}
		LOGGER.info("--- add new group");
		
		groupDAO.insert(group);
		return new ModelAndView("group.form");
	}
}
