package com.company.shield;

import com.company.armor_factory.Material;

public abstract class Shield {
  public int shieldHP;
  Material material;

  public Shield(Material material){
     this.material = material;
     shieldHP = material.getMaterialHP();
  }

  @Override
  public String toString() {
    return "this Shield is made from " + material.getClass().getName() + ", has " + shieldHP + "HP left";
  }

  public int defendWithShield(int attack) {
    return shieldHP - attack;
  }

  public int ramWithShield() {
    return 0;
  }


}
