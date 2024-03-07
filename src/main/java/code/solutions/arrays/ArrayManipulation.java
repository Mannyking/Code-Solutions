package code.solutions.arrays;
import java.util.*;

public class ArrayManipulation {
    public static void main(String[] args) {
        String[] a = {"tree", "filing", "trashy", "abc-def", "uvwxyz"};
        System.out.println(Arrays.toString(removeEveryOther(a)));
    }

// Take an array and remove every second element from the array
    public static Object[] removeEveryOther(Object[] arr) {
        int size = (int) Math.ceil(arr.length / 2.0);
        Object[] result = new Object[size];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
           if (i % 2 == 0) {
               result[counter] = arr[i];
               counter++;
           }
        }
        return result;
    }
// function that takes an array of words and smashes them together into a sentence and returns the sentence
    public static String smash(String... words) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(" ").append(words[i]);
        }
        return result.toString().trim();
    }


    // given an array(list) strarr of strings and an integer k return the first longest string consisting of k consecutive strings taken in the array
    public static String longestConsec(String[] strarr, int k) {
        Map<Integer, String> map = new HashMap<>();
        if (strarr.length == 0 || k > strarr.length || k <= 0) return "";

        int saveNumber = 0;
        for (int i = 0; i <= strarr.length - k; i++) {
            String joining = "";
            for (int j = i; j < i + k; j++) {
                joining += strarr[j];
            }
            if (!map.containsKey(joining.length())) map.put(joining.length(), joining);
            if (joining.length() > saveNumber) saveNumber = joining.length();
        }
        return map.get(saveNumber);
    }

// create a new list that contains each number of list at most N(maxOccurrences) times, without reordering
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int element : elements) {
            map.put(element, map.getOrDefault(element, 0) + 1);
            if (map.get(element) <= maxOccurrences) list.add(element);
            System.out.println("Updated Hashmap values: " + map.entrySet());
        }
        System.out.println(list);
        elements = new int[list.size()];
        for(int i = 0; i < elements.length; i++) {
            elements[i] =list.get(i);
        }
        return elements;
    }

// function that removes the spaces from the values and returns an array showing the space decreasing.
// ['i', 'have','no','space'] -> ['i','ihave','ihaveno','ihavenospace']
    public static String[] spacey(String[] array) {
        String result = "";
        int start = 0;
        for (String string : array) {
            result += string;
            array[start] = result;
            start++;
        }
        return array;
    }

// given an odd-length array of integers, in which all of them are the same, except for one single number
// Complete the method which accepts such an array, and returns that single different number
    static int stray(int[] numbers) {
        Arrays.sort(numbers);
        if (numbers[0] != numbers[1]) {
            return numbers[0];
        }
        else return numbers[numbers.length - 1];
    }

// function which calculates the average of the numbers in a given list
    public static double findAverage(int[] array){
        double sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum/array.length;
    }

// Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers
// 0 is neither positive nor negative
    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[]{};
        int positive = 0;
        int negative = 0;

        for (int j : input) {
            if (j < 0) {
                negative = j + negative;
            }
            else if (j > 0) {
                positive++;
            }
        }
        return new int[]{positive, negative};
    }

// Every day you rent the car costs $40.
// If you rent the car for 7 or more days, you get $50 off your total.
// Alternatively, if you rent the car for 3 or more days, you get $20 off your total.
    public static int rentalCarCost(int d) {
        int cost = d * 40;
        return (d >= 7) ? cost - 50 : (d >= 3) ? cost - 20 : cost;
    }
}
