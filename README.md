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
1. Import url_shortener DB into MySQL workbeanch
  * [url_shortener_hibernate_sequence.sql](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/url_shortener_hibernate_sequence.sql)
  * [url_shortener_urlshortener.sql](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/url_shortener_urlshortener.sql)
2. Download urlshortener-0.0.1-SNAPSHOT.war
  * [urlshortener-0.0.1-SNAPSHOT.war](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/urlshortener-0.0.1-SNAPSHOT.war)
3. Open command prompt ececute the command - java -jar urlshortener-0.0.1-SNAPSHOT.war
4. Launch application with http://localhost:8080/

### Few examples of URL's
- https://www.amazon.com
- http://www.flipkart.com
- www.snapdeal.com
- www.amazon.com/{path-parameters}
- www.amazon.com?{query-parameters}

### Screenshots

1. Screenshot 1 : Landing Screen
![alt text](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/URLScreen_1.PNG)

2. Screenshot 2 : Success Screen
![alt text](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/URLScreen_2.PNG)

3. Screenshot 3 : Error Screen
![alt text](https://github.com/mujjasimkhan/urlshortener-war/blob/91cec0c11f540942191fedff38269f7a661cd71d/URLScreen_3.PNG)
