package com.company.armor_factory.compositePattern.heavyArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateArmguard;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateHelm;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateLegGuard;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateTorsoArmor;
import com.company.armor_factory.materials.Plate;

public class PlateArmorComposite extends BaseArmorComposite {

  public PlateArmorComposite() {
    super(new Plate());
    this.addArmorToList(new PlateHelm());
    this.addArmorToList(new PlateArmguard());
    this.addArmorToList(new PlateLegGuard());
    this.addArmorToList(new PlateTorsoArmor());
  }
}
