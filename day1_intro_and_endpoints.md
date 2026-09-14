# Day 1 Curriculum: Client/Server Basics & Spring Boot Endpoints (6 Hours)

## Session 1: Client/Server Basics & Environment Setup (1.5 Hours)
*(Tutor Note: 2nd year students often struggle with environments. Dedicate time to ensure their JDK and IDE are working properly.)*
- **The Short-lived vs Long-lived Mental Model**
  - Discuss `public static void main(String[] args)` and when the JVM stops.
  - Introduce what a "Daemon" or "Server Background Process" is (A program that waits forever).
- **The Client and The Server**
  - **Client:** The person or app asking for information (Browser, Mobile App).
  - **Server:** The computer that listens and gives the information back.
  - **What is a URL?** Breaking down `http://` (protocol), `localhost:8080` (where it lives), and `/hello` (what we are asking for).
- **Environment Checkout**
  - Ensure all students have Java 17 installed.
  - Ensure IDEs (IntelliJ/Eclipse) are properly configured.

## Session 2: Introducing Spring Boot Ecosystem (1.5 Hours)
- **What is a Framework?**
  - A framework is a massive toolkit built by other developers. It provides reusable code so you don't have to build the complex networking rules from scratch.
- **Java -> Spring -> Spring Boot**
  - Spring is the vast ecosystem. Spring Boot is the "magic wand" that makes configuring Spring extremely easy and ready-to-run.
  - *Exercise (45 min):* Walk students through using `start.spring.io` to generate their first blank artifact. Review the folder structure `src/main/java`.

## Session 3: First Contact - Building HTTP GET Endpoints (1.5 Hours)
- **Understanding Java Annotations**
  - What are Java Annotations (`@`)? They are metadata tags (sticky notes) for tools/frameworks to process, not physical logic.
  - Introduce `@RestController`: Tells Spring "Treat this class as a Web Component".
- **Building `HelloController`**
  - Map our first route using `@GetMapping("/hello")`.
  - Introduce **Java Packages** (Good architecture vs Spaghetti code: `com.example.app.controller`).
  - Let students run the application via IDE and hit `http://localhost:8080/hello` in their browser.
- **Hands-on Labs (Additional Endpoints):**
  - Have them build `/time` returning a timestamp string.
  - Have them build `/random` returning a random number from 1 to 100.
  - Have them build `/ping` returning "pong".

## Session 4: Advanced Endpoints & APIs (1.5 Hours)
- **The Problem with Web Browsers as Testing Tools**
  - Browsers inherently ONLY send `GET` requests from the top URL bar.
  - We need a tool to send raw HTTP requests simulating mobile apps or frontends.
  - **Introduce Postman & cURL:** Show students how to configure a workspace and send requests.
- **🧠 Deep Dive: The Core HTTP Methods (Verbs)**
  - `GET`: Retrieve data safely without modifying it.
  - `POST`: Create entirely new data in the database.
  - `PUT`: Update existing data completely, or create it if absent.
  - `DELETE`: Remove data permanently.
  - `OPTIONS`: Ask the server what methods are allowed (Crucial for frontend CORS pre-flight checks).
  - `HEAD`: Exactly like GET, but explicitly asks the server to only return *Headers* (No Body). Used to check if a massive file exists without actively downloading the whole file.
- **cURL Request Collection (For Teacher Demo)**
  - *Tutor Note: Run these inside your terminal to visually prove HTTP methods to students side-by-side with your running Spring code!*
  ```bash
  # 1. GET Request
  curl -X GET http://localhost:8080/students

  # 2. POST (Create) Request with JSON Body
  curl -X POST http://localhost:8080/students \
       -H "Content-Type: application/json" \
       -d '{"name": "Alice", "age": 20}'

  # 3. PUT (Update/Replace) Request
  curl -X PUT http://localhost:8080/students/1 \
       -H "Content-Type: application/json" \
       -d '{"name": "Alice Updated", "age": 21}'

  # 4. DELETE Request
  curl -X DELETE http://localhost:8080/students/1

  # 5. HEAD Request (Fetches strictly Headers e.g., 200 OK)
  curl -I http://localhost:8080/students

  # 6. OPTIONS Request (Fetches Allowed Methods)
  curl -X OPTIONS -i http://localhost:8080/students
  ```
- **Handling Dynamic Parameters**
  - Modern websites use parameters, e.g. `youtube.com/watch?v=123`.
  - Introduce **`@RequestParam`**: Passing queries via URL (`/hello?name=John`).
  - Introduce **`@PathVariable`**: Building clean restful variables directly inside the path (`/users/502`).
  - Let students practice handling both and printing out custom dynamic Strings (e.g. `return "Hello, " + name;`).
- **Final Day 1 Assignment / Mini-Project: Volatility**
  - Instruct the students to build a `StudentController` containing a private `List<StudentDTO> students = new ArrayList<>()`.
  - Build a `POST` method that saves custom JSON objects directly into this array.
  - Run the server locally, add 3 unique students via cURL or Postman, and `GET` them back out showing success!
  - **The Magic Trick (Proving why we need Day 2):** Stop the Spring Boot server. Start it again. Have the students pull the list of students. It will return completely empty `[]`. This actively proves why RAM memory is critically insufficient for data storage, organically setting them up for why they absolutely *need* to learn Databases tomorrow!
