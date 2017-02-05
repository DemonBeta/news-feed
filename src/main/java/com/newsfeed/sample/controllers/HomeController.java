package com.newsfeed.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.newsfeed.sample.data.entities.SearchRequest;
import com.newsfeed.sample.data.services.NewsService;

@Controller
public class HomeController {

	@Autowired
	private NewsService newsService;

	@RequestMapping("/")
	public String goHome(Model model) {
		model.addAttribute("news", newsService.findAll());
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchNewsEntry(@ModelAttribute SearchRequest searchRequest, Model model) {

		System.out.println("searchNewsEntry: " + searchRequest);
		model.addAttribute("news", newsService.search(searchRequest));
		return "home";
	}
}
