package com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail;

import com.company.business_logic.armor_composite.BaseArmor;
import com.company.business_logic.armor_composite.materials.ChainMail;

public class ChainMailTorsoArmor extends BaseArmor {

  public ChainMailTorsoArmor(){
    super(new ChainMail());
  }
}
