package com.company.business_logic.battle_logic;

import com.company.business_logic.soldiers.BaseSoldier;
import com.company.business_logic.soldiers.squad.Squad;

public class Battle {
  Object attacker;
  Object defender;
  String continueBattle = "continueBattle";

  public Battle(Object attacker, Object defender){
    this.attacker = attacker;
    this.defender = defender;
  }

  public String startBattleHtml(Object attacker, Object defender){
    StringBuilder battleText = new StringBuilder("<html>Battle log:" + "<br>");
    while(checkForWinner(attacker, defender).equals(this.continueBattle)) {
      aAttacksB(attacker, defender);
      battleText.append(checkDefenderHpAfterBeingAttacked(attacker, defender)).append("<br>");

      if(!checkForWinner(attacker, defender).equals(this.continueBattle)){
        battleText.append(checkForWinner(attacker, defender)).append("<br>");
        break;
      }

      aAttacksB(defender, attacker);
      battleText.append(checkDefenderHpAfterBeingAttacked(defender, attacker)).append("<br>");

      if(!checkForWinner(attacker, defender).equals(this.continueBattle)){
        battleText.append(checkForWinner(attacker, defender)).append("<br>");
        break;
      }
    }
    battleText.append("</html>");
    return battleText.toString();
  }

  public String startSquadBattleHtml(Squad attacker, Squad defender){
    StringBuilder battleText = new StringBuilder("<html>Battle log:" + "<br>");
    while(checkForWinner(attacker, defender).equals(this.continueBattle)) {
      aAttacksB(attacker, defender);
      battleText.append(attacker.squadAttackEnemySquadWithLineSeparator(defender, "<br>")).append("<br>");

      if(!checkForWinner(attacker, defender).equals(this.continueBattle)){
        battleText.append(checkForWinner(attacker, defender)).append("<br>");
        break;
      }

      aAttacksB(defender, attacker);
      battleText.append(defender.squadAttackEnemySquadWithLineSeparator(attacker, "<br>")).append("<br>");

      if(!checkForWinner(attacker, defender).equals(this.continueBattle)){
        battleText.append(checkForWinner(attacker, defender)).append("<br>");
        break;
      }
    }
    battleText.append("</html>");
    return battleText.toString();
  }

  public void aAttacksB(Object attacker, Object defender){
    if (attacker instanceof BaseSoldier) {
      if (defender instanceof BaseSoldier) {
        ((BaseSoldier) attacker).attack((BaseSoldier) defender);
      }
    }

    if (attacker instanceof Squad) {
      if (defender instanceof Squad) {
        ((Squad) attacker).squadAttackEnemySquad((Squad) defender);
      }
    }

    if (attacker instanceof Squad) {
      if (defender instanceof BaseSoldier) {
        ((Squad) attacker).squadAttackEnemySoldier((BaseSoldier) defender);
      }
    }
  }

  public String checkDefenderHpAfterBeingAttacked(Object attacker, Object defender) {
    String tmp = "";
    if (attacker instanceof BaseSoldier) {
      if (defender instanceof BaseSoldier) {
        tmp = ((BaseSoldier) attacker).getName() + " attacks " + ((BaseSoldier) defender).getName()
                + ", " + ((BaseSoldier) defender).getName() + " has total HP left: "
                + ((BaseSoldier) defender).getTotalHealthAndArmor();
      }
    }

    if (attacker instanceof Squad) {
      if (defender instanceof Squad) {
        tmp = ((Squad) attacker).getName() + " attacks " + ((Squad) defender).getName() + ", "
                + ((Squad) defender).getName() + " has total HP left: " + ((Squad) defender)
                .getTotalHP();
      }
    }

    if (attacker instanceof Squad) {
      if (defender instanceof BaseSoldier) {
        tmp = ((Squad) attacker).getName() + " attacks " + ((BaseSoldier) defender).getName() + ", "
                + ((BaseSoldier) defender).getName() + " has total HP left: " + ((BaseSoldier) defender)
                .getTotalHealthAndArmor();
      }
    }
    return tmp;
  }


  public String checkForWinner(Object attacker, Object defender){
    String battleResult = this.continueBattle;

    if(attacker instanceof BaseSoldier){
      if(defender instanceof BaseSoldier){
        if(((BaseSoldier) attacker).isAlive() && !((BaseSoldier) defender).isAlive()){
          battleResult = ((BaseSoldier) attacker).getName() + " wins the battle!";
        }
        if(!((BaseSoldier) attacker).isAlive() && ((BaseSoldier) defender).isAlive()){
          battleResult = ((BaseSoldier) defender).getName() + " wins the battle!";
        }
      }
    }

    if(attacker instanceof Squad){
      if(defender instanceof Squad){
        if(((Squad) attacker).isAlive() && !((Squad) defender).isAlive()){
          battleResult = ((Squad) attacker).getName() + " wins the battle!";
        }
        if(!((Squad) attacker).isAlive() && ((Squad) defender).isAlive()){
          battleResult = ((Squad) defender).getName() + " wins the battle!";
        }
      }
    }

    if(attacker instanceof Squad){
      if(defender instanceof BaseSoldier){
        if(((Squad) attacker).isAlive() && !((BaseSoldier) defender).isAlive()){
          battleResult = ((Squad) attacker).getName() + " wins the battle!";
        }
        if(!((Squad) attacker).isAlive() && ((BaseSoldier) defender).isAlive()){
          battleResult = ((BaseSoldier) defender).getName() + " wins the battle!";
        }
      }
    }

    if(attacker instanceof BaseSoldier){
      if(defender instanceof Squad){
        if(((BaseSoldier) attacker).isAlive() && !((Squad) defender).isAlive()){
          battleResult = ((BaseSoldier) attacker).getName() + " wins the battle!";
        }
        if(!((BaseSoldier) attacker).isAlive() && ((Squad) defender).isAlive()){
          battleResult = ((Squad) defender).getName() + " wins the battle!";
        }
      }
    }

    return battleResult;
  }
}
