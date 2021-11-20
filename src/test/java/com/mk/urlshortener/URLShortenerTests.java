package com.mk.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mk.urlshortener.helper.URLShortenerHelper;

@SpringBootTest
class URLShortenerTests {
	
	private String mockUrl = "www.mock.com";
	private int mockKeyLength = 5;
	private URLShortenerHelper objUrlShortenerHelper = new URLShortenerHelper(mockKeyLength, mockUrl);
	private String mockOriginalUrl = "www.shortthisurl.com";


	@Test
	void shortenURLTest() {
		String generatedUrl = objUrlShortenerHelper.shortenURL(mockOriginalUrl);
		assertEquals(generatedUrl.substring(0, 12), mockUrl);
		assertEquals(generatedUrl.substring(13, 18).length(), mockKeyLength);
	}
	
	@Test
	void sanitizeURLTest_for_https() {
		String generatedUrl = objUrlShortenerHelper.sanitizeURL("https://www.shortthisurl.com");
		assertEquals(generatedUrl, mockOriginalUrl);
	}
	
	@Test
	void sanitizeURLTest_for_http() {
		String generatedUrl = objUrlShortenerHelper.sanitizeURL("http://www.shortthisurl.com");
		assertEquals(generatedUrl, mockOriginalUrl);
	}

}
