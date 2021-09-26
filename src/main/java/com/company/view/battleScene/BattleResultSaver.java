package com.company.view.battleScene;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BattleResultSaver {
 public BattleResultSaver(String textToWrite) {

   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   Date date = new Date();
//     System.out.println(date.toString());
    String path = System.getProperty("user.dir") + "\\src\\BattleResultSave.txt";
    String text = textToWrite;

    try {
        System.out.println("Saving does not work yet");
      Files.write(Paths.get("src/resources/myfile.txt"), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
    }
  }

}
