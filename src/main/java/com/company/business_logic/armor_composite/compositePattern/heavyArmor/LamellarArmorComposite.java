package com.company.business_logic.armor_composite.compositePattern.heavyArmor;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar.LamellarArmGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar.LamellarHelm;
import com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar.LamellarLegGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromLamellar.LamellarTorsoArmor;
import com.company.business_logic.armor_composite.materials.Lamellar;

public class LamellarArmorComposite extends BaseArmorComposite {

  public LamellarArmorComposite() {
    super(new Lamellar());
    this.addArmorToList(new LamellarHelm());
    this.addArmorToList(new LamellarArmGuard());
    this.addArmorToList(new LamellarLegGuard());
    this.addArmorToList(new LamellarTorsoArmor());
  }
}
