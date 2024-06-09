# Selenium with Java Automation Framework

This is an automation framework created using Selenium with Java, TestNG, and Maven. This framework can be used to automate web applications and run tests efficiently.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Configurations](#Configurations)
- [Running Tests](#running-tests)


## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK):** Install the latest JDK from [here](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Maven:** Install Maven from [here](https://maven.apache.org/install.html).
- **Git:** Install Git from [here](https://git-scm.com/downloads).
- **IDE:** Use an Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or NetBeans.

## Installation

Follow these steps to set up the project locally:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/selenium-framework.git
    cd selenium-framework
    ```

2. **Import the project into your IDE:**
    - Open your IDE (IntelliJ IDEA/Eclipse/NetBeans).
    - Select `File > Open` and choose the cloned project directory.
    - The IDE will automatically detect and import the Maven project.

3. **Install Maven dependencies:**

    In your terminal or IDE, run:

    ```bash
    mvn clean install
    ```

## Project Structure

The project follows the standard Maven project structure:

- `src/main/java`: Contains the main Java files (Page Objects, utility classes).
- `src/test/java`: Contains the test cases.
- `pom.xml`: Maven configuration file.

## Configurations

- **Properties File:**
    - Create a `config.properties` file in the `src/test/resources` directory.
    - Add necessary configurations like URLs, credentials, browser settings, etc.

### Writing Tests

1. **Page Object Model (POM):**
    - Create a Java class for each web page under `src/main/java/com/example/pages`.
    - Define web elements and methods to interact with them.

2. **Test Cases:**
    - Create a test class under `src/test/java/com/example/tests`.
    - Write test methods using TestNG annotations (`@Test`).

Example Test Class:

```java
package com.example.tests;

import com.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");
        // Add assertions
    }
}
```

## Running Tests

In your terminal or IDE, run:

```bash
mvn test
```
