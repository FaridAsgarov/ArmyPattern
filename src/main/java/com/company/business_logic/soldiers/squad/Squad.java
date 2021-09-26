package com.company.business_logic.soldiers.squad;

import com.company.business_logic.soldiers.BaseSoldier;

import java.util.ArrayList;

public class Squad {

  ArrayList<BaseSoldier> soldierSquad = new ArrayList<>();
  public String squadName;
  private int activeSoldierIndex;

  public Squad(String squadName) {
    this.squadName = squadName;
    this.activeSoldierIndex = 0;
  }

  public BaseSoldier getActiveSoldier() {
        return soldierSquad.get(this.activeSoldierIndex);
  }

  public void nextSoldierIndex() {
    if (this.activeSoldierIndex + 1 < soldierSquad.size()) {
      this.activeSoldierIndex++;
    }
  }

  public void previousSoldierIndex() {
    if (this.activeSoldierIndex > 0) {
      this.activeSoldierIndex--;
    }

  }

  public void setSoldierIndex(int i) {
    this.activeSoldierIndex = i;
  }

  public void addSoldierToTheSquad(BaseSoldier soldier) {
    soldierSquad.add(soldier);
  }

  public void removeSoldierFromTheSquad(BaseSoldier soldier) {
    soldierSquad.remove(soldier);
  }

  public BaseSoldier getSoldier(int index) {
    return soldierSquad.get(index);
  }

  public int getSoldierCount() {
    return soldierSquad.size();
  }

  public ArrayList<String> squadAttackEnemySoldier(BaseSoldier enemy) {
    ArrayList<String> log = new ArrayList<String>();
    for (BaseSoldier soldier : soldierSquad) {
      if (soldier.isAlive()) {
        soldier.attack(enemy);
        log.add(soldier.getClass().getSimpleName() + " " + soldier.getName() + " from squad " + this
            .getName() +
            " attacks " + enemy.getClass().getSimpleName() + " " + enemy.getName() +
            ", " + enemy.getName() + " has " + enemy.getTotalHealthAndArmor() + "HP left;"
        );
      }
    }
    return log;
  }

  public ArrayList<String> squadAttackEnemySquad(Squad enemySquad) {
    ArrayList<String> log = new ArrayList<String>();

    for (BaseSoldier soldier : soldierSquad) {
      for (BaseSoldier enemy : enemySquad.getSoldierSquad())
        if (soldier.isAlive()) {
          soldier.attack(enemy);
          log.add(
              soldier.getClass().getSimpleName() + " " + soldier.getName() + " from squad " + this
                  .getName() +
                  " attacks " + enemy.getClass().getSimpleName() + " " + enemy.getName()
                  + " from squad " + enemySquad.getName() +
                  ", " + enemy.getName() + " has " + enemy.getTotalHealthAndArmor() + "HP left;"
          );
        }
    }

    return log;
  }

  public ArrayList<BaseSoldier> getSoldierSquad() {
    return soldierSquad;
  }

  public boolean isAlive() {
    boolean isAlive = true;
    if (this.getTotalHP() <= 0) {
      isAlive = false;
    }
    ;
    return isAlive;
  }

  public int getTotalHP() {
    int totalHP = 0;
    for (BaseSoldier soldier : soldierSquad) {
      totalHP += soldier.getTotalHealthAndArmor();
    }
    return totalHP;
  }

  public String getName() {
    return this.squadName;
  }

  public void setSquadName(String squadName) {
    this.squadName = squadName;
  }

  public int getX() {
    return getActiveSoldier().getSoldierPosition().positionX;
  }

  public int getY() {
    return getActiveSoldier().getSoldierPosition().positionY;
  }

  public boolean isSpaceOccupied(Squad enemySquad) {
    boolean isOccupied = false;

    if(isSpaceOccupiedByFriend()){
      isOccupied = true;
    }

    if(isSpaceOccupiedByEnemy(enemySquad)){
      isOccupied = true;

    }

    return isOccupied;
  }

  public boolean isSpaceOccupiedByFriend(){
    boolean isOccupied = false;
    for (BaseSoldier soldier : soldierSquad) {
      if (getActiveSoldier().getSoldierPosition().positionX == soldier
          .getSoldierPosition().positionX
          && getActiveSoldier().getSoldierPosition().positionY == soldier
          .getSoldierPosition().positionY && getActiveSoldier().getName() != soldier
          .getName()) {
        isOccupied = true;
      }
    }
    return isOccupied;
  }

  public boolean isSpaceOccupiedByEnemy(Squad enemySquad){
    boolean isOccupied = false;
    for (BaseSoldier enemy : enemySquad.getSoldierSquad()) {
      if (getActiveSoldier().getSoldierPosition().positionX == enemy.getSoldierPosition().positionX
          && getActiveSoldier().getSoldierPosition().positionY == enemy
          .getSoldierPosition().positionY) {
        isOccupied = true;
      }
    }
    return isOccupied;
  }

  public BaseSoldier returnEnemyWhoOccupiedSpace(Squad enemySquad){
    for (BaseSoldier enemy : enemySquad.getSoldierSquad()) {
      if (getActiveSoldier().getSoldierPosition().positionX == enemy.getSoldierPosition().positionX
          && getActiveSoldier().getSoldierPosition().positionY == enemy
          .getSoldierPosition().positionY) {
        return enemy;
      }
    }
    return null;
  }

  public boolean hasAliveSoldier(){
    for (BaseSoldier soldier: soldierSquad){
      if(soldier.isAlive()){
        return true;
      }
    }
    return false;
  }

  public BaseSoldier getAliveSoldier(){
    for (BaseSoldier soldier: soldierSquad){
      if(soldier.isAlive()){
        return soldier;
      }
    }
    return null;
  }

}
