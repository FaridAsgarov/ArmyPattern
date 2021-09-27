package com.company.view.battleScene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

import java.util.Date;


import static com.company.view.Constants.RESOURCES_PATH;

public class BattleResultWriter {

    public static String getDateTimeStringForFileName(String fileExtension){
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date date = new Date();
        return "_date_" + formatter.format(date) + fileExtension;
    }

    public static void writeLogToFile(String text) {
        var path = Path.of(RESOURCES_PATH + "/battleLogText" + getDateTimeStringForFileName(".txt"));
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
