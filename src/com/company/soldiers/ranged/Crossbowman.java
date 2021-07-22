package com.company.soldiers.ranged;

import com.company.armor_composite.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.weapon.baseWeapons.ranged.Crossbow;

public class Crossbowman extends RangedSoldier {

  public Crossbowman(String name) {
    super(name, 100, new ChainmailArmorComposite());
    weaponArsenal.add(new Crossbow(30));
  }
}
