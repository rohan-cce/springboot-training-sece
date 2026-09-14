# Day 2: Relational Databases & N-Tier Architecture (Trainer Script)

## Session 1: Relational Databases & SQL Crash Course (1.5 Hours)

### 1. Fixing Volatility with Non-Volatile Storage
> **What to say:** "Welcome to Day 2! Yesterday, we suffered catastrophic data loss when we restarted the server. Why? Because regular Java variables sit in RAM, which instantly evaporates on shutdown. Today, we fix this permanently by introducing Non-Volatile Storage architecture: **The Relational Database**. Databases write your data safely down into massive physical hard drives organized logically into distinct Rows and Columns."

### 2. The SQL Deep Dive
> **What to say:** "To speak to a database, you cannot use Java. You must use a mathematical language called SQL. For example, if I want to insert data, I legitimately have to write `INSERT INTO students (name, age) VALUES ('Rohan', 21)`. 
> 
> *However*, managing huge raw string queries inside Java code is vulnerable, highly disorganized, and frankly terrible for maintenance. We need a bridge between our Java Classes and SQL Tables. Enter **Object-Relational Mapping (ORM)** and **JPA**."

## Session 2: ORM, JPA and Stereotypes (1.5 Hours)

### 1. The `@Entity` and Identifiers
> **What to say:** "With JPA, we can just code in standard Java! We simply place the sticky note `@Entity` directly on top of our `Student` class. The framework automatically converts that Java class physically into a raw SQL database table.
> Let's look at the Primary Key. Why do we rigorously use `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)`? Because if 1,000 students hit 'Register' on your website at the exact same millisecond, and we calculated IDs manually in Java, they would crash creating identical IDs. By passing that structural responsibility entirely over to the Database engine itself, we mathematically guarantee millisecond-perfect unique uniqueness!"

### 2. Repository Stereotypes and Magic Queries
> **What to say:** "Now we need a tool to fetch our Entities. We do this by building a customized interface using the `@Repository` stereotype. Think of stereotypes exactly like military ranks. `@Component` is a generic soldier. But `@Repository` is a specialized Sniper. When Spring sees it, it grants it proprietary database exception-handling powers.
> The craziest part about Spring Data repositories? **Magic Methods!** You can literally type `List<Student> findByAgeGreaterThan(18)` in pure english, and Spring will physically generate the `SELECT * WHERE age > 18` SQL code for you completely under the hood!"

## Session 5: Live Troubleshooting & Missing Bean Crash Lab (1.0 Hour)
*(Tutor Note: Before class starts, ensure that `@Service` is completely commented out inside `StudentService.java`. When you start the Spring Boot application locally in front of them, it will violently crash. Use this to actively teach them how to confidently read Java Stack Traces!)*

### 1. The ApplicationContext Error
> **What to say:** "Do not panic when your terminal explodes in red text! This is called a Stack Trace, and it is a developer's best friend. Look closely at the error message: `Parameter 0 of constructor in StudentController required a bean of type 'StudentService' that could not be found.` 
> 
> What does this mean? It means our `StudentController` demanded a `StudentService` object through Dependency Injection, but Spring's internal component bucket (the ApplicationContext) was entirely empty!"

### 2. Diagnosing and Fixing the Root Cause
> **What to say:** "Let's investigate `StudentService.java`. Why didn't Spring create the Bean for us? Because it is missing its structural sticky note! Because we removed the `@Service` annotation above the class, Spring's `@ComponentScan` completely ignored this file during startup. It had absolutely no idea it was supposed to build it. Restore the `@Service` annotation, restart the server, and watch how it boots flawlessly!"

## Session 6: Advanced JPA Mappings & Custom Queries (1.5 Hours)

### 1. `ManyToOne` Relational Mappings
> **What to say:** "What if an application has two distinctly different tables, like `Student` and `Department`? Relational mapping links them permanently. If hundreds of Students structurally belong to exactly one University Department, we rigorously map them utilizing `@ManyToOne`. We physically enforce this in the database using a Foreign Key constraint—using `@JoinColumn(name = 'department_id')` so the student row permanently knows exactly which department bucket it belongs to!"

### 2. The INNER JOIN vs LEFT JOIN Truth
> **What to say:** "Now for the big question: How does the Database physically retrieve the string 'Computer Science' if our Student row only stores `department_id = 4`? We must write complex SQL Joins.
> 
> If we write an `INNER JOIN`, the system organically fuses the two tables horizontally, yielding a perfect combined row. But beware the **Edge Case**: What happens if a brand new 1st-year student hasn't officially declared a department yet, meaning their `department_id` is totally null? An `INNER JOIN` violently drops them from all database search results blindly! To resolve this, we switch to a `LEFT JOIN`. This safely retrieves the entire roster of students unconditionally, simply outputting `NULL` strictly for their missing department column."

## Session 4: DTOs, Security & Global Exceptions (1.5 Hours)

### 1. Securing with DTOs and Validation
> **What to say:** "As professional architects, we *never* expose our raw Database `@Entity` objects directly to the Web Controller API. If a hacker reverse-engineers the JSON payload, they could inject malicious values straight into hidden database columns like `feesOwed = 0`. 
> 
> To protect the database, we build a **Data Transfer Object (DTO)**. This is just a 'dummy shell' class possessing only safe frontend fields. You lock it down heavily using `@Valid` annotations like `@NotBlank`. If someone provides a negative age, Spring instantly rejects the payload mathematically before it even reaches the database!"

### 2. Global Exception Handling
> **What to say:** "If a validation uniquely fails, Tomcat throws a massive, horrifying HTML stack trace back to the user interface. That is terrible application UX! We need to intercept those crashes gracefully. We do this by architecting a `GlobalExceptionHandler` and pasting the `@ControllerAdvice` sticker on it. This class operates like a giant net hovering entirely over our application. The split-second an exception throws anywhere, this class catches it dynamically and reformats it cleanly into a structured, peaceful JSON Map returning `{\"error\": \"Age must be greater than zero\"}`!"
