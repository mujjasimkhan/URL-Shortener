package com.mk.urlshortener.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResource {

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
