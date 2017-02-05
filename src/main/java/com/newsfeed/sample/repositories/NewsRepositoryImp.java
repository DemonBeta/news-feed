package com.newsfeed.sample.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.newsfeed.sample.data.entities.NewsEntry;

@Repository
public class NewsRepositoryImp implements NewsRepository {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<NewsEntry> getAllNews() {
		return entityManager.createQuery("select a from NewsEntry a", NewsEntry.class)
                .getResultList();
	}

	@Override
	public NewsEntry getNewsEntry(Long id) {
		return entityManager.find(NewsEntry.class, id);
	}

	@Override
	public Long createNewsEntry(NewsEntry newsEntry) {
		entityManager.persist(newsEntry);
		return null;
	}

	@Override
	public int deleteNewsEntry(Long id) {
		entityManager.remove(getNewsEntry(id));
		return 1;
	}

	@Override
	public void updateNewsEntry(NewsEntry newsEntry) {
		entityManager.merge(newsEntry);
	}
}
