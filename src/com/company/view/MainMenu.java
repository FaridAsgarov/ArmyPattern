package com.company.view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {
    public static final ImageIcon LOGO = new ImageIcon("src/com/company/view/resources/images/logo.jpg");
    public static final ImageIcon VOLUME_OFF = new ImageIcon("src/com/company/view/resources/images/volumeOff.png");
    public static final ImageIcon VOLUME_ON = new ImageIcon("src/com/company/view/resources/images/volumeOn.png");
    public static final File BACKGROUND_IMAGE = new File("src/com/company/view/resources/images/battleBackground.jpg");

    BackgroundMusicRunnable backgroundMusicRunnable = new BackgroundMusicRunnable();
    Thread musicThread;

    public MainMenu() {
        this.setSize(800, 800);
        this.setIconImage(LOGO.getImage());

//    myThread = new Thread(backgroundMusicRunnable);
//    myThread.setDaemon(true);
//    myThread.start();

        JButton volumeControl = getButton("", 695, 680, 75, 75);
        volumeControl.setIcon(VOLUME_OFF);

        JButton startSoldierAutoBattle = getButton("Start Soldier Vs Soldier AutoBattle!", 250, 200, 300, 30);
        JButton startSquadAutoBattle = getButton("Start Squad vs Squad AutoBattle!", 250, 250, 300, 30);
        JButton startBattleScene = getButton("Start Squad Maker Before Manual Battle!", 250, 300, 300, 30);
        JButton exitButton = getButton("Exit", 350, 350, 100, 30);

        JPanel myPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage image = null;
                try {
                    image = ImageIO.read(BACKGROUND_IMAGE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(image, 0, 0, this);
            }
        };

        myPanel.setLayout(null);
        myPanel.add(startSoldierAutoBattle);
        myPanel.add(startSquadAutoBattle);
        myPanel.add(startBattleScene);
        myPanel.add(exitButton);
        myPanel.add(volumeControl);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                turnMusicOff();
                e.getWindow().dispose();
            }
        });


        startSoldierAutoBattle.addActionListener(e -> new MainGUIwindow());

        startSquadAutoBattle.addActionListener(e -> {
            try {
                new SquadBattleGUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        startBattleScene.addActionListener(e -> new SquadMakerGUI());

        exitButton.addActionListener(e -> System.exit(0));

        volumeControl.addActionListener(e -> {
            if (musicThread.isAlive()) {
                turnMusicOff();
                volumeControl.setIcon(VOLUME_OFF);
            } else {
                turnMusicOn();
                volumeControl.setIcon(VOLUME_ON);
            }
        });

        this.add(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private void turnMusicOn() {
        musicThread = new Thread(backgroundMusicRunnable);
        musicThread.setDaemon(true);
        musicThread.start();
    }

    private void turnMusicOff() {
        if (musicThread != null) {
            musicThread.stop();
            musicThread.interrupt();
        }
    }

    private JButton getButton(String text, int x, int y, int width, int height) {
        JButton exitButton = new JButton(text);
        exitButton.setBounds(x, y, width, height);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setOpaque(true);
        return exitButton;
    }
}
