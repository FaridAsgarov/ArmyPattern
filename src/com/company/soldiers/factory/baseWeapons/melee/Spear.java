package com.company.soldiers.factory.baseWeapons.melee;

import com.company.soldiers.factory.BaseWeapon;

public class Spear extends BaseWeapon {

  public Spear(int damageMax, int parryMax) {
    super(damageMax, parryMax);
  }

  public int throwSpear(){
     super.attack();
    //Spear-- after throwing
  }
}
