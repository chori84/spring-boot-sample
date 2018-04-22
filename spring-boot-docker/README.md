# Spring Boot with Docker

https://spring.io/guides/gs/spring-boot-docker/

```
./mvnw install dockerfile:build
docker run -p 8088:8080 -t chori/spring-boot-docker
```

Using Spring Profile
```
$ docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 -t chori/spring-boot-docker
```
