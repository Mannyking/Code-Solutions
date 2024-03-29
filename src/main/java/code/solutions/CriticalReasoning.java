package code.solutions;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CriticalReasoning {
    public static void main(String[] args) {
        System.out.println(bouncingBall(6, 0.1, 2));
    }

// A child is playing with a ball on the nth floor of a tall building. The height of this floor above ground level, h, is known.
//
//He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).
//
//His mother looks out of a window 1.5 meters from the ground.
//
//How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing)?
//
//Three conditions must be met for a valid experiment:
//Float parameter "h" in meters must be greater than 0
//Float parameter "bounce" must be greater than 0 and less than 1
//Float parameter "window" must be less than h.
//If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
//
//Note:
//The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.
//
//Examples:
//- h = 3, bounce = 0.66, window = 1.5, result is 3
//
//- h = 3, bounce = 1, window = 1.5, result is -1
//
//(Condition 2) not fulfilled).
    public static int bouncingBall(double h, double bounce, double window) {
        int count = 1;
        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }
        while (h > window) {
            if (h * bounce > window) {
                count = count + 2;
            }
            else break; // break the loop immediately to prevent unnecessary repetitions until h < window e.g (bounce of 0.1, window of 3, and height of 6)
            h = h * bounce;
        }
        return count;
    }

// function which takes an array containing the names of people that like an item. It must return the display text
// For 4 or more names, the number in "and 2 others" simply increases
    public static String whoLikesIt(String... names) {
        if (names.length == 0) return "no one likes this";
        else if (names.length == 1) return names[0] + " likes this";
        else if (names.length == 2) return names[0] + " and " + names[1] + " like this";
        else if (names.length == 3) return names[0] + " ," + names[1] + " and " + names[2] + " like this";
        else return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
    }

// function to calculate the total time required for all the customers to check out!
// customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
// n: a positive integer, the number of checkout tills.
//TODO solution is GPT-generated
    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers == null || customers.length == 0 || n <= 0) {
            return 0;
        }

        int[] result = new int[n];

        for (int i = 0; i < customers.length; i++) {
            // Find the shortest queue and add the customer's time to it
            int shortestQueueIndex = findShortestQueueIndex(result);
            result[shortestQueueIndex] += customers[i];
        }

        // Find the maximum total time among all queues
        return Arrays.stream(result).max().orElse(0);
    }

    private static int findShortestQueueIndex(int[] queues) {
        int shortestQueueIndex = 0;
        int shortestQueueTime = queues[0];

        for (int i = 1; i < queues.length; i++) {
            if (queues[i] < shortestQueueTime) {
                shortestQueueIndex = i;
                shortestQueueTime = queues[i];
            }
        }

        return shortestQueueIndex;
    }
//TODO solution is GPT-generated

// You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early to an appointment, so you decided to take the opportunity to go for a short walk.
// The city provides its citizens with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).
// You always walk only a single block for each letter (direction) and you know it takes you one minute to traverse one city block,
// so create a function that will return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!)
// and will, of course, return you to your starting point. Return false otherwise.
    public static boolean isValid(char[] walk) {
        //basically, you must go the opposite direction the same amount of times you went the initial
        int north = 0, west = 0, east = 0, south = 0;
        if (walk.length == 10) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : walk) {
                stringBuilder.append(ch);
            }
            System.out.println(stringBuilder);
            Pattern pattern = Pattern.compile("[nswe]");
            Matcher matcher = pattern.matcher(stringBuilder);

            while (matcher.find()) {
                String str = (matcher.group(0));
                switch (str) {
                    case "n":
                        north++;
                        break;
                    case "s":
                        south++;
                        break;
                    case "w":
                        west++;
                        break;
                    case "e":
                        east++;
                        break;
                }
            }
            System.out.println("north: " + north + "south: " + south + "west: " + west + "east: " + east);
            return (north == south && west == east);
        }
        return false;
    }
}