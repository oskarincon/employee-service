# employee-service 
Repository has below projects                                      
**1 : employee service** - Rest API For CURD 

**[JAVA 8 + Spring Boot + redis + docker]*

**Build and run the app using maven** 

you must first compile and create the jar file

## Build
```bash
//first you must download the project  
mkdir <name-folder>
clone respository
cd <name-folder>/employee-service

//build it with maven
mvn clean install

//it will build the project and will create docker image

docker build -t employee:1.0 .

```
run `docker-compose up` in docker  with imagen create  and begin the service to run http://localhost:8080/