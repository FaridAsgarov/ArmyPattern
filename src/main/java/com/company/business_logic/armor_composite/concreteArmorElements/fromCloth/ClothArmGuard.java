package com.company.business_logic.armor_composite.concreteArmorElements.fromCloth;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Cloth;

public class ClothArmGuard extends BaseArmor {

      public ClothArmGuard() {
            super(new Cloth());
      }
}
