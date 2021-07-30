package com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Chainmail;

public class ChainmailArmguard extends BaseArmor {


  public ChainmailArmguard() {
    super(new Chainmail());
  }
}
