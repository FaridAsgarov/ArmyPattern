package com.company.armor_factory.compositePattern.lightArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromLeather.LeatherArmguard;
import com.company.armor_factory.concreteArmorElements.fromLeather.LeatherHelm;
import com.company.armor_factory.concreteArmorElements.fromLeather.LeatherLegGuard;
import com.company.armor_factory.concreteArmorElements.fromLeather.LeatherTorsoArmor;
import com.company.armor_factory.materials.Leather;

public class LeatherArmorComposite extends BaseArmorComposite {

  public LeatherArmorComposite() {
    super(new Leather());
    this.addArmorToList(new LeatherHelm());
    this.addArmorToList(new LeatherArmguard());
    this.addArmorToList(new LeatherLegGuard());
    this.addArmorToList(new LeatherTorsoArmor());
  }
}
