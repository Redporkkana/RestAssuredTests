# RestAssuredTests

Automated API testing project using [Rest Assured](https://rest-assured.io/) in Java.

## Overview

This repository contains automated tests for REST APIs using the Rest Assured framework. The main goal is to ensure API endpoints are functioning correctly and returning expected results.

## Features

- Write and execute HTTP integration tests fluently using Java
- Easily validate HTTP responses and payloads
- Supports common REST methods: GET, POST, PUT, DELETE, etc.
- Works well with build tools like Maven or Gradle

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven or Gradle
- An IDE like IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/Redporkkana/RestAssuredTests.git
   cd RestAssuredTests
   ```

2. Build the project with Maven:

   ```sh
   mvn clean install
   ```
   Or with Gradle:
   ```sh
   ./gradlew build
   ```

### Running Tests

To execute all tests:

```sh
mvn test
```
or
```sh
./gradlew test
```

## Contributing

Pull requests are welcome! See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

## License

This project is licensed under the [MIT License](LICENSE).

## Security

If you find a security vulnerability, please check [SECURITY.md](SECURITY.md) for reporting instructions.
