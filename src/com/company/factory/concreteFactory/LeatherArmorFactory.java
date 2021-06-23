package com.company.factory.concreteFactory;

import com.company.factory.concreteArmorElements.fromLeather.LeatherArmguard;
import com.company.factory.concreteArmorElements.fromLeather.LeatherHelm;
import com.company.factory.concreteArmorElements.fromLeather.LeatherLegGuard;
import com.company.factory.concreteArmorElements.fromLeather.LeatherTorsoArmor;

public class LeatherArmorFactory{

   
  public LeatherHelm createHelm() {
    return new LeatherHelm();
  }

   
  public LeatherArmguard createArmGuards() {
    return new LeatherArmguard();
  }

   
  public LeatherLegGuard createLegGuards() {
    return new LeatherLegGuard();
  }

   
  public LeatherTorsoArmor createTorsoArmor() {
    return new LeatherTorsoArmor();
  }
}
