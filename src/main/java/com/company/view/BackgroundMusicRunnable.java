package com.company.view;

import static com.company.view.Constants.MUSIC_FILE_PATH;

public class BackgroundMusicRunnable implements Runnable {
  boolean isVolumeOn = true;
  MenuSound backgroundMusic = new MenuSound();
  public void run() {
    while (isVolumeOn) {
      backgroundMusic.playSound(MUSIC_FILE_PATH);
    }
  }

}