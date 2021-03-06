# Swagger generated server

Spring Boot Server 


## Overview  
This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  
This is an example of building a swagger-enabled server in Java using the SpringBoot framework.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties

## Installation
To compile app:
* install java8 and maven. In project root catalog type ```mvn clean install``` then in target directory run jar file using command ```java -jar *.jar```
* install node.js and npm. In front/e-sport dorectory type ```npm i``` and then ```ng serve```

Frontend app will be available on port 4200. Backend is available on port 8080.

## Accessibility
App is available on:
* https://e-sport-client.herokuapp.com
* https://e-sport-api.herokuapp.com

Sometimes app need some time to start!

## Functionality
##### Login
Default inserted to DB during app initialization process are:
* user1 / user1
* user2 / user2

This account need to be used to login to app. When the wrong password was given in panel, the appropriate message will be presented.

##### Event view
Two new event are inserting during DB initialization process. This view is presented when user is logged correctly. User can press ```view``` button to show event details.

##### Single event view
View presents all available event information and comments related to event.

##### Add comment
User can add comment to event. All event are sorted by creation date.

##### Remove event
User can remove event. If user is not owner of comment button is not visible.

##### Remove event
User can edit event. If user is not owner of comment button is not visible.

##### Vote for event
User can inform that is interested in event. If user own event post button is not visible.

##### Remove vote for event
User can remove vote for an event. If user not voted for event then button is not visible.

##### Validations
All data are also validated on BE site.