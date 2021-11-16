package com.mk.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;

import com.mk.urlshortener.model.URLShortener;

public interface UrlRepository extends CrudRepository<URLShortener, Integer> {

}
