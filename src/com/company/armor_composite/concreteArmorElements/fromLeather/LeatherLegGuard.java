package com.company.armor_composite.concreteArmorElements.fromLeather;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Leather;

public class LeatherLegGuard extends BaseArmor {

  public LeatherLegGuard(){
    super(new Leather());
  }
}
