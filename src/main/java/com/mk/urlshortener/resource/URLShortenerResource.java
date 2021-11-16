package com.mk.urlshortener.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.urlshortener.model.URLRequestBean;

@RestController
public class URLShortenerResource {

    @PostMapping(value = "/urlshortener", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getShortnedUrl(@RequestBody URLRequestBean urlRequestBean) {
		return "success";
    }
}
