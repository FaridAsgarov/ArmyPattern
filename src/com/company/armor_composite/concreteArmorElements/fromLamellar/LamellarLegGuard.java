package com.company.armor_composite.concreteArmorElements.fromLamellar;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Lamellar;

public class LamellarLegGuard extends BaseArmor {

  public LamellarLegGuard() {
    super(new Lamellar());
  }
}
