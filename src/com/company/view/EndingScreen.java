package com.company.view;

import com.company.view.battleScene.BattleScene;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EndingScreen extends JFrame {
  public EndingScreen(String winnerSquad) {
    ImageIcon logo = new ImageIcon("src/com/company/view/resources/images/logo.jpg");
    this.setIconImage(logo.getImage());

    this.setSize(1280,970);
    this.setTitle("Game over, " + winnerSquad + " won!");

    JLabel winnerMessage = new JLabel(winnerSquad + " won!");
    winnerMessage.setBounds(440,370,400,100);
    winnerMessage.setHorizontalAlignment(SwingConstants.CENTER);
    winnerMessage.setForeground(Color.RED);
    winnerMessage.setFont(new Font("Serif", Font.BOLD, 70));

    JButton backToMainMenu = new JButton("Play Again?");
    backToMainMenu.setOpaque(true);
    backToMainMenu.setBounds(570,475,120,30);
    backToMainMenu.setHorizontalAlignment(SwingConstants.CENTER);


   JPanel myPanel = new JPanel() {
     @Override
     protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       BufferedImage image = null;
       try {
         image = ImageIO.read(new File("src/com/company/view/resources/images/gameOverScreen.jpg"));
         this.setLayout(null);
         this.add(winnerMessage);
         this.add(backToMainMenu);

       } catch (IOException e) {
         e.printStackTrace();
       }
       g.drawImage(image, 0, 0, this);
     }
    };

   backToMainMenu.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
       EndingScreen.super.dispose();
       new BattleScene();
     }
   });

    this.add(myPanel);


    this.setVisible(true);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


}
