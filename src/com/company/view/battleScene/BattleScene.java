package com.company.view.battleScene;

import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.melee.Swordsman;
import com.company.business_logic.soldiers.ranged.Bowman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import com.company.business_logic.soldiers.squad.Squad;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class BattleScene extends JFrame implements KeyListener {
  Squad squadA = new Squad("Red");
  JPanel myPanel;
  public BattleScene(){
    this.setSize(1225,1248);

    JLabel soldier1 = new JLabel();
    BaseSoldier soldierA = new Spearman("Fedya",new SoldierPosition(8,8));
    soldier1.setIcon(soldierA.getSoldierImage());

    JLabel soldier2 = new JLabel();
    BaseSoldier soldierB = new Crossbowman("Grisha",new SoldierPosition(1108,1108));
    soldier2.setIcon(soldierB.getSoldierImage());

    JLabel soldier3 = new JLabel();
    BaseSoldier soldierC = new Swordsman("Vasya",new SoldierPosition(1108,8));
    soldier3.setIcon(soldierC.getSoldierImage());

    JLabel soldier4 = new JLabel();
    BaseSoldier soldierD = new Bowman("Legolas",new SoldierPosition(8,1108));
    soldier4.setIcon(soldierD.getSoldierImage());

    squadA.addSoldierToTheSquad(soldierA);
    squadA.addSoldierToTheSquad(soldierB);
    squadA.addSoldierToTheSquad(soldierC);
    squadA.addSoldierToTheSquad(soldierD);


    soldier1.setBounds(squadA.getActiveSoldier().getSoldierPosition().positionX,
        squadA.getActiveSoldier().getSoldierPosition().positionY,
        100,100);
    squadA.nextSoldierIndex();
    soldier2.setBounds(squadA.getActiveSoldier().getSoldierPosition().positionX,
        squadA.getActiveSoldier().getSoldierPosition().positionY,
        100,100);
    squadA.nextSoldierIndex();
    soldier3.setBounds(squadA.getActiveSoldier().getSoldierPosition().positionX,
        squadA.getActiveSoldier().getSoldierPosition().positionY,
        100,100);
    squadA.nextSoldierIndex();
    soldier4.setBounds(squadA.getActiveSoldier().getSoldierPosition().positionX,
        squadA.getActiveSoldier().getSoldierPosition().positionY,
        100,100);
    squadA.previousSoldierIndex();

    soldier1.setBounds(soldierA.getSoldierPosition().positionX,soldierA.getSoldierPosition().positionY,100,100);
    soldier2.setBounds(soldierB.getSoldierPosition().positionX,soldierB.getSoldierPosition().positionY,100,100);
    soldier3.setBounds(soldierC.getSoldierPosition().positionX,soldierC.getSoldierPosition().positionY,100,100);
    soldier4.setBounds(soldierD.getSoldierPosition().positionX,soldierD.getSoldierPosition().positionY,100,100);

    this.add(soldier1);
    this.add(soldier2);
    this.add(soldier3);
    this.add(soldier4);

    System.out.println(soldier1.getParent().getClass().getSimpleName());
     myPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int yIncrement;
        int xIncrement;
        for(yIncrement = 8; yIncrement <=1208; yIncrement += 100){
          g2.drawLine(8, yIncrement, 1208, yIncrement);
        }
        for(xIncrement = 8; xIncrement <=1208; xIncrement += 100){
          g2.drawLine(xIncrement,8, xIncrement,1208);
        }

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(8));

        g2.drawRect(squadA.getActiveSoldier().getSoldierPosition().positionX-2,squadA.getActiveSoldier().getSoldierPosition().positionY-2,104,104);

      }
    };


    this.add(myPanel);
    this.update(this.getGraphics());
    this.update(myPanel.getGraphics());
    soldier1.setVisible(true);
    soldier2.setVisible(true);
    myPanel.setVisible(true);
    myPanel.setOpaque(true);

    this.setVisible(true);
    this.addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);

//    this.show();
}
  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("keyTyped");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT){
      squadA.nextSoldierIndex();
      this.repaint();
    }
    else if (e.getKeyCode() == KeyEvent.VK_LEFT){
      squadA.previousSoldierIndex();
      this.repaint();
    }
    else if (e.getKeyCode() == KeyEvent.VK_W){
      squadA.getActiveSoldier().moveUp();
      System.out.println(((JLayeredPane) this.rootPane.getComponents()[0]).getComponents().length

      );
//      this.getComponentAt(
//          squadA.getActiveSoldier().getSoldierPosition().positionX, squadA.getActiveSoldier().getSoldierPosition().positionY)
//          .setBounds(squadA.getActiveSoldier().getSoldierPosition().positionX, squadA.getActiveSoldier().getSoldierPosition().positionY, 100, 100);
      this.repaint();
    }
    else if (e.getKeyCode() == KeyEvent.VK_A){
      squadA.getActiveSoldier().moveLeft();
      this.repaint();
    }
    else if (e.getKeyCode() == KeyEvent.VK_D){
      squadA.getActiveSoldier().moveRight();
      this.repaint();
    }
    else if (e.getKeyCode() == KeyEvent.VK_S){
      squadA.getActiveSoldier().moveDown();
      this.repaint();
    }
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      squadA.nextSoldierIndex();
    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
      squadA.previousSoldierIndex();
  }

}
