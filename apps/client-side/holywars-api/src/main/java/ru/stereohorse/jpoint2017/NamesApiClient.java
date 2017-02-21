package ru.stereohorse.jpoint2017;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.stereohorse.jpoint2017.entities.NameResponse;

@FeignClient("names-api")
public interface NamesApiClient {

    @RequestMapping(method = GET, value = "/name")
    NameResponse getName();
}
