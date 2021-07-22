package com.company.armor_composite.concreteArmorElements.fromLeather;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Leather;

public class LeatherTorsoArmor extends BaseArmor {

  public LeatherTorsoArmor(){
    super(new Leather());
  }
}
