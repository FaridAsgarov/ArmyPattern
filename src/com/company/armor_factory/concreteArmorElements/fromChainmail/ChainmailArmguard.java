package com.company.armor_factory.concreteArmorElements.fromChainmail;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Chainmail;

public class ChainmailArmguard extends BaseArmor {


  public ChainmailArmguard() {
    super(new Chainmail());
  }
}
