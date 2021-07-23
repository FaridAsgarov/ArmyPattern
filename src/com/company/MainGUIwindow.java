package com.company;

import com.company.soldiers.BaseSoldier;
import com.company.soldiers.ranged.Bowman;
import com.company.soldiers.ranged.Crossbowman;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MainGUIwindow extends JFrame {

  public MainGUIwindow(){
    JButton b = new JButton("Fight!");
    JLabel firstPlayerLog=new JLabel("<html>");
    JLabel secondPlayerLog=new JLabel("<html>");

    b.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        BaseSoldier fred = new Bowman("fred");
        BaseSoldier george = new Crossbowman("george");

        while(fred.isAlive() && george.isAlive()) {
          fred.attack(george);
          firstPlayerLog.setText(firstPlayerLog.getText() + "<br/>Fred attacks, George has HP left:"
              + george.totalHealthAndArmor);
          george.attack(fred);
          secondPlayerLog.setText(
              secondPlayerLog.getText() + "<br/>George attacks, Fred has HP left: "
                  + fred.totalHealthAndArmor);
        }
      }
    });

    b.setBounds(485,10,100, 40);
    firstPlayerLog.setBounds(50,50, 280,480);
    secondPlayerLog.setBounds(485,50, 480,480);

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
}
