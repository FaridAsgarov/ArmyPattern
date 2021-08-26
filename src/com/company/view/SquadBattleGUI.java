package com.company.view;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.ranged.*;
import com.company.business_logic.soldiers.melee.*;
import com.company.business_logic.soldiers.squad.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;;
import javax.swing.JFrame;
import javax.swing.*;

public class SquadBattleGUI extends JFrame {
  Squad squadA = new Squad("Squad 1");
  Squad squadB = new Squad("Squad 2");


  public SquadBattleGUI() throws IOException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000,1055);
    setLayout(null);

    final JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu squad1 = new JMenu("Squad 1");
    JMenu squad2 = new JMenu("Squad 2");

    JLabel labelForSquad1 = new JLabel("Squad 1 is empty, \n please add soldiers");
    JLabel labelForSquad2 = new JLabel("Squad 2 is empty, \n please add soldiers");
    labelForSquad1.setBounds(130,20,300,200);
    labelForSquad2.setBounds(830,20,300,200);

    JLabel battleLog = new JLabel();
    battleLog.setBounds(165,210,850,1200);
    battleLog.setHorizontalAlignment(SwingConstants.CENTER);
    battleLog.setVerticalAlignment(SwingConstants.TOP);
    battleLog.setOpaque(false);

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
    startBattle.setBounds((this.getWidth()/2)-75,10,150,50);
    this.add(startBattle);


    this.add(battleLog);

    this.add(menuBar);
    this.add(labelForSquad1);
    System.out.println(this.add(labelForSquad2));
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
        if(squadA.getSoldierSquad().size()!=0 && squadB.getSoldierSquad().size()!=0){
          squadA.setSquadName(new DialogBox().showDialog("Enter name for Squad 1:"));
          squadB.setSquadName(new DialogBox().showDialog("Enter name for Squad 2:"));

          Battle battle = new Battle(squadA,squadB);

          battleLog.setText(battle.startSquadBattleHtml(squadA,squadB));
       }
        else{
          battleLog.setText("Can not start battle if Squads are empty");
        }
      }
    });

    addBowman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addCrossbowman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addSpearman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad1.setText(squadToString(squadA));
      }
    });
    addSwordsman.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadA.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
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
        squadB.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addCrossbowman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addSpearman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad2.setText(squadToString(squadB));
      }
    });
    addSwordsman2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        squadB.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog("Enter name for the soldier:"),new SoldierPosition(0,0)));
        labelForSquad2.setText(squadToString(squadB));
      }
    });

    fileMenu.add(saveBattleResult);
    fileMenu.add(exit);

    this.setJMenuBar(menuBar);
    menuBar.setVisible(true);

    String path = new File(".").getCanonicalPath();
    path+= "\\src\\com\\company\\view\\resources\\images\\scrollBackground.png";

    ImageIcon scrollIcon=new ImageIcon(path);
    Image imageBackground = scrollIcon.getImage().getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);


    JTextArea backgroundArea = new JTextArea() {

      Image grayImage = GrayFilter.createDisabledImage(imageBackground);
      {
        setOpaque(false);
      }

      public void paint(Graphics g) {
        g.drawImage(grayImage, 0, 0, this);
        super.paint(g);
      }
    };
    backgroundArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(backgroundArea);
      Container content = this.getContentPane();
      content.add(scrollPane, BorderLayout.CENTER);
    backgroundArea.setBounds(0,0, 1600, 1500);

this.add(backgroundArea);
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
