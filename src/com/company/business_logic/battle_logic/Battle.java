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


  public String startBattle(Object attacker, Object defender){
    String battleText = "Battle log:" + "\n";
    while(checkForWinner(attacker,defender)==this.continueBattle) {
      AattacksB(attacker, defender);
      battleText += checkDefenderHPafterBeingAttacked(attacker, defender) + "\n";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "\n";
        break;
      }

      AattacksB(defender, attacker);
      battleText += checkDefenderHPafterBeingAttacked(defender, attacker) + "\n";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "\n";
        break;
      }
    }
    return battleText;
  }

  public String startBattleHtml(Object attacker, Object defender){
    String battleText = "<html>Battle log:" + "<br>";
    while(checkForWinner(attacker,defender)==this.continueBattle) {
      AattacksB(attacker, defender);
      battleText += checkDefenderHPafterBeingAttacked(attacker, defender) + "<br>";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "<br>";
        break;
      }

      AattacksB(defender, attacker);
      battleText += checkDefenderHPafterBeingAttacked(defender, attacker) + "<br>";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "<br>";
        break;
      }
    }
    battleText += "</html>";
    return battleText;
  }

  public String startSquadBattleHtml(Squad attacker, Squad defender){
    String battleText = "<html>Battle log:" + "<br>";
    while(checkForWinner(attacker,defender)==this.continueBattle) {
      AattacksB(attacker, defender);
      battleText += attacker.squadAttackEnemySquad(defender) + "<br>";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "<br>";
        break;
      }

      AattacksB(defender, attacker);
      battleText += defender.squadAttackEnemySquad(attacker) + "<br>";

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        battleText += checkForWinner(attacker, defender) + "<br>";
        break;
      }
    }
    battleText += "</html>";
    return battleText;
  }

  public void startBattleInConsole(Object attacker, Object defender){
    while(checkForWinner(attacker,defender)==this.continueBattle) {
      AattacksB(attacker, defender);
      System.out.println(checkDefenderHPafterBeingAttacked(attacker, defender));

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        System.out.println(checkForWinner(attacker, defender));
        break;
      }

      AattacksB(defender, attacker);
      System.out.println(checkDefenderHPafterBeingAttacked(defender, attacker));

      if(checkForWinner(attacker,defender)!=this.continueBattle){
        System.out.println(checkForWinner(attacker, defender));
        break;
      }
    }
  }

  public void AattacksB(Object attacker, Object defender){
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

  public String checkDefenderHPafterBeingAttacked(Object attacker, Object defender) {
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

  public String getContinueBattle() {
    return continueBattle;
  }
}
