package com.company.business_logic.armor_composite.concreteArmorElements.fromLeather;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Leather;

public class LeatherArmGuard extends BaseArmor {

   public LeatherArmGuard(){
      super(new Leather());
   }
}
