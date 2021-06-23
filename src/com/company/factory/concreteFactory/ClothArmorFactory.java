package com.company.factory.concreteFactory;

import com.company.factory.concreteArmorElements.fromCloth.ClothArmguard;
import com.company.factory.concreteArmorElements.fromCloth.ClothHelm;
import com.company.factory.concreteArmorElements.fromCloth.ClothLegGuard;
import com.company.factory.concreteArmorElements.fromCloth.ClothTorsoArmor;

public class ClothArmorFactory {

   
  public ClothHelm createHelm() {
    return new ClothHelm();
  }

   
  public ClothArmguard createArmGuards() {
    return new ClothArmguard();
  }

   
  public ClothLegGuard createLegGuards() {
    return new ClothLegGuard();
  }

   
  public ClothTorsoArmor createTorsoArmor() {
    return new ClothTorsoArmor();
  }
}
