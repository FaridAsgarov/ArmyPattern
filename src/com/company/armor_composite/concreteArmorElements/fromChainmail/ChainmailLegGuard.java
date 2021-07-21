package com.company.armor_composite.concreteArmorElements.fromChainmail;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Chainmail;

public class ChainmailLegGuard extends BaseArmor {

  public ChainmailLegGuard(){
    super(new Chainmail());
  }
}
