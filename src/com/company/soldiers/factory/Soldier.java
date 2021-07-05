package com.company.soldiers.factory;

public interface Soldier {
   public String toString();
   public int attack(Soldier enemy);
   public int defend(Soldier enemy);
}
