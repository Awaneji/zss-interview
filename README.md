
# Bookshop API

A **Spring Boot 3** application running on **Java 17** providing simple **CRUD APIs for Books and Categories**, and consuming a **Mock Payment API**.

---

## **Features**

### Book API
- Create, Read, Update
- Search by Category (case-insensitive)

### Category API
- Create, Read

### Payment Integration (Mock)
- Payment API consumed via `WebClient`
- Retry logic for 5xx errors implemented

---

## **Major Dependencies**
| Dependency                          | Purpose                          |
|------------------------------------|----------------------------------|
| **Lombok**                          | Reduce boilerplate (getters/setters)  |
| **spring-boot-starter-validation**  | DTO validations                   |
| **springdoc-openapi-starter-webmvc-ui** | Swagger / OpenAPI UI            |
| **spring-boot-starter-webflux**     | Reactive `WebClient` for payments  |

---

## **Database Requirement**
- **PostgreSQL** installed
- Create database: `bookshop`
- Update your **Postgres username/password** in `application.properties`:

```properties
spring.datasource.username=your-username
spring.datasource.password=your-password
```

---

## **Running the Application**

### Build the JAR
```bash
mvn clean package -DskipTests
```

### Run the Application
```bash
java -jar target/{your-jar-file}.jar
```

### OR Run Directly from IDE
Simply run the main application class.

---

## **API Documentation (Swagger)**
Access via browser:  
[http://localhost:8089/bookshop/swagger-ui/index.html](http://localhost:8089/bookshop/swagger-ui/index.html)

---

## **Areas for Future Improvement**
1. Implement **Shopping Cart** for selling books.
2. Introduce **Authors Model** for richer book metadata.
3. Add Book Inventory management module
4. Change Book → Category relation to **Many-to-Many** (books can belong to multiple categories).
5. Add **Security Layer** (JWT / OAuth2) and enable **SSL/TLS**.
6. Write comprehensive **Unit Tests** for all layers.

---

## **Known Blockers / Limitations**
- Payment integration endpoint `https://secure.v.co.zw/interview` was **down**, preventing full end-to-end tests.
- However, the **transaction request is correctly implemented via `WebClient`**.

---

## **Ports & Endpoints**
| Resource     | URL                                |
|--------------|------------------------------------|
| **Swagger UI** | [http://localhost:8089/bookshop/swagger-ui/index.html](http://localhost:8089/bookshop/swagger-ui/index.html) |
| **API Base**  | `http://localhost:8089/bookshop/api/...` |

---
