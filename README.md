# Blog App Project

## Project Introduction

* This is a back-end java project building REST API's using Spring Boot, Spring Security, JWT, Spring Data JPA, Hibernate, MySQL, Docker and Deploy on AWS.

## Application Features

* Posts Management  
  - Create, Read, Update and Delete Posts. Provide Pagination and Sorting support
* Comments Management 
  - Create, Read, Update and Delete Comments for Blog Post (One to Many)
* Authentication and Authorization 
  - Register, Login and Security
* Category Management 
  - Create, Read, Update and Delete Category

## Technology Stack

* Java Frameworks: Spring Framework(Spring Boot, Spring Security and Spring Data JPA)
  - Spring Boot: create and bootstrap Spring based applications
  - Spring Security: implement authentication and authorization
  - Spring Data JPA: develop a DAO layer
* Token Based Authentication: JWT (JSON Web Token)
* Build Tool: Maven
* Server: Tomcat embedded server
* Database: mySQL database
* REST Client: Postman
* Cloud for Deployment: AWS

## Architecture

#### Spring Boot Architecture
<img width="700" alt="截屏2023-01-31 下午5 49 43" src="https://user-images.githubusercontent.com/117619304/215925291-51102bc9-1b6b-4471-a98a-151bd6984d30.png">

#### REST API
<img width="700" alt="截屏2023-01-31 下午5 51 31" src="https://user-images.githubusercontent.com/117619304/215925499-665c361d-389b-4119-a630-7afdbad0c874.png">

## DAO Layrer (Repository)

### entity 

* Post - CRUD REST APIs with Pagination and Sorting and mapped by categories
* Comment - CRUD REST APIs mapped by posts 
* User - Register and Login REST APIs; Secure APIs using JWT
* Roles - Limiting user access by assigning user roles (with ADMIN having acess to create, delete and post while USER having access to GET)
* Catagory - CRUD REST APIs mapping posts to certain categories

### repository
* Extends JpaRepository, equipped with basic paging and sorting functions and CRUD dunctions to fetch info in DB

## Service Layer

### service
* Provides business logic and build detailed functions for each entity
### serviceImpl
* Implements service

## Controller (REST API)
#### REST API Design for Post Resource

| HTTP METHOD | URL PATH                                         | STATUS CODE | DESCRIPTION                     |
|-------------|-----------------------------------------------   |-------------|---------------------------------|
| GET         | /api/v1/posts                                    | 200 OK      | Get all posts                   |
| GET         | /api/v1/posts/{id}                               | 200 OK      | Get post by id                  |
| POST        | /api/v1/posts                                    | 201 Created | Create a new post               |
| PUT         | /api/v1/posts/{id}                               | 200 OK      | Updating existing posts with id |
| DELETE      | /api/v1/posts/{id}                               | 200 OK      | Delete post by id               |
| GET         | api/v1/posts?pageSize=5pageNo=1&sortBy=firstName | 200 OK      | Paginating and soring posts     |

#### REST API Design for Comment Resource

| HTTP METHOD | URL PATH                             | STATUS CODE | DESCRIPTION                                                 |
|-------------|-----------------------------------   |-------------|-------------------------------------------------------------|
| GET         | /api/v1/posts/{postId}/comments      | 200 OK      | Get all comments which belongs to post with id =postId      |
| GET         | /api/v1/posts/{postId}/comments/{id} | 200 OK      | Get comment by id if it belongs to post with id = postId    |
| POST        | /api/v1/posts/{postId}/comments      | 201 Created | Create a new comment for post with id = postId              |
| PUT         | /api/v1/posts/{postId}/comments/{id} | 200 OK      | Update comment by id if it belongs to post with id = postId |
| DELETE      | /api/v1/posts/{postId}/comments/{id} | 200 OK      | Delete comment by id if it belongs to post with id= postId  |

#### REST API Design for Sign up and Signin/Login system (Authentication)

| HTTP METHOD   | URL PATH         | STATUS CODE   | DESCRIPTION   |
|---------------|------------------|---------------|---------------|
| POST          | /api/v1/auth/signup | 200 OK        | Sign Up       |
| POST          | /api/v1/auth/signin | 200 OK        | Sign In       |

#### REST API Design for Category Resource

| HTTP METHOD | URL PATH               | STATUS CODE | DESCRIPTION                     |
|-------------|------------------------|-------------|---------------------------------|
| POST        | /api/v1/categories        | 200 Created | Create a new category           |
| GET         | /api/v1/categories/{id}   | 200 OK      | Get category by categoryId      |
| GET         | /api/v1/categories        | 201 OK      | Get all categories              |
| PUT         | /api/v1/categories/{id}}  | 200 OK      | Update category by categoryId   |
| DELETE      | /api/v1/categories/{id}}  | 200 OK      | Delete category by categoryId   |

## DTO (between view layer and controller layer)
### payload
* Data Transfer Object (DTO) defines how to send data over the network and would hide detailed implementation of JPA entities and send DTo rather than entity back to the client. 

## JSON 

## Remaining Issues - API Documents
* Swagger does not have proper support in Spring Boot 3, while SpringDoc Open API does not have proper support for Spring Security 6 and JWT
* The project will be updated for API Docs part after SpringDoc Open API releases official docs
