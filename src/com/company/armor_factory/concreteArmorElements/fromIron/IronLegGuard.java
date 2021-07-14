package com.company.armor_factory.concreteArmorElements.fromIron;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Iron;

public class IronLegGuard extends BaseArmor {

  public IronLegGuard() {
    super(new Iron());
  }
}
