package ru.stereohorse.jpoint2017;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
class NamesGenerator {

    private static final String[] NAMES = new String[] {
        "Java",
        "NodeJS",
        "печенька",
        "Clojure",
        "singleton",
        "heap",
        "hashmap",
        "Hazelcast",
        "Gradle",
        "Maven"
    };


    private final Random random = new Random();


    String nextName() {
        return NAMES[random.nextInt(NAMES.length)];
    }
}
