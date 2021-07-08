package com.company.weapon;

import java.util.ArrayList;

public abstract class BaseWeapon implements Weapon {
    public int damageMax;
    public int parryMax;
    private ArrayList<Weapon> Arsenal = new ArrayList<>();

   public BaseWeapon(int damageMax, int parryMax){
        this.damageMax = damageMax;
        this.parryMax = parryMax;
    }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public int attack() {
    int range = (damageMax) + 1;
    return (int)(Math.random() * range) + 0;
  }

  @Override
  public int defend() {
    int range = (parryMax) + 1;
    return (int)(Math.random() * range) + 0;
  }

  public void addWeapon(Weapon weapon){
     Arsenal.add(weapon);
  }

  public void removeWeapon(Weapon weapon){
     Arsenal.remove(weapon);
  }

  public ArrayList<Weapon> getChildren(){
     return Arsenal;
  }
}
