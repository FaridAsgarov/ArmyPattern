package com.company.view;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.soldiers.ranged.*;
import com.company.business_logic.soldiers.melee.*;
import com.company.business_logic.soldiers.squad.*;
import com.company.view.battleScene.BattleResultSavePopUp;
import com.company.view.battleScene.BattleResultWriter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.*;

import static com.company.view.Constants.*;

public class SquadBattleGUI extends JFrame {
  public static final String ENTER_NAME_FOR_THE_SOLDIER = "Enter name for the soldier:";
  public static final int LOG_HEIGHT = 780;
  public static final int LOG_WIDTH = 850;
  public static final int LOG_X_COORDINATE = 165;
  public static final int LOG_Y_COORDINATE = 210;
  public static final int SQUAD_JLABEL_HEIGHT = 200;
  public static final int SQUAD_JLABEL_WIDTH = 300;
  public static final int SQUAD_JLABEL_Y_COORDINATE = 20;
  private final String gameMode = "Squad vs Squad AutoBattle";

  private final String initialSquad1Label = "Squad 1 is empty, \n please add soldiers";
  private final String initialSquad2Label = "Squad 2 is empty, \n please add soldiers";
  private final String emptySquadsWarning = "The battle can not be started if Squads are empty";
  private final String addSoldierString = "Add soldier to the squad";
  private final String addBowmanString = "Add Bowman";
  private final String addCrossbowmanString = "Add Crossbowman";
  private final String addSpearmanString = "Add Spearman";
  private final String addSwordsmanString = "Add Swordsman";

  Squad squadA = new Squad("Squad 1");
  Squad squadB = new Squad("Squad 2");


  public SquadBattleGUI() throws IOException {
    this.setIconImage(LOGO.getImage());

    setSize(1200,1200);
    setLayout(null);

    final JMenuBar menuBar = new JMenuBar();

    JMenu quickStart = new JMenu("Quick start");
    JMenu squad1 = new JMenu("Manual Addition to Squad 1");
    JMenu squad2 = new JMenu("Manual Addition to Squad 2");
    JMenu restart = new JMenu("Restart");
    JMenu save = new JMenu("Save");

    JLabel labelForSquad1 = new JLabel(initialSquad1Label);
    JLabel labelForSquad2 = new JLabel(initialSquad2Label);
    labelForSquad1.setBounds(130,SQUAD_JLABEL_Y_COORDINATE,SQUAD_JLABEL_WIDTH,SQUAD_JLABEL_HEIGHT);
    labelForSquad2.setBounds(830,SQUAD_JLABEL_Y_COORDINATE,SQUAD_JLABEL_WIDTH,SQUAD_JLABEL_HEIGHT);

    JLabel battleLog = new JLabel();
    battleLog.setBounds(LOG_X_COORDINATE,LOG_Y_COORDINATE,LOG_WIDTH,LOG_HEIGHT);
    battleLog.setHorizontalAlignment(SwingConstants.CENTER);
    battleLog.setVerticalAlignment(SwingConstants.TOP);
    battleLog.setOpaque(false);

    JScrollPane log = new JScrollPane(battleLog);
    log.setBounds(LOG_X_COORDINATE, LOG_Y_COORDINATE, LOG_WIDTH, LOG_HEIGHT);
    log.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    log.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(log);

    JMenu addSoldier = new JMenu(addSoldierString);

    JMenuItem addBowman = new JMenuItem(addBowmanString);
    JMenuItem addCrossbowman = new JMenuItem(addCrossbowmanString);
    JMenuItem addSpearman = new JMenuItem(addSpearmanString);
    JMenuItem addSwordsman = new JMenuItem(addSwordsmanString);

    JMenu addSoldier2 = new JMenu(addSoldierString);

    JMenuItem addBowman2 = new JMenuItem(addBowmanString);
    JMenuItem addCrossbowman2 = new JMenuItem(addCrossbowmanString);
    JMenuItem addSpearman2 = new JMenuItem(addSpearmanString);
    JMenuItem addSwordsman2 = new JMenuItem(addSwordsmanString);

    JMenuItem add4soldiersToEachSquad = new JMenuItem("Add 4 soldiers to each squad");

    JMenuItem emptySquads = new JMenuItem("Empty the squads for a new game");

    JMenuItem exportToTextFile = new JMenuItem("Export the existing game to a text file");
    JMenuItem exportToDataBase = new JMenuItem("Export the existing game to a database");

    JButton startBattle = new JButton("Start battle!");
    startBattle.setBounds((this.getWidth()/2)-75,10,150,50);

    this.add(startBattle);
    this.add(menuBar);
    this.add(labelForSquad1);
    this.add(labelForSquad2);

    menuBar.add(quickStart);
    menuBar.add(squad1);
    menuBar.add(squad2);
    menuBar.add(restart);
    menuBar.add(save);

    squad1.add(addSoldier);
    addSoldier.add(addBowman);
    addSoldier.add(addCrossbowman);
    addSoldier.add(addSpearman);
    addSoldier.add(addSwordsman);

    quickStart.add(add4soldiersToEachSquad);
    restart.add(emptySquads);
    save.add(exportToTextFile);
    save.add(exportToDataBase);

    add4soldiersToEachSquad.addActionListener(e -> {
      squadA.addSoldierToTheSquad(new Bowman("",new SoldierPosition(0,0)));
      squadA.addSoldierToTheSquad(new Crossbowman("",new SoldierPosition(0,0)));
      squadA.addSoldierToTheSquad(new Spearman("",new SoldierPosition(0,0)));
      squadA.addSoldierToTheSquad(new Swordsman("",new SoldierPosition(0,0)));

      squadB.addSoldierToTheSquad(new Bowman("",new SoldierPosition(0,0)));
      squadB.addSoldierToTheSquad(new Crossbowman("",new SoldierPosition(0,0)));
      squadB.addSoldierToTheSquad(new Spearman("",new SoldierPosition(0,0)));
      squadB.addSoldierToTheSquad(new Swordsman("",new SoldierPosition(0,0)));

      labelForSquad1.setText(squadToString(squadA));
      labelForSquad2.setText(squadToString(squadB));
    });

    emptySquads.addActionListener(e -> {
      squadA = new Squad("Squad 1");
      squadB = new Squad("Squad 2");

      battleLog.setText("");

      labelForSquad1.setText(initialSquad1Label);
      labelForSquad2.setText(initialSquad2Label);
    });

    exportToTextFile.addActionListener(e -> {
      if (battleLog.getText() == null || Objects.equals(battleLog.getText(), "") || Objects.equals(battleLog.getText(), emptySquadsWarning)) {
        JOptionPane.showMessageDialog(battleLog,"The game can not be saved because Battle Log is empty","Alert",JOptionPane.WARNING_MESSAGE);
      } else {
        if(new BattleResultSavePopUp().ShowDialog("Would you like to export result of battle to a text file?") == 0){
          BattleResultWriter.writeLogToFile("Squad Vs Squad AutoBattle" + "\n" + battleLog.getText());
        }
      }
    });

    exportToDataBase.addActionListener(e -> {
      if(battleLog.getText()!=null && !Objects.equals(battleLog.getText(), "") && !Objects.equals(battleLog.getText(), emptySquadsWarning)){
        DatabaseInfo battle_info;
        try {
          battle_info = new DatabaseInfo();
          Objects.requireNonNull(battle_info).insertBattleInfoToDatabase(gameMode, whoIsWinnerSquad(), getCurrentDateAndFormatToString());
          JOptionPane.showMessageDialog(battleLog,"Successfully exported to database","Success",JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
        }
      }
      else{
        JOptionPane.showMessageDialog(battleLog,"The game can not be saved because Battle Log is empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
    });


    startBattle.addActionListener(e -> {
      if(squadA.getSoldierSquad().size()!=0 && squadB.getSoldierSquad().size()!=0){
        squadA.setSquadName(new DialogBox().showDialog("Enter name for Squad 1:"));
        squadB.setSquadName(new DialogBox().showDialog("Enter name for Squad 2:"));

        Battle battle = new Battle(squadA,squadB);

        battleLog.setText(battle.startSquadBattleHtml(squadA,squadB));

     }
      else{
        battleLog.setText(emptySquadsWarning);
      }
    });

    addBowman.addActionListener(e -> {
      squadA.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad1.setText(squadToString(squadA));
    });
    addCrossbowman.addActionListener(e -> {
      squadA.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad1.setText(squadToString(squadA));
    });
    addSpearman.addActionListener(e -> {
      squadA.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad1.setText(squadToString(squadA));
    });
    addSwordsman.addActionListener(e -> {
      squadA.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad1.setText(squadToString(squadA));
    });

    squad2.add(addSoldier2);
    addSoldier2.add(addBowman2);
    addSoldier2.add(addCrossbowman2);
    addSoldier2.add(addSpearman2);
    addSoldier2.add(addSwordsman2);

    addBowman2.addActionListener(e -> {
      squadB.addSoldierToTheSquad(new Bowman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad2.setText(squadToString(squadB));
    });
    addCrossbowman2.addActionListener(e -> {
      squadB.addSoldierToTheSquad(new Crossbowman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad2.setText(squadToString(squadB));
    });
    addSpearman2.addActionListener(e -> {
      squadB.addSoldierToTheSquad(new Spearman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad2.setText(squadToString(squadB));
    });
    addSwordsman2.addActionListener(e -> {
      squadB.addSoldierToTheSquad(new Swordsman(new DialogBox().showDialog(ENTER_NAME_FOR_THE_SOLDIER),new SoldierPosition(0,0)));
      labelForSquad2.setText(squadToString(squadB));
    });

    this.setJMenuBar(menuBar);
    menuBar.setVisible(true);

    Image imageBackground = SCROLL_ICON.getImage().getScaledInstance(1200, 1200, Image.SCALE_SMOOTH);


    JTextArea backgroundArea = new JTextArea() {

      final Image grayImage = GrayFilter.createDisabledImage(imageBackground);
      {
        setOpaque(false);
      }

      public void paint(Graphics g) {
        g.drawImage(grayImage, 0, 0, this);
        super.paint(g);
      }
    };
    backgroundArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(backgroundArea);
      Container content = this.getContentPane();
      content.add(scrollPane, BorderLayout.CENTER);
    backgroundArea.setBounds(0,0, 1600, 1500);

    this.add(backgroundArea);
    this.setVisible(true);

  }
  private String squadToString(Squad squad){
    StringBuilder tmp = new StringBuilder("<html>Squad consists of following soldiers:");
    for(BaseSoldier soldier : squad.getSoldierSquad()){
      tmp.append("<br>").append(soldier.getName()).append(" : ").append(soldier.getClass().getSimpleName());
    }
    tmp.append("</html>");
    return tmp.toString();
  }

  private String whoIsWinnerSquad(){
    String whoIsWinner = "";
    if(squadA.isAlive()&&!squadB.isAlive()){
      whoIsWinner = squadA.getName() + " won!";
    } else if (!squadA.isAlive()&&squadB.isAlive()){
      whoIsWinner = squadB.getName() + " won!";
    } else if (!squadA.isAlive()&&!squadB.isAlive()){
      whoIsWinner = "Draw, both lost!";
    }
    return whoIsWinner;
  }

  private String getCurrentDateAndFormatToString(){
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return date.format(formatter);
  }
}
