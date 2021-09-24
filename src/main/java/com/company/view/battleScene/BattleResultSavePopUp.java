package com.company.view.battleScene;
import javax.swing.JOptionPane;
import javax.swing.*;

public class BattleResultSavePopUp {
  JFrame frame;

  public BattleResultSavePopUp() {

  }
  public int ShowDialog(){
    Object[] options = {"Yes","No"};
    int n = JOptionPane.showOptionDialog(this.frame,
        "Would you like to export result of battle to a text file?","Would you like to export result of battle to a text file?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

    return n;


  }

}
