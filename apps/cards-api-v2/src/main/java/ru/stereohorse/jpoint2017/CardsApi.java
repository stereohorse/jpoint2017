package ru.stereohorse.jpoint2017;


import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@SpringBootApplication
@RestController
@Slf4j
public class CardsApi {

    @Value("${transactionsApi.url}")
    private String transactionsApiUrl;

    @Autowired
    private CardsStorage cardsStorage;


    private RestTemplate restClient = new RestTemplate();


    @RequestMapping("/transactions")
    public void makeTransaction(@RequestBody CardToCardTransaction transaction) {

        log.info("processing {}", transaction);

        sendTransaction(new Transaction()
                .setAmount(transaction.getAmount())
                .setFromAccount(cardsStorage.accountOf(transaction.getFromCard()))
                .setToAccount(cardsStorage.accountOf(transaction.getToCard())));
    }

    private void sendTransaction(Transaction transaction) {
        restClient.postForLocation(URI.create(transactionsApiUrl), transaction);
    }


    public static void main(String... args) {
        SpringApplication.run(CardsApi.class, args);
    }
}


@Data
class CardToCardTransaction {

    private String fromCard;
    private String toCard;

    private String amount;
}

@Data
@Accessors(chain = true)
class Transaction {

    private String fromAccount;
    private String toAccount;

    private String amount;
}

