package code.solutions;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class QuickCheck {
    private static final String[] strings = {"Old_Image", "New_Image", "Third_Image"};
    private final String firstName, secondName, expression;

    public QuickCheck(String expression, String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.expression = expression;
    }

    public QuickCheck() {
        this("Hello", "World", "!");
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public String getExpression() {
        return this.expression;
    }

    public static void main(String[] args) {
        boolean serverRunning = new QuickCheck().isServerRunning("http://localhost:8000");

        if (serverRunning) {
            System.out.println("Server is running");
        } else {
            System.out.println("Server is not running");
        }
    }

    static String readTextFile(String fileName) {
        try {
            return Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void saveBase64AsImage(String base64String, String fileName) {
        try {
            // Decode base64 string to byte array
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);

            // Create a file to save the image
            Path filePath = Paths.get(fileName + ".jpeg");
            Files.write(filePath, decodedBytes);

            System.out.println("Image saved to: " + filePath.toAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isServerRunning(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}