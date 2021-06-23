package com.company.factory.concreteFactory;

import com.company.factory.concreteArmorElements.fromPlate.PlateArmguard;
import com.company.factory.concreteArmorElements.fromPlate.PlateHelm;
import com.company.factory.concreteArmorElements.fromPlate.PlateLegGuard;
import com.company.factory.concreteArmorElements.fromPlate.PlateTorsoArmor;

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
