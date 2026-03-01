# Week 2 – Modern Java Refresher & Development Workflow

## Overview

Welcome to Advanced Java Programming.

This week is designed to reactivate your knowledge of Java fundamentals and introduce the modern features we will use throughout this course (Java 17+). Even if you have taken Java before, this course assumes fluency with the language and professional development practices.

You will:
* Verify your development environment
* Review core language fundamentals
* Practice modern Java features
* Work in GitHub Codespaces
* Submit your work via Pull Request

This is both a technical refresher and a professional workflow refresher.

### How to Use This Repository

This repository not only contains your assignment intructions, but also the scaffolding for your assignment submission.  You will create a [gitlab codespace](https://docs.github.com/en/codespaces/developing-in-a-codespace/creating-a-codespace-for-a-repository) which will automatically [fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) this repository and create a version in your github account that you can use.

Next, you'll create a [branch](https://docs.github.com/en/codespaces/developing-in-a-codespace/using-source-control-in-your-codespace#creating-or-switching-branches-1) (called a *feature branch*) where you will commit your code.  While we won't be really utilizing the full power of feature branches just yet, I want you to be comfortable with them as they will become important when we begin collaborating with our classmates in future projects.

[Commit](https://docs.github.com/en/codespaces/developing-in-a-codespace/using-source-control-in-your-codespace#committing-your-changes-1) your changes at LEAST after each assignment part, but you should commit them more often and include well-structured commit messages.

Finally, once you've completed all of your changes, you'll raise a [Pull Request](https://docs.github.com/en/codespaces/developing-in-a-codespace/using-source-control-in-your-codespace#raising-a-pull-request-1) against your `main` branch.  Once you've raised a Pull Request, a series of automated tests will run and indicate whether or not you've completed all parts of the assignment, and will give you a preliminary evaluation of your assignment.

You can raise a pull request once, and then continue to commit multiple times after the pull request has been raised.  Each time you commit and push to your repository, the pull request will automatically update and the automated tests will re-run.  You can submit them as many times as you'd like.

#### How to build and run your project

NOTE: While you can use the `javac` and `java` commands to compile and run your project, we'll start with professional tools early and often in this course by using maven to build and run your app.

Take a look at the `pom.xml` file in the root of this repository if you'd like to get a better understanding of how this project is structured.

For now, you can build and run the tests for both parts of your project by using the following command:

```bash
mvn clean test
```

The error outputs will help you better understand the gaps between your project and the expected results.

You can also build and run each project independently by using the following commands:

```bash
# Build and run the alerts mini-app
mvn compile exec:java -Prun-app

# Build and run the Demo (language basics review and moden features demo)
mvn compile exec:java -Prun-demo
```

You can use this to test each part of your assignment independently.

### FINAL SUBMISSIONS

For your final submission, you'll copy/paste a link to your pull request in github into the submission box in Canvas.

## Part 1 – Environment Setup & Verification

In this course we will use Java 17 or later.

If you are developing locally, download and install the latest JDK from:

https://dev.java/download/

If you are using GitHub Codespaces (recommended), verify the installed version by running:

```bash
java -version 2&> java_version.txt
javac -version 2&> javac_version.txt
```

### Submission Requirement

Your submission will include these two text files - make sure you have the correct java version (>17) before proceeding.

## Part 2 – Guided Review: Getting Started

Complete the Getting Started section of the official dev.java tutorial:

[https://dev.java/learn/getting-started/](https://dev.java/learn/getting-started/)

Follow along by compiling and running all example programs in your development environment.

Do not just read — type and execute the examples yourself.

### Submission Requirement
There is no submission requirement for this part, but you should complete it before moving on to the next part of the assignment.

## Part 3 – Java Language Basics Review

Review the Java Language Basics section:

[https://dev.java/learn/language-basics/](https://dev.java/learn/language-basics/)

If you previously learned Java 8, some features will be new to you (for example, var was introduced in Java 10).

As you review, make sure you are comfortable with:

* Primitive vs reference types
* Variables and type inference (var)
* Control flow (if/else, loops)
* Switch expressions (modern switch syntax)
* Methods and overloading
* Access modifiers
* Packages
* Exceptions
* Arrays
* Collections (especially List)

### Submission Requirement
There is no submission requirement for this part, but you should complete it before moving on to the next part of the assignment.

## Part 4 – Implementation Assignment

You will now demonstrate your understanding by creating two Java files in your repository.

**NOTE: All of your files should be placed in the subfolder for this package (namely, the `src/main/....` directory of your project (the one with the `CODE_GOES_HERE.md` file).

### File 1: LanguageBasicsReview.java

Create a class that demonstrates the following:
* A standard instance method
* A static method
* An overloaded method
* A List using List.of(...)
* A try/catch block
* A custom exception class
* A modern switch expression
* Use of var

This file should compile and run.

You may organize it however you like, but all required elements must be present.

A template of this program can be found in the `src/main/java/edu/norcocollege/cis18b/week2/demo` folder.

### File 2: ModernFeaturesDemo.java

Create a class that demonstrates modern Java features. Your program must include:

* A record type
* Pattern matching with instanceof
* A switch expression
* Use of Optional
* A basic Stream operation
* A text block (""")

The purpose of this file is to ensure you are comfortable with features beyond Java 8.

A template of this program can be found in the `src/main/java/edu/norcocollege/cis18b/week2/demo` folder.

### Submission Requirement
Your PR should have the `src/LanguageBasicsReview.java` and `src/ModernFeaturesDemo.java` files, and they should pass all of the automated tests.

## Part 5 – Mini Challenge: Cybersecurity Alert System

To give you some practice, you are building a simplified cybersecurity alert tracking system.

Your task is to design and implement a small in-memory system that tracks security alerts detected by a (fake) monitoring service.

### Requirements
#### Create a record named SecurityAlert

The record must contain:
* `String id`
* `String sourceSystem`
* `String severity` (LOW, MEDIUM, HIGH, CRITICAL)
* `String description`
* `long timestamp`

#### Create a SecurityAlertManager class

This class must:

* Store alerts in a List
* Provide the following methods:
```void addAlert(SecurityAlert alert)
Optional<SecurityAlert> findById(String id)
List<SecurityAlert> findBySeverity(String severity)
boolean removeAlert(String id)
```

#### Use Modern Java Features

Your implementation must demonstrate:

* Use of Optional
* Use of Streams for filtering
* A switch expression for severity handling
* Pattern matching with instanceof
* Use of var
* At least one text block (""")

#### Add Severity Logic

Create a method:

```java
String getSeverityRecommendation(SecurityAlert alert)
```

Then use a modern switch expression to return recommendations:

* LOW → "Log and monitor."
* MEDIUM → "Investigate within 24 hours."
* HIGH → "Escalate to engineering."
* CRITICAL → "Immediate incident response required."

#### Demonstration / Test Harness

The demonstration harness can be found in the `src/main/java/edu/norcocollege/cis18b/week2/alerts` directory.

Update the main method that:

* Creates multiple alerts
* Adds them to the manager
* Queries by severity
* Looks up an alert by ID
* Prints formatted output using a text block

Example output formatting:

```java
System.out.println("""
    === SECURITY ALERT REPORT ===
    Total Alerts: %d
    High Severity Alerts: %d
    """.formatted(total, highCount));
```

### Submission Requirement
Your PR should have the `SecurityAlert.java`, `SecurityAlergManager.java`, and `SecurityAlertMain.java` files, and they should pass all of the automated tests.

#### Stretch Goal (Optional)

If you want to get some extra practice, you can do the following:

* Make severity an enum instead of a String.
* Make the manager thread-safe.
* Prevent duplicate IDs.
* Sort alerts by timestamp.
* Make the record immutable (it already is - explain why).

## Submission

The expected final submission is a link to the Pull Request you created against your main branch.  Once you've created a pull request (see the "Overview" section to find out how), copy the URL / link for your Pull Request and paste into the submission box in Canvas.

### Requirements:
* Create a feature branch.
* Make at least three meaningful commits.
* Use clear commit messages.
* Open a Pull Request to the main branch.
* Your PR must include:
    * Output of java -version
    * One Java feature that was new to you
    * One concept you feel less confident about
    * Any challenges you encountered

## Grading Criteria

You will be graded on:
* Correct use of Java 17+ features
* Code compiles and runs
* Clean, readable structure
* Proper use of Git and PR workflow
* Completeness of required features

For a more complete rubric, please see the rubric attached to this assignment in Canvas.

### Why This Matters

This is an advanced course. We will move quickly into:

* Generics
* Design patterns
* Concurrency
* Collections internals
* Exception architecture
* Functional interfaces
* JDBC and networking
* Larger system design

You must be comfortable with the fundamentals before we build on them.

If you finish early, improve your SecurityAlert design. Think about:

* Encapsulation
* Immutability
* API design clarity
* Error handling

We will revisit this code later in the semester.