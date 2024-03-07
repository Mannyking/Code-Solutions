package code.solutions.strings;

import code.solutions.QuickCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {
    public static void main(String[] args) {
        System.out.println(solution("*(^*^_#", "^_"));
    }
// returns true if the first argument passed in ends with the 2nd argument
    public static boolean solution(String str, String ending) {
        int endLen = ending.length();
        str = str.substring(str.length() - endLen);
        return str.equals(ending);
    }

// function that turns a string into a Mexican Wave
    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char originalLetter = str.charAt(i);
            if (originalLetter == ' ') continue;
            char upperLetter = Character.toUpperCase(originalLetter);
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.setCharAt(i, upperLetter);
            list.add(stringBuilder.toString());
        }
        // Your code here
        return list.toArray(new String[0]);
    }

// correct the errors in the digitised text. You only have to handle the following mistakes:
//S is misinterpreted as 5
//O is misinterpreted as 0
//I is misinterpreted as 1
    public static String correct(String string) {
        string = string.replaceAll("S", "5");
        string = string.replaceAll("O", "0");
        string = string.replaceAll("I", "1");
        return string;
    }

// function will break up camel casing, using a space between words
    public static String camelCase(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            System.out.println(result);
            if (Character.isUpperCase(input.charAt(i))) result += " ";
            result += input.charAt(i);
        }
        return result;
    }

// reversed strings
    public static String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

// number (count) of vowels in the given string
    public static int getCount(String str) {
        Pattern pattern = Pattern.compile("aeiou");
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

// Remove all the vowels in a string
    public static String removeVowels(String str) {
        String result;
        result = str.replaceAll("[aeiouAEIOU]", "");
        return result;
    }

// function printer_error which given a string will return the error rate of the printer as a string representing a rational
// whose numerator is the number of errors and the denominator the length of the control string. Don't reduce this fraction to a simpler expression
    public static String printerError(String s) {
        Pattern pattern = Pattern.compile("(?i)[n-z]");
        Matcher matcher = pattern.matcher(s);
        int start = 0;

        while (matcher.find()) {
            start++;
        }
        return start + "/" + s.length();
    }

// given a string of words, return the length of the shortest word(s)
    public static int findShort(String s) {
        String[] strings = s.split(" ");
        int result = strings[0].length();
        for (String string : strings) {
            if (string.length() < result) {
                result = string.length();
            }
        }
        return result;
    }
}
