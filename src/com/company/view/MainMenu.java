package com.company.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {
  public MainMenu(){
    this.setSize(800,800);

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


    startSoldierAutoBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    startSquadAutoBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    startBattleScene.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

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
