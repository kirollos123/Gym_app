package utils;

import java.io.FileWriter;
import java.io.IOException;

public class LoggerUtil {

    public static void logAction(String action) {
        try (FileWriter writer = new FileWriter("app.log", true)) {
            writer.write(action + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
