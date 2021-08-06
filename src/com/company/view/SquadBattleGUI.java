package com.company.view;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.ranged.*;
import com.company.business_logic.soldiers.melee.*;
import com.company.business_logic.soldiers.squad.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

public class SquadBattleGUI extends JFrame {
  Squad squadA = new Squad("Squad 1");
  Squad squadB = new Squad("Squad 2");


  public SquadBattleGUI(){
    setSize(1200,1200);
    setLayout(null);


    final JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu squad1 = new JMenu("Squad 1");
    JMenu squad2 = new JMenu("Squad 2");

    JLabel labelForSquad1 = new JLabel("Squad 1 is empty, \n please add soldiers");
    JLabel labelForSquad2 = new JLabel("Squad 2 is empty, \n please add soldiers");
    labelForSquad1.setBounds(10,20,300,200);
    labelForSquad2.setBounds(800,20,300,200);

    JLabel battleLog = new JLabel("Battle Log");
    battleLog.setBounds(400,250,500,500);


    JMenuItem saveBattleResult = new JMenuItem("Save result of battle");
    saveBattleResult.setActionCommand("Save result of battle");
    JMenuItem exit = new JMenuItem("Exit");
    exit.setActionCommand("Exit");

    JMenu addSoldier = new JMenu("Add soldier to the squad");

    JMenuItem addBowman = new JMenuItem("Add Bowman");
    JMenuItem addCrossbowman = new JMenuItem("Add Crossbowman");
    JMenuItem addSpearman = new JMenuItem("Add Spearman");
    JMenuItem addSwordsman = new JMenuItem("Add Swordsman");

    JMenu addSoldier2 = new JMenu("Add soldier to the squad");

    JMenuItem addBowman2 = new JMenuItem("Add Bowman");
    JMenuItem addCrossbowman2 = new JMenuItem("Add Crossbowman");
    JMenuItem addSpearman2 = new JMenuItem("Add Spearman");
    JMenuItem addSwordsman2 = new JMenuItem("Add Swordsman");

    JButton startBattle = new JButton("Start battle!");
    startBattle.setBounds(500,10,150,50);
    this.add(startBattle);

    battleLog.setBackground(Color.cyan);
    battleLog.setOpaque(true);
    this.add(battleLog);

    this.add(menuBar);
    this.add(labelForSquad1);
    this.add(labelForSquad2);
    menuBar.add(fileMenu);
    menuBar.add(squad1);
    menuBar.add(squad2);

    squad1.add(addSoldier);
    addSoldier.add(addBowman);
    addSoldier.add(addCrossbowman);
    addSoldier.add(addSpearman);
    addSoldier.add(addSwordsman);

    startBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.setSquadName(new DialogBox().showDialog("Enter name for Squad 1:"));
        squadB.setSquadName(new DialogBox().showDialog("Enter name for Squad 2:"));

        Battle battle = new Battle(squadA,squadB);

        battleLog.setText(battle.startBattleHtml(squadA,squadB));
      }
    });

    addBowman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addCrossbowman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addSpearman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addSwordsman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad1.setText(squadToString(squadA));
      }
    });

    squad2.add(addSoldier2);
    addSoldier2.add(addBowman2);
    addSoldier2.add(addCrossbowman2);
    addSoldier2.add(addSpearman2);
    addSoldier2.add(addSwordsman2);

    addBowman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addCrossbowman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addSpearman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addSwordsman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog("Enter name for the soldier:")));
        labelForSquad2.setText(squadToString(squadB));
      }
    });

    fileMenu.add(saveBattleResult);
    fileMenu.add(exit);

    this.setJMenuBar(menuBar);
    menuBar.setVisible(true);
    this.setVisible(true);
  }
  private String squadToString(Squad squad){
    String tmp = "<html>Squad consists of following soldiers:";
    for(BaseSoldier soldier : squad.getSoldierSquad()){
      tmp += "<br>" + soldier.getName() + " : " + soldier.getClass().getSimpleName();
    }
    tmp += "</html>";
    return tmp;
  }

}
