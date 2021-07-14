package com.company.armor_factory.concreteArmorElements.fromPlate;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Plate;

public class PlateHelm extends BaseArmor {

  public PlateHelm(){
    super(new Plate());
  }
}
