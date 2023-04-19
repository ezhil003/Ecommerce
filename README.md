# Ecommerce Application

       This project is an Ecommerce Application that allows Admin to add, update,view products,delete products in their Ecommerce whereas user can review products,add to 
       cart and order products. It includes microservices for products, authentication and generating reports. 

# Prerequisites

       • Java 11 or later • Spring Boot 2.4.3 or later • Maven 3.6.3 or later

# Installation
       To install the project on a local machine, follow these steps:

       Clone the repository from GitHub. Install Java 8 or later on your local machine. Install the Maven build tool. Open the project in your preferred IDE. Build the 
       project using Maven. Run the application by executing the main class.

# Usage 
       Provide instructions on how to use the application from a shopper's perspective, including browsing products by category, searching for products by keyword, viewing 
       product details, adding items to the cart, and checking out.

# Admin Functionality
       Provide instructions on how to access the admin interface, and the functionality available to administrators, including managing inventory, processing orders, 
       managing customer accounts, and generating reports.

# Technologies used
       The application is built using the following technologies:

       Java Spring Boot Spring Cloud Eureka Feign Maven

# Architecture
       The Ecommerce Application is designed as a microservice-based architecture. The application consists of three microservices, a Eureka server, and a centralized 
       database. The microservices communicate with each other using the Feign client and are registered with the Eureka server. The Eureka server acts as a service 
       registry and facilitates service discovery. The centralized database is used to store the details and data of each service.

# Configuration
      To configure the application, you can modify the application.properties files for each microservice. The files contain properties for configuring the database 
      connection, server port, and other settings. You can also modify the Feign clients to change the endpoints used to check the  other service.

# Database Setup
      Create a Ecommerce database for all the microservices to share. Create the necessary tables for the Ecommerce Application. There should be at 
      least one table for storing the details of the services being monitored. Create a readonly user for the Ecommerce Application database. There should be using in 
      Ecommerce Microservice. If required, set up user accounts and permissions for accessing the database. Note: Make sure to provide the necessary details for 
      connecting to the database in the configuration files of the microservices.
