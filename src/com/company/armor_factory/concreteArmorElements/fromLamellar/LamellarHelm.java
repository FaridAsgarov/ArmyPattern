package com.company.armor_factory.concreteArmorElements.fromLamellar;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Lamellar;

public class LamellarHelm extends BaseArmor {

  public LamellarHelm() {
    super(new Lamellar());
  }
}
