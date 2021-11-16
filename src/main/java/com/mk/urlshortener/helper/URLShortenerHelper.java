package com.mk.urlshortener.helper;

import java.util.Random;

public class URLShortenerHelper {
	private String domain;
	private char allChars[];
	private Random randValue;
	private int keyLength;

	public URLShortenerHelper() {
	}

	public void initilizeRandomChars() {
		randValue = new Random();
		allChars = new char[62];
		for (int i = 0; i < 62; i++) {
			int j = 0;
			if (i < 10) {
				j = i + 48;
			} else if (i > 9 && i <= 35) {
				j = i + 55;
			} else {
				j = i + 61;
			}
			allChars[i] = (char) j;
		}
	}

	public URLShortenerHelper(int length, String newDomain) {
		this.keyLength = length;
		if (!newDomain.isEmpty()) {
			newDomain = sanitizeURL(newDomain);
			domain = newDomain;
		}
	}

	/**
	 * Reads original URL and check for http and https, and convert it to short URL.
	 * 
	 * @param longURL original URL
	 * @return shortURL shortened URL
	 */
	public String shortenURL(String longURL) {
		String shortURL = "";
		if (longURL != null) {
			initilizeRandomChars();
			shortURL = domain + "/" + generateKey();
		}
		return shortURL;
	}

	/**
	 * Reads original URL and check for http/https and returns only url
	 * 
	 * @param longURL original URL
	 * @return shortURL shortened URL
	 */
	public String sanitizeURL(String url) {
		if (url.substring(0, 7).equals("http://"))
			url = url.substring(7);

		if (url.substring(0, 8).equals("https://"))
			url = url.substring(8);

		if (url.charAt(url.length() - 1) == '/')
			url = url.substring(0, url.length() - 1);
		return url;
	}

	private String generateKey() {
		String key = "";
		boolean flag = true;
		while (flag) {
			key = "";
			for (int i = 0; i < keyLength; i++) {
				key += allChars[randValue.nextInt(62)];
			}
			if (key.length() == keyLength)
				flag = false;
		}
		return key;
	}
}
