package com.company.armor_factory.concreteFactory;

import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailArmguard;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailHelm;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailLegGuard;
import com.company.armor_factory.concreteArmorElements.fromChainmail.ChainmailTorsoArmor;

public class ChainmailArmorFactory {

  public ChainmailHelm createHelm() {
    return new ChainmailHelm();
  }

   
  public ChainmailArmguard createArmGuards() {
    return new ChainmailArmguard();
  }

   
  public ChainmailLegGuard createLegGuards() {
    return new ChainmailLegGuard();
  }

   
  public ChainmailTorsoArmor createTorsoArmor() {
    return new ChainmailTorsoArmor();
  }

}
