package com.company.armor_factory.concreteArmorElements.fromChainmail;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Chainmail;

public class ChainmailLegGuard extends BaseArmor {

  public ChainmailLegGuard(){
    super(new Chainmail());
  }
}
