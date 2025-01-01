# Spring Boot Application

## Overview
This project is a Spring Boot application that demonstrates the use of MapStruct for object mapping and Lombok for reducing boilerplate code. It includes REST APIs for managing `Country` and `Company` entities, with DTOs used for communication between layers.

## Features
- RESTful APIs to manage `Country` and `Company` entities.
- Object mapping between entities and DTOs using MapStruct.
- Simplified code with Lombok annotations.

## Prerequisites
- Java 17 or later
- Maven Build and dependency management tool
- An IDE with support for Spring Boot (e.g., IntelliJ IDEA, Eclipse)

## Project Structure
```plaintext
src/
├── main/
│   ├── java/com/example/SpringBootApp/
│   │   ├── Controller/       # REST controllers
│   │   ├── DTOs/             # Data Transfer Objects (DTOs)
│   │   ├── Entities/         # Entity classes
│   │   ├── Mappers/          # MapStruct mappers
│   │   ├── Services/         # Service layer
│   └── resources/
│       ├── application.yml   # Configuration file
│       ├── static/           # Static resources
│       └── templates/        # HTML templates (if applicable)
└── test/
    └── java/com/example/SpringBootApp/
        ├── Controller/       # Controller tests
        ├── Mappers/          # Mapper tests
```

## Installation
1. Clone the repository:
   ```bash
   git clone
   cd spring-boot-app
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Configuration
Update the `application.yml` file in the `src/main/resources` directory if needed. This project does not require a database connection but can be extended to include one.

## How to Run
1. Start the application:
   ```bash
   mvn spring-boot:run
   ```
2. Access the APIs via:
   - `GET /api/countries` to fetch all countries
   - `POST /api/countries` to add a new country
   - `GET /api/companies` to fetch all companies
   - `POST /api/companies` to add a new company

## Technologies Used
- **Spring Boot**: Framework for building Java applications.
- **MapStruct**: Annotation-based object mapping framework.
- **Lombok**: Reduces boilerplate code with annotations.
- **Maven**: Build and dependency management tool.

## Example Usage
### Sample Request - Add a Country
```json
POST /api/countries
{
  "id": 1,
  "name": "United States",
  "isoCode": "US"
}
```

### Sample Response
```json
{
  "id": 1,
  "name": "United States",
  "isoCode": "US"
}
```

## Troubleshooting
### Common Issues
1. **MapStruct Implementation Not Generated**:
   Ensure the `maven-compiler-plugin` is configured with the MapStruct annotation processor in the `pom.xml`.
   ```xml
   <path>
       <groupId>org.mapstruct</groupId>
       <artifactId>mapstruct-processor</artifactId>
       <version>1.4.2.Final</version>
   </path>
   ```
2. **Dependency Injection Errors**:
   Verify that all required beans are annotated correctly (e.g., `@Mapper(componentModel = "spring")`).

## Testing
Run the tests using:
```bash
mvn test
```
Test cases include validation for DTO mapping and API endpoints.

## License
This project is licensed under the [Hazem Mosa](LICENSE).

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any changes or suggestions.

_________

