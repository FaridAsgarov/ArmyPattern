package com.company.view.battleScene;
import javax.swing.JOptionPane;
import javax.swing.*;

public class BattleResultSavePopUp {
  JFrame frame;

  public BattleResultSavePopUp() {

  }
  public int ShowDialog(String message){
    Object[] options = {"Yes","No"};

    return JOptionPane.showOptionDialog(this.frame,
        message,message, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

  }

}
