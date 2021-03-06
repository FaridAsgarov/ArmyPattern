package com.company.view;

import com.company.view.battleScene.BattleScene;
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
  BackgroundMusicRunnable backgroundMusicRunnable = new BackgroundMusicRunnable();
  boolean isThreadOn = true;
  Thread myThread;
  public MainMenu(){
    this.setSize(800,800);

    ImageIcon logo = new ImageIcon("src/com/company/view/resources/images/logo.jpg");
    this.setIconImage(logo.getImage());

    myThread = new Thread(backgroundMusicRunnable);
    myThread.setDaemon(true);
    myThread.start();

    JButton volumeControl = new JButton();
    ImageIcon volumeOff = new ImageIcon("src/com/company/view/resources/images/volumeOff.png");
    ImageIcon volumeOn = new ImageIcon("src/com/company/view/resources/images/volumeOn.png");
    volumeControl.setIcon(volumeOn);
    volumeControl.setBounds(695,680,75,75);

    JButton startSoldierAutoBattle = new JButton("Start Soldier Vs Soldier AutoBattle!");
    JButton startSquadAutoBattle = new JButton("Start Squad vs Squad AutoBattle!");
    JButton startBattleScene = new JButton("Start Squad Maker Before Manual Battle!");
    JButton exitButton = new JButton("Exit");

    startSoldierAutoBattle.setBounds(250,200,300,30);
    startSoldierAutoBattle.setHorizontalAlignment(SwingConstants.CENTER);
    startSoldierAutoBattle.setOpaque(true);

    startSquadAutoBattle.setBounds(250,250,300,30);
    startSquadAutoBattle.setHorizontalAlignment(SwingConstants.CENTER);
    startSquadAutoBattle.setOpaque(true);

    startBattleScene.setBounds(250,300,300,30);
    startBattleScene.setHorizontalAlignment(SwingConstants.CENTER);
    startBattleScene.setOpaque(true);

    exitButton.setBounds(350,350,100,30);
    exitButton.setHorizontalAlignment(SwingConstants.CENTER);
    exitButton.setOpaque(true);

    JPanel myPanel = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = null;
        try {
          image = ImageIO.read(new File("src/com/company/view/resources/images/battleBackground.jpg"));

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

    addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e)
      {
        myThread.stop();
        myThread.interrupt();
        e.getWindow().dispose();
      }
    });


    startSoldierAutoBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new MainGUIwindow();
      }
    });

    startSquadAutoBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          new SquadBattleGUI();
        } catch (IOException ioException) {
          ioException.printStackTrace();
        }
      }
    });

    startBattleScene.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          new SquadMakerGUI();
      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    volumeControl.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(isThreadOn){
          myThread.stop();
          isThreadOn = false;
          volumeControl.setIcon(volumeOff);
        }
        else{
          myThread = new Thread(backgroundMusicRunnable);
          myThread.setDaemon(true);
          myThread.start();
          isThreadOn = true;
          volumeControl.setIcon(volumeOn);
        }
      }
    });

    this.add(myPanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
  }
}
