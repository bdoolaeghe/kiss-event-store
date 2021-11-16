# KISS Event Store
A **Keep It Simple Stupid Event Store**, based on a Postgres DB

## Content
* [kiss-es](kiss-es/) is the event-store library you can import from your java application
* [kiss-es-test](kiss-es-test/) is the test library you can import and use in your integration tests
* [kiss-es-spring-boot-starter](kiss-es-spring-boot-starter/) is the spring-boot-starter you can import in your spring-boot application
* [sample-kiss-es-app](sample-kiss-es-app/) is a sample spring-boot application, using the [kiss-es-spring-boot-starter](kiss-es-spring-boot-starter/)

## How it works
`kiss-event-store` is a simple event-store implementation, using a PostgreSQL database. 
It supports:
- protection against concurrent write (with optimistic lock)
- strong consistency between entities (based on usual DB transaction) 
- capability to mix consistent write of event sources entities with classic CRUD entities (using spring-jdbc, spring-data, or whatever)

## Usage
1. clone this project
2. Install in your repository :
```shell
# ./mvnw clean install
```
For spring-boot application, check  the [sample-kiss-es-app](sample-kiss-es-app/) for an example of usage:
3. import the `kiss-es-spring-boot-starter` in your event sourced project :
```xml
<dependency>
    <groupId>org.kiss</groupId>
    <artifactId>kiss-es-spring-boot-starter</artifactId>    
</dependency>
```
4. Start a postgres DB, and configure your datasource in spring-boot `application.yml`, e.g.:
```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    username: "postgres"
    password: "postgres"
    url: jdbc:postgresql://127.0.0.1:5432/
```
5. implement:
* your Repository class, extending `AbstractDbRepository<ENTITY_ID, ENTITY, EVENT_TYPE>`
* your ENTITY entity class
* your EVENT_TYPE classes
6. implement your integration tests on your repositories, using testcontainers and liquibase


