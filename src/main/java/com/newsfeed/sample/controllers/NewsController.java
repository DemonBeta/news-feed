package com.newsfeed.sample.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.data.services.NewsService;

@Controller
@RequestMapping("/news")
@SessionAttributes("newsEntry")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addNews(SessionStatus status){
		status.setComplete();
		return "news_add";
	}
	
	@ModelAttribute("newsEntry")
	public NewsEntry getNewsEntry(){
		System.out.println("Adding NewsEntry to a model");
		return new NewsEntry();
	}

	@ModelAttribute("tagOptions")
	public List<String> getOptions() {
		return new LinkedList<>(Arrays.asList(new String[] { "World", "Politics", "Economy", "Sport", "Science" }));
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params={"edit"})
	public String editNewsEntry(@RequestParam("edit") Long newsId, Model model){
		model.addAttribute("newsEntry", newsService.find(newsId));
		System.out.println("getting news by ID: "+ newsService.find(newsId));
		return "news_edit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params={"delete"})
	public String deleteNewsEntry(@RequestParam("delete") Long newsId){
		System.out.println("deleteNewsEntry: "+ newsService.find(newsId));
		newsService.delete(newsId);
		return "redirect:/";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveNewsEntry(@Valid @ModelAttribute NewsEntry newsEntry, Errors errors, SessionStatus status){
		if (!errors.hasErrors()){
			System.out.println("Project object validated");
		} else {
			System.out.println("Project object did not validate");
			return "news_add";
		}
		
		System.out.println("saveNewsEntry: "+ newsEntry);
		newsService.create(newsEntry);
		status.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editNewsEntry(@Valid @ModelAttribute NewsEntry newsEntry, Errors errors, SessionStatus status){
		if (!errors.hasErrors()){
			System.out.println("Project object validated");
		} else {
			System.out.println("Project object did not validate");
			return "news_edit";
		}
		
		System.out.println("editNewsEntry: "+ newsEntry);
		newsService.update(newsEntry);
		status.setComplete();
		return "redirect:/";
	}
}
