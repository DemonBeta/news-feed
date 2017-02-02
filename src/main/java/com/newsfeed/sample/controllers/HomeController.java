package com.newsfeed.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String goHome(Model model){
		
//		Project project = new Project();
//		project.setName("First Project");
//		project.setSponsor(new Sponsor("NASA", "555-55-55", "nasa@nasa.com"));
//		project.setDescription("This is a simple project sponsored by NASA");
//		
//		model.addAttribute("currentProject", project);
		
		return "home";
	}
}
