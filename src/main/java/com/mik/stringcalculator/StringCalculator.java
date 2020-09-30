package com.mik.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String s) {
        int sum = 0;
        if (s.isEmpty()) {
            return sum;
        } else if (s.contains(",")) {
            List<Integer> list = stringToIntMap(tokenize(s));
            sum = sum(list);
        } else {
            sum = Integer.parseInt(s);
        }
        return sum;
    }

    private int sum(List<Integer> list) {
        return list.stream().reduce(0, (a, b) -> a + b);
    }

    private List<Integer> stringToIntMap(List<String> list) {
        return list.stream().map(str -> Integer.parseInt(str)).collect(Collectors.toList());
    }

    private List<String> tokenize(String s) {
        return Arrays.asList(s.split(","));
    }
}
