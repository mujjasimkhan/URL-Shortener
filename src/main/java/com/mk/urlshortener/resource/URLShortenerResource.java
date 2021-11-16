package com.mk.urlshortener.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.urlshortener.model.URLRequestBean;
import com.mk.urlshortener.model.URLShortener;
import com.mk.urlshortener.repository.UrlRepository;

@RestController
public class URLShortenerResource {
	@Autowired
    private UrlRepository urlRepository;
   
    @PostMapping(value = "/urlshortener", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getShortnedUrl(@RequestBody URLRequestBean urlRequestBean) {
        URLShortener urlObj = new URLShortener();
        String originalUrl = urlRequestBean.getOriginalUrl();
        urlObj.setUrl(originalUrl);
        urlObj.setShortenedUrl("www.mk.com/abc134");
       
        if(urlRepository.save(urlObj) != null) {
        	return "success";
        } else {
        	return "fail";
        }
        
    }
}
