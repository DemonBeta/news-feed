package com.newsfeed.sample.repositories;

import java.util.List;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.data.entities.SearchRequest;

public interface NewsRepository {

	List<NewsEntry> getAllNews();
	
	NewsEntry getNewsEntry(Long id);

    Long createNewsEntry(NewsEntry newsEntry);

    int deleteNewsEntry(Long id);

    void updateNewsEntry(NewsEntry newsEntry);
    
    List<NewsEntry> searchNewsEntry(SearchRequest searchRequest);
}
