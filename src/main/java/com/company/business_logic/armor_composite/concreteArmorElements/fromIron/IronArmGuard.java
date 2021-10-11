package com.company.business_logic.armor_composite.concreteArmorElements.fromIron;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Iron;

public class IronArmGuard extends BaseArmor {

  public IronArmGuard() {
    super(new Iron());
  }
}
