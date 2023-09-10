package com.acelerati.microservice.microservice_matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class MicroserviceMatriculaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceMatriculaApplication.class, args);
    }

}
