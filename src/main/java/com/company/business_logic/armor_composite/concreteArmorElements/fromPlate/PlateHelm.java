package com.company.business_logic.armor_composite.concreteArmorElements.fromPlate;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateHelm extends BaseArmor {

  public PlateHelm(){
    super(new Plate());
  }
}
