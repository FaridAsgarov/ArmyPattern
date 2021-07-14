package com.company.armor_factory.compositePattern.heavyArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromLamellar.LamellarArmguard;
import com.company.armor_factory.concreteArmorElements.fromLamellar.LamellarHelm;
import com.company.armor_factory.concreteArmorElements.fromLamellar.LamellarLegGuard;
import com.company.armor_factory.concreteArmorElements.fromLamellar.LamellarTorsoArmor;
import com.company.armor_factory.materials.Lamellar;

public class LamellarArmorComposite extends BaseArmorComposite {

  public LamellarArmorComposite() {
    super(new Lamellar());
    this.addArmorToList(new LamellarHelm());
    this.addArmorToList(new LamellarArmguard());
    this.addArmorToList(new LamellarLegGuard());
    this.addArmorToList(new LamellarTorsoArmor());
  }
}
