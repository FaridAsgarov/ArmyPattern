package com.company.view;

import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import com.company.business_logic.soldiers.squad.Squad;
import com.company.view.battleScene.BattleScene;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import static com.company.view.Constants.BACKGROUND_IMAGE;
import static com.company.view.Constants.RESOURCES_PATH;

public class SquadMakerGUI extends JFrame {
    Squad squadA = new Squad(new DialogBox().showDialog("Enter name for Squad 1:"));
  Squad squadB = new Squad(new DialogBox().showDialog("Enter name for Squad 2:"));
  String [] getSoldierNames(){
    BaseSoldier soldierType[]= {new Bowman("firstSoldier", new SoldierPosition(0,0)), new Crossbowman("firstSoldier",new SoldierPosition(0,0)),
        new Spearman("firstSoldier",new SoldierPosition(0,0)), new Swordsman("firstSoldier",new SoldierPosition(0,0))};
    String []names = new String[soldierType.length];
    for(int i = 0 ; i < soldierType.length; i++){
      names[i] = soldierType[i].getClass().getSimpleName();
    }
    return names;
  }
  public SquadMakerGUI(){
  ImageIcon logo = new ImageIcon(RESOURCES_PATH + "/images/logo.jpg");
    this.setIconImage(logo.getImage());
    this.setSize(1000,900);

   JLabel squad1 = new JLabel("<html>" + squadA.getName() + " is currently empty. <br/> Please add soldiers above.");
   squad1.setVerticalAlignment(SwingConstants.TOP);
   squad1.setHorizontalAlignment(SwingConstants.CENTER);
   squad1.setForeground(Color.RED);
   JLabel squad2 = new JLabel("<html>" + squadB.getName() + " is currently empty. <br/> Please add soldiers above.");
    squad2.setVerticalAlignment(SwingConstants.TOP);
    squad2.setHorizontalAlignment(SwingConstants.CENTER);
    squad2.setForeground(Color.RED);

    squad1.setBounds(0,400,380,500);
    squad2.setBounds(400,400,380,500);

    JLabel soldierListLabel = new JLabel("Select a soldier from the list to add to " + squadA.getName() + ":");
    JLabel soldierListLabel2 = new JLabel("Select a soldier from the list to add to " + squadB.getName() + ":");

    soldierListLabel.setVerticalAlignment(SwingConstants.TOP);
    soldierListLabel.setHorizontalAlignment(SwingConstants.CENTER);
    soldierListLabel.setForeground(Color.RED);

    soldierListLabel2.setVerticalAlignment(SwingConstants.TOP);
    soldierListLabel2.setHorizontalAlignment(SwingConstants.CENTER);
    soldierListLabel2.setForeground(Color.RED);

    soldierListLabel.setBounds(0,0,380,20);
    soldierListLabel2.setBounds(400,0,380,20);

    JComboBox soldierList = new JComboBox(getSoldierNames());
    soldierList.setForeground(Color.RED);
    JComboBox soldierList2 = new JComboBox(getSoldierNames());
    soldierList2.setForeground(Color.RED);

    JButton startManualBattle = new JButton("Start Manual Battle!");
    startManualBattle.setVisible(false);
    startManualBattle.setHorizontalAlignment(SwingConstants.CENTER);
    startManualBattle.setVerticalAlignment(SwingConstants.TOP);;
    startManualBattle.setBounds(350,300,150,30);

    soldierList.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          soldierListLabel.setText(soldierList.getSelectedItem() + " is added to " + squadA.getName());
          BaseSoldier soldier = createNewSoldier((String) soldierList.getSelectedItem(), new DialogBox().showDialog("Enter name for Soldier:"));
          squadA.addSoldierToTheSquad(soldier);
          squad1.setText("<html>" + squadA.getName() + " has " + squadA.getSoldierSquad().size() + " soldiers:<br/>" + updateSquadDescription(squadA));

        if(squadA.getSoldierSquad().size()>=5){
          soldierList.setVisible(false);
          soldierListLabel.setBounds(0,0,380,100);
          soldierListLabel.setText("<html>Maximum number of soldier reached,<br/> can not add anymore to " + squadA.getName());
        }

        if(squadA.getSoldierSquad().size()>=1 && squadB.getSoldierSquad().size()>=1){
          startManualBattle.setVisible(true);
        }
      }
    });

    soldierList2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        soldierListLabel2.setText(soldierList2.getSelectedItem() + " is added to " + squadB.getName());
        BaseSoldier soldier2 = createNewSoldier((String) soldierList2.getSelectedItem(), new DialogBox().showDialog("Enter name for Soldier:"));
        squadB.addSoldierToTheSquad(soldier2);
        squad2.setText("<html>" + squadB.getName() + " has " + squadB.getSoldierSquad().size() + " soldiers:<br/>" + updateSquadDescription(squadB));

        if(squadB.getSoldierSquad().size()>=5){
          soldierList2.setVisible(false);
          soldierListLabel2.setBounds(400,0,380,100);
          soldierListLabel2.setText("<html>Maximum number of soldier reached,<br/> can not add anymore to " + squadB.getName());
        }

        if(squadA.getSoldierSquad().size()>=1 && squadB.getSoldierSquad().size()>=1){
          startManualBattle.setVisible(true);
        }
      }
    });

    startManualBattle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SquadMakerGUI.super.dispose();
        new BattleScene(new SoldierPositioningRepository(squadA).setPositions(8,8,100,508),
            new SoldierPositioningRepository(squadB).setPositions(1108,8,100,508)
        );
      }
    });

    soldierList.setBounds(100,22,120,20);
    soldierList2.setBounds(500,22,120,20);

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


   this.add(myPanel);
   myPanel.setLayout(null);
    myPanel.add(squad1);
    myPanel.add(squad2);
    myPanel.add(soldierList);
    myPanel.add(soldierList2);
    myPanel.add(soldierListLabel);
    myPanel.add(soldierListLabel2);
    myPanel.add(startManualBattle);

    myPanel.setVisible(true);
   this.setVisible(true);



  }
  BaseSoldier createNewSoldier(String class_name, String sold_name){
    if(class_name.equals("Bowman")) return  new Bowman(sold_name,new SoldierPosition(0,0));
    if(class_name.equals("Crossbowman")) return  new Crossbowman(sold_name,new SoldierPosition(0,0));
    if(class_name.equals("Spearman")) return  new Spearman(sold_name,new SoldierPosition(0,0));
    if(class_name.equals("Swordsman")) return  new Swordsman(sold_name,new SoldierPosition(0,0));
    return null;
  }

  String updateSquadDescription(Squad squad){
    String tmp = "";
    for(BaseSoldier soldier : squad.getSoldierSquad())
    {
      tmp += soldier.getClass().getSimpleName() + " " + soldier.getName() + "<br/>";
    }
    tmp += "</html>";
    return tmp;
  }

}
