package com.company.view.battleScene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.company.view.Constants.RESOURCES_PATH;

public class BattleResultSaver {
    public static void writeLogToFile(String text) {
        var path = Path.of(RESOURCES_PATH + "/myFile.txt");
        try (var writer = Files.newBufferedWriter(path)) {
            writer.write(format(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String format(String text) {
        return text.replace("null", "")
                .replace("<html>", "")
                .replace("</html>", "")
                .replace("<br>", System.lineSeparator());

    }

}
