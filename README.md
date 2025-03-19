# TinyURL - URL Shortening Service

## Description

This is a URL shortening service similar to TinyURL. Only the HTTP API needs to be implemented, with the following main tasks:

## Main Tasks:

- **[a]** Develop the application using Spring Boot.
- **[b]** Accept long URLs as input and return shortened URLs.
- **[c]** When accessing the service via a shortened URL in a browser, perform a redirect to the original URL.
- **[d]** Use PostgreSQL as the database.
- **[e]** Use Hibernate/JPA for database models.
- **[f]** Use Liquibase for database migrations.
- **[g]** Set up the development environment using Docker/Docker Compose.
- **[h]** Write tests and set up GitHub CI.

## ## Running the Project

To build and run the project using Docker, follow these steps:

### 1. Build the project
Run the following command to build the project and create the `.jar` file:

```bash
mvn clean package
```
### 2. Build and run Docker containers
```bash
docker-compose up --build -d
```

## Use case

### Creating a Short URL

To create a short URL, send a POST request to the following endpoint:

```http request 
POST http://localhost:8080/redirect
```

```json
{
  "url": "https://www.google.com"
}
```

### Redirecting to the Original URL

To access the original URL, send a GET request to the short URL:

```http request
GET http://localhost:8080/redirect/{URL}
```