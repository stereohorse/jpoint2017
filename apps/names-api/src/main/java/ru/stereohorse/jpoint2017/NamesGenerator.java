package ru.stereohorse.jpoint2017;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NamesGenerator {

    private static final String[] NAMES = new String[] {
        "Java",
        "NodeJs",
        "печенька"
    };


    private final Random random = new Random();


    public String nextName() {
        return NAMES[random.nextInt(NAMES.length)];
    }
}
