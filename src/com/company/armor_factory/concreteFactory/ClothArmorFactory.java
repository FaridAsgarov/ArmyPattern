package com.company.armor_factory.concreteFactory;

import com.company.armor_factory.concreteArmorElements.fromCloth.ClothArmguard;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothHelm;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothLegGuard;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothTorsoArmor;

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
