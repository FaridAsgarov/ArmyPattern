package com.company.business_logic.armor_composite.concreteArmorElements.fromCloth;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Cloth;

public class ClothTorsoArmor extends BaseArmor {

  public ClothTorsoArmor(){
    super(new Cloth());
  }
}
