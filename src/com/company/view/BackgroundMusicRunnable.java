package com.company.view;

public class BackgroundMusicRunnable implements Runnable {
  public void run() {
    while ( true ) {
      MenuSound backgroundMusic = new MenuSound();
      backgroundMusic.playSound("src//com//company//view//resources//sounds//epicBackgroundMusic.wav");
    }
  }
}