package ru.stereohorse.jpoint2017;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@SpringBootApplication
@RestController
@Slf4j
public class TransactionsApi {

    @Autowired
    private TransactionsService transactionsService;


    @RequestMapping(value = "/transactions", method = POST)
    public void makeTransaction(@RequestBody Transaction transaction) {

        log.info("v1 processing {}", transaction);

        transactionsService.makeTransaction(transaction);
    }


    public static void main(String... args) {
        SpringApplication.run(TransactionsApi.class, args);
    }
}


@Data
class Transaction {

    private String fromUser;
    private String toUser;

    private String amount;
}
