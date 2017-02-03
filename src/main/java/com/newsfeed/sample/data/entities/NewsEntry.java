package com.newsfeed.sample.data.entities;

import java.util.Date;

public class NewsEntry {
	
	private Long newsId;

	private String header;
	
	private String type;
	
	private String content;
	
	private Date postDate;

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
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "NewsEntry [newsId=" + newsId + ", header=" + header + ", type=" + type + ", content=" + content
				+ ", postDate=" + postDate + "]";
	}
}
