package ru.stereohorse.jpoint2017;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;


@SpringBootApplication
@RestController
public class HolywarsApi {

    @Autowired
    private ReasonsGenerator reasonsGenerator;

    @Value("${api.names.url:http://localhost:8080/name}")
    private String namesApiUrl;


    private RestTemplate restClient = new RestTemplate();


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
        return restClient
            .getForObject(namesApiUrl, NameResponse.class)
            .getName();
    }


    public static void main(String... args) {
        SpringApplication.run(HolywarsApi.class, args);
    }
}


@Data
class HolywarResponse {

    private final String holywar;
}

@Data
class NameResponse {

    private final String name;
}
