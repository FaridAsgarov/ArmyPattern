package com.company.view;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import com.company.view.battleScene.BattleResultSavePopUp;
import com.company.view.battleScene.BattleResultWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.*;

import static com.company.view.Constants.LOGO;
import static com.company.view.Constants.RESOURCES_PATH;

public class SoldierAutoBattleGUI extends JFrame {
  private final int LOG_Y_COORDINATE = 120;
  private final int LOG_WIDTH_AND_HEIGHT = 480;
  private final int firstPlayerLogXcoordinate = 0;
  private final int secondPlayerLogXcoordinate = 490;
  private final int imageSide = 100;
  private final int imageYcoordinate = 200;
  private final String enterNameRequirement = "Enter name to unlock soldier type:";
  private final String startingHtmlTag = "<html>";
  private final String gameMode = "Soldier vs Soldier AutoBattle";
  private String battleLogTextToBeExported = startingHtmlTag;
  String initialStringForFirstSoldierName = "Enter the name for the first soldier:";
  String initialStringForSecondSoldierName = "Enter the name for the second soldier:";

  BaseSoldier firstSoldier;
  BaseSoldier secondSoldier;
  String [] getSoldierNames(){
    BaseSoldier[] soldierType = {new Bowman("firstSoldier", new SoldierPosition(0,0)), new Crossbowman("firstSoldier",new SoldierPosition(0,0)),
        new Spearman("firstSoldier",new SoldierPosition(0,0)), new Swordsman("firstSoldier",new SoldierPosition(0,0))};
    String []names = new String[soldierType.length];
     for(int i = 0 ; i < soldierType.length; i++){
        names[i] = soldierType[i].getClass().getSimpleName();
      }
    return names;
  }
  public SoldierAutoBattleGUI(){
    this.setIconImage(LOGO.getImage());

    final JMenuBar menuBar = new JMenuBar();
    JMenu export = new JMenu("Export the game");
    JMenu reset = new JMenu("Reset the game");

    JMenuItem exportToTextFile = new JMenuItem("Export the existing game to a text file");
    JMenuItem exportToDataBase = new JMenuItem("Export the existing game to a database");
    JMenuItem resetButton = new JMenuItem("Reset all the information to their default values");

    JButton startBattle = new JButton("Fight!");
    JLabel firstPlayerLog=new JLabel(startingHtmlTag);
    JLabel secondPlayerLog=new JLabel(startingHtmlTag);
    firstPlayerLog.setBounds(firstPlayerLogXcoordinate, LOG_Y_COORDINATE, LOG_WIDTH_AND_HEIGHT, LOG_WIDTH_AND_HEIGHT);
    secondPlayerLog.setBounds(secondPlayerLogXcoordinate, LOG_Y_COORDINATE, LOG_WIDTH_AND_HEIGHT, LOG_WIDTH_AND_HEIGHT);
    JLabel firstPlayerPic = new JLabel();

    firstPlayerPic.setBounds(firstPlayerLogXcoordinate, imageYcoordinate, imageSide, imageSide);
    firstPlayerPic.setSize(imageSide, imageSide);

    this.add(firstPlayerPic);

    JLabel secondPlayerPic = new JLabel();
    secondPlayerPic.setBounds(secondPlayerLogXcoordinate+380, imageYcoordinate+100, imageSide, imageSide);
    secondPlayerPic.setSize(imageSide, imageSide);

    this.add(secondPlayerPic);

    JLabel soldierLabel= new JLabel(enterNameRequirement);

    JComboBox soldierList = new JComboBox(getSoldierNames());
    soldierList.setSelectedIndex(2);
    this.add(soldierList);
    this.add(soldierLabel);
    soldierList.setSize(90,80);
    soldierList.setBounds(50,85,300,20);

    soldierLabel.setBounds(50,60,300,20);


    JLabel soldierLabel2= new JLabel(enterNameRequirement);
    JComboBox soldierList2 = new JComboBox(getSoldierNames());
    soldierList2.setSelectedIndex(2);
    this.add(soldierList2);
    this.add(soldierLabel2);
    soldierList2.setSize(90,80);
    soldierList2.setBounds(650,85,300,20);
    soldierLabel2.setBounds(650,60,300,20);

    JTextField firstSoldierName = new JTextField(initialStringForFirstSoldierName);
    this.add(firstSoldierName);
    firstSoldierName.setBounds(50,30,195,20);

    JTextField secondSoldierName = new JTextField(initialStringForSecondSoldierName);
    this.add(secondSoldierName);
    secondSoldierName.setBounds(650,30,215,20);

    soldierList.setVisible(false);
    soldierList2.setVisible(false);

    firstSoldierName.addActionListener(e -> soldierList.setVisible(firstSoldierName.getText().length() > 0));

    secondSoldierName.addActionListener(e -> soldierList2.setVisible(secondSoldierName.getText().length() > 0));

    soldierList.addActionListener(e -> {
      soldierLabel.setText(soldierList.getSelectedItem() + " is selected!");
      firstSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList.getSelectedItem()), firstSoldierName.getText());
      ImageIcon firstPlayerIcon = new ImageIcon(new ImageIcon(RESOURCES_PATH +"/images/" + soldierList.getSelectedItem() +".JPG").getImage().getScaledInstance(imageSide, imageSide, Image.SCALE_DEFAULT));
      firstPlayerPic.setIcon(firstPlayerIcon);
      firstPlayerLog.setComponentZOrder(firstPlayerPic,0);
      firstPlayerPic.setOpaque(true);
    });

    soldierList2.addActionListener(e -> {
      soldierLabel2.setText(soldierList2.getSelectedItem() + " is selected!");
      secondSoldier = SoldierAutoBattleGUI.this.createNewSoldier((String) Objects.requireNonNull(soldierList2.getSelectedItem()), secondSoldierName.getText());
      ImageIcon secondPlayerIcon = new ImageIcon(new ImageIcon(RESOURCES_PATH + "/images/" + soldierList2.getSelectedItem() + ".JPG").getImage().getScaledInstance(imageSide, imageSide, Image.SCALE_DEFAULT));
      secondPlayerPic.setIcon(secondPlayerIcon);
      try{
        secondPlayerLog.setComponentZOrder(secondPlayerPic, 1);
      }
      catch (Exception ex) {
      }
      secondPlayerPic.setOpaque(true);
    });


    startBattle.addActionListener(e -> {
      if(firstSoldier==null || secondSoldier==null){
        JOptionPane.showMessageDialog(firstPlayerLog,"The game can not be started because soldiers are not fully selected yet","Alert",JOptionPane.WARNING_MESSAGE);
        return;
      }

      if(!firstSoldier.isAlive() || !secondSoldier.isAlive()){
        firstSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList.getSelectedItem()), firstSoldierName.getText());
        secondSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList2.getSelectedItem()), secondSoldierName.getText());
      }

      firstPlayerLog.setText(startingHtmlTag);
      secondPlayerLog.setText(startingHtmlTag);

      Battle battle = new Battle(firstSoldier,secondSoldier);
      String firstPlayerAttackString;
      String secondPlayerAttackString;

      while(firstSoldier.isAlive() && secondSoldier.isAlive()) {

        battle.aAttacksB(firstSoldier,secondSoldier);

        firstPlayerAttackString = "<br/>" + firstSoldier.getClass().getSimpleName() + " " + firstSoldierName.getText() + " attacks, " +  secondSoldier.getClass().getSimpleName()
                + " " + secondSoldierName.getText() + " has HP left:" + secondSoldier.totalHealthAndArmor;

        firstPlayerLog.setText(firstPlayerLog.getText() + firstPlayerAttackString);

        saveBattleLogsToText(firstPlayerAttackString);

        battle.aAttacksB(secondSoldier,firstSoldier);

        secondPlayerAttackString = "<br/>" + secondSoldier.getClass().getSimpleName() + " " + secondSoldierName.getText() + " attacks, "
                + firstSoldier.getClass().getSimpleName() + " " + firstSoldierName.getText() + " has HP left:" + firstSoldier.totalHealthAndArmor;

        secondPlayerLog.setText(secondPlayerLog.getText() + secondPlayerAttackString);

        saveBattleLogsToText(secondPlayerAttackString);

        checkForWinner(firstPlayerLog, secondPlayerLog, firstSoldierName, secondSoldierName);
      }
    });

    startBattle.setBounds(435,50, imageSide, 40);

    exportToTextFile.addActionListener(e -> {
      if(!Objects.equals(firstPlayerLog.getText(), startingHtmlTag) || !Objects.equals(secondPlayerLog.getText(), startingHtmlTag)){
        if(new BattleResultSavePopUp().ShowDialog("Would you like to export result of battle to a text file?") == 0){
          BattleResultWriter.writeLogToFile(gameMode + "\n" + battleLogTextToBeExported);
          JOptionPane.showMessageDialog(firstPlayerLog,"Successfully exported to a text file","Success",JOptionPane.WARNING_MESSAGE);
        }
      }
      else{
        JOptionPane.showMessageDialog(firstPlayerLog,"The game can not be saved because Battle Log is empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
    });

    exportToDataBase.addActionListener(e -> {
      if(!Objects.equals(firstPlayerLog.getText(), startingHtmlTag) || !Objects.equals(secondPlayerLog.getText(), startingHtmlTag)){
        DatabaseInfo battle_info;
        try {
          battle_info = new DatabaseInfo();
          Objects.requireNonNull(battle_info).insertBattleInfoToDatabase(gameMode, whoIsTheWinner(), getCurrentDateAndFormatToString());
          JOptionPane.showMessageDialog(firstPlayerLog,"Successfully exported to database","Success", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
        }
      }
      else{
        JOptionPane.showMessageDialog(firstPlayerLog,"The game can not be saved because Battle Log is empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
    });

    resetButton.addActionListener(e -> {
      firstSoldierName.setText(initialStringForFirstSoldierName);
      secondSoldierName.setText(initialStringForSecondSoldierName);
      soldierList.setVisible(false);
      soldierList2.setVisible(false);
      soldierLabel.setText(enterNameRequirement);
      soldierLabel2.setText(enterNameRequirement);
      firstSoldier=null;
      secondSoldier=null;
      firstPlayerLog.setText(startingHtmlTag);
      secondPlayerLog.setText(startingHtmlTag);
      firstPlayerPic.setIcon(null);
      firstPlayerPic.setOpaque(false);
      secondPlayerPic.setIcon(null);
      secondPlayerPic.setOpaque(false);

      JOptionPane.showMessageDialog(firstPlayerLog,"The game was reset to default values","Successful reset",JOptionPane.WARNING_MESSAGE);
    });


    add(startBattle);
    add(firstPlayerLog);
    add(secondPlayerLog);

    setSize(1000,700);
    firstPlayerLog.setBackground(Color.green);
    firstPlayerLog.setOpaque(true);
    firstPlayerLog.setVerticalAlignment(JLabel.TOP);
    firstPlayerLog.setHorizontalAlignment(JLabel.RIGHT);

    secondPlayerLog.setBackground(Color.CYAN);
    secondPlayerLog.setOpaque(true);
    secondPlayerLog.setVerticalAlignment(JLabel.TOP);
    secondPlayerLog.setHorizontalAlignment(JLabel.LEFT);

    this.setJMenuBar(menuBar);
    menuBar.setVisible(true);
    this.add(menuBar);
    menuBar.add(export);
    menuBar.add(reset);
    export.add(exportToTextFile);
    export.add(exportToDataBase);
    reset.add(resetButton);

    setLayout(null);
    setVisible(true);

  }

  private void checkForWinner(JLabel firstPlayerLog, JLabel secondPlayerLog, JTextField firstSoldierName, JTextField secondSoldierName) {
    String firstPlayerWon = "<br/>" + firstSoldierName.getText() + " is the winner!";
    String secondPlayerWon =  "<br/>" + secondSoldierName.getText() + " is the winner!";
    String draw = "<br/> Both soldiers died, no one is the winner!";

    if(firstSoldier.isAlive() && !secondSoldier.isAlive()){
      firstPlayerLog.setText(firstPlayerLog.getText() + firstPlayerWon);
      saveBattleLogsToText(firstPlayerWon);
    }
    else if(secondSoldier.isAlive() && !firstSoldier.isAlive()){
      secondPlayerLog.setText(secondPlayerLog.getText() + secondPlayerWon);
      saveBattleLogsToText(secondPlayerWon);
    }
    else if(!secondSoldier.isAlive() && !firstSoldier.isAlive()){
      firstPlayerLog.setText(firstPlayerLog.getText() + draw);
      saveBattleLogsToText(draw);
      }
    }

  BaseSoldier createNewSoldier(String class_name, String soldier_name){
    if(class_name.equals("Bowman")) return  new Bowman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Crossbowman")) return  new Crossbowman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Spearman")) return  new Spearman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Swordsman")) return  new Swordsman(soldier_name,new SoldierPosition(0,0));
    return null;
  }

  private String getCurrentDateAndFormatToString(){
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return date.format(formatter);
  }

  private void saveBattleLogsToText(String battleText){
    this.battleLogTextToBeExported += battleText + "\n";
  }

  private String whoIsTheWinner(){
    String whoIsWinner = "";
    if(firstSoldier.isAlive()&&!secondSoldier.isAlive()){
      whoIsWinner = firstSoldier.getClass().getSimpleName() + " " + firstSoldier.getName() + " won!";
    } else if (!firstSoldier.isAlive()&&secondSoldier.isAlive()){
      whoIsWinner = secondSoldier.getClass().getSimpleName() + " " + secondSoldier.getName() + " won!";
    } else if (!firstSoldier.isAlive()&&!secondSoldier.isAlive()){
      whoIsWinner = "Draw, both lost!";
    }
    return whoIsWinner;
  }

}
