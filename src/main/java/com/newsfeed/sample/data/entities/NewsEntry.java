package com.newsfeed.sample.data.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class NewsEntry implements Comparable<NewsEntry>{

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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(postDate);
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "NewsEntry [newsId=" + newsId + ", header=" + header + ", tag=" + tag + ", content=" + content
				+ ", postDate=" + postDate + "]";
	}

	@Override
	public int compareTo(NewsEntry entry) {
		return getPostDate().compareTo(entry.getPostDate());
	}
}
