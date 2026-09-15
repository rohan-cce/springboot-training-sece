# LEAP Day 2: Database Integration, JPA & CRUD

## 9. JDBC vs JPA – Why ORM? (8:40 am – 9:10 am)
> **What to say:** "Welcome back! Yesterday our internal RAM array was wiped clean when the server shut down. Today, we need a Database. Historically, writing Java code to talk to SQL required 'JDBC'—a horribly complex, buggy standard requiring 50 lines of code just to insert one row. 
> Today, we use **JPA (Java Persistence API)** and **ORM (Object-Relational Mapping)**. This technology lets us write zero SQL at all! We just hand a Java object to JPA, and it automatically generates the perfect SQL for us behind the scenes."

## 10. Database Configuration (9:10 am – 10:00 am)
> **What to say:** "Open your `pom.xml`, and add the `mysql-connector-j` dependency. Next, open your `application.yml` file. This is the central brain configuring our database credentials. Type your MySQL username and password here. When you start the app, Spring Boot automatically reaches inside your local computer, handshakes with MySQL natively, and secures the connection!"

## 11. JPA Entity & Repository (10:00 am – 11:15 am)
> **What to say:** "To connect a Java Class to a Database Table, we just paste the `@Entity` annotation on it! Now Spring organically transforms our Java file into a structured SQL Table natively. We strictly use `@Id` and `@GeneratedValue(strategy = GenerationType.IDENTITY)` to force the Database to self-manage primary key integer scaling, guaranteeing we never hit ID collision crashes natively! Next, we create a `StudentRepository` extending `JpaRepository`. This interface instantly gives us CRUD powers!"

*(11:15 am – 11:35 am Forenoon Break)*

## 12. CREATE Operation (11:35 am – 12:30 pm)
> **What to say:** "Let's perform our first true POST Request! In our `StudentController`, we create a mapped function. Inside `StudentService`, we construct a new `Student` entity natively, map the DTO properties to it, and cleanly invoke `repository.save(student)`. That's it! Fire a physical JSON POST request through Postman, then refresh MySQL Workbench. The record is permanently recorded successfully!"

## 13. READ Operation (12:30 pm – 1:15 pm)
> **What to say:** "To retrieve our persistent records, we map `@GetMapping` endpoints to `repository.findAll()` and `repository.findById(id)`. Pull all the students via Postman! Even if you hard-restart the Java Server wildly now, the array never drops. The records survive physically forever because they sit on your hard drive natively!"

*(1:15 pm – 2:00 pm Lunch Break)*

## 14. UPDATE & DELETE Operations (2:00 pm – 3:00 pm)
> **What to say:** "What if a student drops out, or changes their name? We must use `PUT` and `DELETE`.
> For `@DeleteMapping("/{id}")`, we simply natively pass the URL variable to `repository.deleteById(id)`. For `@PutMapping("/{id}")`, we first fundamentally check if the `findById()` securely exists, update the specific fields softly, and hit `repository.save()` again! Save serves dual purposes: Insert AND Update natively!"

## 15. Complete CRUD Integration (3:00 pm – 4:10 pm)
> **What to say:** "We have achieved total Database Lifecycle parity. Open Postman. I want you to run the entire flow linearly: POST a brand new student. GET their specific ID. PUT a brand new updated name over their record. Finally, aggressively DELETE them! Verify all stages intimately inside MySQL Workbench natively. You have successfully conquered full REST Backend Engineering structurally!"
