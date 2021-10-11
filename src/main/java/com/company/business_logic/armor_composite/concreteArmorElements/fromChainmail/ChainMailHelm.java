package com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.ChainMail;

public class ChainMailHelm extends BaseArmor {

  public ChainMailHelm(){
    super(new ChainMail());
  }
}
