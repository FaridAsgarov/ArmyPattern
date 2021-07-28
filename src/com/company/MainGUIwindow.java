package com.company;

import com.company.soldiers.BaseSoldier;
import com.company.soldiers.melee.Spearman;
import com.company.soldiers.melee.Swordsman;
import com.company.soldiers.ranged.Bowman;
import com.company.soldiers.ranged.Crossbowman;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUIwindow extends JFrame {
  BaseSoldier firstSoldier;
  BaseSoldier secondSoldier;
  String [] getSoldNames(){
    BaseSoldier soldierType[]= {new Bowman("firstSoldier"), new Crossbowman("firstSoldier"), new Spearman("firstSoldier"), new Swordsman("firstSoldier")};
    String []names = new String[soldierType.length];
     for(int i = 0 ; i < soldierType.length; i++){
        names[i] = soldierType[i].getClass().getSimpleName();
      }
    return names;
  }
  public MainGUIwindow(){
    JButton b = new JButton("Fight!");
    JLabel firstPlayerLog=new JLabel("<html>");
    JLabel secondPlayerLog=new JLabel("<html>");

    JLabel soldierLabel= new JLabel("Enter name to unlock soldier type:");

    JComboBox soldierList = new JComboBox(getSoldNames());
    soldierList.setSelectedIndex(2);
    this.add(soldierList);
    this.add(soldierLabel);
    soldierList.setSize(90,80);
    soldierList.setBounds(50,55,300,20);

    soldierLabel.setBounds(50,30,300,20);


    JLabel soldierLabel2= new JLabel("Enter name to unlock soldier type:");
    JComboBox soldierList2 = new JComboBox(getSoldNames());
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

    firstSoldierName.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          if(firstSoldierName.getText().length()>0){
            soldierList.setVisible(true);
          }else{
            soldierList.setVisible(false);
          }
      }
    });

    secondSoldierName.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          if(secondSoldierName.getText().length()>0){
            soldierList2.setVisible(true);
          }else{
            soldierList2.setVisible(false);
          }
      }
    });



    soldierList.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        soldierLabel.setText(soldierList.getSelectedItem() + " is selected!");
        firstSoldier = createNewSoldier((String) soldierList.getSelectedItem(), firstSoldierName.getText());
        System.out.println(firstSoldier.isAlive());
      }
    });

    soldierList2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        soldierLabel2.setText(soldierList2.getSelectedItem() + " is selected!");
        secondSoldier = createNewSoldier((String) soldierList.getSelectedItem(), secondSoldierName.getText());
      }
    });



    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(firstSoldier==null || secondSoldier==null){
          return;
        }
        double initiative = 0;

        while(firstSoldier.isAlive() && secondSoldier.isAlive()) {
          initiative = Math.random() * 100;
          if (initiative>50) {
            firstSoldier.attack(secondSoldier);
            firstPlayerLog.setText(
                firstPlayerLog.getText() + "<br/>" + firstSoldierName.getText() + " attacks, "
                    + secondSoldierName.getText() + " has HP left:"
                    + secondSoldier.totalHealthAndArmor);
          }
          initiative = Math.random() * 100;
          if (initiative>50) {
            secondSoldier.attack(firstSoldier);
            secondPlayerLog.setText(
                secondPlayerLog.getText() + "<br/>" + secondSoldierName.getText() + " attacks, "
                    + firstSoldierName.getText() + " has HP left:"
                    + firstSoldier.totalHealthAndArmor);
          }
        }

        if(firstSoldier.isAlive() && !secondSoldier.isAlive()){
          firstPlayerLog.setText(firstPlayerLog.getText() + "<br/>" + firstSoldierName.getText() + " is the winner!"
          );}
        if(secondSoldier.isAlive() && !firstSoldier.isAlive()){secondPlayerLog.setText(secondPlayerLog.getText() + "<br/>" + secondSoldierName.getText() + " is the winner!");}
      }
    });

    b.setBounds(485,10,100, 40);
    firstPlayerLog.setBounds(50,120, 280,480);
    secondPlayerLog.setBounds(485,120, 480,480);

    add(b);
    add(firstPlayerLog);
    add(secondPlayerLog);

    setSize(1000,500);
    firstPlayerLog.setSize(480,480);
    firstPlayerLog.setBackground(Color.green);
    firstPlayerLog.setOpaque(true);
    firstPlayerLog.setVerticalAlignment(JLabel.TOP);
    firstPlayerLog.setHorizontalAlignment(JLabel.CENTER);

    secondPlayerLog.setSize(480,480);
    secondPlayerLog.setBackground(Color.CYAN);
    secondPlayerLog.setOpaque(true);
    secondPlayerLog.setVerticalAlignment(JLabel.TOP);
    secondPlayerLog.setHorizontalAlignment(JLabel.CENTER);

    setLayout(null);
    setVisible(true);


  }
  BaseSoldier createNewSoldier(String class_name, String sold_name){
    if(class_name.equals("Bowman")) return  new Bowman(sold_name);
    if(class_name.equals("Crossbowman")) return  new Crossbowman(sold_name);
    if(class_name.equals("Spearman")) return  new Spearman(sold_name);
    if(class_name.equals("Swordsman")) return  new Swordsman(sold_name);
    return null;
  }

}
