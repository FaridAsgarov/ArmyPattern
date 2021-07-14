package com.company.armor_factory.compositePattern.heavyArmor;

import com.company.armor_factory.compositePattern.BaseArmorComposite;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailArmguard;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailHelm;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailLegGuard;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailTorsoArmor;
import com.company.armor_factory.materials.Chainmail;

public class ChainmailArmorComposite extends BaseArmorComposite {

  public ChainmailArmorComposite() {
    super(new Chainmail());
    this.addArmorToList(new ChainmailHelm());
    this.addArmorToList(new ChainmailArmguard());
    this.addArmorToList(new ChainmailLegGuard());
    this.addArmorToList(new ChainmailTorsoArmor());
  }
}
