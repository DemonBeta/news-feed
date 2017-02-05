package com.newsfeed.sample.data.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.data.entities.SearchRequest;
import com.newsfeed.sample.repositories.NewsRepositoryImp;

@Service 
@Transactional
public class NewsService {
	
	@Autowired
    private NewsRepositoryImp repository;

    @Transactional(readOnly = true)
    public List<NewsEntry> findAll() {
    	List<NewsEntry> tempList = repository.getAllNews();
    	Collections.sort(tempList);
    	Collections.reverse(tempList);
        return tempList;
    }

	public void create(NewsEntry newsEntry){
		repository.createNewsEntry(newsEntry);
	}
	
	public NewsEntry find(Long newsId){
		return repository.getNewsEntry(newsId);
	}
	
	public void update(NewsEntry newsEntry){
		repository.updateNewsEntry(newsEntry);
	}
	
	public void delete(Long newsId){
		repository.deleteNewsEntry(newsId);
	}
	
	public List<NewsEntry> search(SearchRequest searchRequest){
		List<NewsEntry> tempList = repository.searchNewsEntry(searchRequest);
    	Collections.sort(tempList);
    	Collections.reverse(tempList);
		return tempList;
	}
}
