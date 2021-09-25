package com.company.business_logic.armor_composite.compositePattern.heavyArmor;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.concreteArmorElements.fromPlate.PlateArmguard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromPlate.PlateHelm;
import com.company.business_logic.armor_composite.concreteArmorElements.fromPlate.PlateLegGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromPlate.PlateTorsoArmor;
import com.company.business_logic.armor_composite.materials.Plate;

public class PlateArmorComposite extends BaseArmorComposite {

  public PlateArmorComposite() {
    super(new Plate());
    this.addArmorToList(new PlateHelm());
    this.addArmorToList(new PlateArmguard());
    this.addArmorToList(new PlateLegGuard());
    this.addArmorToList(new PlateTorsoArmor());
  }
}
