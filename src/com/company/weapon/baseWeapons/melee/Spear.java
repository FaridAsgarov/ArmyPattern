package com.company.weapon.baseWeapons.melee;

import com.company.weapon.BaseWeapon;

public class Spear extends BaseWeapon {

  public Spear(int damageMax, int parryMax) {
    super(damageMax, parryMax);
  }

  public int throwSpear(){
    return super.attack();
    //Spear-- after throwing
  }
}
