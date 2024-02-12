# Spring Circuit Breaker Samples
Circuit Breaker Samples using Spring Boot

<img src="https://github.com/susimsek/spring-circuitbreaker-samples/blob/main/images/introduction.png" alt="Spring Boot Circuit Breaker Samples" width="100%" height="100%"/> 

# Circuit Breaker

Circuit Breaker is implemented via a finite state machine with three states: CLOSED, OPEN and HALF_OPEN.  

<img src="https://github.com/susimsek/spring-circuitbreaker-samples/blob/main/images/circuit-breaker.png" alt="Spring Boot Circuit Breaker" width="100%" height="100%"/>  

When the “circuit” is CLOSED, requests can reach the service, when it is OPEN it fails immediately. After a period of time OPEN it moves to HALF_OPEN, if the failures are below the threshold it moves to CLOSED, or returns to OPEN otherwise.

## Prerequisites

* Java 17
* Kotlin
* Maven 3.x


## Build

You can install the dependencies and build by typing the following command

```sh
mvn clean install
```

## Testing

You can run application's tests by typing the following command

```
mvn verify
```


## Code Quality

You can test code quality locally via sonarqube by typing the following command

```sh
mvn -Psonar compile initialize sonar:sonar
```

## Detekt

Detekt a static code analysis tool for the Kotlin programming language

You can run detekt by typing the following command

```sh
mvn antrun:run@detekt
```

## Docker

You can also fully dockerize  the sample applications. To achieve this, first build a docker image of your app.
The docker image of sample app can be built as follows:


```sh
mvn verify jib:dockerBuild
```

# Used Technologies
* Java 17
* Kotlin
* Docker
* Sonarqube
* Detekt
* Checkstyle
* Spring Boot 3.x
* Spring Boot Web
* Spring Boot Validation
* Spring Boot Actuator
* Spring Cloud Circuit Breaker Resilience4j
* Spring Boot Aop
* Spring Cloud Openfeign
* Springdoc Openapi Webmvc UI
* Mapstruct
* Lombok