package com.company.armor_composite.concreteArmorElements.fromPlate;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Plate;

public class PlateTorsoArmor extends BaseArmor {

  public PlateTorsoArmor(){
    super(new Plate());
  }
}
