package com.company.armor_factory;

public class BaseArmor {
    private Material material;

    public BaseArmor(Material material){
       this.material = material;
    }

    public int getArmorHP(){
      return this.material.getMaterialHP();
    }
}
