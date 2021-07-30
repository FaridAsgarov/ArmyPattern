package com.company.business_logic.armor_composite;

public abstract class Material {
  protected int materialHP;

  protected Material(int materialHP){
      this.materialHP = materialHP;
  }

  @Override
  public String toString() {
    return "this material has " + getMaterialHP() + "HP";
  }

  public int getMaterialHP() {
    return materialHP;
  }

}
