package ru.stereohorse.jpoint2017.eurekaserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaServer.class)
            .web(true)
            .run(args);
    }
}
