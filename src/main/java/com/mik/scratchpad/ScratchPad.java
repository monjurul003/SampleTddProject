package com.mik.scratchpad;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScratchPad {
    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    public static String insertPipeChar(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        int len = s.length();
        int pos = 3, i = 0;

        while(pos<len) {
            s = addChar(s, '|',pos+i);
            pos += 3;
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2");
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numberString = matcher.group(2);
        List<String> strList =Arrays.asList(numberString.split(customDelimiter));
        strList.forEach(System.out::println);
//
//        String str = "//[;][%][,]\n1,2;3%4";
//        Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(str);
//        matcher.matches();
//        String customDelimeter = matcher.group(1);
//        System.out.println(customDelimeter);
//
//        String numbers = matcher.group(2);
//        System.out.println(numbers);
//        System.out.println(Pattern.quote(customDelimeter));
//        List<String> strList = Arrays.asList(numbers.split(Pattern.quote(customDelimeter)));
//        strList.forEach(System.out::println);
//
//        str = "1,2;3%4";
//        String[] s = str.split("[,;%]");
//        Arrays.asList(s).forEach(System.out::println);
//        String sp = insertPipeChar("[,][;][%]");
//        System.out.println(sp);
//        System.out.println("************");
//        str = "1***2***3";
//        s = str.split("[*]+");
//        System.out.println(s.length);
//        Arrays.asList(s).forEach(System.out::println);
    }
}
