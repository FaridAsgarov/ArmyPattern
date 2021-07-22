package com.company.armor_composite.compositePattern.heavyArmor;

import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.armor_composite.concreteArmorElements.fromIron.IronArmguard;
import com.company.armor_composite.concreteArmorElements.fromIron.IronHelm;
import com.company.armor_composite.concreteArmorElements.fromIron.IronLegGuard;
import com.company.armor_composite.concreteArmorElements.fromIron.IronTorsoArmor;
import com.company.armor_composite.materials.Iron;

public class IronArmorComposite extends BaseArmorComposite {

  public IronArmorComposite() {
    super(new Iron());
    this.addArmorToList(new IronHelm());
    this.addArmorToList(new IronArmguard());
    this.addArmorToList(new IronLegGuard());
    this.addArmorToList(new IronTorsoArmor());
  }
}
