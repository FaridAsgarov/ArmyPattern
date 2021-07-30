package com.company.business_logic.armor_composite.compositePattern.heavyArmor;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.concreteArmorElements.fromIron.IronArmguard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromIron.IronHelm;
import com.company.business_logic.armor_composite.concreteArmorElements.fromIron.IronLegGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromIron.IronTorsoArmor;
import com.company.business_logic.armor_composite.materials.Iron;

public class IronArmorComposite extends BaseArmorComposite {

  public IronArmorComposite() {
    super(new Iron());
    this.addArmorToList(new IronHelm());
    this.addArmorToList(new IronArmguard());
    this.addArmorToList(new IronLegGuard());
    this.addArmorToList(new IronTorsoArmor());
  }
}
