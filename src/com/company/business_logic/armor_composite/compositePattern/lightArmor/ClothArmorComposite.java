package com.company.business_logic.armor_composite.compositePattern.lightArmor;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.concreteArmorElements.fromCloth.ClothArmguard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromCloth.ClothHelm;
import com.company.business_logic.armor_composite.concreteArmorElements.fromCloth.ClothLegGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromCloth.ClothTorsoArmor;
import com.company.business_logic.armor_composite.materials.Cloth;

public class ClothArmorComposite extends BaseArmorComposite {

  public ClothArmorComposite() {
     super(new Cloth());
     this.addArmorToList(new ClothHelm());
     this.addArmorToList(new ClothArmguard());
     this.addArmorToList(new ClothLegGuard());
     this.addArmorToList(new ClothTorsoArmor());
  }


}
