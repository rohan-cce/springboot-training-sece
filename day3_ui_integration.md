# LEAP Day 3: UI, Validation, Testing & Finalization

## 16. Introduction to Web Interface (8:40 am – 9:10 am)
> **What to say:** "Welcome to Day 3! We have successfully engineered the invisible backend database layer natively. However, standard users will never interact visually with Postman. We must architect a graphical interface.
> Today, we bridge Java directly with native HTML/CSS/JS. We will serve a static website that fetches data dynamically from our Java REST API."

## 17. Create Web Pages & Forms (9:10 am – 10:00 am)
> **What to say:** "Let's build `index.html` globally inside `src/main/resources/static`. We will construct a visually fundamental `<table>` structure, and a structurally explicit `<form>` collecting name and age inputs natively! We define the form securely to intercept submissions via Javascript. Without styling, native HTML will look aggressively retro, so we'll use PicoCSS for a modern look!"

## 18. UI–CRUD Integration (10:00 am – 11:15 am)
> **What to say:** "Now we natively bridge the Gap! In Java, our `BankAccountController` natively handles `/accounts`. In our `index.html`, we write Javascript to use `fetch('/accounts')`. When a user browses to the URL locally, Javascript organically reaches out to our Server, fetches all active accounts as raw JSON data, and strictly iterates over it dynamically printing physical `<tr>` table rows natively!"

*(11:15 am – 11:35 am Forenoon Break)*

## 19. Input Validation (11:35 am – 12:30 pm)
> **What to say:** "What brutally happens if a user submits negative fifty locally as their age via the HTML form or JSON API? The DB inherently crashes or strictly accepts garbage math. We aggressively map `spring-boot-starter-validation` natively inside our `pom.xml`. Then, we definitively stick `@Positive` over our `age` variable in `BankAccountDTO.java`. Now, Java blocks terrible input mechanically globally!"

## 20. Exception Handling (12:30 pm – 1:15 pm)
> **What to say:** "When `@Valid` triggers a blockage natively, Tomcat throws a horrifying massive ugly stack trace directly onto our graphical UI natively. This strictly ruins Professional UX. 
> To conquer this, we physically engineer the `GlobalExceptionHandler.java` applying the `@ControllerAdvice` global net! If our application organically crashes during validation uniquely, this handler actively intercepts the stack trace natively and forces a pristine clean JSON error message seamlessly protecting the UI completely!"

*(1:15 pm – 2:00 pm Lunch Break)*

## 21. Application Testing & Debugging (2:00 pm – 3:00 pm)
> **What to say:** "It is time to stress-test your architecture completely natively! I want you organically entering strictly invalid inputs intentionally! Ensure validation handles failure cleanly natively. Test the entire flow completely natively: UI -> Controller -> Service -> Database natively returning back structurally to UI."

## 22. Project Finalization & Demonstration (3:00 pm – 4:10 pm)
> **What to say:** "Congratulations! You have physically scaled from zero to a strictly Enterprise-ready structurally fully-integrated Spring framework Natively supporting Relational databases, strict CRUD APIs visually rendered natively on Thymeleaf. Let's globally execute complete application demonstrations locally on stage to conclude LEAP!"
