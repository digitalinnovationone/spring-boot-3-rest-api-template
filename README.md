# DIO Spring Boot RESTful API Template

Welcome to the DIO Spring Boot RESTful API Template! This project serves as a foundational template for creating RESTful APIs using Spring Boot 3, Spring Data JPA, and OpenAPI (Swagger). We have utilized the power of Java 17, the latest LTS version of Java, to build this project. 

As an edtech company, DIO is committed to providing valuable resources for developers and this project is no exception. It stands as a quick start guide to jump-start your API development with the best practices embedded.

## Key Features:

- **Spring Boot 3**: An upgraded version of Spring Boot, enhancing developer productivity with its auto-configuration feature.
- **Spring Data JPA**: Simplifying the database access layer by reducing the boilerplate code.
- **OpenAPI (Swagger)**: Integrated with OpenAPI 3, enabling seamless API documentation for better understanding and testing.
- **Java 17**: Leveraging the latest LTS version of Java, improving readability and efficiency.

## Project Details:

The project focuses on a Game API as an example, including basic CRUD operations and a voting system. It follows the best practices of RESTful principles, including idempotent operations and the use of proper HTTP status codes.

Exception handling is managed globally with a `ControllerAdvice` to handle exceptions consistently across the entire application. 

The project also includes the setup for a H2 database, an in-memory database for testing purposes.

## OpenAPI Documentation:

We have documented all APIs using OpenAPI 3 annotations. You can access the API documentation by launching the application and navigating to `/swagger-ui.html`.

## Getting Started:

To get started, clone this project and import it to your favorite IDE. The project uses Gradle as a build tool and it requires Java 17.

Run the application and navigate to `localhost:8080/swagger-ui.html` to explore the APIs.

This project is intended to be a starting point for your applications. Feel free to modify and expand upon it to suit your needs.

We hope this project provides a helpful start to your RESTful API journey with Spring Boot 3. Happy coding!
