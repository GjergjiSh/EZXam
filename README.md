# Infrastructure

## Docker file
The Dockerfile refers to the ezxam.jar in the target folder. Use "Maven package" to create it.
The name of the jar is defined in the pom under the tag: `finalName`. If the dev changes the name inside this tag, please change also the Dockerfile to refer to this
new name.

To create the image of this Docker file, use:
`docker build -t ezxam .`

The tag name `ezxam` is used also in the Docker-compose file. If you use another tag, please change it also in the
Docker compose file.

## Docker-compose
To run the docker-compose, create the application docker image (see above), then:
`docker-compose up`

### How to use local application with mysql DB
To run the application with the given mysql container, you can just run the mysql container in the docker compose file
and then start the application.

### Application properties
The environment configuration (besides for the url) for the docker-compose app part can be found in 
the application.properties 


# Use cases
1) Professor can register or login to the application. The login/registration is just made of name, username and password.
2) Once the professor is logged in, he wants to see the list of his subjects. This list should include:
2.1) name of the subject
3) For each subject the professor wants to create and edit questions
3.1) For each question, he should be able to define criteria for good answers
3.2) Whenever he edits a score for a question, a **trigger** should update the score of the others by given criteria
4) He should be able to filter out the questions (optional)
5) He should be able to start an exam for each subject
6) Once he creates an exam, he should be able to assign a student to it
7) Before starting the exam, the professor should be able to select a time limit for it
7.1) The professor should also be able to pause this timer during the exam
8) Based on the selected criteria, he should receive a suggested points and grade
9) He should be able to add notes to every answer
10) The result should be consistent over time
11) A **trigger** should adapt the students grade of that session (1 week) according to the normal distribution 
12) Based on the results of the exam session, a **trigger** should update a table containing data analysis of all sessions

## Transactions
For now, whenever we have an SQL statement, wrap it into a transactions
1) Whenever the professor edits multiple criteria, if the weights don't add up to 100%, commit the edited criteria until the last
change (not included)
2)   
