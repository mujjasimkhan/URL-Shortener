package com.mk.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URLShortener {

	public URLShortener() {
		
	}
	public URLShortener(Integer urlId, String shortenedUrl, String url) {
		super();
		this.urlId = urlId;
		this.shortenedUrl = shortenedUrl;
		this.url = url;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer urlId;
	private String shortenedUrl;
	private String url;

	public Integer getUrlId() {
		return urlId;
	}

	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}

	public String getShortenedUrl() {
		return shortenedUrl;
	}

	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "URLBean{" +
				"urlId=" + urlId +
				", shortenedUrl='" + shortenedUrl + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
