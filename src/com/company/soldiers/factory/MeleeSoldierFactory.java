package com.company.soldiers.factory;

public class MeleeSoldierFactory implements Soldier{

  @Override
  public int attack(Soldier enemy) {
    return 0;
  }

  @Override
  public int defend(Soldier enemy) {
    return 0;
  }
}
