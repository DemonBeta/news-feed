package com.newsfeed.sample.data.services;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.repositories.NewsRepositoryImp;

@Service 
@Transactional
public class NewsService {

private List<NewsEntry> news = new LinkedList<>();
	
	public NewsService(){
		NewsEntry first = this.createNewsEntry(1L, "World", "header1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.");
		NewsEntry second = this.createNewsEntry(2L, "Politics", "header2", "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.");
		NewsEntry third = this.createNewsEntry(3L, "Economy", "header3", "content3");
		
		this.news.addAll(Arrays.asList(new NewsEntry[]{first, second, third}));
	}
	
	@Autowired
    private NewsRepositoryImp repository;

    @Transactional(readOnly = true)
    public List<NewsEntry> findAll() {
        return repository.getAllNews();
    }
	
//	public List<NewsEntry> findAll(){
//		return this.news;
//	}
	
//	public void create(NewsEntry newsEntry){
//		this.news.add(newsEntry);
//	}
	
	public void create(NewsEntry newsEntry){
		repository.createNewsEntry(newsEntry);
	}
	
//	public NewsEntry find(Long newsId){
//		return this.news.stream().filter(n -> {
//			return n.getNewsId().equals(newsId);
//		}).collect(Collectors.toList()).get(0);
//	}
	
	public NewsEntry find(Long newsId){
		return repository.getNewsEntry(newsId);
	}
	
//	public void update(NewsEntry newsEntry){
//		this.news.removeIf((NewsEntry n) -> n.getNewsId() == newsEntry.getNewsId());
//		this.news.add(newsEntry);
//	}
	
	public void update(NewsEntry newsEntry){
		repository.updateNewsEntry(newsEntry);
	}
	
//	public void delete(Long newsId){
//		this.news.removeIf((NewsEntry n) -> n.getNewsId() == newsId);
//	}
	
	public void delete(Long newsId){
		repository.deleteNewsEntry(newsId);
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
