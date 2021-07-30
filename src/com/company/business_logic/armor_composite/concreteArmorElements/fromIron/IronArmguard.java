package com.company.business_logic.armor_composite.concreteArmorElements.fromIron;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Iron;

public class IronArmguard extends BaseArmor {

  public IronArmguard() {
    super(new Iron());
  }
}
