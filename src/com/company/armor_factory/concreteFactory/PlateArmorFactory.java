package com.company.armor_factory.concreteFactory;

import com.company.armor_factory.concreteArmorElements.fromPlate.PlateArmguard;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateHelm;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateLegGuard;
import com.company.armor_factory.concreteArmorElements.fromPlate.PlateTorsoArmor;

public class PlateArmorFactory {


  public PlateHelm createHelm() {
    return new PlateHelm();
  }

  public PlateArmguard createArmGuards() {
    return new PlateArmguard();
  }


  public PlateLegGuard createLegGuards() {
    return new PlateLegGuard();
  }

  public PlateTorsoArmor createTorsoArmor() {
    return new PlateTorsoArmor();
  }
}
