package com.company.armor_composite.concreteArmorElements.fromCloth;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Cloth;

public class ClothTorsoArmor extends BaseArmor {

  public ClothTorsoArmor(){
    super(new Cloth());
  }
}
