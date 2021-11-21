package com.mk.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import com.mk.urlshortener.model.URLShortener;
import com.mk.urlshortener.repository.UrlRepository;
import com.mk.urlshortener.resource.URLShortenerResource;

@RunWith(SpringRunner.class)
@WebMvcTest(value = URLShortenerResource.class)
public class URLShortenerResourceTests {
	
	String mockRequest = "{\"originalUrl\":\"www.mock.com\"}";
	String mockResponse = "{\"url\":\"www.mock.com\",\"shortenedUrl\":\"www.mock.com\\\\mockkey\"}";
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UrlRepository mockUrlRepository;

	@Test
	public void getShortnedUrl_newURL() throws Exception {

		URLShortener mockURLShortener = new URLShortener();
		mockURLShortener.setUrlId(1);
		mockURLShortener.setUrl("www.mock.com");
		mockURLShortener.setShortenedUrl("www.mock.com"+"\\"+"mockkey");

		Mockito.when(mockUrlRepository.findByShortenedUrl(Mockito.anyString())).thenReturn(null);
		Mockito.when(mockUrlRepository.save(Mockito.any())).thenReturn(mockURLShortener);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/urlshortener").accept(MediaType.APPLICATION_JSON)
				.content(mockRequest).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(result.getResponse().getStatus(), 200);
		JSONAssert.assertEquals(mockResponse, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getShortnedUrl_execistingURL() throws Exception {
		
		URLShortener mockURLShortener = new URLShortener();
		mockURLShortener.setUrlId(1);
		mockURLShortener.setUrl("www.mock.com");
		mockURLShortener.setShortenedUrl("www.mock.com"+"\\"+"mockkey");

		Mockito.when(mockUrlRepository.findByShortenedUrl(Mockito.anyString())).thenReturn(mockURLShortener);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/urlshortener").accept(MediaType.APPLICATION_JSON)
				.content(mockRequest).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(result.getResponse().getStatus(), 200);
		JSONAssert.assertEquals(mockResponse, result.getResponse().getContentAsString(), false);
	}

}
