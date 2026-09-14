# Day 2 Curriculum: Relational Databases, Advanced JPA, and N-Tier Architecture (6 Hours)

## Session 1: Relational Databases & SQL Crash Course (1.5 Hours)
- **Why Do We Need a Database?**
  - Reiterate Volatility (RAM is wiped identically to turning off a computer).
  - Introduction to Non-volatile storage (Hard Drives) and how Databases interact with them cleanly.
- **Relational vs NoSQL Databases**
  - Why relational structures (PostgreSQL, MySQL, Oracle, H2) rule the enterprise.
  - Designing a strict Table Schema (Rows, Columns, Data Types).
- **SQL (Structured Query Language) Refresher**
  - Writing raw database queries: `SELECT * FROM students WHERE age > 18;`
  - Explaining the Big 4: `INSERT`, `SELECT`, `UPDATE`, `DELETE`.
  - *Exercise (30 min):* Let students open a simple online SQL terminal (or use the built in H2 engine) to manually write 5 queries to solidify their understanding before we let Java auto-generate them.
- **The Concept of Primary Keys**
  - Why UUIDs or auto-incrementing Numbers are essential to uniquely identify records instead of volatile fields like First Names.

## Session 2: ORM and Spring Data JPA (1.5 Hours)
- **The Problem with Raw JDBC in Java**
  - Exhibit the 50 lines of boilerplate Java code required to open an SQL connection, securely draft a string query, extract a `ResultSet`, and finally catch multiple `SQLExceptions`.
  - Introduce SQL Injection vulnerabilities (Bobby Tables!).
- **Enter ORM (Object-Relational Mapping)**
  - Bridging the gap: Java is strictly Object-Oriented; Databases are highly Relational.
  - **JPA (API Rules) vs Hibernate (The Engine Implementation).**
- **Building the `@Entity`**
  - Create the `Student.java` inside an `entity` package.
  - 🧠 *Deep Dive:* The `@GeneratedValue(strategy = GenerationType.IDENTITY)` tag. Why assigning an `id` manually in code causes terrifying race conditions when 1,000 students hit the API simultaneously, and how pushing that responsibility directly onto the Database engine ensures millisecond perfect uniqueness.
- **The Magic of Interfaces (`@Repository`)**
  - Create `StudentRepository` extending `JpaRepository`.
  - Show how Spring parses English method names into live SQL: `findByNameAndAgeGreaterThan(String name, int age)` automatically becomes `SELECT * WHERE name=? AND age>?`.
  - *Exercise (20 min):* Students will build 1 complex Entity with 5 fields and 1 functional Repository.

## Session 3: Validating Data and DTO Architecture (1.5 Hours)
- **🧠 Deep Dive: Data Transfer Objects (DTOs)**
  - Why we strongly recommend **NEVER** exposing Database Entities (Tables) directly to the Web API via `@RequestBody`.
  - Example: A Student entity might have a secret `private boolean isAdmin` or `private double feesOwed` column. If a malicious student reverse-engineers the JSON payload and pushes `{"isAdmin": true, "feesOwed": 0.0}`, the Entity architecture blindly persists it.
  - Solution: A dummy `StudentDTO.java` class possessing only safe frontend fields.
- **Data Validation (`@Valid`)**
  - Invalid inputs corrupt databases.
  - Introduce the Spring Boot Validation starter library.
  - Tag DTO fields with `@NotBlank(message="Name is required")` and `@Min(1)`.
  - Place `@Valid` directly in the `@PostMapping` Controller method.
  - *Exercise (40 min):* Students heavily secure their endpoints with DTOs and Validation limits. Test extensively via Postman by sending invalid fields and observing Spring intercept the 400 Bad Request error automatically.

## Session 4: Standard N-Tier Architecture & The `@Service` Layer (1.5 Hours)
- **Why controllers shouldn't touch Databases**
  - Currently, we injected `StudentRepository` directly into `StudentController`. This egregiously violates the Single Responsibility Principle for complex enterprise apps.
- **The N-Tier Model (Controller -> Service -> Repository -> Database)**
  - **Controller Layer:** Specifically routes HTTP traffic and speaks JSON. Contains zero business logic!
  - **Service Layer:** The heaviest Java layer. Contains mathematical processes, email integrations, logic validations, and algorithms.
  - **Repository Layer:** Strictly interfaces with the specific dialect of the physical Database.
- **🧠 Deep Dive: Dependency Injection (Inversion of Control) & Beans**
  - Introduce the `@Service` annotation.
  - Explain how Spring Boot constructs reusable objects (called **"Beans"**) and places them into an overarching application bucket at startup.
  - **The `@Autowired` Keyword:** Explain that when classes need another class to function, they "inject" that dependency. Historically, developers placed `@Autowired` above their variables. However, modern Spring natively auto-wires any Bean directly entirely through the Constructor without needing the `new` keyword anywhere!
- **End-to-End Implementation Lab:**
  - Let students refactor their entire codebase into standard 4-package architecture (`controller/`, `service/`, `repository/`, `dto/`).
  - Route flow: `POST /api/students` -> `StudentController` -> `studentService.registerStudent(dto)` -> `repository.save(entity)`.
  - **Seeing the Final Database physically:** Walk students through hitting `http://localhost:8080/h2-console`, securely authenticating to `jdbc:h2:mem:studentdb` with user `sa`, and running `SELECT * FROM student;` to visually prove their Java DTO translated to physical data.
