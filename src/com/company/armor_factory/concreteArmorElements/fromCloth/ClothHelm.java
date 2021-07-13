package com.company.armor_factory.concreteArmorElements.fromCloth;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Cloth;

public class ClothHelm extends BaseArmor {

  public ClothHelm(){
    super(new Cloth());
  }
}
