package com.company.view;

import javax.swing.*;
import java.io.File;

public class Constants {
    public static final String RESOURCES_PATH = "src/main/resources";

    public static final ImageIcon LOGO = new ImageIcon(RESOURCES_PATH + "/images/logo.jpg");
    public static final ImageIcon VOLUME_OFF = new ImageIcon(RESOURCES_PATH + "/images/volumeOff.png");
    public static final ImageIcon VOLUME_ON = new ImageIcon(RESOURCES_PATH + "/images/volumeOn.png");
    public static final ImageIcon SCROLL_ICON = new ImageIcon(RESOURCES_PATH + "/images/scrollBackground.png");

    public static final File BACKGROUND_IMAGE = new File(RESOURCES_PATH + "/images/battleBackground.jpg");
    public static final File GAME_OVER_IMAGE = new File(RESOURCES_PATH + "/images/gameOverScreen.jpg");

    public static final String MUSIC_FILE_PATH = RESOURCES_PATH + "/sounds/epicBackgroundMusic.wav";

    public static final String SPEARMAN_IMAGE = RESOURCES_PATH + "/images/Spearman.JPG";
    public static final String SWORDSMAN_IMAGE = RESOURCES_PATH + "/images/Swordsman.JPG";
    public static final String BOWMAN_IMAGE = RESOURCES_PATH + "/images/Bowman.JPG";
    public static final String CROSSBOWMAN_IMAGE = RESOURCES_PATH + "/images/Crossbowman.JPG";
}
