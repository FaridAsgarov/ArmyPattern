package com.company.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogBox extends JFrame {

  public String showDialog(String message){
     return  createUI(this,message);
  }
  private static String createUI(final JFrame frame, String message){
    JPanel panel = new JPanel();
    LayoutManager layout = new FlowLayout();
    panel.setLayout(layout);
    final JLabel label = new JLabel();
    String result = (String) JOptionPane.showInputDialog(
        frame,
        message,
        "Warning!",
        JOptionPane.PLAIN_MESSAGE,
        null,
        null,
        "Text"
    );

    panel.add(label);
    frame.getContentPane().add(panel, BorderLayout.CENTER);


    frame.dispose();
    return result;
  }
}
