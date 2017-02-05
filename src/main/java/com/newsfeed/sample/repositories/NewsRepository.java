package com.newsfeed.sample.repositories;

import java.util.List;

import com.newsfeed.sample.data.entities.NewsEntry;

public interface NewsRepository {

	List<NewsEntry> getAllNews();
	
	NewsEntry getNewsEntry(Long id);

    Long createNewsEntry(NewsEntry newsEntry);

    int deleteNewsEntry(Long id);

    void updateNewsEntry(NewsEntry newsEntry);	
}
