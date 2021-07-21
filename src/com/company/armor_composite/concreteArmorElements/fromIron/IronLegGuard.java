package com.company.armor_composite.concreteArmorElements.fromIron;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Iron;

public class IronLegGuard extends BaseArmor {

  public IronLegGuard() {
    super(new Iron());
  }
}
