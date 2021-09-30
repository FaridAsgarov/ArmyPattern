package com.company.view;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;


import java.awt.Color;
import java.awt.Image;
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
  private String enterNameRequirement = "Enter name to unlock soldier type:";
  BaseSoldier firstSoldier;
  BaseSoldier secondSoldier;
  String [] getSoldierNames(){
    BaseSoldier soldierType[]= {new Bowman("firstSoldier", new SoldierPosition(0,0)), new Crossbowman("firstSoldier",new SoldierPosition(0,0)),
        new Spearman("firstSoldier",new SoldierPosition(0,0)), new Swordsman("firstSoldier",new SoldierPosition(0,0))};
    String []names = new String[soldierType.length];
     for(int i = 0 ; i < soldierType.length; i++){
        names[i] = soldierType[i].getClass().getSimpleName();
      }
    return names;
  }
  public SoldierAutoBattleGUI(){
    this.setIconImage(LOGO.getImage());

    JButton startBattle = new JButton("Fight!");
    JLabel firstPlayerLog=new JLabel("<html>");
    JLabel secondPlayerLog=new JLabel("<html>");
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
    soldierList.setBounds(50,55,300,20);

    soldierLabel.setBounds(50,30,300,20);


    JLabel soldierLabel2= new JLabel(enterNameRequirement);
    JComboBox soldierList2 = new JComboBox(getSoldierNames());
    soldierList2.setSelectedIndex(2);
    this.add(soldierList2);
    this.add(soldierLabel2);
    soldierList2.setSize(90,80);
    soldierList2.setBounds(650,55,300,20);

    soldierLabel2.setBounds(650,30,300,20);


    JTextField firstSoldierName = new JTextField("Enter the name for the first soldier:");
    this.add(firstSoldierName);
    firstSoldierName.setBounds(50,0,190,20);

    JTextField secondSoldierName = new JTextField("Enter the name for the second soldier:");
    this.add(secondSoldierName);
    secondSoldierName.setBounds(650,0,210,20);

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
      secondSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList2.getSelectedItem()), secondSoldierName.getText());
      ImageIcon secondPlayerIcon = new ImageIcon(new ImageIcon(RESOURCES_PATH +"/images/" + soldierList2.getSelectedItem() +".JPG").getImage().getScaledInstance(imageSide, imageSide, Image.SCALE_DEFAULT));
      secondPlayerPic.setIcon(secondPlayerIcon);
      secondPlayerLog.setComponentZOrder(secondPlayerPic,1);
      secondPlayerPic.setOpaque(true);
    });


    startBattle.addActionListener(e -> {
      if(firstSoldier==null || secondSoldier==null){
        return;
      }

      if(!firstSoldier.isAlive() || !secondSoldier.isAlive()){
        firstSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList.getSelectedItem()), firstSoldierName.getText());
        secondSoldier = createNewSoldier((String) Objects.requireNonNull(soldierList2.getSelectedItem()), secondSoldierName.getText());
      }

      firstPlayerLog.setText("<html>");
      secondPlayerLog.setText("<html>");

      Battle battle = new Battle(firstSoldier,secondSoldier);


      while(firstSoldier.isAlive() && secondSoldier.isAlive()) {

        battle.AattacksB(firstSoldier,secondSoldier);

        firstPlayerLog.setText(
            firstPlayerLog.getText() + "<br/>" + firstSoldier.getClass().getSimpleName() + " " + firstSoldierName.getText() + " attacks, " +  secondSoldier.getClass().getSimpleName()
                    + " " + secondSoldierName.getText() + " has HP left:"
                + secondSoldier.totalHealthAndArmor);

        battle.AattacksB(secondSoldier,firstSoldier);
        secondPlayerLog.setText(
              secondPlayerLog.getText() + "<br/>" + secondSoldier.getClass().getSimpleName() + " " + secondSoldierName.getText() + " attacks, "
                  + firstSoldier.getClass().getSimpleName() + " " + firstSoldierName.getText() + " has HP left:"
                  + firstSoldier.totalHealthAndArmor);

        checkForWinner(firstPlayerLog, secondPlayerLog, firstSoldierName, secondSoldierName);

      }
    });

    startBattle.setBounds(485,10, imageSide, 40);




    add(startBattle);
    add(firstPlayerLog);
    add(secondPlayerLog);

    setSize(1000,700);
    firstPlayerLog.setBackground(Color.green);
    firstPlayerLog.setOpaque(true);
    firstPlayerLog.setVerticalAlignment(JLabel.TOP);
    firstPlayerLog.setHorizontalAlignment(JLabel.RIGHT);

    secondPlayerLog.setBackground(Color.CYAN);;
    secondPlayerLog.setOpaque(true);
    secondPlayerLog.setVerticalAlignment(JLabel.TOP);
    secondPlayerLog.setHorizontalAlignment(JLabel.LEFT);

    setLayout(null);
    setVisible(true);


  }

  private void checkForWinner(JLabel firstPlayerLog, JLabel secondPlayerLog, JTextField firstSoldierName, JTextField secondSoldierName) {
    if(firstSoldier.isAlive() && !secondSoldier.isAlive()){
      firstPlayerLog.setText(firstPlayerLog.getText() + "<br/>" + firstSoldierName.getText() + " is the winner!"
      );}
    if(secondSoldier.isAlive() && !firstSoldier.isAlive()){
      secondPlayerLog.setText(secondPlayerLog.getText() +
        "<br/>" + secondSoldierName.getText() + " is the winner!");}
  }

  BaseSoldier createNewSoldier(String class_name, String soldier_name){
    if(class_name.equals("Bowman")) return  new Bowman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Crossbowman")) return  new Crossbowman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Spearman")) return  new Spearman(soldier_name,new SoldierPosition(0,0));
    if(class_name.equals("Swordsman")) return  new Swordsman(soldier_name,new SoldierPosition(0,0));
    return null;
  }

}
