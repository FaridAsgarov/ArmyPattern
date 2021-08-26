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
    this.setSize(1225,1200);

    squadA.addSoldierToTheSquad(new Spearman("Fedya",new SoldierPosition(8,8)));
    squadA.addSoldierToTheSquad(new Crossbowman("Grisha",new SoldierPosition(208,8)));
    squadA.addSoldierToTheSquad(new Swordsman("Vasya",new SoldierPosition(408,208)));
//    squadA.addSoldierToTheSquad(new Bowman("Legolas",new SoldierPosition(8,1108)));



    myPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 8 ; i < 1200; i+= 100){
          for(int j = 8 ; j < 1200; j+= 100){
            g2.drawLine(8 , i , 1200 , i);
            g2.drawLine(j , 8 , j , 1200);
          }
        }

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(8));

        g2.drawRect(squadA.getActiveSoldier().getSoldierPosition().positionX-2,squadA.getActiveSoldier().getSoldierPosition().positionY-2,104,104);

      }
    };
    myPanel.setName("myPanel");
    myPanel.setLayout(null);
    for (int i = 0; i < squadA.getSoldierCount(); i++){
      myPanel.add(new JLabel(squadA.getSoldier(i).getSoldierImage()));
      myPanel.getComponents()[i].setName(squadA.getSoldier(i).getName() + "_JLabel");
      myPanel.getComponents()[i].setBounds(
              squadA.getSoldier(i).getSoldierPosition().positionX,
              squadA.getSoldier(i).getSoldierPosition().positionY,
        100,100);
      myPanel.getComponents()[i].setBackground(Color.red);
      myPanel.repaint();
    }

    this.repaint();
    this.add(myPanel);



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
    if (e.getKeyCode() == KeyEvent.VK_RIGHT){
      squadA.nextSoldierIndex();
    }
    else if (e.getKeyCode() == KeyEvent.VK_LEFT){
      squadA.previousSoldierIndex();
    }
    else if (e.getKeyCode() == KeyEvent.VK_W){
      squadA.getActiveSoldier().moveUp();
    }
    else if (e.getKeyCode() == KeyEvent.VK_A){
      squadA.getActiveSoldier().moveLeft();
    }
    else if (e.getKeyCode() == KeyEvent.VK_D){
      squadA.getActiveSoldier().moveRight();
    }
    else if (e.getKeyCode() == KeyEvent.VK_S){
      squadA.getActiveSoldier().moveDown();

    }
    myPanel.getComponent(squadA.getActiveSoldierIndex()).setBounds(
            squadA.getActiveSoldier().getSoldierPosition().positionX,
            squadA.getActiveSoldier().getSoldierPosition().positionY,
            100,100);
//    System.out.println(squadA.getActiveSoldierIndex());
    this.repaint();
  }
  @Override
  public void keyReleased(KeyEvent e) {
//    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
//      squadA.nextSoldierIndex();
//    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
//      squadA.previousSoldierIndex();
  }

}
