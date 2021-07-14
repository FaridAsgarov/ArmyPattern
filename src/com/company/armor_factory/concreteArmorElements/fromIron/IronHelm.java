package com.company.armor_factory.concreteArmorElements.fromIron;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Iron;

public class IronHelm extends BaseArmor {

  public IronHelm() {
    super(new Iron());
  }
}
