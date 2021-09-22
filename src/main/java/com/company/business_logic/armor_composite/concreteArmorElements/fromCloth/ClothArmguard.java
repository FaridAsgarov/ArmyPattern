package com.company.business_logic.armor_composite.concreteArmorElements.fromCloth;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Cloth;

public class ClothArmguard extends BaseArmor {

      public ClothArmguard() {
            super(new Cloth());
      }
}
