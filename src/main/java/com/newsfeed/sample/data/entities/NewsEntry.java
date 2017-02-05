package com.newsfeed.sample.data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class NewsEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long newsId;

	@NotBlank(message = "You must provide a description")
	private String header;

	private String tag;

	@Lob
	@NotBlank(message = "You must provide a description")
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	@PrePersist
	void createdAt() {
		this.postDate = new Date();
	}

	@PreUpdate
	void updatedAt() {
		this.postDate = new Date();
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getType() {
		return tag;
	}

	public void setType(String type) {
		this.tag = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "NewsEntry [newsId=" + newsId + ", header=" + header + ", type=" + tag + ", content=" + content
				+ ", postDate=" + postDate + "]";
	}
}
