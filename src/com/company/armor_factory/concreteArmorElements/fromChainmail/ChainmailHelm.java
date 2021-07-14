package com.company.armor_factory.concreteArmorElements.fromChainmail;

import com.company.armor_factory.BaseArmor;
import com.company.armor_factory.materials.Chainmail;

public class ChainmailHelm extends BaseArmor {

  public ChainmailHelm(){
    super(new Chainmail());
  }
}
