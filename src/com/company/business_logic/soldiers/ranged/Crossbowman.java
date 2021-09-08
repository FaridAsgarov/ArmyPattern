package com.company.business_logic.soldiers.ranged;

import com.company.business_logic.armor_composite.compositePattern.heavyArmor.ChainmailArmorComposite;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.ranged.Crossbow;

public class Crossbowman extends RangedSoldier {

  public Crossbowman(String name, SoldierPosition soldierPosition) {
    super(name, 100, new ChainmailArmorComposite(),"..\\..\\..\\view\\resources\\images\\Crossbowman.JPG", soldierPosition);
    weaponArsenal.add(new Crossbow(30));
    weaponArsenal.add(new Dagger(10,10));
  }
}
