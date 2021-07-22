package com.company.armor_composite.concreteArmorElements.fromPlate;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Plate;

public class PlateHelm extends BaseArmor {

  public PlateHelm(){
    super(new Plate());
  }
}
