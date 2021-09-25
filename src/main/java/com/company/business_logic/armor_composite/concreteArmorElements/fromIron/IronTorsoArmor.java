package com.company.business_logic.armor_composite.concreteArmorElements.fromIron;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Iron;

public class IronTorsoArmor extends BaseArmor {

  public IronTorsoArmor() {
    super(new Iron());
  }
}
