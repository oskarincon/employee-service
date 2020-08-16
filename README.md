# employee-service
Repository has below projects                                      
**1 : employee crud** - Rest API For CURD 

**[JAVA 8 + Spring Boot + redis + docker]*

**Build and run the app using maven** 

you must first compile and create the jar file

```bash
cd ../Employed
mvn clean install
//it will build the project and will create docker image

docker build -t employee:1.0 .

```
run `docker-compose up` in docker  with imagen create  and begin the service to run http://localhost:8080/