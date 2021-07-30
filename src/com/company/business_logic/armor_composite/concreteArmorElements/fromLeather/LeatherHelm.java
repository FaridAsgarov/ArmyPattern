package com.company.business_logic.armor_composite.concreteArmorElements.fromLeather;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Leather;

public class LeatherHelm extends BaseArmor {

  public LeatherHelm(){
    super(new Leather());
  }
}
