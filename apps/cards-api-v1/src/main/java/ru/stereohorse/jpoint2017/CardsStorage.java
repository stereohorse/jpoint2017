package ru.stereohorse.jpoint2017;

import org.springframework.stereotype.Repository;

import static java.lang.String.format;

@Repository
public class CardsStorage {

    String userOf(String card) {
        return format("[user of card %s]", card);
    }
}
