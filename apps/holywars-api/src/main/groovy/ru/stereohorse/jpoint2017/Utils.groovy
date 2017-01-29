package ru.stereohorse.jpoint2017

import com.fasterxml.jackson.databind.ObjectMapper

class Utils {

    static String readJsonVal(String jsonStr) {
        return new ObjectMapper().readTree(jsonStr).get("value").toString().replace("\"", "")
    }
}
