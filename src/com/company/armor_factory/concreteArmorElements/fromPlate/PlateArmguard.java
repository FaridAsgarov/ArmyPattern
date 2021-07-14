package com.company.armor_factory.concreteArmorElements.fromPlate;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Plate;

public class PlateArmguard extends BaseArmor {

  public PlateArmguard() {
    super(new Plate());
  }

}
