# Password Manager Documentation

## 1. System Architecture

**Main Components**:

- **Frontend**: Built with **ReactJS**, the frontend handles user interactions and communicates with the backend via API calls.
  
- **Backend**: Implemented using **Spring MVC**, the backend processes business logic, manages authentication and authorization, and handles requests from the frontend.

- **Security**: Managed by **Spring Security**, ensuring that only authenticated and authorized users can access specific endpoints.

- **Database**: A **SQL database** stores user information, including encrypted passwords and other necessary data.

**APIs Exposed**:

- **Security**:
  - `auth/login`: Handles user authentication by validating credentials and issuing tokens or sessions.
  - `auth/register`: Manages user registration and triggers email verification.

- **Home Page**:
  - `api/welcome`: A protected endpoint that provides welcome information to authenticated users.

**Services Added**:

- **Email OTP Verification Service**: 
  - Used to verify the authenticity of the user's email during registration. An OTP (One-Time Password) is sent to the user's email, which they must enter to complete the registration process.

---

## 2. Component Design

### 1. Frontend (ReactJS)

- **Design Framework**:
  - The frontend utilizes **Bootstrap CSS** for responsive and consistent design, ensuring a user-friendly interface across various devices.

- **Communication with Backend**:
  - The frontend communicates with the backend via **Axios**, a promise-based HTTP client, for making API requests such as user authentication, registration, and fetching data.

### 2. Backend (Spring MVC)

- **Structure**:
  - The backend is organized into several packages to maintain a clean and modular architecture:
    - **Configuration**: Contains classes for configuring security, database connections, and other application settings.
    - **Repository**: Manages data access and persistence, typically interacting with the database through JPA or similar frameworks.
    - **Controllers**: Handle incoming HTTP requests, process them, and return appropriate responses.
    - **Service**: Contains the business logic, where most of the application’s core functionality is implemented.
    - **Register Response & Register Request**: DTOs (Data Transfer Objects) used for handling user registration data.
    - **Entities**: Represent the database tables and are mapped to the SQL database using JPA annotations.

- **Security**:
  - **Password Storage**: User passwords are encrypted using **Bcrypt** with a strength factor of 10, ensuring a secure and resilient password storage mechanism.

### 3. Database (SQL)

- **Users Table**:
  - The database currently consists of a single table named `users`, which stores the following information:
    - **id**: A unique identifier for each user (likely the primary key).
    - **username**: The username chosen by the user.
    - **email**: The user’s email address, used for account verification and communication.
    - **password**: The user’s encrypted password, stored using Bcrypt encryption.
    - **isVerified**: A boolean flag indicating whether the user’s email has been verified.

---

## 4. Security Considerations

- **Authentication**:
  - [Details about authentication methods]

- **Authorization**:
  - [Details about access control and roles]

- **Data Protection**:
  - [Details about measures for protecting sensitive data]

- **Security Features**:
  - [Details about additional security features]

---

## 5. Scalability and Performance

- **Load Handling**:
  - [Details about handling increasing load]

- **Performance Optimization**:
  - [Details about performance optimization techniques]

- **Database Scaling**:
  - [Details about database scaling and indexing]

---

## 6. Deployment Architecture

- **Environment Setup**:
  - [Details about different environments and configurations]

- **Deployment Process**:
  - [Details about deployment steps and tools]

- **Hosting**:
  - [Details about where the application is hosted]

---
