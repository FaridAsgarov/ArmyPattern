package com.company.armor_factory.compositePattern.lightArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothArmguard;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothHelm;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothLegGuard;
import com.company.armor_factory.concreteArmorElements.fromCloth.ClothTorsoArmor;
import com.company.armor_factory.materials.Cloth;

public class ClothArmorComposite extends BaseArmorComposite {

  public ClothArmorComposite() {
     super(new Cloth());
     this.addArmorToList(new ClothHelm());
     this.addArmorToList(new ClothArmguard());
     this.addArmorToList(new ClothLegGuard());
     this.addArmorToList(new ClothTorsoArmor());
  }


}
