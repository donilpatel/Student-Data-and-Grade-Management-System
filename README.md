# Student Data and Grade Management System

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

---

## Overview
The **Student Data and Grade Management System** is a Java-based application designed to process and manage student records. It reads input files containing student data, calculates final grades using weighted averages, and outputs the results in a sorted format. This project adheres to Object-Oriented Programming principles and integrates robust error-handling mechanisms to ensure reliability.

---

## Features
- Processes and aggregates student records from input files.
- Calculates final grades using customizable weighted averages.
- Outputs results sorted by specified criteria (e.g., alphabetical order, grade).
- Modular and extensible architecture, leveraging:
  - Encapsulation
  - Inheritance
  - Polymorphism
- Supports flexibility with a `GradedEntity` interface for handling diverse graded entities.
- Robust error handling for input validation, file operations, and program reliability.
- Comprehensive documentation with UML diagrams and adherence to SOLID principles.

---

## Technologies Used
- **Programming Language**: Java
- **Concepts**:
  - Object-Oriented Programming (OOP)
  - File Handling
  - Error Handling
- **Design Principles**:
  - SOLID Principles
  - Modular Design

---

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/student-grade-management-system.git
   cd student-grade-management-system
   ```

2. **Compile the Java Files**:
   Ensure you have Java installed on your system.
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the Application**:
   ```bash
   java -cp bin Main
   ```

---

## Usage
1. Place the student data input files in the specified directory (`data/` by default).
2. Run the application as described above.
3. Follow the prompts to specify the input file, grading criteria, and output preferences.
4. Review the output file containing sorted results in the `output/` directory.

---

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes with descriptive messages.
4. Push to your branch and create a pull request.
