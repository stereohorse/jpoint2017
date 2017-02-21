package ru.stereohorse.jpoint2017;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class NamesApi {

    @Autowired
    private NamesGenerator namesGenerator;


    @RequestMapping("/name")
    public NameResponse getName() {
        return new NameResponse(namesGenerator.nextName());
    }


    public static void main(String... args) {
        SpringApplication.run(NamesApi.class, args);
    }
}


@Data
class NameResponse {

    private final String name;
}
