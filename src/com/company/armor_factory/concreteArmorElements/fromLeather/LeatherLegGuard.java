package com.company.armor_factory.concreteArmorElements.fromLeather;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Leather;

public class LeatherLegGuard extends BaseArmor {

  public LeatherLegGuard(){
    super(new Leather());
  }
}
