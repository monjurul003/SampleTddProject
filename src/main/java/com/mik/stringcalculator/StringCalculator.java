package com.mik.stringcalculator;

public class StringCalculator {

    public int add(String s) {
        int sum = 0;
        if (s.isEmpty()) {
            return sum;
        } else if (s.contains(",")) {
            String[] strList = s.split(",");
            sum = Integer.parseInt(strList[0]) + Integer.parseInt(strList[1]);
        } else {
            sum = Integer.parseInt(s);
        }
        return sum;
    }
}
