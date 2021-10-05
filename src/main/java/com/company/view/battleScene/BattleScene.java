package com.company.view.battleScene;

import com.company.business_logic.battle_logic.Battle;
import com.company.business_logic.soldiers.squad.Squad;
import com.company.view.DatabaseInfo;
import com.company.view.EndingScreen;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

import static com.company.view.Constants.LOGO;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Font.BOLD;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.TOP;

public class BattleScene extends JFrame implements KeyListener {
    public static final int SCENE_WIDTH = 1225;
    public static final int SCENE_HEIGHT = 1080;
    public static final int SIDE_SIZE = 100;
    public static final int LOG_HEIGHT = 500;
    private final JLabel battleLog = new JLabel("<html> Battle Log: <br/>");
    private String battleLogTextToBeExported;
    private String gameMode = "Squad vs Squad Manual Battle";
    private final JPanel myPanel;

    private final Squad squadA;
    private final Squad squadB;

    public BattleScene(Squad squadA, Squad squadB) {
        this.squadA = squadA;
        this.squadB = squadB;

        this.setIconImage(LOGO.getImage());

        this.setSize(SCENE_WIDTH, SCENE_HEIGHT);


        battleLog.setBounds(150, 528, 900, LOG_HEIGHT);
        battleLog.setHorizontalAlignment(CENTER);
        battleLog.setVerticalAlignment(TOP);
        battleLog.setFont(new Font("Serif", BOLD, 17));

        myPanel = createPanel(squadA, squadB);
        myPanel.setName("myPanel");
        myPanel.setLayout(null);

        paintSoldiers(squadA, "_squadA", Color.RED);
        paintSoldiers(squadB, "_squadB", Color.BLUE);

        this.repaint();
        this.add(myPanel);

        JScrollPane log = new JScrollPane(battleLog);
        log.setBounds(0, 510, SCENE_WIDTH-20, LOG_HEIGHT);
        log.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        myPanel.add(log);

        this.update(this.getGraphics());
        this.setVisible(true);
        this.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void paintSoldiers(Squad squad, String suffix, Color color) {
        for (int i = 0; i < squad.getSoldierCount(); i++) {
            Component component = new JLabel(squad.getSoldier(i).getSoldierImage());
            component.setName(squad.getSoldier(i).getName() + suffix);
            component.setBounds(
                    squad.getSoldier(i).getSoldierPosition().positionX,
                    squad.getSoldier(i).getSoldierPosition().positionY,
                    SIDE_SIZE, SIDE_SIZE);
            component.setBackground(color);
            myPanel.add(component);
            myPanel.repaint();
        }
    }

    private JPanel createPanel(Squad squadA, Squad squadB) {
        final JPanel myPanel;
        myPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                for (int i = 8; i < 608; i += SIDE_SIZE) {
                    for (int j = 8; j < 1275; j += SIDE_SIZE) {
                        g2.drawLine(8, i, 1208, i);
                        g2.drawLine(j, 8, j, 508);
                    }
                }


                if(squadA.hasAliveSoldier()){
                    g2.setColor(RED);
                    g2.setStroke(new BasicStroke(8));
                    g2.drawRect(squadA.getAliveSoldier().getSoldierPosition().positionX - 2, squadA.getAliveSoldier().getSoldierPosition().positionY - 2, 104, 104);
                }

                if(squadB.hasAliveSoldier()){
                    g2.setColor(BLUE);
                    g2.setStroke(new BasicStroke(8));
                    g2.drawRect(squadB.getAliveSoldier().getSoldierPosition().positionX - 2, squadB.getAliveSoldier().getSoldierPosition().positionY - 2, 104, 104);
                }
            }
        };
        return myPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Squad attacker;
        Squad defender;
        if (e.isAltDown()) {
            attacker = squadB;
            defender = squadA;
        } else {
            attacker = squadA;
            defender = squadB;
        }

        Component component = myPanel.getComponentAt(attacker.getX(), attacker.getY());

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            attacker.nextSoldierIndex();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            attacker.previousSoldierIndex();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            attacker.getActiveSoldier().moveUp();
            attackEnemyTiles(attacker, defender);
            if (attacker.isSpaceOccupied(defender)) {
                attacker.getActiveSoldier().moveDown();
            }
            attacker.getActiveSoldier().checkBoundaries(8, 1108, 8, 408);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            attacker.getActiveSoldier().moveLeft();
            attackEnemyTiles(attacker, defender);
            if (attacker.isSpaceOccupied(defender)) {
                attacker.getActiveSoldier().moveRight();
            }
            attacker.getActiveSoldier().checkBoundaries(8, 1108, 8, 408);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            attacker.getActiveSoldier().moveRight();
            attackEnemyTiles(attacker, defender);
            if (attacker.isSpaceOccupied(defender)) {
                attacker.getActiveSoldier().moveLeft();
            }
            attacker.getActiveSoldier().checkBoundaries(8, 1108, 8, 408);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            attacker.getActiveSoldier().moveDown();
            attackEnemyTiles(attacker, defender);
            if (attacker.isSpaceOccupied(defender)) {
                attacker.getActiveSoldier().moveUp();
            }
            attacker.getActiveSoldier().checkBoundaries(8, 1108, 8, 408);
        }

        component.setBounds(
                attacker.getActiveSoldier().getSoldierPosition().positionX,
                attacker.getActiveSoldier().getSoldierPosition().positionY,
                100, 100);

        removeDeadSoldierLabels();

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void removeDeadSoldierLabels() {
        repaintAliveSoldiers(squadA, 0);
        repaintAliveSoldiers(squadB, squadA.getSoldierCount());

        if (squadA.getSoldierCount() == 0 || squadB.getSoldierCount() == 0) {
            if(new BattleResultSavePopUp().ShowDialog("Would you like to export result of battle to a text file?") == 0){
                addWhoWonToBattleLogText();
                BattleResultWriter.writeLogToFile(battleLogTextToBeExported);
            }
            if(new BattleResultSavePopUp().ShowDialog("Would you like to export the battle result to a database?") == 0){
                DatabaseInfo battle_info = null;
                try {
                    battle_info = new DatabaseInfo();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                battle_info.insertBattleInfoToDatabase(gameMode, whoIsWinnerSquad(), getCurrentDateAndFormatToString());
                JOptionPane.showMessageDialog(battleLog,"Successfully exported to database","Success",JOptionPane.WARNING_MESSAGE);
            }
            if (squadA.getSoldierCount() == 0) {
                new EndingScreen(squadB.getName());
            } else {
                new EndingScreen(squadA.getName());
            }
            this.dispose();
        }
    }

    private void repaintAliveSoldiers(Squad squad, int offset) {
        for (int i = 0; i < squad.getSoldierCount(); i++) {
            if (!squad.getSoldier(i).isAlive()) {
                myPanel.remove(myPanel.getComponent(i + offset));
                squad.removeSoldierFromTheSquad(squad.getSoldier(i));
                squad.setSoldierIndex(0);
                repaint();
            }
        }
    }

    public void attackEnemyTiles(Squad friendlySquad, Squad enemySquad) {
        if (friendlySquad.isSpaceOccupiedByEnemy(enemySquad)) {
            Battle battle = new Battle(friendlySquad.getActiveSoldier(),
                    friendlySquad.returnEnemyWhoOccupiedSpace(enemySquad));
            battleLog.setText(battle.startBattleHtml(friendlySquad.getActiveSoldier(),
                    friendlySquad.returnEnemyWhoOccupiedSpace(enemySquad)));
            saveBattleLogsToText(battleLog.getText());
        }
    }

    public void saveBattleLogsToText(String battleText){
        this.battleLogTextToBeExported += battleText + "\n";
    }

    private void addWhoWonToBattleLogText(){
        battleLogTextToBeExported += "<br>";
        if (squadA.getSoldierCount() == 0) {
            battleLogTextToBeExported += squadB.getName();
        } else if (squadB.getSoldierCount() == 0) {
            battleLogTextToBeExported += squadA.getName();
        } else {
            battleLogTextToBeExported += "Draw, no one ";
        }
        battleLogTextToBeExported += " has won the Battle!";
    }

    private String getCurrentDateAndFormatToString(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
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
}
