package com.company.armor_factory.concreteArmorElements.fromPlate;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Plate;

public class PlateLegGuard extends BaseArmor {

  public PlateLegGuard(){
    super(new Plate());
  }
}
