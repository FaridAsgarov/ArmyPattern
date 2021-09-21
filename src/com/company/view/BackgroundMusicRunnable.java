package com.company.view;

public class BackgroundMusicRunnable implements Runnable {
  boolean isVolumeOn = true;
  MenuSound backgroundMusic = new MenuSound();
  public void run() {
    while (isVolumeOn) {
      backgroundMusic.playSound("src//com//company//view//resources//sounds//epicBackgroundMusic.wav");
    }
  }

}