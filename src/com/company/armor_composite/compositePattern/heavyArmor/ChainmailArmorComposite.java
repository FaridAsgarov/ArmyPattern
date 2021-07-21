package com.company.armor_composite.compositePattern.heavyArmor;

import com.company.armor_composite.compositePattern.BaseArmorComposite;
import com.company.armor_composite.concreteArmorElements.fromChainmail.ChainmailArmguard;
import com.company.armor_composite.concreteArmorElements.fromChainmail.ChainmailHelm;
import com.company.armor_composite.concreteArmorElements.fromChainmail.ChainmailLegGuard;
import com.company.armor_composite.concreteArmorElements.fromChainmail.ChainmailTorsoArmor;
import com.company.armor_composite.materials.Chainmail;

public class ChainmailArmorComposite extends BaseArmorComposite {

  public ChainmailArmorComposite() {
    super(new Chainmail());
    this.addArmorToList(new ChainmailHelm());
    this.addArmorToList(new ChainmailArmguard());
    this.addArmorToList(new ChainmailLegGuard());
    this.addArmorToList(new ChainmailTorsoArmor());
  }
}
