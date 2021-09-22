package com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Lamellar;

public class LamellarArmguard extends BaseArmor {

  public LamellarArmguard() {
    super(new Lamellar());
  }
}
