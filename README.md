# Project 2: Mechanic Shop Management System - Back End
## Mechanic Shop Management System - Back End
The purpose of the Mechanic Shop Management System is to provide a structured and organized way for an auto mechanic to track work orders and charge customers appropriate amounts for work performed.
Employees can login to the system to view, update, and create new work orders.

## Technologies Used
- Java 8 or higher, utilizing multiple apis
  - Apis used include:
    - Spring Boot
    - Spring Data/JPA
    - Spring MVC
    - Spring DevTools for debugging
    - Spring Security
    - Maven for dependency management
    - PostgreSQL for database manipulation
    - Google GSON for JSON manipulation
    - Java Web Tokens for authorization tracking

## Features
- Employees can login
- Employees can create new work orders
- Employees can add new customers and vehicles to the system
- Employees can update submitted work orders with new parts/labor costs if needed
- Employees can mark a work order as complete when work has been completed

## Getting Started
- To begin using this software, make sure you have the [Java 8 JDK (or higher version)](https://www.oracle.com/java/technologies/javase-downloads.html) installed.
- You will also need [Spring Tool Suite](https://spring.io/tools).
- You also need to have [Apache Maven](https://maven.apache.org/) installed.
- You must also [download](https://git-scm.com/downloads) and [install](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) Git.
- After you have installed Maven and Git, open Git Bash in the directory of your choice and run the following command<br>
  `git clone https://github.com/Revature-Batch-2105-Project-2/Project-2-Backend.git`
- When you have all of the software installed and have cloned the repository, open Spring Tool Suite and Import an Existing Maven Project.
  - In the window that pops up, navigate to the directory you cloned the repository into and click on the `pom.xml` file.
  - Maven will read the file, and will download all of the required dependencies.
- After Maven has finished building the project, click the green Run button at the top of STS to run the program.
  - Once you have the project running in STS, you will also need to download and run the [front end codebase](https://github.com/shadekiller666/Revature-Project_2-Front_End).

## Usage
- With both the front and back end codebases running, go to [localhost:4200](http://localhost:4200) and you should see a login page.
  - On the login page enter username "dummy" and password "dummy" and click the login button.
- Once logged in, you should see a list of work orders in the system, you can click on one of the rows in the list to view a specific work order.
- You can also click on one of the boxes at the top to change what the list displays.
- To add a new work order, click "New Work Order" on the navbar at the top.
- To create a new customer, click "New Customer" on the navbar at the top.
- To view the work order history of a specific vehicle or customer, click "History" at the top of the page and begin typing in the search boxes on the page.

## Contributors
- [Gerald Stillman](https://github.com/shadekiller666)
- [Paul Athmer](https://github.com/pathmer)
- [Cory Haas](https://github.com/blueflotsam)
- [Tom Vang](https://github.com/tvang8394)
