package com.company.view;

import javax.swing.*;
import java.io.File;

public class Constants {
    public static final String RESOURCES_PATH = "src/main/java/com/company/view/resources";

    public static final ImageIcon LOGO = new ImageIcon(RESOURCES_PATH + "/images/logo.jpg");
    public static final ImageIcon VOLUME_OFF = new ImageIcon(RESOURCES_PATH + "/images/volumeOff.png");
    public static final ImageIcon VOLUME_ON = new ImageIcon(RESOURCES_PATH + "/images/volumeOn.png");
    public static final ImageIcon SCROLL_ICON = new ImageIcon(RESOURCES_PATH + "/images/scrollBackground.png");

    public static final File BACKGROUND_IMAGE = new File(RESOURCES_PATH + "/images/battleBackground.jpg");
    public static final File GAME_OVER_IMAGE = new File(RESOURCES_PATH + "/images/gameOverScreen.jpg");

    public static final String MUSIC_FILE_PATH = RESOURCES_PATH + "/sounds/epicBackgroundMusic.wav";


}
