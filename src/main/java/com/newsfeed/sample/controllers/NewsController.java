package com.newsfeed.sample.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.data.services.NewsService;

@Controller
@RequestMapping("/manage_news")
@SessionAttributes("newsEntry")
public class NewsController {
	
	@Autowired
	private NewsService newsService;

//	@RequestMapping(value="/find")
//	public String find(Model model){
//		model.addAttribute("projects", newsService.findAll());
//		return "projects";
//	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addNews(Model model){	
		return "news_add";
	}
	
	@ModelAttribute("newsEntry")
	public NewsEntry getNewsEntry(){
//		System.out.println("Adding NewsEntry to a model");
		return new NewsEntry();
	}

	@ModelAttribute("tagOptions")
	public List<String> getOptions() {
		return new LinkedList<>(Arrays.asList(new String[] { "World", "Politics", "Economy", "Sport", "Science" }));
	}
	

//	@RequestMapping(value="/add", method=RequestMethod.POST)
//	public String saveProject(@Valid @ModelAttribute NewsEntry newsEntry, Errors errors, RedirectAttributes attributes){
//		if (!errors.hasErrors()){
//			System.out.println("Project object validated");
//		} else {
//			System.out.println("Project object did not validate");
//			return "project_add";
//		}
//		
//		project.setProjectId(55L);
//		projectService.save(project);
//		attributes.addAttribute("projectId", project.getProjectId().toString());
//		System.out.println(project);
//		return "redirect:/";
//	}
}
