package com.company.soldiers;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.Material;
import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.shield.Shield;
import com.company.weapon.Weapon;
import com.company.weapon.baseWeapons.melee.Spear;
import com.company.weapon.baseWeapons.ranged.RangedWeapon;
import java.util.ArrayList;

public class BaseSoldier {
  protected String name;
  protected int baseHP;
  public int totalHealthAndArmor;
  protected BaseArmorComposite armorSet;
  protected Shield shield;
  protected ArrayList<Weapon> weaponArsenal = new ArrayList<>();

  public BaseSoldier(String name, int baseHP, Shield shield, BaseArmorComposite armorSet)
  {
      this.name = name;
      this.baseHP = baseHP;
      this.armorSet = armorSet;
      this.totalHealthAndArmor = baseHP + armorSet.getTotalArmorHP();
      this.shield = shield;
  }


  public int attack(BaseSoldier enemy) {
    int attack = 0;
    int block = 0;

    if(enemy.isAlive()){
      attack = weaponArsenal.get(0).attack();
      block = enemy.defend();
      int dmg = attack - block;

      if(dmg>0) {
        enemy.totalHealthAndArmor -= dmg;
        return weaponArsenal.get(0).attack();
      }
    }
    return 0;
  }

  public int shieldRam(BaseSoldier enemy){
    int attack = 0;
    int block = 0;

    if(shield!=null){
      if(enemy.isAlive()){
       attack = shield.ramWithShield();
       block = enemy.defend();
       int dmg = attack - block;

       if(dmg>0){
        enemy.totalHealthAndArmor -= dmg;
        return shield.ramWithShield();
       }
      }
    }
    return 0;
  }

  public int defend() {
    if(weaponArsenal.get(0) instanceof RangedWeapon){
      return 0;
    }
    if(shield==null) {
      return weaponArsenal.get(0).defend();
    }
    return shield.defendWithShield();
  }


  public boolean isAlive() {
    if(this.totalHealthAndArmor <= 0){
      return false;
    }
    return true;
  }


}
