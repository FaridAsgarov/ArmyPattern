package com.company.armor_composite.concreteArmorElements.fromChainmail;

import com.company.armor_composite.BaseArmor;
import com.company.armor_composite.materials.Chainmail;

public class ChainmailTorsoArmor extends BaseArmor {

  public ChainmailTorsoArmor(){
    super(new Chainmail());
  }
}
