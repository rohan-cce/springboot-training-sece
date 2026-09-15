# LEAP Day 1: Spring Boot Foundation & REST API

## 1. Introduction to the LEAP Project (8:40 am – 9:00 am)
> **What to say:** "Welcome to the Java DBMS Project LEAP! Over the next three days, you will structurally transform from writing basic Java Console algorithms into architecting a fully functional, production-ready N-Tier Web Application. 
> Together, we will build a Complete Application exactly as they do in the physical tech industry: architecting REST APIs hitting a MySQL database natively and rendering visually via Thymeleaf web pages!"

## 2. Why Spring Boot? (9:00 am – 9:30 am)
> **What to say:** "Writing a server objectively from absolute scratch using raw network sockets takes thousands of distinct lines of generic boilerplate code. A **Framework** actively does the architectural heavy lifting for you. We are aggressively teaching you **Spring Boot** because it is the most dominant Enterprise Java framework natively used across the globe. It mathematically simplifies complex database connections down to just two lines of code safely!"

## 3. Spring Boot Application & Maven Basics (9:30 am – 10:00 am)
> **What to say:** "Everyone navigate to `start.spring.io`, the Spring Initializr. This generates our foundational architecture. Notice the `pom.xml` document. This is your project grocery list; when we type dependencies locally, Maven automatically downloads exactly what we need directly from the internet seamlessly. Create your project now!"

## 4. Create First Spring Boot Application (10:00 am – 11:15 am)
> **What to say:** "Open the initialized environment in your local IDE. Look exactly at the `@SpringBootApplication` annotation natively sitting in your `main()` file. Run your application hitting the green button. Ensure it does not crash! The Tomcat server safely spins up implicitly in the background hosting port 8080. You have physically booted a background server natively."

*(11:15 am – 11:35 am Forenoon Break)*

## 5. Spring Boot Annotations & Controller (11:35 am – 12:30 pm)
> **What to say:** "Servers must actively respond to the internet. Open your files and create a new programmatic Java Class. Paste the `@RestController` annotation natively over the top line. This is a framework 'Sticky Note' strictly indicating 'Connect this specific class explicitly to the web!' Use `@GetMapping('/hello')` to seamlessly define your very first HTTP web destination dynamically."

## 6. REST API & Request–Response Flow (12:30 pm – 1:15 pm)
> **What to say:** "Let's learn REST API rules natively! A Client inherently sends a **Request** over HTTP, and the Server actively returns a **Response**.
> Let's test this in Google Chrome! We type `http://localhost:8080/hello`. That fundamentally generates an HTTP `GET` Request. Chrome inherently receives our payload string natively back seamlessly. We will introduce `POST` shortly, which actively creates massive data."

*(1:15 pm – 2:00 pm Lunch Break)*

## 7. Application Layers – Controller & Service (2:00 pm – 3:00 pm)
> **What to say:** "Enterprise Applications universally require strict separated N-Tier layers permanently! 
> 1. The **Controller (`@RestController`)** acts purely effectively as a Traffic Cop routing URL requests natively, doing absolutely zero physical logic.
> 2. The **Service Layer (`@Service`)** exclusively processes complex heavy math calculations structurally!
> 
> Let's build a `BankAccountController` relying dynamically on a `BankAccountService` using **Dependency Injection** internally. The Service will natively hold our volatile generic `ArrayList` isolating it from the web requests completely!"

## 8. API Testing with Postman (3:00 pm – 4:10 pm)
> **What to say:** "Chrome cannot securely execute `POST` Requests organically from its URL bar. This physically restricts us natively. Look at Postman. Postman is a developer tool allowing us to craft massive `POST` body JSON blocks perfectly and inject them structurally into our exact endpoint. Send a JSON BankAccount body natively. See our 200 OK locally returned! Notice how our array dynamically scales up inside RAM volatile memory successfully! 
> *(Tutor note: The volatile Array memory loss will securely bridge them into tomorrow's Database class natively.)*"
