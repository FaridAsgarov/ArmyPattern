package com.company.business_logic.soldiers.ranged;

import com.company.business_logic.armor_composite.compositePattern.lightArmor.LeatherArmorComposite;
import com.company.business_logic.soldiers.SoldierPosition;
import com.company.business_logic.weapon.baseWeapons.melee.Dagger;
import com.company.business_logic.weapon.baseWeapons.ranged.Bow;

public class Bowman extends RangedSoldier {

  public Bowman(String name, SoldierPosition soldierPosition) {
    super(name, 100, new LeatherArmorComposite(),"..\\..\\..\\view\\resources\\images\\Bowman.JPG", soldierPosition);
    weaponArsenal.add(new Bow(20));
    weaponArsenal.add(new Dagger(10,10));
  }
}
