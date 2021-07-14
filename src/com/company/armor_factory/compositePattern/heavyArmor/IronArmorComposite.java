package com.company.armor_factory.compositePattern.heavyArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromIron.IronArmguard;
import com.company.armor_factory.concreteArmorElements.fromIron.IronHelm;
import com.company.armor_factory.concreteArmorElements.fromIron.IronLegGuard;
import com.company.armor_factory.concreteArmorElements.fromIron.IronTorsoArmor;
import com.company.armor_factory.materials.Iron;

public class IronArmorComposite extends BaseArmorComposite {

  public IronArmorComposite() {
    super(new Iron());
    this.addArmorToList(new IronHelm());
    this.addArmorToList(new IronArmguard());
    this.addArmorToList(new IronLegGuard());
    this.addArmorToList(new IronTorsoArmor());
  }
}
