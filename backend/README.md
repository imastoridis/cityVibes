# City Vibes Backend (Spring Boot)

Welcome to my application! This is a secure, multi-user RESTful API built with Spring Boot, Spring Security, and Spring Data JPA.

It allows users to add reviews and vibes to a city and visualize the experiences of other users

## Table of Contents

1.  Prerequisites

2.  Setup and Run Locally (Recommended)

3.  Run with Docker

4.  API Endpoints

## 1\. Prerequisites

You need the following installed on your machine:

-	**Java Development Kit (JDK) 21 or higher**

-	**Apache Maven** (for building the project)

-	**Git**

-	**Docker** (for containerized deployment)

## 2\. Setup and Run Locally 

### Step 1: Clone the Repository

```
git clone https://github.com/imastoridis/cityVibes.git
cd cityVibes
```

### Step 2: Build the Project

Use Maven to compile the code and package it into a runnable JAR file.

```
mvn clean install

```

### Step 3: Run the Application

Execute the packaged JAR file.

```
java -jar target/city-vibes-1.0-SNAPSHOT.jar
** Note: The JAR name must match your project's artifactId and version from pom.xml**
```

The application will start on `http://localhost:8080`.

## 3\. Run with Docker (Development Setup `Dockerfile.dev`)

This project provides specialized Dockerfiles for different use cases. You must use the `-f` flag to specify which one to use.

Use this for active coding, rapid restarts, and debugging.

### Step 1: Clone the Repository

```
git clone https://github.com/imastoridis/cityVibes.git
cd cityVibes
```

### Step 2: Build the Development Docker Image

```
docker build -d app-dev frontend-dev.
```

The application will be accessible at `http://localhost:4200`.

## 4\. API Endpoints

The API requires a registered user to access most resources. Registration/Authentication endpoints should be accessible first.

| Endpoint            | Method | Description                                           | Authentication |
| ------------------- | ------ | ----------------------------------------------------- | -------------- |
| `/api/register`     | `POST` | Registers a new user.                                 | None           |
| `/login`            | `POST` | Authenticates a user and issues a session cookie.     | None           |
| `/api/categories`   | `GET`  | Retrieve all categories for the authenticated user.   | Required       |
| `/api/categories`   | `POST` | Create a new category.                                | Required       |
| `/api/transactions` | `GET`  | Retrieve all transactions for the authenticated user. | Required       |
| `/api/transactions` | `POST` | Create a new transaction.                             | Required       |
| `/api/transactions` | `PUT`  | Update an existing transaction.                       | Required       |
| `/api/transactions` | `DELETE` | Delete a transaction.                               | Required       |
