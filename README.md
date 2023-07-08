# DIO Spring Boot RESTful API Template

Welcome to the DIO Spring Boot RESTful API Template! This project serves as a foundational template for creating RESTful APIs using Spring Boot 3, Spring Data JPA, and OpenAPI (Swagger) for API documentation. We have utilized the power of Java 17, the latest LTS version of Java, to build this project.

As an edtech company, DIO is committed to providing valuable resources for developers and this project is no exception. It stands as a quick start guide to jump-start your API development with the best practices embedded.

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.1.0-brightgreen.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.1.214-darkblue.svg" />
    </a>
    <a alt="PostgreSQL">
        <img src="https://img.shields.io/badge/PostgreSQL-v42.6.0-blue.svg" />
    </a>
</p>

## Table of Contents

- [Key Features](#key-features)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Project Details](#project-details)
- [API Usage (Swagger UI Documentation)](#api-usage-swagger-ui-documentation)
- [Hosting on Railway.app](#hosting-on-railway)
- [Contribution](#contribution)
- [License](#license)
- [Authors](#authors)

## Key Features:

- **Java 17**: Leveraging the latest LTS version of Java, improving readability and efficiency.
- **Spring Boot 3**: An upgraded version of Spring Boot, enhancing developer productivity with its auto-configuration
  feature. Generated using [Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.1.1&packaging=jar&jvmVersion=17&groupId=me.dio&artifactId=spring-boot-3-rest-api-template&name=spring-boot-3-rest-api-template&description=DIO%20Spring%20Boot%20RESTful%20API%20Template&packageName=me.dio&dependencies=web,data-jpa,h2,postgresql).
- **Spring Data JPA**: Simplifying the database access layer by reducing the boilerplate code.
- **OpenAPI (Swagger)**: Integrated with OpenAPI 3, enabling seamless API documentation for better understanding and
  testing.

## Project Structure:

The project is organized into several packages, each serving a specific purpose:

- `controller`: This package contains our Rest Controllers. Here, we expose our endpoints, following the REST architectural style. DTOs are used in this layer to define the consumption interfaces appropriately, avoiding the exposure of unnecessary model attributes.

- `exception`: define our custom exceptions and a global exception handler for dealing with Spring's exceptions.

- `model`: where our entities are defined, using JPA (Jakarta) annotations for ORM with our SQL database.

- `repository`: In this package, we handle data access using interfaces provided by Spring Data JPA.

- `service`: where our business logic lives. Here we validate our data, handle business exceptions, and manage access to our SQL database through repositories.

- `Application.java`: This is the main class to run our project. It initializes our Spring application and connects all the components together.

Please note that this structure is a simple suggestion for educational purposes. Each developer is free to adapt and modify this structure according to their project needs and standards.

## Setup

These instructions guide you through cloning the repository and starting the application in Unix or Windows environments, with the development profile enabled.

1. Clone the repository: git clone https://github.com/digitalinnovationone/spring-boot-3-rest-api-template.git
2. Start the application in the Unix environment: `./gradlew bootrun --args='--spring.profiles.active=dev'`
3. Start the application in the Windows environment: `gradle.bat bootrun --args='--spring.profiles.active=dev'`

## Project Details:

The project focuses on a Heroes API as an example, which includes basic CRUD operations and gain experience (XP) system. It adheres to the best practices of RESTful principles, such as idempotent operations and the use of appropriate HTTP status codes.

Exception handling is globally managed with a `@RestControllerAdvice` to ensure consistent handling of exceptions throughout the entire application.

The project also includes the setup for an H2 database (an in-memory database) for testing purposes and development environment. For the production environment on Railway, PostgreSQL database is used.

## API Usage (Swagger UI Documentation)

The API documentation can be found on Swagger UI. To view it, please visit: [Swagger UI](http://localhost:8080/swagger-ui.html).

## Hosting on Railway

Both this project and your PostgreSQL database are hosted on [Railway.app](https://railway.app/). To access our demo application, visit:
- Development Environment: [https://[your-public-domain]-dev.up.railway.app/swagger-ui.html](https://heroes-api-veni-dev.up.railway.app/swagger-ui.html)
- Production Environment: [https://[your-public-domain]-prd.up.railway.app/swagger-ui.html](https://heroes-api-veni-prd.up.railway.app/swagger-ui.html)

## Contribution

We welcome contributions! If you encounter any issues or have suggestions for improvements, don't hesitate to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. Please refer to the <a href="https://github.com/digitalinnovationone/spring-boot-3-rest-api-template/blob/main/LICENSE.md">(LICENSE)</a> file for details.

## Authors

<table>
  <tr>
    <td align="center"><a href="https://github.com/falvojr"><img src="https://avatars.githubusercontent.com/u/730492?v=4&s=100" width="100px;" alt=""/><br/><strong>Venilton FalvoJr</strong></a><br/><a href="https://www.linkedin.com/in/falvojr/">LinkedIn</a></td>
    <td align="center"><a href="https://github.com/cami-la"><img src="https://avatars.githubusercontent.com/u/64323124?v=4&s=100" width="100px;" alt=""/><br/><strong>Camila Cavalcante</strong></a><br/><a href="https://www.linkedin.com/in/cami-la/">LinkedIn</a></td>
    <td align="center"><a href="https://github.com/rafaskb"><img src="https://avatars.githubusercontent.com/u/2331058?v=4&s=100" width="100px;" alt=""/><br/><strong>Rafa Skoberg</strong></a><br/><a href="https://www.linkedin.com/in/rafaskoberg/">LinkedIn</a></td>
  </tr>
</table>
