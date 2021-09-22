package com.company.business_logic.armor_composite.concreteArmorElements.fromPlate;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateLegGuard extends BaseArmor {

  public PlateLegGuard(){
    super(new Plate());
  }
}
