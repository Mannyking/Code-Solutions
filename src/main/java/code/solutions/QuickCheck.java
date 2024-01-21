package code.solutions;

import org.json.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class QuickCheck {
    public static void main(String[] args) {
        String str = "Hello World";
        str = String.valueOf(str.charAt(2));
        System.out.println(str);
    }

// function to get invoice price in json file retrieved from Google Takeout
    static double computeExpenses() throws IOException {
        double amount = 0;
        String jsonContent = new String(Files.readAllBytes(Paths.get("Purchase History.json")));
        JSONArray jsonArray = new JSONArray(jsonContent);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String amountUnclean = jsonObject.getJSONObject("purchaseHistory").getString("invoicePrice");
            String amountClean = amountUnclean.replaceAll("[NG,$]|[^\\x20-\\x7E]", "");
            amount += Double.parseDouble(amountClean);
        }
        return amount;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to be executed in the new thread
        System.out.println("Task executed by thread: " + Thread.currentThread().getName());
    }
}