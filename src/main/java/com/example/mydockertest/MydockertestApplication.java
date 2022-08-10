package com.example.mydockertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication()
@EnableSwagger2
public class MydockertestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydockertestApplication.class, args);
    }

}
