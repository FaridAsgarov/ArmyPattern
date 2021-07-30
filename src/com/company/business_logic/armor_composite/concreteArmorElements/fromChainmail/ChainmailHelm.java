package com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.Chainmail;

public class ChainmailHelm extends BaseArmor {

  public ChainmailHelm(){
    super(new Chainmail());
  }
}
