package com.company.soldiers.ranged;

import com.company.armor_composite.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.weapon.baseWeapons.melee.Dagger;
import com.company.weapon.baseWeapons.ranged.Bow;

public class Bowman extends RangedSoldier {

  public Bowman(String name) {
    super(name, 100, new LeatherArmorComposite());
    weaponArsenal.add(new Bow(20));
    weaponArsenal.add(new Dagger(10,10));
  }
}
