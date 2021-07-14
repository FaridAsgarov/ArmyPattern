package com.company.armor_factory.concreteArmorElements.fromCloth;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Cloth;

public class ClothTorsoArmor extends BaseArmor {

  public ClothTorsoArmor(){
    super(new Cloth());
  }
}
