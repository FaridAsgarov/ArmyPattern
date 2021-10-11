package com.company.business_logic.soldiers.ranged;

import com.company.business_logic.armor_composite.compositePattern.heavyArmor.ChainMailArmorComposite;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.ranged.Crossbow;

import static com.company.view.Constants.CROSSBOWMAN_IMAGE;

public class Crossbowman extends RangedSoldier {

  public Crossbowman(String name, SoldierPosition soldierPosition) {
    super(name, 100, new ChainMailArmorComposite(),CROSSBOWMAN_IMAGE, soldierPosition);
    weaponArsenal.add(new Crossbow(30));
    weaponArsenal.add(new Dagger(10,10));
  }
}
