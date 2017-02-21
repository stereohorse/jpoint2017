package ru.stereohorse.jpoint2017;


import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.Data;


@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
public class HolywarsApi {

    @Autowired
    private ReasonsGenerator reasonsGenerator;

    @Autowired
    private NamesApiClient namesApi;


    @RequestMapping("/holywar")
    public HolywarResponse getHolywar() {

        return new HolywarResponse(
            format("%s круче чем %s, потому что %s",
                fetchName(),
                fetchName(),
                reasonsGenerator.nextReason())
        );
    }

    private String fetchName() {
        return namesApi.getName().getName();
    }


    public static void main(String... args) {
        SpringApplication.run(HolywarsApi.class, args);
    }
}


@Data
class HolywarResponse {

    private final String holywar;
}
