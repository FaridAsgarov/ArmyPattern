package com.company.armor_factory.concreteArmorElements.fromLeather;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Leather;

public class LeatherTorsoArmor extends BaseArmor {

  public LeatherTorsoArmor(){
    super(new Leather());
  }
}
