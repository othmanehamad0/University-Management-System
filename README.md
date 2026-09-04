# University Management System


A Spring Boot backend that models the core academic and administrative operations of a university: students, professors, courses, enrollments, grades, attendance, exams, the library, clubs, payments, and scholarships. It's built as a full JPA domain model with a business-logic service layer, custom validation utilities, and unit tests for key services.

## Features

14-entity relational domain model covering students, professors, departments, courses, enrollments, grades, exams, attendance, library books & loans, clubs & memberships, payments, and scholarships
- **Rich JPA relationships** — one-to-many, many-to-one, and many-to-many (e.g. students ↔ clubs) including a composite-key join entity (`StudentClub` / `StudentClubId`) for extra membership data like join date
- **Service layer** per domain area, encapsulating queries (by department, enrollment date, email, gender, etc.) and business rules rather than exposing raw repositories
- **Centralized validation utilities** (`ServiceValidation`, `StudentValidator`, `BookValidator`) reused across services for consistent input checking
- **Unit tests** (JUnit 5) for the Student, Book, Club, and Attendance services
- **Spring Security & Actuator** already wired into the dependency graph, ready for authentication and health/monitoring endpoints
- **Schema script generation** — Hibernate is configured to emit a `create.sql` DDL script from the JPA metadata, useful for reviewing the schema before deploying

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1.0 (Web MVC, Data JPA, Validation, Security, Actuator) |
| Database | MySQL |
| Build | Maven |
| Other | Lombok, JUnit 5 |

## Domain Model

| Entity | Purpose |
|---|---|
| `Students` | Student profile, contact info, department & advisor links |
| `Professors` | Faculty profile, department, salary, hire date |
| `Departments` | Academic departments (budget, building) |
| `Courses` | Course catalog — credit hours, semester, teaching professor |
| `Enrollments` | Student ↔ Course registrations with status |
| `Grades` | Marks and letter grades per exam |
| `Exams` | Exams per course (type, date, total marks) |
| `Attendance` | Per-course, per-day attendance status |
| `Books` / `LibraryLoans` | Library catalog and loan/return tracking |
| `Clubs` / `StudentClub` | Student clubs and membership (with join date) |
| `Payments` | Student tuition/fee payments |
| `Scholarships` | Scholarship awards per student |

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/university/management/
│   │   │   ├── entity/         # 14 core JPA entities + enums
│   │   │   ├── repository/     # Spring Data JPA repositories (1 per entity)
│   │   │   ├── service/        # Business logic per domain area
│   │   │   ├── validation/     # Shared validation utilities
│   │   │   └── UniversityManagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/university/management/
│           ├── StudentServiceTest.java
│           ├── BookServiceTest.java
│           ├── ClubServiceTest.java
│           └── AttendanceServiceTest.java
├── pom.xml
└── mvnw / mvnw.cmd
```

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.9+ (or use the included `./mvnw` wrapper)
- MySQL 8+ running locally

### Configuration

Update `src/main/resources/application.properties` with your own database connection details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/univ_pr_db
spring.datasource.username=root
spring.datasource.password=your_password
```

> **Tip:** the schema-export path (`jakarta.persistence.schema-generation.scripts.create-target`) is currently set to a local Windows path — update it to a path on your machine, or remove that block if you don't need the generated `create.sql`. It's also worth moving the DB password to an environment variable before this is shared or deployed anywhere.

### Run

```bash
git clone <repo-url>
cd demo
./mvnw spring-boot:run
```

The application starts on **http://localhost:8080**.

## Testing

```bash
./mvnw test
```

Runs the existing unit test suite for the Student, Book, Club, and Attendance services.

## Project Status

This version implements the **data and service layer** — entities, repositories, business logic, and validation — without REST controllers yet. It's currently consumed directly through the service layer (as in the unit tests). Natural next steps:

- [ ] REST controllers to expose the service layer over HTTP
- [ ] Authentication/authorization on top of the existing Spring Security dependency
- [ ] Unit test coverage for the remaining services
- [ ] API documentation (OpenAPI/Swagger)

## License

No license file is included yet. Add one (e.g., MIT) if you plan to make this project public or open source.
