package com.newsfeed.sample.data.entities;

public class SearchRequest {

	private String header;

	private String tag;

	private String content;

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

	@Override
	public String toString() {
		return "SearchRequest [header=" + header + ", tag=" + tag + ", content=" + content + "]";
	}
	
}
