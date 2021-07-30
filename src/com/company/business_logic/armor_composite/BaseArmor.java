package com.company.business_logic.armor_composite;

public abstract class BaseArmor {
    private Material material;

    public BaseArmor(Material material){
       this.material = material;
    }

    public int getArmorHP(){
      return this.material.getMaterialHP();
    }
}
