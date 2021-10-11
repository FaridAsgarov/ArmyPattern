package com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.ChainMail;

public class ChainMailArmGuard extends BaseArmor {


  public ChainMailArmGuard() {
    super(new ChainMail());
  }
}
