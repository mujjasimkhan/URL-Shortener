package com.mk.urlshortener.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.urlshortener.helper.URLShortenerHelper;
import com.mk.urlshortener.model.URLRequestBean;
import com.mk.urlshortener.model.URLShortener;
import com.mk.urlshortener.repository.UrlRepository;

@RestController
public class URLShortenerResource {
	@Autowired
	private UrlRepository urlRepository;

	/**
	 * POST call: Body has original URL to convert to short URL. Check if original
	 * URL is present in the DB, if present pull the record and send it user if URL
	 * is not present in the DB convert the URL to short URL and save to DB.
	 * 
	 * @param urlRequestBean
	 * @return URLShortener has ID, Original URL and Shortened URL
	 */
	@PostMapping(value = "/urlshortener", produces = MediaType.APPLICATION_JSON_VALUE)
	public URLShortener getShortnedUrl(@RequestBody URLRequestBean urlRequestBean) {
		URLShortener urlObj;
		URLShortenerHelper urlShortenerHelperObj;
		String shortenedUrl;

		String originalUrl = urlRequestBean.getOriginalUrl();
		String sanitizeOriginalURL = new URLShortenerHelper().sanitizeURL(originalUrl);
		try {
			URLShortener shortenedUrlList = urlRepository.findByShortenedUrl(sanitizeOriginalURL);
			if (shortenedUrlList == null) {
				urlShortenerHelperObj = new URLShortenerHelper(5, "www.mk.com/");
				shortenedUrl = urlShortenerHelperObj.shortenURL(originalUrl);
				urlObj = new URLShortener();
				urlObj.setShortenedUrl(shortenedUrl);
				urlObj.setUrl(sanitizeOriginalURL);
				return urlRepository.save(urlObj);
			} else {
				return shortenedUrlList;
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to perform DB operation");
		}

	}
}
