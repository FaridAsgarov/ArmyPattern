package com.company.business_logic.armor_composite.concreteArmorElements.fromPlate;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateArmGuard extends BaseArmor {

  public PlateArmGuard() {
    super(new Plate());
  }

}
