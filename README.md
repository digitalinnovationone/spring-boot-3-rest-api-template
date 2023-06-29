# DIO Spring Boot RESTful API Template

Welcome to the DIO Spring Boot RESTful API Template! This project serves as a foundational template for creating RESTful
APIs using Spring Boot 3, Spring Data JPA, and OpenAPI (Swagger). We have utilized the power of Java 17, the latest LTS
version of Java, to build this project.

As an edtech company, DIO is committed to providing valuable resources for developers and this project is no exception.
It stands as a quick start guide to jump-start your API development with the best practices embedded.

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

## Key Features:

- **Java 17**: Leveraging the latest LTS version of Java, improving readability and efficiency.
- **Spring Boot 3**: An upgraded version of Spring Boot, enhancing developer productivity with its auto-configuration
  feature.
- **Spring Data JPA**: Simplifying the database access layer by reducing the boilerplate code.
- **OpenAPI (Swagger)**: Integrated with OpenAPI 3, enabling seamless API documentation for better understanding and
  testing.

## Setup

These instructions will provide users with the necessary steps to clone the repository and start the application in
different environments (Unix and Windows) with the development profile enabled.

1. Clone the repository: git clone https://github.com/digitalinnovationone/spring-boot-3-rest-api-template.git
2. Start the application in the Unix environment: ./gradlew bootrun --args='--spring.profiles.active=dev'
3. Start the application in the Windows environment: gradle.bat bootrun --args='--spring.profiles.active=dev'

## Project Details:

The project focuses on a Game API as an example, which includes basic CRUD operations and a voting system. It adheres to the best practices of RESTful principles, such as idempotent operations and the use of appropriate HTTP status codes.

Exception handling is globally managed with a `RestControllerAdvice to ensure consistent handling of exceptions throughout the entire application.

The project also includes the setup for an H2 database (an in-memory database) for testing purposes and development environment. For the production environment on Railway, PostgreSQL database is used.

## API Usage

### GET /games

- Description: Get all games
- Response:
  - Status: 200 OK
  - Content-Type: application/json
  - Body:

    ```json
    [
      {
        "id": 1,
        "name": "Game Name",
        "votes": 5,
        "version": 1
      },
      {
        "id": 2,
        "name": "Another Game",
        "votes": 3,
        "version": 1
      }
    ]
    ```

### GET /games/{id}

- Description: Get a game by ID
- Response:
  - Status: 200 OK
  - Content-Type: application/json
  - Body:

    ```json
    {
      "id": 1,
      "name": "Game Name",
      "votes": 5,
      "version": 1
    }
    ```

  - Status: 404 Not Found (if the game is not found)

### POST /games

- Description: Create a new game
- Request Body:
  - Content-Type: application/json
  - Body:

    ```json
    {
      "name": "New Game",
      "votes": 0
    }
    ```

- Response:
  - Status: 201 Created
  - Content-Type: application/json
  - Body:

    ```json
    {
      "id": 3,
      "name": "New Game",
      "votes": 0,
      "version": 1
    }
    ```

  - Status: 422 Unprocessable Entity (if invalid game data is provided)

### PUT /games/{id}

- Description: Update a game
- Request Body:
  - Content-Type: application/json
  - Body:

    ```json
    {
      "name": "Updated Game",
      "votes": 10
    }
    ```

- Response:
  - Status: 200 OK
  - Content-Type: application/json
  - Body:

    ```json
    {
      "id": 3,
      "name": "Updated Game",
      "votes": 10,
      "version": 2
    }
    ```

  - Status: 404 Not Found (if the game is not found)
  - Status: 422 Unprocessable Entity (if invalid game data is provided)

### DELETE /games/{id}

- Description: Delete a game
- Response:
  - Status: 204 No Content
  - Status: 404 Not Found (if the game is not found)

### POST /games/{id}/vote

- Description: Vote for a game
- Response:
  - Status: 204 No Content
  - Status: 404 Not Found (if the game is not found)

## Swagger Documentation

The API documentation can be found on Swagger. To view it, please visit: [Swagger Documentation](http://localhost:8080/swagger-ui/index.htm).

## Hosting on Railway.app

This project is hosted on Railway.app. To access the application, visit: [Application URL](https://sua-url-de-hospedagem-aqui).

## Contribution

Contributions are welcome! If you encounter any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. Please refer to
the <a href="https://github.com/cami-la/url-shortener-preview/blob/3eb25645b0ca1a1ee8bd8b5de947c11f5a6d42ba/LICENSE.md">(
LICENSE)</a> file for details.
<hr>

## Authors

- [Camila Cavalcante](https://www.linkedin.com/in/cami-la/)
  ![Camila Cavalcante](https://avatars.githubusercontent.com/u/64323124?v=4&s=100)

- [Venilton FalvoJr](https://www.linkedin.com/in/falvojr/)
  ![Venilton FalvoJr](https://avatars.githubusercontent.com/u/730492?v=4&s=100)