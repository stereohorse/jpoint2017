package ru.stereohorse.jpoint2017;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
class ReasonsGenerator {

    private static final String[] REASONS = new String[] {
        "меньше памяти жрет",
        "хотя бы не падает",
        "написали прямыми руками"
    };


    private final Random random = new Random();


    String nextReason() {
        return REASONS[random.nextInt(REASONS.length)];
    }
}
