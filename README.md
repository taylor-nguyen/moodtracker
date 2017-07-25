This is a small mood tracker web application that captures the mood of individual, using:
1. Spring Boot 1.5.4
2. SpringMVC 4.3.9
2. MySQL 5.x
3. AngularJS 1.x
4. Bootstrap 3.x

Steps to run:
1. Run db_query.sql (under src/main/resources/static/db) to set up database and table
2. Update application.properties (under src/main/resources) with your database settings
3. Run mvn clean install on a command line or run it as a goal within an IDE i.e. Eclipse, IntelliJ IDEA
4. Run mvn spring-boot:run on the command line or run MoodTrackerApplication as a Java application
5. Access the app in localhost:8080/index.html
