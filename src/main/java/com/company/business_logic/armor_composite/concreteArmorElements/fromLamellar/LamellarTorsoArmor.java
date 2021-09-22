package com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Lamellar;

public class LamellarTorsoArmor extends BaseArmor {

  public LamellarTorsoArmor() {
    super(new Lamellar());
  }
}
