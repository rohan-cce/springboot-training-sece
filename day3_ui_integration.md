# Day 3 Curriculum: Frontend Integration with Vanilla HTML & JavaScript (6 Hours)

## Session 1: Client vs Server Architectures & Design (1.5 Hours)
- **The True Separation of Concerns:**
  - Modern applications violently divide operational logic into Frontends (Client view) and Backends (Server logic).
  - So far, Postman acts as our API Client. Now, we build a real Client using a Web Browser.
  - Explain that backends shouldn't construct HTML. They exclusively build raw JSON structures utilizing endpoints (`@RestController`).
  - Frontends (HTML/JS) run entirely on User Devices (Chrome/Safari) independently, reaching across the internet strictly to download backend JSON.
- **The Static Architecture Approach:**
  - Where do HTML files live? When a user visits a website, the Spring Boot server simply locates raw `.html` files in the `/static` folder and ships it to the browser over the network exactly as it exists on the hard drive.
  
## Session 2: HTML & CSS Crash Course (1.5 Hours)
- **HTML Structure (The Skeleton)**
  - What are layout elements? `<html>`, `<head>`, `<body>`.
  - Utilizing Content tags: `<h1>`, `<p>`, `<div>`, `<input>`, `<button>`.
  - Building Data Tables for directories: `<table>`, `<thead>`, `<tr>`, `<th>`, `<tbody id="student-table">`. (Explain why we give the body a unique ID for Javascript).
- **CSS Styling (The Paint)**
  - Dropping in a CDN classless layout (**Pico CSS**) directly into the `<head>`. This instantly makes the site beautiful automatically without teaching 2nd-years dense CSS mapping attributes.
- *Exercise (30 min):* Students draft their `src/main/resources/static/index.html` skeleton natively. Prove that Spring Boot automatically hosts anything in the `/static` folder globally when accessing `http://localhost:8080/`.

## Session 3: Connecting to APIs with Vanilla JavaScript (1.5 Hours)
- **What is JavaScript?**
  - Java runs aggressively on the Server. JavaScript runs securely inside the User's Browser Engine. They are entirely disconnected programming languages!
- **The `fetch()` Protocol (Reading Data)**
  - How browsers launch background HTTP calls invisibly.
  - Using `fetch('/students')` to issue a dynamic `GET` request.
  - Parsing the Response Payload: `.then(response => response.json())`
- **DOM Manipulation (Wiring JSON aggressively into HTML)**
  - Using `document.getElementById('student-table')` to locate the blank table.
  - Iterating the fetched JSON arrays using `forEach`.
  - Dynamically constructing physical `<tr><td>...</td></tr>` HTML syntax strings manually, injecting them natively into the user's screen.
- *Exercise (45 min):* Outline the GET logic. When students refresh Chrome, the empty HTML table should automatically connect to the API, resolving the loop, and populate physically from their Java H2 Database!

## Session 4: Forms & Asynchronous Data Persistence (1.5 Hours)
*(Tutor Note: Combine their Java backend architecture with this new Frontend.)*
- **The Interactive Web Form (Writing Data)**
  - Constructing an exact HTML `<form>` identified precisely with `id="student-form"`.
  - Sabotaging default HTML behavior: Setting up an `onsubmit` Javascript event listener firing `event.preventDefault()` so the page doesn't glitch-reload instantly.
- **Crafting the Javascript POST Request**
  - Extracting live values extracted from the HTML inputs natively.
  - Executing a complex payload transmission:
    ```javascript
    fetch('/students', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name: nameVal, age: ageVal }) // Serializing JS objects into valid JSON strings
    })
    ```
- **End-to-End Validation Failures Configuration**
  - Surfacing HTTP Error codes securely in the Frontend. If Spring Boot throws a **400 Bad Request** due to a negative age intentionally (Validation limits mapped heavily on Day 2), Javascript accurately intercepts the 400 status branch and `alert()`s the user locally.
- **Final Deployment Check (30 min):**
  - Command students to test completely! They should organically enter validation-failing ages, ensuring the database correctly repels them, then input correct values, observing the table physically update in real-time.
