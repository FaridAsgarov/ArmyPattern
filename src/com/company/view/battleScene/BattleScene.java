package com.company.view.battleScene;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import com.company.business_logic.soldiers.squad.Squad;
import com.company.view.EndingScreen;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BattleScene extends JFrame implements KeyListener {
  Squad squadA = new Squad("Red");
  Squad squadB = new Squad("Blue");
  JLabel battleLog = new JLabel("<html> Battle Log: <br/>");
  JPanel myPanel;

  public BattleScene(){
    ImageIcon logo = new ImageIcon("src/com/company/view/resources/images/logo.jpg");
    this.setIconImage(logo.getImage());

    this.setSize(1228,1250);

    squadA.addSoldierToTheSquad(new Spearman("Fedya",new SoldierPosition(8,8)));
    squadA.addSoldierToTheSquad(new Crossbowman("Grisha",new SoldierPosition(8,108)));
    squadA.addSoldierToTheSquad(new Swordsman("Vasya",new SoldierPosition(8,208)));
    squadA.addSoldierToTheSquad(new Bowman("Legolas",new SoldierPosition(8,308)));

    squadB.addSoldierToTheSquad(new Spearman("Evil Fedya",new SoldierPosition(1108,8)));
    squadB.addSoldierToTheSquad(new Crossbowman("Evil Grisha",new SoldierPosition(1108,108)));
    squadB.addSoldierToTheSquad(new Swordsman("Evil Vasya",new SoldierPosition(1108,208)));
    squadB.addSoldierToTheSquad(new Bowman("Evil Legolas",new SoldierPosition(1108,308)));


    battleLog.setBounds(320,528,700,900);
    battleLog.setHorizontalAlignment(SwingConstants.CENTER);
    battleLog.setVerticalAlignment(SwingConstants.TOP);
    battleLog.setFont(new Font("Serif", Font.BOLD, 20));


    myPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 8 ; i < 608; i+= 100){
          for(int j = 8 ; j < 1275; j+= 100){
            g2.drawLine(8 , i , 1208 , i);
            g2.drawLine(j , 8 , j, 508);
          }
        }

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(8));
        g2.drawRect(squadA.getActiveSoldier().getSoldierPosition().positionX-2,squadA.getActiveSoldier().getSoldierPosition().positionY-2,104,104);

        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(8));
        g2.drawRect(squadB.getActiveSoldier().getSoldierPosition().positionX-2,squadB.getActiveSoldier().getSoldierPosition().positionY-2,104,104);

      }
    };
    myPanel.setName("myPanel");
    myPanel.setLayout(null);
    for (int i = 0; i < squadA.getSoldierCount(); i++) {
      myPanel.add(new JLabel(squadA.getSoldier(i).getSoldierImage()));
      myPanel.getComponents()[i].setName(squadA.getSoldier(i).getName() + "_JLabel");
      myPanel.getComponents()[i].setBounds(
          squadA.getSoldier(i).getSoldierPosition().positionX,
          squadA.getSoldier(i).getSoldierPosition().positionY,
          100, 100);
      myPanel.getComponents()[i].setBackground(Color.red);

      myPanel.repaint();

    }
    for (int i = 0; i < squadB.getSoldierCount(); i++){
      myPanel.add(new JLabel(squadB.getSoldier(i).getSoldierImage()));
      myPanel.getComponents()[squadB.getSoldierCount() + i].setName(squadB.getSoldier(i).getName() + "_JLabel2");
      myPanel.getComponents()[squadB.getSoldierCount() + i].setBounds(
          squadB.getSoldier(i).getSoldierPosition().positionX,
          squadB.getSoldier(i).getSoldierPosition().positionY,
          100,100);
      myPanel.getComponents()[squadB.getSoldierCount() + i].setBackground(Color.blue);

      myPanel.repaint();
    }


    this.repaint();
    myPanel.repaint();
    this.add(myPanel);
    myPanel.add(battleLog);


    this.update(this.getGraphics());


    this.setVisible(true);
    this.addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);


//    this.show();
}
  @Override
  public void keyTyped(KeyEvent e) {
  }
  @Override
  public void keyPressed(KeyEvent e) {
    if(e.isAltDown())
     {
       if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
         squadB.nextSoldierIndex();
       } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
         squadB.previousSoldierIndex();
       } else if (e.getKeyCode() == KeyEvent.VK_W) {
         squadB.getActiveSoldier().moveUp();
         attackEnemyTiles(squadB,squadA);
         if(squadB.isSpaceOccupiedByFriend()){
           squadB.getActiveSoldier().moveDown();
         }
         squadB.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
       } else if (e.getKeyCode() == KeyEvent.VK_A) {
         squadB.getActiveSoldier().moveLeft();
         attackEnemyTiles(squadB,squadA);
         if(squadB.isSpaceOccupiedByFriend()){
           squadB.getActiveSoldier().moveRight();
         }
         squadB.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
       } else if (e.getKeyCode() == KeyEvent.VK_D) {
         squadB.getActiveSoldier().moveRight();
         attackEnemyTiles(squadB,squadA);
         if(squadB.isSpaceOccupiedByFriend()){
           squadB.getActiveSoldier().moveLeft();
         }
         squadB.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
       } else if (e.getKeyCode() == KeyEvent.VK_S) {
         squadB.getActiveSoldier().moveDown();
         attackEnemyTiles(squadB,squadA);
         if(squadB.isSpaceOccupiedByFriend()){
           squadB.getActiveSoldier().moveUp();
         }
         squadB.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
       }
       myPanel.getComponent(squadB.getActiveSoldierIndex() + squadB.getSoldierCount()).setBounds(
           squadB.getActiveSoldier().getSoldierPosition().positionX,
           squadB.getActiveSoldier().getSoldierPosition().positionY,
           100, 100);

     }
    else {
     if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        squadA.nextSoldierIndex();
      } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        squadA.previousSoldierIndex();
      }
     else if (e.getKeyCode() == KeyEvent.VK_W) {
        squadA.getActiveSoldier().moveUp();
       attackEnemyTiles(squadA,squadB);
       if(squadA.isSpaceOccupiedByFriend()){
         squadA.getActiveSoldier().moveDown();
       }
        squadA.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
      } else if (e.getKeyCode() == KeyEvent.VK_A) {
        squadA.getActiveSoldier().moveLeft();
       attackEnemyTiles(squadA,squadB);
       if(squadA.isSpaceOccupiedByFriend()){
         squadA.getActiveSoldier().moveRight();
       }
        squadA.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
      } else if (e.getKeyCode() == KeyEvent.VK_D) {
        squadA.getActiveSoldier().moveRight();
       attackEnemyTiles(squadA,squadB);
       if(squadA.isSpaceOccupiedByFriend()){
         squadA.getActiveSoldier().moveLeft();
       }
        squadA.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
      } else if (e.getKeyCode() == KeyEvent.VK_S) {
        squadA.getActiveSoldier().moveDown();
       attackEnemyTiles(squadA,squadB);
       if(squadA.isSpaceOccupiedByFriend()){
         squadA.getActiveSoldier().moveUp();
       }
        squadA.getActiveSoldier().checkBoundaries(8,1108, 8, 408);
      }
      myPanel.getComponent(squadA.getActiveSoldierIndex()).setBounds(
          squadA.getActiveSoldier().getSoldierPosition().positionX,
          squadA.getActiveSoldier().getSoldierPosition().positionY,
          100, 100);

    }
    removeDeadSoldierLabels();
    this.repaint();
  }
  @Override
  public void keyReleased(KeyEvent e) {
//    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//      squadA.nextSoldierIndex();
//    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
//      squadA.previousSoldierIndex();
  }
  public void removeDeadSoldierLabels(){
    for(int i = 0 ; i < squadA.getSoldierCount(); i++){
      if(!squadA.getSoldier(i).isAlive() ){
        myPanel.remove(myPanel.getComponent(i));
        squadA.removeSoldierFromTheSquad(squadA.getSoldier(i));
        squadA.setSoldierIndex(0);
        repaint();
      }
    }
    for(int i = 0 ; i < squadB.getSoldierCount(); i++){
      if(!squadB.getSoldier(i).isAlive() ){
        myPanel.remove(myPanel.getComponent(i+squadB.getSoldierCount()));
        squadB.removeSoldierFromTheSquad(squadB.getSoldier(i));
        squadB.setSoldierIndex(0);
        repaint();
      }
    }
    if(squadA.getSoldierCount()==0 || squadB.getSoldierCount()==0){
      if(squadA.getSoldierCount()==0){
       new EndingScreen(squadB.getName());
      }
      else {
        new EndingScreen(squadA.getName());
      }
      this.dispose();
    }
    repaint();
  }

  public void attackEnemyTiles(Squad friendlySquad, Squad enemySquad){
    if(friendlySquad.isSpaceOccupiedByEnemy(enemySquad)){
      Battle battle = new Battle(friendlySquad.getActiveSoldier(),
          friendlySquad.returnEnemyWhoOccupiedSpace(enemySquad));
      battleLog.setText(battle.startBattleHtml(friendlySquad.getActiveSoldier(),
          friendlySquad.returnEnemyWhoOccupiedSpace(enemySquad)));
    }
  }

}
