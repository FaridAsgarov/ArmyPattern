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

    String path = System.getProperty("user.dir") + "\\src\\BattleResultSave_"+date.toString()+".txt";
    String text = textToWrite;

    try {
      Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
    }

  }

}
