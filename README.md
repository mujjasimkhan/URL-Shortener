# URL-Shortener
<!-- ABOUT THE PROJECT -->
## About The Project

Build a URL shortener application without using any external service.
As a user I will be able to go to a page, type in a URL and get a short URL out of it. I will also
be shown all existing short URLs and the number of times it was used. When anyone opens
the short URL, they will be redirected to the initial URL that was used to generate a short
URL.
What is a Short URL?
A short URL, as the name suggests is a URL path which is not longer than 10 characters.
Something like http://localhost:8080/a83br5. The URL can be alpha-numeric and must be
unique for each input URL.


### Built With
* [Spring Boot](https://spring.io/projects/spring-boot)
* [React.js](https://reactjs.org/)
* [Bootstrap](https://react-bootstrap.netlify.app/getting-started/introduction/)
* [MySQL DB](https://www.mysql.com/)


### Prerequisites
1. Install JDK
2. Install Node.js(For react project)
3. Install MySQL server
4. Install MySQL workbeanch

### Steps to run the aplication
1. Import url_shortener DB into MySQL workbeanch(urlshortener-war/url_shortener_hibernate_sequence.sql and urlshortener-war/url_shortener_urlshortener.sql)
2. Download urlshortener-0.0.1-SNAPSHOT.war and open command prompt (urlshortener-war/urlshortener-0.0.1-SNAPSHOT.war)
3. In Command prompt ececute the command - java -jar urlshortener-0.0.1-SNAPSHOT.war
4. Launch application with http://localhost:8080/

### Few examples of URL's
- https://www.amazon.com
- http://www.flipkart.com
- www.snapdeal.com
- www.amazon.com/{path-parameters}
- www.amazon.com?{query-parameters}
