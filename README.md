# Infrastructure

## Docker file
The Dockerfile refers to the ezxam.jar in the target. The name of the jar is defined in the pom under 
the tag: `finalName`. If the dev changes the name inside this tag, please change also the Dockerfile to refer to this
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