package com.company.armor_composite.compositePattern.lightArmor;

import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.armor_composite.concreteArmorElements.fromLeather.LeatherArmguard;
import com.company.armor_composite.concreteArmorElements.fromLeather.LeatherHelm;
import com.company.armor_composite.concreteArmorElements.fromLeather.LeatherLegGuard;
import com.company.armor_composite.concreteArmorElements.fromLeather.LeatherTorsoArmor;
import com.company.armor_composite.materials.Leather;

public class LeatherArmorComposite extends BaseArmorComposite {

  public LeatherArmorComposite() {
    super(new Leather());
    this.addArmorToList(new LeatherHelm());
    this.addArmorToList(new LeatherArmguard());
    this.addArmorToList(new LeatherLegGuard());
    this.addArmorToList(new LeatherTorsoArmor());
  }
}
