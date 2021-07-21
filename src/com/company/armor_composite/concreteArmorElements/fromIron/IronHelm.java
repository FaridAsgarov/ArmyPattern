package com.company.armor_composite.concreteArmorElements.fromIron;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Iron;

public class IronHelm extends BaseArmor {

  public IronHelm() {
    super(new Iron());
  }
}
