package com.company.business_logic.armor_composite.concreteArmorElements.fromPlate;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateArmguard extends BaseArmor {

  public PlateArmguard() {
    super(new Plate());
  }

}
