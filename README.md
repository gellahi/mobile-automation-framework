# Mobile Test Automation Framework

## Project Overview

This project implements a production-style mobile automation framework for Android using:

- Java
- Appium
- TestNG
- Maven
- GitHub Actions (CI)
- Page Object Model (POM)

The framework automates the Sauce Labs Android Sample E-Commerce Application and validates complete user flows including authentication, product selection, cart operations, and checkout.

---

## Tech Stack

- Java 17
- Appium (UiAutomator2)
- TestNG
- Maven
- GitHub Actions
- Android Emulator (CI)
- Docker (Local Appium execution)

---

## Framework Architecture

- Page Object Model (POM)
- Separate Page classes
- Encapsulated locators
- Reusable driver setup
- Independent test cases
- Structured branching model

Project Structure:


src/
├── main/java/com/mobile/automation/
│ ├── pages/
│ └── utils/
└── test/java/com/mobile/automation/
├── base/
└── tests/


---

## Implemented Test Cases (10 Total)

### Authentication
- Valid Login
- Invalid Login
- Logout

### Product & Cart
- Add product to cart
- Cart navigation
- Product sorting

### Checkout
- Checkout navigation
- Form validation error
- Complete checkout form flow

### Smoke
- Application launch verification

---

## Running Tests Locally

### Prerequisites

- Java 17
- Maven
- Android SDK
- Running Android device or emulator
- Appium Server (Docker recommended)

### Start Appium via Docker


docker pull appium/appium
docker run -d -p 4723:4723 --name appium-server appium/appium


### Run Tests

For physical device:


mvn clean test -Dudid=<your-device-udid>


---

## CI/CD Pipeline

GitHub Actions pipeline:

- Triggers on push to `main`
- Triggers on Pull Requests to `main`
- Sets up Android Emulator
- Installs Appium
- Builds Maven project
- Executes all 10 automated test cases

Pipeline ensures no unverified code is merged into production branch.

---

## Git Workflow

- Protected `main` and `develop` branches
- No direct commits allowed
- Feature branches per issue
- Mandatory PR review
- Squash merge strategy
- Linked issues for traceability

---

## Author

Final Year Software Engineering Student  
FAST NUCES – Applied DevOps