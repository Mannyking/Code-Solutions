package code.solutions.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {
    public static void main(String[] args) {
        System.out.println(solution("world"));
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
}
