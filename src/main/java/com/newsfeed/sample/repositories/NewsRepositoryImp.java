package com.newsfeed.sample.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.newsfeed.sample.data.entities.NewsEntry;
import com.newsfeed.sample.data.entities.SearchRequest;

@Repository
public class NewsRepositoryImp implements NewsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<NewsEntry> getAllNews() {
		return entityManager.createQuery("select a from NewsEntry a", NewsEntry.class).getResultList();
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

	@Override
	public List<NewsEntry> searchNewsEntry(SearchRequest searchRequest) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<NewsEntry> criteria = builder.createQuery(NewsEntry.class);
		Root<NewsEntry> newsEntry = criteria.from(NewsEntry.class);

		if ((searchRequest.getTag() != null) && (!searchRequest.getTag().toLowerCase().equals("any tag"))) {
			predicates.add(builder.like(newsEntry.<String>get("tag"), searchRequest.getTag()));
		}

		if ((searchRequest.getHeader() != null) && (!searchRequest.getHeader().equals(""))) {
			predicates.add(builder.like(newsEntry.get("header"), "%" + searchRequest.getHeader() + "%"));
		}
		
		if ((searchRequest.getContent() != null) && (!searchRequest.getContent().equals(""))) {
			predicates.add(builder.like(newsEntry.get("content"), "%" + searchRequest.getContent() + "%"));
		}
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.select(newsEntry);

		TypedQuery<NewsEntry> query = entityManager.createQuery(criteria);
		List<NewsEntry> list = query.getResultList();

		return list;
	}
}
