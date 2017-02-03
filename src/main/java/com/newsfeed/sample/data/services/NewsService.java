package com.newsfeed.sample.data.services;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.newsfeed.sample.data.entities.NewsEntry;

public class NewsService {

private List<NewsEntry> news = new LinkedList<>();
	
	public NewsService(){
		NewsEntry first = this.createNewsEntry(1L, "type1", "header1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.");
		NewsEntry second = this.createNewsEntry(1L, "type2", "header2", "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.");
		NewsEntry third = this.createNewsEntry(1L, "type3", "header3", "content3");
		
		this.news.addAll(Arrays.asList(new NewsEntry[]{first, second, third}));
	}
	
	public List<NewsEntry> findAll(){
		return this.news;
	}
	
	public void save(NewsEntry newsEntry){
		this.news.add(newsEntry);
	}
	
	public NewsEntry find(Long newsId){
		return this.news.stream().filter(n -> {
			return n.getNewsId().equals(newsId);
		}).collect(Collectors.toList()).get(0);
	}
	
	public void delete(Long newsId){
		this.news.removeIf((NewsEntry n) -> n.getNewsId() == newsId);
	}

	private NewsEntry createNewsEntry(Long newsId, String type, String header, String content) {
		NewsEntry newsEntry = new NewsEntry();
		newsEntry.setHeader(header);
		newsEntry.setType(type);
		newsEntry.setContent(content);
		newsEntry.setPostDate(new Date());
		newsEntry.setNewsId(newsId);
		return newsEntry;
	}
}
