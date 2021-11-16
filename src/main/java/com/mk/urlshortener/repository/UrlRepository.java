package com.mk.urlshortener.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mk.urlshortener.model.URLShortener;

public interface UrlRepository extends CrudRepository<URLShortener, Integer> {

	/**
	 * Query to select record by email id
	 * 
	 * @param emailAddress
	 * @return URLShortener
	 */
	@Query(value = "SELECT * FROM urlshortener WHERE url = ?1", nativeQuery = true)
	URLShortener findByShortenedUrl(String emailAddress);
}
