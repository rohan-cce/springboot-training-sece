# Spring Initializr Setup Guide for Students

To ensure everyone is on the same page for the new curriculum with MySQL and Thymeleaf, please follow these exact steps when creating your project on [start.spring.io](https://start.spring.io/).

## 1. Project Metadata
Set the following properties logically to match the workspace:
- **Project**: Maven
- **Language**: Java
- **Spring Boot**: 4.1.1 *(Note: If this exact version is unavailable, choose the latest stable 4.x or 3.x release)*
- **Packaging**: Jar
- **Java**: 17

## 2. Dependencies
You will need to search for and ADD the following 5 dependencies using the "ADD DEPENDENCIES" button:

1. **Spring Web** 
   *(Provides RESTful web services, Apache Tomcat, etc.)*
2. **Spring Data JPA** 
   *(Provides Hibernate for object-relational mapping and data persistence)*
3. **MySQL Driver** 
   *(Required since we are using local MySQL Workbench instead of an in-memory H2 database)*
4. **Validation** 
   *(Required for model and data validation, e.g., `@NotNull`, `@Size` annotations)*

*Note: Do NOT add the `H2 Database` or `Spring Session` dependencies unless explicitly instructed during a specific workshop module.*
