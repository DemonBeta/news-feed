package com.newsfeed.sample.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.newsfeed.sample.data.entities.SearchRequest;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {

	@ModelAttribute("searchTagOptions")
	public List<String> getOptions() {
		return new LinkedList<>(Arrays.asList(new String[] {"Any tag", "World", "Politics", "Economy", "Sport", "Science" }));
	}
	
	@ModelAttribute("searchRequest")
	public SearchRequest getSearchRequest(){
		System.out.println("Adding SearchRequest to a model");
		return new SearchRequest();
	}
}
