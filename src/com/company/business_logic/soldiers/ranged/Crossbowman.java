package com.company.business_logic.soldiers.ranged;

import com.company.business_logic.armor_composite.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.ranged.Crossbow;

public class Crossbowman extends RangedSoldier {

  public Crossbowman(String name) {
    super(name, 100, new ChainmailArmorComposite());
    weaponArsenal.add(new Crossbow(30));
    weaponArsenal.add(new Dagger(10,10));
  }
}
