package com.company.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndingScreen extends JFrame {
  public EndingScreen(String winnerSquad) {
    this.setSize(1280,970);
    this.setTitle("Game over, " + winnerSquad + " won!");

   JPanel myPanel = new JPanel() {
     @Override
     protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       BufferedImage image = null;
       try {
         image = ImageIO.read(new File("src/com/company/view/resources/images/gameOverScreen.jpg"));

       } catch (IOException e) {
         e.printStackTrace();
       }
       g.drawImage(image, 0, 0, this);
     }
    };

    this.add(myPanel);

    this.setVisible(true);


  }


}
