package com.mik.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringCalculator {

    public int add(String s) {
        List<Integer> list = stringToIntMap(tokenize(s));
        return sum(list);
    }

    private boolean customDelimited(String s) {
        return s.startsWith("//");
    }

    private int sum(List<Integer> list) {
        return list.stream().reduce(0, (a, b) -> a + b);
    }

    private List<Integer> stringToIntMap(List<String> list) throws RuntimeException {
        List<Integer> numList = list.stream().map(str -> Integer.parseInt(str)).collect(Collectors.toList());
        List<Integer> negativeList = Arrays.asList(numList.stream().filter(i -> i < 0).toArray(Integer[]::new));
        if (negativeList.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeList);
        }
        return Arrays.asList(numList.stream().filter(i -> i<1000).toArray(Integer[]::new));
    }

    private List<String> tokenize(String s) {
        if (s.isEmpty()) {
            return new ArrayList<String>();
        } else if (customDelimited(s)) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(s);
            matcher.matches();
            String customDelimiter = matcher.group(1);
            String numberString = matcher.group(2);
            return Arrays.asList(numberString.split(customDelimiter));
        } else {
            return commaAndnewLineDelimitedString(s);
        }
    }

    private List<String> commaAndnewLineDelimitedString(String s) {
        return Arrays.asList(s.split(",|\n"));
    }
}
