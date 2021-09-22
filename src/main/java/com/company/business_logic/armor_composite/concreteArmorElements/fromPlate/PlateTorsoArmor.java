package com.company.business_logic.armor_composite.concreteArmorElements.fromPlate;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateTorsoArmor extends BaseArmor {

  public PlateTorsoArmor(){
    super(new Plate());
  }
}
