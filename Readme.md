# 🎫 Event Ticket Platform

A **complete event management system** for organizing, selling, and validating event tickets with secure login, QR scanning, and role-based access.

---

## 🚀 Features

* 🎟 Event creation, updating, deletion, and reporting
* 💳 Secure ticket purchases with real-time inventory
* 📱 QR code generation and scanning for check-in
* 🔐 Role-based access control (organizer, attendee, staff)
* 🌐 OAuth2 authentication via Keycloak
* 📦 Well-structured REST API for frontend consumption

---

## 🛠 Tech Stack

* **Backend:** Java 21, Spring Boot 3, MapStruct, Lombok, JPA
* **Frontend:** React + Vite *(configured for Keycloak integration)*
* **Database:** PostgreSQL
* **Authentication:** Keycloak

---

## 🗂 Architecture Overview

```
[ React + Vite Frontend ] → [ Spring Boot API ] → [ PostgreSQL ]
                                 ↕
                             [ Keycloak ]
```

---

## ⚙️ Developer Workflow

### 1️⃣ Clone the Repository

```bash
git clone <copy-url-from-above>
cd tickit
```

---

### 2️⃣ Backend Setup

#### 🔸 PostgreSQL

* Ensure PostgreSQL is running on port `5432`
* A user `postgres` must exist (password as per `application.properties`)

#### 🔸 Keycloak

* Ensure Keycloak runs on port `9090`
* Setup details below in [Keycloak Setup](#4-keycloak-setup)

#### 🔸 Run Spring Boot

```bash
./mvnw spring-boot:run
```

Or to package and run:

```bash
./mvnw clean package
java -jar target/tickit-0.0.1-SNAPSHOT.jar
```

---

### 3️⃣ Frontend Setup (React + Vite) {pending now}

```bash
cd frontend
npm install
npm run dev
```

* Frontend will run at: `http://localhost:5173` {will redirects to `/callback` after login from keycloak}

---

### 4️⃣ Keycloak Setup

#### 🔹 Access Admin Panel

* URL: [http://localhost:9090](http://localhost:9090)
* Login: `admin / admin`

#### 🔹 Create Realm

* Name: `tickit`

#### 🔹 Create Client

* Client ID: `tickit-app`
* Client Type: `public`
* Valid Redirect URIs:

  ```
  http://localhost:5173/callback
  ```
* Web Origins:

  ```
  http://localhost:5173
  ```

#### 🔹 Create Roles

* `organizer`, `attendee`, `staff`

#### 🔹 Create Users

* Assign each user the appropriate role

---

## 🔐 React + Keycloak Auth Flow (Callback)

* After login, Keycloak will redirect to `http://localhost:5173/callback`
* The frontend should parse the token from URL and authenticate the user

---

## 📦 REST API Overview

### Organizer

| Method | Endpoint                      | Description       |
| ------ | ----------------------------- | ----------------- |
| POST   | `/api/v1/events`              | Create event      |
| PUT    | `/api/v1/events/{id}`         | Update event      |
| GET    | `/api/v1/events`              | List all events   |
| DELETE | `/api/v1/events/{id}`         | Delete event      |
| GET    | `/api/v1/events/{id}/tickets` | View ticket sales |

### Attendee

| Method | Endpoint                                             | Description              |
| ------ | ---------------------------------------------------- | ------------------------ |
| GET    | `/api/v1/published-events`                           | Browse published events  |
| POST   | `/api/v1/published-event/{id}/ticket-types/{typeId}` | Purchase ticket          |
| GET    | `/api/v1/tickets`                                    | View user tickets        |
| GET    | `/api/v1/tickets/{id}/qr-codes`                      | Fetch QR code for ticket |

### Staff

| Method | Endpoint                                 | Description          |
| ------ | ---------------------------------------- | -------------------- |
| POST   | `/api/v1/events/{id}/ticket-validations` | Validate ticket      |
| GET    | `/api/v1/events/{id}/ticket-validations` | View validation logs |

---

## 🧑‍💻 Developed By

**Jagmohan Sharma**
CSE, Batch of 2026
Motilal Nehru National Institute of Technology (MNNIT), Allahabad