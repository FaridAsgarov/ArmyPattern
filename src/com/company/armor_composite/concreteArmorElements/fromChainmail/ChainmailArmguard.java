package com.company.armor_composite.concreteArmorElements.fromChainmail;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Chainmail;

public class ChainmailArmguard extends BaseArmor {


  public ChainmailArmguard() {
    super(new Chainmail());
  }
}
