package com.company.view.battleScene;

import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.melee.Spearman;
import com.company.business_logic.soldiers.ranged.Crossbowman;
import java.awt.Graphics;;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleScene extends JFrame {
  public BattleScene(){
    this.setSize(1217,1240);


    JLabel soldier1 = new JLabel();
    BaseSoldier soldierA = new Spearman("Fedya",new SoldierPosition(0,0));
    soldier1.setIcon(soldierA.getSoldierImage());

    JLabel soldier2 = new JLabel();
    BaseSoldier soldierB = new Crossbowman("Grisha",new SoldierPosition(1100,1100));
    soldier2.setIcon(soldierB.getSoldierImage());

    soldier1.setBounds(soldierA.getSoldierPosition().positionX,soldierA.getSoldierPosition().positionY,100,100);
    soldier2.setBounds(soldierB.getSoldierPosition().positionX,soldierB.getSoldierPosition().positionY,100,100);

    this.add(soldier1);
    this.add(soldier2);


    JPanel myPanel = new JPanel() {
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yIncrement;
        int xIncrement;
        for(yIncrement = 0; yIncrement <=1200; yIncrement += 100){
          g.drawLine(0, yIncrement, 1200, yIncrement);
        }
        for(xIncrement = 0; xIncrement <=1200; xIncrement += 100){
          g.drawLine(xIncrement,0, xIncrement,1200);
        }

      }
    };

    this.add(myPanel);
//    this.update(this.getGraphics());
//    this.update(myPanel.getGraphics());

    soldier1.setVisible(true);
    soldier2.setVisible(true);
    myPanel.setVisible(true);
    myPanel.setOpaque(true);
    this.setVisible(true);

//    this.show();
}
}
