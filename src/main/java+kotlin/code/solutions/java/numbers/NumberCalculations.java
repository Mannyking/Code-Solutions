package code.solutions.java.numbers;

import java.util.*;

public class NumberCalculations {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        System.out.println(sortDesc(834776328));
    }

// function that takes two integers and returns the sum of every number between (and including) them
// next time use sum of arithmetic progression formula: n * (a + b) / 2
    public static int getSum(int a, int b) {
        int result = 0;
        if (a == b) return a;

        int difference = Math.abs(a - b);
        if (a < b) {
            for (int i = 0; i < difference; i++) {
                result = result + a;
                a = a + 1;
            }
            return result + b;
        }
        else {
            for (int i = 0; i < difference; i++) {
                result = result + b;
                b = b + 1;
            }
            return result + a;
        }
    }

// function that can take any non-negative integer as an argument and return it with its digits in descending order
    public static int sortDesc(final int num) {
        int result;
        StringBuilder stringBuilder = new StringBuilder();
        if (num < 0) {
            return 0;
        }
        if (String.valueOf(num).length() ==  1) {
            return num;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        String[] split = String.valueOf(num).split("");
        for (String string : split) {
            hashMap.put(Integer.valueOf(string), hashMap.getOrDefault(Integer.parseInt(string), 0) + 1);
        }
        for (Integer integer : hashMap.keySet()) {
            int amount = hashMap.get(integer);
            for (int i = 0; i < amount; i++) {
                stringBuilder.append(integer);
            }
        }
        stringBuilder.reverse();
        result = Integer.parseInt(String.valueOf(stringBuilder));
        return result;
    }

// he drinks 0.5 litres of water per hour
// return the number of litres Nathan will drink
    public int Liters(double time)  {
        return (int) (0.5 * (int) time);
    }

// Count the number of divisors of a positive integer n
    public long numberOfDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list.size();
    }

// how many years ago the father was twice as old as his son (or in how many years he will be twice as old)
    public static int TwiceAsOld(int dadYears, int sonYears){
        int result = 0;
        if (dadYears == sonYears) return 0;
        else if (dadYears > 2 * sonYears) {
            return dadYears - (2 * sonYears);
        }
        else {
            return (2 * sonYears) - dadYears;
        }
    }

// find the first element of an array that is not consecutive
    static Integer find(final int[] array) {
        if (array.length == 0 || array.length == 1) return null;
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] != 1) return array[i];
        }
        return null;
    }

// given an array of numbers
// sort the odd numbers in ascending order while leaving the even numbers at their original positions
    public static int[] sortArray(int[] array) {
        List<Integer> oddInts = new ArrayList<>();
        List<Integer> oddIntsIndex = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddInts.add(array[i]);
                oddIntsIndex.add(i);
            }
        }
        Collections.sort(oddInts);
        for (int i = 0; i < oddInts.size(); i++) {
            int index = oddIntsIndex.get(i);
            array[index] = oddInts.get(i);
        }

        return array;
    }

// Your task is to construct a building which will be a pile of n cubes. The cube at the bottom will have a volume of (n)cube,
// the cube above will have volume of (n-1)cube and so on until the top which will have a volume of 1cube
// You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?
// return -1 if n isn't an integer

    public static long findNb(long m) {
        long total = 0;
        int counter = 0;

        while (total < m) {
            counter++;
            total += (long) Math.pow(counter, 3);
        }
        return (m == total) ? counter : -1;
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