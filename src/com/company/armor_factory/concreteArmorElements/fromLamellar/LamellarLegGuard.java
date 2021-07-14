package com.company.armor_factory.concreteArmorElements.fromLamellar;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Lamellar;

public class LamellarLegGuard extends BaseArmor {

  public LamellarLegGuard() {
    super(new Lamellar());
  }
}
