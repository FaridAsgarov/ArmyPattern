package com.company.view;

import com.company.view.battleScene.BattleScene;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {
  BackgroundMusicRunnable backgroundMusicRunnable = new BackgroundMusicRunnable();
  public MainMenu(){
    this.setSize(800,800);

    Thread myThread = new Thread(backgroundMusicRunnable);
    myThread.setDaemon(true);
    myThread.start();

    JButton startSoldierAutoBattle = new JButton("Start Soldier Vs Soldier AutoBattle!");
    JButton startSquadAutoBattle = new JButton("Start Squad vs Squad AutoBattle!");
    JButton startBattleScene = new JButton("Start Squad vs Squad Manual Battle!");
    JButton exitButton = new JButton("Exit");

    this.setLayout(null);

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
          new BattleScene();
      }
    });

    exitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    this.add(startSoldierAutoBattle);
    this.add(startSquadAutoBattle);
    this.add(startBattleScene);
    this.add(exitButton);

    setVisible(true);
  }
}
