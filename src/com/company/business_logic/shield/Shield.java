package com.company.business_logic.shield;

import com.company.business_logic.armor_composite.Material;

public abstract class Shield {
  public int shieldHP;
  public int shieldRamMax;
  public int blockMax;
  Material material;

  public Shield(Material material){
     this.material = material;
     shieldHP = material.getMaterialHP();
  }

  @Override
  public String toString() {
    return "this Shield is made from " + material.getClass().getSimpleName() + ", has " + shieldHP + "HP left";
  }

  public int defendWithShield() {
    int range = (blockMax) + 1;
    return (int)(Math.random() * range) + 0;
  }

  public int ramWithShield() {
    int range = (shieldRamMax) + 1;
    return (int)(Math.random() * range) + 0;
  }


}
