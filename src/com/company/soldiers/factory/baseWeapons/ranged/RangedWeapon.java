package com.company.soldiers.factory.baseWeapons.ranged;

import com.company.soldiers.factory.BaseWeapon;

public class RangedWeapon extends BaseWeapon {
  public int arrowNum;

  public RangedWeapon(int damageMax) {
    super(damageMax, 0);
    this.arrowNum = 1;
  }

  @Override
  public int attack() {
    if(arrowNum > 0) {
      arrowNum--;
      return super.attack();
    }
    return 0;
  }

  public void reload(){
     arrowNum++;
  }
}
