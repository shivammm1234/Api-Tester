# Api-Tester


API Tester Tool 🚀

A lightweight API testing application built using Spring Boot + Vanilla HTML/CSS/JS that allows users to send HTTP requests and inspect responses without using external tools like Postman.

📌 Features

Send GET, POST, PUT, DELETE, PATCH requests

Custom headers support

JSON request body support

Displays:

Status code

Response body

Headers

Response time

Logs request history into database

Simple UI (No React or heavy frontend frameworks)

🛠 Tech Stack

Backend

Spring Boot

RestTemplate

JPA + Database

Frontend

HTML

CSS

JavaScript (Fetch API)


⚙️ How It Works
Frontend UI → POST /api/execute → Backend → Target API → Response → UI
Your backend acts as a proxy request executor.


▶️ How to Run
1️⃣ Start Backend

Run Spring Boot application

mvn spring-boot:run
or
Run main() method

Default port:
http://localhost:8080/index.html

