# Day 1: Client/Server Basics & Spring Boot Endpoints (Trainer Script)

## Session 1: Client/Server Basics (1.5 Hours)

### 1. The Short-lived vs Long-lived Mental Model
> **What to say:** "Welcome everyone! Up until today, every Java program you have ever written has been short-lived. You click 'Run', the `main()` method triggers, it prints something to the console, and the JVM instantly shuts down. Today, we change that. Enterprise applications do not shut down. They start up, and they wait forever. This is called a Server. It listens on a specific network port infinitely, waiting for a device anywhere in the world to ask it a question."

### 2. The Client and The Server
> **What to say:** "Let's define two words we will use constantly. The **Client** is the caller asking the question—like a Chrome Browser or your phone's Instagram app. The **Server** is the massive computer sitting in a warehouse holding the data, listening for that question to arrive. When you type a URL like `http://localhost:8080/hello`, you are literally telling your browser: 'Use the HTTP protocol, traverse the internet to my local machine on port 8080, and trigger the `/hello` code sequence'."

*(Tutor Action: Dedicate 30 minutes ensuring all their Java 17 and IDEs are configured securely).*

## Session 2: Introducing the Spring Boot Ecosystem (1.5 Hours)

### 1. What is a Framework?
> **What to say:** "Writing a server from absolute scratch using raw Java networking sockets takes hundreds of lines of code just to reliably print 'Hello World' over the internet. That's a massive waste of time. A **Framework** is a massive, pre-built toolkit designed by experts to do the structural heavy lifting for you. We are using **Spring Boot**, the most dominant enterprise Java framework in the world. It provides 'opinionated defaults'—meaning it automatically makes the best architectural assumptions for you, so you only have to write your specific business logic!"

### 2. Spring Initializr and the POM
> **What to say:** "Let's build our first server! Everyone go to `start.spring.io`. This is the Spring Initializr. It instantly yields a completely valid, functioning server blueprint. Let's look at the `pom.xml` file it generated. Think of the `pom.xml` as a grocery list. When you put a dependency in there, the Maven tool instantly runs to the internet internet, downloads that exact code package, and wires it into your project for free!"

## Session 3: First Contact - Building HTTP GET Endpoints (1.5 Hours)

### 1. Understanding Java Annotations
> **What to say:** "To build our first web component, we need to understand Annotations. These are the words that start with an `@` symbol. Annotations aren't regular Java logic; they are 'sticky notes' you place on your code. When the Spring framework boots up, it reads those sticky notes and grants those classes special powers. For example, pasting `@RestController` at the top of an ordinary class yells to Spring: 'Hey, connect this specific class directly to the internet!'"

### 2. Building `HelloController`
> **What to say:** "Let's create a new class called `HelloController`. Above it, type `@RestController`. Now, write a standard Java method that returns the string 'Hello BTech!'. To map this to a URL, we place `@GetMapping("/hello")` directly above the method. Now, hit the green 'Run' button. Go to your web browser and type `http://localhost:8080/hello`. Boom! You have just successfully served data from a live Java Daemon web server."

*(Tutor Action: Have them independently build a `/time` endpoint returning a timestamp, and a `/random` endpoint returning a random number).*

### 3. Day 1 Hiccup: The Missing Controller Lab
> **What to say:** "Let's learn how to read errors. Before we move on, I want you to go into your Controller and completely delete the `@RestController` annotation. Now, restart your server and try to hit the URL. 
> 
> *Pause.* You just got hit with a massive `404 Not Found` Whitelabel Error Page! Why? Because without that explicit sticky note, Spring ComponentScan treats your controller as just a boring, normal Java class. It blindly ignores it and never connects it to the internet! Restore the annotation, restart, and watch the internet connection magically re-establish!"

## Session 4: Advanced Endpoints & APIs (1.5 Hours)

### 1. The Core HTTP Verbs
> **What to say:** "So far, our browser can only 'GET' information. But real applications allow you to create, modify, and destroy data. This is where HTTP Verbs come in. 
> *   `GET`: means 'give me the data'.
> *   `POST`: means 'I am giving you brand new data to securely save into your database'.
> *   `PUT`: means 'I want to overwrite existing data'.
> *   `DELETE`: means 'Destroy this record permanently.'
> A web browser naturally only executes `GET` requests from its top URL bar. We need a professional tool to simulate the complex `POST` and `DELETE` requests that mobile apps usually send behind the scenes."

### 2. Dynamic URL Parameters
> **What to say:** "If you go to a Youtube video, the URL isn't just `/watch`. It looks like `/watch?v=12345`. How do they extract that `12345` dynamic variable into their Java code? They use `@RequestParam`. When you want dynamic paths, like looking up user ID 502 via `/users/502`, you use `@PathVariable` to explicitly rip the '502' integer straight out of the URL path!"

*(Tutor Action: Walk them through the Postman / cURL logic so they can send raw POST requests).*

### 3. REST API Best Practices (Industry Guidelines)
> **What to say:** "Now that you can physically build endpoints, you need to learn the 'Golden Rules of REST'. If you build APIs incorrectly, other developers simply will not use them. Here are the four strict industry standards you must follow in your projects:
> 
> 1. **Use Plural Nouns, Never Verbs:** The URL represents the *resource*, while the HTTP method represents the *action*. Never build endpoints like `/getStudent` or `/saveStudent`. Instead, simply use the plural noun `/students`. If you `GET /students`, you fetch them. If you `POST /students`, you save them!
> 2. **Nest Architecturally:** If you want to find all students in Department 4, nest it logically left-to-right: `/departments/4/students`.
> 3. **Strict Status Codes:** Do not return a 200 OK with an error message inside it! If validation fails, strictly return `400`. If data is missing, strictly return `404 Not Found`. 
> 4. **API Versioning:** Always prefix your URLs with versions, like `/api/v1/students`. If you radically change the database entirely next year, you release `/api/v2/students`, saving millions of old mobile apps from globally crashing overnight!"

## Session 5: Volatility & Under The Hood (1.5 Hours)

### 1. The Memory Volatility Mini-Project (The Setup for Day 2)
> **What to say:** "To finish off Day 1, I want you to create a `StudentController`. Inside it, simply define a private generic `ArrayList` holding Students. Create a `@PostMapping` that takes JSON and adds students securely into your List. Run it, mapping data via Postman. Look! You have 3 students successfully stored! 
> 
> *Pause.* Now, stop your Java server visually. Start it again. Make a `GET` request. Oh no! The array is completely empty! Where did the students go? They vanished because Java variables only live dynamically in RAM, and RAM is entirely volatile. This disastrous data loss perfectly proves exactly why we desperately need to learn persistent **Databases** tomorrow morning!"

### 2. Auto-Configuration Mechanics
> **What to say:** "Before we conclude, look at the `@SpringBootApplication` tag in your main file. That single sticky note is actually three notes combined: It turns on `@ComponentScan` (hunting for your RestControllers), `@Configuration`, and crucially `@EnableAutoConfiguration`. This auto-configurer actively scans your `pom.xml`, sees the Web dependency, and literally builds a massive Tomcat Server secretly in the background for you entirely from scratch. That is the true magic of Spring!"
