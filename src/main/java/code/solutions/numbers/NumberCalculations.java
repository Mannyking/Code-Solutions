package code.solutions.numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberCalculations {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        System.out.println(comp(a, b));
    }

// Given an array of integers, find the one that appears an odd number of times.
// There will always be only one integer that appears an odd number of times.
    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : a) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (Integer result : map.keySet()) {
            if (map.get(result) % 2 != 0) {
                return result;
            }
        }
        return 0;
    }

//  function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears).
//  "Same" means, here, that the elements in b are the elements in a squared, regardless of the order
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        if (a.length == 0) return true;
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] * a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

//function which takes its speed in km per hour and returns it in cm per second, rounded down to the integer
    public int cockroachSpeed(double x) {
        double kmToCm = x * 100000;
        double hourToSeconds = 60 * 60;
        return (int) (kmToCm / hourToSeconds);
    }
}