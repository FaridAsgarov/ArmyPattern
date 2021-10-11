package com.company.business_logic.armor_composite.compositePattern.heavyArmor;

import com.company.business_logic.armor_composite.compositePattern.BaseArmorComposite;
import com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail.ChainMailArmGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail.ChainMailHelm;
import com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail.ChainMailLegGuard;
import com.company.business_logic.armor_composite.concreteArmorElements.fromChainmail.ChainMailTorsoArmor;
import com.company.business_logic.armor_composite.materials.ChainMail;

public class ChainMailArmorComposite extends BaseArmorComposite {

  public ChainMailArmorComposite() {
    super(new ChainMail());
    this.addArmorToList(new ChainMailHelm());
    this.addArmorToList(new ChainMailArmGuard());
    this.addArmorToList(new ChainMailLegGuard());
    this.addArmorToList(new ChainMailTorsoArmor());
  }
}
