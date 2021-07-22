package com.company.armor_composite.concreteArmorElements.fromCloth;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Cloth;

public class ClothHelm extends BaseArmor {

  public ClothHelm(){
    super(new Cloth());
  }
}
